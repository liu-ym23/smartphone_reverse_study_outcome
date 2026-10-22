package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.event.x0;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "tab_resort", description = "商列tab重排", service = {"LiveList"})
public final class LiveListTabResortAbility extends com.bytedance.android.livesdk.livecommerce.ability.d<Bundle> {
    public String a;
    public final Lazy b;
    public volatile String c;
    public volatile long d;

    public final Map<String, String> c() {
        int r1 = ECSdk.a;     // Catch: Exception -> L7
        pg.c r2 = (pg.c) ECSdk.a(pg.c.class);     // Catch: Exception -> L7
        if (r2 == null) goto L6;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L7
        r3.put("category_level", 32);     // Catch: Exception -> L7
        r3.put("click_score", Float.valueOf(d().c()));     // Catch: Exception -> L7
        r3.put("consecutive_click_score", Float.valueOf(d().d()));     // Catch: Exception -> L7
        r3.put("add_to_cart_score", Float.valueOf(d().b()));     // Catch: Exception -> L7
        r3.put("seq_length", d().f());     // Catch: Exception -> L7
        Unit r4 = Unit.INSTANCE;     // Catch: Exception -> L7
        r2.b();     // Catch: Exception -> L7
    L6:
        return null;
    L7:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }

    public final yh.a d() {
        return (yh.a) this.b.getValue();
    }

    public LiveListTabResortAbility() {
        this.b = LazyKt.lazy(LiveListTabResortAbility$tabConfig$2.INSTANCE);
    }

    public final void g() {
        if (d().e() != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        dm.a.a("LiveListTabResortAbility").i("updateRequestCategoryName: enable_ecom_tab_sort != 2 so return");
        return;
    L9:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new LiveListTabResortAbility$updateRequestCategoryName$1(this, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static boolean e(PromotionCategory r2) {
        if (r2.isAllTab() == false) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getCategoryType(), PromotionCategory.CATEGORY_TYPE_FRONT) == false) goto L7;
    L10:
        return true;
    L7:
        if (Intrinsics.areEqual(r2.getCategoryType(), "1") == true) goto L10;
        if (Intrinsics.areEqual(r2.getCategoryType(), PromotionCategory.CATEGORY_TYPE_SECOND) == false) goto L11;
        goto L10
    }

    public final List<PromotionCategory> f(List<PromotionCategory> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "categories");
        Iterator<T> r0 = r8.iterator();
    L3:
        int r2 = 0;
        if (r0.hasNext() == false) goto L7;
        ((PromotionCategory) r0.next()).setResorted(false);
        goto L3
    L7:
        if (r9 == true) goto L9;
    L24:
        String r10 = this.a;
        if (r10 != null) goto L27;
    L30:
        boolean r11 = true;
    L31:
        if (r11 == false) goto L33;
        return r8;
    L33:
        Iterator<T> r12 = r8.iterator();
    L35:
        if (r12.hasNext() == false) goto L44;
        Object r1 = r12.next();
        PromotionCategory r3 = (PromotionCategory) r1;
        if (Intrinsics.areEqual(r3.getName(), this.a) == true) goto L39;
    L41:
        boolean r4 = false;
    L42:
        if (r4 == false) goto L35;
    L45:
        PromotionCategory r5 = (PromotionCategory) r1;
        if (r5 != null) goto L48;
        return r8;
    L48:
        List<PromotionCategory> r13 = CollectionsKt.toMutableList(r8);
        r13.remove(r5);
        Iterator<PromotionCategory> r6 = r13.iterator();
    L50:
        if (r6.hasNext() == false) goto L55;
        if (e(r6.next()) == true) goto L56;
        r2 = r2 + 1;
    L56:
        if (r2 < 0) goto L74;
        ListProtector.add(r13, r2, r5);
        r5.setResorted(true);
        return r13;
    L74:
        return r8;
    L55:
        r2 = -1;
        goto L56
    L39:
        if (e(r3) == false) goto L41;
        r4 = true;
        goto L42
    L44:
        r1 = null;
        goto L45
    L27:
        if (r10.length() == 0) goto L30;
        r11 = false;
        goto L31
    L9:
        if (d().e() == 1) goto L11;
        int r14 = ECExceptionMonitor.a;
        ECExceptionMonitor.h("enable_ecom_tab_sort !=1 so return");
        dm.a.a("LiveListTabResortAbility").i("enable_ecom_tab_sort !=1 so return");
        goto L24
    L11:
        ArrayList r7 = new ArrayList();
        Iterator<T> r15 = r8.iterator();
    L13:
        if (r15.hasNext() == false) goto L18;
        Object r16 = r15.next();
        if (e((PromotionCategory) r16) == false) goto L13;
        r7.add(r16);
        goto L13
    L18:
        if (r7.isEmpty() == false) goto L59;
        dm.a.a("LiveListTabResortAbility").i("canResortList is null, so return");
        goto L24
    L59:
        c();     // Catch: Exception -> L22
        int r17 = ECExceptionMonitor.a;     // Catch: Exception -> L22
        ECExceptionMonitor.h("无策略结果直接返回");     // Catch: Exception -> L22
        dm.a.a("LiveListTabResortAbility").i("无策略结果直接返回");     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L24
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r1, Bundle r2, Object r3, il2.a r4, com.bytedance.android.livesdk.livecommerce.ability.e r5) {
        Bundle r6 = r2;
        String r7 = null;
        if (r6 == null) goto L5;
        String r8 = r6.getString("function");
    L6:
        if (r6 == null) goto L9;
        r7 = r6.getString("intention");
    L9:
        if (Intrinsics.areEqual(r8, "sync_intention_and_enable_resort") == false) goto L15;
        if (r7 == null) goto L17;
        String r9 = a2.d(r7);
        if (r9 == null) goto L17;
        this.a = r9;
    L17:
        x0 r10 = new x0();
        r10.f("biz_name", "live_feature");
        String r11 = this.a;
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        r10.c.c("param", r11);
        r10.k();
        if (r5 == null) goto L24;
        r5.onSuccess();
        return;
    L24:
        return;
    L15:
        if (Intrinsics.areEqual(r8, "sync_nullable_intention_and_resort") == false) goto L17;
        this.a = r7;
        goto L17
    L5:
        r8 = null;
        goto L6
    }
}
