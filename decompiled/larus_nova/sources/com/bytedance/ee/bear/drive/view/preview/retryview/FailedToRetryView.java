package com.bytedance.ee.bear.drive.view.preview.retryview;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import i75.g;
import z95.c;
import z95.e;
import z95.f;

/* JADX INFO: loaded from: classes16.dex */
public class FailedToRetryView extends SpaceEmptyState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f225174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f225175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f225176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f225177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f225178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f225179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PreviewViewModel f225180g;

    public class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FailedToRetryView f225181a;

        public a(FailedToRetryView r100) {
            this.f225181a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            if (this.f225181a.f225179f == null) goto L6;
            tt5.a.h("DRIVE_PREVIEW_FLOW", "showBlockState#btn retry click");
            ((ka5.b) this.f225181a.f225179f).f502186a.liveInnerReload().postValue(null);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            super.updateDrawState(r100);
            r100.setColor(UIHelper.getColor(R.color.text_placeholder));
            r100.setUnderlineText(false);
        }
    }

    public interface b {
    }

    public final void f() {
        setVisibility(0);
        Context r100 = getContext();
        if (e() == false) goto L9;
        setDesc(getResources().getString(R.string.CreationMobile_Common_NoInternet));
        String r101 = r100.getString(R.string.Drive_Drive_Retry);
        View.OnClickListener r102 = new z95.b(this);
        this.f225175b = r101;
        setPrimaryText(r101);
        setPrimaryClickListener(new f(r102));
        if (this.f225178e == true) goto L7;
        showPrimaryAction(false);
    L7:
        setPrimaryActionEnabled(false);
        return;
    L9:
        String r103 = r100.getString(R.string.Drive_Drive_Retry);
        View.OnClickListener r104 = new c(this);
        this.f225175b = r103;
        setPrimaryText(r103);
        setPrimaryClickListener(new f(r104));
        setPrimaryActionEnabled(true);
        showSecondaryAction(false);
    }

    private CharSequence getDescriptionText() {
        if (TextUtils.isEmpty(this.f225174a) == true) goto L7;
        return this.f225174a;
    L7:
        if (this.f225177d == false) goto L11;
        return getRetrySpannableString();
    L11:
        return getContext().getString(R.string.Drive_Drive_LoadingFail);
    }

    public static boolean e() {
        boolean r100 = g.a();
        boolean r101 = g.b();
        tt5.a.b("FailedToRetryView", "interceptWeakNetworkRequest: isUnUsableNetState=" + r100 + ", weakNetState=" + r101);
        if (r100 == true) goto L7;
        if (r101 == true) goto L7;
        return false;
    L7:
        return true;
    }

    private SpannableString getRetrySpannableString() {
        String r100 = getResources().getString(R.string.CreationMobile_PDFPreview_Failed_Placeholder1);
        String r101 = getResources().getString(R.string.CreationMobile_PDFPreview_Failed_Placeholder2);
        SpannableString r102 = new SpannableString(r100 + r101);
        a r103 = new a(this);
        ForegroundColorSpan r104 = new ForegroundColorSpan(getResources().getColor(R.color.primary_fill_default));
        r102.setSpan(r103, 0, r102.length(), 17);
        r102.setSpan(r104, r102.length() - r101.length(), r102.length(), 17);
        return r102;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [z95.a] */
    public final void g() {
        Context r100 = getContext();
        setVisibility(0);
        String r101 = getContext().getString(R.string.Drive_Drive_OpenWithOtherApps);
        View.OnClickListener r102 = new e(this);
        this.f225175b = r101;
        setPrimaryText(r101);
        setPrimaryClickListener(new f(r102));
        if (e() == false) goto L5;
        return;
    L5:
        String r103 = r100.getString(R.string.Drive_Drive_Retry);
        ?? r104 = new z95.a(this);
        this.f225176c = r103;
        setSecondaryText(r103);
        setSecondaryClickListener(new z95.g(r104));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public FailedToRetryView(Context r100) {
        super(r100);
        this.f225178e = true;
        d(r100);
    }

    public static /* synthetic */ SpannableString b(FailedToRetryView r100) {
        return r100.getRetrySpannableString();
    }

    public static /* synthetic */ CharSequence c(FailedToRetryView r100) {
        return r100.getDescriptionText();
    }

    public final void d(Context r100) {
        setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
        setImageRes(Integer.valueOf(R.drawable.ccm_empty_negative_load_failed));
        setDesc(r100.getString(R.string.Drive_Drive_LoadingFail));
        f();
    }

    public void setDescriptionText(CharSequence r100) {
        tt5.a.h("FailedToRetryView", "setDescriptionText: " + r100);
        setDesc(r100);
    }

    public void setPlaceHolderText(CharSequence r100) {
        tt5.a.h("FailedToRetryView", "setPlaceHolderText: " + r100);
        this.f225174a = r100;
        setDesc(r100);
    }

    public void setRetryClickListener(b r100) {
        this.f225179f = r100;
    }

    public FailedToRetryView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225178e = true;
        d(r100);
    }

    public static /* synthetic */ void a(FailedToRetryView r100, Boolean r101) {
        r100.getClass();
        if (r101 == null) goto L16;
        r100.setPrimaryActionEnabled(r101.booleanValue());
        r100.setSecondaryActionEnabled(r101.booleanValue());
        CharSequence r102 = r100.getResources().getString(R.string.CreationMobile_Common_NoInternet);
        if (r101.booleanValue() == true) goto L9;
    L14:
        tt5.a.h("FailedToRetryView", "observeOuterNetState: " + r102);
        r100.setDesc(r102);
        return;
    L9:
        if (r100.f225177d == true) goto L11;
    L13:
        r102 = r100.getDescriptionText();
        goto L14
    L11:
        if (e() == true) goto L13;
        r102 = r100.getRetrySpannableString();
        goto L14
    }

    public FailedToRetryView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225178e = true;
        d(r100);
    }
}
