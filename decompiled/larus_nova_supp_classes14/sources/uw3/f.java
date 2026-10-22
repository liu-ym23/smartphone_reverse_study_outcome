package uw3;

import com.bytedance.applog.filter.NativeFilterJNI;
import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.priority.PriorityWrapper;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends com.bytedance.applog.log.b<Boolean> {
    public final /* synthetic */ com.bytedance.applog.b b;
    public final /* synthetic */ g c;
    public final /* synthetic */ JSONObject d;

    public final Object a(Object[] r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        PriorityWrapper.j.b(new Object[0]);
        if (this.b.T1() == false) goto L6;
        NativeLogWrapper.a();
    L6:
        if (NativeFilterJNI.nativeInitServerFilter(this.c.d, this.b.getContext().getFilesDir().getAbsolutePath()) != 0) goto L12;
        JSONObject r4 = this.d;
        if (r4 == null) goto L10;
        NativeFilterJNI.nativeSetServerFilterConfig(this.c.d, r4.toString());
    L10:
        g r5 = this.c;
        r5.e = !NativeFilterJNI.nativeIsServerFilterEmpty(r5.d);
    L12:
        return Boolean.TRUE;
    }

    public f(com.bytedance.applog.b r1, g r2, JSONObject r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
