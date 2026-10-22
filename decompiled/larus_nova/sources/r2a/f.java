package r2a;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f535841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f535842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f535843f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f535838a, r101.f535838a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535839b, r101.f535839b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f535840c, r101.f535840c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f535841d, r101.f535841d) == true) goto L21;
        return false;
    L21:
        if (this.f535842e == r101.f535842e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f535843f, r101.f535843f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f535838a.hashCode() * 31) + this.f535839b.hashCode()) * 31) + this.f535840c.hashCode()) * 31) + this.f535841d.hashCode()) * 31;
        if (this.f535842e == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f535843f.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "UgcVoiceInfo(avatarUrl=" + this.f535838a + ", avatarUri=" + this.f535839b + ", voiceName=" + this.f535840c + ", localVoiceId=" + this.f535841d + ", isPublic=" + this.f535842e + ", languageCode=" + this.f535843f + ')';
    }

    public f(String r100, String r101, String r102, String r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "avatarUrl");
        Intrinsics.checkNotNullParameter(r101, "avatarUri");
        Intrinsics.checkNotNullParameter(r102, "voiceName");
        Intrinsics.checkNotNullParameter(r103, "localVoiceId");
        Intrinsics.checkNotNullParameter(r105, UserInfo.LANGUAGECODE);
        this.f535838a = r100;
        this.f535839b = r101;
        this.f535840c = r102;
        this.f535841d = r103;
        this.f535842e = r104;
        this.f535843f = r105;
    }
}
