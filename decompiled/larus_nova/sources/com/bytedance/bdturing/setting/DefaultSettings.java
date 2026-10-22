package com.bytedance.bdturing.setting;

import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f202073a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JSONObject f202074b = null;

    static {
        Lazy r100 = LazyKt.lazy(DefaultSettings$raw$2.INSTANCE);
        f202073a = r100;
        f202074b = new JSONObject((String) r100.getValue());
    }
}
