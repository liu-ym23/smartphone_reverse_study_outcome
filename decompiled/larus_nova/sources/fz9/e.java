package fz9;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f479442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Message f479443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f479444e;

    public e() {
        this(null, 0, 0, null, null);
    }

    public final String toString() {
        return "ProgressLoadingData(taskId=" + this.f479440a + ", width=" + this.f479441b + ", height=" + this.f479442c + ", message=" + this.f479443d + ", index=" + this.f479444e + ')';
    }

    public final int hashCode() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f479440a);
        r100.append(this.f479441b);
        r100.append(this.f479442c);
        Message r101 = this.f479443d;
        if (r101 == null) goto L5;
        String r102 = r101.getMessageId();
    L6:
        r100.append(r102);
        r100.append(this.f479444e);
        return r100.toString().hashCode();
    L5:
        r102 = null;
        goto L6
    }

    @Override // fz9.c
    public final int getHeight() {
        return this.f479442c;
    }

    @Override // fz9.c
    public final Integer getIndex() {
        return this.f479444e;
    }

    @Override // fz9.c
    public final Message getMessage() {
        return this.f479443d;
    }

    @Override // fz9.c
    public final String getTaskId() {
        return this.f479440a;
    }

    @Override // fz9.c
    public final int getWidth() {
        return this.f479441b;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof e) == false) goto L23;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f479440a, r101.f479440a) == true) goto L7;
        return false;
    L7:
        if (this.f479441b == r101.f479441b) goto L9;
        return false;
    L9:
        if (this.f479442c != r101.f479442c) goto L26;
        Message r102 = this.f479443d;
        String r103 = null;
        if (r102 == null) goto L13;
        String r104 = r102.getMessageId();
    L14:
        Message r105 = r101.f479443d;
        if (r105 == null) goto L18;
        r103 = r105.getMessageId();
    L18:
        if (Intrinsics.areEqual(r104, r103) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f479444e, r101.f479444e) == false) goto L28;
        return true;
    L28:
        return false;
    L13:
        r104 = null;
        goto L14
    L26:
        return false;
    L23:
        return false;
    }

    public e(String r100, int r101, int r102, Message r103, Integer r104) {
        this.f479440a = r100;
        this.f479441b = r101;
        this.f479442c = r102;
        this.f479443d = r103;
        this.f479444e = r104;
    }
}
