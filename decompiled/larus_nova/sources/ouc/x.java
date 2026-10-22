package ouc;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class x extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f526862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final luc.f f526863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f526864c;

    public final int hashCode() {
        if (this.f526862a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f526864c.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    @Override // ouc.g0
    public final String toString() {
        if (this.f526862a == false) goto L6;
        StringBuilder r100 = new StringBuilder();
        o0.a(r100, this.f526864c);
        return r100.toString();
    L6:
        return this.f526864c;
    }

    @Override // ouc.g0
    public final String a() {
        return this.f526864c;
    }

    @Override // ouc.g0
    public final boolean c() {
        return this.f526862a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (x.class != r100.getClass()) goto L17;
        x r101 = (x) r100;
        if (this.f526862a == r101.f526862a) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f526864c, r101.f526864c) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public x(Object r100, boolean r101, luc.f r102) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        this.f526862a = r101;
        this.f526863b = r102;
        this.f526864c = r100.toString();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isInline() == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
