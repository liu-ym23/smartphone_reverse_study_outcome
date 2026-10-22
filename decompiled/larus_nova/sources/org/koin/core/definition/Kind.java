package org.koin.core.definition;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lorg/koin/core/definition/Kind;", "", "Single", "Factory", "koin-core"}, k = 1, mv = {1, 5, 1})
public final enum Kind extends Enum<Kind> {
    public static final Kind Factory = null;
    public static final Kind Single = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Kind[] f526136a = null;

    static {
        Kind r100 = new Kind("Single", 0);
        Single = r100;
        Kind r101 = new Kind("Factory", 1);
        Factory = r101;
        f526136a = new Kind[]{r100, r101};
    }

    public static Kind[] values() {
        return (Kind[]) Arrays.copyOf(f526136a, 2);
    }

    public static Kind valueOf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return (Kind) r27.a.a(Kind.class, r100);
    }

    public Kind(String r100, int r101) {
        super(r100, r101);
    }
}
