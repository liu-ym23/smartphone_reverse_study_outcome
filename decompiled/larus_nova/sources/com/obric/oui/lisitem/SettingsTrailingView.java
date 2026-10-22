package com.obric.oui.lisitem;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/obric/oui/lisitem/SettingsTrailingView;", "Landroid/widget/LinearLayout;", "", "text", "", "setTrailingText", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImage", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "textView", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getIconImageView", "()Landroid/widget/ImageView;", "setIconImageView", "(Landroid/widget/ImageView;)V", "iconImageView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class SettingsTrailingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f401385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f401386b;

    public SettingsTrailingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SettingsTrailingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ImageView getIconImageView() {
        return this.f401386b;
    }

    public final TextView getTextView() {
        return this.f401385a;
    }

    public final void setIconImageView(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401386b = r100;
    }

    public final void setTextView(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f401385a = r100;
    }

    public final void setTrailingImage(Drawable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f401386b.setImageDrawable(r100);
    }

    public final void setTrailingText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f401385a.setText(r100);
    }

    public SettingsTrailingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.o_settings_trailing_view_2, this, false);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-1, -2);
        r104.gravity = 8388629;
        addView(r103, r104);
        this.f401385a = (TextView) findViewById(R.id.trailingText);
        ImageView r105 = (ImageView) findViewById(R.id.trailingImage);
        this.f401386b = r105;
        r105.setImageDrawable(r100.getDrawable(R.drawable.ic_arrow_forward_list_item));
    }

    public /* synthetic */ SettingsTrailingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
