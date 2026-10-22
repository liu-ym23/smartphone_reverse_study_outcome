package org.commonmark.internal;

import java.util.Locale;
import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.Paragraph;

/* JADX INFO: loaded from: classes42.dex */
public final class q extends wvc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paragraph f525753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkReferenceDefinitionParser f525754b;

    public q() {
        this(0);
    }

    @Override // wvc.a, wvc.d
    public final boolean b() {
        return true;
    }

    @Override // wvc.a, wvc.d
    public final void c() {
        if (this.f525754b.f525652b.length() != 0) goto L6;
        this.f525753a.g();
        return;
    }

    @Override // wvc.d
    public final Block a() {
        return this.f525753a;
    }

    public q(int r100) {
        this.f525753a = new Paragraph();
        this.f525754b = new LinkReferenceDefinitionParser();
    }

    @Override // wvc.a, wvc.d
    public final void d(CharSequence r110) {
        LinkReferenceDefinitionParser r100 = this.f525754b;
        if (r100.f525652b.length() == 0) goto L5;
        r100.f525652b.append('\n');
    L5:
        r100.f525652b.append(r110);
        int r101 = 0;
    L7:
        if (r101 >= r110.length()) goto L101;
        switch(LinkReferenceDefinitionParser.a.f525661a[r100.f525651a.ordinal()]) {
            case 1: goto L102;
            case 2: goto L73;
            case 3: goto L52;
            case 4: goto L39;
            case 5: goto L21;
            case 6: goto L11;
            default: goto L82;
        };
    L11:
        int r102 = tvc.c.d(r110, r101, r100.f525657g);
        if (r102 == (-1)) goto L81;
        r100.f525658h.append(r110.subSequence(r101, r102));
        if (r102 < r110.length()) goto L17;
        r100.f525658h.append('\n');
    L58:
        r101 = r102;
        goto L82
    L17:
        r101 = tvc.d.c(r110, r102 + 1, r110.length());
        if (r101 != r110.length()) goto L81;
        r100.f525659i = true;
        r100.a();
        r100.f525652b.setLength(0);
        r100.f525651a = LinkReferenceDefinitionParser.State.START_DEFINITION;
    L81:
        r101 = -1;
        goto L82
    L21:
        r101 = tvc.d.c(r110, r101, r110.length());
        if (r101 < r110.length()) goto L24;
        r100.f525651a = LinkReferenceDefinitionParser.State.START_DEFINITION;
        goto L82
    L24:
        r100.f525657g = 0;
        char r103 = r110.charAt(r101);
        if (r103 != '\"') goto L27;
    L32:
        r100.f525657g = r103;
    L34:
        if (r100.f525657g == 0) goto L38;
        r100.f525651a = LinkReferenceDefinitionParser.State.TITLE;
        r100.f525658h = new StringBuilder();
        r101 = r101 + 1;
        if (r101 != r110.length()) goto L82;
        r100.f525658h.append('\n');
        goto L82
    L38:
        r100.a();
        r100.f525651a = LinkReferenceDefinitionParser.State.START_DEFINITION;
        goto L82
    L27:
        if (r103 == '\'') goto L32;
        if (r103 != '(') goto L34;
        r100.f525657g = ')';
        goto L34
    L39:
        int r104 = tvc.d.c(r110, r101, r110.length());
        int r105 = tvc.c.a(r110, r104);
        if (r105 == (-1)) goto L81;
        if (r110.charAt(r104) != '<') goto L45;
        String r106 = r110.subSequence(r104 + 1, r105 - 1).toString();
    L46:
        r100.f525656f = r106;
        r101 = tvc.d.c(r110, r105, r110.length());
        if (r101 < r110.length()) goto L49;
        r100.f525659i = true;
        r100.f525652b.setLength(0);
    L51:
        r100.f525651a = LinkReferenceDefinitionParser.State.START_TITLE;
        goto L82
    L49:
        if (r101 != r105) goto L51;
    L45:
        r106 = r110.subSequence(r104, r105).toString();
        goto L46
    L52:
        r102 = tvc.c.b(r110, r101);
        if (r102 == (-1)) goto L81;
        r100.f525654d.append(r110, r101, r102);
        if (r102 < r110.length()) goto L60;
        r100.f525654d.append('\n');
        goto L58
    L60:
        if (r110.charAt(r102) != ']') goto L81;
        int r107 = r102 + 1;
        if (r107 >= r110.length()) goto L81;
        if (r110.charAt(r107) != ':') goto L81;
        if (r100.f525654d.length() > 999) goto L81;
        String r108 = r100.f525654d.toString();
        Pattern r109 = tvc.a.f547710a;
        String r111 = tvc.a.f547712c.matcher(r108.trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
        if (r111.isEmpty() == true) goto L81;
        r100.f525655e = r111;
        r100.f525651a = LinkReferenceDefinitionParser.State.DESTINATION;
        r101 = tvc.d.c(r110, r107 + 1, r110.length());
        goto L82
    L73:
        int r112 = tvc.d.c(r110, r101, r110.length());
        if (r112 >= r110.length()) goto L81;
        if (r110.charAt(r112) != '[') goto L81;
        r100.f525651a = LinkReferenceDefinitionParser.State.LABEL;
        r100.f525654d = new StringBuilder();
        r101 = r112 + 1;
        if (r101 < r110.length()) goto L82;
        r100.f525654d.append('\n');
        goto L82
    L102:
        return;
    L82:
        if (r101 != (-1)) goto L7;
        r100.f525651a = LinkReferenceDefinitionParser.State.PARAGRAPH;
        return;
    }

    @Override // wvc.d
    public final wvc.c f(wvc.g r100) {
        h r101 = (h) r100;
        if (r101.f525697h == false) goto L5;
        return null;
    L5:
        return wvc.c.a(r101.f525691b);
    }

    @Override // wvc.a, wvc.d
    public final void g(vvc.a r100) {
        StringBuilder r101 = this.f525754b.f525652b;
        if (r101.length() <= 0) goto L6;
        r100.a(r101.toString(), this.f525753a);
        return;
    }
}
