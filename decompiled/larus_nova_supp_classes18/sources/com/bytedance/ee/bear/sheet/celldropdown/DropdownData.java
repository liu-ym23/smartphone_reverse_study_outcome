package com.bytedance.ee.bear.sheet.celldropdown;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DropdownData implements NonProguard {
    private static final String TAG = "DropdownData";
    private Map<String, String> colorMap;
    private boolean enableOptionColor;
    private boolean isMulti;
    private String[] options;
    private String textColor;
    private String[] values;

    public static class a {
        public final String a;
        public final String b;
        public boolean c;

        public final int hashCode() {
            return Objects.hash(new Object[]{this.a, this.b, Boolean.valueOf(this.c)});
        }

        public final String toString() {
            return "DropdownItem{color='" + this.a + "', option='" + this.b + "', isSelected=" + this.c + '}';
        }

        public a() {
        }

        public a(String r1) {
            this.b = r1;
            this.c = false;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L19:
            return false;
        L8:
            if (a.class != r5.getClass()) goto L19;
            a r6 = (a) r5;
            if (this.c == r6.c) goto L13;
        L17:
            return false;
        L13:
            if (Objects.equals(this.a, r6.a) == false) goto L17;
            if (Objects.equals(this.b, r6.b) == false) goto L17;
            return true;
        }

        public a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
            this.c = false;
        }
    }

    public DropdownData() {
    }

    public a[] parseToDropdownArray() {
        String[] r0 = this.options;
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.length;
        ArrayList r2 = new ArrayList();
        if (this.colorMap != null) goto L9;
    L13:
        int r3 = 0;
    L14:
        if (r3 >= r1) goto L16;
        r2.add(new a(this.options[r3]));
        r3 = r3 + 1;
    L16:
        HashSet r4 = new HashSet(Arrays.asList(this.values));
        Iterator r5 = r2.iterator();
    L18:
        if (r5.hasNext() == false) goto L23;
        a r6 = (a) r5.next();
        if (r4.contains(r6.b) == false) goto L18;
        r6.c = true;
        goto L18
    L23:
        return (a[]) r2.toArray(new a[0]);
    L9:
        if (this.enableOptionColor == false) goto L13;
        int r7 = 0;
    L11:
        if (r7 >= r1) goto L16;
        r2.add(new a(this.colorMap.get(this.options[r7]), this.options[r7]));
        r7 = r7 + 1;
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

    public void setColorMap(Map<String, String> r1) {
        this.colorMap = r1;
    }

    public void setEnableOptionColor(boolean r1) {
        this.enableOptionColor = r1;
    }

    public void setIsEnableOptionColor(boolean r1) {
        setEnableOptionColor(r1);
    }

    public void setMulti(boolean r1) {
        this.isMulti = r1;
    }

    public void setOptions(String[] r1) {
        this.options = r1;
    }

    public void setTextColor(String r1) {
        this.textColor = r1;
    }

    public void setValues(String[] r1) {
        this.values = r1;
    }
}
