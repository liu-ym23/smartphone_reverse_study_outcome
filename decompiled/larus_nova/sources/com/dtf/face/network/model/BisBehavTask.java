package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.sdk.m.s.a;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;

/* JADX INFO: loaded from: classes22.dex */
public class BisBehavTask {

    @JSONField(name = "dur")
    public int dur;

    @JSONField(name = a.f25767y)
    public String extInfo;

    @JSONField(name = "idx")
    public String idx;

    @JSONField(name = "name")
    public String name;

    @JSONField(name = GearStrategyConsts.EV_QUALITY)
    public int quality;

    public BisBehavTask() {
        this.name = "";
        this.idx = "";
        this.dur = 0;
        this.quality = 0;
        this.extInfo = "";
    }
}
