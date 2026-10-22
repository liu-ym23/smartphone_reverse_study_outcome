package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.sys;

import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.Target;
import rkb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements g<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatImageView f413254a;

    public c(AppCompatImageView r100) {
        this.f413254a = r100;
    }

    @Override // rkb.g
    public final boolean onLoadFailed(Exception r100, Object r101, Target<Object> r102, boolean r103) {
        this.f413254a.setVisibility(8);
        return true;
    }

    @Override // rkb.g
    public final boolean onResourceReady(Object r100, Object r101, Target<Object> r102, DataSource r103, boolean r104) {
        this.f413254a.setVisibility(0);
        return false;
    }
}
