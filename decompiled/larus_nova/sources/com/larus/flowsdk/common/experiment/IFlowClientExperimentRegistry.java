package com.larus.flowsdk.common.experiment;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/flowsdk/common/experiment/IFlowClientExperimentRegistry;", "", MiPushClient.COMMAND_REGISTER, "", "priority", "", "Companion", "flow-client-experiment-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowClientExperimentRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f343453a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f343454a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Object f343455b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final HashSet<String> f343456c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final HashSet<String> f343457d = null;

        /* JADX INFO: renamed from: com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry$a$a, reason: collision with other inner class name */
        public static final class C4314a<T> implements Comparator {
            public C4314a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r100, T r101) {
                ((IFlowClientExperimentRegistry) r101).priority();
                ((IFlowClientExperimentRegistry) r100).priority();
                return ComparisonsKt.compareValues(0, 0);
            }
        }

        public static final class b<T> implements Comparator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Comparator f343458a;

            public b(C4314a r100) {
                this.f343458a = r100;
            }

            @Override // java.util.Comparator
            public final int compare(T r100, T r101) {
                int r102 = this.f343458a.compare(r100, r101);
                if (r102 == 0) goto L6;
                return r102;
            L6:
                return ComparisonsKt.compareValues(((IFlowClientExperimentRegistry) r100).getClass().getName(), ((IFlowClientExperimentRegistry) r101).getClass().getName());
            }
        }

        public a() {
        }

        static {
            f343454a = new a();
            f343455b = new Object();
            f343456c = new HashSet();
            f343457d = new HashSet();
        }

        public static List a() {
            Set r100 = ServiceManager.get().getServices(IFlowClientExperimentRegistry.class, true);
            HashSet r101 = new HashSet();
            ArrayList r102 = new ArrayList();
            Iterator r103 = r100.iterator();
        L4:
            if (r103.hasNext() == false) goto L9;
            Object r104 = r103.next();
            if (r101.add(((IFlowClientExperimentRegistry) r104).getClass().getName()) == false) goto L4;
            r102.add(r104);
            goto L4
        L9:
            return CollectionsKt.sortedWith(r102, new b(new C4314a()));
        }
    }

    static {
        f343453a = a.f343454a;
    }

    void priority();

    void register();
}
