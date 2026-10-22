package com.larus.office.plugins.input.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.nova.R;
import com.larus.office.impl.databinding.LarusOfficeSdkTextLoadingBinding;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0014J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/office/plugins/input/view/TextLoadingView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "multiLoading", "Lcom/larus/bmhome/chat/layout/widget/ThreeLoadingIndicator;", "binding", "Lcom/larus/office/impl/databinding/LarusOfficeSdkTextLoadingBinding;", "setFontWeightCompat", "", "Landroid/widget/TextView;", "weight", "changeTypes", "type", "onAttachedToWindow", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextLoadingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreeLoadingIndicator f362638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusOfficeSdkTextLoadingBinding f362639b;

    public static final class a {
    }

    static {
    }

    public TextLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TextLoadingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        FLogger.f375446a.i("TextLoadingView", "onAttachedToWindow visibility=" + getVisibility());
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L8;
        ThreeLoadingIndicator r100 = this.f362638a;
        if (r100 == null) goto L9;
        r100.d();
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThreeLoadingIndicator r100 = this.f362638a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void a(int r100) {
        CharSequence r101 = getResources().getText(R.string.larus_thinking_state);
        Resources r102 = getResources();
        int r103 = R.color.larus_neutral_100;
        Integer r104 = Integer.valueOf(r102.getColor(R.color.larus_neutral_100));
        if (r100 != 1) goto L5;
        r101 = getResources().getText(R.string.larus_aiDoc_writing_hint_short);
        float r105 = 600.0f;
        int r106 = R.drawable.larus_office_sdk_loading_dot_blue;
        r103 = R.color.larus_primary_50;
        Integer r107 = null;
    L6:
        LarusOfficeSdkTextLoadingBinding r108 = this.f362639b;
        if (r108 == null) goto L30;
        TextView r109 = r108.f362191b;
        if (r109 == null) goto L31;
        b(r109, (int) r105);
        r109.setTextColor(ContextCompat.getColor(r109.getContext(), r103));
        StringBuilder r110 = new StringBuilder();
        r110.append(r101);
        r110.append(' ');
        SpannableStringBuilder r111 = new SpannableStringBuilder(r110.toString());
        ThreeLoadingIndicator r112 = this.f362638a;
        if (r112 == null) goto L13;
        r112.a();
    L13:
        ThreeLoadingIndicator r113 = new ThreeLoadingIndicator(r109, r106, r109.getContext(), r107);
        this.f362638a = r113;
        List<v0> r114 = r113.f304930b;
        if (r114 == null) goto L19;
        Iterator<T> r115 = r114.iterator();
    L17:
        if (r115.hasNext() == false) goto L19;
        r111.append("⚫", (v0) r115.next(), 17);
    L19:
        ThreeLoadingIndicator r116 = this.f362638a;
        if (r116 == null) goto L23;
        r116.b(true);
    L23:
        if (r109.getVisibility() != 0) goto L27;
        ThreeLoadingIndicator r117 = this.f362638a;
        if (r117 == null) goto L27;
        r117.d();
    L27:
        r109.setText(r111);
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r105 = 400.0f;
        r107 = r104;
        r106 = R.drawable.larus_office_bg_loading_dot;
        goto L6
    }

    public static void b(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = 0;
        if (Build.VERSION.SDK_INT < 28) goto L6;
        r100.setTypeface(Typeface.create(r100.getTypeface(), r101, false));
        return;
    L6:
        if (r101 < 600) goto L8;
        r102 = 1;
    L8:
        r100.setTypeface(r100.getTypeface(), r102);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        FLogger.f375446a.i("TextLoadingView", "onVisibilityChanged visibility=" + r101);
        if (r101 != 0) goto L7;
        ThreeLoadingIndicator r102 = this.f362638a;
        if (r102 == null) goto L11;
        r102.d();
        return;
    L11:
        return;
    L7:
        ThreeLoadingIndicator r103 = this.f362638a;
        if (r103 == null) goto L13;
        r103.a();
        return;
    }

    public TextLoadingView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        boolean r102 = false;
        View r111 = LayoutInflater.from(r100).inflate(R.layout.larus_office_sdk_text_loading, this, false);
        addView(r111);
        TextView r103 = (TextView) ViewBindings.findChildViewById(r111, R.id.text_loading_main_text);
        if (r103 == null) goto L30;
        LarusOfficeSdkTextLoadingBinding r104 = new LarusOfficeSdkTextLoadingBinding((FrameLayout) r111, r103);
        this.f362639b = r104;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.larus_tlv_loadingIconRes, R.attr.larus_tlv_text, R.attr.larus_tlv_textColor, R.attr.larus_tlv_text_weight});
        String r106 = r105.getString(1);
        int r107 = r105.getColor(2, 0);
        int r108 = r105.getResourceId(0, 0);
        float r109 = r105.getFloat(3, 0.0f);
        r105.recycle();
        TextView r112 = r104.f362191b;
        if (r112 != null) goto L7;
        return;
    L7:
        if (r109 <= 0.0f) goto L9;
        b(r112, (int) r109);
    L9:
        if (r106 != null) goto L11;
    L12:
        r102 = true;
    L13:
        if (r102 == true) goto L15;
        r112.setText(r106);
    L15:
        if (r107 == 0) goto L17;
        r112.setTextColor(r107);
    L17:
        if (r108 == 0) goto L33;
        StringBuilder r113 = new StringBuilder();
        r113.append(r112.getText());
        r113.append(' ');
        SpannableStringBuilder r114 = new SpannableStringBuilder(r113.toString());
        ThreeLoadingIndicator r115 = new ThreeLoadingIndicator(r112, r108, r100, null);
        this.f362638a = r115;
        List<v0> r116 = r115.f304930b;
        if (r116 == null) goto L24;
        Iterator<T> r117 = r116.iterator();
    L22:
        if (r117.hasNext() == false) goto L24;
        r114.append("⚫", (v0) r117.next(), 17);
    L24:
        ThreeLoadingIndicator r118 = this.f362638a;
        if (r118 == null) goto L27;
        r118.b(true);
    L27:
        r112.setText(r114);
        return;
    L33:
        return;
    L11:
        if (r106.length() != 0) goto L13;
    L30:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(R.id.text_loading_main_text)));
    }

    public /* synthetic */ TextLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
