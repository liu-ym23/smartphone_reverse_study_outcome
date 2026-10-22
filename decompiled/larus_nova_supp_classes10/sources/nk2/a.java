package nk2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends QUIModule {
    public final LiveRoomParams l;

    public final QIPresenter h() {
        return new com.bytedance.android.livesdk.livecommerce.room.widgets.info_card.presenter.a(this.l);
    }

    public a(LiveRoomParams r2) {
        super(0);
        this.l = r2;
    }

    public final View f(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        FrameLayout r4 = new FrameLayout(r2);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        return r4;
    }
}
