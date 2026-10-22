package com.bytedance.android.window.shop.innerflow.holder.element.presenter;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout;
import com.bytedance.android.ec.window.base.repository.dto.s;
import com.bytedance.android.ec.window.base.repository.dto.t;
import com.bytedance.android.ec.window.base.repository.vo.ContainerType;
import com.bytedance.android.window.shop.innerflow.repo.ECWindowInnerFlowComponentDTO;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ECWindowInnerFlowFloatLynxPresenter a;

    public f(ECWindowInnerFlowFloatLynxPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r18) {
        ECWindowInnerFlowComponentDTO r1 = (ECWindowInnerFlowComponentDTO) r18;
        if (r1.getStatusCode() != 0) goto L121;
        com.bytedance.android.window.shop.innerflow.repo.c r2 = new com.bytedance.android.window.shop.innerflow.repo.c();
        if (r1.getComponents() == null) goto L13;
        List<s> r3 = r1.getComponents();
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        s r6 = (s) r5.next();
        int r7 = com.bytedance.android.ec.window.base.repository.vo.d.a;
        r4.add(com.bytedance.android.ec.window.base.repository.vo.d.a.a(r6));
        goto L10
    L12:
        r2.a = r4;
    L13:
        Map r8 = ECWindowInnerFlowFloatLynxPresenter.E(this.a);
        List<com.bytedance.android.ec.window.base.repository.vo.d> r9 = r2.a;
        if (r9 == null) goto L101;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L16:
        int r13 = 1;
        char r14 = 0;
        if (r11.hasNext() == false) goto L24;
        T r12 = r11.next();
        if (((com.bytedance.android.ec.window.base.repository.vo.d) r12).b() == ContainerType.FLOAT_LYNX_CONTAINER.getType()) goto L22;
        r13 = 0;
    L22:
        if (r13 == 0) goto L16;
        r10.add(r12);
        goto L16
    L24:
        Iterator r15 = r10.iterator();
    L26:
        if (r15.hasNext() == false) goto L122;
        final com.bytedance.android.ec.window.base.repository.vo.d r16 = (com.bytedance.android.ec.window.base.repository.vo.d) r15.next();
        ECWindowInnerFlowFloatLynxPresenter r17 = this.a;
        r17.getClass();
        List r19 = r16.f();
        String r110 = null;
        if (r19 == null) goto L43;
        Iterator<T> r20 = r19.iterator();
    L31:
        if (r20.hasNext() == false) goto L41;
        T r21 = r20.next();
        Integer r22 = ((t) r21).a();
        if (r22 != null) goto L36;
    L38:
        boolean r23 = false;
    L39:
        if (r23 == false) goto L31;
    L42:
        t r24 = (t) r21;
    L44:
        List r25 = r16.f();
        if (r25 == null) goto L60;
        Iterator<T> r26 = r25.iterator();
    L48:
        if (r26.hasNext() == false) goto L58;
        T r27 = r26.next();
        Integer r28 = ((t) r27).a();
        if (r28 != null) goto L53;
    L55:
        boolean r29 = false;
    L56:
        if (r29 == false) goto L48;
    L59:
        t r30 = (t) r27;
    L61:
        if (r24 != null) goto L67;
        if (r30 != null) goto L67;
        final Context r31 = r17.u().c();
        Fragment r32 = r17.u().a;
        if ((r32 instanceof DialogFragment) == true) goto L66;
        r32 = null;
    L66:
        final DialogFragment r33 = (DialogFragment) r32;
        final JSONObject r34 = z1.g(r16.c());
        final String r35 = r16.e();
        WindowFloatLayout r36 = new ECWindowInnerFlowFloatLynxPresenter$createDefaultFloatLayout$storeFloatLayout$1(r16, r31, r33, r34, r35);
        String r37 = r16.d();
        Pair[] r38 = new Pair[2];
        r38[r14] = TuplesKt.to("metaInfo", r8);
        r38[r13] = TuplesKt.to("data", r16.c());
        r36.e(r37, MapsKt.mapOf(r38), null);
    L100:
        r13 = 1;
        r14 = 0;
    L67:
        String r39 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (r24 == null) goto L70;
        Integer r40 = r24.c();
    L72:
        if (r40 != null) goto L75;
    L77:
        String r111 = r39;
    L78:
        if (r30 == null) goto L80;
        Integer r41 = r30.c();
    L81:
        if (r41 != null) goto L84;
    L86:
        String r112 = r39;
    L87:
        if (r24 == null) goto L89;
        String r42 = r24.d();
    L90:
        Intrinsics.checkNotNullParameter("innerFlow", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r42 != null) goto L93;
        String r43 = "innerFlow";
    L94:
        if (r30 == null) goto L96;
        r110 = r30.d();
    L96:
        Intrinsics.checkNotNullParameter("innerFlow", CommentConstants$CmtLongPanelStrategy.DEFAULT);
        if (r110 != null) goto L99;
        r110 = "innerFlow";
    L99:
        jo.a r44 = jo.a.a;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(jo.a.b(r16.e(), r.a.f(), r111)).subscribe(new e(r17, r43, r110, r24, r30, r16, r111, r112, r8)), r17.G());
        goto L100
    L93:
        r43 = r42;
        goto L94
    L89:
        r42 = null;
        goto L90
    L84:
        if (r41.intValue() != 0) goto L86;
        r112 = "all";
        goto L87
    L80:
        r41 = null;
        goto L81
    L75:
        if (r40.intValue() != 0) goto L77;
        r111 = "all";
        goto L78
    L70:
        r40 = null;
        goto L72
    L53:
        if (r28.intValue() != r13) goto L55;
        r29 = true;
        goto L56
    L58:
        r27 = null;
        goto L59
    L60:
        r30 = null;
        goto L61
    L36:
        if (r22.intValue() != 0) goto L38;
        r23 = true;
        goto L39
    L41:
        r21 = null;
        goto L42
    L43:
        r24 = null;
        goto L44
    L122:
        return;
    L101:
        return;
    }
}
