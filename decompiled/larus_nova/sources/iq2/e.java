package iq2;

import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedViewService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IKtvComponentFeedViewService f495336a;

    public final d a() {
        IKtvComponentFeedView r100 = this.f495336a.getKtvComponentFeedView();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new d(r100);
    }

    public e(IKtvComponentFeedViewService r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f495336a = r100;
    }
}
