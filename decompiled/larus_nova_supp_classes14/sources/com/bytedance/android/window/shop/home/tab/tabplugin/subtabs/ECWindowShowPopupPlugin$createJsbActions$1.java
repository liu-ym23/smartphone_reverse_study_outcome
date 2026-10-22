package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.widget.popup.WindowPopupWindowManager;
import dr3.f;
import dr3.h;
import er3.c;
import er3.d;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowShowPopupPlugin$createJsbActions$1 extends FunctionReferenceImpl implements Function1<JSONObject, Unit> {
    public ECWindowShowPopupPlugin$createJsbActions$1(ECWindowShowPopupPlugin r8) {
        super(1, r8, ECWindowShowPopupPlugin.class, "onReceivePopupEvent", "onReceivePopupEvent(Lorg/json/JSONObject;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.ArrayList] */
    public final void invoke(JSONObject r12) {
        Intrinsics.checkNotNullParameter(r12, "p1");
        ECWindowShowPopupPlugin r0 = (ECWindowShowPopupPlugin) ((CallableReference) this).receiver;
        if (ECWindowJsbPlugin.g(r12, r0.c) == false) goto L90;
        View r1 = r0.b.findViewWithTag(r12.optString("target"));
        if (r1 != null) goto L8;
        r1 = r0.d;
    L8:
        JSONObject r2 = r12.optJSONObject("popup");
        if (r2 == null) goto L91;
        WindowPopupWindowManager.PopupPosition.a r3 = WindowPopupWindowManager.PopupPosition.Companion;
        String r13 = r12.optString("position");
        r3.getClass();
        Intrinsics.checkNotNullParameter(r13, "desc");
        WindowPopupWindowManager.PopupPosition r14 = (WindowPopupWindowManager.PopupPosition) WindowPopupWindowManager.PopupPosition.access$getMap$cp().get(r13);
        if (r14 == null) goto L92;
        er3.b r4 = (er3.b) u0.b(r2.toString(), er3.b.class);
        if (r4 == null) goto L93;
        int r5 = f.e;
        Intrinsics.checkNotNullParameter(r4, "groupDto");
        c r6 = r4.b();
        f r7 = null;
        if (r6 == null) goto L20;
        fr3.a<?> r8 = r6.b();
    L22:
        if ((r8 instanceof fr3.a.c) == true) goto L24;
        r8 = null;
    L24:
        fr3.a.c r9 = (fr3.a.c) r8;
        if (r9 == null) goto L70;
        List<c> r10 = r4.a();
        if (r10 == null) goto L70;
        ArrayList r11 = new ArrayList();
        Iterator r15 = r10.iterator();
    L31:
        if (r15.hasNext() == false) goto L60;
        c r16 = (c) r15.next();
        int r17 = dr3.b.a;
        List<er3.f> r18 = r16.a();
        if (r18 == null) goto L40;
        int r19 = d.b;
        ?? r20 = new ArrayList();
        Iterator r21 = r18.iterator();
    L36:
        if (r21.hasNext() == false) goto L41;
        d r110 = d.b.a((er3.f) r21.next());
        if (r110 == null) goto L36;
        r20.add(r110);
    L41:
        fr3.a<?> r22 = r16.b();
        Intrinsics.checkNotNullParameter(r20, "actions");
        if (r22 != null) goto L45;
    L55:
        Disposable r23 = null;
    L56:
        if (r23 == null) goto L31;
        r11.add(r23);
        goto L31
    L45:
        if ((r22 instanceof fr3.a.b) == false) goto L48;
        r23 = new dr3.c((fr3.a.b) r22);
        goto L56
    L48:
        if ((r22 instanceof fr3.a.g) == false) goto L51;
        r23 = new h(r20, (fr3.a.g) r22);
        goto L56
    L51:
        if ((r22 instanceof fr3.a.e) == false) goto L54;
        r23 = new dr3.d(r20, (fr3.a.e) r22);
        goto L56
    L54:
        if ((r22 instanceof fr3.a.c) == true) goto L55;
        throw new NoWhenBranchMatchedException();
    L40:
        r20 = CollectionsKt.emptyList();
        goto L41
    L60:
        List<er3.f> r24 = r4.b().a();
        if (r24 == null) goto L68;
        int r25 = d.b;
        ?? r26 = new ArrayList();
        Iterator r27 = r24.iterator();
    L64:
        if (r27.hasNext() == false) goto L69;
        d r28 = d.b.a((er3.f) r27.next());
        if (r28 == null) goto L64;
        r26.add(r28);
    L69:
        r7 = new f(r26, r9, r11);
        goto L70
    L68:
        r26 = CollectionsKt.emptyList();
    L70:
        if (r7 == null) goto L94;
        int r29 = WindowPopupWindowManager.a;
        WindowPopupWindowManager.a(r1, r7, r0.e, r14);
        return;
    L94:
        return;
    L20:
        r8 = null;
        goto L22
    L93:
        return;
    L92:
        return;
    L91:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((JSONObject) r1);
        return Unit.INSTANCE;
    }
}
