package com.obric.oui.fluid;

import com.obric.oui.material.r;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007J&\u0010\r\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007R'\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/fluid/FluidToken;", "", "", "name", "Lcom/obric/oui/fluid/a;", "parse", "customTokenOwner", "", "overrideExisting", "", MiPushClient.COMMAND_REGISTER, "", "customTokens", "registerTokens", "Ljava/util/concurrent/ConcurrentHashMap;", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "tokens", "OUI_Effect_Fluid_Thin_Light", "Lcom/obric/oui/fluid/a;", "OUI_Effect_Fluid_Thin_Dark", "OUI_Effect_Fluid_Regular_Light", "OUI_Effect_Fluid_Regular_Dark", "<init>", "()V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class FluidToken {
    public static final FluidToken INSTANCE = null;
    public static final a OUI_Effect_Fluid_Regular_Dark = null;
    public static final a OUI_Effect_Fluid_Regular_Light = null;
    public static final a OUI_Effect_Fluid_Thin_Dark = null;
    public static final a OUI_Effect_Fluid_Thin_Light = null;
    private static final Lazy tokens$delegate = null;

    private FluidToken() {
    }

    static {
        INSTANCE = new FluidToken();
        tokens$delegate = LazyKt.lazy(FluidToken$tokens$2.INSTANCE);
        OUI_Effect_Fluid_Thin_Light = c.a(FluidTokenCore.OUI_Effect_Fluid_Thin_Light);
        OUI_Effect_Fluid_Thin_Dark = c.a(FluidTokenCore.OUI_Effect_Fluid_Thin_Dark);
        OUI_Effect_Fluid_Regular_Light = c.a(FluidTokenCore.OUI_Effect_Fluid_Regular_Light);
        OUI_Effect_Fluid_Regular_Dark = c.a(FluidTokenCore.OUI_Effect_Fluid_Regular_Dark);
    }

    private final ConcurrentHashMap<String, a> getTokens() {
        return (ConcurrentHashMap) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final a parse(String r100) {
        int r101 = r.f401494a;
        return (a) r.a(r100, INSTANCE.getTokens());
    }

    @JvmStatic
    public static final void register(Object r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "customTokenOwner");
        int r101 = r.f401494a;
        ConcurrentHashMap<String, a> r102 = INSTANCE.getTokens();
        LinkedHashMap r103 = new LinkedHashMap();
        Field[] r104 = r100.getClass().getDeclaredFields();     // Catch: Exception -> L11
        int r105 = r104.length;     // Catch: Exception -> L11
        int r106 = 0;
    L4:
        if (r106 >= r105) goto L12;
        Field r107 = r104[r106];     // Catch: Exception -> L11
        r106 = r106 + 1;     // Catch: Exception -> L11
        if (a.class.isAssignableFrom(r107.getType()) == false) goto L4;
        r107.setAccessible(true);     // Catch: Exception -> L11
        Object r108 = r107.get(r100);     // Catch: Exception -> L11
        if ((r108 instanceof a) == false) goto L4;
        r103.put(r107.getName().toLowerCase(Locale.ROOT), r108);     // Catch: Exception -> L11
    L12:
        r.b(r102, r103, r110);
        return;
    L11:
        Intrinsics.stringPlus("Failed to parse tokens from ", r100.getClass().getSimpleName());
        goto L12
    }

    @JvmStatic
    public static final void registerTokens(Map<String, a> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customTokens");
        int r102 = r.f401494a;
        r.b(INSTANCE.getTokens(), r100, r101);
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
