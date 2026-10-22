package lq1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.view.IReplayWidgetView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a<T extends IReplayWidgetView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f510284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f510285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f510286c;

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        this.f510285b = null;
        if ((this instanceof l) == false) goto L7;
        d r100 = this.f510286c;
        if (r100 == null) goto L7;
        r100.removeMessageListener((l) this);
    L7:
        this.f510284a = null;
    }

    public final void e(T r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f510284a = r100;
        DataCenter r101 = r100.getDataCenter();
        this.f510285b = r101;
        if (r101 == null) goto L5;
        d r102 = (d) r101.get("data_message_manager");
    L6:
        this.f510286c = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
