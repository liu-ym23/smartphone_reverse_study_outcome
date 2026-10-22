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
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.utils.y;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0004+,-.B\u0013\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%B\u001d\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b$\u0010(B%\b\u0016\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010)\u001a\u00020\n¢\u0006\u0004\b$\u0010*J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000eR\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView;", "Lcom/bytedance/awemeopen/apps/framework/base/view/refresh/DmtTextView;", "", "Lcom/bytedance/awemeopen/bizmodels/feed/video/TextExtraStruct;", "structList", "", "setTextExtraList", "Lcom/bytedance/awemeopen/apps/framework/base/view/f;", "l", "setListener", "", GXTemplateKey.STYLE_FONT_LINES, "setFoldingToLine", "getFoldingToLine", "", "isMob", "setMobShow", "strRes", "setSignature", "visible", "setVisible", "", "f", "Lkotlin/Lazy;", "getMMoreBtnText", "()Ljava/lang/String;", "mMoreBtnText", "Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView$d;", "mOnSpanClickListener", "Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView$d;", "getMOnSpanClickListener", "()Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView$d;", "setMOnSpanClickListener", "(Lcom/bytedance/awemeopen/apps/framework/base/view/ProfileSignatureView$d;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class ProfileSignatureView extends DmtTextView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f193212l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f193213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f193214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f193215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f193216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f193217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f193218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f193219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpannableStringBuilder f193220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<TextExtraStruct> f193221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f193222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f193223k;

    public final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f193224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProfileSignatureView f193225b;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            y.a(r100);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setTextSize(this.f193225b.getTextSize());
            r100.setColor(this.f193224a);
        }

        public a(ProfileSignatureView r100, TextExtraStruct r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "struct");
            this.f193225b = r100;
            this.f193224a = r102;
            r100.getPaint().setColor(r102);
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

    public final void setListener(f r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
    }

    public final void setMOnSpanClickListener(d r100) {
    }

    private final String getMMoreBtnText() {
        return (String) this.f193218f.getValue();
    }

    public final void B() {
        if (this.f193214b == true) goto L6;
        this.f193214b = true;
        return;
    }

    public final int getFoldingToLine() {
        return this.f193223k;
    }

    public ProfileSignatureView(Context r100) {
        this(r100, null);
    }

    private final void setTextExtraList(List<TextExtraStruct> r110) {
        List<TextExtraStruct> r100 = r110;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        CharSequence r102 = getText();
        if ((r102 instanceof SpannableStringBuilder) == false) goto L14;
        SpannableStringBuilder r103 = (SpannableStringBuilder) r102;
    L15:
        if (r103 != null) goto L18;
        r103 = new SpannableStringBuilder(getText());
    L18:
        if (TextUtils.isEmpty(String.valueOf(this.f193220h)) == false) goto L20;
        return;
    L20:
        int r104 = r103.length();
        Iterator<TextExtraStruct> r111 = r110.iterator();
    L22:
        if (r111.hasNext() == false) goto L45;
        TextExtraStruct r105 = r111.next();
        if (r105.getStart() > r105.getEnd()) goto L22;
        if (r105.getStart() > r104) goto L22;
        if (r105.getEnd() < 0) goto L22;
        if (r105.getStart() >= 0) goto L33;
        int r106 = 0;
    L35:
        if (r105.getEnd() <= r104) goto L37;
        int r107 = r104;
    L38:
        if (r107 <= r106) goto L22;
        int r108 = r105.getType();
        if (r108 == 0) goto L43;
        if (r108 == 1) goto L43;
    L44:
        r103.setSpan(new a(this, r105, this.f193219g), r106, r107, 33);
    L43:
        this.f193219g = getResources().getColor(R.color.aos_link3);
        goto L44
    L37:
        r107 = r105.getEnd();
        goto L38
    L33:
        r106 = r105.getStart();
        goto L35
    L45:
        this.f193220h = r103;
        setText(r103);
        return;
    L14:
        r103 = null;
        goto L15
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static final /* synthetic */ String x(ProfileSignatureView r100) {
        return r100.getMMoreBtnText();
    }

    public static final void y(ProfileSignatureView r100) {
        r100.getClass();
        r100.setMovementMethod(i.f193246b);
        r100.setText(r100.A(r100.f193216d, false));
        r100.setMaxLines(Integer.MAX_VALUE);
        List<TextExtraStruct> r101 = r100.f193221i;
        if (r101 == null) goto L5;
        r100.setTextExtraList(r101);
    L5:
        r100.f193213a = true;
    }

    public final void setFoldingToLine(int r100) {
        if (r100 >= 0) goto L4;
        this.f193223k = this.f193222j;
        return;
    L4:
        this.f193223k = r100;
    }

    public final void setMobShow(boolean r100) {
        this.f193214b = r100;
    }

    public final void setSignature(int r100) {
        C(this, getContext().getString(r100));
    }

    public final void setVisible(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L5:
        setVisibility(r101);
        return;
    L4:
        r101 = 8;
        goto L5
    }

    public ProfileSignatureView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void C(ProfileSignatureView r100, String r101) {
        List<TextExtraStruct> r102 = CollectionsKt.emptyList();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "textExtraStructList");
        r100.setOnClickListener(null);
        if ((!TextUtils.equals(r101, r100.f193216d)) == false) goto L6;
        r100.f193214b = false;
        r100.f193216d = r101;
        r100.f193221i = r102;
        r100.setMovementMethod(i.f193246b);
        r100.setText(r100.A(r101, false));
        r100.setTextExtraList(r102);
    L6:
        if (r100.f193213a == true) goto L16;
        int r103 = r100.f193223k;
        if (r103 >= 0) goto L11;
        r100.getClass();
        r100.B();
        return;
    L11:
        if (r100.f193215c == true) goto L15;
        ViewTreeObserver r104 = r100.getViewTreeObserver();
        if (r104 == null) goto L19;
        r104.addOnGlobalLayoutListener(new h(r100, r103));
        return;
    L19:
        return;
    L15:
        r100.B();
        return;
    L16:
        r100.B();
    }

    public static final /* synthetic */ void z(ProfileSignatureView r100, List r101) {
        r100.setTextExtraList(r101);
    }

    public final SpannableStringBuilder A(CharSequence r100, boolean r110) {
        int r101 = 0;
        if (r100 == null) goto L10;
        boolean r102 = true;
        if (r100.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 != true) goto L10;
    L11:
        if (r102 == false) goto L13;
        Context r104 = getContext();
        float r105 = 0.0f;
        if (r104 == null) goto L17;
        Resources r106 = r104.getResources();
        float r107 = TypedValue.applyDimension(2, 14.0f, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()));
    L18:
        com.bytedance.awemeopen.apps.framework.base.view.d r108 = new com.bytedance.awemeopen.apps.framework.base.view.d(r107, ContextCompat.getColor(getContext(), R.color.aos_text_primary), new ProfileSignatureView$buildClickableSpannable$textSpan$1(this));
        Context r109 = getContext();
        if (r109 == null) goto L21;
        Resources r111 = r109.getResources();
        r105 = TypedValue.applyDimension(2, 14.0f, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()));
    L21:
        com.bytedance.awemeopen.apps.framework.base.view.d r112 = new com.bytedance.awemeopen.apps.framework.base.view.d(r105, ContextCompat.getColor(getContext(), R.color.aos_text_tertiary), new ProfileSignatureView$buildClickableSpannable$expandSpan$1(this));
        if ((r100 instanceof SpannableStringBuilder) == false) goto L24;
        SpannableStringBuilder r113 = (SpannableStringBuilder) r100;
    L25:
        if (r113 != null) goto L27;
        r113 = new SpannableStringBuilder(r100);
    L27:
        r113.setSpan(r108, 0, r100.length(), 17);
        if (r110 == false) goto L30;
        r113.append(getMMoreBtnText());
        r113.setSpan(r112, r100.length(), r100.length() + getMMoreBtnText().length(), 17);
    L30:
        Object[] r114 = r113.getSpans(0, r100.length(), c.class);
        int r115 = r114.length;
    L31:
        if (r101 >= r115) goto L33;
        ((c) r114[r101]).updateDrawState(getPaint());
        r101 = r101 + 1;
        goto L31
    L33:
        return r113;
    L24:
        r113 = null;
        goto L25
    L17:
        r107 = 0.0f;
        goto L18
    L13:
        return new SpannableStringBuilder("");
    L7:
        r103 = false;
    L10:
        r102 = false;
        goto L11
    }

    public ProfileSignatureView(Context r100, AttributeSet r101, int r102) {
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f193217e = -1.0f;
        this.f193218f = LazyKt.lazy(new ProfileSignatureView$mMoreBtnText$2(this));
        this.f193222j = 4;
        this.f193223k = 4;
        setHighlightColor(0);
    }
}
