package r2a;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.network.http.a<SpeakerVoice> f535829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f535831c;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f535829a, r101.f535829a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535830b, r101.f535830b) == true) goto L15;
        return false;
    L15:
        if (this.f535831c == r101.f535831c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        com.larus.network.http.a<SpeakerVoice> r100 = this.f535829a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f535830b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f535831c == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateUgcVoiceResponseWrapper(res=" + this.f535829a + ", localVoiceId=" + this.f535830b + ", fromCreateApi=" + this.f535831c + ')';
    }

    public /* synthetic */ c(com.larus.network.http.a r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101, false);
    }

    public c(com.larus.network.http.a<SpeakerVoice> r100, String r101, boolean r102) {
        this.f535829a = r100;
        this.f535830b = r101;
        this.f535831c = r102;
    }
}
