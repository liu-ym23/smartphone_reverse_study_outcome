package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes34.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f400004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f400005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f400006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f400007d;

    public abstract void a(HashMap<String, vla.d> r100);

    public abstract d b();

    public abstract void d(HashSet<String> r100);

    public abstract void e(Context r100, AttributeSet r101);

    public void f(HashMap<String, Integer> r100) {
    }

    public d() {
        this.f400004a = -1;
        this.f400005b = -1;
        this.f400006c = null;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public static float g(Object r100) {
        if ((r100 instanceof Float) == false) goto L6;
        return ((Float) r100).floatValue();
    L6:
        return CastFloatProtector.parseFloat(r100.toString());
    }

    public d c(d r100) {
        this.f400004a = r100.f400004a;
        this.f400005b = r100.f400005b;
        this.f400006c = r100.f400006c;
        this.f400007d = r100.f400007d;
        return this;
    }
}
