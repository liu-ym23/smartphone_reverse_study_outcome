package com.larus.business.markdown.impl.markwon;

import com.larus.business.markdown.api.extplugin.latex.ILatexPluginKt;
import com.larus.trace.CopyContentTypeString;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
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
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<? extends uvc.b>, String> f320599a = null;

    public static final class a {
    }

    public c() {
    }

    static {
        Map<Class<? extends uvc.b>, String> r100 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ThematicBreak.class, "thematic"), TuplesKt.to(Heading.class, "heading"), TuplesKt.to(FencedCodeBlock.class, "code_block"), TuplesKt.to(IndentedCodeBlock.class, "code_block"), TuplesKt.to(HtmlBlock.class, "html"), TuplesKt.to(HtmlInline.class, "html"), TuplesKt.to(LinkReferenceDefinition.class, "link_ref_def"), TuplesKt.to(Paragraph.class, "paragraph"), TuplesKt.to(TableBlock.class, CopyContentTypeString.TABLE), TuplesKt.to(TableCell.class, "table_cell"), TuplesKt.to(TableBody.class, "table_body"), TuplesKt.to(TableRow.class, "table_row"), TuplesKt.to(TableHead.class, "table_header"), TuplesKt.to(BlockQuote.class, "block_quote"), TuplesKt.to(OrderedList.class, "list"), TuplesKt.to(BulletList.class, "list"), TuplesKt.to(ListItem.class, "list_item"), TuplesKt.to(Code.class, "inline_code"), TuplesKt.to(Emphasis.class, "emphasis"), TuplesKt.to(StrongEmphasis.class, "strong"), TuplesKt.to(Link.class, "link"), TuplesKt.to(Image.class, "image"), TuplesKt.to(Text.class, "text")});
        com.larus.business.markdown.api.extplugin.latex.a r101 = ILatexPluginKt.b();
        if (r101 == null) goto L6;
        Map<Class<? extends uvc.b>, String> r102 = r101.getNodeReportMap();
        if (r102 == null) goto L6;
    L7:
        r100.putAll(r102);
        f320599a = r100;
        return;
    L6:
        r102 = MapsKt.emptyMap();
        goto L7
    }
}
