package kc8;

import com.larus.bmhome.chat.block.base.config.ToolBlockInitStatus;
import com.larus.bmhome.chat.block.base.config.ToolBlockInteractType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class w0 implements jc8.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ToolBlockInteractType f502610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ToolBlockInitStatus f502611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f502612c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r101 = (w0) r100;
        if (this.f502610a == r101.f502610a) goto L12;
        return false;
    L12:
        if (this.f502611b == r101.f502611b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502612c, r101.f502612c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f502610a.hashCode() * 31) + this.f502611b.hashCode()) * 31;
        d r101 = this.f502612c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ToolCallBlockConfig(toolBlockInteractType=" + this.f502610a + ", toolInitStatus=" + this.f502611b + ", detailNavigator=" + this.f502612c + ')';
    }

    public w0() {
        this(ToolBlockInteractType.Default, ToolBlockInitStatus.Default, null);
    }

    public w0(ToolBlockInteractType r100, ToolBlockInitStatus r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "toolBlockInteractType");
        Intrinsics.checkNotNullParameter(r101, "toolInitStatus");
        this.f502610a = r100;
        this.f502611b = r101;
        this.f502612c = r102;
    }
}
