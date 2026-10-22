package org.jsoup.parser;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes42.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f526067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f526068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f526069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Document f526070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Element> f526071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f526072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Token f526073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f526074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, f> f526075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Token.g f526076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Token.f f526077k;

    public abstract boolean c(Token r100);

    public final Element a() {
        int r100 = this.f526071e.size();
        if (r100 <= 0) goto L6;
        return (Element) ListProtector.get(this.f526071e, r100 - 1);
    L6:
        return this.f526070d;
    }

    public final void f() {
        h r100 = this.f526069c;
        Token.TokenType r101 = Token.TokenType.EOF;
    L4:
        if (r100.f526051e == false) goto L5;
        StringBuilder r102 = r100.f526053g;
        if (r102.length() == 0) goto L9;
        String r103 = r102.toString();
        r102.delete(0, r102.length());
        Token.b r104 = r100.f526058l;
        r104.f525969b = r103;
        r100.f526052f = null;
        Token r105 = r104;
    L13:
        c(r105);
        r105.f();
        if (r105.f525967a != r101) goto L4;
        return;
    L9:
        String r106 = r100.f526052f;
        if (r106 == null) goto L12;
        Token.b r107 = r100.f526058l;
        r107.f525969b = r106;
        r100.f526052f = null;
        r105 = r107;
        goto L13
    L12:
        r100.f526051e = false;
        r105 = r100.f526050d;
        goto L13
    L5:
        r100.f526049c.read(r100, r100.f526047a);
        goto L4
    }

    public i() {
        this.f526076j = new Token.g();
        this.f526077k = new Token.f();
    }

    public final boolean b(String r100) {
        if (this.f526071e.size() != 0) goto L5;
        return false;
    L5:
        Element r101 = a();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.f525906d.f526035b.equals(r100) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean d(String r100) {
        Token r101 = this.f526073g;
        Token.f r102 = this.f526077k;
        if (r101 != r102) goto L6;
        Token.f r103 = new Token.f();
        r103.n(r100);
        return c(r103);
    L6:
        r102.p();
        r102.n(r100);
        return c(r102);
    }

    public final void e(String r100) {
        Token.g r101 = this.f526076j;
        if (this.f526073g != r101) goto L6;
        Token.g r102 = new Token.g();
        r102.n(r100);
        c(r102);
        return;
    L6:
        r101.p();
        r101.n(r100);
        c(r101);
    }

    public final f g(String r100, d r101) {
        f r102 = this.f526075i.get(r100);
        if (r102 != null) goto L6;
        f r103 = f.a(r100, r101);
        this.f526075i.put(r100, r103);
        return r103;
    L6:
        return r102;
    }
}
