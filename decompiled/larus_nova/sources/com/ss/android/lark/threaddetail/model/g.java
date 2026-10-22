package com.ss.android.lark.threaddetail.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    public interface a {
        ThreadTopic N1();

        MessageInfo O1();
    }

    static {
    }

    @JvmStatic
    public static final boolean a(n5b.a r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "dataCallback");
        if (r100.f518077b.isSameOnPush(r101.N1()) == true) goto L5;
        return false;
    L5:
        MessageInfo r102 = new MessageInfo(r100.f518078c, r100.f518076a);
        r102.setReactionInfoList(r100.f518079d);
        r102.setPin(r100.f518082g);
        r102.setTranslateInfo(r100.f518083h);
        r102.setIsTranslating(r100.isTranslating());
        r102.setNeedToAutoTranslate(r100.f518085j);
        r102.setOriginalSender(r100.f518084i);
        r102.setDingStatus(r100.f518089n);
        r102.setRecallUser(r100.f518090o);
        MessageInfo r103 = r101.O1();
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r102.getMessage().isContentSame(r103.getMessage()) == true) goto L12;
        return false;
    L12:
        if (r102.getMessageSender().isContentSame(r103.getMessageSender()) == false) goto L93;
        List<ReactionInfo> r104 = r102.getReactionInfoList();
        if (r104 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == false) goto L31;
        List<ReactionInfo> r106 = r103.getReactionInfoList();
        if (r106 != null) goto L25;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == false) goto L31;
    L87:
        return true;
    L25:
        if (r106.isEmpty() == true) goto L28;
        r107 = false;
    L31:
        List<ReactionInfo> r108 = r102.getReactionInfoList();
        List<ReactionInfo> r109 = r103.getReactionInfoList();
        if (r108 == r109) goto L47;
        if (r108 == null) goto L48;
        if (r109 == null) goto L48;
        if (r108.size() != r109.size()) goto L48;
        int r110 = 0;
    L42:
        if (r110 >= r108.size()) goto L47;
        if (((y28.b) ListProtector.get(r108, r110)).isContentSame((y28.b) ListProtector.get(r109, r110)) == false) goto L48;
        r110 = r110 + 1;
    L48:
        boolean r111 = false;
    L49:
        if (r111 == false) goto L94;
        Pin r112 = r102.getPin();
        if (r112 != null) goto L54;
    L56:
        boolean r113 = false;
    L57:
        if (r113 == false) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(r102.getTranslateInfo(), r103.getTranslateInfo()) == true) goto L63;
        return false;
    L63:
        if (r102.isTranslating() == r103.isTranslating()) goto L66;
        return false;
    L66:
        if (r102.isNeedToAutoTranslate() != r103.isNeedToAutoTranslate()) goto L98;
        ChatChatter r114 = r102.getOriginalSender();
        if (r114 != null) goto L71;
    L73:
        boolean r115 = false;
    L74:
        if (r115 == false) goto L77;
        return false;
    L77:
        if (Intrinsics.areEqual(r102.getDingStatus(), r103.getDingStatus()) == false) goto L100;
        ChatChatter r116 = r102.getRecallUser();
        if (r116 != null) goto L82;
    L84:
        boolean r117 = false;
    L85:
        if (r117 == false) goto L87;
        return false;
    L82:
        if (r116.isContentSame(r103.getRecallUser()) == true) goto L84;
        r117 = true;
        goto L85
    L100:
        return false;
    L71:
        if (r114.isContentSame(r103.getOriginalSender()) == true) goto L73;
        r115 = true;
        goto L74
    L98:
        return false;
    L54:
        if (r112.isContentSame(r103.getPin()) == true) goto L56;
        r113 = true;
        goto L57
    L94:
        return false;
    L47:
        r111 = true;
        goto L49
    L17:
        if (r104.isEmpty() == true) goto L20;
        r105 = false;
        goto L21
    L93:
        return false;
    }
}
