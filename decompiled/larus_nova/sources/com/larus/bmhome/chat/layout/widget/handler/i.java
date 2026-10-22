package com.larus.bmhome.chat.layout.widget.handler;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.deepsearch.DeepSearchLoadingView;
import com.larus.common_ui.widget.roundlayout.RoundImageView;
import com.larus.mainbot.impl.databinding.LarusDeepSearchLoadingBinding;
import com.larus.nova.R;
import com.larus.platform.service.c1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class i implements pw8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f305029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.a f305030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f305031c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.larus.bmhome.chat.layout.widget.handler.h] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // pw8.a
    public final void a(ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        LinearLayout r100 = new LinearLayout(this.f305029a);
        boolean r101 = true;
        r100.setOrientation(1);
        TextView r102 = new TextView(this.f305029a);
        Context r103 = this.f305029a;
        r102.setText(r103.getResources().getString(R.string.larus_search_deepsearch_mindmap));
        r102.setTextSize(20.0f);
        r102.setTextColor(ContextCompat.getColor(r103, v19.c.b(R.attr.larus_neutral_100, r103, R.color.larus_neutral_100)));
        r102.setPadding(i5.Y(), i5.Q(), 0, i5.h());
        r102.setTypeface(Typeface.DEFAULT_BOLD);
        r100.addView(r102);
        if (Intrinsics.areEqual(this.f305030b.c(), Boolean.TRUE) == false) goto L9;
        final DeepSearchLoadingView r104 = new DeepSearchLoadingView(this.f305029a, null);
        final LarusDeepSearchLoadingBinding r105 = r104.f302623a;
        r105.f358569c.cancelAnimation();
        LottieAdapterView r106 = r105.f358569c;
        Intrinsics.checkNotNull(r106);
        e1.x(r106);
        r106.setRepeatCount(-1);
        r106.setRepeatMode(1);
        boolean r111 = v19.h.f552477a;
        if (v19.h.b(r106.getContext()) == false) goto L7;
        String r112 = "lottie/sparkle_dark.json";
    L8:
        r106.setAnimation(r112);
        r106.playAnimation();
        final RoundImageView r113 = r105.f358568b;
        final int r114 = r113.getResources().getColor(v19.c.b(R.attr.larus_base_2_overlay, null, R.color.larus_base_2_overlay));
        final int r115 = r113.getResources().getColor(v19.c.b(R.attr.larus_neutral_transparent_1, null, R.color.larus_neutral_transparent_1));
        final Ref.BooleanRef r116 = new Ref.BooleanRef();
        r116.element = true;
        final ValueAnimator r107 = ValueAnimator.ofArgb(new int[]{r114, r115});
        r107.setDuration(1000);
        r107.setRepeatCount(-1);
        r107.addUpdateListener(new com.larus.bmhome.chat.deepsearch.h(r113, r116, r115, r114, r107, r104, r105));
        r107.start();
        r100.addView(r104);
    L18:
        r110.addView(r100);
        return;
    L7:
        r112 = "lottie/sparkle_light.json";
        goto L8
    L9:
        FrameLayout r108 = new FrameLayout(this.f305029a);
        r108.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        if ((this.f305029a.getResources().getConfiguration().uiMode & 48) == 32) goto L13;
        r101 = false;
    L13:
        Uri.Builder r109 = UriProtector.parse(this.f305030b.b()).buildUpon();
        if (r101 == false) goto L16;
        String r117 = "dark";
    L17:
        final Uri r118 = r109.appendQueryParameter("appTheme", r117).appendQueryParameter("mindmapMarkdown", this.f305030b.a()).build();
        FLogger.f375446a.d(this.f305031c.f305022b, "[biz_deep_search] finalUrl = " + r118 + "...");
        ImageView r119 = new ImageView(this.f305029a);
        Context r120 = this.f305029a;
        r119.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (((double) m0.b(r120)) * 0.75d)));
        r119.setBackground(ContextCompat.getDrawable(r120, v19.c.b(R.attr.larus_bg_rounded_rect_with_border, r120, R.drawable.larus_bg_rounded_rect_with_border)));
        r119.setOnClickListener(new g(r118));
        c1 r121 = c1.f365723a;
        Context r122 = this.f305029a;
        String r123 = r118.toString();
        final f r124 = this.f305031c;
        r108.addView(r121.c(r122, r123, new h(r124)));
        r108.addView(r119);
        r100.addView(r108);
        goto L18
    L16:
        r117 = "light";
        goto L17
    }

    @Override // pw8.a
    public final void b(int r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r101, "currentViewGroup");
    }

    public i(Context r100, f.a r101, f r102) {
        this.f305029a = r100;
        this.f305030b = r101;
        this.f305031c = r102;
    }
}
