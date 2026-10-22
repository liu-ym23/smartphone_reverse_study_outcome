package com.larus.bmhome.view.actionbar.edit.component;

import android.widget.SeekBar;
import android.widget.TextView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class h0 implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<com.larus.bmhome.actionbar.model.w> f316338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f316339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Long, Unit> f316340c;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public h0(List r100, TextView r101, c0 r102) {
        this.f316338a = r100;
        this.f316339b = r101;
        this.f316340c = r102;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        com.larus.bmhome.actionbar.model.w r103 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(this.f316338a, r101);
        TextView r104 = this.f316339b;
        Long r105 = null;
        if (r103 == null) goto L5;
        String r106 = j0.d(r103);
    L6:
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r104.setText(r106);
        Function1<Long, Unit> r107 = this.f316340c;
        if (r103 == null) goto L11;
        r105 = r103.f295510a;
    L11:
        r107.invoke(r105);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
