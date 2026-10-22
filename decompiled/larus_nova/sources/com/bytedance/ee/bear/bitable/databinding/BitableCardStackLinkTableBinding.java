package com.bytedance.ee.bear.bitable.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.titlebar.BitableBaseTitleBar;
import com.bytedance.ee.bear.bitable.infoarch.toolbar.BitableToolbarContainer;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableCardStackLinkTableBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f210701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f210702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f210703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitableNativeViewContainer f210704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitableBaseTitleBar f210705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BitableToolbarContainer f210706f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f210701a;
    }

    public static BitableCardStackLinkTableBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.bitable_card_stack_link_table, r101, false);
        r101.addView(r102);
        int r103 = R.id.addRecordContainer;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.addRecordContainer);
        if (r104 == null) goto L15;
        r103 = R.id.divider;
        View r105 = ViewBindings.findChildViewById(r102, R.id.divider);
        if (r105 == null) goto L15;
        r103 = R.id.nativeViewContainer;
        BitableNativeViewContainer r106 = (BitableNativeViewContainer) ViewBindings.findChildViewById(r102, R.id.nativeViewContainer);
        if (r106 == null) goto L15;
        r103 = R.id.titleBar;
        BitableBaseTitleBar r107 = (BitableBaseTitleBar) ViewBindings.findChildViewById(r102, R.id.titleBar);
        if (r107 == null) goto L15;
        r103 = R.id.toolbarContainer;
        BitableToolbarContainer r108 = (BitableToolbarContainer) ViewBindings.findChildViewById(r102, R.id.toolbarContainer);
        if (r108 == null) goto L15;
        return new BitableCardStackLinkTableBinding((LinearLayout) r102, r104, r105, r106, r107, r108);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public BitableCardStackLinkTableBinding(LinearLayout r100, LinearLayout r101, View r102, BitableNativeViewContainer r103, BitableBaseTitleBar r104, BitableToolbarContainer r105) {
        this.f210701a = r100;
        this.f210702b = r101;
        this.f210703c = r102;
        this.f210704d = r103;
        this.f210705e = r104;
        this.f210706f = r105;
    }
}
