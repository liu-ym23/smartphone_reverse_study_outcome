package com.bytedance.ee.bear.sheet.selectcolor;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
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

        public void setColorList(String[] r100) {
            this.colorList = r100;
        }

        public void setDefaultColor(String r100) {
            this.defaultColor = r100;
        }

        public void setTopicColor(String r100) {
            this.topicColor = r100;
        }

        public ColorScheme(String r100, String r101, String[] r102) {
            this.topicColor = r100;
            this.defaultColor = r101;
            this.colorList = r102;
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

    private ColorScheme[] parseColorScheme(String[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L22;
        ColorScheme[] r101 = new ColorScheme[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        ColorScheme r103 = (ColorScheme) JSON.parseObject(r100[r102], ColorScheme.class);     // Catch: Throwable -> L11
    L13:
        r101[r102] = r103;
        r102 = r102 + 1;
    L11:
        th = move-exception;
        tt5.a.d(TAG, "parse ColorScheme error : " + th);
        r103 = new ColorScheme();
        goto L13
    L14:
        return r101;
    L22:
        return null;
    }

    public void setColorSchemeList(ColorScheme[] r100) {
        this.colorSchemeList = r100;
    }

    public void setSelectedColor(String r100) {
        this.selectedColor = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public static String findDefaultColor(ColorScheme[] r100, String r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L17;
        ColorScheme r104 = r100[r103];
        if (r101.equalsIgnoreCase(r104.getTopicColor()) == true) goto L10;
        r103 = r103 + 1;
        goto L6
    L10:
        return r104.getDefaultColor();
    L17:
        return null;
    L16:
        return null;
    }

    public SheetSelectColorData(String r100, String r101, String[] r102) {
        this.title = r100;
        this.selectedColor = r101;
        this.colorSchemeList = parseColorScheme(r102);
    }

    public SheetSelectColorData(String r100, String r101, ColorScheme[] r102) {
        this.title = r100;
        this.selectedColor = r101;
        this.colorSchemeList = r102;
    }
}
