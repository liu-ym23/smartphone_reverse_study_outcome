package com.obric.sva.sdk.data;

import com.obric.sva.sdk.controller.ExtendedSmMgr;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes6.dex */
public class SmModel implements ISmModel {
    public static final int NUM_OF_MAX_USERS = 3;
    public final String HEY_SNAPDRAGON;
    public final String HEY_SNAPDRAGON_3_0;
    public final String NI_HAO_XIAO_LONG;
    private final String TAG;
    protected String mSmFullFileName;
    private List<IKeyphraseModel> mSmKeyphraseList;
    private String mSmPrettyFileName;
    private String mSmPrettyKeyphrase;
    private String mSmSuffix;
    private int mSmType;
    private UUID mSmUUID;
    private ISmModel.ModelVersion mSmVersion;

    @Override // com.obric.sva.sdk.data.ISmModel
    public ArrayList<IUserModel> getAllUsers() {
        ArrayList<IUserModel> r100 = new ArrayList();
        Iterator<IKeyphraseModel> r101 = this.mSmKeyphraseList.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addAll(r101.next().getUserList());
        goto L4
    L6:
        return r100;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean isSupportExtendedOpaqueData() {
        this.mSmVersion.getVersionNumber();
        ISmModel.ModelVersion.VERSION_3_0.getVersionNumber();
        return true;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean isUserTrainedSoundModel() {
        return this.mSmSuffix.endsWith(ISmModel.SUFFIX_TRAINED_SOUND_MODEL);
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean canAddUser() {
        if (isUserTrainedSoundModel() == true) goto L5;
    L23:
        boolean r100 = false;
    L24:
        LogUtils.d(this.TAG, "canAddUser: canAddUser = " + r100, new Object[0]);
        return r100;
    L5:
        if (isUdkSm() == true) goto L23;
        ISmModel.ModelVersion r101 = this.mSmVersion;
        r100 = true;
        if (r101 == ISmModel.ModelVersion.VERSION_3_0) goto L22;
        if (r101 == ISmModel.ModelVersion.VERSION_4_0) goto L22;
        if (r101 == ISmModel.ModelVersion.VERSION_5_0) goto L22;
        if (r101 == ISmModel.ModelVersion.VERSION_6_0) goto L22;
        if (r101 == ISmModel.ModelVersion.VERSION_7_0) goto L22;
        if (getAllUsers().size() < 3) goto L24;
    L22:
        if (getAllUsers().size() <= 0) goto L24;
        goto L23
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean isUdkSm() {
        String r100 = getSoundModelPrettyKeyphrase();
        ArrayList<String> r101 = ExtendedSmMgr.getPDKkeyphraseList();
        boolean r102 = true;
        if (r101.isEmpty() == true) goto L5;
        Iterator<String> r103 = r101.iterator();
    L13:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();
        if (r100 == null) goto L13;
        if (r100.equalsIgnoreCase(r104) == false) goto L13;
    L10:
        r102 = false;
    L19:
        LogUtils.d(this.TAG, "isUdkSm: isUdkSm = " + r102, new Object[0]);
        return r102;
    L5:
        if ("Hey Snapdragon".equalsIgnoreCase(r100) == true) goto L10;
        if ("ni hao xiao long".equalsIgnoreCase(r100) == true) goto L10;
        if ("HeySnapdragon_flt10p100".equalsIgnoreCase(r100) == false) goto L19;
        goto L10
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getSoundModelFullFileName() {
        return this.mSmFullFileName;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public List<IKeyphraseModel> getSoundModelKeyphraseList() {
        return this.mSmKeyphraseList;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getSoundModelPrettyFileName() {
        return this.mSmPrettyFileName;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getSoundModelPrettyKeyphrase() {
        return this.mSmPrettyKeyphrase;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getSoundModelSuffix() {
        return this.mSmSuffix;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public int getSoundModelType() {
        return this.mSmType;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public UUID getSoundModelUUID() {
        return this.mSmUUID;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public ISmModel.ModelVersion getSoundModelVersion() {
        return this.mSmVersion;
    }

    public SmModel(String r100) {
        this.HEY_SNAPDRAGON = "Hey Snapdragon";
        this.NI_HAO_XIAO_LONG = "ni hao xiao long";
        this.HEY_SNAPDRAGON_3_0 = "HeySnapdragon_flt10p100";
        this.TAG = "SmModel";
        this.mSmVersion = ISmModel.ModelVersion.VERSION_2_0;
        this.mSmKeyphraseList = new ArrayList();
        this.mSmFullFileName = r100;
        this.mSmPrettyFileName = r100.substring(0, r100.indexOf("."));
        this.mSmSuffix = r100.substring(r100.lastIndexOf(46));
        this.mSmUUID = UUID.randomUUID();
        LogUtils.d("SmModel", "SmModel: mSmFullFileName = " + this.mSmFullFileName + " mSmSuffix = " + this.mSmSuffix + " mSmUUID = " + this.mSmUUID, new Object[0]);
    }

    private String maskUserIdForLog(int r100) {
        String r101 = String.valueOf(r100);
        return "****" + r101.substring(Math.max(0, r101.length() - 4));
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public IKeyphraseModel getKeyphraseModel(String r100) {
        LogUtils.d(this.TAG, "getKeyphraseModel: keyphrase = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "getKeyphraseModel: invalid input param", new Object[0]);
        return null;
    L6:
        Iterator<IKeyphraseModel> r101 = this.mSmKeyphraseList.iterator();
    L8:
        if (r101.hasNext() == false) goto L16;
        IKeyphraseModel r102 = r101.next();
        if (r102.getKeyphraseFullName().equalsIgnoreCase(r100) == false) goto L8;
        return r102;
    L16:
        return null;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public String getKeyphraseNameById(int r100) {
        Iterator<IKeyphraseModel> r101 = this.mSmKeyphraseList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        IKeyphraseModel r102 = r101.next();
        if (r102.getKeyphraseId() != r100) goto L4;
        String r103 = r102.getKeyphraseFullName();
    L9:
        LogUtils.d(this.TAG, "getKeyphraseNameById: id = " + r100 + " keyphraseName = " + r103, new Object[0]);
        return r103;
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void removeKeyphrase(String r100) {
        LogUtils.d(this.TAG, "removeKeyphrase: keyphrase = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "removeKeyphrase: invalid input param", new Object[0]);
        return;
    L6:
        IKeyphraseModel r101 = getKeyphraseModel(r100);
        if (r101 == null) goto L10;
        this.mSmKeyphraseList.remove(r101);
        return;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelFullFileName(String r100) {
        this.mSmFullFileName = r100;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelPrettyFileName(String r100) {
        this.mSmPrettyFileName = r100;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelPrettyKeyphrase(String r100) {
        this.mSmPrettyKeyphrase = r100;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelSuffix(String r100) {
        this.mSmSuffix = r100;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelType(int r100) {
        this.mSmType = r100;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void setSoundModelVersion(ISmModel.ModelVersion r100) {
        this.mSmVersion = r100;
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void addKeyphrase(String r100, int r101) {
        LogUtils.d(this.TAG, "addKeyphrase: keyphrase = " + r100 + " keyphraseId = " + r101, new Object[0]);
        if (r100 != null) goto L5;
    L12:
        LogUtils.d(this.TAG, "addKeyphrase: invalid input param", new Object[0]);
        return;
    L5:
        if (r101 < (-1)) goto L12;
        IKeyphraseModel r102 = getKeyphraseModel(r100);
        if (r102 != null) goto L10;
        KeyphraseModel r103 = new KeyphraseModel(r100);
        r103.setKeyphraseId(r101);
        this.mSmKeyphraseList.add(r103);
        return;
    L10:
        r102.setKeyphraseId(r101);
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public boolean isUserExistForKeyphrase(String r100, String r101) {
        IKeyphraseModel r102 = getKeyphraseModel(r100);
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        LogUtils.d(this.TAG, "isUserExistForKeyphrase: keyphrase = " + r100 + " userName = " + r101 + " bExist = " + r103, new Object[0]);
        return r103;
    L5:
        if (r102.getUserModel(r101) == null) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void removeUser(String r100, String r101) {
        LogUtils.d(this.TAG, "removeUser: keyphrase = " + r100 + " userName = " + r101, new Object[0]);
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        IKeyphraseModel r102 = getKeyphraseModel(r100);
        if (r102 != null) goto L10;
        LogUtils.d(this.TAG, "removeUser: invalid keyphrase = " + r100, new Object[0]);
        return;
    L10:
        r102.removeUser(r101);
        return;
    L12:
        LogUtils.d(this.TAG, "removeUser: invalid input param", new Object[0]);
    }

    @Override // com.obric.sva.sdk.data.ISmModel
    public void addKeyphraseAndUser(String r100, int r101, String r102, int r103) {
        LogUtils.d(this.TAG, "addKeyphraseAndUser: keyphrase = " + r100 + " keyphraseId = " + r101 + " userName = " + r102 + " userId = " + maskUserIdForLog(r103), new Object[0]);
        if (r100 != null) goto L5;
    L14:
        LogUtils.d(this.TAG, "addKeyphraseAndUser: invalid input param", new Object[0]);
        return;
    L5:
        if (r101 < (-1)) goto L14;
        if (r102 == null) goto L14;
        if (r103 < (-1)) goto L14;
        IKeyphraseModel r104 = getKeyphraseModel(r100);
        if (r104 != null) goto L12;
        KeyphraseModel r105 = new KeyphraseModel(r100);
        r105.setKeyphraseId(r101);
        r105.addUser(r102, r103);
        this.mSmKeyphraseList.add(r105);
        return;
    L12:
        r104.setKeyphraseId(r101);
        r104.addUser(r102, r103);
    }
}
