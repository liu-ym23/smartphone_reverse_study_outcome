package lsc;

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
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes41.dex */
public class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f510586a;

    @Override // lsc.m
    public final h B() {
        return this.f510586a.B();
    }

    @Override // lsc.m
    public final void a() {
        this.f510586a.a();
    }

    @Override // lsc.m
    public final void b() {
        this.f510586a.b();
    }

    @Override // lsc.m
    public final y builder() {
        return this.f510586a.builder();
    }

    @Override // lsc.m
    public final int length() {
        return this.f510586a.length();
    }

    @Override // lsc.m
    public final t r() {
        return this.f510586a.r();
    }

    public c(m r100) {
        this.f510586a = r100;
    }

    @Override // uvc.c
    public final void A(CustomNode r100) {
        J(r100);
    }

    @Override // lsc.m
    public final void C(uvc.b r100) {
        this.f510586a.C(r100);
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
        if (r101 == null) goto L5;
        r101.a(this, r100);
        return;
    L5:
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
        return this.f510586a.i(r100);
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
        this.f510586a.q(r100);
    }

    @Override // lsc.m
    public final boolean s(uvc.b r100) {
        return this.f510586a.s(r100);
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
        this.f510586a.G(r100, r101);
    }

    @Override // lsc.m
    public final void o(int r100, Object r101) {
        this.f510586a.o(r100, r101);
    }

    @Override // lsc.m
    public final <N extends uvc.b> void y(N r100, int r101) {
        this.f510586a.y(r100, r101);
    }
}
