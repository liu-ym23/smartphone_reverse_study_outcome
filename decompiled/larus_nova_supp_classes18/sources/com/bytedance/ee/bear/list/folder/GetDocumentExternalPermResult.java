package com.bytedance.ee.bear.list.folder;

import com.bytedance.ee.bear.contract.Result;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GetDocumentExternalPermResult extends Result {
    private HashMap<String, Boolean> permMap;

    public GetDocumentExternalPermResult() {
    }

    public HashMap<String, Boolean> getPermMap() {
        return this.permMap;
    }

    public void setPermMap(HashMap<String, Boolean> r1) {
        this.permMap = r1;
    }
}
