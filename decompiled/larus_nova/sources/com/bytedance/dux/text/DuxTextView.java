package com.bytedance.dux.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.utils.EmojiTextViewHelper;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.d;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u00022\u0019B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0017J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u001f\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/bytedance/dux/text/DuxTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "index", "", "setTextSpec", "Lcom/bytedance/dux/text/DuxTextView$TextSpec;", "spec", "", "size", "setTextSize", "alpha", "setAlpha", "alphaMax", "setAlphaMax", "getLayoutDirection", "getTextDirection", "", "Landroid/text/InputFilter;", "filters", "setFilters", "([Landroid/text/InputFilter;)V", "", "enableParseEmoji", "setEnableParseEmoji", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha", "b", "Z", "getSForceLTR", "()Z", "setSForceLTR", "(Z)V", "sForceLTR", "Lcom/bytedance/dux/utils/EmojiTextViewHelper;", "getEmojiViewHelper", "()Lcom/bytedance/dux/utils/EmojiTextViewHelper;", "emojiViewHelper", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TextSpec", "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer[] f205756d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<TextSpec[]> f205757e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f205758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f205759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EmojiTextViewHelper f205760c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/dux/text/DuxTextView$TextSpec;", "", "", "getTextStyle", "H0", "H1", "H2", "H3", "H4", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "P3", "T1", "T2", "H0S", "H1S", "H2S", "H3S", "H4S", "P1S", "P2S", "P3S", "T1S", "T2S", "dux_release"}, k = 1, mv = {1, 7, 1})
    public static final enum TextSpec extends Enum<TextSpec> {
        public static final TextSpec H0 = null;
        public static final TextSpec H0S = null;
        public static final TextSpec H1 = null;
        public static final TextSpec H1S = null;
        public static final TextSpec H2 = null;
        public static final TextSpec H2S = null;
        public static final TextSpec H3 = null;
        public static final TextSpec H3S = null;
        public static final TextSpec H4 = null;
        public static final TextSpec H4S = null;
        public static final TextSpec P1 = null;
        public static final TextSpec P1S = null;
        public static final TextSpec P2 = null;
        public static final TextSpec P2S = null;
        public static final TextSpec P3 = null;
        public static final TextSpec P3S = null;
        public static final TextSpec T1 = null;
        public static final TextSpec T1S = null;
        public static final TextSpec T2 = null;
        public static final TextSpec T2S = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextSpec[] f205761a = null;

        public static TextSpec valueOf(String r100) {
            return (TextSpec) r27.a.a(TextSpec.class, r100);
        }

        public static TextSpec[] values() {
            return (TextSpec[]) f205761a.clone();
        }

        static {
            TextSpec r100 = new TextSpec("H0", 0);
            H0 = r100;
            TextSpec r101 = new TextSpec("H1", 1);
            H1 = r101;
            TextSpec r102 = new TextSpec("H2", 2);
            H2 = r102;
            TextSpec r103 = new TextSpec("H3", 3);
            H3 = r103;
            TextSpec r104 = new TextSpec("H4", 4);
            H4 = r104;
            TextSpec r105 = new TextSpec(DiagnoseResult.DIAGNOSE_LEVEL_P1, 5);
            P1 = r105;
            TextSpec r110 = new TextSpec(DiagnoseResult.DIAGNOSE_LEVEL_P2, 6);
            P2 = r110;
            TextSpec r111 = new TextSpec("P3", 7);
            P3 = r111;
            TextSpec r112 = new TextSpec("T1", 8);
            T1 = r112;
            TextSpec r113 = new TextSpec("T2", 9);
            T2 = r113;
            TextSpec r114 = new TextSpec("H0S", 10);
            H0S = r114;
            TextSpec r115 = new TextSpec("H1S", 11);
            H1S = r115;
            TextSpec r106 = new TextSpec("H2S", 12);
            H2S = r106;
            TextSpec r107 = new TextSpec("H3S", 13);
            H3S = r107;
            TextSpec r108 = new TextSpec("H4S", 14);
            H4S = r108;
            TextSpec r109 = new TextSpec("P1S", 15);
            P1S = r109;
            TextSpec r116 = new TextSpec("P2S", 16);
            P2S = r116;
            TextSpec r117 = new TextSpec("P3S", 17);
            P3S = r117;
            TextSpec r118 = new TextSpec("T1S", 18);
            T1S = r118;
            TextSpec r119 = new TextSpec("T2S", 19);
            T2S = r119;
            f205761a = new TextSpec[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        }

        public final int getTextStyle() {
            Integer[] r100 = DuxTextView.f205756d;
            return a.a(ordinal());
        }

        public TextSpec(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        public static final int a(int r100) {
            Integer[] r101 = DuxTextView.f205756d;
            if (r100 >= 0) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == true) goto L10;
            return 0;
        L10:
            return DuxTextView.f205756d[r100].intValue();
        L5:
            if (r100 >= 20) goto L7;
            r102 = true;
            goto L8
        }
    }

    public DuxTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        new a();
        f205756d = new Integer[]{Integer.valueOf(R.style.DuxTextView_Spec_H0), Integer.valueOf(R.style.DuxTextView_Spec_H1), Integer.valueOf(R.style.DuxTextView_Spec_H2), Integer.valueOf(R.style.DuxTextView_Spec_H3), Integer.valueOf(R.style.DuxTextView_Spec_H4), Integer.valueOf(R.style.DuxTextView_Spec_P1), Integer.valueOf(R.style.DuxTextView_Spec_P2), Integer.valueOf(R.style.DuxTextView_Spec_P3), Integer.valueOf(R.style.DuxTextView_Spec_T1), Integer.valueOf(R.style.DuxTextView_Spec_T2), Integer.valueOf(R.style.DuxTextView_Spec_H0S), Integer.valueOf(R.style.DuxTextView_Spec_H1S), Integer.valueOf(R.style.DuxTextView_Spec_H2S), Integer.valueOf(R.style.DuxTextView_Spec_H3S), Integer.valueOf(R.style.DuxTextView_Spec_H4S), Integer.valueOf(R.style.DuxTextView_Spec_P1S), Integer.valueOf(R.style.DuxTextView_Spec_P2S), Integer.valueOf(R.style.DuxTextView_Spec_P3S), Integer.valueOf(R.style.DuxTextView_Spec_T1S), Integer.valueOf(R.style.DuxTextView_Spec_T2S)};
        f205757e = LazyKt.lazy(DuxTextView$TextSpecManifest$textSpecEnums$2.INSTANCE);
    }

    private final EmojiTextViewHelper getEmojiViewHelper() {
        EmojiTextViewHelper r100 = this.f205760c;
        if (r100 != null) goto L6;
        EmojiTextViewHelper r101 = new EmojiTextViewHelper(this);
        this.f205760c = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // android.view.View
    public int getLayoutDirection() {
        Lazy<Boolean> r100 = DuxConfig.f204899c;
        if (r100 == null) goto L5;
        boolean r101 = r100.getValue().booleanValue();
    L6:
        if (r101 == false) goto L12;
        if (this.f205759b == false) goto L12;
        return 0;
    L12:
        return super.getLayoutDirection();
    L5:
        r101 = true;
        goto L6
    }

    @Override // android.view.View
    public int getTextDirection() {
        Lazy<Boolean> r100 = DuxConfig.f204899c;
        if (r100 == null) goto L5;
        boolean r101 = r100.getValue().booleanValue();
    L6:
        if (r101 == false) goto L12;
        if (this.f205759b == false) goto L12;
        return 3;
    L12:
        return super.getTextDirection();
    L5:
        r101 = true;
        goto L6
    }

    @Override // android.view.View
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return super.createAccessibilityNodeInfo();
    L4:
        int r100 = d.f473061a;
        d.b("DuxTextView", "createAccessibilityNodeInfo Exception.");
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean hasOverlappingRendering() {
        return super.hasOverlappingRendering();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean performLongClick() {
        return super.performLongClick();
    L4:
        getText();
        return false;
    }

    public final float getMaxAlpha() {
        return this.f205758a;
    }

    public final boolean getSForceLTR() {
        return this.f205759b;
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        float r101 = this.f205758a;
        if (r101 > 0.0f) goto L5;
    L8:
        super.setAlpha(r100);
        return;
    L5:
        if (r100 <= r101) goto L8;
        super.setAlpha(r101);
    }

    public final void setAlphaMax(float r100) {
        this.f205758a = r100;
        float r101 = getAlpha();
        float r102 = this.f205758a;
        if (r101 <= r102) goto L5;
        setAlpha(r102);
    L5:
        Objects.toString(getText());
    }

    public final void setEnableParseEmoji(boolean r100) {
        getEmojiViewHelper().c(r100);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] r100) {
        InputFilter[] r101 = getEmojiViewHelper().b(r100);
        boolean r102 = true;
        if (r101 != null) goto L5;
    L11:
        if (r102 == false) goto L13;
        super.setFilters(r100);
        return;
    L13:
        super.setFilters(r101);
        return;
    L5:
        if (r101.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = false;
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    public final void setMaxAlpha(float r100) {
        this.f205758a = r100;
    }

    public final void setSForceLTR(boolean r100) {
        this.f205759b = r100;
    }

    @Override // android.widget.TextView
    @Deprecated(message = "Text size is not recommended", replaceWith = @ReplaceWith(expression = "setTextSpec()", imports = {}))
    public void setTextSize(float r100) {
        super.setTextSize(r100);
    }

    public final void setTextSpec(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r101 = false;
    L7:
        if (r101 == false) goto L9;
        TextSpec r102 = f205757e.getValue()[r100];
    L10:
        if (r102 == null) goto L13;
        setTextSpec(r102);
        return;
    L13:
        return;
    L9:
        r102 = null;
        goto L10
    L4:
        if (r100 >= f205757e.getValue().length) goto L6;
        r101 = true;
        goto L7
    }

    public final void setTextSpec(TextSpec r100) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        TextViewCompat.setTextAppearance(this, a.a(r100.ordinal()));
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);     // Catch: NullPointerException -> L5
        return;
    L5:
        int r102 = d.f473061a;
        d.b("DuxTextView", "onVisibilityChanged");
    }

    public DuxTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205758a = 1.0f;
        this.f205759b = true;
        if (r101 == null) goto L21;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.forceTextDirectionLTR, R.attr.textSpec}, r102, 0);
        int r104 = r103.getInt(1, -1);
        this.f205759b = r103.getBoolean(0, true);
        r103.recycle();
        if (r104 == (-1)) goto L27;
        int r105 = a.a(r104);
        TypedArray r106 = r100.obtainStyledAttributes(r105, new int[]{android.R.attr.textSize, android.R.attr.typeface, android.R.attr.textStyle, android.R.attr.textColor, android.R.attr.textColorHint, android.R.attr.textColorLink, android.R.attr.shadowColor, android.R.attr.shadowDx, android.R.attr.shadowDy, android.R.attr.shadowRadius, android.R.attr.fontFamily, android.R.attr.textFontWeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.textAllCaps, R.attr.textLocale});
        setTextSize(0, r106.getDimensionPixelSize(0, 0));     // Catch: Throwable -> L18
        r106.recycle();
        TypedArray r107 = r100.obtainStyledAttributes(r105, new int[]{android.R.attr.textAppearance, R.attr.autoSizeMaxTextSize, R.attr.autoSizeMinTextSize, R.attr.autoSizePresetSizes, R.attr.autoSizeStepGranularity, R.attr.autoSizeTextType, R.attr.drawableBottomCompat, R.attr.drawableEndCompat, R.attr.drawableLeftCompat, R.attr.drawableRightCompat, R.attr.drawableStartCompat, R.attr.drawableTint, R.attr.drawableTintMode, R.attr.drawableTopCompat, R.attr.firstBaselineToTopHeight, R.attr.fontFamily, R.attr.fontVariationSettings, R.attr.lastBaselineToBottomHeight, R.attr.lineHeight, R.attr.textAllCaps, R.attr.textLocale});
        setLineHeight(r107.getDimensionPixelSize(18, 0));     // Catch: Throwable -> L11 Exception -> L13
    L15:
        r107.recycle();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r107.recycle();
        throw th;
    L18:
        th = move-exception;
        r106.recycle();
        throw th;
    L27:
        return;
    }

    public /* synthetic */ DuxTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
