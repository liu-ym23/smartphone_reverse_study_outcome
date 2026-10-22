package com.ss.android.download.api.config;

import com.ss.android.download.api.model.AppLinkCallbackModel;
import com.ss.android.download.api.model.DownloadEventModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/ss/android/download/api/config/DownloadBusinessInterceptor;", "", "beforeSendAdEvent", "", "eventModel", "Lcom/ss/android/download/api/model/DownloadEventModel;", "checkInterceptAdEvent", "", "onBeforeAppLink", "appLinkCallbackModel", "Lcom/ss/android/download/api/model/AppLinkCallbackModel;", "onInitFinish", "onSendAdEvent", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface DownloadBusinessInterceptor {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static boolean checkInterceptAdEvent(DownloadBusinessInterceptor r100, DownloadEventModel r101) {
            return false;
        }
    }

    void beforeSendAdEvent(DownloadEventModel r100);

    boolean checkInterceptAdEvent(DownloadEventModel r100);

    void onBeforeAppLink(AppLinkCallbackModel r100);

    void onInitFinish();

    void onSendAdEvent(DownloadEventModel r100);
}
