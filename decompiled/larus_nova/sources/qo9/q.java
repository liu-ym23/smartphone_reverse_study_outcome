package qo9;

import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class q implements va8.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f534321a;

    @Override // va8.j
    public final void a(va8.f r100, va8.h r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "current");
    }

    public q(o r100) {
        this.f534321a = r100;
    }

    @Override // va8.j
    public final FloatChatWindowState b(va8.f r100, va8.h r101, FloatChatWindowState r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "current");
        Intrinsics.checkNotNullParameter(r102, "defaultTarget");
        boolean r103 = false;
        if (r100.getType() == FloatChatWindowEventType.ManualDragDown) goto L5;
    L19:
        if (r103 == false) goto L22;
        FLogger.f375446a.i("OfficeChatWindow", "回答进行中，手势下拉从 Expanded 收敛到 Preview");
        return FloatChatWindowState.Preview;
    L22:
        return r102;
    L5:
        if (r101.f553966a != FloatChatWindowState.Expanded) goto L19;
        com.larus.office.plugins.inputv2.adapter.g r104 = this.f534321a.f534309k;
        if (r104 == null) goto L16;
        ew8.b r105 = (ew8.b) r104.e(ew8.b.class);
        if (r105 != null) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 != true) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        r103 = true;
        goto L19
    L11:
        if (r105.ef() != true) goto L13;
        r106 = true;
    L16:
        r107 = false;
        goto L17
    }
}
