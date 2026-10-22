package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public final class j {

    public class a implements y.a<Message.Reaction, Reaction> {
        public a() {
        }

        @Override // com.larksuite.framework.utils.y.a
        public final Reaction get(Message.Reaction r100) {
            Message.Reaction r101 = r100;
            String r102 = r101.type;
            int r103 = r101.chatter_count.intValue();
            List<String> r104 = r101.chatter_ids;
            if (r103 > 0) goto L11;
            if (r104 != null) goto L7;
        L9:
            r103 = 0;
            goto L11
        L7:
            if (r104.isEmpty() == true) goto L9;
            r103 = r104.size();
        L11:
            return new Reaction(r102, r103, r101.chatter_ids);
        }
    }

    public static ArrayList<Reaction> a(List<Message.Reaction> r100) {
        return new ArrayList(y.a(r100, new a()));
    }
}
