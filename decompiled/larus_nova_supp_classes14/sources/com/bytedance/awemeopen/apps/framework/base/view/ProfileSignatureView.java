package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.utils.y;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004+,-.B\u0013\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%B\u001d\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b$\u0010(B%\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010)\u001a\u00020\n¢\u0006\u0004\b$\u0010*J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000eR\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView;", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtTextView;", "", "Lcom/bytedance/awemeopen/bizmodels/feed/video/TextExtraStruct;", "structList", "", "setTextExtraList", "Lcom/bytedance/awemeopen/apps/framework/base/view/f;", "l", "setListener", "", "lines", "setFoldingToLine", "getFoldingToLine", "", "isMob", "setMobShow", "strRes", "setSignature", "visible", "setVisible", "", "f", "Lkotlin/Lazy;", "getMMoreBtnText", "()Ljava/lang/String;", "mMoreBtnText", "Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView$d;", "mOnSpanClickListener", "Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView$d;", "getMOnSpanClickListener", "()Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView$d;", "setMOnSpanClickListener", "(Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView$d;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "d", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class ProfileSignatureView extends DmtTextView {
    public static final /* synthetic */ int l = 0;
    public boolean a;
    public boolean b;
    public boolean c;
    public String d;
    public float e;
    public final Lazy f;
    public int g;
    public SpannableStringBuilder h;
    public List<TextExtraStruct> i;
    public final int j;
    public int k;

    public final class a extends c {
        public final int a;
        public final /* synthetic */ ProfileSignatureView b;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            y.a(r2);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setTextSize(this.b.getTextSize());
            r2.setColor(this.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(ProfileSignatureView r2, TextExtraStruct r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "struct");
            this.b = r2;
            this.a = r4;
            r2.getPaint().setColor(r4);
        }
    }

    public static final class b {
    }

    public abstract class c extends ClickableSpan {
        public c() {
        }
    }

    public interface d {
    }

    static {
    }

    public final d getMOnSpanClickListener() {
        return null;
    }

    public final void setListener(f r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
    }

    public final void setMOnSpanClickListener(d r1) {
    }

    private final String getMMoreBtnText() {
        return (String) this.f.getValue();
    }

    public final void B() {
        if (this.b == true) goto L6;
        this.b = true;
        return;
    }

    public final int getFoldingToLine() {
        return this.k;
    }

    public ProfileSignatureView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setTextExtraList(List<TextExtraStruct> r10) {
        List<TextExtraStruct> r0 = r10;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        CharSequence r2 = getText();
        if ((r2 instanceof SpannableStringBuilder) == false) goto L14;
        SpannableStringBuilder r3 = (SpannableStringBuilder) r2;
    L15:
        if (r3 != null) goto L18;
        r3 = new SpannableStringBuilder(getText());
    L18:
        if (TextUtils.isEmpty(String.valueOf(this.h)) == false) goto L20;
        return;
    L20:
        int r4 = r3.length();
        Iterator<TextExtraStruct> r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L45;
        TextExtraStruct r5 = r11.next();
        if (r5.getStart() > r5.getEnd()) goto L22;
        if (r5.getStart() > r4) goto L22;
        if (r5.getEnd() < 0) goto L22;
        if (r5.getStart() >= 0) goto L33;
        int r6 = 0;
    L35:
        if (r5.getEnd() <= r4) goto L37;
        int r7 = r4;
    L38:
        if (r7 <= r6) goto L22;
        int r8 = r5.getType();
        if (r8 == 0) goto L43;
        if (r8 == 1) goto L43;
    L44:
        r3.setSpan(new a(this, r5, this.g), r6, r7, 33);
    L43:
        this.g = getResources().getColor(2131100289);
        goto L44
    L37:
        r7 = r5.getEnd();
        goto L38
    L33:
        r6 = r5.getStart();
        goto L35
    L45:
        this.h = r3;
        setText(r3);
        return;
    L14:
        r3 = null;
        goto L15
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ String x(ProfileSignatureView r0) {
        return r0.getMMoreBtnText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(ProfileSignatureView r2) {
        r2.getClass();
        r2.setMovementMethod(i.b);
        r2.setText(r2.A(r2.d, false));
        r2.setMaxLines(Integer.MAX_VALUE);
        List<TextExtraStruct> r0 = r2.i;
        if (r0 == null) goto L5;
        r2.setTextExtraList(r0);
    L5:
        r2.a = true;
    }

    public final void setFoldingToLine(int r1) {
        if (r1 >= 0) goto L4;
        this.k = this.j;
        return;
    L4:
        this.k = r1;
    }

    public final void setMobShow(boolean r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSignature(int r2) {
        C(this, getContext().getString(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setVisible(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    public ProfileSignatureView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void C(ProfileSignatureView r3, String r4) {
        List<TextExtraStruct> r0 = CollectionsKt.emptyList();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "textExtraStructList");
        r3.setOnClickListener(null);
        if ((!TextUtils.equals(r4, r3.d)) == false) goto L6;
        r3.b = false;
        r3.d = r4;
        r3.i = r0;
        r3.setMovementMethod(i.b);
        r3.setText(r3.A(r4, false));
        r3.setTextExtraList(r0);
    L6:
        if (r3.a == true) goto L16;
        int r5 = r3.k;
        if (r5 >= 0) goto L11;
        r3.getClass();
        r3.B();
        return;
    L11:
        if (r3.c == true) goto L15;
        ViewTreeObserver r1 = r3.getViewTreeObserver();
        if (r1 == null) goto L19;
        r1.addOnGlobalLayoutListener(new h(r3, r5));
        return;
    L19:
        return;
    L15:
        r3.B();
        return;
    L16:
        r3.B();
    }

    public static final /* synthetic */ void z(ProfileSignatureView r0, List r1) {
        r0.setTextExtraList(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final SpannableStringBuilder A(CharSequence r9, boolean r10) {
        int r0 = 0;
        if (r9 == null) goto L10;
        boolean r2 = true;
        if (r9.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L10;
    L11:
        if (r2 == false) goto L13;
        Context r3 = getContext();
        float r5 = 0.0f;
        if (r3 == null) goto L17;
        Resources r4 = r3.getResources();
        float r6 = TypedValue.applyDimension(2, 14.0f, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()));
    L18:
        com.bytedance.awemeopen.apps.framework.base.view.d r7 = new com.bytedance.awemeopen.apps.framework.base.view.d(r6, ContextCompat.getColor(getContext(), 2131100332), new ProfileSignatureView$buildClickableSpannable$textSpan$1(this));
        Context r8 = getContext();
        if (r8 == null) goto L21;
        Resources r11 = r8.getResources();
        r5 = TypedValue.applyDimension(2, 14.0f, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()));
    L21:
        com.bytedance.awemeopen.apps.framework.base.view.d r12 = new com.bytedance.awemeopen.apps.framework.base.view.d(r5, ContextCompat.getColor(getContext(), 2131100343), new ProfileSignatureView$buildClickableSpannable$expandSpan$1(this));
        if ((r9 instanceof SpannableStringBuilder) == false) goto L24;
        SpannableStringBuilder r13 = (SpannableStringBuilder) r9;
    L25:
        if (r13 != null) goto L27;
        r13 = new SpannableStringBuilder(r9);
    L27:
        r13.setSpan(r7, 0, r9.length(), 17);
        if (r10 == false) goto L30;
        r13.append(getMMoreBtnText());
        r13.setSpan(r12, r9.length(), r9.length() + getMMoreBtnText().length(), 17);
    L30:
        Object[] r14 = r13.getSpans(0, r9.length(), c.class);
        int r15 = r14.length;
    L31:
        if (r0 >= r15) goto L33;
        ((c) r14[r0]).updateDrawState(getPaint());
        r0 = r0 + 1;
        goto L31
    L33:
        return r13;
    L24:
        r13 = null;
        goto L25
    L17:
        r6 = 0.0f;
        goto L18
    L13:
        return new SpannableStringBuilder("");
    L7:
        r1 = false;
    L10:
        r2 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProfileSignatureView(Context r2, AttributeSet r3, int r4) {
        new LinkedHashMap();
        super(r2, r3, r4);
        this.e = -1.0f;
        this.f = LazyKt.lazy(new ProfileSignatureView$mMoreBtnText$2(this));
        this.j = 4;
        this.k = 4;
        setHighlightColor(0);
    }
}
