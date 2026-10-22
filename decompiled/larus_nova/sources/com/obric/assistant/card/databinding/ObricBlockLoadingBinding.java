package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricBlockLoadingBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f386055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f386056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShimmerTextView f386057c;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f386055a;
    }

    public ObricBlockLoadingBinding(LinearLayout r100, SimpleDraweeView r101, ShimmerTextView r102) {
        this.f386055a = r100;
        this.f386056b = r101;
        this.f386057c = r102;
    }
}
