package com.obric.oui.segmentedtab;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabMiniView;", "Lcom/obric/oui/segmentedtab/OTouchAnimView;", "", "originIconAlpha", "", "setOriginIconAlpha", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSegmentTabMiniView extends OTouchAnimView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f402701g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f402702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f402703f;

    public static final class a {
    }

    static {
    }

    public OSegmentTabMiniView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OSegmentTabMiniView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public final boolean a() {
        return true;
    }

    public final void setOriginIconAlpha(int r100) {
        this.f402703f = r100;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public final void c(float r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        wma.b.a(this.f402702e, "onTouchAnimUpdate, scene: " + r101 + ", animFraction: " + r100);
        if (Intrinsics.areEqual(r101, "press_anim") == true) goto L6;
        Intrinsics.areEqual(r101, "release_anim");
    L6:
        RangesKt.coerceIn((int) (this.f402703f * (1 - (r100 * 0.5f))), 0, 255);
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        throw null;
    }

    public OSegmentTabMiniView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = f402701g;
        f402701g = r103 + 1;
        this.f402702e = Intrinsics.stringPlus("OSegmentTabView_", Integer.valueOf(r103));
    }

    public /* synthetic */ OSegmentTabMiniView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
