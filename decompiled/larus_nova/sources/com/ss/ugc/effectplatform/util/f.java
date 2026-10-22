package com.ss.ugc.effectplatform.util;

import bytekn.foundation.io.file.FileManager;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458035a = 0;

    static {
    }

    public static String j(String r100) {
        return r100 + FileManager.f21782a + EffectConstants.KEY_EFFECT_VERSION;
    }

    public static String d(String r100, String r101) {
        return r100 + FileManager.f21782a + EffectConstants.KEY_CATEGORY_VERSION + r101;
    }

    public static String k(String r100, String r101) {
        return EffectConstants.KEY_EFFECT_CHANNEL + r101 + r100;
    }

    public static String b(String r100, String r101, List r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        int r104 = bytekn.foundation.utils.a.f21806a;
        if (r102 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        ArrayList r106 = null;
    L24:
        r103.append(r106);
        return r103.toString() + FileManager.f21782a + EffectConstants.KEY_EFFECT_CHANNEL + r100;
    L11:
        r106 = new ArrayList();
        if (r102 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        Iterator r107 = r102.iterator();
    L16:
        if (r107.hasNext() == false) goto L24;
        Object r108 = r107.next();
        if (r108 == null) goto L22;
        String r109 = r108.toString();
        if (r109 == null) goto L22;
    L23:
        r106.add(r109);
    L22:
        r109 = "";
        goto L23
    L5:
        if (r102.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }

    public static String e(String r100, String r101, Integer r102, Integer r103) {
        String r104 = "effectchannelinfosticker" + r101 + r100;
        if (r102 == null) goto L5;
        r104 = r104 + r102.intValue();
    L5:
        if (r103 != null) goto L7;
        return r104;
    L7:
        return r104 + r103.intValue();
    }

    public static String a(String r100, String r101, int r102, int r103, int r104) {
        return r100 + FileManager.f21782a + EffectConstants.KEY_EFFECT_CHANNEL + r101 + r102 + "_" + r103 + "_" + r104;
    }

    public static String c(String r100, String r101, int r102, int r103, int r104) {
        return r100 + FileManager.f21782a + EffectConstants.KEY_EFFECT_CHANNEL + r101 + r102 + "_" + r103 + "_" + r104 + "paging";
    }

    public static String f(String r100, String r101, boolean r102, String r103, int r104, int r105) {
        StringBuilder r106 = new StringBuilder();
        if (r102 == false) goto L5;
        r101 = r101 + r103 + r104 + r105;
    L5:
        r106.append(r101);
        r106.append("checked");
        return r106.toString() + FileManager.f21782a + EffectConstants.KEY_EFFECT_CHANNEL + r100;
    }

    public static String g(String r100, String r101, boolean r102, String r103, int r104, int r105, int r106) {
        if (r102 == false) goto L4;
        String r107 = r101 + r103 + r104 + r105 + r106;
    L6:
        return r107 + FileManager.f21782a + EffectConstants.KEY_EFFECT_CHANNEL + r100;
    L4:
        r107 = r101 + r106;
        goto L6
    }

    public static String h(String r100, String r101, String r102, int r103, int r104, int r105, String r106) {
        return (r101 + r102 + r103 + r104 + r105 + r106 + "paging_checked") + FileManager.f21782a + EffectConstants.KEY_EFFECT_CHANNEL + r100;
    }

    public static String i(String r100, String r101, String r102, int r103, int r104, int r105, String r106) {
        return (r101 + r102 + r103 + r104 + r105 + r106 + "paging") + FileManager.f21782a + EffectConstants.KEY_EFFECT_CHANNEL + r100;
    }
}
