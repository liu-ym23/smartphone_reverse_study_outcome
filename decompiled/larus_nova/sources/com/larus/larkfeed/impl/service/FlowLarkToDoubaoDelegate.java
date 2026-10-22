package com.larus.larkfeed.impl.service;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.larkforward.IFlowLarkToDoubaoService;
import com.larus.bmhome.chat.larkforward.d0;
import com.larus.bmhome.chat.larkforward.e0;
import com.larus.bmhome.chat.larkforward.p;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.exp.o;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class FlowLarkToDoubaoDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f355505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<b> f355506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f355507c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f355508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f355509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f355510c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f355508a == r101.f355508a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f355509b, r101.f355509b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f355510c, r101.f355510c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f355508a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f355509b.hashCode()) * 31;
            Bundle r102 = this.f355510c;
            if (r102 != null) goto L5;
            int r103 = 0;
        L7:
            return r101 + r103;
        L5:
            r103 = r102.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingForwardResult(requestToken=" + this.f355508a + ", secUserId=" + this.f355509b + ", chatBundle=" + this.f355510c + ')';
        }

        public b(long r100, String r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r101, "secUserId");
            this.f355508a = r100;
            this.f355509b = r101;
            this.f355510c = r102;
        }
    }

    static {
    }

    public final FragmentActivity a() {
        f09.a r100 = AppHost.f326268a.a();
        Activity r101 = r100.getCurrentActivity();
        Object r102 = null;
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r103 = (FragmentActivity) r101;
    L6:
        if (r103 != null) goto L8;
    L13:
        if (r101 == null) goto L20;
        Activity r104 = r100.a(r101, new g(this));
        if (r104 == null) goto L20;
        if ((r104 instanceof FragmentActivity) == true) goto L19;
        return null;
    L19:
        return (FragmentActivity) r104;
    L20:
        List r105 = CollectionsKt.asReversed(r100.m());
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        Object r108 = r107.next();
        if ((r108 instanceof FragmentActivity) == false) goto L22;
        r106.add(r108);
        goto L22
    L26:
        Iterator r109 = r106.iterator();
    L28:
        if (r109.hasNext() == false) goto L32;
        Object r110 = r109.next();
        if (d((FragmentActivity) r110) == false) goto L28;
    L33:
        FragmentActivity r111 = (FragmentActivity) r110;
        if (r111 == null) goto L36;
        return r111;
    L36:
        List r112 = CollectionsKt.asReversed(r100.g());
        ArrayList r113 = new ArrayList();
        Iterator r114 = r112.iterator();
    L38:
        if (r114.hasNext() == false) goto L42;
        Object r115 = r114.next();
        if ((r115 instanceof FragmentActivity) == false) goto L38;
        r113.add(r115);
        goto L38
    L42:
        Iterator r116 = r113.iterator();
    L44:
        if (r116.hasNext() == false) goto L49;
        Object r117 = r116.next();
        if (d((FragmentActivity) r117) == false) goto L44;
        r102 = r117;
    L49:
        return (FragmentActivity) r102;
    L32:
        r110 = null;
        goto L33
    L8:
        if (d(r103) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L13;
        return r103;
    L5:
        r103 = null;
        goto L6
    }

    public final mpc.a c() {
        IFlowLarkToDoubaoService r100 = (IFlowLarkToDoubaoService) ServiceManager.get().getService(IFlowLarkToDoubaoService.class);
        if (r100 == null) goto L9;
        d0 r101 = r100.c(AppHost.f326268a.getApplication().getString(R.string.app_string_name), (Drawable) this.f355507c.getValue());
        if (r101 == null) goto L9;
        mpc.a r102 = new mpc.a();
        String r103 = r101.f303392a;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f514765a = r103;
        String r104 = r101.f303393b;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f514766b = r104;
        r102.f514767c = r101.f303394c;
        return r102;
    L9:
        FLogger.f375446a.w("FlowLarkToDoubaoDelegate", "getDoubaoForwardItem failed: FlowSDK service unavailable");
        return new mpc.a();
    }

    public final void e() {
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.b() == true) goto L6;
        FLogger.f375446a.w("FlowLarkToDoubaoDelegate", "openDoubaoMainBot skipped: lark social disabled");
        return;
    L6:
        IFlowLarkToDoubaoService r100 = (IFlowLarkToDoubaoService) ServiceManager.get().getService(IFlowLarkToDoubaoService.class);
        if (r100 != null) goto L11;
        FLogger.f375446a.e("FlowLarkToDoubaoDelegate", "openDoubaoMainBot failed: FlowSDK service unavailable");
        return;
    L11:
        if (o.a() == true) goto L20;
        this.f355506b.set(null);
        AppHost.Companion r101 = AppHost.f326268a;
        Activity r102 = r101.a().getCurrentActivity();
        if (r102 == null) goto L17;
        final boolean r103 = true;
        if (Intrinsics.areEqual(r102.getClass().getName(), "com.suite.lark.platform.feature.forward.doubao.ForwardDoubaoActivity") != true) goto L17;
    L18:
        r100.a(r101.getApplication().getString(R.string.app_string_name), new e(r103, this));
        return;
    L17:
        r103 = false;
        goto L18
    L20:
        final long r104 = this.f355505a.get();
        final String r105 = AccountService.f365697a.getSecUserId();
        b r106 = this.f355506b.getAndSet(null);
        if (r106 != null) goto L23;
        r100.a(AppHost.f326268a.getApplication().getString(R.string.app_string_name), new f(this, r105, r104));
        return;
    L23:
        if (StringsKt.isBlank(r106.f355509b) == false) goto L25;
    L35:
        FLogger.f375446a.w("FlowLarkToDoubaoDelegate", "openDoubaoMainBot skipped: account or request changed after forward");
        return;
    L25:
        if (Intrinsics.areEqual(r106.f355509b, r105) == false) goto L35;
        if (r106.f355508a != r104) goto L35;
        Bundle r107 = r106.f355510c;
        if (r107 != null) goto L33;
        FLogger.f375446a.e("FlowLarkToDoubaoDelegate", "openDoubaoMainBot failed: forward result bundle unavailable");
        return;
    L33:
        FLogger.f375446a.i("FlowLarkToDoubaoDelegate", "openDoubaoMainBot with forward result conversation");
        f(r107, r106.f355509b, r106.f355508a);
    }

    public FlowLarkToDoubaoDelegate() {
        this.f355505a = new AtomicLong(0);
        this.f355506b = new AtomicReference(null);
        this.f355507c = LazyKt.lazy(LazyThreadSafetyMode.NONE, new d(this));
    }

    public static boolean d(Activity r100) {
        if (r100.isFinishing() == false) goto L5;
    L9:
        return false;
    L5:
        if (r100.isDestroyed() == true) goto L9;
        if (Intrinsics.areEqual(r100.getClass().getName(), "com.suite.lark.platform.feature.forward.doubao.ForwardDoubaoActivity") == true) goto L9;
        return true;
    }

    public final void b(mpc.c r110, ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1.a r210) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        IFlowLarkToDoubaoService r100 = (IFlowLarkToDoubaoService) ServiceManager.get().getService(IFlowLarkToDoubaoService.class);
        if (r100 != null) goto L6;
        FLogger.f375446a.e("FlowLarkToDoubaoDelegate", "forwardLarkMessagesToDoubao failed: FlowSDK service unavailable");
        r210.onFailure(-7, AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Friend_SendFailed_Error));
        return;
    L6:
        List<String> r111 = r110.f514768a;
        String r112 = r110.f514769b;
        String r113 = r110.f514770c;
        boolean r114 = r110.f514771d;
        String r115 = r110.f514772e;
        boolean r116 = r110.f514773f;
        mpc.d r101 = r110.f514774g;
        p r102 = new p(r111, r112, r113, r114, r115, r116, new e0(r101.f514776a, r101.f514777b, r101.f514778c, r101.f514779d), r110.f514775h);
        if (o.a() == true) goto L10;
        this.f355506b.set(null);
        this.f355505a.incrementAndGet();
        i r103 = new i(r210);
        LarkSocialExp.f365340a.getClass();
        r100.b(r102, r103, LarkSocialExp.b(), AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Friend_SendFailed_Error));
        return;
    L10:
        this.f355506b.set(null);
        j r104 = new j(this, this.f355505a.incrementAndGet(), r210, AccountService.f365697a.getSecUserId());
        LarkSocialExp.f365340a.getClass();
        r100.b(r102, r104, LarkSocialExp.b(), AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Friend_SendFailed_Error));
    }

    public final void f(Bundle r110, String r111, long r112) {
        FragmentActivity r100 = a();
        if (r100 != null) goto L6;
        FLogger.f375446a.w("FlowLarkToDoubaoDelegate", "openDoubaoMainBot failed: no stable host activity");
        return;
    L6:
        LifecycleOwnerKt.getLifecycleScope(r100).launchWhenResumed(new FlowLarkToDoubaoDelegate$showMainBotBundleWhenHostResumed$1(r111, this, r112, r100, r110, null));
    }
}
