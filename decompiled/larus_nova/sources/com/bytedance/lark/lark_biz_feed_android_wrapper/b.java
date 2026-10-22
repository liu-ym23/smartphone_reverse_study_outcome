package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.i;
import com.bytedance.lark.view_flow_wrapper.h;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface b extends h {

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final a f253230u1 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f253231a = null;

        static {
            f253231a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.lark.lark_biz_feed_android_wrapper.b$b, reason: collision with other inner class name */
    public static final class C3604b extends com.bytedance.lark.view_flow_wrapper.a<b> {
        public C3604b(Function0<? extends b> r100) {
            Intrinsics.checkNotNullParameter(r100, "serviceProvider");
            super(r100);
        }
    }

    static {
        f253230u1 = a.f253231a;
    }

    <T> Object lc(Function1<? super i, ? extends T> r100, Continuation<? super Result<? extends T>> r101);
}
