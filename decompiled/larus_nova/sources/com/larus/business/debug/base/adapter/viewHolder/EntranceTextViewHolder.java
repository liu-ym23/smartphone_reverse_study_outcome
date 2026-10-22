package com.larus.business.debug.base.adapter.viewHolder;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sv8.g;
import sv8.h;
import zv8.b;
import zv8.e;
import zv8.j;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceTextViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "content", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "copyToClipboard", "key", "", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceTextViewHolder extends EntranceViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f319974d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f319975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f319976c;

    public EntranceTextViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(final e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        this.f319977a = r100;
        this.f319975b = (TextView) this.itemView.findViewById(R.id.entrance_title);
        this.f319976c = (TextView) this.itemView.findViewById(R.id.entrance_text);
        this.itemView.setOnLongClickListener(new g(r100));
        TextView r101 = this.f319975b;
        if (r101 == null) goto L5;
        r101.setText(r100.c());
    L5:
        TextView r102 = this.f319976c;
        if (r102 == null) goto L8;
        r102.setText("");
    L8:
        this.itemView.setOnClickListener(new h(r100, this));
        if ((r100 instanceof j) == false) goto L11;
        j r103 = (j) r100;
    L12:
        if (r103 == null) goto L17;
        Activity r104 = AppHost.f326268a.a().getCurrentActivity();
        if (r104 == null) goto L18;
        r103.f573754c = new b(r104, r103);
        return;
    L18:
        return;
    L17:
        return;
    L11:
        r103 = null;
        goto L12
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
    }
}
