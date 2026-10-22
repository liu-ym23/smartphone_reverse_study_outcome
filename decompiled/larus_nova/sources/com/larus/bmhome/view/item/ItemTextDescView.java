package com.larus.bmhome.view.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001a¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextDescView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "descView", "getDescView", "init", "", "value", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "setTextColor", "color", "descText", "getDescText", "setDescText", "setEnabled", "enabled", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTextDescView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f316968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f316969b;

    public final CharSequence getDescText() {
        return this.f316969b.getText();
    }

    public final CharSequence getText() {
        return this.f316968a.getText();
    }

    public final TextView getDescView() {
        return this.f316969b;
    }

    public final TextView getTextView() {
        return this.f316968a;
    }

    public ItemTextDescView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        TextView r101 = new TextView(getContext());
        r101.setId(R.id.view_id_text);
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), c.b(R.attr.larus_neutral_100, r101.getContext(), R.color.larus_neutral_100)));
        r101.setTextSize(0, i5.t());
        r101.setGravity(16);
        this.f316968a = r101;
        TextView r102 = new TextView(getContext());
        r102.setId(R.id.view_id_desc);
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), c.b(R.attr.larus_neutral_70, r102.getContext(), R.color.larus_neutral_70)));
        r102.setTextSize(0, i5.t());
        r102.setGravity(8388629);
        this.f316969b = r102;
        R5(r100, null);
    }

    public final void setDescText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f316969b.setText(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        if (r100 == false) goto L4;
        float r101 = 1.0f;
    L5:
        setAlpha(r101);
        super.setEnabled(r100);
        return;
    L4:
        r101 = 0.3f;
        goto L5
    }

    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f316968a.setText(r100);
    }

    public final void setTextColor(int r100) {
        this.f316968a.setTextColor(r100);
    }

    public ItemTextDescView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        TextView r102 = new TextView(getContext());
        r102.setId(R.id.view_id_text);
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), c.b(R.attr.larus_neutral_100, r102.getContext(), R.color.larus_neutral_100)));
        r102.setTextSize(0, i5.t());
        r102.setGravity(16);
        this.f316968a = r102;
        TextView r103 = new TextView(getContext());
        r103.setId(R.id.view_id_desc);
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), c.b(R.attr.larus_neutral_70, r103.getContext(), R.color.larus_neutral_70)));
        r103.setTextSize(0, i5.t());
        r103.setGravity(8388629);
        this.f316969b = r103;
        R5(r100, r101);
    }

    public final void R5(Context r100, AttributeSet r101) {
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.textColor, android.R.attr.text, android.R.attr.textFontWeight, R.attr.larus_describe_text});
        View r103 = this.f316968a;
        ConstraintLayout.LayoutParams r104 = new ConstraintLayout.LayoutParams(-2, -2);
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        r104.startToStart = 0;
        Unit r105 = Unit.INSTANCE;
        addView(r103, r104);
        TextView r106 = this.f316968a;
        String r107 = r102.getString(1);
        String r108 = "";
        if (r107 != null) goto L5;
        r107 = "";
    L5:
        r106.setText(r107);
        this.f316968a.setTextColor(r102.getColor(0, ContextCompat.getColor(r100, c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100))));
        if (Build.VERSION.SDK_INT < 28) goto L8;
        this.f316968a.setTypeface(Typeface.create(this.f316968a.getTypeface(), r102.getInteger(2, 400), this.f316968a.getTypeface().isItalic()));
    L8:
        this.f316968a.setMaxLines(1);
        this.f316968a.setEllipsize(TextUtils.TruncateAt.END);
        View r109 = this.f316969b;
        ConstraintLayout.LayoutParams r110 = new ConstraintLayout.LayoutParams(0, -2);
        r110.topToTop = 0;
        r110.bottomToBottom = 0;
        r110.startToEnd = this.f316968a.getId();
        r110.endToEnd = 0;
        r110.setMarginStart(i5.q());
        addView(r109, r110);
        TextView r111 = this.f316969b;
        String r112 = r102.getString(3);
        if (r112 == null) goto L12;
        r108 = r112;
    L12:
        r111.setText(r108);
        this.f316969b.setMaxLines(1);
        this.f316969b.setEllipsize(TextUtils.TruncateAt.END);
        int r113 = r102.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        int r114 = getPaddingTop();
        int r115 = getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r113 + ",top:" + r114 + ",end:" + r113 + ",bottom:" + r115);
        setPaddingRelative(r113, r114, r113, r115);
        setMinHeight(i5.h0());
        r102.recycle();
    }

    public ItemTextDescView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        TextView r103 = new TextView(getContext());
        r103.setId(R.id.view_id_text);
        r103.setTextColor(ContextCompat.getColor(r103.getContext(), c.b(R.attr.larus_neutral_100, r103.getContext(), R.color.larus_neutral_100)));
        r103.setTextSize(0, i5.t());
        r103.setGravity(16);
        this.f316968a = r103;
        TextView r104 = new TextView(getContext());
        r104.setId(R.id.view_id_desc);
        r104.setTextColor(ContextCompat.getColor(r104.getContext(), c.b(R.attr.larus_neutral_70, r104.getContext(), R.color.larus_neutral_70)));
        r104.setTextSize(0, i5.t());
        r104.setGravity(8388629);
        this.f316969b = r104;
        R5(r100, r101);
    }
}
