package com.obric.oui.titlebar;

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
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "请使用 OCTitleBar")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\"\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0013\u0010$\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b#\u0010\u001b¨\u0006,"}, d2 = {"Lcom/obric/oui/titlebar/OContainerTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "", "color", "", "setDividerLineBackground", ce.f26391f, "I", "getMStart0Color", "()I", "setMStart0Color", "(I)V", "mStart0Color", "h", "getMStart1Color", "setMStart1Color", "mStart1Color", RXScreenCaptureService.KEY_INDEX, "getMEnd0Color", "setMEnd0Color", "mEnd0Color", ce.f26395j, "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "Landroid/widget/ImageView;", "getStartButton0", "()Landroid/widget/ImageView;", "startButton0", "getStartButton1", "startButton1", "Landroid/widget/FrameLayout;", "getEndContainer", "()Landroid/widget/FrameLayout;", "endContainer", "getEndButton", "endButton", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OContainerTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f403391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f403392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f403393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f403394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f403395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f403396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f403397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f403398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f403399j;

    public OContainerTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OContainerTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ImageView getEndButton() {
        return this.f403394e;
    }

    public final FrameLayout getEndContainer() {
        return this.f403393d;
    }

    public final int getMEnd0Color() {
        return this.f403398i;
    }

    public final int getMEnd1Color() {
        return this.f403399j;
    }

    public final int getMStart0Color() {
        return this.f403396g;
    }

    public final int getMStart1Color() {
        return this.f403397h;
    }

    public final ImageView getStartButton0() {
        return this.f403391b;
    }

    public final ImageView getStartButton1() {
        return this.f403392c;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r100) {
        View r101 = this.f403395f;
        if (r101 == null) goto L7;
        r101.setBackgroundColor(r100);
        return;
    }

    public final void setMEnd0Color(int r100) {
        this.f403398i = r100;
    }

    public final void setMEnd1Color(int r100) {
        this.f403399j = r100;
    }

    public final void setMStart0Color(int r100) {
        this.f403396g = r100;
    }

    public final void setMStart1Color(int r100) {
        this.f403397h = r100;
    }

    public OContainerTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.o_view_container_title_bar, this);
        this.f403391b = (ImageView) findViewById(R.id.iv_start_0);
        this.f403392c = (ImageView) findViewById(R.id.iv_start_1);
        this.f403393d = (FrameLayout) findViewById(R.id.end_container);
        this.f403394e = (ImageView) findViewById(R.id.iv_end_1);
        this.f403462a = (TextView) findViewById(R.id.title);
        this.f403395f = findViewById(R.id.line);
        if (r101 == null) goto L17;
        int r103 = 0;
        TypedArray r104 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_centerText, R.attr.oui_centerTextColor, R.attr.oui_centerTextSize, R.attr.oui_dividerColor, R.attr.oui_dividerVisible}, 0, 0);
        setTitle(r104.getString(0));     // Catch: Throwable -> L14
        setTitleColor(r104.getColor(1, ContextCompat.getColor(getContext(), R.color.TextPrimary)));     // Catch: Throwable -> L14
        setTitleSizePixel(r104.getDimension(2, pla.d.g(17)));     // Catch: Throwable -> L14
        int r105 = r104.getColor(3, ContextCompat.getColor(getContext(), R.color.LinePrimary));     // Catch: Throwable -> L14
        boolean r106 = r104.getBoolean(4, false);     // Catch: Throwable -> L14
        View r107 = this.f403395f;     // Catch: Throwable -> L14
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

    public /* synthetic */ OContainerTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
