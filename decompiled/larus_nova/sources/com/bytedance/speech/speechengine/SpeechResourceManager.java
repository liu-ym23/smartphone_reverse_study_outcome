package com.bytedance.speech.speechengine;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public interface SpeechResourceManager {

    /* JADX INFO: renamed from: com.bytedance.speech.speechengine.SpeechResourceManager$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$checkResourceDownload(SpeechResourceManager r100) {
            return false;
        }

        public static void $default$checkResourceUpdate(SpeechResourceManager r100, CheckResouceUpdateListener r101) {
        }

        public static boolean $default$extractResource(SpeechResourceManager r100, String r101) {
            return false;
        }

        public static void $default$fetchResource(SpeechResourceManager r100, FetchResourceListener r101) {
        }

        public static String $default$getResourcePath(SpeechResourceManager r100) {
            return "";
        }

        public static void $default$setAddress(SpeechResourceManager r100, String r101) {
        }

        public static void $default$setAppId(SpeechResourceManager r100, String r101) {
        }

        public static void $default$setAppVersion(SpeechResourceManager r100, String r101) {
        }

        public static void $default$setDeviceId(SpeechResourceManager r100, String r101) {
        }

        public static void $default$setEngineName(SpeechResourceManager r100, String r101) {
        }

        public static void $default$setTtsLanguage(SpeechResourceManager r100, String[] r101) {
        }

        public static void $default$setTtsVoiceType(SpeechResourceManager r100, String[] r101) {
        }

        public static void $default$setUseOnlineModel(SpeechResourceManager r100, boolean r101) {
        }

        public static boolean $default$initResourceManager(SpeechResourceManager r100, Context r101, String r102) {
            return r100.initResourceManager(r101, "", "", "", false, r102);
        }
    }

    public interface CheckResouceUpdateListener {
        void onCheckResult(boolean r100);
    }

    public interface FetchResourceListener {
        void onFailed(String r100);

        void onSuccess();
    }

    boolean checkResourceDownload();

    boolean checkResourceDownload(String r100);

    void checkResourceUpdate(CheckResouceUpdateListener r100);

    void checkResourceUpdate(String r100, CheckResouceUpdateListener r101);

    boolean extractResource(String r100);

    void fetchResource(FetchResourceListener r100);

    void fetchResourceByName(String r100, FetchResourceListener r101);

    String getResourcePath();

    String getResourcePath(String r100);

    boolean initResourceManager(Context r100, String r101);

    boolean initResourceManager(Context r100, String r101, String r102, String r103, boolean r104, String r105);

    void setAddress(String r100);

    void setAppId(String r100);

    void setAppVersion(String r100);

    void setDeviceId(String r100);

    void setEngineName(String r100);

    void setTtsLanguage(String[] r100);

    void setTtsVoiceType(String[] r100);

    void setUseOnlineModel(boolean r100);
}
