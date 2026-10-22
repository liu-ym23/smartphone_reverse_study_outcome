package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.share.ShareFileSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeListSortFilterScene {
    public static final /* synthetic */ int e = 0;
    public final Kind a;
    public final String b;
    public final List<c> c;
    public final List<b> d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeListSortFilterScene$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "MY_ROOT", "SHARED", "SHARED_FOLDER", "SUB_FOLDER", "FAVORITE", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Kind extends Enum<Kind> {
        public static final Kind FAVORITE = null;
        public static final Kind MY_ROOT = null;
        public static final Kind RECENT = null;
        public static final Kind SHARED = null;
        public static final Kind SHARED_FOLDER = null;
        public static final Kind SUB_FOLDER = null;
        public static final /* synthetic */ Kind[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Kind> getEntries() {
            return b;
        }

        static {
            Kind r0 = new Kind("RECENT", 0);
            RECENT = r0;
            Kind r1 = new Kind("MY_ROOT", 1);
            MY_ROOT = r1;
            Kind r3 = new Kind("SHARED", 2);
            SHARED = r3;
            Kind r5 = new Kind("SHARED_FOLDER", 3);
            SHARED_FOLDER = r5;
            Kind r7 = new Kind("SUB_FOLDER", 4);
            SUB_FOLDER = r7;
            Kind r9 = new Kind("FAVORITE", 5);
            FAVORITE = r9;
            Kind[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
        }

        public static Kind[] values() {
            return (Kind[]) a.clone();
        }

        public static Kind valueOf(String r1) {
            return (Kind) r27.a.a(Kind.class, r1);
        }

        public Kind(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.office.list.adapter.OfficeListSortFilterScene$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0134a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[OfficeSpaceTab.values().length];
                r0[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[OfficeSpaceTab.FAVORITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[OfficeSpaceTab.MINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[OfficeSpaceTab.SHARED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public static List a() {
            return CollectionsKt.listOf(new b[]{g(FilterType.ALL), g(FilterType.DOC), g(FilterType.SHEET), g(FilterType.BITABLE), g(FilterType.SLIDES), g(FilterType.MINDNOTE), g(FilterType.FILE)});
        }

        public static b g(FilterType r8) {
            return new b(r8.getResId(), r8.getType(), r8.getFileType(), r8.getForbiddenFileType(), null, false);
        }

        public static c h(FolderSort r3) {
            zd5.q r4 = r3.convertSortType();
            return new c(r4.a, r4.b, r4.c);
        }

        public static c i(ShareFileSort r3) {
            return new c(r3.getResId(), r3.getRank(), r3.getAsc());
        }

        public static OfficeListSortFilterScene b(Kind r4, String r5) {
            return new OfficeListSortFilterScene(r4, r5, CollectionsKt.listOf(new c[]{h(FolderSort.MODIFIED_TIME), h(FolderSort.CREATED_TIME)}), CollectionsKt.emptyList());
        }

        public static boolean d(b r2, FilterType r3) {
            if (r2.getType() == r3.getType()) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(r2.c, r3.getFileType()) == false) goto L9;
            if (Intrinsics.areEqual(r2.d, r3.getForbiddenFileType()) == false) goto L9;
            return true;
        }

        public static String e(Context r7, b r8) {
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r8, "option");
            Integer r1 = 2131889407;
            boolean r5 = true;
            if (r8.f == false) goto L41;
            Integer r0 = r8.e;
            if (r0 != null) goto L8;
        L10:
            if (r0 != null) goto L13;
        L15:
            if (r0 != null) goto L18;
        L20:
            if (r0 != null) goto L23;
        L25:
            if (r0 != null) goto L28;
        L30:
            if (r0 != null) goto L33;
        L35:
            if (r0 != null) goto L38;
        L71:
            r1 = null;
        L72:
            if (r1 == null) goto L74;
            int r9 = r1.intValue();
        L76:
            return r7.getString(r9);
        L74:
            r9 = r8.a;
            goto L76
        L38:
            if (r0.intValue() != 100) goto L71;
            r1 = 2131889405;
            goto L72
        L33:
            if (r0.intValue() != 8) goto L35;
            r1 = 2131889401;
            goto L72
        L28:
            if (r0.intValue() != 5) goto L30;
        L23:
            if (r0.intValue() != 4) goto L25;
        L58:
            r1 = 2131889406;
            goto L72
        L18:
            if (r0.intValue() != 3) goto L20;
            r1 = 2131889399;
            goto L72
        L13:
            if (r0.intValue() != 1) goto L15;
        L55:
            r1 = 2131889402;
            goto L72
        L8:
            if (r0.intValue() != 0) goto L10;
        L9:
            r1 = 2131889398;
            goto L72
        L41:
            if (r8.getType() != FilterType.ALL.getType()) goto L54;
            if (r8.c.length() != 0) goto L45;
            boolean r2 = true;
        L46:
            if (r2 == false) goto L54;
            if (r8.d.length() == 0) goto L51;
            r5 = false;
        L51:
            if (r5 == false) goto L54;
        L45:
            r2 = false;
        L54:
            if (d(r8, FilterType.DOC) == true) goto L55;
            if (d(r8, FilterType.SHEET) == true) goto L58;
            if (d(r8, FilterType.BITABLE) == false) goto L63;
            r1 = 2131889400;
            goto L72
        L63:
            if (d(r8, FilterType.SLIDES) == true) goto L72;
            if (d(r8, FilterType.MINDNOTE) == false) goto L69;
            r1 = 2131889404;
            goto L72
        L69:
            if (d(r8, FilterType.FILE) == false) goto L71;
            r1 = 2131889403;
            goto L72
        }

        public static String f(Context r2, c r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "option");
            int r0 = r3.b;
            if (r0 != RecentSort.OPENED.getRank()) goto L6;
            int r4 = 2131889409;
        L18:
            return r2.getString(r4);
        L6:
            if (r0 != RecentSort.MODIFIED.getRank()) goto L8;
        L16:
            r4 = 2131889434;
            goto L18
        L8:
            if (r0 == ShareFileSort.MODIFIED_TIME.getRank()) goto L16;
            if (r0 == FolderSort.MODIFIED_TIME.convertSortType().b) goto L16;
            if (r0 != FolderSort.NAME.getRank()) goto L15;
            r4 = 2131889437;
            goto L18
        L15:
            r4 = r3.a;
            goto L18
        }

        public static OfficeListSortFilterScene c(OfficeSpaceTab r54, String r55, Fragment r56) {
            Intrinsics.checkNotNullParameter(r54, "tab");
            Intrinsics.checkNotNullParameter(r55, "module");
            int r1 = C0134a.a[r54.ordinal()];
            if (r1 == 1) goto L36;
            if (r1 == 2) goto L43;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L9;
            return new OfficeListSortFilterScene(Kind.SHARED, "shared", CollectionsKt.listOf(new c[]{i(ShareFileSort.MODIFIED_TIME), i(ShareFileSort.CREATE_TIME), i(ShareFileSort.SHARE_TIME)}), a());
        L9:
            throw new NoWhenBranchMatchedException();
        L11:
            if (r56 == null) goto L15;
            Bundle r2 = r56.getArguments();
            if (r2 == null) goto L15;
            String r3 = r2.getString(ResourceData.KEY_TOKEN);
        L16:
            if (r3 != null) goto L19;
            r3 = "";
        L19:
            if (r3.length() <= 0) goto L21;
            boolean r7 = true;
        L22:
            if (r7 == false) goto L25;
            return b(Kind.SUB_FOLDER, r3);
        L25:
            if (Intrinsics.areEqual(r55, "my_root_folder") == true) goto L40;
            int r4 = OfficeListSortFilterScene.e;
            if (Intrinsics.areEqual(r55, "shared_folder") == true) goto L41;
            StringBuilder r5 = new StringBuilder("skip sort scene because token is empty. module=");
            r5.append(r55);
            r5.append(", fragment=");
            if (r56 == null) goto L33;
            String r0 = r56.getClass().getSimpleName();
        L34:
            r5.append(r0);
            tt5.a.h("OfficeSortFilterScene", r5.toString());
            return null;
        L33:
            r0 = null;
            goto L34
        L41:
            return new OfficeListSortFilterScene(Kind.SHARED_FOLDER, "shared_folder_v2", CollectionsKt.listOf(new c[]{h(FolderSort.MODIFIED_TIME), h(FolderSort.CREATED_TIME), h(FolderSort.SHARED_TIME)}), CollectionsKt.emptyList());
        L40:
            return b(Kind.MY_ROOT, "my_root");
        L21:
            r7 = false;
        L15:
            r3 = null;
            goto L16
        L43:
            return new OfficeListSortFilterScene(Kind.FAVORITE, "star", CollectionsKt.emptyList(), a());
        L36:
            Kind r6 = Kind.RECENT;
            RecentSort r8 = RecentSort.OPENED;
            RecentSort r9 = RecentSort.MODIFIED;
            List r10 = CollectionsKt.listOf(new c[]{new c(r8.getResId(), r8.getRank(), r8.getAsc()), new c(r9.getResId(), r9.getRank(), r9.getAsc())});
            FilterType r18 = FilterType.ALL;
            return new OfficeListSortFilterScene(r6, "recent", r10, CollectionsKt.listOf(new b[]{new b(2131889398, r18.getType(), "", "", 0, true), new b(2131887745, r18.getType(), "", "", 1, true), new b(2131887914, r18.getType(), "", "", 2, true), new b(2131889399, r18.getType(), "", "", 3, true), new b(2131887733, r18.getType(), "", "", 4, true), new b(2131889407, r18.getType(), "", "", 5, true), new b(2131889401, r18.getType(), "", "", 8, true), new b(2131888183, r18.getType(), "", "", 100, true)}));
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final String c;
        public final String d;
        public final Integer e;
        public final boolean f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
            Integer r1 = this.e;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            if (this.f == false) goto L9;
            int r4 = 1231;
        L11:
            return r3 + r4;
        L9:
            r4 = 1237;
            goto L11
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "FilterOption(titleRes=" + this.a + ", type=" + this.b + ", fileType=" + this.c + ", forbiddenFileType=" + this.d + ", officeRecentTabType=" + this.e + ", isOfficeRecentFilter=" + this.f + ')';
        }

        public final int getType() {
            return this.b;
        }

        public b(int r2, int r3, String r4, String r5, Integer r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r4, "fileType");
            Intrinsics.checkNotNullParameter(r5, "forbiddenFileType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "SortOption(titleRes=" + this.a + ", rank=" + this.b + ", asc=" + this.c + ')';
        }

        public static c a(c r2, boolean r3) {
            return new c(r2.a, r2.b, r3);
        }

        public c(int r1, int r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeListSortFilterScene) == true) goto L8;
        return false;
    L8:
        OfficeListSortFilterScene r6 = (OfficeListSortFilterScene) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "OfficeListSortFilterScene(kind=" + this.a + ", token=" + this.b + ", sortOptions=" + this.c + ", filterOptions=" + this.d + ')';
    }

    public final boolean a() {
        return !this.c.isEmpty();
    }

    public OfficeListSortFilterScene(Kind r2, String r3, List<c> r4, List<b> r5) {
        Intrinsics.checkNotNullParameter(r2, "kind");
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "sortOptions");
        Intrinsics.checkNotNullParameter(r5, "filterOptions");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
