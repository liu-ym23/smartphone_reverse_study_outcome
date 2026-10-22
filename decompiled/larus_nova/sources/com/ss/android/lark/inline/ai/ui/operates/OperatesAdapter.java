package com.ss.android.lark.inline.ai.ui.operates;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.inline.ai.api.ui.Operate;
import com.ss.android.lark.inline.ai.ui.f0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001a\u001b\u001c\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J&\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$ViewHolder;", "<init>", "()V", "data", "", "Lcom/ss/android/lark/inline/ai/api/ui/Operate;", "onOperateClickListener", "Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$OnOperateClickListener;", "setData", "", "setOnOperateClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "payloads", "", "", "Companion", "ViewHolder", "OnOperateClickListener", "DiffCallback", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperatesAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Operate> f427572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f427573b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/ss/android/lark/inline/ai/api/ui/Operate;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "getChangePayload", "", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Operate> f427574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Operate> f427575b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            List<Operate> r100 = this.f427575b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            List<Operate> r100 = this.f427574a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public DiffCallback(List<Operate> r100, List<Operate> r101) {
            this.f427574a = r100;
            this.f427575b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            List<Operate> r102 = this.f427574a;
            if (r102 == null) goto L11;
            Operate r103 = (Operate) CollectionsKt.getOrNull(r102, r100);
            if (r103 == null) goto L11;
            List<Operate> r104 = this.f427575b;
            if (r104 == null) goto L9;
            Operate r105 = (Operate) CollectionsKt.getOrNull(r104, r100);
        L13:
            return r103.equals(r105);
        L9:
            r105 = null;
        L11:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            List<Operate> r102 = this.f427574a;
            String r103 = null;
            if (r102 == null) goto L7;
            Operate r104 = (Operate) CollectionsKt.getOrNull(r102, r100);
            if (r104 == null) goto L7;
            String r105 = r104.getType();
        L8:
            List<Operate> r106 = this.f427575b;
            if (r106 == null) goto L14;
            Operate r107 = (Operate) CollectionsKt.getOrNull(r106, r100);
            if (r107 == null) goto L14;
            r103 = r107.getType();
        L14:
            return Intrinsics.areEqual(r105, r103);
        L7:
            r105 = null;
            goto L8
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final Object getChangePayload(int r100, int r101) {
            Bundle r102 = new Bundle();
            List<Operate> r103 = this.f427574a;
            Boolean r104 = null;
            if (r103 == null) goto L5;
            Operate r105 = (Operate) CollectionsKt.getOrNull(r103, r100);
        L6:
            List<Operate> r106 = this.f427575b;
            if (r106 == null) goto L9;
            Operate r107 = (Operate) CollectionsKt.getOrNull(r106, r100);
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
            String r110 = r105.getBtnType();
        L22:
            if (r107 == null) goto L24;
            String r111 = r107.getBtnType();
        L26:
            if (Intrinsics.areEqual(r110, r111) == true) goto L28;
            r102.putInt("btnType", 1);
        L28:
            if (r105 == null) goto L30;
            Boolean r112 = Boolean.valueOf(r105.getDisabled());
        L31:
            if (r107 == null) goto L34;
            r104 = Boolean.valueOf(r107.getDisabled());
        L34:
            if (Intrinsics.areEqual(r112, r104) == true) goto L36;
            r102.putInt("disable", 1);
        L36:
            return r102;
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/operates/OperatesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(OperateButton r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(Operate r100);
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperatesAdapter f427576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Operate f427577b;

        public c(OperatesAdapter r100, Operate r101) {
            this.f427576a = r100;
            this.f427577b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f427576a.f427573b;
            if (r101 == null) goto L6;
            r101.a(this.f427577b);
            return;
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<Operate> r100 = this.f427572a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public OperatesAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((ViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        AttributeSet r102 = null;
        OperateButton r103 = new OperateButton(r100.getContext(), r102, 6, 0);
        r103.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r103.setPadding(f0.a(16), f0.a(7), f0.a(16), f0.a(7));
        r103.setTextSize(16.0f);
        return new ViewHolder(r103);
    }

    public final void y2(ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<Operate> r102 = this.f427572a;
        if (r102 == null) goto L12;
        Operate r103 = (Operate) ListProtector.get(r102, r101);
        if (r103 == null) goto L13;
        View r104 = r100.itemView;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.ui.operates.OperateButton");
        OperateButton r105 = (OperateButton) r104;
        String r106 = r103.getBtnType();
        if (r106 != null) goto L10;
        r106 = "default";
    L10:
        r105.setType(r106);
        r105.setText(r103.getText());
        r105.setEnabled(!r103.getDisabled());
        r105.setOnClickListener(new c(this, r103));
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        ViewHolder r103 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        if ((!r102.isEmpty()) == true) goto L5;
    L24:
        y2(r103, r101);
        return;
    L5:
        if ((ListProtector.get(r102, 0) instanceof Bundle) == false) goto L24;
        List<Operate> r104 = this.f427572a;
        if (r104 == null) goto L26;
        Operate r105 = (Operate) ListProtector.get(r104, r101);
        if (r105 == null) goto L28;
        Object r106 = ListProtector.get(r102, 0);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.os.Bundle");
        Bundle r107 = (Bundle) r106;
        View r108 = r103.itemView;
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.ui.operates.OperateButton");
        OperateButton r109 = (OperateButton) r108;
        if (r107.getInt("text") != 1) goto L15;
        r109.setText(r105.getText());
    L15:
        if (r107.getInt("btnType") != 1) goto L21;
        String r110 = r105.getBtnType();
        if (r110 != null) goto L19;
        r110 = "default";
    L19:
        r109.setType(r110);
    L21:
        if (r107.getInt("disable") != 1) goto L23;
        r109.setEnabled(!r105.getDisabled());
    L23:
        r109.setOnClickListener(new com.ss.android.lark.inline.ai.ui.operates.a(this, r105));
        return;
    L28:
        return;
    }
}
