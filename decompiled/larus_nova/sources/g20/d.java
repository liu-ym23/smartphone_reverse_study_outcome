package g20;

import a20.m;
import android.view.View;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemDebugModeViewHolder;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenFeatureTabListItemDebugModeViewHolder f479656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a20.e f479657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f10.f f479658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f479659d;

    public d(OpenFeatureTabListItemDebugModeViewHolder r100, a20.e r101, f10.f r102, int r103) {
        this.f479656a = r100;
        this.f479657b = r101;
        this.f479658c = r102;
        this.f479659d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        a20.e r101 = this.f479657b;
        if (r101 == null) goto L6;
        r101.a(r100, this.f479658c, this.f479659d, new m(this.f479656a.f61682l, OpenFeatureIconCallbackType.DEBUG_BUTTON));
        return;
    }
}
