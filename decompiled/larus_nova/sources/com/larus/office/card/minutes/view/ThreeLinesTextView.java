package com.larus.office.card.minutes.view;

import android.R;
import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J0\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0007H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/office/card/minutes/view/ThreeLinesTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "originText", "", "updatingInternal", "", "lastBufferType", "Landroid/widget/TextView$BufferType;", "trimPosted", "setText", "", "text", "type", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "scheduleTrimIfNeeded", "tryTrimNow", "trimToLast3LinesIfNeeded", "buildLayout", "Landroid/text/StaticLayout;", "width", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreeLinesTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f361527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f361528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView.BufferType f361529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f361530d;

    public ThreeLinesTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ThreeLinesTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void z() {
        if (this.f361528b == false) goto L6;
        return;
    L6:
        if (getMeasuredWidth() > 0) goto L9;
        return;
    L9:
        if (this.f361530d == false) goto L11;
        return;
    L11:
        this.f361530d = true;
        post(new v(this));
    }

    public static void x(ThreeLinesTextView r100) {
        r100.f361530d = false;
        if (r100.f361528b == true) goto L23;
        CharSequence r101 = r100.f361527a;
        if (r101 == null) goto L24;
        int r102 = (r100.getMeasuredWidth() - r100.getPaddingLeft()) - r100.getPaddingRight();
        if (r102 <= 0) goto L25;
        StaticLayout r103 = r100.y(r101, r102);
        if (r103.getLineCount() <= 3) goto L14;
        CharSequence r104 = r101.subSequence(r103.getLineStart(r103.getLineCount() - 3), r101.length());
        if (Intrinsics.areEqual(r100.getText(), r104) == true) goto L22;
        r100.f361528b = true;
        super.setText(r104, r100.f361529c);
        r100.f361528b = false;
        return;
    L22:
        return;
    L14:
        if (Intrinsics.areEqual(r100.getText(), r101) == true) goto L20;
        r100.f361528b = true;
        super.setText(r101, r100.f361529c);
        r100.f361528b = false;
        return;
    L20:
        return;
    L25:
        return;
    L24:
        return;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        boolean r102 = this.f361528b;
        if (r102 == true) goto L9;
        this.f361527a = r100;
        if (r101 != null) goto L7;
        TextView.BufferType r103 = TextView.BufferType.NORMAL;
    L8:
        this.f361529c = r103;
        goto L9
    L7:
        r103 = r101;
    L9:
        if (r102 == false) goto L13;
        super.setText(r100, r101);
        return;
    L13:
        if (r100 != null) goto L15;
        r100 = "";
    L15:
        int r104 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        if (r104 > 0) goto L18;
        r100 = null;
    L22:
        if (r100 == null) goto L24;
        this.f361528b = true;
        super.setText(r100, r101);
        this.f361528b = false;
        return;
    L24:
        super.setText("", this.f361529c);
        z();
        return;
    L18:
        StaticLayout r105 = y(r100, r104);
        if (r105.getLineCount() <= 3) goto L22;
        r100 = r100.subSequence(r105.getLineStart(r105.getLineCount() - 3), r100.length());
        goto L22
    }

    public final StaticLayout y(CharSequence r110, int r111) {
        Layout.Alignment r100 = Layout.Alignment.ALIGN_NORMAL;
        if (Build.VERSION.SDK_INT < 23) goto L6;
        StaticLayout r112 = StaticLayout.Builder.obtain(r110, 0, r110.length(), getPaint(), r111).setAlignment(r100).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).setIncludePad(getIncludeFontPadding()).setBreakStrategy(getBreakStrategy()).setHyphenationFrequency(getHyphenationFrequency()).build();
        Intrinsics.checkNotNull(r112);
        return r112;
    L6:
        return new StaticLayout(r110, getPaint(), r111, r100, getLineSpacingMultiplier(), getLineSpacingExtra(), getIncludeFontPadding());
    }

    public ThreeLinesTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f361529c = TextView.BufferType.NORMAL;
        setMaxLines(3);
        setEllipsize(null);
    }

    public /* synthetic */ ThreeLinesTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.textViewStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (r100 == false) goto L6;
        z();
        return;
    }
}
