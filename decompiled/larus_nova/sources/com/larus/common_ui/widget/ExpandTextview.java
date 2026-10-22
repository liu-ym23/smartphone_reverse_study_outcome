package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusExpandTextViewBinding;
import com.larus.nova.R;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0013J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010$\u001a\u00020%J#\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/larus/common_ui/widget/ExpandTextview;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusExpandTextViewBinding;", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusExpandTextViewBinding;", "expandNow", "", "getExpandNow", "()Z", "setExpandNow", "(Z)V", "getTextLine", "", "content", "", "immerseBgColor", "(Ljava/lang/String;Ljava/lang/Integer;)I", "setContent", "", "tail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "setContentTextColor", "color", "setContentTextAlpha", "alpha", "", "setContentTextMaxLine", GXTemplateKey.STYLE_FONT_LINES, "setExpandTextColor", "getContentView", "Landroid/widget/TextView;", "createStaticLayout", "Landroid/text/Layout;", "(Ljava/lang/String;Ljava/lang/Integer;)Landroid/text/Layout;", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpandTextview extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusExpandTextViewBinding f328432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f328433b;

    public static final class a {
    }

    static {
    }

    public final TextView getContentView() {
        return this.f328432a.f326707b;
    }

    public final LarusExpandTextViewBinding getBinding() {
        return this.f328432a;
    }

    public final boolean getExpandNow() {
        return this.f328433b;
    }

    public ExpandTextview(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setContentTextAlpha(float r100) {
        this.f328432a.f326707b.setAlpha(r100);
    }

    public final void setContentTextColor(int r100) {
        this.f328432a.f326707b.setTextColor(r100);
    }

    public final void setContentTextMaxLine(int r100) {
        this.f328432a.f326707b.setMaxLines(r100);
    }

    public final void setExpandNow(boolean r100) {
        this.f328433b = r100;
    }

    public final void setExpandTextColor(int r100) {
        this.f328432a.f326708c.setTextColor(r100);
    }

    public ExpandTextview(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_expand_text_view, this, false);
        addView(r102);
        int r103 = R.id.content_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.content_text);
        if (r104 == null) goto L9;
        r103 = R.id.expand_text;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r102, R.id.expand_text);
        if (r105 == null) goto L9;
        this.f328432a = new LarusExpandTextViewBinding((ConstraintLayout) r102, r104, r105);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }

    public final void a(String r110, String r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r110, "content");
        if (o0.d(r111) == false) goto L5;
        this.f328432a.f326708c.setText(r111);
    L5:
        AppHost.Companion r100 = AppHost.f326268a;
        Resources r101 = r100.getApplication().getResources();
        if (r112 == null) goto L8;
        int r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).widthPixels - ((r101.getDimensionPixelSize(c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12)) + r101.getDimensionPixelSize(c.b(R.attr.larus_dp_52, null, R.dimen.larus_dp_52))) + r101.getDimensionPixelSize(c.b(R.attr.larus_dp_32, null, R.dimen.larus_dp_32)));
    L9:
        int r113 = r102;
        this.f328432a.f326707b.setMaxWidth(r113);
        Resources r103 = r100.getApplication().getResources();
        if (r112 == null) goto L12;
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels - ((r103.getDimensionPixelSize(c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12)) + r103.getDimensionPixelSize(c.b(R.attr.larus_dp_52, null, R.dimen.larus_dp_52))) + r103.getDimensionPixelSize(c.b(R.attr.larus_dp_32, null, R.dimen.larus_dp_32)));
    L13:
        int r105 = r104;
        if (Build.VERSION.SDK_INT < 23) goto L16;
        StaticLayout r106 = StaticLayout.Builder.obtain(r110, 0, r110.length(), this.f328432a.f326707b.getPaint(), r105).build();
    L17:
        Intrinsics.checkNotNull(r106);
        if (r106 == null) goto L31;
        int r107 = r106.getLineCount();
        int r108 = this.f328432a.f326707b.getMaxLines();
        if (r108 <= 0) goto L22;
        int r109 = r108;
    L23:
        if (r107 <= r109) goto L25;
        String r114 = r110.substring(0, r106.getLineEnd(r108 - 2)) + TextUtils.ellipsize(r110.substring(r106.getLineStart(r108 - 1), r110.length()), this.f328432a.f326707b.getPaint(), r106.getWidth() - this.f328432a.f326708c.getPaint().measureText(r111), TextUtils.TruncateAt.END);
        this.f328433b = true;
        ViewGroup.LayoutParams r115 = this.f328432a.f326706a.getLayoutParams();
        r115.width = r113;
        this.f328432a.f326706a.setLayoutParams(r115);
        this.f328432a.f326708c.setVisibility(0);
    L29:
        this.f328432a.f326707b.setText(r114);
        return;
    L25:
        this.f328432a.f326708c.setVisibility(8);
        if (r112 != null) goto L28;
        this.f328432a.f326707b.setGravity(17);
    L28:
        this.f328433b = false;
        r114 = r110;
        goto L29
    L22:
        r109 = 2;
        goto L23
    L31:
        return;
    L16:
        r106 = new StaticLayout(r110, this.f328432a.f326707b.getPaint(), r105, Layout.Alignment.ALIGN_NORMAL, this.f328432a.f326707b.getLineSpacingMultiplier(), this.f328432a.f326707b.getLineSpacingExtra(), this.f328432a.f326707b.getIncludeFontPadding());
        goto L17
    L12:
        r104 = r103.getDimensionPixelSize(c.b(R.attr.larus_dp_322, null, R.dimen.larus_dp_322));
        goto L13
    L8:
        r102 = r101.getDimensionPixelSize(c.b(R.attr.larus_dp_322, null, R.dimen.larus_dp_322));
        goto L9
    }
}
