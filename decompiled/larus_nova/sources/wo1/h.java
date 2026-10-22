package wo1;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.n;
import com.bytedance.android.live.browser.jsbridge.base.LiveLoadShortTouchBigCardResultModel;
import com.bytedance.android.livesdk.chatroom.view.CommonIconEntryView;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.m;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.p;
import com.bytedance.android.livesdkapi.sti.framework.IIconModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.a3;
import w20.va;

/* JADX INFO: loaded from: classes8.dex */
public final class h extends a3<va, LiveLoadShortTouchBigCardResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f560508a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public h(p r100) {
        Intrinsics.checkNotNullParameter(r100, "commonIconModel");
        this.f560508a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        va r112 = (va) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        p r113 = this.f560508a;
        if (r113 == null) goto L14;
        g r100 = new g(this);
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r100, "listener");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r100, "listener");
        Integer r101 = r112.getType();
        int r102 = r113.f115554q.type;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.intValue() != r102) goto L15;
        n r103 = r113.f115554q;
        r103.payload = r112.a();
        com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a r114 = new com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.a(r113.getContext(), r113.f115554q, r113.f115555r);
        r113.f115543f = r114;
        CommonIconEntryView r104 = r114.a();
        if (r104 == null) goto L12;
        new IIconModel.EntryView(r104, 500 + r113.f115554q.shortTouchBigCard.duration, false, 4, null);
    L12:
        new Handler(Looper.getMainLooper()).postDelayed(new m(r113, r100), 200);
        return;
    L15:
        return;
    }
}
