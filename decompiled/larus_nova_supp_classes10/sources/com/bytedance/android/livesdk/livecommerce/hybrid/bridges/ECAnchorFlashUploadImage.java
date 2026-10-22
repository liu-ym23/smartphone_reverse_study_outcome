package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECAnchorFlashUploadImage;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAnchorFlashUploadImage extends ECBaseBridgeMethod {
    public final String e;
    public final Lazy f;

    public static final class a {
    }

    static {
    }

    public ECAnchorFlashUploadImage() {
        this.e = "ec.AnchorFlashUploadImage";
        this.f = LazyKt.lazy(ECAnchorFlashUploadImage$pattern$2.INSTANCE);
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r11, ECBaseBridgeMethod.a r12) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "iReturn");
        String r0 = ((Regex) this.f.getValue()).replaceFirst(r11.optString("imgData"), "");
        dm.a.a("ECAnchorFlashUploadImage").a("base64Str = " + r0);
        String r2 = r11.optString("roomID");
        String r13 = r11.optString("roomUniqueKey");
        int r3 = FlashController.f;
        FlashController r14 = ControllerCenter.c(r2, r13).p;
        Objects.toString(r14);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r15 = Result.constructor-impl(BuildersKt.launch$default(r14.a, null, null, new ECAnchorFlashUploadImage$handle$$inlined$runCatching$lambda$1(null, r14, r0, r12), 3, null));     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r15) == null) goto L13;
        dm.a.a("ECAnchorFlashUploadImage").b("error", null);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
