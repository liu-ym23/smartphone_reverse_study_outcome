package com.bytedance.livesdk.preview.widgets;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.j1;
import com.bytedance.livesdk.preview.base.VHWidget;
import com.bytedance.livesdk.preview.viewmodel.PreviewPlayerContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.live.preview.LivePreviewPlayerContainerAbility;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/livesdk/preview/widgets/BasePreviewPlayerWidget;", "Lcom/bytedance/livesdk/preview/base/VHWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePreviewPlayerWidget extends VHWidget {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PreviewPlayerContext f256447e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.livesdk.preview.base.VHWidget
    public final void Iq() {
        Object r100 = null;
        boolean r101 = r100 instanceof ViewGroup;
        ViewGroup r102 = (ViewGroup) null;
        PreviewPlayerContext r103 = this.f256447e;
        if (r103 == null) goto L6;
        r103.setPreviewPlayerView(null);
        return;
    }

    @Override // com.bytedance.livesdk.preview.base.VHWidget
    public final void wq() {
    }

    @Override // com.bytedance.livesdk.preview.base.VHWidget
    public final void Bq() {
        super.Bq();
        PreviewPlayerContext r100 = (PreviewPlayerContext) yq(PreviewPlayerContext.class);
        this.f256447e = r100;
        if (r100 == null) goto L5;
        r100.setContainerView(this.containerView);
    L5:
        PreviewPlayerContext r101 = this.f256447e;
        if (r101 == null) goto L12;
        ViewGroup r102 = this.containerView;
        if ((r102 instanceof ViewGroup) == true) goto L10;
        r102 = null;
    L10:
        r101.setPlayerContainerAbility(new LivePreviewPlayerContainerAbility(r102));
        return;
    }

    @Override // com.bytedance.livesdk.preview.base.VHWidget
    public final void Jq() {
        super.Jq();
        super.Cq();
    }

    @Override // com.bytedance.livesdk.preview.base.VHWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        j1.f142014a.getValue().getOpenFixPlayerV1();
    }

    public BasePreviewPlayerWidget() {
    }
}
