package k52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePipelineType;
import h52.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessagePipelineType f501825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f501826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f501827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f501828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e52.a f501829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k<c> f501830f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f501825a, r101.f501825a) == true) goto L8;
        return false;
    L8:
        if (this.f501826b == r101.f501826b) goto L10;
        return false;
    L10:
        if (this.f501827c == r101.f501827c) goto L12;
        return false;
    L12:
        if (this.f501828d == r101.f501828d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f501829e, r101.f501829e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f501830f, r101.f501830f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        MessagePipelineType r100 = this.f501825a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((r102 * 31) + this.f501826b) * 31) + this.f501827c) * 31) + this.f501828d) * 31;
        e52.a r104 = this.f501829e;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        k<c> r107 = this.f501830f;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ModelPipelineConfig(pipelineSymbol=" + this.f501825a + ", defaultBufferSize=" + this.f501826b + ", defaultTik=" + this.f501827c + ", numPerTik=" + this.f501828d + ", textMessageConfig=" + this.f501829e + ", renderTextProcessor=" + this.f501830f + ")";
    }

    public a(MessagePipelineType r100, int r101, int r102, int r103, e52.a r104, k<c> r105) {
        Intrinsics.checkNotNullParameter(r100, "pipelineSymbol");
        Intrinsics.checkNotNullParameter(r104, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r105, "renderTextProcessor");
        this.f501825a = r100;
        this.f501826b = r101;
        this.f501827c = r102;
        this.f501828d = r103;
        this.f501829e = r104;
        this.f501830f = r105;
    }
}
