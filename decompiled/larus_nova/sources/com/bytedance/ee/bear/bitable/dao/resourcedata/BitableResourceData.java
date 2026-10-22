package com.bytedance.ee.bear.bitable.dao.resourcedata;

import com.bytedance.ee.bear.bitable.dao.extra.BitableResourceDataExtra;
import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.Gson;
import du5.b;
import tt5.a;

/* JADX INFO: loaded from: classes15.dex */
public class BitableResourceData implements NonProguard {
    public static final String KEY_BASE_TOKEN = "base_token";
    public static final String KEY_BLOCK_ID = "block_id";
    public static final String KEY_DELETE_STRATEGY = "delete_strategy";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_OBJ_TOKEN = "obj_token";
    public static final String KEY_RESOURCE_VALUE = "res_value";
    public static final String KEY_RES_KEY = "res_key";
    public static final String KEY_REV_1 = "rev1";
    public static final String KEY_REV_2 = "rev2";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String KEY_VIEW_ID = "view_id";
    public static final String TABLE_NAME = "BitableResourceData";
    private String baseToken;
    private String blockId;
    private BitableResourceDataExtra dataExtra;
    private Integer deleteStrategy;
    private String extra;
    private String objToken;
    private String resKey;
    private String resValue;
    private Integer rev1;
    private Integer rev2;
    private Long timestamp;
    private String viewId;

    public String toString() {
        return "BitableResourceData{, blockId='" + this.blockId + "', viewId='" + this.viewId + "', resKey='" + b.k(this.resKey) + "', resValue length='" + this.resValue.length() + "', rev1=" + this.rev1 + ", rev2=" + this.rev2 + ", extra=" + this.extra + ", timestamp=" + this.timestamp + ", deleteStrategy=" + this.deleteStrategy + '}';
    }

    public BitableResourceData() {
        this.baseToken = "";
        this.blockId = "";
        this.resKey = "";
        this.objToken = "";
        this.viewId = "";
        this.resValue = "";
        this.rev1 = 0;
        this.rev2 = 0;
        this.extra = "";
        this.timestamp = 0L;
        this.deleteStrategy = 0;
    }

    public String getBaseToken() {
        return this.baseToken;
    }

    public String getBlockId() {
        return this.blockId;
    }

    public Integer getDeleteStrategy() {
        return this.deleteStrategy;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getObjToken() {
        return this.objToken;
    }

    public String getResKey() {
        return this.resKey;
    }

    public String getResValue() {
        return this.resValue;
    }

    public Integer getRev1() {
        return this.rev1;
    }

    public Integer getRev2() {
        return this.rev2;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public String getViewId() {
        return this.viewId;
    }

    public BitableResourceData(BitableResourceData r100) {
        this.baseToken = "";
        this.blockId = "";
        this.resKey = "";
        this.objToken = "";
        this.viewId = "";
        this.resValue = "";
        this.rev1 = 0;
        this.rev2 = 0;
        this.extra = "";
        this.timestamp = 0L;
        this.deleteStrategy = 0;
        this.baseToken = r100.baseToken;
        this.blockId = r100.blockId;
        this.resKey = r100.resKey;
        this.objToken = r100.objToken;
        this.resValue = r100.resValue;
        this.rev1 = r100.rev1;
        this.rev2 = r100.rev2;
        this.timestamp = r100.timestamp;
        this.viewId = r100.viewId;
        this.deleteStrategy = r100.deleteStrategy;
    }

    public <T extends BitableResourceDataExtra> T getExtraData(Class<T> r100) {
        BitableResourceDataExtra r101 = this.dataExtra;     // Catch: Exception -> L13
        if (r101 == null) goto L9;
        if (r100.isInstance(r101) == false) goto L9;
        return r100.cast(this.dataExtra);
    L9:
        if (this.dataExtra != null) goto L12;
        this.dataExtra = (BitableResourceDataExtra) new Gson().fromJson(getExtra(), r100);     // Catch: Exception -> L13
    L12:
        return r100.cast(this.dataExtra);
    L13:
        e = move-exception;
        a.e(TABLE_NAME, "BitableResourceData getExtraData failed", e, false);
        return null;
    }

    public void setBaseToken(String r100) {
        this.baseToken = r100;
    }

    public void setBlockId(String r100) {
        this.blockId = r100;
    }

    public void setDeleteStrategy(Integer r100) {
        this.deleteStrategy = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setObjToken(String r100) {
        this.objToken = r100;
    }

    public void setResKey(String r100) {
        this.resKey = r100;
    }

    public void setResValue(String r100) {
        this.resValue = r100;
    }

    public void setRev1(Integer r100) {
        this.rev1 = r100;
    }

    public void setRev2(Integer r100) {
        this.rev2 = r100;
    }

    public void setTimestamp(Long r100) {
        this.timestamp = r100;
    }

    public void setViewId(String r100) {
        this.viewId = r100;
    }
}
