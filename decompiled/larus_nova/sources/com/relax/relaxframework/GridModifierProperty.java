package com.relax.relaxframework;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/relax/relaxframework/GridModifierProperty;", "", "", "value", "I", "getValue", "()I", "Order", "JustifySelf", "GridColumnSpan", "GridRowSpan", "GridColumnStart", "GridColumnEnd", "GridRowStart", "GridRowEnd", "AlignSelf", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum GridModifierProperty extends Enum<GridModifierProperty> {
    public static final GridModifierProperty AlignSelf = null;
    public static final GridModifierProperty GridColumnEnd = null;
    public static final GridModifierProperty GridColumnSpan = null;
    public static final GridModifierProperty GridColumnStart = null;
    public static final GridModifierProperty GridRowEnd = null;
    public static final GridModifierProperty GridRowSpan = null;
    public static final GridModifierProperty GridRowStart = null;
    public static final GridModifierProperty JustifySelf = null;
    public static final GridModifierProperty Order = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GridModifierProperty[] f404733a = null;
    private final int value;

    public static GridModifierProperty valueOf(String r100) {
        return (GridModifierProperty) r27.a.a(GridModifierProperty.class, r100);
    }

    public static GridModifierProperty[] values() {
        return (GridModifierProperty[]) f404733a.clone();
    }

    static {
        GridModifierProperty r100 = new GridModifierProperty("Order", 0, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY);
        Order = r100;
        GridModifierProperty r101 = new GridModifierProperty("JustifySelf", 1, 179);
        JustifySelf = r101;
        GridModifierProperty r102 = new GridModifierProperty("GridColumnSpan", 2, 180);
        GridColumnSpan = r102;
        GridModifierProperty r103 = new GridModifierProperty("GridRowSpan", 3, 181);
        GridRowSpan = r103;
        GridModifierProperty r104 = new GridModifierProperty("GridColumnStart", 4, 182);
        GridColumnStart = r104;
        GridModifierProperty r105 = new GridModifierProperty("GridColumnEnd", 5, 183);
        GridColumnEnd = r105;
        GridModifierProperty r110 = new GridModifierProperty("GridRowStart", 6, 184);
        GridRowStart = r110;
        GridModifierProperty r111 = new GridModifierProperty("GridRowEnd", 7, 185);
        GridRowEnd = r111;
        GridModifierProperty r112 = new GridModifierProperty("AlignSelf", 8, 186);
        AlignSelf = r112;
        f404733a = new GridModifierProperty[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final int getValue() {
        return this.value;
    }

    public GridModifierProperty(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
