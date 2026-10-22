package kq9;

import com.larus.platform.model.album.FastSendFromCameraScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f505657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f505658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f505659c;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f505657a == r101.f505657a) goto L12;
        return false;
    L12:
        if (this.f505658b == r101.f505658b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f505659c, r101.f505659c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f505657a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f505658b) * 31;
        o r102 = this.f505659c;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "FastSendImageInCameraConfig(isBottomControlAdapt=" + this.f505657a + ", bottomScene=" + this.f505658b + ", albumThumbConfig=" + this.f505659c + ')';
    }

    public /* synthetic */ q(int r100) {
        this(true, FastSendFromCameraScene.DEFAULT.getScene(), new o(0));
    }

    public q(boolean r100, int r101, o r102) {
        this.f505657a = r100;
        this.f505658b = r101;
        this.f505659c = r102;
    }
}
