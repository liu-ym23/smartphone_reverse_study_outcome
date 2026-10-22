package nh0;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.UpdateLayoutType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UpdateLayoutType f519156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f519157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f519158c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L12;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f519156a, r101.f519156a) == true) goto L8;
        return false;
    L8:
        if (this.f519157b == r101.f519157b) goto L10;
        return false;
    L10:
        if (this.f519158c == r101.f519158c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        UpdateLayoutType r100 = this.f519156a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.f519157b) * 31) + this.f519158c;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "UpdateLayoutConfigExtraObject:{uiLayout=" + this.f519157b + ", playMode=" + this.f519158c + '}';
    }

    public final UpdateLayoutType getType() {
        return this.f519156a;
    }

    public s(UpdateLayoutType r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f519156a = r100;
        this.f519157b = r101;
        this.f519158c = r102;
    }
}
