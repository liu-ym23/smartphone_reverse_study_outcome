package com.bytedance.locallife.dito.common.settings;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import en6.p;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoCommonSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DitoCommonSetting f257684a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static DitoCommonSetting f257685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static DitoImmediateSetting f257686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f257687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f257688e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f257689f = null;

    static {
        f257684a = new DitoCommonSetting();
        f257688e = LazyKt.lazy(DitoCommonSettings$ditoNestedScrollConfig$2.INSTANCE);
        f257689f = LazyKt.lazy(DitoCommonSettings$fixDitoStickSpaceView$2.INSTANCE);
    }

    public static DitoCommonSetting a() {
        DitoCommonSetting r100 = f257685b;
        if (r100 != null) goto L11;
        Dito r101 = Dito.f257280a;
        pq6.a r102 = l.l();
        if (r102 == null) goto L10;
        DitoCommonSetting r103 = (DitoCommonSetting) ((p) r102).a("aweme_dito_settings", DitoCommonSetting.class);
        if (r103 == null) goto L10;
        f257685b = r103;
        return r103;
    L10:
        return f257684a;
    L11:
        return r100;
    }
}
