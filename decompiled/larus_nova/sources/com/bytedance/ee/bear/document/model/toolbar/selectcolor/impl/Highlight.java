package com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.amap.api.col.s.ce;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONObject;
import tt5.a;

/* JADX INFO: loaded from: classes16.dex */
public class Highlight implements NonProguard {
    private ColorItem[] background;
    private int backgroundSpanCount;
    private ColorItem clear;
    private boolean isShow;
    private ColorItem reset;
    private Selected selected;
    private ColorItem[] text;
    private int textColorSpanCount;

    public static class CallbackEntity implements NonProguard {
        private ColorItem background;
        private ColorItem clear;
        private ColorItem reset;
        private ColorItem text;

        public String toString() {
            return "CallbackEntity{background=" + this.background + ", text=" + this.text + ", clear=" + this.clear + ", reset=" + this.reset + '}';
        }

        public CallbackEntity() {
        }

        public ColorItem getBackground() {
            return this.background;
        }

        public ColorItem getClear() {
            return this.clear;
        }

        public ColorItem getReset() {
            return this.reset;
        }

        public ColorItem getText() {
            return this.text;
        }

        public void setBackground(ColorItem r100) {
            this.background = r100;
        }

        public void setClear(ColorItem r100) {
            this.clear = r100;
        }

        public void setReset(ColorItem r100) {
            this.reset = r100;
        }

        public void setText(ColorItem r100) {
            this.text = r100;
        }
    }

    public static class ColorItem implements NonProguard {
        private static final String TAG = "ColorItem";
        private String key;
        private boolean showFontIcon;
        private String type;
        private ColorRgba value;

        public String getKey() {
            String r100 = this.key;
            if (r100 != null) goto L6;
            return "";
        L6:
            return r100;
        }

        public String toShortString() {
            if (ColorRgba.access$100(this.value) != 1.0f) goto L7;
            return "rgb(" + ColorRgba.access$200(this.value) + "," + ColorRgba.access$300(this.value) + "," + ColorRgba.access$400(this.value) + ')';
        L7:
            return "rgba(" + ColorRgba.access$200(this.value) + "," + ColorRgba.access$300(this.value) + "," + ColorRgba.access$400(this.value) + "," + ColorRgba.access$100(this.value) + ')';
        }

        public String toString() {
            return "ColorItem{type='" + this.type + "', key='" + this.key + "', showFontIcon='" + this.showFontIcon + "', value='" + this.value + "'}";
        }

        public ColorItem() {
            this.showFontIcon = true;
        }

        public String getType() {
            return this.type;
        }

        public ColorRgba getValue() {
            return this.value;
        }

        public boolean isShowFontIcon() {
            return this.showFontIcon;
        }

        public ColorItem(ColorRgba r100) {
            this.showFontIcon = true;
            this.value = r100;
        }

        public static ColorItem fromJson(String r100) {
            JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L8
            String r102 = r101.optString("type", "");     // Catch: Throwable -> L8
            String r103 = r101.optString("key", "");     // Catch: Throwable -> L8
            boolean r104 = r101.optBoolean("showFontIcon", true);     // Catch: Throwable -> L8
            ColorRgba r105 = new ColorRgba();     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r101.optString("value")) == true) goto L6;
            JSONObject r106 = new JSONObject(r101.optString("value"));     // Catch: Throwable -> L8
            r105.setR(r106.optInt("r"));     // Catch: Throwable -> L8
            r105.setG(r106.optInt(ce.f26391f));     // Catch: Throwable -> L8
            r105.setB(r106.optInt("b"));     // Catch: Throwable -> L8
            r105.setA((float) r106.optDouble(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY));     // Catch: Throwable -> L8
        L6:
            ColorItem r107 = new ColorItem(r102, r103, r104, r105);     // Catch: Throwable -> L8
        L10:
            if (r107 == null) goto L12;
            return r107;
        L12:
            return new ColorItem("background", "", true, new ColorRgba());
        L8:
            th = move-exception;
            a.f(TAG, th, false);
            r107 = null;
            goto L10
        }

        public static String toJson(ColorItem r100) {
            String r101 = JSON.toJSONString(r100);     // Catch: Throwable -> L4
        L6:
            if (r101 != null) goto L11;
            return "";
        L11:
            return r101;
        L4:
            th = move-exception;
            a.f(TAG, th, false);
            r101 = null;
            goto L6
        }

        public void setKey(String r100) {
            this.key = r100;
        }

        public void setShowFontIcon(boolean r100) {
            this.showFontIcon = r100;
        }

        public void setType(String r100) {
            this.type = r100;
        }

        public void setValue(ColorRgba r100) {
            this.value = r100;
        }

        public static /* synthetic */ String access$002(ColorItem r100, String r101) {
            r100.type = r101;
            return r101;
        }

        public ColorItem(String r100, String r101, boolean r102, ColorRgba r103) {
            this.type = r100;
            this.key = r101;
            this.showFontIcon = r102;
            this.value = r103;
        }
    }

    public static class ColorRgba implements NonProguard {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f220278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f220279b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f220280g;
        private String key;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f220281r;

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f220281r), Integer.valueOf(this.f220280g), Integer.valueOf(this.f220279b), Float.valueOf(this.f220278a)});
        }

        public String toShortString() {
            if (this.f220278a != 1.0f) goto L6;
            return "rgb()";
        L6:
            return "rgba()";
        }

        public String toString() {
            return "ColorRgba{r=" + this.f220281r + ", g=" + this.f220280g + ", b=" + this.f220279b + ", a=" + this.f220278a + ", key=" + this.key + '}';
        }

        public ColorRgba() {
        }

        public float getA() {
            return this.f220278a;
        }

        public int getB() {
            return this.f220279b;
        }

        public int getG() {
            return this.f220280g;
        }

        public String getKey() {
            return this.key;
        }

        public int getR() {
            return this.f220281r;
        }

        public static /* synthetic */ float access$100(ColorRgba r100) {
            return r100.f220278a;
        }

        public static /* synthetic */ int access$200(ColorRgba r100) {
            return r100.f220281r;
        }

        public static /* synthetic */ int access$300(ColorRgba r100) {
            return r100.f220280g;
        }

        public static /* synthetic */ int access$400(ColorRgba r100) {
            return r100.f220279b;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L23:
            return false;
        L8:
            if (getClass() != r100.getClass()) goto L23;
            ColorRgba r101 = (ColorRgba) r100;
            if (this.f220281r == r101.f220281r) goto L13;
        L21:
            return false;
        L13:
            if (this.f220280g != r101.f220280g) goto L21;
            if (this.f220279b != r101.f220279b) goto L21;
            if (this.key.equals(r101.key) == false) goto L21;
            if (Float.compare(r101.f220278a, this.f220278a) != 0) goto L21;
            return true;
        }

        public void setA(float r100) {
            this.f220278a = r100;
        }

        public void setB(int r100) {
            this.f220279b = r100;
        }

        public void setG(int r100) {
            this.f220280g = r100;
        }

        public void setKey(String r100) {
            this.key = r100;
        }

        public void setR(int r100) {
            this.f220281r = r100;
        }

        public ColorRgba(int r100, int r101, int r102, float r103) {
            this.f220281r = r100;
            this.f220280g = r101;
            this.f220279b = r102;
            this.f220278a = r103;
        }

        public ColorRgba(int r100, int r101, int r102, float r103, String r104) {
            this(r100, r101, r102, r103);
            this.key = r104;
        }
    }

    public static class Selected implements NonProguard {
        private ColorItem background;
        private ColorItem text;

        public String toString() {
            return "Selected{background=" + this.background + ", text=" + this.text + '}';
        }

        public Selected() {
        }

        public ColorItem getBackground() {
            return this.background;
        }

        public ColorItem getText() {
            return this.text;
        }

        public static Selected fromJson(String r100) {
            Selected r101 = new Selected();
            return (Selected) JSON.parseObject(r100, Selected.class);
        L5:
            e = move-exception;
            a.f("Selected", e, false);
            return r101;
        }

        public void setBackground(ColorItem r100) {
            this.background = r100;
        }

        public void setText(ColorItem r100) {
            this.text = r100;
        }
    }

    public Highlight() {
    }

    private void setBackgroundItemType() {
        ColorItem[] r100 = this.background;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length == 0) goto L12;
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        ColorItem.access$002(r100[r102], "background");
        r102 = r102 + 1;
        goto L8
    L13:
        return;
    }

    private void setClearItemType() {
        ColorItem r100 = this.clear;
        if (r100 != null) goto L5;
        return;
    L5:
        ColorItem.access$002(r100, "clear");
    }

    private void setTextItemType() {
        ColorItem[] r100 = this.text;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length == 0) goto L12;
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L13;
        ColorItem.access$002(r100[r102], "text");
        r102 = r102 + 1;
        goto L8
    L13:
        return;
    }

    public String toString() {
        return "Highlight{text=" + Arrays.toString(this.text) + ", background=" + Arrays.toString(this.background) + ", selected=" + this.selected + ", clear=" + this.clear + ", reset=" + this.reset + ", isShow=" + this.isShow + '}';
    }

    public void ensureItemType() {
        setTextItemType();
        setBackgroundItemType();
        setClearItemType();
    }

    public ColorItem[] getBackground() {
        return this.background;
    }

    public int getBackgroundSpanCount() {
        return this.backgroundSpanCount;
    }

    public ColorItem getClear() {
        return this.clear;
    }

    public ColorItem getReset() {
        return this.reset;
    }

    public Selected getSelected() {
        return this.selected;
    }

    public ColorItem[] getText() {
        return this.text;
    }

    public int getTextColorSpanCount() {
        return this.textColorSpanCount;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public void setBackground(ColorItem[] r100) {
        this.background = r100;
    }

    public void setBackgroundSpanCount(int r100) {
        this.backgroundSpanCount = r100;
    }

    public void setClear(ColorItem r100) {
        this.clear = r100;
    }

    public void setReset(ColorItem r100) {
        this.reset = r100;
    }

    public void setSelected(Selected r100) {
        this.selected = r100;
    }

    public void setShow(boolean r100) {
        this.isShow = r100;
    }

    public void setText(ColorItem[] r100) {
        this.text = r100;
    }

    public void setTextColorSpanCount(int r100) {
        this.textColorSpanCount = r100;
    }
}
