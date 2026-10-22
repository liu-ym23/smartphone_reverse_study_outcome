package db5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.bytedance.ee.bear.utils.AtUtils;
import db5.a;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class i<T extends db5.a> implements Function<T, g> {
    public final Context a;
    public final List<String> b;
    public final un5.a.a c;
    public final TextView d;

    public class a implements Drawable.Callback {
        public final /* synthetic */ SpannableStringBuilder a;
        public final /* synthetic */ i b;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r1, Runnable r2) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r2) {
            tt5.a.b("FormatFun", "invalidateDrawable");
            final SpannableStringBuilder r3 = this.a;
            com.bytedance.ee.util.ui.j.f(new h(this, r3));
        }

        public a(i r1, SpannableStringBuilder r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
        return c((db5.a) r1);
    }

    public g c(T r12) throws Exception {
        g r0 = d(r12);
        SpannableStringBuilder r1 = r0.a;
        bo4.a[] r2 = r12.b;
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r4 >= r2.length) goto L51;
        bo4.a r5 = r2[r4];
        int r7 = r5.c;
        if (r7 != 0) goto L28;
        tt5.a.b("FormatFun", "apply: set user span");
        un5.l r8 = j(r12, r5);
        List<String> r9 = this.b;
        if (r9 == null) goto L19;
        Iterator<String> r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L19;
        String r11 = r10.next();
        if (TextUtils.isEmpty(r11) == true) goto L11;
        if (TextUtils.isEmpty(r5.e) == true) goto L11;
        if (TextUtils.equals(r11, r5.e) == false) goto L11;
        un5.g r13 = new un5.g(this.a);
        int r14 = r5.a;
        r1.setSpan(r13, r14, r5.g.length() + r14, 33);
        boolean r16 = true;
    L20:
        if (r16 == false) goto L22;
    L26:
        int r17 = r5.a;
        int r6 = r5.g.length() + r17;
        r8.getClass();
        r1.setSpan(r8, r17, r6, 33);
    L50:
        r4 = r4 + 1;
        goto L4
    L22:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.bitable.content.use_language_user_span_enable") == false) goto L26;
        if (TextUtils.equals(r8.a(), r5.g) == true) goto L26;
        un5.j r18 = new un5.j(r8);
        int r19 = r5.a;
        r1.setSpan(r18, r19, r5.g.length() + r19, 33);
    L19:
        r16 = false;
        goto L20
    L28:
        if (r7 != 6) goto L31;
        tt5.a.b("FormatFun", "apply: set user span");
        un5.f r20 = new un5.f(this.a, r5.e);
        int r21 = r5.a;
        r1.setSpan(r20, r21, r5.g.length() + r21, 33);
        goto L50
    L31:
        if (AtUtils.i(r7) == false) goto L49;
        tt5.a.b("FormatFun", "apply: set doc span type = " + r5.c);
        String r22 = r5.h;
        if (r22 != null) goto L35;
    L37:
        r1.replace(r5.a, r5.b, "<doc.at.~#_%=`>" + r5.g);
    L38:
        r5.b += 15;
        un5.e r23 = g(r12, r5);
        un5.d r24 = e(r1, r5, AtUtils.g(r5.c, r5.d));
        int r26 = r5.a;
        r24.getClass();
        r1.setSpan(r24, r26, r26 + 15, 33);
        int r27 = r5.a;
        int r28 = r5.b;
        r23.getClass();
        r1.setSpan(r23, r27, r28, 33);
        int r29 = r4 + 1;
    L40:
        if (r29 >= r2.length) goto L42;
        bo4.a r30 = r2[r29];
        r30.a += 15;
        r30.b += 15;
        r29 = r29 + 1;
        goto L40
    L42:
        int r31 = 0;
    L43:
        j[] r32 = r12.c;
        if (r31 >= r32.length) goto L50;
        j r33 = r32[r31];
        int r34 = r33.a;
        if (r34 <= r5.a) goto L48;
        r33.a = r34 + 15;
        r33.b += 15;
    L48:
        r31 = r31 + 1;
        goto L43
    L35:
        if (r22.length() != 0) goto L37;
        r1.replace(r5.a, r5.b, "<doc.at.~#_%=`>" + r5.g);
        goto L38
    L49:
        tt5.a.b("FormatFun", "apply: set hyperlink style" + r5.c);
        un5.h r36 = i(r12, r5);
        int r37 = r5.a;
        int r38 = r5.g.length() + r37;
        r36.getClass();
        r1.setSpan(r36, r37, r38, 33);
        goto L50
    L51:
        AtUtils.c.clear();
        int r39 = 0;
    L52:
        j[] r40 = r12.c;
        if (r39 >= r40.length) goto L55;
        j r41 = r40[r39];
        un5.h r42 = h(r12, r41);
        int r43 = r41.a;
        int r44 = r41.b;
        r42.getClass();
        r1.setSpan(r42, r43, r44, 33);
        r39 = r39 + 1;
    L55:
        k[] r46 = r12.d;
        if (r3 >= r46.length) goto L58;
        k r47 = r46[r3];
        r1.setSpan(new StyleSpan(r47.c), r47.a, r47.b, 18);
        r3 = r3 + 1;
        goto L55
    L58:
        return r0;
    }

    public g d(T r3) {
        return new g(new SpannableStringBuilder(r3.a));
    }

    public un5.d f(TextView r8, bo4.a r9) {
        return new un5.d(this.a, r8, r9.x, r9.c, r9.e);
    }

    public un5.e g(T r12, bo4.a r13) {
        return new un5.e(this.a, r13.e, r13.c, r13.d, r13.f, r13.x, r13.p, r13.o, r13.n, this.c);
    }

    public un5.h h(T r3, j r4) {
        return new un5.h(this.a, r4.d, this.c);
    }

    public un5.h i(T r11, bo4.a r12) {
        return new un5.k(this.a, r12.e, Integer.valueOf(r12.c), Integer.valueOf(r12.d), r12.f, r12.x, r12.o, r12.n, this.c);
    }

    public un5.l j(T r14, bo4.a r16) {
        Context r1 = this.a;
        String r2 = r16.g;
        String r3 = r16.e;
        String r5 = r16.i;
        String r6 = r16.j;
        boolean r8 = r16.q;
        String r9 = r16.r;
        boolean r10 = r16.u;
        String r11 = r16.m;
        un5.a.a r12 = this.c;
        String r17 = r16.t;
        un5.l r18 = new un5.l(r1, r2, r3, null, r5, r6, null, r8, r9, r10, r11, r12);
        r18.p = r17;
        return r18;
    }

    public i(TextView r1, un5.a.a r2, List<String> r3) {
        this.d = r1;
        this.a = r1.getContext();
        this.b = r3;
        this.c = r2;
    }

    public un5.d e(SpannableStringBuilder r5, bo4.a r6, int r7) {
        boolean r0 = kn4.f.a().d();
        if (TextUtils.isEmpty(r6.x) == true) goto L8;
        TextView r1 = this.d;
        if (r1 == null) goto L8;
        return f(r1, r6);
    L8:
        if (r0 == false) goto L16;
        if (TextUtils.isEmpty(r6.o) == true) goto L16;
        if (TextUtils.isEmpty(r6.n) == true) goto L16;
        Drawable r8 = kn4.f.b().b().a(this.a, r6.o, r6.n, r7);
        r8.setCallback(new a(this, r5));
        return new un5.d(this.a, r8, r6.c, r6.e);
    L16:
        return new un5.d(this.a, r7, r6.c, r6.e);
    }
}
