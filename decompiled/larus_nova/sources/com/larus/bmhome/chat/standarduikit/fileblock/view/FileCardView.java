package com.larus.bmhome.chat.standarduikit.fileblock.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.mainbot.impl.databinding.LarusBlockItemFileBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.lynx.textra.PlatformFontCaps;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;
import yk8.b;
import yk8.c;
import yk8.d;
import yk8.e;
import yk8.g;
import zk8.v;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u001fB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileblock/view/FileCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/fileblock/view/FileCardViewInput;", "Lcom/larus/bmhome/chat/standarduikit/fileblock/view/FileCardViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "boundUrl", "", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemFileBinding;", "getBinding", "()Lcom/larus/mainbot/impl/databinding/LarusBlockItemFileBinding;", "binding$delegate", "Lkotlin/Lazy;", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "bindFileIcon", "bindCardStyle", "updateIconLayout", "sizeDp", "", "updateTextLayout", "startMarginDp", "verticalMarginDp", "updateSubtitleTopMargin", "topMarginDp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileCardView extends ConstraintLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f309074c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f309075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f309076b;

    public static final class a {
    }

    static {
    }

    private final LarusBlockItemFileBinding getBinding() {
        return (LarusBlockItemFileBinding) this.f309076b.getValue();
    }

    public FileCardView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f309075a = "";
        this.f309076b = LazyKt.lazy(new yk8.a(r100, this));
        setBackgroundResource(R.drawable.larus_bg_gaokao_8_radius);
    }

    public final void T5(int r100) {
        ViewGroup.LayoutParams r101 = getBinding().f358450g.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        ((ViewGroup.MarginLayoutParams) r102).width = c7.b(Integer.valueOf(r100));
        ((ViewGroup.MarginLayoutParams) r102).height = c7.b(Integer.valueOf(r100));
        ((ViewGroup.MarginLayoutParams) r102).topMargin = c7.b(16);
        ((ViewGroup.MarginLayoutParams) r102).bottomMargin = c7.b(16);
        getBinding().f358450g.setLayoutParams(r102);
    }

    public final void U5(int r100) {
        ViewGroup.LayoutParams r101 = getBinding().f358452i.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r102 = (LinearLayout.LayoutParams) r101;
        r102.topMargin = c7.b(Integer.valueOf(r100));
        getBinding().f358452i.setLayoutParams(r102);
    }

    public final void S5(final g r110, final v r111) {
        Intrinsics.checkNotNullParameter(r110, "input");
        Intrinsics.checkNotNullParameter(r111, BdpAppEventConstant.PARAMS_OUTPUT);
        this.f309075a = r110.f568262i;
        int r100 = 2;
        boolean r101 = true;
        int r102 = 0;
        if (r110.f568260g == false) goto L5;
        setBackgroundResource(R.drawable.larus_bg_file_card_action);
        setMinimumHeight(c7.b(72));
        T5(32);
        V5(12, 0);
        TextView r103 = getBinding().f358451h;
        r103.setIncludeFontPadding(false);
        r103.setTypeface(Typeface.create("sans-serif-medium", 0));
        r103.setTextSize(2, 14.0f);
        r103.setLineSpacing(0.0f, 1.0f);
        TextViewCompat.setLineHeight(r103, c7.b(20));
        TextView r104 = getBinding().f358452i;
        r104.setIncludeFontPadding(false);
        r104.setTypeface(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0));
        r104.setTextSize(2, 12.0f);
        r104.setLineSpacing(0.0f, 1.0f);
        TextViewCompat.setLineHeight(r104, c7.b(18));
        U5(2);
    L10:
        AppCompatImageView r105 = getBinding().f358450g;
        Integer r106 = r110.f568254a;
        if (r106 == null) goto L13;
        int r107 = r106.intValue();
    L14:
        r105.setImageResource(r107);
        getBinding().f358451h.setText(r110.f568256c);
        boolean r108 = r110.f568260g;
        if (r108 == false) goto L17;
        String r109 = r110.f568259f;
    L18:
        if (r108 == false) goto L23;
        if (r110.f568259f.length() > 0) goto L29;
    L30:
        boolean r112 = false;
    L31:
        TextView r113 = getBinding().f358451h;
        if (r110.f568260g == false) goto L35;
        r100 = 1;
    L38:
        r113.setMaxLines(r100);
        TextView r114 = getBinding().f358451h;
        if (r110.f568260g == false) goto L41;
    L44:
        TextUtils.TruncateAt r115 = TextUtils.TruncateAt.END;
    L45:
        r114.setEllipsize(r115);
        getBinding().f358452i.setText(r109);
        TextView r116 = getBinding().f358452i;
        int r117 = 8;
        if (r112 == false) goto L48;
        int r118 = 0;
    L49:
        r116.setVisibility(r118);
        LinearLayout r119 = getBinding().f358445b;
        if (r110.f568261h == false) goto L52;
    L55:
        if (r101 == false) goto L57;
        int r120 = 0;
    L58:
        r119.setVisibility(r120);
        FileAudioButtonView r121 = getBinding().f358449f;
        if (r110.f568261h == false) goto L61;
        int r122 = 0;
    L62:
        r121.setVisibility(r122);
        getBinding().f358449f.c(r110.f568263j);
        ImageView r123 = getBinding().f358447d;
        if (r110.f568260g == false) goto L65;
        int r124 = 0;
    L66:
        r123.setVisibility(r124);
        ImageView r125 = getBinding().f358448e;
        if (r110.f568260g == false) goto L69;
        r117 = 0;
    L69:
        r125.setVisibility(r117);
        ViewGroup.LayoutParams r126 = getBinding().f358447d.getLayoutParams();
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r127 = (LinearLayout.LayoutParams) r126;
        if (r110.f568261h == true) goto L72;
    L74:
        r127.setMarginStart(r102);
        getBinding().f358447d.setLayoutParams(r127);
        e1.d(getBinding().f358449f, new b(r110, r111, this));
        e1.d(getBinding().f358447d, new c(r111));
        e1.d(getBinding().f358448e, new d(r111));
        e1.d(getBinding().f358444a, new e(r111));
        return;
    L72:
        if (r110.f568260g == false) goto L74;
        r102 = c7.b(12);
        goto L74
    L65:
        r124 = 8;
        goto L66
    L61:
        r122 = 8;
        goto L62
    L57:
        r120 = 8;
        goto L58
    L52:
        if (r110.f568260g == true) goto L55;
        r101 = false;
        goto L55
    L48:
        r118 = 8;
        goto L49
    L41:
        if (r110.f568258e == true) goto L44;
        r115 = null;
        goto L45
    L35:
        if (r110.f568258e == true) goto L38;
        r100 = Integer.MAX_VALUE;
    L29:
        r112 = true;
        goto L31
    L23:
        if (r110.f568258e == false) goto L30;
        if (r110.f568257d.length() <= 0) goto L27;
        boolean r128 = true;
    L28:
        if (r128 == false) goto L30;
    L27:
        r128 = false;
        goto L28
    L17:
        r109 = r110.f568257d;
        goto L18
    L13:
        r107 = r110.f568255b;
        goto L14
    L5:
        Integer r129 = r110.f568264k;
        if (r129 == null) goto L8;
        int r130 = r129.intValue();
    L9:
        setBackgroundResource(r130);
        setMinimumHeight(0);
        T5(24);
        V5(16, 16);
        TextView r131 = getBinding().f358451h;
        r131.setIncludeFontPadding(true);
        r131.setTypeface(Typeface.create("PingFang SC", 0));
        r131.setTextSize(0, i5.q());
        r131.setLineSpacing(0.0f, 1.0f);
        TextView r132 = getBinding().f358452i;
        r132.setIncludeFontPadding(true);
        r132.setTypeface(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0));
        r132.setTextSize(0, i5.m());
        r132.setLineSpacing(0.0f, 1.0f);
        U5(4);
        goto L10
    L8:
        r130 = R.drawable.larus_bg_gaokao_8_radius;
        goto L9
    }

    public final void V5(int r100, int r101) {
        ViewGroup.LayoutParams r102 = getBinding().f358446c.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        r103.setMarginStart(c7.b(Integer.valueOf(r100)));
        ((ViewGroup.MarginLayoutParams) r103).topMargin = c7.b(Integer.valueOf(r101));
        ((ViewGroup.MarginLayoutParams) r103).bottomMargin = c7.b(Integer.valueOf(r101));
        getBinding().f358446c.setLayoutParams(r103);
    }

    public static Unit R5(FileCardView r100, String r101, vl8.g r102) {
        Intrinsics.checkNotNullParameter(r102, "state");
        if (Intrinsics.areEqual(r100.f309075a, r101) == false) goto L6;
        r100.getBinding().f358449f.c(r102);
    L6:
        return Unit.INSTANCE;
    }
}
