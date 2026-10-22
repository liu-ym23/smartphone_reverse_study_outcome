package com.ss.android.ugc.bytex.pthread.base.convergence.scheduler;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider;", "", "priorityAffinity", "", "Companion", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface PriorityProvider {
    public static final Companion Companion = null;
    public static final int INFERIOR = 1;
    public static final int ORDINARY = 6;
    public static final int PIVOTAL = 11;
    public static final int REALTIME = 16;

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\b\u001a\u00020\u0004*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/scheduler/PriorityProvider$Companion;", "", "()V", "INFERIOR", "", "ORDINARY", "PIVOTAL", "REALTIME", "progressive", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int INFERIOR = 1;
        public static final int ORDINARY = 6;
        public static final int PIVOTAL = 11;
        public static final int REALTIME = 16;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final int progressive(int r100) {
            return r100 + 5;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    int priorityAffinity();
}
