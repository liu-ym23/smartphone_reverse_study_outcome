package com.relax.relaxframework;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/FlexModifierProperty;", "", "", "value", "I", "getValue", "()I", "Order", "FlexGrow", "FlexShrink", "FlexBasis", "AlignSelf", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum FlexModifierProperty extends Enum<FlexModifierProperty> {
    public static final FlexModifierProperty AlignSelf = null;
    public static final FlexModifierProperty FlexBasis = null;
    public static final FlexModifierProperty FlexGrow = null;
    public static final FlexModifierProperty FlexShrink = null;
    public static final FlexModifierProperty Order = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexModifierProperty[] f404723a = null;
    private final int value;

    public static FlexModifierProperty valueOf(String r100) {
        return (FlexModifierProperty) r27.a.a(FlexModifierProperty.class, r100);
    }

    public static FlexModifierProperty[] values() {
        return (FlexModifierProperty[]) f404723a.clone();
    }

    static {
        FlexModifierProperty r100 = new FlexModifierProperty("Order", 0, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY);
        Order = r100;
        FlexModifierProperty r101 = new FlexModifierProperty("FlexGrow", 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO);
        FlexGrow = r101;
        FlexModifierProperty r102 = new FlexModifierProperty("FlexShrink", 2, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE);
        FlexShrink = r102;
        FlexModifierProperty r103 = new FlexModifierProperty("FlexBasis", 3, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY);
        FlexBasis = r103;
        FlexModifierProperty r104 = new FlexModifierProperty("AlignSelf", 4, 186);
        AlignSelf = r104;
        f404723a = new FlexModifierProperty[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public FlexModifierProperty(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
