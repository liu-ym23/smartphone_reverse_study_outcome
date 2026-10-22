package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/PkgType;", "", "(Ljava/lang/String;I)V", "into", "Lopen_pkm/proto/PkgType;", "intoInt", "", "Common", "Main", "Subpackage", "Independent", "Companion", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum PkgType extends Enum<PkgType> {
    public static final PkgType Common = null;
    public static final a Companion = null;
    public static final PkgType Independent = null;
    public static final PkgType Main = null;
    public static final PkgType Subpackage = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkgType[] f252875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252876b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252877a = null;

        static {
            int[] r100 = new int[PkgType.values().length];
            r100[PkgType.Common.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PkgType.Main.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PkgType.Subpackage.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PkgType.Independent.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f252877a = r100;
        }
    }

    public static EnumEntries<PkgType> getEntries() {
        return f252876b;
    }

    public static PkgType valueOf(String r100) {
        return (PkgType) r27.a.a(PkgType.class, r100);
    }

    public static PkgType[] values() {
        return (PkgType[]) f252875a.clone();
    }

    static {
        PkgType r100 = new PkgType("Common", 0);
        Common = r100;
        PkgType r101 = new PkgType("Main", 1);
        Main = r101;
        PkgType r102 = new PkgType("Subpackage", 2);
        Subpackage = r102;
        PkgType r103 = new PkgType("Independent", 3);
        Independent = r103;
        PkgType[] r104 = {r100, r101, r102, r103};
        f252875a = r104;
        f252876b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public final open_pkm.proto.PkgType into() {
        int r100 = b.f252877a[ordinal()];
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L19;
        if (r100 == 3) goto L18;
        if (r100 != 4) goto L12;
        return open_pkm.proto.PkgType.VAR_PKG_TYPE_INDEPENDENT;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return open_pkm.proto.PkgType.VAR_PKG_TYPE_SUBPACKAGE;
    L19:
        return open_pkm.proto.PkgType.VAR_PKG_TYPE_MAIN;
    L16:
        return open_pkm.proto.PkgType.VAR_PKG_TYPE_COMMON;
    }

    public final int intoInt() {
        int r100 = b.f252877a[ordinal()];
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
    public static final PkgType fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L16;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 != 3) goto L12;
        return Independent;
    L12:
        throw new RuntimeException("Unmatched primitive enum value: PkgType with ");
    L18:
        return Subpackage;
    L19:
        return Main;
    L16:
        return Common;
    }

    public PkgType(String r100, int r101) {
        super(r100, r101);
    }
}
