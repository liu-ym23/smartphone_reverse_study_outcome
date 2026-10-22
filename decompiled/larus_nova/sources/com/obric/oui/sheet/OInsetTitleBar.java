package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.amap.api.col.s.ce;
import com.larus.nova.R;
import com.obric.oui.titlebar.OTitleBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR(\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR(\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#¨\u00068"}, d2 = {"Lcom/obric/oui/sheet/OInsetTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "", "color", "", "setDividerLineBackground", "Landroid/widget/ImageView;", "<set-?>", "b", "Landroid/widget/ImageView;", "getStartButton0", "()Landroid/widget/ImageView;", "startButton0", "c", "getStartButton1", "startButton1", "d", "getEndButton1", "endButton1", "e", "getEndButton0", "endButton0", "Landroid/widget/FrameLayout;", ce.f26391f, "Landroid/widget/FrameLayout;", "getMRightAction", "()Landroid/widget/FrameLayout;", "setMRightAction", "(Landroid/widget/FrameLayout;)V", "mRightAction", "h", "I", "getMStart0Color", "()I", "setMStart0Color", "(I)V", "mStart0Color", RXScreenCaptureService.KEY_INDEX, "getMStart1Color", "setMStart1Color", "mStart1Color", ce.f26395j, "getMEnd0Color", "setMEnd0Color", "mEnd0Color", ce.f26396k, "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OInsetTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f402859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f402860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f402861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f402862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f402863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f402864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f402865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f402866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f402867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f402868k;

    public OInsetTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OInsetTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final FrameLayout getMRightAction() {
        FrameLayout r100 = this.f402864g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightAction");
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView r100 = this.f402859b;
        if (r100 == null) goto L6;
        j.b(r100, pla.d.g(40), pla.d.g(44), false);
    L6:
        ImageView r101 = this.f402860c;
        if (r101 == null) goto L10;
        j.b(r101, pla.d.g(40), pla.d.g(44), false);
    L10:
        ImageView r102 = this.f402862e;
        if (r102 == null) goto L14;
        j.b(r102, pla.d.g(40), pla.d.g(44), false);
    L14:
        ImageView r103 = this.f402861d;
        if (r103 == null) goto L19;
        j.b(r103, pla.d.g(40), pla.d.g(44), false);
        return;
    }

    public final ImageView getEndButton0() {
        return this.f402862e;
    }

    public final ImageView getEndButton1() {
        return this.f402861d;
    }

    public final int getMEnd0Color() {
        return this.f402867j;
    }

    public final int getMEnd1Color() {
        return this.f402868k;
    }

    public final int getMStart0Color() {
        return this.f402865h;
    }

    public final int getMStart1Color() {
        return this.f402866i;
    }

    public final ImageView getStartButton0() {
        return this.f402859b;
    }

    public final ImageView getStartButton1() {
        return this.f402860c;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r100) {
        View r101 = this.f402863f;
        if (r101 == null) goto L7;
        r101.setBackgroundColor(r100);
        return;
    }

    public final void setMEnd0Color(int r100) {
        this.f402867j = r100;
    }

    public final void setMEnd1Color(int r100) {
        this.f402868k = r100;
    }

    public final void setMRightAction(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402864g = r100;
    }

    public final void setMStart0Color(int r100) {
        this.f402865h = r100;
    }

    public final void setMStart1Color(int r100) {
        this.f402866i = r100;
    }

    public OInsetTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.o_view_inset_title_bar, this);
        this.f402859b = (ImageView) findViewById(R.id.iv_start_0);
        this.f402860c = (ImageView) findViewById(R.id.iv_start_1);
        this.f402862e = (ImageView) findViewById(R.id.iv_end_0);
        this.f402861d = (ImageView) findViewById(R.id.iv_end_1);
        this.f403462a = (TextView) findViewById(R.id.title);
        setMRightAction((FrameLayout) findViewById(R.id.fl_right_container));
        this.f402863f = findViewById(R.id.line);
        if (r101 == null) goto L17;
        int r103 = 0;
        TypedArray r104 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_centerText, R.attr.oui_centerTextColor, R.attr.oui_centerTextSize, R.attr.oui_dividerColor, R.attr.oui_dividerVisible}, 0, 0);
        setTitle(r104.getString(0));     // Catch: Throwable -> L14
        setTitleColor(r104.getColor(1, ContextCompat.getColor(getContext(), R.color.TextPrimary)));     // Catch: Throwable -> L14
        setTitleSizePixel(r104.getDimension(2, pla.d.g(17)));     // Catch: Throwable -> L14
        int r105 = r104.getColor(3, ContextCompat.getColor(getContext(), R.color.LinePrimary));     // Catch: Throwable -> L14
        boolean r106 = r104.getBoolean(4, false);     // Catch: Throwable -> L14
        View r107 = this.f402863f;     // Catch: Throwable -> L14
        if (r107 == null) goto L12;
        if (r106 == true) goto L11;
        r103 = 8;
    L11:
        r107.setVisibility(r103);     // Catch: Throwable -> L14
    L12:
        setDividerLineBackground(r105);     // Catch: Throwable -> L14
        r104.recycle();
        return;
    L14:
        th = move-exception;
        r104.recycle();
        throw th;
    }

    public /* synthetic */ OInsetTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
