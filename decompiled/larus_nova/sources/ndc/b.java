package ndc;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b<DATA extends Photo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f518843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<odc.a<DATA>> f518844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ldc.b f518845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f518846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Stack<odc.a<?>> f518847e;

    public b(ViewGroup r100, List<odc.a<DATA>> r101, ldc.b r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "components");
        Intrinsics.checkNotNullParameter(r102, "dependency");
        this.f518843a = r100;
        this.f518844b = r101;
        this.f518845c = r102;
        this.f518847e = new Stack();
    }
}
