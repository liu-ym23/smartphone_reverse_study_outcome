package l92;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.pin.business.im.PinImHighlightPageItemView;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import jc1.k;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f508097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PinImHighlightPageItemView f508098b;

    public c(String r100, PinImHighlightPageItemView r101) {
        this.f508097a = r100;
        this.f508098b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((ILiveActionHandler) k.n(ILiveActionHandler.class)).handle(this.f508098b.getContext(), this.f508097a);
    }
}
