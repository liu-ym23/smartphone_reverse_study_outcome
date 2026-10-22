package com.larus.perfdegrade.api;

import com.larus.perfdegrade.api.model.PerfDegradeScrollEvent;
import com.larus.perfdegrade.api.model.PerfDegradeType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import cp9.a;
import cp9.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/larus/perfdegrade/api/IPerfDegradeAbility;", "", "isExperimentEnabled", "", "type", "Lcom/larus/perfdegrade/api/model/PerfDegradeType;", "trigger", "Lcom/larus/perfdegrade/api/model/PerfDegradeResult;", "request", "Lcom/larus/perfdegrade/api/model/PerfDegradeRequest;", "shouldDispatchScrollEvent", "scene", "", "dispatchScrollEvent", "", "event", "Lcom/larus/perfdegrade/api/model/PerfDegradeScrollEvent;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IPerfDegradeAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f363951a = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/perfdegrade/api/IPerfDegradeAbility$Companion;", "Lcom/larus/perfdegrade/api/IPerfDegradeAbility;", "<init>", "()V", "impl", "isExperimentEnabled", "", "type", "Lcom/larus/perfdegrade/api/model/PerfDegradeType;", "trigger", "Lcom/larus/perfdegrade/api/model/PerfDegradeResult;", "request", "Lcom/larus/perfdegrade/api/model/PerfDegradeRequest;", "shouldDispatchScrollEvent", "scene", "", "dispatchScrollEvent", "", "event", "Lcom/larus/perfdegrade/api/model/PerfDegradeScrollEvent;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IPerfDegradeAbility {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f363952b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final IPerfDegradeAbility f363953c = null;

        private Companion() {
        }

        static {
            f363952b = new Companion();
            f363953c = (IPerfDegradeAbility) ServiceManager.get().getService(IPerfDegradeAbility.class);
        }

        @Override // com.larus.perfdegrade.api.IPerfDegradeAbility
        public final b a(a r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            IPerfDegradeAbility r101 = f363953c;
            if (r101 == null) goto L7;
            b r102 = r101.a(r100);
            if (r102 == null) goto L7;
            return r102;
        L7:
            return new b(false, "perf degrade ability not found");
        }

        @Override // com.larus.perfdegrade.api.IPerfDegradeAbility
        public final void b(PerfDegradeScrollEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            IPerfDegradeAbility r101 = f363953c;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // com.larus.perfdegrade.api.IPerfDegradeAbility
        public final boolean c(PerfDegradeType r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "scene");
            IPerfDegradeAbility r102 = f363953c;
            if (r102 != null) goto L7;
            return false;
        L7:
            return r102.c(r100, r101);
        }
    }

    static {
        f363951a = Companion.f363952b;
    }

    b a(a r100);

    void b(PerfDegradeScrollEvent r100);

    boolean c(PerfDegradeType r100, String r101);
}
