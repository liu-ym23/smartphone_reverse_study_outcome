package qn2;

import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.android.livesdk.paramtransfer.RoomParamsConsumeStage;
import com.bytedance.android.livesdkapi.paramtransfer.model.RoomBundleParams;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class l extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534020a;

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getBundleKey() {
        return "live_gamecp_params";
    }

    public l() {
        this.f534020a = "GameCPLiveParamsConsume";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getClickParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getGameCpClick();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getCommonParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getGameCpCommon();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    @Override // com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final String getFirstShowParam(RoomBundleParams r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getGameCpFirstShow();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return "";
    }

    public static void c(Bundle r100, String r101, Object r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        if ((r102 instanceof Boolean) == false) goto L7;
        r100.putBoolean(r101, ((Boolean) r102).booleanValue());
        return;
    L7:
        if ((r102 instanceof String) == false) goto L10;
        r100.putString(r101, (String) r102);
        return;
    L10:
        if ((r102 instanceof Integer) == false) goto L13;
        r100.putInt(r101, ((Number) r102).intValue());
        return;
    L13:
        if ((r102 instanceof Short) == false) goto L16;
        r100.putShort(r101, ((Number) r102).shortValue());
        return;
    L16:
        if ((r102 instanceof Long) == false) goto L19;
        r100.putLong(r101, ((Number) r102).longValue());
        return;
    L19:
        if ((r102 instanceof Byte) == false) goto L22;
        r100.putByte(r101, ((Number) r102).byteValue());
        return;
    L22:
        if ((r102 instanceof byte[]) == false) goto L25;
        r100.putByteArray(r101, (byte[]) r102);
        return;
    L25:
        if ((r102 instanceof Character) == false) goto L28;
        r100.putChar(r101, ((Character) r102).charValue());
        return;
    L28:
        if ((r102 instanceof char[]) == false) goto L31;
        r100.putCharArray(r101, (char[]) r102);
        return;
    L31:
        if ((r102 instanceof CharSequence) == false) goto L34;
        r100.putCharSequence(r101, (CharSequence) r102);
        return;
    L34:
        if ((r102 instanceof Float) == false) goto L37;
        r100.putFloat(r101, ((Number) r102).floatValue());
        return;
    L37:
        if ((r102 instanceof Double) == false) goto L40;
        r100.putDouble(r101, ((Number) r102).doubleValue());
        return;
    L40:
        if ((r102 instanceof boolean[]) == false) goto L43;
        r100.putBooleanArray(r101, (boolean[]) r102);
        return;
    L43:
        if ((r102 instanceof int[]) == false) goto L46;
        r100.putIntArray(r101, (int[]) r102);
        return;
    L46:
        if ((r102 instanceof long[]) == false) goto L49;
        r100.putLongArray(r101, (long[]) r102);
        return;
    L49:
        if ((r102 instanceof double[]) == false) goto L52;
        r100.putDoubleArray(r101, (double[]) r102);
        return;
    L52:
        if ((r102 instanceof Parcelable) == false) goto L55;
        r100.putParcelable(r101, (Parcelable) r102);
        return;
    L55:
        if ((r102 instanceof Serializable) == false) goto L58;
        r100.putSerializable(r101, (Serializable) r102);
        return;
    L58:
        if ((r102 instanceof JSONObject) == false) goto L60;
    L63:
        r100.putString(r101, r102.toString());
        return;
    L60:
        if ((r102 instanceof JSONArray) == true) goto L63;
        r100.putString(r101, GsonProtectorUtils.toJson(new Gson(), r102));
    }

    @Override // qn2.c, com.bytedance.android.livesdkapi.paramtransfer.consume.BaseRoomParamsConsumer, com.bytedance.android.livesdkapi.paramtransfer.consume.IRoomParamsConsumer
    public final void consume(RoomBundleParams r100, RoomParamsConsumeStage r101, Bundle r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r101, "stage");
        super.consume(r100, r101, r102, r103);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L26
        Unit r105 = null;
        if (r100 == null) goto L24;
        String r106 = r100.getGameCpFirstShow();     // Catch: Throwable -> L26
        if (r106 == null) goto L24;
        if (r106.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L14;
        r106 = null;
    L14:
        if (r106 == null) goto L24;
        JSONObject r108 = new JSONObject(r106).optJSONObject("game_promote_enter_room");     // Catch: Throwable -> L26
        if (r108 != null) goto L18;
        return;
    L18:
        if (r102 == null) goto L24;
        Bundle r109 = new Bundle();     // Catch: Throwable -> L26
        Iterator<String> r110 = r108.keys();     // Catch: Throwable -> L26
    L21:
        if (r110.hasNext() == false) goto L23;
        String r111 = r110.next();     // Catch: Throwable -> L26
        c(r109, r111, r108.opt(r111));     // Catch: Throwable -> L26
        goto L21
    L23:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r102.putBundle("game_promote_enter_room", r109);     // Catch: Throwable -> L26
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L26
        goto L24
    L10:
        r107 = false;
    L24:
        Object r113 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L26
    L28:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L35;
        Logger.d(this.f534020a, "consume error: " + r114.getMessage());
        return;
    L35:
        return;
    L26:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }
}
