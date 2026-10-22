package com.bytedance.lark.view_flow_wrapper;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes20.dex */
public interface v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f254467a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f254468a = null;

        static {
            f254468a = new a();
        }

        public a() {
        }
    }

    public static final class b implements v {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f254469b = null;

        static {
            f254469b = new b();
        }

        public b() {
        }

        @Override // com.bytedance.lark.view_flow_wrapper.v
        public final Object a(Continuation<? super Unit> r100) {
            return Unit.INSTANCE;
        }
    }

    static {
        f254467a = a.f254468a;
    }

    Object a(Continuation<? super Unit> r100);
}
