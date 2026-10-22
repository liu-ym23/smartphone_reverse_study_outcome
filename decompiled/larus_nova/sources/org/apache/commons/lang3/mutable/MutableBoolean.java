package org.apache.commons.lang3.mutable;

import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: loaded from: classes42.dex */
public class MutableBoolean implements Serializable, Comparable<MutableBoolean> {
    private static final long serialVersionUID = -4830728138360036487L;
    private boolean value;

    public void setFalse() {
        this.value = false;
    }

    public void setTrue() {
        this.value = true;
    }

    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }

    public int hashCode() {
        if (this.value == false) goto L5;
        Boolean r100 = Boolean.TRUE;
    L7:
        return r100.hashCode();
    L5:
        r100 = Boolean.FALSE;
        goto L7
    }

    public boolean isFalse() {
        return !this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public Boolean toBoolean() {
        return Boolean.valueOf(booleanValue());
    }

    public MutableBoolean() {
    }

    public boolean booleanValue() {
        return this.value;
    }

    public boolean isTrue() {
        return this.value;
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10979getValue() {
        return getValue();
    }

    public MutableBoolean(Boolean r100) {
        this.value = r100.booleanValue();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MutableBoolean r100) {
        return BooleanUtils.compare(this.value, r100.value);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof MutableBoolean) == true) goto L5;
        return false;
    L5:
        if (this.value != ((MutableBoolean) r100).booleanValue()) goto L9;
        return true;
    L9:
        return false;
    }

    public void setValue(Boolean r100) {
        this.value = r100.booleanValue();
    }

    public MutableBoolean(boolean r100) {
        this.value = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MutableBoolean r100) {
        return compareTo2(r100);
    }

    public /* bridge */ /* synthetic */ void setValue(Object r100) {
        setValue((Boolean) r100);
    }

    public void setValue(boolean r100) {
        this.value = r100;
    }
}
