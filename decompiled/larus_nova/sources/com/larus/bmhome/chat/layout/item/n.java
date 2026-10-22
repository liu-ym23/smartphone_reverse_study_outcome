package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes25.dex */
public final class n extends xc8.h {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f304513p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RoundAvatarImageView f304514q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LottieAdapterView f304515r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup f304516s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ViewGroup f304517t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f304518u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f304519v;

    public static final class a {
    }

    static {
    }

    public final void n() {
        FLogger.f375446a.i("BotMakerBox", "hideAvatarLoading");
        LottieAdapterView r100 = this.f304515r;     // Catch: Exception -> L10
        if (r100 == null) goto L6;
        r100.cancelAnimation();     // Catch: Exception -> L10
    L6:
        LottieAdapterView r101 = this.f304515r;     // Catch: Exception -> L10
        if (r101 == null) goto L15;
        r101.setVisibility(8);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        FLogger.f375446a.e("BotMakerBox", "hideAvatarLoading fail e=" + e.getMessage());
    }

    public final ViewGroup getCreateContainer() {
        return this.f304517t;
    }

    public final ViewGroup getEditContainer() {
        return this.f304516s;
    }

    public final ViewGroup getTitleContainer() {
        return this.f304518u;
    }

    public n(Context r100) {
        super(r100);
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(getMaxWidth(), getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_160, null, R.dimen.larus_dp_160)));
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_bot_maker_card, null);
        addView(r102, r101);
        this.f304513p = (TextView) r102.findViewById(R.id.nick_name);
        this.f304514q = (RoundAvatarImageView) r102.findViewById(R.id.iv_header);
        this.f304515r = (LottieAdapterView) r102.findViewById(R.id.avatar_loading);
        this.f304516s = (ViewGroup) r102.findViewById(R.id.edit_container);
        this.f304517t = (ViewGroup) r102.findViewById(R.id.create_container);
        this.f304518u = (ViewGroup) r102.findViewById(R.id.title_container);
        this.f304519v = r102;
    }

    public final void setCreateContainer(ViewGroup r100) {
        this.f304517t = r100;
    }

    public final void setEditContainer(ViewGroup r100) {
        this.f304516s = r100;
    }

    public final void setTitleContainer(ViewGroup r100) {
        this.f304518u = r100;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r100, boolean r101) {
        super.l(r100, r101);
        View r102 = this.f304519v;
        if (r102 == null) goto L9;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L8;
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
        r104.width = getMaxWidth();
        r102.setLayoutParams(r104);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
