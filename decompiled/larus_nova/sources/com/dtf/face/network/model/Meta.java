package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ec.core.event.a;
import faceverify.q;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class Meta {

    @JSONField(name = "collectInfo")
    public Map<String, Object> collectInfo;

    @JSONField(name = q.KEY_COLLECT_SIG)
    public String collectInfoSig;

    @JSONField(name = a.KEY_SCORE)
    public Map<String, Object> score;

    @JSONField(name = "serialize")
    public int serialize;

    @JSONField(name = "type")
    public String type;

    public Meta() {
    }

    public Meta(String r100, Map<String, Object> r101, Map<String, Object> r102, int r103) {
        this.type = r100;
        this.score = r101;
        this.collectInfo = r102;
        this.serialize = r103;
    }
}
