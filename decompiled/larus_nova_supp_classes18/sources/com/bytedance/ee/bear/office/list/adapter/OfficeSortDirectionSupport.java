package com.bytedance.ee.bear.office.list.adapter;

import android.app.Application;
import com.bytedance.ee.bear.list.folder.FolderSort;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeSortDirectionSupport {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeSortDirectionSupport$DirectionSlot;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "SECOND", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DirectionSlot extends Enum<DirectionSlot> {
        public static final DirectionSlot FIRST = null;
        public static final DirectionSlot SECOND = null;
        public static final /* synthetic */ DirectionSlot[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DirectionSlot> getEntries() {
            return b;
        }

        static {
            DirectionSlot r0 = new DirectionSlot("FIRST", 0);
            FIRST = r0;
            DirectionSlot r1 = new DirectionSlot("SECOND", 1);
            SECOND = r1;
            DirectionSlot[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static DirectionSlot[] values() {
            return (DirectionSlot[]) a.clone();
        }

        public static DirectionSlot valueOf(String r1) {
            return (DirectionSlot) r27.a.a(DirectionSlot.class, r1);
        }

        public DirectionSlot(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final String a;
        public final DirectionSlot b;
        public final OfficeListSortFilterScene.c c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "DirectionOption(title=" + this.a + ", slot=" + this.b + ", sortOption=" + this.c + ')';
        }

        public a(String r2, DirectionSlot r3, OfficeListSortFilterScene.c r4) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, "slot");
            Intrinsics.checkNotNullParameter(r4, "sortOption");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DirectionSlot.values().length];
            r0[DirectionSlot.FIRST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DirectionSlot.SECOND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static String d(OfficeListSortFilterScene.c r3) {
        Intrinsics.checkNotNullParameter(r3, "option");
        Application r0 = eu5.b.a;
        DirectionSlot r1 = c(r3, r3.c);
        int r2 = b.a[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 != 2) goto L11;
        if (f(r3) == false) goto L9;
        String r4 = r0.getString(2131889423);
        Intrinsics.checkNotNull(r4);
        return r4;
    L9:
        String r5 = r0.getString(2131889444);
        Intrinsics.checkNotNull(r5);
        return r5;
    L11:
        throw new NoWhenBranchMatchedException();
    L13:
        if (f(r3) == false) goto L15;
        String r6 = r0.getString(2131889411);
        Intrinsics.checkNotNull(r6);
        return r6;
    L15:
        String r7 = r0.getString(2131889442);
        Intrinsics.checkNotNull(r7);
        return r7;
    }

    public static List e(OfficeListSortFilterScene r5) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        OfficeListSortFilterScene.Kind r0 = r5.a;
        if (r0 != OfficeListSortFilterScene.Kind.MY_ROOT) goto L5;
    L8:
        List r6 = CollectionsKt.toMutableList(r5.c);
        List r1 = r6;
        if ((r1 instanceof Collection) == true) goto L11;
    L13:
        Iterator r2 = r1.iterator();
    L15:
        if (r2.hasNext() == false) goto L22;
        boolean r4 = false;
        if (((OfficeListSortFilterScene.c) r2.next()).b != FolderSort.NAME.getRank()) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L15;
    L23:
        if (r4 == false) goto L25;
        FolderSort r7 = FolderSort.NAME;
        r6.add(new OfficeListSortFilterScene.c(r7.getResId(), r7.getRank(), true));
    L25:
        return r6;
    L19:
        r3 = false;
    L22:
        r4 = true;
        goto L23
    L11:
        if (r1.isEmpty() == false) goto L13;
    L5:
        if (r0 == OfficeListSortFilterScene.Kind.SUB_FOLDER) goto L8;
        return r5.c;
    }

    public static boolean f(OfficeListSortFilterScene.c r1) {
        Intrinsics.checkNotNullParameter(r1, "option");
        if (r1.b != FolderSort.NAME.getRank()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(OfficeListSortFilterScene.c r0, DirectionSlot r1) {
        if (f(r0) == false) goto L8;
        if (r1 == DirectionSlot.FIRST) goto L9;
    L10:
        return false;
    L9:
        return true;
    L8:
        if (r1 != DirectionSlot.SECOND) goto L10;
        goto L9
    }

    public static DirectionSlot c(OfficeListSortFilterScene.c r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "option");
        DirectionSlot r0 = DirectionSlot.FIRST;
        if (r2 != a(r1, r0)) goto L6;
        return r0;
    L6:
        return DirectionSlot.SECOND;
    }

    public static OfficeListSortFilterScene.c g(OfficeListSortFilterScene.c r2, DirectionSlot r3) {
        Intrinsics.checkNotNullParameter(r2, "option");
        Intrinsics.checkNotNullParameter(r3, "slot");
        boolean r4 = a(r2, r3);
        return new OfficeListSortFilterScene.c(r2.a, r2.b, r4);
    }

    public static List b(OfficeListSortFilterScene.c r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "selectedOption");
        Intrinsics.checkNotNullParameter(r8, "firstTitle");
        Intrinsics.checkNotNullParameter(r9, "secondTitle");
        DirectionSlot r2 = DirectionSlot.FIRST;
        boolean r3 = a(r7, r2);
        DirectionSlot r1 = DirectionSlot.SECOND;
        return CollectionsKt.listOf(new a[]{new a(r8, r2, new OfficeListSortFilterScene.c(r7.a, r7.b, r3)), new a(r9, r1, new OfficeListSortFilterScene.c(r7.a, r7.b, a(r7, r1)))});
    }
}
