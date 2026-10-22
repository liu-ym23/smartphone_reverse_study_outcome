package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class FieldUIKitFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f216138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e0 f216139b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f0 f216140c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldUIKitFactory$Type;", "", "<init>", "(Ljava/lang/String;I)V", "COMMON", "GRID", "GALLERY", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type COMMON = null;
        public static final Type GALLERY = null;
        public static final Type GRID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f216141a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f216142b = null;

        public static EnumEntries<Type> getEntries() {
            return f216142b;
        }

        static {
            Type r100 = new Type("COMMON", 0);
            COMMON = r100;
            Type r101 = new Type("GRID", 1);
            GRID = r101;
            Type r102 = new Type("GALLERY", 2);
            GALLERY = r102;
            Type[] r103 = {r100, r101, r102};
            f216141a = r103;
            f216142b = EnumEntriesKt.enumEntries(r103);
        }

        public static Type[] values() {
            return (Type[]) f216141a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f216143a = null;

        static {
            int[] r100 = new int[Type.values().length];
            r100[Type.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Type.GRID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Type.GALLERY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f216143a = r100;
        }
    }

    static {
        f216138a = new c();
        f216139b = new e0();
        f216140c = new f0();
    }

    public static c a(Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = a.f216143a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return f216139b;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return f216140c;
    L13:
        return f216138a;
    }
}
