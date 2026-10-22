package zg1;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f571820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f571821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f571823d;

    public static final class a {
    }

    static {
    }

    public e3(boolean r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f571821b = r100;
        this.f571822c = r101;
        this.f571823d = r102;
        ALogger.w("ToolbarLandscapeBlockEvent", "block:" + this.f571821b + ",token:" + r101 + ",source:" + r102);
    }

    public /* synthetic */ e3(boolean r100, String r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        r101 = "default";
    L5:
        this(r100, 0, r101);
    }
}
