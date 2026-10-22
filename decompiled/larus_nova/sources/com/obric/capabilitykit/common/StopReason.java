package com.obric.capabilitykit.common;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/obric/capabilitykit/common/StopReason;", "", "()V", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StopReason {
    public static final String CLARIFY_TIMEOUT = "clarify_timeout";
    public static final Companion Companion = null;
    public static final String DIRECT_SEND_INTERRUPT = "direct_send_interrupt";
    public static final String SYSTEM_TERMINATE = "system_terminate";
    public static final String USER_STOP_COMPLEX_TASK = "user_stop_complex_task";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/common/StopReason$Companion;", "", "()V", "CLARIFY_TIMEOUT", "", "DIRECT_SEND_INTERRUPT", "SYSTEM_TERMINATE", "USER_STOP_COMPLEX_TASK", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StopReason() {
    }
}
