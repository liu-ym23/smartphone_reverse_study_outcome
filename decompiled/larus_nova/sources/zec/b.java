package zec;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class b extends LinearLayout implements vec.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wec.a f571588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f571589b;

    public void a() {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public abstract /* synthetic */ int getCellViewHeight();

    public abstract /* synthetic */ void setTypeFace(Typeface r100);

    public final int getLayoutResource() {
        return this.f571589b;
    }

    public final wec.a getMDay() {
        return this.f571588a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setupLayoutResource(R.layout.calendar_list_day_view);
        this.f571589b = R.layout.calendar_list_day_view;
    }

    private final void setupLayoutResource(int r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(r100, this);
        r101.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r101.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public final void setLayoutResource(int r100) {
        this.f571589b = r100;
    }

    public final void setMDay(wec.a r100) {
        this.f571588a = r100;
    }
}
