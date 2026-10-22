package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_Identifier extends Identifier {
    private final Object value;

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Identifier{value=" + this.value + "}";
    }

    @Override // androidx.camera.core.impl.Identifier
    public Object getValue() {
        return this.value;
    }

    public AutoValue_Identifier(Object r2) {
        if (r2 == null) goto L7;
        this.value = r2;
        return;
    L7:
        throw new NullPointerException("Null value");
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof Identifier) == true) goto L8;
        return false;
    L8:
        return this.value.equals(((Identifier) r2).getValue());
    }
}
