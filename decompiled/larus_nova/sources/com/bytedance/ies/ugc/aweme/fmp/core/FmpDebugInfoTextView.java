package com.bytedance.ies.ugc.aweme.fmp.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import androidx.appcompat.widget.AppCompatTextView;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/ugc/aweme/fmp/core/FmpDebugInfoTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "fmp-core_saasRelease"}, k = 1, mv = {1, 6, 0})
public final class FmpDebugInfoTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f248889f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f248890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<b> f248891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f248892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f248893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<b> f248894e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f248895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f248896b;

        public final String toString() {
            return "PaintInfo(color=" + this.f248895a + ", rect=" + this.f248896b + ')';
        }

        public final int hashCode() {
            return this.f248896b.hashCode();
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == true) goto L5;
            return false;
        L5:
            return Intrinsics.areEqual(((b) r100).f248896b, this.f248896b);
        }

        public b(int r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
            this.f248895a = r100;
            this.f248896b = r101;
        }
    }

    static {
    }

    public FmpDebugInfoTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f248891b = new ArrayList();
        this.f248892c = new ArrayList();
        this.f248894e = new LinkedHashSet();
        new ArrayList();
        Paint r101 = new Paint();
        this.f248893d = r101;
        r101.setColor(FakePickerAvatarCreator.CYAN);
        Paint r102 = this.f248893d;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRectPaint");
        r102 = null;
    L5:
        r102.setStyle(Paint.Style.FILL);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f248890a == false) goto L5;
        String r101 = String.valueOf(SystemClock.elapsedRealtime());
        Paint r102 = new Paint();
        r102.setTextSize(100.0f);
        r102.setColor(FakePickerAvatarCreator.GREEN);
        Unit r103 = Unit.INSTANCE;
        r100.drawText(r101, 100.0f, 200.0f, r102);
        invalidate();
    L5:
        Iterator<T> r104 = this.f248891b.iterator();
    L7:
        if (r104.hasNext() == false) goto L16;
        b r105 = (b) r104.next();
        Paint r106 = this.f248893d;
        Paint r107 = null;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRectPaint");
        r106 = null;
    L11:
        r106.setColor(r105.f248895a);
        Rect r108 = r105.f248896b;
        Paint r109 = this.f248893d;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRectPaint");
    L15:
        r100.drawRect(r108, r107);
        goto L7
    L14:
        r107 = r109;
        goto L15
    L16:
        super.onDraw(r100);
    }
}
