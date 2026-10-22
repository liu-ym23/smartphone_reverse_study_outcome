package com.bytedance.ee.bear.document.domaincharacteristicconfig;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setDocsApiPrefix(String r1) {
        this.docsApiPrefix = r1;
    }

    public void setFrontierDomain(String[] r1) {
        this.frontierDomain = r1;
    }

    public void setSrcHost(String r1) {
        this.srcHost = r1;
    }

    public void setSrcUrl(String r1) {
        this.srcUrl = r1;
    }

    public void setUnit(String r1) {
        this.unit = r1;
    }
}
