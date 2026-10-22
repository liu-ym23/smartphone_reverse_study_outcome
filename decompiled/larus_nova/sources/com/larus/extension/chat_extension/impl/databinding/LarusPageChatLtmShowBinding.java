package com.larus.extension.chat_extension.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;

/* JADX INFO: loaded from: classes24.dex */
public final class LarusPageChatLtmShowBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f342799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f342800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f342801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f342802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NovaTitleBarEx f342803e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f342799a;
    }

    public LarusPageChatLtmShowBinding(LinearLayout r100, LinearLayout r101, TextView r102, RecyclerView r103, NovaTitleBarEx r104) {
        this.f342799a = r100;
        this.f342800b = r101;
        this.f342801c = r102;
        this.f342802d = r103;
        this.f342803e = r104;
    }
}
