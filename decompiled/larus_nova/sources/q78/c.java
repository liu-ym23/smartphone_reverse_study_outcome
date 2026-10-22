package q78;

import android.media.AudioFormat;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f531978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f531979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudioFormat f531980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f531981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f531982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f531983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AudioFormat f531984g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f531978a == r101.f531978a) goto L12;
        return false;
    L12:
        if (this.f531979b == r101.f531979b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f531980c, r101.f531980c) == true) goto L18;
        return false;
    L18:
        if (this.f531981d == r101.f531981d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f531982e, r101.f531982e) == true) goto L24;
        return false;
    L24:
        if (this.f531983f == r101.f531983f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f531984g, r101.f531984g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f531978a * 31) + this.f531979b) * 31) + this.f531980c.hashCode()) * 31;
        if (this.f531981d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        a r103 = this.f531982e;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return ((((r102 + r104) * 31) + this.f531983f) * 31) + this.f531984g.hashCode();
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioRecordingConfigurationWrapper(clientAudioSource=" + this.f531978a + ", clientAudioSessionId=" + this.f531979b + ", clientFormat=" + this.f531980c + ", isClientSilenced=" + this.f531981d + ", audioDevice=" + this.f531982e + ", audioSource=" + this.f531983f + ", format=" + this.f531984g + ')';
    }

    public c(int r100, int r101, AudioFormat r102, boolean r103, a r104, int r105, AudioFormat r106) {
        Intrinsics.checkNotNullParameter(r102, "clientFormat");
        Intrinsics.checkNotNullParameter(r106, SubInfo.KEY_FORMAT);
        this.f531978a = r100;
        this.f531979b = r101;
        this.f531980c = r102;
        this.f531981d = r103;
        this.f531982e = r104;
        this.f531983f = r105;
        this.f531984g = r106;
    }
}
