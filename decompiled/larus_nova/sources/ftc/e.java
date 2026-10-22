package ftc;

import com.larus.trace.CopyContentTypeString;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<? extends uvc.b>, String> f478829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f478830b = null;

    static {
        f478829a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ThematicBreak.class, "thematic"), TuplesKt.to(Heading.class, "heading"), TuplesKt.to(FencedCodeBlock.class, "code_block"), TuplesKt.to(IndentedCodeBlock.class, "code_block"), TuplesKt.to(HtmlBlock.class, "html"), TuplesKt.to(HtmlInline.class, "html"), TuplesKt.to(LinkReferenceDefinition.class, "link_ref_def"), TuplesKt.to(Paragraph.class, "paragraph"), TuplesKt.to(BlockQuote.class, "block_quote"), TuplesKt.to(OrderedList.class, "list"), TuplesKt.to(BulletList.class, "list"), TuplesKt.to(ListItem.class, "list_item"), TuplesKt.to(Code.class, "inline_code"), TuplesKt.to(Emphasis.class, "emphasis"), TuplesKt.to(StrongEmphasis.class, "strong"), TuplesKt.to(Link.class, "link"), TuplesKt.to(Image.class, "image"), TuplesKt.to(Text.class, "text")});
        f478830b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("org.commonmark.ext.gfm.tables.TableBlock", CopyContentTypeString.TABLE), TuplesKt.to("org.commonmark.ext.gfm.tables.TableCell", "table_cell"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableBody", "table_body"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableCell", "table_row"), TuplesKt.to("org.commonmark.ext.gfm.tables.TableHead", "table_header")});
    }
}
