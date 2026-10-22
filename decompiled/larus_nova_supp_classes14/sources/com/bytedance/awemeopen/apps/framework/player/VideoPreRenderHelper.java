package com.bytedance.awemeopen.apps.framework.player;

import android.view.Surface;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import com.bytedance.awemeopen.infra.base.player.g;
import com.bytedance.awemeopen.infra.base.player.k;
import com.bytedance.awemeopen.infra.base.player.l;
import com.bytedance.awemeopen.infra.base.player.surface.AbsSurfaceSource;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/player/VideoPreRenderHelper;", "Lcom/bytedance/awemeopen/apps/framework/player/e;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/bytedance/awemeopen/infra/base/player/k;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoPreRenderHelper implements e, ViewPager.OnPageChangeListener, k {
    public final g a;
    public boolean b;
    public final LinkedList<f> c;
    public boolean d;
    public int e;
    public boolean f;
    public int g;
    public int h;

    public static final class a {
    }

    static {
    }

    public final void c(String r1) {
    }

    public final void e(String r1, int r2, String r3) {
    }

    public final void f(String r1, boolean r2, int r3, int r4) {
    }

    public final void h(String r1) {
    }

    public final void onPlayPrepare(String r1) {
    }

    public final void onPlaying(String r1) {
    }

    public final f i() {
        if (this.f == false) goto L6;
        return (f) CollectionsKt.firstOrNull(this.c);
    L6:
        return (f) CollectionsKt.lastOrNull(this.c);
    }

    public VideoPreRenderHelper(g r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        this.a = r2;
        this.c = new LinkedList();
        this.h = -1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.player.e
    public final void a(final f r3) {
        Intrinsics.checkNotNullParameter(r3, "preRenderData");
        AoVideoView r0 = r3.a;
        if ((r0 instanceof AoVideoView) == false) goto L5;
        r0.c(new VideoPreRenderHelper$addPreRenderData$1(r3, this));
    L5:
        int r1 = r3.c;
        if (this.h <= r1) goto L9;
        if (r1 == 0) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L19;
        if (Intrinsics.areEqual(CollectionsKt.firstOrNull(this.c), r3) == true) goto L24;
        this.c.addFirst(r3);
        if (this.c.size() <= 3) goto L24;
        this.c.removeLast();
    L24:
        this.h = r3.c;
        return;
    L19:
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull(this.c), r3) == true) goto L24;
        this.c.addLast(r3);
        if (this.c.size() <= 3) goto L24;
        this.c.removeFirst();
    L9:
        r2 = false;
        goto L11
    }

    public final boolean b(f r5) {
        if (this.b == true) goto L6;
        AoLogger.b("PRERENDER_HELPER", new Object[]{"page is invisible"});
        return false;
    L6:
        if (r5 != null) goto L10;
        AoLogger.b("PRERENDER_HELPER", new Object[]{"preRenderData is null"});
        return false;
    L10:
        if (Intrinsics.areEqual(this.a.g(), r5.b.e) == false) goto L13;
        AoLogger.b("PRERENDER_HELPER", new Object[]{"current video is playing, can not prerender"});
        return false;
    L13:
        return true;
    }

    public final void onPageScrollStateChanged(int r4) {
        this.g = r4;
        if (r4 == 0) goto L5;
        return;
    L5:
        f r5 = i();
        if (b(r5) == true) goto L8;
        return;
    L8:
        Intrinsics.checkNotNull(r5);
        AoVideoView r0 = r5.a;
        Surface r2 = null;
        if ((r0 instanceof AoVideoView) == false) goto L11;
        AoVideoView r1 = r0;
    L12:
        if (r1 == null) goto L16;
        AbsSurfaceSource r3 = r1.getSurfaceSource();
        if (r3 == null) goto L16;
        r2 = r3.b();
    L16:
        this.a.c(r2, r5.b);
        return;
    L11:
        r1 = null;
        goto L12
    }

    public final void onPageSelected(int r1) {
        this.e = r1;
    }

    public final void l(String r1, l r2) {
        Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
    }

    public final void d(String r1, long r2, int r4) {
        f r3 = i();
        if (b(r3) == false) goto L22;
        boolean r5 = true;
        if (this.g == 1) goto L8;
        r5 = false;
    L8:
        if (r5 == false) goto L10;
        return;
    L10:
        if (r4 < 90) goto L24;
        Intrinsics.checkNotNull(r3);
        AoVideoView r6 = r3.a;
        Surface r7 = null;
        if ((r6 instanceof AoVideoView) == false) goto L15;
        AoVideoView r8 = r6;
    L16:
        if (r8 == null) goto L20;
        AbsSurfaceSource r9 = r8.getSurfaceSource();
        if (r9 == null) goto L20;
        r7 = r9.b();
    L20:
        this.a.c(r7, r3.b);
        return;
    L15:
        r8 = null;
        goto L16
    L24:
        return;
    }

    public final void g(String r1, boolean r2, String r3) {
        if (this.g != 1) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return;
    L8:
        this.d = true;
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void onPageScrolled(int r2, float r3, int r4) {
        boolean r5 = true;
        if (this.g == 1) goto L5;
        return;
    L5:
        int r6 = this.e;
        if (r2 != r6) goto L8;
        r5 = false;
    L9:
        this.f = r5;
        f r7 = i();
        if (b(r7) == true) goto L12;
        return;
    L12:
        Intrinsics.checkNotNull(r7);
        AoVideoView r8 = r7.a;
        Surface r0 = null;
        if ((r8 instanceof AoVideoView) == false) goto L15;
        AoVideoView r9 = r8;
    L16:
        if (r9 == null) goto L20;
        AbsSurfaceSource r10 = r9.getSurfaceSource();
        if (r10 == null) goto L20;
        r0 = r10.b();
    L20:
        this.a.c(r0, r7.b);
        return;
    L15:
        r9 = null;
        goto L16
    L8:
        if (r2 < r6) goto L9;
    }
}
