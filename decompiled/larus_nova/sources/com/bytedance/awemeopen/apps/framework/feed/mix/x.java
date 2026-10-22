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

/* JADX INFO: loaded from: classes14.dex */
public final class x extends IWrittenLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AoImageView f194985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f194986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f194987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f194988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Context f194989g;

    @Override // com.bytedance.awemeopen.writtenlayout.IWrittenLayout
    public final View f() {
        ViewGroup.LayoutParams r100 = new ViewGroup.LayoutParams(-1, -1);
        h(r100, 108.0f);
        final Context r101 = this.f194989g;
        Function1<LinearLayout, Unit> r102 = new MixAwemeListViewHolder$Companion$new$item$1$createView$1(this, r101);
        Intrinsics.checkNotNullParameter(r100, "lparams");
        return o(0, r100, r102);
    }

    public x(Context r100) {
        this.f194989g = r100;
        super(r100);
    }
}
