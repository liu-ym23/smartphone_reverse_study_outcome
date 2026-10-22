package kza;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f506822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f506823b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f506822a, r101.f506822a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506823b, r101.f506823b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f506822a.hashCode() * 31;
        q r101 = this.f506823b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "OpenFeishuMediaSecurityRequest(mediaInfo=" + this.f506822a + ", authorization=" + this.f506823b + ')';
    }

    public t(r r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_PARAM_KEY_MEDIA_INFO);
        this.f506822a = r100;
        this.f506823b = r101;
    }
}
