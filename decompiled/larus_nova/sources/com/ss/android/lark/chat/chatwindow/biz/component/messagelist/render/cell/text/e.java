package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f412255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f412256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f412257c;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f412255a.element = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f412255a.element = false;
        this.f412256b.invoke();
        this.f412257c.removeOnAttachStateChangeListener(this);
    }

    public e(Ref.BooleanRef r100, Function0<Unit> r101, View r102) {
        this.f412255a = r100;
        this.f412256b = r101;
        this.f412257c = r102;
    }
}
