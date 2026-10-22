package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SubBlockModel implements Serializable {
    private List<String> dataToken;
    private String objToken;
    private String ownerResKey;
    private SubBlockType subBlockType;
    private int type;
    private String url;

    public int hashCode() {
        return Objects.hash(new Object[]{this.objToken, this.dataToken, Integer.valueOf(this.type), this.subBlockType, this.url});
    }

    public String toString() {
        return "SubBlockModel{, type=" + this.type + ", subBlockType=" + this.subBlockType + '}';
    }

    public SubBlockModel() {
        this.type = e.g.b;
        this.subBlockType = SubBlockType.COMMENTS_DATA;
    }

    public List<String> getDataToken() {
        return this.dataToken;
    }

    public String getObjToken() {
        return this.objToken;
    }

    public String getOwnerResKey() {
        return this.ownerResKey;
    }

    public SubBlockType getSubBlockType() {
        return this.subBlockType;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public SubBlockModel(String r2) {
        this.type = e.g.b;
        this.subBlockType = SubBlockType.COMMENTS_DATA;
        this.url = r2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L36:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L36;
        SubBlockModel r6 = (SubBlockModel) r5;
        if (TextUtils.equals(this.objToken, r6.objToken) == false) goto L36;
        SubBlockType r2 = this.subBlockType;
        if (r2 != r6.subBlockType) goto L36;
        if (r2 != SubBlockType.COMMENTS_DATA) goto L18;
        return true;
    L18:
        if (r2 != SubBlockType.POLL_DATA) goto L28;
        List<String> r3 = this.dataToken;
        if (r3 == null) goto L26;
        List<String> r7 = r6.dataToken;
        if (r7 == null) goto L26;
        if (r3.equals(r7) == false) goto L26;
        return true;
    L26:
        return false;
    L28:
        if (r2 != SubBlockType.IMAGE_DATA) goto L36;
        String r4 = this.url;
        if (r4 == null) goto L36;
        String r8 = r6.url;
        if (r8 == null) goto L36;
        if (r4.equals(r8) == false) goto L36;
        return true;
    }

    public void setDataToken(List<String> r1) {
        this.dataToken = r1;
    }

    public void setObjToken(String r1) {
        this.objToken = r1;
    }

    public void setOwnerResKey(String r1) {
        this.ownerResKey = r1;
    }

    public void setSubBlockType(SubBlockType r1) {
        this.subBlockType = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public SubBlockModel(String r2, int r3, SubBlockType r4) {
        this.type = e.g.b;
        SubBlockType r0 = SubBlockType.COMMENTS_DATA;
        this.objToken = r2;
        this.type = r3;
        this.subBlockType = r4;
    }

    public SubBlockModel(String r2, int r3, SubBlockType r4, String r5) {
        this.type = e.g.b;
        SubBlockType r0 = SubBlockType.COMMENTS_DATA;
        this.objToken = r2;
        this.url = r5;
        this.type = r3;
        this.subBlockType = r4;
    }

    public SubBlockModel(String r2, int r3, SubBlockType r4, List<String> r5) {
        this.type = e.g.b;
        SubBlockType r0 = SubBlockType.COMMENTS_DATA;
        this.objToken = r2;
        this.dataToken = r5;
        this.type = r3;
        this.subBlockType = r4;
    }
}
