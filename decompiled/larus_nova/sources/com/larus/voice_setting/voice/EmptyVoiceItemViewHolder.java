package com.larus.voice_setting.voice;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larus/voice_setting/voice/EmptyVoiceItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/voice_setting/voice/BaseVoiceItem;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "bindData", "", "voiceItem", "Lcom/larus/voice_setting/voice/VoiceItem;", "config", "Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "changeDividerVisibility", "isVisible", "", "setMoreBtnClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "detach", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyVoiceItemViewHolder extends RecyclerView.ViewHolder implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f376245b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f376246a;

    @Override // com.larus.voice_setting.voice.a
    public final void l3(boolean r100) {
    }

    @Override // com.larus.voice_setting.voice.a
    public final void x1(q2 r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
    }

    @Override // com.larus.voice_setting.voice.a
    public final void detach() {
        ValueAnimator r100 = this.f376246a;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f376246a;
        if (r101 == null) goto L8;
        r101.removeAllUpdateListeners();
    L8:
        this.f376246a = null;
    }

    public EmptyVoiceItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    @Override // com.larus.voice_setting.voice.a
    public final void W1(r2 r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
    }

    @Override // com.larus.voice_setting.voice.a
    public final void d2(o2 r100, t2 r101) {
        Intrinsics.checkNotNullParameter(r101, "config");
        final WeakReference r102 = new WeakReference(this.itemView.findViewById(R.id.avatar_view));
        final WeakReference r103 = new WeakReference(this.itemView.findViewById(R.id.empty_title));
        final WeakReference r104 = new WeakReference(this.itemView.findViewById(R.id.empty_des));
        final WeakReference r105 = new WeakReference(this.itemView.findViewById(R.id.empty_label));
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{0.05f, 0.1f});
        this.f376246a = r106;
        if (r106 == null) goto L5;
        r106.setDuration(500);
    L5:
        ValueAnimator r107 = this.f376246a;
        if (r107 == null) goto L8;
        r107.setRepeatCount(-1);
    L8:
        ValueAnimator r108 = this.f376246a;
        if (r108 == null) goto L11;
        r108.setRepeatMode(2);
    L11:
        ValueAnimator r109 = this.f376246a;
        if (r109 == null) goto L14;
        r109.addUpdateListener(new j0(r102, r103, r104, r105));
    L14:
        ValueAnimator r110 = this.f376246a;
        if (r110 == null) goto L18;
        r110.start();
        return;
    }
}
