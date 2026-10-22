package com.bytedance.locallife.bridge.common.method;

import android.text.TextUtils;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class w extends ko6.o {
    public w() {
    }

    public static ko6.o.c j(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(ko6.o.c.class, "<this>");
        ko6.o.c r102 = (ko6.o.c) com.bytedance.ies.xbridge.utils.g.c(ko6.o.c.class);
        r102.setResult(Boolean.valueOf(r100));
        r102.setErrorMsg(r101);
        return r102;
    }

    @Override // v56.c
    public final void e(XBaseParamModel r110, v56.a r111, XBridgePlatformType r112) {
        ko6.o.b r113 = (ko6.o.b) r110;
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r100 = r113.getChannel();     // Catch: Exception -> L22
        String r101 = r113.getAccessKey();     // Catch: Exception -> L22
        if (r100.length() != 0) goto L7;
        boolean r114 = true;
    L9:
        if (r114 == false) goto L11;
    L20:
        r111.onSuccess(j(false, "invalid params"), "");     // Catch: Exception -> L22
    L28:
        return;
    L11:
        if (r101.length() != 0) goto L13;
        boolean r115 = true;
    L14:
        if (r115 == true) goto L20;
        AtomicBoolean r102 = new AtomicBoolean(false);     // Catch: Exception -> L22
        GeckoClient r116 = com.bytedance.geckox.a.a(r101);     // Catch: Exception -> L22
        if (r116 != null) goto L19;
        r111.onSuccess(j(false, "geckoClient is null"), "");     // Catch: Exception -> L22
        goto L28
    L19:
        HashMap r103 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(r101, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel(r100)))});     // Catch: Exception -> L22
        OptionCheckUpdateParams r104 = new OptionCheckUpdateParams();     // Catch: Exception -> L22
        r104.setEnableThrottle(false);     // Catch: Exception -> L22
        r104.setChannelUpdatePriority(3);     // Catch: Exception -> L22
        r104.setListener(new v(r100, this, r111, r102, r101));     // Catch: Exception -> L22
        Unit r105 = Unit.INSTANCE;     // Catch: Exception -> L22
        r116.checkUpdateMulti(null, r103, r104);     // Catch: Exception -> L22
        goto L28
    L13:
        r115 = false;
        goto L14
    L7:
        r114 = false;
    L22:
        e = move-exception;
        String r117 = e.getMessage();
        if (r117 != null) goto L26;
        r117 = "catch exception";
    L26:
        CompletionBlock.a.a(r111, 0, r117, null, 4);
    }

    public static final boolean h(w r100, Map r101, String r102, String r103) {
        r100.getClass();
        if (r101 == null) goto L24;
        List r104 = (List) r101.get(r102);
        if (r104 == null) goto L25;
        List r105 = r104;
        if ((r105 instanceof Collection) == true) goto L9;
    L11:
        Iterator r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L17;
        if (TextUtils.equals((CharSequence) ((android.util.Pair) r106.next()).first, r103) == false) goto L13;
        boolean r107 = true;
    L18:
        if (r107 != true) goto L26;
        return true;
    L26:
        return false;
    L17:
        r107 = false;
        goto L18
    L9:
        if (r105.isEmpty() == false) goto L11;
    L25:
        return false;
    L24:
        return false;
    }

    public static final void i(w r100, CompletionBlock r101, AtomicBoolean r102, boolean r103, String r104) {
        r100.getClass();
        if (r102.compareAndSet(false, true) == false) goto L6;
        r101.onSuccess(j(r103, r104), "");
        return;
    }
}
