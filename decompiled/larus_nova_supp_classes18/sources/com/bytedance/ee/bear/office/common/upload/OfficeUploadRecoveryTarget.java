package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeUploadRecoveryTarget {
    public static final /* synthetic */ int c = 0;
    public final Type a;
    public final String b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryTarget$Type;", "", "<init>", "(Ljava/lang/String;I)V", "ROOT_MINE", "FOLDER", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type FOLDER = null;
        public static final Type ROOT_MINE = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("ROOT_MINE", 0);
            ROOT_MINE = r0;
            Type r1 = new Type("FOLDER", 1);
            FOLDER = r1;
            Type[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
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

    public static final class a {
        public static OfficeUploadRecoveryTarget b() {
            return new OfficeUploadRecoveryTarget(Type.ROOT_MINE, null);
        }

        public static OfficeUploadRecoveryTarget a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "folderToken");
            if ((!StringsKt.isBlank(r2)) == true) goto L6;
            r2 = null;
        L6:
            if (r2 != null) goto L8;
            return null;
        L8:
            return new OfficeUploadRecoveryTarget(Type.FOLDER, r2);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Type.values().length];
            r0[Type.ROOT_MINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Type.FOLDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final String a() {
        Type r0 = this.a;
        int r1 = b.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "root";
    L5:
        if (r1 != 2) goto L11;
        StringBuilder r2 = new StringBuilder("folder:");
        String r3 = this.b;
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r2.append(r3.hashCode());
        return r2.toString();
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public final g0 b() {
        Type r0 = this.a;
        int r1 = b.a[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L11;
        String r2 = this.b;
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        return new g0.a(r2);
    L11:
        throw new NoWhenBranchMatchedException();
    L13:
        return g0.b.a;
    }

    public OfficeUploadRecoveryTarget(Type r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
