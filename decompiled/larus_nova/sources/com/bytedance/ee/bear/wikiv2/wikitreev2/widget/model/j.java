package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikNodeType;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f241913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f241914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f241915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f241916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f241917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f241918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f241919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f241920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f241921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f241922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f241923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f241924l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f241925m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f241926n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f241927o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f241928p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f241929q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f241930r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f241931s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f241932t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f241933u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f241934v;

    public final boolean c() {
        if (this.f241929q != WikNodeType.DIR.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d() {
        return TextUtils.equals("wikiroot%favorite", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(this.f241926n, 0));
    }

    public final boolean e() {
        if (this.f241920h == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final String b() {
        if (e() == false) goto L11;
        if (this.f241925m == false) goto L9;
        return this.f241915c;
    L9:
        return this.f241921i;
    L11:
        return this.f241914b;
    }

    public static j a(TreeNode r210, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.a r211) {
        return new j(r210.space_id, r210.wiki_token, r210.obj_token, r210.obj_type, r210.title, r210.parent_wiki_token, r210.sort_id, r210.wiki_node_type, r210.origin_wiki_token, r210.origin_space_id, r210.has_child, r210.secret_key_delete, r210.origin_is_external, r211.f241732a, r211.f241736e, r211.f241735d, r210.getNodeType(), r211.f241737f, r211.f241738g, r210.isSpaceDocument, r210.isWikiHomePage, r210.iconInfo);
    }

    public j(String r100, String r101, String r102, int r103, String r104, String r105, double r110, int r111, String r112, String r113, boolean r114, boolean r115, boolean r116, String r117, int r118, boolean r210, int r211, boolean r212, boolean r213, boolean r214, boolean r215, String r216) {
        this.f241913a = r100;
        this.f241914b = r101;
        this.f241915c = r102;
        this.f241916d = r103;
        this.f241917e = r104;
        this.f241918f = r105;
        this.f241919g = r110;
        this.f241920h = r111;
        this.f241921i = r112;
        this.f241922j = r113;
        this.f241923k = r114;
        this.f241924l = r115;
        this.f241925m = r116;
        this.f241926n = r117;
        this.f241927o = r118;
        this.f241928p = r210;
        this.f241929q = r211;
        this.f241930r = r212;
        this.f241931s = r213;
        this.f241932t = r214;
        this.f241933u = r215;
        this.f241934v = r216;
    }
}
