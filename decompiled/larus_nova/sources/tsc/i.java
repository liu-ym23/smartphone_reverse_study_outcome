package tsc;

import android.text.Spanned;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;

/* JADX INFO: loaded from: classes5.dex */
public class i extends h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f547455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f547456g;

    public static final class a {
    }

    static {
    }

    @Override // lsc.a, lsc.j
    public final void i(CharSequence r100, uvc.b r101) {
    }

    public i() {
        this.f547456g = null;
        this.f547455f = new LinkedHashSet();
    }

    public static String q(List r100) {
        StringBuffer r101 = new StringBuffer("{");
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.append("span: " + ((usc.e) r102.next()).toString());
        goto L4
    L6:
        r101.append(com.alipay.sdk.m.u.i.f25855d);
        return r101.toString();
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r100) {
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L8;
        r102.setTag(R.id.markwon_cached_widget_list, null);
    L8:
        CharSequence r103 = r100.getText();
        if ((r103 instanceof Spanned) == false) goto L13;
        int r104 = 0;
        usc.e[] r105 = (usc.e[]) ((Spanned) r103).getSpans(0, r103.length(), usc.e.class);
        int r106 = r105.length;
    L11:
        if (r104 >= r106) goto L15;
        r105[r104].a(r100);
        r104 = r104 + 1;
        goto L11
    L15:
        return;
    }

    @Override // lsc.a, lsc.j
    public final void c(lsc.p.a r100) {
        r100.a(HtmlBlock.class, new j(this));
        r100.a(HtmlInline.class, new k(this));
    }

    @Override // lsc.a, lsc.j
    public final void k(vvc.e.a r100) {
        usc.c.a r101 = new usc.c.a();
        r101.f551579a.addAll(this.f547455f);
        r100.a(r101);
    }

    public static String p(usc.e r100, String r101) {
        return "span[" + r100 + "]:" + r101;
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r100, Spanned r101) {
        n r102 = this.f547456g;
        if (r102 == null) goto L5;
        r102.d("custom-data-hp", "beforeSetText markdown: " + r101);
    L5:
        CharSequence r103 = r100.getText();
        n r104 = this.f547456g;
        if (r104 == null) goto L9;
        r104.d("custom-data-hp", "beforeSetText currText: " + r103);
    L9:
        if ((r103 instanceof Spanned) == true) goto L11;
        CharSequence r105 = null;
    L12:
        Spanned r106 = (Spanned) r105;
        if (r106 == null) goto L19;
        usc.e[] r107 = (usc.e[]) r106.getSpans(0, r103.length(), usc.e.class);
        if (r107 == null) goto L19;
        List r108 = ArraysKt.toMutableList(r107);
        if (r108 == null) goto L19;
    L20:
        n r109 = this.f547456g;
        if (r109 == null) goto L23;
        r109.d("custom-data-hp", "beforeSetText currSpans: " + q(r108));
    L23:
        List r110 = ArraysKt.toMutableList(r101.getSpans(0, r101.length(), usc.e.class));
        n r111 = this.f547456g;
        if (r111 == null) goto L26;
        r111.d("custom-data-hp", "beforeSetText newSpans: " + q(r110));
    L26:
        Iterator r112 = r108.iterator();
    L28:
        if (r112.hasNext() == false) goto L38;
        usc.e r113 = (usc.e) r112.next();
        if (r110.remove(r113) == false) goto L31;
        n r114 = this.f547456g;
        if (r114 == null) goto L37;
        r114.d("custom-data-hp", p(r113, "reuse span"));
    L37:
        r113.g(r100, r101);
        goto L28
    L31:
        r113.c(r100);
        n r115 = this.f547456g;
        if (r115 == null) goto L28;
        r115.d("custom-data-hp", p(r113, "span.onDetach"));
        goto L28
    L38:
        Iterator r116 = r110.iterator();
    L40:
        if (r116.hasNext() == false) goto L45;
        usc.e r117 = (usc.e) r116.next();
        n r118 = this.f547456g;
        if (r118 == null) goto L44;
        r118.d("custom-data-hp", p(r117, "new span beforeAttach"));
    L44:
        r117.d(r100, r101);
        goto L40
    L45:
        return;
    L19:
        r108 = new ArrayList();
        goto L20
    L11:
        r105 = r103;
        goto L12
    }
}
