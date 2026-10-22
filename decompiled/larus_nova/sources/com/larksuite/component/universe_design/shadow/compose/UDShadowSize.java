package com.larksuite.component.universe_design.shadow.compose;

import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/universe_design/shadow/compose/UDShadowSize;", "", "blur", "Landroidx/compose/ui/unit/Dp;", "offset", "<init>", "(Ljava/lang/String;IFF)V", "getBlur-D9Ej5fM$universe_ui_shadow_release", "()F", FaceService.girlLabel, "getOffset-D9Ej5fM$universe_ui_shadow_release", "None", "S1", "S2", "S3", "S4", "S5", "universe-ui-shadow_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDShadowSize extends Enum<UDShadowSize> {
    public static final UDShadowSize None = null;
    public static final UDShadowSize S1 = null;
    public static final UDShadowSize S2 = null;
    public static final UDShadowSize S3 = null;
    public static final UDShadowSize S4 = null;
    public static final UDShadowSize S5 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDShadowSize[] f285247a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285248b = null;
    private final float blur;
    private final float offset;

    public static EnumEntries<UDShadowSize> getEntries() {
        return f285248b;
    }

    static {
        float r100 = 0;
        UDShadowSize r101 = new UDShadowSize("None", 0, Dp.m7544constructorimpl(r100), Dp.m7544constructorimpl(r100));
        None = r101;
        float r102 = 4;
        float r103 = 2;
        UDShadowSize r104 = new UDShadowSize("S1", 1, Dp.m7544constructorimpl(r102), Dp.m7544constructorimpl(r103));
        S1 = r104;
        float r105 = 6;
        UDShadowSize r106 = new UDShadowSize("S2", 2, Dp.m7544constructorimpl(r105), Dp.m7544constructorimpl(r103));
        S2 = r106;
        float r110 = 8;
        UDShadowSize r107 = new UDShadowSize("S3", 3, Dp.m7544constructorimpl(r110), Dp.m7544constructorimpl(r102));
        S3 = r107;
        UDShadowSize r108 = new UDShadowSize("S4", 4, Dp.m7544constructorimpl(16), Dp.m7544constructorimpl(r105));
        S4 = r108;
        UDShadowSize r109 = new UDShadowSize("S5", 5, Dp.m7544constructorimpl(36), Dp.m7544constructorimpl(r110));
        S5 = r109;
        UDShadowSize[] r111 = {r101, r104, r106, r107, r108, r109};
        f285247a = r111;
        f285248b = EnumEntriesKt.enumEntries(r111);
    }

    public static UDShadowSize[] values() {
        return (UDShadowSize[]) f285247a.clone();
    }

    /* JADX INFO: renamed from: getBlur-D9Ej5fM$universe_ui_shadow_release, reason: not valid java name */
    public final float m8538getBlurD9Ej5fM$universe_ui_shadow_release() {
        return this.blur;
    }

    /* JADX INFO: renamed from: getOffset-D9Ej5fM$universe_ui_shadow_release, reason: not valid java name */
    public final float m8539getOffsetD9Ej5fM$universe_ui_shadow_release() {
        return this.offset;
    }

    public static UDShadowSize valueOf(String r100) {
        return (UDShadowSize) r27.a.a(UDShadowSize.class, r100);
    }

    public UDShadowSize(String r100, int r101, float r102, float r103) {
        super(r100, r101);
        this.blur = r102;
        this.offset = r103;
    }
}
