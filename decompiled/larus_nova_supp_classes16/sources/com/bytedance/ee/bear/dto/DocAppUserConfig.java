package com.bytedance.ee.bear.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocAppUserConfig implements Serializable {
    private List<String> docDomains;
    private Map<Integer, String> urlRegex;

    public DocAppUserConfig() {
        this.docDomains = new ArrayList();
        this.urlRegex = new HashMap();
    }

    public List<String> getDocDomains() {
        return this.docDomains;
    }

    public Map<Integer, String> getUrlRegex() {
        return this.urlRegex;
    }

    public void setDocDomains(List<String> r1) {
        this.docDomains = r1;
    }

    public void setUrlRegex(Map<Integer, String> r1) {
        this.urlRegex = r1;
    }

    public DocAppUserConfig(List<String> r2, Map<Integer, String> r3) {
        this.docDomains = new ArrayList();
        new HashMap();
        this.docDomains = r2;
        this.urlRegex = r3;
    }
}
