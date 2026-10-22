package com.bytedance.ee.bear.doc.vote;

import com.bytedance.ee.bear.jsbridge.jsapi.entity.BaseJSModel;

/* JADX INFO: loaded from: classes16.dex */
public class VoteOptionJsData implements BaseJSModel {
    public String block_id;
    public boolean isVoteDesc;
    public String offset;
    public String option_id;
    public String page_id;
    public int vote_count;

    public VoteOptionJsData() {
        this.offset = "";
        this.isVoteDesc = false;
    }
}
