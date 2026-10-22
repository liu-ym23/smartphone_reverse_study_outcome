package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BaseFirstLevelTabManager a;
    public final /* synthetic */ List b;
    public final /* synthetic */ TabLayout c;
    public final /* synthetic */ FragmentActivity d;
    public final /* synthetic */ Function0 e;

    public a(BaseFirstLevelTabManager r1, List r2, TabLayout r3, FragmentActivity r4, Function0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        TabLayout r6 = this.c;
        if (r6 == null) goto L5;
        int r7 = r6.getSelectedTabPosition();
    L7:
        if (r7 >= this.b.size()) goto L32;
        if (r7 < 0) goto L34;
        BaseFirstLevelTabManager r0 = this.a;
        int r8 = ((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) ListProtector.get(this.b, r7)).VL().getValue();
        int r1 = BaseFirstLevelTabManager.o;
        r0.getClass();
        if (r8 != FirstLevelTab.OrderedSongTab.getValue()) goto L14;
        String r9 = "banner_ready";
    L17:
        pb0.a r2 = pb0.b.a;
        String r3 = k.n(IMiddlewareUserService.class).user().n().toString().toString();
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        pb0.a r4 = pb0.b.a;
        if (r4 == null) goto L20;
        r4.c(r3, r9);
    L20:
        Long r10 = KtvLoggerHelper.a;
        String r11 = KtvLoggerHelper.H(j.c());
        String r12 = com.bytedance.android.live.ktv.common.util.f.a;
        String r13 = j.d();
        Intrinsics.checkNotNullParameter(r13, "liveType");
        Intrinsics.checkNotNullParameter(r11, "functionType");
        JSONObject r14 = new JSONObject();
        r14.put("live_type", r13);
        r14.put("function_type", r11);
        if (KtvSettingHelper.t() == false) goto L26;
        r14.put("first_level_tab_ser", FirstLevelTab.RealTimeChorusTab.getValue());     // Catch: Exception -> L25
    L26:
        k.n(IMiddlewareRoomService.class).actionHandler().handle(this.d, "sslocal://webcast_enter_solo_ktv?source=" + r9 + "&source_params=" + r14.toString());
        Function0 r15 = this.e;
        if (r15 == null) goto L33;
        Unit r16 = (Unit) r15.invoke();
        return;
    L33:
        return;
    L14:
        if (r8 != FirstLevelTab.OrderSongTab.getValue()) goto L16;
        r9 = "banner_order";
        goto L17
    L16:
        r9 = "";
        goto L17
    L34:
        return;
    L32:
        return;
    L5:
        r7 = FirstLevelTab.Unknown.getValue();
        goto L7
    }
}
