package qh0;

import android.content.Context;
import com.bytedance.android.live.liveinteract.plantform.permission.checker.s;
import com.bytedance.android.live.liveinteract.plantform.permission.checker.t;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    public static final class a implements qh0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f532889a;

        public final Context getContext() {
            return this.f532889a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f532889a = r100;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r100) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.a(this, r100);
        }
    }

    public static final class b implements qh0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f532890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OperateType f532891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f532892c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f532893d;

        public final Context getContext() {
            return this.f532890a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r100) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.e(this);
        }

        public b(Context r100, OperateType r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateType");
            this.f532890a = r100;
            this.f532891b = r101;
            this.f532892c = r102;
            this.f532893d = false;
        }
    }

    public static final class c implements qh0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f532894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OperateType f532895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f532896c;

        public final Context getContext() {
            return this.f532894a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r100) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.i(this, r100);
        }

        public c(Context r100, OperateType r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateType");
            this.f532894a = r100;
            this.f532895b = r101;
            this.f532896c = r102;
        }
    }

    public static final class d implements qh0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f532897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OperateType f532898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f532899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f532900d;

        public final Context getContext() {
            return this.f532897a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r100) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.m(this, r100);
        }

        public d(Context r100, OperateType r101, int r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateType");
            this.f532897a = r100;
            this.f532898b = r101;
            this.f532899c = r102;
            this.f532900d = r103;
        }
    }

    public static final class e implements qh0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f532901a;

        public final Context getContext() {
            return this.f532901a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r100) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.q(this, r100);
        }

        public e(Context r100, OperateType r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateType");
            this.f532901a = r100;
        }
    }

    /* JADX INFO: renamed from: qh0.f$f, reason: collision with other inner class name */
    public static final class C7326f implements qh0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f532902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OperateType f532903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f532904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f532905d;

        public final Context getContext() {
            return this.f532902a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r100) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.r(this, r100);
        }

        public C7326f(Context r100, OperateType r101, int r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateType");
            this.f532902a = r100;
            this.f532903b = r101;
            this.f532904c = r102;
            this.f532905d = r103;
        }
    }

    public static final class g implements qh0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f532906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OperateType f532907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f532908c;

        public final Context getContext() {
            return this.f532906a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r100) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.o(this, r100);
        }

        public g(Context r100, OperateType r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateType");
            this.f532906a = r100;
            this.f532907b = r101;
            this.f532908c = r102;
        }
    }

    public static final class h implements qh0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f532909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OperateType f532910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f532911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f532912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final IRoom f532913e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f532914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f532915g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final j1 f532916h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Function2<? super String, ? super String, Unit> f532917i;

        public final Context getContext() {
            return this.f532909a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r100) {
            return new t(this, r100, this.f532916h, this.f532917i);
        }

        public h(Context r100, OperateType r101, int r102, int r103, IRoom r104, String r105, String r106, j1 r110, Function2 r111, int r112) {
            if ((r112 & 32) == 0) goto L6;
            r105 = "0";
        L6:
            if ((r112 & 256) == 0) goto L9;
            r106 = null;
        L9:
            if ((r112 & 512) == 0) goto L12;
            r110 = null;
        L12:
            if ((r112 & 1024) == 0) goto L14;
            r111 = null;
        L14:
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "operateType");
            Intrinsics.checkNotNullParameter(r105, "toUserId");
            this.f532909a = r100;
            this.f532910b = r101;
            this.f532911c = r102;
            this.f532912d = r103;
            this.f532913e = r104;
            this.f532914f = r105;
            this.f532915g = r106;
            this.f532916h = r110;
            this.f532917i = r111;
        }
    }

    static {
    }

    @JvmStatic
    public static final s a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "createConfigs");
        Iterator r101 = r100.iterator();
        qh0.a<rh0.a> r102 = null;
    L4:
        if (r101.hasNext() == false) goto L7;
        r102 = ((qh0.c) r101.next()).a(r102);
        goto L4
    L7:
        return new s(r102);
    }
}
