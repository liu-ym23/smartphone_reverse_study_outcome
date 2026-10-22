package com.bytedance.ee.bear.contract.icon;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class IconInfo implements NonProguard {
    public static final int EMOJI = 1;
    public static final int IMAGE = 2;
    public static final int USER_IMAGE = 3;
    private String fs_unit;
    private Integer id;
    private String key;
    private int type;

    public IconInfo() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.key, Integer.valueOf(this.type), this.fs_unit});
    }

    public String toString() {
        return "IconInfo{id=" + this.id + ", key='" + this.key + "', type=" + this.type + ", fs_unit='" + this.fs_unit + "'}";
    }

    public String getFs_unit() {
        return this.fs_unit;
    }

    public Integer getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public int getType() {
        return this.type;
    }

    public static boolean isEmpty(IconInfo r1) {
        if (r1 != null) goto L4;
    L9:
        return true;
    L4:
        if (r1.key == null) goto L9;
        if (r1.fs_unit == null) goto L9;
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L21;
        IconInfo r6 = (IconInfo) r5;
        if (this.type == r6.type) goto L13;
    L19:
        return false;
    L13:
        if (Objects.equals(this.id, r6.id) == false) goto L19;
        if (Objects.equals(this.key, r6.key) == false) goto L19;
        if (Objects.equals(this.fs_unit, r6.fs_unit) == false) goto L19;
        return true;
    }

    public void setFs_unit(String r1) {
        this.fs_unit = r1;
    }

    public void setId(Integer r1) {
        this.id = r1;
    }

    public void setKey(String r1) {
        this.key = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }
}
