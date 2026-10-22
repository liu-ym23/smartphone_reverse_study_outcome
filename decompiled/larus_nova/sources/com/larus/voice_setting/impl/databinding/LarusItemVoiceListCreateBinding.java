package com.larus.voice_setting.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes32.dex */
public final class LarusItemVoiceListCreateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f376110a;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f376110a;
    }

    public LarusItemVoiceListCreateBinding(LinearLayout r100) {
        this.f376110a = r100;
    }

    public static LarusItemVoiceListCreateBinding a(LayoutInflater r100, ViewGroup r101) {
        View r102 = r100.inflate(R.layout.larus_item_voice_list_create, r101, false);
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.create_voice_text)) == null) goto L7;
        return new LarusItemVoiceListCreateBinding((LinearLayout) r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.create_voice_text)));
    }
}
