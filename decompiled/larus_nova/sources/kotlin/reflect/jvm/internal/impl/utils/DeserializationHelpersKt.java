package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;

/* JADX INFO: loaded from: classes5.dex */
public final class DeserializationHelpersKt {
    public static final JvmMetadataVersion jvmMetadataVersionOrDefault(DeserializationConfiguration r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        BinaryVersion r101 = r100.getBinaryVersion();
        if ((r101 instanceof JvmMetadataVersion) == false) goto L5;
        JvmMetadataVersion r102 = (JvmMetadataVersion) r101;
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        return JvmMetadataVersion.INSTANCE;
    L5:
        r102 = null;
        goto L6
    }
}
