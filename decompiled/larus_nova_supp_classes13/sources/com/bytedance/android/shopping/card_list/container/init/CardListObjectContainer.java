package com.bytedance.android.shopping.card_list.container.init;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.async.DisposableScope;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.container.CardListActivity;
import com.bytedance.android.shopping.card_list.container.CardListDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListObjectContainer implements com.bytedance.android.ec.core.async.b {
    public final ConcurrentHashMap<KClass<? extends com.bytedance.android.shopping.card_list.components.a>, com.bytedance.android.shopping.card_list.components.a> a;
    public final ConcurrentHashMap<KClass<? extends com.bytedance.android.shopping.card_list.components.a>, Function0<com.bytedance.android.shopping.card_list.components.a>> b;
    public final AppCompatActivity c;
    public final Fragment d;
    public final com.bytedance.android.shopping.card_list.common_params.a e;
    public final CardListContainerConfig f;
    public final g g;
    public final /* synthetic */ DisposableScope h;

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.h.add(r2);
        return r2;
    }

    public final void clearDisposable() {
        this.h.clearDisposable();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.h.remove(r2);
    }

    public final void a() {
        Fragment r0 = this.d;
        CardListActivity r2 = null;
        if ((r0 instanceof CardListDialogFragment) == true) goto L5;
        r0 = null;
    L5:
        CardListDialogFragment r1 = (CardListDialogFragment) r0;
        if (r1 != null) goto L21;
    L13:
        CardListActivity r3 = this.c;
        if ((r3 instanceof CardListActivity) == false) goto L17;
        r2 = r3;
    L17:
        CardListActivity r4 = r2;
        if (r4 == null) goto L23;
        r4.finish();
        return;
    L23:
        return;
    L21:
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L13;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L13
    }

    public final CompositeDisposable compositeDisposable() {
        return this.h.a();
    }

    public final Context getContext() {
        AppCompatActivity r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.d;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getContext();
    }

    public final AppCompatActivity getActivity() {
        return this.c;
    }

    public final <T extends com.bytedance.android.shopping.card_list.components.a> T b(KClass<? extends com.bytedance.android.shopping.card_list.components.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        com.bytedance.android.shopping.card_list.components.a r1 = null;
        if (this.a.containsKey(r4) == false) goto L9;
        com.bytedance.android.shopping.card_list.components.a r5 = this.a.get(r4);
        if ((r5 instanceof com.bytedance.android.shopping.card_list.components.a) == false) goto L20;
        r1 = r5;
    L20:
        return (T) r1;
    L9:
        Function0<com.bytedance.android.shopping.card_list.components.a> r0 = this.b.get(r4);
        if (r0 == null) goto L12;
        com.bytedance.android.shopping.card_list.components.a r2 = (com.bytedance.android.shopping.card_list.components.a) r0.invoke();
    L13:
        if (r2 == null) goto L16;
        this.a.put(r4, r2);
        c(r2);
    L16:
        if ((r2 instanceof com.bytedance.android.shopping.card_list.components.a) == true) goto L19;
        return null;
    L19:
        return (T) r2;
    L12:
        r2 = null;
        goto L13
    }

    public final void c(com.bytedance.android.shopping.card_list.components.a r3) {
        AppCompatActivity r0 = this.c;
        if (r0 == null) goto L6;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L6;
    L10:
        if (r1 == null) goto L25;
        Lifecycle.State r2 = r1.getCurrentState();
        int r4 = d.a[r2.ordinal()];
        if (r4 != 2) goto L14;
        r3.onCreate();
        return;
    L14:
        if (r4 != 3) goto L16;
        r3.onCreate();
        r3.onStart();
        return;
    L16:
        if (r4 != 4) goto L18;
        r3.onCreate();
        r3.onStart();
        r3.onResume();
        return;
    L18:
        if (r4 != 5) goto L29;
        r3.onCreate();
        r3.onStart();
        r3.onResume();
        r3.onPause();
        r3.onStop();
        r3.onDestroy();
        return;
    L29:
        return;
    L25:
        return;
    L6:
        Fragment r5 = this.d;
        if (r5 == null) goto L9;
        r1 = r5.getLifecycle();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    public final <T extends View> T d(int r2) {
        AppCompatActivity r0 = this.c;
        if (r0 == null) goto L6;
        T r1 = (T) r0.findViewById(r2);
        if (r1 == null) goto L6;
        return r1;
    L6:
        Fragment r3 = this.d;
        if (r3 == null) goto L11;
        View r4 = r3.getView();
        if (r4 == null) goto L11;
        return (T) r4.findViewById(r2);
    L11:
        return null;
    }

    public final <T extends com.bytedance.android.shopping.card_list.components.a> void e(KClass<? extends com.bytedance.android.shopping.card_list.components.a> r2, Boolean r3, Function0<? extends T> r4) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r4, "func");
        this.b.put(r2, r4);
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L11;
        Function0<com.bytedance.android.shopping.card_list.components.a> r5 = this.b.get(r2);
        if (r5 == null) goto L7;
        com.bytedance.android.shopping.card_list.components.a r6 = (com.bytedance.android.shopping.card_list.components.a) r5.invoke();
    L8:
        if (r6 == null) goto L12;
        this.a.put(r2, r6);
        c(r6);
        return;
    L12:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public CardListObjectContainer(AppCompatActivity r2, Fragment r3, com.bytedance.android.shopping.card_list.common_params.a r4, CardListContainerConfig r5, g r6) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "screenSizeService");
        this.h = new DisposableScope();
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        if (r2 == null) goto L6;
        Lifecycle r7 = r2.getLifecycle();
        if (r7 == null) goto L6;
    L9:
        if (r7 == null) goto L12;
        r7.addObserver(new AnonymousClass1(this));
        return;
    L12:
        return;
    L6:
        if (r3 == null) goto L8;
        r7 = r3.getLifecycle();
        goto L9
    L8:
        r7 = null;
        goto L9
    }
}
