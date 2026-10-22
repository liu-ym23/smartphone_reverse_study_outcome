package c35;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;
import tk5.c;
import tk5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements c {
    public final /* synthetic */ a a;
    public final /* synthetic */ m b;

    public final void a(d<? extends vk5.c> r4) {
        Intrinsics.checkNotNullParameter(r4, "mission");
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.a.getId());
        m r5 = this.b;
        if (r5 == null) goto L6;
        r5.b(new JSONObject(MapsKt.mapOf(TuplesKt.to(JSEventListener.ACTION, TipCallBackData.CONFIRM))));
        return;
    }

    public final void b(d<? extends vk5.c> r4) {
        Intrinsics.checkNotNullParameter(r4, "mission");
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.a.getId());
        m r5 = this.b;
        if (r5 == null) goto L6;
        r5.b(new JSONObject(MapsKt.mapOf(TuplesKt.to(JSEventListener.ACTION, "dismiss"))));
        return;
    }

    public final void c(d<? extends vk5.c> r4) {
        Intrinsics.checkNotNullParameter(r4, "mission");
        ((sk5.b) org.koin.java.a.c(sk5.b.class, null, null, 6)).b().c(this.a.getId());
        m r5 = this.b;
        if (r5 == null) goto L6;
        r5.b(new JSONObject(MapsKt.mapOf(TuplesKt.to(JSEventListener.ACTION, "cancel"))));
        return;
    }

    public b(a r1, m r2) {
        this.a = r1;
        this.b = r2;
    }
}
