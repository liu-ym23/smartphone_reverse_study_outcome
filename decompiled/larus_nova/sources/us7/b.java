package us7;

import android.content.Context;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.config.AndroidDocConfig;
import com.dtf.face.config.ProtocolContent;
import com.dtf.face.log.RecordService;
import com.dtf.face.verify.IFlowCheck;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements IFlowCheck {
    @Override // com.dtf.face.verify.IFlowCheck
    public final String getCurrentFlow() {
        ProtocolContent r100 = hs7.a.h().d();
        if (r100 == null) goto L7;
        r100.getCurrentProtocolName();
        return null;
    L7:
        return null;
    }

    public b() {
    }

    @Override // com.dtf.face.verify.IFlowCheck
    public final boolean gotoNextFlow(Context r110, String r111, String r112, Map<String, Object> r210) {
        ProtocolContent r100 = hs7.a.h().d();
        if (r100 == null) goto L20;
        boolean r101 = r100.hasNextProtocol();
        Object r102 = r100.getNextProtocol();
        String r103 = r100.getCurrentProtocolName();
        if (r102 == null) goto L16;
        RecordService.getInstance().recordEvent(2, "nextFlowRight", new String[]{"name", r103, "code", r111});
        if ((r102 instanceof AndroidDocConfig) == false) goto L12;
        if (hs7.a.h().m() == true) goto L22;
        return false;
    L22:
        return baseverify.d.b(r110, r210);
    L12:
        if ((r102 instanceof AndroidClientConfig) == true) goto L23;
        RecordService.getInstance().recordEvent(2, "nextFlowError", new String[]{"name", r103, "code", r111});
        hs7.a.h().a("Z1025", r111);
    L18:
        return true;
    L23:
        return baseverify.d.a(r110, r210);
    L16:
        if (r101 == false) goto L24;
        RecordService.getInstance().recordEvent(2, "nextFlowError", new String[]{"name", r103, "code", r111});
        hs7.a.h().a("Z1025", r111);
        goto L18
    L24:
        return false;
    L20:
        return false;
    }
}
