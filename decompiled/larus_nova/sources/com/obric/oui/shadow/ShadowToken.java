package com.obric.oui.shadow;

import com.obric.oui.material.f;
import com.obric.oui.material.r;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R-\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/shadow/ShadowToken;", "", "", "name", "", "Lcom/obric/oui/shadow/a;", "parse", "(Ljava/lang/String;)[Lcom/obric/oui/shadow/a;", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens", "Oui_Shadow_Thin", "[Lcom/obric/oui/shadow/a;", "Oui_Shadow_Regular", "Oui_Shadow_Thick", "Oui_Shadow_UltraThick", "Oui_Shadow_Text_Regular", "Shadow_1", "Shadow_2", "Shadow_3", "Shadow_Thick", "Shadow_Text", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class ShadowToken {
    public static final ShadowToken INSTANCE = null;
    public static final a[] Oui_Shadow_Regular = null;
    public static final a[] Oui_Shadow_Text_Regular = null;
    public static final a[] Oui_Shadow_Thick = null;
    public static final a[] Oui_Shadow_Thin = null;
    public static final a[] Oui_Shadow_UltraThick = null;
    public static final a[] Shadow_1 = null;
    public static final a[] Shadow_2 = null;
    public static final a[] Shadow_3 = null;
    public static final a[] Shadow_Text = null;
    public static final a[] Shadow_Thick = null;
    private static final Lazy tokens$delegate = null;

    private ShadowToken() {
    }

    static {
        INSTANCE = new ShadowToken();
        tokens$delegate = LazyKt.lazy(ShadowToken$tokens$2.INSTANCE);
        Oui_Shadow_Thin = f.c(ShadowTokenCore.Oui_Shadow_Thin);
        Oui_Shadow_Regular = f.c(ShadowTokenCore.Oui_Shadow_Regular);
        Oui_Shadow_Thick = f.c(ShadowTokenCore.Oui_Shadow_Thick);
        Oui_Shadow_UltraThick = f.c(ShadowTokenCore.Oui_Shadow_UltraThick);
        Oui_Shadow_Text_Regular = f.c(ShadowTokenCore.Oui_Shadow_Text_Regular);
        Shadow_1 = f.c(ShadowTokenCore.Shadow_1);
        Shadow_2 = f.c(ShadowTokenCore.Shadow_2);
        Shadow_3 = f.c(ShadowTokenCore.Shadow_3);
        Shadow_Thick = f.c(ShadowTokenCore.Shadow_Thick);
        Shadow_Text = f.c(ShadowTokenCore.Shadow_Text);
    }

    private final ConcurrentHashMap<String, a[]> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final a[] parse(String r100) {
        int r101 = r.f401494a;
        return (a[]) r.a(r100, INSTANCE.getTokens());
    }
}
