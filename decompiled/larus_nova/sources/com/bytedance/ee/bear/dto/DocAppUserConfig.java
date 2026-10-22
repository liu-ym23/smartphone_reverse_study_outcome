package com.bytedance.ee.bear.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setDocDomains(List<String> r100) {
        this.docDomains = r100;
    }

    public void setUrlRegex(Map<Integer, String> r100) {
        this.urlRegex = r100;
    }

    public DocAppUserConfig(List<String> r100, Map<Integer, String> r101) {
        this.docDomains = new ArrayList();
        new HashMap();
        this.docDomains = r100;
        this.urlRegex = r101;
    }
}
