package ke2;

import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {
    public static final void a(MusicPanel r100, Map<String, String> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "logParams");
        if (r102 == false) goto L5;
        boolean r103 = j.i();
    L6:
        if (r103 == false) goto L17;
        if (r100 == null) goto L14;
        KtvMusic r104 = r100.f153577a;
        if (r104 == null) goto L14;
        WantListenInfo r105 = r104.getWantListenInfo();
        if (r105 == null) goto L14;
        String r106 = String.valueOf(r105.getWantListenCount().longValue());
        if (r106 == null) goto L14;
    L15:
        r101.put("listen_song_cnt", r106);
        return;
    L14:
        r106 = "0";
        goto L15
    L17:
        return;
    L5:
        r103 = true;
        goto L6
    }
}
