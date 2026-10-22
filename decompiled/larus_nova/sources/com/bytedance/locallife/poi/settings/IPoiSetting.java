package com.bytedance.locallife.poi.settings;

import com.ss.android.ugc.aweme.poi.settings.PoiSetting;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class IPoiSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f264216a = null;

    static {
        f264216a = LazyKt.lazy(IPoiSetting$defaultValue$2.INSTANCE);
    }

    public static PoiSetting a() {
        return (PoiSetting) f264216a.getValue();
    }
}
