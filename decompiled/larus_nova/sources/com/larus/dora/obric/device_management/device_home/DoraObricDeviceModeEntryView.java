package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001b\u001a\u00020\u0007*\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeEntryView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "modeDot", "Landroid/view/View;", "modeText", "Landroid/widget/TextView;", "modeChevron", "onModeClick", "Lkotlin/Function0;", "", "isModeClickEnabled", "", "setOnModeClickListener", "listener", ChameleonOpenTracker.Stage.RENDER, "product", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeEntryProduct;", "state", "Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesModeUiState;", "drawableRes", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeIndicator;", "getDrawableRes", "(Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeIndicator;)I", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceModeEntryView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f339128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f339129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f339130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f339131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f339132e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339133a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f339134b = null;

        static {
            int[] r100 = new int[DoraObricDeviceModeEntryLabel.values().length];
            r100[DoraObricDeviceModeEntryLabel.ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DoraObricDeviceModeEntryLabel.HEADPHONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f339133a = r100;
            int[] r101 = new int[DoraObricDeviceModeIndicator.values().length];
            r101[DoraObricDeviceModeIndicator.ASSISTANT_MEMORY_OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[DoraObricDeviceModeIndicator.ASSISTANT_MEMORY_ON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[DoraObricDeviceModeIndicator.HEADPHONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f339134b = r101;
        }
    }

    public DoraObricDeviceModeEntryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DoraObricDeviceModeEntryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setOnModeClickListener(Function0<Unit> r100) {
        this.f339131d = r100;
    }

    public final void a(DoraObricDeviceModeEntryProduct r100, h3 r101) {
        Intrinsics.checkNotNullParameter(r100, "product");
        Intrinsics.checkNotNullParameter(r101, "state");
        z1 r102 = b2.a(r100, r101);
        int r103 = 8;
        if (r102 != null) goto L6;
        setVisibility(8);
        setEnabled(false);
        this.f339132e = false;
        return;
    L6:
        setVisibility(0);
        setEnabled(r102.f339397b);
        this.f339132e = r102.f339398c;
        setAlpha(1.0f);
        this.f339128a.setEnabled(r102.f339397b);
        this.f339129b.setEnabled(r102.f339397b);
        this.f339130c.setEnabled(r102.f339397b);
        this.f339128a.setAlpha(r102.f339400e);
        this.f339129b.setAlpha(r102.f339400e);
        this.f339130c.setAlpha(r102.f339400e);
        View r104 = this.f339130c;
        if (r102.f339399d == false) goto L9;
        r103 = 0;
    L9:
        r104.setVisibility(r103);
        setClickable(true);
        TextView r105 = this.f339129b;
        DoraObricDeviceModeEntryLabel r106 = r102.f339396a;
        int r107 = a.f339133a[r106.ordinal()];
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        int r108 = R.string.larus_dora_obric_glasses_mode_headphone_cn;
    L16:
        r105.setText(r108);
        setContentDescription(this.f339129b.getText());
        View r109 = this.f339128a;
        DoraObricDeviceModeIndicator r110 = r102.f339401f;
        int r111 = a.f339134b[r110.ordinal()];
        if (r111 == 1) goto L25;
        if (r111 != 2) goto L20;
        int r112 = R.drawable.larus_dora_obric_device_mode_entry_indicator_running;
    L26:
        r109.setBackgroundResource(r112);
        return;
    L20:
        if (r111 != 3) goto L23;
        r112 = R.drawable.larus_dora_obric_device_mode_entry_indicator_headphone;
        goto L26
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        r112 = R.drawable.larus_dora_obric_device_mode_entry_indicator_disabled;
        goto L26
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r108 = R.string.larus_dora_obric_glasses_mode_assistant_cn;
        goto L16
    }

    public DoraObricDeviceModeEntryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_dora_view_obric_device_mode_entry, this, true);
        this.f339128a = findViewById(R.id.dora_obric_device_mode_entry_dot);
        this.f339129b = (TextView) findViewById(R.id.dora_obric_device_mode_entry_text);
        this.f339130c = findViewById(R.id.dora_obric_device_mode_entry_chevron);
        setVisibility(8);
        setOnClickListener(new e2(this));
    }

    public /* synthetic */ DoraObricDeviceModeEntryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
