package com.larus.livetutor.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0014\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007J&\u0010\u0019\u001a\u00020\u000f2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001b\u0010\u001a\u001a\u00020\u000f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011H\u0000¢\u0006\u0002\b\u001bR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/livetutor/impl/view/TutorStarListView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "starList", "", "Lcom/larus/livetutor/impl/view/TutorStarItem;", "listener", "Lkotlin/Function2;", "", "decorationChangeListener", "Lkotlin/Function0;", "updateDecoration", "updateData", "data", "", "getViewRectByPosition", "Landroid/graphics/Rect;", "position", "setOnItemSelectedListener", "setDecorationChangeListener", "setDecorationChangeListener$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TutorStarListView extends RecyclerView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f356798d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<m2> f356799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Integer, ? super List<m2>, Unit> f356800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f356801c;

    public TutorStarListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TutorStarListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setDecorationChangeListener$impl_mainlandRelease(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f356801c = r100;
    }

    public final void setOnItemSelectedListener(Function2<? super Integer, ? super List<m2>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f356800b = r100;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.livetutor.impl.view.n2] */
    public TutorStarListView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ArrayList r103 = new ArrayList();
        this.f356799a = r103;
        setAdapter(new TutorStarAdapter(r103, new n2(this)));
        setLayoutManager(new LinearLayoutManager(r100, 0, false));
        setOverScrollMode(2);
        setItemAnimator(null);
        setClipChildren(false);
        setClipToPadding(false);
        post(new o2(this));
    }

    public /* synthetic */ TutorStarListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
