package zd5;

import android.app.Application;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.manualoffline.ManualOfflineSort;
import com.bytedance.ee.bear.list.mine.MineSort;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.list.share.ShareFileSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortScene;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static ArrayList<Document> a(FolderSortStrategy r100, List<Document> r101) {
        ArrayList<Document> r102 = new ArrayList();
        ArrayList r103 = (ArrayList) r101;
        if (r103.size() == 0) goto L44;
        if (r100 == null) goto L7;
        int r104 = r100.getType();
        if (FilterType.isPhotoV2(r104, r100.f227682c, r100.f227683d) == false) goto L12;
        r104 = FilterType.ALL.getType();
    L12:
        if (r104 == FilterType.ALL.getType()) goto L43;
        Iterator r105 = r103.iterator();
    L15:
        if (r105.hasNext() == false) goto L44;
        Document r106 = (Document) r105.next();
        sbb.e r107 = sbb.e.f541301l;
        if (r104 != r107.f541317b) goto L23;
        int r108 = r106.getType();
        int r109 = r107.f541317b;
        if (r108 == r109) goto L22;
        if (c(r109, r106) == false) goto L23;
    L22:
        r102.add(r106);
    L23:
        sbb.e r110 = sbb.e.f541296g;
        int r111 = r110.f541317b;
        if (r104 == r111) goto L34;
        if (c(r111, r106) == true) goto L34;
        if (r106.getType() == r104) goto L32;
        if (c(r104, r106) == false) goto L15;
    L32:
        r102.add(r106);
    L34:
        if (r106.getType() != r110.f541317b) goto L36;
    L37:
        r102.add(r106);
    L39:
        if (c(r110.f541317b, r106) == true) goto L42;
        if (c(sbb.e.f541304o.f541317b, r106) == false) goto L15;
    L42:
        r102.add(r106);
        goto L15
    L36:
        if (r106.getType() != sbb.e.f541304o.f541317b) goto L39;
    L43:
        r102.addAll(r101);
        goto L44
    L7:
        return (ArrayList) r101;
    L44:
        return r102;
    }

    public static boolean c(int r100, Document r101) {
        if (r101.getType() == sbb.e.f541303n.f541317b) goto L5;
    L7:
        return false;
    L5:
        if (r100 != r101.f227908y1) goto L7;
        return true;
    }

    public static String b(SortScene r100, int r101, boolean r102) {
        Application r103 = eu5.b.a();
        if (r102 == false) goto L5;
        int r104 = R.string.LarkCCM_NewCM_FromAToZ_Option;
    L6:
        r103.getString(r104);
        if (r102 == false) goto L9;
        int r105 = R.string.LarkCCM_NewCM_EarliestToLatest_Option;
    L10:
        r103.getString(r105);
        if (SortScene.FolderSort != r100) goto L26;
        if (r101 != FolderSort.CREATED_TIME.getRank()) goto L16;
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_Created);
    L16:
        if (r101 != FolderSort.NAME.getRank()) goto L19;
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_Name);
    L19:
        if (r101 != FolderSort.MODIFIED_TIME.getRank()) goto L22;
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_LastUpdated);
    L22:
        if (r101 == FolderSort.SHARED_TIME.getRank()) goto L24;
        return "";
    L24:
        return r103.getString(R.string.LarkCCM_NewCM_Mobile_SortBySharedTime_Option);
    L26:
        if (SortScene.RecentSort != r100) goto L38;
        if (r101 != RecentSort.OPENED.getRank()) goto L31;
        return r103.getString(R.string.LarkCCM_NewCM_Mobile_SortByVisitedTime_Option);
    L31:
        if (r101 != RecentSort.MODIFIED.getRank()) goto L34;
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_LastUpdated);
    L34:
        if (r101 == RecentSort.CREATED.getRank()) goto L36;
        return "";
    L36:
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_Created);
    L38:
        if (SortScene.SubordinateSort != r100) goto L44;
        if (r101 == RecentSort.MODIFIED.getRank()) goto L42;
        return "";
    L42:
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_LastUpdated);
    L44:
        if (SortScene.ManualOfflineSort != r100) goto L56;
        if (r101 != ManualOfflineSort.CREATED.getRank()) goto L49;
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_Created);
    L49:
        if (r101 != ManualOfflineSort.MODIFIED.getRank()) goto L52;
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_LastUpdated);
    L52:
        if (r101 == ManualOfflineSort.DEFAULT.getRank()) goto L54;
        return "";
    L54:
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_Added);
    L56:
        if (SortScene.ShareFileSort != r100) goto L66;
        if (r101 != ShareFileSort.CREATE_TIME.getRank()) goto L61;
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_Created);
    L61:
        if (r101 != ShareFileSort.SHARE_TIME.getRank()) goto L64;
        return r103.getString(R.string.LarkCCM_NewCM_Mobile_SortBySharedTime_Option);
    L64:
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_LastUpdated);
    L66:
        if (SortScene.MineSort == r100) goto L68;
        return "";
    L68:
        if (r101 != MineSort.CREATE_TIME.getRank()) goto L71;
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_Created);
    L71:
        if (r101 == MineSort.MODIFIED_TIME.getRank()) goto L73;
        return "";
    L73:
        return r103.getString(R.string.CreationMobile_ECM_ManageGroup_SortBy_Option_LastUpdated);
    L9:
        r105 = R.string.LarkCCM_NewCM_LatestToEarliest_Option;
        goto L10
    L5:
        r104 = R.string.LarkCCM_NewCM_FromZToA_Option;
        goto L6
    }
}
