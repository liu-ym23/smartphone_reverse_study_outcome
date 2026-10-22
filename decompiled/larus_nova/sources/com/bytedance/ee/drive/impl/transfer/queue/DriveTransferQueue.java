package com.bytedance.ee.drive.impl.transfer.queue;

import androidx.lifecycle.MutableLiveData;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.ee.drive.impl.transfer.queue.DriveTransferTask;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class DriveTransferQueue<T extends DriveTransferTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f242652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<EState> f242653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f242654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f242655d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/drive/impl/transfer/queue/DriveTransferQueue$EState;", "", ErrorCode.INIT, "IDLE", "WORKING", "DESTROYED", "drive-impl_release"}, k = 1, mv = {1, 7, 1})
    public static final enum EState extends Enum<EState> {
        public static final EState DESTROYED = null;
        public static final EState IDLE = null;
        public static final EState INIT = null;
        public static final EState WORKING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EState[] f242656a = null;

        public static EState valueOf(String r100) {
            return (EState) r27.a.a(EState.class, r100);
        }

        public static EState[] values() {
            return (EState[]) f242656a.clone();
        }

        static {
            EState r100 = new EState(ErrorCode.INIT, 0);
            INIT = r100;
            EState r101 = new EState("IDLE", 1);
            IDLE = r101;
            EState r102 = new EState("WORKING", 2);
            WORKING = r102;
            EState r103 = new EState("DESTROYED", 3);
            DESTROYED = r103;
            f242656a = new EState[]{r100, r101, r102, r103};
        }

        public EState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return this.f242652a + '(' + hashCode() + "){state: " + this.f242653b.getValue() + ", taskCount: " + ((ConcurrentHashMap) this.f242654c.getValue()).size() + ", allTasks: " + CollectionsKt.joinToString$default(((ConcurrentHashMap) this.f242654c.getValue()).keySet(), null, null, null, 0, null, null, 63, null) + ", transferring: " + CollectionsKt.joinToString$default(((ConcurrentHashMap) this.f242655d.getValue()).keySet(), null, null, null, 0, null, null, 63, null) + '}';
    }

    public DriveTransferQueue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        this.f242652a = r100;
        MutableLiveData<EState> r101 = new MutableLiveData(EState.INIT);
        this.f242653b = r101;
        this.f242654c = LazyKt.lazy(DriveTransferQueue$allTaskMap$2.INSTANCE);
        this.f242655d = LazyKt.lazy(DriveTransferQueue$transferringTaskMap$2.INSTANCE);
        r101.postValue(EState.IDLE);
    }
}
