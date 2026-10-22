package r62;

import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewV2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements ChannelTrayListViewBinder.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelTrayListViewV2 f536326a;

    public a(ChannelTrayListViewV2 r100) {
        this.f536326a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewBinder.a
    public final void a(p62.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        r100.f527875j = System.currentTimeMillis();
        Function1<p62.a, Unit> r101 = this.f536326a.getTrayClickCallback();
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(r100);
        return;
    }
}
