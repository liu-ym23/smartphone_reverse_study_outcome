package pf9;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class t implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f528969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f528970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f528972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f528973e;

    public /* synthetic */ t(int r100, int r101, String r102, String r110) {
        this(r100, r101, r102, r110, 0);
    }

    public t(int r100, int r101, String r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r102, "quotaExceededToast");
        Intrinsics.checkNotNullParameter(r103, "limitType");
        this.f528969a = r100;
        this.f528970b = r101;
        this.f528971c = r102;
        this.f528972d = r103;
        this.f528973e = r104;
    }
}
