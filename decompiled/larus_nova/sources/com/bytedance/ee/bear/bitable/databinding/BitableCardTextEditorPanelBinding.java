package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableTextFieldEditor;
import com.bytedance.ee.bear.widget.AtFinderView;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardTextEditorPanelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f210707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtFinderView f210708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CellEditDragView f210709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f210710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitableTextFieldEditor f210711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f210712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AppCompatImageView f210713g;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210707a;
    }

    public BitableCardTextEditorPanelBinding(FrameLayout r100, AtFinderView r101, CellEditDragView r102, View r103, BitableTextFieldEditor r104, LinearLayout r105, AppCompatImageView r106) {
        this.f210707a = r100;
        this.f210708b = r101;
        this.f210709c = r102;
        this.f210710d = r103;
        this.f210711e = r104;
        this.f210712f = r105;
        this.f210713g = r106;
    }
}
