package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
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
        this.type = e.f541296g.f541317b;
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

    public SubBlockModel(String r100) {
        this.type = e.f541296g.f541317b;
        this.subBlockType = SubBlockType.COMMENTS_DATA;
        this.url = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L36:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L36;
        SubBlockModel r101 = (SubBlockModel) r100;
        if (TextUtils.equals(this.objToken, r101.objToken) == false) goto L36;
        SubBlockType r102 = this.subBlockType;
        if (r102 != r101.subBlockType) goto L36;
        if (r102 != SubBlockType.COMMENTS_DATA) goto L18;
        return true;
    L18:
        if (r102 != SubBlockType.POLL_DATA) goto L28;
        List<String> r103 = this.dataToken;
        if (r103 == null) goto L26;
        List<String> r104 = r101.dataToken;
        if (r104 == null) goto L26;
        if (r103.equals(r104) == false) goto L26;
        return true;
    L26:
        return false;
    L28:
        if (r102 != SubBlockType.IMAGE_DATA) goto L36;
        String r105 = this.url;
        if (r105 == null) goto L36;
        String r106 = r101.url;
        if (r106 == null) goto L36;
        if (r105.equals(r106) == false) goto L36;
        return true;
    }

    public void setDataToken(List<String> r100) {
        this.dataToken = r100;
    }

    public void setObjToken(String r100) {
        this.objToken = r100;
    }

    public void setOwnerResKey(String r100) {
        this.ownerResKey = r100;
    }

    public void setSubBlockType(SubBlockType r100) {
        this.subBlockType = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public SubBlockModel(String r100, int r101, SubBlockType r102) {
        this.type = e.f541296g.f541317b;
        SubBlockType r103 = SubBlockType.COMMENTS_DATA;
        this.objToken = r100;
        this.type = r101;
        this.subBlockType = r102;
    }

    public SubBlockModel(String r100, int r101, SubBlockType r102, String r103) {
        this.type = e.f541296g.f541317b;
        SubBlockType r104 = SubBlockType.COMMENTS_DATA;
        this.objToken = r100;
        this.url = r103;
        this.type = r101;
        this.subBlockType = r102;
    }

    public SubBlockModel(String r100, int r101, SubBlockType r102, List<String> r103) {
        this.type = e.f541296g.f541317b;
        SubBlockType r104 = SubBlockType.COMMENTS_DATA;
        this.objToken = r100;
        this.dataToken = r103;
        this.type = r101;
        this.subBlockType = r102;
    }
}
