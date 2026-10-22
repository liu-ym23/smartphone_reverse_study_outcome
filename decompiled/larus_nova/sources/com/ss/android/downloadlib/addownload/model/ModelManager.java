package com.ss.android.downloadlib.addownload.model;

import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.download.api.settings.TTDownloadSettingsAdapter;
import com.ss.android.download.api.settings.TTDownloadSettingsModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.addownload.DownloadInsideHelper;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.DownloadSettingUtils;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ModelManager {
    private final ConcurrentHashMap<Long, DownloadController> controllers;
    private final ConcurrentHashMap<Long, DownloadEventConfig> eventConfigs;
    private volatile boolean init;
    private final ConcurrentHashMap<Long, DownloadModel> models;
    private final ConcurrentHashMap<Long, NativeDownloadModel> nativeModels;

    public static class SingleTonHolder {
        private static final ModelManager INSTANCE = null;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new ModelManager(null);
        }

        public static /* synthetic */ ModelManager access$100() {
            return INSTANCE;
        }
    }

    private ModelManager() {
        this.init = false;
        this.models = new ConcurrentHashMap();
        this.eventConfigs = new ConcurrentHashMap();
        this.controllers = new ConcurrentHashMap();
        this.nativeModels = new ConcurrentHashMap();
    }

    public static ModelManager getInstance() {
        return SingleTonHolder.access$100();
    }

    public void init() {
        DownloadComponentManager.getInstance().submitCPUTask(new AnonymousClass1(this), true);
    }

    public ConcurrentHashMap<Long, NativeDownloadModel> getAllNativeModels() {
        return this.nativeModels;
    }

    public /* synthetic */ ModelManager(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ boolean access$200(ModelManager r100) {
        return r100.init;
    }

    public static /* synthetic */ ConcurrentHashMap access$300(ModelManager r100) {
        return r100.nativeModels;
    }

    public DownloadController getDownloadController(long r100) {
        return this.controllers.get(Long.valueOf(r100));
    }

    public DownloadEventConfig getDownloadEventConfig(long r100) {
        return this.eventConfigs.get(Long.valueOf(r100));
    }

    public DownloadModel getDownloadModel(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Iterator<DownloadModel> r101 = this.models.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        DownloadModel r102 = r101.next();
        if (r102 == null) goto L7;
        if (r100.equals(r102.getPackageName()) == false) goto L7;
        return r102;
    L13:
        return null;
    }

    public NativeDownloadModel getNativeDownloadModel(long r100) {
        NativeDownloadModel r101 = this.nativeModels.get(Long.valueOf(r100));
        AdDownloadModel r102 = (AdDownloadModel) getDownloadModel(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        AdDownloadEventConfig r103 = (AdDownloadEventConfig) getDownloadEventConfig(r100);
        boolean r104 = true;
        if (r103 != null) goto L9;
        r103 = new AdDownloadEventConfig.Builder().setDefaultEventConfigSign(true).build();
    L9:
        AdDownloadController r105 = (AdDownloadController) getDownloadController(r100);
        if (r105 != null) goto L12;
        r105 = new AdDownloadController.Builder().setDefaultControllerSign(true).build();
    L12:
        if (r101 == null) goto L29;
        r101.updateDownloadModel(r102);
        IAdSDKSettingsProvider r106 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r106 != null) goto L17;
    L19:
        r104 = false;
    L21:
        if (r105.defaultControllerSign() == true) goto L25;
        if (r104 == false) goto L25;
        r101.updateDownloadController(r105);
    L25:
        if (r103.defaultEventConfigSign() == true) goto L30;
        if (r104 == false) goto L31;
        r101.updateDownloadEventConfig(r103);
        return r101;
    L31:
        return r101;
    L30:
        return r101;
    L17:
        if (r106.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.KEY_ENABLE_CONTROLLER_EVENT_CONFIG_UPDATE_OPT, 1) != 1) goto L19;
    L29:
        return new NativeDownloadModel(r102, r103, r105);
    }

    public NativeDownloadModel getNativeDownloadModelForAppLink(long r100) {
        return this.nativeModels.get(Long.valueOf(r100));
    }

    public NativeDownloadModel getNativeModelByInfo(DownloadInfo r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<NativeDownloadModel> r101 = this.nativeModels.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L15;
        NativeDownloadModel r102 = r101.next();
        if (r102 == null) goto L7;
        if (r102.getDownloadId() != r100.getId()) goto L7;
        return r102;
    L15:
        if (TextUtils.isEmpty(r100.getExtra()) == false) goto L41;
    L31:
        Iterator<NativeDownloadModel> r103 = this.nativeModels.values().iterator();
    L33:
        if (r103.hasNext() == false) goto L40;
        NativeDownloadModel r104 = r103.next();
        if (r104 == null) goto L33;
        if (TextUtils.equals(r104.getDownloadUrl(), r100.getUrl()) == false) goto L33;
        return r104;
    L40:
        return null;
    L41:
        long r105 = ToolUtils.optLong(new JSONObject(r100.getExtra()), "extra");     // Catch: Exception -> L29
        if (r105 == 0) goto L31;
        Iterator<NativeDownloadModel> r106 = this.nativeModels.values().iterator();     // Catch: Exception -> L29
    L20:
        if (r106.hasNext() == false) goto L27;
        NativeDownloadModel r107 = r106.next();     // Catch: Exception -> L29
        if (r107 == null) goto L20;
        if (r107.getId() != r105) goto L20;
        return r107;
    L27:
        TTDownloaderMonitor.inst().monitorDataError("getNativeModelByInfo");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    }

    public NativeDownloadModel getNativeModelByInfoId(int r100) {
        Iterator<NativeDownloadModel> r101 = this.nativeModels.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        NativeDownloadModel r102 = r101.next();
        if (r102 == null) goto L4;
        if (r102.getDownloadId() != r100) goto L4;
        return r102;
    L11:
        return null;
    }

    public NativeDownloadModel getNativeModelByPkg(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Iterator<NativeDownloadModel> r101 = this.nativeModels.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        NativeDownloadModel r102 = r101.next();
        if (r102 == null) goto L7;
        if (r100.equals(r102.getPackageName()) == false) goto L7;
        return r102;
    L13:
        return null;
    }

    public NativeDownloadModel getNativeModelByTaskKey(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Iterator<NativeDownloadModel> r101 = this.nativeModels.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        NativeDownloadModel r102 = r101.next();
        if (r102 == null) goto L7;
        if (r100.equals(r102.getDownloadHandlerTaskKey()) == false) goto L7;
        return r102;
    L13:
        return null;
    }

    public NativeDownloadModel getNativeModelByUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Iterator<NativeDownloadModel> r101 = this.nativeModels.values().iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        NativeDownloadModel r102 = r101.next();
        if (r102 == null) goto L7;
        if (r100.equals(r102.getDownloadUrl()) == false) goto L7;
        return r102;
    L13:
        return null;
    }

    public void mergeDownloadList(List<DownloadInfo> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<NativeDownloadModel> r102 = this.nativeModels.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(Long.valueOf(r102.next().getId()));
        goto L4
    L6:
        Iterator<DownloadInfo> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        DownloadInfo r104 = r103.next();
        if (DownloadStatus.isDownloadOver(r104.getStatus()) == false) goto L8;
        NativeDownloadModel r105 = ToolUtils.transferDownloadInfoIntoNativeDownloadModel(r104);
        if (r105 == null) goto L8;
        if (r101.contains(Long.valueOf(r105.getId())) == false) goto L8;
        putNativeModel(r105);
        goto L8
    }

    public synchronized void putNativeModel(NativeDownloadModel r100) {
        monitor-enter(this);
        if (r100 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.nativeModels.put(Long.valueOf(r100.getId()), r100);     // Catch: Throwable -> L9
        SharedPrefsManager.getInstance().saveNativeDownloadModel(r100);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeMemoryCaches(long r100) {
        this.models.remove(Long.valueOf(r100));
        this.eventConfigs.remove(Long.valueOf(r100));
        this.controllers.remove(Long.valueOf(r100));
    }

    public synchronized void removeNativeModel(NativeDownloadModel r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L6
        r101.add(r100);     // Catch: Throwable -> L6
        removeNativeModels(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void removeNativeModels(List<NativeDownloadModel> r100) {
        monitor-enter(this);
        SharedPrefsManager.getInstance().removeNativeDownloadModels(SharedPrefsManager.getNativeModelIds(r100));     // Catch: Throwable -> L10
        Iterator<NativeDownloadModel> r101 = r100.iterator();     // Catch: Throwable -> L10
    L5:
        if (r101.hasNext() == false) goto L8;
        NativeDownloadModel r102 = r101.next();     // Catch: Throwable -> L10
        this.nativeModels.remove(Long.valueOf(r102.getId()));     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void removeNativeModelsById(List<Long> r100) {
        monitor-enter(this);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L10
        Iterator<Long> r102 = r100.iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        long r103 = r102.next().longValue();     // Catch: Throwable -> L10
        r101.add(String.valueOf(r103));     // Catch: Throwable -> L10
        this.nativeModels.remove(Long.valueOf(r103));     // Catch: Throwable -> L10
        goto L5
    L7:
        SharedPrefsManager.getInstance().removeNativeDownloadModels(r101);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public DownloadModel getDownloadModel(long r100) {
        return this.models.get(Long.valueOf(r100));
    }

    public static /* synthetic */ boolean access$202(ModelManager r100, boolean r101) {
        r100.init = r101;
        return r101;
    }

    private static DeepLink mergeDeepLinkFieldsWhenEmpty(DownloadModel r100, DownloadModel r101) {
        DeepLink r102 = r101.getDeepLink();
        DeepLink r103 = r100.getDeepLink();
        if (r102 == null) goto L16;
        if (r103 != null) goto L7;
        return r102;
    L7:
        if (TextUtils.isEmpty(r102.getOpenUrl()) == false) goto L10;
        r102.setOpenUrl(r103.getOpenUrl());
    L10:
        if (TextUtils.isEmpty(r102.getWebUrl()) == false) goto L13;
        r102.setWebUrl(r103.getWebUrl());
    L13:
        if (TextUtils.isEmpty(r102.getPackageName()) == false) goto L18;
        r102.setPackageName(r103.getPackageName());
        return r102;
    L18:
        return r102;
    L16:
        return r103;
    }

    public void addDownloadController(long r100, DownloadController r101) {
        if (r101 == null) goto L5;
        this.controllers.put(Long.valueOf(r100), r101);
        return;
    }

    public void addDownloadEventConfig(long r100, DownloadEventConfig r101) {
        if (r101 == null) goto L15;
        TTDownloadSettingsModel r102 = TTDownloadSettingsAdapter.INSTANCE.get();
        if (r102 != null) goto L6;
    L13:
        this.eventConfigs.put(Long.valueOf(r100), r101);
        return;
    L6:
        if (r102.getFixWebTrackPoint() != 1) goto L13;
        if ((r101 instanceof AdDownloadEventConfig) == true) goto L10;
    L12:
        this.eventConfigs.put(Long.valueOf(r100), r101);
        return;
    L10:
        if (((AdDownloadEventConfig) r101).defaultEventConfigSign() == false) goto L12;
        return;
    }

    public void addDownloadModel(DownloadModel r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        DownloadModel r102 = this.models.get(Long.valueOf(r100.getId()));
        if (r102 == null) goto L7;
        this.models.put(Long.valueOf(r100.getId()), generateDownloadModel(r102, r100, r101));
        return;
    L7:
        this.models.put(Long.valueOf(r100.getId()), r100);
        if (r100.getDeepLink() == null) goto L12;
        r100.getDeepLink().setId(r100.getId());
        r100.getDeepLink().setPackageName(r100.getPackageName());
        return;
    }

    public void correctModelsPkgName(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        Iterator<DownloadModel> r102 = this.models.values().iterator();
    L9:
        if (r102.hasNext() == false) goto L24;
        DownloadModel r103 = r102.next();
        if ((r103 instanceof AdDownloadModel) == false) goto L9;
        if (TextUtils.equals(r103.getDownloadUrl(), r100) == false) goto L9;
        ((AdDownloadModel) r103).setPackageName(r101);
        goto L9
    L24:
        return;
    }

    public Map<Long, NativeDownloadModel> correctNativeModelsPkgName(String r100, String r101) {
        HashMap r102 = new HashMap();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L15:
        return r102;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        Iterator<NativeDownloadModel> r103 = this.nativeModels.values().iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        NativeDownloadModel r104 = r103.next();
        if (r104 == null) goto L9;
        if (TextUtils.equals(r104.getDownloadUrl(), r100) == false) goto L9;
        r104.getModel().setPackageName(r101);
        r102.put(Long.valueOf(r104.getId()), r104);
        goto L9
    }

    public DownloadModel getDownloadModel(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        if (r101 == false) goto L14;
        Iterator<DownloadModel> r102 = this.models.values().iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        DownloadModel r103 = r102.next();
        if (r103 == null) goto L8;
        if (r100.equals(r103.getDownloadUrl()) == false) goto L8;
        return r103;
    L14:
        return null;
    }

    public static DownloadModel generateDownloadModel(DownloadModel r100, DownloadModel r101, int r102) {
        if (r100 != null) goto L4;
    L76:
        return r101;
    L4:
        if ((r101 instanceof AdDownloadModel) == false) goto L76;
        AdDownloadModel r103 = (AdDownloadModel) r101;
    L73:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "generateDownloadModel");
    L75:
        return r103;
    L8:
        if (TextUtils.isEmpty(r101.getPackageName()) == false) goto L10;
        String r104 = r100.getPackageName();     // Catch: Exception -> L73
    L11:
        r103.setPackageName(r104);     // Catch: Exception -> L73
        if (TextUtils.isEmpty(r101.getLogExtra()) == false) goto L14;
        String r105 = r100.getLogExtra();     // Catch: Exception -> L73
    L15:
        r103.setLogExtra(r105);     // Catch: Exception -> L73
        if (TextUtils.isEmpty(r101.getFilePath()) == false) goto L18;
        String r106 = r100.getFilePath();     // Catch: Exception -> L73
    L19:
        r103.setFilePath(r106);     // Catch: Exception -> L73
        if (DownloadInsideHelper.isGameUnionLive(r100) == false) goto L27;
        if (r101.getCallScene() != 9) goto L24;
    L25:
        r103.setExtra(ToolUtils.mergeJson(new JSONObject[]{r100.getExtra(), r101.getExtra()}));     // Catch: Exception -> L73
        goto L27
    L24:
        if (r101.getCallScene() == 10) goto L25;
    L27:
        if (r100.getCallScene() == 9) goto L36;
        if (r100.getCallScene() == 10) goto L36;
        if (r101.getCallScene() != 0) goto L33;
        int r107 = r100.getCallScene();     // Catch: Exception -> L73
    L34:
        r103.setCallScene(r107);     // Catch: Exception -> L73
        goto L36
    L33:
        r107 = r101.getCallScene();     // Catch: Exception -> L73
    L36:
        if (TextUtils.isEmpty(r101.getName()) == false) goto L38;
        String r108 = r100.getName();     // Catch: Exception -> L73
    L39:
        r103.setAppName(r108);     // Catch: Exception -> L73
        if (TextUtils.isEmpty(r101.getAppIcon()) == false) goto L42;
        String r109 = r100.getAppIcon();     // Catch: Exception -> L73
    L43:
        r103.setAppIcon(r109);     // Catch: Exception -> L73
        if (TextUtils.isEmpty(r101.getComplianceData()) == true) goto L56;
        if (TextUtils.isEmpty(r100.getComplianceData()) == true) goto L56;
        if (r103.isComplianceDataFromLogExtra() == false) goto L61;
        if ((r100 instanceof AdDownloadModel) == false) goto L61;
        if (((AdDownloadModel) r100).isComplianceDataFromLogExtra() == true) goto L61;
        r103.setComplianceData(r100.getComplianceData());     // Catch: Exception -> L73
    L61:
        if (r100.distinctDir() == false) goto L64;
        r103.setDistinctDir(true);     // Catch: Exception -> L73
    L64:
        if (DownloadInsideHelper.isGameUnionLive(r101) == true) goto L66;
    L71:
        r103.setDeepLink(mergeDeepLinkFieldsWhenEmpty(r100, r101));     // Catch: Exception -> L73
        goto L75
    L66:
        if (DownloadSettingUtils.getSetting(r103).optInt(DownloadSettingKeys.ENABLE_SKIP_SET_DOWNLOAD_MODEL, 0) != 1) goto L71;
        if (r102 != 0) goto L71;
        if (r100.getExtra() == null) goto L71;
        r103.setExtra(r100.getExtra());     // Catch: Exception -> L73
    L56:
        if (TextUtils.isEmpty(r101.getComplianceData()) == false) goto L58;
        String r110 = r100.getComplianceData();     // Catch: Exception -> L73
    L59:
        r103.setComplianceData(r110);     // Catch: Exception -> L73
        goto L61
    L58:
        r110 = r101.getComplianceData();     // Catch: Exception -> L73
        goto L59
    L42:
        r109 = r101.getAppIcon();     // Catch: Exception -> L73
        goto L43
    L38:
        r108 = r101.getName();     // Catch: Exception -> L73
        goto L39
    L18:
        r106 = r101.getFilePath();     // Catch: Exception -> L73
        goto L19
    L14:
        r105 = r101.getLogExtra();     // Catch: Exception -> L73
        goto L15
    L10:
        r104 = r101.getPackageName();     // Catch: Exception -> L73
        goto L11
    }
}
