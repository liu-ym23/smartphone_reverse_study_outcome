package com.larus.bmhome.chat.list.cell.test;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class y extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f305993e = 0;

    public static final class a {
        public static y a(Message r510) {
            Intrinsics.checkNotNullParameter(r510, "message");
            int r100 = com.larus.bmhome.chat.layout.holder.helper.s.f303683a;
            Intrinsics.checkNotNullParameter(r510, "message");
            List r101 = com.larus.bmhome.chat.layout.holder.helper.s.a(r510);
            if (r101 == null) goto L20;
            Iterator r102 = r101.iterator();
            if (r102.hasNext() == true) goto L7;
            Object r103 = null;
        L17:
            Message r104 = (Message) r103;
            if (r104 == null) goto L20;
            long r105 = r104.getLocalIndex();
        L21:
            long r210 = r105 - 1;
            String r106 = r510.getConversationId();
            String r107 = r510.getSenderId();
            String r211 = r510.getMessageId() + "-crowd-onClick-tab";
            String r212 = r510.getSectionId();
            String r310 = r510.getReplyId();
            MessageStatus r110 = MessageStatus.MessageStatus_AVAILABLE;
            List<List<Message>> r410 = r510.getSubListGroup();
            Pair[] r108 = new Pair[1];
            String r109 = r510.getMessageId();
            String r111 = "";
            if (r109 != null) goto L24;
            r109 = "";
        L24:
            r108[0] = TuplesKt.to("refer_msg_id", r109);
            Map<String, String> r112 = c.a(MapsKt.mutableMapOf(r108), r510);
            Pair[] r113 = new Pair[1];
            String r114 = r510.getSenderId();
            if (r114 == null) goto L28;
            r111 = r114;
        L28:
            r113[0] = TuplesKt.to("bot_id", r111);
            return new y(b0.j(new Message(r106, null, r107, 0, 21, r110, 800, false, null, null, null, null, null, r112, null, r211, r210, 0, false, r212, null, null, MapsKt.mutableMapOf(r113), null, null, 0, false, 0, r310, null, false, "crowd_test_tab", null, 0, null, r410, null, 1874222986, 23, null), 7));
        L7:
            Object r115 = r102.next();
            if (r102.hasNext() == true) goto L10;
        L9:
            r103 = r115;
            goto L17
        L10:
            long r116 = ((Message) r115).getServerIndex();
        L11:
            Object r117 = r102.next();
            long r118 = ((Message) r117).getServerIndex();
            if (r116 <= r118) goto L15;
            r115 = r117;
            r116 = r118;
        L15:
            if (r102.hasNext() == true) goto L11;
        L20:
            r105 = r510.getLocalIndex();
            goto L21
        }
    }

    static {
    }

    @Override // xc8.b
    public final int d() {
        return 0;
    }

    public y(Message r100) {
        super(r100);
    }
}
