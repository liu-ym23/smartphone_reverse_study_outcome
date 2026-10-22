package com.ss.android.lark.inline.ai.ui.operates;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.inline.ai.api.ui.Operate;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperatesRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "operatesAdapter", "Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter;", "setData", "", "data", "", "Lcom/ss/android/lark/inline/ai/api/ui/Operate;", "setOnOperateClickListener", "listener", "Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$OnOperateClickListener;", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperatesRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OperatesAdapter f427578a;

    public static final class a {
    }

    static {
    }

    public OperatesRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OperatesRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setData(List<Operate> r100) {
        OperatesAdapter r101 = this.f427578a;
        r101.getClass();
        DiffUtil.calculateDiff(new OperatesAdapter.DiffCallback(r101.f427572a, r100), false).dispatchUpdatesTo(r101);
        r101.f427572a = r100;
    }

    public final void setOnOperateClickListener(OperatesAdapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        OperatesAdapter r101 = this.f427578a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f427573b = r100;
    }

    public OperatesRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        OperatesAdapter r103 = new OperatesAdapter();
        this.f427578a = r103;
        setAdapter(r103);
        setLayoutManager(new LinearLayoutManager(r100, 0, false));
        addItemDecoration(new AnonymousClass1());
        setItemAnimator(null);
    }

    public /* synthetic */ OperatesRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
