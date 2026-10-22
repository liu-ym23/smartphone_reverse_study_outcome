package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class f<T extends Content> extends v5b.a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f411952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f411953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f411954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f411955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f411956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f<T> f411957g;

    public boolean e() {
        int r100 = this.f411956f;
        if (r100 == 1) goto L17;
        if (r100 == 0) goto L18;
        String r101 = this.f411952b;
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return false;
    L14:
        if (this.f411957g == null) goto L20;
        return true;
    L20:
        return false;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L18:
        return false;
    L17:
        return false;
    }

    public f(T r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411952b = "";
    }

    @Override // v5b.a
    public boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L6;
        return false;
    L6:
        if ((r100 instanceof f) == false) goto L46;
        f r101 = (f) r100;
        if (y28.a.a(this.f411952b, r101.f411952b) == true) goto L10;
    L24:
        boolean r102 = false;
    L25:
        f<T> r103 = this.f411957g;
        if (r103 == null) goto L45;
        f<T> r104 = r101.f411957g;
        if (r104 == null) goto L45;
        if ((r103 instanceof c) == false) goto L45;
        if ((r104 instanceof c) == false) goto L45;
        T r105 = r103.f553338a;
        MergeForwardContent r106 = null;
        if ((r105 instanceof MergeForwardContent) == false) goto L36;
        MergeForwardContent r107 = (MergeForwardContent) r105;
    L37:
        T r108 = r104.f553338a;
        if ((r108 instanceof MergeForwardContent) == false) goto L40;
        r106 = (MergeForwardContent) r108;
    L40:
        if (r102 == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(r107, r106) == false) goto L48;
        return true;
    L48:
        return false;
    L36:
        r107 = null;
    L45:
        return r102;
    L10:
        if (this.f411953c != r101.f411953c) goto L24;
        if (this.f411954d != r101.f411954d) goto L24;
        if (this.f411955e != r101.f411955e) goto L24;
        if (this.f411956f != r101.f411956f) goto L24;
        if (Intrinsics.areEqual(this.f411957g, r101.f411957g) == true) goto L23;
        f<T> r109 = this.f411957g;
        if (r109 == null) goto L24;
        Intrinsics.checkNotNull(r109);
        if (r109.d(r101.f411957g) == false) goto L24;
    L23:
        r102 = true;
        goto L25
    L46:
        return false;
    }
}
