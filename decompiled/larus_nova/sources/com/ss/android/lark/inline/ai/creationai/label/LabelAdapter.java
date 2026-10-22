package com.ss.android.lark.inline.ai.creationai.label;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.inline.ai.api.creationai.ItemContainer;
import com.ss.android.lark.inline.ai.api.creationai.MenuItem;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$OnOperateClickListener;", "setData", "", "setOnOperateClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "Companion", "ViewHolder", "OnOperateClickListener", "DiffCallback", "LabelViewHolder", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LabelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<MenuItem> f427143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f427144b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<MenuItem> f427145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<MenuItem> f427146b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            List<MenuItem> r100 = this.f427146b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            List<MenuItem> r100 = this.f427145a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public DiffCallback(List<MenuItem> r100, List<MenuItem> r101) {
            this.f427145a = r100;
            this.f427146b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            List<MenuItem> r102 = this.f427145a;
            if (r102 == null) goto L11;
            MenuItem r103 = (MenuItem) CollectionsKt.getOrNull(r102, r100);
            if (r103 == null) goto L11;
            List<MenuItem> r104 = this.f427146b;
            if (r104 == null) goto L9;
            MenuItem r105 = (MenuItem) CollectionsKt.getOrNull(r104, r100);
        L13:
            return r103.equals(r105);
        L9:
            r105 = null;
        L11:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            List<MenuItem> r102 = this.f427145a;
            String r103 = null;
            if (r102 == null) goto L5;
            MenuItem r104 = (MenuItem) CollectionsKt.getOrNull(r102, r100);
        L6:
            List<MenuItem> r105 = this.f427146b;
            if (r105 == null) goto L9;
            MenuItem r106 = (MenuItem) CollectionsKt.getOrNull(r105, r101);
        L10:
            if (r104 == null) goto L12;
            String r107 = r104.getId();
        L13:
            if (r106 == null) goto L16;
            r103 = r106.getId();
        L16:
            return Intrinsics.areEqual(r107, r103);
        L12:
            r107 = null;
            goto L13
        L9:
            r106 = null;
            goto L10
        L5:
            r104 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final Object getChangePayload(int r100, int r101) {
            Bundle r102 = new Bundle();
            List<MenuItem> r103 = this.f427145a;
            ItemContainer r104 = null;
            if (r103 == null) goto L5;
            MenuItem r105 = (MenuItem) CollectionsKt.getOrNull(r103, r100);
        L6:
            List<MenuItem> r106 = this.f427146b;
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
            String r110 = r105.getType();
        L22:
            if (r107 == null) goto L24;
            String r111 = r107.getType();
        L26:
            if (Intrinsics.areEqual(r110, r111) == true) goto L28;
            r102.putInt("btnType", 1);
        L28:
            if (r105 == null) goto L30;
            String r112 = r105.getIcon();
        L31:
            if (r107 == null) goto L33;
            String r113 = r107.getIcon();
        L35:
            if (Intrinsics.areEqual(r112, r113) == true) goto L38;
            r102.putInt("icon", 1);
        L38:
            if (DowngradeSettingUtil.a("creation_ai_label_history_entry_enable") == true) goto L47;
            if (r105 == null) goto L41;
            ItemContainer r114 = r105.getRightItem();
        L42:
            if (r107 == null) goto L45;
            r104 = r107.getRightItem();
        L45:
            if (Intrinsics.areEqual(r114, r104) == true) goto L47;
            r102.putInt("rightIcon", 1);
            goto L47
        L41:
            r114 = null;
        L47:
            return r102;
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$LabelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "itemView", "Lcom/ss/android/lark/inline/ai/creationai/label/LabelItem;", "getItemView", "()Lcom/ss/android/lark/inline/ai/creationai/label/LabelItem;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LabelViewHolder extends RecyclerView.ViewHolder {
        public LabelViewHolder(LabelItem r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/label/LabelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
    }

    public static final class a {
    }

    public interface b {
        void a(MenuItem r100);

        void b(MenuItem r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LabelAdapter f427147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MenuItem f427148b;

        public c(LabelAdapter r100, MenuItem r101) {
            this.f427147a = r100;
            this.f427148b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f427147a.f427144b;
            if (r101 == null) goto L6;
            r101.a(this.f427148b);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LabelAdapter f427149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MenuItem f427150b;

        public d(LabelAdapter r100, MenuItem r101) {
            this.f427149a = r100;
            this.f427150b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f427149a.f427144b;
            if (r101 == null) goto L6;
            r101.b(this.f427150b);
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LabelAdapter f427151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MenuItem f427152b;

        public e(LabelAdapter r100, MenuItem r101) {
            this.f427151a = r100;
            this.f427152b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f427151a.f427144b;
            if (r101 == null) goto L6;
            r101.b(this.f427152b);
            return;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<MenuItem> r100 = this.f427143a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public LabelAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<MenuItem> r102 = this.f427143a;
        if (r102 == null) goto L31;
        MenuItem r103 = (MenuItem) ListProtector.get(r102, r101);
        if (r103 == null) goto L38;
        View r104 = r100.itemView;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.label.LabelItem");
        LabelItem r105 = (LabelItem) r104;
        r105.setText(r103.getText());
        r105.setLeftIconVisible(false);
        r105.setLeftLabelVisible(Intrinsics.areEqual(r103.getType(), "quote"));
        r105.setOnClickListener(new c(this, r103));
        if (Intrinsics.areEqual(r103.getType(), "quote") == true) goto L11;
        r105.b(6);
    L14:
        r105.setPadding(r105.a(20), r105.a(16), r105.a(20), r105.a(8));
        r105.setTextSize(14);
        r105.setTextColor("text_caption");
        if (DowngradeSettingUtil.a("creation_ai_label_history_entry_enable") == true) goto L35;
        r105.getRightIconLayout().removeAllViews();
        ItemContainer r106 = r103.getRightItem();
        if (r106 == null) goto L36;
        r105.setRightIconVisible(r106.getShow());
        ArrayList<MenuItem> r107 = r106.getData();
        if (r107 == null) goto L37;
        Iterator<MenuItem> r108 = r107.iterator();
    L22:
        if (r108.hasNext() == false) goto L39;
        MenuItem r109 = r108.next();
        RedBadgeIcon r110 = new RedBadgeIcon(r105.getContext(), null, 6, 0);
        r110.setRightIcon(r109.getIcon());
        Integer r111 = r109.getBadgeNum();
        if (r111 == null) goto L26;
        int r112 = r111.intValue();
    L27:
        if (r112 <= 0) goto L29;
        boolean r113 = true;
    L30:
        r110.setRightBadge(r113);
        r110.setOnClickListener(new d(this, r109));
        r110.setIconColor("title_color");
        r105.getRightIconLayout().addView(r110);
        goto L22
    L29:
        r113 = false;
        goto L30
    L26:
        r112 = 0;
        goto L27
    L39:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L11:
        if (r101 != 0) goto L13;
        r105.b(4);
        goto L14
    L13:
        r105.b(4);
        goto L14
    L38:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new LabelViewHolder(new LabelItem(r100.getContext(), null, 6, 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if ((!r102.isEmpty()) == true) goto L5;
    L86:
        onBindViewHolder(r100, r101);
        return;
    L5:
        if ((ListProtector.get(r102, 0) instanceof Bundle) == false) goto L86;
        List<MenuItem> r103 = this.f427143a;
        if (r103 == null) goto L85;
        MenuItem r104 = (MenuItem) ListProtector.get(r103, r101);
        if (r104 == null) goto L95;
        Object r105 = ListProtector.get(r102, 0);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r106 = (Bundle) r105;
        View r107 = r100.itemView;
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.label.LabelItem");
        LabelItem r108 = (LabelItem) r107;
        if (r106.getInt("text") != 1) goto L15;
        r108.setText(r104.getText());
    L15:
        if (r106.getInt("icon") != 1) goto L29;
        String r109 = r104.getIcon();
        if (r109 == null) goto L22;
        r108.getClass();
        if (r109.length() == 0) goto L22;
        boolean r110 = false;
    L23:
        if (r110 == false) goto L25;
        r108.f427156d.setImageResource(n.n(r108.getContext(), "ud_icon_abbreviation_outlined"));
        goto L29
    L25:
        int r111 = n.o(r108.getContext(), r109);
        if (r111 == 0) goto L29;
        r108.f427156d.setImageResource(r111);
    L22:
        r110 = true;
    L29:
        if (r106.getInt("btnType") != 1) goto L38;
        r108.setLeftLabelVisible(Intrinsics.areEqual(r104.getType(), "quote"));
        if (Intrinsics.areEqual(r104.getType(), "quote") == true) goto L34;
        r108.b(4);
        goto L38
    L34:
        if (r101 != 0) goto L36;
        r108.b(2);
        goto L38
    L36:
        r108.b(2);
    L38:
        if (DowngradeSettingUtil.a("creation_ai_label_history_entry_enable") == false) goto L40;
        return;
    L40:
        if (r106.getInt("rightIcon") != 1) goto L97;
        ItemContainer r112 = r104.getRightItem();     // Catch: Exception -> L83
        if (r112 == null) goto L44;
        r108.setRightIconVisible(r112.getShow());     // Catch: Exception -> L83
    L44:
        ItemContainer r113 = r104.getRightItem();     // Catch: Exception -> L83
        if (r113 == null) goto L51;
        ArrayList<MenuItem> r114 = r113.getData();     // Catch: Exception -> L83
        if (r114 == null) goto L51;
        if (r114.size() != r108.getRightIconLayout().getChildCount()) goto L51;
        boolean r115 = true;
    L52:
        if (r115 == false) goto L67;
        ItemContainer r116 = r104.getRightItem();     // Catch: Exception -> L83
        if (r116 == null) goto L98;
        ArrayList<MenuItem> r117 = r116.getData();     // Catch: Exception -> L83
        if (r117 == null) goto L99;
        int r118 = r117.size();     // Catch: Exception -> L83
        int r119 = 0;
    L58:
        if (r119 >= r118) goto L103;
        View r120 = r108.getRightIconLayout().getChildAt(r119);     // Catch: Exception -> L83
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.creationai.label.RedBadgeIcon");     // Catch: Exception -> L83
        RedBadgeIcon r121 = (RedBadgeIcon) r120;     // Catch: Exception -> L83
        r121.setRightIcon(((MenuItem) ListProtector.get(r117, r119)).getIcon());     // Catch: Exception -> L83
        Integer r122 = ((MenuItem) ListProtector.get(r117, r119)).getBadgeNum();     // Catch: Exception -> L83
        if (r122 == null) goto L62;
        int r123 = r122.intValue();     // Catch: Exception -> L83
    L63:
        if (r123 <= 0) goto L65;
        boolean r124 = true;
    L66:
        r121.setRightBadge(r124);     // Catch: Exception -> L83
        r119 = r119 + 1;     // Catch: Exception -> L83
        goto L58
    L65:
        r124 = false;
        goto L66
    L62:
        r123 = 0;
        goto L63
    L103:
        return;
    L99:
        return;
    L98:
        return;
    L67:
        r108.getRightIconLayout().removeAllViews();     // Catch: Exception -> L83
        ItemContainer r125 = r104.getRightItem();     // Catch: Exception -> L83
        if (r125 == null) goto L100;
        ArrayList<MenuItem> r126 = r125.getData();     // Catch: Exception -> L83
        if (r126 == null) goto L101;
        Iterator<MenuItem> r127 = r126.iterator();     // Catch: Exception -> L83
    L73:
        if (r127.hasNext() == false) goto L104;
        MenuItem r128 = r127.next();     // Catch: Exception -> L83
        RedBadgeIcon r129 = new RedBadgeIcon(r108.getContext(), null, 6, 0);     // Catch: Exception -> L83
        r129.setRightIcon(r128.getIcon());     // Catch: Exception -> L83
        Integer r130 = r128.getBadgeNum();     // Catch: Exception -> L83
        if (r130 == null) goto L77;
        int r131 = r130.intValue();     // Catch: Exception -> L83
    L78:
        if (r131 <= 0) goto L80;
        boolean r132 = true;
    L81:
        r129.setRightBadge(r132);     // Catch: Exception -> L83
        r129.setOnClickListener(new e(this, r128));     // Catch: Exception -> L83
        r108.getRightIconLayout().addView(r129);     // Catch: Exception -> L83
        goto L73
    L80:
        r132 = false;
        goto L81
    L77:
        r131 = 0;
        goto L78
    L104:
        return;
    L101:
        return;
    L100:
        return;
    L51:
        r115 = false;
    L83:
        e = move-exception;
        Log.e("LabelAdapter", "onBindViewHolder() PAYLOAD_KEY_RIGHT_ICON change failed: ", e);
        return;
    L97:
        return;
    L95:
        return;
    }
}
