package lx1;

import android.content.Context;
import com.bytedance.android.live.base.model.feedback.Option;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kx1.h;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements b<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f511114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kx1.e f511115b;

    @Override // lx1.b
    public final List<h> a(List<Option> r100) {
        if (r100 == null) goto L7;
        List<Option> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L10;
        Option r104 = (Option) r103.next();
        r102.add(new h(this.f511114a, r104, this.f511115b));
        goto L5
    L10:
        return r102;
    L7:
        return null;
    }

    public e(Context r100, mx1.d.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "selectListener");
        this.f511114a = r100;
        this.f511115b = r101;
    }
}
