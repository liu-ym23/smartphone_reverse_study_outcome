package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class AutoValue_DeviceProperties extends DeviceProperties {
    private final String manufacturer;
    private final String model;
    private final int sdkVersion;

    public int hashCode() {
        return ((((this.manufacturer.hashCode() ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.sdkVersion;
    }

    public String toString() {
        return "DeviceProperties{manufacturer=" + this.manufacturer + ", model=" + this.model + ", sdkVersion=" + this.sdkVersion + "}";
    }

    @Override // androidx.camera.core.impl.DeviceProperties
    public String manufacturer() {
        return this.manufacturer;
    }

    @Override // androidx.camera.core.impl.DeviceProperties
    public String model() {
        return this.model;
    }

    @Override // androidx.camera.core.impl.DeviceProperties
    public int sdkVersion() {
        return this.sdkVersion;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DeviceProperties) == false) goto L16;
        DeviceProperties r6 = (DeviceProperties) r5;
        if (this.manufacturer.equals(r6.manufacturer()) == true) goto L10;
    L14:
        return false;
    L10:
        if (this.model.equals(r6.model()) == false) goto L14;
        if (this.sdkVersion != r6.sdkVersion()) goto L14;
        return true;
    L16:
        return false;
    }

    public AutoValue_DeviceProperties(String r1, String r2, int r3) {
        if (r1 == null) goto L11;
        this.manufacturer = r1;
        if (r2 == null) goto L9;
        this.model = r2;
        this.sdkVersion = r3;
        return;
    L9:
        throw new NullPointerException("Null model");
    L11:
        throw new NullPointerException("Null manufacturer");
    }
}
