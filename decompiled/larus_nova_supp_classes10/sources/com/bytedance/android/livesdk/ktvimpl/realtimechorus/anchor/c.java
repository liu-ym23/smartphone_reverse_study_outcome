package com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget;
import com.bytedance.android.livesdk.message.linker.LinkmicInfoWithRtcInfoData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c extends com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b {
    public static final a W0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static c a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("real_time_chorus_anchor_context");
            if ((r0 instanceof RealTimeChorusAnchorDataContext) == true) goto L5;
            r0 = null;
        L5:
            RealTimeChorusAnchorDataContext r1 = (RealTimeChorusAnchorDataContext) r0;
            if (r1 == null) goto L11;
            j<c> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (c) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        W0 = a.a;
    }

    void C3(RealTimeChorusBusinessWidget.h r1);

    void E4(RealTimeChorusBusinessWidget.h r1);

    void finishAudioTalk();

    int getSelfSilenceType();

    void j2(int r1, LinkmicInfoWithRtcInfoData r2);

    RealTimeChorusMainViewWidget u2();

    void zg(String r1, String r2);
}
