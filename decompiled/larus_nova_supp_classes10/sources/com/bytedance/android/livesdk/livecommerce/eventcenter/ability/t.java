package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.UrlBuilderV2;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@LiveAtomicAbilityDescriptor(action = "open_schema", description = "打开schema", service = {"LiveBase"})
public final class t extends com.bytedance.android.livesdk.livecommerce.ability.d<sl.n> {

    public static final class a {
    }

    static {
    }

    public t() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r6, sl.n r7, Object r8, il2.a r9, com.bytedance.android.livesdk.livecommerce.ability.e r10) {
        sl.n r11 = r7;
        if (r11 == null) goto L5;
        String r0 = r11.b();
    L7:
        if (r0 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        if (r10 == null) goto L58;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r10, 0, null, 3);
        return;
    L58:
        return;
    L16:
        final UrlBuilderV2 r1 = new UrlBuilderV2(r0);
        boolean r2 = r8 instanceof com.bytedance.android.ec.common.api.jump.model.a;
        if (r2 == true) goto L19;
        Object r4 = null;
    L20:
        com.bytedance.android.ec.common.api.jump.model.a r5 = (com.bytedance.android.ec.common.api.jump.model.a) r4;
        if (r5 == null) goto L26;
        com.bytedance.android.ec.common.api.jump.model.f r12 = r5.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r12 == null) goto L26;
        BtmUtilsKt.c(r1, BtmUtilsKt.e(r12.a, PageFinder.via(r12.b)));
    L26:
        if (r11.a() != 1) goto L46;
        if (r2 == true) goto L30;
        r8 = null;
    L30:
        com.bytedance.android.ec.common.api.jump.model.a r13 = (com.bytedance.android.ec.common.api.jump.model.a) r8;
        if (r13 == null) goto L46;
        LiveRoomParams r14 = r13.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r14 == null) goto L46;
        JSONObject r15 = new JSONObject();
        String r16 = r14.getGroupId();     // Catch: Exception -> L42
        if (r16 == null) goto L38;
        r15.put("group_id", r16);     // Catch: Exception -> L42
    L38:
        r15.put("room_id", r14.getRoomId());     // Catch: Exception -> L42
        r15.put("request_id", r14.getRequestId());     // Catch: Exception -> L42
        r15.put("action_type", r14.getActionType());     // Catch: Exception -> L42
        r15.put("enter_from_merge", r14.getEnterFromMerge());     // Catch: Exception -> L42
        r15.put("enter_method", r14.getEnterMethod());     // Catch: Exception -> L42
        String r17 = r14.isOtherChannel();     // Catch: Exception -> L42
        if (r17 == null) goto L44;
        r15.put("is_other_channel", r17);     // Catch: Exception -> L42
    L44:
        Unit r18 = Unit.INSTANCE;
        r1.addOrReplaceParam("source_info", r15);
    L42:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L46:
        if (Intrinsics.areEqual(r11.c(), Boolean.TRUE) == false) goto L52;
        int r19 = ECSdk.a;
        IECHostService r20 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r20 == null) goto L53;
        jj.a r21 = r20.getIECHostRouterManager();
        if (r21 == null) goto L53;
        r21.openSchema(r6, r1.build());
    L53:
        if (r10 == null) goto L60;
        r10.onSuccess();
        return;
    L60:
        return;
    L52:
        UtilityKotlinExtentionsKt.f(r6, r11.b(), new LiveOpenSchemaAbility$execute$3(r1));
        goto L53
    L19:
        r4 = r8;
        goto L20
    L9:
        if (r0.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r0 = null;
        goto L7
    }
}
