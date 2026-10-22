package g20;

import a20.m;
import android.view.View;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.base.OpenFeatureIconCallbackType;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3.OpenFeatureTabListItemViewHolderV3;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenFeatureTabListItemViewHolderV3 f479665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a20.e f479666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f479667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f10.f f479668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f479669e;

    public h(OpenFeatureTabListItemViewHolderV3 r100, a20.e r101, View r102, f10.f r103, int r104) {
        this.f479665a = r100;
        this.f479666b = r101;
        this.f479667c = r102;
        this.f479668d = r103;
        this.f479669e = r104;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f479666b != null) goto L5;
        LocalTestManager.a(new Class[]{wy.a.class});
    L5:
        a20.e r101 = this.f479666b;
        if (r101 == null) goto L9;
        r101.a(this.f479667c, this.f479668d, this.f479669e, new m(this.f479665a.f61682l, OpenFeatureIconCallbackType.ITEM_CONTENT));
        return;
    }
}
