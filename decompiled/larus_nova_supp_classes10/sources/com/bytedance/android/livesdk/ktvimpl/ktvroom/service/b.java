package com.bytedance.android.livesdk.ktvimpl.ktvroom.service;

import android.content.Context;
import com.bytedance.android.livesdk.message.linker.LinkmicInfoWithRtcInfoData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b extends com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a {
    public static final a T0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static b a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("ktv_room_anchor_context");
            if ((r0 instanceof KtvAnchorDataContext) == true) goto L5;
            r0 = null;
        L5:
            KtvAnchorDataContext r1 = (KtvAnchorDataContext) r0;
            if (r1 == null) goto L11;
            j<b> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (b) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        T0 = a.a;
    }

    void finishAudioTalk();

    int getSelfSilenceType();

    void j2(int r1, LinkmicInfoWithRtcInfoData r2);

    void switchScene(int r1, int r2, int r3, String r4);

    void switchVoiceSceneWithCheck(Context r1, String r2);
}
