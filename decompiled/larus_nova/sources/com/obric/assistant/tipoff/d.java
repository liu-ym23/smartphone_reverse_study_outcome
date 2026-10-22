package com.obric.assistant.tipoff;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.larus.common_ui.widget.MaxHeightScrollView;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseObricTipOffDialogFragment.a f393516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f393517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseObricTipOffDialogFragment f393518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MaxHeightScrollView f393519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f393520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f393521f;

    public d(BaseObricTipOffDialogFragment.a r100, View r101, BaseObricTipOffDialogFragment r102, MaxHeightScrollView r103, View r104, int r105) {
        this.f393516a = r100;
        this.f393517b = r101;
        this.f393518c = r102;
        this.f393519d = r103;
        this.f393520e = r104;
        this.f393521f = r105;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        this.f393516a.f393421a = false;
        if (ViewCompat.isAttachedToWindow(this.f393517b) == false) goto L6;
        BaseObricTipOffDialogFragment r109 = this.f393518c;
        View r110 = this.f393517b;
        MaxHeightScrollView r111 = this.f393519d;
        View r112 = this.f393520e;
        int r113 = this.f393521f;
        BaseObricTipOffDialogFragment.a r114 = this.f393516a;
        int r115 = BaseObricTipOffDialogFragment.f393420d;
        r109.getClass();
        BaseObricTipOffDialogFragment.Z90(r110, r111, r112, r113, r114);
        return;
    }
}
