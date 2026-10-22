package tk8;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<jc8.a> f546588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f546589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc8.b f546590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f546591d;

    public e() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f546588a, r101.f546588a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f546589b, r101.f546589b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f546590c, r101.f546590c) == true) goto L18;
        return false;
    L18:
        if (this.f546591d == r101.f546591d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f546588a.hashCode() * 31) + this.f546589b.hashCode()) * 31;
        kc8.b r101 = this.f546590c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f546591d == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ElapsedBlockContentViewInput(models=" + this.f546588a + ", message=" + this.f546589b + ", blockDependConfig=" + this.f546590c + ", forceRefresh=" + this.f546591d + ')';
    }

    public e(List r100, Message r101, kc8.b r102) {
        Intrinsics.checkNotNullParameter(r100, "models");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f546588a = r100;
        this.f546589b = r101;
        this.f546590c = r102;
        this.f546591d = false;
    }
}
