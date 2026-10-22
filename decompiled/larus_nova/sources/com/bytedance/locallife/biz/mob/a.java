package com.bytedance.locallife.biz.mob;

import android.content.Context;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.lynx.tasm.LynxError;
import com.ss.android.ugc.aweme.etkit.IEventTrackInterceptor;
import com.ss.android.ugc.aweme.etkit.Params;
import com.ss.android.ugc.aweme.etkit.TrackModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f256703c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f256704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<IEventTrackInterceptor> f256705b;

    /* JADX INFO: renamed from: com.bytedance.locallife.biz.mob.a$a, reason: collision with other inner class name */
    public static final class C3646a {
        public static void a(mq6.c r100, EventType r101) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "eventType");
            String r102 = String.valueOf(r101.getType());
            r100.getClass();
            mq6.a r103 = mq6.c.a.f514894a;
            r100.g("life_event_type", r102);
        }

        public static void c(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "map");
            b(r100, new e(MapsKt.toMutableMap(r101)), null, null);
        }

        public static void d(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "jsonObject");
            b(r100, new c(r101), null, null);
        }

        public static void b(String r100, Params r101, Context r102, List r103) {
            TrackModel r104 = new TrackModel(r100, r101);
            List<? extends IEventTrackInterceptor> r105 = b.f256706a;
            Intrinsics.checkNotNullParameter(r104, "trackModel");
            ArrayList r106 = new ArrayList();
            if (r103 == null) goto L5;
            r106.addAll(r103);
        L5:
            r106.addAll(b.f256706a);
            Iterator r107 = r106.iterator();
        L7:
            if (r107.hasNext() == false) goto L20;
            IEventTrackInterceptor r108 = (IEventTrackInterceptor) r107.next();
            Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L11
            r108.a(r102, r104);     // Catch: Throwable -> L11
            Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        L13:
            Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
            if (r111 == null) goto L7;
            ETkitException r112 = new ETkitException(r111);
            Intrinsics.checkNotNullParameter(r112, LynxError.LYNX_THROWABLE);
            if (HostServiceUtilsKt.u().g() == true) goto L19;
            HostServiceUtilsKt.c().b(r112);
            goto L7
        L19:
            throw r112;
        L11:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L13
        }
    }

    static {
    }

    public final Context getContext() {
        return this.f256704a;
    }

    public a(Context r100) {
        this.f256704a = r100;
        this.f256705b = new CopyOnWriteArrayList();
    }

    public final f b(Function1<? super f, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "compose");
        f r101 = new f(this);
        r100.invoke(r101);
        return r101;
    }

    public final void a(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "map");
        C3646a.b(r100, new e(MapsKt.toMutableMap(r101)), this.f256704a, this.f256705b);
    }
}
