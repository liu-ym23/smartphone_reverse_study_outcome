package org.jsoup.parser;

import com.larksuite.component.card.protocol.data.person.Character;
import javax.annotation.Nullable;
import org.jsoup.helper.ValidationException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Token {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TokenType f525967a;

    public static final enum TokenType extends Enum<TokenType> {
        public static final TokenType Character = null;
        public static final TokenType Comment = null;
        public static final TokenType Doctype = null;
        public static final TokenType EOF = null;
        public static final TokenType EndTag = null;
        public static final TokenType StartTag = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TokenType[] f525968a = null;

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
            f525968a = new TokenType[]{r100, r101, r102, r103, r104, r105};
        }

        public static TokenType[] values() {
            return (TokenType[]) f525968a.clone();
        }

        public static TokenType valueOf(String r100) {
            return (TokenType) r27.a.a(TokenType.class, r100);
        }

        public TokenType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends b {
        @Override // org.jsoup.parser.Token.b
        public final String toString() {
            return "<![CDATA[" + this.f525969b + "]]>";
        }

        public a(String r100) {
            this.f525969b = r100;
        }
    }

    public static class b extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f525969b;

        @Override // org.jsoup.parser.Token
        public final void f() {
            this.f525969b = null;
        }

        public b() {
            this.f525967a = TokenType.Character;
        }

        public String toString() {
            return this.f525969b;
        }
    }

    public static final class c extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f525970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f525971c;

        @Override // org.jsoup.parser.Token
        public final void f() {
            Token.g(this.f525970b);
            this.f525971c = null;
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder("<!--");
            String r101 = this.f525971c;
            if (r101 != null) goto L6;
            r101 = this.f525970b.toString();
        L6:
            r100.append(r101);
            r100.append("-->");
            return r100.toString();
        }

        public c() {
            this.f525970b = new StringBuilder();
            this.f525967a = TokenType.Comment;
        }

        public final void h(char r100) {
            String r101 = this.f525971c;
            if (r101 == null) goto L5;
            this.f525970b.append(r101);
            this.f525971c = null;
        L5:
            this.f525970b.append(r100);
        }

        public final void i(String r100) {
            String r101 = this.f525971c;
            if (r101 == null) goto L6;
            this.f525970b.append(r101);
            this.f525971c = null;
        L6:
            if (this.f525970b.length() != 0) goto L8;
            this.f525971c = r100;
            return;
        L8:
            this.f525970b.append(r100);
        }
    }

    public static final class d extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StringBuilder f525972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f525973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final StringBuilder f525974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final StringBuilder f525975e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f525976f;

        @Override // org.jsoup.parser.Token
        public final void f() {
            Token.g(this.f525972b);
            this.f525973c = null;
            Token.g(this.f525974d);
            Token.g(this.f525975e);
            this.f525976f = false;
        }

        public final String toString() {
            return "<!doctype " + this.f525972b.toString() + ">";
        }

        public d() {
            this.f525972b = new StringBuilder();
            this.f525973c = null;
            this.f525974d = new StringBuilder();
            this.f525975e = new StringBuilder();
            this.f525976f = false;
            this.f525967a = TokenType.Doctype;
        }
    }

    public static final class e extends Token {
        @Override // org.jsoup.parser.Token
        public final void f() {
        }

        public final String toString() {
            return "";
        }

        public e() {
            this.f525967a = TokenType.EOF;
        }
    }

    public static final class f extends h {
        public final String toString() {
            StringBuilder r100 = new StringBuilder("</");
            String r101 = this.f525977b;
            if (r101 != null) goto L6;
            r101 = "[unset]";
        L6:
            r100.append(r101);
            r100.append(">");
            return r100.toString();
        }

        public f() {
            this.f525967a = TokenType.EndTag;
        }
    }

    public static final class g extends h {
        public g() {
            this.f525967a = TokenType.StartTag;
        }

        @Override // org.jsoup.parser.Token.h
        public final h p() {
            super.p();
            this.f525987l = null;
            return this;
        }

        public final String toString() {
            String r100 = "[unset]";
            if (l() == true) goto L5;
        L11:
            StringBuilder r101 = new StringBuilder("<");
            String r102 = this.f525977b;
            if (r102 == null) goto L14;
            r100 = r102;
        L14:
            r101.append(r100);
            r101.append(">");
            return r101.toString();
        L5:
            if (this.f525987l.f525924a <= 0) goto L11;
            StringBuilder r103 = new StringBuilder("<");
            String r104 = this.f525977b;
            if (r104 == null) goto L9;
            r100 = r104;
        L9:
            r103.append(r100);
            r103.append(" ");
            r103.append(this.f525987l.toString());
            r103.append(">");
            return r103.toString();
        }

        @Override // org.jsoup.parser.Token.h, org.jsoup.parser.Token
        public final /* bridge */ /* synthetic */ void f() {
            p();
        }
    }

    public static abstract class h extends Token {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public String f525977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public String f525978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final StringBuilder f525979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public String f525980e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f525981f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final StringBuilder f525982g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f525983h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f525984i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f525985j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f525986k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public org.jsoup.nodes.b f525987l;

        public h p() {
            this.f525977b = null;
            this.f525978c = null;
            Token.g(this.f525979d);
            this.f525980e = null;
            this.f525981f = false;
            Token.g(this.f525982g);
            this.f525983h = null;
            this.f525985j = false;
            this.f525984i = false;
            this.f525986k = false;
            this.f525987l = null;
            return this;
        }

        public final boolean l() {
            if (this.f525987l == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final String m() {
            String r100 = this.f525977b;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == true) goto L13;
            return this.f525977b;
        L13:
            throw new ValidationException("Must be false");
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        public final void o() {
            if (this.f525987l != null) goto L6;
            this.f525987l = new org.jsoup.nodes.b();
        L6:
            if (this.f525981f == true) goto L8;
        L26:
            Token.g(this.f525979d);
            this.f525980e = null;
            this.f525981f = false;
            Token.g(this.f525982g);
            this.f525983h = null;
            this.f525984i = false;
            this.f525985j = false;
            return;
        L8:
            if (this.f525987l.f525924a >= 512) goto L26;
            if (this.f525979d.length() <= 0) goto L12;
            String r100 = this.f525979d.toString();
        L13:
            String r101 = r100.trim();
            if (r101.length() <= 0) goto L26;
            if (this.f525984i == false) goto L22;
            if (this.f525982g.length() <= 0) goto L20;
            String r102 = this.f525982g.toString();
        L25:
            this.f525987l.a(r101, r102);
            goto L26
        L20:
            r102 = this.f525983h;
            goto L25
        L22:
            if (this.f525985j == false) goto L24;
            r102 = "";
            goto L25
        L24:
            r102 = null;
            goto L25
        L12:
            r100 = this.f525980e;
            goto L13
        }

        public h() {
            this.f525979d = new StringBuilder();
            this.f525981f = false;
            this.f525982g = new StringBuilder();
            this.f525984i = false;
            this.f525985j = false;
            this.f525986k = false;
        }

        @Override // org.jsoup.parser.Token
        public /* bridge */ /* synthetic */ void f() {
            p();
        }

        public final void h(char r100) {
            this.f525984i = true;
            String r101 = this.f525983h;
            if (r101 == null) goto L5;
            this.f525982g.append(r101);
            this.f525983h = null;
        L5:
            this.f525982g.append(r100);
        }

        public final void i(String r100) {
            this.f525984i = true;
            String r101 = this.f525983h;
            if (r101 == null) goto L6;
            this.f525982g.append(r101);
            this.f525983h = null;
        L6:
            if (this.f525982g.length() != 0) goto L8;
            this.f525983h = r100;
            return;
        L8:
            this.f525982g.append(r100);
        }

        public final void j(int[] r100) {
            this.f525984i = true;
            String r101 = this.f525983h;
            if (r101 == null) goto L5;
            this.f525982g.append(r101);
            this.f525983h = null;
        L5:
            int r102 = r100.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L8;
            int r104 = r100[r103];
            this.f525982g.appendCodePoint(r104);
            r103 = r103 + 1;
            goto L6
        }

        public final void k(String r100) {
            String r101 = r100.replace(0, 65533);
            String r102 = this.f525977b;
            if (r102 == null) goto L6;
            r101 = r102.concat(r101);
        L6:
            this.f525977b = r101;
            org.jsoup.parser.d r103 = org.jsoup.parser.d.f526020c;
            this.f525978c = fwc.a.a(r101.trim());
        }

        public final void n(String r100) {
            this.f525977b = r100;
            org.jsoup.parser.d r101 = org.jsoup.parser.d.f526020c;
            this.f525978c = fwc.a.a(r100.trim());
        }
    }

    public abstract void f();

    public final boolean a() {
        if (this.f525967a != TokenType.Comment) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.f525967a != TokenType.Doctype) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        if (this.f525967a != TokenType.EOF) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d() {
        if (this.f525967a != TokenType.EndTag) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e() {
        if (this.f525967a != TokenType.StartTag) goto L5;
        return true;
    L5:
        return false;
    }

    public Token() {
    }

    public static void g(StringBuilder r100) {
        if (r100 == null) goto L5;
        r100.delete(0, r100.length());
        return;
    }
}
