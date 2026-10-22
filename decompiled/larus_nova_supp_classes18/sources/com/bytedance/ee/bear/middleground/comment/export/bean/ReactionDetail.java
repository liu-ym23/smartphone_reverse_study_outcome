package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ReactionDetail implements BaseJSModel {
    private List<Reaction> data;
    private String reactionKey;
    private String referKey;
    private String referType;

    public String toString() {
        return "ReactionShowDetail{referType='" + this.referType + "', referKey='" + this.referKey + "', reactionKey='" + this.reactionKey + "', data=" + this.data + '}';
    }

    public ReactionDetail() {
    }

    public List<Reaction> getData() {
        return this.data;
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public String getReferKey() {
        return this.referKey;
    }

    public String getReferType() {
        return this.referType;
    }

    public void setData(List<Reaction> r1) {
        this.data = r1;
    }

    public void setReactionKey(String r1) {
        this.reactionKey = r1;
    }

    public void setReferKey(String r1) {
        this.referKey = r1;
    }

    public void setReferType(String r1) {
        this.referType = r1;
    }

    public ReactionDetail(String r1, String r2, List<Reaction> r3) {
        this.referType = r1;
        this.referKey = r2;
        this.data = r3;
    }
}
