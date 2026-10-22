package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.MoltenFfiLibLarkBizFeed;
import com.bytedance.lark.lark_biz_feed_android.g;
import com.bytedance.lark.lark_biz_feed_android.m;
import com.bytedance.lark.view_flow_wrapper.e;
import com.bytedance.lark.view_flow_wrapper.i;
import com.bytedance.lark.view_flow_wrapper.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class c<VF extends i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<VF> f253232a;

    public static final class a implements g {
        public a() {
        }

        @Override // com.bytedance.lark.lark_biz_feed_android.g
        public final byte[] a(m r110) {
            Intrinsics.checkNotNullParameter(r110, "info");
            e r100 = com.bytedance.lark.view_flow_wrapper.internal.a.f254437a;
            k r101 = new k(r110.f253174a, r110.f253175b, r110.f253176c, r110.f253177d, r110.f253178e);
            Intrinsics.checkNotNullParameter(r101, "info");
            e r111 = com.bytedance.lark.view_flow_wrapper.internal.a.f254437a;
            if (r111 != null) goto L7;
            return null;
        L7:
            return r111.a(r101);
        }

        @Override // com.bytedance.lark.lark_biz_feed_android.g
        public final void onInvokeeEnd(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "invokeeObj");
            e r101 = com.bytedance.lark.view_flow_wrapper.internal.a.f254437a;
            Intrinsics.checkNotNullParameter(r100, "invokeeObj");
            e r102 = com.bytedance.lark.view_flow_wrapper.internal.a.f254437a;
            if (r102 == null) goto L6;
            r102.onInvokeeEnd(r100);
            return;
        }

        @Override // com.bytedance.lark.lark_biz_feed_android.g
        public final Object onInvokeeStart(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "hookBuf");
            e r101 = com.bytedance.lark.view_flow_wrapper.internal.a.f254437a;
            Intrinsics.checkNotNullParameter(r100, "hookBuf");
            e r102 = com.bytedance.lark.view_flow_wrapper.internal.a.f254437a;
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.onInvokeeStart(r100);
        }
    }

    public static final class b {
    }

    static {
        MoltenFfiLibLarkBizFeed.f253144b = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<? extends VF> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewFlowProvider");
        this.f253232a = r100;
    }
}
