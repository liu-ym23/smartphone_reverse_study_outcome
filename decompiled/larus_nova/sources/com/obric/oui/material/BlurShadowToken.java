package com.obric.oui.material;

import com.obric.oui.blur.BlurToken;
import com.obric.oui.shadow.ShadowToken;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/material/BlurShadowToken;", "", "", "name", "Lcom/obric/oui/material/a;", "parse", "", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/Map;", "tokens", "Blur_Shadow_Thin", "Lcom/obric/oui/material/a;", "Blur_Shadow_Regular", "Blur_Shadow_Thin_On_Image", "Blur_Shadow_Regular_On_Image", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class BlurShadowToken {
    public static final a Blur_Shadow_Regular = null;
    public static final a Blur_Shadow_Regular_On_Image = null;
    public static final a Blur_Shadow_Thin = null;
    public static final a Blur_Shadow_Thin_On_Image = null;
    public static final BlurShadowToken INSTANCE = null;
    private static final Lazy tokens$delegate = null;

    private BlurShadowToken() {
    }

    static {
        INSTANCE = new BlurShadowToken();
        tokens$delegate = LazyKt.lazy(BlurShadowToken$tokens$2.INSTANCE);
        Blur_Shadow_Thin = new a(BlurToken.Blur_Thin, ShadowToken.Shadow_2);
        float r100 = BlurToken.Blur_Regular;
        com.obric.oui.shadow.a[] r101 = ShadowToken.Shadow_3;
        Blur_Shadow_Regular = new a(r100, r101);
        Blur_Shadow_Thin_On_Image = new a(r100, r101);
        Blur_Shadow_Regular_On_Image = new a(BlurToken.Blur_Thick, ShadowToken.Shadow_Thick);
    }

    private final Map<String, a> getTokens() {
        return (Map) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final a parse(String r100) {
        int r101 = r.f401494a;
        return (a) r.a(r100, INSTANCE.getTokens());
    }
}
