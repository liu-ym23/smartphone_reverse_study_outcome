package com.larus.camera.impl.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\r\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J*\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\b\u0010$\u001a\u00020\u0018H\u0002J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0002J \u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\rH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011¨\u0006-"}, d2 = {"Lcom/larus/camera/impl/widget/LinearGradientAutoFitTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startColor", "endColor", "minTextSize", "", "maxTextSize", "textSize15", "getTextSize15", "()F", "textSize15$delegate", "Lkotlin/Lazy;", "textSize14", "getTextSize14", "textSize14$delegate", "init", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "adjustTextSize", "applyGradient", "width", "height", "blendColors", "color1", "color2", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinearGradientAutoFitTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f322867g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f322868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f322869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f322870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f322871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f322872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f322873f;

    public static final class a {
    }

    static {
    }

    public LinearGradientAutoFitTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LinearGradientAutoFitTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int y(int r100, int r101, float r102) {
        float r103 = 1 - r102;
        float r104 = (((r100 >> 16) & 255) * r103) + (((r101 >> 16) & 255) * r102);
        float r105 = (((r100 >> 8) & 255) * r103) + (((r101 >> 8) & 255) * r102);
        return ((int) (((r100 & 255) * r103) + ((r101 & 255) * r102))) | (((((int) r104) << 16) | (-16777216)) | (((int) r105) << 8));
    }

    private final float getTextSize14() {
        return ((Number) this.f322873f.getValue()).floatValue();
    }

    private final float getTextSize15() {
        return ((Number) this.f322872e.getValue()).floatValue();
    }

    public final void x() {
        CharSequence r100 = getText();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        if (r100.length() > 30) goto L14;
        setTextSize(0, getTextSize15());
    L15:
        int r102 = getWidth();
        getHeight();
        int r103 = this.f322868a;
        int r104 = this.f322869b;
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, r102, 0.0f, new int[]{r103, r103, y(r103, this.f322869b, 0.33f), y(this.f322868a, this.f322869b, 0.67f), r104, r104}, new float[]{0.0f, 0.4f, 0.45f, 0.55f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
        return;
    L14:
        setTextSize(0, getTextSize14());
        goto L15
    L8:
        r101 = false;
        goto L9
    }

    public LinearGradientAutoFitTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f322870c = 2.0f;
        this.f322871d = 100.0f;
        this.f322872e = LazyKt.lazy(new n());
        this.f322873f = LazyKt.lazy(new o());
        if (r101 == null) goto L5;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.larus_endColor, R.attr.larus_maxTextSize, R.attr.larus_minTextSize, R.attr.larus_startColor});
        this.f322868a = r103.getColor(3, 0);
        this.f322869b = r103.getColor(0, 0);
        this.f322870c = r103.getDimension(2, this.f322870c);
        this.f322871d = r103.getDimension(1, this.f322871d);
        r103.recycle();
    L5:
        x();
    }

    public /* synthetic */ LinearGradientAutoFitTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        x();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        x();
    }
}
