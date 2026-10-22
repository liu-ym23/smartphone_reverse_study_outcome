package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.infocheck;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentVersionInfo implements NonProguard {
    private int code;
    private Data data;
    private String msg;

    public static class Data implements NonProguard {
        private List<ObjVersion> obj_version;

        public static class ObjVersion implements NonProguard {
            private String token;
            private int version;

            public ObjVersion() {
            }

            public String getToken() {
                return this.token;
            }

            public int getVersion() {
                return this.version;
            }

            public void setToken(String r1) {
                this.token = r1;
            }

            public void setVersion(int r1) {
                this.version = r1;
            }
        }

        public Data() {
        }

        public List<ObjVersion> getObj_version() {
            return this.obj_version;
        }

        public void setObj_version(List<ObjVersion> r1) {
            this.obj_version = r1;
        }
    }

    public DocumentVersionInfo() {
    }

    public int getCode() {
        return this.code;
    }

    public Data getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setData(Data r1) {
        this.data = r1;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }
}
