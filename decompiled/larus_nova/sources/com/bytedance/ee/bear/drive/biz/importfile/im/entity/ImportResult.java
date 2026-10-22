package com.bytedance.ee.bear.drive.biz.importfile.im.entity;

import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class ImportResult implements Serializable, NonProguard {
    public static final int STATUS_SHEET_CELL_CONTENT_TOO_LONG = 2005;
    public static final int STATUS_SHEET_IMPORT_EXCEED_IMAGE_LIMIT = 2002;
    public static final int STATUS_SHEET_IMPORT_IMAGE_UPLOAD_ERROR = 2004;
    public static final int STATUS_SHEET_STORAGE_USAGE_LIMITATION_BODY_UPLOAD = 2003;
    public static final int STATUS_SHEET_UPLOAD_WARNING_CELL_CUT = 2001;
    public static final int STATUS_SHEET_UPLOAD_WARNING_COLUMN_CUT = 2000;
    private Detail result;

    public static class Detail implements Serializable {
        private HashMap<String, String> extra;
        private String job_error_msg;
        private int job_status;
        private String token;
        private String type;
        private String url;

        public int getExtraCode() {
            HashMap<String, String> r100 = this.extra;     // Catch: Throwable -> L12
            if (r100 != null) goto L6;
            return -1;
        L6:
            if (r100.isEmpty() == true) goto L18;
            Iterator<Map.Entry<String, String>> r101 = this.extra.entrySet().iterator();     // Catch: Throwable -> L12
            if (r101.hasNext() == false) goto L14;
            return CastIntegerProtector.parseInt(r101.next().getKey());
        L14:
            return -1;
        L18:
            return -1;
        L12:
            th = move-exception;
            tt5.a.f("", th, false);
            goto L14
        }

        public Detail() {
            this.job_status = -1;
        }

        public HashMap<String, String> getExtra() {
            return this.extra;
        }

        public String getJob_error_msg() {
            return this.job_error_msg;
        }

        public int getJob_status() {
            return this.job_status;
        }

        public String getToken() {
            return this.token;
        }

        public String getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public void setExtra(HashMap<String, String> r100) {
            this.extra = r100;
        }

        public void setJob_error_msg(String r100) {
            this.job_error_msg = r100;
        }

        public void setJob_status(int r100) {
            this.job_status = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }

        public void setType(String r100) {
            this.type = r100;
        }

        public void setUrl(String r100) {
            this.url = r100;
        }
    }

    public ImportResult() {
    }

    public Detail getResult() {
        return this.result;
    }

    public void setResult(Detail r100) {
        this.result = r100;
    }
}
