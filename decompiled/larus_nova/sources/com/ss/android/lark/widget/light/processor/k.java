package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.view.View;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.span.ImageGalleryInfo;
import com.ss.android.lark.widget.span.ImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements com.ss.android.lark.widget.light.viewstub.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageGalleryInfo f446181a;

    public static final class a implements com.ss.android.lark.widget.light.image.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f446182a;

        public a(View r100) {
            this.f446182a = r100;
        }

        @Override // com.ss.android.lark.widget.light.image.a.c
        public final void a(LKUIRoundedImageView2 r100, com.ss.android.lark.widget.light.image.a.b r101) {
            Intrinsics.checkNotNullParameter(r100, "imageView");
            Intrinsics.checkNotNullParameter(r101, "data");
            Object r102 = this.f446182a.getTag(R.id.tag_span_container_view);
            if ((r102 instanceof LKUILightTextView) == false) goto L5;
            LKUILightTextView r103 = (LKUILightTextView) r102;
        L6:
            int[] r104 = new int[2];
            r100.getLocationOnScreen(r104);
            if (r103 == null) goto L10;
            mcc.p r105 = new mcc.p();
            r105.f513260f = r104[0];
            r105.f513261g = r104[1];
            r105.f513258d = r100.getWidth();
            r105.f513259e = r100.getHeight();
            r105.f513257c = r101.f446082a;
            r105.f513262h = r100.getDrawable();
            Unit r106 = Unit.INSTANCE;
            r103.j(r103, r105);
            return;
        L10:
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.ss.android.lark.widget.light.image.a.c
        public final boolean b(LKUIRoundedImageView2 r100, com.ss.android.lark.widget.light.image.a.b r101) {
            Intrinsics.checkNotNullParameter(r100, "imageView");
            Intrinsics.checkNotNullParameter(r101, "data");
            Object r102 = this.f446182a.getTag(R.id.tag_span_container_view);
            if ((r102 instanceof LKUILightTextView) == false) goto L5;
            LKUILightTextView r103 = (LKUILightTextView) r102;
        L6:
            if (r103 != null) goto L8;
        L10:
            return false;
        L8:
            if (r103.performLongClick() != true) goto L10;
            return true;
        L5:
            r103 = null;
            goto L6
        }
    }

    public k(ImageGalleryInfo r100) {
        this.f446181a = r100;
    }

    @Override // com.ss.android.lark.widget.light.viewstub.h
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.ss.android.lark.widget.light.image.a r101 = (com.ss.android.lark.widget.light.image.a) r100;
        ArrayList<ImageInfo> r102 = this.f446181a.getImageInfo();
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ImageInfo r105 = (ImageInfo) r104.next();
        r103.add(new com.ss.android.lark.widget.light.image.a.b(r105.token, r105.width, r105.height, r105.text));
        goto L4
    L6:
        r101.setData(r103);
        r101.setOnItemViewClickListener(new a(r100));
    }

    @Override // com.ss.android.lark.widget.light.viewstub.h
    public final View b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new com.ss.android.lark.widget.light.image.a(r100);
    }
}
