package com.bytedance.ee.bear.atfinder;

import com.bytedance.ee.bear.config.CcmMentionConfig;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes15.dex */
public class MentionModel implements NonProguard {
    private static final int AUTHOR_MAX_COUNT = 0;
    private static final String TAG = "MentionModel";
    private ArrayList<String> authorIds;
    private String chatId;
    private boolean isOwner;
    private String keyword;
    private String ownerId;
    private int source;
    private String token;

    static {
        int r100 = ((CcmMentionConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c(CcmMentionConfig.KEY, CcmMentionConfig.class, new CcmMentionConfig())).getAuthorMaxCount();
        AUTHOR_MAX_COUNT = r100;
        tt5.a.h(TAG, "AUTHOR_MAX_COUNT = " + r100);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("MentionModel{keyword='");
        r100.append(this.keyword);
        r100.append("', token='");
        r100.append(this.token);
        r100.append("', source=");
        r100.append(this.source);
        r100.append(", chatId='");
        r100.append(this.chatId);
        r100.append("', ownerId='");
        r100.append(this.ownerId);
        r100.append("', isOwner='");
        r100.append(this.isOwner);
        r100.append("', authorIds='");
        ArrayList<String> r101 = this.authorIds;
        if (r101 != null) goto L5;
        String r102 = "";
    L10:
        r100.append(r102);
        r100.append("'}");
        return r100.toString();
    L5:
        StringBuilder r103 = new StringBuilder("[\n");
        Iterator<String> r104 = r101.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        String r105 = r104.next();
        r103.append("\t");
        r103.append(r105.toString());
        r103.append("\n");
        goto L7
    L9:
        r103.append("]");
        r102 = r103.toString();
        goto L10
    }

    public MentionModel() {
    }

    public ArrayList<String> getAuthorIds() {
        return this.authorIds;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public int getSource() {
        return this.source;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isOwner() {
        return this.isOwner;
    }

    public void setAuthorIds(ArrayList<String> r100) {
        if (r100 == null) goto L6;
        int r101 = r100.size();
        int r102 = AUTHOR_MAX_COUNT;
        if (r101 <= r102) goto L6;
        this.authorIds = new ArrayList(r100.subList(0, r102));
        return;
    L6:
        this.authorIds = r100;
    }

    public void setChatId(String r100) {
        this.chatId = r100;
    }

    public void setKeyword(String r100) {
        this.keyword = r100;
    }

    public void setOwner(boolean r100) {
        this.isOwner = r100;
    }

    public void setOwnerId(String r100) {
        this.ownerId = r100;
    }

    public void setSource(int r100) {
        this.source = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public MentionModel(String r100, String r101, int r102) {
        this.keyword = r100;
        this.token = r101;
        this.source = r102;
    }

    public MentionModel(String r100, String r101, int r102, String r103) {
        this.keyword = r100;
        this.token = r101;
        this.source = r102;
        this.chatId = r103;
    }
}
