package com.larksuite.component.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larksuite/component/ui/dialog/UDBaseListDialogAdapterWrapper;", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "itemLayout", "", "<init>", "(Landroid/content/Context;I)V", "onCreateViewHolder", "Lcom/larksuite/component/universe_design/dialog/UDBaseListDialogAdapter$UDDialogListItemViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UDBaseListDialogAdapterWrapper extends UDBaseListDialogAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f284122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f284123j;

    public UDBaseListDialogAdapterWrapper(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f284122i = r100;
        this.f284123j = r101;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100, r101);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDBaseListDialogAdapter
    public final UDBaseListDialogAdapter.UDDialogListItemViewHolder z2(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(this.f284122i).inflate(this.f284123j, r100, false);
        TraverseLayoutChildIdUtilsKt.a(r102);
        return new UDBaseListDialogAdapter.UDDialogListItemViewHolder(r102);
    }
}
