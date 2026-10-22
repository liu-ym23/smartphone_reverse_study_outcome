package fr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedMessageConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o1 implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWrappedMessageConfig f478523a;

    public static final class a {
    }

    static {
        new o1(LiveWrappedMessageConfig.RELIABLE_ORDERED);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478523a;
    }

    public o1(LiveWrappedMessageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478523a = r100;
    }
}
