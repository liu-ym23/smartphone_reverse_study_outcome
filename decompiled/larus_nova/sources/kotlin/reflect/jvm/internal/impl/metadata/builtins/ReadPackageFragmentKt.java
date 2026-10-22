package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;

/* JADX INFO: loaded from: classes5.dex */
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        BuiltInsBinaryVersion r101 = BuiltInsBinaryVersion.Companion.readFrom(r100);     // Catch: Throwable -> L10
        if (r101.isCompatibleWithCurrentCompilerVersion() == false) goto L6;
        ExtensionRegistryLite r102 = ExtensionRegistryLite.newInstance();     // Catch: Throwable -> L10
        BuiltInsProtoBuf.registerAllExtensions(r102);     // Catch: Throwable -> L10
        ProtoBuf.PackageFragment r103 = ProtoBuf.PackageFragment.parseFrom(r100, r102);     // Catch: Throwable -> L10
    L7:
        Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> r104 = TuplesKt.to(r103, r101);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r100, null);
        return r104;
    L6:
        r103 = null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);
        throw th;
    }
}
