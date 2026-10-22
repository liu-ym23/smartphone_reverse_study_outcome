package com.larus.av_call.view;

import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusButtonSceneModeBinding;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010J\u001a\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0014\u0010\u001c\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001eJ \u0010\u001f\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/av_call/view/SceneModeButton;", "Landroid/widget/LinearLayout;", "Lcom/larus/av_call/view/IRealCallDayNight;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/av_call/databinding/LarusButtonSceneModeBinding;", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "forceDarkMode", "", "configDependency", "Lcom/larus/av_call/service/IRealtimeCallConfigDependency;", "initView", "", "subtitleUseCC", "enableAudioBgSimpleColor", "updateButton", "scene", "Lcom/larus/av_call/model/CallSceneDisplayModel;", "springSceneTitle", "", "setExitListener", "listener", "Lkotlin/Function0;", "refreshThemeDayNight", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SceneModeButton extends LinearLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f290578e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusButtonSceneModeBinding f290579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThemeType f290580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f290581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IRealtimeCallConfigDependency f290582d;

    public SceneModeButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SceneModeButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(boolean r100) {
        this.f290581c = r100;
        Application r101 = i88.e.f488685a;
        ThemeType r102 = this.f290580b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r102, "themeType");
        if (r100 == false) goto L5;
    L16:
        int r103 = R.drawable.larus_bg_choose_scene_dark_v2;
    L17:
        setBackground(ContextCompat.getDrawable(i88.e.f488685a, r103));
        LarusButtonSceneModeBinding r104 = this.f290579a;
        ThemeType r105 = this.f290580b;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r105, "themeType");
        i88.e.h(r104.f290507d, r105, r100);
        if (r100 == false) goto L20;
    L23:
        r104.f290508e.setIndeterminateTintList(ColorStateList.valueOf(com.larus.utils.j0.a(R.color.larus_static_white)));
        AppCompatTextView r106 = r104.f290509f;
        int r107 = com.larus.utils.j0.f375426a;
        r106.setTextColor(com.larus.utils.j0.a(R.color.larus_static_white));
        r104.f290505b.setBackgroundColor(com.larus.utils.j0.a(R.color.static_white_transparent_2));
        r104.f290506c.setImageResource(R.drawable.larus_ic_scene_exit_dark);
        return;
    L20:
        if (i88.e.o(r105) == true) goto L23;
        r104.f290508e.setIndeterminateTintList(ColorStateList.valueOf(com.larus.utils.j0.a(R.color.larus_static_black)));
        AppCompatTextView r108 = r104.f290509f;
        int r109 = com.larus.utils.j0.f375426a;
        r108.setTextColor(com.larus.utils.j0.a(R.color.larus_static_black));
        r104.f290505b.setBackgroundColor(com.larus.utils.j0.a(R.color.larus_static_black_transparent_1));
        r104.f290506c.setImageDrawable(com.larus.utils.j0.f(R.drawable.larus_ic_scene_exit_dark, ColorProtector.parseColor("#CC000000")));
        return;
    L5:
        if (i88.e.o(r102) == true) goto L16;
        IRealtimeCallConfigDependency r110 = i88.e.f488686b;
        if (r110 == null) goto L12;
        boolean r111 = true;
        if (r110.r() != true) goto L12;
    L13:
        if (r111 == false) goto L15;
        r103 = R.drawable.larus_bg_choose_scene_white_bg;
        goto L17
    L15:
        r103 = v19.c.b(R.attr.larus_bg_choose_scene_v2, null, R.drawable.larus_bg_choose_scene_v2);
    L12:
        r111 = false;
        goto L13
    }

    public final void setExitListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.d(this.f290579a.f290506c, new i(r100));
    }

    public final void b(h88.c r100, String r101) {
        LarusButtonSceneModeBinding r102 = this.f290579a;
        if (r100 != null) goto L10;
        com.larus.utils.e1.x(r102.f290507d);
        com.larus.utils.e1.o(r102.f290508e);
        com.larus.utils.e1.o(r102.f290505b);
        com.larus.utils.e1.o(r102.f290506c);
        Application r103 = i88.e.f488685a;
        i88.e.h(r102.f290507d, this.f290580b, this.f290581c);
        AppCompatTextView r104 = r102.f290509f;
        if (r101 != null) goto L8;
        r101 = getContext().getString(R.string.larus_voice_call_select_theme_btn);
    L8:
        r104.setText(r101);
        return;
    L10:
        if (r100.f484287f == false) goto L12;
        com.larus.utils.e1.o(r102.f290505b);
        com.larus.utils.e1.o(r102.f290506c);
    L13:
        r102.f290504a.setEnabled(!r100.f484288g);
        if (r100.f484282a == false) goto L16;
        com.larus.utils.e1.o(r102.f290507d);
        com.larus.utils.e1.x(r102.f290508e);
    L17:
        r102.f290509f.setText(r100.f484285d);
        return;
    L16:
        com.larus.utils.e1.x(r102.f290507d);
        com.larus.utils.e1.o(r102.f290508e);
        Application r105 = i88.e.f488685a;
        SimpleDraweeView r106 = r102.f290507d;
        ThemeType r107 = this.f290580b;
        String r108 = r100.f484283b;
        Boolean r109 = r100.f484284c;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        Intrinsics.checkNotNullParameter(r107, "themeType");
        ImageLoaderKt.y(r106, r108, "scene_item", new i88.c(r109, r107), 4);
        goto L17
    L12:
        com.larus.utils.e1.x(r102.f290505b);
        com.larus.utils.e1.x(r102.f290506c);
        goto L13
    }

    public SceneModeButton(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        LayoutInflater.from(r100).inflate(R.layout.larus_button_scene_mode, this);
        int r102 = R.id.exit_divider;
        View r103 = ViewBindings.findChildViewById(this, R.id.exit_divider);
        if (r103 == null) goto L15;
        r102 = R.id.exit_icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.exit_icon);
        if (r104 == null) goto L15;
        r102 = R.id.scene_icon;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.scene_icon);
        if (r105 == null) goto L15;
        r102 = R.id.scene_loading;
        ProgressBar r106 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.scene_loading);
        if (r106 == null) goto L15;
        r102 = R.id.scene_text;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.scene_text);
        if (r107 == null) goto L15;
        this.f290579a = new LarusButtonSceneModeBinding(this, r103, r104, r105, r106, r107);
        this.f290580b = ThemeType.DEFAULT;
        this.f290582d = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        setOrientation(0);
        setVisibility(8);
        setGravity(16);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public /* synthetic */ SceneModeButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
