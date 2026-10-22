package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import com.bytedance.android.shopping.prepurchase.arch.container.ability.r;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/state/h;", "STATE", "STORE", "Lcom/bytedance/android/shopping/prepurchase/arch/standard/component/pref/TaskScheduler;", "invoke", "()Lcom/bytedance/android/shopping/prepurchase/arch/standard/component/pref/TaskScheduler;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class StandardPrefService$taskScheduler$2 extends Lambda implements Function0<TaskScheduler> {
    final /* synthetic */ StandardPrefService this$0;

    public static final class a implements d {
        public final /* synthetic */ StandardPrefService$taskScheduler$2 a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.StandardPrefService$taskScheduler$2$a$a, reason: collision with other inner class name */
        public static final class RunnableC0156a implements Runnable {
            public final /* synthetic */ r a;
            public final /* synthetic */ a b;
            public final /* synthetic */ int c;

            public RunnableC0156a(r r1, a r2, int r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.b.a.this$0, "execute: " + this.c + ' ' + this.a.getName());
                this.a.t();
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ r b;

            public b(a r1, r r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                StandardPrefService r0 = this.a.a.this$0;     // Catch: Throwable -> L10
                StringBuilder r1 = new StringBuilder("execute: ");     // Catch: Throwable -> L10
                r r2 = this.b;     // Catch: Throwable -> L10
                if (r2 == null) goto L5;
                String r3 = r2.getName();     // Catch: Throwable -> L10
            L6:
                r1.append(r3);     // Catch: Throwable -> L10
                com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(r0, r1.toString());     // Catch: Throwable -> L10
                r r4 = this.b;     // Catch: Throwable -> L10
                if (r4 == null) goto L13;
                r4.t();     // Catch: Throwable -> L10
                return;
            L13:
                return;
            L5:
                r3 = null;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L17;
                throw th;
            }
        }

        public a(StandardPrefService$taskScheduler$2 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.pref.d
        public final void a(int r4, List<? extends r> r5) {
            Intrinsics.checkNotNullParameter(r5, "tasks");
            if (r4 != 3) goto L9;
            int r6 = r5.size();
        L5:
            r6 = r6 - 1;
            if (r6 < 0) goto L18;
            StandardPrefService.a2(this.a.this$0).postAtFrontOfQueue(new b(this, (r) CollectionsKt.getOrNull(r5, r6)));
            goto L5
        L18:
            return;
        L9:
            if (r4 != 4) goto L14;
            Iterator<T> r7 = r5.iterator();
        L12:
            if (r7.hasNext() == false) goto L22;
            StandardPrefService.a2(this.a.this$0).post(new RunnableC0156a((r) r7.next(), this, r4));
            goto L12
        L22:
            return;
        L14:
            Iterator<T> r8 = r5.iterator();
        L16:
            if (r8.hasNext() == false) goto L23;
            r r9 = (r) r8.next();
            com.bytedance.android.shopping.prepurchase.arch.container.component.b.a(this.a.this$0, "execute: " + r9.getName());
            r9.t();
            goto L16
        }
    }

    public StandardPrefService$taskScheduler$2(StandardPrefService r1) {
        this.this$0 = r1;
        super(0);
    }

    public final TaskScheduler invoke() {
        return new TaskScheduler(new a(this), this.this$0.O1().w7());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2518invoke() {
        return invoke();
    }
}
