package com.obric.assistant.state.multitask;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f393276a = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f393277a = null;

        static {
            f393277a = new a();
        }

        public a() {
        }

        public static void a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "eventBuilder");
            b r101 = c.f393279a;
            b r102 = c.f393279a;
            if (r102.isEnabled() == false) goto L6;
            r102.a((com.obric.assistant.state.multitask.a) r100.invoke());
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.state.multitask.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes5.dex */
    public static final class C4635b implements b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C4635b f393278b = null;

        static {
            f393278b = new C4635b();
        }

        public C4635b() {
        }

        @Override // com.obric.assistant.state.multitask.b
        public final void a(com.obric.assistant.state.multitask.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.obric.assistant.state.multitask.b
        public final void b(com.obric.assistant.state.multitask.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.obric.assistant.state.multitask.b
        public final boolean isEnabled() {
            return false;
        }
    }

    static {
        f393276a = a.f393277a;
    }

    void a(com.obric.assistant.state.multitask.a r100);

    void b(com.obric.assistant.state.multitask.a r100);

    boolean isEnabled();
}
