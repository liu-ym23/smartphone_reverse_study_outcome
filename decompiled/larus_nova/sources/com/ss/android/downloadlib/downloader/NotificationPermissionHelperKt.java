package com.ss.android.downloadlib.downloader;

import androidx.core.app.NotificationManagerCompat;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"isNotificationEnabled", "", "download-impl_release"}, k = 2, mv = {1, 1, 16})
public final class NotificationPermissionHelperKt {
    public static final boolean isNotificationEnabled() {
        return NotificationManagerCompat.from(GlobalInfo.getContext()).areNotificationsEnabled();
    L4:
        th = move-exception;
        th.printStackTrace();
        return true;
    }
}
