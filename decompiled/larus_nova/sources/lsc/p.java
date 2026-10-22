package lsc;

import io.noties.markwon.core.CoreProps;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.CustomBlock;
import org.commonmark.node.CustomNode;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes41.dex */
public final class p implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f510612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f510613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f510614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<? extends uvc.b>, m.c<? extends uvc.b>> f510615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m.a f510616e;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a implements m.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<? extends uvc.b>, m.c<? extends uvc.b>> f510617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m.a f510618b;

        public a() {
            this.f510617a = new HashMap();
        }

        public final a a(Class r100, m.c r101) {
            ((HashMap) this.f510617a).put(r100, r101);
            return this;
        }
    }

    @Override // lsc.m
    public final void a() {
        if (this.f510614c.length() <= 0) goto L8;
        y r100 = this.f510614c;
        if ('\n' == r100.f510625a.charAt(r100.length() - 1)) goto L9;
        this.f510614c.a('\n');
        return;
    L9:
        return;
    }

    @Override // lsc.m
    public final void b() {
        this.f510614c.a('\n');
    }

    @Override // lsc.m
    public final int length() {
        return this.f510614c.length();
    }

    @Override // lsc.m
    public final h B() {
        return this.f510612a;
    }

    @Override // lsc.m
    public final y builder() {
        return this.f510614c;
    }

    @Override // lsc.m
    public final t r() {
        return this.f510613b;
    }

    @Override // uvc.c
    public final void A(CustomNode r100) {
        J(r100);
    }

    @Override // lsc.m
    public final void C(uvc.b r100) {
        this.f510616e.a(this, r100);
    }

    @Override // uvc.c
    public final void D(Link r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void E(SoftLineBreak r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void F(Document r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void H(Paragraph r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void I(Emphasis r100) {
        J(r100);
    }

    public final void J(uvc.b r100) {
        m.c<uvc.b> r101 = i(r100);
        if (r101 == null) goto L27;
        r101.a(this, r100);
        Map<Class<? extends uvc.b>, String> r102 = ftc.e.f478829a;
        if ((r100 instanceof ListBlock) == false) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L29;
        HashMap<String, Integer> r104 = CoreProps.f492268j.a(r());
        Class<?> r105 = r100.getClass();
        String r106 = ftc.e.f478829a.get(r105);
        if (r106 != null) goto L16;
        r106 = ftc.e.f478830b.get(r105.getName());
    L16:
        if (r106 != null) goto L19;
        r106 = r105.getSimpleName();
    L19:
        if (r104 == null) goto L23;
        Integer r107 = r104.get(r106);
        if (r107 == null) goto L23;
    L24:
        int r108 = r107.intValue() + 1;
        if (r104 == null) goto L30;
        Integer r109 = r104.put(r106, Integer.valueOf(r108));
        return;
    L30:
        return;
    L23:
        r107 = 0;
        goto L24
    L29:
        return;
    L7:
        if (Intrinsics.areEqual(r100.getClass().getName(), "org.commonmark.ext.gfm.tables.TableBlock") == true) goto L10;
        r103 = false;
        goto L11
    L27:
        c(r100);
    }

    @Override // lsc.m
    public final void c(uvc.b r100) {
        uvc.b r101 = r100.f551901b;
    L3:
        if (r101 == null) goto L5;
        uvc.b r102 = r101.f551904e;
        r101.a(this);
        r101 = r102;
        goto L3
    }

    @Override // uvc.c
    public final void d(IndentedCodeBlock r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void e(CustomBlock r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void f(BlockQuote r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void g(HtmlBlock r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void h(Image r100) {
        J(r100);
    }

    @Override // lsc.m
    public final m.c<uvc.b> i(uvc.b r100) {
        return (m.c) this.f510615d.get(r100.getClass());
    }

    @Override // uvc.c
    public final void j(HardLineBreak r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void k(FencedCodeBlock r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void l(Text r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void m(HtmlInline r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void n(StrongEmphasis r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void p(Code r100) {
        J(r100);
    }

    @Override // lsc.m
    public final void q(uvc.b r100) {
        this.f510616e.b(this, r100);
    }

    @Override // lsc.m
    public final boolean s(uvc.b r100) {
        if (r100.f551904e == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // uvc.c
    public final void t(BulletList r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void u(LinkReferenceDefinition r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void v(ThematicBreak r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void w(ListItem r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void x(Heading r100) {
        J(r100);
    }

    @Override // uvc.c
    public final void z(OrderedList r100) {
        J(r100);
    }

    @Override // lsc.m
    public final <N extends uvc.b> void G(N r100, int r101) {
        Class<?> r102 = r100.getClass();
        x r103 = ((l) this.f510612a.f510595e).a(r102);
        if (r103 == null) goto L6;
        o(r101, r103.a(this.f510612a, this.f510613b));
        return;
    }

    @Override // lsc.m
    public final void o(int r100, Object r101) {
        y r102 = this.f510614c;
        y.f(r102, r101, r100, r102.length());
    }

    @Override // lsc.m
    public final <N extends uvc.b> void y(N r100, int r101) {
        Class<?> r102 = r100.getClass();
        x r103 = ((l) this.f510612a.f510595e).a(r102);
        if (r103 == null) goto L7;
        o(r101, r103.a(this.f510612a, this.f510613b));
        return;
    L7:
        throw new NullPointerException(r102.getName());
    }

    public p(h r100, u r101, y r102, Map r103, m.a r104) {
        this.f510612a = r100;
        this.f510613b = r101;
        this.f510614c = r102;
        this.f510615d = r103;
        this.f510616e = r104;
    }
}
