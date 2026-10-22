package com.larus.avlink.simulInterpret.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.avlink.impl.databinding.LarusDoraPageTimbreCloneBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.DoraConfig;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.o0;
import ga8.b;
import ga8.c;
import ga8.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\fH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/avlink/simulInterpret/settings/TimbreCloneFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusDoraPageTimbreCloneBinding;", "TAG", "", "speakCloneDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "switchListener", "Lkotlin/Function1;", "", "", "autoLogEnterPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "getCurrentPageName", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "showRestartDialog", "isChecked", "saveSpeakerCloneOption", "restoreSwitchState", "targetState", "dismissRestartDialog", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimbreCloneFragment extends TraceFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f294676i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusDoraPageTimbreCloneBinding f294677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f294678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommonDialog f294679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ga8.a f294680h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "general_setting";
    }

    public TimbreCloneFragment() {
        this.f294678f = "TimbreCloneFragment";
    }

    public final void U90(boolean r100) {
        LarusDoraPageTimbreCloneBinding r101 = this.f294677e;
        if (r101 == null) goto L11;
        ItemTextToggle r102 = r101.f293196b;
        if (r102 == null) goto L12;
        CustomSwitchCompat r103 = r102.getToggleView();
        if (r103 == null) goto L13;
        r103.setOnCheckedChangeListener(null);
        r103.setChecked(r100);
        r103.setOnCheckedChangeListener(new e(this));
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDoraPageTimbreCloneBinding r102 = this.f294677e;
        if (r102 == null) goto L5;
        NovaTitleBarEx r103 = r102.f293197c;
        NovaTitleBarEx.Y5(r103, getString(R.string.larus_dora_simul_interpret_settings_title_cn), null, null, 6);
        NovaTitleBarEx.b6(r103, R.drawable.larus_ic_left_back, false, null, null, new c(this), 14);
    L5:
        LarusDoraPageTimbreCloneBinding r104 = this.f294677e;
        if (r104 == null) goto L12;
        ItemTextToggle r105 = r104.f293196b;
        if (r105 == null) goto L12;
        CustomSwitchCompat r106 = r105.getToggleView();
        if (r106 == null) goto L12;
        r106.setChecked(o0.d(DoraConfig.f331707a.getString("key_timbre_clone", "")));
    L12:
        this.f294680h = new ga8.a(this);
        LarusDoraPageTimbreCloneBinding r107 = this.f294677e;
        if (r107 == null) goto L20;
        ItemTextToggle r108 = r107.f293196b;
        if (r108 == null) goto L21;
        CustomSwitchCompat r109 = r108.getToggleView();
        if (r109 == null) goto L22;
        r109.setOnCheckedChangeListener(new b(this));
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_dora_page_timbre_clone, r101, false);
        int r104 = R.id.dora_multi_devices_switch_hint;
        if (((AppCompatTextView) ViewBindings.findChildViewById(r103, R.id.dora_multi_devices_switch_hint)) == null) goto L15;
        r104 = R.id.scroll_view;
        if (((ScrollView) ViewBindings.findChildViewById(r103, R.id.scroll_view)) == null) goto L15;
        r104 = R.id.timbre_clone;
        if (((ItemGroup) ViewBindings.findChildViewById(r103, R.id.timbre_clone)) == null) goto L15;
        r104 = R.id.timbre_clone_switch;
        ItemTextToggle r105 = (ItemTextToggle) ViewBindings.findChildViewById(r103, R.id.timbre_clone_switch);
        if (r105 == null) goto L15;
        r104 = R.id.title;
        NovaTitleBarEx r106 = (NovaTitleBarEx) ViewBindings.findChildViewById(r103, R.id.title);
        if (r106 == null) goto L15;
        ConstraintLayout r107 = (ConstraintLayout) r103;
        this.f294677e = new LarusDoraPageTimbreCloneBinding(r107, r105, r106);
        return r107;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
