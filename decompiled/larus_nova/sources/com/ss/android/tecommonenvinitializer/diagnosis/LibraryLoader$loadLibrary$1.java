package com.ss.android.tecommonenvinitializer.diagnosis;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final /* synthetic */ class LibraryLoader$loadLibrary$1 extends FunctionReferenceImpl implements Function1<List<? extends String>, Boolean> {
    public static final LibraryLoader$loadLibrary$1 INSTANCE = null;

    static {
        INSTANCE = new LibraryLoader$loadLibrary$1();
    }

    public LibraryLoader$loadLibrary$1() {
        super(1, a.class, "systemLoader", "systemLoader(Ljava/util/List;)Z", 1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        a.a(r100);
        return Boolean.TRUE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(List<? extends String> r100) {
        return invoke2(r100);
    }
}
