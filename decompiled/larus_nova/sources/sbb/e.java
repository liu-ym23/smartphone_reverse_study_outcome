package sbb;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f541293d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f541294e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f541295f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f541296g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e f541297h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f541298i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e f541299j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final e f541300k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f541301l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final e f541302m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final e f541303n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final e f541304o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final e f541305p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e f541306q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final e f541307r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final e f541308s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final e f541309t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final e f541310u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e f541311v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final e f541312w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e f541313x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e f541314y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Integer[] f541315z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f541316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f541317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f541318c;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.f541316a, Integer.valueOf(this.f541317b)});
    }

    static {
        ArrayList r100 = new ArrayList();
        f541293d = r100;
        f541295f = new e(0, DocumentType.FOLDER_NAME, DocumentType.FOLDER_NAME);
        e r101 = new e(2, "doc", "doc");
        f541296g = r101;
        e r102 = new e(3, DocumentType.SHEET_NAME, DocumentType.SHEET_NAME);
        f541297h = r102;
        e r103 = new e(8, DocumentType.BITABLE_NAME, DocumentType.BITABLE_NAME);
        f541298i = r103;
        e r104 = new e(84, DocumentType.BASE_ADD_NAME, DocumentType.BASE_ADD_PATH_NAME);
        f541299j = r104;
        e r105 = new e(11, DocumentType.MINDNOTE_NAME, DocumentType.MINDNOTE_NAME);
        f541300k = r105;
        f541301l = new e(12, "file", "file");
        e r110 = new e(30, "slides", "slides");
        f541302m = r110;
        f541303n = new e(16, "wiki", "wiki");
        e r111 = new e(22, DocumentType.DOCX_NAME, DocumentType.DOCX_NAME);
        f541304o = r111;
        f541305p = new e(38, DocumentType.WIKI_FOLDER_NAME, DocumentType.WIKI_FOLDER_NAME);
        f541306q = new e(28, DocumentType.MINUTES_NAME, DocumentType.MINUTES_NAME);
        f541307r = new e(80, "form", "form");
        f541308s = new e(111, DocumentType.WIKI_FOLDER_NAME, DocumentType.WIKI_FOLDER_NAME);
        f541309t = new e(113, "miaodaCreative", "page");
        f541310u = new e(114, "miaodaApplication", "app");
        f541311v = new e(125, "doubao_conversation_sharing", "unknown");
        f541312w = new e(200, "open_platform", "open_platform");
        f541313x = new e(998, DocumentType.IM_FILE_NAME, DocumentType.IM_FILE_NAME);
        e r112 = new e(44, DocumentType.DOCX_SYNC_BLOCK_NAME, DocumentType.DOCX_SYNC_BLOCK_NAME);
        f541314y = r112;
        f541294e = new e(-1, "unknown", "unknown");
        r100.add(r101.getType());
        r100.add(r102.getType());
        r100.add(r105.getType());
        r100.add(r111.getType());
        r100.add(r103.getType());
        r100.add(r104.getType());
        r100.add(r110.getType());
        r100.add(r112.getType());
        f541315z = new Integer[]{2, 3, 8, 11, 12, 30, 16, 0, 22, 44};
    }

    public String getType() {
        return this.f541316a;
    }

    public final int h() {
        return this.f541317b;
    }

    public static String b(String r100) {
        String r101 = f541294e.f541318c;
        e r102 = f541296g;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L97;
        if (TextUtils.equals(r100, r102.f541318c) == true) goto L97;
        e r103 = f541297h;
        if (TextUtils.equals(r100, r103.getType()) == true) goto L113;
        if (TextUtils.equals(r100, r103.f541318c) == true) goto L113;
        e r104 = f541300k;
        if (TextUtils.equals(r100, r104.getType()) == true) goto L112;
        if (TextUtils.equals(r100, r104.f541318c) == true) goto L112;
        e r105 = f541298i;
        if (TextUtils.equals(r100, r105.getType()) == true) goto L111;
        if (TextUtils.equals(r100, r105.f541318c) == true) goto L111;
        e r106 = f541299j;
        if (TextUtils.equals(r100, r106.getType()) == true) goto L110;
        if (TextUtils.equals(r100, r106.f541318c) == true) goto L110;
        e r107 = f541301l;
        if (TextUtils.equals(r100, r107.getType()) == true) goto L109;
        if (TextUtils.equals(r100, r107.f541318c) == true) goto L109;
        e r108 = f541302m;
        if (TextUtils.equals(r100, r108.getType()) == true) goto L108;
        if (TextUtils.equals(r100, r108.f541318c) == true) goto L108;
        e r109 = f541295f;
        if (TextUtils.equals(r100, r109.getType()) == true) goto L107;
        if (TextUtils.equals(r100, r109.f541318c) == true) goto L107;
        e r110 = f541303n;
        if (TextUtils.equals(r100, r110.getType()) == true) goto L106;
        if (TextUtils.equals(r100, r110.f541318c) == true) goto L106;
        e r111 = f541304o;
        if (TextUtils.equals(r100, r111.getType()) == true) goto L105;
        if (TextUtils.equals(r100, r111.f541318c) == true) goto L105;
        e r112 = f541306q;
        if (TextUtils.equals(r100, r112.getType()) == true) goto L104;
        if (TextUtils.equals(r100, r112.f541318c) == true) goto L104;
        e r113 = f541309t;
        if (TextUtils.equals(r100, r113.getType()) == true) goto L103;
        if (TextUtils.equals(r100, r113.f541318c) == true) goto L103;
        e r114 = f541310u;
        if (TextUtils.equals(r100, r114.getType()) == true) goto L102;
        if (TextUtils.equals(r100, r114.f541318c) == true) goto L102;
        e r115 = f541312w;
        if (TextUtils.equals(r100, r115.getType()) == true) goto L101;
        if (TextUtils.equals(r100, r115.f541318c) == true) goto L101;
        e r116 = f541313x;
        if (TextUtils.equals(r100, r116.getType()) == true) goto L100;
        if (TextUtils.equals(r100, r116.f541318c) == true) goto L100;
        e r117 = f541314y;
        if (TextUtils.equals(r100, r117.getType()) == true) goto L99;
        if (TextUtils.equals(r100, r117.f541318c) == true) goto L99;
        return r101;
    L99:
        return r117.f541318c;
    L100:
        return r116.f541318c;
    L101:
        return r115.f541318c;
    L102:
        return r114.f541318c;
    L103:
        return r113.f541318c;
    L104:
        return r112.f541318c;
    L105:
        return r111.f541318c;
    L106:
        return r110.f541318c;
    L107:
        return r109.f541318c;
    L108:
        return r108.f541318c;
    L109:
        return r107.f541318c;
    L110:
        return r106.f541318c;
    L111:
        return r105.f541318c;
    L112:
        return r104.f541318c;
    L113:
        return r103.f541318c;
    L97:
        return r102.f541318c;
    }

    public static String c(int r100) {
        if (r100 != f541301l.f541317b) goto L7;
        return "drive";
    L7:
        return f(r100);
    }

    public static e d(int r100) {
        e r101 = f541296g;
        if (r100 != r101.f541317b) goto L5;
        return r101;
    L5:
        e r102 = f541295f;
        if (r100 != r102.f541317b) goto L8;
        return r102;
    L8:
        e r103 = f541297h;
        if (r100 != r103.f541317b) goto L11;
        return r103;
    L11:
        e r104 = f541298i;
        if (r100 != r104.f541317b) goto L14;
        return r104;
    L14:
        e r105 = f541299j;
        if (r100 != r105.f541317b) goto L17;
        return r105;
    L17:
        e r106 = f541300k;
        if (r100 != r106.f541317b) goto L20;
        return r106;
    L20:
        e r107 = f541301l;
        if (r100 != r107.f541317b) goto L23;
        return r107;
    L23:
        e r108 = f541302m;
        if (r100 != r108.f541317b) goto L26;
        return r108;
    L26:
        e r109 = f541303n;
        if (r100 != r109.f541317b) goto L29;
        return r109;
    L29:
        e r110 = f541304o;
        if (r100 != r110.f541317b) goto L32;
        return r110;
    L32:
        e r111 = f541306q;
        if (r100 != r111.f541317b) goto L35;
        return r111;
    L35:
        e r112 = f541307r;
        if (r100 != r112.f541317b) goto L38;
        return r112;
    L38:
        e r113 = f541309t;
        if (r100 != r113.f541317b) goto L41;
        return r113;
    L41:
        e r114 = f541310u;
        if (r100 != r114.f541317b) goto L44;
        return r114;
    L44:
        e r115 = f541311v;
        if (r100 != r115.f541317b) goto L47;
        return r115;
    L47:
        e r116 = f541312w;
        if (r100 != r116.f541317b) goto L50;
        return r116;
    L50:
        e r117 = f541313x;
        if (r100 != r117.f541317b) goto L53;
        return r117;
    L53:
        e r118 = f541314y;
        if (r100 != r118.f541317b) goto L57;
        return r118;
    L57:
        return f541294e;
    }

    public static e e(String r100) {
        e r101 = f541294e;
        e r102 = f541296g;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541297h;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541300k;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541298i;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541299j;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541301l;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541302m;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541295f;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541303n;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541304o;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541306q;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541307r;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541309t;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541310u;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541311v;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541312w;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541313x;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        r102 = f541314y;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L56;
        return r101;
    L56:
        return r102;
    }

    public static String f(int r100) {
        e r101 = f541296g;
        if (r100 == r101.f541317b) goto L5;
        e r102 = f541295f;
        if (r100 == r102.f541317b) goto L9;
        e r103 = f541297h;
        if (r100 == r103.f541317b) goto L13;
        e r104 = f541298i;
        if (r100 == r104.f541317b) goto L17;
        e r105 = f541300k;
        if (r100 == r105.f541317b) goto L21;
        e r106 = f541301l;
        if (r100 == r106.f541317b) goto L25;
        e r107 = f541302m;
        if (r100 == r107.f541317b) goto L29;
        e r108 = f541303n;
        if (r100 == r108.f541317b) goto L33;
        e r109 = f541304o;
        if (r100 == r109.f541317b) goto L37;
        e r110 = f541306q;
        if (r100 == r110.f541317b) goto L41;
        e r111 = f541307r;
        if (r100 == r111.f541317b) goto L45;
        e r112 = f541309t;
        if (r100 == r112.f541317b) goto L49;
        e r113 = f541310u;
        if (r100 == r113.f541317b) goto L53;
        e r114 = f541311v;
        if (r100 == r114.f541317b) goto L57;
        e r115 = f541312w;
        if (r100 == r115.f541317b) goto L61;
        e r116 = f541313x;
        if (r100 != r116.f541317b) goto L67;
        return r116.getType();
    L67:
        if (r100 == 44) goto L69;
        e r117 = f541308s;
        if (r100 != r117.f541317b) goto L75;
        return r117.getType();
    L75:
        return f541294e.getType();
    L69:
        return f541314y.getType();
    L61:
        return r115.getType();
    L57:
        return r114.getType();
    L53:
        return r113.getType();
    L49:
        return r112.getType();
    L45:
        return r111.getType();
    L41:
        return r110.getType();
    L37:
        return r109.getType();
    L33:
        return r108.getType();
    L29:
        return r107.getType();
    L25:
        return r106.getType();
    L21:
        return r105.getType();
    L17:
        return r104.getType();
    L13:
        return r103.getType();
    L9:
        return r102.getType();
    L5:
        return r101.getType();
    }

    public static int g(String r100) {
        int r101 = f541294e.f541317b;
        e r102 = f541296g;
        if (TextUtils.equals(r100, r102.getType()) == true) goto L57;
        e r103 = f541297h;
        if (TextUtils.equals(r100, r103.getType()) == true) goto L58;
        e r104 = f541300k;
        if (TextUtils.equals(r100, r104.getType()) == true) goto L59;
        e r105 = f541298i;
        if (TextUtils.equals(r100, r105.getType()) == true) goto L60;
        e r106 = f541299j;
        if (TextUtils.equals(r100, r106.getType()) == true) goto L61;
        e r107 = f541301l;
        if (TextUtils.equals(r100, r107.getType()) == true) goto L62;
        e r108 = f541302m;
        if (TextUtils.equals(r100, r108.getType()) == true) goto L63;
        e r109 = f541295f;
        if (TextUtils.equals(r100, r109.getType()) == true) goto L64;
        e r110 = f541303n;
        if (TextUtils.equals(r100, r110.getType()) == true) goto L65;
        e r111 = f541304o;
        if (TextUtils.equals(r100, r111.getType()) == true) goto L66;
        e r112 = f541306q;
        if (TextUtils.equals(r100, r112.getType()) == true) goto L67;
        e r113 = f541307r;
        if (TextUtils.equals(r100, r113.getType()) == true) goto L68;
        e r114 = f541309t;
        if (TextUtils.equals(r100, r114.getType()) == true) goto L69;
        e r115 = f541310u;
        if (TextUtils.equals(r100, r115.getType()) == true) goto L70;
        e r116 = f541311v;
        if (TextUtils.equals(r100, r116.getType()) == true) goto L71;
        e r117 = f541312w;
        if (TextUtils.equals(r100, r117.getType()) == true) goto L72;
        e r118 = f541313x;
        if (TextUtils.equals(r100, r118.getType()) == true) goto L73;
        e r119 = f541314y;
        if (TextUtils.equals(r100, r119.getType()) == true) goto L56;
        return r101;
    L56:
        return r119.f541317b;
    L73:
        return r118.f541317b;
    L72:
        return r117.f541317b;
    L71:
        return r116.f541317b;
    L70:
        return r115.f541317b;
    L69:
        return r114.f541317b;
    L68:
        return r113.f541317b;
    L67:
        return r112.f541317b;
    L66:
        return r111.f541317b;
    L65:
        return r110.f541317b;
    L64:
        return r109.f541317b;
    L63:
        return r108.f541317b;
    L62:
        return r107.f541317b;
    L61:
        return r106.f541317b;
    L60:
        return r105.f541317b;
    L59:
        return r104.f541317b;
    L58:
        return r103.f541317b;
    L57:
        return r102.f541317b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (e.class != r100.getClass()) goto L17;
        e r101 = (e) r100;
        if (this.f541317b == r101.f541317b) goto L13;
    L15:
        return false;
    L13:
        if (Objects.equals(this.f541316a, r101.f541316a) == false) goto L15;
        return true;
    }

    public static String a(Context r100, int r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r101 != f541296g.f541317b) goto L10;
        return r100.getResources().getString(R.string.Doc_List_UntitledDocument);
    L10:
        if (r101 != f541297h.f541317b) goto L14;
        return r100.getResources().getString(R.string.Doc_List_UntitledSheet);
    L14:
        if (r101 != f541298i.f541317b) goto L18;
        return r100.getResources().getString(R.string.Doc_List_UntitledBitable);
    L18:
        if (r101 != f541299j.f541317b) goto L22;
        return r100.getResources().getString(R.string.Doc_List_UntitledBitable);
    L22:
        if (r101 != f541300k.f541317b) goto L26;
        return r100.getResources().getString(R.string.Doc_List_UntitledMindnote);
    L26:
        if (r101 != f541301l.f541317b) goto L30;
        return r100.getResources().getString(R.string.Doc_List_UntitledFile);
    L30:
        if (r101 != f541302m.f541317b) goto L34;
        return r100.getResources().getString(R.string.LarkCCM_Slides_Untitled);
    L34:
        if (r101 == f541295f.f541317b) goto L41;
        if (r101 == 111) goto L41;
        return r100.getResources().getString(R.string.Doc_List_UntitledDocument);
    L41:
        return r100.getResources().getString(R.string.CreationMobile_Common_UntitledFolder);
    }

    public e(int r100, String r101, String r102) {
        this.f541317b = r100;
        this.f541316a = r101;
        this.f541318c = r102;
    }
}
