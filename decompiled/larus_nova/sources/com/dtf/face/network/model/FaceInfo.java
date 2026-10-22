package com.dtf.face.network.model;

import android.graphics.Rect;
import com.alibaba.fastjson.annotation.JSONField;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class FaceInfo {

    @JSONField(name = "confidence")
    public float confidence;

    @JSONField(name = "feaVersion")
    public String feaVersion;

    @JSONField(name = "feature")
    public String feature;

    @JSONField(name = "points")
    public List<android.graphics.Point> points;

    @JSONField(name = GearStrategyConsts.EV_QUALITY)
    public float quality;

    @JSONField(name = SVGRenderEngine.RECT)
    public Rect rect;

    public FaceInfo() {
    }

    public FaceInfo(Rect r100, List<android.graphics.Point> r101, float r102, float r103, String r104, String r105) {
        this.rect = r100;
        this.points = r101;
        this.confidence = r102;
        this.quality = r103;
        this.feature = r104;
        this.feaVersion = r105;
    }
}
