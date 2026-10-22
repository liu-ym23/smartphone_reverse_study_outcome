package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/PkmFrom;", "", "(Ljava/lang/String;I)V", "into", "Lopen_pkm/proto/PkmFrom;", "intoInt", "", "Normal", "Async", "Preload", "Builtin", "Companion", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum PkmFrom extends Enum<PkmFrom> {
    public static final PkmFrom Async = null;
    public static final PkmFrom Builtin = null;
    public static final a Companion = null;
    public static final PkmFrom Normal = null;
    public static final PkmFrom Preload = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkmFrom[] f252881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252882b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252883a = null;

        static {
            int[] r100 = new int[PkmFrom.values().length];
            r100[PkmFrom.Normal.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PkmFrom.Async.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PkmFrom.Preload.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PkmFrom.Builtin.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f252883a = r100;
        }
    }

    public static EnumEntries<PkmFrom> getEntries() {
        return f252882b;
    }

    public static PkmFrom valueOf(String r100) {
        return (PkmFrom) r27.a.a(PkmFrom.class, r100);
    }

    public static PkmFrom[] values() {
        return (PkmFrom[]) f252881a.clone();
    }

    static {
        PkmFrom r100 = new PkmFrom("Normal", 0);
        Normal = r100;
        PkmFrom r101 = new PkmFrom("Async", 1);
        Async = r101;
        PkmFrom r102 = new PkmFrom("Preload", 2);
        Preload = r102;
        PkmFrom r103 = new PkmFrom("Builtin", 3);
        Builtin = r103;
        PkmFrom[] r104 = {r100, r101, r102, r103};
        f252881a = r104;
        f252882b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public final open_pkm.proto.PkmFrom into() {
        int r100 = b.f252883a[ordinal()];
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 != 4) goto L12;
        return open_pkm.proto.PkmFrom.VAR_PKM_FROM_BUILTIN;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return open_pkm.proto.PkmFrom.VAR_PKM_FROM_PRELOAD;
    L19:
        return open_pkm.proto.PkmFrom.VAR_PKM_FROM_ASYNC;
    L16:
        return open_pkm.proto.PkmFrom.VAR_PKM_FROM_NORMAL;
    }

    public final int intoInt() {
        int r100 = b.f252883a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L7;
        return 1;
    L7:
        if (r100 != 3) goto L9;
        return 2;
    L9:
        if (r100 != 4) goto L12;
        return 3;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final PkmFrom fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L16;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 != 3) goto L12;
        return Builtin;
    L12:
        throw new RuntimeException("Unmatched primitive enum value: PkmFrom with ");
    L18:
        return Preload;
    L19:
        return Async;
    L16:
        return Normal;
    }

    public PkmFrom(String r100, int r101) {
        super(r100, r101);
    }
}
