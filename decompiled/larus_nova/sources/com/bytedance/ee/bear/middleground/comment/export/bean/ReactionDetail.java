package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

    public void setData(List<Reaction> r100) {
        this.data = r100;
    }

    public void setReactionKey(String r100) {
        this.reactionKey = r100;
    }

    public void setReferKey(String r100) {
        this.referKey = r100;
    }

    public void setReferType(String r100) {
        this.referType = r100;
    }

    public ReactionDetail(String r100, String r101, List<Reaction> r102) {
        this.referType = r100;
        this.referKey = r101;
        this.data = r102;
    }
}
