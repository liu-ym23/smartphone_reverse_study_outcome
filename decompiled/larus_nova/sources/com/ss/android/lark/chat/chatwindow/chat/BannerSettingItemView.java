package com.ss.android.lark.chat.chatwindow.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/BannerSettingItemView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnView", "Landroid/view/View;", "getBtnView", "()Landroid/view/View;", "titleView", "getTitleView", "tvDesc", "Landroid/widget/TextView;", "getTvDesc", "()Landroid/widget/TextView;", "vLineRight", "vLineLeft", "setLineVisibility", "", "isVisible", "", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerSettingItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f412344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f412345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f412346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f412347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f412348e;

    public BannerSettingItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BannerSettingItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final View getBtnView() {
        return this.f412344a;
    }

    public final View getTitleView() {
        return this.f412345b;
    }

    public final TextView getTvDesc() {
        return this.f412346c;
    }

    public final void setLineVisibility(boolean r100) {
        View r101 = this.f412347d;
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        View r104 = this.f412348e;
        if (r100 == true) goto L10;
        r102 = 8;
    L10:
        r104.setVisibility(r102);
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public BannerSettingItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(1);
        LayoutInflater.from(r100).inflate(R.layout.view_banner_item_decoration, this, true);
        this.f412344a = findViewById(R.id.rl_banner_upgrade_root);
        this.f412345b = findViewById(R.id.tv_banner_title);
        this.f412346c = (TextView) findViewById(R.id.tv_banner_desc);
        this.f412347d = findViewById(R.id.v_line_right);
        this.f412348e = findViewById(R.id.v_line_left);
    }

    public /* synthetic */ BannerSettingItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
