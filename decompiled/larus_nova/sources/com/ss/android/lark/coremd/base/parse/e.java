package com.ss.android.lark.coremd.base.parse;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f419540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f419541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f> f419542c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f419540a, r101.f419540a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f419541b, r101.f419541b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f419542c, r101.f419542c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f419540a.hashCode() * 31) + this.f419541b.hashCode()) * 31;
        List<f> r101 = this.f419542c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MarkdownParseConfig(plugins=" + this.f419540a + ", theme=" + this.f419541b + ", parseListeners=" + this.f419542c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(List<? extends g> r100, j r101, List<? extends f> r102) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS);
        Intrinsics.checkNotNullParameter(r101, "theme");
        this.f419540a = r100;
        this.f419541b = r101;
        this.f419542c = r102;
    }
}
