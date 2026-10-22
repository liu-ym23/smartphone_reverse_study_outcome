package com.bytedance.dux.popover.menu;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.dux.popover.DuxPopoverLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u00015B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u0019¢\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014RT\u0010!\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010)\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010-\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(¨\u00066"}, d2 = {"Lcom/bytedance/dux/popover/menu/PopoverMenuLinearLayout;", "Landroid/widget/LinearLayout;", "", "pressed", "", "setPressed", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getPressedCornerRadius", "()F", "setPressedCornerRadius", "(F)V", "pressedCornerRadius", "Lcom/bytedance/dux/popover/menu/PopoverMenuLinearLayout$Index;", "b", "Lcom/bytedance/dux/popover/menu/PopoverMenuLinearLayout$Index;", "getIndexPos", "()Lcom/bytedance/dux/popover/menu/PopoverMenuLinearLayout$Index;", "setIndexPos", "(Lcom/bytedance/dux/popover/menu/PopoverMenuLinearLayout$Index;)V", "indexPos", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "pressedColor", "c", "Lkotlin/jvm/functions/Function2;", "getNotifyPressedCallback", "()Lkotlin/jvm/functions/Function2;", "setNotifyPressedCallback", "(Lkotlin/jvm/functions/Function2;)V", "notifyPressedCallback", "value", "e", "Z", "getForceDark", "()Z", "setForceDark", "(Z)V", "forceDark", "f", "getForceLight", "setForceLight", "forceLight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Index", "dux_release"}, k = 1, mv = {1, 7, 1})
public class PopoverMenuLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f205473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Index f205474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super Boolean, ? super Integer, Unit> f205475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f205476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f205477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f205478f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/dux/popover/menu/PopoverMenuLinearLayout$Index;", "", "FIRST", "LAST", FlowDoraWifiScene.OTHER, "ONLY_ONE", "dux_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Index extends Enum<Index> {
        public static final Index FIRST = null;
        public static final Index LAST = null;
        public static final Index ONLY_ONE = null;
        public static final Index OTHER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Index[] f205479a = null;

        public static Index valueOf(String r100) {
            return (Index) a.a(Index.class, r100);
        }

        public static Index[] values() {
            return (Index[]) f205479a.clone();
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
            f205479a = new Index[]{r100, r101, r102, r103};
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
        return this.f205477e;
    }

    public final boolean getForceLight() {
        return this.f205478f;
    }

    public final Index getIndexPos() {
        return this.f205474b;
    }

    public final Function2<Boolean, Integer, Unit> getNotifyPressedCallback() {
        return this.f205475c;
    }

    public final float getPressedCornerRadius() {
        return this.f205473a;
    }

    public final void setForceDark(boolean r100) {
        if (r100 == false) goto L4;
        this.f205476d = ColorProtector.parseColor("#FF45474F");
    L5:
        this.f205477e = r100;
        return;
    L4:
        this.f205476d = ContextCompat.getColor(getContext(), R.color.BGPopoverPressed);
        goto L5
    }

    public final void setForceLight(boolean r100) {
        if (r100 == false) goto L4;
        this.f205476d = ColorProtector.parseColor("#FFF3F3F4");
    L5:
        this.f205478f = r100;
        return;
    L4:
        this.f205476d = ContextCompat.getColor(getContext(), R.color.BGPopoverPressed);
        goto L5
    }

    public final void setIndexPos(Index r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f205474b = r100;
    }

    public final void setNotifyPressedCallback(Function2<? super Boolean, ? super Integer, Unit> r100) {
        this.f205475c = r100;
    }

    @Override // android.view.View
    public void setPressed(boolean r110) {
        super.setPressed(r110);
        Function2<? super Boolean, ? super Integer, Unit> r100 = this.f205475c;
        if (r100 == null) goto L6;
        r100.invoke(Boolean.valueOf(r110), Integer.valueOf(this.f205476d));
    L6:
        if (r110 == false) goto L17;
        GradientDrawable r111 = new GradientDrawable();
        r111.setColor(this.f205476d);
        Index r101 = this.f205474b;
        if (r101 != Index.FIRST) goto L11;
        float r102 = this.f205473a;
        r111.setCornerRadii(new float[]{r102, r102, r102, r102, 0.0f, 0.0f, 0.0f, 0.0f});
    L16:
        setBackground(r111);
        return;
    L11:
        if (r101 != Index.LAST) goto L14;
        float r103 = this.f205473a;
        r111.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r103, r103, r103, r103});
        goto L16
    L14:
        if (r101 != Index.ONLY_ONE) goto L16;
        float r104 = this.f205473a;
        r111.setCornerRadii(new float[]{r104, r104, r104, r104, r104, r104, r104, r104});
        goto L16
    L17:
        setBackgroundColor(0);
    }

    public final void setPressedCornerRadius(float r100) {
        this.f205473a = r100;
    }

    public PopoverMenuLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = DuxPopoverLayout.f205431z;
        this.f205473a = DuxPopoverLayout.A;
        this.f205474b = Index.OTHER;
        this.f205476d = ContextCompat.getColor(r100, R.color.BGPopoverPressed);
    }

    public /* synthetic */ PopoverMenuLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
