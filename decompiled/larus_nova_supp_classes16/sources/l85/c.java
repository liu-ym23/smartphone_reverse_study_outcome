package l85;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.drive.module.nativepreview.component.sandwich.DriveNativeRenderComponent;
import com.bytedance.ee.lark.component.core.settings.NativeComponentSdkConfig;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements d {
    public ur5.a a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // l85.d
    public final void a(DocumentPluginHost r2, t r3) {
        if (r3 == null) goto L12;
        View r4 = r3.getContentView();
        if (r4 == null) goto L13;
        if (r2 == null) goto L9;
        WebFragment r5 = r2.c();
        if (r5 == null) goto L9;
        FragmentManager r6 = r5.getChildFragmentManager();
    L10:
        r4.setTag(2131370303, r6);
        return;
    L9:
        r6 = null;
        goto L10
    L13:
        return;
    }

    @Override // l85.d
    public final void b(FragmentActivity r9, pxb.a r10) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r10, "webView");
        tr5.b r0 = tr5.b.a.a;
        r0.getClass();
        Log.i("NativeRenderManager", "init mixrender ");
        r10.b(new wr5.a());
        txb.a r3 = null;
        if (NativeComponentSdkConfig.isLegacySdkInitCheck() == false) goto L12;
        Log.i("NativeRenderManager", "init enable init check");
        txb.b r1 = r10.getServiceManager();
        bs5.a r4 = tr5.b.a(r10);
        if (r1 == null) goto L12;
        if (r4 == null) goto L12;
        if (r4.n() == null) goto L12;
        if (r4.n().d == null) goto L12;
        as5.b r2 = r4.n();
        r2.d.a = r9;
    L14:
        if (NativeComponentSdkConfig.isLegacySdkInitCheck() == false) goto L20;
        if (r2 != null) goto L19;
        Log.i("NativeRenderManager", "init enable init check, cacheProvider is null");
        ur5.a r5 = new ur5.a(r9, r10, new zr5.b());
        as5.b r6 = new as5.b(r5);
        bs5.a r7 = tr5.b.a(r10);
        if (r7 == null) goto L21;
        r7.setNativeComponentProvider(r6);
    L21:
        as5.b r8 = r6;
        ur5.a r11 = r5;
        r2 = r8;
    L22:
        txb.b r12 = r10.getServiceManager();
        if (r12 == null) goto L25;
        r3 = (txb.a) r12.getService(txb.a.class);
    L25:
        boolean r13 = false;
        if (r3 == null) goto L28;
        r0.b = r3.d();
    L29:
        vr5.a r14 = new vr5.a(r10, r2);
        r14.a("insertNativeComponent");
        r14.a("updateNativeComponentAttribute");
        r14.a("deleteNativeComponent");
        r14.a("nativeComponentDispatchAction");
        Log.i("NativeRenderManager", "init:  RegisterNativeComponent nativeComponentContext " + r11.hashCode() + " webView:" + r10.hashCode());
        tt5.a.h("DriveSandwichRenderPlatform", "registerNativeRender() called with: activity = " + r9 + ", WebView = " + r10 + " nativeComponentContext:" + r11);
        this.a = r11;
        as5.c r16 = r0.a;
        r16.getClass();
        StringBuilder r17 = new StringBuilder("register component on webView, viewType = drive_file_block component:");
        r17.append(DriveNativeRenderComponent.class.getCanonicalName());
        Log.i("NativeComponentTypeProviderImpl", r17.toString());
        int r18 = r10.hashCode();
        Iterator r19 = ((CopyOnWriteArrayList) r16.b).iterator();
    L31:
        if (r19.hasNext() == false) goto L35;
        as5.c.a r20 = (as5.c.a) r19.next();
        if (r20.a != r18) goto L31;
        r20.a(DriveNativeRenderComponent.class);
        r13 = true;
    L35:
        if (r13 == true) goto L37;
        as5.c.a r21 = new as5.c.a();
        r21.a = r18;
        r21.a(DriveNativeRenderComponent.class);
        ((CopyOnWriteArrayList) r16.b).add(r21);
    L37:
        zr5.b r22 = r11.c;
        if (r22 == null) goto L40;
        j85.a r23 = new j85.a();
        Intrinsics.checkNotNullParameter(r23, "monitor");
        ((ArrayList) r22.a).add(r23);
    L40:
        txb.a r24 = ms5.a.a(r10);
        if (r24 == null) goto L47;
        r24.l(new j85.b());
        return;
    L47:
        return;
    L28:
        r0.b = false;
        Log.e("NativeRenderManager", "openMixRender failed, renderInWebViewService is null");
        goto L29
    L19:
        Log.i("NativeRenderManager", "init enable init check, cacheProvider not null");
        r11 = r2.d;
        goto L22
    L20:
        r5 = new ur5.a(r9, r10, new zr5.b());
        r6 = new as5.b(r5);
    L12:
        r2 = null;
        goto L14
    }

    @Override // l85.d
    public final void c(DocumentPluginHost r2, t r3) {
        if (r3 == null) goto L7;
        View r4 = r3.getContentView();
        if (r4 == null) goto L8;
        r4.setTag(2131370303, null);
        return;
    L8:
        return;
    }

    @Override // l85.d
    public final void d(FragmentActivity r7, pxb.a r8) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "webView");
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.native_render_clear_context");
        tt5.a.h("DriveSandwichRenderPlatform", "unRegisterNativeRender() called with: activity = " + r7 + ", WebView = " + r8 + " mNativeComponentContext:" + this.a + " enableClearContext:" + r0);
        tr5.b r9 = tr5.b.a.a;
        ur5.a r1 = this.a;
        r9.getClass();
        r8.c();
        r8.getBridge().b("insertNativeComponent");
        r8.getBridge().b("updateNativeComponentAttribute");
        r8.getBridge().b("deleteNativeComponent");
        r8.getBridge().b("nativeComponentDispatchAction");
        if (r0 == true) goto L5;
    L18:
        this.a = null;
        return;
    L5:
        if (NativeComponentSdkConfig.isLegacySdkInitCheck() == false) goto L16;
        Log.i("NativeRenderManager", "unRegisterNativeComponent init enable init check");
        txb.b r2 = r8.getServiceManager();
        bs5.a r4 = tr5.b.a(r8);
        if (r2 == null) goto L16;
        if (r4 == null) goto L16;
        if (r4.n() == null) goto L16;
        if (r4.n().d == null) goto L16;
        ur5.a r3 = r4.n().d;
        if (r3 == null) goto L16;
        Log.i("NativeRenderManager", "unRegisterNativeComponent: nativeComponentContext clear Context nativeComponentContext:" + r3.hashCode() + " webView:" + r8.hashCode());
        r3.a = null;
    L16:
        if (r1 == null) goto L18;
        r1.a = null;
        Log.i("NativeRenderManager", "unRegisterNativeComponent: componentContext clear, nativeComponentContext：" + r1.hashCode() + " webView:" + r8.hashCode());
        goto L18
    }
}
