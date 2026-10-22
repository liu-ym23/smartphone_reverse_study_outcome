package io.noties.markwon.html.jsoup.parser;

import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Arrays;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes41.dex */
public final class c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final char[] f492610r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f492611s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f492612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParseErrorList f492613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TokeniserState f492614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Token f492615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f492616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f492617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StringBuilder f492618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StringBuilder f492619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Token.h f492620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Token.g f492621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Token.f f492622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Token.b f492623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Token.d f492624m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Token.c f492625n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f492626o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int[] f492627p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int[] f492628q;

    static {
        char[] r100 = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        f492610r = r100;
        f492611s = new int[]{8364, 129, AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel, 402, AVMDLDataLoader.KeyIsCustomUA, 8230, AVMDLDataLoader.KeyIsEnableSpeedEngine, AVMDLDataLoader.KeyIsEnableSpeedReport, 710, 8240, 352, 8249, 338, 141, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200, 143, 144, AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel, AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue, AVMDLDataLoader.KeyIsEnableSpeedPredict, AVMDLDataLoader.KeyIsP2PConfigStr, AVMDLDataLoader.KeyIsSpeedEngineSetting, 8211, 8212, TTVideoEngineInterface.PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD, 8482, 353, 8250, 339, 157, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY};
        Arrays.sort(r100);
    }

    public final void e() {
        Token.b(this.f492619h);
    }

    public final void i() {
        g(this.f492625n);
    }

    public final void j() {
        g(this.f492624m);
    }

    public final void k() {
        Token.h r100 = this.f492620i;
        if (r100.f492591d == null) goto L5;
        r100.i();
    L5:
        g(this.f492620i);
    }

    public final boolean n() {
        if (this.f492626o != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f492620i.h().equalsIgnoreCase(this.f492626o) == false) goto L7;
        return true;
    }

    public final Token o() {
    L3:
        if (this.f492616e == true) goto L6;
        this.f492614c.read(this, this.f492612a);
        goto L3
    L6:
        if (this.f492618g.length() <= 0) goto L9;
        String r100 = this.f492618g.toString();
        StringBuilder r101 = this.f492618g;
        r101.delete(0, r101.length());
        this.f492617f = null;
        Token.b r102 = this.f492623l;
        r102.f492584b = r100;
        return r102;
    L9:
        String r103 = this.f492617f;
        if (r103 == null) goto L13;
        Token.b r104 = this.f492623l;
        r104.f492584b = r103;
        this.f492617f = null;
        return r104;
    L13:
        this.f492616e = false;
        return this.f492615d;
    }

    public final void a(TokeniserState r100) {
        this.f492612a.a();
        this.f492614c = r100;
    }

    public final void b(String r100) {
        if (this.f492613b.canAddError() == false) goto L6;
        ParseErrorList r101 = this.f492613b;
        a r102 = this.f492612a;
        r101.add(new b(r102.f492605f + r102.f492604e, "Invalid character reference: %s", new Object[]{r100}));
        return;
    }

    public final Token.h d(boolean r100) {
        if (r100 == false) goto L4;
        Token.h r101 = this.f492621j;
        r101.j();
    L5:
        this.f492620i = r101;
        return r101;
    L4:
        r101 = this.f492622k;
        r101.j();
        goto L5
    }

    public final void f(char r100) {
        h(String.valueOf(r100));
    }

    public final void g(Token r100) {
        if (this.f492616e == true) goto L16;
        this.f492615d = r100;
        this.f492616e = true;
        Token.TokenType r101 = r100.f492582a;
        if (r101 != Token.TokenType.StartTag) goto L8;
        this.f492626o = ((Token.g) r100).f492589b;
        return;
    L8:
        if (r101 == Token.TokenType.EndTag) goto L10;
        return;
    L10:
        if (((Token.f) r100).f492597j != null) goto L12;
        return;
    L12:
        if (this.f492613b.canAddError() == false) goto L20;
        ParseErrorList r102 = this.f492613b;
        a r103 = this.f492612a;
        r102.add(new b(r103.f492605f + r103.f492604e));
        return;
    L20:
        return;
    L16:
        throw new IllegalArgumentException("There is an unread token pending!");
    }

    public final void h(String r100) {
        if (this.f492617f != null) goto L6;
        this.f492617f = r100;
        return;
    L6:
        if (this.f492618g.length() != 0) goto L8;
        this.f492618g.append(this.f492617f);
    L8:
        this.f492618g.append(r100);
    }

    public final void l(TokeniserState r100) {
        if (this.f492613b.canAddError() == false) goto L6;
        ParseErrorList r101 = this.f492613b;
        a r102 = this.f492612a;
        r101.add(new b(r102.f492605f + r102.f492604e, "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[]{r100}));
        return;
    }

    public final void m(TokeniserState r100) {
        if (this.f492613b.canAddError() == false) goto L6;
        ParseErrorList r101 = this.f492613b;
        a r102 = this.f492612a;
        r101.add(new b(r102.f492605f + r102.f492604e, "Unexpected character '%s' in input state [%s]", new Object[]{Character.valueOf(r102.i()), r100}));
        return;
    }

    public c(a r100, ParseErrorList r101) {
        this.f492614c = TokeniserState.Data;
        this.f492616e = false;
        this.f492617f = null;
        this.f492618g = new StringBuilder(1024);
        this.f492619h = new StringBuilder(1024);
        this.f492621j = new Token.g();
        this.f492622k = new Token.f();
        this.f492623l = new Token.b();
        this.f492624m = new Token.d();
        this.f492625n = new Token.c();
        this.f492627p = new int[1];
        this.f492628q = new int[2];
        this.f492612a = r100;
        this.f492613b = r101;
    }

    public final int[] c(Character r110, boolean r111) {
        if (this.f492612a.j() == false) goto L5;
        return null;
    L5:
        if (r110 != null) goto L7;
    L9:
        a r112 = this.f492612a;
        char[] r100 = f492610r;
        r112.b();
        if (r112.j() == false) goto L12;
    L14:
        boolean r113 = false;
    L15:
        if (r113 == false) goto L17;
        return null;
    L17:
        int[] r114 = this.f492627p;
        a r101 = this.f492612a;
        r101.f492606g = r101.f492604e;
        if (r101.k("#") == false) goto L74;
        boolean r115 = this.f492612a.l("X");
        a r102 = this.f492612a;
        if (r115 == false) goto L35;
        r102.b();
        int r103 = r102.f492604e;
    L22:
        int r116 = r102.f492604e;
        if (r116 >= r102.f492602c) goto L34;
        char r117 = r102.f492600a[r116];
        if (r117 < '0') goto L27;
        if (r117 > '9') goto L27;
    L33:
        r102.f492604e = r116 + 1;
    L27:
        if (r117 >= 'A') goto L29;
    L30:
        if (r117 < 'a') goto L34;
        if (r117 > 'f') goto L34;
    L29:
        if (r117 <= 'F') goto L33;
    L34:
        String r104 = a.c(r102.f492600a, r102.f492607h, r103, r116 - r103);
    L44:
        if (r104.length() != 0) goto L48;
        b("numeric reference with no numerals");
        a r118 = this.f492612a;
        r118.f492604e = r118.f492606g;
        return null;
    L48:
        if (this.f492612a.k(i.f25853b) == true) goto L50;
        b("missing semicolon");
    L50:
        if (r115 == false) goto L52;
        int r119 = 16;
    L144:
        int r120 = CastIntegerProtector.valueOf(r104, r119).intValue();     // Catch: NumberFormatException -> L56
    L57:
        if (r120 != (-1)) goto L59;
    L72:
        b("character outside of valid range");
        r114[0] = 65533;
        return r114;
    L59:
        if (r120 < 55296) goto L63;
        if (r120 <= 57343) goto L72;
    L63:
        if (r120 > 1114111) goto L72;
        if (r120 >= 128) goto L68;
    L70:
        r114[0] = r120;
        return r114;
    L68:
        if (r120 >= 160) goto L70;
        b("character is not a valid unicode code point");
        r120 = f492611s[r120 + com.alipay.sdk.m.n.a.f25611g];
    L56:
        r120 = -1;
        goto L57
    L52:
        r119 = 10;
        goto L144
    L35:
        r102.b();
        int r105 = r102.f492604e;
    L36:
        int r106 = r102.f492604e;
        if (r106 >= r102.f492602c) goto L42;
        char r107 = r102.f492600a[r106];
        if (r107 < '0') goto L42;
        if (r107 > '9') goto L42;
        r102.f492604e = r106 + 1;
    L42:
        r104 = a.c(r102.f492600a, r102.f492607h, r105, r106 - r105);
        goto L44
    L74:
        a r108 = this.f492612a;
        r108.b();
        int r121 = r108.f492604e;
    L75:
        int r122 = r108.f492604e;
        if (r122 >= r108.f492602c) goto L87;
        char r123 = r108.f492600a[r122];
        if (r123 >= 'A') goto L80;
    L81:
        if (r123 < 'a') goto L85;
        if (r123 > 'z') goto L85;
    L86:
        r108.f492604e++;
    L85:
        if (Character.isLetter(r123) == false) goto L87;
    L80:
        if (r123 <= 'Z') goto L86;
    L87:
        int r109 = r108.f492604e;
        if (r109 < r108.f492602c) goto L90;
        boolean r124 = true;
    L91:
        if (r124 == true) goto L96;
        char r125 = r108.f492600a[r109];
        if (r125 < '0') goto L96;
        if (r125 > '9') goto L96;
        r108.f492604e = r109 + 1;
    L96:
        String r126 = a.c(r108.f492600a, r108.f492607h, r121, r109 - r121);
        boolean r127 = this.f492612a.m(';');
        if (io.noties.markwon.html.jsoup.nodes.c.a(r126) == null) goto L99;
        boolean r128 = true;
    L100:
        if (r128 == false) goto L103;
        if (r127 == false) goto L103;
        boolean r129 = true;
    L104:
        if (r129 == true) goto L109;
        a r130 = this.f492612a;
        r130.f492604e = r130.f492606g;
        if (r127 == false) goto L108;
        b(String.format("invalid named referenece '%s'", new Object[]{r126}));
    L108:
        return null;
    L109:
        if (r111 == false) goto L126;
        if (this.f492612a.o() == true) goto L123;
        a r131 = this.f492612a;
        if (r131.j() == true) goto L119;
        char r132 = r131.f492600a[r131.f492604e];
        if (r132 < '0') goto L119;
        if (r132 > '9') goto L119;
        boolean r133 = true;
    L120:
        if (r133 == true) goto L123;
        if (this.f492612a.n(new char[]{com.alipay.sdk.m.n.a.f25612h, '-', '_'}) == false) goto L126;
    L119:
        r133 = false;
    L123:
        a r134 = this.f492612a;
        r134.f492604e = r134.f492606g;
        return null;
    L126:
        if (this.f492612a.k(i.f25853b) == true) goto L128;
        b("missing semicolon");
    L128:
        int[] r135 = this.f492628q;
        String r136 = io.noties.markwon.html.jsoup.nodes.c.a(r126);
        if (r136 == null) goto L134;
        int r137 = r136.length();
        if (r137 != 1) goto L133;
        r135[0] = r136.charAt(0);
    L135:
        if (r137 != 1) goto L139;
        r114[0] = this.f492628q[0];
        return r114;
    L139:
        if (r137 != 2) goto L143;
        return this.f492628q;
    L143:
        throw new IllegalArgumentException("Unexpected characters returned for ".concat(r126));
    L133:
        r135[0] = r136.charAt(0);
        r135[1] = r136.charAt(1);
        goto L135
    L134:
        r137 = 0;
    L103:
        r129 = false;
        goto L104
    L99:
        r128 = false;
        goto L100
    L90:
        r124 = false;
        goto L91
    L12:
        if (Arrays.binarySearch(r100, r112.f492600a[r112.f492604e]) < 0) goto L14;
        r113 = true;
        goto L15
    L7:
        if (r110.charValue() != this.f492612a.i()) goto L9;
        return null;
    }
}
