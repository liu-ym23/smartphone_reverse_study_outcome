package com.ss.android.lark.inline.ai.asr.subprompt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import h18.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import slb.j;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "currentIndex", "", "lastIndex", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter$OnOperateClickListener;", "setData", "", "setOnOperateClickListener", "listener", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "SubPromptViewHolder", "OnOperateClickListener", "DiffCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubPromptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<j> f426887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f426888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f426889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f426890d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/Prompt;", "newList", "lastIndex", "", "currentIndex", "<init>", "(Ljava/util/List;Ljava/util/List;II)V", "getOldListSize", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<j> f426891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<j> f426892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f426893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f426894d;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            List<j> r100 = this.f426892b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            List<j> r100 = this.f426891a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            if (r100 != this.f426893c) goto L5;
        L7:
            return false;
        L5:
            if (r101 == this.f426894d) goto L7;
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            List<j> r102 = this.f426891a;
            String r103 = null;
            if (r102 == null) goto L7;
            j r104 = (j) CollectionsKt.getOrNull(r102, r100);
            if (r104 == null) goto L7;
            String r105 = r104.f542534a;
        L8:
            List<j> r106 = this.f426892b;
            if (r106 == null) goto L14;
            j r107 = (j) CollectionsKt.getOrNull(r106, r101);
            if (r107 == null) goto L14;
            r103 = r107.f542534a;
        L14:
            return Intrinsics.areEqual(r105, r103);
        L7:
            r105 = null;
            goto L8
        }

        public DiffCallback(List<j> r100, List<j> r101, int r102, int r103) {
            this.f426891a = r100;
            this.f426892b = r101;
            this.f426893c = r102;
            this.f426894d = r103;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptAdapter$SubPromptViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "subPromptTextView", "Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptTextView;", "getSubPromptTextView", "()Lcom/ss/android/lark/inline/ai/asr/subprompt/SubPromptTextView;", "subPromptSelectedIv", "Landroidx/appcompat/widget/AppCompatImageView;", "getSubPromptSelectedIv", "()Landroidx/appcompat/widget/AppCompatImageView;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubPromptViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SubPromptTextView f426895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatImageView f426896b;

        public SubPromptViewHolder(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f426895a = (SubPromptTextView) r100.findViewById(R.id.subprompt_text);
            this.f426896b = (AppCompatImageView) r100.findViewById(R.id.subprompt_selected_iv);
        }
    }

    public interface a {
        void a(j r100);
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubPromptAdapter f426897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f426898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f426899c;

        public b(SubPromptAdapter r100, RecyclerView.ViewHolder r101, j r102) {
            this.f426897a = r100;
            this.f426898b = r101;
            this.f426899c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SubPromptAdapter r101 = this.f426897a;
            r101.f426888b = this.f426898b.getBindingAdapterPosition();
            a r102 = this.f426897a.f426890d;
            if (r102 == null) goto L5;
            r102.a(this.f426899c);
        L5:
            SubPromptAdapter r103 = this.f426897a;
            List<j> r104 = r103.f426887a;
            DiffUtil.calculateDiff(new DiffCallback(r104, r104, r103.f426889c, r103.f426888b), false).dispatchUpdatesTo(this.f426897a);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<j> r100 = this.f426887a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public SubPromptAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<j> r102 = this.f426887a;
        if (r102 == null) goto L13;
        j r103 = (j) ListProtector.get(r102, r101);
        if (r103 == null) goto L14;
        SubPromptViewHolder r104 = (SubPromptViewHolder) r100;
        int r105 = this.f426888b;
        if (r105 != r101) goto L10;
        this.f426889c = r105;
        r104.f426896b.setVisibility(0);
        SubPromptTextView r106 = r104.f426895a;
        int r107 = e.f483540a;
        r106.setTypeface(e.b(r106.getContext(), 1));
        r104.f426895a.setType("primary");
    L11:
        r104.f426895a.setText(r103.f542537d);
        r104.itemView.setOnClickListener(new b(this, r100, r103));
        return;
    L10:
        r104.f426896b.setVisibility(8);
        SubPromptTextView r108 = r104.f426895a;
        int r109 = e.f483540a;
        r108.setTypeface(e.b(r108.getContext(), 0));
        r104.f426895a.setType("default");
        goto L11
    L14:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.inline_ai_asr_subprompt_item, r100, false);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup");
        return new SubPromptViewHolder((ViewGroup) r102);
    }
}
