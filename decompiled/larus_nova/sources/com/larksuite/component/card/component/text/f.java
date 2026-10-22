package com.larksuite.component.card.component.text;

import android.text.Layout;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f283649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f283650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f283651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f283652d;

    public static final class a {
    }

    static {
    }

    public f(b r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "renderEntity");
        this.f283649a = r100;
        this.f283650b = r101;
        this.f283651c = r102;
    }

    public final Layout a(CharSequence r100, d r101, float r102, float r103, int r104) {
        TextLayoutBuilder r105 = new TextLayoutBuilder();
        r105.h(r100);
        r105.j(r101.f283616d);
        int r106 = r101.f283617e;
        if (r106 == 0) goto L5;
        r105.i(r106);
    L5:
        r105.k(r101.f283620h);
        r105.f((int) r102);
        r105.c(r101.f283618f);
        boolean r107 = false;
        r105.f446130f = false;
        int r108 = h18.e.f483540a;
        r105.m(h18.e.a(LarkContext.getApplication()));
        TextLayoutBuilder.a r109 = r105.f446127c;
        if (r109.f446139h == true) goto L8;
        r109.f446139h = true;
        r105.f446128d = null;
    L8:
        r109.f446134c = this.f283651c;
        r105.d(r101.f283619g);
        int r110 = (int) r103;
        TextLayoutBuilder.a r111 = r105.f446127c;
        if (r111.f446143l == r110) goto L11;
        r111.f446143l = r110;
        r105.f446128d = null;
    L11:
        r105.e(r104);
        if (this.f283650b <= 0) goto L14;
        r107 = true;
    L14:
        r105.g(r107);
        return r105.a();
    }
}
