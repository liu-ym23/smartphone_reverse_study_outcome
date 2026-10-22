package k61;

import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f501945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n61.a f501946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LivePerfBizType f501947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LivePerfBizLevel f501948d;

    /* JADX INFO: renamed from: k61.a$a, reason: collision with other inner class name */
    public static final class C6511a {
    }

    static {
    }

    public final String toString() {
        return "BasicPerfInfo(type=" + this.f501947c.name() + ", level=" + this.f501948d.getLevel() + ')';
    }

    public final LivePerfBizType getType() {
        return this.f501947c;
    }

    public a(LivePerfBizType r100, LivePerfBizLevel r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "level");
        this.f501947c = r100;
        this.f501948d = r101;
    }
}
