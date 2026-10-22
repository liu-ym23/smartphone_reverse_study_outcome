package com.bytedance.ee.bear.bitable.preload.bean;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/bitable/preload/bean/BitableOfflineTransferModel;", "Ljava/io/Serializable;", "<init>", "()V", "bitableToken", "", "getBitableToken", "()Ljava/lang/String;", "setBitableToken", "(Ljava/lang/String;)V", "resKey", "getResKey", "setResKey", WikiFolderPushPlugin.BLOCK_ID, "getBlockId", "setBlockId", "objToken", "getObjToken", "setObjToken", "viewId", "getViewId", "setViewId", "resValue", "getResValue", "setResValue", "version1", "", "getVersion1", "()Ljava/lang/Integer;", "setVersion1", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "version2", "getVersion2", "setVersion2", "extra", "getExtra", "setExtra", "timestamp", "", "getTimestamp", "()Ljava/lang/Long;", "setTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "parseResourceData", "Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableResourceData;", "isFromRn", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableOfflineTransferModel implements Serializable {
    private String bitableToken;
    private String blockId;
    private String extra;
    private String objToken;
    private String resKey;
    private String resValue;
    private Long timestamp;
    private Integer version1;
    private Integer version2;
    private String viewId;

    public BitableOfflineTransferModel() {
    }

    public final String getBitableToken() {
        return this.bitableToken;
    }

    public final String getBlockId() {
        return this.blockId;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final String getResKey() {
        return this.resKey;
    }

    public final String getResValue() {
        return this.resValue;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final Integer getVersion1() {
        return this.version1;
    }

    public final Integer getVersion2() {
        return this.version2;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final BitableResourceData parseResourceData(boolean r100) {
        BitableResourceData r101 = new BitableResourceData();
        String r102 = this.bitableToken;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.setBaseToken(r102);
        String r104 = this.blockId;
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r101.setBlockId(r104);
        String r105 = this.objToken;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r101.setObjToken(r105);
        String r106 = this.viewId;
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        r101.setViewId(r106);
        String r107 = this.resKey;
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        r101.setResKey(r107);
        String r108 = this.resValue;
        if (r108 != null) goto L20;
        r108 = "";
    L20:
        r101.setResValue(r108);
        int r109 = this.version1;
        if (r109 != null) goto L23;
        r109 = 0;
    L23:
        r101.setRev1(r109);
        int r110 = this.version2;
        if (r110 != null) goto L26;
        r110 = 0;
    L26:
        r101.setRev2(r110);
        String r111 = this.extra;
        if (r111 == null) goto L30;
        r103 = r111;
    L30:
        r101.setExtra(r103);
        Long r112 = this.timestamp;
        if (r112 != null) goto L33;
        r112 = Long.valueOf(System.currentTimeMillis());
    L33:
        r101.setTimestamp(r112);
        if (r100 == false) goto L36;
        int r113 = 0;
    L37:
        r101.setDeleteStrategy(r113);
        return r101;
    L36:
        r113 = 1;
        goto L37
    }

    public final void setBitableToken(String r100) {
        this.bitableToken = r100;
    }

    public final void setBlockId(String r100) {
        this.blockId = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public final void setObjToken(String r100) {
        this.objToken = r100;
    }

    public final void setResKey(String r100) {
        this.resKey = r100;
    }

    public final void setResValue(String r100) {
        this.resValue = r100;
    }

    public final void setTimestamp(Long r100) {
        this.timestamp = r100;
    }

    public final void setVersion1(Integer r100) {
        this.version1 = r100;
    }

    public final void setVersion2(Integer r100) {
        this.version2 = r100;
    }

    public final void setViewId(String r100) {
        this.viewId = r100;
    }
}
