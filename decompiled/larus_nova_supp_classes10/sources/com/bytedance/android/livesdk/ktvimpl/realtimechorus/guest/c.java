package com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import tf0.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface c extends b {
    public static final a Y0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static c a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("real_time_chorus_guest_context");
            if ((r0 instanceof RealTimeChorusGuestDataContext) == true) goto L5;
            r0 = null;
        L5:
            RealTimeChorusGuestDataContext r1 = (RealTimeChorusGuestDataContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<c> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (c) r2.getValue();
        L11:
            return null;
        }
    }

    static {
        Y0 = a.a;
    }

    void A7();

    void C3(RealTimeChorusBusinessWidget.h r1);

    void E0(String r1);

    void E4(RealTimeChorusBusinessWidget.h r1);

    void Ji();

    void K2(boolean r1, boolean r2, q r3);

    void O0(String r1, String r2, boolean r3);

    void Re();

    void W0(String r1, String r2);

    void bm(String r1);

    void cancelApply(h80.a<Boolean> r1, boolean r2, String r3);

    void checkAndApply(int r1, String r2, int r3, String r4);

    void checkAndReply(long r1, String r3, String r4, int r5);

    void disconnect(int r1, boolean r2, boolean r3, boolean r4, rj0.c r5);

    Object getRealTimeChorusMicManager();

    Pair<String, Map<String, Map<String, List<Object>>>> getRoomWrdsListenerData();

    int getSelfSilenceType();

    com.bytedance.android.live.pushstream.d guestLiveStream();

    void ktvApply(KtvMusic r1, String r2, LinkApplyType r3, int r4, tf0.b r5);

    void onSei(String r1, ye1.a r2);

    RealTimeChorusMainViewWidget u2();
}
