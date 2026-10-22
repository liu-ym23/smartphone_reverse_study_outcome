package mv0;

import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.livesdk.chatroom.dsl.DSLContainerDynamicProxy;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements l71.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f515821a = null;

    public e() {
    }

    static {
        f515821a = new e();
    }

    @Override // l71.b
    public final is2.k a(d90.d r100, Tetris r101) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        Intrinsics.checkNotNullParameter("con_4_1", "tag");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        com.bytedance.android.livesdk.chatroom.dsl.b r102 = DSLContainerDynamicProxy.f105879f;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.a(r100, "con_4_1", r101);
    }
}
