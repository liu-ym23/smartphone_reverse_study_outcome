package com.bytedance.ee.bear.document.offline.sync.preloadexecutor.infocheck;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
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

            public void setToken(String r100) {
                this.token = r100;
            }

            public void setVersion(int r100) {
                this.version = r100;
            }
        }

        public Data() {
        }

        public List<ObjVersion> getObj_version() {
            return this.obj_version;
        }

        public void setObj_version(List<ObjVersion> r100) {
            this.obj_version = r100;
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

    public void setCode(int r100) {
        this.code = r100;
    }

    public void setData(Data r100) {
        this.data = r100;
    }

    public void setMsg(String r100) {
        this.msg = r100;
    }
}
