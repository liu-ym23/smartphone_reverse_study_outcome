package com.bytedance.ee.bear.sheet.screenshotobserver;

import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001c\u0010\u0013\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/sheet/screenshotobserver/ScreenshotObserverPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "screenshotObserver", "Lcom/bytedance/ee/bear/sheet/screenshotobserver/ScreenshotObserver;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "addScreenshotListener", "listener", "Lcom/bytedance/ee/bear/sheet/screenshotobserver/IScreenshotObserver$OnScreenshotListener;", "removeScreenshotListener", "onDetachFromUIContainer", "onDetachFromHost", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenshotObserverPlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final String TAG = "ScreenshotObserverPlugin";
    private final LifecycleEventObserver lifecycleObserver;
    private ScreenshotObserver screenshotObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements LifecycleEventObserver {
        public final /* synthetic */ ScreenshotObserverPlugin a;

        public b(ScreenshotObserverPlugin r1) {
            this.a = r1;
        }

        public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
        L14:
            e = move-exception;
            tt5.a.e(ScreenshotObserverPlugin.TAG, "startObserve or stopObserve error", e, false);
            return;
        L4:
            if (Lifecycle.Event.ON_RESUME != r4) goto L9;
            ScreenshotObserver r5 = ScreenshotObserverPlugin.access$getScreenshotObserver$p(this.a);     // Catch: Exception -> L14
            if (r5 == null) goto L17;
            r5.d();     // Catch: Exception -> L14
        L17:
            return;
        L9:
            if (Lifecycle.Event.ON_PAUSE != r4) goto L17;
            ScreenshotObserver r6 = ScreenshotObserverPlugin.access$getScreenshotObserver$p(this.a);     // Catch: Exception -> L14
            if (r6 == null) goto L17;
            r6.e();     // Catch: Exception -> L14
            goto L17
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ScreenshotObserverPlugin() {
        this.lifecycleObserver = new b(this);
    }

    public static final /* synthetic */ ScreenshotObserver access$getScreenshotObserver$p(ScreenshotObserverPlugin r0) {
        return r0.screenshotObserver;
    }

    public final void addScreenshotListener(gn5.a r3) {
        if (r3 == null) goto L9;
        ScreenshotObserver r0 = this.screenshotObserver;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (((CopyOnWriteArrayList) r0.a).contains(r3) == true) goto L11;
        ((CopyOnWriteArrayList) r0.a).add(r3);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void onAttachToHost(DocumentPluginHost r15) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r15);
        Looper r0 = null;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L5;
        boolean r16 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new UniBaseEntity(getDocViewModel().getToken(), sbb.e.d(getDocViewModel().getDocumentTypeValue()), BizDomain.FileBizDomainCCM, getDocViewModel().getCreatorTenantId(), getDocViewModel().getOwnerUserId(), null, null, null, null, 480, null), "EXPORT"), null).getAllow();
    L6:
        tt5.a.h(TAG, "adminCanExport:" + r16);
        if (r16 == false) goto L13;
        ScreenshotObserver r17 = new ScreenshotObserver();
        this.screenshotObserver = r17;
        FragmentActivity r1 = getActivity();
        List r2 = c.a.a.e("screenshot_keywords", String.class, new ArrayList());
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "keywords");
        tt5.a.b("ScreenshotObserver", "onCreate");
        r17.m = new WeakReference(r1);
        r17.j = new gn5.c(r1, r2);
        r17.h = r1.getContentResolver();
        PthreadHandlerThreadV2 r3 = new PthreadHandlerThreadV2("Screenshot_Observer");
        r17.e = r3;
        ThreadMethodProxy.start(r3);
        PthreadHandlerThreadV2 r4 = r17.e;
        if (r4 == null) goto L11;
        r0 = r4.getLooper();
    L11:
        Intrinsics.checkNotNull(r0);
        r17.f = new Handler(r0);
        r17.c = new ScreenshotObserver.b(r17, MediaStore.Images.Media.INTERNAL_CONTENT_URI, r17.f);
        r17.d = new ScreenshotObserver.b(r17, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r17.f);
        r17.g = StoragePermissionUtils.d(r1, 2);
        r17.i = ScreenshotObserver.LifecycleState.Created;
        return;
    L13:
        return;
    L5:
        r16 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, getDocViewModel().getDocumentTypeValue(), getDocViewModel().getToken()).a;
        goto L6
    }

    public void onDetachFromHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r3);
        ScreenshotObserver r4 = this.screenshotObserver;
        if (r4 == null) goto L8;
        tt5.a.b("ScreenshotObserver", "onDestroy");
        r4.i = ScreenshotObserver.LifecycleState.Destroyed;
        j.e(r4.n);
        ((CopyOnWriteArrayList) r4.a).clear();
        PthreadHandlerThreadV2 r5 = r4.e;
        if (r5 == null) goto L9;
        r5.quit();
        return;
    L9:
        return;
    }

    public final void removeScreenshotListener(gn5.a r3) {
        if (r3 == null) goto L7;
        ScreenshotObserver r0 = this.screenshotObserver;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((CopyOnWriteArrayList) r0.a).remove(r3);
        return;
    L8:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        if (r1 == null) goto L10;
        WebFragment r3 = r1.c();
        if (r3 == null) goto L11;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L12;
        r4.addObserver(this.lifecycleObserver);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
        if (r1 == null) goto L9;
        WebFragment r3 = r1.c();
        if (r3 == null) goto L9;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L9;
        r4.removeObserver(this.lifecycleObserver);
    L9:
        ScreenshotObserver r5 = this.screenshotObserver;
        if (r5 == null) goto L13;
        r5.e();
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
