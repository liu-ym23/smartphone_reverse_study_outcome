package com.bytedance.ee.bear.document.doccomponent.impl;

import android.app.Activity;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u000245B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010!\u001a\u00020\"H\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010#\u001a\u00020\bH\u0004J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0018H\u0016J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020\"H\u0017J\b\u0010+\u001a\u00020\"H\u0017J\b\u0010,\u001a\u00020\"H\u0017J\b\u0010-\u001a\u00020\"H\u0002J\b\u0010.\u001a\u00020\"H\u0002J\b\u0010/\u001a\u00020\"H\u0017J\u0010\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020'H\u0003J\b\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020'H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/document/doccomponent/impl/AbsDocComponentImpl;", "Lcom/bytedance/ee/bear/doccomponent/api/DocComponentApi;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "Lcom/ss/android/lark/edit/keyboard/utils/KeyboardEventInterceptor;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "documentToken", "", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "host", "Lcom/bytedance/ee/bear/doccomponent/api/DocComponentHost;", "getHost", "()Lcom/bytedance/ee/bear/doccomponent/api/DocComponentHost;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getDocumentToken", "()Ljava/lang/String;", "callbackMapper", "Lcom/bytedance/ee/bear/document/doccomponent/impl/CallbackInvokeMapper;", "getCallbackMapper", "()Lcom/bytedance/ee/bear/document/doccomponent/impl/CallbackInvokeMapper;", "docComponentContentEventHandler", "Lcom/bytedance/ee/bear/doccomponent/api/DocComponentContentEventHandler;", "getDocComponentContentEventHandler", "()Lcom/bytedance/ee/bear/doccomponent/api/DocComponentContentEventHandler;", "setDocComponentContentEventHandler", "(Lcom/bytedance/ee/bear/doccomponent/api/DocComponentContentEventHandler;)V", "routeInterceptor", "Lcom/bytedance/ee/bear/route/IRouteInterceptor;", "backPressDispatcher", "Lcom/bytedance/ee/bear/facade/common/BackPressDispatcher;", "init", "", "configModule", "setContentEventHandler", "handler", "processContentEvent", "", "event", "Lcom/bytedance/ee/bear/doccomponent/api/IDocComponentContentEvent;", "onFragmentCreate", "onFragmentResume", "onFragmentPause", "bindNativeEvents", "unbindNativeEvents", "onFragmentDestroy", "updateInterceptRouterDispatch", "shouldIntercept", "onBackPressed", "interceptKeyboardEvent", "Companion", "ActivityLifecycleObserver", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDocComponentImpl implements LifecycleObserver, d, rcb.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f219527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f219528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s05.d f219529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s05.a f219530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public sa5.b f219531e;

    public static final class a implements LifecycleObserver, bp5.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FragmentActivity f219532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f219533b;

        @Override // bp5.c.a
        public final boolean interceptSetStatusBarColor(Activity r100, int r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            return true;
        }

        @Override // bp5.c.a
        public final boolean interceptSetSystemUiVisibility(Activity r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            return true;
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public final void onActivityCreate() {
            bp5.c.b(this.f219532a, this);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onActivityDestroy() {
            String r100 = this.f219533b;
            Map<String, c> r101 = e.f540020a;
            tt5.a.h("DComponent_DocComponentFragmentManager", "removeHost:" + r100);
            ((ConcurrentHashMap) e.f540020a).remove(r100);
            FragmentActivity r102 = this.f219532a;
            if (r102 == null) goto L7;
            Lifecycle r103 = r102.getLifecycle();
            if (r103 == null) goto L7;
            r103.removeObserver(this);
        L7:
            bp5.c.c(this.f219532a, this);
            this.f219532a = null;
        }

        public a(Fragment r100, FragmentActivity r101) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, "activity");
            this.f219532a = r101;
            Map<String, c> r102 = e.f540020a;
            if (r100 != null) goto L5;
            tt5.a.k("DComponent_DocComponentFragmentManager", "extractDocComponentHostId no fragment");
            String r103 = "";
        L6:
            this.f219533b = r103;
            return;
        L5:
            r103 = e.b(r100.getArguments());
            goto L6
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // rcb.d
    public final boolean interceptKeyboardEvent() {
        return false;
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        ActivityResultCaller r100 = this.f219528b;
        if ((r100 instanceof d) == false) goto L8;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.facade.common.BackPressHandler");
        if (((d) r100).onBackPressed() == false) goto L10;
        tt5.a.h("DComponent_BaseDocComponentImpl", "Back press consumed by :" + this.f219528b);
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onFragmentCreate() {
        tt5.a.h("DComponent_BaseDocComponentImpl", "onFragmentCreate");
        ArrayList r100 = (ArrayList) rcb.c.f537197a;
        if (r100.contains(this) == true) goto L6;
        r100.add(this);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onFragmentDestroy() {
        tt5.a.h("DComponent_BaseDocComponentImpl", "onFragmentDestroy");
        ((ArrayList) rcb.c.f537197a).remove(this);
        a(new sz4.b());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onFragmentPause() {
        tt5.a.h("DComponent_BaseDocComponentImpl", "onFragmentPause");
        Flowable.just(org.koin.java.a.c(h.class, null, null, 6)).subscribe(new s05.b(false, this), s05.c.f540017a);
        sa5.b r100 = this.f219531e;
        if (r100 == null) goto L6;
        r100.d(this);
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onFragmentResume() {
        tt5.a.h("DComponent_BaseDocComponentImpl", "onFragmentResume");
        Flowable.just(org.koin.java.a.c(h.class, null, null, 6)).subscribe(new s05.b(true, this), s05.c.f540017a);
        sa5.b r100 = this.f219531e;
        if (r100 == null) goto L6;
        r100.e(this);
        return;
    }

    public final boolean a(qz4.d r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        tt5.a.h("DComponent_BaseDocComponentImpl", "processContentEvent() called with: event = " + r100 + ", contentEventHandler=null");
        StringBuilder r101 = new StringBuilder("processContentEvent() onContentEvent ret=");
        r101.append(false);
        tt5.a.h("DComponent_BaseDocComponentImpl", r101.toString());
        return false;
    }

    public AbsDocComponentImpl(WebFragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "documentToken");
        this.f219529c = new s05.d();
        this.f219530d = new s05.a(this);
        this.f219528b = r100;
        c r102 = e.a(r100);
        this.f219527a = r102;
        if (r102 != null) goto L5;
        tt5.a.k("DComponent_BaseDocComponentImpl", "extractDocComponentHost is null");
    L6:
        FragmentActivity r103 = r100.getActivity();
        if (r103 != null) goto L9;
        tt5.a.d("DComponent_BaseDocComponentImpl", "activity is null");
        return;
    L9:
        this.f219531e = (sa5.b) m.a.a(r103, sa5.b.class);
        r103.getLifecycle().addObserver(new a(r100, r103));
        r100.getLifecycle().addObserver(this);
        return;
    L5:
        r102.b();
        tt5.a.h("DComponent_BaseDocComponentImpl", "DocComponent host bind ok, called onDocComponentApiCreated(" + hashCode() + ')');
        goto L6
    }
}
