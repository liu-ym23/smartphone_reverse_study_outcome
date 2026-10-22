package com.cronutils.model.field.value;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public abstract class FieldValue<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 2392311922703946889L;

    public FieldValue() {
    }

    public abstract T getValue();

    public final String toString() {
        return String.format("%s", new Object[]{getValue()});
    }
}
