package com.ss.android.lark.chat.entity.reaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
public class Reaction implements Serializable, b<Reaction> {
    private List<String> chatterIds;
    private int count;
    private String messageId;
    private String type;

    public boolean isItemSame(Reaction r100) {
        return true;
    }

    public String toString() {
        return "Reaction{type='" + this.type + "', count=" + this.count + ", chatterIds=" + this.chatterIds + '}';
    }

    public Reaction() {
    }

    public List<String> getChatterIds() {
        return this.chatterIds;
    }

    public int getCount() {
        return this.count;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getType() {
        return this.type;
    }

    public boolean isContentSame(Reaction r100) {
        if (this.type.equals(r100.getType()) == true) goto L6;
        return false;
    L6:
        if (this.count == r100.getCount()) goto L8;
        return false;
    L8:
        List<String> r101 = r100.getChatterIds();
        if (this.chatterIds.size() != r101.size()) goto L16;
        if (this.chatterIds.containsAll(r101) == false) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((Reaction) r100);
    }

    public void setChatterIds(List<String> r100) {
        this.chatterIds = r100;
    }

    public void setCount(int r100) {
        this.count = r100;
    }

    public void setMessageId(String r100) {
        this.messageId = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((Reaction) r100);
    }

    public Reaction(String r100, int r101, String r102) {
        this.type = r100;
        this.count = r101;
        this.chatterIds = new ArrayList(Arrays.asList(new String[]{r102}));
    }

    public Reaction(String r100, int r101, List<String> r102) {
        this.type = r100;
        this.count = r101;
        this.chatterIds = r102;
    }
}
