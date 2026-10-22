package com.larus.photopicker.impl.ui;

import android.widget.FrameLayout;
import com.larus.photopicker.impl.ui.holder.InputPaddingFooterViewHolder;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class a2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f364088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PhotoPickerFragment f364089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f364090c;

    public /* synthetic */ a2(boolean r100, PhotoPickerFragment r101, Function1 r102) {
        this.f364088a = r100;
        this.f364089b = r101;
        this.f364090c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = this.f364088a;
        PhotoPickerFragment r101 = this.f364089b;
        Function1 r102 = this.f364090c;
        if (r100 == false) goto L7;
        FrameLayout r103 = r101.F;
        if (r103 == null) goto L7;
        int r104 = r103.getHeight();
    L8:
        InputPaddingFooterViewHolder r105 = r101.f364060k0;
        if (r105 == null) goto L11;
        r105.T3(r104);
    L11:
        r102.invoke(Integer.valueOf(r104));
        return;
    L7:
        r104 = 0;
        goto L8
    }
}
