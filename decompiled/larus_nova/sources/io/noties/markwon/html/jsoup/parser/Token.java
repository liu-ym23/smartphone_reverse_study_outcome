package io.noties.markwon.html.jsoup.parser;

import com.larksuite.component.card.protocol.data.person.Character;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public abstract class Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TokenType f492582a;

    public static final enum TokenType extends Enum<TokenType> {
        public static final TokenType Character = null;
        public static final TokenType Comment = null;
        public static final TokenType Doctype = null;
        public static final TokenType EOF = null;
        public static final TokenType EndTag = null;
        public static final TokenType StartTag = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TokenType[] f492583a = null;

        static {
            TokenType r100 = new TokenType("Doctype", 0);
            Doctype = r100;
            TokenType r101 = new TokenType("StartTag", 1);
            StartTag = r101;
            TokenType r102 = new TokenType("EndTag", 2);
            EndTag = r102;
            TokenType r103 = new TokenType("Comment", 3);
            Comment = r103;
            TokenType r104 = new TokenType(Character.TAG, 4);
            Character = r104;
            TokenType r105 = new TokenType("EOF", 5);
            EOF = r105;
            f492583a = new TokenType[]{r100, r101, r102, r103, r104, r105};
        }

        public static TokenType[] values() {
            return (TokenType[]) f492583a.clone();
        }

        public static TokenType valueOf(String r100) {
            return (TokenType) r27.a.a(TokenType.class, r100);
        }

        public TokenType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends b {
        @Override // io.noties.markwon.html.jsoup.parser.Token.b
        public final String toString() {
            return "<![CDATA[" + this.f492584b + "]]>";
        }

        public a(String r100) {
            this.f492584b = r100;
        }
    }

    public static class b extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f492584b;

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public final Token a() {
            this.f492584b = null;
            return this;
        }

        public b() {
            super(TokenType.Character);
        }

        public String toString() {
            return this.f492584b;
        }
    }

    public static final class c extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f492585b;

        public c() {
            super(TokenType.Comment);
            this.f492585b = new StringBuilder();
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public final Token a() {
            Token.b(this.f492585b);
            return this;
        }

        public final String toString() {
            return "<!--" + this.f492585b.toString() + "-->";
        }
    }

    public static final class d extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f492586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final StringBuilder f492587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final StringBuilder f492588d;

        public d() {
            super(TokenType.Doctype);
            this.f492586b = new StringBuilder();
            this.f492587c = new StringBuilder();
            this.f492588d = new StringBuilder();
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public final Token a() {
            Token.b(this.f492586b);
            Token.b(this.f492587c);
            Token.b(this.f492588d);
            return this;
        }
    }

    public static final class e extends Token {
        @Override // io.noties.markwon.html.jsoup.parser.Token
        public final Token a() {
            return this;
        }

        public e() {
            super(TokenType.EOF);
        }
    }

    public static final class f extends h {
        public f() {
            super(TokenType.EndTag);
        }

        public final String toString() {
            return "</" + h() + ">";
        }
    }

    public static final class g extends h {
        public g() {
            super(TokenType.StartTag);
            this.f492597j = new io.noties.markwon.html.jsoup.nodes.b();
        }

        public final String toString() {
            io.noties.markwon.html.jsoup.nodes.b r100 = this.f492597j;
            if (r100 == null) goto L9;
            if (r100.f492575a <= 0) goto L9;
            return "<" + h() + " " + this.f492597j.toString() + ">";
        L9:
            return "<" + h() + ">";
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.h
        public final h j() {
            super.j();
            this.f492597j = new io.noties.markwon.html.jsoup.nodes.b();
            return this;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.h, io.noties.markwon.html.jsoup.parser.Token
        public final /* bridge */ /* synthetic */ Token a() {
            j();
            return this;
        }
    }

    public static abstract class h extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f492589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f492590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f492591d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final StringBuilder f492592e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f492593f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f492594g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f492595h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f492596i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public io.noties.markwon.html.jsoup.nodes.b f492597j;

        public h j() {
            this.f492589b = null;
            this.f492590c = null;
            this.f492591d = null;
            Token.b(this.f492592e);
            this.f492593f = null;
            this.f492594g = false;
            this.f492595h = false;
            this.f492596i = false;
            this.f492597j = null;
            return this;
        }

        public final String h() {
            String r100 = this.f492589b;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == true) goto L13;
            return this.f492589b;
        L13:
            throw new IllegalArgumentException("Must be false");
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        public final void i() {
            if (this.f492597j != null) goto L5;
            this.f492597j = new io.noties.markwon.html.jsoup.nodes.b();
        L5:
            String r100 = this.f492591d;
            if (r100 == null) goto L40;
            String r101 = r100.trim();
            this.f492591d = r101;
            if (r101.length() <= 0) goto L40;
            if (this.f492595h == false) goto L16;
            if (this.f492592e.length() <= 0) goto L14;
            String r102 = this.f492592e.toString();
        L19:
            io.noties.markwon.html.jsoup.nodes.b r103 = this.f492597j;
            String r104 = this.f492591d;
            int r105 = r103.a(r104);
            if (r105 == (-1)) goto L22;
            r103.f492577c[r105] = r102;
            goto L40
        L22:
            int r106 = r103.f492575a;
            int r107 = r106 + 1;
            if (r107 < r106) goto L25;
            boolean r108 = true;
        L26:
            if (r108 == false) goto L39;
            String[] r109 = r103.f492576b;
            int r110 = r109.length;
            if (r110 >= r107) goto L37;
            int r111 = 4;
            if (r110 < 4) goto L33;
            r111 = r106 * 2;
        L33:
            if (r107 > r111) goto L36;
            r107 = r111;
        L36:
            String[] r112 = new String[r107];
            System.arraycopy(r109, 0, r112, 0, Math.min(r109.length, r107));
            r103.f492576b = r112;
            String[] r113 = r103.f492577c;
            String[] r114 = new String[r107];
            System.arraycopy(r113, 0, r114, 0, Math.min(r113.length, r107));
            r103.f492577c = r114;
        L37:
            String[] r115 = r103.f492576b;
            int r116 = r103.f492575a;
            r115[r116] = r104;
            r103.f492577c[r116] = r102;
            r103.f492575a = r116 + 1;
            goto L40
        L39:
            throw new IllegalArgumentException("Must be true");
        L25:
            r108 = false;
            goto L26
        L14:
            r102 = this.f492593f;
            goto L19
        L16:
            if (this.f492594g == false) goto L18;
            r102 = "";
            goto L19
        L18:
            r102 = null;
        L40:
            this.f492591d = null;
            this.f492594g = false;
            this.f492595h = false;
            Token.b(this.f492592e);
            this.f492593f = null;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public /* bridge */ /* synthetic */ Token a() {
            return j();
        }

        public h(TokenType r100) {
            super(r100);
            this.f492592e = new StringBuilder();
            this.f492594g = false;
            this.f492595h = false;
            this.f492596i = false;
        }

        public final void c(char r100) {
            String r101 = String.valueOf(r100);
            String r102 = this.f492591d;
            if (r102 == null) goto L6;
            r101 = r102.concat(r101);
        L6:
            this.f492591d = r101;
        }

        public final void d(char r100) {
            this.f492595h = true;
            String r101 = this.f492593f;
            if (r101 == null) goto L5;
            this.f492592e.append(r101);
            this.f492593f = null;
        L5:
            this.f492592e.append(r100);
        }

        public final void e(String r100) {
            this.f492595h = true;
            String r101 = this.f492593f;
            if (r101 == null) goto L6;
            this.f492592e.append(r101);
            this.f492593f = null;
        L6:
            if (this.f492592e.length() != 0) goto L8;
            this.f492593f = r100;
            return;
        L8:
            this.f492592e.append(r100);
        }

        public final void f(int[] r100) {
            this.f492595h = true;
            String r101 = this.f492593f;
            if (r101 == null) goto L5;
            this.f492592e.append(r101);
            this.f492593f = null;
        L5:
            int r102 = r100.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L8;
            int r104 = r100[r103];
            this.f492592e.appendCodePoint(r104);
            r103 = r103 + 1;
            goto L6
        }

        public final void g(String r100) {
            String r101 = this.f492589b;
            if (r101 == null) goto L6;
            r100 = r101.concat(r100);
        L6:
            this.f492589b = r100;
            if (r100 == null) goto L9;
            String r102 = r100.toLowerCase(Locale.ENGLISH);
        L10:
            this.f492590c = r102;
            return;
        L9:
            r102 = "";
            goto L10
        }
    }

    public abstract Token a();

    public Token(TokenType r100) {
        this.f492582a = r100;
    }

    public static void b(StringBuilder r100) {
        if (r100 == null) goto L5;
        r100.delete(0, r100.length());
        return;
    }
}
