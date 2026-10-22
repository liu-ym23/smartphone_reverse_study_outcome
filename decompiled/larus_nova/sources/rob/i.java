package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SendType f538814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f538816c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f538814a == r101.f538814a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538815b, r101.f538815b) == true) goto L15;
        return false;
    L15:
        if (this.f538816c == r101.f538816c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f538814a.hashCode() * 31) + this.f538815b.hashCode()) * 31;
        if (this.f538816c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "SendTypeData(sendType=" + this.f538814a + ", title=" + this.f538815b + ", isSelected=" + this.f538816c + ')';
    }

    public i(SendType r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "sendType");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f538814a = r100;
        this.f538815b = r101;
        this.f538816c = r102;
    }
}
