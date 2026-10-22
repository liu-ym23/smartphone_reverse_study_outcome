package com.ss.android.downloadlib.runtime.impl;

import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.download.api.common.DefaultDownloadUIFactory;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.download.api.runtime.IAdHostUIProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import t6.a;
import t6.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u0001:\u0001#B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J<\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdHostUIProviderImpl;", "Lcom/ss/android/download/api/runtime/IAdHostUIProvider;", "enableRuntimeDialog", "", "enableRuntimeToast", "enableRuntime", "(ZZZ)V", "defaultUIFactory", "Lcom/ss/android/download/api/common/DefaultDownloadUIFactory;", "needDefaultFactory", "buildNotification", "Landroid/app/Notification;", "builder", "Landroidx/core/app/NotificationCompat$Builder;", "createLoadingView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getSkinName", "", "getSkinType", "showDialog", "Landroid/app/Dialog;", "downloadAlertDialogInfo", "Lcom/ss/android/download/api/model/DownloadAlertDialogInfo;", "showToast", "", "scene", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/download/api/download/DownloadModel;", "message", "icon", "Landroid/graphics/drawable/Drawable;", "duration", "Companion", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class AdHostUIProviderImpl implements IAdHostUIProvider {
    public static final Companion Companion = null;
    public static final String TAG = "AdHostUIProviderImpl";
    private final DefaultDownloadUIFactory defaultUIFactory;
    private final boolean enableRuntime;
    private final boolean enableRuntimeDialog;
    private final boolean enableRuntimeToast;
    private final boolean needDefaultFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdHostUIProviderImpl$Companion;", "", "()V", "TAG", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.ss.android.download.api.runtime.IAdHostUIProvider
    public String getSkinName() {
        if (this.enableRuntime == false) goto L8;
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "getSkinName", "使用Runtime提供的能力获取当前的皮肤名称");
        b r100 = a.f544652a;
        p6.a r101 = (p6.a) a.C7690a.a(p6.a.class, null);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSkinName();
    L8:
        return null;
    }

    @Override // com.ss.android.download.api.runtime.IAdHostUIProvider
    public String getSkinType() {
        if (this.enableRuntime == false) goto L8;
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "getSkinType", "使用Runtime提供的能力获取当前应用的皮肤类型");
        b r100 = a.f544652a;
        p6.a r101 = (p6.a) a.C7690a.a(p6.a.class, null);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSkinType();
    L8:
        return null;
    }

    @Override // com.ss.android.download.api.runtime.IAdHostUIProvider
    public Notification buildNotification(NotificationCompat.Builder r100) {
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "buildNotification", "使用初始化注入的能力,回调创建通知栏的时机");
        return GlobalInfo.getDownloadUIFactory().buildNotification(r100);
    }

    @Override // com.ss.android.download.api.runtime.IAdHostUIProvider
    public View createLoadingView(Context r100) {
        if (this.enableRuntime == false) goto L8;
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "createLoadingView", "使用Runtime提供的能力展示loading组件");
        b r101 = a.f544652a;
        p6.a r102 = (p6.a) a.C7690a.a(p6.a.class, null);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.c();
    L8:
        return null;
    }

    @Override // com.ss.android.download.api.runtime.IAdHostUIProvider
    public Dialog showDialog(final DownloadAlertDialogInfo r100) {
        if (this.enableRuntime == false) goto L11;
        if (this.enableRuntimeDialog == false) goto L11;
        Context r101 = r100.mContext;
        new AdHostUIProviderImpl$showDialog$dialogBuilder$1(r100);
        new AdHostUIProviderImpl$showDialog$dialogBuilder$2(r100);
        new AdHostUIProviderImpl$showDialog$dialogBuilder$3(r100);
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "showDialog", "使用Runtime提供的能力展示弹窗");
        b r102 = a.f544652a;
        p6.a r103 = (p6.a) a.C7690a.a(p6.a.class, null);
        if (r103 != null) goto L9;
        return null;
    L9:
        return r103.a();
    L11:
        if (this.needDefaultFactory == false) goto L13;
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "showDialog", "未使用Runtime能力且初始化未注入UI能力, 使用SDK内置的能力展示AlertDialog");
        return this.defaultUIFactory.showAlertDialog(r100);
    L13:
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "showDialog", "使用初始化注入的UI能力展示AlertDialog");
        return GlobalInfo.getDownloadUIFactory().showAlertDialog(r100);
    }

    public AdHostUIProviderImpl(boolean r100, boolean r101, boolean r102) {
        if (GlobalInfo.getDownloadUIFactory() != null) goto L5;
        boolean r103 = true;
    L6:
        this.needDefaultFactory = r103;
        this.defaultUIFactory = new DefaultDownloadUIFactory();
        this.enableRuntime = r102;
        this.enableRuntimeDialog = r100;
        this.enableRuntimeToast = r101;
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.ss.android.download.api.runtime.IAdHostUIProvider
    public void showToast(int r110, Context r111, DownloadModel r112, String r113, Drawable r114, int r115) {
        if (this.enableRuntime == false) goto L10;
        if (this.enableRuntimeToast == false) goto L10;
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "showToast", "使用Runtime提供的能力展示toast");
        b r100 = a.f544652a;
        p6.a r101 = (p6.a) a.C7690a.a(p6.a.class, null);
        if (r101 == null) goto L14;
        r101.b();
        return;
    L14:
        return;
    L10:
        if (this.needDefaultFactory == false) goto L12;
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "showToast", "未使用Runtime能力且初始化未注入UI能力, 使用SDK内置的能力展示Toast");
        this.defaultUIFactory.showToastWithDuration(r110, r111, r112, r113, r114, r115);
        return;
    L12:
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "showToast", "使用初始化注入的UI能力展示Toast");
        GlobalInfo.getDownloadUIFactory().showToastWithDuration(r110, r111, r112, r113, r114, r115);
    }
}
