package com.bytedance.kmp.klay.event;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableSharedFlow<C3598a> f252183a;

    /* JADX INFO: renamed from: com.bytedance.kmp.klay.event.a$a, reason: collision with other inner class name */
    public static final class C3598a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3598a) == true) goto L8;
            return false;
        L8:
            ((C3598a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "EventWrapper(eventClass=null, event=null)";
        }
    }

    public a() {
        this.f252183a = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        new LinkedHashMap();
        new ReentrantLock();
    }
}
