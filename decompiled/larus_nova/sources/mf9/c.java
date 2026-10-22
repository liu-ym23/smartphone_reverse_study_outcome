package mf9;

import com.larus.im.bean.message.block.Block;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Block> f513652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f513653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f513654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f513655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f513656e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f513652a, r101.f513652a) == true) goto L12;
        return false;
    L12:
        if (this.f513653b == r101.f513653b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f513654c, r101.f513654c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f513655d, r101.f513655d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f513656e, r101.f513656e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f513652a.hashCode() * 31;
        if (this.f513653b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Integer r103 = this.f513654c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        b r107 = this.f513655d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        e r110 = this.f513656e;
        if (r110 == null) goto L19;
        r104 = r110.hashCode();
    L19:
        return r109 + r104;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DeepResearchResp(content=" + this.f513652a + ", isFinish=" + this.f513653b + ", seqNo=" + this.f513654c + ", options=" + this.f513655d + ", reportPodcastData=" + this.f513656e + ')';
    }

    public c(List<Block> r100, boolean r101, Integer r102, b r103, e r104) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f513652a = r100;
        this.f513653b = r101;
        this.f513654c = r102;
        this.f513655d = r103;
        this.f513656e = r104;
    }
}
