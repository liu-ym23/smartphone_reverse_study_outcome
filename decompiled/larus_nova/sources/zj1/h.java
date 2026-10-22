package zj1;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.larus.nova.R;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f572441a;

    @Override // com.bytedance.android.livesdk.chatroom.widget.m0
    public final Rect a() {
        Rect r100 = new Rect();
        this.f572441a.f572428b.f568056c.R8().getRenderView().getSelfView().getGlobalVisibleRect(r100);
        return r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.m0
    public final int b() {
        return this.f572441a.f572427a.f490211d.getPortraitVideoViewMarginTop();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.m0
    public final Rect c() {
        if (this.f572441a.f572429c.f510501h.getView() != null) goto L5;
        return null;
    L5:
        if (this.f572441a.f572429c.f510501h.getView().findViewById(R.id.fragment_container) == null) goto L10;
        Rect r100 = new Rect();
        this.f572441a.f572429c.f510501h.getView().findViewById(R.id.fragment_container).getGlobalVisibleRect(r100);
        return r100;
    L10:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.m0
    public final Pair<Integer, Integer> d() {
        View r100 = this.f572441a.f572428b.f568056c.R8().getRenderView().getSelfView();
        return new Pair(Integer.valueOf(r100.getWidth()), Integer.valueOf(r100.getHeight()));
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.m0
    public final Rect e() {
        ILivePlayerClient r100 = this.f572441a.f572428b.f568057d;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.extraRenderController() != null) goto L7;
        return null;
    L7:
        if (this.f572441a.f572428b.f568057d.extraRenderController().curExtraRenderView() == null) goto L13;
        Rect r101 = new Rect();
        this.f572441a.f572428b.f568057d.extraRenderController().curExtraRenderView().getGlobalVisibleRect(r101);
        return r101;
    L13:
        return null;
    }

    public h(f r100) {
        this.f572441a = r100;
    }
}
