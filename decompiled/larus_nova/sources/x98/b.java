package x98;

import com.alibaba.gaiax.model.GXAnimation;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.larus.avlink.liveai.model.LiveAiEventScene;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f562990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveAiEventScene f562991b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f562990a == r101.f562990a) goto L12;
        return false;
    L12:
        if (this.f562991b == r101.f562991b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f562990a * 31;
        LiveAiEventScene r101 = this.f562991b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        int r100 = this.f562990a;
        if (r100 != 0) goto L5;
        String r101 = ErrorCode.INIT;
    L13:
        return "LiveAiEvent(type=" + r101 + ", scene=" + this.f562991b + ')';
    L5:
        if (r100 != 2) goto L7;
        r101 = GXAnimation.STATE_START;
        goto L13
    L7:
        if (r100 == 5) goto L9;
        r101 = "UNKNOWN";
        goto L13
    L9:
        r101 = "STOP";
        goto L13
    }

    public final int getType() {
        return this.f562990a;
    }

    public b(int r100, LiveAiEventScene r101) {
        this.f562990a = r100;
        this.f562991b = r101;
    }
}
