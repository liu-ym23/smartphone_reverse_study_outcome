package com.ss.android.lark.vote.message.pin;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends iya.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f445252e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f445253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f445254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f445255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f445256d;

    public static final class a {
    }

    static {
    }

    public b(View r100) {
        this.f445253a = r100;
        this.f445254b = (ViewGroup) r100.findViewById(R.id.vote_card);
        this.f445255c = (TextView) r100.findViewById(R.id.vote_title_tv);
        this.f445256d = (RecyclerView) r100.findViewById(R.id.vote_option_rv);
        ImageView r101 = (ImageView) r100.findViewById(R.id.vote_icon);
        TextView r102 = (TextView) r100.findViewById(R.id.tv_name_time);
    }
}
