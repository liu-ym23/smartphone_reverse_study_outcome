package com.bytedance.ee.bear.document.model.toolbar.selectcolor.impl;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONObject;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public void setBackground(ColorItem r1) {
            this.background = r1;
        }

        public void setClear(ColorItem r1) {
            this.clear = r1;
        }

        public void setReset(ColorItem r1) {
            this.reset = r1;
        }

        public void setText(ColorItem r1) {
            this.text = r1;
        }
    }

    public static class ColorItem implements NonProguard {
        private static final String TAG = "ColorItem";
        private String key;
        private boolean showFontIcon;
        private String type;
        private ColorRgba value;

        public String getKey() {
            String r0 = this.key;
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
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

        public ColorItem(ColorRgba r2) {
            this.showFontIcon = true;
            this.value = r2;
        }

        public static ColorItem fromJson(String r9) {
            JSONObject r3 = new JSONObject(r9);     // Catch: Throwable -> L8
            String r10 = r3.optString("type", "");     // Catch: Throwable -> L8
            String r4 = r3.optString("key", "");     // Catch: Throwable -> L8
            boolean r5 = r3.optBoolean("showFontIcon", true);     // Catch: Throwable -> L8
            ColorRgba r6 = new ColorRgba();     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r3.optString("value")) == true) goto L6;
            JSONObject r7 = new JSONObject(r3.optString("value"));     // Catch: Throwable -> L8
            r6.setR(r7.optInt("r"));     // Catch: Throwable -> L8
            r6.setG(r7.optInt("g"));     // Catch: Throwable -> L8
            r6.setB(r7.optInt("b"));     // Catch: Throwable -> L8
            r6.setA((float) r7.optDouble("a"));     // Catch: Throwable -> L8
        L6:
            ColorItem r0 = new ColorItem(r10, r4, r5, r6);     // Catch: Throwable -> L8
        L10:
            if (r0 == null) goto L12;
            return r0;
        L12:
            return new ColorItem(RectColorView.RectColorType.TYPE_BACKGROUND, "", true, new ColorRgba());
        L8:
            th = move-exception;
            a.f(TAG, th, false);
            r0 = null;
            goto L10
        }

        public static String toJson(ColorItem r2) {
            String r3 = JSON.toJSONString(r2);     // Catch: Throwable -> L4
        L6:
            if (r3 != null) goto L11;
            return "";
        L11:
            return r3;
        L4:
            th = move-exception;
            a.f(TAG, th, false);
            r3 = null;
            goto L6
        }

        public void setKey(String r1) {
            this.key = r1;
        }

        public void setShowFontIcon(boolean r1) {
            this.showFontIcon = r1;
        }

        public void setType(String r1) {
            this.type = r1;
        }

        public void setValue(ColorRgba r1) {
            this.value = r1;
        }

        public static /* synthetic */ String access$002(ColorItem r0, String r1) {
            r0.type = r1;
            return r1;
        }

        public ColorItem(String r1, String r2, boolean r3, ColorRgba r4) {
            this.type = r1;
            this.key = r2;
            this.showFontIcon = r3;
            this.value = r4;
        }
    }

    public static class ColorRgba implements NonProguard {
        private float a;
        private int b;
        private int g;
        private String key;
        private int r;

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.r), Integer.valueOf(this.g), Integer.valueOf(this.b), Float.valueOf(this.a)});
        }

        public String toShortString() {
            if (this.a != 1.0f) goto L6;
            return "rgb()";
        L6:
            return "rgba()";
        }

        public String toString() {
            return "ColorRgba{r=" + this.r + ", g=" + this.g + ", b=" + this.b + ", a=" + this.a + ", key=" + this.key + '}';
        }

        public ColorRgba() {
        }

        public float getA() {
            return this.a;
        }

        public int getB() {
            return this.b;
        }

        public int getG() {
            return this.g;
        }

        public String getKey() {
            return this.key;
        }

        public int getR() {
            return this.r;
        }

        public static /* synthetic */ float access$100(ColorRgba r0) {
            return r0.a;
        }

        public static /* synthetic */ int access$200(ColorRgba r0) {
            return r0.r;
        }

        public static /* synthetic */ int access$300(ColorRgba r0) {
            return r0.g;
        }

        public static /* synthetic */ int access$400(ColorRgba r0) {
            return r0.b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L23:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L23;
            ColorRgba r6 = (ColorRgba) r5;
            if (this.r == r6.r) goto L13;
        L21:
            return false;
        L13:
            if (this.g != r6.g) goto L21;
            if (this.b != r6.b) goto L21;
            if (this.key.equals(r6.key) == false) goto L21;
            if (Float.compare(r6.a, this.a) != 0) goto L21;
            return true;
        }

        public void setA(float r1) {
            this.a = r1;
        }

        public void setB(int r1) {
            this.b = r1;
        }

        public void setG(int r1) {
            this.g = r1;
        }

        public void setKey(String r1) {
            this.key = r1;
        }

        public void setR(int r1) {
            this.r = r1;
        }

        public ColorRgba(int r1, int r2, int r3, float r4) {
            this.r = r1;
            this.g = r2;
            this.b = r3;
            this.a = r4;
        }

        public ColorRgba(int r1, int r2, int r3, float r4, String r5) {
            this(r1, r2, r3, r4);
            this.key = r5;
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

        public static Selected fromJson(String r3) {
            Selected r0 = new Selected();
            return (Selected) JSON.parseObject(r3, Selected.class);
        L5:
            e = move-exception;
            a.f("Selected", e, false);
            return r0;
        }

        public void setBackground(ColorItem r1) {
            this.background = r1;
        }

        public void setText(ColorItem r1) {
            this.text = r1;
        }
    }

    public Highlight() {
    }

    private void setBackgroundItemType() {
        ColorItem[] r0 = this.background;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length == 0) goto L12;
        int r1 = r0.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        ColorItem.access$002(r0[r2], RectColorView.RectColorType.TYPE_BACKGROUND);
        r2 = r2 + 1;
        goto L8
    L13:
        return;
    }

    private void setClearItemType() {
        ColorItem r0 = this.clear;
        if (r0 != null) goto L5;
        return;
    L5:
        ColorItem.access$002(r0, RectColorView.RectColorType.TYPE_CLEAR);
    }

    private void setTextItemType() {
        ColorItem[] r0 = this.text;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length == 0) goto L12;
        int r1 = r0.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        ColorItem.access$002(r0[r2], "text");
        r2 = r2 + 1;
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

    public void setBackground(ColorItem[] r1) {
        this.background = r1;
    }

    public void setBackgroundSpanCount(int r1) {
        this.backgroundSpanCount = r1;
    }

    public void setClear(ColorItem r1) {
        this.clear = r1;
    }

    public void setReset(ColorItem r1) {
        this.reset = r1;
    }

    public void setSelected(Selected r1) {
        this.selected = r1;
    }

    public void setShow(boolean r1) {
        this.isShow = r1;
    }

    public void setText(ColorItem[] r1) {
        this.text = r1;
    }

    public void setTextColorSpanCount(int r1) {
        this.textColorSpanCount = r1;
    }
}
