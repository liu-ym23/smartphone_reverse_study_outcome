package com.ss.android.lark.coremd.impl.parse;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.coremd.base.parse.z;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<s> f419894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, z<View>> f419895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function4<Integer, Integer, View, Layout, Unit> f419896c;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    public final Class<s> getType() {
        return this.f419894a;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        z<View> r101 = this.f419895b.invoke(r100);
        if (r101 != null) goto L6;
        Log.e("NodeClickableSpan", "onClick: adapter is null");
        return;
    L6:
        Layout r102 = r101.a(r100);
        if (r102 != null) goto L10;
        Log.e("NodeClickableSpan", "onClick: layout is null");
        return;
    L10:
        CharSequence r103 = r101.c(r100);
        if ((r103 instanceof Spanned) == true) goto L14;
        Log.e("NodeClickableSpan", "onClick: text is not Spanned");
        return;
    L14:
        Spanned r104 = (Spanned) r103;
        int r105 = r104.getSpanStart(this);
        int r106 = r104.getSpanEnd(this);
        this.f419896c.invoke(Integer.valueOf(r105), Integer.valueOf(r106), r100, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Class<s> r100, Function1<? super View, ? extends z<View>> r101, Function4<? super Integer, ? super Integer, ? super View, ? super Layout, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "adapterProvider");
        Intrinsics.checkNotNullParameter(r102, "invocation");
        this.f419894a = r100;
        this.f419895b = r101;
        this.f419896c = r102;
    }
}
