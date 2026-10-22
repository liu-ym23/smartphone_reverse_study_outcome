package com.bytedance.ee.bear.contract.icon;

import com.bytedance.ee.util.io.NonProguard;
import java.util.Objects;

/* JADX INFO: loaded from: classes16.dex */
public class IconInfo implements NonProguard {
    public static final int EMOJI = 1;
    public static final int IMAGE = 2;
    public static final int USER_IMAGE = 3;
    private String fs_unit;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Integer f217066id;
    private String key;
    private int type;

    public IconInfo() {
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f217066id, this.key, Integer.valueOf(this.type), this.fs_unit});
    }

    public String toString() {
        return "IconInfo{id=" + this.f217066id + ", key='" + this.key + "', type=" + this.type + ", fs_unit='" + this.fs_unit + "'}";
    }

    public String getFs_unit() {
        return this.fs_unit;
    }

    public Integer getId() {
        return this.f217066id;
    }

    public String getKey() {
        return this.key;
    }

    public int getType() {
        return this.type;
    }

    public static boolean isEmpty(IconInfo r100) {
        if (r100 != null) goto L4;
    L9:
        return true;
    L4:
        if (r100.key == null) goto L9;
        if (r100.fs_unit == null) goto L9;
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        IconInfo r101 = (IconInfo) r100;
        if (this.type == r101.type) goto L13;
    L19:
        return false;
    L13:
        if (Objects.equals(this.f217066id, r101.f217066id) == false) goto L19;
        if (Objects.equals(this.key, r101.key) == false) goto L19;
        if (Objects.equals(this.fs_unit, r101.fs_unit) == false) goto L19;
        return true;
    }

    public void setFs_unit(String r100) {
        this.fs_unit = r100;
    }

    public void setId(Integer r100) {
        this.f217066id = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
