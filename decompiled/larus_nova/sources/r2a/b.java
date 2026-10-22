package r2a;

import com.larus.im.bean.bot.IconItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f535824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IconItem f535827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f535828e;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f535824a == r101.f535824a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535825b, r101.f535825b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f535826c, r101.f535826c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f535827d, r101.f535827d) == true) goto L21;
        return false;
    L21:
        if (this.f535828e == r101.f535828e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f535824a * 31;
        String r101 = this.f535825b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f535826c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        IconItem r108 = this.f535827d;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.f535828e == false) goto L17;
        int r110 = 1231;
    L19:
        return r109 + r110;
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateUgcVoiceItem(createState=" + this.f535824a + ", localVoiceId=" + this.f535825b + ", voiceName=" + this.f535826c + ", voiceIcon=" + this.f535827d + ", replaceVoice=" + this.f535828e + ')';
    }

    public /* synthetic */ b(int r100) {
        this(-1, "", "", null, false);
    }

    public b(int r100, String r101, String r102, IconItem r103, boolean r104) {
        this.f535824a = r100;
        this.f535825b = r101;
        this.f535826c = r102;
        this.f535827d = r103;
        this.f535828e = r104;
    }
}
