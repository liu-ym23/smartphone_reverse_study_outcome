package com.obric.common.oea.foundation.animation.token;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"com/obric/common/oea/foundation/animation/token/Token$Delay", "", "Lcom/obric/common/oea/foundation/animation/token/Token$Delay;", "", "value", "I", "getValue", "()I", "OUI_ANIMATION_DELAY_NONE", "OUI_ANIMATION_DELAY_SHORT_1", "OUI_ANIMATION_DELAY_SHORT_2", "OUI_ANIMATION_DELAY_SHORT_3", "OUI_ANIMATION_DELAY_SHORT_4", "OUI_ANIMATION_DELAY_MEDIUM_1", "OUI_ANIMATION_DELAY_MEDIUM_2", "OUI_ANIMATION_DELAY_MEDIUM_3", "OUI_ANIMATION_DELAY_MEDIUM_4", "OUI_ANIMATION_DELAY_LONG_1", "OUI_ANIMATION_DELAY_LONG_2", "OUI_ANIMATION_DELAY_LONG_3", "OUI_ANIMATION_DELAY_LONG_4", "OUI_ANIMATION_DELAY_VERY_LONG_1", "OUI_ANIMATION_DELAY_VERY_LONG_2", "OUI_ANIMATION_DELAY_VERY_LONG_3", "OUI_ANIMATION_DELAY_VERY_LONG_4", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum Token$Delay extends Enum<Token$Delay> {
    public static final Token$Delay OUI_ANIMATION_DELAY_LONG_1 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_LONG_2 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_LONG_3 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_LONG_4 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_MEDIUM_1 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_MEDIUM_2 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_MEDIUM_3 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_MEDIUM_4 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_NONE = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_SHORT_1 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_SHORT_2 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_SHORT_3 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_SHORT_4 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_VERY_LONG_1 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_VERY_LONG_2 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_VERY_LONG_3 = null;
    public static final Token$Delay OUI_ANIMATION_DELAY_VERY_LONG_4 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Token$Delay[] f396405a = null;
    private final int value;

    public static Token$Delay valueOf(String r100) {
        return (Token$Delay) a.a(Token$Delay.class, r100);
    }

    public static Token$Delay[] values() {
        return (Token$Delay[]) f396405a.clone();
    }

    static {
        Token$Delay r100 = new Token$Delay("OUI_ANIMATION_DELAY_NONE", 0, 0);
        OUI_ANIMATION_DELAY_NONE = r100;
        Token$Delay r101 = new Token$Delay("OUI_ANIMATION_DELAY_SHORT_1", 1, 50);
        OUI_ANIMATION_DELAY_SHORT_1 = r101;
        Token$Delay r102 = new Token$Delay("OUI_ANIMATION_DELAY_SHORT_2", 2, 100);
        OUI_ANIMATION_DELAY_SHORT_2 = r102;
        Token$Delay r103 = new Token$Delay("OUI_ANIMATION_DELAY_SHORT_3", 3, 150);
        OUI_ANIMATION_DELAY_SHORT_3 = r103;
        Token$Delay r104 = new Token$Delay("OUI_ANIMATION_DELAY_SHORT_4", 4, 200);
        OUI_ANIMATION_DELAY_SHORT_4 = r104;
        Token$Delay r105 = new Token$Delay("OUI_ANIMATION_DELAY_MEDIUM_1", 5, 250);
        OUI_ANIMATION_DELAY_MEDIUM_1 = r105;
        Token$Delay r106 = new Token$Delay("OUI_ANIMATION_DELAY_MEDIUM_2", 6, 300);
        OUI_ANIMATION_DELAY_MEDIUM_2 = r106;
        Token$Delay r107 = new Token$Delay("OUI_ANIMATION_DELAY_MEDIUM_3", 7, TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG);
        OUI_ANIMATION_DELAY_MEDIUM_3 = r107;
        Token$Delay r108 = new Token$Delay("OUI_ANIMATION_DELAY_MEDIUM_4", 8, 400);
        OUI_ANIMATION_DELAY_MEDIUM_4 = r108;
        Token$Delay r109 = new Token$Delay("OUI_ANIMATION_DELAY_LONG_1", 9, 450);
        OUI_ANIMATION_DELAY_LONG_1 = r109;
        Token$Delay r110 = new Token$Delay("OUI_ANIMATION_DELAY_LONG_2", 10, 500);
        OUI_ANIMATION_DELAY_LONG_2 = r110;
        Token$Delay r111 = new Token$Delay("OUI_ANIMATION_DELAY_LONG_3", 11, 550);
        OUI_ANIMATION_DELAY_LONG_3 = r111;
        Token$Delay r112 = new Token$Delay("OUI_ANIMATION_DELAY_LONG_4", 12, 600);
        OUI_ANIMATION_DELAY_LONG_4 = r112;
        Token$Delay r113 = new Token$Delay("OUI_ANIMATION_DELAY_VERY_LONG_1", 13, 700);
        OUI_ANIMATION_DELAY_VERY_LONG_1 = r113;
        Token$Delay r114 = new Token$Delay("OUI_ANIMATION_DELAY_VERY_LONG_2", 14, 800);
        OUI_ANIMATION_DELAY_VERY_LONG_2 = r114;
        Token$Delay r115 = new Token$Delay("OUI_ANIMATION_DELAY_VERY_LONG_3", 15, 900);
        OUI_ANIMATION_DELAY_VERY_LONG_3 = r115;
        Token$Delay r116 = new Token$Delay("OUI_ANIMATION_DELAY_VERY_LONG_4", 16, 1000);
        OUI_ANIMATION_DELAY_VERY_LONG_4 = r116;
        f396405a = new Token$Delay[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116};
    }

    public final int getValue() {
        return this.value;
    }

    public Token$Delay(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
