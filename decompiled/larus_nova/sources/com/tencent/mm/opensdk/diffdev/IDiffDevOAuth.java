package com.tencent.mm.opensdk.diffdev;

/* JADX INFO: loaded from: classes40.dex */
public interface IDiffDevOAuth {
    void addListener(OAuthListener r100);

    boolean auth(String r100, String r101, String r102, String r103, String r104, OAuthListener r105);

    void detach();

    void removeAllListeners();

    void removeListener(OAuthListener r100);

    boolean stopAuth();
}
