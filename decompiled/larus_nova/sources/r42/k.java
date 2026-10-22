package r42;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k extends i {
    @Override // r42.i
    public final boolean a() {
        return this.f536044b;
    }

    public k(IRoom r100) {
        super(r100);
    }

    @Override // r42.i
    public final void b(vlc.d r100, aa2.e r101) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        Intrinsics.checkNotNullParameter(r101, "onHistoryCallBack");
        ALogger.i("HISTORY_COMMENT_TAG", "start load history comment...");
        if ((r100 instanceof vlc.e) == true) goto L5;
        vlc.d r102 = null;
    L6:
        vlc.e r103 = (vlc.e) r102;
        if (r103 == null) goto L10;
        r103.E(new tlc.a(-1), new j(this, r101, r100));
        return;
    L10:
        return;
    L5:
        r102 = r100;
        goto L6
    }
}
