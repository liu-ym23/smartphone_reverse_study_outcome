package com.ss.android.download.api;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0003\f\r\u000eJ\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/ss/android/download/api/ITTDownloadIntercept;", "", "tag", "", "getTag", "()Ljava/lang/String;", "doProcess", "", "chain", "Lcom/ss/android/download/api/ITTDownloadIntercept$Chain;", "nextIndex", "", "Chain", "ChainInfo", "Companion", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface ITTDownloadIntercept {
    public static final Companion Companion = null;
    public static final String TAG_BEGIN_DOWNLOAD_APP = "BEGIN_DOWNLOAD_APP";
    public static final String TAG_COMPLIANCE = "COMPLIANCE";
    public static final String TAG_LANDING_PAGE = "LANDING_PAGE";
    public static final String TAG_OPEN_INSTALLED_APP = "INSTALLED_APP";
    public static final String TAG_OPEN_MARKET = "OPEN_MARKET";
    public static final String TAG_OPEN_QUICK_APP = "OPEN_QUICK_APP";
    public static final String TAG_ORDER_DOWNLOAD_APP = "ORDER_DOWNLOAD_APP";
    public static final String TAG_OTHER_DOWNLOAD_APP = "OTHER_DOWNLOAD_APP";
    public static final String TAG_PAUSE_DOWNLOAD_APP = "PAUSE_DOWNLOAD_APP";
    public static final String TAG_RESUME_DOWNLOAD_APP = "RESUME_DOWNLOAD_APP";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/ss/android/download/api/ITTDownloadIntercept$Chain;", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "info", "Lcom/ss/android/download/api/ITTDownloadIntercept$ChainInfo;", "getInfo", "()Lcom/ss/android/download/api/ITTDownloadIntercept$ChainInfo;", "addIntercept", "processor", "Lcom/ss/android/download/api/ITTDownloadIntercept;", "proceed", "", "nextIndex", "", "processorTag", "", "download-api_release"}, k = 1, mv = {1, 1, 16})
    public interface Chain {
        Chain addIntercept(ITTDownloadIntercept r100);

        Context getAppContext();

        ChainInfo getInfo();

        void proceed(int r100);

        void proceed(String r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/download/api/ITTDownloadIntercept$ChainInfo;", "", "()V", "download-api_release"}, k = 1, mv = {1, 1, 16})
    public static abstract class ChainInfo {
        public ChainInfo() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/download/api/ITTDownloadIntercept$Companion;", "", "()V", "TAG_BEGIN_DOWNLOAD_APP", "", "TAG_COMPLIANCE", "TAG_LANDING_PAGE", "TAG_OPEN_INSTALLED_APP", "TAG_OPEN_MARKET", "TAG_OPEN_QUICK_APP", "TAG_ORDER_DOWNLOAD_APP", "TAG_OTHER_DOWNLOAD_APP", "TAG_PAUSE_DOWNLOAD_APP", "TAG_RESUME_DOWNLOAD_APP", "download-api_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String TAG_BEGIN_DOWNLOAD_APP = "BEGIN_DOWNLOAD_APP";
        public static final String TAG_COMPLIANCE = "COMPLIANCE";
        public static final String TAG_LANDING_PAGE = "LANDING_PAGE";
        public static final String TAG_OPEN_INSTALLED_APP = "INSTALLED_APP";
        public static final String TAG_OPEN_MARKET = "OPEN_MARKET";
        public static final String TAG_OPEN_QUICK_APP = "OPEN_QUICK_APP";
        public static final String TAG_ORDER_DOWNLOAD_APP = "ORDER_DOWNLOAD_APP";
        public static final String TAG_OTHER_DOWNLOAD_APP = "OTHER_DOWNLOAD_APP";
        public static final String TAG_PAUSE_DOWNLOAD_APP = "PAUSE_DOWNLOAD_APP";
        public static final String TAG_RESUME_DOWNLOAD_APP = "RESUME_DOWNLOAD_APP";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void doProcess(Chain r100, int r101);

    String getTag();
}
