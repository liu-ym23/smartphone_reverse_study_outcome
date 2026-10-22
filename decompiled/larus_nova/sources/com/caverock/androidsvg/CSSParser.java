package com.caverock.androidsvg;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes22.dex */
public final class CSSParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaType f272714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Source f272715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f272716c;

    public static final enum AttribOp extends Enum<AttribOp> {
        public static final AttribOp DASHMATCH = null;
        public static final AttribOp EQUALS = null;
        public static final AttribOp EXISTS = null;
        public static final AttribOp INCLUDES = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AttribOp[] f272717a = null;

        static {
            AttribOp r100 = new AttribOp("EXISTS", 0);
            EXISTS = r100;
            AttribOp r101 = new AttribOp("EQUALS", 1);
            EQUALS = r101;
            AttribOp r102 = new AttribOp("INCLUDES", 2);
            INCLUDES = r102;
            AttribOp r103 = new AttribOp("DASHMATCH", 3);
            DASHMATCH = r103;
            f272717a = new AttribOp[]{r100, r101, r102, r103};
        }

        public static AttribOp[] values() {
            return (AttribOp[]) f272717a.clone();
        }

        public static AttribOp valueOf(String r100) {
            return (AttribOp) r27.a.a(AttribOp.class, r100);
        }

        public AttribOp(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Combinator extends Enum<Combinator> {
        public static final Combinator CHILD = null;
        public static final Combinator DESCENDANT = null;
        public static final Combinator FOLLOWS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Combinator[] f272718a = null;

        static {
            Combinator r100 = new Combinator("DESCENDANT", 0);
            DESCENDANT = r100;
            Combinator r101 = new Combinator("CHILD", 1);
            CHILD = r101;
            Combinator r102 = new Combinator("FOLLOWS", 2);
            FOLLOWS = r102;
            f272718a = new Combinator[]{r100, r101, r102};
        }

        public static Combinator[] values() {
            return (Combinator[]) f272718a.clone();
        }

        public static Combinator valueOf(String r100) {
            return (Combinator) r27.a.a(Combinator.class, r100);
        }

        public Combinator(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum MediaType extends Enum<MediaType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MediaType[] f272719a = null;
        public static final MediaType all = null;
        public static final MediaType aural = null;
        public static final MediaType braille = null;
        public static final MediaType embossed = null;
        public static final MediaType handheld = null;
        public static final MediaType print = null;
        public static final MediaType projection = null;
        public static final MediaType screen = null;
        public static final MediaType speech = null;
        public static final MediaType tty = null;

        /* JADX INFO: renamed from: tv, reason: collision with root package name */
        public static final MediaType f272720tv = null;

        static {
            MediaType r100 = new MediaType("all", 0);
            all = r100;
            MediaType r101 = new MediaType("aural", 1);
            aural = r101;
            MediaType r102 = new MediaType("braille", 2);
            braille = r102;
            MediaType r103 = new MediaType("embossed", 3);
            embossed = r103;
            MediaType r104 = new MediaType("handheld", 4);
            handheld = r104;
            MediaType r105 = new MediaType("print", 5);
            print = r105;
            MediaType r110 = new MediaType("projection", 6);
            projection = r110;
            MediaType r111 = new MediaType("screen", 7);
            screen = r111;
            MediaType r112 = new MediaType("speech", 8);
            speech = r112;
            MediaType r113 = new MediaType("tty", 9);
            tty = r113;
            MediaType r114 = new MediaType(CommonCmd.AIDL_PLATFORM_TYPE_TV, 10);
            f272720tv = r114;
            f272719a = new MediaType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static MediaType[] values() {
            return (MediaType[]) f272719a.clone();
        }

        public static MediaType valueOf(String r100) {
            return (MediaType) r27.a.a(MediaType.class, r100);
        }

        public MediaType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PseudoClassIdents extends Enum<PseudoClassIdents> {
        public static final PseudoClassIdents UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Map<String, PseudoClassIdents> f272721a = null;
        public static final PseudoClassIdents active = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ PseudoClassIdents[] f272722b = null;
        public static final PseudoClassIdents checked = null;
        public static final PseudoClassIdents disabled = null;
        public static final PseudoClassIdents empty = null;
        public static final PseudoClassIdents enabled = null;
        public static final PseudoClassIdents first_child = null;
        public static final PseudoClassIdents first_of_type = null;
        public static final PseudoClassIdents focus = null;
        public static final PseudoClassIdents hover = null;
        public static final PseudoClassIdents indeterminate = null;
        public static final PseudoClassIdents lang = null;
        public static final PseudoClassIdents last_child = null;
        public static final PseudoClassIdents last_of_type = null;
        public static final PseudoClassIdents link = null;
        public static final PseudoClassIdents not = null;
        public static final PseudoClassIdents nth_child = null;
        public static final PseudoClassIdents nth_last_child = null;
        public static final PseudoClassIdents nth_last_of_type = null;
        public static final PseudoClassIdents nth_of_type = null;
        public static final PseudoClassIdents only_child = null;
        public static final PseudoClassIdents only_of_type = null;
        public static final PseudoClassIdents root = null;
        public static final PseudoClassIdents target = null;
        public static final PseudoClassIdents visited = null;

        static {
            PseudoClassIdents r100 = new PseudoClassIdents(PickerReporterConstants.KEY.TARGET, 0);
            target = r100;
            PseudoClassIdents r101 = new PseudoClassIdents(RootDescription.ROOT_ELEMENT, 1);
            root = r101;
            PseudoClassIdents r102 = new PseudoClassIdents("nth_child", 2);
            nth_child = r102;
            PseudoClassIdents r103 = new PseudoClassIdents("nth_last_child", 3);
            nth_last_child = r103;
            PseudoClassIdents r104 = new PseudoClassIdents("nth_of_type", 4);
            nth_of_type = r104;
            PseudoClassIdents r105 = new PseudoClassIdents("nth_last_of_type", 5);
            nth_last_of_type = r105;
            PseudoClassIdents r110 = new PseudoClassIdents("first_child", 6);
            first_child = r110;
            PseudoClassIdents r111 = new PseudoClassIdents("last_child", 7);
            last_child = r111;
            PseudoClassIdents r112 = new PseudoClassIdents("first_of_type", 8);
            first_of_type = r112;
            PseudoClassIdents r113 = new PseudoClassIdents("last_of_type", 9);
            last_of_type = r113;
            PseudoClassIdents r114 = new PseudoClassIdents("only_child", 10);
            only_child = r114;
            PseudoClassIdents r115 = new PseudoClassIdents("only_of_type", 11);
            only_of_type = r115;
            PseudoClassIdents r106 = new PseudoClassIdents("empty", 12);
            empty = r106;
            PseudoClassIdents r107 = new PseudoClassIdents("not", 13);
            not = r107;
            PseudoClassIdents r108 = new PseudoClassIdents(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, 14);
            lang = r108;
            PseudoClassIdents r109 = new PseudoClassIdents("link", 15);
            link = r109;
            PseudoClassIdents r116 = new PseudoClassIdents("visited", 16);
            visited = r116;
            PseudoClassIdents r117 = new PseudoClassIdents("hover", 17);
            hover = r117;
            PseudoClassIdents r118 = new PseudoClassIdents("active", 18);
            active = r118;
            PseudoClassIdents r119 = new PseudoClassIdents(ButtonColorBean.StateFocus, 19);
            focus = r119;
            PseudoClassIdents r120 = new PseudoClassIdents("enabled", 20);
            enabled = r120;
            PseudoClassIdents r121 = new PseudoClassIdents("disabled", 21);
            disabled = r121;
            PseudoClassIdents r122 = new PseudoClassIdents("checked", 22);
            checked = r122;
            PseudoClassIdents r123 = new PseudoClassIdents("indeterminate", 23);
            indeterminate = r123;
            PseudoClassIdents r124 = new PseudoClassIdents("UNSUPPORTED", 24);
            UNSUPPORTED = r124;
            f272722b = new PseudoClassIdents[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124};
            f272721a = new HashMap();
            PseudoClassIdents[] r125 = values();
            int r126 = r125.length;
            int r127 = 0;
        L3:
            if (r127 >= r126) goto L8;
            PseudoClassIdents r128 = r125[r127];
            if (r128 == UNSUPPORTED) goto L7;
            f272721a.put(r128.name().replace('_', '-'), r128);
        L7:
            r127 = r127 + 1;
            goto L3
        }

        public static PseudoClassIdents[] values() {
            return (PseudoClassIdents[]) f272722b.clone();
        }

        public static PseudoClassIdents fromString(String r100) {
            PseudoClassIdents r101 = (PseudoClassIdents) ((HashMap) f272721a).get(r100);
            if (r101 == null) goto L6;
            return r101;
        L6:
            return UNSUPPORTED;
        }

        public static PseudoClassIdents valueOf(String r100) {
            return (PseudoClassIdents) r27.a.a(PseudoClassIdents.class, r100);
        }

        public PseudoClassIdents(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> {
        public static final Source Document = null;
        public static final Source RenderOptions = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f272723a = null;

        static {
            Source r100 = new Source("Document", 0);
            Document = r100;
            Source r101 = new Source("RenderOptions", 1);
            RenderOptions = r101;
            f272723a = new Source[]{r100, r101};
        }

        public static Source[] values() {
            return (Source[]) f272723a.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272724a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f272725b = null;

        static {
            int[] r100 = new int[PseudoClassIdents.values().length];
            f272725b = r100;
            r100[PseudoClassIdents.first_child.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L77:
            f272725b[PseudoClassIdents.last_child.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L91:
            f272725b[PseudoClassIdents.only_child.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L99:
            f272725b[PseudoClassIdents.first_of_type.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L103:
            f272725b[PseudoClassIdents.last_of_type.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L65:
            f272725b[PseudoClassIdents.only_of_type.ordinal()] = 6;     // Catch: NoSuchFieldError -> L39
        L69:
            f272725b[PseudoClassIdents.root.ordinal()] = 7;     // Catch: NoSuchFieldError -> L40
        L85:
            f272725b[PseudoClassIdents.empty.ordinal()] = 8;     // Catch: NoSuchFieldError -> L41
        L87:
            f272725b[PseudoClassIdents.nth_child.ordinal()] = 9;     // Catch: NoSuchFieldError -> L42
        L105:
            f272725b[PseudoClassIdents.nth_last_child.ordinal()] = 10;     // Catch: NoSuchFieldError -> L43
        L109:
            f272725b[PseudoClassIdents.nth_of_type.ordinal()] = 11;     // Catch: NoSuchFieldError -> L44
        L71:
            f272725b[PseudoClassIdents.nth_last_of_type.ordinal()] = 12;     // Catch: NoSuchFieldError -> L45
        L75:
            f272725b[PseudoClassIdents.not.ordinal()] = 13;     // Catch: NoSuchFieldError -> L46
        L89:
            f272725b[PseudoClassIdents.target.ordinal()] = 14;     // Catch: NoSuchFieldError -> L47
        L93:
            f272725b[PseudoClassIdents.lang.ordinal()] = 15;     // Catch: NoSuchFieldError -> L48
        L113:
            f272725b[PseudoClassIdents.link.ordinal()] = 16;     // Catch: NoSuchFieldError -> L49
        L61:
            f272725b[PseudoClassIdents.visited.ordinal()] = 17;     // Catch: NoSuchFieldError -> L50
        L79:
            f272725b[PseudoClassIdents.hover.ordinal()] = 18;     // Catch: NoSuchFieldError -> L51
        L81:
            f272725b[PseudoClassIdents.active.ordinal()] = 19;     // Catch: NoSuchFieldError -> L52
        L95:
            f272725b[PseudoClassIdents.focus.ordinal()] = 20;     // Catch: NoSuchFieldError -> L53
        L101:
            f272725b[PseudoClassIdents.enabled.ordinal()] = 21;     // Catch: NoSuchFieldError -> L54
        L63:
            f272725b[PseudoClassIdents.disabled.ordinal()] = 22;     // Catch: NoSuchFieldError -> L55
        L67:
            f272725b[PseudoClassIdents.checked.ordinal()] = 23;     // Catch: NoSuchFieldError -> L56
        L83:
            f272725b[PseudoClassIdents.indeterminate.ordinal()] = 24;     // Catch: NoSuchFieldError -> L57
        L29:
            int[] r101 = new int[AttribOp.values().length];
            f272724a = r101;
            r101[AttribOp.EQUALS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L107:
            f272724a[AttribOp.INCLUDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L111:
            f272724a[AttribOp.DASHMATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f272726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AttribOp f272727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f272728c;

        public b(String r100, AttribOp r101, String r102) {
            this.f272726a = r100;
            this.f272727b = r101;
            this.f272728c = r102;
        }
    }

    public static class c extends SVGParser.g {

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f272729a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f272730b;

            public a(int r100, int r101) {
                this.f272729a = r100;
                this.f272730b = r101;
            }
        }

        public static int r(int r100) {
            if (r100 >= 48) goto L5;
        L8:
            int r101 = 65;
            if (r100 >= 65) goto L11;
        L13:
            r101 = 97;
            if (r100 >= 97) goto L16;
            return -1;
        L16:
            if (r100 <= 102) goto L18;
            return -1;
        L18:
            return (r100 - r101) + 10;
        L11:
            if (r100 > 70) goto L13;
        L5:
            if (r100 > 57) goto L8;
            return r100 - 48;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v12, types: [com.caverock.androidsvg.CSSParser$AttribOp] */
        /* JADX WARN: Type inference failed for: r12v40 */
        /* JADX WARN: Type inference failed for: r12v41 */
        /* JADX WARN: Type inference failed for: r12v42, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r12v45 */
        /* JADX WARN: Type inference failed for: r12v46 */
        /* JADX WARN: Type inference failed for: r12v50 */
        /* JADX WARN: Type inference failed for: r12v51 */
        /* JADX WARN: Type inference failed for: r7v13 */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4, types: [com.caverock.androidsvg.CSSParser$Combinator] */
        /* JADX WARN: Type inference failed for: r9v10, types: [com.caverock.androidsvg.CSSParser$o] */
        /* JADX WARN: Type inference failed for: r9v11 */
        /* JADX WARN: Type inference failed for: r9v12, types: [com.caverock.androidsvg.CSSParser$o] */
        /* JADX WARN: Type inference failed for: r9v13, types: [com.caverock.androidsvg.CSSParser$o] */
        /* JADX WARN: Type inference failed for: r9v14, types: [com.caverock.androidsvg.CSSParser$o] */
        /* JADX WARN: Type inference failed for: r9v15, types: [com.caverock.androidsvg.CSSParser$o] */
        /* JADX WARN: Type inference failed for: r9v16, types: [com.caverock.androidsvg.CSSParser$o] */
        /* JADX WARN: Type inference failed for: r9v19 */
        /* JADX WARN: Type inference failed for: r9v20 */
        /* JADX WARN: Type inference failed for: r9v21 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7 */
        /* JADX WARN: Type inference failed for: r9v8, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v9, types: [com.caverock.androidsvg.CSSParser$o] */
        public final List<n> u() throws CSSParseException {
            String r100 = null;
            if (f() == false) goto L5;
            return null;
        L5:
            int r101 = 1;
            ArrayList r102 = new ArrayList(1);
            n r103 = new n();
        L6:
            int r104 = 0;
            if (f() == true) goto L271;
            if (f() == false) goto L11;
            String r105 = r100;
            boolean r106 = false;
        L264:
            if (r106 == false) goto L271;
            if (p() == false) goto L269;
            r102.add(r103);
            r103 = new n();
        L269:
            r100 = r105;
            r101 = 1;
            goto L6
        L11:
            int r107 = this.f272976b;
            List<o> r108 = r103.f272744a;
            if (r108 != null) goto L14;
        L17:
            boolean r109 = true;
        L19:
            if (r109 == false) goto L21;
        L26:
            ?? r110 = r100;
        L28:
            if (d('*') == false) goto L30;
            ?? r111 = new o(r110, r100);
        L35:
            if (f() == true) goto L257;
            if (d('.') == true) goto L38;
            if (d('#') == true) goto L47;
            if (d('[') == true) goto L56;
            r111 = r111;
            if (d(':') == false) goto L257;
            if (r111 != 0) goto L96;
            r111 = new o(r110, r100);
        L96:
            String r112 = t();
            if (r112 == null) goto L256;
            PseudoClassIdents r113 = PseudoClassIdents.fromString(r112);
            String r114 = "Invalid or missing parameter section for pseudo class: ";
            switch(a.f272725b[r113.ordinal()]) {
                case 1: goto L250;
                case 2: goto L249;
                case 3: goto L248;
                case 4: goto L245;
                case 5: goto L244;
                case 6: goto L243;
                case 7: goto L241;
                case 8: goto L239;
                case 9: goto L165;
                case 10: goto L165;
                case 11: goto L165;
                case 12: goto L165;
                case 13: goto L124;
                case 14: goto L122;
                case 15: goto L104;
                case 16: goto L102;
                case 17: goto L102;
                case 18: goto L102;
                case 19: goto L102;
                case 20: goto L102;
                case 21: goto L102;
                case 22: goto L102;
                case 23: goto L102;
                case 24: goto L102;
                default: goto L101;
            };
        L102:
            Object r115 = new h(r112);
            r103.a();
        L240:
            String r116 = null;
        L252:
            if (r111.f272749d != null) goto L254;
            r111.f272749d = new ArrayList();
        L254:
            ((ArrayList) r111.f272749d).add(r115);
            r100 = r116;
            r101 = 1;
            r104 = 0;
            goto L35
        L122:
            r115 = new k();
            r103.a();
            goto L240
        L239:
            r115 = new f();
            r103.a();
            goto L240
        L241:
            Object r117 = new j();
            r103.a();
        L242:
            r115 = r117;
        L247:
            r116 = null;
            goto L252
        L243:
            Object r118 = new i(true, r111.f272747b);
            r103.a();
        L246:
            r115 = r118;
            goto L247
        L244:
            r118 = new e(0, 1, false, true, r111.f272747b);
            r103.a();
            goto L246
        L245:
            r118 = new e(0, 1, true, true, r111.f272747b);
            r103.a();
            goto L246
        L248:
            r116 = null;
            r115 = new i(false, null);
            r103.a();
            goto L252
        L249:
            r116 = r100;
            r115 = new e(0, 1, false, false, null);
            r103.a();
            goto L252
        L250:
            r116 = r100;
            r115 = new e(0, 1, true, false, null);
            r103.a();
            goto L252
        L104:
            if (f() == true) goto L121;
            int r119 = this.f272976b;
            if (d('(') == false) goto L121;
            q();
            ?? r120 = r100;
        L110:
            String r121 = t();
            r120 = r120;
            if (r121 == null) goto L112;
            if (r120 != 0) goto L115;
            r120 = new ArrayList();
        L115:
            r120.add(r121);
            q();
            if (p() == true) goto L110;
            if (d(')') == true) goto L121;
            this.f272976b = r119;
            goto L121
        L112:
            this.f272976b = r119;
        L121:
            r115 = new h(r112);
            r103.a();
            goto L240
        L124:
            if (f() == true) goto L152;
            int r122 = this.f272976b;
            if (d('(') == false) goto L152;
            q();
            List<n> r123 = u();
            if (r123 != null) goto L133;
            this.f272976b = r122;
            goto L152
        L133:
            if (d(')') == true) goto L135;
            this.f272976b = r122;
            goto L152
        L135:
            Iterator r124 = ((ArrayList) r123).iterator();
        L137:
            if (r124.hasNext() == false) goto L154;
            List<o> r125 = ((n) r124.next()).f272744a;
            if (r125 == null) goto L154;
            Iterator r126 = ((ArrayList) r125).iterator();
        L143:
            if (r126.hasNext() == false) goto L137;
            List<d> r127 = ((o) r126.next()).f272749d;
            if (r127 == null) goto L137;
            Iterator r128 = ((ArrayList) r127).iterator();
        L149:
            if (r128.hasNext() == false) goto L143;
            if ((((d) r128.next()) instanceof g) == false) goto L149;
        L154:
            if (r123 == null) goto L163;
            r115 = new g(r123);
            Iterator<n> r129 = r123.iterator();
            int r130 = Integer.MIN_VALUE;
        L157:
            if (r129.hasNext() == false) goto L161;
            int r131 = r129.next().f272745b;
            if (r131 <= r130) goto L157;
            r130 = r131;
            goto L157
        L161:
            r103.f272745b = r130;
            goto L240
        L163:
            throw new CSSParseException("Invalid or missing parameter section for pseudo class: ".concat(r112));
        L152:
            r123 = null;
            goto L154
        L165:
            if (r113 != PseudoClassIdents.nth_child) goto L167;
        L170:
            boolean r210 = true;
        L172:
            if (r113 != PseudoClassIdents.nth_of_type) goto L174;
        L177:
            boolean r211 = true;
        L179:
            if (f() == true) goto L183;
            int r132 = this.f272976b;
            if (d('(') == false) goto L183;
            q();
            if (e("odd") == false) goto L188;
            a r133 = new a(2, r101);
        L190:
            r114 = "Invalid or missing parameter section for pseudo class: ";
        L230:
            q();
            if (d(')') == true) goto L235;
            this.f272976b = r132;
        L234:
            r133 = null;
        L235:
            if (r133 == null) goto L238;
            r117 = new e(r133.f272729a, r133.f272730b, r210, r211, r111.f272747b);
            r103.a();
            goto L242
        L238:
            throw new CSSParseException(r114.concat(r112));
        L188:
            if (e("even") == false) goto L192;
            r133 = new a(2, r104);
            goto L190
        L192:
            if (d('+') == false) goto L195;
        L197:
            int r134 = 1;
        L198:
            com.caverock.androidsvg.a r135 = com.caverock.androidsvg.a.a(this.f272975a, this.f272976b, this.f272977c);
            if (r135 == null) goto L202;
            this.f272976b = r135.f272980a;
        L202:
            if (d('n') == false) goto L204;
        L207:
            if (r135 != null) goto L210;
            r135 = new com.caverock.androidsvg.a(1, this.f272976b);
        L210:
            q();
            boolean r136 = d('+');
            if (r136 == true) goto L215;
            r136 = d('-');
            if (r136 == false) goto L215;
            int r137 = -1;
        L216:
            if (r136 == false) goto L221;
            q();
            com.caverock.androidsvg.a r138 = com.caverock.androidsvg.a.a(this.f272975a, this.f272976b, this.f272977c);
            if (r138 == null) goto L220;
            this.f272976b = r138.f272980a;
        L223:
            if (r135 != null) goto L225;
            int r139 = 0;
        L226:
            if (r138 != null) goto L228;
            int r140 = 0;
        L229:
            r133 = new a(r139, r140);
            goto L230
        L228:
            r140 = ((int) r138.f272981b) * r137;
            goto L229
        L225:
            r139 = r134 * ((int) r135.f272981b);
            goto L226
        L220:
            this.f272976b = r132;
            goto L234
        L221:
            r138 = null;
        L215:
            r137 = 1;
            goto L216
        L204:
            if (d('N') == true) goto L207;
            r138 = r135;
            r137 = r134;
            r114 = "Invalid or missing parameter section for pseudo class: ";
            r135 = null;
            r134 = 1;
            goto L223
        L195:
            if (d('-') == false) goto L197;
            r134 = -1;
        L183:
            r114 = "Invalid or missing parameter section for pseudo class: ";
            goto L234
        L174:
            if (r113 == PseudoClassIdents.nth_last_of_type) goto L177;
            r211 = false;
            goto L179
        L167:
            if (r113 == PseudoClassIdents.nth_of_type) goto L170;
            r210 = false;
            goto L172
        L101:
            throw new CSSParseException("Unsupported pseudo class: ".concat(r112));
        L256:
            throw new CSSParseException("Invalid pseudo class");
        L56:
            if (r111 != 0) goto L58;
            r111 = new o(r110, r100);
        L58:
            q();
            String r141 = t();
            if (r141 == null) goto L91;
            q();
            if (d(com.alipay.sdk.m.n.a.f25612h) == false) goto L64;
            Object r142 = AttribOp.EQUALS;
        L70:
            if (r142 == null) goto L82;
            q();
            if (f() == false) goto L74;
            String r143 = r100;
        L78:
            if (r143 == null) goto L81;
            q();
        L83:
            ?? r144 = r142;
            if (d(']') == false) goto L89;
            if (r142 != null) goto L87;
            r144 = AttribOp.EXISTS;
        L87:
            r111.a(r141, r144, r143);
            r103.a();
            goto L35
        L89:
            throw new CSSParseException("Invalid attribute simpleSelectors");
        L81:
            throw new CSSParseException("Invalid attribute simpleSelectors");
        L74:
            r143 = k();
            if (r143 != null) goto L78;
            r143 = t();
            goto L78
        L82:
            r143 = r100;
            goto L83
        L64:
            if (e("~=") == false) goto L67;
            r142 = AttribOp.INCLUDES;
            goto L70
        L67:
            if (e("|=") == false) goto L69;
            r142 = AttribOp.DASHMATCH;
            goto L70
        L69:
            r142 = r100;
            goto L70
        L91:
            throw new CSSParseException("Invalid attribute simpleSelectors");
        L47:
            if (r111 != 0) goto L49;
            r111 = new o(r110, r100);
        L49:
            String r145 = t();
            if (r145 == null) goto L53;
            r111.a("id", AttribOp.EQUALS, r145);
            r103.f272745b += 1000000;
            goto L35
        L53:
            throw new CSSParseException("Invalid \"#id\" simpleSelectors");
        L38:
            if (r111 != 0) goto L40;
            r111 = new o(r110, r100);
        L40:
            String r146 = t();
            if (r146 == null) goto L44;
            r111.a("class", AttribOp.EQUALS, r146);
            r103.a();
            goto L35
        L44:
            throw new CSSParseException("Invalid \".class\" simpleSelectors");
        L257:
            r105 = r100;
            if (r111 != 0) goto L260;
            this.f272976b = r107;
            r106 = false;
            goto L264
        L260:
            if (r103.f272744a != null) goto L262;
            r103.f272744a = new ArrayList();
        L262:
            ((ArrayList) r103.f272744a).add(r111);
            r106 = true;
            goto L264
        L30:
            String r147 = t();
            if (r147 == null) goto L33;
            o r148 = new o(r110, r147);
            r103.f272745b += r101;
            r111 = r148;
            goto L35
        L33:
            r111 = r100;
            goto L35
        L21:
            if (d(Typography.greater) == false) goto L24;
            Combinator r149 = Combinator.CHILD;
            q();
            r110 = r149;
            goto L28
        L24:
            if (d('+') == false) goto L26;
            Combinator r150 = Combinator.FOLLOWS;
            q();
            r110 = r150;
            goto L28
        L14:
            if (((ArrayList) r108).isEmpty() == true) goto L17;
            r109 = false;
        L271:
            List<o> r151 = r103.f272744a;
            if (r151 != null) goto L274;
        L277:
            boolean r152 = true;
        L278:
            if (r152 == true) goto L280;
            r102.add(r103);
        L280:
            return r102;
        L274:
            if (((ArrayList) r151).isEmpty() == true) goto L277;
            r152 = false;
            goto L278
        }

        public final String s() {
            if (f() == false) goto L5;
            return null;
        L5:
            char r100 = this.f272975a.charAt(this.f272976b);
            if (r100 != '\'') goto L8;
        L10:
            StringBuilder r101 = new StringBuilder();
            this.f272976b++;
            int r102 = h().intValue();
        L12:
            if (r102 == (-1)) goto L39;
            if (r102 == r100) goto L39;
            if (r102 != 92) goto L37;
            r102 = h().intValue();
            if (r102 == (-1)) goto L12;
            if (r102 == 10) goto L36;
            if (r102 == 13) goto L36;
            if (r102 == 12) goto L36;
            int r103 = r(r102);
            if (r103 == (-1)) goto L37;
            int r104 = 1;
        L30:
            if (r104 > 5) goto L35;
            r102 = h().intValue();
            int r105 = r(r102);
            if (r105 == (-1)) goto L35;
            r103 = (r103 * 16) + r105;
            r104 = r104 + 1;
        L35:
            r101.append((char) r103);
        L36:
            r102 = h().intValue();
        L37:
            r101.append((char) r102);
            r102 = h().intValue();
        L39:
            return r101.toString();
        L8:
            if (r100 == '\"') goto L10;
            return null;
        }

        public final String t() {
            if (f() == false) goto L5;
            int r100 = this.f272976b;
        L30:
            int r101 = this.f272976b;
            if (r100 != r101) goto L34;
            return null;
        L34:
            String r102 = this.f272975a.substring(r101, r100);
            this.f272976b = r100;
            return r102;
        L5:
            int r103 = this.f272976b;
            int r104 = this.f272975a.charAt(r103);
            if (r104 != 45) goto L9;
            r104 = a();
        L9:
            if (r104 < 65) goto L11;
            if (r104 > 90) goto L11;
        L14:
            int r105 = a();
        L15:
            if (r105 < 65) goto L17;
            if (r105 > 90) goto L17;
        L27:
            r105 = a();
        L17:
            if (r105 < 97) goto L20;
            if (r105 <= 122) goto L27;
        L20:
            if (r105 >= 48) goto L22;
        L23:
            if (r105 == 45) goto L27;
            if (r105 == 95) goto L27;
            int r106 = this.f272976b;
        L29:
            this.f272976b = r103;
            r100 = r106;
            goto L30
        L22:
            if (r105 <= 57) goto L27;
        L11:
            if (r104 < 97) goto L13;
            if (r104 <= 122) goto L14;
        L13:
            if (r104 == 95) goto L14;
            r106 = r103;
            goto L29
        }

        public c(String r100) {
            super(r100.replaceAll("(?s)/\\*.*?\\*/", ""));
        }
    }

    public interface d {
        boolean a(SVG.j0 r100);
    }

    public static class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f272731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f272732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f272733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f272734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f272735e;

        public final String toString() {
            if (this.f272733c == false) goto L5;
            String r100 = "";
        L7:
            if (this.f272734d == false) goto L10;
            return String.format("nth-%schild(%dn%+d of type <%s>)", new Object[]{r100, Integer.valueOf(this.f272731a), Integer.valueOf(this.f272732b), this.f272735e});
        L10:
            return String.format("nth-%schild(%dn%+d)", new Object[]{r100, Integer.valueOf(this.f272731a), Integer.valueOf(this.f272732b)});
        L5:
            r100 = "last-";
            goto L7
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public final boolean a(SVG.j0 r100) {
            if (this.f272734d == true) goto L5;
        L7:
            String r101 = this.f272735e;
        L8:
            SVG.h0 r102 = r100.f272873b;
            if (r102 == null) goto L20;
            Iterator<SVG.l0> r103 = r102.getChildren().iterator();
            int r104 = 0;
            int r105 = 0;
        L12:
            if (r103.hasNext() == false) goto L22;
            SVG.j0 r106 = (SVG.j0) r103.next();
            if (r106 != r100) goto L16;
            r104 = r105;
        L16:
            if (r101 == null) goto L19;
            if (r106.n().equals(r101) == false) goto L12;
        L19:
            r105 = r105 + 1;
        L22:
            if (this.f272733c == false) goto L24;
            int r107 = r104 + 1;
        L25:
            int r108 = this.f272731a;
            if (r108 == 0) goto L28;
            int r109 = r107 - this.f272732b;
            if ((r109 % r108) == 0) goto L34;
            return false;
        L34:
            if (Integer.signum(r109) != 0) goto L36;
        L37:
            return true;
        L36:
            if (Integer.signum(r107 - this.f272732b) == Integer.signum(this.f272731a)) goto L37;
            return false;
        L28:
            if (r107 != this.f272732b) goto L45;
            return true;
        L45:
            return false;
        L24:
            r107 = r105 - r104;
            goto L25
        L20:
            r104 = 0;
            r105 = 1;
            goto L22
        L5:
            if (this.f272735e != null) goto L7;
            r101 = r100.n();
            goto L8
        }

        public e(int r100, int r101, boolean r102, boolean r103, String r104) {
            this.f272731a = r100;
            this.f272732b = r101;
            this.f272733c = r102;
            this.f272734d = r103;
            this.f272735e = r104;
        }
    }

    public static class f implements d {
        public final String toString() {
            return "empty";
        }

        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.caverock.androidsvg.CSSParser.d
        public final boolean a(SVG.j0 r100) {
            if ((r100 instanceof SVG.h0) == true) goto L5;
        L8:
            return true;
        L5:
            if (((SVG.h0) r100).getChildren().size() == 0) goto L8;
            return false;
        }
    }

    public static class g implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<n> f272736a;

        public final String toString() {
            return "not(" + this.f272736a + ")";
        }

        public g(List<n> r100) {
            this.f272736a = r100;
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public final boolean a(SVG.j0 r100) {
            Iterator<n> r101 = this.f272736a.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            if (CSSParser.g(r101.next(), r100) == false) goto L4;
            return false;
        L9:
            return true;
        }
    }

    public static class h implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f272737a;

        @Override // com.caverock.androidsvg.CSSParser.d
        public final boolean a(SVG.j0 r100) {
            return false;
        }

        public final String toString() {
            return this.f272737a;
        }

        public h(String r100) {
            this.f272737a = r100;
        }
    }

    public static class i implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f272738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f272739b;

        public final String toString() {
            if (this.f272738a == false) goto L6;
            return String.format("only-of-type <%s>", new Object[]{this.f272739b});
        L6:
            return String.format("only-child", new Object[0]);
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public final boolean a(SVG.j0 r100) {
            if (this.f272738a == true) goto L5;
        L7:
            String r101 = this.f272739b;
        L8:
            SVG.h0 r102 = r100.f272873b;
            if (r102 == null) goto L18;
            Iterator<SVG.l0> r103 = r102.getChildren().iterator();
            int r104 = 0;
        L12:
            if (r103.hasNext() == false) goto L19;
            SVG.j0 r105 = (SVG.j0) r103.next();
            if (r101 == null) goto L17;
            if (r105.n().equals(r101) == false) goto L12;
        L17:
            r104 = r104 + 1;
        L19:
            if (r104 != 1) goto L28;
            return true;
        L28:
            return false;
        L18:
            r104 = 1;
            goto L19
        L5:
            if (this.f272739b != null) goto L7;
            r101 = r100.n();
            goto L8
        }

        public i(boolean r100, String r101) {
            this.f272738a = r100;
            this.f272739b = r101;
        }
    }

    public static class j implements d {
        public final String toString() {
            return RootDescription.ROOT_ELEMENT;
        }

        public j() {
        }

        @Override // com.caverock.androidsvg.CSSParser.d
        public final boolean a(SVG.j0 r100) {
            if (r100.f272873b != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static class k implements d {
        @Override // com.caverock.androidsvg.CSSParser.d
        public final boolean a(SVG.j0 r100) {
            return false;
        }

        public final String toString() {
            return PickerReporterConstants.KEY.TARGET;
        }

        public k() {
        }
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f272740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SVG.Style f272741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Source f272742c;

        public final String toString() {
            return String.valueOf(this.f272740a) + " {...} (src=" + this.f272742c + ")";
        }

        public l(n r100, SVG.Style r101, Source r102) {
            this.f272740a = null;
            this.f272741b = null;
            this.f272740a = r100;
            this.f272741b = r101;
            this.f272742c = r102;
        }
    }

    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<l> f272743a;

        public final String toString() {
            if (this.f272743a != null) goto L6;
            return "";
        L6:
            StringBuilder r100 = new StringBuilder();
            Iterator<l> r101 = this.f272743a.iterator();
        L8:
            if (r101.hasNext() == false) goto L11;
            r100.append(r101.next().toString());
            r100.append('\n');
            goto L8
        L11:
            return r100.toString();
        }

        public m() {
            this.f272743a = null;
        }

        public final void a(l r100) {
            if (this.f272743a != null) goto L5;
            this.f272743a = new ArrayList();
        L5:
            int r101 = 0;
        L7:
            if (r101 >= this.f272743a.size()) goto L13;
            if (((l) ListProtector.get(this.f272743a, r101)).f272740a.f272745b > r100.f272740a.f272745b) goto L10;
            r101 = r101 + 1;
            goto L7
        L10:
            ListProtector.add(this.f272743a, r101, r100);
            return;
        L13:
            this.f272743a.add(r100);
        }

        public final void b(m r100) {
            if (r100.f272743a != null) goto L6;
            return;
        L6:
            if (this.f272743a != null) goto L8;
            this.f272743a = new ArrayList(((ArrayList) r100.f272743a).size());
        L8:
            Iterator r101 = ((ArrayList) r100.f272743a).iterator();
        L10:
            if (r101.hasNext() == false) goto L12;
            a((l) r101.next());
            goto L10
        }
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<o> f272744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f272745b;

        public final void a() {
            this.f272745b += 1000;
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder();
            Iterator<o> r101 = this.f272744a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r100.append(r101.next());
            r100.append(' ');
            goto L4
        L6:
            r100.append('[');
            r100.append(this.f272745b);
            r100.append(']');
            return r100.toString();
        }

        public n() {
            this.f272744a = null;
            this.f272745b = 0;
        }
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Combinator f272746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f272747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<b> f272748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<d> f272749d;

        public final String toString() {
            StringBuilder r100 = new StringBuilder();
            Combinator r101 = this.f272746a;
            if (r101 != Combinator.CHILD) goto L6;
            r100.append("> ");
        L8:
            String r102 = this.f272747b;
            if (r102 != null) goto L11;
            r102 = "*";
        L11:
            r100.append(r102);
            List<b> r103 = this.f272748c;
            if (r103 == null) goto L27;
            Iterator r104 = ((ArrayList) r103).iterator();
        L15:
            if (r104.hasNext() == false) goto L27;
            b r105 = (b) r104.next();
            r100.append('[');
            r100.append(r105.f272726a);
            int r106 = a.f272724a[r105.f272727b.ordinal()];
            if (r106 != 1) goto L19;
            r100.append(com.alipay.sdk.m.n.a.f25612h);
            r100.append(r105.f272728c);
        L26:
            r100.append(']');
            goto L15
        L19:
            if (r106 != 2) goto L21;
            r100.append("~=");
            r100.append(r105.f272728c);
            goto L26
        L21:
            if (r106 != 3) goto L26;
            r100.append("|=");
            r100.append(r105.f272728c);
        L27:
            List<d> r107 = this.f272749d;
            if (r107 == null) goto L34;
            Iterator r108 = ((ArrayList) r107).iterator();
        L31:
            if (r108.hasNext() == false) goto L34;
            d r109 = (d) r108.next();
            r100.append(':');
            r100.append(r109);
        L34:
            return r100.toString();
        L6:
            if (r101 != Combinator.FOLLOWS) goto L8;
            r100.append("+ ");
            goto L8
        }

        public o(Combinator r100, String r101) {
            this.f272746a = null;
            this.f272747b = null;
            this.f272748c = null;
            this.f272749d = null;
            if (r100 != null) goto L6;
            r100 = Combinator.DESCENDANT;
        L6:
            this.f272746a = r100;
            this.f272747b = r101;
        }

        public final void a(String r100, AttribOp r101, String r102) {
            if (this.f272748c != null) goto L5;
            this.f272748c = new ArrayList();
        L5:
            List<b> r103 = this.f272748c;
            ArrayList r104 = (ArrayList) r103;
            r104.add(new b(r100, r101, r102));
        }
    }

    public static List<MediaType> c(c r100) {
        ArrayList r101 = new ArrayList();
    L4:
        if (r100.f() == true) goto L29;
        if (r100.f() == true) goto L21;
        int r102 = r100.f272976b;
        char r103 = r100.f272975a.charAt(r102);
        if (r103 < 'A') goto L11;
        if (r103 > 'Z') goto L11;
    L13:
        int r104 = r100.a();
    L14:
        if (r104 < 65) goto L16;
        if (r104 > 90) goto L16;
    L18:
        r104 = r100.a();
    L16:
        if (r104 < 97) goto L19;
        if (r104 <= 122) goto L18;
    L19:
        String r105 = r100.f272975a.substring(r102, r100.f272976b);
    L22:
        if (r105 == null) goto L29;
        r101.add(MediaType.valueOf(r105));     // Catch: IllegalArgumentException -> L26
    L28:
        if (r100.p() == true) goto L4;
    L11:
        if (r103 < 'a') goto L20;
        if (r103 <= 'z') goto L13;
    L20:
        r100.f272976b = r102;
    L21:
        r105 = null;
    L29:
        return r101;
    }

    public final m e(c r100) {
        m r101 = new m();
    L20:
        if (r100.f() == true) goto L19;
        if (r100.e("<!--") == true) goto L20;
        if (r100.e("-->") == true) goto L20;
        if (r100.d('@') == true) goto L13;
        if (d(r101, r100) == false) goto L19;
    L13:
        b(r101, r100);     // Catch: CSSParseException -> L17
    L19:
        return r101;
    L17:
        e = move-exception;
        e.getMessage();
        goto L19
    }

    public CSSParser(MediaType r100, Source r101) {
        this.f272714a = null;
        this.f272715b = null;
        this.f272716c = false;
        this.f272714a = r100;
        this.f272715b = r101;
    }

    public static boolean g(n r100, SVG.j0 r101) {
        ArrayList r102 = new ArrayList();
        Object r103 = r101.f272873b;
    L3:
        int r104 = 0;
        if (r103 == null) goto L6;
        ListProtector.add(r102, 0, r103);
        r103 = ((SVG.l0) r103).f272873b;
        goto L3
    L6:
        int r105 = r102.size() - 1;
        List<o> r106 = r100.f272744a;
        if (r106 != null) goto L9;
        int r107 = 0;
    L11:
        if (r107 == 1) goto L13;
        List<o> r108 = r100.f272744a;
        if (r108 == null) goto L19;
        r104 = ((ArrayList) r108).size();
    L19:
        return f(r100, r104 - 1, r102, r105, r101);
    L13:
        return i((o) ListProtector.get(r100.f272744a, 0), r101);
    L9:
        r107 = ((ArrayList) r106).size();
        goto L11
    }

    public static boolean i(o r100, SVG.j0 r101) {
        String r102 = r100.f272747b;
        if (r102 != null) goto L5;
    L7:
        List<b> r103 = r100.f272748c;
        if (r103 == null) goto L26;
        Iterator r104 = ((ArrayList) r103).iterator();
    L11:
        if (r104.hasNext() == false) goto L26;
        b r105 = (b) r104.next();
        String r106 = r105.f272726a;
        r106.getClass();
        if (r106.equals("id") == false) goto L15;
        if (r105.f272728c.equals(r101.f272861c) == true) goto L11;
        return false;
    L15:
        if (r106.equals("class") == false) goto L16;
        List<String> r107 = r101.f272865g;
        if (r107 == null) goto L19;
        if (r107.contains(r105.f272728c) == true) goto L11;
        return false;
    L19:
        return false;
    L16:
        return false;
    L26:
        List<d> r108 = r100.f272749d;
        if (r108 == null) goto L34;
        Iterator r109 = ((ArrayList) r108).iterator();
    L30:
        if (r109.hasNext() == false) goto L49;
        if (((d) r109.next()).a(r101) == true) goto L30;
        return false;
    L49:
        return true;
    L34:
        return true;
    L5:
        if (r102.equals(r101.n().toLowerCase(Locale.US)) == true) goto L7;
        return false;
    }

    public final void b(m r110, c r111) throws CSSParseException {
        String r100 = r111.t();
        r111.q();
        if (r100 == null) goto L125;
        int r101 = 0;
        if (this.f272716c == true) goto L31;
        if (r100.equals("media") == false) goto L31;
        List<MediaType> r102 = c(r111);
        if (r111.d('{') == false) goto L29;
        r111.q();
        MediaType r103 = this.f272714a;
        Iterator r104 = ((ArrayList) r102).iterator();
    L12:
        if (r104.hasNext() == false) goto L17;
        MediaType r105 = (MediaType) r104.next();
        if (r105 == MediaType.all) goto L16;
        if (r105 != r103) goto L12;
    L16:
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
        this.f272716c = true;
        r110.b(e(r111));
        this.f272716c = false;
    L22:
        if (r111.f() == false) goto L24;
    L122:
        r111.q();
        return;
    L24:
        if (r111.d('}') == true) goto L122;
        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
    L20:
        e(r111);
        goto L22
    L17:
        r106 = false;
        goto L18
    L29:
        throw new CSSParseException("Invalid @media rule: missing rule set");
    L31:
        if (this.f272716c == false) goto L33;
    L109:
        String.format("Ignoring @%s rule", new Object[]{r100});
    L111:
        if (r111.f() == true) goto L122;
        int r112 = r111.h().intValue();
        if (r112 != 59) goto L116;
        if (r101 == 0) goto L122;
    L116:
        if (r112 == 123) goto L117;
        if (r112 != 125) goto L111;
        if (r101 <= 0) goto L111;
        r101 = r101 - 1;
        if (r101 != 0) goto L111;
    L117:
        r101 = r101 + 1;
        goto L111
    L33:
        if (r100.equals("import") == false) goto L109;
        String r107 = null;
        if (r111.f() == true) goto L97;
        int r113 = r111.f272976b;
        if (r111.e("url(") == false) goto L97;
        r111.q();
        String r108 = r111.s();
        if (r108 != null) goto L88;
        StringBuilder r109 = new StringBuilder();
    L44:
        if (r111.f() == true) goto L85;
        char r114 = r111.f272975a.charAt(r111.f272976b);
        if (r114 == '\'') goto L85;
        if (r114 == '\"') goto L85;
        if (r114 == '(') goto L85;
        if (r114 == ')') goto L85;
        if (SVGParser.g.g(r114) == true) goto L85;
        if (Character.isISOControl(r114) == true) goto L85;
        r111.f272976b++;
        if (r114 != '\\') goto L83;
        if (r111.f() == true) goto L44;
        String r115 = r111.f272975a;
        int r116 = r111.f272976b;
        r111.f272976b = r116 + 1;
        r114 = r115.charAt(r116);
        if (r114 == '\n') goto L44;
        if (r114 == '\r') goto L44;
        if (r114 == '\f') goto L44;
        int r117 = c.r(r114);
        if (r117 == (-1)) goto L83;
        int r118 = 1;
    L74:
        if (r118 > 5) goto L82;
        if (r111.f() == true) goto L82;
        int r119 = c.r(r111.f272975a.charAt(r111.f272976b));
        if (r119 == (-1)) goto L82;
        r111.f272976b++;
        r117 = (r117 * 16) + r119;
        r118 = r118 + 1;
    L82:
        r109.append((char) r117);
    L83:
        r109.append(r114);
    L85:
        if (r109.length() != 0) goto L87;
        r108 = null;
        goto L88
    L87:
        r108 = r109.toString();
    L88:
        if (r108 != null) goto L90;
        r111.f272976b = r113;
        goto L97
    L90:
        r111.q();
        if (r111.f() == false) goto L93;
    L96:
        r107 = r108;
        goto L97
    L93:
        if (r111.e(")") == true) goto L96;
        r111.f272976b = r113;
    L97:
        if (r107 != null) goto L99;
        r107 = r111.s();
    L99:
        if (r107 == null) goto L108;
        r111.q();
        c(r111);
        if (r111.f() == true) goto L122;
        if (r111.d(';') == true) goto L122;
        throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
    L108:
        throw new CSSParseException("Invalid @import rule: expected string or url()");
    L125:
        throw new CSSParseException("Invalid '@' rule");
    }

    public final boolean d(m r110, c r111) throws CSSParseException {
        List<n> r100 = r111.u();
        if (r100 == null) goto L60;
        ArrayList r101 = (ArrayList) r100;
        if (r101.isEmpty() == true) goto L60;
        if (r111.d('{') == false) goto L59;
        r111.q();
        SVG.Style r102 = new SVG.Style();
    L9:
        String r103 = r111.t();
        r111.q();
        if (r111.d(':') == false) goto L57;
        r111.q();
        if (r111.f() == true) goto L36;
        int r104 = r111.f272976b;
        int r105 = r111.f272975a.charAt(r104);
        int r112 = r104;
    L16:
        if (r105 == (-1)) goto L33;
        if (r105 == 59) goto L33;
        if (r105 == 125) goto L33;
        if (r105 == 33) goto L33;
        if (r105 != 10) goto L23;
    L26:
        boolean r113 = true;
    L27:
        if (r113 == true) goto L33;
        if (SVGParser.g.g(r105) == true) goto L31;
        r112 = r111.f272976b + 1;
    L31:
        r105 = r111.a();
        goto L16
    L23:
        if (r105 == 13) goto L26;
        r113 = false;
    L33:
        if (r111.f272976b <= r104) goto L35;
        String r106 = r111.f272975a.substring(r104, r112);
    L37:
        if (r106 == null) goto L55;
        r111.q();
        if (r111.d('!') == false) goto L45;
        r111.q();
        if (r111.e("important") == false) goto L44;
        r111.q();
        goto L45
    L44:
        throw new CSSParseException("Malformed rule set: found unexpected '!'");
    L45:
        r111.d(';');
        SVGParser.H(r102, r103, r106);
        r111.q();
        if (r111.f() == true) goto L49;
        if (r111.d('}') == false) goto L9;
    L49:
        r111.q();
        Iterator r114 = r101.iterator();
    L51:
        if (r114.hasNext() == false) goto L53;
        r110.a(new l((n) r114.next(), r102, this.f272715b));
        goto L51
    L53:
        return true;
    L55:
        throw new CSSParseException("Expected property value");
    L35:
        r111.f272976b = r104;
    L36:
        r106 = null;
        goto L37
    L57:
        throw new CSSParseException("Expected ':'");
    L59:
        throw new CSSParseException("Malformed rule block: expected '{'");
    L60:
        return false;
    }

    public static int a(List<SVG.h0> r100, int r101, SVG.j0 r102) {
        int r103 = 0;
        if (r101 >= 0) goto L5;
        return 0;
    L5:
        Object r104 = ListProtector.get(r100, r101);
        SVG.h0 r105 = r102.f272873b;
        if (r104 == r105) goto L8;
        return -1;
    L8:
        Iterator<SVG.l0> r106 = r105.getChildren().iterator();
    L10:
        if (r106.hasNext() == false) goto L15;
        if (r106.next() == r102) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return r103;
    L15:
        return -1;
    }

    public static boolean h(n r100, int r101, List r102, int r103) {
        o r104 = (o) ListProtector.get(r100.f272744a, r101);
        SVG.j0 r105 = (SVG.j0) ListProtector.get(r102, r103);
        if (i(r104, r105) == true) goto L5;
        return false;
    L5:
        Combinator r106 = r104.f272746a;
        if (r106 != Combinator.DESCENDANT) goto L15;
        if (r101 != 0) goto L9;
        return true;
    L9:
        if (r103 <= 0) goto L13;
        r103 = r103 - 1;
        if (h(r100, r101 - 1, r102, r103) == false) goto L9;
        return true;
    L13:
        return false;
    L15:
        if (r106 == Combinator.CHILD) goto L17;
        int r107 = a(r102, r103, r105);
        if (r107 > 0) goto L22;
        return false;
    L22:
        return f(r100, r101 - 1, r102, r103, (SVG.j0) ListProtector.get(r105.f272873b.getChildren(), r107 - 1));
    L17:
        return h(r100, r101 - 1, r102, r103 - 1);
    }

    public static boolean f(n r100, int r101, List r102, int r103, SVG.j0 r104) {
        o r105 = (o) ListProtector.get(r100.f272744a, r101);
        if (i(r105, r104) == true) goto L5;
        return false;
    L5:
        Combinator r106 = r105.f272746a;
        if (r106 != Combinator.DESCENDANT) goto L16;
        if (r101 != 0) goto L9;
        return true;
    L9:
        if (r103 < 0) goto L14;
        if (h(r100, r101 - 1, r102, r103) == true) goto L12;
        r103 = r103 - 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    L16:
        if (r106 == Combinator.CHILD) goto L18;
        int r107 = a(r102, r103, r104);
        if (r107 > 0) goto L23;
        return false;
    L23:
        return f(r100, r101 - 1, r102, r103, (SVG.j0) ListProtector.get(r104.f272873b.getChildren(), r107 - 1));
    L18:
        return h(r100, r101 - 1, r102, r103);
    }
}
