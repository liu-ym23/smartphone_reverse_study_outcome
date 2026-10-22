package com.bytedance.ee.bear.middleground.comment.export;

import android.graphics.Matrix;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentBuilder {
    public boolean A;
    public ye5.a B;
    public Function3<? super String, ? super float[], ? super Matrix, Unit> C;
    public Fragment D;
    public FrameLayout E;
    public k F;
    public Function0<Boolean> G;
    public final FragmentActivity a;
    public final FrameLayout b;
    public final FragmentManager c;
    public String d;
    public String e;
    public sbb.e f;
    public boolean g;
    public String h;
    public long i;
    public long j;
    public o k;
    public boolean l;
    public boolean m;
    public boolean n;
    public CommentStyle o;
    public boolean p;
    public boolean q;
    public v r;
    public boolean s;
    public g t;
    public Function1<? super List<String>, Unit> u;
    public m v;
    public boolean w;
    public t x;
    public bf5.a y;
    public boolean z;

    public final FragmentActivity getActivity() {
        return this.a;
    }

    public CommentBuilder(FragmentActivity r2, FrameLayout r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "viewParent");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.h = "";
        this.i = 1;
        this.l = true;
        this.o = CommentStyle.HALF_SCREEN;
        this.p = true;
        this.u = CommentBuilder$mReadMessage$1.INSTANCE;
        this.F = f.a;
    }
}
