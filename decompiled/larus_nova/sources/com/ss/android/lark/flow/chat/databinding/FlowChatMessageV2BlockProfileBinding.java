package com.ss.android.lark.flow.chat.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.flow.chat.view.MaxWidthConstraintLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatMessageV2BlockProfileBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaxWidthConstraintLayout f422121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarkAvatarView f422122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f422123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f422124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f422125e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f422121a;
    }

    public FlowChatMessageV2BlockProfileBinding(MaxWidthConstraintLayout r100, LarkAvatarView r101, TextView r102, View r103, TextView r104) {
        this.f422121a = r100;
        this.f422122b = r101;
        this.f422123c = r102;
        this.f422124d = r103;
        this.f422125e = r104;
    }
}
