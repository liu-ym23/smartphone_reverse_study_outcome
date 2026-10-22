package com.obric.sva.sdk.controller;

import android.content.Context;
import android.content.Intent;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.obric.sva.sdk.data.ExtendedSmModel;
import com.obric.sva.sdk.data.IExtendedSmModel;
import com.obric.sva.sdk.data.IKeyphraseModel;
import com.obric.sva.sdk.data.ISmModel;
import com.obric.sva.sdk.data.SettingsDAO;
import com.obric.sva.sdk.data.SettingsModel;
import com.obric.sva.sdk.listen.ObricListenTypes;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ExtendedSmMgr {
    private static final int SVA_APP_KEYPHRASE_ID_BASE = 500;
    private static volatile ArrayList<String> mUIMKeyphraseList;
    private final String TAG;
    private int mKeyphraseIdCounter;
    private volatile List<IExtendedSmModel> mSoundModelList;

    public static /* synthetic */ boolean a(File r100) {
        return lambda$initSoundModels$1(r100);
    }

    public static /* synthetic */ boolean b(File r100, String r101) {
        return lambda$initSoundModels$0(r100, r101);
    }

    public static /* synthetic */ int c(File r100, File r101) {
        return lambda$initSoundModels$3(r100, r101);
    }

    public static /* synthetic */ File[] d(int r100) {
        return lambda$initSoundModels$2(r100);
    }

    static {
        mUIMKeyphraseList = new ArrayList();
    }

    public ArrayList<IExtendedSmModel> getAllLoadedSoundModelList() {
        ArrayList<IExtendedSmModel> r100 = new ArrayList();
        Iterator<IExtendedSmModel> r101 = this.mSoundModelList.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        IExtendedSmModel r102 = r101.next();
        if (IExtendedSmModel.SessionStatus.STARTED == r102.getSessionStatus()) goto L9;
        if (IExtendedSmModel.SessionStatus.LOADED != r102.getSessionStatus()) goto L4;
    L9:
        r100.add(r102);
        goto L4
    L10:
        return r100;
    }

    public ArrayList<IExtendedSmModel> getCanDeleteSoundModelList() {
        ArrayList<IExtendedSmModel> r100 = new ArrayList();
        Iterator<IExtendedSmModel> r101 = this.mSoundModelList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        IExtendedSmModel r102 = r101.next();
        if (r102.isUserTrainedSoundModel() == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public ArrayList<IExtendedSmModel> getCanMergeSoundModelList() {
        ArrayList<IExtendedSmModel> r100 = new ArrayList();
        Iterator<IExtendedSmModel> r101 = this.mSoundModelList.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        IExtendedSmModel r102 = r101.next();
        if (r102.getSoundModelVersion() != ISmModel.ModelVersion.VERSION_2_0) goto L4;
        if (r102.isUdkSm() == true) goto L4;
        r100.add(r102);
        goto L4
    L10:
        return r100;
    }

    public ArrayList<IExtendedSmModel> getSingleKeyphraseSoundModelList() {
        ArrayList<IExtendedSmModel> r100 = new ArrayList();
        Iterator<IExtendedSmModel> r101 = this.mSoundModelList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        IExtendedSmModel r102 = r101.next();
        if (r102 == null) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public ArrayList<IExtendedSmModel> getTrainableSoundModelList() {
        ArrayList<IExtendedSmModel> r100 = new ArrayList();
        Iterator<IExtendedSmModel> r101 = this.mSoundModelList.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        IExtendedSmModel r102 = r101.next();
        if (ISmModel.SUFFIX_DEFAULT_SOUND_MODEL.equalsIgnoreCase(r102.getSoundModelSuffix()) == false) goto L4;
        if (r102.getSoundModelKeyphraseList().size() != 1) goto L4;
        r100.add(r102);
        goto L4
    L10:
        return r100;
    }

    public boolean hasActiveSessions() {
        Iterator<IExtendedSmModel> r100 = this.mSoundModelList.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        IExtendedSmModel r101 = r100.next();
        if (IExtendedSmModel.SessionStatus.STARTED != r101.getSessionStatus()) goto L4;
        return true;
    L8:
        return false;
    }

    public boolean hasLoadedOrActiveSessions() {
        Iterator<IExtendedSmModel> r100 = this.mSoundModelList.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        IExtendedSmModel r101 = r100.next();
        if (IExtendedSmModel.SessionStatus.UNLOADED == r101.getSessionStatus()) goto L4;
        return true;
    L8:
        return false;
    }

    public void resetAllSessionStatus() {
        LogUtils.d(this.TAG, "resetAllSessionStatus: enter", new Object[0]);
        Iterator<IExtendedSmModel> r100 = this.mSoundModelList.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().setSessionStatus(IExtendedSmModel.SessionStatus.UNLOADED);
        goto L4
    }

    public ExtendedSmMgr() {
        this.TAG = "ExtendedSmMgr";
        this.mSoundModelList = Collections.synchronizedList(new ArrayList());
        this.mKeyphraseIdCounter = 0;
    }

    public static ArrayList<String> getPDKkeyphraseList() {
        return mUIMKeyphraseList;
    }

    public List<IExtendedSmModel> getAllSoundModelList() {
        return this.mSoundModelList;
    }

    public ArrayList<String> getUIMKeyphraseList() {
        return mUIMKeyphraseList;
    }

    private ISmModel.ModelVersion convertVersion(int r100) {
        if (r100 != 256) goto L5;
        ISmModel.ModelVersion r101 = ISmModel.ModelVersion.VERSION_1_0;
    L24:
        LogUtils.d(this.TAG, "convertVersion: version = " + r100 + " convertedVersion = " + r101, new Object[0]);
        return r101;
    L5:
        if (r100 != 512) goto L7;
        r101 = ISmModel.ModelVersion.VERSION_2_0;
        goto L24
    L7:
        if (r100 != 768) goto L9;
        r101 = ISmModel.ModelVersion.VERSION_3_0;
        goto L24
    L9:
        if (r100 != 1024) goto L11;
        r101 = ISmModel.ModelVersion.VERSION_4_0;
        goto L24
    L11:
        if (r100 != 1280) goto L13;
        r101 = ISmModel.ModelVersion.VERSION_5_0;
        goto L24
    L13:
        if (r100 != 1536) goto L15;
        r101 = ISmModel.ModelVersion.VERSION_6_0;
        goto L24
    L15:
        if (r100 == 1792) goto L17;
        r101 = ISmModel.ModelVersion.VERSION_UNKNOWN;
        goto L24
    L17:
        r101 = ISmModel.ModelVersion.VERSION_7_0;
        goto L24
    }

    private ArrayList<String> generateKeyphraseUserIndicesArray(ObricListenTypes.SVASoundModelInfo r210) {
        ObricListenTypes.SVASoundModelInfo r100 = r210;
        ArrayList<String> r101 = new ArrayList();
        if (r100 != null) goto L6;
        LogUtils.e(this.TAG, "generateKeyphraseUserIndicesArray: invalid input param", new Object[0]);
        return r101;
    L6:
        ObricListenTypes.KeywordInfo[] r102 = r100.keywordInfo;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L10;
        ObricListenTypes.KeywordInfo r105 = r102[r104];
        r101.add(r105.keywordPhrase);
        String r106 = this.TAG;
        StringBuilder r110 = new StringBuilder("generateKeyphraseUserIndicesArray: ");
        r110.append(r105.keywordPhrase);
        r110.append(" index = ");
        r110.append(r101.size() - 1);
        LogUtils.d(r106, r110.toString(), new Object[0]);
        r104 = r104 + 1;
        goto L8
    L10:
        String[] r107 = r100.userNames;
        int r108 = r107.length;
        int r109 = 0;
    L11:
        if (r109 >= r108) goto L34;
        String r111 = r107[r109];
        ObricListenTypes.KeywordInfo[] r112 = r100.keywordInfo;
        int r113 = r112.length;
        int r114 = 0;
    L13:
        if (r114 >= r113) goto L33;
        ObricListenTypes.KeywordInfo r115 = r112[r114];
        if (768 != r100.version) goto L25;
        String[] r116 = r100.userNames;
        int r117 = r116.length;
        int r118 = 0;
    L17:
        String[] r119 = r107;
        if (r118 >= r117) goto L24;
        if (r111.equals(r116[r118]) == false) goto L23;
        r101.add(r111 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r115.keywordPhrase);
        String r120 = this.TAG;
        StringBuilder r121 = new StringBuilder("generateKeyphraseUserIndicesArray: 3.0 model ");
        r121.append(r115.keywordPhrase);
        r121.append(" & ");
        r121.append(r111);
        r121.append(" index = ");
        r121.append(r101.size() - 1);
        LogUtils.d(r120, r121.toString(), new Object[0]);
    L23:
        r118 = r118 + 1;
        r107 = r119;
        r108 = r108;
        r112 = r112;
        r113 = r113;
        goto L17
    L24:
        int r122 = r108;
        ObricListenTypes.KeywordInfo[] r123 = r112;
        int r124 = r113;
    L32:
        r114 = r114 + 1;
        r100 = r210;
        r107 = r119;
        r108 = r122;
        r112 = r123;
        r113 = r124;
        goto L13
    L25:
        r119 = r107;
        r122 = r108;
        r123 = r112;
        r124 = r113;
        String[] r125 = r115.activeUsers;
        int r126 = r125.length;
        int r127 = 0;
    L26:
        if (r127 >= r126) goto L32;
        if (r111.equals(r125[r127]) == false) goto L31;
        r101.add(r111 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r115.keywordPhrase);
        String r128 = this.TAG;
        StringBuilder r129 = new StringBuilder("generateKeyphraseUserIndicesArray: 2.0 model ");
        r129.append(r115.keywordPhrase);
        r129.append(" & ");
        r129.append(r111);
        r129.append(" index = ");
        r129.append(r101.size() - 1);
        LogUtils.d(r128, r129.toString(), new Object[0]);
    L31:
        r127 = r127 + 1;
        goto L26
    L33:
        r109 = r109 + 1;
        r100 = r210;
        goto L11
    L34:
        return r101;
    }

    private static /* synthetic */ boolean lambda$initSoundModels$1(File r100) {
        if (r100.getName().equals(SettingsDAO.NAME_HEYSNAPDRAGON_VOICE_MODEL) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.getName().equals(SettingsDAO.NAME_HEYSNAPDRAGON_BREATH_MODEL) == true) goto L8;
        return false;
    }

    private static /* synthetic */ File[] lambda$initSoundModels$2(int r100) {
        return new File[r100];
    }

    private ObricListenTypes.SVASoundModelInfo query(String r100) {
        LogUtils.d(this.TAG, "query: smFullName = " + r100, new Object[0]);
        if (r100 != null) goto L7;
        LogUtils.e(this.TAG, "query: invalid input param", new Object[0]);
        return null;
    L7:
        if (rna.c.c(Global.getInstance().PATH_ROOT + HTTP.URL_DEFAULT + r100) == true) goto L15;
        LogUtils.e(this.TAG, "query: error file not exists", new Object[0]);
        return null;
    L15:
        ObricListenTypes.SVASoundModelInfo r101 = new ObricListenTypes.SVASoundModelInfo();     // Catch: Exception -> L10
        r101.version = 0;     // Catch: Exception -> L10
        r101.type = 0;     // Catch: Exception -> L10
        r101.keywordInfo = new ObricListenTypes.KeywordInfo[1];     // Catch: Exception -> L10
        ObricListenTypes.KeywordInfo r102 = new ObricListenTypes.KeywordInfo();     // Catch: Exception -> L10
        r102.keywordPhrase = "obric";     // Catch: Exception -> L10
        r102.activeUsers = new String[]{"obric"};     // Catch: Exception -> L10
        r101.keywordInfo[0] = r102;     // Catch: Exception -> L10
        r101.userNames = new String[]{"obric"};     // Catch: Exception -> L10
        return r101;
    L10:
        e = move-exception;
        LogUtils.e(this.TAG, "query: error " + e, new Object[0]);
        return null;
    }

    public void deleteSoundModel(String r100) {
        LogUtils.d(this.TAG, "deleteSoundModel: smFullName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "deleteSoundModel: invalid input param", new Object[0]);
        return;
    L6:
        IExtendedSmModel r101 = getSoundModel(r100);
        if (r101 == null) goto L10;
        this.mSoundModelList.remove(r101);
        return;
    }

    public ByteBuffer getLanguageModel(ISmModel.ModelVersion r100) {
        LogUtils.d(this.TAG, "getLanguageModel: enter with version:" + r100, new Object[0]);
        if (r100 != ISmModel.ModelVersion.VERSION_5_0) goto L5;
    L16:
        LogUtils.e(this.TAG, "getLanguageModel: no corresponding language model", new Object[0]);
        String r101 = null;
    L18:
        if (rna.c.c(r101) == true) goto L26;
        LogUtils.d(this.TAG, "getLanguageModel: language model file not exist", new Object[0]);
        return null;
    L26:
        return rna.c.e(r101);
    L21:
        e = move-exception;
        LogUtils.e(this.TAG, "getLanguageModel: read language model failed, filePath=" + r101 + ", err=" + e, new Object[0]);
        return null;
    L5:
        if (r100 == ISmModel.ModelVersion.VERSION_6_0) goto L16;
        if (r100 != ISmModel.ModelVersion.VERSION_4_0) goto L11;
        r101 = Global.getInstance().PATH_ROOT + "/merged_language_model_1225.lat";
        LogUtils.d(this.TAG, "getLanguageModel: merged model", new Object[0]);
        goto L18
    L11:
        if (r100 != ISmModel.ModelVersion.VERSION_7_0) goto L14;
        LogUtils.d(this.TAG, "getLanguageModel: sm7 merged model", new Object[0]);
        throw new RuntimeException("has removed the model  , if need , please contact the developer");
    L14:
        LogUtils.d(this.TAG, "getLanguageModel: default model", new Object[0]);
        throw new RuntimeException("has removed the model , if need , please contact the developer");
    }

    public String getSmNameByHandle(int r100) {
        Iterator<IExtendedSmModel> r101 = this.mSoundModelList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        IExtendedSmModel r102 = r101.next();
        if (r102.getSoundModelHandle() != r100) goto L4;
        String r103 = r102.getSoundModelFullFileName();
    L9:
        LogUtils.d(this.TAG, "getSmNameByHandle: smHandle = " + r100 + " smName = " + r103, new Object[0]);
        return r103;
    L8:
        r103 = null;
        goto L9
    }

    public String getSmNameByKeyphraseId(int r100) {
        String r101 = null;
        if (r100 >= 0) goto L6;
        LogUtils.e(this.TAG, "getSmNameByKeyphraseId: invalid input param", new Object[0]);
        return null;
    L6:
        Iterator<IExtendedSmModel> r102 = this.mSoundModelList.iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        IExtendedSmModel r103 = r102.next();
        Iterator<IKeyphraseModel> r104 = r103.getSoundModelKeyphraseList().iterator();
    L11:
        if (r104.hasNext() == false) goto L8;
        if (r100 != r104.next().getKeyphraseId()) goto L11;
        r101 = r103.getSoundModelFullFileName();
        goto L8
    L15:
        LogUtils.e(this.TAG, "getSmNameByKeyphraseId: keyphraseId = " + r100 + " smName = " + r101, new Object[0]);
        return r101;
    }

    public IExtendedSmModel getSoundModel(String r100) {
        return getSoundModel(r100, this.mSoundModelList);
    }

    public String getSoundModelFullPath(String r100) {
        LogUtils.d(this.TAG, "getSoundModelFullPath: smFullName = " + r100, new Object[0]);
        if (r100 != null) goto L7;
        LogUtils.e(this.TAG, "getSoundModelFullPath: invalid input param", new Object[0]);
        return null;
    L7:
        return Global.getInstance().PATH_ROOT + HTTP.URL_DEFAULT + r100;
    }

    public boolean initSoundModels(Context r110) {
        ArrayList r100 = new ArrayList();
        ArrayList<String> r101 = new ArrayList();
        PolarisFileWrapper r102 = new PolarisFileWrapper(Global.getInstance().PATH_ROOT);
        if (r102.exists() == false) goto L21;
        File[] r103 = r102.listFiles(new d());
        LogUtils.d(this.TAG, "initSoundModels: check endfix files = " + r103.length, new Object[0]);
        File[] r104 = (File[]) Arrays.stream(r103).filter(new e()).toArray(new f());
        LogUtils.d(this.TAG, "initSoundModels: check name files = " + r104.length, new Object[0]);
        if (r104.length != 0) goto L8;
        LogUtils.e(this.TAG, "initSoundModels: no sound model file found", new Object[0]);
        publishSoundModels(r100, r101);
        return false;
    L8:
        LogUtils.e(this.TAG, "initSoundModels:  sound model file found with size :" + r104.length, new Object[0]);
        ArrayList r105 = new ArrayList();
        int r106 = r104.length;
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L11;
        r105.add(r104[r107]);
        r107 = r107 + 1;
        goto L9
    L11:
        Collections.sort(r105, new g());
        Iterator r108 = r105.iterator();
    L13:
        if (r108.hasNext() == false) goto L15;
        File r109 = (File) r108.next();
        LogUtils.d(this.TAG, "after sort file is :" + r109.getName(), new Object[0]);
        goto L13
    L15:
        Iterator r111 = r105.iterator();
        boolean r112 = false;
    L17:
        if (r111.hasNext() == false) goto L19;
        String r113 = ((File) r111.next()).getName();
        LogUtils.d(this.TAG, "initSoundModels: add sound model " + r113, new Object[0]);
        addSoundModel(r110, r113, r100, r101);
        r112 = true;
        goto L17
    L19:
        publishSoundModels(r100, r101);
        return r112;
    L21:
        publishSoundModels(r100, r101);
        return false;
    }

    public void resetSessionStatus(String r100) {
        LogUtils.d(this.TAG, "resetSessionStatus: enter : " + r100, new Object[0]);
        Iterator<IExtendedSmModel> r101 = this.mSoundModelList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        IExtendedSmModel r102 = r101.next();
        if (r102.getSoundModelFullFileName().equalsIgnoreCase(r100) == false) goto L4;
    L9:
        if (r102 == null) goto L15;
        r102.setSessionStatus(IExtendedSmModel.SessionStatus.UNLOADED);
        return;
    L15:
        return;
    L8:
        r102 = null;
        goto L9
    }

    private IExtendedSmModel getSoundModel(String r100, List<IExtendedSmModel> r101) {
        LogUtils.d(this.TAG, "getSoundModel: smFullName = " + r100, new Object[0]);
        IExtendedSmModel r102 = null;
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "getSoundModel: invalid input param", new Object[0]);
        return null;
    L6:
        monitor-enter(r101);
        Iterator<IExtendedSmModel> r103 = r101.iterator();     // Catch: Throwable -> L16
    L9:
        if (r103.hasNext() == false) goto L13;
        IExtendedSmModel r104 = r103.next();     // Catch: Throwable -> L16
        if (r104.getSoundModelFullFileName().equalsIgnoreCase(r100) == false) goto L9;
        r102 = r104;
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L16
        LogUtils.d(this.TAG, "getSoundModel: return model is  " + r102, new Object[0]);
        return r102;
    L16:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$initSoundModels$0(File r100, String r101) {
        if (r101.endsWith(ISmModel.SUFFIX_DEFAULT_SOUND_MODEL) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private static /* synthetic */ int lambda$initSoundModels$3(File r100, File r101) {
        boolean r102 = r100.getName().contains("voice");
        boolean r103 = r101.getName().contains("voice");
        if (r102 == false) goto L7;
        if (r103 == true) goto L7;
        return -1;
    L7:
        if (r102 == true) goto L11;
        if (r103 == false) goto L13;
        return 1;
    L13:
        return 0;
    L11:
        return 0;
    }

    private void publishSoundModels(List<IExtendedSmModel> r100, ArrayList<String> r101) {
        this.mSoundModelList = Collections.synchronizedList(new ArrayList(r100));
        mUIMKeyphraseList = new ArrayList(r101);
    }

    public void addSoundModel(Context r100, String r101) {
        addSoundModel(r100, r101, this.mSoundModelList, mUIMKeyphraseList);
    }

    public void updateSoundModel(Context r100, IExtendedSmModel r101) {
        updateSoundModel(r100, r101, mUIMKeyphraseList);
    }

    private int generateKeyphraseId(Context r100, ArrayList<String> r101, String r102) {
        if (r101 != null) goto L4;
    L9:
        LogUtils.e(this.TAG, "generateKeyphraseId: invalid input param", new Object[0]);
        return -1;
    L4:
        if (r101.isEmpty() == true) goto L9;
        if (r102 == null) goto L9;
        return r101.indexOf(r102);
    }

    private int generateUserId(ArrayList<String> r100, String r101, String r102) {
        if (r100 != null) goto L4;
    L10:
        LogUtils.e(this.TAG, "generateUserId: invalid input param", new Object[0]);
        return -1;
    L4:
        if (r100.isEmpty() == true) goto L10;
        if (r101 == null) goto L10;
        if (r102 == null) goto L10;
        return r100.indexOf(r102 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r101);
    }

    private void updateSoundModel(Context r100, IExtendedSmModel r101, ArrayList<String> r102) {
        LogUtils.d(this.TAG, "updateSoundModel: soundModel = " + r101, new Object[0]);
        if (r101 != null) goto L6;
        LogUtils.e(this.TAG, "updateSoundModel: invalid input param", new Object[0]);
        return;
    L6:
        String r103 = r101.getSoundModelFullFileName();
        ObricListenTypes.SVASoundModelInfo r104 = query(r103);
        if (r104 == null) goto L13;
        LogUtils.i(this.TAG, "updateSoundModel: query model Info " + r104, new Object[0]);
        r101.setSoundModelType(r104.type);
        r101.setSoundModelVersion(convertVersion(r104.version));
        ObricListenTypes.KeywordInfo[] r105 = r104.keywordInfo;
        if (r105 == null) goto L13;
        if (r105.length <= 0) goto L13;
        r101.setSoundModelPrettyKeyphrase(r105[0].keywordPhrase);
        addKeyphraseAndUsers(r100, r104, r101, r102);
    L13:
        SettingsModel r106 = new SettingsModel(r100, r103);
        r101.setSoundModelActionName(r106.getActionName());
        r101.setSoundModelActionIntent(r106.getActionIntent());
    }

    public void setSoundModelAction(String r100, String r101, Intent r102) {
        LogUtils.d(this.TAG, "setSoundModelAction: smFullName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.e(this.TAG, "setSoundModelAction: invalid input param", new Object[0]);
        return;
    L6:
        IExtendedSmModel r103 = getSoundModel(r100);
        if (r103 == null) goto L10;
        r103.setSoundModelActionName(r101);
        r103.setSoundModelActionIntent(r102);
        return;
    }

    private void addKeyphraseAndUsers(Context r110, ObricListenTypes.SVASoundModelInfo r210, IExtendedSmModel r211, ArrayList<String> r212) {
        ObricListenTypes.SVASoundModelInfo r100 = r210;
        int r101 = 0;
        if (r100 == null) goto L26;
        if (r211 == null) goto L26;
        ArrayList<String> r102 = generateKeyphraseUserIndicesArray(r100);
        if (r102.isEmpty() == true) goto L25;
        ObricListenTypes.KeywordInfo[] r103 = r100.keywordInfo;
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L32;
        ObricListenTypes.KeywordInfo r106 = r103[r105];
        int r111 = generateKeyphraseId(r110, r102, r106.keywordPhrase);
        r211.addKeyphrase(r106.keywordPhrase, r111);
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: keyphrase " + r106 + " 's keyphraseId = " + r111, new Object[r101]);
        if (r211.isUserTrainedSoundModel() == true) goto L16;
        if (r212.contains(r106.keywordPhrase) == true) goto L16;
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: add " + r106.keywordPhrase + " to mUIMKeyphraseList", new Object[r101]);
        r212.add(r106.keywordPhrase);
    L16:
        if (768 != r100.version) goto L21;
        String[] r112 = r100.userNames;
        int r113 = r112.length;
        int r114 = 0;
    L18:
        if (r114 >= r113) goto L20;
        String r107 = r112[r114];
        int r108 = generateUserId(r102, r106.keywordPhrase, r107);
        r211.addKeyphraseAndUser(r106.keywordPhrase, r111, r107, r108);
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: 3.0 model user " + r107 + " 's userId = " + r108, new Object[0]);
        r114 = r114 + 1;
        r103 = r103;
        r104 = r104;
        goto L18
    L20:
        ObricListenTypes.KeywordInfo[] r115 = r103;
        int r116 = r104;
    L24:
        r105 = r105 + 1;
        r100 = r210;
        r103 = r115;
        r104 = r116;
        r101 = 0;
        goto L9
    L21:
        r115 = r103;
        r116 = r104;
        String[] r109 = r106.activeUsers;
        int r117 = r109.length;
        int r118 = 0;
    L22:
        if (r118 >= r117) goto L24;
        String r119 = r109[r118];
        int r120 = generateUserId(r102, r106.keywordPhrase, r119);
        r211.addKeyphraseAndUser(r106.keywordPhrase, r111, r119, r120);
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: user " + r119 + " 's userId = " + r120, new Object[0]);
        r118 = r118 + 1;
        goto L22
    L32:
        return;
    L25:
        return;
    L26:
        LogUtils.e(this.TAG, "addKeyphraseAndUsers: invalid input param", new Object[0]);
    }

    private void addSoundModel(Context r100, String r101, List<IExtendedSmModel> r102, ArrayList<String> r103) {
        LogUtils.d(this.TAG, "addSoundModel: smFullName = " + r101, new Object[0]);
        if (r101 != null) goto L6;
        LogUtils.d(this.TAG, "addSoundModel: invalid input param", new Object[0]);
        return;
    L6:
        IExtendedSmModel r104 = getSoundModel(r101, r102);
        if (r104 != null) goto L9;
        LogUtils.d(this.TAG, "addSoundModel: new one sound model" + r101, new Object[0]);
        r104 = new ExtendedSmModel(r101);
        r102.add(r104);
    L10:
        updateSoundModel(r100, r104, r103);
        SettingsModel r105 = new SettingsModel(r100, r101);
        if (r104.isSupportExtendedOpaqueData() == false) goto L14;
        LogUtils.d(this.TAG, "addSoundModel: set opaque data transfer enabled.", new Object[0]);
        r105.setOpaqueDataTransferEnabled(true);
        return;
    L14:
        return;
    L9:
        LogUtils.d(this.TAG, "addSoundModel: sound model already exists", new Object[0]);
        goto L10
    }
}
