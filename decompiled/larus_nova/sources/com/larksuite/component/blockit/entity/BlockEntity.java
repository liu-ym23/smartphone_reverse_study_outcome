package com.larksuite.component.blockit.entity;

import com.larksuite.component.openplatform.api.entity.BaseBlockInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public class BlockEntity extends BaseBlockInfo {
    private String appID;
    private String appIDStr;
    private String blockID;
    private String blockTypeID;
    private Map<String, String> i18nPreview;
    private Map<String, String> i18nSummary;
    private String preview;
    private String sourceData;
    private String sourceLink;
    private String sourceMeta;
    private String summary;

    public String toString() {
        return "BlockEntity{blockID='" + this.blockID + "', blockTypeID='" + this.blockTypeID + "', sourceLink='" + this.sourceLink + "', sourceData='" + this.sourceData + "', sourceMeta='" + this.sourceMeta + "', preview='" + this.preview + "', summary='" + this.summary + "', i18nPreview=" + this.i18nPreview + ", i18nSummary=" + this.i18nSummary + ", appID=" + this.appID + '}';
    }

    private BlockEntity() {
    }

    public String getAppID() {
        return this.appID;
    }

    public String getAppIDStr() {
        return this.appIDStr;
    }

    public String getBlockID() {
        return this.blockID;
    }

    public String getBlockTypeID() {
        return this.blockTypeID;
    }

    public Map<String, String> getI18nPreview() {
        return this.i18nPreview;
    }

    public Map<String, String> getI18nSummary() {
        return this.i18nSummary;
    }

    public String getPreview() {
        return this.preview;
    }

    public String getSourceData() {
        return this.sourceData;
    }

    public String getSourceLink() {
        return this.sourceLink;
    }

    public String getSourceMeta() {
        return this.sourceMeta;
    }

    public String getSummary() {
        return this.summary;
    }

    public BlockEntity(String r100) {
        this.blockID = r100;
    }

    public void setAppID(String r100) {
        this.appID = r100;
    }

    public void setAppIDStr(String r100) {
        this.appIDStr = r100;
    }

    public void setBlockID(String r100) {
        this.blockID = r100;
    }

    public void setBlockTypeID(String r100) {
        this.blockTypeID = r100;
    }

    public void setI18nPreview(Map<String, String> r100) {
        this.i18nPreview = r100;
    }

    public void setI18nSummary(Map<String, String> r100) {
        this.i18nSummary = r100;
    }

    public void setPreview(String r100) {
        this.preview = r100;
    }

    public void setSourceData(String r100) {
        this.sourceData = r100;
    }

    public void setSourceLink(String r100) {
        this.sourceLink = r100;
    }

    public void setSourceMeta(String r100) {
        this.sourceMeta = r100;
    }

    public void setSummary(String r100) {
        this.summary = r100;
    }
}
