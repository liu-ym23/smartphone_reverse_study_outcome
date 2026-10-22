package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import bt8.o2;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o2 f316721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f316722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f316723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f316724d;

    public a(View r100, o2 r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f316721a = r101;
        this.f316722b = ContextCompat.getColor(r100.getContext(), c.b(R.attr.larus_primary_50, r100.getContext(), R.color.larus_primary_50));
        this.f316723c = ContextCompat.getColor(r100.getContext(), c.b(R.attr.larus_neutral_100, r100.getContext(), R.color.larus_neutral_100));
        this.f316724d = (TextView) r100.findViewById(R.id.tv_item_name);
    }
}
