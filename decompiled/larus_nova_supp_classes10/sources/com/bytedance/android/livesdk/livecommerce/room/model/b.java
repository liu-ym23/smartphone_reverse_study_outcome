package com.bytedance.android.livesdk.livecommerce.room.model;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/b;", "", "", "clickArea", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "clickEnterFrom", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/model/response/j0;", "action", "Lcom/bytedance/android/ec/model/response/j0;", "b", "()Lcom/bytedance/android/ec/model/response/j0;", "clickType", "I", "f", "()I", "Lcom/bytedance/android/livesdk/livecommerce/room/model/d;", "btmModel", "Lcom/bytedance/android/livesdk/livecommerce/room/model/d;", "c", "()Lcom/bytedance/android/livesdk/livecommerce/room/model/d;", "requestScene", "h", "Lcom/bytedance/android/livesdk/livecommerce/room/model/f;", "params", "Lcom/bytedance/android/livesdk/livecommerce/room/model/f;", "g", "()Lcom/bytedance/android/livesdk/livecommerce/room/model/f;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("action")
    private final j0 action;

    @SerializedName("btm_model")
    private final d btmModel;

    @SerializedName("click_area")
    private final String clickArea;

    @SerializedName("click_enter_from")
    private final Integer clickEnterFrom;

    @SerializedName("click_type")
    private final int clickType;

    @SerializedName("params")
    private final f params;

    @SerializedName("request_scene")
    private final int requestScene;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L20;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.clickArea, r4.clickArea) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.clickEnterFrom, r4.clickEnterFrom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.action, r4.action) == true) goto L12;
        return false;
    L12:
        if (this.clickType == r4.clickType) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.btmModel, r4.btmModel) == true) goto L16;
        return false;
    L16:
        if (this.requestScene == r4.requestScene) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r0 = this.clickArea;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.clickEnterFrom;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        j0 r7 = this.action;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.clickType) * 31;
        d r10 = this.btmModel;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (((r9 + r11) * 31) + this.requestScene) * 31;
        f r13 = this.params;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECLiveHybridJumpDispatcherModel(clickArea=" + this.clickArea + ", clickEnterFrom=" + this.clickEnterFrom + ", action=" + this.action + ", clickType=" + this.clickType + ", btmModel=" + this.btmModel + ", requestScene=" + this.requestScene + ", params=" + this.params + ")";
    }

    public b() {
        this.clickArea = null;
        this.clickEnterFrom = null;
        this.action = null;
        this.clickType = 0;
        this.btmModel = null;
        this.requestScene = -1;
        this.params = null;
    }

    public final j0 b() {
        return this.action;
    }

    public final d c() {
        return this.btmModel;
    }

    public final String d() {
        return this.clickArea;
    }

    public final Integer e() {
        return this.clickEnterFrom;
    }

    public final int f() {
        return this.clickType;
    }

    public final f g() {
        return this.params;
    }

    public final int h() {
        return this.requestScene;
    }

    public static com.bytedance.android.ec.common.api.jump.model.g a(b r13, PageFinder r14) {
        Intrinsics.checkNotNullParameter(r14, "defaultPageFinder");
        f r0 = r13.params;
        if (r0 == null) goto L5;
        String r1 = r0.e();
    L6:
        f r2 = r13.params;
        if (r2 == null) goto L9;
        String r3 = r2.f();
    L10:
        com.bytedance.android.ec.common.api.jump.model.b r4 = (LiveRoomParams) UtilityKotlinExtentionsKt.f(r1, r3, ECLiveHybridJumpDispatcherModel$getLiveRoomParams$1.INSTANCE);
        if (r4 != null) goto L13;
        r4 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L13:
        KClass r5 = Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class);
        d r6 = r13.btmModel;
        if (r6 == null) goto L16;
        String r7 = r6.a();
    L17:
        BtmSDK r8 = BtmSDK.INSTANCE;
        d r9 = r13.btmModel;
        if (r9 == null) goto L20;
        r9.b(r14);
    L21:
        String r10 = r8.getPageId(r14);
        f r15 = r13.params;
        if (r15 == null) goto L25;
        String r16 = r15.b();
        if (r16 == null) goto L25;
    L26:
        jf.b.c r11 = new jf.b.c(r16);
        f r17 = r13.params;
        if (r17 == null) goto L29;
        Integer r18 = r17.g();
    L30:
        jf.e r12 = jf.f.a(r18);
        f r19 = r13.params;
        if (r19 == null) goto L42;
        Map<String, Object> r110 = r19.c();
        if (r110 == null) goto L42;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L36
        Object r111 = Result.constructor-impl(new JSONObject(r110));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r111) == false) goto L41;
        r111 = null;
    L41:
        JSONObject r112 = (JSONObject) r111;
    L43:
        f r113 = r13.params;
        if (r113 == null) goto L55;
        Map<String, Object> r114 = r113.a();
        if (r114 == null) goto L55;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L49
        Object r115 = Result.constructor-impl(new JSONObject(r114));     // Catch: Throwable -> L49
    L52:
        if (Result.isFailure-impl(r115) == false) goto L54;
        r115 = null;
    L54:
        JSONObject r116 = (JSONObject) r115;
    L56:
        com.bytedance.android.ec.common.api.jump.model.f r117 = r4.buildParams(r5, new com.bytedance.android.ec.common.api.jump.model.f.a(r7, r10, r11, r12, null, r112, r116, 16));
        KClass r22 = Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.g.class);
        f r118 = r13.params;
        if (r118 == null) goto L61;
        c r119 = r118.d();
        if (r119 == null) goto L61;
        ql.a r120 = r119.a(null);
    L63:
        return r117.buildParams(r22, new com.bytedance.android.ec.common.api.jump.model.g.a(r120));
    L61:
        r120 = new ql.a();
    L49:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r115 = Result.constructor-impl(ResultKt.createFailure(th));
    L55:
        r116 = null;
    L36:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
    L42:
        r112 = null;
        goto L43
    L29:
        r18 = null;
    L25:
        jf.b.d r121 = jf.b.d.b;
        r16 = "default";
        goto L26
    L20:
        r14 = null;
        goto L21
    L16:
        r7 = null;
        goto L17
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
