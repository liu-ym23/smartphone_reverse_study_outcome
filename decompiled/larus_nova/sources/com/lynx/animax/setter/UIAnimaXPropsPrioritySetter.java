package com.lynx.animax.setter;

import com.lynx.animax.AnimaXPlayer;
import java.lang.ref.WeakReference;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes32.dex */
public final class UIAnimaXPropsPrioritySetter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue<b> f380418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<AnimaXPlayer> f380419b;

    public static final enum ExecutionPriority extends Enum<ExecutionPriority> {
        public static final ExecutionPriority DEFAULT = null;
        public static final ExecutionPriority HIGH = null;
        public static final ExecutionPriority LOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExecutionPriority[] f380420a = null;
        private final int value;

        static {
            ExecutionPriority r100 = new ExecutionPriority("HIGH", 0, -100);
            HIGH = r100;
            ExecutionPriority r101 = new ExecutionPriority("DEFAULT", 1, 0);
            DEFAULT = r101;
            ExecutionPriority r102 = new ExecutionPriority("LOW", 2, 100);
            LOW = r102;
            f380420a = new ExecutionPriority[]{r100, r101, r102};
        }

        public static ExecutionPriority[] values() {
            return (ExecutionPriority[]) f380420a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ExecutionPriority valueOf(String r100) {
            return (ExecutionPriority) r27.a.a(ExecutionPriority.class, r100);
        }

        public ExecutionPriority(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @FunctionalInterface
    public interface a {
        void a(AnimaXPlayer r100) throws Exception;
    }

    public static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f380421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ExecutionPriority f380422b;

        @Override // java.lang.Comparable
        public final int compareTo(b r100) {
            return Integer.compare(this.f380422b.getValue(), r100.f380422b.getValue());
        }

        public b(a r100, ExecutionPriority r101) {
            this.f380421a = r100;
            this.f380422b = r101;
        }
    }

    public UIAnimaXPropsPrioritySetter() {
        this.f380418a = new PriorityQueue();
    }

    public final void a(a r100) {
        b(r100, ExecutionPriority.DEFAULT);
    }

    public final void b(a r100, ExecutionPriority r101) {
        b r102 = new b(r100, r101);
        this.f380418a.add(r102);
    }
}
