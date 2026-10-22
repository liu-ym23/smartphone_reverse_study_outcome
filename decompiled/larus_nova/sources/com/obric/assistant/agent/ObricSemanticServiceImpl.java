package com.obric.assistant.agent;

import androidx.exifinterface.media.ExifInterface;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/agent/ObricSemanticServiceImpl;", "Lcom/obric/assistant/agent/IObricSemanticApi;", "<init>", "()V", "deleted", "Lcom/obric/assistant/agent/ObricSemanticServiceImpl$EvictingLinkedBlockingDeque;", "Lcom/larus/im/bean/message/Message;", "markDeleted", "", "message", "getDeleted", "", "Companion", "EvictingLinkedBlockingDeque", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSemanticServiceImpl implements IObricSemanticApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EvictingLinkedBlockingDeque<Message> f385584a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/agent/ObricSemanticServiceImpl$EvictingLinkedBlockingDeque;", ExifInterface.LONGITUDE_EAST, "Ljava/util/concurrent/LinkedBlockingDeque;", "capacity", "", "<init>", "(I)V", "offerFirstWithEviction", "", "e", "(Ljava/lang/Object;)Z", "putFirstWithEviction", "", "(Ljava/lang/Object;)V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EvictingLinkedBlockingDeque<E> extends LinkedBlockingDeque<E> {
        private final int capacity;

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingDeque, java.util.Deque
        public final /* bridge */ int size() {
            return getSize();
        }

        public EvictingLinkedBlockingDeque(int r100) {
            super(r100);
            this.capacity = r100;
        }

        public final boolean offerFirstWithEviction(E r100) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (remainingCapacity() != 0) goto L7;
            pollLast();     // Catch: Throwable -> L10
            FLogger.f375446a.d("ObricSemanticServiceImp", "队列已满，丢弃队尾元素，剩余容量：" + remainingCapacity());     // Catch: Throwable -> L10
        L7:
            boolean r101 = offerFirst(r100);     // Catch: Throwable -> L10
            monitor-exit(this);
            return r101;
        }

        public final void putFirstWithEviction(E r100) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (remainingCapacity() != 0) goto L7;
            pollLast();     // Catch: Throwable -> L10
            FLogger.f375446a.d("ObricSemanticServiceImp", "队列已满，丢弃队尾元素，剩余容量：" + remainingCapacity());     // Catch: Throwable -> L10
        L7:
            putFirst(r100);     // Catch: Throwable -> L10
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(this);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.agent.IObricSemanticApi
    public final List<Message> getDeleted() {
        List r100 = CollectionsKt.toList(this.f385584a);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((Message) r103) == null) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        r104 = false;
        goto L9
    L11:
        return r101;
    }

    public ObricSemanticServiceImpl() {
        this.f385584a = new EvictingLinkedBlockingDeque(10);
    }

    @Override // com.obric.assistant.agent.IObricSemanticApi
    public final void a(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f385584a.offerFirstWithEviction(r100);
        FLogger.f375446a.d("ObricSemanticServiceImp", "deleted：" + this.f385584a);
    }
}
