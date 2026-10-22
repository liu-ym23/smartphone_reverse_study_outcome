package com.bytedance.ee.bear.sheet.selectcolor;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetSelectColorData implements NonProguard {
    private static final String TAG = "SheetSelectColorData";
    private ColorScheme[] colorSchemeList;
    private String selectedColor;
    private String title;

    public static class ColorScheme implements NonProguard {
        private String[] colorList;
        private String defaultColor;
        private String topicColor;

        public ColorScheme() {
        }

        public String[] getColorList() {
            return this.colorList;
        }

        public String getDefaultColor() {
            return this.defaultColor;
        }

        public String getTopicColor() {
            return this.topicColor;
        }

        public void setColorList(String[] r1) {
            this.colorList = r1;
        }

        public void setDefaultColor(String r1) {
            this.defaultColor = r1;
        }

        public void setTopicColor(String r1) {
            this.topicColor = r1;
        }

        public ColorScheme(String r1, String r2, String[] r3) {
            this.topicColor = r1;
            this.defaultColor = r2;
            this.colorList = r3;
        }
    }

    public ColorScheme[] getColorSchemeList() {
        return this.colorSchemeList;
    }

    public String getSelectedColor() {
        return this.selectedColor;
    }

    public String getTitle() {
        return this.title;
    }

    private ColorScheme[] parseColorScheme(String[] r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.length == 0) goto L22;
        ColorScheme[] r0 = new ColorScheme[r6.length];
        int r1 = 0;
    L8:
        if (r1 >= r6.length) goto L14;
        ColorScheme r2 = (ColorScheme) JSON.parseObject(r6[r1], ColorScheme.class);     // Catch: Throwable -> L11
    L13:
        r0[r1] = r2;
        r1 = r1 + 1;
    L11:
        th = move-exception;
        tt5.a.d(TAG, "parse ColorScheme error : " + th);
        r2 = new ColorScheme();
        goto L13
    L14:
        return r0;
    L22:
        return null;
    }

    public void setColorSchemeList(ColorScheme[] r1) {
        this.colorSchemeList = r1;
    }

    public void setSelectedColor(String r1) {
        this.selectedColor = r1;
    }

    public void setTitle(String r1) {
        this.title = r1;
    }

    public static String findDefaultColor(ColorScheme[] r4, String r5) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r5) == true) goto L16;
        int r0 = r4.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L17;
        ColorScheme r2 = r4[r1];
        if (r5.equalsIgnoreCase(r2.getTopicColor()) == true) goto L10;
        r1 = r1 + 1;
        goto L6
    L10:
        return r2.getDefaultColor();
    L17:
        return null;
    L16:
        return null;
    }

    public SheetSelectColorData(String r1, String r2, String[] r3) {
        this.title = r1;
        this.selectedColor = r2;
        this.colorSchemeList = parseColorScheme(r3);
    }

    public SheetSelectColorData(String r1, String r2, ColorScheme[] r3) {
        this.title = r1;
        this.selectedColor = r2;
        this.colorSchemeList = r3;
    }
}
