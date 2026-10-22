package im0;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.messagewindow.framework.process.a f490449e;

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.live.messagewindow.framework.process.a r100 = this.f490449e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "action");
        r100.f83132a = this;
    }

    public f(com.bytedance.android.live.messagewindow.framework.process.a r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        super(j71.a.f.f497569b);
        this.f490449e = r100;
    }
}
