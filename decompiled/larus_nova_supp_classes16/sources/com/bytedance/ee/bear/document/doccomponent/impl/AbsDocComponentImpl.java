package com.bytedance.ee.bear.document.doccomponent.impl;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.route.h;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qz4.c;
import s05.e;
import sa5.d;
import sa5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u000245B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010!\u001a\u00020\"H\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010#\u001a\u00020\bH\u0004J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0018H\u0016J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\"H\u0017J\b\u0010+\u001a\u00020\"H\u0017J\b\u0010,\u001a\u00020\"H\u0017J\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\b\u0010/\u001a\u00020\"H\u0017J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020'H\u0003J\b\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020'H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/document/doccomponent/impl/AbsDocComponentImpl;", "Lcom/bytedance/ee/bear/doccomponent/api/DocComponentApi;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/ss/android/lark/edit/keyboard/utils/KeyboardEventInterceptor;", "fragment", "Landroidx/fragment/app/Fragment;", "documentToken", "", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "host", "Lcom/bytedance/ee/bear/doccomponent/api/DocComponentHost;", "getHost", "()Lcom/bytedance/ee/bear/doccomponent/api/DocComponentHost;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getDocumentToken", "()Ljava/lang/String;", "callbackMapper", "Lcom/bytedance/ee/bear/document/doccomponent/impl/CallbackInvokeMapper;", "getCallbackMapper", "()Lcom/bytedance/ee/bear/document/doccomponent/impl/CallbackInvokeMapper;", "docComponentContentEventHandler", "Lcom/bytedance/ee/bear/doccomponent/api/DocComponentContentEventHandler;", "getDocComponentContentEventHandler", "()Lcom/bytedance/ee/bear/doccomponent/api/DocComponentContentEventHandler;", "setDocComponentContentEventHandler", "(Lcom/bytedance/ee/bear/doccomponent/api/DocComponentContentEventHandler;)V", "routeInterceptor", "Lcom/bytedance/ee/bear/route/IRouteInterceptor;", "backPressDispatcher", "Lcom/bytedance/ee/bear/facade/common/BackPressDispatcher;", "init", "", "configModule", "setContentEventHandler", "handler", "processContentEvent", "", "event", "Lcom/bytedance/ee/bear/doccomponent/api/IDocComponentContentEvent;", "onFragmentCreate", "onFragmentResume", "onFragmentPause", "bindNativeEvents", "unbindNativeEvents", "onFragmentDestroy", "updateInterceptRouterDispatch", "shouldIntercept", "onBackPressed", "interceptKeyboardEvent", "Companion", "ActivityLifecycleObserver", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDocComponentImpl implements LifecycleObserver, d, rcb.d {
    public final c a;
    public final Fragment b;
    public final s05.d c;
    public final s05.a d;
    public sa5.b e;

    public static final class a implements LifecycleObserver, bp5.c.a {
        public FragmentActivity a;
        public final String b;

        public final boolean interceptSetStatusBarColor(Activity r1, int r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            return true;
        }

        public final boolean interceptSetSystemUiVisibility(Activity r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "activity");
            return true;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public final void onActivityCreate() {
            bp5.c.b(this.a, this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onActivityDestroy() {
            String r0 = this.b;
            Map<String, c> r1 = e.a;
            tt5.a.h("DComponent_DocComponentFragmentManager", "removeHost:" + r0);
            ((ConcurrentHashMap) e.a).remove(r0);
            FragmentActivity r2 = this.a;
            if (r2 == null) goto L7;
            Lifecycle r3 = r2.getLifecycle();
            if (r3 == null) goto L7;
            r3.removeObserver(this);
        L7:
            bp5.c.c(this.a, this);
            this.a = null;
        }

        public a(Fragment r2, FragmentActivity r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "activity");
            this.a = r3;
            Map<String, c> r4 = e.a;
            if (r2 != null) goto L5;
            tt5.a.k("DComponent_DocComponentFragmentManager", "extractDocComponentHostId no fragment");
            String r5 = "";
        L6:
            this.b = r5;
            return;
        L5:
            r5 = e.b(r2.getArguments());
            goto L6
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean interceptKeyboardEvent() {
        return false;
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        d r0 = this.b;
        if ((r0 instanceof d) == false) goto L8;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.facade.common.BackPressHandler");
        if (r0.onBackPressed() == false) goto L10;
        tt5.a.h("DComponent_BaseDocComponentImpl", "Back press consumed by :" + this.b);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onFragmentCreate() {
        tt5.a.h("DComponent_BaseDocComponentImpl", "onFragmentCreate");
        ArrayList r0 = (ArrayList) rcb.c.a;
        if (r0.contains(this) == true) goto L6;
        r0.add(this);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onFragmentDestroy() {
        tt5.a.h("DComponent_BaseDocComponentImpl", "onFragmentDestroy");
        ((ArrayList) rcb.c.a).remove(this);
        a(new sz4.b());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onFragmentPause() {
        tt5.a.h("DComponent_BaseDocComponentImpl", "onFragmentPause");
        Flowable.just(org.koin.java.a.c(h.class, null, null, 6)).subscribe(new s05.b(false, this), s05.c.a);
        sa5.b r0 = this.e;
        if (r0 == null) goto L6;
        r0.d(this);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onFragmentResume() {
        tt5.a.h("DComponent_BaseDocComponentImpl", "onFragmentResume");
        Flowable.just(org.koin.java.a.c(h.class, null, null, 6)).subscribe(new s05.b(true, this), s05.c.a);
        sa5.b r0 = this.e;
        if (r0 == null) goto L6;
        r0.e(this);
        return;
    }

    public final boolean a(qz4.d r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        tt5.a.h("DComponent_BaseDocComponentImpl", "processContentEvent() called with: event = " + r3 + ", contentEventHandler=null");
        StringBuilder r4 = new StringBuilder("processContentEvent() onContentEvent ret=");
        r4.append(false);
        tt5.a.h("DComponent_BaseDocComponentImpl", r4.toString());
        return false;
    }

    public AbsDocComponentImpl(WebFragment r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "documentToken");
        this.c = new s05.d();
        this.d = new s05.a(this);
        this.b = r3;
        c r5 = e.a(r3);
        this.a = r5;
        if (r5 != null) goto L5;
        tt5.a.k("DComponent_BaseDocComponentImpl", "extractDocComponentHost is null");
    L6:
        FragmentActivity r6 = r3.getActivity();
        if (r6 != null) goto L9;
        tt5.a.d("DComponent_BaseDocComponentImpl", "activity is null");
        return;
    L9:
        this.e = (sa5.b) m.a.a(r6, sa5.b.class);
        r6.getLifecycle().addObserver(new a(r3, r6));
        r3.getLifecycle().addObserver(this);
        return;
    L5:
        r5.b();
        tt5.a.h("DComponent_BaseDocComponentImpl", "DocComponent host bind ok, called onDocComponentApiCreated(" + hashCode() + ')');
        goto L6
    }
}
