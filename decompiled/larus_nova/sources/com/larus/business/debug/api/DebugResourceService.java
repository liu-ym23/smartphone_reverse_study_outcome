package com.larus.business.debug.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import ov8.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\b\u0010\b\u001a\u00020\tH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/larus/business/debug/api/DebugResourceService;", "", "appIconId", "", "getAppIconId", "()Ljava/lang/Integer;", "appLabelId", "getAppLabelId", "blockShare", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DebugResourceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f319939a = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/larus/business/debug/api/DebugResourceService$Companion;", "Lcom/larus/business/debug/api/DebugResourceService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/business/debug/api/DebugResourceService;", "impl$delegate", "Lkotlin/Lazy;", "appIconId", "", "getAppIconId", "()Ljava/lang/Integer;", "appLabelId", "getAppLabelId", "blockShare", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements DebugResourceService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f319940b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<DebugResourceService> f319941c = null;

        private Companion() {
        }

        static {
            f319940b = new Companion();
            f319941c = LazyKt.lazy(new a());
        }

        @Override // com.larus.business.debug.api.DebugResourceService
        public final Integer b() {
            DebugResourceService r100 = f319941c.getValue();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.b();
        }
    }

    static {
        f319939a = Companion.f319940b;
    }

    Integer b();
}
