package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.MergeForwardContent;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public final class x {
    public static Reaction a(Message.Reaction r100) {
        String r101 = r100.type;
        int r102 = r100.chatter_count.intValue();
        List<String> r103 = r100.chatter_ids;
        if (r102 > 0) goto L11;
        if (r103 != null) goto L7;
    L9:
        r102 = 0;
        goto L11
    L7:
        if (r103.isEmpty() == true) goto L9;
        r102 = r103.size();
    L11:
        return new Reaction(r101, r102, r100.chatter_ids);
    }

    public static List<Reaction> b(List<Message.Reaction> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L8;
        Iterator<Message.Reaction> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.add(a(r102.next()));
    L8:
        return r101;
    }

    public static Map<String, List<Reaction>> c(Map<String, MergeForwardContent.MessageReaction> r100) {
        HashMap r101 = new HashMap();
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<MergeForwardContent.MessageReaction> r102 = r100.values().iterator();
    L7:
        if (r102.hasNext() == false) goto L13;
        MergeForwardContent.MessageReaction r103 = r102.next();
        ArrayList r104 = new ArrayList();
        Iterator<MergeForwardContent.Reaction> r105 = r103.reactions.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        MergeForwardContent.Reaction r106 = r105.next();
        r104.add(new Reaction(r106.type, r106.count.intValue(), r106.chatter_ids));
        goto L10
    L12:
        r101.put(r103.message_id, r104);
        goto L7
    L13:
        return r101;
    }
}
