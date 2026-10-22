package msc;

import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.v;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import lsc.y;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes5.dex */
public class o extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f515535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f515536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f515537c;

    /* JADX INFO: loaded from: classes41.dex */
    public interface a {
        void a(lsc.m r100, Text r101, int r102);
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface b {
        void a(lsc.m r100, String r101, int r102, uvc.b r103);
    }

    public o() {
        this.f515535a = new ArrayList(0);
        this.f515537c = new ArrayList(0);
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r100) {
        if (this.f515536b == false) goto L5;
        return;
    L5:
        if (r100.getMovementMethod() != null) goto L9;
        r100.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    @Override // lsc.a, lsc.j
    public void c(lsc.p.a r100) {
        r100.a(Text.class, new g(this));
        r100.a(StrongEmphasis.class, new h());
        r100.a(Emphasis.class, new i());
        r100.a(BlockQuote.class, new j());
        r100.a(Code.class, new k());
        r100.a(FencedCodeBlock.class, new l());
        r100.a(IndentedCodeBlock.class, new m());
        r100.a(Image.class, new n());
        r100.a(BulletList.class, new t());
        r100.a(OrderedList.class, new t());
        r100.a(ListItem.class, new io.noties.markwon.core.a());
        r100.a(ThematicBreak.class, new msc.a());
        r100.a(Heading.class, new msc.b());
        r100.a(SoftLineBreak.class, new c());
        r100.a(HardLineBreak.class, new d());
        r100.a(Paragraph.class, new e());
        r100.a(Link.class, new f());
    }

    @Override // lsc.a, lsc.j
    public final void h(lsc.l.a r100) {
        nsc.c r101 = new nsc.c();
        r100.a(StrongEmphasis.class, new nsc.l());
        r100.a(Emphasis.class, new nsc.f());
        r100.a(BlockQuote.class, new nsc.b(0, 0));
        r100.a(Code.class, new nsc.d());
        r100.a(FencedCodeBlock.class, r101);
        r100.a(IndentedCodeBlock.class, r101);
        r100.a(ListItem.class, new nsc.k());
        r100.a(Heading.class, new nsc.h());
        r100.a(Link.class, new nsc.i());
        r100.a(ThematicBreak.class, new nsc.n());
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r100, Spanned r110) {
        io.noties.markwon.core.spans.r[] r101 = (io.noties.markwon.core.spans.r[]) r110.getSpans(0, r110.length(), io.noties.markwon.core.spans.r.class);
        if (r101 == null) goto L8;
        TextPaint r102 = r100.getPaint();
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L8;
        io.noties.markwon.core.spans.r r105 = r101[r104];
        r105.f492366d = (int) (r102.measureText(r105.f492364b) + 0.5f);
        r104 = r104 + 1;
    L8:
        if ((r110 instanceof Spannable) == false) goto L18;
        Spannable r111 = (Spannable) r110;
        v[] r106 = (v[]) r111.getSpans(0, r111.length(), v.class);
        if (r106 == null) goto L14;
        int r107 = r106.length;
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L14;
        r111.removeSpan(r106[r108]);
        r108 = r108 + 1;
    L14:
        r111.setSpan(new v(r100), 0, r111.length(), 18);
        return;
    }

    @Override // lsc.a, lsc.j
    public void a(TextView r100, uvc.b r101, lsc.p r102) {
        s r103 = r102.f510612a.f510591a;
        float r104 = r103.f515549i;
        if (r104 == 1.0f) goto L5;
    L6:
        r102.o(0, new io.noties.markwon.core.spans.l(r104, r103.f515550j));
        return;
    L5:
        if (r103.f515550j != 1.0f) goto L6;
    }

    @Override // lsc.a, lsc.j
    public void d(CharSequence r100, uvc.b r101, lsc.p r102) {
        s r103 = r102.f510612a.f510591a;
        float r104 = r103.f515549i;
        if (r104 == 1.0f) goto L5;
    L6:
        r102.o(0, new io.noties.markwon.core.spans.l(r104, r103.f515550j));
        return;
    L5:
        if (r103.f515550j != 1.0f) goto L6;
    }

    public static void n(lsc.m r100, String r101, String r102, uvc.b r103) {
        r100.C(r103);
        int r104 = r100.length();
        y r105 = r100.builder();
        r105.f510625a.append(Typography.nbsp);
        r105.f510625a.append('\n');
        r105.b(r100.B().f510592b.a(r101, r102));
        r100.a();
        r100.builder().a(Typography.nbsp);
        CoreProps.f492269k.c(r100.r(), r101);
        r100.G(r103, r104);
        r100.q(r103);
    }
}
