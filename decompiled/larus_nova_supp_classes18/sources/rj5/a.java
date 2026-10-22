package rj5;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.view3.MoreFragmentV3;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.more.protocol3.g {
    public final PluginHost c;
    public final C0300a d;
    public boolean e;

    /* JADX INFO: renamed from: rj5.a$a, reason: collision with other inner class name */
    public static final class C0300a implements com.ss.android.lark.appcontext.applifecycle.v {
        public final /* synthetic */ a a;

        public C0300a(a r1) {
            this.a = r1;
        }

        public final void onConfigurationChanged(Configuration r3) {
            boolean r4 = a.k(this.a);
            a r0 = this.a;
            if (r0.e == r4) goto L6;
            r0.f();
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements com.bytedance.ee.bear.more.protocol3.m {
        public final /* synthetic */ a a;

        @Override // com.bytedance.ee.bear.more.protocol3.m
        public final boolean isVisible() {
            a r0 = this.a;
            r0.e = a.k(r0);
            return this.a.e;
        }

        public c(a r1) {
            this.a = r1;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r21) {
            tt5.a.h("BrowserViewItemV3", SendEventContainerMethodParamModel.EventKinds.onClick);
            r4 r1 = this.a.c.getHostAbilityOrNull(r4.class);
            if (r1 == null) goto L5;
            r1.startBrowserView();
        L5:
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).b(CommonMoreItemId.BROWSER_VIEW.getId());
            a r2 = this.a;
            sj5.b r4 = r2.getHost();
            if (r4 == null) goto L10;
            MoreFragmentV3 r5 = r4.getHostFragment();
            if (r5 == null) goto L10;
            Bundle r6 = r5.getArguments();
        L11:
            oj5.c r3 = r2.c();
            if (r3 != null) goto L14;
        L16:
            sj5.b r7 = this.a.getHost();
            if (r7 == null) goto L20;
            r7.a();
            return;
        L20:
            return;
        L14:
            if ((r3 instanceof oj5.a) == false) goto L16;
            oj5.a r8 = (oj5.a) r3;
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).c(new com.bytedance.ee.bear.more.i(r6, r8.c, r8.getType(), false, r8.b(), "browser_view", "none", "", "", r3 instanceof oj5.f, r8.k, r8.r, r8.isOwner(), r8.L()));
        L10:
            r6 = null;
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        return h(com.bytedance.ee.bear.more.protocol3.f.y.c, new com.bytedance.ee.bear.more.protocol3.e.f(false, false, false), CollectionsKt.listOf(new c(this)), CollectionsKt.listOf(new com.bytedance.ee.bear.more.protocol3.checker.d()), new d(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b
    public final void release() {
        Object r0 = com.ss.android.lark.appcontext.applifecycle.q.c;
        com.ss.android.lark.appcontext.applifecycle.q.a.a.b(this.d);
    }

    public a(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
        C0300a r3 = new C0300a(this);
        Object r0 = com.ss.android.lark.appcontext.applifecycle.q.c;
        com.ss.android.lark.appcontext.applifecycle.q.a.a.a(r3);
        this.d = r3;
    }

    public static final boolean k(a r2) {
        if (r2.a == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        sj5.b r3 = r2.getHost();
        if (r3 == null) goto L17;
        MoreFragmentV3 r4 = r3.getHostFragment();
        if (r4 == null) goto L18;
        Context r5 = r4.getContext();
        if (r5 != null) goto L16;
        return false;
    L16:
        return ku5.c.k(r5);
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    L5:
        r0 = false;
        goto L6
    }
}
