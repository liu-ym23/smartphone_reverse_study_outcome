package jd2;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f498218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<k> f498219c;

    public final int hashCode() {
        return (((this.f498217a.hashCode() * 31) + this.f498218b) * 31) + this.f498219c.hashCode();
    }

    public final String toString() {
        return "ChorusUserInfoData(chorusNumStr='" + this.f498217a + "', chorusNum=" + this.f498218b + ", chorusUserAvatarList=" + this.f498219c + ')';
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        a r102 = (a) r100;
        if ((!Intrinsics.areEqual(this.f498217a, r102.f498217a)) == false) goto L17;
        return false;
    L17:
        if (this.f498218b == r102.f498218b) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.f498219c, r102.f498219c)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.ktvapi.model.ChorusUserInfoData");
    L8:
        r101 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, int r101, List<? extends k> r102) {
        Intrinsics.checkNotNullParameter(r100, "chorusNumStr");
        Intrinsics.checkNotNullParameter(r102, "chorusUserAvatarList");
        this.f498217a = r100;
        this.f498218b = r101;
        this.f498219c = r102;
    }
}
