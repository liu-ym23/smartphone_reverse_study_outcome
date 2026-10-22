package com.larus.dora.impl.dynamic.viewholder;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import com.larus.dora.impl.databinding.LarusDoraDeviceInfoReconnectLayoutBinding;
import com.larus.dora.impl.dynamic.BaseViewHolder;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/dora/impl/dynamic/viewholder/DeviceInfoReconnectViewHolder;", "Lcom/larus/dora/impl/dynamic/BaseViewHolder;", "Lcom/larus/dora/impl/dynamic/entity/CardInstance;", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoReconnectLayoutBinding;", "<init>", "(Lcom/larus/dora/impl/databinding/LarusDoraDeviceInfoReconnectLayoutBinding;)V", "rotateAnimation", "Landroid/view/animation/Animation;", "currentUIState", "Lcom/larus/dora/impl/dynamic/event/DeviceUIState;", "deviceMac", "", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "shouldShowLoading", "", "bind", "", "data", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "updateUIByConnectionState", "state", "updateUIState", "newState", "startLoadingAnimation", "stopLoadingAnimation", "onViewAttached", "onViewDetached", "onViewRecycled", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceInfoReconnectViewHolder extends BaseViewHolder<d59.c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f335287g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusDoraDeviceInfoReconnectLayoutBinding f335288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Animation f335289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e59.c f335290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f335291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f335292f;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void onViewRecycled() {
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void U3() {
        if (this.f335292f == false) goto L6;
        X3();
        return;
    }

    public final void X3() {
        if (this.f335289c != null) goto L7;
        Animation r100 = AnimationUtils.loadAnimation(this.itemView.getContext(), R.anim.larus_dora_loading_animation);
        this.f335289c = r100;
        if (r100 == null) goto L7;
        r100.setInterpolator(new LinearInterpolator());
    L7:
        this.f335288b.f332433d.clearAnimation();
        e1.x(this.f335288b.f332433d);
        this.f335288b.f332433d.startAnimation(this.f335289c);
    }

    public final void Y3() {
        this.f335288b.f332433d.clearAnimation();
        e1.o(this.f335288b.f332433d);
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void V3() {
        Y3();
        this.f335289c = null;
    }

    public DeviceInfoReconnectViewHolder(LarusDoraDeviceInfoReconnectLayoutBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        super(r100.f332430a);
        this.f335288b = r100;
        this.f335290d = e59.c.d.f471068a;
    }

    public final void Z3(e59.c r100) {
        if (Intrinsics.areEqual(this.f335290d, r100) == false) goto L5;
        return;
    L5:
        this.f335290d = r100;
        if (Intrinsics.areEqual(r100, e59.c.d.f471068a) == false) goto L9;
        this.f335288b.f332432c.setText(R.string.larus_dora_device_disconnected_btn_retry_cn);
        this.f335288b.f332431b.setEnabled(true);
        e1.x(this.f335288b.f332431b);
        this.f335292f = false;
        Y3();
        return;
    L9:
        if (Intrinsics.areEqual(r100, e59.c.C5742c.f471067a) == false) goto L12;
        e1.x(this.f335288b.f332433d);
        this.f335292f = true;
        this.f335288b.f332432c.setText(R.string.larus_dora_device_disconnected_btn_retrying_cn);
        this.f335288b.f332431b.setEnabled(false);
        e1.x(this.f335288b.f332431b);
        X3();
        return;
    L12:
        if (Intrinsics.areEqual(r100, e59.c.a.f471065a) == false) goto L15;
        this.f335288b.f332432c.setText(R.string.larus_dora_device_disconnected_btn_retry_cn);
        this.f335288b.f332431b.setEnabled(true);
        e1.x(this.f335288b.f332431b);
        this.f335292f = false;
        Y3();
        return;
    L15:
        if (Intrinsics.areEqual(r100, e59.c.b.f471066a) == false) goto L19;
        e1.o(this.f335288b.f332431b);
        Y3();
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.dora.impl.dynamic.BaseViewHolder
    public final void T3(d59.c r100, e59.b r101, d59.b r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "connectionState");
        if (r102 == null) goto L7;
        z49.b r103 = r102.f467075a;
        if (r103 == null) goto L7;
        String r104 = r103.c();
    L8:
        this.f335291e = r104;
        e1.d(this.f335288b.f332431b, new d(this));
        if ((r101 instanceof e59.b.d) == false) goto L12;
        Z3(e59.c.d.f471068a);
        return;
    L12:
        if ((r101 instanceof e59.b.C5741b) == false) goto L18;
        if (Intrinsics.areEqual(((e59.b.C5741b) r101).f471062a, this.f335291e) == false) goto L16;
        Z3(e59.c.C5742c.f471067a);
        return;
    L16:
        Z3(e59.c.d.f471068a);
        return;
    L18:
        if ((r101 instanceof e59.b.a) == false) goto L24;
        if (Intrinsics.areEqual(((e59.b.a) r101).f471061a, this.f335291e) == false) goto L22;
        Z3(e59.c.b.f471066a);
        return;
    L22:
        Z3(e59.c.d.f471068a);
        return;
    L24:
        if ((r101 instanceof e59.b.c) == false) goto L30;
        if (Intrinsics.areEqual(((e59.b.c) r101).f471063a, this.f335291e) == false) goto L36;
        Z3(e59.c.d.f471068a);
        return;
    L36:
        return;
    L30:
        throw new NoWhenBranchMatchedException();
    L7:
        r104 = null;
        goto L8
    }
}
