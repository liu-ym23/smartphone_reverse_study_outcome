package com.larus.livetutor.impl.view;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.venus.ShapeConstraintLayout;
import com.larus.livetutor.impl.LiveTutorActivity;
import com.larus.livetutor.impl.base.BaseBottomDialog;
import com.larus.livetutor.impl.databinding.LiveTutorSettingsDialogBinding;
import com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel;
import com.larus.nova.R;
import com.larus.settings.tutor.LiveTutorConfig;
import com.larus.settings.tutor.VoiceConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0003J\b\u0010\u0015\u001a\u00020\u0014H\u0003J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\f\u0010\u0017\u001a\u00020\u0014*\u00020\fH\u0002J$\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J&\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/livetutor/impl/view/LiveTutorSettingsDialog;", "Lcom/larus/livetutor/impl/base/BaseBottomDialog;", "viewModel", "Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;Landroid/content/Context;)V", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "binding", "Lcom/larus/livetutor/impl/databinding/LiveTutorSettingsDialogBinding;", "config", "Lcom/larus/settings/tutor/LiveTutorConfig;", "pitchList", "", "Lcom/larus/settings/tutor/VoiceConfig;", "speedList", "initView", "", "initObservers", "dismiss", "initPitchAndRate", "updatePitchAndRate", TextureRenderKeys.KEY_IS_PITCH, "", "speed", "isPitch", "", "refreshPitchAndRate", "getProgress", "", "list", "value", "defaultValue", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorSettingsDialog extends BaseBottomDialog {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f356729s = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LiveTutorViewModel f356730n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LiveTutorSettingsDialogBinding f356731o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LiveTutorConfig f356732p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<VoiceConfig> f356733q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<VoiceConfig> f356734r;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f356735a;

        public b(k0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f356735a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f356735a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f356735a.invoke(r100);
        }
    }

    static {
    }

    public final void P0() {
        double r100 = oj9.a.a(this.f356732p);
        double r101 = oj9.a.b(this.f356732p);
        Double r102 = this.f356730n.getCurrentUserSetting().getTtsPitch();
        if (r102 == null) goto L5;
        double r103 = r102.doubleValue();
    L6:
        Double r104 = this.f356730n.getCurrentUserSetting().getTtsSpeed();
        if (r104 == null) goto L9;
        double r105 = r104.doubleValue();
    L10:
        String r106 = getContext().getString(R.string.larus_tutor_voice_settings_default_cn);
        LiveTutorSettingsDialogBinding r107 = this.f356731o;
        r107.f355985b.setProgress(O0(this.f356733q, r103, r100));
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        boolean r111 = true;
        String r112 = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r103)}, 1));
        AppCompatTextView r113 = r107.f355986c;
        if (r103 != r100) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
        r112 = r106 + r112;
    L16:
        r113.setText(r112);
        r107.f355987d.setProgress(O0(this.f356734r, r105, r101));
        String r109 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r105)}, 1));
        AppCompatTextView r114 = r107.f355988e;
        if (r105 == r101) goto L20;
        r111 = false;
    L20:
        if (r111 == false) goto L22;
        r109 = r106 + r109;
    L22:
        r114.setText(r109);
        return;
    L13:
        r108 = false;
        goto L14
    L9:
        r105 = r101;
        goto L10
    L5:
        r103 = r100;
        goto L6
    }

    @Override // com.larus.livetutor.impl.base.BaseBottomDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (Intrinsics.areEqual(this.f356730n.getSpeedingChanging().getValue(), Boolean.TRUE) == false) goto L6;
        kj9.b.a("[LiveTutorSettingsDialog] speed changing, ignore dismiss");
        return;
    L6:
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r101 == null) goto L20;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r100.getLooper()) goto L11;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    /* JADX WARN: Type inference failed for: r2v20, types: [com.larus.livetutor.impl.view.k0] */
    public LiveTutorSettingsDialog(LiveTutorViewModel r110, final LiveTutorActivity r210) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, new j0(r210));
        this.f356730n = r110;
        View r100 = LayoutInflater.from(r210).inflate(R.layout.live_tutor_settings_dialog, null, false);
        int r101 = R.id.live_tutor_pitch_progress;
        SeekBar r102 = (SeekBar) ViewBindings.findChildViewById(r100, R.id.live_tutor_pitch_progress);
        if (r102 == null) goto L69;
        r101 = R.id.live_tutor_pitch_progress_text;
        AppCompatTextView r111 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.live_tutor_pitch_progress_text);
        if (r111 == null) goto L69;
        r101 = R.id.live_tutor_pitch_title;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.live_tutor_pitch_title)) == null) goto L69;
        r101 = R.id.live_tutor_rate_progress;
        SeekBar r103 = (SeekBar) ViewBindings.findChildViewById(r100, R.id.live_tutor_rate_progress);
        if (r103 == null) goto L69;
        r101 = R.id.live_tutor_rate_progress_text;
        AppCompatTextView r112 = (AppCompatTextView) ViewBindings.findChildViewById(r100, R.id.live_tutor_rate_progress_text);
        if (r112 == null) goto L69;
        r101 = R.id.live_tutor_rate_title;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.live_tutor_rate_title)) == null) goto L69;
        if (((ShapeConstraintLayout) ViewBindings.findChildViewById(r100, R.id.sheet_container)) == null) goto L67;
        r101 = R.id.speed_container;
        if (((ShapeConstraintLayout) ViewBindings.findChildViewById(r100, R.id.speed_container)) == null) goto L69;
        r101 = R.id.speed_title;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.speed_title)) == null) goto L69;
        r101 = R.id.subtitle_container;
        ItemTextToggle r104 = (ItemTextToggle) ViewBindings.findChildViewById(r100, R.id.subtitle_container);
        if (r104 == null) goto L69;
        r101 = R.id.subtitle_title;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.subtitle_title)) == null) goto L69;
        r101 = R.id.top_bar_icon;
        View r113 = ViewBindings.findChildViewById(r100, R.id.top_bar_icon);
        if (r113 == null) goto L69;
        CoordinatorLayout r105 = (CoordinatorLayout) r100;
        LiveTutorSettingsDialogBinding r106 = new LiveTutorSettingsDialogBinding(r105, r102, r111, r103, r112, r104, r113);
        this.f356731o = r106;
        LiveTutorConfig r107 = r110.getLiveTutorConfig();
        this.f356732p = r107;
        List<VoiceConfig> r114 = com.larus.settings.tutor.b.f368559a;
        this.f356733q = r114;
        List<VoiceConfig> r115 = com.larus.settings.tutor.b.f368560b;
        this.f356734r = r115;
        setContentView(r105);
        CustomSwitchCompat r108 = r104.getToggleView();
        r108.setTrackResource(R.drawable.live_tutor_bg_switch_track);
        Boolean r116 = r110.getSubtitleState().getValue();
        if (r116 == null) goto L29;
        boolean r117 = r116.booleanValue();
    L30:
        r108.setChecked(r117);
        r108.setOnCheckedChangeListener(new l0(this));
        r104.getTextView().setTextColor(ContextCompat.getColor(getContext(), R.color.black));
        double r118 = oj9.a.a(r107);
        Double r109 = r110.getCurrentUserSetting().getTtsPitch();
        if (r109 == null) goto L33;
        double r119 = r109.doubleValue();
    L34:
        List<VoiceConfig> r120 = r107.getTtsPitchList();
        if (r120 == null) goto L46;
        List r121 = CollectionsKt.filterNotNull(r120);
        if (r121 == null) goto L46;
        if ((!r121.isEmpty()) == true) goto L42;
        r121 = null;
    L42:
        if (r121 == null) goto L46;
        List<VoiceConfig> r122 = CollectionsKt.sortedWith(r121, new m0());
        if (r122 == null) goto L46;
        r114 = r122;
    L46:
        this.f356733q = r114;
        r102.setMax(r114.size() - 1);
        r102.setProgress(O0(this.f356733q, r119, r118));
        r102.setOnSeekBarChangeListener(new o0(this, r118, r106, r102));
        double r123 = oj9.a.b(r107);
        Double r124 = r110.getCurrentUserSetting().getTtsSpeed();
        if (r124 == null) goto L49;
        double r125 = r124.doubleValue();
    L50:
        List<VoiceConfig> r126 = r107.getTtsSpeedList();
        if (r126 == null) goto L62;
        List r127 = CollectionsKt.filterNotNull(r126);
        if (r127 == null) goto L62;
        if ((!r127.isEmpty()) == false) goto L57;
        List r128 = r127;
    L58:
        if (r128 == null) goto L62;
        List<VoiceConfig> r129 = CollectionsKt.sortedWith(r128, new n0());
        if (r129 == null) goto L62;
        r115 = r129;
        goto L62
    L57:
        r128 = null;
    L62:
        this.f356734r = r115;
        r103.setMax(r115.size() - 1);
        r103.setProgress(O0(this.f356734r, r125, r123));
        r103.setOnSeekBarChangeListener(new p0(this, r123, r106));
        BottomSheetBehavior r130 = BottomSheetBehavior.from(findViewById(R.id.sheet_container));
        r130.setHideable(true);
        r130.setSkipCollapsed(true);
        r130.setFitToContents(true);
        r130.setState(3);
        r130.setBottomSheetCallback(new q0(this));
        LifecycleOwner r131 = r110.getLifecycleOwner();
        if (r131 == null) goto L70;
        r110.getSpeedingChanging().observe(r131, new b(new k0(this)));
        return;
    L70:
        return;
    L49:
        r125 = r123;
        goto L50
    L33:
        r119 = r118;
        goto L34
    L29:
        r117 = true;
        goto L30
    L67:
        r101 = R.id.sheet_container;
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public static int O0(List r100, double r101, double r110) {
        Iterator r102 = r100.iterator();
        if (r102.hasNext() == true) goto L5;
        Object r103 = null;
    L24:
        return RangesKt.coerceAtLeast(CollectionsKt.indexOf(r100, (VoiceConfig) r103), 0);
    L5:
        Object r104 = r102.next();
        if (r102.hasNext() == true) goto L8;
    L7:
        r103 = r104;
        goto L24
    L8:
        Double r105 = ((VoiceConfig) r104).getValue();
        if (r105 == null) goto L11;
        double r106 = r105.doubleValue();
    L12:
        double r107 = Math.abs(r106 - r101);
    L13:
        Object r108 = r102.next();
        Double r109 = ((VoiceConfig) r108).getValue();
        if (r109 == null) goto L16;
        double r111 = r109.doubleValue();
    L17:
        double r112 = Math.abs(r111 - r101);
        if (Double.compare(r107, r112) <= 0) goto L21;
        r104 = r108;
        r107 = r112;
    L21:
        if (r102.hasNext() == true) goto L13;
    L16:
        r111 = r110;
        goto L17
    L11:
        r106 = r110;
        goto L12
    }

    public static void Q0(LiveTutorSettingsDialog r100, double r101, double r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L9;
        Double r105 = r100.f356730n.getCurrentUserSetting().getTtsPitch();
        if (r105 == null) goto L7;
        r101 = r105.doubleValue();
        goto L9
    L7:
        r101 = oj9.a.a(r100.f356732p);
    L9:
        if ((r104 & 2) == 0) goto L15;
        Double r106 = r100.f356730n.getCurrentUserSetting().getTtsSpeed();
        if (r106 == null) goto L13;
        r102 = r106.doubleValue();
        goto L15
    L13:
        r102 = oj9.a.b(r100.f356732p);
    L15:
        if (Intrinsics.areEqual(r101, r100.f356730n.getCurrentUserSetting().getTtsPitch()) == true) goto L17;
    L19:
        if (r103 == false) goto L21;
        r100.f356730n.updatePitch(r101);
        return;
    L21:
        r100.f356730n.updateSpeed(r102);
        return;
    L17:
        if (Intrinsics.areEqual(r102, r100.f356730n.getCurrentUserSetting().getTtsSpeed()) == false) goto L19;
        r100.P0();
    }
}
