package com.bytedance.bdp.bdpplatform.service.ui.loading;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ib4.a;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u001d\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eB%\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/bdp/bdpplatform/service/ui/loading/LoadingView;", "Landroid/widget/LinearLayout;", "Lib4/a;", "Landroid/view/View;", "getView", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setLoadingSrc", "", "size", "setLoadingSrcSize", "(Ljava/lang/Float;)V", "space", "setSpaceBetween", "setLoadingViewBackground", "", "msg", "setLoadingText", "", "colorInt", "setLoadingTextColor", "(Ljava/lang/Integer;)V", "setLoadingTextSize", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bdp-service_release"}, k = 1, mv = {1, 4, 0})
public final class LoadingView extends LinearLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f201423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProgressBar f201424b;

    public View getView() {
        return this;
    }

    public LoadingView(Context r100) {
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.bdp_loading_layout, this, true);
        this.f201423a = (TextView) findViewById(R.id.vTvLoadingText);
        this.f201424b = (ProgressBar) findViewById(R.id.vPbLoading);
    }

    public void setLoadingSrc(Drawable r100) {
        this.f201424b.setIndeterminateDrawable(r100);
    }

    public void setLoadingSrcSize(Float r100) {
        if (r100 == null) goto L9;
        r100.floatValue();
        int r101 = MathKt.roundToInt(r100.floatValue());
        ViewGroup.LayoutParams r102 = this.f201424b.getLayoutParams();
        ProgressBar r103 = this.f201424b;
        if (r102 != null) goto L6;
        r102 = new LinearLayout.LayoutParams(r101, r101);
    L7:
        r103.setLayoutParams(r102);
        return;
    L6:
        r102.width = r101;
        r102.height = r101;
        goto L7
    }

    public void setLoadingText(String r100) {
        this.f201423a.setText(r100);
    }

    public void setLoadingTextColor(Integer r100) {
        if (r100 == null) goto L5;
        r100.intValue();
        this.f201423a.setTextColor(r100.intValue());
        return;
    }

    public void setLoadingTextSize(Float r100) {
        if (r100 == null) goto L5;
        r100.floatValue();
        this.f201423a.setTextSize(r100.floatValue());
        return;
    }

    public void setLoadingViewBackground(Drawable r100) {
        setBackground(r100);
    }

    public void setSpaceBetween(Float r100) {
        ViewGroup.LayoutParams r101 = this.f201423a.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r100 == null) goto L7;
        int r103 = MathKt.roundToInt(r100.floatValue());
    L8:
        r102.topMargin = r103;
        return;
    L7:
        r103 = 0;
        goto L8
    }

    public LoadingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.bdp_loading_layout, this, true);
        this.f201423a = (TextView) findViewById(R.id.vTvLoadingText);
        this.f201424b = (ProgressBar) findViewById(R.id.vPbLoading);
    }

    public LoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.bdp_loading_layout, this, true);
        this.f201423a = (TextView) findViewById(R.id.vTvLoadingText);
        this.f201424b = (ProgressBar) findViewById(R.id.vPbLoading);
    }
}
