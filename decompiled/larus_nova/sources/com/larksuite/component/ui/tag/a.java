package com.larksuite.component.ui.tag;

import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f284421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f284422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f284423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f284424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f284425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f284426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f284427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f284428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f284429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f284430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f284431k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f284432l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f284433m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final f f284434n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f284435o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f284436p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f f284437q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f f284438r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f284439s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f f284440t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f284441u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f284442v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final f f284443w;

    public a() {
        this.f284421a = TagProviderKt.f284375i;
        this.f284422b = TagProviderKt.f284390x;
        this.f284423c = TagProviderKt.f284376j;
        this.f284424d = TagProviderKt.f284377k;
        this.f284425e = TagProviderKt.f284378l;
        this.f284426f = TagProviderKt.f284380n;
        this.f284427g = TagProviderKt.f284379m;
        this.f284428h = TagProviderKt.f284368b;
        this.f284429i = TagProviderKt.f284367a;
        this.f284430j = TagProviderKt.f284381o;
        this.f284431k = TagProviderKt.f284382p;
        this.f284432l = TagProviderKt.f284371e;
        f r100 = TagProviderKt.f284370d;
        this.f284433m = r100;
        this.f284434n = TagProviderKt.f284374h;
        this.f284435o = TagProviderKt.f284386t;
        this.f284436p = TagProviderKt.f284388v;
        this.f284437q = TagProviderKt.f284373g;
        this.f284438r = TagProviderKt.f284372f;
        this.f284439s = TagProviderKt.f284384r;
        this.f284440t = r100;
        this.f284441u = TagProviderKt.f284369c;
        this.f284442v = TagProviderKt.f284387u;
        this.f284443w = TagProviderKt.f284389w;
    }

    public final f a(String r100) {
        f r101 = TagProviderKt.f284367a;
        int r102 = f.f284457g;
        f.a r103 = new f.a();
        r103.f284464a = 65573;
        r103.f284465b = 2;
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        r100 = UIHelper.getString(R.string.Lark_Legacy_External);
    L11:
        r103.f284467d = r100;
        r103.f284468e = R.color.LARK_TAG_TEXT_BLUE;
        r103.f284470g = R.color.LARK_TAG_TEXT_BLUE_BG;
        return r103.a();
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
