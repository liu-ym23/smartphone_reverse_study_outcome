package ep1;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.um;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f473419a;

    @Override // ep1.e, ep1.c
    public final String b() {
        if (z.i(this.f473419a) == false) goto L8;
        if (um.f121385a.getValue().booleanValue() == false) goto L8;
        return s1.B(R.string.ttlive_anchor_toolbar_title_broadcast_game_effect);
    L8:
        return s1.B(R.string.ttlive_broadcast_more_dialog_title_effect);
    }

    public b() {
        this.f473419a = null;
    }
}
