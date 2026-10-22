package st0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class e extends com.bytedance.android.live.profile.ui.component.base.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f543540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f543541c;

    public e(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "title");
        super(r100);
        this.f543540b = r101;
        this.f543541c = r102;
    }

    public /* synthetic */ e(int r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = "";
    L5:
        this(r100, r101, false);
    }
}
