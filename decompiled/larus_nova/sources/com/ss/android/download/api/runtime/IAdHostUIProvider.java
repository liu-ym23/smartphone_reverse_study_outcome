package com.ss.android.download.api.runtime;

import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J<\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0014H&¨\u0006\u001b"}, d2 = {"Lcom/ss/android/download/api/runtime/IAdHostUIProvider;", "", "buildNotification", "Landroid/app/Notification;", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "createLoadingView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getSkinName", "", "getSkinType", "showDialog", "Landroid/app/Dialog;", "downloadAlertDialogInfo", "Lcom/ss/android/download/api/model/DownloadAlertDialogInfo;", "showToast", "", "scene", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/download/api/download/DownloadModel;", "message", "icon", "Landroid/graphics/drawable/Drawable;", "duration", "download-api_release"}, k = 1, mv = {1, 1, 16})
public interface IAdHostUIProvider {
    Notification buildNotification(NotificationCompat.Builder r100);

    View createLoadingView(Context r100);

    String getSkinName();

    String getSkinType();

    Dialog showDialog(DownloadAlertDialogInfo r100);

    void showToast(int r100, Context r101, DownloadModel r102, String r103, Drawable r104, int r105);
}
