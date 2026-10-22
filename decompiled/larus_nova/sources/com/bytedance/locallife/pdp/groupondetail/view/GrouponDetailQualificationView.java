package com.bytedance.locallife.pdp.groupondetail.view;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import dx6.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/pdp/groupondetail/view/GrouponDetailQualificationView;", "Landroid/widget/FrameLayout;", "Ldx6/e;", "vo", "", "setVO", "Lcx6/a;", "listener", "setHighlightClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class GrouponDetailQualificationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cx6.a f261422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f261423b;

    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GrouponDetailQualificationView f261424a;

        public a(GrouponDetailQualificationView r100) {
            this.f261424a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            cx6.a r101 = this.f261424a.f261422a;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setUnderlineText(false);
            r100.setColor(ColorProtector.parseColor("#04498D"));
        }
    }

    public GrouponDetailQualificationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GrouponDetailQualificationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setHighlightClickListener(cx6.a r100) {
        this.f261422a = r100;
    }

    public final void setVO(e r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        String r101 = r100.d();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        int r102 = a(r101, this.f261423b);
        int r103 = a(r100.d() + 65292 + r100.e(), this.f261423b);
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        int r105 = 0;
        if (TextUtils.isEmpty(r100.d()) == true) goto L16;
        StringBuilder r106 = new StringBuilder();
        r106.append(r100.d());
        if (r102 != r103) goto L10;
        String r107 = "，";
    L11:
        r106.append(r107);
        r104.append(r106.toString());
        String r108 = r100.d();
        if (r108 == null) goto L14;
        int r109 = r108.length();
    L15:
        int r110 = r109 + 1;
        r104.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#99161823")), 0, r110, 33);
    L18:
        if (TextUtils.isEmpty(r100.e()) == true) goto L23;
        r104.append(r100.e());
        a r111 = new a(this);
        String r112 = r100.e();
        if (r112 == null) goto L22;
        r105 = r112.length();
    L22:
        r104.setSpan(r111, r110, r105 + r110, 33);
    L23:
        this.f261423b.setText(r104);
        return;
    L14:
        r109 = 0;
        goto L15
    L10:
        r107 = "\n";
        goto L11
    L16:
        r110 = 0;
        goto L18
    }

    public static int a(String r100, DuxTextView r110) {
        TextPaint r101 = r110.getPaint();
        int r102 = com.bytedance.locallife.biz.common.utils.e.b() - (com.bytedance.locallife.dito.utils.e.b(12) * 4);
        if (r102 > 0) goto L6;
        return 0;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L8;
        StaticLayout r103 = StaticLayout.Builder.obtain(r100, 0, r100.length(), r101, r102).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(r110.getLineSpacingExtra(), r110.getLineSpacingMultiplier()).setIncludePad(r110.getIncludeFontPadding()).setBreakStrategy(r110.getBreakStrategy()).setHyphenationFrequency(r110.getHyphenationFrequency()).build();
    L10:
        return r103.getLineCount();
    L8:
        r103 = new StaticLayout(r100, r101, r102, Layout.Alignment.ALIGN_NORMAL, r110.getLineSpacingMultiplier(), r110.getLineSpacingExtra(), r110.getIncludeFontPadding());
        goto L10
    }

    public GrouponDetailQualificationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        DuxTextView r103 = new DuxTextView(r100, null, 6, 0);
        this.f261423b = r103;
        bx6.a.e(r103, 11.0f);
        r103.setGravity(17);
        r103.setMovementMethod(LinkMovementMethod.getInstance());
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -2);
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        addView(r103, r104);
    }

    public /* synthetic */ GrouponDetailQualificationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
