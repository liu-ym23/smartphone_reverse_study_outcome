package com.larus.business.debug.base.adapter.viewHolder;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.t0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sv8.a;
import sv8.b;
import sv8.c;
import zv8.e;
import zv8.j;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceButtonViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "button", "Landroid/widget/TextView;", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceButtonViewHolder extends EntranceViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f319957c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f319958b;

    public EntranceButtonViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(final e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        this.f319977a = r100;
        this.f319958b = (TextView) this.itemView.findViewById(R.id.entrance_button);
        this.itemView.setOnLongClickListener(new a(r100));
        TextView r101 = this.f319958b;
        if (r101 == null) goto L5;
        r101.setText(r100.c());
    L5:
        this.itemView.setOnClickListener(new b(r100));
        t0.c(new c(r100, this));
        if ((r100 instanceof j) == false) goto L8;
        j r102 = (j) r100;
    L9:
        if (r102 == null) goto L14;
        Activity r103 = AppHost.f326268a.a().getCurrentActivity();
        if (r103 == null) goto L15;
        r102.f573754c = new zv8.b(r103, r102);
        return;
    L15:
        return;
    L14:
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        TextView r101 = this.f319958b;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        TextView r102 = this.f319958b;
        if (r102 == null) goto L8;
        r102.setText("");
    L8:
        TextView r103 = this.f319958b;
        if (r103 == null) goto L11;
        r103.setOnClickListener(null);
    L11:
        r100.a();
        this.itemView.setPadding(0, 0, 0, 0);
    }
}
