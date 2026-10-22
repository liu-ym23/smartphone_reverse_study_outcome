package fi3;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f477337e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f477339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f477340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f477341d;

    public static final class a {
    }

    static {
    }

    public w() {
        this("", "", "", "");
    }

    public final String getIdentifier() {
        return this.f477339b;
    }

    public w(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r103, "command");
        this.f477338a = r100;
        this.f477339b = r101;
        this.f477340c = r102;
        this.f477341d = r103;
    }
}
