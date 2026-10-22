package com.larus.bmhome.chat.list.cell.test;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<List<String>> f305986e = null;

    public static final class a {
        public static p a(Message r510) {
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
            long r210 = r105 + 1;
            String r106 = r510.getConversationId();
            String r211 = r510.getMessageId() + "-crowd-onClick-selection";
            String r212 = r510.getSectionId();
            String r310 = r510.getReplyId();
            MessageStatus r110 = MessageStatus.MessageStatus_AVAILABLE;
            List<List<Message>> r410 = r510.getSubListGroup();
            Pair[] r107 = new Pair[3];
            String r108 = r510.getMessageId();
            String r109 = "";
            if (r108 != null) goto L24;
            r108 = "";
        L24:
            r107[0] = TuplesKt.to("refer_msg_id", r108);
            r107[1] = TuplesKt.to("crowd_test_title", com.larus.bmhome.chat.bean.d.x(r510).getCrowdTestTitle());
            r107[2] = TuplesKt.to("crowd_test_button_list", com.larus.bmhome.chat.bean.d.x(r510).getCrowdTestButtonList());
            Map<String, String> r111 = c.a(MapsKt.mutableMapOf(r107), r510);
            Pair[] r112 = new Pair[1];
            String r113 = r510.getSenderId();
            if (r113 == null) goto L28;
            r109 = r113;
        L28:
            r112[0] = TuplesKt.to("bot_id", r109);
            return new p(b0.j(new Message(r106, null, null, 0, 21, r110, 800, false, null, null, null, null, null, r111, null, r211, r210, 0, false, r212, null, null, MapsKt.mutableMapOf(r112), null, null, 0, false, 0, r310, null, false, "crowd_test_selection", null, 0, null, r410, null, 1874222990, 23, null), 6));
        L7:
            Object r114 = r102.next();
            if (r102.hasNext() == true) goto L10;
        L9:
            r103 = r114;
            goto L17
        L10:
            long r115 = ((Message) r114).getServerIndex();
        L11:
            Object r116 = r102.next();
            long r117 = ((Message) r116).getServerIndex();
            if (r115 >= r117) goto L15;
            r114 = r116;
            r115 = r117;
        L15:
            if (r102.hasNext() == true) goto L11;
        L20:
            r105 = r510.getLocalIndex();
            goto L21
        }
    }

    static {
        f305986e = LazyKt.lazy(new o());
    }

    public p(Message r100) {
        super(r100);
    }
}
