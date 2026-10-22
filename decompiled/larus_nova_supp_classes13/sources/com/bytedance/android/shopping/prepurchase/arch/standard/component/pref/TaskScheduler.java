package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import android.view.Choreographer;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.j;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.r;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class TaskScheduler {
    public static final /* synthetic */ int i = 0;
    public int a;
    public final Map<Integer, List<r>> b;
    public f c;
    public final e d;
    public b e;
    public NFrameWatcher f;
    public final d g;
    public final j h;

    public static final class NFrameWatcher {
        public int a;
        public final PostNFrameTask b;
        public final int c;
        public final Function0<Unit> d;

        public final class PostNFrameTask implements Choreographer.FrameCallback {
            public final /* synthetic */ NFrameWatcher a;

            public PostNFrameTask(NFrameWatcher r1) {
                this.a = r1;
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long r2) {
                NFrameWatcher r3 = this.a;
                int r4 = r3.a + 1;
                r3.a = r4;
                if (r4 != r3.c) goto L5;
                r3.a = -1;
                r3.d.invoke();
                return;
            L5:
                com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$NFrameWatcher$PostNFrameTask$doFrame$1(this));
            }
        }

        public NFrameWatcher(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "readyCallback");
            this.c = 3;
            this.d = r2;
            this.a = -1;
            this.b = new PostNFrameTask(this);
        }
    }

    public static final class a {
    }

    static {
    }

    public TaskScheduler(StandardPrefService$taskScheduler$2.a r2, j r3) {
        Intrinsics.checkNotNullParameter(r2, "executor");
        Intrinsics.checkNotNullParameter(r3, "logAbility");
        this.g = r2;
        this.h = r3;
        this.b = new LinkedHashMap();
        this.d = new e(this);
    }

    public static final boolean a(TaskScheduler r4, int r5) {
        if (r4.a < r5) goto L5;
        return false;
    L5:
        r4.a = r5;
        List<r> r0 = r4.b.remove(Integer.valueOf(r5));
        j r1 = r4.h;
        StringBuilder r2 = new StringBuilder("stage = ");
        r2.append(r5);
        r2.append(",taskSize=");
        if (r0 == null) goto L8;
        Integer r3 = Integer.valueOf(r0.size());
    L9:
        r2.append(r3);
        r1.d("TaskScheduler", r2.toString());
        b r6 = r4.e;
        if (r6 == null) goto L12;
        r6.a(r5);
    L12:
        if (r0 == null) goto L15;
        r4.g.a(r5, r0);
    L15:
        b r7 = r4.e;
        if (r7 == null) goto L18;
        r7.b();
    L18:
        return true;
    L8:
        r3 = null;
        goto L9
    }

    public final void b(final int r2, final com.bytedance.android.shopping.prepurchase.arch.container.ability.b r3, final Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "task");
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new TaskScheduler$enqueue$1(this, r2, r3, r4));
    }
}
