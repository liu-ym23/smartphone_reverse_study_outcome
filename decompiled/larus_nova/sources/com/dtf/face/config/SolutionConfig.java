package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import faceverify.w;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class SolutionConfig {
    public int currentConfigBizIndex;

    @JSONField(name = "navi")
    public NavigatePage navi;

    @JSONField(name = "order")
    public List<String> order;

    public void fixValidConfig() {
        List<String> r100 = this.order;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L20:
        if (r101 == true) goto L25;
        this.order.clear();
        return;
    L25:
        return;
    L5:
        if (r100.size() <= 0) goto L20;
        int r102 = 0;
        boolean r103 = true;
    L8:
        if (r102 >= this.order.size()) goto L19;
        if (w.BLOB_ELEM_TYPE_FACE.equals(ListProtector.get(this.order, r102)) == false) goto L12;
    L15:
        r103 = true;
    L16:
        if (r103 == false) goto L19;
        r102 = r102 + 1;
        goto L8
    L12:
        if ("doc".equals(ListProtector.get(this.order, r102)) == true) goto L15;
        r103 = false;
    L19:
        r101 = r103;
        goto L20
    }

    public SolutionConfig() {
        this.currentConfigBizIndex = 0;
    }
}
