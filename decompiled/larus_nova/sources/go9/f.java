package go9;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.office.plugins.aiedit.AIEditPlugin;
import com.larus.office.plugins.aiedit.SelectChangeData;
import com.larus.office.plugins.input.m1;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes30.dex */
public final class f implements i<SelectChangeData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AIEditPlugin f481947a;

    public static final class a {
    }

    static {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public f(AIEditPlugin r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        this.f481947a = r100;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        SelectChangeData r102 = (SelectChangeData) r100;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("Selected text changed, text length: ");
        String r105 = null;
        if (r102 == null) goto L7;
        String r106 = r102.getText();
        if (r106 == null) goto L7;
        Integer r107 = Integer.valueOf(r106.length());
    L8:
        r104.append(r107);
        r103.i("DocSelectionChangeHandler", r104.toString());
        this.f481947a.updateSelectedData(r102);
        String r108 = this.f481947a.getCachedSelectedText();
        if (r102 == null) goto L11;
        String r109 = r102.getText();
    L13:
        if (Intrinsics.areEqual(r108, r109) == true) goto L30;
        AIEditPlugin r110 = this.f481947a;
        if (r102 == null) goto L17;
        String r111 = r102.getText();
    L18:
        if (r102 == null) goto L20;
        String r112 = r102.getWholeText();
    L21:
        r110.updateSelectedText(r111, r112);
        m1 r113 = this.f481947a.findDocxAIChatContract$impl_mainlandRelease();
        if (r113 == null) goto L31;
        if (r102 == null) goto L25;
        String r114 = r102.getPlainText();
    L26:
        if (r102 == null) goto L28;
        r105 = r102.getWholeText();
    L28:
        r113.onSelectionChanged(r114, r105);
        return;
    L25:
        r114 = null;
        goto L26
    L31:
        return;
    L20:
        r112 = null;
        goto L21
    L17:
        r111 = null;
        goto L18
    L30:
        return;
    L11:
        r109 = null;
    L7:
        r107 = null;
        goto L8
    }
}
