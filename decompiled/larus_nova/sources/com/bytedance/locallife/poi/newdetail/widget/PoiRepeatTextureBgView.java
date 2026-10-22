package com.bytedance.locallife.poi.newdetail.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/PoiRepeatTextureBgView;", "Landroid/view/View;", "Lcom/bytedance/locallife/poi/newdetail/widget/PoiRepeatTextureBgView$a;", "bitmapManager", "", "setManager", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiRepeatTextureBgView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f263333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f263334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f263335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f263336d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f263337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArrayList<b> f263338b;

        public a(Context r100) {
            this.f263338b = new CopyOnWriteArrayList();
        }
    }

    public interface b {
        void a();

        void b();
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiRepeatTextureBgView f263339a;

        @Override // com.bytedance.locallife.poi.newdetail.widget.PoiRepeatTextureBgView.b
        public final void a() {
            a r100 = this.f263339a.f263333a;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNullParameter(this, "callback");
            r100.f263338b.remove(this);
            return;
        }

        @Override // com.bytedance.locallife.poi.newdetail.widget.PoiRepeatTextureBgView.b
        public final void b() {
            a r100 = this.f263339a.f263333a;
            if (r100 == null) goto L5;
            Intrinsics.checkNotNullParameter(this, "callback");
            r100.f263338b.remove(this);
        L5:
            this.f263339a.invalidate();
        }

        public c(PoiRepeatTextureBgView r100) {
            this.f263339a = r100;
        }
    }

    public PoiRepeatTextureBgView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiRepeatTextureBgView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        a r101 = this.f263333a;
        if (r101 == null) goto L12;
        Bitmap r102 = r101.f263337a;
        if (r102 == null) goto L16;
        int r103 = (getWidth() * r102.getHeight()) / r102.getWidth();
        int r104 = getHeight();
    L7:
        if (r104 <= 0) goto L17;
        this.f263335c.set(0, 0, r102.getWidth(), r102.getHeight());
        this.f263336d.set(0, getHeight() - r104, getWidth(), (getHeight() - r104) + r103);
        if (r100 == null) goto L11;
        r100.drawBitmap(r102, this.f263335c, this.f263336d, null);
    L11:
        r104 = r104 - r103;
        goto L7
    L17:
        return;
    L16:
        return;
    }

    public final void setManager(a r100) {
        this.f263333a = r100;
        if (r100 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        setVisibility(0);
        a r101 = this.f263333a;
        if (r101 == null) goto L8;
        Bitmap r102 = r101.f263337a;
    L9:
        if (r102 != null) goto L14;
        if (r101 == null) goto L15;
        c r103 = this.f263334b;
        Intrinsics.checkNotNullParameter(r103, "callback");
        r101.f263338b.add(r103);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public PoiRepeatTextureBgView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263334b = new c(this);
        this.f263335c = new Rect();
        this.f263336d = new Rect();
    }

    public /* synthetic */ PoiRepeatTextureBgView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
