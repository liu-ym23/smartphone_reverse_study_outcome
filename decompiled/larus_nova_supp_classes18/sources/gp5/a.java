package gp5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends UDBaseDialogBuilder<a> {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public int f;
    public final int g;
    public final int h;
    public int i;
    public CharSequence j;
    public CharSequence k;
    public View l;
    public int m;
    public final boolean n;
    public boolean o;
    public boolean p;
    public b q;
    public InterfaceC0236a r;
    public InterfaceC0236a s;
    public Function1<? super Boolean, Boolean> t;
    public final gp5.b u;
    public CharSequence v;
    public boolean w;

    /* JADX INFO: renamed from: gp5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0236a {
        void a(String r1);
    }

    public interface b {
        void a(CharSequence r1, SpaceEditText r2);
    }

    public final SpaceEditText g() {
        gp5.b r0 = this.u;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.x;
    }

    public final void c() {
        addActionButton(2131391778, 2131887716, null);
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = 2131248268;
        this.k = "";
        this.m = -1;
        this.n = true;
        this.v = "";
        this.w = true;
        gp5.b r1 = new gp5.b(r3);
        this.u = r1;
        a r4 = (a) controller(r1);
        marginInDp(36);
        autoDismiss(true);
        cancelable(false);
        cancelOnTouchOutside(false);
    }

    public final void a(int r3) {
        addActionButton(2131391777, r3, null);
    }

    public final void e(CharSequence r1) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        this.k = r1;
    }

    public final void f(int r2) {
        this.j = getContext().getString(r2);
    }

    public final void b(CharSequence r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        UDBaseDialogBuilder.ActionBuilder r5 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(r3).onClickListener(null);
        if (r4 == null) goto L5;
        r5.bgDrawableRes(r4.intValue());
    L5:
        addActionButton(r5);
    }

    public final void d(CharSequence r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "text");
        UDBaseDialogBuilder.ActionBuilder r5 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(r3).onClickListener(null);
        if (r4 == null) goto L5;
        r5.bgDrawableRes(r4.intValue());
    L5:
        addActionButton(r5);
    }
}
