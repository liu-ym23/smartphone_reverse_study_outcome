package com.larus.apm.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import p48.e;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/larus/apm/api/ITTProtector;", "", "init", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITTProtector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286948a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/larus/apm/api/ITTProtector$Companion;", "Lcom/larus/apm/api/ITTProtector;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/apm/api/ITTProtector;", "impl$delegate", "Lkotlin/Lazy;", "init", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ITTProtector {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286949b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<ITTProtector> f286950c = null;

        private Companion() {
        }

        static {
            f286949b = new Companion();
            f286950c = LazyKt.lazy(new e());
        }

        @Override // com.larus.apm.api.ITTProtector
        public final void init() {
            ITTProtector r100 = f286950c.getValue();
            if (r100 == null) goto L6;
            r100.init();
            return;
        }
    }

    static {
        f286948a = Companion.f286949b;
    }

    void init();
}
