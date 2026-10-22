package gr2;

import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import fr2.b0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements b0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f482302b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Env f482303a;

    public static final class a {
    }

    static {
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482303a;
    }

    public e(Env r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f482303a = r100;
    }
}
