package p4;

import com.bytedance.ai.bridge.remote.model.PrivacyCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f527619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PrivacyCard f527620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f527621c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f527619a == r101.f527619a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527620b, r101.f527620b) == true) goto L15;
        return false;
    L15:
        if (this.f527621c == r101.f527621c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f527619a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        PrivacyCard r103 = this.f527620b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f527621c == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CheckPrivacyOrLoginStatusResult(privacyAgreed=" + this.f527619a + ", privacyCard=" + this.f527620b + ", alreadyLogin=" + this.f527621c + ')';
    }

    public i(boolean r100, PrivacyCard r101, boolean r102) {
        this.f527619a = r100;
        this.f527620b = r101;
        this.f527621c = r102;
    }
}
