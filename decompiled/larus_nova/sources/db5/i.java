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

/* JADX INFO: loaded from: classes16.dex */
public class i<T extends db5.a> implements Function<T, g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f467820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f467821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final un5.a.InterfaceC7903a f467822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f467823d;

    public class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpannableStringBuilder f467824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f467825b;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r100) {
            tt5.a.b("FormatFun", "invalidateDrawable");
            final SpannableStringBuilder r101 = this.f467824a;
            com.bytedance.ee.util.ui.j.f(new h(this, r101));
        }

        public a(i r100, SpannableStringBuilder r101) {
            this.f467825b = r100;
            this.f467824a = r101;
        }
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ g apply(Object r100) throws Exception {
        return c((db5.a) r100);
    }

    public g c(T r110) throws Exception {
        g r100 = d(r110);
        SpannableStringBuilder r101 = r100.f467817a;
        bo4.a[] r102 = r110.f467805b;
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r102.length) goto L51;
        bo4.a r105 = r102[r104];
        int r106 = r105.f19813c;
        if (r106 != 0) goto L28;
        tt5.a.b("FormatFun", "apply: set user span");
        un5.l r107 = j(r110, r105);
        List<String> r108 = this.f467821b;
        if (r108 == null) goto L19;
        Iterator<String> r109 = r108.iterator();
    L11:
        if (r109.hasNext() == false) goto L19;
        String r111 = r109.next();
        if (TextUtils.isEmpty(r111) == true) goto L11;
        if (TextUtils.isEmpty(r105.f19815e) == true) goto L11;
        if (TextUtils.equals(r111, r105.f19815e) == false) goto L11;
        un5.g r112 = new un5.g(this.f467820a);
        int r113 = r105.f19811a;
        r101.setSpan(r112, r113, r105.f19817g.length() + r113, 33);
        boolean r114 = true;
    L20:
        if (r114 == false) goto L22;
    L26:
        int r115 = r105.f19811a;
        int r116 = r105.f19817g.length() + r115;
        r107.getClass();
        r101.setSpan(r107, r115, r116, 33);
    L50:
        r104 = r104 + 1;
        goto L4
    L22:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.bitable.content.use_language_user_span_enable") == false) goto L26;
        if (TextUtils.equals(r107.a(), r105.f19817g) == true) goto L26;
        un5.j r117 = new un5.j(r107);
        int r118 = r105.f19811a;
        r101.setSpan(r117, r118, r105.f19817g.length() + r118, 33);
    L19:
        r114 = false;
        goto L20
    L28:
        if (r106 != 6) goto L31;
        tt5.a.b("FormatFun", "apply: set user span");
        un5.f r119 = new un5.f(this.f467820a, r105.f19815e);
        int r120 = r105.f19811a;
        r101.setSpan(r119, r120, r105.f19817g.length() + r120, 33);
        goto L50
    L31:
        if (AtUtils.i(r106) == false) goto L49;
        tt5.a.b("FormatFun", "apply: set doc span type = " + r105.f19813c);
        String r121 = r105.f19818h;
        if (r121 != null) goto L35;
    L37:
        r101.replace(r105.f19811a, r105.f19812b, "<doc.at.~#_%=`>" + r105.f19817g);
    L38:
        r105.f19812b += 15;
        un5.e r122 = g(r110, r105);
        un5.d r123 = e(r101, r105, AtUtils.g(r105.f19813c, r105.f19814d));
        int r124 = r105.f19811a;
        r123.getClass();
        r101.setSpan(r123, r124, r124 + 15, 33);
        int r125 = r105.f19811a;
        int r126 = r105.f19812b;
        r122.getClass();
        r101.setSpan(r122, r125, r126, 33);
        int r127 = r104 + 1;
    L40:
        if (r127 >= r102.length) goto L42;
        bo4.a r128 = r102[r127];
        r128.f19811a += 15;
        r128.f19812b += 15;
        r127 = r127 + 1;
        goto L40
    L42:
        int r129 = 0;
    L43:
        j[] r130 = r110.f467806c;
        if (r129 >= r130.length) goto L50;
        j r131 = r130[r129];
        int r132 = r131.f467826a;
        if (r132 <= r105.f19811a) goto L48;
        r131.f467826a = r132 + 15;
        r131.f467827b += 15;
    L48:
        r129 = r129 + 1;
        goto L43
    L35:
        if (r121.length() != 0) goto L37;
        r101.replace(r105.f19811a, r105.f19812b, "<doc.at.~#_%=`>" + r105.f19817g);
        goto L38
    L49:
        tt5.a.b("FormatFun", "apply: set hyperlink style" + r105.f19813c);
        un5.h r133 = i(r110, r105);
        int r134 = r105.f19811a;
        int r135 = r105.f19817g.length() + r134;
        r133.getClass();
        r101.setSpan(r133, r134, r135, 33);
        goto L50
    L51:
        AtUtils.f239808c.clear();
        int r136 = 0;
    L52:
        j[] r137 = r110.f467806c;
        if (r136 >= r137.length) goto L55;
        j r138 = r137[r136];
        un5.h r139 = h(r110, r138);
        int r140 = r138.f467826a;
        int r141 = r138.f467827b;
        r139.getClass();
        r101.setSpan(r139, r140, r141, 33);
        r136 = r136 + 1;
    L55:
        k[] r142 = r110.f467807d;
        if (r103 >= r142.length) goto L58;
        k r143 = r142[r103];
        r101.setSpan(new StyleSpan(r143.f467832c), r143.f467830a, r143.f467831b, 18);
        r103 = r103 + 1;
        goto L55
    L58:
        return r100;
    }

    public g d(T r100) {
        return new g(new SpannableStringBuilder(r100.f467804a));
    }

    public un5.d f(TextView r100, bo4.a r101) {
        return new un5.d(this.f467820a, r100, r101.f19834x, r101.f19813c, r101.f19815e);
    }

    public un5.e g(T r110, bo4.a r111) {
        return new un5.e(this.f467820a, r111.f19815e, r111.f19813c, r111.f19814d, r111.f19816f, r111.f19834x, r111.f19826p, r111.f19825o, r111.f19824n, this.f467822c);
    }

    public un5.h h(T r100, j r101) {
        return new un5.h(this.f467820a, r101.f467829d, this.f467822c);
    }

    public un5.h i(T r110, bo4.a r111) {
        return new un5.k(this.f467820a, r111.f19815e, Integer.valueOf(r111.f19813c), Integer.valueOf(r111.f19814d), r111.f19816f, r111.f19834x, r111.f19825o, r111.f19824n, this.f467822c);
    }

    public un5.l j(T r110, bo4.a r111) {
        Context r100 = this.f467820a;
        String r101 = r111.f19817g;
        String r102 = r111.f19815e;
        String r103 = r111.f19819i;
        String r104 = r111.f19820j;
        boolean r105 = r111.f19827q;
        String r106 = r111.f19828r;
        boolean r112 = r111.f19831u;
        String r113 = r111.f19823m;
        un5.a.InterfaceC7903a r114 = this.f467822c;
        String r115 = r111.f19830t;
        un5.l r116 = new un5.l(r100, r101, r102, null, r103, r104, null, r105, r106, r112, r113, r114);
        r116.f550827p = r115;
        return r116;
    }

    public i(TextView r100, un5.a.InterfaceC7903a r101, List<String> r102) {
        this.f467823d = r100;
        this.f467820a = r100.getContext();
        this.f467821b = r102;
        this.f467822c = r101;
    }

    public un5.d e(SpannableStringBuilder r100, bo4.a r101, int r102) {
        boolean r103 = kn4.f.a().d();
        if (TextUtils.isEmpty(r101.f19834x) == true) goto L8;
        TextView r104 = this.f467823d;
        if (r104 == null) goto L8;
        return f(r104, r101);
    L8:
        if (r103 == false) goto L16;
        if (TextUtils.isEmpty(r101.f19825o) == true) goto L16;
        if (TextUtils.isEmpty(r101.f19824n) == true) goto L16;
        Drawable r105 = kn4.f.b().b().a(this.f467820a, r101.f19825o, r101.f19824n, r102);
        r105.setCallback(new a(this, r100));
        return new un5.d(this.f467820a, r105, r101.f19813c, r101.f19815e);
    L16:
        return new un5.d(this.f467820a, r102, r101.f19813c, r101.f19815e);
    }
}
