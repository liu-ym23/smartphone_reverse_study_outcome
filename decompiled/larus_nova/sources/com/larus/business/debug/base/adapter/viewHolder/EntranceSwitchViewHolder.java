package com.larus.business.debug.base.adapter.viewHolder;

import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sv8.f;
import zv8.e;
import zv8.p;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/business/debug/base/adapter/viewHolder/EntranceSwitchViewHolder;", "Lcom/larus/business/debug/base/adapter/viewHolder/EntranceViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "switch", "Landroidx/appcompat/widget/SwitchCompat;", "bind", "", "debugEntrance", "Lcom/larus/business/debug/base/register/DebugEntrance;", "unbind", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceSwitchViewHolder extends EntranceViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f319972c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SwitchCompat f319973b;

    public EntranceSwitchViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void T3(final e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        this.f319977a = r100;
        SwitchCompat r101 = (SwitchCompat) this.itemView.findViewById(R.id.entrance_switch);
        this.f319973b = r101;
        if (r101 == null) goto L6;
        r101.setOnLongClickListener(new sv8.e(r100));
    L6:
        if ((r100 instanceof p) == false) goto L8;
        final p r102 = (p) r100;
    L9:
        if (r102 == null) goto L16;
        final SwitchCompat r103 = this.f319973b;
        if (r103 == null) goto L13;
        r102.f573771b = r103;
    L13:
        if (r103 == null) goto L17;
        r103.setText(r102.c());
        r103.setChecked(r102.f());
        r103.setOnCheckedChangeListener(new f(r100, r102, r103));
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.larus.business.debug.base.adapter.viewHolder.EntranceViewHolder
    public final void U3(e r100) {
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        Intrinsics.checkNotNullParameter(r100, "debugEntrance");
        if ((r100 instanceof p) == false) goto L5;
        p r101 = (p) r100;
    L6:
        if (r101 != null) goto L8;
    L10:
        SwitchCompat r102 = this.f319973b;
        if (r102 == null) goto L13;
        r102.setVisibility(0);
    L13:
        SwitchCompat r103 = this.f319973b;
        if (r103 == null) goto L16;
        r103.setText("");
    L16:
        SwitchCompat r104 = this.f319973b;
        if (r104 == null) goto L20;
        r104.setOnCheckedChangeListener(null);
        return;
    L20:
        return;
    L8:
        if (r101.f573771b != this.f319973b) goto L10;
        r101.f573771b = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
