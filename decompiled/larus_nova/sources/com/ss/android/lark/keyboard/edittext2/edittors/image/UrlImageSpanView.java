package com.ss.android.lark.keyboard.edittext2.edittors.image;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class UrlImageSpanView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f429060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f429061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f429062c;

    public static final class a {
    }

    static {
    }

    private final ImageView getImageView() {
        return (ImageView) this.f429061b.getValue();
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        Log.d("UrlImageSpanView", "requestLayout: requestLayout called");
    }

    public final int getFixSize() {
        return this.f429060a;
    }

    public static final /* synthetic */ ImageView a(UrlImageSpanView r100) {
        return r100.getImageView();
    }

    public final void setFixSize(int r100) {
        this.f429060a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UrlImageSpanView(final Context r110, com.ss.android.lark.widget.span.b.AbstractC5432b<?> r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "loadInfo");
        super(r110);
        this.f429060a = -1;
        this.f429061b = LazyKt.lazy(new UrlImageSpanView$imageView$2(r110, this));
        Resources r112 = getResources();
        int r100 = (int) (((double) WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).widthPixels) * 0.4d);
        Resources r113 = getResources();
        int r101 = (int) (((double) WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics()).heightPixels) * 0.4d);
        Context r114 = getContext();
        if ((r114 instanceof Activity) == true) goto L5;
    L7:
        boolean r102 = true;
        if ((r111 instanceof com.ss.android.lark.widget.span.b.AbstractC5432b.a) == false) goto L10;
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        r103.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(VFSFiles.f444819b.i((String) ((com.ss.android.lark.widget.span.b.AbstractC5432b.a) r111).f448642d).getPath(), r103);
        Pair r104 = new Pair(Integer.valueOf(r103.outWidth), Integer.valueOf(r103.outHeight));
    L20:
        int[] r105 = ImageUtils.g(((Number) r104.component1()).intValue(), ((Number) r104.component2()).intValue(), r100, r101, 80, 80);
        Intrinsics.checkNotNull(r105);
        int r106 = r105[0];
        int r107 = r105[1];
        IRequestCreator r115 = ImageLoader.with(r114).load(r111.f448642d).asBitmap();
        c r116 = new c(this);
        int r108 = this.f429060a;
        if (1 > r108) goto L24;
        if (r108 >= r107) goto L24;
    L25:
        if (r102 == false) goto L27;
        r115.override(r108, r108).centerCrop().into(r116);
    L28:
        Paint r117 = new Paint();
        r117.setColor(UIHelper.getColor(R.color.static_white));
        r117.setStyle(Paint.Style.FILL);
        this.f429062c = r117;
        return;
    L27:
        r115.override(r106, r107).into(r116);
    L24:
        r102 = false;
        goto L25
    L10:
        int r109 = Integer.MAX_VALUE;
        if ((r111 instanceof com.ss.android.lark.widget.span.b.AbstractC5432b.C5433b) == false) goto L19;
        com.ss.android.lark.widget.span.b.AbstractC5432b.C5433b r118 = (com.ss.android.lark.widget.span.b.AbstractC5432b.C5433b) r111;
        int r119 = r118.f448640b;
        int r120 = r118.f448641c;
        if (r119 != 0) goto L15;
        r119 = Integer.MAX_VALUE;
    L15:
        if (r120 == 0) goto L18;
        r109 = r120;
    L18:
        r104 = TuplesKt.to(Integer.valueOf(r119), Integer.valueOf(r109));
        goto L20
    L19:
        r104 = TuplesKt.to(Integer.MAX_VALUE, Integer.MAX_VALUE);
        goto L20
    L5:
        if (UIUtils.isActivityRunning((Activity) r114) == true) goto L7;
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        Log.d("UrlImageSpanView", "measureView: measured size is " + getMeasuredWidth() + Permission.EXECUTE + getMeasuredHeight() + ", widthMeasureSpec is " + r100 + ", heightMeasureSpec is " + r101);
    }
}
