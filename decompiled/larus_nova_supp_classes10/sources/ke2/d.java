package ke2;

import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final void a(MusicPanel r2, Map<String, String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "logParams");
        if (r4 == false) goto L5;
        boolean r5 = j.i();
    L6:
        if (r5 == false) goto L17;
        if (r2 == null) goto L14;
        KtvMusic r6 = r2.a;
        if (r6 == null) goto L14;
        WantListenInfo r7 = r6.getWantListenInfo();
        if (r7 == null) goto L14;
        String r8 = String.valueOf(r7.getWantListenCount().longValue());
        if (r8 == null) goto L14;
    L15:
        r3.put("listen_song_cnt", r8);
        return;
    L14:
        r8 = BDLocationException.ERROR_TIMEOUT;
        goto L15
    L17:
        return;
    L5:
        r5 = true;
        goto L6
    }
}
