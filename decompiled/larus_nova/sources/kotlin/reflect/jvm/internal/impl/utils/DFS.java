package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes42.dex */
public class DFS {

    public static abstract class AbstractNodeHandler<N, R> implements NodeHandler<N, R> {
        public AbstractNodeHandler() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public void afterChildren(N r100) {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public boolean beforeChildren(N r100) {
            return true;
        }
    }

    public static abstract class CollectingNodeHandler<N, R, C extends Iterable<R>> extends AbstractNodeHandler<N, C> {
        protected final C result;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            if (r100 == 1) goto L5;
            String r101 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L7:
            if (r100 == 1) goto L9;
            int r102 = 3;
        L10:
            Object[] r103 = new Object[r102];
            if (r100 == 1) goto L13;
            r103[0] = "result";
        L14:
            if (r100 == 1) goto L16;
            r103[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
        L17:
            if (r100 == 1) goto L19;
            r103[2] = "<init>";
        L19:
            String r104 = String.format(r101, r103);
            if (r100 == 1) goto L23;
            throw new IllegalArgumentException(r104);
        L23:
            throw new IllegalStateException(r104);
        L16:
            r103[1] = "result";
            goto L17
        L13:
            r103[0] = "kotlin/reflect/jvm/internal/impl/utils/DFS$CollectingNodeHandler";
            goto L14
        L9:
            r102 = 2;
            goto L10
        L5:
            r101 = "@NotNull method %s.%s must not return null";
            goto L7
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public C result() {
            C r100 = this.result;
            if (r100 != null) goto L5;
            $$$reportNull$$$0(1);
        L5:
            return r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
        public /* bridge */ /* synthetic */ Object result() {
            return result();
        }

        public CollectingNodeHandler(C r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.result = r100;
        }
    }

    public interface Neighbors<N> {
        Iterable<? extends N> getNeighbors(N r100);
    }

    public interface NodeHandler<N, R> {
        void afterChildren(N r100);

        boolean beforeChildren(N r100);

        R result();
    }

    public static abstract class NodeHandlerWithListResult<N, R> extends CollectingNodeHandler<N, R, LinkedList<R>> {
        public NodeHandlerWithListResult() {
            super(new LinkedList());
        }
    }

    public interface Visited<N> {
        boolean checkAndMarkVisited(N r100);
    }

    public static class VisitedWithSet<N> implements Visited<N> {
        private final Set<N> visited;

        private static /* synthetic */ void $$$reportNull$$$0(int r100) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"}));
        }

        public VisitedWithSet() {
            this(new HashSet());
        }

        public VisitedWithSet(Set<N> r100) {
            if (r100 != null) goto L4;
            $$$reportNull$$$0(0);
        L4:
            this.visited = r100;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Visited
        public boolean checkAndMarkVisited(N r100) {
            return this.visited.add(r100);
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r100) {
        Object[] r101 = new Object[3];
        switch(r100) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L4;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L4;
            case 8: goto L10;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L6;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L4;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L4;
            case 21: goto L10;
            case 22: goto L5;
            case 23: goto L10;
            case 24: goto L9;
            case 25: goto L8;
            default: goto L4;
        };
    L4:
        r101[0] = "nodes";
    L11:
        r101[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch(r100) {
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L16;
            case 15: goto L16;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L15;
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L15;
            case 22: goto L14;
            case 23: goto L14;
            case 24: goto L14;
            case 25: goto L14;
            default: goto L13;
        };
    L13:
        r101[2] = "dfs";
    L19:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r101));
    L14:
        r101[2] = "doDfs";
        goto L19
    L15:
        r101[2] = "topologicalOrder";
        goto L19
    L16:
        r101[2] = "dfsFromNode";
        goto L19
    L17:
        r101[2] = "ifAny";
        goto L19
    L5:
        r101[0] = "current";
        goto L11
    L6:
        r101[0] = "node";
        goto L11
    L7:
        r101[0] = "predicate";
        goto L11
    L8:
        r101[0] = "handler";
        goto L11
    L9:
        r101[0] = "visited";
        goto L11
    L10:
        r101[0] = "neighbors";
        goto L11
    }

    public static <N, R> R dfs(Collection<N> r100, Neighbors<N> r101, NodeHandler<N, R> r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(4);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(5);
    L6:
        if (r102 != null) goto L9;
        $$$reportNull$$$0(6);
    L9:
        return (R) dfs(r100, r101, new VisitedWithSet(), r102);
    }

    public static <N> Boolean ifAny(Collection<N> r100, Neighbors<N> r101, final Function1<N, Boolean> r102) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(7);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(8);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(9);
    L8:
        final boolean[] r103 = new boolean[1];
        return (Boolean) dfs(r100, r101, new AnonymousClass1(r102, r103));
    }

    public static <N, R> R dfs(Collection<N> r100, Neighbors<N> r101, Visited<N> r102, NodeHandler<N, R> r103) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(0);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(1);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(2);
    L8:
        if (r103 != null) goto L10;
        $$$reportNull$$$0(3);
    L10:
        Iterator<N> r104 = r100.iterator();
    L12:
        if (r104.hasNext() == false) goto L15;
        doDfs(r104.next(), r101, r102, r103);
        goto L12
    L15:
        return r103.result();
    }

    public static <N> void doDfs(N r100, Neighbors<N> r101, Visited<N> r102, NodeHandler<N, ?> r103) {
        if (r100 != null) goto L4;
        $$$reportNull$$$0(22);
    L4:
        if (r101 != null) goto L6;
        $$$reportNull$$$0(23);
    L6:
        if (r102 != null) goto L8;
        $$$reportNull$$$0(24);
    L8:
        if (r103 != null) goto L11;
        $$$reportNull$$$0(25);
    L11:
        if (r102.checkAndMarkVisited(r100) == true) goto L14;
        return;
    L14:
        if (r103.beforeChildren(r100) == true) goto L16;
        return;
    L16:
        Iterator<? extends N> r104 = r101.getNeighbors(r100).iterator();
    L18:
        if (r104.hasNext() == false) goto L20;
        doDfs(r104.next(), r101, r102, r103);
        goto L18
    L20:
        r103.afterChildren(r100);
    }
}
