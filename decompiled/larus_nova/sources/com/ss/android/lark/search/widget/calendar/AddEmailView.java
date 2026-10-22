package com.ss.android.lark.search.widget.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/search/widget/calendar/AddEmailView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mAddMailContainer", "Landroid/widget/RelativeLayout;", "getMAddMailContainer", "()Landroid/widget/RelativeLayout;", "setMAddMailContainer", "(Landroid/widget/RelativeLayout;)V", "mAddMailImg", "Landroid/widget/ImageView;", "getMAddMailImg", "()Landroid/widget/ImageView;", "setMAddMailImg", "(Landroid/widget/ImageView;)V", "mMailNameTv", "Landroid/widget/TextView;", "getMMailNameTv", "()Landroid/widget/TextView;", "setMMailNameTv", "(Landroid/widget/TextView;)V", "initViews", "", "search-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddEmailView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f440370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f440371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f440372c;

    public final RelativeLayout getMAddMailContainer() {
        RelativeLayout r100 = this.f440370a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAddMailContainer");
        return null;
    }

    public final ImageView getMAddMailImg() {
        ImageView r100 = this.f440371b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAddMailImg");
        return null;
    }

    public final TextView getMMailNameTv() {
        TextView r100 = this.f440372c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mMailNameTv");
        return null;
    }

    public AddEmailView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setMAddMailContainer(RelativeLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440370a = r100;
    }

    public final void setMAddMailImg(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440371b = r100;
    }

    public final void setMMailNameTv(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f440372c = r100;
    }

    public AddEmailView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.calendar_add_mail, this, true);
        setMAddMailContainer((RelativeLayout) findViewById(R.id.add_mail_container));
        setMAddMailImg((ImageView) findViewById(R.id.add_mail_img));
        setMMailNameTv((TextView) findViewById(R.id.mail_name_tv));
    }
}
