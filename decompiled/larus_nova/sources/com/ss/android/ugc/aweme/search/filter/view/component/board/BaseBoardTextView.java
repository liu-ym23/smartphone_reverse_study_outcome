package com.ss.android.ugc.aweme.search.filter.view.component.board;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.larus.nova.R;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.utils.ViewExtKt;
import com.ss.android.ugc.aweme.search.filter.utils.ECSearchFilterRes;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import com.ss.android.ugc.aweme.search.utils.extensions.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u0006¢\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010%\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/board/BaseBoardTextView;", "Landroid/widget/LinearLayout;", "", "text", "", "setMainTitleText", "", "textId", "color", "setMainTitleTextColor", "(Ljava/lang/Integer;)V", "", CloudControlInf.SP, "setMainTitleTextSize", "(Ljava/lang/Double;)V", "setSubTitleText", "setSubTitleTextColor", "setSubTitleTextSize", "Landroid/widget/ImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/ImageView;", "getFilterIconLeft", "()Landroid/widget/ImageView;", "filterIconLeft", "b", "Landroid/widget/LinearLayout;", "getFilterTitleContent", "()Landroid/widget/LinearLayout;", "filterTitleContent", "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "c", "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "getFilterMainTitleText", "()Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "filterMainTitleText", "d", "getFilterSubTitleText", "filterSubTitleText", "", "e", "Z", "getMIsSelected", "()Z", "setMIsSelected", "(Z)V", "mIsSelected", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseBoardTextView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f453058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f453059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DmtTextView f453060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DmtTextView f453061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f453062e;

    public BaseBoardTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseBoardTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ImageView getFilterIconLeft() {
        return this.f453058a;
    }

    public final DmtTextView getFilterMainTitleText() {
        return this.f453060c;
    }

    public final DmtTextView getFilterSubTitleText() {
        return this.f453061d;
    }

    public final LinearLayout getFilterTitleContent() {
        return this.f453059b;
    }

    public final boolean getMIsSelected() {
        return this.f453062e;
    }

    public final void setMIsSelected(boolean r100) {
        this.f453062e = r100;
    }

    public final void setMainTitleText(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        this.f453060c.setVisibility(8);
        return;
    L12:
        this.f453060c.setVisibility(0);
        this.f453060c.setText(r100);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setMainTitleTextColor(Integer r100) {
        if (r100 == null) goto L5;
        r100.intValue();
        this.f453060c.setTextColor(r100.intValue());
        return;
    }

    public final void setMainTitleTextSize(Double r100) {
        if (r100 == null) goto L5;
        r100.doubleValue();
        DmtTextView r101 = this.f453060c;
        float r102 = (float) r100.doubleValue();
        Resources r103 = Resources.getSystem();
        r101.setTextSize(0, TypedValue.applyDimension(2, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        return;
    }

    public final void setSubTitleText(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        this.f453061d.setVisibility(8);
        return;
    L12:
        this.f453061d.setVisibility(0);
        this.f453061d.setText(r100);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void setSubTitleTextColor(Integer r100) {
        if (r100 == null) goto L5;
        r100.intValue();
        this.f453061d.setTextColor(r100.intValue());
        return;
    }

    public final void setSubTitleTextSize(Double r100) {
        if (r100 == null) goto L5;
        r100.doubleValue();
        DmtTextView r101 = this.f453061d;
        float r102 = (float) r100.doubleValue();
        Resources r103 = Resources.getSystem();
        r101.setTextSize(0, TypedValue.applyDimension(2, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics())));
        return;
    }

    public final void setMainTitleText(int r100) {
        this.f453060c.setVisibility(0);
        this.f453060c.setText(r100);
    }

    public final void setSubTitleText(int r100) {
        this.f453061d.setVisibility(0);
        this.f453061d.setText(r100);
    }

    public final void a(boolean r100, Boolean r101) {
        this.f453062e = r100;
        boolean r102 = false;
        if (r100 == false) goto L14;
        TextPaint r103 = this.f453060c.getPaint();
        if (r103 == null) goto L7;
        r103.setFakeBoldText(true);
    L7:
        TextPaint r104 = this.f453061d.getPaint();
        if (r104 == null) goto L21;
        if (r101 != null) goto L11;
    L12:
        r102 = true;
    L13:
        r104.setFakeBoldText(r102);
        return;
    L11:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L13;
    L21:
        return;
    L14:
        TextPaint r105 = this.f453060c.getPaint();
        if (r105 == null) goto L17;
        r105.setFakeBoldText(false);
    L17:
        TextPaint r106 = this.f453061d.getPaint();
        if (r106 == null) goto L23;
        r106.setFakeBoldText(false);
        return;
    }

    public BaseBoardTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_search_textview_in_select_borad, this);
        this.f453058a = (ImageView) findViewById(R.id.filter_icon_left);
        this.f453059b = (LinearLayout) findViewById(R.id.filter_title_content);
        this.f453060c = (DmtTextView) findViewById(R.id.filter_main_title_text);
        this.f453061d = (DmtTextView) findViewById(R.id.filter_sub_title_text);
    }

    public /* synthetic */ BaseBoardTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void b(Drawable r100, int r101, int r102, int r103) {
        if (r100 != null) goto L5;
        this.f453058a.setVisibility(8);
        return;
    L5:
        this.f453058a.setVisibility(0);
        this.f453058a.setImageDrawable(r100);
        ViewExtensionsKt.b(this.f453058a, DimenExtensionsKt.a(Integer.valueOf(r101)));
        ViewExtKt.f(this.f453058a, DimenExtensionsKt.a(Integer.valueOf(r102)));
        ViewExtKt.n(this.f453058a, DimenExtensionsKt.a(Integer.valueOf(r103)));
    }

    public final void c(Integer r100, int r101, int r102, int r103) {
        if (r100 != null) goto L5;
        this.f453058a.setVisibility(8);
        return;
    L5:
        this.f453058a.setVisibility(0);
        ECSearchFilterRes r104 = ECSearchFilterRes.f452967b;
        ImageView r105 = this.f453058a;
        int r106 = r100.intValue();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "imageView");
        r105.setImageResource(r106);
        ViewExtensionsKt.b(this.f453058a, DimenExtensionsKt.a(Integer.valueOf(r101)));
        ViewExtKt.f(this.f453058a, DimenExtensionsKt.a(Integer.valueOf(r102)));
        ViewExtKt.n(this.f453058a, DimenExtensionsKt.a(Integer.valueOf(r103)));
    }

    public static /* synthetic */ void d(BaseBoardTextView r100, Integer r101, int r102, int r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 16;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = 16;
    L9:
        if ((r104 & 8) == 0) goto L11;
        int r105 = 2;
    L12:
        r100.c(r101, r102, r103, r105);
        return;
    L11:
        r105 = 0;
        goto L12
    }
}
