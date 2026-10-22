package lx1;

import android.content.Context;
import com.bytedance.android.live.base.model.feedback.Option;
import com.bytedance.android.livesdk.feedback.view.feedback.LargeCardPreviewFeedback;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kx1.g;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements b<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f511112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kx1.d f511113b;

    @Override // lx1.b
    public final List<g> a(List<Option> r100) {
        if (r100 == null) goto L7;
        List<Option> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L5:
        if (r103.hasNext() == false) goto L10;
        Option r104 = (Option) r103.next();
        r102.add(new g(this.f511112a, r104, this.f511113b));
        goto L5
    L10:
        return r102;
    L7:
        return null;
    }

    public d(Context r100, LargeCardPreviewFeedback.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "clickListener");
        this.f511112a = r100;
        this.f511113b = r101;
    }
}
