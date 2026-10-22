package io.noties.markwon.ext.tables;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.trace.CopyContentTypeString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Block;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes41.dex */
public final class e extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TableBlock f492509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CharSequence> f492510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TableCell.Alignment> f492511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f492512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TableTitle f492513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StringBuilder f492514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f492515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f492516h;

    /* JADX INFO: loaded from: classes5.dex */
    public static class a extends wvc.b {
        public a() {
        }
    }

    @Override // wvc.a, wvc.d
    public final void c() {
        TableTitle r100 = this.f492513e;
        r100.f492503h = CopyContentTypeString.TABLE;
        r100.f492504i = this.f492514f.toString();
    }

    @Override // wvc.d
    public final Block a() {
        return this.f492509a;
    }

    public static List<TableCell.Alignment> j(CharSequence r110) {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        boolean r102 = false;
    L3:
        int r103 = 0;
    L4:
        TableCell.Alignment r104 = null;
        if (r101 >= r110.length()) goto L50;
        char r105 = r110.charAt(r101);
        if (r105 == '\t') goto L49;
        if (r105 == ' ') goto L49;
        boolean r106 = true;
        if (r105 == '-') goto L20;
        if (r105 == ':') goto L20;
        if (r105 != '|') goto L15;
        r101 = r101 + 1;
        r103 = r103 + 1;
        if (r103 > 1) goto L18;
        r102 = true;
        goto L4
    L18:
        return null;
    L15:
        return null;
    L20:
        if (r103 == 0) goto L22;
    L24:
        if (r105 != ':') goto L26;
        r101 = r101 + 1;
        boolean r107 = true;
    L27:
        boolean r108 = false;
    L29:
        if (r101 >= r110.length()) goto L33;
        if (r110.charAt(r101) != '-') goto L33;
        r101 = r101 + 1;
        r108 = true;
    L33:
        if (r108 == false) goto L34;
        if (r101 < r110.length()) goto L38;
    L40:
        r106 = false;
    L41:
        if (r107 == false) goto L44;
        if (r106 == false) goto L44;
        r104 = TableCell.Alignment.CENTER;
    L48:
        r100.add(r104);
    L44:
        if (r107 == false) goto L46;
        r104 = TableCell.Alignment.LEFT;
        goto L48
    L46:
        if (r106 == false) goto L48;
        r104 = TableCell.Alignment.RIGHT;
        goto L48
    L38:
        if (r110.charAt(r101) != ':') goto L40;
        r101 = r101 + 1;
        goto L41
    L34:
        return null;
    L26:
        r107 = false;
        goto L27
    L22:
        if (r100.isEmpty() == true) goto L24;
        return null;
    L49:
        r101 = r101 + 1;
        goto L4
    L50:
        if (r102 == true) goto L52;
        return null;
    L52:
        return r100;
    }

    public static List<String> k(CharSequence r100) {
        String r101 = r100.toString().trim();
        if (r101.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) == false) goto L5;
        r101 = r101.substring(1);
    L5:
        ArrayList r102 = new ArrayList();
        StringBuilder r103 = new StringBuilder();
        int r104 = 0;
    L7:
        if (r104 >= r101.length()) goto L21;
        char r105 = r101.charAt(r104);
        if (r105 == '\\') goto L13;
        if (r105 == '|') goto L12;
        r103.append(r105);
    L19:
        r104 = r104 + 1;
        goto L7
    L12:
        r102.add(r103.toString());
        r103.setLength(0);
        goto L19
    L13:
        int r106 = r104 + 1;
        if (r106 < r101.length()) goto L16;
    L18:
        r103.append('\\');
        goto L19
    L16:
        if (r101.charAt(r106) != '|') goto L18;
        r103.append('|');
        r104 = r106;
        goto L19
    L21:
        if (r103.length() <= 0) goto L23;
        r102.add(r103.toString());
    L23:
        return r102;
    }

    @Override // wvc.a, wvc.d
    public final void d(CharSequence r100) {
        if (this.f492516h == false) goto L5;
        this.f492516h = false;
    L6:
        this.f492514f.append(r100);
        this.f492514f.append("\n");
        return;
    L5:
        this.f492510b.add(r100);
        goto L6
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        org.commonmark.internal.h r101 = (org.commonmark.internal.h) r100;
        if (r101.f525690a.toString().contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) == true) goto L5;
        return null;
    L5:
        return wvc.c.a(r101.f525691b);
    }

    @Override // wvc.a, wvc.d
    public final void g(vvc.a r110) {
        StringBuilder r100 = new StringBuilder();
        int r101 = this.f492512d.size();
        this.f492509a.b(this.f492513e);
        TableHead r102 = new TableHead();
        this.f492509a.b(r102);
        TableRow r103 = new TableRow();
        r102.b(r103);
        int r104 = 0;
    L4:
        if (r104 >= r101) goto L9;
        TableCell r105 = i((String) ListProtector.get(this.f492512d, r104), r104, r110);
        r105.f525648h = true;
        r103.b(r105);
        if (this.f492515g.booleanValue() == false) goto L8;
        h(r105, r100);
        r100.append('\t');
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        Iterator r106 = ((ArrayList) this.f492510b).iterator();
        TableBody r107 = null;
    L11:
        if (r106.hasNext() == false) goto L29;
        CharSequence r108 = (CharSequence) r106.next();
        if (this.f492515g.booleanValue() == false) goto L15;
        r100.append('\n');
    L15:
        List<String> r109 = k(r108);
        TableRow r111 = new TableRow();
        int r112 = 0;
    L16:
        if (r112 >= r101) goto L25;
        if (r112 >= ((ArrayList) r109).size()) goto L20;
        String r113 = (String) ListProtector.get(r109, r112);
    L21:
        TableCell r114 = i(r113, r112, r110);
        r111.b(r114);
        if (this.f492515g.booleanValue() == false) goto L24;
        h(r114, r100);
        r100.append('\t');
    L24:
        r112 = r112 + 1;
        goto L16
    L20:
        r113 = "";
        goto L21
    L25:
        if (r107 != null) goto L27;
        r107 = new TableBody();
        this.f492509a.b(r107);
    L27:
        r107.b(r111);
        goto L11
    L29:
        if (this.f492515g.booleanValue() == false) goto L41;
        TableTitle r115 = this.f492513e;
        r115.f492505j = r100.toString();
        return;
    }

    public e(List<TableCell.Alignment> r100, List<String> r101) {
        this.f492509a = new TableBlock();
        this.f492510b = new ArrayList();
        this.f492513e = new TableTitle();
        this.f492514f = new StringBuilder();
        this.f492515g = Boolean.FALSE;
        this.f492516h = true;
        this.f492511c = r100;
        this.f492512d = r101;
    }

    public static uvc.b h(uvc.b r100, StringBuilder r101) {
        if ((r100 instanceof Text) == false) goto L6;
        r101.append(((Text) r100).f525783h);
        return r100.f551904e;
    L6:
        uvc.b r102 = r100.f551901b;
    L7:
        if (r102 == null) goto L10;
        r102 = h(r102, r101);
        goto L7
    L10:
        return r100.f551904e;
    }

    public final TableCell i(String r100, int r101, vvc.a r102) {
        TableCell r103 = new TableCell();
        if (r101 >= this.f492511c.size()) goto L5;
        r103.f525649i = (TableCell.Alignment) ListProtector.get(this.f492511c, r101);
    L5:
        r102.a(r100.trim(), r103);
        return r103;
    }

    public e(List<TableCell.Alignment> r100, List<String> r101, String r102, boolean r103) {
        this.f492509a = new TableBlock();
        this.f492510b = new ArrayList();
        this.f492513e = new TableTitle();
        StringBuilder r104 = new StringBuilder();
        this.f492514f = r104;
        this.f492515g = Boolean.FALSE;
        this.f492516h = true;
        this.f492511c = r100;
        this.f492512d = r101;
        r104.append(r102);
        r104.append("\n");
        this.f492515g = Boolean.valueOf(r103);
    }
}
