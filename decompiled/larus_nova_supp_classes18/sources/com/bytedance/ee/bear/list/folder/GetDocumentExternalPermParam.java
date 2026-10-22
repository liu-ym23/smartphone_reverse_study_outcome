package com.bytedance.ee.bear.list.folder;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GetDocumentExternalPermParam implements Serializable {
    private List<ObjsBean> objs;

    public static class ObjsBean implements Serializable {
        private String token;
        private int type;

        public ObjsBean() {
        }

        public String getToken() {
            return this.token;
        }

        public int getType() {
            return this.type;
        }

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setType(int r1) {
            this.type = r1;
        }
    }

    public GetDocumentExternalPermParam() {
    }

    public List<ObjsBean> getObjs() {
        return this.objs;
    }

    public void setObjs(List<ObjsBean> r1) {
        this.objs = r1;
    }
}
