package com.larksuite.component.card.component.slider;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.Gson;
import com.larksuite.component.card.component.g;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0014J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u001c\u0010\u0011\u001a\u00020\u0012*\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0013H\u0002¨\u0006 "}, d2 = {"Lcom/larksuite/component/card/component/slider/UniversalCardLynxSliderUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/card/component/slider/CardSeekBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "createView", "Landroid/content/Context;", "initSeekBar", "", "seekBar", "setProps", SlcElement.KEY_PROPS, "Lcom/lynx/react/bridge/ReadableMap;", "applyProps", "Lcom/larksuite/component/card/component/slider/CardSliderProps;", "toColorOrDefault", "", "", "default", "Lkotlin/Function0;", "createProgressDrawable", "Landroid/graphics/drawable/Drawable;", "bgColor", "fillColor", "createThumbDrawable", "knobColor", "sendEvent", "value", "mode", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardLynxSliderUI extends LynxUI<CardSeekBar> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283560a = 0;

    public static final class a {
    }

    static {
    }

    public UniversalCardLynxSliderUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CardSeekBar r101 = new CardSeekBar(r100, 0);
        r101.setMax(100);
        r101.setBackground(null);
        r101.setSplitTrack(false);
        int r102 = UIUtils.dp2px(r100, 8.0f);
        r101.setPadding(r102, 0, r102, 0);
        N(r101, new com.larksuite.component.card.component.slider.a(0));
        r101.setOnSeekBarChangeListener(new c(this));
        return r101;
    }

    @LynxProp(name = SlcElement.KEY_PROPS)
    public final void setProps(ReadableMap r100) {
        CardSeekBar r101 = getView();
        if (r101 != null) goto L6;
        Log.e("UniversalCardLynxSliderUI", "setProps fail, view is null");
        return;
    L6:
        if (r100 == null) goto L9;
        Gson r102 = g.f283368a;
        com.larksuite.component.card.component.slider.a r103 = (com.larksuite.component.card.component.slider.a) g.c(r100, com.larksuite.component.card.component.slider.a.class);
        if (r103 == null) goto L9;
    L10:
        N(r101, r103);
        return;
    L9:
        r103 = new com.larksuite.component.card.component.slider.a(0);
        goto L10
    }

    public static int O(String r100, Function0 r101) {
        if (r100 == null) goto L4;
        return Color.parseColor(r100);
    L7:
        th = move-exception;
        Log.e("UniversalCardLynxSliderUI", "parse color " + r100 + " error", th);
        return ((Number) r101.invoke()).intValue();
    L4:
        return ((Number) r101.invoke()).intValue();
    }

    public final void N(CardSeekBar r110, com.larksuite.component.card.component.slider.a r111) {
        final Context r100 = getLynxContext().getContext();
        r110.setEnabled(!r111.b());
        Integer r101 = r111.e();
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        r110.setProgress(r102);
        int r103 = O(r111.a(), new UniversalCardLynxSliderUI$applyProps$bgColor$1(r100));
        int r104 = O(r111.c(), new UniversalCardLynxSliderUI$applyProps$fillColor$1(r100));
        int r112 = O(r111.d(), new UniversalCardLynxSliderUI$applyProps$knobColor$1(r100));
        Intrinsics.checkNotNull(r100);
        GradientDrawable r105 = new GradientDrawable();
        r105.setShape(0);
        r105.setCornerRadius(UIUtils.dp2px(r100, 1.0f));
        r105.setColor(r103);
        GradientDrawable r106 = new GradientDrawable();
        r106.setShape(0);
        r106.setCornerRadius(UIUtils.dp2px(r100, 1.0f));
        r106.setColor(r103);
        ClipDrawable r107 = new ClipDrawable(r106, GravityCompat.START, 1);
        GradientDrawable r108 = new GradientDrawable();
        r108.setShape(0);
        r108.setCornerRadius(UIUtils.dp2px(r100, 1.0f));
        r108.setColor(r104);
        LayerDrawable r109 = new LayerDrawable(new Drawable[]{r105, r107, new ClipDrawable(r108, GravityCompat.START, 1)});
        r109.setId(0, R.id.background);
        r109.setId(1, R.id.secondaryProgress);
        r109.setId(2, R.id.progress);
        r110.setProgressDrawable(r109);
        GradientDrawable r113 = new GradientDrawable();
        r113.setShape(1);
        int r114 = UIUtils.dp2px(r100, 16.0f);
        r113.setSize(r114, r114);
        r113.setColor(r112);
        r113.setStroke(UIUtils.dp2px(r100, 0.5f), UIUtils.getAlphaColor(r112, 0.15d));
        r110.setThumb(r113);
        r110.setThumbOffset(UIUtils.dp2px(r100, 8.0f));
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static final void M(UniversalCardLynxSliderUI r100, int r101, String r102) {
        r100.getClass();
        HashMap r103 = new HashMap();
        r103.put("value", Integer.valueOf(r101));
        r103.put("mode", r102);
        r100.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r100.getSign(), "valueChange", r103));
    }
}
