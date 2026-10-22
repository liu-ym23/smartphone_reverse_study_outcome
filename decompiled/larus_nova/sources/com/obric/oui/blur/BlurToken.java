package com.obric.oui.blur;

import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J&\u0010\u0017\u001a\u00020\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u00192\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/blur/BlurToken;", "", "()V", "Blur_Background_Regular", "", "Blur_Background_Thick", "Blur_Progress_Regular", "Blur_Progress_Thin", "Blur_Regular", "Blur_Thick", "Blur_Thin", "Blur_UltraThick", "Blur_UltraThin", "Blur_Zero", "parse", "name", "", "(Ljava/lang/String;)Ljava/lang/Float;", MiPushClient.COMMAND_REGISTER, "", "customTokenOwner", "overrideExisting", "", "registerTokens", "customTokens", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlurToken {
    public static final float Blur_Background_Regular = 0.0f;
    public static final float Blur_Background_Thick = 0.0f;
    public static final float Blur_Progress_Regular = 0.0f;
    public static final float Blur_Progress_Thin = 0.0f;
    public static final float Blur_Regular = 0.0f;
    public static final float Blur_Thick = 0.0f;
    public static final float Blur_Thin = 0.0f;
    public static final float Blur_UltraThick = 0.0f;
    public static final float Blur_UltraThin = 0.0f;
    public static final float Blur_Zero = 0.0f;
    public static final BlurToken INSTANCE = null;

    private BlurToken() {
    }

    static {
        INSTANCE = new BlurToken();
        Blur_Zero = 0.1f;
        Blur_UltraThin = BlurTokenCore.Blur_UltraThin;
        Blur_Thin = 8.0f;
        Blur_Regular = 20.0f;
        Blur_Thick = 32.0f;
        Blur_UltraThick = 64.0f;
        Blur_Background_Regular = 20.0f;
        Blur_Background_Thick = 64.0f;
        Blur_Progress_Thin = 8.0f;
        Blur_Progress_Regular = 20.0f;
    }

    @JvmStatic
    public static final Float parse(String r100) {
        return BlurTokenCore.parse(INSTANCE, r100);
    }

    @JvmStatic
    public static final void register(Object r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customTokenOwner");
        BlurTokenCore.register(INSTANCE, r100, r101);
    }

    @JvmStatic
    public static final void registerTokens(Map<String, Float> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customTokens");
        BlurTokenCore.registerTokens(INSTANCE, r100, r101);
    }

    public static /* synthetic */ void register$default(Object r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = true;
    L5:
        register(r100, r101);
    }

    public static /* synthetic */ void registerTokens$default(Map r100, boolean r101, int r102, Object r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = true;
    L5:
        registerTokens(r100, r101);
    }
}
