package com.ss.android.lark.compose.foundation.widget;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BA\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0006\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0007\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\t\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rj\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchStyle;", "", "trackWidth", "Landroidx/compose/ui/unit/Dp;", "trackHeight", "thumbSize", "thumbPadding", "trackRadius", "loadingIndicatorSize", "loadingIndicatorStrokeWidth", "<init>", "(Ljava/lang/String;IFFFFFFF)V", "getTrackWidth-D9Ej5fM$flow_ud_release", "()F", FaceService.girlLabel, "getTrackHeight-D9Ej5fM$flow_ud_release", "getThumbSize-D9Ej5fM$flow_ud_release", "getThumbPadding-D9Ej5fM$flow_ud_release", "getTrackRadius-D9Ej5fM$flow_ud_release", "getLoadingIndicatorSize-D9Ej5fM$flow_ud_release", "getLoadingIndicatorStrokeWidth-D9Ej5fM$flow_ud_release", EffectConstants.NORMAL, "SMALL", "flow-ud_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowSwitchStyle extends Enum<FlowSwitchStyle> {
    public static final FlowSwitchStyle NORMAL = null;
    public static final FlowSwitchStyle SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowSwitchStyle[] f417682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f417683b = null;
    private final float loadingIndicatorSize;
    private final float loadingIndicatorStrokeWidth;
    private final float thumbPadding;
    private final float thumbSize;
    private final float trackHeight;
    private final float trackRadius;
    private final float trackWidth;

    public static EnumEntries<FlowSwitchStyle> getEntries() {
        return f417683b;
    }

    static {
        float r110 = 2;
        FlowSwitchStyle r111 = new FlowSwitchStyle(EffectConstants.NORMAL, 0, Dp.m7544constructorimpl(51), Dp.m7544constructorimpl(31), Dp.m7544constructorimpl(27), Dp.m7544constructorimpl(r110), Dp.m7544constructorimpl((float) 15.5d), Dp.m7544constructorimpl(16), Dp.m7544constructorimpl(r110));
        NORMAL = r111;
        FlowSwitchStyle r100 = new FlowSwitchStyle("SMALL", 1, Dp.m7544constructorimpl(30), Dp.m7544constructorimpl(18), Dp.m7544constructorimpl(14), Dp.m7544constructorimpl(r110), Dp.m7544constructorimpl(9), Dp.m7544constructorimpl(10), Dp.m7544constructorimpl(1));
        SMALL = r100;
        FlowSwitchStyle[] r101 = {r111, r100};
        f417682a = r101;
        f417683b = EnumEntriesKt.enumEntries(r101);
    }

    public static FlowSwitchStyle[] values() {
        return (FlowSwitchStyle[]) f417682a.clone();
    }

    /* JADX INFO: renamed from: getLoadingIndicatorSize-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m8627getLoadingIndicatorSizeD9Ej5fM$flow_ud_release() {
        return this.loadingIndicatorSize;
    }

    /* JADX INFO: renamed from: getLoadingIndicatorStrokeWidth-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m8628getLoadingIndicatorStrokeWidthD9Ej5fM$flow_ud_release() {
        return this.loadingIndicatorStrokeWidth;
    }

    /* JADX INFO: renamed from: getThumbPadding-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m8629getThumbPaddingD9Ej5fM$flow_ud_release() {
        return this.thumbPadding;
    }

    /* JADX INFO: renamed from: getThumbSize-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m8630getThumbSizeD9Ej5fM$flow_ud_release() {
        return this.thumbSize;
    }

    /* JADX INFO: renamed from: getTrackHeight-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m8631getTrackHeightD9Ej5fM$flow_ud_release() {
        return this.trackHeight;
    }

    /* JADX INFO: renamed from: getTrackRadius-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m8632getTrackRadiusD9Ej5fM$flow_ud_release() {
        return this.trackRadius;
    }

    /* JADX INFO: renamed from: getTrackWidth-D9Ej5fM$flow_ud_release, reason: not valid java name */
    public final float m8633getTrackWidthD9Ej5fM$flow_ud_release() {
        return this.trackWidth;
    }

    public static FlowSwitchStyle valueOf(String r100) {
        return (FlowSwitchStyle) r27.a.a(FlowSwitchStyle.class, r100);
    }

    public FlowSwitchStyle(String r100, int r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108) {
        super(r100, r101);
        this.trackWidth = r102;
        this.trackHeight = r103;
        this.thumbSize = r104;
        this.thumbPadding = r105;
        this.trackRadius = r106;
        this.loadingIndicatorSize = r107;
        this.loadingIndicatorStrokeWidth = r108;
    }
}
