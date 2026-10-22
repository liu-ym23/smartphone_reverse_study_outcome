package com.bytedance.live.livelink.kmp.api.base.rtc;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/live/livelink/kmp/api/base/rtc/Env;", "", "ENV_PRODUCT", "ENV_BOE", "ENV_TEST", "live-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Env extends Enum<Env> {
    public static final Env ENV_BOE = null;
    public static final Env ENV_PRODUCT = null;
    public static final Env ENV_TEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Env[] f255224a = null;

    static {
        Env r100 = new Env("ENV_PRODUCT", 0);
        ENV_PRODUCT = r100;
        Env r101 = new Env("ENV_BOE", 1);
        ENV_BOE = r101;
        Env r102 = new Env("ENV_TEST", 2);
        ENV_TEST = r102;
        f255224a = new Env[]{r100, r101, r102};
    }

    public static Env valueOf(String r100) {
        return (Env) a.a(Env.class, r100);
    }

    public static Env[] values() {
        return (Env[]) f255224a.clone();
    }

    public Env(String r100, int r101) {
        super(r100, r101);
    }
}
