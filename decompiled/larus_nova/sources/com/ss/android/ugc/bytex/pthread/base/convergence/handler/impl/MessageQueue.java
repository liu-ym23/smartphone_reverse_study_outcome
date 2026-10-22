package com.ss.android.ugc.bytex.pthread.base.convergence.handler.impl;

import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u001a\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u001a\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/MessageQueue;", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/IMessageQueue;", "()V", "leader", "Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/MessageQueue$Node;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "notEmpty", "Ljava/util/concurrent/locks/Condition;", "enqueueMessage", "", "msg", "Landroid/os/Message;", "hasMessages", "", "h", "Landroid/os/Handler;", "what", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "isEmpty", "pollMessage", "keepAliveTime", "", "removeCallbacksAndMessages", "removeMessages", "r", "Ljava/lang/Runnable;", "Node", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class MessageQueue implements IMessageQueue {
    private volatile Node leader;
    private final ReentrantLock lock;
    private final Condition notEmpty;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/MessageQueue$Node;", "", "data", "Landroid/os/Message;", TeaEventTrack.ACTION_DRAMA_NEXT, "(Landroid/os/Message;Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/MessageQueue$Node;)V", "getData", "()Landroid/os/Message;", "setData", "(Landroid/os/Message;)V", "getNext", "()Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/MessageQueue$Node;", "setNext", "(Lcom/ss/android/ugc/bytex/pthread/base/convergence/handler/impl/MessageQueue$Node;)V", "recycle", "", "recycleWithMsg", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
    public static final class Node {
        private Message data;
        private Node next;

        /* JADX WARN: Multi-variable type inference failed */
        public Node() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public Node(Message r100, Node r101) {
            this.data = r100;
            this.next = r101;
        }

        public /* synthetic */ Node(Message r100, Node r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }

        public final Message getData() {
            return this.data;
        }

        public final Node getNext() {
            return this.next;
        }

        public final void recycle() {
            this.next = null;
            this.data = null;
        }

        public final void recycleWithMsg() {
            this.next = null;
            Message r100 = this.data;
            if (r100 == null) goto L5;
            r100.recycle();
        L5:
            this.data = null;
        }

        public final void setData(Message r100) {
            this.data = r100;
        }

        public final void setNext(Node r100) {
            this.next = r100;
        }
    }

    public MessageQueue() {
        ReentrantLock r100 = new ReentrantLock();
        this.lock = r100;
        this.notEmpty = r100.newCondition();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue
    public void enqueueMessage(Message r100) {
        Node r101 = new Node(r100, null, 2, 0 == true ? 1 : 0);
        this.lock.lock();
    L16:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L4:
        if (this.leader != null) goto L6;
        this.leader = r101;     // Catch: Throwable -> L16
    L13:
        this.notEmpty.signal();     // Catch: Throwable -> L16
        this.lock.unlock();
        return;
    L6:
        Node r102 = this.leader;     // Catch: Throwable -> L16
    L7:
        if (r102 != null) goto L10;
        Intrinsics.throwNpe();     // Catch: Throwable -> L16
    L10:
        if (r102.getNext() == null) goto L12;
        r102 = r102.getNext();     // Catch: Throwable -> L16
        goto L7
    L12:
        r102.setNext(r101);     // Catch: Throwable -> L16
        goto L13
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue
    public boolean hasMessages(Handler r100, int r101, Object r102) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.lock.lock();
        Node r103 = this.leader;     // Catch: Throwable -> L30
    L7:
        if (r103 == null) goto L28;
        Message r104 = r103.getData();     // Catch: Throwable -> L30
        if (r104 != null) goto L12;
        Intrinsics.throwNpe();     // Catch: Throwable -> L30
    L12:
        if (r104.what != r101) goto L26;
        Message r105 = r103.getData();     // Catch: Throwable -> L30
        if (r105 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L30
    L17:
        if (Intrinsics.areEqual(r100, r105.getTarget()) == false) goto L26;
        if (r102 == null) goto L24;
        Message r106 = r103.getData();     // Catch: Throwable -> L30
        if (r106 != null) goto L23;
        Intrinsics.throwNpe();     // Catch: Throwable -> L30
    L23:
        if (Intrinsics.areEqual(r106.obj, r102) == false) goto L26;
    L24:
        this.lock.unlock();
        return true;
    L26:
        r103 = r103.getNext();     // Catch: Throwable -> L30
        goto L7
    L28:
        this.lock.unlock();
        return false;
    L30:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue
    public boolean isEmpty() {
        if (this.leader != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue
    public Message pollMessage(long r100) {
        this.lock.lock();
    L19:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L4:
        if (this.leader == null) goto L6;
    L8:
        Node r101 = this.leader;     // Catch: Throwable -> L19
        Message r102 = null;
        if (r101 == null) goto L11;
        Node r103 = r101.getNext();     // Catch: Throwable -> L19
    L12:
        this.leader = r103;     // Catch: Throwable -> L19
        if (r101 == null) goto L15;
        r102 = r101.getData();     // Catch: Throwable -> L19
    L15:
        if (r101 == null) goto L17;
        r101.recycle();     // Catch: Throwable -> L19
    L17:
        this.lock.unlock();
        return r102;
    L11:
        r103 = null;
        goto L12
    L6:
        if (r100 <= 0) goto L8;
        this.notEmpty.await(r100, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L19
        goto L8
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue
    public void removeCallbacksAndMessages(Handler r100, Object r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.lock.lock();
        Node r102 = this.leader;     // Catch: Throwable -> L38
    L6:
        if (r102 == null) goto L19;
        Message r103 = r102.getData();     // Catch: Throwable -> L38
        if (r103 != null) goto L11;
        Intrinsics.throwNpe();     // Catch: Throwable -> L38
    L11:
        if (Intrinsics.areEqual(r100, r103.getTarget()) == false) goto L19;
        if (r101 == null) goto L18;
        Message r104 = r102.getData();     // Catch: Throwable -> L38
        if (r104 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L38
    L17:
        if (r104.obj != r101) goto L19;
    L18:
        Node r105 = r102.getNext();     // Catch: Throwable -> L38
        this.leader = r105;     // Catch: Throwable -> L38
        r102.recycleWithMsg();     // Catch: Throwable -> L38
        r102 = r105;
    L19:
        if (r102 == null) goto L36;
        Node r106 = r102.getNext();     // Catch: Throwable -> L38
        if (r106 == null) goto L35;
        Message r107 = r106.getData();     // Catch: Throwable -> L38
        if (r107 != null) goto L26;
        Intrinsics.throwNpe();     // Catch: Throwable -> L38
    L26:
        if (Intrinsics.areEqual(r100, r107.getTarget()) == false) goto L35;
        if (r101 == null) goto L33;
        Message r108 = r106.getData();     // Catch: Throwable -> L38
        if (r108 != null) goto L32;
        Intrinsics.throwNpe();     // Catch: Throwable -> L38
    L32:
        if (Intrinsics.areEqual(r101, r108.obj) == false) goto L35;
    L33:
        Node r109 = r106.getNext();     // Catch: Throwable -> L38
        r106.recycleWithMsg();     // Catch: Throwable -> L38
        r102.setNext(r109);     // Catch: Throwable -> L38
    L35:
        r102 = r106;
        goto L19
    L36:
        this.lock.unlock();
        return;
    L38:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue
    public void removeMessages(Handler r100, int r101, Object r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.lock.lock();
        Node r103 = this.leader;     // Catch: Throwable -> L48
    L6:
        if (r103 == null) goto L24;
        Message r104 = r103.getData();     // Catch: Throwable -> L48
        if (r104 != null) goto L11;
        Intrinsics.throwNpe();     // Catch: Throwable -> L48
    L11:
        if (Intrinsics.areEqual(r100, r104.getTarget()) == false) goto L24;
        Message r105 = r103.getData();     // Catch: Throwable -> L48
        if (r105 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L48
    L16:
        if (r105.what != r101) goto L24;
        if (r102 == null) goto L23;
        Message r106 = r103.getData();     // Catch: Throwable -> L48
        if (r106 != null) goto L22;
        Intrinsics.throwNpe();     // Catch: Throwable -> L48
    L22:
        if (r106.obj != r102) goto L24;
    L23:
        Node r107 = r103.getNext();     // Catch: Throwable -> L48
        this.leader = r107;     // Catch: Throwable -> L48
        r103.recycleWithMsg();     // Catch: Throwable -> L48
        r103 = r107;
    L24:
        if (r103 == null) goto L46;
        Node r108 = r103.getNext();     // Catch: Throwable -> L48
        if (r108 == null) goto L45;
        Message r109 = r108.getData();     // Catch: Throwable -> L48
        if (r109 != null) goto L31;
        Intrinsics.throwNpe();     // Catch: Throwable -> L48
    L31:
        if (Intrinsics.areEqual(r100, r109.getTarget()) == false) goto L45;
        Message r110 = r108.getData();     // Catch: Throwable -> L48
        if (r110 != null) goto L36;
        Intrinsics.throwNpe();     // Catch: Throwable -> L48
    L36:
        if (r110.what != r101) goto L45;
        if (r102 == null) goto L43;
        Message r111 = r108.getData();     // Catch: Throwable -> L48
        if (r111 != null) goto L42;
        Intrinsics.throwNpe();     // Catch: Throwable -> L48
    L42:
        if (Intrinsics.areEqual(r102, r111.obj) == false) goto L45;
    L43:
        Node r112 = r108.getNext();     // Catch: Throwable -> L48
        r108.recycleWithMsg();     // Catch: Throwable -> L48
        r103.setNext(r112);     // Catch: Throwable -> L48
    L45:
        r103 = r108;
        goto L24
    L46:
        this.lock.unlock();
        return;
    L48:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.handler.IMessageQueue
    public void removeMessages(Handler r100, Runnable r101, Object r102) {
        if (r100 == null) goto L52;
        if (r101 == null) goto L72;
        this.lock.lock();
        Node r103 = this.leader;     // Catch: Throwable -> L49
    L7:
        if (r103 == null) goto L25;
        Message r104 = r103.getData();     // Catch: Throwable -> L49
        if (r104 != null) goto L12;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L12:
        if (Intrinsics.areEqual(r100, r104.getTarget()) == false) goto L25;
        Message r105 = r103.getData();     // Catch: Throwable -> L49
        if (r105 != null) goto L17;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L17:
        if (Intrinsics.areEqual(r105.getCallback(), r101) == false) goto L25;
        if (r102 == null) goto L24;
        Message r106 = r103.getData();     // Catch: Throwable -> L49
        if (r106 != null) goto L23;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L23:
        if (r106.obj != r102) goto L25;
    L24:
        Node r107 = r103.getNext();     // Catch: Throwable -> L49
        this.leader = r107;     // Catch: Throwable -> L49
        r103.recycleWithMsg();     // Catch: Throwable -> L49
        r103 = r107;
    L25:
        if (r103 == null) goto L47;
        Node r108 = r103.getNext();     // Catch: Throwable -> L49
        if (r108 == null) goto L46;
        Message r109 = r108.getData();     // Catch: Throwable -> L49
        if (r109 != null) goto L32;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L32:
        if (Intrinsics.areEqual(r100, r109.getTarget()) == false) goto L46;
        Message r110 = r108.getData();     // Catch: Throwable -> L49
        if (r110 != null) goto L37;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L37:
        if (Intrinsics.areEqual(r110.getCallback(), r101) == false) goto L46;
        if (r102 == null) goto L44;
        Message r111 = r108.getData();     // Catch: Throwable -> L49
        if (r111 != null) goto L43;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L43:
        if (Intrinsics.areEqual(r102, r111.obj) == false) goto L46;
    L44:
        Node r112 = r108.getNext();     // Catch: Throwable -> L49
        r108.recycleWithMsg();     // Catch: Throwable -> L49
        r103.setNext(r112);     // Catch: Throwable -> L49
    L46:
        r103 = r108;
        goto L25
    L47:
        this.lock.unlock();
        return;
    L49:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L72:
        return;
    }
}
