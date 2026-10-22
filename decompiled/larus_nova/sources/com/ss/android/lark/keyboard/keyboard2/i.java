package com.ss.android.lark.keyboard.keyboard2;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f429551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f429552b;

    public interface a {
        void performClick();
    }

    public interface b extends a {
        KeyboardMenu.f a();
    }

    public i(AppCompatImageView r100, KeyboardMenu.f r101) {
        Intrinsics.checkNotNullParameter(r100, "iconView");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f429551a = r100;
        this.f429552b = r101;
    }
}
