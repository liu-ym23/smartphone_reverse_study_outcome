package com.obric.common.oea.foundation.animation.token;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"com/obric/common/oea/foundation/animation/token/Token$Bounce", "", "Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "", "bounce", FaceService.girlLabel, "getBounce", "()F", "dampingRatio", "getDampingRatio", "OUI_ANIMATION_BOUNCE_SMOOTH", "OUI_ANIMATION_BOUNCE_SNAPPY_1", "OUI_ANIMATION_BOUNCE_SNAPPY_2", "OUI_ANIMATION_BOUNCE_SNAPPY_3", "OUI_ANIMATION_BOUNCE_SNAPPY_4", "OUI_ANIMATION_BOUNCE_BOUNCY_1", "OUI_ANIMATION_BOUNCE_BOUNCY_2", "OUI_ANIMATION_BOUNCE_BOUNCY_3", "OUI_ANIMATION_BOUNCE_BOUNCY_4", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum Token$Bounce extends Enum<Token$Bounce> {
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_BOUNCY_1 = null;
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_BOUNCY_2 = null;
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_BOUNCY_3 = null;
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_BOUNCY_4 = null;
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_SMOOTH = null;
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_SNAPPY_1 = null;
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_SNAPPY_2 = null;
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_SNAPPY_3 = null;
    public static final Token$Bounce OUI_ANIMATION_BOUNCE_SNAPPY_4 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Token$Bounce[] f396404a = null;
    private final float bounce;
    private final float dampingRatio;

    public static Token$Bounce valueOf(String r100) {
        return (Token$Bounce) a.a(Token$Bounce.class, r100);
    }

    public static Token$Bounce[] values() {
        return (Token$Bounce[]) f396404a.clone();
    }

    static {
        Token$Bounce r100 = new Token$Bounce("OUI_ANIMATION_BOUNCE_SMOOTH", 0, 0.0f, 1.0f);
        OUI_ANIMATION_BOUNCE_SMOOTH = r100;
        Token$Bounce r101 = new Token$Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_1", 1, 0.05f, 0.95f);
        OUI_ANIMATION_BOUNCE_SNAPPY_1 = r101;
        Token$Bounce r102 = new Token$Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_2", 2, 0.1f, 0.9f);
        OUI_ANIMATION_BOUNCE_SNAPPY_2 = r102;
        Token$Bounce r103 = new Token$Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_3", 3, 0.15f, 0.85f);
        OUI_ANIMATION_BOUNCE_SNAPPY_3 = r103;
        Token$Bounce r104 = new Token$Bounce("OUI_ANIMATION_BOUNCE_SNAPPY_4", 4, 0.2f, 0.8f);
        OUI_ANIMATION_BOUNCE_SNAPPY_4 = r104;
        Token$Bounce r105 = new Token$Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_1", 5, 0.25f, 0.75f);
        OUI_ANIMATION_BOUNCE_BOUNCY_1 = r105;
        Token$Bounce r106 = new Token$Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_2", 6, 0.3f, 0.7f);
        OUI_ANIMATION_BOUNCE_BOUNCY_2 = r106;
        Token$Bounce r107 = new Token$Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_3", 7, 0.35f, 0.65f);
        OUI_ANIMATION_BOUNCE_BOUNCY_3 = r107;
        Token$Bounce r108 = new Token$Bounce("OUI_ANIMATION_BOUNCE_BOUNCY_4", 8, 0.4f, 0.6f);
        OUI_ANIMATION_BOUNCE_BOUNCY_4 = r108;
        f396404a = new Token$Bounce[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final float getBounce() {
        return this.bounce;
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public Token$Bounce(String r100, int r101, float r102, float r103) {
        super(r100, r101);
        this.bounce = r102;
        this.dampingRatio = r103;
    }
}
