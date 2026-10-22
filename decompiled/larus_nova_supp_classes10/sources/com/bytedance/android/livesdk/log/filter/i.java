package com.bytedance.android.livesdk.log.filter;

import android.os.Bundle;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i extends a<am2.f> {
    public i() {
    }

    public final void J(Bundle r3) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        this.b.remove("game_ranklist_id");     // Catch: Throwable -> L14
        if (r3 == null) goto L6;
        String r4 = r3.getString("live.intent.extra.LIVE_JUMP_EXTRA");     // Catch: Throwable -> L14
    L8:
        if (r2.a(r4) == false) goto L12;
        JSONObject r5 = new JSONObject(r4).optJSONObject("gamecp_context");     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        this.b.put("game_ranklist_id", JSONObjectProtectorUtils.getString(r5, "game_ranklist_id"));     // Catch: Throwable -> L14
    L12:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        return;
    L6:
        r4 = null;
    L14:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<String, String>> r0 = this.b.entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        Map.Entry<String, String> r1 = r0.next();
        if (r1.getValue().length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        Map.Entry<String, String> r3 = r1;
    L14:
        if (r3 == null) goto L6;
        r4.put(r1.getKey(), r1.getValue());
        goto L6
    L13:
        r3 = null;
        goto L14
    L10:
        r2 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r5) {
        am2.f r6 = (am2.f) r5;
        Map<String, String> r0 = this.b;
        String r1 = "";
        if (r6 == null) goto L6;
        String r2 = r6.a;
        if (r2 == null) goto L6;
    L7:
        r0.put("enter_from", r2);
        Map<String, String> r3 = this.b;
        if (r6 == null) goto L11;
        String r4 = r6.b;
        if (r4 == null) goto L11;
    L12:
        r3.put("promote_game_id", r4);
        Map<String, String> r7 = this.b;
        if (r6 == null) goto L16;
        String r8 = r6.c;
        if (r8 == null) goto L16;
    L17:
        r7.put("promote_game_name", r8);
        Map<String, String> r9 = this.b;
        if (r6 == null) goto L21;
        String r10 = r6.d;
        if (r10 == null) goto L21;
    L22:
        r9.put("promote_scene", r10);
        Map<String, String> r11 = this.b;
        if (r6 == null) goto L26;
        String r12 = r6.e;
        if (r12 == null) goto L26;
    L27:
        r11.put("order", r12);
        Map<String, String> r13 = this.b;
        if (r6 == null) goto L33;
        String r14 = r6.f;
        if (r14 == null) goto L33;
        r1 = r14;
    L33:
        r13.put("label", r1);
        return;
    L26:
        r12 = "";
    L21:
        r10 = "";
    L16:
        r8 = "";
    L11:
        r4 = "";
    L6:
        r2 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r3, Object r4) {
        am2.f r5 = (am2.f) r4;
        if (r3 == null) goto L17;
        Iterator<Map.Entry<String, String>> r6 = this.b.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L23;
        Map.Entry<String, String> r0 = r6.next();
        if (r0.getValue().length() <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        Map.Entry<String, String> r2 = r0;
    L15:
        if (r2 == null) goto L7;
        r3.put(r0.getKey(), r0.getValue());
        goto L7
    L14:
        r2 = null;
        goto L15
    L11:
        r1 = false;
        goto L12
    L23:
        return;
    }
}
