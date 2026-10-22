package com.bytedance.ee.bear.sheet.borderline;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorData;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BorderLineData implements NonProguard {
    private static final String TAG = "BorderLineData";
    private BorderLineParam borderLineParam;
    private String id;
    private String title;

    public static class BorderLineParam implements NonProguard {
        private String[] border;
        private SheetSelectColorData.ColorScheme[] color;
        private DefaultValue defaultValue;

        public BorderLineParam() {
        }

        public String[] getBorder() {
            return this.border;
        }

        public SheetSelectColorData.ColorScheme[] getColor() {
            return this.color;
        }

        public DefaultValue getDefaultValue() {
            return this.defaultValue;
        }

        public void setBorder(String[] r1) {
            this.border = r1;
        }

        public void setColor(SheetSelectColorData.ColorScheme[] r1) {
            this.color = r1;
        }

        public void setDefaultValue(DefaultValue r1) {
            this.defaultValue = r1;
        }
    }

    public static class DefaultValue implements NonProguard {
        private String border;
        private String color;

        public DefaultValue() {
        }

        public String getBorder() {
            return this.border;
        }

        public String getColor() {
            return this.color;
        }

        public void setBorder(String r1) {
            this.border = r1;
        }

        public void setColor(String r1) {
            this.color = r1;
        }

        public DefaultValue(String r1, String r2) {
            this.border = r1;
            this.color = r2;
        }
    }

    public BorderLineParam getBorderLineParam() {
        return this.borderLineParam;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public BorderLineParam parseBorderLineParam(String r3) {
        return (BorderLineParam) JSON.parseObject(r3, BorderLineParam.class);
    L4:
        th = move-exception;
        tt5.a.d(TAG, "parse BorderLineData error : " + th);
        return new BorderLineParam();
    }

    public void setBorderLineParam(BorderLineParam r1) {
        this.borderLineParam = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public BorderLineData(String r1, String r2, String r3) {
        this.id = r1;
        this.title = r2;
        this.borderLineParam = parseBorderLineParam(r3);
    }

    public BorderLineData(String r1, String r2, BorderLineParam r3) {
        this.id = r1;
        this.title = r2;
        this.borderLineParam = r3;
    }
}
