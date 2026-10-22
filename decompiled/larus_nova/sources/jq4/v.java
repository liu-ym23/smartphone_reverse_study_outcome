package jq4;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.record.a f500062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f500063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f500064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f500065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f500066e;

    public v(com.bytedance.ee.bear.bitable.card.view.record.a r100, RecyclerView r101, int r102, int r103, int r104) {
        this.f500062a = r100;
        this.f500063b = r101;
        this.f500064c = r102;
        this.f500065d = r103;
        this.f500066e = r104;
    }

    public final void a() {
        com.bytedance.ee.bear.bitable.card.view.record.a r100 = this.f500062a;
        RecyclerView r101 = this.f500063b;
        int r102 = this.f500064c;
        int r103 = this.f500065d;
        int r104 = this.f500066e;
        r100.getClass();
        int[] r105 = new int[2];
        WindowManager r106 = (WindowManager) r101.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r107 = new DisplayMetrics();
        r106.getDefaultDisplay().getRealMetrics(r107);
        int r108 = r107.heightPixels;
        r101.getLocationOnScreen(r105);
        int r109 = r105[1];
        int r110 = r108 - r102;
        tt5.a.b("STFocusCellVisibleUpdater", "viewTop:" + r103 + ", listTop:" + r109 + ", viewBottom:" + r104 + ", panelTop:" + r110);
        if (r103 < r109) goto L6;
        if (r104 > r110) goto L6;
        tt5.a.b("STFocusCellVisibleUpdater", "no scroll");
        return;
    L6:
        View r111 = r101.getRootView();
        if (r111 == null) goto L13;
        View r112 = r111.findViewById(R.id.cover_view_pager_wrapper);
        if (r112 == null) goto L13;
        if (r112.getLayoutParams().height <= 0) goto L13;
        boolean r113 = true;
    L14:
        tt5.a.h("STFocusCellVisibleUpdater", "bringViewVisible hasBigCollapsingSpace " + r113);
        if (r113 == true) goto L17;
    L19:
        if (r104 <= r110) goto L27;
        tt5.a.b("STFocusCellVisibleUpdater", "scroll to bottom visible");
        if (r100.f208665f == false) goto L24;
        if (r113 == false) goto L24;
        r101.smoothScrollBy(0, r104 - r110);
        return;
    L24:
        if (r110 <= r109) goto L26;
        r101.smoothScrollBy(0, r104 - r110);
        return;
    L26:
        r101.smoothScrollBy(0, RangesKt.coerceAtLeast(r103 - r109, 0));
        return;
    L27:
        tt5.a.b("STFocusCellVisibleUpdater", "other case");
        r101.smoothScrollBy(0, -Math.min(Math.abs(r109 - r103), Math.abs(r110 - r104)));
        return;
    L17:
        if (r100.f208665f == false) goto L19;
        r101.startNestedScroll(2, 1);
    L13:
        r113 = false;
        goto L14
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
