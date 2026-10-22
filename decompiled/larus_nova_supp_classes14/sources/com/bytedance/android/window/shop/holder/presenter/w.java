package com.bytedance.android.window.shop.holder.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.o0;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.router.WindowEntranceInfoExtKt;
import com.bytedance.android.window.shop.router.WindowEntranceInfoScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ WindowReplayStructElementPresenter a;
    public final /* synthetic */ sq3.h b;
    public final /* synthetic */ uq3.s c;

    public w(WindowReplayStructElementPresenter r1, sq3.h r2, uq3.s r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        Integer r12 = (Integer) ((WindowV2ProductItemVO) this.b).C.a(wn.a.C);
        if (r12 == null) goto L5;
        int r13 = r12.intValue();
    L6:
        String r14 = "a1.b7635.c68164.d15552_i" + r13;
        int r0 = zq3.f.a;
        WindowReplayStructElementPresenter r1 = this.a;
        String r2 = this.c.a;
        QContext r3 = r1.u();
        Activity r4 = l0.c(r3.c());
        String r5 = null;
        if ((r4 instanceof FragmentActivity) == true) goto L9;
        r4 = null;
    L9:
        if (r4 != null) goto L14;
        Context r6 = r3.c();
        if ((r6 instanceof FragmentActivity) == true) goto L13;
        r6 = null;
    L13:
        r4 = (FragmentActivity) r6;
    L14:
        if (r4 == null) goto L36;
        JSONObject r7 = xn.c.c(r4);
        if (r7 == null) goto L36;
        String r8 = r7.toString();
        com.bytedance.commerce.base.json.a[] r9 = new com.bytedance.commerce.base.json.a[7];
        r9[0] = JsonDslUtilKt.d("tab_name", r1.E().getLastCategoryId());
        r9[1] = JsonDslUtilKt.d("ecom_entrance_form", r1.E().getLastCategoryId());
        String r10 = r1.E().getLastSubCategoryId();
        String r15 = "";
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        r9[2] = JsonDslUtilKt.d("tab_name_second", r10);
        String r16 = r1.E().getLastSubCategoryId();
        if (r16 != null) goto L24;
        r16 = "";
    L24:
        r9[3] = JsonDslUtilKt.d("ecom_entrance_form_second", r16);
        String r17 = r1.E().getCategoryName();
        if (r17 != null) goto L27;
        r17 = "";
    L27:
        r9[4] = JsonDslUtilKt.d("classification_tab", r17);
        r9[5] = JsonDslUtilKt.d("classification_tab_id", r1.E().getLastCategoryId());
        String r18 = r1.E().getLastSubCategoryId();
        if (r18 == null) goto L31;
        r15 = r18;
    L31:
        r9[6] = JsonDslUtilKt.d("classification_sub_tab_id", r15);
        x0.b(r7, JsonDslUtilKt.a(r9), false);
        WindowEntranceInfoScene r19 = WindowEntranceInfoScene.ENTER_REPLAY;
        Set<WindowEntranceInfoScene> r20 = WindowEntranceInfoExtKt.a;
        Intrinsics.checkNotNullParameter(r7, "$this$doPostEntranceInfoStringCheck");
        Intrinsics.checkNotNullParameter(r19, "scene");
        gl.a r21 = WindowEntranceInfoExtKt.b(r7, r19, r8);
        if (r21 != null) goto L34;
        String r22 = r7.toString();
    L35:
        o0 r23 = new o0(r2);
        r23.b("entrance_info", r22);
        r2 = r23.c();
        goto L36
    L34:
        r22 = r21.h();
    L36:
        PageFinder r24 = PageFinder.via(this.a.j);
        ECWindowViewModel r25 = (ECWindowViewModel) this.a.g.getValue();
        if (r25 == null) goto L41;
        ECWindowParam r26 = r25.getShopParam();
        if (r26 == null) goto L41;
        r5 = r26.getAuthorId();
    L41:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.y().getContext(), zq3.f.c(r2, r14, r24, zq3.f.a(r5, this.b)));
        this.a.F("to_watch_explain_click", r14);
        return;
    L5:
        r13 = -1;
        goto L6
    }
}
