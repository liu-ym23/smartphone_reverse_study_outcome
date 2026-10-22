package com.ss.android.lark.inline.ai.ui.prompts;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.ui.f0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\b\u001d\u001e\u001f !\"#$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tJ \u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$PromptForRv;", "onPromptClickListener", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$OnPromptClickListener;", "setData", "", "promptGroups", "Lcom/ss/android/lark/inline/ai/api/ui/PromptGroup;", "setOnPromptClickListener", "listener", "convertPromptGroup", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onBindChildViewHolder", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$ChildViewHolder;", "getItemViewType", "Companion", "ParentViewHolder", "ChildViewHolder", "RecentViewHolder", "PromptForRv", "ItemViewType", "OnPromptClickListener", "DiffCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<c> f427582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f427583b;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$ChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "icon", "Landroidx/appcompat/widget/AppCompatImageView;", "getIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "text", "Landroidx/appcompat/widget/AppCompatTextView;", "getText", "()Landroidx/appcompat/widget/AppCompatTextView;", "rightArrow", "getRightArrow", "background", "Landroid/graphics/drawable/StateListDrawable;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class ChildViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatImageView f427584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatTextView f427585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f427586c;

        public final StateListDrawable T3() {
            StateListDrawable r100 = new StateListDrawable();
            int[] r101 = {R.attr.state_pressed};
            GradientDrawable r102 = new GradientDrawable();
            r102.setColor(ContextCompat.getColor(this.itemView.getContext(), com.larus.nova.R.color.fill_hover));
            r102.setCornerRadius(f0.a(6));
            Unit r103 = Unit.INSTANCE;
            r100.addState(r101, r102);
            GradientDrawable r104 = new GradientDrawable();
            Context r105 = this.itemView.getContext();
            com.ss.android.lark.storage.a r106 = com.ss.android.lark.inline.ai.logic.b.f427283a;
            r104.setColor(ContextCompat.getColor(r105, com.larus.nova.R.color.bg_float));
            r104.setCornerRadius(f0.a(6));
            r100.addState(new int[0], r104);
            return r100;
        }

        public ChildViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f427584a = (AppCompatImageView) r100.findViewById(com.larus.nova.R.id.prompt_child_icon);
            AppCompatTextView r101 = (AppCompatTextView) r100.findViewById(com.larus.nova.R.id.prompt_child_text);
            this.f427585b = r101;
            this.f427586c = (AppCompatImageView) r100.findViewById(com.larus.nova.R.id.prompt_right_arrow);
            r101.setTextSize(16.0f);
            r101.setTextColor(ContextCompat.getColor(r101.getContext(), com.larus.nova.R.color.text_title));
            this.itemView.setBackground(T3());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$PromptForRv;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f427587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f427588b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            List<c> r100 = this.f427588b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            List<c> r100 = this.f427587a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public DiffCallback(List<c> r100, List<c> r101) {
            this.f427587a = r100;
            this.f427588b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            List<c> r102 = this.f427587a;
            if (r102 == null) goto L24;
            c r103 = (c) CollectionsKt.getOrNull(r102, r100);
            if (r103 == null) goto L27;
            List<c> r104 = this.f427588b;
            if (r104 == null) goto L25;
            c r105 = (c) CollectionsKt.getOrNull(r104, r101);
            if (r105 == null) goto L28;
            boolean r106 = r103.f427591a;
            if (r106 == r105.f427591a) goto L15;
            return false;
        L15:
            if (r106 == true) goto L17;
        L20:
            Prompt r107 = r103.f427593c;
            if (r107 != null) goto L23;
            return false;
        L23:
            return r107.equals(r105.f427593c);
        L17:
            if (Intrinsics.areEqual(r103.f427592b, r105.f427592b) == false) goto L20;
            return true;
        L28:
            return false;
        L25:
            return false;
        L27:
            return false;
        L24:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$ParentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ParentViewHolder extends RecyclerView.ViewHolder {
        public ParentViewHolder(AppCompatTextView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            View r101 = this.itemView;
            Context r102 = r101.getContext();
            com.ss.android.lark.storage.a r103 = com.ss.android.lark.inline.ai.logic.b.f427283a;
            r101.setBackgroundColor(ContextCompat.getColor(r102, com.larus.nova.R.color.bg_float));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$RecentViewHolder;", "Lcom/ss/android/lark/inline/ai/ui/prompts/PromptsAdapter$ChildViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "deleteIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getDeleteIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "leftContentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLeftContentView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecentViewHolder extends ChildViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatImageView f427589d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ConstraintLayout f427590e;

        public RecentViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f427589d = (AppCompatImageView) r100.findViewById(com.larus.nova.R.id.swipe_menu_delete);
            ConstraintLayout r101 = (ConstraintLayout) r100.findViewById(com.larus.nova.R.id.item_content);
            this.f427590e = r101;
            r101.setBackground(T3());
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Prompt r100);

        void b(Prompt r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f427591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f427592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Prompt f427593c;

        public c(boolean r100, String r101, Prompt r102) {
            this.f427591a = r100;
            this.f427592b = r101;
            this.f427593c = r102;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromptsAdapter f427594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Prompt f427595b;

        public d(PromptsAdapter r100, Prompt r101) {
            this.f427594a = r100;
            this.f427595b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f427594a.f427583b;
            if (r101 == null) goto L6;
            r101.a(this.f427595b);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f427596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PromptsAdapter f427597b;

        public e(c r100, PromptsAdapter r101) {
            this.f427596a = r100;
            this.f427597b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Prompt r101 = this.f427596a.f427593c;
            if (r101 == null) goto L8;
            b r102 = this.f427597b.f427583b;
            if (r102 == null) goto L9;
            r102.b(r101);
            return;
        L9:
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f427598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PromptsAdapter f427599b;

        public f(c r100, PromptsAdapter r101) {
            this.f427598a = r100;
            this.f427599b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Prompt r101 = this.f427598a.f427593c;
            if (r101 == null) goto L8;
            b r102 = this.f427599b.f427583b;
            if (r102 == null) goto L9;
            r102.a(r101);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<c> r100 = this.f427582a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public PromptsAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        List<c> r101 = this.f427582a;
        if (r101 == null) goto L9;
        c r102 = (c) ListProtector.get(r101, r100);
        if (r102 == null) goto L9;
        if (r102.f427591a != true) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
        return 0;
    L12:
        List<c> r104 = this.f427582a;
        if (r104 == null) goto L19;
        c r105 = (c) ListProtector.get(r104, r100);
        if (r105 == null) goto L19;
        Prompt r106 = r105.f427593c;
        if (r106 == null) goto L19;
        String r107 = r106.getType();
    L21:
        if (Intrinsics.areEqual(r107, "history_prompt") == false) goto L25;
        return 2;
    L25:
        return 1;
    L19:
        r107 = null;
    L9:
        r103 = false;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<c> r102 = this.f427582a;
        if (r102 == null) goto L21;
        c r103 = (c) CollectionsKt.getOrNull(r102, r101);
        if (r103 != null) goto L8;
        return;
    L8:
        if ((r100 instanceof ParentViewHolder) == false) goto L15;
        View r104 = r100.itemView;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        ((AppCompatTextView) r104).setText(r103.f427592b);
        View r105 = r100.itemView;
        if (r101 != 0) goto L12;
        int r106 = 0;
    L13:
        r105.setPadding(r105.getPaddingLeft(), r106, r105.getPaddingRight(), r105.getPaddingBottom());
        return;
    L12:
        r106 = f0.a(8);
        goto L13
    L15:
        if ((r100 instanceof RecentViewHolder) == false) goto L18;
        y2((ChildViewHolder) r100, r103);
        RecentViewHolder r107 = (RecentViewHolder) r100;
        r107.f427589d.setImageResource(com.larus.nova.R.drawable.ud_icon_delete_trash_outlined);
        ColorStateList r108 = UDColorUtils.getColorStateList(r107.f427589d.getContext(), com.larus.nova.R.color.white);
        r107.f427589d.setImageTintList(r108);
        r107.f427589d.setOnClickListener(new e(r103, this));
        r107.f427590e.setOnClickListener(new f(r103, this));
        return;
    L18:
        if ((r100 instanceof ChildViewHolder) == false) goto L24;
        y2((ChildViewHolder) r100, r103);
        return;
    L24:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 0) goto L5;
        AppCompatTextView r102 = new AppCompatTextView(r100.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r102.setPadding(f0.a(14), 0, f0.a(14), f0.a(4));
        r102.setTextSize(14.0f);
        r102.setTextColor(ContextCompat.getColor(r100.getContext(), com.larus.nova.R.color.text_caption));
        return new ParentViewHolder(r102);
    L5:
        if (r101 == 2) goto L11;
        return new ChildViewHolder(LayoutInflater.from(r100.getContext()).inflate(com.larus.nova.R.layout.inline_ai_prompt_child_item, r100, false));
    L11:
        return new RecentViewHolder(LayoutInflater.from(r100.getContext()).inflate(com.larus.nova.R.layout.inline_ai_prompt_recent_item, r100, false));
    }

    public final void y2(ChildViewHolder r100, c r101) {
        Prompt r102 = r101.f427593c;
        if (r102 != null) goto L5;
        return;
    L5:
        r100.f427585b.setText(Html.fromHtml(r102.getText()));
        int r103 = 8;
        if (r102.getIcon() <= 0) goto L8;
        r100.f427584a.setVisibility(0);
        r100.f427584a.setImageDrawable(AppCompatResources.getDrawable(r100.itemView.getContext(), r102.getIcon()));
    L9:
        r100.itemView.setOnClickListener(new d(this, r102));
        AppCompatImageView r104 = r100.f427586c;
        if (r102.getRightArrow() == false) goto L12;
        r103 = 0;
    L12:
        r104.setVisibility(r103);
        return;
    L8:
        r100.f427584a.setVisibility(8);
        goto L9
    }
}
