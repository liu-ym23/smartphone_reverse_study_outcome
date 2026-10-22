package com.obric.oui.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.alipay.sdk.m.x.d;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002¨\u0006!"}, d2 = {"Lcom/obric/oui/status/OPageStatus;", "Landroid/widget/LinearLayout;", "", "type", "", "setType", "resId", "setLoadingLayout", "Lcom/obric/oui/text/OTextView;", "getTitleView", "", "text", d.f25925o, "color", "setTitleColor", "getMessageView", "setMessage", "setMessageColor", "Lcom/obric/oui/button/OButton;", "getButton", "Lcom/obric/oui/progress/ODownloadProgressView;", "getLoadingView", "getLoadingResultView", "setLoadingResult", "setLoadingResultColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPageStatus extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f403036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OTextView f403037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OTextView f403038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OButton f403039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f403040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ODownloadProgressView f403041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OTextView f403042g;

    public static final class a {
    }

    static {
    }

    public OPageStatus(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OPageStatus(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final OButton getButton() {
        OButton r100 = this.f403039d;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("button");
        return null;
    L6:
        return r100;
    }

    public final OTextView getMessageView() {
        OTextView r100 = this.f403038c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        return null;
    L6:
        return r100;
    }

    public final OTextView getTitleView() {
        OTextView r100 = this.f403037b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    L6:
        return r100;
    }

    public final OTextView getLoadingResultView() {
        return this.f403042g;
    }

    public final ODownloadProgressView getLoadingView() {
        return this.f403041f;
    }

    public final void a(boolean r100) {
        OButton r101 = this.f403039d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("button");
        r101 = null;
    L5:
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void b(boolean r100) {
        ODownloadProgressView r101 = this.f403041f;
        if (r101 == null) goto L10;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void setLoadingLayout(int r100) {
        FrameLayout r101 = this.f403040e;
        FrameLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        r101 = null;
    L5:
        r101.removeAllViews();
        if (r100 == 0) goto L16;
        Context r103 = getContext();     // Catch: Exception -> L13
        FrameLayout r104 = this.f403040e;     // Catch: Exception -> L13
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");     // Catch: Exception -> L13
    L11:
        LinearLayout.inflate(r103, r100, r102);     // Catch: Exception -> L13
        return;
    L10:
        r102 = r104;
    L17:
        return;
    }

    public final void setLoadingResult(CharSequence r100) {
        OTextView r101 = this.f403042g;
        if (r101 == null) goto L7;
        r101.setText(r100);
        return;
    }

    public final void setLoadingResultColor(int r100) {
        OTextView r101 = this.f403042g;
        if (r101 == null) goto L7;
        r101.setTextColor(r100);
        return;
    }

    public final void setMessage(CharSequence r100) {
        OTextView r101 = this.f403038c;
        OTextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        r101 = null;
    L5:
        r101.setText(r100);
        OTextView r103 = this.f403038c;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
    L9:
        int r104 = 0;
        if (r100 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        r104 = 8;
    L18:
        r102.setVisibility(r104);
        return;
    L12:
        if (r100.length() == 0) goto L15;
        r105 = false;
        goto L16
    L8:
        r102 = r103;
        goto L9
    }

    public final void setMessageColor(int r100) {
        OTextView r101 = this.f403038c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageView");
        r101 = null;
    L5:
        r101.setTextColor(r100);
    }

    public final void setTitle(CharSequence r100) {
        OTextView r101 = this.f403037b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public final void setTitleColor(int r100) {
        OTextView r101 = this.f403037b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r101 = null;
    L5:
        r101.setTextColor(r100);
    }

    public final void setType(int r100) {
        FrameLayout r101 = null;
        if (r100 != 0) goto L5;
        LinearLayout r102 = this.f403036a;
        if (r102 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r102 = null;
    L28:
        r102.setVisibility(0);
        FrameLayout r103 = this.f403040e;
        if (r103 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
        r103 = null;
    L31:
        r103.setVisibility(8);
        setLoadingLayout(0);
        this.f403041f = null;
        this.f403042g = null;
        return;
    L5:
        if (r100 != 1) goto L7;
        LinearLayout r104 = this.f403036a;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r104 = null;
    L20:
        r104.setVisibility(8);
        FrameLayout r105 = this.f403040e;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L24:
        r101.setVisibility(0);
        setLoadingLayout(R.layout.o_page_status_vertical_loading_item);
        this.f403041f = (ODownloadProgressView) findViewById(R.id.status_loading);
        this.f403042g = (OTextView) findViewById(R.id.status_loading_result);
        return;
    L23:
        r101 = r105;
        goto L24
    L7:
        if (r100 != 2) goto L35;
        LinearLayout r106 = this.f403036a;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        r106 = null;
    L12:
        r106.setVisibility(8);
        FrameLayout r107 = this.f403040e;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
    L16:
        r101.setVisibility(0);
        setLoadingLayout(R.layout.o_page_status_horizontal_loading_item);
        this.f403041f = (ODownloadProgressView) findViewById(R.id.status_loading);
        this.f403042g = (OTextView) findViewById(R.id.status_loading_result);
        return;
    L15:
        r101 = r107;
        goto L16
    }

    public OPageStatus(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.o_page_status_layout, this, true);
        setGravity(1);
        this.f403036a = (LinearLayout) findViewById(R.id.content_container);
        this.f403037b = (OTextView) findViewById(R.id.status_title);
        this.f403038c = (OTextView) findViewById(R.id.status_message);
        this.f403039d = (OButton) findViewById(R.id.status_button);
        this.f403040e = (FrameLayout) findViewById(R.id.loading_container);
        if (r101 == null) goto L30;
        TypedArray r103 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{R.attr.opagestatus_loadingResult, R.attr.opagestatus_loadingResultColor, R.attr.opagestatus_message, R.attr.opagestatus_messageColor, R.attr.opagestatus_showLoading, R.attr.opagestatus_title, R.attr.opagestatus_titleColor, R.attr.opagestatus_type}, 0, 0);
        if (r103.hasValue(7) == false) goto L8;
        setType(r103.getInt(7, 0));
    L8:
        if (r103.hasValue(5) == false) goto L11;
        setTitle(r103.getString(5));
    L11:
        if (r103.hasValue(6) == false) goto L14;
        setTitleColor(r103.getColor(6, R.color.oui_basic_text_3));
    L14:
        if (r103.hasValue(2) == false) goto L17;
        setMessage(r103.getString(2));
    L17:
        if (r103.hasValue(3) == false) goto L20;
        setMessageColor(r103.getColor(3, R.color.oui_basic_text_3b));
    L20:
        if (r103.hasValue(4) == false) goto L23;
        b(r103.getBoolean(4, false));
    L23:
        if (r103.hasValue(0) == false) goto L26;
        setLoadingResult(r103.getString(0));
    L26:
        if (r103.hasValue(1) == false) goto L28;
        setLoadingResultColor(r103.getColor(0, R.color.oui_basic_text_3));
    L28:
        r103.recycle();
        return;
    }

    public /* synthetic */ OPageStatus(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
