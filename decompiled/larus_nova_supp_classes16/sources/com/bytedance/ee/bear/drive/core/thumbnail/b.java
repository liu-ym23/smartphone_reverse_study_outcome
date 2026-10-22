package com.bytedance.ee.bear.drive.core.thumbnail;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final /* synthetic */ int j = 0;
    public final RecyclerView a;
    public final ViewPager b;
    public final List<f> c;
    public final ThumbnailTrackerLayoutManager d;
    public final DrivePreviewThumbnailAdapter e;
    public final HorizontalSpaceItemDecoration f;
    public final int g;
    public final DrivePreviewThumbnailController$pageChangeListener$1 h;
    public Runnable i;

    public static final class a {
    }

    static {
    }

    public final void a(int r2, boolean r3) {
        if (r2 >= 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == true) goto L10;
        tt5.a.k("DrivePreviewThumbnailController", "updateSelectedPosition invalid position=" + r2 + " itemCount=" + ((ArrayList) this.c).size());
        return;
    L10:
        ThumbnailTrackerLayoutManager r1 = this.d;
        r1.b = r2;
        r1.c = r2;
        if (r3 == false) goto L13;
        this.a.smoothScrollToPosition(r2);
        return;
    L13:
        this.a.scrollToPosition(r2);
        return;
    L4:
        if (r2 >= ((ArrayList) this.c).size()) goto L6;
        r0 = true;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.ee.bear.drive.core.thumbnail.DrivePreviewThumbnailController$pageChangeListener$1] */
    public b(GalleryThumbnailView r5, ViewPager r6, List r7) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        Intrinsics.checkNotNullParameter(r6, "viewPager");
        Intrinsics.checkNotNullParameter(r7, "openEntities");
        this.a = r5;
        this.b = r6;
        List r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r0 = r10.next();
        int r1 = r11 + 1;
        if (r11 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        BaseOpenEntity r2 = (BaseOpenEntity) r0;
        com.bytedance.ee.bear.drive.core.fragment.j.a.getClass();
        r9.add(new f(r2, r11, com.bytedance.ee.bear.drive.core.fragment.j.d(r2)));
        r11 = r1;
        goto L4
    L9:
        this.c = r9;
        this.d = new ThumbnailTrackerLayoutManager(this.a.getContext());
        this.e = new DrivePreviewThumbnailAdapter(r9, new DrivePreviewThumbnailController$adapter$1(this));
        this.f = new HorizontalSpaceItemDecoration(this.a.getContext().getResources().getDimensionPixelSize(2131166322));
        this.g = this.a.getContext().getResources().getDimensionPixelSize(2131166323);
        this.h = new DrivePreviewThumbnailController$pageChangeListener$1(this);
    }
}
