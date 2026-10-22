package uvc;

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
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes42.dex */
public abstract class a implements c {
    public a() {
    }

    @Override // uvc.c
    public final void A(CustomNode r100) {
        c(r100);
    }

    @Override // uvc.c
    public void D(Link r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void E(SoftLineBreak r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void F(Document r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void H(Paragraph r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void I(Emphasis r100) {
        c(r100);
    }

    public final void c(b r100) {
        b r101 = r100.f551901b;
    L3:
        if (r101 == null) goto L5;
        b r102 = r101.f551904e;
        r101.a(this);
        r101 = r102;
        goto L3
    }

    @Override // uvc.c
    public final void d(IndentedCodeBlock r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void e(CustomBlock r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void f(BlockQuote r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void g(HtmlBlock r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void h(Image r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void j(HardLineBreak r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void k(FencedCodeBlock r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void l(Text r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void m(HtmlInline r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void n(StrongEmphasis r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void p(Code r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void t(BulletList r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void u(LinkReferenceDefinition r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void v(ThematicBreak r100) {
        c(r100);
    }

    @Override // uvc.c
    public void w(ListItem r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void x(Heading r100) {
        c(r100);
    }

    @Override // uvc.c
    public final void z(OrderedList r100) {
        c(r100);
    }
}
