package com.bytedance.bdp.appbase.base.log.diagnose;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f200600c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f200601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f200602b;

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.base.log.diagnose.a$a, reason: collision with other inner class name */
    public static final class C2891a {
    }

    static {
    }

    public a() {
        this.f200601a = LazyKt.lazy(new LogWriter$logFile$2(this));
        this.f200602b = LazyKt.lazy(LogWriter$folderPath$2.INSTANCE);
    }
}
