package com.larus.bmhome.music.widget;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/music/widget/AuthorView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fullText", "", "tailText", "setContent", "", "fullContent", "tail", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "adjustContent", "width", "preCalculateLayout", "Landroid/text/StaticLayout;", "Landroid/widget/TextView;", "text", "tvWidth", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthorView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f313154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f313155b;

    public AuthorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public AuthorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f313154a = "";
        this.f313155b = "";
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = (View.MeasureSpec.getSize(r110) - getPaddingStart()) - getPaddingEnd();
        String r101 = this.f313154a;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 23) goto L8;
        StaticLayout.Builder r103 = StaticLayout.Builder.obtain(r101, 0, r101.length(), getPaint(), r100);
        if (r102 < 28) goto L7;
        r103.setUseLineSpacingFromFallbacks(true);
    L7:
        StaticLayout r104 = r103.build();
    L9:
        Intrinsics.checkNotNull(r104);
        if (r104.getLineCount() <= getMaxLines()) goto L19;
        int r105 = getMaxLines() - 1;
        int r106 = r104.getLineStart(r105);
        String r107 = this.f313154a.substring(0, r106);
        CharSequence r108 = TextUtils.ellipsize(this.f313154a.substring(r106), getPaint(), r100 - getPaint().measureText(this.f313155b), TextUtils.TruncateAt.END);
        if (r105 != 0) goto L15;
        String r109 = r107 + r108 + this.f313155b;
    L17:
        if (Intrinsics.areEqual(getText(), r109) == true) goto L19;
        setText(r109);
        goto L19
    L15:
        r109 = r107 + '\n' + r108 + this.f313155b;
    L19:
        super.onMeasure(r110, r111);
        return;
    L8:
        r104 = new StaticLayout(r101, getPaint(), r100, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), getIncludeFontPadding());
        goto L9
    }
}
