package com.ss.android.lark.widget.richtext.deprecated.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbstractParseResult implements Serializable {
    private static final long serialVersionUID = -5721926812249440813L;

    public AbstractParseResult() {
    }

    public abstract boolean canPartialUpdate(AbstractParseResult r100);

    public abstract int getHashCode();

    public abstract boolean isEquals(Object r100);

    public int hashCode() {
        return getHashCode();
    }

    public boolean equals(Object r100) {
        return isEquals(r100);
    }
}
