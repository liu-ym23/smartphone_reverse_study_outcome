package ee3;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public TextView a;
    public TextView b;
    public FrameLayout c;
    public b d;
    public View.OnClickListener e;
    public Integer f;
    public Integer g;

    public static final class a {
    }

    public interface b {
        void a(int r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.d();
            b r3 = this.a.d;
            if (r3 == null) goto L6;
            r3.a(0);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ f a;

        public d(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.c();
            b r3 = this.a.d;
            if (r3 == null) goto L6;
            r3.a(1);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ f a;

        public e(f r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    static {
    }

    public f() {
    }

    public final void c() {
        this.g = 1;
        TextView r1 = this.b;
        if (r1 == null) goto L5;
        r1.setSelected(true);
    L5:
        TextView r0 = this.a;
        if (r0 == null) goto L9;
        r0.setSelected(false);
        return;
    }

    public final void d() {
        this.g = 0;
        TextView r1 = this.a;
        if (r1 == null) goto L5;
        r1.setSelected(true);
    L5:
        TextView r2 = this.b;
        if (r2 == null) goto L9;
        r2.setSelected(false);
        return;
    }

    public static ColorStateList b(Context r5) {
        int[] r1 = {-1, r5.getResources().getColor(2131105971)};
        return new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, r1);
    }

    public final void a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "root");
        View r0 = th.a.c(r4.getContext(), 2131560476, r4, false);
        if (r0 == null) goto L47;
        FrameLayout r1 = (FrameLayout) r0;
        this.c = r1;
        r4.addView(r1);
        Integer r5 = this.f;
        TextView r2 = null;
        if (r5 == null) goto L10;
        int r6 = r5.intValue();
        FrameLayout r3 = this.c;
        if (r3 == null) goto L9;
        r3.setVisibility(r6);
    L9:
        this.f = null;
    L10:
        FrameLayout r7 = this.c;
        if (r7 == null) goto L13;
        TextView r8 = (TextView) r7.findViewById(2131390778);
    L14:
        this.a = r8;
        FrameLayout r9 = this.c;
        if (r9 == null) goto L17;
        TextView r10 = (TextView) r9.findViewById(2131390777);
    L18:
        this.b = r10;
        FrameLayout r11 = this.c;
        if (r11 == null) goto L23;
        TextView r12 = (TextView) r11.findViewById(2131390778);
        if (r12 == null) goto L23;
        r12.setTextColor(b(r12.getContext()));
        r12.setOnClickListener(new c(this));
        Unit r13 = Unit.INSTANCE;
    L24:
        this.a = r12;
        FrameLayout r14 = this.c;
        if (r14 == null) goto L29;
        TextView r15 = (TextView) r14.findViewById(2131390777);
        if (r15 == null) goto L29;
        r15.setTextColor(b(r15.getContext()));
        r15.setOnClickListener(new d(this));
        Unit r16 = Unit.INSTANCE;
        r2 = r15;
    L29:
        this.b = r2;
        FrameLayout r17 = this.c;
        if (r17 == null) goto L34;
        View r18 = r17.findViewById(2131376107);
        if (r18 == null) goto L34;
        r18.setOnClickListener(new e(this));
    L34:
        Integer r19 = this.g;
        if (r19 != null) goto L38;
    L40:
        if (r19 != null) goto L43;
        return;
    L43:
        if (r19.intValue() != 0) goto L49;
        d();
        return;
    L49:
        return;
    L38:
        if (r19.intValue() != 1) goto L40;
        c();
        return;
    L23:
        r12 = null;
        goto L24
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
}
