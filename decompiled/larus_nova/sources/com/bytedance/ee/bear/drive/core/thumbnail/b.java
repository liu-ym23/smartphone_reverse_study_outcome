package com.bytedance.ee.bear.drive.core.thumbnail;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f224357j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f224358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager f224359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f> f224360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThumbnailTrackerLayoutManager f224361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DrivePreviewThumbnailAdapter f224362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HorizontalSpaceItemDecoration f224363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f224364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DrivePreviewThumbnailController$pageChangeListener$1 f224365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f224366i;

    public static final class a {
    }

    static {
    }

    public final void a(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r102 = false;
    L7:
        if (r102 == true) goto L10;
        tt5.a.k("DrivePreviewThumbnailController", "updateSelectedPosition invalid position=" + r100 + " itemCount=" + ((ArrayList) this.f224360c).size());
        return;
    L10:
        ThumbnailTrackerLayoutManager r103 = this.f224361d;
        r103.f224330b = r100;
        r103.f224331c = r100;
        if (r101 == false) goto L13;
        this.f224358a.smoothScrollToPosition(r100);
        return;
    L13:
        this.f224358a.scrollToPosition(r100);
        return;
    L4:
        if (r100 >= ((ArrayList) this.f224360c).size()) goto L6;
        r102 = true;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.bytedance.ee.bear.drive.core.thumbnail.DrivePreviewThumbnailController$pageChangeListener$1] */
    public b(GalleryThumbnailView r100, ViewPager r101, List r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewPager");
        Intrinsics.checkNotNullParameter(r102, "openEntities");
        this.f224358a = r100;
        this.f224359b = r101;
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
        int r106 = 0;
    L4:
        if (r105.hasNext() == false) goto L9;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        BaseOpenEntity r109 = (BaseOpenEntity) r107;
        com.bytedance.ee.bear.drive.core.fragment.j.f224217a.getClass();
        r104.add(new f(r109, r106, com.bytedance.ee.bear.drive.core.fragment.j.d(r109)));
        r106 = r108;
        goto L4
    L9:
        this.f224360c = r104;
        this.f224361d = new ThumbnailTrackerLayoutManager(this.f224358a.getContext());
        this.f224362e = new DrivePreviewThumbnailAdapter(r104, new DrivePreviewThumbnailController$adapter$1(this));
        this.f224363f = new HorizontalSpaceItemDecoration(this.f224358a.getContext().getResources().getDimensionPixelSize(R.dimen.drive_preview_thumbnail_item_spacing));
        this.f224364g = this.f224358a.getContext().getResources().getDimensionPixelSize(R.dimen.drive_preview_thumbnail_item_translation);
        this.f224365h = new DrivePreviewThumbnailController$pageChangeListener$1(this);
    }
}
