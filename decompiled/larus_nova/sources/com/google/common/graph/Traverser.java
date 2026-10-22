package com.google.common.graph;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Deque;

/* JADX INFO: loaded from: classes23.dex */
@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
@ElementTypesAreNonnullByDefault
public abstract class Traverser<N> {

    public static abstract enum InsertionOrder extends Enum<InsertionOrder> {
        public static final InsertionOrder BACK = null;
        public static final InsertionOrder FRONT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InsertionOrder[] f275555a = null;

        public InsertionOrder() {
            throw null;
        }

        public abstract <T> void insertInto(Deque<T> r100, T r101);

        static {
            final String r100 = "FRONT";
            final int r101 = 0;
            InsertionOrder r102 = new AnonymousClass1(r100, r101);
            FRONT = r102;
            final String r103 = "BACK";
            final int r104 = 1;
            InsertionOrder r105 = new AnonymousClass2(r103, r104);
            BACK = r105;
            f275555a = new InsertionOrder[]{r102, r105};
        }

        public static InsertionOrder[] values() {
            return (InsertionOrder[]) f275555a.clone();
        }

        public static InsertionOrder valueOf(String r100) {
            return (InsertionOrder) r27.a.a(InsertionOrder.class, r100);
        }

        public InsertionOrder(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }
}
