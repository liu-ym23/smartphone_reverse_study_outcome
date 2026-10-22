package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.share.ShareFileSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeListSortFilterScene {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f235658e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Kind f235659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f235660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f235661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f235662d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeListSortFilterScene$Kind;", "", "<init>", "(Ljava/lang/String;I)V", "RECENT", "MY_ROOT", "SHARED", "SHARED_FOLDER", "SUB_FOLDER", "FAVORITE", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Kind extends Enum<Kind> {
        public static final Kind FAVORITE = null;
        public static final Kind MY_ROOT = null;
        public static final Kind RECENT = null;
        public static final Kind SHARED = null;
        public static final Kind SHARED_FOLDER = null;
        public static final Kind SUB_FOLDER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f235663a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f235664b = null;

        public static EnumEntries<Kind> getEntries() {
            return f235664b;
        }

        static {
            Kind r100 = new Kind("RECENT", 0);
            RECENT = r100;
            Kind r101 = new Kind("MY_ROOT", 1);
            MY_ROOT = r101;
            Kind r102 = new Kind("SHARED", 2);
            SHARED = r102;
            Kind r103 = new Kind("SHARED_FOLDER", 3);
            SHARED_FOLDER = r103;
            Kind r104 = new Kind("SUB_FOLDER", 4);
            SUB_FOLDER = r104;
            Kind r105 = new Kind("FAVORITE", 5);
            FAVORITE = r105;
            Kind[] r110 = {r100, r101, r102, r103, r104, r105};
            f235663a = r110;
            f235664b = EnumEntriesKt.enumEntries(r110);
        }

        public static Kind[] values() {
            return (Kind[]) f235663a.clone();
        }

        public static Kind valueOf(String r100) {
            return (Kind) r27.a.a(Kind.class, r100);
        }

        public Kind(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.office.list.adapter.OfficeListSortFilterScene$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C3381a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f235665a = null;

            static {
                int[] r100 = new int[OfficeSpaceTab.values().length];
                r100[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[OfficeSpaceTab.FAVORITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[OfficeSpaceTab.MINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[OfficeSpaceTab.SHARED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f235665a = r100;
            }
        }

        public static List a() {
            return CollectionsKt.listOf(new b[]{g(FilterType.ALL), g(FilterType.DOC), g(FilterType.SHEET), g(FilterType.BITABLE), g(FilterType.SLIDES), g(FilterType.MINDNOTE), g(FilterType.FILE)});
        }

        public static b g(FilterType r100) {
            return new b(r100.getResId(), r100.getType(), r100.getFileType(), r100.getForbiddenFileType(), null, false);
        }

        public static c h(FolderSort r100) {
            zd5.q r101 = r100.convertSortType();
            return new c(r101.f571310a, r101.f571311b, r101.f571312c);
        }

        public static c i(ShareFileSort r100) {
            return new c(r100.getResId(), r100.getRank(), r100.getAsc());
        }

        public static OfficeListSortFilterScene b(Kind r100, String r101) {
            return new OfficeListSortFilterScene(r100, r101, CollectionsKt.listOf(new c[]{h(FolderSort.MODIFIED_TIME), h(FolderSort.CREATED_TIME)}), CollectionsKt.emptyList());
        }

        public static boolean d(b r100, FilterType r101) {
            if (r100.getType() == r101.getType()) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(r100.f235668c, r101.getFileType()) == false) goto L9;
            if (Intrinsics.areEqual(r100.f235669d, r101.getForbiddenFileType()) == false) goto L9;
            return true;
        }

        public static String e(Context r100, b r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "option");
            boolean r102 = r101.f235671f;
            Integer r103 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_Slides_Menu);
            Integer r104 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_Sheets_Menu);
            Integer r105 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_All_Menu);
            Integer r106 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_Docs_Menu);
            boolean r107 = true;
            if (r102 == false) goto L41;
            Integer r108 = r101.f235670e;
            if (r108 != null) goto L8;
        L10:
            if (r108 != null) goto L13;
        L15:
            if (r108 != null) goto L18;
        L20:
            if (r108 != null) goto L23;
        L25:
            if (r108 != null) goto L28;
        L30:
            if (r108 != null) goto L33;
        L35:
            if (r108 != null) goto L38;
        L71:
            r103 = null;
        L72:
            if (r103 == null) goto L74;
            int r109 = r103.intValue();
        L76:
            return r100.getString(r109);
        L74:
            r109 = r101.f235666a;
            goto L76
        L38:
            if (r108.intValue() != 100) goto L71;
            r103 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_Other_Menu);
            goto L72
        L33:
            if (r108.intValue() != 8) goto L35;
            r103 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_Compressed_Menu);
            goto L72
        L28:
            if (r108.intValue() != 5) goto L30;
        L23:
            if (r108.intValue() != 4) goto L25;
        L58:
            r103 = r104;
            goto L72
        L18:
            if (r108.intValue() != 3) goto L20;
            r103 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_AudioVideo_Menu);
            goto L72
        L13:
            if (r108.intValue() != 1) goto L15;
        L55:
            r103 = r106;
            goto L72
        L8:
            if (r108.intValue() != 0) goto L10;
        L9:
            r103 = r105;
            goto L72
        L41:
            if (r101.getType() != FilterType.ALL.getType()) goto L54;
            if (r101.f235668c.length() != 0) goto L45;
            boolean r110 = true;
        L46:
            if (r110 == false) goto L54;
            if (r101.f235669d.length() == 0) goto L51;
            r107 = false;
        L51:
            if (r107 == false) goto L54;
        L45:
            r110 = false;
        L54:
            if (d(r101, FilterType.DOC) == true) goto L55;
            if (d(r101, FilterType.SHEET) == true) goto L58;
            if (d(r101, FilterType.BITABLE) == false) goto L63;
            r103 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_Bitable_Menu);
            goto L72
        L63:
            if (d(r101, FilterType.SLIDES) == true) goto L72;
            if (d(r101, FilterType.MINDNOTE) == false) goto L69;
            r103 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_MindNotes_Menu);
            goto L72
        L69:
            if (d(r101, FilterType.FILE) == false) goto L71;
            r103 = Integer.valueOf(R.string.LarkCCM_Doubao_DriveFilter_Files_Menu);
            goto L72
        }

        public static String f(Context r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "option");
            int r102 = r101.f235673b;
            if (r102 != RecentSort.OPENED.getRank()) goto L6;
            int r103 = R.string.LarkCCM_Doubao_Drive_AccessTime_Menu;
        L18:
            return r100.getString(r103);
        L6:
            if (r102 != RecentSort.MODIFIED.getRank()) goto L8;
        L16:
            r103 = R.string.LarkCCM_Doubao_Drive_ModifiedTime_Menu;
            goto L18
        L8:
            if (r102 == ShareFileSort.MODIFIED_TIME.getRank()) goto L16;
            if (r102 == FolderSort.MODIFIED_TIME.convertSortType().f571311b) goto L16;
            if (r102 != FolderSort.NAME.getRank()) goto L15;
            r103 = R.string.LarkCCM_Doubao_Drive_Name_Menu;
            goto L18
        L15:
            r103 = r101.f235672a;
            goto L18
        }

        public static OfficeListSortFilterScene c(OfficeSpaceTab r510, String r511, Fragment r512) {
            Intrinsics.checkNotNullParameter(r510, "tab");
            Intrinsics.checkNotNullParameter(r511, EventConstant.Key.MODULE);
            int r100 = C3381a.f235665a[r510.ordinal()];
            if (r100 == 1) goto L36;
            if (r100 == 2) goto L43;
            if (r100 == 3) goto L11;
            if (r100 != 4) goto L9;
            return new OfficeListSortFilterScene(Kind.SHARED, "shared", CollectionsKt.listOf(new c[]{i(ShareFileSort.MODIFIED_TIME), i(ShareFileSort.CREATE_TIME), i(ShareFileSort.SHARE_TIME)}), a());
        L9:
            throw new NoWhenBranchMatchedException();
        L11:
            if (r512 == null) goto L15;
            Bundle r101 = r512.getArguments();
            if (r101 == null) goto L15;
            String r102 = r101.getString("token");
        L16:
            if (r102 != null) goto L19;
            r102 = "";
        L19:
            if (r102.length() <= 0) goto L21;
            boolean r103 = true;
        L22:
            if (r103 == false) goto L25;
            return b(Kind.SUB_FOLDER, r102);
        L25:
            if (Intrinsics.areEqual(r511, "my_root_folder") == true) goto L40;
            int r104 = OfficeListSortFilterScene.f235658e;
            if (Intrinsics.areEqual(r511, "shared_folder") == true) goto L41;
            StringBuilder r105 = new StringBuilder("skip sort scene because token is empty. module=");
            r105.append(r511);
            r105.append(", fragment=");
            if (r512 == null) goto L33;
            String r106 = r512.getClass().getSimpleName();
        L34:
            r105.append(r106);
            tt5.a.h("OfficeSortFilterScene", r105.toString());
            return null;
        L33:
            r106 = null;
            goto L34
        L41:
            return new OfficeListSortFilterScene(Kind.SHARED_FOLDER, "shared_folder_v2", CollectionsKt.listOf(new c[]{h(FolderSort.MODIFIED_TIME), h(FolderSort.CREATED_TIME), h(FolderSort.SHARED_TIME)}), CollectionsKt.emptyList());
        L40:
            return b(Kind.MY_ROOT, "my_root");
        L21:
            r103 = false;
        L15:
            r102 = null;
            goto L16
        L43:
            return new OfficeListSortFilterScene(Kind.FAVORITE, ScoreTags.SCORE_TYPE_STAR, CollectionsKt.emptyList(), a());
        L36:
            Kind r107 = Kind.RECENT;
            RecentSort r108 = RecentSort.OPENED;
            RecentSort r109 = RecentSort.MODIFIED;
            List r110 = CollectionsKt.listOf(new c[]{new c(r108.getResId(), r108.getRank(), r108.getAsc()), new c(r109.getResId(), r109.getRank(), r109.getAsc())});
            FilterType r111 = FilterType.ALL;
            return new OfficeListSortFilterScene(r107, "recent", r110, CollectionsKt.listOf(new b[]{new b(R.string.LarkCCM_Doubao_DriveFilter_All_Menu, r111.getType(), "", "", 0, true), new b(R.string.Doc_Facade_Document, r111.getType(), "", "", 1, true), new b(R.string.Doc_List_Filter_Image, r111.getType(), "", "", 2, true), new b(R.string.LarkCCM_Doubao_DriveFilter_AudioVideo_Menu, r111.getType(), "", "", 3, true), new b(R.string.Doc_Facade_CreateSheet, r111.getType(), "", "", 4, true), new b(R.string.LarkCCM_Doubao_DriveFilter_Slides_Menu, r111.getType(), "", "", 5, true), new b(R.string.LarkCCM_Doubao_DriveFilter_Compressed_Menu, r111.getType(), "", "", 8, true), new b(R.string.Doc_Search_Other, r111.getType(), "", "", 100, true)}));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f235666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f235667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f235668c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f235669d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f235670e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f235671f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f235666a == r101.f235666a) goto L12;
            return false;
        L12:
            if (this.f235667b == r101.f235667b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f235668c, r101.f235668c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f235669d, r101.f235669d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f235670e, r101.f235670e) == true) goto L24;
            return false;
        L24:
            if (this.f235671f == r101.f235671f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f235666a * 31) + this.f235667b) * 31) + this.f235668c.hashCode()) * 31) + this.f235669d.hashCode()) * 31;
            Integer r101 = this.f235670e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f235671f == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "FilterOption(titleRes=" + this.f235666a + ", type=" + this.f235667b + ", fileType=" + this.f235668c + ", forbiddenFileType=" + this.f235669d + ", officeRecentTabType=" + this.f235670e + ", isOfficeRecentFilter=" + this.f235671f + ')';
        }

        public final int getType() {
            return this.f235667b;
        }

        public b(int r100, int r101, String r102, String r103, Integer r104, boolean r105) {
            Intrinsics.checkNotNullParameter(r102, "fileType");
            Intrinsics.checkNotNullParameter(r103, "forbiddenFileType");
            this.f235666a = r100;
            this.f235667b = r101;
            this.f235668c = r102;
            this.f235669d = r103;
            this.f235670e = r104;
            this.f235671f = r105;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f235672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f235673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f235674c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f235672a == r101.f235672a) goto L12;
            return false;
        L12:
            if (this.f235673b == r101.f235673b) goto L15;
            return false;
        L15:
            if (this.f235674c == r101.f235674c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f235672a * 31) + this.f235673b) * 31;
            if (this.f235674c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "SortOption(titleRes=" + this.f235672a + ", rank=" + this.f235673b + ", asc=" + this.f235674c + ')';
        }

        public static c a(c r100, boolean r101) {
            return new c(r100.f235672a, r100.f235673b, r101);
        }

        public c(int r100, int r101, boolean r102) {
            this.f235672a = r100;
            this.f235673b = r101;
            this.f235674c = r102;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OfficeListSortFilterScene) == true) goto L8;
        return false;
    L8:
        OfficeListSortFilterScene r101 = (OfficeListSortFilterScene) r100;
        if (this.f235659a == r101.f235659a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235660b, r101.f235660b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235661c, r101.f235661c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f235662d, r101.f235662d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f235659a.hashCode() * 31) + this.f235660b.hashCode()) * 31) + this.f235661c.hashCode()) * 31) + this.f235662d.hashCode();
    }

    public final String toString() {
        return "OfficeListSortFilterScene(kind=" + this.f235659a + ", token=" + this.f235660b + ", sortOptions=" + this.f235661c + ", filterOptions=" + this.f235662d + ')';
    }

    public final boolean a() {
        return !this.f235661c.isEmpty();
    }

    public OfficeListSortFilterScene(Kind r100, String r101, List<c> r102, List<b> r103) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, "sortOptions");
        Intrinsics.checkNotNullParameter(r103, "filterOptions");
        this.f235659a = r100;
        this.f235660b = r101;
        this.f235661c = r102;
        this.f235662d = r103;
    }
}
