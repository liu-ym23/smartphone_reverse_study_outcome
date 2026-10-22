package com.ivy.ivykit.api.plugin;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IvyResourceService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IvyResourceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278345a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IvyResourceService$Companion;", "Lcom/ivy/ivykit/api/plugin/IvyResourceService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IvyResourceService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278346b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IvyResourceService> f278347c = null;

        private Companion() {
        }

        static {
            f278346b = new Companion();
            f278347c = LazyKt.lazy(IvyResourceService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.plugin.IvyResourceService
        public final void a() {
            IvyResourceService r100 = f278347c.getValue();
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.IvyResourceService
        public final void b() {
            IvyResourceService r100 = f278347c.getValue();
            if (r100 == null) goto L6;
            r100.b();
            return;
        }
    }

    static {
        f278345a = Companion.f278346b;
    }

    void a();

    void b();
}
