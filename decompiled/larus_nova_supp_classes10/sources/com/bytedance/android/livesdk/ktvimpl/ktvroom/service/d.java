package com.bytedance.android.livesdk.ktvimpl.ktvroom.service;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkMatchType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import tf0.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface d extends com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a {
    public static final a U0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static d a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d("voice_chat_guest_context");
            if ((r0 instanceof KtvGuestDataContext) == true) goto L5;
            r0 = null;
        L5:
            KtvGuestDataContext r1 = (KtvGuestDataContext) r0;
            if (r1 == null) goto L11;
            j<d> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (d) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(d r2, h80.a r3, boolean r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = true;
        L8:
            r2.cancelApply(r3, r4, null);
        }
    }

    static {
        U0 = a.a;
    }

    void cancelApply(h80.a<Boolean> r1, boolean r2, String r3);

    void checkAndApply(int r1, String r2, int r3, LinkMatchType r4, String r5, String r6);

    void checkAndApply(int r1, String r2, int r3, String r4);

    void checkAndReply(long r1, String r3, String r4, int r5);

    void disconnect(int r1, boolean r2, boolean r3, boolean r4, rj0.c r5);

    we0.b getLinkmicReturnRoomParams();

    int getSelfSilenceType();

    com.bytedance.android.live.pushstream.d guestLiveStream();

    boolean interceptCloseRoom(Runnable r1, boolean r2);

    void ktvApply(KtvMusic r1, String r2, LinkApplyType r3, int r4, tf0.b r5);

    void onClickToolbar(int r1);

    void onSei(String r1, ye1.a r2);

    void showFollowGuideDialog(boolean r1, q r2);

    void showInviteDialog(boolean r1, String r2, int r3);

    void tryAutoFastMatch();

    void tryFastMatch(String r1);
}
