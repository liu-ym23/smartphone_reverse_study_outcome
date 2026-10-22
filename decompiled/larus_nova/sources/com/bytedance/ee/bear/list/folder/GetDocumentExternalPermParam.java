package com.bytedance.ee.bear.list.folder;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setType(int r100) {
            this.type = r100;
        }
    }

    public GetDocumentExternalPermParam() {
    }

    public List<ObjsBean> getObjs() {
        return this.objs;
    }

    public void setObjs(List<ObjsBean> r100) {
        this.objs = r100;
    }
}
