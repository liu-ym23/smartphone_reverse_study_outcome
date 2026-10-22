package yf1;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStackKt;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements c {
    public a() {
    }

    @Override // yf1.c
    public final void a(Bundle r100, Bundle r101, StackContext r102) {
        Intrinsics.checkNotNullParameter(r100, "targetInfo");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Bundle r103 = null;
        Object r104 = null;
        if (r101 == null) goto L5;
        String r105 = com.bytedance.android.livesdk.chatroom.backroom.utils.a.a(r101);
    L7:
        if (TextUtils.equals(IBackRoomStackKt.JUMP_SOURCE_LIVE_CHALLENGE, r105) == false) goto L20;
        Bundle r106 = m0.a(r100);
        if (r106 == null) goto L11;
        Object r107 = r106.clone();
    L13:
        if ((r107 instanceof Bundle) == false) goto L16;
        r104 = r107;
    L16:
        Bundle r108 = (Bundle) r104;
        if (r108 != null) goto L19;
        r108 = new Bundle();
    L19:
        r108.putString(ILiveRoomPlayFragmentConstant.EXTRA_CREATE_PRE_ROOM_BUNDLE_SCENE, "live_challenge_live_detail");
        r108.putLong(ILiveRoomPlayFragmentConstant.EXTRA_PRE_ROOM_ID, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID));
        m0.e(r100, r108);
        return;
    L11:
        r107 = null;
        goto L13
    L20:
        Bundle r109 = m0.a(r100);
        if (r109 != null) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual("live_challenge_live_detail", r109.getString(ILiveRoomPlayFragmentConstant.EXTRA_CREATE_PRE_ROOM_BUNDLE_SCENE)) == false) goto L25;
        r103 = r109;
    L25:
        if (r103 == null) goto L30;
        r103.remove(ILiveRoomPlayFragmentConstant.EXTRA_CREATE_PRE_ROOM_BUNDLE_SCENE);
        r103.remove(ILiveRoomPlayFragmentConstant.EXTRA_PRE_ROOM_ID);
        return;
    L30:
        return;
    L5:
        r105 = null;
        goto L7
    }
}
