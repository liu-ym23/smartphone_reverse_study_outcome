package hq2;

import com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IMediaLinkOutService f486499a;

    public final boolean a() {
        return this.f486499a.isMediaLinkOn();
    }

    public final void b() {
        this.f486499a.onClickLinkIcon();
    }

    public d(IMediaLinkOutService r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f486499a = r100;
    }
}
