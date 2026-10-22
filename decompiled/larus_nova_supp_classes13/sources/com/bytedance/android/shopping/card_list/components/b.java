package com.bytedance.android.shopping.card_list.components;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b implements a {
    public SimpleScene<View, c, q> a;
    public final LifecycleOwner b;
    public final CardListObjectContainer c;

    public final Context e() {
        return this.c.getContext();
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onCreate() {
        SimpleScene<View, c, q> r0 = this.a;
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.d;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onDestroy() {
        SimpleScene<View, c, q> r0 = this.a;
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.i;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onPause() {
        SimpleScene<View, c, q> r0 = this.a;
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.g;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onResume() {
        SimpleScene<View, c, q> r0 = this.a;
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.f;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onStart() {
        SimpleScene<View, c, q> r0 = this.a;
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.e;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.card_list.components.a
    public void onStop() {
        SimpleScene<View, c, q> r0 = this.a;
        if (r0 == null) goto L8;
        Function0<Unit> r1 = r0.h;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    L9:
        return;
    }

    public b(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.c = r2;
        Fragment r0 = r2.c;
        if (r0 != null) goto L7;
        r0 = r2.d;
        if (r0 != null) goto L7;
        throw new Exception("访问了不存在了lifecycle");
    L7:
        this.b = r0;
    }

    public final <T extends a> T f(KClass<? extends a> r2) {
        Intrinsics.checkNotNullParameter(r2, "className");
        return (T) this.c.b(r2);
    }
}
