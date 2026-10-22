package com.ss.android.ugc.aweme.search.vision.result.status;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/status/PhotoSearchErrorView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "b", "Landroid/view/View$OnClickListener;", "getMOnClickListener", "()Landroid/view/View$OnClickListener;", "setMOnClickListener", "(Landroid/view/View$OnClickListener;)V", "mOnClickListener", "", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "d", "getDesc", SocialConstants.PARAM_APP_DESC, "e", "getRetryText", "retryText", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchErrorView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DmtTextView f453769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f453770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f453771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f453772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f453773e;

    public final String getDesc() {
        return this.f453772d;
    }

    public final View.OnClickListener getMOnClickListener() {
        return this.f453770b;
    }

    public final String getRetryText() {
        return this.f453773e;
    }

    public final String getTitle() {
        return this.f453771c;
    }

    public final void setMOnClickListener(View.OnClickListener r100) {
        this.f453770b = r100;
    }

    public PhotoSearchErrorView(Context r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r103, "retryText");
        super(r100);
        this.f453771c = r101;
        this.f453772d = r102;
        this.f453773e = r103;
        LayoutInflater.from(getContext()).inflate(R.layout.search_photo_layout_default_with_pic, this, true);
        ImageView r104 = (ImageView) findViewById(R.id.iv_empty);
        ViewGroup.LayoutParams r105 = null;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L9
        if (r104 == null) goto L6;
        r104.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.photo_search_network_error));     // Catch: Throwable -> L9
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L9
    L11:
        DmtTextView r108 = (DmtTextView) findViewById(R.id.tv_title);
        if (r108 == null) goto L14;
        r108.setText(this.f453771c);
    L14:
        DmtTextView r109 = (DmtTextView) findViewById(R.id.tv_refresh);
        this.f453769a = r109;
        if (r109 == null) goto L17;
        r109.setVisibility(0);
    L17:
        DmtTextView r110 = this.f453769a;
        if (r110 == null) goto L20;
        r110.setOnClickListener(new PhotoSearchErrorView$initErrorView$2(this));
    L20:
        DmtTextView r111 = this.f453769a;
        if (r111 == null) goto L23;
        r111.setText(this.f453773e);
    L23:
        DmtTextView r112 = this.f453769a;
        if (r112 == null) goto L26;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
    L28:
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L31;
        r105 = r113;
    L31:
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r105;
        if (r114 == null) goto L34;
        r114.topMargin = DimenExtensionsKt.b(40);
    L34:
        DmtTextView r115 = (DmtTextView) findViewById(R.id.tv_desc);
        if (r115 == null) goto L40;
        r115.setText(this.f453772d);
        return;
    L40:
        return;
    L26:
        r113 = null;
        goto L28
    L6:
        r107 = null;
    L9:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
