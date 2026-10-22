package ql1;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.PanelType;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.SelectDanmuEmojiPresenter;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import lm1.e;
import yr1.f;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PanelType f533712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f533713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f533714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f533715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f533716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f533717f;

    public final Context getContext() {
        return this.f533715d;
    }

    public final View a(SelectDanmuEmojiPresenter r100) {
        Intrinsics.checkNotNullParameter(r100, "panelContext");
        if (this.f533713b == true) goto L19;
        this.f533713b = true;
        d r101 = this.f533717f;
        e r102 = new e(r101.f533721d);
        int r103 = r101.f533720c;
        View r104 = null;
        if (r103 != 1) goto L8;
        a r105 = new a(this, r100);
        f r106 = r.e();
        Context r107 = this.f533715d;
        d r108 = this.f533717f;
        View r109 = r106.f(r107, r108.f533718a, r108.f533719b, r102, r105);
        if (r109 == null) goto L17;
        r100.n();
        Unit r110 = Unit.INSTANCE;
        r104 = r109;
    L17:
        this.f533714c = r104;
        goto L19
    L8:
        if (r103 != 2) goto L19;
        b r111 = new b(this, r100);
        f r112 = r.e();
        Context r113 = this.f533715d;
        d r114 = this.f533717f;
        View r115 = r112.f(r113, r114.f533718a, r114.f533719b, r102, r111);
        if (r115 == null) goto L13;
        r100.n();
        Unit r116 = Unit.INSTANCE;
        r104 = r115;
    L13:
        this.f533714c = r104;
    L19:
        return this.f533714c;
    }

    public c(Context r100, DataCenter r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "providerParam");
        this.f533715d = r100;
        this.f533716e = r101;
        this.f533717f = r102;
        this.f533712a = PanelType.EMOJI;
    }
}
