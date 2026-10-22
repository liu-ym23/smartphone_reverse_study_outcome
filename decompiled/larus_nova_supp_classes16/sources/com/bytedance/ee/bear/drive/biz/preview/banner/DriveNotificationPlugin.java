package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveFullScreenVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.util.ui.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/banner/DriveNotificationPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "Lcom/bytedance/ee/bear/notification/INotification$INotificationCallback;", "<init>", "()V", "iNotificationView", "Lcom/bytedance/ee/bear/notification/INotification$INotificationView;", "notificationView", "Landroid/view/View;", "tipsRoot", "Landroid/view/ViewGroup;", "driveNotificationVM", "Lcom/bytedance/ee/bear/drive/biz/preview/banner/DriveNotificationVM;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "reportNotificationClose", "nid", "", "reportNotificationOpen", "closeNotificationInternal", "showNotificationInternal", "notification", "onDetachPreview", "onDetachFromHost", "showNotification", "products", "", "closeNotification", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveNotificationPlugin extends AbsDrivePreviewPlugin implements com.bytedance.ee.bear.notification.a.a {
    public static final a Companion = null;
    public static final String TAG = "DriveNotificationPlugin";
    private DriveNotificationVM driveNotificationVM;
    private com.bytedance.ee.bear.notification.a.b iNotificationView;
    private View notificationView;
    private ViewGroup tipsRoot;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ DriveNotificationPlugin b;

        public b(String r1, DriveNotificationPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h(DriveNotificationPlugin.TAG, "closeNotification() nid=" + this.a);     // Catch: Throwable -> L7
            DriveNotificationPlugin r0 = this.b;     // Catch: Throwable -> L7
            String r1 = this.a;     // Catch: Throwable -> L7
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            DriveNotificationPlugin.access$closeNotificationInternal(r0, r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class c implements com.bytedance.ee.bear.notification.a.b.a {
        public final /* synthetic */ DriveNotificationPlugin a;

        public c(DriveNotificationPlugin r1) {
            this.a = r1;
        }

        public final void a(String r3) {
            com.bytedance.ee.bear.notification.a r4 = (com.bytedance.ee.bear.notification.a) org.koin.java.a.c(com.bytedance.ee.bear.notification.a.class, null, null, 6);
            com.bytedance.ee.bear.notification.a.b r0 = DriveNotificationPlugin.access$getINotificationView$p(this.a);
            String r1 = "";
            if (r0 == null) goto L6;
            String r2 = r0.g();
            if (r2 == null) goto L6;
        L7:
            r4.a(r2);
            DriveNotificationPlugin r5 = this.a;
            com.bytedance.ee.bear.notification.a.b r6 = DriveNotificationPlugin.access$getINotificationView$p(r5);
            if (r6 == null) goto L13;
            String r7 = r6.g();
            if (r7 == null) goto L13;
            r1 = r7;
        L13:
            DriveNotificationPlugin.access$reportNotificationClose(r5, r1);
            return;
        L6:
            r2 = "";
            goto L7
        }
    }

    public static final class d implements com.bytedance.ee.bear.notification.a.b.b {
        public final /* synthetic */ DriveNotificationPlugin a;

        public d(DriveNotificationPlugin r1) {
            this.a = r1;
        }

        public final void a(String r4) {
            h r0 = (h) org.koin.java.a.c(h.class, null, null, 6);
            String r1 = "";
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            r0.u5(ow4.a.a(r4, "tab_notice"));
            DriveNotificationPlugin r5 = this.a;
            com.bytedance.ee.bear.notification.a.b r2 = DriveNotificationPlugin.access$getINotificationView$p(r5);
            if (r2 == null) goto L11;
            String r3 = r2.g();
            if (r3 == null) goto L11;
            r1 = r3;
        L11:
            DriveNotificationPlugin.access$reportNotificationOpen(r5, r1);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DriveNotificationPlugin a;

        public e(DriveNotificationPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            com.bytedance.ee.bear.drive.biz.preview.screen.a r4 = (com.bytedance.ee.bear.drive.biz.preview.screen.a) r3;
            if (DriveNotificationPlugin.access$getNotificationView$p(this.a) != null) goto L5;
            return;
        L5:
            if (DriveNotificationPlugin.access$getINotificationView$p(this.a) != null) goto L7;
            return;
        L7:
            if (DriveNotificationPlugin.access$getTipsRoot$p(this.a) == null) goto L36;
            StringBuilder r0 = new StringBuilder("liveFullScreen it=");
            r0.append(r4);
            r0.append(", vm height=");
            DriveNotificationVM r1 = DriveNotificationPlugin.access$getDriveNotificationVM$p(this.a);
            if (r1 == null) goto L14;
            MutableLiveData<Integer> r2 = r1.getShowState();
            if (r2 == null) goto L14;
            Integer r5 = (Integer) r2.getValue();
        L15:
            r0.append(r5);
            tt5.a.h(DriveNotificationPlugin.TAG, r0.toString());
            if (r4.a == true) goto L25;
            DriveNotificationVM r6 = DriveNotificationPlugin.access$getDriveNotificationVM$p(this.a);
            if (r6 == null) goto L25;
            MutableLiveData<Integer> r7 = r6.getShowState();
            if (r7 == null) goto L25;
            Integer r8 = (Integer) r7.getValue();
            if (r8 == null) goto L25;
            int r9 = r8.intValue();
        L26:
            LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, r9);
            View r11 = DriveNotificationPlugin.access$getNotificationView$p(this.a);
            if (r11 == null) goto L29;
            r11.setLayoutParams(r10);
        L29:
            View r12 = DriveNotificationPlugin.access$getNotificationView$p(this.a);
            if (r12 == null) goto L35;
            r12.requestLayout();
            return;
        L35:
            return;
        L25:
            r9 = 0;
        L14:
            r5 = null;
            goto L15
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ DriveNotificationPlugin a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public f(DriveNotificationPlugin r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DriveNotificationPlugin r0 = this.a;     // Catch: Throwable -> L11
            String r1 = this.b;     // Catch: Throwable -> L11
            String r2 = "";
            if (r1 != null) goto L5;
            r1 = "";
        L5:
            String r3 = this.c;     // Catch: Throwable -> L11
            if (r3 == null) goto L9;
            r2 = r3;
        L9:
            DriveNotificationPlugin.access$showNotificationInternal(r0, r1, r2);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ DriveNotificationPlugin a;

        public g(DriveNotificationPlugin r1) {
            this.a = r1;
        }

        public final void a() {
            StringBuilder r0 = new StringBuilder("showNotificationInternal() height=");
            View r1 = DriveNotificationPlugin.access$getNotificationView$p(this.a);
            Integer r2 = null;
            if (r1 == null) goto L5;
            Integer r3 = Integer.valueOf(r1.getHeight());
        L6:
            r0.append(r3);
            tt5.a.h(DriveNotificationPlugin.TAG, r0.toString());
            DriveNotificationVM r4 = DriveNotificationPlugin.access$getDriveNotificationVM$p(this.a);
            if (r4 == null) goto L15;
            MutableLiveData<Integer> r5 = r4.getShowState();
            if (r5 == null) goto L16;
            View r6 = DriveNotificationPlugin.access$getNotificationView$p(this.a);
            if (r6 == null) goto L13;
            r2 = Integer.valueOf(r6.getHeight());
        L13:
            r5.setValue(r2);
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        tt5.a.h(TAG, "onAttachPreview");
        this.tipsRoot = (ViewGroup) findViewById(2131370319);
        DriveNotificationVM r0 = this.driveNotificationVM;
        View r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.ee.bear.notification.a.b r2 = r0.getINotificationView();
    L6:
        this.iNotificationView = r2;
        if (r2 == null) goto L9;
        r1 = r2.e(getActivity());
    L9:
        this.notificationView = r1;
        com.bytedance.ee.bear.notification.a.b r3 = this.iNotificationView;
        if (r3 == null) goto L12;
        r3.f(new c(this));
    L12:
        com.bytedance.ee.bear.notification.a.b r4 = this.iNotificationView;
        if (r4 == null) goto L16;
        r4.d(new d(this));
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        tt5.a.h(TAG, "onDetachPreview");
    }

    public DriveNotificationPlugin() {
    }

    public static final /* synthetic */ DriveNotificationVM access$getDriveNotificationVM$p(DriveNotificationPlugin r0) {
        return r0.driveNotificationVM;
    }

    public static final /* synthetic */ com.bytedance.ee.bear.notification.a.b access$getINotificationView$p(DriveNotificationPlugin r0) {
        return r0.iNotificationView;
    }

    public static final /* synthetic */ View access$getNotificationView$p(DriveNotificationPlugin r0) {
        return r0.notificationView;
    }

    public static final /* synthetic */ ViewGroup access$getTipsRoot$p(DriveNotificationPlugin r0) {
        return r0.tipsRoot;
    }

    private final void closeNotificationInternal(String r3) {
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder("closeNotificationInternal nid=");
        r0.append(r3);
        r0.append(" notificationId=");
        com.bytedance.ee.bear.notification.a.b r4 = this.iNotificationView;
        if (r4 == null) goto L8;
        String r5 = r4.g();
    L9:
        r0.append(r5);
        tt5.a.h(TAG, r0.toString());
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-1, -2);
        View r1 = this.notificationView;
        if (r1 == null) goto L12;
        r1.setLayoutParams(r6);
    L12:
        com.bytedance.ee.bear.notification.a.b r7 = this.iNotificationView;
        if (r7 == null) goto L15;
        r7.a();
    L15:
        DriveNotificationVM r8 = this.driveNotificationVM;
        if (r8 == null) goto L21;
        MutableLiveData<Integer> r9 = r8.getShowState();
        if (r9 == null) goto L22;
        r9.postValue(0);
        return;
    L22:
        return;
    L21:
        return;
    L8:
        r5 = null;
        goto L9
    }

    private final void reportNotificationClose(String r5) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap r2 = new HashMap(r0.m("docCommonParams"));
        r2.put("location", "android_lark");
        r2.put("announcement_id", r5);
        r2.put("click", "close");
        r2.put("target", "none");
        tt5.a.b(TAG, "reportNotificationClose, params = " + r2);
        r0.n("ccm_announcement_click", r2);
    }

    private final void reportNotificationOpen(String r5) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        HashMap r2 = new HashMap(r0.m("docCommonParams"));
        r2.put("location", "android_lark");
        r2.put("announcement_id", r5);
        r2.put("click", "open");
        r2.put("target", "none");
        tt5.a.b(TAG, "reportNotificationOpen, params = " + r2);
        r0.n("ccm_announcement_click", r2);
    }

    public void closeNotification(String r2) {
        m.a(new b(r2, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        DriveNotificationVM r4 = (DriveNotificationVM) new ViewModelProvider(getActivity()).get(DriveNotificationVM.class);
        this.driveNotificationVM = r4;
        if (r4 == null) goto L5;
        r4.initIfNeed();
    L5:
        ((DriveFullScreenVM) new ViewModelProvider(getActivity()).get(DriveFullScreenVM.class)).getLiveFullScreen().observe(getLifecycleOwner(), new e(this));
        ((com.bytedance.ee.bear.notification.a) org.koin.java.a.c(com.bytedance.ee.bear.notification.a.class, null, null, 6)).b(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onDetachFromHost(r3);
        ((com.bytedance.ee.bear.notification.a) org.koin.java.a.c(com.bytedance.ee.bear.notification.a.class, null, null, 6)).c(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$closeNotificationInternal(DriveNotificationPlugin r0, String r1) {
        r0.closeNotificationInternal(r1);
    }

    public static final /* synthetic */ void access$reportNotificationClose(DriveNotificationPlugin r0, String r1) {
        r0.reportNotificationClose(r1);
    }

    public static final /* synthetic */ void access$reportNotificationOpen(DriveNotificationPlugin r0, String r1) {
        r0.reportNotificationOpen(r1);
    }

    private final void showNotificationInternal(String r5, String r6) {
        if (isUIContainerDetached() == false) goto L5;
        return;
    L5:
        if (this.iNotificationView == null) goto L30;
        View r0 = this.notificationView;
        if (r0 == null) goto L10;
        ViewParent r1 = r0.getParent();
    L12:
        if (r1 != null) goto L16;
        tt5.a.h(TAG, "showNotificationInternal()  addView");
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -2);
        ViewGroup r3 = this.tipsRoot;
        if (r3 == null) goto L16;
        r3.addView(this.notificationView, r2);
    L16:
        com.bytedance.ee.bear.notification.a.b r4 = this.iNotificationView;
        if (r4 == null) goto L19;
        r4.c(r5, r6);
    L19:
        View r7 = this.notificationView;
        if (r7 == null) goto L22;
        r7.post(new g(this));
    L22:
        StringBuilder r8 = new StringBuilder("showNotificationInternal()  done visibility=");
        View r9 = this.notificationView;
        boolean r10 = false;
        if (r9 != null) goto L25;
    L27:
        r8.append(r10);
        tt5.a.h(TAG, r8.toString());
        return;
    L25:
        if (r9.getVisibility() != 0) goto L27;
        r10 = true;
        goto L27
    L10:
        r1 = null;
        goto L12
    }

    public static final /* synthetic */ void access$showNotificationInternal(DriveNotificationPlugin r0, String r1, String r2) {
        r0.showNotificationInternal(r1, r2);
    }

    public void showNotification(String r6, List<String> r7, String r8) {
        tt5.a.h(TAG, "showNotification() nid=" + r6);
        boolean r0 = true;
        if (r7 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L15;
        if (r7 != null) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == true) goto L15;
        return;
    L11:
        if (r7.contains(FileInfoPuller.CALLER_WIKI) != true) goto L13;
    L15:
        tt5.a.h(TAG, "showNotification() nid=" + r6 + " start show");
        m.a(new f(this, r6, r8));
        return;
    L5:
        if (r7.contains("file") != true) goto L7;
        r4 = true;
        goto L8
    }
}
