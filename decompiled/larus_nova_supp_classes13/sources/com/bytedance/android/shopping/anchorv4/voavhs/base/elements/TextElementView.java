package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.Highlight;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.base.LinkAction;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u000eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R(\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextElementView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/ActionHubAccessor;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/e;", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "textElement", "", "setTextWithHighlight", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "hub", "setActionHub", "", "getViewTag", "<set-?>", "a", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getDescriptionVO", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "descriptionVO", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextElementView extends AppCompatTextView implements ActionHubAccessor, com.bytedance.android.shopping.anchorv4.voavhs.base.design.e {
    public TextElement a;
    public com.bytedance.android.shopping.anchorv4.voavhs.base.design.a b;
    public String c;

    public static final class a {
    }

    static {
    }

    public TextElementView(Context r7) {
        this(r7, null, 0, null, 30);
    }

    public TextElementView(Context r7, AttributeSet r8) {
        this(r7, r8, 0, null, 28);
    }

    public TextElementView(Context r7, AttributeSet r8, int r9) {
        this(r7, r8, r9, null, 24);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Action associatedAction() {
        TextElement r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAction();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.e
    public String getViewTag() {
        TextElement r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTag();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.design.a actionHub() {
        return this.b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final Object descriptionVO() {
        return this.a;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final void dispatchPossibleShow() {
        ActionHubAccessor.DefaultImpls.b(this);
    }

    public final TextElement getDescriptionVO() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setTextWithHighlight(TextElement r11) {
        List r0 = r11.getHighlights();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L41;
        setText(r11.getText());
        return;
    L41:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L35
        SpannableString r3 = new SpannableString(r11.getText());     // Catch: Throwable -> L35
        Iterator r4 = r11.getHighlights().iterator();     // Catch: Throwable -> L35
    L13:
        if (r4.hasNext() == false) goto L33;
        Highlight r5 = (Highlight) r4.next();     // Catch: Throwable -> L35
        FontStyle r6 = r5.getHighlightStyle();     // Catch: Throwable -> L35
        if (r6 == null) goto L13;
        ForegroundColorSpan r7 = new ForegroundColorSpan(com.bytedance.android.shopping.extensions.a.a(r6.getTextColor(), 0));     // Catch: Throwable -> L35
        Integer r8 = r5.getStart();     // Catch: Throwable -> L35
        if (r8 == null) goto L19;
        int r9 = r8.intValue();     // Catch: Throwable -> L35
    L20:
        Integer r10 = r5.getEnd();     // Catch: Throwable -> L35
        if (r10 == null) goto L23;
        int r12 = r10.intValue();     // Catch: Throwable -> L35
    L24:
        r3.setSpan(r7, r9, r12 + 1, 18);     // Catch: Throwable -> L35
        AbsoluteSizeSpan r13 = new AbsoluteSizeSpan(com.bytedance.android.shopping.extensions.b.b(Float.valueOf(r6.getFontSize())));     // Catch: Throwable -> L35
        Integer r14 = r5.getStart();     // Catch: Throwable -> L35
        if (r14 == null) goto L27;
        int r15 = r14.intValue();     // Catch: Throwable -> L35
    L28:
        Integer r16 = r5.getEnd();     // Catch: Throwable -> L35
        if (r16 == null) goto L31;
        int r17 = r16.intValue();     // Catch: Throwable -> L35
    L32:
        r3.setSpan(r13, r15, r17 + 1, 18);     // Catch: Throwable -> L35
        goto L13
    L31:
        r17 = 0;
        goto L32
    L27:
        r15 = 0;
        goto L28
    L23:
        r12 = 0;
        goto L24
    L19:
        r9 = 0;
        goto L20
    L33:
        setText(r3);     // Catch: Throwable -> L35
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L38:
        if (Result.exceptionOrNull-impl(r18) == null) goto L49;
        setText(r11.getText());
        return;
    L49:
        return;
    L35:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public final String getOnLimitClickBindKey(Action r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return ActionHubAccessor.DefaultImpls.c(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        r3.save();
        TextElement r0 = this.a;
        if (r0 == null) goto L9;
        FontStyle r1 = r0.getFontStyle();
        if (r1 == null) goto L9;
        Float r2 = r1.getVerticalOffSet();
        if (r2 == null) goto L9;
        float r4 = r2.floatValue();
    L10:
        r3.translate(0.0f, r4);
        super/*android.widget.TextView*/.onDraw(r3);
        r3.restore();
        return;
    L9:
        r4 = 0.0f;
        goto L10
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.ActionHubAccessor
    public void setActionHub(com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r2) {
        Intrinsics.checkNotNullParameter(r2, "hub");
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(TextElement r12) {
        this.a = r12;
        if (r12 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        setText(r12.getText());
        int r0 = r12.getTextGravity();
        if (r0 == 0) goto L13;
        if (r0 == 1) goto L12;
        if (r0 != 2) goto L13;
        int r1 = 8388629;
    L14:
        setGravity(r1);
        FontStyle r2 = r12.getFontStyle();
        if (r2 == null) goto L101;
        Integer r3 = r2.getFontUnit();
        if (r3 != null) goto L20;
    L22:
        setTextSize(1, r2.getFontSize());
    L24:
        if (r2.getLine() < 1) goto L26;
        int r4 = r2.getLine();
    L27:
        setMaxLines(r4);
        String r5 = r12.getTruncate();
        int r6 = r5.hashCode();
        if (r6 == (-1074341483)) goto L36;
        if (r6 == 3198432) goto L33;
    L38:
        TextUtils.TruncateAt r7 = TextUtils.TruncateAt.END;
    L39:
        setEllipsize(r7);
        int r8 = 0;
        setTextColor(com.bytedance.android.shopping.extensions.a.a(r2.getTextColor(), 0));
        String r9 = this.c;
        if (r9 != null) goto L42;
    L89:
        if (r8 != 0) goto L101;
        if (r2.getFontWeight() < 500) goto L93;
        setTypeface(getTypeface(), 1);
    L93:
        String r10 = r2.getFontEnum();
        if (r10 == null) goto L101;
        if (r10.hashCode() != 51) goto L101;
        if (r10.equals("3") == false) goto L101;
        setTypeface(getTypeface(), 3);
        goto L101
    L42:
        if (r9.hashCode() == (-1431958525)) goto L45;
    L47:
        Typeface r11 = ECFontHelper.e.b(r9, r2.getFontWeight(), false);
    L48:
        ViewGroup.LayoutParams r13 = null;
        if (r2.getFontWeight() < 500) goto L51;
        Integer r14 = 1;
    L53:
        if (Intrinsics.areEqual(r2.getFontEnum(), "3") == false) goto L55;
        r14 = 3;
    L55:
        if (r11 == null) goto L60;
        if (r14 != null) goto L58;
        setTypeface(r11);
    L59:
        int r15 = 1;
    L61:
        FontStyle r16 = r12.getFontStyle();
        if (r16 == null) goto L88;
        f73.b r17 = r16.getMargin();
        if (r17 == null) goto L88;
        ViewGroup.LayoutParams r18 = getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L69;
        r13 = r18;
    L69:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r13;
        if (r19 != null) goto L72;
        r19 = new ViewGroup.MarginLayoutParams(-2, -2);
    L72:
        Float r20 = r17.b();
        if (r20 == null) goto L75;
        int r21 = com.bytedance.android.shopping.extensions.b.b(r20);
    L76:
        r19.leftMargin = r21;
        Float r22 = r17.c();
        if (r22 == null) goto L79;
        int r23 = com.bytedance.android.shopping.extensions.b.b(r22);
    L80:
        r19.rightMargin = r23;
        Float r24 = r17.d();
        if (r24 == null) goto L83;
        int r25 = com.bytedance.android.shopping.extensions.b.b(r24);
    L84:
        r19.topMargin = r25;
        Float r26 = r17.a();
        if (r26 == null) goto L87;
        r8 = com.bytedance.android.shopping.extensions.b.b(r26);
    L87:
        r19.bottomMargin = r8;
        Unit r27 = Unit.INSTANCE;
        setLayoutParams(r19);
        goto L88
    L83:
        r25 = 0;
        goto L84
    L79:
        r23 = 0;
        goto L80
    L75:
        r21 = 0;
    L88:
        r8 = r15;
        goto L89
    L58:
        setTypeface(r11, r14.intValue());
        goto L59
    L60:
        r15 = 0;
        goto L61
    L51:
        r14 = null;
        goto L53
    L45:
        if (r9.equals("monospace") == false) goto L47;
        r11 = Typeface.MONOSPACE;
        goto L48
    L33:
        if (r5.equals("head") == false) goto L38;
        r7 = TextUtils.TruncateAt.START;
        goto L39
    L36:
        if (r5.equals("middle") == false) goto L38;
        r7 = TextUtils.TruncateAt.MIDDLE;
        goto L39
    L26:
        r4 = Integer.MAX_VALUE;
        goto L27
    L20:
        if (r3.intValue() != 0) goto L22;
        setTextSize(2, r2.getFontSize());
    L101:
        Link r28 = r12.getLink();
        if (r28 != null) goto L104;
    L106:
        setTextWithHighlight(r12);
        Action r110 = r12.getAction();
        Intrinsics.checkNotNullParameter(this, "theView");
        ActionHubAccessor.DefaultImpls.a(this, this, r110);
        return;
    L104:
        if (Intrinsics.areEqual(r28.getAction(), LinkAction.ACTION_SCHEMA.getAction()) == false) goto L106;
        setOnClickListener(new e(r28, this));
        goto L106
    L12:
        r1 = 17;
    L13:
        r1 = 16;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextElementView(Context r4, AttributeSet r5, int r6, String r7, int r8) {
        if ((r8 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r8 & 4) == 0) goto L9;
        r6 = 0;
    L9:
        if ((r8 & 16) == 0) goto L11;
        r7 = null;
    L11:
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.b = null;
        this.c = r7;
        setIncludeFontPadding(false);
        setGravity(16);
    }
}
