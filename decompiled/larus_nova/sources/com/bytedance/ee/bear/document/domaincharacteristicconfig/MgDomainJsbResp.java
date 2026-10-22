package com.bytedance.ee.bear.document.domaincharacteristicconfig;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: classes16.dex */
public class MgDomainJsbResp implements NonProguard {
    private String docsApiPrefix;
    private String[] frontierDomain;
    private String srcHost;
    private String srcUrl;
    private String unit;

    public String toString() {
        return "MgDomainJsbResp{unit='" + this.unit + "', docsApiPrefix='" + this.docsApiPrefix + "', frontierDomain=" + Arrays.toString(this.frontierDomain) + '}';
    }

    public MgDomainJsbResp() {
        this.unit = "";
        this.docsApiPrefix = "";
        this.srcHost = "";
        this.srcUrl = "";
    }

    public String getDocsApiPrefix() {
        return this.docsApiPrefix;
    }

    public String[] getFrontierDomain() {
        return this.frontierDomain;
    }

    public String getSrcHost() {
        return this.srcHost;
    }

    public String getSrcUrl() {
        return this.srcUrl;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setDocsApiPrefix(String r100) {
        this.docsApiPrefix = r100;
    }

    public void setFrontierDomain(String[] r100) {
        this.frontierDomain = r100;
    }

    public void setSrcHost(String r100) {
        this.srcHost = r100;
    }

    public void setSrcUrl(String r100) {
        this.srcUrl = r100;
    }

    public void setUnit(String r100) {
        this.unit = r100;
    }
}
