package ue1;

import am2.x;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.audiencerecord.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Room f549791a;

    public final void b() {
        HashMap r100 = new HashMap();
        Room r101 = this.f549791a;
        if (r101 == null) goto L18;
        LiveMode r102 = r101.getStreamType();
        int r103 = h1.f66189a;
        r100.put("live_type", i1.a(r102));
        Context r104 = s1.getContext();
        if (r104 == null) goto L13;
        Resources r105 = r104.getResources();
        if (r105 == null) goto L13;
        Configuration r106 = r105.getConfiguration();
        if (r106 == null) goto L13;
        if (r106.orientation != 1) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
        String r108 = "0";
    L17:
        r100.put("room_orientation", r108);
        goto L18
    L16:
        r108 = "1";
    L13:
        r107 = false;
    L18:
        u.l().sendLog("livesdk_watched_record_finish_success", r100, new Object[]{Room.class, x.class});
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        HashMap r101 = new HashMap();
        Room r102 = this.f549791a;
        if (r102 == null) goto L5;
        LiveMode r103 = r102.getStreamType();
        int r104 = h1.f66189a;
        r101.put("live_type", i1.a(r103));
    L5:
        Context r105 = s1.getContext();
        if (r105 == null) goto L14;
        Resources r106 = r105.getResources();
        if (r106 == null) goto L14;
        Configuration r107 = r106.getConfiguration();
        if (r107 == null) goto L14;
        if (r107.orientation != 1) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L17;
        String r109 = "0";
    L18:
        r101.put("room_orientation", r109);
        r101.put("reason", r100);
        u.l().sendLog("livesdk_watched_record_finish_fail", r101, new Object[]{Room.class, x.class});
        return;
    L17:
        r109 = "1";
    L14:
        r108 = false;
        goto L15
    }

    public b(Room r100, o r101) {
        this.f549791a = r100;
    }
}
