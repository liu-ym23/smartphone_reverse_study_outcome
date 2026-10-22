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
public interface c {
    void A(CustomNode r100);

    void D(Link r100);

    void E(SoftLineBreak r100);

    void F(Document r100);

    void H(Paragraph r100);

    void I(Emphasis r100);

    void d(IndentedCodeBlock r100);

    void e(CustomBlock r100);

    void f(BlockQuote r100);

    void g(HtmlBlock r100);

    void h(Image r100);

    void j(HardLineBreak r100);

    void k(FencedCodeBlock r100);

    void l(Text r100);

    void m(HtmlInline r100);

    void n(StrongEmphasis r100);

    void p(Code r100);

    void t(BulletList r100);

    void u(LinkReferenceDefinition r100);

    void v(ThematicBreak r100);

    void w(ListItem r100);

    void x(Heading r100);

    void z(OrderedList r100);
}
