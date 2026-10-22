package com.bytedance.ee.bear.sheet.borderline;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorData;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class BorderLineData implements NonProguard {
    private static final String TAG = "BorderLineData";
    private BorderLineParam borderLineParam;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f237363id;
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

        public void setBorder(String[] r100) {
            this.border = r100;
        }

        public void setColor(SheetSelectColorData.ColorScheme[] r100) {
            this.color = r100;
        }

        public void setDefaultValue(DefaultValue r100) {
            this.defaultValue = r100;
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

        public void setBorder(String r100) {
            this.border = r100;
        }

        public void setColor(String r100) {
            this.color = r100;
        }

        public DefaultValue(String r100, String r101) {
            this.border = r100;
            this.color = r101;
        }
    }

    public BorderLineParam getBorderLineParam() {
        return this.borderLineParam;
    }

    public String getId() {
        return this.f237363id;
    }

    public String getTitle() {
        return this.title;
    }

    public BorderLineParam parseBorderLineParam(String r100) {
        return (BorderLineParam) JSON.parseObject(r100, BorderLineParam.class);
    L4:
        th = move-exception;
        tt5.a.d(TAG, "parse BorderLineData error : " + th);
        return new BorderLineParam();
    }

    public void setBorderLineParam(BorderLineParam r100) {
        this.borderLineParam = r100;
    }

    public void setId(String r100) {
        this.f237363id = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public BorderLineData(String r100, String r101, String r102) {
        this.f237363id = r100;
        this.title = r101;
        this.borderLineParam = parseBorderLineParam(r102);
    }

    public BorderLineData(String r100, String r101, BorderLineParam r102) {
        this.f237363id = r100;
        this.title = r101;
        this.borderLineParam = r102;
    }
}
