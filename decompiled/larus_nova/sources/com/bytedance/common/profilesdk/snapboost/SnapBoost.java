package com.bytedance.common.profilesdk.snapboost;

import android.content.Context;
import com.bytedance.common.profilesdk.AppContext;
import com.bytedance.common.profilesdk.util.VersionUtils;

/* JADX INFO: loaded from: classes15.dex */
public class SnapBoost {
    private static volatile boolean isEnabled = true;
    private static volatile boolean sInited;

    public static class ProfileEditorBuilder {
        private boolean mAllMethod;
        private String mDexPath;
        private String mName;
        private boolean mNeedCompile;
        private boolean mNeverSkip;
        private String mVersion;

        public ProfileEditor build() {
            ProfileEditor r100 = new ProfileEditor();
            r100.mNeedCompile = this.mNeedCompile;
            r100.mNeverSkip = this.mNeverSkip;
            r100.mDexPath = this.mDexPath;
            r100.mName = this.mName;
            r100.mVersion = this.mVersion;
            r100.mAllMethod = this.mAllMethod;
            return r100;
        }

        public ProfileEditorBuilder() {
            this.mName = "none";
            this.mVersion = "0";
            this.mAllMethod = false;
        }

        public ProfileEditorBuilder name(String r100) {
            this.mName = r100;
            return this;
        }

        public ProfileEditorBuilder version(String r100) {
            this.mVersion = r100;
            return this;
        }
    }

    public SnapBoost() {
    }

    public static boolean versionSupport() {
        return true;
    }

    public static ProfileEditorBuilder createEditorBuidler() {
        return new ProfileEditorBuilder();
    }

    public static boolean hasInited() {
        if (sInited == true) goto L5;
    L7:
        return false;
    L5:
        if (isEnabled == false) goto L7;
        return true;
    }

    public static boolean versionSupportProfile() {
        if (VersionUtils.isP() == false) goto L5;
    L10:
        return true;
    L5:
        if (VersionUtils.isQ() == true) goto L10;
        if (VersionUtils.isR() == true) goto L10;
        return false;
    }

    public static ClassList findClassList(String r100) {
        return new ClassList(r100, SnapBoost.class.getClassLoader());
    }

    public static void init(Context r100, boolean r101) {
        AppContext.init(r100);
        sInited = true;
    }
}
