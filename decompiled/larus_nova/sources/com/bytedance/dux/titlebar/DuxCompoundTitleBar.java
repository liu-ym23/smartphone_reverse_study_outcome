package com.bytedance.dux.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.g;
import em4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010 \u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\"\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0013\u0010$\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0013\u0010&\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0013\u0010*\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/bytedance/dux/titlebar/DuxCompoundTitleBar;", "Lcom/bytedance/dux/titlebar/DuxTitleBar;", "", "color", "", "setDividerLineBackground", ce.f26396k, "I", "getMStart0Color", "()I", "setMStart0Color", "(I)V", "mStart0Color", "l", "getMStart1Color", "setMStart1Color", "mStart1Color", "m", "getMEnd0Color", "setMEnd0Color", "mEnd0Color", OfficeSDKRequestTag.KEY_NEW_USER, "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "Landroid/view/ViewGroup;", "getTitleBarContainer", "()Landroid/view/ViewGroup;", "titleBarContainer", "Landroid/widget/ImageView;", "getStartButton0", "()Landroid/widget/ImageView;", "startButton0", "getStartButton1", "startButton1", "getEndButton0", "endButton0", "getEndButton1", "endButton1", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", ItemStyle.ITEM_STYLE_DIVIDER, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxCompoundTitleBar extends DuxTitleBar {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f205780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f205781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f205782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f205783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f205784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f205785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f205786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f205787l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f205788m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f205789n;

    public DuxCompoundTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public DuxCompoundTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DuxCompoundTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView r100 = getStartButton0();
        if (r100 == null) goto L5;
        n.b(r100, g.c(44), g.c(44), false);
    L5:
        ImageView r101 = getStartButton1();
        if (r101 == null) goto L8;
        n.b(r101, g.c(44), g.c(44), false);
    L8:
        ImageView r102 = getEndButton0();
        if (r102 == null) goto L11;
        n.b(r102, g.c(44), g.c(44), false);
    L11:
        ImageView r103 = getEndButton1();
        if (r103 == null) goto L15;
        n.b(r103, g.c(44), g.c(44), false);
        return;
    }

    public final View getDivider() {
        return this.f205785j;
    }

    public final ImageView getEndButton0() {
        return this.f205783h;
    }

    public final ImageView getEndButton1() {
        return this.f205784i;
    }

    public final int getMEnd0Color() {
        return this.f205788m;
    }

    public final int getMEnd1Color() {
        return this.f205789n;
    }

    public final int getMStart0Color() {
        return this.f205786k;
    }

    public final int getMStart1Color() {
        return this.f205787l;
    }

    public final ImageView getStartButton0() {
        return this.f205781f;
    }

    public final ImageView getStartButton1() {
        return this.f205782g;
    }

    public final ViewGroup getTitleBarContainer() {
        return this.f205780e;
    }

    @Override // com.bytedance.dux.titlebar.DuxTitleBar
    public void setDividerLineBackground(int r100) {
        View r101 = this.f205785j;
        if (r101 == null) goto L6;
        r101.setBackgroundColor(r100);
        return;
    }

    public final void setMEnd0Color(int r100) {
        this.f205788m = r100;
    }

    public final void setMEnd1Color(int r100) {
        this.f205789n = r100;
    }

    public final void setMStart0Color(int r100) {
        this.f205786k = r100;
    }

    public final void setMStart1Color(int r100) {
        this.f205787l = r100;
    }

    public DuxCompoundTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        int r104 = 0;
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, null);
        if (this.f205812b == false) goto L11;
        int r105 = R.layout.dux_view_compound_title_bar_new;
    L12:
        FrameLayout.inflate(r100, r105, this);
        this.f205780e = (ViewGroup) findViewById(R.id.title_bar_container);
        this.f205781f = (ImageView) findViewById(R.id.iv_start_0);
        this.f205782g = (ImageView) findViewById(R.id.iv_start_1);
        this.f205783h = (ImageView) findViewById(R.id.iv_end_0);
        this.f205784i = (ImageView) findViewById(R.id.iv_end_1);
        this.f205811a = (TextView) findViewById(R.id.title);
        this.f205785j = findViewById(R.id.line);
        b(new View[]{this.f205781f, this.f205782g, this.f205783h, this.f205784i});
        c(new TextView[]{this.f205811a});
        if (r101 == null) goto L27;
        TypedArray r106 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.adaptLargeFontMode, R.attr.centerText, R.attr.centerTextColor, R.attr.centerTextSize, R.attr.dividerColor, R.attr.dividerVisible}, 0, 0);
        setTitle(r106.getString(1));     // Catch: Throwable -> L24
        setTitleColor(r106.getColor(2, ContextCompat.getColor(getContext(), R.color.TextPrimary)));     // Catch: Throwable -> L24
        setTitleSizePixel(r106.getDimension(3, a(17)));     // Catch: Throwable -> L24
        int r107 = r106.getColor(4, ContextCompat.getColor(getContext(), R.color.LinePrimary));     // Catch: Throwable -> L24
        boolean r108 = r106.getBoolean(5, false);     // Catch: Throwable -> L24
        View r109 = this.f205785j;     // Catch: Throwable -> L24
        if (r109 == null) goto L22;
        if (r108 == true) goto L21;
        r104 = 8;
    L21:
        r109.setVisibility(r104);     // Catch: Throwable -> L24
    L22:
        setDividerLineBackground(r107);     // Catch: Throwable -> L24
        r106.recycle();
        return;
    L24:
        th = move-exception;
        r106.recycle();
        throw th;
    L27:
        return;
    L11:
        r105 = R.layout.dux_view_compound_title_bar;
        goto L12
    }
}
