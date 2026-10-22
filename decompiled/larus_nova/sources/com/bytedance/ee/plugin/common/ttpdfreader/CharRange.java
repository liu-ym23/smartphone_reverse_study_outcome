package com.bytedance.ee.plugin.common.ttpdfreader;

import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public class CharRange {
    public final CharLocation fromLocation;
    public final CharLocation toLocation;

    public String toString() {
        return "CharRange@" + hashCode() + "{fromLocation: " + this.fromLocation + ", toLocation" + this.toLocation + '}';
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof CharRange) == true) goto L5;
        return false;
    L5:
        CharRange r101 = (CharRange) r100;
        if (Objects.equals(this.fromLocation, r101.fromLocation) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.toLocation, r101.toLocation) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public CharRange(CharLocation r100, CharLocation r101) {
        this.fromLocation = r100;
        this.toLocation = r101;
    }
}
