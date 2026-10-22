package com.bytedance.ee.bear.office.list.adapter;

import android.app.Application;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.larus.nova.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeSortDirectionSupport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235693a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeSortDirectionSupport$DirectionSlot;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "SECOND", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DirectionSlot extends Enum<DirectionSlot> {
        public static final DirectionSlot FIRST = null;
        public static final DirectionSlot SECOND = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DirectionSlot[] f235694a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f235695b = null;

        public static EnumEntries<DirectionSlot> getEntries() {
            return f235695b;
        }

        static {
            DirectionSlot r100 = new DirectionSlot("FIRST", 0);
            FIRST = r100;
            DirectionSlot r101 = new DirectionSlot("SECOND", 1);
            SECOND = r101;
            DirectionSlot[] r102 = {r100, r101};
            f235694a = r102;
            f235695b = EnumEntriesKt.enumEntries(r102);
        }

        public static DirectionSlot[] values() {
            return (DirectionSlot[]) f235694a.clone();
        }

        public static DirectionSlot valueOf(String r100) {
            return (DirectionSlot) r27.a.a(DirectionSlot.class, r100);
        }

        public DirectionSlot(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f235696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DirectionSlot f235697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OfficeListSortFilterScene.c f235698c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f235696a, r101.f235696a) == true) goto L12;
            return false;
        L12:
            if (this.f235697b == r101.f235697b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f235698c, r101.f235698c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f235696a.hashCode() * 31) + this.f235697b.hashCode()) * 31) + this.f235698c.hashCode();
        }

        public final String toString() {
            return "DirectionOption(title=" + this.f235696a + ", slot=" + this.f235697b + ", sortOption=" + this.f235698c + ')';
        }

        public a(String r100, DirectionSlot r101, OfficeListSortFilterScene.c r102) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "slot");
            Intrinsics.checkNotNullParameter(r102, "sortOption");
            this.f235696a = r100;
            this.f235697b = r101;
            this.f235698c = r102;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235699a = null;

        static {
            int[] r100 = new int[DirectionSlot.values().length];
            r100[DirectionSlot.FIRST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DirectionSlot.SECOND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f235699a = r100;
        }
    }

    static {
    }

    public static String d(OfficeListSortFilterScene.c r100) {
        Intrinsics.checkNotNullParameter(r100, "option");
        Application r101 = eu5.b.f474075a;
        DirectionSlot r102 = c(r100, r100.f235674c);
        int r103 = b.f235699a[r102.ordinal()];
        if (r103 == 1) goto L13;
        if (r103 != 2) goto L11;
        if (f(r100) == false) goto L9;
        String r104 = r101.getString(R.string.LarkCCM_Doubao_Drive_Descending_Menu);
        Intrinsics.checkNotNull(r104);
        return r104;
    L9:
        String r105 = r101.getString(R.string.LarkCCM_Doubao_Drive_OldestFirst_Menu);
        Intrinsics.checkNotNull(r105);
        return r105;
    L11:
        throw new NoWhenBranchMatchedException();
    L13:
        if (f(r100) == false) goto L15;
        String r106 = r101.getString(R.string.LarkCCM_Doubao_Drive_Ascending_Menu);
        Intrinsics.checkNotNull(r106);
        return r106;
    L15:
        String r107 = r101.getString(R.string.LarkCCM_Doubao_Drive_NewestFirst_Menu);
        Intrinsics.checkNotNull(r107);
        return r107;
    }

    public static List e(OfficeListSortFilterScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        OfficeListSortFilterScene.Kind r101 = r100.f235659a;
        if (r101 != OfficeListSortFilterScene.Kind.MY_ROOT) goto L5;
    L8:
        List r102 = CollectionsKt.toMutableList(r100.f235661c);
        List r103 = r102;
        if ((r103 instanceof Collection) == true) goto L11;
    L13:
        Iterator r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L22;
        boolean r105 = false;
        if (((OfficeListSortFilterScene.c) r104.next()).f235673b != FolderSort.NAME.getRank()) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L15;
    L23:
        if (r105 == false) goto L25;
        FolderSort r107 = FolderSort.NAME;
        r102.add(new OfficeListSortFilterScene.c(r107.getResId(), r107.getRank(), true));
    L25:
        return r102;
    L19:
        r106 = false;
    L22:
        r105 = true;
        goto L23
    L11:
        if (r103.isEmpty() == false) goto L13;
    L5:
        if (r101 == OfficeListSortFilterScene.Kind.SUB_FOLDER) goto L8;
        return r100.f235661c;
    }

    public static boolean f(OfficeListSortFilterScene.c r100) {
        Intrinsics.checkNotNullParameter(r100, "option");
        if (r100.f235673b != FolderSort.NAME.getRank()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(OfficeListSortFilterScene.c r100, DirectionSlot r101) {
        if (f(r100) == false) goto L8;
        if (r101 == DirectionSlot.FIRST) goto L9;
    L10:
        return false;
    L9:
        return true;
    L8:
        if (r101 != DirectionSlot.SECOND) goto L10;
        goto L9
    }

    public static DirectionSlot c(OfficeListSortFilterScene.c r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "option");
        DirectionSlot r102 = DirectionSlot.FIRST;
        if (r101 != a(r100, r102)) goto L6;
        return r102;
    L6:
        return DirectionSlot.SECOND;
    }

    public static OfficeListSortFilterScene.c g(OfficeListSortFilterScene.c r100, DirectionSlot r101) {
        Intrinsics.checkNotNullParameter(r100, "option");
        Intrinsics.checkNotNullParameter(r101, "slot");
        boolean r102 = a(r100, r101);
        return new OfficeListSortFilterScene.c(r100.f235672a, r100.f235673b, r102);
    }

    public static List b(OfficeListSortFilterScene.c r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "selectedOption");
        Intrinsics.checkNotNullParameter(r101, "firstTitle");
        Intrinsics.checkNotNullParameter(r102, "secondTitle");
        DirectionSlot r103 = DirectionSlot.FIRST;
        boolean r104 = a(r100, r103);
        DirectionSlot r105 = DirectionSlot.SECOND;
        return CollectionsKt.listOf(new a[]{new a(r101, r103, new OfficeListSortFilterScene.c(r100.f235672a, r100.f235673b, r104)), new a(r102, r105, new OfficeListSortFilterScene.c(r100.f235672a, r100.f235673b, a(r100, r105)))});
    }
}
