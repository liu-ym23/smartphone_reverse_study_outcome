package com.bytedance.common.profilesdk;

/* JADX INFO: loaded from: classes15.dex */
public class ProfileManager {
    public static boolean createProfileForSourceDex(String r100, String r101) {
        return DexImageLoader.ProfileChoreographer.createAllClassProfile(r100, r101);
    }
}
