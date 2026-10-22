package org.jsoup.parser;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes42.dex */
abstract enum TokeniserState extends Enum<TokeniserState> {
    public static final TokeniserState AfterAttributeName = null;
    public static final TokeniserState AfterAttributeValue_quoted = null;
    public static final TokeniserState AfterDoctypeName = null;
    public static final TokeniserState AfterDoctypePublicIdentifier = null;
    public static final TokeniserState AfterDoctypePublicKeyword = null;
    public static final TokeniserState AfterDoctypeSystemIdentifier = null;
    public static final TokeniserState AfterDoctypeSystemKeyword = null;
    public static final TokeniserState AttributeName = null;
    public static final TokeniserState AttributeValue_doubleQuoted = null;
    public static final TokeniserState AttributeValue_singleQuoted = null;
    public static final TokeniserState AttributeValue_unquoted = null;
    public static final TokeniserState BeforeAttributeName = null;
    public static final TokeniserState BeforeAttributeValue = null;
    public static final TokeniserState BeforeDoctypeName = null;
    public static final TokeniserState BeforeDoctypePublicIdentifier = null;
    public static final TokeniserState BeforeDoctypeSystemIdentifier = null;
    public static final TokeniserState BetweenDoctypePublicAndSystemIdentifiers = null;
    public static final TokeniserState BogusComment = null;
    public static final TokeniserState BogusDoctype = null;
    public static final TokeniserState CdataSection = null;
    public static final TokeniserState CharacterReferenceInData = null;
    public static final TokeniserState CharacterReferenceInRcdata = null;
    public static final TokeniserState Comment = null;
    public static final TokeniserState CommentEnd = null;
    public static final TokeniserState CommentEndBang = null;
    public static final TokeniserState CommentEndDash = null;
    public static final TokeniserState CommentStart = null;
    public static final TokeniserState CommentStartDash = null;
    public static final TokeniserState Data = null;
    public static final TokeniserState Doctype = null;
    public static final TokeniserState DoctypeName = null;
    public static final TokeniserState DoctypePublicIdentifier_doubleQuoted = null;
    public static final TokeniserState DoctypePublicIdentifier_singleQuoted = null;
    public static final TokeniserState DoctypeSystemIdentifier_doubleQuoted = null;
    public static final TokeniserState DoctypeSystemIdentifier_singleQuoted = null;
    public static final TokeniserState EndTagOpen = null;
    public static final TokeniserState MarkupDeclarationOpen = null;
    public static final TokeniserState PLAINTEXT = null;
    public static final TokeniserState RCDATAEndTagName = null;
    public static final TokeniserState RCDATAEndTagOpen = null;
    public static final TokeniserState Rawtext = null;
    public static final TokeniserState RawtextEndTagName = null;
    public static final TokeniserState RawtextEndTagOpen = null;
    public static final TokeniserState RawtextLessthanSign = null;
    public static final TokeniserState Rcdata = null;
    public static final TokeniserState RcdataLessthanSign = null;
    public static final TokeniserState ScriptData = null;
    public static final TokeniserState ScriptDataDoubleEscapeEnd = null;
    public static final TokeniserState ScriptDataDoubleEscapeStart = null;
    public static final TokeniserState ScriptDataDoubleEscaped = null;
    public static final TokeniserState ScriptDataDoubleEscapedDash = null;
    public static final TokeniserState ScriptDataDoubleEscapedDashDash = null;
    public static final TokeniserState ScriptDataDoubleEscapedLessthanSign = null;
    public static final TokeniserState ScriptDataEndTagName = null;
    public static final TokeniserState ScriptDataEndTagOpen = null;
    public static final TokeniserState ScriptDataEscapeStart = null;
    public static final TokeniserState ScriptDataEscapeStartDash = null;
    public static final TokeniserState ScriptDataEscaped = null;
    public static final TokeniserState ScriptDataEscapedDash = null;
    public static final TokeniserState ScriptDataEscapedDashDash = null;
    public static final TokeniserState ScriptDataEscapedEndTagName = null;
    public static final TokeniserState ScriptDataEscapedEndTagOpen = null;
    public static final TokeniserState ScriptDataEscapedLessthanSign = null;
    public static final TokeniserState ScriptDataLessthanSign = null;
    public static final TokeniserState SelfClosingStartTag = null;
    public static final TokeniserState TagName = null;
    public static final TokeniserState TagOpen = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f525988a = null;
    static final char[] attributeNameCharsSorted = null;
    static final char[] attributeValueUnquoted = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ TokeniserState[] f525989b = null;
    static final char nullChar = 0;

    public TokeniserState() {
        throw null;
    }

    public abstract void read(h r100, a r101);

    static {
        final String r100 = "Data";
        final int r101 = 0;
        TokeniserState r102 = new AnonymousClass1(r100, r101);
        Data = r102;
        final String r103 = "CharacterReferenceInData";
        final int r104 = 1;
        TokeniserState r105 = new AnonymousClass2(r103, r104);
        CharacterReferenceInData = r105;
        final String r106 = "Rcdata";
        final int r107 = 2;
        TokeniserState r108 = new AnonymousClass3(r106, r107);
        Rcdata = r108;
        final String r109 = "CharacterReferenceInRcdata";
        final int r110 = 3;
        TokeniserState r111 = new AnonymousClass4(r109, r110);
        CharacterReferenceInRcdata = r111;
        final String r112 = "Rawtext";
        final int r113 = 4;
        TokeniserState r114 = new AnonymousClass5(r112, r113);
        Rawtext = r114;
        final String r115 = "ScriptData";
        final int r116 = 5;
        TokeniserState r117 = new AnonymousClass6(r115, r116);
        ScriptData = r117;
        final String r118 = "PLAINTEXT";
        final int r119 = 6;
        TokeniserState r120 = new AnonymousClass7(r118, r119);
        PLAINTEXT = r120;
        final String r121 = "TagOpen";
        final int r122 = 7;
        TokeniserState r123 = new AnonymousClass8(r121, r122);
        TagOpen = r123;
        final String r124 = "EndTagOpen";
        final int r125 = 8;
        TokeniserState r126 = new AnonymousClass9(r124, r125);
        EndTagOpen = r126;
        final String r127 = "TagName";
        final int r128 = 9;
        TokeniserState r129 = new AnonymousClass10(r127, r128);
        TagName = r129;
        final String r130 = "RcdataLessthanSign";
        final int r131 = 10;
        TokeniserState r132 = new AnonymousClass11(r130, r131);
        RcdataLessthanSign = r132;
        final String r133 = "RCDATAEndTagOpen";
        final int r134 = 11;
        TokeniserState r135 = new AnonymousClass12(r133, r134);
        RCDATAEndTagOpen = r135;
        final String r136 = "RCDATAEndTagName";
        final int r137 = 12;
        TokeniserState r138 = new AnonymousClass13(r136, r137);
        RCDATAEndTagName = r138;
        final String r139 = "RawtextLessthanSign";
        final int r140 = 13;
        TokeniserState r141 = new AnonymousClass14(r139, r140);
        RawtextLessthanSign = r141;
        final String r142 = "RawtextEndTagOpen";
        final int r143 = 14;
        TokeniserState r144 = new AnonymousClass15(r142, r143);
        RawtextEndTagOpen = r144;
        final String r145 = "RawtextEndTagName";
        final int r146 = 15;
        TokeniserState r147 = new AnonymousClass16(r145, r146);
        RawtextEndTagName = r147;
        final String r148 = "ScriptDataLessthanSign";
        final int r149 = 16;
        TokeniserState r150 = new AnonymousClass17(r148, r149);
        ScriptDataLessthanSign = r150;
        final String r151 = "ScriptDataEndTagOpen";
        final int r152 = 17;
        TokeniserState r153 = new AnonymousClass18(r151, r152);
        ScriptDataEndTagOpen = r153;
        final String r154 = "ScriptDataEndTagName";
        final int r155 = 18;
        TokeniserState r156 = new AnonymousClass19(r154, r155);
        ScriptDataEndTagName = r156;
        final String r157 = "ScriptDataEscapeStart";
        final int r158 = 19;
        TokeniserState r159 = new AnonymousClass20(r157, r158);
        ScriptDataEscapeStart = r159;
        final String r160 = "ScriptDataEscapeStartDash";
        final int r161 = 20;
        TokeniserState r162 = new AnonymousClass21(r160, r161);
        ScriptDataEscapeStartDash = r162;
        final String r163 = "ScriptDataEscaped";
        final int r164 = 21;
        TokeniserState r165 = new AnonymousClass22(r163, r164);
        ScriptDataEscaped = r165;
        final String r166 = "ScriptDataEscapedDash";
        final int r167 = 22;
        TokeniserState r168 = new AnonymousClass23(r166, r167);
        ScriptDataEscapedDash = r168;
        final String r169 = "ScriptDataEscapedDashDash";
        final int r170 = 23;
        TokeniserState r171 = new AnonymousClass24(r169, r170);
        ScriptDataEscapedDashDash = r171;
        final String r172 = "ScriptDataEscapedLessthanSign";
        final int r173 = 24;
        TokeniserState r174 = new AnonymousClass25(r172, r173);
        ScriptDataEscapedLessthanSign = r174;
        final String r175 = "ScriptDataEscapedEndTagOpen";
        final int r176 = 25;
        TokeniserState r177 = new AnonymousClass26(r175, r176);
        ScriptDataEscapedEndTagOpen = r177;
        final String r178 = "ScriptDataEscapedEndTagName";
        final int r179 = 26;
        TokeniserState r180 = new AnonymousClass27(r178, r179);
        ScriptDataEscapedEndTagName = r180;
        final String r181 = "ScriptDataDoubleEscapeStart";
        final int r182 = 27;
        TokeniserState r183 = new AnonymousClass28(r181, r182);
        ScriptDataDoubleEscapeStart = r183;
        final String r184 = "ScriptDataDoubleEscaped";
        final int r185 = 28;
        TokeniserState r186 = new AnonymousClass29(r184, r185);
        ScriptDataDoubleEscaped = r186;
        final String r187 = "ScriptDataDoubleEscapedDash";
        final int r188 = 29;
        TokeniserState r189 = new AnonymousClass30(r187, r188);
        ScriptDataDoubleEscapedDash = r189;
        final String r190 = "ScriptDataDoubleEscapedDashDash";
        final int r191 = 30;
        TokeniserState r192 = new AnonymousClass31(r190, r191);
        ScriptDataDoubleEscapedDashDash = r192;
        final String r193 = "ScriptDataDoubleEscapedLessthanSign";
        final int r194 = 31;
        TokeniserState r195 = new AnonymousClass32(r193, r194);
        ScriptDataDoubleEscapedLessthanSign = r195;
        final String r196 = "ScriptDataDoubleEscapeEnd";
        final int r197 = 32;
        TokeniserState r198 = new AnonymousClass33(r196, r197);
        ScriptDataDoubleEscapeEnd = r198;
        final String r199 = "BeforeAttributeName";
        final int r200 = 33;
        TokeniserState r201 = new AnonymousClass34(r199, r200);
        BeforeAttributeName = r201;
        final String r202 = "AttributeName";
        final int r203 = 34;
        TokeniserState r204 = new AnonymousClass35(r202, r203);
        AttributeName = r204;
        final String r205 = "AfterAttributeName";
        final int r206 = 35;
        TokeniserState r207 = new AnonymousClass36(r205, r206);
        AfterAttributeName = r207;
        final String r208 = "BeforeAttributeValue";
        final int r209 = 36;
        TokeniserState r210 = new AnonymousClass37(r208, r209);
        BeforeAttributeValue = r210;
        final String r211 = "AttributeValue_doubleQuoted";
        final int r212 = 37;
        TokeniserState r213 = new AnonymousClass38(r211, r212);
        AttributeValue_doubleQuoted = r213;
        final String r214 = "AttributeValue_singleQuoted";
        final int r215 = 38;
        TokeniserState r216 = new AnonymousClass39(r214, r215);
        AttributeValue_singleQuoted = r216;
        final String r217 = "AttributeValue_unquoted";
        final int r218 = 39;
        TokeniserState r219 = new AnonymousClass40(r217, r218);
        AttributeValue_unquoted = r219;
        final String r220 = "AfterAttributeValue_quoted";
        final int r221 = 40;
        TokeniserState r222 = new AnonymousClass41(r220, r221);
        AfterAttributeValue_quoted = r222;
        final String r223 = "SelfClosingStartTag";
        final int r224 = 41;
        TokeniserState r225 = new AnonymousClass42(r223, r224);
        SelfClosingStartTag = r225;
        final String r226 = "BogusComment";
        final int r227 = 42;
        TokeniserState r228 = new AnonymousClass43(r226, r227);
        BogusComment = r228;
        final String r229 = "MarkupDeclarationOpen";
        final int r230 = 43;
        TokeniserState r231 = new AnonymousClass44(r229, r230);
        MarkupDeclarationOpen = r231;
        final String r232 = "CommentStart";
        final int r233 = 44;
        TokeniserState r234 = new AnonymousClass45(r232, r233);
        CommentStart = r234;
        final String r235 = "CommentStartDash";
        final int r236 = 45;
        TokeniserState r237 = new AnonymousClass46(r235, r236);
        CommentStartDash = r237;
        final String r238 = "Comment";
        final int r239 = 46;
        TokeniserState r240 = new AnonymousClass47(r238, r239);
        Comment = r240;
        final String r241 = "CommentEndDash";
        final int r242 = 47;
        TokeniserState r243 = new AnonymousClass48(r241, r242);
        CommentEndDash = r243;
        final String r244 = "CommentEnd";
        final int r245 = 48;
        TokeniserState r246 = new AnonymousClass49(r244, r245);
        CommentEnd = r246;
        final String r247 = "CommentEndBang";
        final int r248 = 49;
        TokeniserState r249 = new AnonymousClass50(r247, r248);
        CommentEndBang = r249;
        final String r250 = "Doctype";
        final int r251 = 50;
        TokeniserState r252 = new AnonymousClass51(r250, r251);
        Doctype = r252;
        final String r253 = "BeforeDoctypeName";
        final int r254 = 51;
        TokeniserState r255 = new AnonymousClass52(r253, r254);
        BeforeDoctypeName = r255;
        final String r256 = "DoctypeName";
        final int r257 = 52;
        TokeniserState r258 = new AnonymousClass53(r256, r257);
        DoctypeName = r258;
        final String r259 = "AfterDoctypeName";
        final int r260 = 53;
        TokeniserState r261 = new AnonymousClass54(r259, r260);
        AfterDoctypeName = r261;
        final String r262 = "AfterDoctypePublicKeyword";
        final int r263 = 54;
        TokeniserState r264 = new AnonymousClass55(r262, r263);
        AfterDoctypePublicKeyword = r264;
        final String r265 = "BeforeDoctypePublicIdentifier";
        final int r266 = 55;
        TokeniserState r267 = new AnonymousClass56(r265, r266);
        BeforeDoctypePublicIdentifier = r267;
        final String r268 = "DoctypePublicIdentifier_doubleQuoted";
        final int r269 = 56;
        TokeniserState r270 = new AnonymousClass57(r268, r269);
        DoctypePublicIdentifier_doubleQuoted = r270;
        final String r271 = "DoctypePublicIdentifier_singleQuoted";
        final int r272 = 57;
        TokeniserState r273 = new AnonymousClass58(r271, r272);
        DoctypePublicIdentifier_singleQuoted = r273;
        final String r274 = "AfterDoctypePublicIdentifier";
        final int r275 = 58;
        TokeniserState r276 = new AnonymousClass59(r274, r275);
        AfterDoctypePublicIdentifier = r276;
        final String r277 = "BetweenDoctypePublicAndSystemIdentifiers";
        final int r278 = 59;
        TokeniserState r279 = new AnonymousClass60(r277, r278);
        BetweenDoctypePublicAndSystemIdentifiers = r279;
        final String r280 = "AfterDoctypeSystemKeyword";
        final int r281 = 60;
        TokeniserState r282 = new AnonymousClass61(r280, r281);
        AfterDoctypeSystemKeyword = r282;
        final String r283 = "BeforeDoctypeSystemIdentifier";
        final int r284 = 61;
        TokeniserState r285 = new AnonymousClass62(r283, r284);
        BeforeDoctypeSystemIdentifier = r285;
        final String r286 = "DoctypeSystemIdentifier_doubleQuoted";
        final int r287 = 62;
        TokeniserState r288 = new AnonymousClass63(r286, r287);
        DoctypeSystemIdentifier_doubleQuoted = r288;
        final String r289 = "DoctypeSystemIdentifier_singleQuoted";
        final int r290 = 63;
        TokeniserState r291 = new AnonymousClass64(r289, r290);
        DoctypeSystemIdentifier_singleQuoted = r291;
        final String r292 = "AfterDoctypeSystemIdentifier";
        final int r293 = 64;
        TokeniserState r294 = new AnonymousClass65(r292, r293);
        AfterDoctypeSystemIdentifier = r294;
        final String r295 = "BogusDoctype";
        final int r296 = 65;
        TokeniserState r297 = new AnonymousClass66(r295, r296);
        BogusDoctype = r297;
        final String r298 = "CdataSection";
        final int r299 = 66;
        TokeniserState r300 = new AnonymousClass67(r298, r299);
        CdataSection = r300;
        f525989b = new TokeniserState[]{r102, r105, r108, r111, r114, r117, r120, r123, r126, r129, r132, r135, r138, r141, r144, r147, r150, r153, r156, r159, r162, r165, r168, r171, r174, r177, r180, r183, r186, r189, r192, r195, r198, r201, r204, r207, r210, r213, r216, r219, r222, r225, r228, r231, r234, r237, r240, r243, r246, r249, r252, r255, r258, r261, r264, r267, r270, r273, r276, r279, r282, r285, r288, r291, r294, r297, r300};
        attributeNameCharsSorted = new char[]{'\t', '\n', '\f', '\r', ' ', Typography.quote, '\'', '/', Typography.less, com.alipay.sdk.m.n.a.f25612h, Typography.greater};
        attributeValueUnquoted = new char[]{0, '\t', '\n', '\f', '\r', ' ', Typography.quote, Typography.amp, '\'', Typography.less, com.alipay.sdk.m.n.a.f25612h, Typography.greater, '`'};
        f525988a = String.valueOf(65533);
    }

    public static TokeniserState[] values() {
        return (TokeniserState[]) f525989b.clone();
    }

    public static /* synthetic */ String access$300() {
        return f525988a;
    }

    public static TokeniserState valueOf(String r100) {
        return (TokeniserState) r27.a.a(TokeniserState.class, r100);
    }

    public static void access$100(h r100, TokeniserState r101) {
        int[] r102 = r100.c(null, false);
        if (r102 != null) goto L5;
        r100.f(Typography.amp);
    L6:
        r100.p(r101);
        return;
    L5:
        r100.g(new String(r102, 0, r102.length));
        goto L6
    }

    public TokeniserState(String r100, int r101, AnonymousClass1 r102) {
        super(r100, r101);
    }

    public static void access$500(h r100, a r101, TokeniserState r102) {
        if (r101.u() == false) goto L6;
        String r103 = r101.h();
        r100.f526057k.k(r103);
        r100.f526054h.append(r103);
        return;
    L6:
        if (r100.o() == true) goto L8;
    L28:
        boolean r104 = true;
    L29:
        if (r104 == false) goto L33;
        r100.g("</");
        r100.h(r100.f526054h);
        r100.p(r102);
        return;
    L33:
        return;
    L8:
        if (r101.n() == true) goto L28;
        char r105 = r101.e();
        if (r105 != '\t') goto L12;
    L26:
        r100.p(BeforeAttributeName);
    L27:
        r104 = false;
        goto L29
    L12:
        if (r105 == '\n') goto L26;
        if (r105 == '\f') goto L26;
        if (r105 == '\r') goto L26;
        if (r105 == ' ') goto L26;
        if (r105 != '/') goto L22;
        r100.p(SelfClosingStartTag);
        goto L27
    L22:
        if (r105 == '>') goto L24;
        r100.f526054h.append(r105);
        goto L28
    L24:
        r100.l();
        r100.p(Data);
        goto L27
    }

    public static void access$200(h r100, a r101, TokeniserState r102, TokeniserState r103) {
        char r104 = r101.l();
        if (r104 != 0) goto L5;
        r100.n(r102);
        r101.a();
        r100.f(65533);
        return;
    L5:
        if (r104 != '<') goto L7;
        r100.a(r103);
        return;
    L7:
        if (r104 == 65535) goto L19;
        int r105 = r101.f525994e;
        int r106 = r101.f525992c;
        char[] r107 = r101.f525990a;
        int r108 = r105;
    L9:
        if (r108 >= r106) goto L14;
        char r109 = r107[r108];
        if (r109 == 0) goto L14;
        if (r109 == '<') goto L14;
        r108 = r108 + 1;
    L14:
        r101.f525994e = r108;
        if (r108 <= r105) goto L17;
        String r110 = a.c(r101.f525990a, r101.f525997h, r105, r108 - r105);
    L18:
        r100.g(r110);
        return;
    L17:
        r110 = "";
        goto L18
    L19:
        r100.i(new Token.e());
    }

    public static void access$400(h r100, a r101, TokeniserState r102, TokeniserState r103) {
        if (r101.t() == false) goto L5;
        r100.d(false);
        r100.p(r102);
        return;
    L5:
        r100.g("</");
        r100.p(r103);
    }

    public static void access$600(h r100, a r101, TokeniserState r102, TokeniserState r103) {
        if (r101.u() == false) goto L5;
        String r104 = r101.h();
        r100.f526054h.append(r104);
        r100.g(r104);
        return;
    L5:
        char r105 = r101.e();
        if (r105 == '\t') goto L21;
        if (r105 == '\n') goto L21;
        if (r105 == '\f') goto L21;
        if (r105 == '\r') goto L21;
        if (r105 == ' ') goto L21;
        if (r105 == '/') goto L21;
        if (r105 == '>') goto L21;
        r101.y();
        r100.p(r103);
        return;
    L21:
        if (r100.f526054h.toString().equals("script") == false) goto L23;
        r100.p(r102);
    L24:
        r100.f(r105);
        return;
    L23:
        r100.p(r103);
        goto L24
    }
}
