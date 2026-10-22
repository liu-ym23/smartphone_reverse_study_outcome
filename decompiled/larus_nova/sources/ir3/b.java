package ir3;

import android.app.Activity;
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
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.nova.R;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;
import ne7.e;

/* JADX INFO: loaded from: classes14.dex */
@XBridgeMethod(name = "annie.navigateTo", owner = "hsu.wang")
public final class b extends a {
    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        a.InterfaceC6352a r102 = (a.InterfaceC6352a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Activity r103 = r100.getOwnerActivity();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.annie.pro.ui.AnnieProActivity");
        Fragment r104 = ((AnnieProActivity) r103).getSupportFragmentManager().findFragmentById(R.id.annie_pro_fragment_container);
        if ((r104 instanceof AnnieProFragment) == false) goto L5;
        Fragment r105 = (AnnieProFragment) r104;
    L6:
        String r106 = r102.getUrl();
        if (r106 == null) goto L29;
        if (r105 == null) goto L29;
        Intrinsics.checkNotNullParameter(r106, "relativePath");
        FragmentActivity r107 = r105.getActivity();
        if (r107 == null) goto L14;
        FragmentManager r108 = r107.getSupportFragmentManager();
        if (r108 == null) goto L14;
        FragmentTransaction r109 = r108.beginTransaction();
    L15:
        if (r109 == null) goto L17;
        r109.setCustomAnimations(R.anim.anim_x_100_to_0, R.anim.anim_x_0_to_m100, R.anim.anim_x_m100_to_0, R.anim.anim_x_0_to_100);
    L17:
        if (r109 == null) goto L19;
        r109.hide(r105);
    L19:
        AnnieProFragment r111 = new AnnieProFragment();
        Bundle r112 = new Bundle();
        r112.putString(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r106);
        r111.setArguments(r112);
        if (r109 != null) goto L22;
    L27:
        if (r109 == null) goto L29;
        r109.commit();
        goto L29
    L22:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r109, r111, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.annie_pro_fragment_container) == false) goto L24;
        FragmentTransaction r113 = r109;
    L25:
        if (r113 == null) goto L27;
        r113.addToBackStack(null);
        goto L27
    L24:
        r113 = r109.add(R.id.annie_pro_fragment_container, r111);
    L14:
        r109 = null;
    L29:
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) e.b(a.b.class), null, 2, null);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
