package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmMetadataVersion extends BinaryVersion {
    public static final Companion Companion = null;
    public static final JvmMetadataVersion INSTANCE = null;
    public static final JvmMetadataVersion INSTANCE_NEXT = null;
    public static final JvmMetadataVersion INVALID_VERSION = null;
    private final boolean isStrictSemantics;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        JvmMetadataVersion r100 = new JvmMetadataVersion(new int[]{2, 0, 0});
        INSTANCE = r100;
        INSTANCE_NEXT = r100.next();
        INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    }

    public final JvmMetadataVersion next() {
        if (getMajor() != 1) goto L8;
        if (getMinor() != 9) goto L8;
        return new JvmMetadataVersion(new int[]{2, 0, 0});
    L8:
        return new JvmMetadataVersion(new int[]{getMajor(), getMinor() + 1, 0});
    }

    public final boolean isStrictSemantics() {
        return this.isStrictSemantics;
    }

    public JvmMetadataVersion(int... r100) {
        Intrinsics.checkNotNullParameter(r100, "numbers");
        this(r100, false);
    }

    private final boolean isCompatibleInternal(JvmMetadataVersion r100) {
        if (getMajor() != 1) goto L8;
        if (getMinor() != 0) goto L8;
        return false;
    L8:
        if (getMajor() != 0) goto L11;
        return false;
    L11:
        return !newerThan(r100);
    }

    private final boolean newerThan(JvmMetadataVersion r100) {
        if (getMajor() <= r100.getMajor()) goto L6;
        return true;
    L6:
        if (getMajor() >= r100.getMajor()) goto L9;
    L7:
        return false;
    L9:
        if (getMinor() <= r100.getMinor()) goto L7;
        return true;
    }

    public final boolean isCompatible(JvmMetadataVersion r100) {
        Intrinsics.checkNotNullParameter(r100, "metadataVersionFromLanguageVersion");
        if (getMajor() != 2) goto L12;
        if (getMinor() != 0) goto L12;
        JvmMetadataVersion r101 = INSTANCE;
        if (r101.getMajor() != 1) goto L12;
        if (r101.getMinor() != 8) goto L12;
        return true;
    L12:
        return isCompatibleInternal(r100.lastSupportedVersionWithThisLanguageVersion(this.isStrictSemantics));
    }

    public final JvmMetadataVersion lastSupportedVersionWithThisLanguageVersion(boolean r100) {
        if (r100 == false) goto L4;
        JvmMetadataVersion r101 = INSTANCE;
    L6:
        if (r101.newerThan(this) == false) goto L9;
        return r101;
    L9:
        return this;
    L4:
        r101 = INSTANCE_NEXT;
        goto L6
    }

    public JvmMetadataVersion(int[] r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "versionArray");
        super(Arrays.copyOf(r100, r100.length));
        this.isStrictSemantics = r101;
    }
}
