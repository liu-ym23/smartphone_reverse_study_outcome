package com.ss.android.lark.inline.ai.creationai.quickPrompt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\t !\"#$%&'(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\"\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "onPromptClickListener", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$OnPromptClickListener;", "setData", "", "promptGroups", "setOnPromptClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "onBindChildViewHolder", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "isSwitchView", "", "getItemViewType", "Companion", "NormalViewHolder", "DatasetViewHolder", "SelectViewHolder", "SwitchViewHolder", "DividerViewHolder", "ItemViewType", "OnPromptClickListener", "DiffCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickPromptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<MenuItem> f427204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f427205b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$DatasetViewHolder;", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "badgePoint", "getBadgePoint", "()Landroid/view/View;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DatasetViewHolder extends NormalViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f427206d;

        public DatasetViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f427206d = r100.findViewById(R.id.badge_point);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<MenuItem> f427207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<MenuItem> f427208b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            List<MenuItem> r100 = this.f427208b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            List<MenuItem> r100 = this.f427207a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public DiffCallback(List<MenuItem> r100, List<MenuItem> r101) {
            this.f427207a = r100;
            this.f427208b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            List<MenuItem> r102 = this.f427207a;
            if (r102 == null) goto L14;
            MenuItem r103 = (MenuItem) CollectionsKt.getOrNull(r102, r100);
            if (r103 == null) goto L14;
            List<MenuItem> r104 = this.f427208b;
            if (r104 == null) goto L14;
            MenuItem r105 = (MenuItem) CollectionsKt.getOrNull(r104, r101);
            if (r105 == null) goto L14;
            return Intrinsics.areEqual(r103, r105);
        L14:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            List<MenuItem> r102 = this.f427207a;
            if (r102 == null) goto L14;
            MenuItem r103 = (MenuItem) CollectionsKt.getOrNull(r102, r100);
            if (r103 == null) goto L14;
            List<MenuItem> r104 = this.f427208b;
            if (r104 == null) goto L14;
            MenuItem r105 = (MenuItem) CollectionsKt.getOrNull(r104, r101);
            if (r105 == null) goto L14;
            return Intrinsics.areEqual(r103.getId(), r105.getId());
        L14:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final Object getChangePayload(int r100, int r101) {
            Bundle r102 = new Bundle();
            List<MenuItem> r103 = this.f427207a;
            Integer r104 = null;
            if (r103 == null) goto L5;
            MenuItem r105 = (MenuItem) CollectionsKt.getOrNull(r103, r100);
        L6:
            List<MenuItem> r106 = this.f427208b;
            if (r106 == null) goto L9;
            MenuItem r107 = (MenuItem) CollectionsKt.getOrNull(r106, r100);
        L10:
            if (r105 == null) goto L12;
            String r108 = r105.getText();
        L13:
            if (r107 == null) goto L15;
            String r109 = r107.getText();
        L17:
            if (Intrinsics.areEqual(r108, r109) == true) goto L19;
            r102.putInt("text", 1);
        L19:
            if (r105 == null) goto L21;
            String r110 = r105.getDesc();
        L22:
            if (r107 == null) goto L24;
            String r111 = r107.getDesc();
        L26:
            if (Intrinsics.areEqual(r110, r111) == true) goto L28;
            r102.putInt("text_desc", 1);
        L28:
            if (r105 == null) goto L30;
            String r112 = r105.getType();
        L31:
            if (r107 == null) goto L33;
            String r113 = r107.getType();
        L35:
            if (Intrinsics.areEqual(r112, r113) == true) goto L37;
            r102.putInt("btnType", 1);
        L37:
            if (r105 == null) goto L39;
            Boolean r114 = Boolean.valueOf(r105.getDisabled());
        L40:
            if (r107 == null) goto L42;
            Boolean r115 = Boolean.valueOf(r107.getDisabled());
        L44:
            if (Intrinsics.areEqual(r114, r115) == true) goto L46;
            r102.putInt("disable", 1);
        L46:
            if (r105 == null) goto L48;
            String r116 = r105.getIcon();
        L49:
            if (r107 == null) goto L51;
            String r117 = r107.getIcon();
        L53:
            if (Intrinsics.areEqual(r116, r117) == true) goto L55;
            r102.putInt("icon", 1);
        L55:
            if (r105 == null) goto L57;
            Boolean r118 = Boolean.valueOf(r105.getSelected());
        L58:
            if (r107 == null) goto L60;
            Boolean r119 = Boolean.valueOf(r107.getSelected());
        L62:
            if (Intrinsics.areEqual(r118, r119) == true) goto L64;
            r102.putInt("selected", 1);
        L64:
            if (r105 == null) goto L66;
            Integer r120 = r105.getBadgeNum();
        L67:
            if (r107 == null) goto L70;
            r104 = r107.getBadgeNum();
        L70:
            if (Intrinsics.areEqual(r120, r104) == true) goto L72;
            r102.putInt(IAllianceService.CONTENT_TYPE_BADGE, 1);
        L72:
            return r102;
        L66:
            r120 = null;
            goto L67
        L60:
            r119 = null;
            goto L62
        L57:
            r118 = null;
            goto L58
        L51:
            r117 = null;
            goto L53
        L48:
            r116 = null;
            goto L49
        L42:
            r115 = null;
            goto L44
        L39:
            r114 = null;
            goto L40
        L33:
            r113 = null;
            goto L35
        L30:
            r112 = null;
            goto L31
        L24:
            r111 = null;
            goto L26
        L21:
            r110 = null;
            goto L22
        L15:
            r109 = null;
            goto L17
        L12:
            r108 = null;
            goto L13
        L9:
            r107 = null;
            goto L10
        L5:
            r105 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$DividerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DividerViewHolder extends RecyclerView.ViewHolder {
        public DividerViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "description", "getDescription", "badgeNum", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "getBadgeNum", "()Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class NormalViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f427209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f427210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UDBadgeView f427211c;

        public NormalViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f427209a = (TextView) r100.findViewById(R.id.title);
            this.f427210b = (TextView) r100.findViewById(R.id.sub_title);
            this.f427211c = (UDBadgeView) r100.findViewById(R.id.badge_num);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$SelectViewHolder;", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "select", "Landroidx/appcompat/widget/AppCompatImageView;", "getSelect", "()Landroidx/appcompat/widget/AppCompatImageView;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SelectViewHolder extends NormalViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppCompatImageView f427212d;

        public SelectViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f427212d = (AppCompatImageView) r100.findViewById(R.id.selected_icon);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$SwitchViewHolder;", "Lcom/ss/android/lark/inline/ai/creationai/quickPrompt/QuickPromptAdapter$NormalViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "switch", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "getSwitch", "()Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SwitchViewHolder extends NormalViewHolder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final UDSwitch f427213d;

        public SwitchViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f427213d = (UDSwitch) r100.findViewById(R.id.item_switch);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(MenuItem r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickPromptAdapter f427214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MenuItem f427215b;

        public c(QuickPromptAdapter r100, MenuItem r101) {
            this.f427214a = r100;
            this.f427215b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f427214a.f427205b;
            if (r101 == null) goto L6;
            r101.a(this.f427215b);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickPromptAdapter f427216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MenuItem f427217b;

        public d(QuickPromptAdapter r100, MenuItem r101) {
            this.f427216a = r100;
            this.f427217b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f427216a.f427205b;
            if (r101 == null) goto L6;
            r101.a(this.f427217b);
            return;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<MenuItem> r100 = this.f427204a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public QuickPromptAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        List<MenuItem> r101 = this.f427204a;
        if (r101 == null) goto L7;
        MenuItem r102 = (MenuItem) ListProtector.get(r101, r100);
        if (r102 == null) goto L7;
        String r103 = r102.getType();
    L9:
        if (Intrinsics.areEqual(r103, "radio") == false) goto L13;
        return 2;
    L13:
        if (Intrinsics.areEqual(r103, "switcher") == false) goto L17;
        return 1;
    L17:
        if (Intrinsics.areEqual(r103, ItemStyle.ITEM_STYLE_DIVIDER) == false) goto L21;
        return 3;
    L21:
        if (Intrinsics.areEqual(r103, "dataset") == false) goto L24;
        return 4;
    L24:
        return 0;
    L7:
        r103 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<MenuItem> r102 = this.f427204a;
        if (r102 == null) goto L52;
        MenuItem r103 = (MenuItem) CollectionsKt.getOrNull(r102, r101);
        if (r103 != null) goto L8;
        return;
    L8:
        if ((r100 instanceof SwitchViewHolder) == false) goto L10;
        y2((NormalViewHolder) r100, r103, true);
        SwitchViewHolder r104 = (SwitchViewHolder) r100;
        r104.f427213d.setChecked(r103.getSelected());
        r104.f427213d.setOnClickListener(new d(this, r103));
        return;
    L10:
        int r105 = 8;
        if ((r100 instanceof SelectViewHolder) == false) goto L21;
        y2((NormalViewHolder) r100, r103, false);
        SelectViewHolder r106 = (SelectViewHolder) r100;
        AppCompatImageView r107 = r106.f427212d;
        if (r103.getSelected() == false) goto L15;
        r105 = 0;
    L15:
        r107.setVisibility(r105);
        TextView r108 = r106.f427209a;
        if (r103.getSelected() == false) goto L18;
        int r109 = R.color.text_link_normal;
    L19:
        r108.setTextColor(UIHelper.getColor(r109));
        return;
    L18:
        r109 = R.color.text_title;
        goto L19
    L21:
        if ((r100 instanceof DatasetViewHolder) == false) goto L30;
        y2((NormalViewHolder) r100, r103, false);
        Integer r110 = r103.getBadgeNum();
        if (r110 == null) goto L28;
        int r111 = r110.intValue();
        View r112 = ((DatasetViewHolder) r100).f427206d;
        if (r111 <= 0) goto L27;
        r105 = 0;
    L27:
        r112.setVisibility(r105);
        return;
    L28:
        ((DatasetViewHolder) r100).f427206d.setVisibility(8);
        return;
    L30:
        if ((r100 instanceof NormalViewHolder) == false) goto L57;
        NormalViewHolder r113 = (NormalViewHolder) r100;
        y2(r113, r103, false);
        Integer r114 = r103.getBadgeNum();
        if (r114 == null) goto L48;
        int r115 = r114.intValue();
        Unit r116 = null;
        if (r115 <= 0) goto L44;
        UDBadgeView r117 = r113.f427211c;
        if (r117 == null) goto L38;
        r117.setVisibility(0);
    L38:
        UDBadgeView r118 = r113.f427211c;
        if (r118 == null) goto L41;
        r118.setText(String.valueOf(RangesKt.coerceAtMost(r115, 99)));
    L41:
        UDBadgeView r119 = r113.f427211c;
        if (r119 == null) goto L47;
        r119.a();
        r116 = Unit.INSTANCE;
    L47:
        if (r116 == null) goto L48;
        return;
    L44:
        UDBadgeView r120 = r113.f427211c;
        if (r120 == null) goto L47;
        r120.setVisibility(8);
        r116 = Unit.INSTANCE;
    L48:
        UDBadgeView r121 = r113.f427211c;
        if (r121 == null) goto L59;
        r121.setVisibility(8);
        return;
    L59:
        return;
    L57:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return new NormalViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.creation_ai_item_normal_layout, r100, false));
    L17:
        return new DatasetViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.creation_ai_item_dataset_layout, r100, false));
    L18:
        return new DividerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.creation_ai_item_divider_layout, r100, false));
    L19:
        return new SelectViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.creation_ai_item_radio_layout, r100, false));
    L15:
        return new SwitchViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.creation_ai_item_switch_layout, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r110, "payloads");
        if ((!r110.isEmpty()) == false) goto L98;
        int r102 = 0;
        if ((ListProtector.get(r110, 0) instanceof Bundle) == false) goto L98;
        List<MenuItem> r103 = this.f427204a;
        if (r103 == null) goto L97;
        MenuItem r104 = (MenuItem) ListProtector.get(r103, r101);
        if (r104 == null) goto L100;
        Object r111 = ListProtector.get(r110, 0);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r112 = (Bundle) r111;
        if ((r100 instanceof SwitchViewHolder) == false) goto L25;
        if (r112.getInt("text") != 1) goto L17;
        ((SwitchViewHolder) r100).f427209a.setText(r104.getText());
    L17:
        if (r112.getInt("text_desc") != 1) goto L22;
        TextView r105 = ((SwitchViewHolder) r100).f427210b;
        if (r105 == null) goto L22;
        r105.setText(r104.getDesc());
    L22:
        if (r112.getInt("selected") != 1) goto L101;
        ((SwitchViewHolder) r100).f427213d.setChecked(r104.getSelected());
        return;
    L101:
        return;
    L25:
        if ((r100 instanceof SelectViewHolder) == false) goto L46;
        if (r112.getInt("text") != 1) goto L30;
        ((SelectViewHolder) r100).f427209a.setText(r104.getText());
    L30:
        if (r112.getInt("text_desc") != 1) goto L35;
        TextView r106 = ((SelectViewHolder) r100).f427210b;
        if (r106 == null) goto L35;
        r106.setText(r104.getDesc());
    L35:
        if (r112.getInt("selected") != 1) goto L103;
        SelectViewHolder r107 = (SelectViewHolder) r100;
        AppCompatImageView r113 = r107.f427212d;
        if (r104.getSelected() == true) goto L40;
        r102 = 8;
    L40:
        r113.setVisibility(r102);
        TextView r108 = r107.f427209a;
        if (r104.getSelected() == false) goto L43;
        int r109 = R.color.text_link_normal;
    L44:
        r108.setTextColor(UIHelper.getColor(r109));
        return;
    L43:
        r109 = R.color.text_title;
        goto L44
    L103:
        return;
    L46:
        if ((r100 instanceof DatasetViewHolder) == false) goto L66;
        if (r112.getInt("text") != 1) goto L51;
        ((DatasetViewHolder) r100).f427209a.setText(r104.getText());
    L51:
        if (r112.getInt("text_desc") != 1) goto L56;
        TextView r114 = ((DatasetViewHolder) r100).f427210b;
        if (r114 == null) goto L56;
        r114.setText(r104.getDesc());
    L56:
        if (r112.getInt(IAllianceService.CONTENT_TYPE_BADGE) != 1) goto L105;
        Integer r115 = r104.getBadgeNum();
        if (r115 == null) goto L64;
        int r116 = r115.intValue();
        View r117 = ((DatasetViewHolder) r100).f427206d;
        if (r116 > 0) goto L63;
        r102 = 8;
    L63:
        r117.setVisibility(r102);
        return;
    L64:
        ((DatasetViewHolder) r100).f427206d.setVisibility(8);
        return;
    L105:
        return;
    L66:
        if ((r100 instanceof NormalViewHolder) == true) goto L68;
        return;
    L68:
        if (r112.getInt("text") != 1) goto L71;
        ((NormalViewHolder) r100).f427209a.setText(r104.getText());
    L71:
        if (r112.getInt("text_desc") != 1) goto L76;
        TextView r118 = ((NormalViewHolder) r100).f427210b;
        if (r118 == null) goto L76;
        r118.setText(r104.getDesc());
    L76:
        if (r112.getInt(IAllianceService.CONTENT_TYPE_BADGE) != 1) goto L109;
        Integer r119 = r104.getBadgeNum();
        if (r119 == null) goto L94;
        int r120 = r119.intValue();
        Unit r121 = null;
        if (r120 <= 0) goto L90;
        NormalViewHolder r122 = (NormalViewHolder) r100;
        UDBadgeView r123 = r122.f427211c;
        if (r123 == null) goto L84;
        r123.setVisibility(0);
    L84:
        UDBadgeView r124 = r122.f427211c;
        if (r124 == null) goto L87;
        r124.setText(String.valueOf(RangesKt.coerceAtMost(r120, 99)));
    L87:
        UDBadgeView r125 = r122.f427211c;
        if (r125 == null) goto L93;
        r125.a();
        r121 = Unit.INSTANCE;
    L93:
        if (r121 == null) goto L94;
        return;
    L90:
        UDBadgeView r126 = ((NormalViewHolder) r100).f427211c;
        if (r126 == null) goto L93;
        r126.setVisibility(8);
        r121 = Unit.INSTANCE;
    L94:
        UDBadgeView r127 = ((NormalViewHolder) r100).f427211c;
        if (r127 == null) goto L111;
        r127.setVisibility(8);
        return;
    L111:
        return;
    L109:
        return;
    L100:
        return;
    L97:
        return;
    L98:
        onBindViewHolder(r100, r101);
    }

    public final void y2(NormalViewHolder r100, MenuItem r101, boolean r102) {
        r100.f427209a.setText(r101.getText());
        TextView r103 = r100.f427210b;
        if (r103 == null) goto L5;
        r103.setText(r101.getDesc());
    L5:
        if (r102 == true) goto L8;
        r100.itemView.setOnClickListener(new c(this, r101));
        return;
    }
}
