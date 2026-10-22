package ir3;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.annie.pro.ui.AnnieProActivity;
import com.bytedance.annie.pro.ui.AnnieProFragment;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;
import ne7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@XBridgeMethod(name = "annie.navigateTo", owner = "hsu.wang")
public final class b extends a {
    public b() {
    }

    public final void handle(IBDXBridgeContext r8, XBaseParamModel r9, CompletionBlock r10) {
        a.InterfaceC0138a r11 = (a.InterfaceC0138a) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Object r12 = r8.getOwnerActivity();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.annie.pro.ui.AnnieProActivity");
        Fragment r13 = ((AnnieProActivity) r12).getSupportFragmentManager().findFragmentById(2131362979);
        if ((r13 instanceof AnnieProFragment) == false) goto L5;
        AnnieProFragment r14 = (AnnieProFragment) r13;
    L6:
        String r15 = r11.getUrl();
        if (r15 == null) goto L29;
        if (r14 == null) goto L29;
        Intrinsics.checkNotNullParameter(r15, "relativePath");
        FragmentActivity r1 = r14.getActivity();
        if (r1 == null) goto L14;
        FragmentManager r2 = r1.getSupportFragmentManager();
        if (r2 == null) goto L14;
        FragmentTransaction r3 = r2.beginTransaction();
    L15:
        if (r3 == null) goto L17;
        r3.setCustomAnimations(2130772005, 2130772004, 2130772006, 2130772003);
    L17:
        if (r3 == null) goto L19;
        r3.hide(r14);
    L19:
        AnnieProFragment r16 = new AnnieProFragment();
        Bundle r4 = new Bundle();
        r4.putString("relative_path", r15);
        r16.setArguments(r4);
        if (r3 != null) goto L22;
    L27:
        if (r3 == null) goto L29;
        r3.commit();
        goto L29
    L22:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131362979) == false) goto L24;
        FragmentTransaction r17 = r3;
    L25:
        if (r17 == null) goto L27;
        r17.addToBackStack(null);
        goto L27
    L24:
        r17 = r3.add(2131362979, r16);
    L14:
        r3 = null;
    L29:
        CompletionBlock.DefaultImpls.onSuccess$default(r10, e.b(a.b.class), null, 2, null);
        return;
    L5:
        r14 = null;
        goto L6
    }
}
