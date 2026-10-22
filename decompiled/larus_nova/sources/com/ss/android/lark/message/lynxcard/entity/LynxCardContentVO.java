package com.ss.android.lark.message.lynxcard.entity;

import com.ss.android.lark.chat.base.view.vo.message.b;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v5b.a;

/* JADX INFO: loaded from: classes36.dex */
public final class LynxCardContentVO extends f<CardContent> implements b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f432122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f432123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f432124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f432125k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f432126l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EllipsizeFrameLayout.a f432127m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f432128n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f432129o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f432130p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f432131q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f432132r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f432133s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f432134t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f432135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f432136v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient CharSequence f432137w;

    @Override // com.ss.android.lark.chat.base.view.vo.message.b
    public final boolean a() {
        return ((CardContent) this.f553338a).resourceIsCleaned();
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.b
    public final ResourceCleanScene b() {
        return ((CardContent) this.f553338a).firstResourceScene();
    }

    public final int f() {
        return ((Number) this.f432130p.getValue()).intValue();
    }

    public final String g() {
        return (String) this.f432128n.getValue();
    }

    public final String h() {
        return (String) this.f432132r.getValue();
    }

    public final String i() {
        return (String) this.f432134t.getValue();
    }

    public final boolean j() {
        return ((Boolean) this.f432131q.getValue()).booleanValue();
    }

    public LynxCardContentVO(final CardContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f432122h = LazyKt.lazy(new LynxCardContentVO$cardType$2(r100));
        this.f432123i = LazyKt.lazy(new LynxCardContentVO$extraType$2(r100));
        this.f432124j = LazyKt.lazy(new LynxCardContentVO$extraInfo$2(r100));
        this.f432125k = LazyKt.lazy(new LynxCardContentVO$enableForward$2(r100));
        this.f432127m = new EllipsizeFrameLayout.a();
        this.f432128n = LazyKt.lazy(new LynxCardContentVO$dslJsonString$2(r100));
        this.f432129o = LazyKt.lazy(new LynxCardContentVO$jsonAttachment$2(r100));
        this.f432130p = LazyKt.lazy(new LynxCardContentVO$contentVersion$2(r100));
        this.f432131q = LazyKt.lazy(new LynxCardContentVO$isForward$2(r100));
        this.f432132r = LazyKt.lazy(new LynxCardContentVO$messageId$2(r100));
        this.f432133s = LazyKt.lazy(new LynxCardContentVO$cardHeader$2(r100));
        this.f432134t = LazyKt.lazy(new LynxCardContentVO$universalCardId$2(r100));
        this.f432135u = LazyKt.lazy(new LynxCardContentVO$universalCardVersion$2(r100));
        this.f432136v = LazyKt.lazy(new LynxCardContentVO$dataSource$2(r100));
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(a<?> r100) {
        if ((r100 instanceof LynxCardContentVO) == false) goto L46;
        LynxCardContentVO r101 = (LynxCardContentVO) r100;
        String r102 = h();
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L43;
        String r104 = r101.h();
        if (r104 != null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == true) goto L43;
        if (super.d(r101) == false) goto L43;
        if (Intrinsics.areEqual(h(), r101.h()) == false) goto L43;
        if (((CardContent.Type) this.f432122h.getValue()) != ((CardContent.Type) r101.f432122h.getValue())) goto L43;
        if (Intrinsics.areEqual(g(), g()) == false) goto L43;
        if (f() != r101.f()) goto L43;
        if (Intrinsics.areEqual(i(), r101.i()) == false) goto L43;
        if (Intrinsics.areEqual((String) this.f432135u.getValue(), (String) r101.f432135u.getValue()) == false) goto L43;
        if (j() != r101.j()) goto L43;
        if (this.f432126l != r101.f432126l) goto L43;
        if (Intrinsics.areEqual(this.f432127m, r101.f432127m) == false) goto L43;
        boolean r106 = true;
    L44:
        if (r106 == false) goto L46;
        return true;
    L15:
        if (r104.length() == 0) goto L18;
        r105 = false;
    L43:
        r106 = false;
        goto L44
    L7:
        if (r102.length() == 0) goto L10;
        r103 = false;
    L46:
        super.d(r100);
        return false;
    }
}
