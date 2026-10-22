package com.bytedance.bdp.appbase.cpapi.contextservice.base;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public abstract class AbsApiHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f200776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f200777b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f200778c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f200779d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f200780e = null;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        f200776a = LazyKt.lazy(AbsApiHandler$Companion$bpeaService$2.INSTANCE);
        f200777b = LazyKt.lazy(AbsApiHandler$Companion$bpeaReportConfig$2.INSTANCE);
        f200778c = LazyKt.lazy(AbsApiHandler$Companion$bpeaReportEnable$2.INSTANCE);
        f200779d = LazyKt.lazy(AbsApiHandler$Companion$bpeaReportIgnoredList$2.INSTANCE);
        f200780e = LazyKt.lazy(AbsApiHandler$Companion$infoService$2.INSTANCE);
    }
}
