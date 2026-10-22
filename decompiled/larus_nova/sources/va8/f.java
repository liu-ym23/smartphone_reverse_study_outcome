package va8;

import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FloatChatWindowEventType f553960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FloatChatWindowState f553961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f553962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f553963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t0 f553964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f553965f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f553960a == r101.f553960a) goto L12;
        return false;
    L12:
        if (this.f553961b == r101.f553961b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f553962c, r101.f553962c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f553963d, r101.f553963d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f553964e, r101.f553964e) == true) goto L24;
        return false;
    L24:
        if (this.f553965f == r101.f553965f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f553960a.hashCode() * 31;
        FloatChatWindowState r101 = this.f553961b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Message r105 = this.f553962c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f553963d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        t0 r111 = this.f553964e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        if (this.f553965f == false) goto L21;
        int r113 = 1231;
    L23:
        return r112 + r113;
    L21:
        r113 = 1237;
        goto L23
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FloatChatWindowEvent(type=" + this.f553960a + ", targetState=" + this.f553961b + ", anchorMessage=" + this.f553962c + ", queryMsgId=" + this.f553963d + ", viewBusinessPayload=" + this.f553964e + ", needAnim=" + this.f553965f + ')';
    }

    public final FloatChatWindowEventType getType() {
        return this.f553960a;
    }

    public f(FloatChatWindowEventType r100, FloatChatWindowState r101, Message r102, String r103, t0 r104, boolean r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r106 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r106 & 32) == 0) goto L17;
        r105 = true;
    L17:
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f553960a = r100;
        this.f553961b = r101;
        this.f553962c = r102;
        this.f553963d = r103;
        this.f553964e = r104;
        this.f553965f = r105;
    }
}
