package ie2;

import android.content.Context;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.AdjustItemView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.DummyItemView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KSongChallengeItemView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.MusicOperateView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.PauseAndRestartItemView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.SilenceOperateView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final MusicOperateView a(MusicOperateType r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "musicOperateType");
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = a.a[r2.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        if (r0 == 4) goto L17;
        return new DummyItemView(r2, r3);
    L17:
        return new SilenceOperateView(r2, r3);
    L18:
        return new KSongChallengeItemView(r2, r3);
    L19:
        return new PauseAndRestartItemView(r2, r3);
    L15:
        return new AdjustItemView(r2, r3);
    }
}
