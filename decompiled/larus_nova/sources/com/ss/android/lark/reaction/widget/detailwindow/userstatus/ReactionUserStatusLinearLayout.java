package com.ss.android.lark.reaction.widget.detailwindow.userstatus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import v2c.a;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionUserStatusLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f439342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f439343b;

    public int getMaxLines() {
        return this.f439343b.getMaxLines();
    }

    public final void a() {
        getContext();
        LinearLayout.inflate(getContext(), R.layout.reaction_view_user_status, this);
        this.f439342a = (ImageView) findViewById(R.id.iv_icon);
        this.f439343b = (TextView) findViewById(R.id.tv_desc);
        setTextSize(12);
    }

    public ReactionUserStatusLinearLayout(Context r100) {
        super(r100);
        a();
    }

    public void setIconVisibility(int r100) {
        this.f439342a.setVisibility(r100);
    }

    public void setMaxLines(int r100) {
        this.f439343b.setMaxLines(r100);
    }

    public void setTextColor(int r100) {
        this.f439343b.setTextColor(r100);
    }

    public void setTextMaxWidth(int r100) {
        this.f439343b.setMaxWidth(r100);
    }

    public void setTextSize(int r100) {
        this.f439343b.setTextSize(r100);
        this.f439343b.setMinHeight(a.a(getContext(), r100 + 2));
    }

    public void setWidth(int r100) {
        this.f439343b.setWidth(r100);
    }

    public ReactionUserStatusLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public ReactionUserStatusLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }
}
