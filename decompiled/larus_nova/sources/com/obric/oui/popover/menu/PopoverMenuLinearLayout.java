package com.obric.oui.popover.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00106\u001a\u00020\u0019¢\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014RT\u0010!\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u00101\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006:"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "Landroid/widget/LinearLayout;", "", "pressed", "", "setPressed", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getPressedCornerRadius", "()F", "setPressedCornerRadius", "(F)V", "pressedCornerRadius", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "b", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "getIndexPos", "()Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "setIndexPos", "(Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;)V", "indexPos", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "pressedColor", "c", "Lkotlin/jvm/functions/Function2;", "getNotifyPressedCallback", "()Lkotlin/jvm/functions/Function2;", "setNotifyPressedCallback", "(Lkotlin/jvm/functions/Function2;)V", "notifyPressedCallback", "Landroid/graphics/drawable/GradientDrawable;", "d", "Landroid/graphics/drawable/GradientDrawable;", "getStateBackground", "()Landroid/graphics/drawable/GradientDrawable;", "setStateBackground", "(Landroid/graphics/drawable/GradientDrawable;)V", "stateBackground", "value", "f", "Z", "getForceDark", "()Z", "setForceDark", "(Z)V", "forceDark", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Index", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class PopoverMenuLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f402310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Index f402311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Boolean, ? super Integer, Unit> f402312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GradientDrawable f402313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f402314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f402315f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout$Index;", "", "FIRST", "LAST", FlowDoraWifiScene.OTHER, "ONLY_ONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum Index extends Enum<Index> {
        public static final Index FIRST = null;
        public static final Index LAST = null;
        public static final Index ONLY_ONE = null;
        public static final Index OTHER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Index[] f402316a = null;

        public static Index valueOf(String r100) {
            return (Index) r27.a.a(Index.class, r100);
        }

        public static Index[] values() {
            return (Index[]) f402316a.clone();
        }

        static {
            Index r100 = new Index("FIRST", 0);
            FIRST = r100;
            Index r101 = new Index("LAST", 1);
            LAST = r101;
            Index r102 = new Index(FlowDoraWifiScene.OTHER, 2);
            OTHER = r102;
            Index r103 = new Index("ONLY_ONE", 3);
            ONLY_ONE = r103;
            f402316a = new Index[]{r100, r101, r102, r103};
        }

        public Index(String r100, int r101) {
            super(r100, r101);
        }
    }

    public PopoverMenuLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PopoverMenuLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final boolean getForceDark() {
        return this.f402315f;
    }

    public final Index getIndexPos() {
        return this.f402311b;
    }

    public final Function2<Boolean, Integer, Unit> getNotifyPressedCallback() {
        return this.f402312c;
    }

    public final float getPressedCornerRadius() {
        return this.f402310a;
    }

    public final GradientDrawable getStateBackground() {
        return this.f402313d;
    }

    public final void setForceDark(boolean r100) {
        GradientDrawable r101 = null;
        if (r100 == false) goto L8;
        this.f402314e = ColorProtector.parseColor("#1affffff");
        Drawable r102 = ContextCompat.getDrawable(getContext(), R.drawable.o_pop_list_item_dark);
        if ((r102 instanceof GradientDrawable) == false) goto L7;
        r101 = (GradientDrawable) r102;
    L7:
        this.f402313d = r101;
    L12:
        GradientDrawable r103 = this.f402313d;
        if (r103 == null) goto L16;
        setBackground(r103);
    L16:
        this.f402315f = r100;
        return;
    L8:
        this.f402314e = ContextCompat.getColor(getContext(), R.color.oui_state_overlay_pressed);
        Drawable r104 = ContextCompat.getDrawable(getContext(), R.drawable.o_pop_list_item);
        if ((r104 instanceof GradientDrawable) == false) goto L11;
        r101 = (GradientDrawable) r104;
    L11:
        this.f402313d = r101;
        goto L12
    }

    public final void setIndexPos(Index r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402311b = r100;
    }

    public final void setNotifyPressedCallback(Function2<? super Boolean, ? super Integer, Unit> r100) {
        this.f402312c = r100;
    }

    @Override // android.view.View
    public void setPressed(boolean r100) {
        super.setPressed(r100);
        Function2<? super Boolean, ? super Integer, Unit> r101 = this.f402312c;
        if (r101 == null) goto L7;
        r101.invoke(Boolean.valueOf(r100), Integer.valueOf(this.f402314e));
        return;
    }

    public final void setPressedCornerRadius(float r100) {
        this.f402310a = r100;
    }

    public final void setStateBackground(GradientDrawable r100) {
        this.f402313d = r100;
    }

    public PopoverMenuLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402310a = d.q(this, 20);
        this.f402311b = Index.OTHER;
        this.f402314e = ContextCompat.getColor(r100, R.color.oui_state_overlay_pressed);
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
