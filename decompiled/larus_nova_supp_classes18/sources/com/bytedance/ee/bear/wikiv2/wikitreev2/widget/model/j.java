package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikNodeType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public String e;
    public final String f;
    public final double g;
    public final int h;
    public final String i;
    public final String j;
    public boolean k;
    public final boolean l;
    public final boolean m;
    public final String n;
    public final int o;
    public final boolean p;
    public int q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public String v;

    public final boolean c() {
        if (this.q != WikNodeType.DIR.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d() {
        return TextUtils.equals("wikiroot%favorite", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(this.n, 0));
    }

    public final boolean e() {
        if (this.h == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String b() {
        if (e() == false) goto L11;
        if (this.m == false) goto L9;
        return this.c;
    L9:
        return this.i;
    L11:
        return this.b;
    }

    public static j a(TreeNode r28, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r29) {
        return new j(r28.space_id, r28.wiki_token, r28.obj_token, r28.obj_type, r28.title, r28.parent_wiki_token, r28.sort_id, r28.wiki_node_type, r28.origin_wiki_token, r28.origin_space_id, r28.has_child, r28.secret_key_delete, r28.origin_is_external, r29.a, r29.e, r29.d, r28.getNodeType(), r29.f, r29.g, r28.isSpaceDocument, r28.isWikiHomePage, r28.iconInfo);
    }

    public j(String r4, String r5, String r6, int r7, String r8, String r9, double r10, int r12, String r13, String r14, boolean r15, boolean r16, boolean r17, String r18, int r19, boolean r20, int r21, boolean r22, boolean r23, boolean r24, boolean r25, String r26) {
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
        this.o = r19;
        this.p = r20;
        this.q = r21;
        this.r = r22;
        this.s = r23;
        this.t = r24;
        this.u = r25;
        this.v = r26;
    }
}
