package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.heytap.mcssdk.constant.b;

/* JADX INFO: loaded from: classes22.dex */
public class OCRInfo {

    @JSONField(name = "cardHeight")
    public String cardHeight;

    @JSONField(name = "cardLeft")
    public String cardLeft;

    @JSONField(name = "cardTop")
    public String cardTop;

    @JSONField(name = "cardWidth")
    public String cardWidth;

    @JSONField(name = "certName")
    public String certName;

    @JSONField(name = "certNo")
    public String certNo;

    @JSONField(name = b.f276370t)
    public String endDate;
    public boolean isFront;

    @JSONField(name = "name")
    public String name;

    @JSONField(name = "nowDate")
    public String nowDate;

    @JSONField(name = "num")
    public String num;

    @JSONField(name = b.f276369s)
    public String startDate;

    public OCRInfo() {
        this.isFront = true;
    }
}
