package com.bytedance.ee.bear.sheet.celldropdown;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes18.dex */
public class DropdownData implements NonProguard {
    private static final String TAG = "DropdownData";
    private Map<String, String> colorMap;
    private boolean enableOptionColor;
    private boolean isMulti;
    private String[] options;
    private String textColor;
    private String[] values;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f237444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f237445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f237446c;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f237444a, this.f237445b, Boolean.valueOf(this.f237446c)});
        }

        public final String toString() {
            return "DropdownItem{color='" + this.f237444a + "', option='" + this.f237445b + "', isSelected=" + this.f237446c + '}';
        }

        public a() {
        }

        public a(String r100) {
            this.f237445b = r100;
            this.f237446c = false;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L19:
            return false;
        L8:
            if (a.class != r100.getClass()) goto L19;
            a r101 = (a) r100;
            if (this.f237446c == r101.f237446c) goto L13;
        L17:
            return false;
        L13:
            if (Objects.equals(this.f237444a, r101.f237444a) == false) goto L17;
            if (Objects.equals(this.f237445b, r101.f237445b) == false) goto L17;
            return true;
        }

        public a(String r100, String r101) {
            this.f237444a = r100;
            this.f237445b = r101;
            this.f237446c = false;
        }
    }

    public DropdownData() {
    }

    public a[] parseToDropdownArray() {
        String[] r100 = this.options;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.length;
        ArrayList r102 = new ArrayList();
        if (this.colorMap != null) goto L9;
    L13:
        int r103 = 0;
    L14:
        if (r103 >= r101) goto L16;
        r102.add(new a(this.options[r103]));
        r103 = r103 + 1;
    L16:
        HashSet r104 = new HashSet(Arrays.asList(this.values));
        Iterator r105 = r102.iterator();
    L18:
        if (r105.hasNext() == false) goto L23;
        a r106 = (a) r105.next();
        if (r104.contains(r106.f237445b) == false) goto L18;
        r106.f237446c = true;
        goto L18
    L23:
        return (a[]) r102.toArray(new a[0]);
    L9:
        if (this.enableOptionColor == false) goto L13;
        int r107 = 0;
    L11:
        if (r107 >= r101) goto L16;
        r102.add(new a(this.colorMap.get(this.options[r107]), this.options[r107]));
        r107 = r107 + 1;
        goto L11
    }

    public String toString() {
        return "DropdownData{selectedOption='" + b.g(Arrays.toString(this.values)) + "'enableOptionColor= " + this.enableOptionColor + ", colors=" + this.colorMap + ", options=" + b.g(Arrays.toString(this.options)) + '}';
    }

    public Map<String, String> getColorMap() {
        return this.colorMap;
    }

    public boolean getEnableOptionColor() {
        return this.enableOptionColor;
    }

    public String[] getOptions() {
        return this.options;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public String[] getValues() {
        return this.values;
    }

    public boolean isEnableOptionColor() {
        return this.enableOptionColor;
    }

    public boolean isMulti() {
        return this.isMulti;
    }

    public void setColorMap(Map<String, String> r100) {
        this.colorMap = r100;
    }

    public void setEnableOptionColor(boolean r100) {
        this.enableOptionColor = r100;
    }

    public void setIsEnableOptionColor(boolean r100) {
        setEnableOptionColor(r100);
    }

    public void setMulti(boolean r100) {
        this.isMulti = r100;
    }

    public void setOptions(String[] r100) {
        this.options = r100;
    }

    public void setTextColor(String r100) {
        this.textColor = r100;
    }

    public void setValues(String[] r100) {
        this.values = r100;
    }
}
