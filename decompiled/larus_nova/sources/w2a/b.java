package w2a;

import com.larus.im.bean.bot.MixVoice;
import com.larus.voice_setting.voice.editvoice.b1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MixVoice f558056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f558058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<MixVoice> f558059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b1 f558060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<MixVoice> f558061g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f558055a, r101.f558055a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558056b, r101.f558056b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558057c, r101.f558057c) == true) goto L18;
        return false;
    L18:
        if (this.f558058d == r101.f558058d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558059e, r101.f558059e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f558060f, r101.f558060f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f558061g, r101.f558061g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f558055a.hashCode() * 31) + this.f558056b.hashCode()) * 31) + this.f558057c.hashCode()) * 31) + this.f558058d) * 31;
        List<MixVoice> r101 = this.f558059e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        b1 r105 = this.f558060f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<MixVoice> r108 = this.f558061g;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MixedVoiceUpdate(action=" + this.f558055a + ", voice=" + this.f558056b + ", from=" + this.f558057c + ", updateIndex=" + this.f558058d + ", oldVoiceList=" + this.f558059e + ", oldPitchAndRate=" + this.f558060f + ", newVoiceList=" + this.f558061g + ')';
    }

    public /* synthetic */ b(String r100, MixVoice r110, String r111, List r112, b1 r113, List r114) {
        this(r100, r110, r111, 0, r112, r113, r114);
    }

    public b(String r100, MixVoice r101, String r102, int r103, List<MixVoice> r104, b1 r105, List<MixVoice> r106) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "voice");
        Intrinsics.checkNotNullParameter(r102, "from");
        this.f558055a = r100;
        this.f558056b = r101;
        this.f558057c = r102;
        this.f558058d = r103;
        this.f558059e = r104;
        this.f558060f = r105;
        this.f558061g = r106;
    }
}
