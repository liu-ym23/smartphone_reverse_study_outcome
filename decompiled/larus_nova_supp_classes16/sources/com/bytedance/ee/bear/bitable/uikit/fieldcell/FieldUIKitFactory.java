package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class FieldUIKitFactory {
    public static final c a = null;
    public static final e0 b = null;
    public static final f0 c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldUIKitFactory$Type;", "", "<init>", "(Ljava/lang/String;I)V", "COMMON", "GRID", "GALLERY", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type COMMON = null;
        public static final Type GALLERY = null;
        public static final Type GRID = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("COMMON", 0);
            COMMON = r0;
            Type r1 = new Type("GRID", 1);
            GRID = r1;
            Type r3 = new Type("GALLERY", 2);
            GALLERY = r3;
            Type[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Type.GRID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Type.GALLERY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new c();
        b = new e0();
        c = new f0();
    }

    public static c a(Type r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return b;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return c;
    L13:
        return a;
    }
}
