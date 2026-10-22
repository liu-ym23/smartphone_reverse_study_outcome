package com.cronutils.model.field.constraint;

import com.cronutils.model.field.value.SpecialChar;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import zr7.a;

/* JADX INFO: loaded from: classes6.dex */
public class FieldConstraints implements Serializable {
    private static final long serialVersionUID = -9112124669329704710L;
    private final Integer endRange;
    private final Map<Integer, Integer> intMapping;
    private final Set<SpecialChar> specialChars;
    private final Integer startRange;
    private final boolean strictRange;
    private final Map<String, Integer> stringMapping;

    public int hashCode() {
        return Objects.hash(new Object[]{this.stringMapping, this.intMapping, this.specialChars, this.startRange, this.endRange, Boolean.valueOf(this.strictRange)});
    }

    public int getEndRange() {
        return this.endRange.intValue();
    }

    public int getStartRange() {
        return this.startRange.intValue();
    }

    public Set<String> getStringMappingKeySet() {
        return this.stringMapping.keySet();
    }

    public Set<SpecialChar> getSpecialChars() {
        return this.specialChars;
    }

    public boolean isStrictRange() {
        return this.strictRange;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        FieldConstraints r101 = (FieldConstraints) r100;
        if (this.strictRange == r101.strictRange) goto L13;
    L23:
        return false;
    L13:
        if (this.stringMapping.equals(r101.stringMapping) == false) goto L23;
        if (this.intMapping.equals(r101.intMapping) == false) goto L23;
        if (this.specialChars.equals(r101.specialChars) == false) goto L23;
        if (this.startRange.equals(r101.startRange) == false) goto L23;
        if (this.endRange.equals(r101.endRange) == false) goto L23;
        return true;
    }

    public Integer getIntMappingValue(Integer r100) {
        return this.intMapping.get(r100);
    }

    public Integer getStringMappingValue(String r100) {
        return this.stringMapping.get(r100);
    }

    public boolean isInRange(int r100) {
        if (r100 >= getStartRange()) goto L5;
    L7:
        return false;
    L5:
        if (r100 > getEndRange()) goto L7;
        return true;
    }

    public boolean isPeriodInRange(int r100) {
        if (r100 > 0) goto L4;
    L8:
        return false;
    L4:
        if (r100 > ((getEndRange() - getStartRange()) + 1)) goto L8;
        if (r100 > getEndRange()) goto L8;
        return true;
    }

    public FieldConstraints(Map<String, Integer> r100, Map<Integer, Integer> r101, Set<SpecialChar> r102, int r103, int r104, boolean r105) {
        a.b(r100, "String mapping must not be null");
        this.stringMapping = Collections.unmodifiableMap(r100);
        a.b(r101, "Integer mapping must not be null");
        this.intMapping = Collections.unmodifiableMap(r101);
        a.b(r102, "Special (non-standard) chars set must not be null");
        this.specialChars = Collections.unmodifiableSet(r102);
        this.startRange = Integer.valueOf(r103);
        this.endRange = Integer.valueOf(r104);
        this.strictRange = r105;
    }
}
