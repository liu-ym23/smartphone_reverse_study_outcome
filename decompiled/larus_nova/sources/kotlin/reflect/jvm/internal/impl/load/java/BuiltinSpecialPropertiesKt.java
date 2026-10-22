package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes42.dex */
public final class BuiltinSpecialPropertiesKt {
    public static final /* synthetic */ FqName access$child(FqName r100, String r101) {
        return child(r100, r101);
    }

    public static final /* synthetic */ FqName access$childSafe(FqNameUnsafe r100, String r101) {
        return childSafe(r100, r101);
    }

    private static final FqName child(FqName r100, String r101) {
        return r100.child(Name.identifier(r101));
    }

    private static final FqName childSafe(FqNameUnsafe r100, String r101) {
        return r100.child(Name.identifier(r101)).toSafe();
    }
}
