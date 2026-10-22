package com.ss.android.lark.chat.entity.reaction;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class ReactionInfo implements Serializable, b<ReactionInfo> {
    private Reaction reaction;
    private Map<String, ChatChatter> reactionChatters;

    public boolean isItemSame(ReactionInfo r100) {
        return true;
    }

    public Reaction getReaction() {
        return this.reaction;
    }

    public Map<String, ChatChatter> getReactionChatters() {
        return this.reactionChatters;
    }

    public boolean isContentSame(ReactionInfo r100) {
        if (this.reaction.isContentSame(r100.reaction) == true) goto L6;
        return false;
    L6:
        if (this.reactionChatters.size() == r100.reactionChatters.size()) goto L8;
    L18:
        return false;
    L8:
        if (this.reactionChatters.values().containsAll(r100.reactionChatters.values()) == false) goto L18;
        Iterator<String> r101 = this.reactionChatters.keySet().iterator();
    L12:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next();
        if (a.c(this.reactionChatters.get(r102), r100.reactionChatters.get(r102)) == true) goto L12;
        return false;
    L16:
        return true;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((ReactionInfo) r100);
    }

    public void setReaction(Reaction r100) {
        this.reaction = r100;
    }

    public void setReactionChatters(Map<String, ChatChatter> r100) {
        this.reactionChatters = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((ReactionInfo) r100);
    }

    public ReactionInfo(Reaction r100, Map<String, ChatChatter> r101) {
        new HashMap();
        this.reaction = r100;
        this.reactionChatters = r101;
    }
}
