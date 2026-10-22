package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.Iterator;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingContentController f436332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f436333b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmRecordingContentController f436334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f436335b;

        public a(MmRecordingContentController r100, String r101) {
            this.f436334a = r100;
            this.f436335b = r101;
        }

        public final void a() {
            if (this.f436334a.f436299a.b().isAttachedToWindow() == true) goto L6;
            this.f436334a.f436309k = false;
            int r100 = bwb.b.f21271a;
            bwb.b.f(MmUiLogScene.CONTENT, "scheduleRelayoutFix", "skip detached pager(second post), reason=" + this.f436335b, this.f436334a.c());
            return;
        L6:
            MmRecordingContentController r101 = this.f436334a;
            r101.f436309k = false;
            String r102 = this.f436335b;
            if (r101.f436308j == false) goto L68;
            ViewPager2 r103 = r101.f436299a.b();
            if (r103.getScrollState() == 0) goto L13;
            int r104 = bwb.b.f21271a;
            bwb.b.f(MmUiLogScene.CONTENT, "tryFixPagerMisalignment", "skip non-idle, reason=" + r102 + ", state=" + r103.getScrollState(), r101.c());
            return;
        L13:
            if (r103.getWidth() > 0) goto L15;
        L58:
            int r105 = bwb.b.f21271a;
            bwb.b.f(MmUiLogScene.CONTENT, "tryFixPagerMisalignment", "skip invalid size, reason=" + r102 + ", width=" + r103.getWidth() + ", height=" + r103.getHeight(), r101.c());
            r101.f436308j = false;
            return;
        L15:
            if (r103.getHeight() <= 0) goto L58;
            View r106 = r103.getChildAt(0);
            Integer r107 = null;
            if ((r106 instanceof RecyclerView) == false) goto L20;
            RecyclerView r108 = (RecyclerView) r106;
        L21:
            if (r108 != null) goto L23;
            int r109 = bwb.b.f21271a;
            bwb.b.h(MmUiLogScene.CONTENT, "tryFixPagerMisalignment", "skip recyclerView null, reason=" + r102, r101.c());
            r101.f436308j = false;
            return;
        L23:
            int r110 = r103.getCurrentItem();
            RecyclerView.ViewHolder r111 = r108.findViewHolderForAdapterPosition(r110);
            if (r111 == null) goto L28;
            View r112 = r111.itemView;
            if (r112 == null) goto L28;
            r107 = Integer.valueOf(r112.getLeft());
        L28:
            int r113 = r108.getPaddingLeft();
            int r114 = r108.getWidth() - r108.getPaddingRight();
            Iterator<View> r115 = ViewGroupKt.getChildren(r108).iterator();
        L30:
            if (r115.hasNext() == false) goto L47;
            View r116 = r115.next();
            RecyclerView.ViewHolder r117 = r108.getChildViewHolder(r116);
            if (r117.getBindingAdapterPosition() != (-1)) goto L34;
        L44:
            boolean r118 = false;
        L45:
            if (r118 == false) goto L30;
            boolean r119 = true;
        L48:
            if (r107 != null) goto L50;
        L51:
            if (r119 == false) goto L53;
        L52:
            boolean r120 = true;
        L54:
            int r121 = bwb.b.f21271a;
            bwb.b.f(MmUiLogScene.CONTENT, "tryFixPagerMisalignment", "reason=" + r102 + ", currentItem=" + r110 + ", currentLeft=" + r107 + ", hasAdjacentVisiblePage=" + r119 + ", isMisaligned=" + r120, r101.c());
            r101.f436308j = false;
            if (r120 == false) goto L69;
            r103.setCurrentItem(r110, false);
            return;
        L69:
            return;
        L53:
            r120 = false;
            goto L54
        L50:
            if (r107.intValue() != 0) goto L52;
        L34:
            if (r117.getBindingAdapterPosition() == r110) goto L44;
            if (r116.getVisibility() != 0) goto L44;
            if (r116.getWidth() <= 0) goto L44;
            if (r116.getRight() <= r113) goto L44;
            if (r116.getLeft() >= r114) goto L44;
            r118 = true;
            goto L45
        L47:
            r119 = false;
            goto L48
        L20:
            r108 = null;
            goto L21
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public e(MmRecordingContentController r100, String r101) {
        this.f436332a = r100;
        this.f436333b = r101;
    }

    public final void a() {
        if (this.f436332a.f436299a.b().isAttachedToWindow() == true) goto L6;
        this.f436332a.f436309k = false;
        int r100 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.CONTENT, "scheduleRelayoutFix", "skip detached pager(first post), reason=" + this.f436333b, this.f436332a.c());
        return;
    L6:
        this.f436332a.f436299a.b().post(new a(this.f436332a, this.f436333b));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
