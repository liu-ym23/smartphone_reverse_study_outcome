package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class HeadVideoAutoPlayController$savePauseEventToDisk$1 extends Lambda implements Function0<Unit> {
    public static final HeadVideoAutoPlayController$savePauseEventToDisk$1 INSTANCE = null;

    static {
        INSTANCE = new HeadVideoAutoPlayController$savePauseEventToDisk$1();
    }

    public HeadVideoAutoPlayController$savePauseEventToDisk$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m150invoke() {
        mj.a r0 = com.bytedance.android.ec.sdk.helper.d.b.getIECSPService();
        JSONObject r1 = new JSONObject();
        Lazy r2 = HeadVideoAutoPlayController.a;
        Long r3 = HeadVideoAutoPlayController.b;
        if (r3 == null) goto L5;
        r1.put("stop_flag", r3.longValue());
    L5:
        r1.put("records", new JSONArray(HeadVideoAutoPlayController.c));
        Unit r4 = Unit.INSTANCE;
        r0.putString("ec_pd_head_video_pause_event", r1.toString());
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m150invoke();
        return Unit.INSTANCE;
    }
}
