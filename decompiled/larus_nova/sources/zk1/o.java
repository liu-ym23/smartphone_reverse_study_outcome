package zk1;

import android.animation.ObjectAnimator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayListCacheWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements ReplayActionSheet.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayListCacheWidget f572606a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet.a
    public final void onDismiss() {
        ReplayListCacheWidget r100 = this.f572606a;
        r100.getClass();
        com.bytedance.android.livesdk.f.d().a();
        if (ReplayListCacheWidget.xq() == false) goto L5;
        String r101 = LiveDegradeFpsAnimator.TRANSLATION_Y;
    L7:
        if (ReplayListCacheWidget.xq() == false) goto L9;
        float r102 = r100.f108160a;
    L10:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100.contentView.findViewById(R.id.vs_cache_content), r101, new float[]{r102, 0.0f});
        r103.setDuration(200);
        r103.start();
        ReplayListCacheWidget.a r104 = r100.f108163d;
        if (r104 == null) goto L14;
        r104.a();
        return;
    L14:
        return;
    L9:
        r102 = r100.f108161b;
        goto L10
    L5:
        r101 = LiveDegradeFpsAnimator.TRANSLATION_X;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet.a
    public final void onShow() {
        ReplayListCacheWidget r100 = this.f572606a;
        r100.getClass();
        if (ReplayListCacheWidget.xq() == false) goto L5;
        String r101 = LiveDegradeFpsAnimator.TRANSLATION_Y;
    L7:
        if (ReplayListCacheWidget.xq() == false) goto L9;
        float r102 = r100.f108160a;
    L10:
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r100.contentView.findViewById(R.id.vs_cache_content), r101, new float[]{0.0f, r102});
        r103.setDuration(200);
        r103.start();
        ReplayListCacheWidget.a r104 = r100.f108163d;
        if (r104 == null) goto L14;
        r104.c();
        return;
    L14:
        return;
    L9:
        r102 = r100.f108161b;
        goto L10
    L5:
        r101 = LiveDegradeFpsAnimator.TRANSLATION_X;
        goto L7
    }

    public o(ReplayListCacheWidget r100) {
        this.f572606a = r100;
    }
}
