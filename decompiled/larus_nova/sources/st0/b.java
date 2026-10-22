package st0;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends com.bytedance.android.live.profile.ui.component.base.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f543535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f543536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f543537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f543538f;

    public b(int r100, String r101, int r102, int r103, int r104, boolean r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r106 & 4) == 0) goto L9;
        r102 = UtilityKotlinExtentionsKt.i(36);
    L9:
        if ((r106 & 8) == 0) goto L12;
        r103 = -1;
    L12:
        if ((r106 & 16) == 0) goto L15;
        r104 = -1;
    L15:
        if ((r106 & 32) == 0) goto L17;
        r105 = false;
    L17:
        Intrinsics.checkNotNullParameter(r101, "text");
        super(r100);
        this.f543534b = r101;
        this.f543535c = r102;
        this.f543536d = r103;
        this.f543537e = r104;
        this.f543538f = r105;
    }
}
