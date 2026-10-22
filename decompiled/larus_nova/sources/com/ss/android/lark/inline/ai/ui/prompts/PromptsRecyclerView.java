package com.ss.android.lark.inline.ai.ui.prompts;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "promptsAdapter", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter;", "onShadowChangeListener", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsRecyclerView$OnShadowChangeListener;", "setData", "", "promptGroups", "", "Lcom/ss/android/lark/inline/ai/api/ui/PromptGroup;", "setOnPromptClickListener", "listener", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$OnPromptClickListener;", "setOnShadowChangeListener", "Companion", "OnShadowChangeListener", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptsRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PromptsAdapter f427600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f427601b;

    public static final class a {
    }

    public interface b {
        void a(boolean r100);
    }

    static {
    }

    public PromptsRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PromptsRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setData(List<PromptGroup> r100) {
        PromptsAdapter r101 = this.f427600a;
        r101.getClass();
        ArrayList r102 = null;
        if (r100 == null) goto L24;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L7:
        if (r104.hasNext() == false) goto L23;
        PromptGroup r105 = (PromptGroup) r104.next();
        String r106 = r105.getTitle();
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L17;
        r103.add(new PromptsAdapter.c(true, r105.getTitle(), null));
    L17:
        ArrayList<Prompt> r108 = r105.getPrompts();
        if (r108 == null) goto L7;
        Iterator<T> r109 = r108.iterator();
    L21:
        if (r109.hasNext() == false) goto L7;
        r103.add(new PromptsAdapter.c(false, null, (Prompt) r109.next()));
        goto L21
    L11:
        if (r106.length() == 0) goto L14;
        r107 = false;
        goto L15
    L23:
        r102 = r103;
    L24:
        DiffUtil.calculateDiff(new PromptsAdapter.DiffCallback(r101.f427582a, r102), false).dispatchUpdatesTo(r101);
        r101.f427582a = r102;
    }

    public final void setOnPromptClickListener(PromptsAdapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        PromptsAdapter r101 = this.f427600a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f427583b = r100;
    }

    public final void setOnShadowChangeListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f427601b = r100;
    }

    public PromptsRecyclerView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        PromptsAdapter r103 = new PromptsAdapter();
        this.f427600a = r103;
        setAdapter(r103);
        setLayoutManager(new LinearLayoutManager(r100, 1, false));
        addItemDecoration(new AnonymousClass1(this, r100));
        setItemAnimator(null);
    }

    public /* synthetic */ PromptsRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
