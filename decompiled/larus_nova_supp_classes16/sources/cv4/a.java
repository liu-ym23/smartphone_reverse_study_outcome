package cv4;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentPlugin;
import com.bytedance.ee.bear.bitable.superagent.cardexpand.CardExpandPanel;
import com.bytedance.ee.bear.bitable.superagent.p;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends XCoreBridgeMethod {
    public final FragmentManager a;
    public final p b;
    public final String c;

    public final String getName() {
        return this.c;
    }

    public a(FragmentManager r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "fm");
        this.a = r2;
        this.b = r3;
        this.c = "bitable.superAgent.openCardExpand";
    }

    public final void handle(XReadableMap r12, XBridgeMethod.Callback r13, XBridgePlatformType r14) {
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Intrinsics.checkNotNullParameter(r14, "type");
        if (this.a.isStateSaved() == false) goto L6;
        XCoreBridgeMethod.onFailure$default(this, r13, 0, "fragmentManager stateSaved", null, 8, null);
        return;
    L6:
        String r16 = s.f(r12, "data", "");
        boolean r1 = false;
        if (r16.length() != 0) goto L9;
        boolean r17 = true;
    L10:
        if (r17 == false) goto L32;
        XCoreBridgeMethod.onFailure$default(this, r13, 0, "fragmentManager stateSaved", null, 8, null);
        return;
    L32:
        JSONObject r18 = new JSONObject(r16);     // Catch: Exception -> L28
        if (this.a.findFragmentByTag("CardExpandPanel") == null) goto L17;
        r1 = true;
    L17:
        j.e(BitableSuperAgentPlugin.TAG, "CardExpandHandler: ENTER, existing=" + r1);
        if (r1 == false) goto L21;
        XCoreBridgeMethod.onFailure$default(this, r13, 0, "panel already shown", null, 8, null);
        return;
    L21:
        CardExpandPanel r19 = new CardExpandPanel();
        r19.ga0(this.b);
        r19.da0(r18);
        FragmentManager r110 = this.a;
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, "CardExpandPanel", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r19, r0) == false) goto L34;
    L26:
        XCoreBridgeMethod.onSuccess$default(this, r13, new LinkedHashMap(), null, 4, null);
        return;
    L34:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L25:
        r19.show(r110, "CardExpandPanel");
    L28:
        e = move-exception;
        j.g(BitableSuperAgentPlugin.TAG, "OpenCardExpand: parse json failed", e);
        XCoreBridgeMethod.onFailure$default(this, r13, 0, "invalid json", null, 8, null);
        return;
    L9:
        r17 = false;
        goto L10
    }
}
