package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class BotsResponse implements Serializable {
    public List<Chatter> chatters;
    public boolean hasMore;

    public BotsResponse(List<Chatter> r100, boolean r101) {
        this.chatters = r100;
        this.hasMore = r101;
    }
}
