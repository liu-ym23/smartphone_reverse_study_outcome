package com.ivy.ivykit.api.plugin;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyLynxBehaviorService;", "", "Companion", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IIvyLynxBehaviorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278330a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyLynxBehaviorService$Companion;", "Lcom/ivy/ivykit/api/plugin/IIvyLynxBehaviorService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IIvyLynxBehaviorService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278331b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IIvyLynxBehaviorService> f278332c = null;

        private Companion() {
        }

        static {
            f278331b = new Companion();
            f278332c = LazyKt.lazy(IIvyLynxBehaviorService$Companion$impl$2.INSTANCE);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyLynxBehaviorService
        public final List<Object> a() {
            IIvyLynxBehaviorService r100 = f278332c.getValue();
            if (r100 == null) goto L5;
            List<Object> r101 = r100.a();
        L6:
            if (r101 == null) goto L8;
            return r101;
        L8:
            return CollectionsKt.emptyList();
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
        f278330a = Companion.f278331b;
    }

    List<Object> a();
}
