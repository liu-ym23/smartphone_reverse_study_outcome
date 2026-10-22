package com.obric.assistant.card.databinding;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.obric.assistant.remote_card_container.widget.RemoteCardContainer;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricCardItemRemoteCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RemoteCardContainer f386129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RemoteCardContainer f386130b;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386129a;
    }

    public ObricCardItemRemoteCardBinding(RemoteCardContainer r100, RemoteCardContainer r101) {
        this.f386129a = r100;
        this.f386130b = r101;
    }
}
