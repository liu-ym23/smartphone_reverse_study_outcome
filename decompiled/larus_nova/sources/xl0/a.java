package xl0;

import android.view.View;
import com.bytedance.android.live.messagewindow.business.card.c;
import com.bytedance.android.live.messagewindow.business.card.d;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements k71.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f564432a = null;

    public a() {
    }

    static {
        f564432a = new a();
    }

    @Override // k71.a
    public final c a(DataCenter r100) {
        return new c(r100);
    }

    @Override // k71.a
    public final d b(DataCenter r100, View r101, CardTypeAndPriority r102) {
        Intrinsics.checkNotNullParameter(r101, "bannerContainerView");
        Intrinsics.checkNotNullParameter(r102, "cardTypeAndPriority");
        return new d(r100, r101, r102);
    }
}
