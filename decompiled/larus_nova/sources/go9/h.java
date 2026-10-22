package go9;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.office.plugins.aiedit.AIEditPlugin;
import com.larus.office.plugins.input.s1;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes30.dex */
public final class h implements i<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AIEditPlugin f481949a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public h(AIEditPlugin r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        this.f481949a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        String r102 = (String) r100;
        FLogger.f375446a.i("SlidesSelectionChangeHandler", "Got slides selection change data: " + r102);
        s1 r103 = this.f481949a.findSlidesAIChatContract$impl_mainlandRelease();
        if (r103 == null) goto L6;
        r103.onSlidesSelectionChanged(r102);
        return;
    }
}
