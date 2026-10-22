package com.ss.android.lark.widget.codeblock.theme;

import android.text.style.CharacterStyle;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class CodeBlockV2ThemeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f445712a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f445713b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, CharacterStyle> f445714c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CharacterStyle> f445715d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<CharacterStyle, Set<String>> f445716e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Function3<CharacterStyle, Function0<? extends CharacterStyle>, String, CharacterStyle> f445717f = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f445718a = null;

        static {
            int[] r100 = new int[LineContent.ContentType.values().length];
            r100[LineContent.ContentType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L56
        L119:
            r100[LineContent.ContentType.OPERATOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L57
        L129:
            r100[LineContent.ContentType.PUNCTUATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L58
        L137:
            r100[LineContent.ContentType.PROPERTY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L59
        L141:
            r100[LineContent.ContentType.CHAR_ESCAPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L60
        L145:
            r100[LineContent.ContentType.CLASS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L61
        L151:
            r100[LineContent.ContentType.FUNCTION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L62
        L167:
            r100[LineContent.ContentType.VARIABLE_LANGUAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L63
        L175:
            r100[LineContent.ContentType.VARIABLE_CONSTANT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L64
        L177:
            r100[LineContent.ContentType.TITLE_CLASS_INHERITED.ordinal()] = 10;     // Catch: NoSuchFieldError -> L65
        L183:
            r100[LineContent.ContentType.TITLE_FUNCTION.ordinal()] = 11;     // Catch: NoSuchFieldError -> L66
        L199:
            r100[LineContent.ContentType.TITLE_FUNCTION_INVOKE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L67
        L207:
            r100[LineContent.ContentType.PARAMS.ordinal()] = 13;     // Catch: NoSuchFieldError -> L68
        L107:
            r100[LineContent.ContentType.META_PROMPT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L69
        L111:
            r100[LineContent.ContentType.META_KEYWORD.ordinal()] = 15;     // Catch: NoSuchFieldError -> L70
        L125:
            r100[LineContent.ContentType.TAG.ordinal()] = 16;     // Catch: NoSuchFieldError -> L71
        L135:
            r100[LineContent.ContentType.CODE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L72
        L139:
            r100[LineContent.ContentType.EMPHASIS.ordinal()] = 18;     // Catch: NoSuchFieldError -> L73
        L147:
            r100[LineContent.ContentType.TEMPLATE_TAG.ordinal()] = 19;     // Catch: NoSuchFieldError -> L74
        L159:
            r100[LineContent.ContentType.KEYWORD.ordinal()] = 20;     // Catch: NoSuchFieldError -> L75
        L169:
            r100[LineContent.ContentType.BUILT_IN.ordinal()] = 21;     // Catch: NoSuchFieldError -> L76
        L171:
            r100[LineContent.ContentType.TYPE.ordinal()] = 22;     // Catch: NoSuchFieldError -> L77
        L179:
            r100[LineContent.ContentType.LITERAL.ordinal()] = 23;     // Catch: NoSuchFieldError -> L78
        L191:
            r100[LineContent.ContentType.NUMBER.ordinal()] = 24;     // Catch: NoSuchFieldError -> L79
        L201:
            r100[LineContent.ContentType.REGEXP.ordinal()] = 25;     // Catch: NoSuchFieldError -> L80
        L203:
            r100[LineContent.ContentType.STRING.ordinal()] = 26;     // Catch: NoSuchFieldError -> L81
        L109:
            r100[LineContent.ContentType.SUBST.ordinal()] = 27;     // Catch: NoSuchFieldError -> L82
        L117:
            r100[LineContent.ContentType.SYMBOL.ordinal()] = 28;     // Catch: NoSuchFieldError -> L83
        L127:
            r100[LineContent.ContentType.VARIABLE.ordinal()] = 29;     // Catch: NoSuchFieldError -> L84
        L131:
            r100[LineContent.ContentType.TITLE.ordinal()] = 30;     // Catch: NoSuchFieldError -> L85
        L143:
            r100[LineContent.ContentType.TITLE_CLASS.ordinal()] = 31;     // Catch: NoSuchFieldError -> L86
        L153:
            r100[LineContent.ContentType.COMMENT.ordinal()] = 32;     // Catch: NoSuchFieldError -> L87
        L161:
            r100[LineContent.ContentType.DOCTAG.ordinal()] = 33;     // Catch: NoSuchFieldError -> L88
        L163:
            r100[LineContent.ContentType.META.ordinal()] = 34;     // Catch: NoSuchFieldError -> L89
        L173:
            r100[LineContent.ContentType.META_STRING.ordinal()] = 35;     // Catch: NoSuchFieldError -> L90
        L185:
            r100[LineContent.ContentType.SECTION.ordinal()] = 36;     // Catch: NoSuchFieldError -> L91
        L193:
            r100[LineContent.ContentType.NAME.ordinal()] = 37;     // Catch: NoSuchFieldError -> L92
        L195:
            r100[LineContent.ContentType.ATTR.ordinal()] = 38;     // Catch: NoSuchFieldError -> L93
        L205:
            r100[LineContent.ContentType.ATTRIBUTE.ordinal()] = 39;     // Catch: NoSuchFieldError -> L94
        L113:
            r100[LineContent.ContentType.BULLET.ordinal()] = 40;     // Catch: NoSuchFieldError -> L95
        L121:
            r100[LineContent.ContentType.FORMULA.ordinal()] = 41;     // Catch: NoSuchFieldError -> L96
        L123:
            r100[LineContent.ContentType.LINK.ordinal()] = 42;     // Catch: NoSuchFieldError -> L97
        L133:
            r100[LineContent.ContentType.QUOTE.ordinal()] = 43;     // Catch: NoSuchFieldError -> L98
        L149:
            r100[LineContent.ContentType.SELECTOR_TAG.ordinal()] = 44;     // Catch: NoSuchFieldError -> L99
        L155:
            r100[LineContent.ContentType.SELECTOR_ID.ordinal()] = 45;     // Catch: NoSuchFieldError -> L100
        L157:
            r100[LineContent.ContentType.SELECTOR_CLASS.ordinal()] = 46;     // Catch: NoSuchFieldError -> L101
        L165:
            r100[LineContent.ContentType.SELECTOR_ATTR.ordinal()] = 47;     // Catch: NoSuchFieldError -> L102
        L181:
            r100[LineContent.ContentType.SELECTOR_PSEUDO.ordinal()] = 48;     // Catch: NoSuchFieldError -> L103
        L187:
            r100[LineContent.ContentType.TEMPLATE_VARIABLE.ordinal()] = 49;     // Catch: NoSuchFieldError -> L104
        L189:
            r100[LineContent.ContentType.ADDITION.ordinal()] = 50;     // Catch: NoSuchFieldError -> L105
        L197:
            r100[LineContent.ContentType.DELETION.ordinal()] = 51;     // Catch: NoSuchFieldError -> L106
        L54:
            f445718a = r100;
        }
    }

    static {
        f445712a = LazyKt.lazy(CodeBlockV2ThemeManager$defaultThemeConfig$2.INSTANCE);
        f445713b = LazyKt.lazy(CodeBlockV2ThemeManager$defaultContentTypeStyle$2.INSTANCE);
        f445714c = new ConcurrentHashMap();
        f445715d = new ConcurrentHashMap();
        f445716e = new ConcurrentHashMap();
        f445717f = CodeBlockV2ThemeManager$checkSpanUsedAction$1.INSTANCE;
    }

    @JvmStatic
    public static final void a() {
        f445714c.clear();
        f445715d.clear();
        f445716e.clear();
    }

    public static com.ss.android.lark.widget.codeblock.theme.a.C5390a d() {
        return (com.ss.android.lark.widget.codeblock.theme.a.C5390a) f445713b.getValue();
    }

    public static com.ss.android.lark.widget.codeblock.theme.a.C5390a b(LineContent.ContentType r110) {
        switch(a.f445718a[r110.ordinal()]) {
            case 1: goto L57;
            case 2: goto L107;
            case 3: goto L106;
            case 4: goto L105;
            case 5: goto L104;
            case 6: goto L103;
            case 7: goto L102;
            case 8: goto L101;
            case 9: goto L100;
            case 10: goto L99;
            case 11: goto L98;
            case 12: goto L97;
            case 13: goto L96;
            case 14: goto L95;
            case 15: goto L94;
            case 16: goto L93;
            case 17: goto L92;
            case 18: goto L91;
            case 19: goto L90;
            case 20: goto L89;
            case 21: goto L88;
            case 22: goto L87;
            case 23: goto L86;
            case 24: goto L85;
            case 25: goto L84;
            case 26: goto L83;
            case 27: goto L82;
            case 28: goto L81;
            case 29: goto L80;
            case 30: goto L79;
            case 31: goto L78;
            case 32: goto L77;
            case 33: goto L76;
            case 34: goto L75;
            case 35: goto L74;
            case 36: goto L73;
            case 37: goto L72;
            case 38: goto L71;
            case 39: goto L70;
            case 40: goto L69;
            case 41: goto L68;
            case 42: goto L67;
            case 43: goto L66;
            case 44: goto L65;
            case 45: goto L64;
            case 46: goto L63;
            case 47: goto L62;
            case 48: goto L61;
            case 49: goto L60;
            case 50: goto L59;
            case 51: goto L58;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L58:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-1812919, -1812919, 4);
    L59:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-11493041, -11493041, 4);
    L60:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L61:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L62:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L63:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L64:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L65:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-1812919, -1812919, 4);
    L66:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6250073, -6250073, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("fontStyle", "italic")}));
    L67:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("-lark-textDecoration", SegmentStyle.UNDERLINE)}));
    L68:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-5888348, -5888348, 4);
    L69:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L70:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-11493041, -11493041, 4);
    L71:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L72:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-1812919, -1812919, 4);
    L73:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-1812919, -1812919, 4);
    L74:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-11493041, -11493041, 4);
    L75:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L76:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-5888348, -5888348, 4);
    L77:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6250073, -6250073, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("fontStyle", "italic")}));
    L78:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L79:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L80:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L81:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L82:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-1812919, -1812919, 4);
    L83:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-11493041, -11493041, 4);
    L84:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-11493041, -11493041, 4);
    L85:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L86:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-16677701, -16677701, 4);
    L87:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L88:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-4094975, -4094975, 4);
    L89:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-5888348, -5888348, 4);
    L90:
        return d();
    L91:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-13947082, -1513240, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("fontStyle", "italic")}));
    L92:
        return d();
    L93:
        return d();
    L94:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L95:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L96:
        return d();
    L97:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L98:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L99:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-12551950, -12551950, 4);
    L100:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L101:
        return new com.ss.android.lark.widget.codeblock.theme.a.C5390a(-6789119, -6789119, 4);
    L102:
        return d();
    L103:
        return d();
    L104:
        return d();
    L105:
        return d();
    L106:
        return d();
    L107:
        return d();
    L57:
        return d();
    }

    public static CharacterStyle c(LineContent.ContentType r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        Intrinsics.checkNotNullParameter(r102, "key");
        if (r100 != LineContent.ContentType.TEXT) goto L5;
        return null;
    L5:
        Map<LineContent.ContentType, com.ss.android.lark.widget.codeblock.theme.a.C5390a> r103 = ((com.ss.android.lark.widget.codeblock.theme.a) f445712a.getValue()).f445724c;
        com.ss.android.lark.widget.codeblock.theme.a.C5390a r104 = r103.get(r100);
        if (r104 != null) goto L8;
        r104 = b(r100);
        r103.put(r100, r104);
    L8:
        com.ss.android.lark.widget.codeblock.theme.a.C5390a r105 = r104;
        if (r101 == false) goto L11;
        final int r106 = r105.f445726b;
    L12:
        com.ss.android.lark.widget.codeblock.theme.a.C5390a r107 = d();
        if (r101 == false) goto L15;
        int r108 = r107.f445726b;
    L16:
        if (r106 != r108) goto L18;
        return null;
    L18:
        Function0<com.ss.android.lark.widget.light.span.CustomForegroundColorSpan> r109 = new CodeBlockV2ThemeManager$getColorSpanByContentType$createAction$1(r106);
        ConcurrentHashMap<Integer, CharacterStyle> r110 = f445714c;
        Integer r111 = Integer.valueOf(r106);
        com.ss.android.lark.widget.light.span.CustomForegroundColorSpan r112 = r110.get(r111);
        if (r112 != null) goto L24;
        r112 = r109.invoke();
        CharacterStyle r113 = r110.putIfAbsent(r111, r112);
        if (r113 == null) goto L24;
        r112 = r113;
    L24:
        CharacterStyle r114 = r112;
        Function3<CharacterStyle, Function0<? extends CharacterStyle>, String, CharacterStyle> r115 = f445717f;
        Intrinsics.checkNotNull(r114);
        return r115.invoke(r114, r109, r102);
    L15:
        r108 = r107.f445725a;
        goto L16
    L11:
        r106 = r105.f445725a;
        goto L12
    }

    public static Set e(LineContent.ContentType r100, final Map r101, final String r110) {
        Intrinsics.checkNotNullParameter(r100, "contentType");
        Intrinsics.checkNotNullParameter(r110, "key");
        Map<LineContent.ContentType, com.ss.android.lark.widget.codeblock.theme.a.C5390a> r102 = ((com.ss.android.lark.widget.codeblock.theme.a) f445712a.getValue()).f445724c;
        com.ss.android.lark.widget.codeblock.theme.a.C5390a r103 = r102.get(r100);
        if (r103 != null) goto L5;
        r103 = b(r100);
        r102.put(r100, r103);
    L5:
        Map<String, String> r104 = r103.f445727c;
        boolean r105 = true;
        if (r104 != null) goto L8;
    L11:
        boolean r106 = true;
    L13:
        if (r106 == false) goto L22;
        if (r101 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        return null;
    L16:
        if (r101.isEmpty() == true) goto L19;
        r107 = false;
    L22:
        LinkedHashSet r108 = new LinkedHashSet();
        Function2<String, Function0<? extends CharacterStyle>, CharacterStyle> r109 = new CodeBlockV2ThemeManager$getStyleSpanByContentTypeStyle$getStyleSpanAction$1(r110);
        if (r101 == null) goto L25;
        String r111 = (String) r101.get("fontWeight");
    L26:
        if (r111 != null) goto L28;
    L31:
        boolean r112 = true;
    L32:
        final String r113 = "";
        if (r112 == false) goto L44;
        if (r104 == null) goto L36;
        String r114 = r104.get("fontWeight");
    L37:
        if (r114 != null) goto L39;
    L42:
        boolean r115 = true;
    L43:
        if (r115 == false) goto L44;
    L56:
        if (r101 == null) goto L58;
        String r116 = (String) r101.get("fontStyle");
    L59:
        if (r116 != null) goto L61;
    L64:
        boolean r117 = true;
    L65:
        if (r117 == false) goto L76;
        if (r104 == null) goto L68;
        String r118 = r104.get("fontStyle");
    L69:
        if (r118 != null) goto L71;
    L74:
        boolean r119 = true;
    L75:
        if (r119 == false) goto L76;
    L91:
        if (r101 == null) goto L93;
        String r120 = (String) r101.get("-lark-textDecoration");
    L94:
        if (r120 != null) goto L96;
    L99:
        boolean r121 = true;
    L100:
        if (r121 == false) goto L111;
        if (r104 == null) goto L103;
        String r122 = r104.get("-lark-textDecoration");
    L104:
        if (r122 != null) goto L106;
    L109:
        boolean r123 = true;
    L110:
        if (r123 == false) goto L111;
    L145:
        return r108;
    L106:
        if (r122.length() == 0) goto L109;
        r123 = false;
        goto L110
    L103:
        r122 = null;
    L111:
        if (r101 == null) goto L113;
        final String r124 = (String) r101.get("-lark-textDecoration");
    L114:
        if (r104 == null) goto L116;
        String r125 = r104.get("-lark-textDecoration");
    L118:
        if (r124 != null) goto L120;
    L122:
        boolean r126 = false;
    L123:
        if (r126 == true) goto L130;
        if (r125 != null) goto L126;
    L128:
        boolean r127 = false;
    L129:
        if (r127 == true) goto L130;
    L132:
        if (r124 != null) goto L134;
    L136:
        boolean r128 = false;
    L137:
        if (r128 == true) goto L144;
        if (r125 != null) goto L140;
    L142:
        r105 = false;
    L143:
        if (r105 == false) goto L145;
    L140:
        if (StringsKt.contains$default(r125, "lineThrough", false, 2, null) != true) goto L142;
    L144:
        r108.add(r109.invoke("lineThrough", new CodeBlockV2ThemeManager$getStyleSpanByContentTypeStyle$4(r124)));
        goto L145
    L134:
        if (StringsKt.contains$default(r124, "lineThrough", false, 2, null) != true) goto L136;
        r128 = true;
        goto L137
    L126:
        if (StringsKt.contains$default(r125, SegmentStyle.UNDERLINE, false, 2, null) != true) goto L128;
        r127 = true;
    L130:
        r108.add(r109.invoke(SegmentStyle.UNDERLINE, new CodeBlockV2ThemeManager$getStyleSpanByContentTypeStyle$3(r124)));
        goto L132
    L120:
        if (StringsKt.contains$default(r124, SegmentStyle.UNDERLINE, false, 2, null) != true) goto L122;
        r126 = true;
        goto L123
    L116:
        r125 = null;
        goto L118
    L113:
        r124 = null;
        goto L114
    L96:
        if (r120.length() == 0) goto L99;
        r121 = false;
        goto L100
    L93:
        r120 = null;
        goto L94
    L71:
        if (r118.length() == 0) goto L74;
        r119 = false;
        goto L75
    L68:
        r118 = null;
    L76:
        if (r101 == null) goto L81;
        String r129 = (String) r101.get("fontStyle");
        if (r129 == null) goto L81;
        r113 = r129;
    L88:
        if (Intrinsics.areEqual(StringsKt.trim(r113).toString(), "italic") == false) goto L91;
        r108.add(r109.invoke("italic", new CodeBlockV2ThemeManager$getStyleSpanByContentTypeStyle$2(r101, r113)));
    L81:
        if (r104 == null) goto L83;
        String r130 = r104.get("fontStyle");
    L84:
        if (r130 == null) goto L88;
        r113 = r130;
        goto L88
    L83:
        r130 = null;
        goto L84
    L61:
        if (r116.length() == 0) goto L64;
        r117 = false;
        goto L65
    L58:
        r116 = null;
        goto L59
    L39:
        if (r114.length() == 0) goto L42;
        r115 = false;
        goto L43
    L36:
        r114 = null;
    L44:
        if (r101 == null) goto L47;
        final String r131 = (String) r101.get("fontWeight");
        if (r131 == null) goto L47;
    L53:
        if (Intrinsics.areEqual(StringsKt.trim(r131).toString(), CommodityText.BOLD) == false) goto L56;
        r108.add(r109.invoke(CommodityText.BOLD, new CodeBlockV2ThemeManager$getStyleSpanByContentTypeStyle$1(r101, r131)));
    L47:
        if (r104 == null) goto L49;
        r131 = r104.get("fontWeight");
    L50:
        if (r131 != null) goto L53;
        r131 = "";
        goto L53
    L49:
        r131 = null;
        goto L50
    L28:
        if (r111.length() == 0) goto L31;
        r112 = false;
        goto L32
    L25:
        r111 = null;
        goto L26
    L8:
        if (r104.isEmpty() == true) goto L11;
        r106 = false;
        goto L13
    }
}
