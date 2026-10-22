package kotlin.reflect.jvm.internal.impl.platform;

/* JADX INFO: loaded from: classes42.dex */
public abstract class SimplePlatform {
    private final String platformName;
    private final TargetPlatformVersion targetPlatformVersion;

    public String getTargetName() {
        return getTargetPlatformVersion().getDescription();
    }

    public String toString() {
        String r100 = getTargetName();
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return this.platformName + " (" + r100 + ')';
    L9:
        return this.platformName;
    L5:
        r101 = false;
        goto L6
    }

    public TargetPlatformVersion getTargetPlatformVersion() {
        return this.targetPlatformVersion;
    }
}
