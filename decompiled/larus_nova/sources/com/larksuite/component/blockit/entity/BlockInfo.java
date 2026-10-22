package com.larksuite.component.blockit.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class BlockInfo implements Serializable {
    public String blockID;
    public String blockTypeID;
    public String i18nPreview;
    public String i18nSummary;
    public String sourceData;
    public String sourceLink;
    public String sourceMeta;

    public BlockInfo(BlockEntity r100) {
        this.blockID = r100.getBlockID();
        this.blockTypeID = r100.getBlockTypeID();
        this.sourceLink = r100.getSourceLink();
        this.sourceMeta = r100.getSourceMeta();
        this.sourceData = r100.getSourceData();
        this.i18nPreview = r100.getPreview();
        this.i18nSummary = r100.getSummary();
    }
}
