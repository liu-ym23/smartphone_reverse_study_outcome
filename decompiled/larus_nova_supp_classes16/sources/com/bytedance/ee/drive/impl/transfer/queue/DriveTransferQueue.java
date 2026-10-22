package com.bytedance.ee.drive.impl.transfer.queue;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferTask;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class DriveTransferQueue<T extends DriveTransferTask> {
    public final String a;
    public final MutableLiveData<EState> b;
    public final Lazy c;
    public final Lazy d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/drive/impl/transfer/queue/DriveTransferQueue$EState;", "", "INIT", "IDLE", "WORKING", "DESTROYED", "drive-impl_release"}, k = 1, mv = {1, 7, 1})
    public static final enum EState extends Enum<EState> {
        public static final EState DESTROYED = null;
        public static final EState IDLE = null;
        public static final EState INIT = null;
        public static final EState WORKING = null;
        public static final /* synthetic */ EState[] a = null;

        public static EState valueOf(String r1) {
            return (EState) r27.a.a(EState.class, r1);
        }

        public static EState[] values() {
            return (EState[]) a.clone();
        }

        static {
            EState r0 = new EState("INIT", 0);
            INIT = r0;
            EState r1 = new EState("IDLE", 1);
            IDLE = r1;
            EState r3 = new EState("WORKING", 2);
            WORKING = r3;
            EState r5 = new EState("DESTROYED", 3);
            DESTROYED = r5;
            a = new EState[]{r0, r1, r3, r5};
        }

        public EState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return this.a + '(' + hashCode() + "){state: " + this.b.getValue() + ", taskCount: " + ((ConcurrentHashMap) this.c.getValue()).size() + ", allTasks: " + CollectionsKt.joinToString$default(((ConcurrentHashMap) this.c.getValue()).keySet(), null, null, null, 0, null, null, 63, null) + ", transferring: " + CollectionsKt.joinToString$default(((ConcurrentHashMap) this.d.getValue()).keySet(), null, null, null, 0, null, null, 63, null) + '}';
    }

    public DriveTransferQueue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logTag");
        this.a = r2;
        MutableLiveData<EState> r3 = new MutableLiveData(EState.INIT);
        this.b = r3;
        this.c = LazyKt.lazy(DriveTransferQueue$allTaskMap$2.INSTANCE);
        this.d = LazyKt.lazy(DriveTransferQueue$transferringTaskMap$2.INSTANCE);
        r3.postValue(EState.IDLE);
    }
}
