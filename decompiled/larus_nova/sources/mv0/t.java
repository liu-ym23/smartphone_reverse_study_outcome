package mv0;

import com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class t extends qs0.a<IMediaLinkOutService> implements qs0.r {
    public t() {
        super(jc1.k.n(IMediaLinkOutService.class));
    }

    @Override // qs0.r
    public final boolean isUserInMediaLink(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return ((IMediaLinkOutService) this.f534640a).isUserInMediaLink(r100);
    }
}
