package zg1;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f571962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f571963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClientUIInfo f571964c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v1) == false) goto L12;
        v1 r101 = (v1) r100;
        if (this.f571962a == r101.f571962a) goto L8;
        return false;
    L8:
        if (this.f571963b == r101.f571963b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f571964c, r101.f571964c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f571962a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f571963b) * 31;
        ClientUIInfo r102 = this.f571964c;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "MultiLinkClientUIInfoChangeEvent(roomId=" + this.f571962a + ", uiLayout=" + this.f571963b + ", clientUIInfo=" + this.f571964c + ")";
    }

    public v1(long r100, int r101, ClientUIInfo r102) {
        this.f571962a = r100;
        this.f571963b = r101;
        this.f571964c = r102;
    }
}
