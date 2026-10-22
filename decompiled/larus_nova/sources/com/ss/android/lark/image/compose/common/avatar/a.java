package com.ss.android.lark.image.compose.common.avatar;

import androidx.compose.ui.unit.Dp;
import com.ss.android.lark.image.compose.common.ImageFormat;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f426260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f426261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f426262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f426263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageFormat f426264e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f426260a, r101.f426260a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f426261b, r101.f426261b) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.f426262c, r101.f426262c) == true) goto L18;
        return false;
    L18:
        if (this.f426263d == r101.f426263d) goto L21;
        return false;
    L21:
        if (this.f426264e == r101.f426264e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f426260a.hashCode() * 31) + this.f426261b.hashCode()) * 31) + Dp.m7550hashCodeimpl(this.f426262c)) * 31) + this.f426263d) * 31) + this.f426264e.hashCode();
    }

    public final String toString() {
        return "AvatarImage(key=" + this.f426260a + ", entityId=" + this.f426261b + ", dpSize=" + Dp.m7555toStringimpl(this.f426262c) + ", dpr=" + this.f426263d + ", format=" + this.f426264e + ')';
    }

    public a(String r100, String r101, float r102, ImageFormat r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "entityId");
        Intrinsics.checkNotNullParameter(r103, SubInfo.KEY_FORMAT);
        this.f426260a = r100;
        this.f426261b = r101;
        this.f426262c = r102;
        this.f426263d = 1;
        this.f426264e = r103;
    }
}
