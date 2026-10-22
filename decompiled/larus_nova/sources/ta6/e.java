package ta6;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e<T> implements d<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b01.e f545187e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f545189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f545190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Type f545191d;

    public static final class a {
    }

    static {
    }

    @Override // ta6.d
    public Type getType() {
        return this.f545191d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object r100, Type r101) {
        Intrinsics.checkNotNullParameter("gamecp_team_play_kmp_enable", "name");
        Intrinsics.checkNotNullParameter("一键上车kmp开关", "description");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f545188a = "gamecp_team_play_kmp_enable";
        this.f545189b = r100;
        this.f545190c = false;
        this.f545191d = r101;
        ConcurrentHashMap<String, com.bytedance.tools.kcp.ultrasettings.runtime.c> r102 = UltraSettingsManager.f271014a;
        UltraSettingsManager.b("gamecp_team_play_kmp_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("gamecp_team_play_kmp_enable", getType(), "一键上车kmp开关", ""));
    }
}
