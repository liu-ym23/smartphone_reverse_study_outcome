package lx1;

import android.content.Context;
import com.bytedance.android.live.base.model.feedback.Option;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kx1.f;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements b<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f511110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kx1.e f511111b;

    @Override // lx1.b
    public final List<f> a(List<Option> r100) {
        if (r100 == null) goto L7;
        List<Option> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L10;
        Option r104 = (Option) r103.next();
        r102.add(new f(this.f511110a, r104, this.f511111b));
        goto L5
    L10:
        return r102;
    L7:
        return null;
    }

    public c(Context r100, kx1.e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "selectListener");
        this.f511110a = r100;
        this.f511111b = r101;
    }
}
