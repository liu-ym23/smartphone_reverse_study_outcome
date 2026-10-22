package com.obric.assistant.impl.databinding;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricActivityRecordAudioRuleWebviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f389450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f389451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f389452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f389453d;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f389450a;
    }

    public ObricActivityRecordAudioRuleWebviewBinding(LinearLayout r100, ImageView r101, View r102, ProgressBar r103, TextView r104, WebView r105) {
        this.f389450a = r100;
        this.f389451b = r102;
        this.f389452c = r103;
        this.f389453d = r104;
    }
}
