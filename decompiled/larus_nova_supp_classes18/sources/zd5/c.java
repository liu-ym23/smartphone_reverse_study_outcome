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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static ArrayList<Document> a(FolderSortStrategy r5, List<Document> r6) {
        ArrayList<Document> r0 = new ArrayList();
        ArrayList r1 = (ArrayList) r6;
        if (r1.size() == 0) goto L44;
        if (r5 == null) goto L7;
        int r2 = r5.getType();
        if (FilterType.isPhotoV2(r2, r5.c, r5.d) == false) goto L12;
        r2 = FilterType.ALL.getType();
    L12:
        if (r2 == FilterType.ALL.getType()) goto L43;
        Iterator r7 = r1.iterator();
    L15:
        if (r7.hasNext() == false) goto L44;
        Document r8 = (Document) r7.next();
        sbb.e r3 = sbb.e.l;
        if (r2 != r3.b) goto L23;
        int r4 = r8.getType();
        int r9 = r3.b;
        if (r4 == r9) goto L22;
        if (c(r9, r8) == false) goto L23;
    L22:
        r0.add(r8);
    L23:
        sbb.e r10 = sbb.e.g;
        int r11 = r10.b;
        if (r2 == r11) goto L34;
        if (c(r11, r8) == true) goto L34;
        if (r8.getType() == r2) goto L32;
        if (c(r2, r8) == false) goto L15;
    L32:
        r0.add(r8);
    L34:
        if (r8.getType() != r10.b) goto L36;
    L37:
        r0.add(r8);
    L39:
        if (c(r10.b, r8) == true) goto L42;
        if (c(sbb.e.o.b, r8) == false) goto L15;
    L42:
        r0.add(r8);
        goto L15
    L36:
        if (r8.getType() != sbb.e.o.b) goto L39;
    L43:
        r0.addAll(r6);
        goto L44
    L7:
        return (ArrayList) r6;
    L44:
        return r0;
    }

    public static boolean c(int r2, Document r3) {
        if (r3.getType() == sbb.e.n.b) goto L5;
    L7:
        return false;
    L5:
        if (r2 != r3.y1) goto L7;
        return true;
    }

    public static String b(SortScene r5, int r6, boolean r7) {
        Application r0 = eu5.b.a();
        if (r7 == false) goto L5;
        int r1 = 2131889595;
    L6:
        r0.getString(r1);
        if (r7 == false) goto L9;
        int r8 = 2131889593;
    L10:
        r0.getString(r8);
        if (SortScene.FolderSort != r5) goto L26;
        if (r6 != FolderSort.CREATED_TIME.getRank()) goto L16;
        return r0.getString(2131887273);
    L16:
        if (r6 != FolderSort.NAME.getRank()) goto L19;
        return r0.getString(2131887275);
    L19:
        if (r6 != FolderSort.MODIFIED_TIME.getRank()) goto L22;
        return r0.getString(2131887274);
    L22:
        if (r6 == FolderSort.SHARED_TIME.getRank()) goto L24;
        return "";
    L24:
        return r0.getString(2131889613);
    L26:
        if (SortScene.RecentSort != r5) goto L38;
        if (r6 != RecentSort.OPENED.getRank()) goto L31;
        return r0.getString(2131889615);
    L31:
        if (r6 != RecentSort.MODIFIED.getRank()) goto L34;
        return r0.getString(2131887274);
    L34:
        if (r6 == RecentSort.CREATED.getRank()) goto L36;
        return "";
    L36:
        return r0.getString(2131887273);
    L38:
        if (SortScene.SubordinateSort != r5) goto L44;
        if (r6 == RecentSort.MODIFIED.getRank()) goto L42;
        return "";
    L42:
        return r0.getString(2131887274);
    L44:
        if (SortScene.ManualOfflineSort != r5) goto L56;
        if (r6 != ManualOfflineSort.CREATED.getRank()) goto L49;
        return r0.getString(2131887273);
    L49:
        if (r6 != ManualOfflineSort.MODIFIED.getRank()) goto L52;
        return r0.getString(2131887274);
    L52:
        if (r6 == ManualOfflineSort.DEFAULT.getRank()) goto L54;
        return "";
    L54:
        return r0.getString(2131887272);
    L56:
        if (SortScene.ShareFileSort != r5) goto L66;
        if (r6 != ShareFileSort.CREATE_TIME.getRank()) goto L61;
        return r0.getString(2131887273);
    L61:
        if (r6 != ShareFileSort.SHARE_TIME.getRank()) goto L64;
        return r0.getString(2131889613);
    L64:
        return r0.getString(2131887274);
    L66:
        if (SortScene.MineSort == r5) goto L68;
        return "";
    L68:
        if (r6 != MineSort.CREATE_TIME.getRank()) goto L71;
        return r0.getString(2131887273);
    L71:
        if (r6 == MineSort.MODIFIED_TIME.getRank()) goto L73;
        return "";
    L73:
        return r0.getString(2131887274);
    L9:
        r8 = 2131889606;
        goto L10
    L5:
        r1 = 2131889596;
        goto L6
    }
}
