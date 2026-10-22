package org.apache.commons.lang3.builder;

import com.alipay.sdk.m.u.i;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes42.dex */
public class MultilineRecursiveToStringStyle extends RecursiveToStringStyle {
    private static final long serialVersionUID = 1;
    private int spaces;

    private void resetIndent() {
        setArrayStart("{" + System.lineSeparator() + spacer(this.spaces));
        setArraySeparator("," + System.lineSeparator() + spacer(this.spaces));
        setArrayEnd(System.lineSeparator() + spacer(this.spaces + (-2)) + i.f25855d);
        StringBuilder r100 = new StringBuilder("[");
        r100.append(System.lineSeparator());
        r100.append(spacer(this.spaces));
        setContentStart(r100.toString());
        setFieldSeparator("," + System.lineSeparator() + spacer(this.spaces));
        setContentEnd(System.lineSeparator() + spacer(this.spaces + (-2)) + "]");
    }

    public MultilineRecursiveToStringStyle() {
        this.spaces = 2;
        resetIndent();
    }

    private StringBuilder spacer(int r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101.append(" ");
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.apache.commons.lang3.builder.RecursiveToStringStyle, org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, Object r102) {
        if (ClassUtils.isPrimitiveWrapper(r102.getClass()) == false) goto L5;
    L9:
        super.appendDetail(r100, r101, r102);
        return;
    L5:
        if (String.class.equals(r102.getClass()) == true) goto L9;
        if (accept(r102.getClass()) == false) goto L9;
        this.spaces += 2;
        resetIndent();
        r100.append(ReflectionToStringBuilder.toString(r102, this));
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void reflectionAppendArrayDetail(StringBuffer r100, String r101, Object r102) {
        this.spaces += 2;
        resetIndent();
        super.reflectionAppendArrayDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, byte[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, char[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, double[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, float[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, int[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, long[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, Object[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, short[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer r100, String r101, boolean[] r102) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(r100, r101, r102);
        this.spaces -= 2;
        resetIndent();
    }
}
