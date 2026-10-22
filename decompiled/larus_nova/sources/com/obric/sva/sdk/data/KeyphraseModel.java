package com.obric.sva.sdk.data;

import com.obric.sva.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class KeyphraseModel implements IKeyphraseModel {
    private final String TAG;
    private String mKeyphraseFullName;
    private int mKeyphraseId;
    private String mKeyphrasePrettyName;
    private ArrayList<IUserModel> mUserList;

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public String getKeyphraseFullName() {
        return this.mKeyphraseFullName;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public int getKeyphraseId() {
        return this.mKeyphraseId;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public String getKeyphrasePrettyName() {
        return this.mKeyphrasePrettyName;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public ArrayList<IUserModel> getUserList() {
        return this.mUserList;
    }

    public KeyphraseModel(String r100) {
        this.TAG = "KeyphraseModel";
        this.mKeyphraseId = -1;
        this.mUserList = new ArrayList();
        this.mKeyphraseFullName = r100;
    }

    private String maskUserIdForLog(int r100) {
        String r101 = String.valueOf(r100);
        return "****" + r101.substring(Math.max(0, r101.length() - 4));
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public IUserModel getUserModel(String r100) {
        LogUtils.d(this.TAG, "getUserModel: userName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "getUserModel: invalid input param", new Object[0]);
        return null;
    L6:
        Iterator<IUserModel> r101 = this.mUserList.iterator();
    L8:
        if (r101.hasNext() == false) goto L16;
        IUserModel r102 = r101.next();
        if (r102.getUserName().equalsIgnoreCase(r100) == false) goto L8;
        return r102;
    L16:
        return null;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public String getUserNameById(int r100) {
        Iterator<IUserModel> r101 = this.mUserList.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        IUserModel r102 = r101.next();
        if (r102.getUserId() != r100) goto L4;
        String r103 = r102.getUserName();
    L9:
        LogUtils.d(this.TAG, "getUserNameById: id = " + r100 + " userName = " + r103, new Object[0]);
        return r103;
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void removeUser(String r100) {
        LogUtils.d(this.TAG, "removeUser: userName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "removeUser: invalid input param", new Object[0]);
        return;
    L6:
        ArrayList r101 = new ArrayList();
        Iterator<IUserModel> r102 = this.mUserList.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        IUserModel r103 = r102.next();
        if (r100.equalsIgnoreCase(r103.getUserName()) == false) goto L8;
        r101.add(r103);
        goto L8
    L13:
        if (r101.isEmpty() == true) goto L21;
        this.mUserList.removeAll(r101);
        return;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void setKeyphraseFullName(String r100) {
        this.mKeyphraseFullName = r100;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void setKeyphraseId(int r100) {
        LogUtils.d(this.TAG, "setKeyphraseId: id = " + r100, new Object[0]);
        if (r100 >= (-1)) goto L6;
        LogUtils.d(this.TAG, "setKeyphraseId: invalid keyphrase id", new Object[0]);
        return;
    L6:
        this.mKeyphraseId = r100;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void setKeyphrasePrettyName(String r100) {
        this.mKeyphrasePrettyName = r100;
    }

    @Override // com.obric.sva.sdk.data.IKeyphraseModel
    public void addUser(String r100, int r101) {
        LogUtils.d(this.TAG, "addUser: userName = " + r100 + " userId = " + maskUserIdForLog(r101), new Object[0]);
        if (r100 != null) goto L5;
    L12:
        LogUtils.d(this.TAG, "addUser: invalid input param", new Object[0]);
        return;
    L5:
        if (r101 < (-1)) goto L12;
        IUserModel r102 = getUserModel(r100);
        if (r102 != null) goto L10;
        UserModel r103 = new UserModel(r100);
        r103.setUserId(r101);
        this.mUserList.add(r103);
        return;
    L10:
        r102.setUserId(r101);
    }
}
