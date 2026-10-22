package com.larus.login.impl.switchbind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bk9.a;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/login/impl/switchbind/view/AccountCardView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titleView", "Landroid/widget/TextView;", "avatarView", "Lcom/larus/bmhome/view/RoundAvatarImageView;", "nicknameView", "bindButton", "titleHint", "setAccountInfo", "", "accountInfo", "Lcom/larus/login/impl/switchbind/entity/AccountInfo;", "showTitleHint", "setOnBindClickListener", "listener", "Landroid/view/View$OnClickListener;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountCardView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoundAvatarImageView f358262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f358263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f358264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f358265d;

    public AccountCardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AccountCardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setAccountInfo(a r110) {
        Intrinsics.checkNotNullParameter(r110, "accountInfo");
        RoundAvatarImageView.f(this.f358262a, r110.f19383a, "settings.account.switch_bind", false, 12);
        this.f358263b.setText(r110.f19384b);
        if (r110.f19386d == false) goto L8;
        String r111 = r110.f19385c;
        StringCompanionObject r100 = StringCompanionObject.INSTANCE;
        int r101 = j0.f375426a;
        String r102 = String.format(j0.d(R.string.larus_rebind_douyin_unavailable_boundAccount_msg_cn), Arrays.copyOf(new Object[]{r111}, 1));
        SpannableString r103 = new SpannableString(r102);
        int r104 = StringsKt.indexOf$default(r102, r111, 0, false, 6, null);
        if (r104 == (-1)) goto L7;
        r103.setSpan(new StyleSpan(1), r104, r111.length() + r104, 33);
    L7:
        this.f358265d.setText(r103);
        e1.x(this.f358265d);
        return;
    L8:
        e1.x(this);
    }

    public final void setOnBindClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f358264c.setOnClickListener(r100);
    }

    public AccountCardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_view_account_card, this, true);
        TextView r103 = (TextView) findViewById(R.id.card_title);
        this.f358262a = (RoundAvatarImageView) findViewById(R.id.avatar);
        this.f358263b = (TextView) findViewById(R.id.nickname);
        TextView r104 = (TextView) findViewById(R.id.bind_button);
        this.f358264c = r104;
        this.f358265d = (TextView) findViewById(R.id.card_title_hint);
        if (r101 == null) goto L10;
        int r105 = 0;
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_card_title, R.attr.larus_show_bind_button}, 0, 0);
        r103.setText(r106.getString(0));
        if (r106.getBoolean(1, false) == true) goto L8;
        r105 = 8;
    L8:
        r104.setVisibility(r105);
        r106.recycle();
        return;
    }

    public /* synthetic */ AccountCardView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
