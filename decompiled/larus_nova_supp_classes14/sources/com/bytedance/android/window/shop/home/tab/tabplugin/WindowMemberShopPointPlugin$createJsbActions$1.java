package com.bytedance.android.window.shop.home.tab.tabplugin;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.window.shop.home.ECWindowActivity;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class WindowMemberShopPointPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public WindowMemberShopPointPlugin$createJsbActions$1(WindowMemberShopPointPlugin r8) {
        super(1, r8, WindowMemberShopPointPlugin.class, "handleCloseBanner", "handleCloseBanner(Lorg/json/JSONObject;)V", 0);
    }

    public final void invoke(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "p1");
        FragmentActivity r5 = l0.c(((WindowMemberShopPointPlugin) ((CallableReference) this).receiver).f);
        if ((r5 instanceof ECWindowActivity) == false) goto L5;
        r5.finish();
        return;
    L5:
        if (r5 == null) goto L33;
        FragmentManager r6 = r5.getSupportFragmentManager();
        if (r6 == null) goto L34;
        List r7 = r6.getFragments();
        if (r7 == null) goto L35;
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        Object r1 = r8.next();
        if ((r1 instanceof ECWindowDialogFragment) == false) goto L12;
        r0.add(r1);
        goto L12
    L16:
        ECWindowDialogFragment r9 = (ECWindowDialogFragment) CollectionsKt.firstOrNull(r0);
        if (r9 == null) goto L36;
        r9.dismissAllowingStateLoss();     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r10 = DialogFragmentLancet.sLastShowStack;
        if (r10 == null) goto L37;
        com.bytedance.crash.d.d(r10, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
