package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_Config_Option<T> extends Config.Option<T> {
    private final String id;
    private final Object token;
    private final Class<T> valueClass;

    public int hashCode() {
        int r0 = (((this.id.hashCode() ^ 1000003) * 1000003) ^ this.valueClass.hashCode()) * 1000003;
        Object r1 = this.token;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 ^ r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Option{id=" + this.id + ", valueClass=" + this.valueClass + ", token=" + this.token + "}";
    }

    @Override // androidx.camera.core.impl.Config.Option
    public String getId() {
        return this.id;
    }

    @Override // androidx.camera.core.impl.Config.Option
    public Object getToken() {
        return this.token;
    }

    @Override // androidx.camera.core.impl.Config.Option
    public Class<T> getValueClass() {
        return this.valueClass;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Config.Option) == false) goto L21;
        Config.Option r6 = (Config.Option) r5;
        if (this.id.equals(r6.getId()) == true) goto L10;
    L19:
        return false;
    L10:
        if (this.valueClass.equals(r6.getValueClass()) == false) goto L19;
        Object r1 = this.token;
        if (r1 != null) goto L17;
        if (r6.getToken() != null) goto L19;
        return true;
    L17:
        if (r1.equals(r6.getToken()) == false) goto L19;
        return true;
    L21:
        return false;
    }

    public AutoValue_Config_Option(String r1, Class<T> r2, Object r3) {
        if (r1 == null) goto L11;
        this.id = r1;
        if (r2 == null) goto L9;
        this.valueClass = r2;
        this.token = r3;
        return;
    L9:
        throw new NullPointerException("Null valueClass");
    L11:
        throw new NullPointerException("Null id");
    }
}
