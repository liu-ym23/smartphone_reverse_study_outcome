package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.dialog.TraverseLayoutChildIdUtilsKt;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/message/card/view/richtext/RichTextRenderAdapter;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "itemLayout", "", "checkIndex", "<init>", "(Landroid/content/Context;II)V", "getContext", "()Landroid/content/Context;", "getItemLayout", "()I", "onCreateViewHolder", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "RichTextRenderViewHolder", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichTextRenderAdapter extends UDBaseListDialogAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f431968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f431969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f431970k;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/message/card/view/richtext/RichTextRenderAdapter$RichTextRenderViewHolder;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "message-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RichTextRenderViewHolder extends UDBaseListDialogAdapter.UDDialogListItemViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UDCheckBox f431971b;

        public RichTextRenderViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f431971b = (UDCheckBox) r100.findViewById(R.id.lkui_dialog_content_item_cb);
        }
    }

    public final Context getContext() {
        return this.f431968i;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r100, r101);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100, r101);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.y2(r100, r101);
        UDCheckBox r102 = null;
        if ((r100 instanceof RichTextRenderViewHolder) == false) goto L5;
        RichTextRenderViewHolder r103 = (RichTextRenderViewHolder) r100;
    L7:
        if (r101 != this.f431970k) goto L14;
        if (r103 == null) goto L10;
        r102 = r103.f431971b;
    L10:
        if (r102 == null) goto L12;
        r102.setVisibility(0);
    L12:
        if (r102 == null) goto L21;
        r102.setChecked(true);
        return;
    L21:
        return;
    L14:
        if (r103 == null) goto L16;
        r102 = r103.f431971b;
    L16:
        if (r102 == null) goto L18;
        r102.setVisibility(8);
    L18:
        if (r102 == null) goto L23;
        r102.setChecked(false);
        return;
    L23:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final UDBaseListDialogAdapter.UDDialogListItemViewHolder z2(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(this.f431968i).inflate(this.f431969j, r100, false);
        TraverseLayoutChildIdUtilsKt.a(r102);
        return new RichTextRenderViewHolder(r102);
    }

    public RichTextRenderAdapter(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f431968i = r100;
        this.f431969j = r101;
        this.f431970k = r102;
    }
}
