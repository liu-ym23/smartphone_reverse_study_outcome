package com.obric.miniapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.model.objects.Applet;
import com.larus.nova.R;
import com.obric.miniapp.databinding.MiniAppActionBarBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0014\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0017\u001a\u00020\u000eJ\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/miniapp/view/MiniAppActionBar;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "applet", "Lcom/bytedance/ai/model/objects/Applet;", "binding", "Lcom/obric/miniapp/databinding/MiniAppActionBarBinding;", "onCloseListener", "Lkotlin/Function0;", "", "onRefreshListener", "updateBackground", "isDark", "", "setApplet", "setOnCloseListener", "listener", "setOnRefreshListener", "release", "initActionBarInLightMode", "initActionBarInDarkMode", "showMiniAppMenu", "getItemDataList", "", "Lcom/obric/miniapp/view/actionsheet/ActionSheetItemData;", "navigateToMiniAppOwnSettingsPage", "targetApplet", "onMiniAppShortcutClick", "navigateToMiniAppSystemSettingsPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppActionBar extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f398570e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Applet f398571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MiniAppActionBarBinding f398572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f398573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f398574d;

    public static final class a {
    }

    static {
    }

    public final void setApplet(Applet r100) {
        Intrinsics.checkNotNullParameter(r100, "applet");
        this.f398571a = r100;
    }

    public final void setOnCloseListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f398573c = r100;
    }

    public final void setOnRefreshListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f398574d = r100;
    }

    public MiniAppActionBar(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        View r112 = LayoutInflater.from(r110).inflate(R.layout.mini_app_action_bar, this, false);
        int r113 = R.id.btn_mini_close;
        ConstraintLayout r100 = (ConstraintLayout) ViewBindings.findChildViewById(r112, R.id.btn_mini_close);
        if (r100 == null) goto L15;
        r113 = R.id.btn_mini_menu;
        ConstraintLayout r101 = (ConstraintLayout) ViewBindings.findChildViewById(r112, R.id.btn_mini_menu);
        if (r101 == null) goto L15;
        r113 = R.id.iv_mini_close;
        ImageView r102 = (ImageView) ViewBindings.findChildViewById(r112, R.id.iv_mini_close);
        if (r102 == null) goto L15;
        r113 = R.id.iv_mini_menu;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r112, R.id.iv_mini_menu);
        if (r103 == null) goto L15;
        r113 = R.id.mini_divider;
        View r104 = ViewBindings.findChildViewById(r112, R.id.mini_divider);
        if (r104 == null) goto L15;
        ConstraintLayout r114 = (ConstraintLayout) r112;
        this.f398572b = new MiniAppActionBarBinding(r114, r100, r101, r102, r103, r104);
        addView(r114);
        r101.setOnClickListener(new c(this));
        r100.setOnClickListener(new d(this));
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }
}
