package com.larus.mainbot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.standarduikit.fileblock.view.FileAudioButtonView;
import com.larus.bmhome.chat.standarduikit.localfileblock.view.LocalFileCardView;

/* JADX INFO: loaded from: classes30.dex */
public final class LarusBlockItemLocalFileBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f358461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileAudioButtonView f358462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f358463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f358464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f358465e;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f358461a;
    }

    public LarusBlockItemLocalFileBinding(LocalFileCardView r100, FileAudioButtonView r101, SimpleDraweeView r102, TextView r103, TextView r104) {
        this.f358461a = r100;
        this.f358462b = r101;
        this.f358463c = r102;
        this.f358464d = r103;
        this.f358465e = r104;
    }
}
