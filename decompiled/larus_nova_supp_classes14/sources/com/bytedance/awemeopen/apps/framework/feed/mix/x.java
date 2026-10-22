package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.writtenlayout.IWrittenLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x extends IWrittenLayout {
    public AoImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public final /* synthetic */ Context g;

    public final View f() {
        ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-1, -1);
        h(r0, 108.0f);
        final Context r2 = this.g;
        Function1<LinearLayout, Unit> r1 = new MixAwemeListViewHolder$Companion$new$item$1$createView$1(this, r2);
        Intrinsics.checkNotNullParameter(r0, "lparams");
        return o(0, r0, r1);
    }

    public x(Context r1) {
        this.g = r1;
        super(r1);
    }
}
