package com.bytedance.android.shopping.utils.gallery;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.gallery2.GalleryViewer;
import com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryViewerPlayerBlockCompat;
import com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    public k() {
    }

    static {
    }

    public static void a(Context r9, List r10, List r11, List r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "videos");
        Intrinsics.checkNotNullParameter(r11, "images");
        Intrinsics.checkNotNullParameter(r12, "titlesList");
        ArrayList r0 = new ArrayList();
        r0.addAll(r11);
        List r2 = r10;
        if ((r11.size() + (!r2.isEmpty() ? 1 : 0)) != 0) goto L5;
        return;
    L5:
        String r4 = "";
        if ((!r2.isEmpty()) == false) goto L11;
        fj.d r1 = (fj.d) ListProtector.get(r10, 0);
        VideoHolder r6 = new VideoHolder(r9, false, false, 30);
        ECUrlModel r7 = new ECUrlModel();
        String r8 = r1.g;
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        r7.setUrlList(CollectionsKt.listOf(r8));
        Unit r15 = Unit.INSTANCE;
        r6.f(r1, r7, ECGalleryServiceUtil$startGalleryService$videoHolder$1$2.INSTANCE);
        r6.b();
    L13:
        if ((r9 instanceof FragmentActivity) == false) goto L15;
        ((FragmentActivity) r9).getLifecycle().addObserver(new VideoPlayListener(r6));
    L15:
        if (r14 == true) goto L27;
        if ((!r2.isEmpty()) == false) goto L27;
        if ((!r11.isEmpty()) == false) goto L21;
        ListProtector.add(r0, 0, ListProtector.get(r11, 0));
        goto L27
    L21:
        String r16 = ((fj.d) ListProtector.get(r10, 0)).g;
        if (r16 == null) goto L25;
        r4 = r16;
    L25:
        ListProtector.add(r0, 0, r4);
    L27:
        if ((r6 instanceof ee3.c) == false) goto L29;
        VideoHolder r17 = r6;
    L30:
        GalleryViewerPlayerBlockCompat r18 = new GalleryViewerPlayerBlockCompat(r9);
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r3 = r0.iterator();
    L32:
        if (r3.hasNext() == false) goto L34;
        String r5 = (String) r3.next();
        com.bytedance.android.ec.model.k r20 = new com.bytedance.android.ec.model.k();
        r20.b = r5;
        r19.add(r20);
        goto L32
    L34:
        r18.a(r19, r14);
        if (r14 == false) goto L40;
        ee3.f r21 = r18.d;
        FrameLayout r110 = r21.c;
        if (r110 != null) goto L39;
        r21.f = 8;
        goto L40
    L39:
        r110.setVisibility(8);
    L40:
        r18.setOnDismissListener(new i(r0, r6, r12));
        r18.setOnPageSelectedListener(new j());
        r18.b(r17);
        ((GalleryViewer) r18).b.setData(r12);
        PhotoViewerDialog.showAnimated$default(r18, r13, null, 2, null);
        return;
    L29:
        r17 = null;
        goto L30
    L11:
        r6 = null;
        goto L13
    }
}
