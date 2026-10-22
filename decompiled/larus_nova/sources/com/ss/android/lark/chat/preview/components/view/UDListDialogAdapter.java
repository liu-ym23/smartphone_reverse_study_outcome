package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/UDListDialogAdapter;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "selectItemPosition", "", "selectItemColor", "<init>", "(Landroid/content/Context;II)V", "getContext", "()Landroid/content/Context;", "getSelectItemPosition", "()I", "getSelectItemColor", "onBindViewHolder", "", "holder", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "position", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDListDialogAdapter extends UDBaseListDialogAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f416165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f416166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f416167k;

    public final Context getContext() {
        return this.f416165i;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((UDBaseListDialogAdapter.UDDialogListItemViewHolder) r100, r101);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final void y2(UDBaseListDialogAdapter.UDDialogListItemViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.y2(r100, r101);
        if (r101 != this.f416166j) goto L5;
        r100.f284850a.setTextColor(this.f416165i.getResources().getColor(this.f416167k));
        return;
    L5:
        r100.f284850a.setTextColor(this.f416165i.getResources().getColor(R.color.text_title));
    }

    public UDListDialogAdapter(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f416165i = r100;
        this.f416166j = r101;
        this.f416167k = r102;
    }
}
