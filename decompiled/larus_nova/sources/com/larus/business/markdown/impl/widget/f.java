package com.larus.business.markdown.impl.widget;

import com.baidu.platform.comapi.map.MapBundleKey;
import io.noties.markwon.ext.tables.TableTitle;
import io.noties.markwon.ext.tasklist.TaskListItem;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
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

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f320725a = 0;

    static {
    }

    public static uvc.b c(uvc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BlockQuote) == false) goto L6;
        uvc.b r101 = new BlockQuote();
    L96:
        if (r101 == null) goto L100;
        Map<String, Object> r102 = r101.f551906g;
        if (r102 == null) goto L100;
        HashMap r103 = (HashMap) r102;
        r103.putAll(r100.f551906g);
    L100:
        return r101;
    L6:
        if ((r100 instanceof BulletList) == false) goto L9;
        BulletList r104 = new BulletList();
        BulletList r105 = (BulletList) r100;
        r104.f525759i = r105.f525759i;
        r104.f525778h = r105.f525778h;
        r101 = r104;
        goto L96
    L9:
        if ((r100 instanceof Code) == false) goto L12;
        Code r106 = new Code();
        r106.f525760h = ((Code) r100).f525760h;
        r101 = r106;
        goto L96
    L12:
        if ((r100 instanceof Document) == false) goto L15;
        r101 = new Document();
        goto L96
    L15:
        if ((r100 instanceof Emphasis) == false) goto L18;
        Emphasis r107 = new Emphasis();
        r107.f525761h = ((Emphasis) r100).f525761h;
        r101 = r107;
        goto L96
    L18:
        if ((r100 instanceof FencedCodeBlock) == false) goto L21;
        FencedCodeBlock r108 = new FencedCodeBlock();
        FencedCodeBlock r109 = (FencedCodeBlock) r100;
        r108.f525762h = r109.f525762h;
        r108.f525763i = r109.f525763i;
        r108.f525764j = r109.f525764j;
        r108.f525765k = r109.f525765k;
        r108.f525766l = r109.f525766l;
        r101 = r108;
        goto L96
    L21:
        if ((r100 instanceof HardLineBreak) == false) goto L24;
        r101 = new HardLineBreak();
        goto L96
    L24:
        if ((r100 instanceof Heading) == false) goto L27;
        Heading r110 = new Heading();
        r110.f525767h = ((Heading) r100).f525767h;
        r101 = r110;
        goto L96
    L27:
        if ((r100 instanceof ThematicBreak) == false) goto L30;
        r101 = new ThematicBreak();
        goto L96
    L30:
        if ((r100 instanceof HtmlInline) == false) goto L33;
        HtmlInline r111 = new HtmlInline();
        r111.f525769h = ((HtmlInline) r100).f525769h;
        r101 = r111;
        goto L96
    L33:
        if ((r100 instanceof HtmlBlock) == false) goto L36;
        HtmlBlock r112 = new HtmlBlock();
        r112.f525768h = ((HtmlBlock) r100).f525768h;
        r101 = r112;
        goto L96
    L36:
        if ((r100 instanceof Image) == false) goto L39;
        Image r113 = new Image();
        Image r114 = (Image) r100;
        r113.f525770h = r114.f525770h;
        r113.f525771i = r114.f525771i;
        r101 = r113;
        goto L96
    L39:
        if ((r100 instanceof IndentedCodeBlock) == false) goto L42;
        IndentedCodeBlock r115 = new IndentedCodeBlock();
        r115.f525772h = ((IndentedCodeBlock) r100).f525772h;
        r101 = r115;
        goto L96
    L42:
        if ((r100 instanceof Link) == false) goto L45;
        Link r116 = new Link();
        Link r117 = (Link) r100;
        r116.f525773h = r117.f525773h;
        r116.f525774i = r117.f525774i;
        r101 = r116;
        goto L96
    L45:
        if ((r100 instanceof ListItem) == false) goto L48;
        r101 = new ListItem();
        goto L96
    L48:
        if ((r100 instanceof OrderedList) == false) goto L51;
        OrderedList r118 = new OrderedList();
        OrderedList r119 = (OrderedList) r100;
        r118.f525779i = r119.f525779i;
        r118.f525781k = r119.f525781k;
        r101 = r118;
        goto L96
    L51:
        if ((r100 instanceof Paragraph) == false) goto L54;
        r101 = new Paragraph();
        goto L96
    L54:
        if ((r100 instanceof SoftLineBreak) == false) goto L57;
        r101 = new SoftLineBreak();
        goto L96
    L57:
        if ((r100 instanceof StrongEmphasis) == false) goto L60;
        StrongEmphasis r120 = new StrongEmphasis();
        r120.f525782h = ((StrongEmphasis) r100).f525782h;
        r101 = r120;
        goto L96
    L60:
        if ((r100 instanceof Text) == false) goto L63;
        Text r121 = new Text();
        r121.f525783h = ((Text) r100).f525783h;
        r101 = r121;
        goto L96
    L63:
        if ((r100 instanceof LinkReferenceDefinition) == false) goto L66;
        LinkReferenceDefinition r122 = new LinkReferenceDefinition();
        LinkReferenceDefinition r123 = (LinkReferenceDefinition) r100;
        r122.f525775h = r123.f525775h;
        r122.f525776i = r123.f525776i;
        r122.f525777j = r123.f525777j;
        r101 = r122;
        goto L96
    L66:
        if ((r100 instanceof LatexMathBlock) == false) goto L69;
        LatexMathBlock r124 = new LatexMathBlock();
        r124.f492652h = ((LatexMathBlock) r100).f492652h;
        r101 = r124;
        goto L96
    L69:
        if ((r100 instanceof TaskListItem) == false) goto L72;
        r101 = new TaskListItem(((TaskListItem) r100).f492570h);
        goto L96
    L72:
        if ((r100 instanceof TableBlock) == false) goto L75;
        r101 = new TableBlock();
        goto L96
    L75:
        if ((r100 instanceof LatexMathNode) == false) goto L78;
        LatexMathNode r125 = new LatexMathNode();
        r125.f492653h = ((LatexMathNode) r100).f492653h;
        r101 = r125;
        goto L96
    L78:
        if ((r100 instanceof TableTitle) == false) goto L81;
        TableTitle r126 = new TableTitle();
        TableTitle r127 = (TableTitle) r100;
        r126.f492503h = r127.f492503h;
        r126.f492504i = r127.f492504i;
        r101 = r126;
        goto L96
    L81:
        if ((r100 instanceof Strikethrough) == false) goto L84;
        r101 = new Strikethrough();
        goto L96
    L84:
        if ((r100 instanceof TableBody) == false) goto L87;
        r101 = new TableBody();
        goto L96
    L87:
        if ((r100 instanceof TableCell) == false) goto L90;
        TableCell r128 = new TableCell();
        TableCell r129 = (TableCell) r100;
        r128.f525648h = r129.f525648h;
        r128.f525649i = r129.f525649i;
        r101 = r128;
        goto L96
    L90:
        if ((r100 instanceof TableHead) == false) goto L93;
        r101 = new TableHead();
        goto L96
    L93:
        if ((r100 instanceof TableRow) == false) goto L95;
        r101 = new TableRow();
        goto L96
    L95:
        r101 = null;
        goto L96
    }

    public static void g(uvc.b r100) {
        uvc.b r101 = r100.f551901b;
    L3:
        if (r101 == null) goto L8;
        g(r101);
        if ((r100 instanceof OrderedList) == false) goto L7;
        OrderedList r102 = (OrderedList) r100;
        r102.f525779i = r102.f525780j;
    L7:
        r101 = r101.f551904e;
        goto L3
    }

    public static void h(uvc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        uvc.b r101 = r100.f551903d;
        if (r101 == null) goto L6;
        r101.f551904e = r100.f551904e;
    L6:
        uvc.b r102 = r100.f551904e;
        if (r102 == null) goto L10;
        r102.f551903d = r101;
    L10:
        uvc.b r103 = r100.f551900a;
        if (r103 == null) goto L13;
        uvc.b r104 = r103.f551901b;
    L15:
        if (Intrinsics.areEqual(r104, r100) == false) goto L20;
        uvc.b r105 = r100.f551900a;
        if (r105 == null) goto L20;
        r105.f551901b = r100.f551904e;
    L20:
        uvc.b r106 = r100.f551900a;
        if (r106 == null) goto L23;
        uvc.b r107 = r106.f551902c;
    L25:
        if (Intrinsics.areEqual(r107, r100) == false) goto L30;
        uvc.b r108 = r100.f551900a;
        if (r108 == null) goto L30;
        r108.f551902c = r100.f551903d;
    L30:
        r100.f551900a = null;
        r100.f551904e = null;
        r100.f551903d = null;
        return;
    L23:
        r107 = null;
        goto L25
    L13:
        r104 = null;
        goto L15
    }

    public static void a(uvc.b r100, uvc.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        h(r101);
        r101.f551900a = r100;
        uvc.b r102 = r100.f551902c;
        if (r102 == null) goto L5;
        r102.f551904e = r101;
        r101.f551903d = r102;
        r100.f551902c = r101;
        return;
    L5:
        r100.f551901b = r101;
        r100.f551902c = r101;
    }

    public static boolean b(uvc.b r100, uvc.b r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L376;
        if (r101 == null) goto L376;
        if (Intrinsics.areEqual(r100.getClass().getCanonicalName(), r101.getClass().getCanonicalName()) == true) goto L14;
    L359:
        boolean r102 = false;
    L360:
        if (r102 == true) goto L362;
        return false;
    L362:
        uvc.b r103 = r100.f551901b;
        uvc.b r104 = r101.f551901b;
    L363:
        if (r103 != null) goto L368;
        if (r104 != null) goto L368;
        return true;
    L368:
        if (b(r103, r104) == false) goto L369;
        if (r103 == null) goto L372;
        r103 = r103.f551904e;
    L373:
        if (r104 != null) goto L374;
        r104 = null;
        goto L363
    L374:
        r104 = r104.f551904e;
        goto L363
    L372:
        r103 = null;
        goto L373
    L369:
        return false;
    L14:
        if ((r100 instanceof BlockQuote) == true) goto L358;
        boolean r105 = r100 instanceof BulletList;
        if (r105 == false) goto L34;
        if (r105 == false) goto L20;
        BulletList r106 = (BulletList) r100;
    L21:
        if (r106 == null) goto L359;
        if ((r101 instanceof BulletList) == false) goto L26;
        BulletList r107 = (BulletList) r101;
    L27:
        if (r107 == null) goto L359;
        if (r106.f525759i != r107.f525759i) goto L359;
        if (r106.f525778h != r107.f525778h) goto L359;
    L26:
        r107 = null;
        goto L27
    L20:
        r106 = null;
        goto L21
    L34:
        boolean r108 = r100 instanceof Code;
        if (r108 == false) goto L49;
        if (r108 == false) goto L38;
        Code r109 = (Code) r100;
    L39:
        if (r109 == null) goto L359;
        if ((r101 instanceof Code) == false) goto L44;
        Code r110 = (Code) r101;
    L45:
        if (r110 == null) goto L359;
        r102 = Intrinsics.areEqual(r109.f525760h, r110.f525760h);
        goto L360
    L44:
        r110 = null;
        goto L45
    L38:
        r109 = null;
        goto L39
    L49:
        if ((r100 instanceof Document) == true) goto L358;
        boolean r111 = r100 instanceof Emphasis;
        if (r111 == false) goto L65;
        if (r111 == false) goto L55;
        Emphasis r112 = (Emphasis) r100;
    L56:
        if (r112 == null) goto L359;
        if ((r101 instanceof Emphasis) == false) goto L61;
        Emphasis r113 = (Emphasis) r101;
    L62:
        if (r113 == null) goto L359;
        r102 = Intrinsics.areEqual(r112.f525761h, r113.f525761h);
        goto L360
    L61:
        r113 = null;
        goto L62
    L55:
        r112 = null;
        goto L56
    L65:
        boolean r114 = r100 instanceof FencedCodeBlock;
        if (r114 == false) goto L90;
        if (r114 == false) goto L69;
        FencedCodeBlock r115 = (FencedCodeBlock) r100;
    L70:
        if (r115 == null) goto L359;
        if ((r101 instanceof FencedCodeBlock) == false) goto L75;
        FencedCodeBlock r116 = (FencedCodeBlock) r101;
    L76:
        if (r116 == null) goto L359;
        if (r115.f525762h != r116.f525762h) goto L359;
        if (r115.f525763i != r116.f525763i) goto L359;
        if (r115.f525764j != r116.f525764j) goto L359;
        if (Intrinsics.areEqual(r115.f525765k, r116.f525765k) == false) goto L359;
        if (Intrinsics.areEqual(r115.f525766l, r116.f525766l) == false) goto L359;
    L75:
        r116 = null;
        goto L76
    L69:
        r115 = null;
        goto L70
    L90:
        if ((r100 instanceof HardLineBreak) == true) goto L358;
        boolean r117 = r100 instanceof Heading;
        if (r117 == false) goto L109;
        if (r117 == false) goto L96;
        Heading r118 = (Heading) r100;
    L97:
        if (r118 == null) goto L359;
        if ((r101 instanceof Heading) == false) goto L102;
        Heading r119 = (Heading) r101;
    L103:
        if (r119 == null) goto L359;
        if (r118.f525767h != r119.f525767h) goto L359;
    L102:
        r119 = null;
        goto L103
    L96:
        r118 = null;
        goto L97
    L109:
        if ((r100 instanceof ThematicBreak) == true) goto L358;
        boolean r120 = r100 instanceof HtmlInline;
        if (r120 == false) goto L125;
        if (r120 == false) goto L115;
        HtmlInline r121 = (HtmlInline) r100;
    L116:
        if (r121 == null) goto L359;
        if ((r101 instanceof HtmlInline) == false) goto L121;
        HtmlInline r122 = (HtmlInline) r101;
    L122:
        if (r122 == null) goto L359;
        r102 = Intrinsics.areEqual(r121.f525769h, r122.f525769h);
        goto L360
    L121:
        r122 = null;
        goto L122
    L115:
        r121 = null;
        goto L116
    L125:
        boolean r123 = r100 instanceof HtmlBlock;
        if (r123 == false) goto L139;
        if (r123 == false) goto L129;
        HtmlBlock r124 = (HtmlBlock) r100;
    L130:
        if (r124 == null) goto L359;
        if ((r101 instanceof HtmlBlock) == false) goto L135;
        HtmlBlock r125 = (HtmlBlock) r101;
    L136:
        if (r125 == null) goto L359;
        r102 = Intrinsics.areEqual(r124.f525768h, r125.f525768h);
        goto L360
    L135:
        r125 = null;
        goto L136
    L129:
        r124 = null;
        goto L130
    L139:
        boolean r126 = r100 instanceof Image;
        if (r126 == false) goto L157;
        if (r126 == false) goto L143;
        Image r127 = (Image) r100;
    L144:
        if (r127 == null) goto L359;
        if ((r101 instanceof Image) == false) goto L149;
        Image r128 = (Image) r101;
    L150:
        if (r128 == null) goto L359;
        if (Intrinsics.areEqual(r127.f525770h, r128.f525770h) == false) goto L359;
        if (Intrinsics.areEqual(r127.f525771i, r128.f525771i) == false) goto L359;
    L149:
        r128 = null;
        goto L150
    L143:
        r127 = null;
        goto L144
    L157:
        boolean r129 = r100 instanceof IndentedCodeBlock;
        if (r129 == false) goto L171;
        if (r129 == false) goto L161;
        IndentedCodeBlock r130 = (IndentedCodeBlock) r100;
    L162:
        if (r130 == null) goto L359;
        if ((r101 instanceof IndentedCodeBlock) == false) goto L167;
        IndentedCodeBlock r131 = (IndentedCodeBlock) r101;
    L168:
        if (r131 == null) goto L359;
        r102 = Intrinsics.areEqual(r130.f525772h, r131.f525772h);
        goto L360
    L167:
        r131 = null;
        goto L168
    L161:
        r130 = null;
        goto L162
    L171:
        boolean r132 = r100 instanceof Link;
        if (r132 == false) goto L190;
        if (r132 == false) goto L175;
        Link r133 = (Link) r100;
    L176:
        if (r133 == null) goto L359;
        if ((r101 instanceof Link) == false) goto L181;
        Link r134 = (Link) r101;
    L182:
        if (r134 == null) goto L359;
        if (Intrinsics.areEqual(r133.f525773h, r134.f525773h) == false) goto L359;
        if (Intrinsics.areEqual(r133.f525774i, r134.f525774i) == false) goto L359;
    L181:
        r134 = null;
        goto L182
    L175:
        r133 = null;
        goto L176
    L190:
        if ((r100 instanceof ListItem) == true) goto L358;
        boolean r135 = r100 instanceof OrderedList;
        if (r135 == false) goto L211;
        if (r135 == false) goto L196;
        OrderedList r136 = (OrderedList) r100;
    L197:
        if (r136 == null) goto L359;
        if ((r101 instanceof OrderedList) == false) goto L202;
        OrderedList r137 = (OrderedList) r101;
    L203:
        if (r137 == null) goto L359;
        if (r136.f525780j != r137.f525780j) goto L359;
        if (r136.f525781k != r137.f525781k) goto L359;
    L202:
        r137 = null;
        goto L203
    L196:
        r136 = null;
        goto L197
    L211:
        if ((r100 instanceof Paragraph) == true) goto L358;
        if ((r100 instanceof SoftLineBreak) == true) goto L358;
        boolean r138 = r100 instanceof StrongEmphasis;
        if (r138 == false) goto L230;
        if (r138 == false) goto L220;
        StrongEmphasis r139 = (StrongEmphasis) r100;
    L221:
        if (r139 == null) goto L359;
        if ((r101 instanceof StrongEmphasis) == false) goto L226;
        StrongEmphasis r140 = (StrongEmphasis) r101;
    L227:
        if (r140 == null) goto L359;
        r102 = Intrinsics.areEqual(r139.f525782h, r140.f525782h);
        goto L360
    L226:
        r140 = null;
        goto L227
    L220:
        r139 = null;
        goto L221
    L230:
        boolean r141 = r100 instanceof Text;
        if (r141 == false) goto L244;
        if (r141 == false) goto L234;
        Text r142 = (Text) r100;
    L235:
        if (r142 == null) goto L359;
        if ((r101 instanceof Text) == false) goto L240;
        Text r143 = (Text) r101;
    L241:
        if (r143 == null) goto L359;
        r102 = Intrinsics.areEqual(r142.f525783h, r143.f525783h);
        goto L360
    L240:
        r143 = null;
        goto L241
    L234:
        r142 = null;
        goto L235
    L244:
        boolean r144 = r100 instanceof LinkReferenceDefinition;
        if (r144 == false) goto L264;
        if (r144 == false) goto L248;
        LinkReferenceDefinition r145 = (LinkReferenceDefinition) r100;
    L249:
        if (r145 == null) goto L359;
        if ((r101 instanceof LinkReferenceDefinition) == false) goto L254;
        LinkReferenceDefinition r146 = (LinkReferenceDefinition) r101;
    L255:
        if (r146 == null) goto L359;
        if (Intrinsics.areEqual(r145.f525775h, r146.f525775h) == false) goto L359;
        if (Intrinsics.areEqual(r145.f525776i, r146.f525776i) == false) goto L359;
        if (Intrinsics.areEqual(r145.f525777j, r146.f525777j) == false) goto L359;
    L254:
        r146 = null;
        goto L255
    L248:
        r145 = null;
        goto L249
    L264:
        boolean r147 = r100 instanceof LatexMathBlock;
        if (r147 == false) goto L278;
        if (r147 == false) goto L268;
        LatexMathBlock r148 = (LatexMathBlock) r100;
    L269:
        if (r148 == null) goto L359;
        if ((r101 instanceof LatexMathBlock) == false) goto L274;
        LatexMathBlock r149 = (LatexMathBlock) r101;
    L275:
        if (r149 == null) goto L359;
        r102 = Intrinsics.areEqual(r148.f492652h, r149.f492652h);
        goto L360
    L274:
        r149 = null;
        goto L275
    L268:
        r148 = null;
        goto L269
    L278:
        boolean r150 = r100 instanceof TaskListItem;
        if (r150 == false) goto L295;
        if (r150 == false) goto L282;
        TaskListItem r151 = (TaskListItem) r100;
    L283:
        if (r151 == null) goto L359;
        if ((r101 instanceof TaskListItem) == false) goto L288;
        TaskListItem r152 = (TaskListItem) r101;
    L289:
        if (r152 == null) goto L359;
        if (r151.f492570h != r152.f492570h) goto L359;
    L288:
        r152 = null;
        goto L289
    L282:
        r151 = null;
        goto L283
    L295:
        if ((r100 instanceof TableBlock) == true) goto L358;
        boolean r153 = r100 instanceof LatexMathNode;
        if (r153 == false) goto L311;
        if (r153 == false) goto L301;
        LatexMathNode r154 = (LatexMathNode) r100;
    L302:
        if (r154 == null) goto L359;
        if ((r101 instanceof LatexMathNode) == false) goto L307;
        LatexMathNode r155 = (LatexMathNode) r101;
    L308:
        if (r155 == null) goto L359;
        r102 = Intrinsics.areEqual(r154.f492653h, r155.f492653h);
        goto L360
    L307:
        r155 = null;
        goto L308
    L301:
        r154 = null;
        goto L302
    L311:
        boolean r156 = r100 instanceof TableTitle;
        if (r156 == false) goto L330;
        if (r156 == false) goto L315;
        TableTitle r157 = (TableTitle) r100;
    L316:
        if (r157 == null) goto L359;
        if ((r101 instanceof TableTitle) == false) goto L321;
        TableTitle r158 = (TableTitle) r101;
    L322:
        if (r158 == null) goto L359;
        if (Intrinsics.areEqual(r157.f492503h, r158.f492503h) == false) goto L359;
        if (Intrinsics.areEqual(r157.f492504i, r158.f492504i) == false) goto L359;
    L321:
        r158 = null;
        goto L322
    L315:
        r157 = null;
        goto L316
    L330:
        if ((r100 instanceof Strikethrough) == true) goto L358;
        if ((r100 instanceof TableBody) == true) goto L358;
        boolean r159 = r100 instanceof TableCell;
        if (r159 == false) goto L354;
        if (r159 == false) goto L339;
        TableCell r160 = (TableCell) r100;
    L340:
        if (r160 == null) goto L359;
        if ((r101 instanceof TableCell) == false) goto L345;
        TableCell r161 = (TableCell) r101;
    L346:
        if (r161 == null) goto L359;
        if (r160.f525648h != r161.f525648h) goto L359;
        if (r160.f525649i != r161.f525649i) goto L359;
    L345:
        r161 = null;
        goto L346
    L339:
        r160 = null;
        goto L340
    L354:
        if ((r100 instanceof TableHead) == true) goto L358;
        if ((r100 instanceof TableRow) == false) goto L359;
    L358:
        r102 = true;
    L376:
        return false;
    }

    public static void d(uvc.b r100, uvc.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "sibling");
        h(r101);
        uvc.b r102 = r100.f551904e;
        r101.f551904e = r102;
        if (r102 == null) goto L5;
        r102.f551903d = r101;
    L5:
        r101.f551903d = r100;
        r100.f551904e = r101;
        uvc.b r103 = r100.f551900a;
        r101.f551900a = r103;
        if (r101.f551904e != null) goto L11;
        if (r103 == null) goto L12;
        r103.f551902c = r101;
        return;
    L12:
        return;
    }

    public static void e(uvc.b r100, uvc.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "sibling");
        h(r101);
        uvc.b r102 = r100.f551903d;
        r101.f551903d = r102;
        if (r102 == null) goto L5;
        r102.f551904e = r101;
    L5:
        r101.f551904e = r100;
        r100.f551903d = r101;
        uvc.b r103 = r100.f551900a;
        r101.f551900a = r103;
        if (r101.f551903d != null) goto L11;
        if (r103 == null) goto L12;
        r103.f551901b = r101;
        return;
    L12:
        return;
    }

    public static uvc.b f(uvc.b r100, Set r101) {
        Intrinsics.checkNotNullParameter(r101, "nodeList");
        uvc.b r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        r102 = null;
        if ((r100 instanceof HtmlBlock) == false) goto L8;
        HtmlBlock r103 = (HtmlBlock) r100;
        boolean r104 = StringsKt.startsWith$default(r103.f525768h, "<data-block", false, 2, null);
        uvc.b r105 = r103;
        if (r104 == false) goto L71;
    L6:
        r102 = r105;
    L71:
        if (r102 == null) goto L74;
        r101.add(r102);
        return r102.f551904e;
    L74:
        uvc.b r106 = r100.f551901b;
    L75:
        if (r106 == null) goto L78;
        r106 = f(r106, r101);
        goto L75
    L78:
        return r100.f551904e;
    L8:
        if ((r100 instanceof HtmlInline) == false) goto L49;
        HtmlInline r107 = (HtmlInline) r100;
        WidgetNode r108 = new WidgetNode();
        if (StringsKt.startsWith$default(r107.f525769h, "<data-block", false, 2, null) == false) goto L13;
        String r109 = "</data-block";
    L15:
        uvc.b r110 = r107;
    L16:
        if (r110 == null) goto L22;
        if ((r110 instanceof HtmlInline) == false) goto L21;
        if (StringsKt.startsWith$default(((HtmlInline) r110).f525769h, r109, false, 2, null) == true) goto L22;
    L21:
        ((ArrayList) r108.f320718h).add(r110);
        r110 = r110.f551904e;
    L22:
        if (r110 == null) goto L24;
        ((ArrayList) r108.f320718h).add(r110);
    L24:
        uvc.b r111 = r107.f551900a;
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(r108.f320718h), r111.f551901b) == false) goto L29;
        boolean r112 = Intrinsics.areEqual(CollectionsKt.lastOrNull(r108.f320718h), r111.f551902c);
        r105 = r111;
        if (r112 == true) goto L6;
    L29:
        uvc.b r113 = (uvc.b) CollectionsKt.firstOrNull(r108.f320718h);
        if (r113 == null) goto L32;
        uvc.b r114 = r113.f551903d;
    L33:
        uvc.b r115 = (uvc.b) CollectionsKt.lastOrNull(r108.f320718h);
        if (r115 == null) goto L36;
        uvc.b r116 = r115.f551904e;
    L37:
        Iterator r117 = ((ArrayList) r108.f320718h).iterator();
    L39:
        if (r117.hasNext() == false) goto L41;
        a(r108, (uvc.b) r117.next());
        goto L39
    L41:
        if (r114 == null) goto L44;
        if (r116 == null) goto L44;
        d(r114, r108);
    L48:
        r102 = r108;
    L44:
        if (r114 == null) goto L46;
        d(r114, r108);
        goto L48
    L46:
        if (r116 == null) goto L71;
        d(r116, r108);
        goto L48
    L36:
        r116 = null;
        goto L37
    L32:
        r114 = null;
        goto L33
    L13:
        if (StringsKt.startsWith$default(r107.f525769h, "<data-inline", false, 2, null) == false) goto L71;
        r109 = "</data-inline";
        goto L15
    L49:
        boolean r118 = true;
        if ((r100 instanceof Image) == false) goto L52;
        boolean r119 = true;
    L53:
        if (r119 == true) goto L56;
        r118 = r100 instanceof TableBlock;
    L56:
        if (r118 == false) goto L59;
        r102 = r100;
        goto L71
    L59:
        if ((r100 instanceof ListItem) == false) goto L71;
        ListItem r120 = (ListItem) r100;
        uvc.b r121 = r120.f551900a;
        if ((r121 instanceof OrderedList) == false) goto L63;
        OrderedList r122 = (OrderedList) r121;
    L64:
        if (r122 == null) goto L71;
        uvc.b r123 = r122.f551901b;
        int r124 = r122.f525779i;
    L66:
        if (r123 == null) goto L70;
        if (Intrinsics.areEqual(r123, r100) == true) goto L70;
        r124 = r124 + 1;
        r123 = r123.f551904e;
    L70:
        ((HashMap) r120.f551906g).put("order_number", Integer.valueOf(r124));
        goto L71
    L63:
        r122 = null;
        goto L64
    L52:
        r119 = r100 instanceof FencedCodeBlock;
        goto L53
    }
}
