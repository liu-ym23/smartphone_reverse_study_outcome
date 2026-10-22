package com.obric.sva.sdk.data;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public interface IKeyphraseModel {
    public static final int INVALID_ID = -1;

    void addUser(String r100, int r101);

    String getKeyphraseFullName();

    int getKeyphraseId();

    String getKeyphrasePrettyName();

    ArrayList<IUserModel> getUserList();

    IUserModel getUserModel(String r100);

    String getUserNameById(int r100);

    void removeUser(String r100);

    void setKeyphraseFullName(String r100);

    void setKeyphraseId(int r100);

    void setKeyphrasePrettyName(String r100);
}
