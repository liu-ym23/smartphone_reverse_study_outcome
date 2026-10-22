package org.jsoup.parser;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Arrays;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.jsoup.helper.ValidationException;
import org.jsoup.nodes.Entities;

/* JADX INFO: loaded from: classes42.dex */
public final class h {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final char[] f526045t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int[] f526046u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.jsoup.parser.a f526047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParseErrorList f526048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TokeniserState f526049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Token f526050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f526051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public String f526052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StringBuilder f526053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StringBuilder f526054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Token.g f526055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Token.f f526056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Token.h f526057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Token.b f526058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Token.d f526059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Token.c f526060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    public String f526061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public String f526062p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f526063q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int[] f526064r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f526065s;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f526066a = null;

        static {
            int[] r100 = new int[TokeniserState.values().length];
            f526066a = r100;
            r100[TokeniserState.TagOpen.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f526066a[TokeniserState.Data.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        char[] r100 = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        f526045t = r100;
        f526046u = new int[]{8364, 129, AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel, 402, AVMDLDataLoader.KeyIsCustomUA, 8230, AVMDLDataLoader.KeyIsEnableSpeedEngine, AVMDLDataLoader.KeyIsEnableSpeedReport, 710, 8240, 352, 8249, 338, 141, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200, 143, 144, AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel, AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue, AVMDLDataLoader.KeyIsEnableSpeedPredict, AVMDLDataLoader.KeyIsP2PConfigStr, AVMDLDataLoader.KeyIsSpeedEngineSetting, 8211, 8212, TTVideoEngineInterface.PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 8482, 353, 8250, 339, 157, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY};
        Arrays.sort(r100);
    }

    public final void e() {
        Token.g(this.f526054h);
    }

    public final void j() {
        i(this.f526060n);
    }

    public final void k() {
        i(this.f526059m);
    }

    public final void l() {
        Token.h r100 = this.f526057k;
        if (r100.f525981f == false) goto L5;
        r100.o();
    L5:
        i(this.f526057k);
    }

    public final boolean o() {
        if (this.f526061o != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f526057k.m().equalsIgnoreCase(this.f526061o) == false) goto L7;
        return true;
    }

    public final void a(TokeniserState r100) {
        p(r100);
        this.f526047a.a();
    }

    public final Token.h d(boolean r100) {
        if (r100 == false) goto L4;
        Token.h r101 = this.f526055i;
        r101.p();
    L5:
        this.f526057k = r101;
        return r101;
    L4:
        r101 = this.f526056j;
        r101.p();
        goto L5
    }

    public final void f(char r100) {
        if (this.f526052f != null) goto L6;
        this.f526052f = String.valueOf(r100);
    L9:
        this.f526058l.getClass();
        int r101 = this.f526047a.f525995f;
        return;
    L6:
        if (this.f526053g.length() != 0) goto L8;
        this.f526053g.append(this.f526052f);
    L8:
        this.f526053g.append(r100);
        goto L9
    }

    public final void g(String r100) {
        if (this.f526052f != null) goto L6;
        this.f526052f = r100;
    L9:
        this.f526058l.getClass();
        int r101 = this.f526047a.f525995f;
        return;
    L6:
        if (this.f526053g.length() != 0) goto L8;
        this.f526053g.append(this.f526052f);
    L8:
        this.f526053g.append(r100);
        goto L9
    }

    public final void h(StringBuilder r100) {
        if (this.f526052f != null) goto L6;
        this.f526052f = r100.toString();
    L9:
        this.f526058l.getClass();
        int r101 = this.f526047a.f525995f;
        return;
    L6:
        if (this.f526053g.length() != 0) goto L8;
        this.f526053g.append(this.f526052f);
    L8:
        this.f526053g.append(r100);
        goto L9
    }

    public final void i(Token r100) {
        if (this.f526051e == true) goto L16;
        this.f526050d = r100;
        this.f526051e = true;
        r100.getClass();
        int r101 = this.f526047a.f525995f;
        this.f526063q = -1;
        Token.TokenType r102 = r100.f525967a;
        if (r102 != Token.TokenType.StartTag) goto L8;
        this.f526061o = ((Token.g) r100).f525977b;
        this.f526062p = null;
        return;
    L8:
        if (r102 != Token.TokenType.EndTag) goto L18;
        Token.f r103 = (Token.f) r100;
        if (r103.l() == false) goto L19;
        Object[] r104 = {r103.f525978c};
        if (this.f526048b.canAddError() == false) goto L20;
        this.f526048b.add(new c(this.f526047a, "Attributes incorrectly present on end tag [/%s]", r104));
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L16:
        throw new ValidationException("Must be false");
    }

    public final void m(TokeniserState r100) {
        if (this.f526048b.canAddError() == false) goto L6;
        this.f526048b.add(new c(this.f526047a, "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[]{r100}));
        return;
    }

    public final void n(TokeniserState r100) {
        if (this.f526048b.canAddError() == false) goto L6;
        ParseErrorList r101 = this.f526048b;
        org.jsoup.parser.a r102 = this.f526047a;
        r101.add(new c(r102, "Unexpected character '%s' in input state [%s]", new Object[]{Character.valueOf(r102.l()), r100}));
        return;
    }

    public final void p(TokeniserState r100) {
        int r101 = a.f526066a[r100.ordinal()];
        if (r101 != 1) goto L5;
        org.jsoup.parser.a r102 = this.f526047a;
        int r103 = r102.f525995f;
        int r104 = r102.f525994e;
    L11:
        this.f526049c = r100;
        return;
    L5:
        if (r101 != 2) goto L11;
        if (this.f526063q != (-1)) goto L11;
        org.jsoup.parser.a r105 = this.f526047a;
        this.f526063q = r105.f525995f + r105.f525994e;
        goto L11
    }

    public h(org.jsoup.parser.a r100, ParseErrorList r101) {
        this.f526049c = TokeniserState.Data;
        this.f526050d = null;
        this.f526051e = false;
        this.f526052f = null;
        this.f526053g = new StringBuilder(1024);
        this.f526054h = new StringBuilder(1024);
        Token.g r102 = new Token.g();
        this.f526055i = r102;
        this.f526056j = new Token.f();
        this.f526057k = r102;
        this.f526058l = new Token.b();
        this.f526059m = new Token.d();
        this.f526060n = new Token.c();
        this.f526063q = -1;
        this.f526064r = new int[1];
        this.f526065s = new int[2];
        this.f526047a = r100;
        this.f526048b = r101;
    }

    public final void b(String r100, Object... r101) {
        if (this.f526048b.canAddError() == false) goto L6;
        this.f526048b.add(new c(this.f526047a, String.format("Invalid character reference: ".concat(r100), r101)));
        return;
    }

    @Nullable
    public final int[] c(@Nullable Character r110, boolean r111) {
        if (this.f526047a.n() == false) goto L5;
        return null;
    L5:
        if (r110 != null) goto L7;
    L9:
        org.jsoup.parser.a r100 = this.f526047a;
        char[] r101 = f526045t;
        r100.b();
        if (r100.n() == false) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == false) goto L17;
        return null;
    L17:
        int[] r103 = this.f526064r;
        org.jsoup.parser.a r104 = this.f526047a;
        if ((r104.f525992c - r104.f525994e) >= 1024) goto L20;
        r104.f525993d = 0;
    L20:
        r104.b();
        r104.f525996g = r104.f525994e;
        char r105 = 'A';
        if (this.f526047a.p("#") == false) goto L75;
        boolean r106 = this.f526047a.q("X");
        if (r106 == false) goto L38;
        org.jsoup.parser.a r112 = this.f526047a;
        r112.b();
        int r113 = r112.f525994e;
    L25:
        int r114 = r112.f525994e;
        if (r114 >= r112.f525992c) goto L37;
        char r115 = r112.f525990a[r114];
        if (r115 < '0') goto L30;
        if (r115 > '9') goto L30;
    L36:
        r112.f525994e = r114 + 1;
        r105 = 'A';
    L30:
        if (r115 >= r105) goto L32;
    L33:
        if (r115 < 'a') goto L37;
        if (r115 > 'f') goto L37;
    L32:
        if (r115 <= 'F') goto L36;
    L37:
        String r107 = org.jsoup.parser.a.c(r112.f525990a, r112.f525997h, r113, r114 - r113);
    L47:
        if (r107.length() != 0) goto L50;
        b("numeric reference with no numerals", new Object[0]);
        this.f526047a.w();
        return null;
    L50:
        org.jsoup.parser.a r108 = this.f526047a;
        r108.f525996g = -1;
        if (r108.p(com.alipay.sdk.m.u.i.f25853b) == true) goto L53;
        b("missing semicolon on [&#%s]", new Object[]{r107});
    L53:
        if (r106 == false) goto L55;
        int r109 = 16;
    L150:
        int r116 = CastIntegerProtector.valueOf(r107, r109).intValue();     // Catch: NumberFormatException -> L58
    L59:
        if (r116 != (-1)) goto L61;
    L73:
        b("character [%s] outside of valid range", new Object[]{Integer.valueOf(r116)});
        r103[0] = 65533;
    L74:
        return r103;
    L61:
        if (r116 < 55296) goto L65;
        if (r116 <= 57343) goto L73;
    L65:
        if (r116 > 1114111) goto L73;
        if (r116 >= 128) goto L70;
    L72:
        r103[0] = r116;
        goto L74
    L70:
        if (r116 >= 160) goto L72;
        b("character [%s] is not a valid unicode code point", new Object[]{Integer.valueOf(r116)});
        r116 = f526046u[r116 + com.alipay.sdk.m.n.a.f25611g];
    L58:
        r116 = -1;
        goto L59
    L55:
        r109 = 10;
        goto L150
    L38:
        org.jsoup.parser.a r117 = this.f526047a;
        r117.b();
        int r118 = r117.f525994e;
    L39:
        int r119 = r117.f525994e;
        if (r119 >= r117.f525992c) goto L45;
        char r120 = r117.f525990a[r119];
        if (r120 < '0') goto L45;
        if (r120 > '9') goto L45;
        r117.f525994e = r119 + 1;
    L45:
        r107 = org.jsoup.parser.a.c(r117.f525990a, r117.f525997h, r118, r119 - r118);
        goto L47
    L75:
        org.jsoup.parser.a r121 = this.f526047a;
        r121.b();
        int r122 = r121.f525994e;
    L76:
        int r123 = r121.f525994e;
        if (r123 >= r121.f525992c) goto L88;
        char r124 = r121.f525990a[r123];
        if (r124 >= 'A') goto L81;
    L82:
        if (r124 < 'a') goto L86;
        if (r124 > 'z') goto L86;
    L87:
        r121.f525994e++;
    L86:
        if (Character.isLetter(r124) == false) goto L88;
    L81:
        if (r124 <= 'Z') goto L87;
    L88:
        int r125 = r121.f525994e;
        if (r125 < r121.f525992c) goto L91;
        boolean r126 = true;
    L92:
        if (r126 == true) goto L97;
        char r127 = r121.f525990a[r125];
        if (r127 < '0') goto L97;
        if (r127 > '9') goto L97;
        r121.f525994e = r125 + 1;
    L97:
        String r128 = org.jsoup.parser.a.c(r121.f525990a, r121.f525997h, r122, r125 - r122);
        boolean r129 = this.f526047a.r(';');
        char[] r130 = Entities.f525911a;
        if (Entities.EscapeMode.base.codepointForName(r128) == (-1)) goto L100;
        boolean r131 = true;
    L101:
        if (r131 == false) goto L103;
    L110:
        boolean r132 = true;
    L111:
        if (r132 == true) goto L116;
        this.f526047a.w();
        if (r129 == false) goto L115;
        b("invalid named reference [%s]", new Object[]{r128});
    L115:
        return null;
    L116:
        if (r111 == true) goto L118;
    L132:
        org.jsoup.parser.a r133 = this.f526047a;
        r133.f525996g = -1;
        if (r133.p(com.alipay.sdk.m.u.i.f25853b) == true) goto L135;
        b("missing semicolon on [&%s]", new Object[]{r128});
    L135:
        int[] r134 = this.f526065s;
        String r135 = Entities.f525912b.get(r128);
        if (r135 == null) goto L138;
        r134[0] = r135.codePointAt(0);
        r134[1] = r135.codePointAt(1);
        char r136 = 2;
    L142:
        if (r136 != 1) goto L145;
        r103[0] = this.f526065s[0];
        return r103;
    L145:
        if (r136 != 2) goto L149;
        return this.f526065s;
    L149:
        throw new ValidationException("Unexpected characters returned for ".concat(r128));
    L138:
        int r137 = Entities.EscapeMode.extended.codepointForName(r128);
        if (r137 == (-1)) goto L141;
        r134[0] = r137;
        r136 = 1;
        goto L142
    L141:
        r136 = 0;
        goto L142
    L118:
        if (this.f526047a.u() == true) goto L130;
        org.jsoup.parser.a r138 = this.f526047a;
        if (r138.n() == true) goto L126;
        char r139 = r138.f525990a[r138.f525994e];
        if (r139 < '0') goto L126;
        if (r139 > '9') goto L126;
        boolean r140 = true;
    L127:
        if (r140 == true) goto L130;
        if (this.f526047a.s(new char[]{com.alipay.sdk.m.n.a.f25612h, '-', '_'}) == false) goto L132;
    L126:
        r140 = false;
    L130:
        this.f526047a.w();
        return null;
    L103:
        if (Entities.EscapeMode.extended.codepointForName(r128) == (-1)) goto L105;
        boolean r141 = true;
    L106:
        if (r141 == false) goto L109;
        if (r129 == true) goto L110;
    L109:
        r132 = false;
        goto L111
    L105:
        r141 = false;
        goto L106
    L100:
        r131 = false;
        goto L101
    L91:
        r126 = false;
        goto L92
    L12:
        if (Arrays.binarySearch(r101, r100.f525990a[r100.f525994e]) < 0) goto L14;
        r102 = true;
        goto L15
    L7:
        if (r110.charValue() != this.f526047a.l()) goto L9;
        return null;
    }
}
