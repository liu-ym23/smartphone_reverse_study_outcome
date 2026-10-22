package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes31.dex */
public final class LarusItemActionBarMsgInstructionV2Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f373161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f373162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f373163c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f373161a;
    }

    public static LarusItemActionBarMsgInstructionV2Binding a(LayoutInflater r100, ConstraintLayout r101) {
        if (r101 == null) goto L12;
        r100.inflate(R.layout.larus_item_action_bar_msg_instruction_v2, r101);
        int r102 = R.id.display_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r101, R.id.display_text);
        if (r103 == null) goto L10;
        r102 = R.id.icon;
        SimpleDraweeView r104 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.icon);
        if (r104 == null) goto L10;
        return new LarusItemActionBarMsgInstructionV2Binding(r101, r103, r104);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L12:
        throw new NullPointerException("parent");
    }

    public LarusItemActionBarMsgInstructionV2Binding(ConstraintLayout r100, TextView r101, SimpleDraweeView r102) {
        this.f373161a = r100;
        this.f373162b = r101;
        this.f373163c = r102;
    }
}
