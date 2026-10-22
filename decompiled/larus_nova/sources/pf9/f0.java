package pf9;

import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.cmd.ReplyType;
import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f0 implements z0.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f528906e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReplyType f528907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f528908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f528909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReplyStage f528910d;

    public static final class a {
        public static f0 a(ReplyType r100, ReplyStage r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return new f0(r100, null, null, r101);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f528907a == r101.f528907a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528908b, r101.f528908b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528909c, r101.f528909c) == true) goto L18;
        return false;
    L18:
        if (this.f528910d == r101.f528910d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f528907a.hashCode() * 31;
        k0 r101 = this.f528908b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        m r105 = this.f528909c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        ReplyStage r108 = this.f528910d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowLLMReplyUpdateEvent(type=" + this.f528907a + ", textContent=" + this.f528908b + ", audioContent=" + this.f528909c + ", stage=" + this.f528910d + ')';
    }

    public final ReplyType getType() {
        return this.f528907a;
    }

    public f0(ReplyType r100, k0 r101, m r102, ReplyStage r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f528907a = r100;
        this.f528908b = r101;
        this.f528909c = r102;
        this.f528910d = r103;
    }
}
