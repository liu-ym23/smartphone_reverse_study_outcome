package lx1;

import android.content.Context;
import com.bytedance.android.live.base.model.feedback.Option;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements b<kx1.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f511108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kx1.e f511109b;

    @Override // lx1.b
    public final List<kx1.b> a(List<Option> r100) {
        if (r100 == null) goto L7;
        List<Option> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L10;
        Option r104 = (Option) r103.next();
        r102.add(new kx1.b(this.f511108a, r104, this.f511109b));
        goto L5
    L10:
        return r102;
    L7:
        return null;
    }

    public a(Context r100, mx1.a.C6868a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "selectListener");
        this.f511108a = r100;
        this.f511109b = r101;
    }
}
