package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.ReplySuggestList;

/* JADX INFO: loaded from: classes4.dex */
public final class LarusChatInputReplyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f310788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f310789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f310790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatImageView f310791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReplySuggestList f310792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f310793f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f310788a;
    }

    public LarusChatInputReplyBinding(View r100, View r101, AppCompatImageView r102, AppCompatImageView r103, ReplySuggestList r104, TextView r105) {
        this.f310788a = r100;
        this.f310789b = r101;
        this.f310790c = r102;
        this.f310791d = r103;
        this.f310792e = r104;
        this.f310793f = r105;
    }
}
