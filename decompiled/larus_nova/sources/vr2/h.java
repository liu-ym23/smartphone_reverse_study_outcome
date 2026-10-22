package vr2;

import com.bytedance.android.livesdkapi.interact.data.LinkFeedTypeConstant;
import com.bytedance.android.scope.o;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements o, b {
    public h() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // vr2.b
    public final boolean N7(int r100) {
        return LinkFeedTypeConstant.Companion.isDouyinFullScreen(r100);
    }

    @Override // vr2.b
    public final boolean xd(int r100) {
        return LinkFeedTypeConstant.Companion.isDouyinIMCardLive(r100);
    }
}
