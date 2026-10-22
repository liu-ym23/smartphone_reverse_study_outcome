package com.bytedance.geckox;

import android.text.TextUtils;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.geckox.model.CheckRequestParamModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.core.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class GeckoClient {
    public static final String GECKO_ROOT_DIR = "gecko_offline_res_x";
    private GeckoConfig mConfig;

    public void checkUpdateMulti() {
    }

    public void release() {
    }

    public GeckoConfig getConfig() {
        return this.mConfig;
    }

    private GeckoClient(GeckoConfig r100) {
        this.mConfig = r100;
    }

    private boolean checkTargetChannel(Map<String, List<CheckRequestBodyModel.TargetChannel>> r100) {
        if (r100 != null) goto L5;
    L18:
        return true;
    L5:
        if (r100.isEmpty() == true) goto L18;
        List<String> r101 = this.mConfig.getAccessKeys();
        Iterator<Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>>> r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> r103 = r102.next();
        Iterator<String> r104 = r101.iterator();
        boolean r105 = false;
    L12:
        if (r104.hasNext() == false) goto L16;
        if (TextUtils.equals(r104.next(), r103.getKey()) == false) goto L12;
        r105 = true;
        goto L12
    L16:
        if (r105 == true) goto L9;
        return false;
    }

    private boolean checkTargetChannelAndGroup(Map<String, CheckRequestParamModel> r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Set<String> r101 = r100.keySet();
        b r102 = b.a.f245076a;
        return ((ConcurrentHashMap) GlobalManager.f250635d).keySet().containsAll(r101);
    }

    public static GeckoClient create(GeckoConfig r100) {
        if (r100 == null) goto L21;
        List<String> r101 = r100.getAccessKeys();
        if (r101 == null) goto L19;
        if (r101.isEmpty() == true) goto L19;
        Iterator<String> r102 = r100.getAccessKeys().iterator();     // Catch: IllegalArgumentException -> L12
    L9:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();     // Catch: IllegalArgumentException -> L12
        b r104 = b.a.f245076a;     // Catch: IllegalArgumentException -> L12
        b.d(r103, r100.getResRootDir().getAbsolutePath());     // Catch: IllegalArgumentException -> L12
    L14:
        GeckoClient r105 = new GeckoClient(r100);
        Map<String, GeckoClient> r106 = a.f245075a;
        String r107 = r100.getAccessKey();
        ConcurrentHashMap r108 = (ConcurrentHashMap) a.f245075a;
        if (r108.get(r107) != null) goto L17;
        r108.put(r107, r105);
    L17:
        return r105;
    L12:
        e = move-exception;
        GeckoLogger.d("gecko client register root dir failed:" + e.getMessage());
    L19:
        throw new IllegalArgumentException("access key empty");
    L21:
        throw new IllegalArgumentException("config == null");
    }

    public void addCustomParams(Map<String, Map<String, OptionCheckUpdateParams.CustomValue>> r100) {
        b r101 = b.a.f245076a;
        Set<String> r102 = n.f250675a;
        if (r100 == null) goto L8;
        Iterator<Map.Entry<String, Map<String, OptionCheckUpdateParams.CustomValue>>> r103 = r100.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, Map<String, OptionCheckUpdateParams.CustomValue>> r104 = r103.next();
        Set<String> r105 = n.f250675a;
        n.a(r104.getKey(), r104.getValue());
        goto L6
    L10:
        return;
    }

    public void checkUpdateMulti(String r100) {
        checkUpdateMulti(r100, null, null, null);
    }

    public void checkUpdateMulti(Map<String, List<CheckRequestBodyModel.TargetChannel>> r100) {
        checkUpdateMulti(null, null, r100, null);
    }

    public void checkUpdateMulti(Map<String, CheckRequestParamModel> r100, OptionCheckUpdateParams r101) {
        if (GlobalManager.f250634c.get() == false) goto L5;
        b r102 = b.a.f245076a;
        if (b.c() == true) goto L19;
        if (r101 != null) goto L15;
        return;
    L15:
        if (r101.getListener() == null) goto L50;
        r101.getListener().onCheckServerVersionFail(null, new IllegalStateException("gecko is disabled"));
        return;
    L50:
        return;
    L19:
        if (checkTargetChannelAndGroup(r100) == false) goto L43;
        if (r101 != null) goto L45;
        r101 = new OptionCheckUpdateParams();
    L45:
        if (this.mConfig.getCacheConfig() == null) goto L47;
        this.mConfig.getCacheConfig().getClass();
        this.mConfig.getCacheConfig();
        this.mConfig.getResRootDir();
        this.mConfig.getAccessKeys();
        throw null;
    L47:
        c.c(r100, r101, ReqType.NORMAL);     // Catch: Throwable -> L28 Exception -> L30
    L26:
        if (r101.getListener() == null) goto L44;
    L34:
        r101.getListener().onUpdateFinish();
    L44:
        return;
    L30:
        e = move-exception;
        GeckoLogger.w("Gecko update failed:", e);     // Catch: Throwable -> L28
        if (r101.getListener() == null) goto L44;
    L28:
        th = move-exception;
        if (r101.getListener() == null) goto L39;
        r101.getListener().onUpdateFinish();
    L39:
        throw th;
    L43:
        throw new IllegalArgumentException("requestParams is null or target keys are not in deployments keys");
    L5:
        if (r101 != null) goto L7;
    L9:
        GeckoLogger.w("do not call deprecated checkUpdateMulti before GeckoGlobalManager.init");
        return;
    L7:
        if (r101.getListener() == null) goto L9;
        r101.getListener().onCheckServerVersionFail(null, new IllegalStateException("do not call deprecated checkUpdateMulti before GeckoGlobalManager.init"));
        goto L9
    }

    public void checkUpdateTarget(List<String> r100, GeckoUpdateListener r101) {
        checkUpdateTarget(r100, null, r101);
    }

    public void checkUpdateMulti(String r100, GeckoUpdateListener r101) {
        checkUpdateMulti(r100, null, null, r101);
    }

    public void checkUpdateMulti(String r100, Map<String, List<CheckRequestBodyModel.TargetChannel>> r101) {
        checkUpdateMulti(r100, null, r101, null);
    }

    public void checkUpdateMulti(Map<String, List<CheckRequestBodyModel.TargetChannel>> r100, GeckoUpdateListener r101) {
        checkUpdateMulti(null, null, r100, r101);
    }

    private boolean needRequest(String r100, Map<String, List<CheckRequestBodyModel.TargetChannel>> r110, OptionCheckUpdateParams r111) {
        if (r111.isRequestWhenHasLocalVersion() == false) goto L5;
        return true;
    L5:
        if (r110 != null) goto L7;
    L34:
        return true;
    L7:
        if (r110.isEmpty() == true) goto L34;
        if (TextUtils.isEmpty(r100) == false) goto L12;
    L14:
        ArrayList r101 = new ArrayList();
        Iterator<Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>>> r112 = r110.entrySet().iterator();
    L16:
        if (r112.hasNext() == false) goto L25;
        Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> r102 = r112.next();
        String r103 = r102.getKey();
        Iterator<CheckRequestBodyModel.TargetChannel> r104 = r102.getValue().iterator();
    L19:
        if (r104.hasNext() == false) goto L16;
        CheckRequestBodyModel.TargetChannel r105 = r104.next();
        Long r106 = ResLoadUtils.innerGetLatestChannelVersion(this.mConfig.getResRootDir(), r103, r105.channelName);
        if (r106 == null) goto L22;
        r101.add(new UpdatePackage(r103, r105.channelName, r106.longValue()));
        goto L19
    L22:
        return true;
    L25:
        if (r111.getListener() == null) goto L32;
        Iterator r107 = r101.iterator();
    L28:
        if (r107.hasNext() == false) goto L43;
        UpdatePackage r113 = (UpdatePackage) r107.next();
        Set<GeckoUpdateListener> r108 = ty5.a.f547967a;
        GeckoUpdateListener r109 = r111.getListener();
        if (r109 == null) goto L28;
        r109.onUpdateSuccess(r113, r113.getVersion());
        r109.onUpdateSuccess(r113.getChannel(), r113.getVersion());
        goto L28
    L43:
        return false;
    L32:
        return false;
    L12:
        if ("default".equals(r100) == true) goto L14;
        return true;
    }

    public void checkUpdateMulti(String r100, Map<String, List<CheckRequestBodyModel.TargetChannel>> r110, OptionCheckUpdateParams r111) {
        if (GlobalManager.f250634c.get() == false) goto L5;
        b r101 = b.a.f245076a;
        if (b.c() == true) goto L21;
        if (r111 != null) goto L17;
        return;
    L17:
        if (r111.getListener() == null) goto L126;
        r111.getListener().onCheckServerVersionFail(null, new IllegalStateException("gecko is disabled"));
        return;
    L126:
        return;
    L21:
        if (checkTargetChannel(r110) == false) goto L117;
        if (r111 != null) goto L24;
        r111 = new OptionCheckUpdateParams();
    L24:
        cz5.b r102 = cz5.b.f466051a;
        GeckoConfig r103 = this.mConfig;
        boolean r104 = true;
        boolean r105 = false;
        if (r111.isLazyUpdate() == false) goto L77;
        if (r103.getAccessKeys().size() <= 1) goto L31;
        GeckoUpdateListener r106 = r111.getListener();
        if (r106 == null) goto L91;
        r106.onCheckServerVersionFail(null, new IllegalArgumentException("lazy update not support multi ak"));
    L91:
        if (r104 == false) goto L94;
        return;
    L94:
        if (needRequest(r100, r110, r111) == true) goto L119;
        return;
    L119:
        if (this.mConfig.getCacheConfig() == null) goto L121;
        this.mConfig.getCacheConfig().getClass();
        this.mConfig.getCacheConfig();
        this.mConfig.getResRootDir();
        this.mConfig.getAccessKeys();
        throw null;
    L121:
        c.b(this.mConfig, r110, r100, r111);     // Catch: Throwable -> L102 Exception -> L104
    L100:
        if (r111.getListener() == null) goto L118;
    L108:
        r111.getListener().onUpdateFinish();
    L118:
        return;
    L104:
        e = move-exception;
        GeckoLogger.w("Gecko update failed:", e);     // Catch: Throwable -> L102
        if (r111.getListener() == null) goto L118;
    L102:
        th = move-exception;
        if (r111.getListener() == null) goto L113;
        r111.getListener().onUpdateFinish();
    L113:
        throw th;
    L31:
        if (r110 == null) goto L33;
        int r107 = r110.size();
    L34:
        if (r107 <= 1) goto L38;
        GeckoUpdateListener r108 = r111.getListener();
        if (r108 == null) goto L91;
        r108.onCheckServerVersionFail(null, new IllegalArgumentException("lazy update not support channels with multi ak"));
        goto L91
    L38:
        String r109 = r103.getAccessKey();
        if (r110 == null) goto L41;
        List<CheckRequestBodyModel.TargetChannel> r112 = r110.get(r109);
    L42:
        List<CheckRequestBodyModel.TargetChannel> r113 = r112;
        if (r113 != null) goto L45;
    L48:
        boolean r114 = true;
    L49:
        if (r100 != null) goto L51;
    L54:
        boolean r115 = true;
    L55:
        if (r115 == false) goto L57;
    L58:
        r105 = true;
    L59:
        if (r114 == false) goto L64;
        if (r105 == false) goto L64;
        GeckoUpdateListener r116 = r111.getListener();
        if (r116 == null) goto L91;
        r116.onCheckServerVersionFail(null, new IllegalArgumentException("lazy update argument error: channel empty and group empty"));
    L64:
        if (r114 == true) goto L69;
        if (r105 == true) goto L69;
        GeckoUpdateListener r117 = r111.getListener();
        if (r117 == null) goto L91;
        r117.onCheckServerVersionFail(null, new IllegalArgumentException("lazy update argument error: channel not empty and group not empty"));
    L69:
        if (r112 == null) goto L74;
        List<CheckRequestBodyModel.TargetChannel> r118 = r112;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator<T> r120 = r118.iterator();
    L72:
        if (r120.hasNext() == false) goto L75;
        r119.add(((CheckRequestBodyModel.TargetChannel) r120.next()).channelName);
    L75:
        r104 = r102.update(cz5.b.b(r111, r109, r100, r119));
        goto L91
    L74:
        r119 = null;
        goto L75
    L57:
        if (Intrinsics.areEqual(r100, "default") == false) goto L59;
    L51:
        if (r100.length() == 0) goto L54;
        r115 = false;
        goto L55
    L45:
        if (r113.isEmpty() == true) goto L48;
        r114 = false;
        goto L49
    L41:
        r112 = null;
        goto L42
    L33:
        r107 = 0;
        goto L34
    L77:
        if (r103.getAccessKeys().size() > 1) goto L90;
        String r121 = r103.getAccessKey();
        if (r110 == null) goto L90;
        if (r110.size() != 1) goto L90;
        List<CheckRequestBodyModel.TargetChannel> r122 = r110.get(r121);
        if (r122 == null) goto L90;
        if (r122.size() != 1) goto L90;
        r104 = r102.update(cz5.b.b(r111, r121, r100, CollectionsKt.listOf(((CheckRequestBodyModel.TargetChannel) ListProtector.get(r122, 0)).channelName)));
    L90:
        r104 = false;
        goto L91
    L117:
        throw new IllegalArgumentException("target keys are not in deployments keys");
    L5:
        if (r111 != null) goto L7;
    L9:
        GeckoLogger.w("do not call checkUpdateMulti before GeckoGlobalManager.init");
        if (r111 == null) goto L124;
        r111.getTag();
        return;
    L124:
        return;
    L7:
        if (r111.getListener() == null) goto L9;
        r111.getListener().onCheckServerVersionFail(null, new IllegalStateException("do not call checkUpdateMulti before GeckoGlobalManager.init"));
        goto L9
    }

    public void checkUpdateTarget(List<String> r100, Map<String, Object> r101, GeckoUpdateListener r102) {
        HashMap r103 = new HashMap();
        ArrayList r104 = new ArrayList();
        Iterator<String> r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(new CheckRequestBodyModel.TargetChannel(r105.next()));
        goto L4
    L6:
        r103.put(this.mConfig.getAccessKey(), r104);
        OptionCheckUpdateParams r106 = new OptionCheckUpdateParams();
        r106.setEnableThrottle(false);
        r106.setListener(r102);
        if (r101 == null) goto L9;
        HashMap r107 = new HashMap();
        r107.put(this.mConfig.getAccessKey(), r101);
        r106.setCustomParam(r107);
    L9:
        checkUpdateMulti("", r103, r106);
    }

    public void registerCheckUpdate(Map<String, CheckRequestParamModel> r100, OptionCheckUpdateParams r101, Map<String, String> r102) {
        checkUpdateMulti(r100, r101);
    }

    public void checkUpdateMulti(String r100, GeckoUpdateListener r101, Map<String, List<CheckRequestBodyModel.TargetChannel>> r102) {
        checkUpdateMulti(r100, null, r102, r101);
    }

    public void checkUpdateMulti(String r100, Map<String, Map<String, Object>> r101, Map<String, List<CheckRequestBodyModel.TargetChannel>> r102, GeckoUpdateListener r103) {
        OptionCheckUpdateParams r104 = new OptionCheckUpdateParams().setListener(r103);
        if (r101 == null) goto L5;
        r104.setCustomParam(r101);
    L5:
        checkUpdateMulti(r100, r102, r104);
    }
}
