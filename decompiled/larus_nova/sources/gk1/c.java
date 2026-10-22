package gk1;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ls2.d;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.bytedance.android.livesdk.room.Task.base.a<d, ls2.c> {
    @Override // gs2.a
    public final String taskID() {
        return "VsPageSourceLogInitTask";
    }

    @Override // com.bytedance.android.livesdk.room.Task.base.LiveTask
    public final List<String> f() {
        ArrayList r100 = new ArrayList();
        r100.add("RoomSessionTaskConst_SessionContainerIntentInitTask");
        return r100;
    }

    @Override // gs2.a
    public final void run() {
        d r100 = h();
        Bundle r101 = r100.f510526o;
        if (r101 != null) goto L5;
        ju2.b r102 = null;
    L35:
        ((ik1.d) h().b("RoomSessionTaskConst_live_room_container_data")).f490230f = r102;
        return;
    L5:
        String r103 = r101.getString(VSConstants.EXTRA_RECOMMEND_TYPE);
        String r104 = r100.f510526o.getString(VSConstants.EXTRA_BOOST_TASK_ID);
        String r105 = r100.f510526o.getString(VSConstants.EXTRA_INSERT_TASK_ID);
        ju2.b r106 = new ju2.b();
        if (TextUtils.isEmpty(r103) == false) goto L8;
        r103 = "";
    L8:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r106.f500420d = r103;
        if (TextUtils.isEmpty(r104) == false) goto L11;
        r104 = "";
    L11:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r106.f500434r = r104;
        if (TextUtils.isEmpty(r105) == false) goto L14;
        r105 = "";
    L14:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r106.f500421e = r105;
        if (TextUtils.isEmpty(r100.f510516e) == false) goto L17;
        String r107 = "";
    L18:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f500418b = r107;
        if (TextUtils.isEmpty(r100.f510517f) == false) goto L21;
        String r108 = "";
    L22:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r106.f500419c = r108;
        Bundle r109 = m0.a(r100.f510526o);
        if (r109.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE) == false) goto L26;
        String r110 = r109.getString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE, "");
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r106.f500422f = r110;
    L26:
        if (r109.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_VIDEO_TYPES) == false) goto L28;
        r106.f500429m = r109.getInt(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_VIDEO_TYPES, 0);
    L28:
        String r111 = r100.f510526o.getString(VSConstants.EXTRA_VS_AWEME_VIDEO_ID);
        if (TextUtils.isEmpty(r111) == true) goto L32;
        r106.f500424h = r111;
    L32:
        if (r100.f510526o.containsKey(VSConstants.EXTRA_VS_IS_WATCHED_AWEME_VIDEO) == false) goto L34;
        r106.f500425i = Integer.valueOf(r100.f510526o.getInt(VSConstants.EXTRA_VS_IS_WATCHED_AWEME_VIDEO));
    L34:
        r102 = r106;
        goto L35
    L21:
        r108 = r100.f510517f;
        goto L22
    L17:
        r107 = r100.f510516e;
        goto L18
    }

    public c() {
    }

    @Override // gs2.a
    public final LiveTaskType d() {
        return LiveTaskType.MAIN;
    }
}
