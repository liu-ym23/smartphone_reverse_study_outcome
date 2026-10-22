package fr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedForwardStreamStateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f1 implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError f478503a;

    @Override // fr2.i
    public final int value() {
        return this.f478503a.value();
    }

    @Override // fr2.i
    public final LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError getReal() {
        return this.f478503a;
    }

    public f1(LiveWrappedForwardStreamStateInfo.LiveWrappedForwardStreamError r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478503a = r100;
    }
}
