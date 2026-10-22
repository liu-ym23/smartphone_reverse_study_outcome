package com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableDataModel;
import com.bytedance.ee.bear.bitable.card.viewmodel.parser.FieldTypeDeserializer;
import com.bytedance.ee.bear.bitable.card.viewmodel.parser.FieldUITypeDeserializer;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes15.dex */
public class ReferenceModel implements NonProguard {
    public static final int FAIL_STATE = 2;
    public static final int NONE_PROXY_TYPE = -1;
    public static final int PENDING_STATE = 0;
    public static final int SUCCESS_STATE = 1;
    private String payload;
    private int proxyType;
    private int state;

    public TableDataModel.RecordsBean.ContentBean parseToContentBean() {
        com.bytedance.ee.bear.bitable.filter.parse.a r100 = new com.bytedance.ee.bear.bitable.filter.parse.a();
        r100.putDeserializer(EFieldType.class, new FieldTypeDeserializer());
        r100.putDeserializer(EFieldUIType.class, new FieldUITypeDeserializer());
        return (TableDataModel.RecordsBean.ContentBean) JSON.parseObject(this.payload, TableDataModel.RecordsBean.ContentBean.class, r100, new oq4.a(), JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
    }

    public ReferenceModel() {
        this.state = -1;
        this.proxyType = -1;
    }

    public String getPayload() {
        return this.payload;
    }

    public int getProxyType() {
        return this.proxyType;
    }

    public int getState() {
        return this.state;
    }

    public ReferenceModel(String r100) {
        this.state = -1;
        this.proxyType = -1;
        this.payload = r100;
    }

    public void setPayload(String r100) {
        this.payload = r100;
    }

    public void setProxyType(int r100) {
        this.proxyType = r100;
    }

    public void setState(int r100) {
        this.state = r100;
    }
}
