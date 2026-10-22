package com.bytedance.ttcnpa.utils;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zh7.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ttcnpa/utils/CnpaThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "<init>", "()V", "Companion", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
public final class CnpaThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f271056b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f271057a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ttcnpa/utils/CnpaThreadFactory$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "ttcnpa_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public CnpaThreadFactory() {
        this.f271057a = "TTCNPA-IO";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        return new PthreadThreadV2(new a(r100, this), this.f271057a);
    }
}
