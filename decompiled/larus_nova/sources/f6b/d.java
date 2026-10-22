package f6b;

import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat f475731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fxa.b f475732b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f475731a, r101.f475731a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f475732b, r101.f475732b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Chat r100 = this.f475731a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        fxa.b r104 = this.f475732b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ExtraParam(chat=" + this.f475731a + ", chatBundle=" + this.f475732b + ')';
    }

    public d(Chat r100, ChatBundleV2 r101) {
        this.f475731a = r100;
        this.f475732b = r101;
    }
}
