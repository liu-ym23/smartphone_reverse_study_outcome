package org.apache.commons.lang3.builder;

import java.util.Collection;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes42.dex */
public class RecursiveToStringStyle extends ToStringStyle {
    private static final long serialVersionUID = 1;

    public boolean accept(Class<?> r100) {
        return true;
    }

    public RecursiveToStringStyle() {
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, Object r102) {
        if (ClassUtils.isPrimitiveWrapper(r102.getClass()) == false) goto L5;
    L9:
        super.appendDetail(r100, r101, r102);
        return;
    L5:
        if (String.class.equals(r102.getClass()) == true) goto L9;
        if (accept(r102.getClass()) == false) goto L9;
        r100.append(ReflectionToStringBuilder.toString(r102, this));
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, Collection<?> r102) {
        appendClassName(r100, r102);
        appendIdentityHashCode(r100, r102);
        appendDetail(r100, r101, r102.toArray());
    }
}
