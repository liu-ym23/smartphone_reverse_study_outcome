package com.obric.aivoice.core.data;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.sdk.AIVoiceConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0002\u001a'\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u0002H\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u001a\u0010\u0015\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u001a\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001¨\u0006\u0019"}, d2 = {"getModelName", "", "Landroid/os/Bundle;", "getTaskId", "", "isError", "", "isFinish", "isSuccess", "isTaskId", "setBasicTypeRes", ExifInterface.GPS_DIRECTION_TRUE, "data", "code", "", "(Landroid/os/Bundle;Ljava/lang/Object;I)Landroid/os/Bundle;", "setBizCall", "bizName", "fromPkgName", "setGlobalCall", "methodName", "setModelCall", "modelName", "setSceneCall", "sceneName", "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BundleExtKt {
    public static final String getModelName(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getString(IdlKeys.Args_ModelName);
    }

    public static final long getTaskId(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getLong(IdlKeys.Result);
    }

    public static final boolean isError(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return !isSuccess(r100);
    }

    public static final boolean isFinish(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getBoolean(IdlKeys.IsFinish, true);
    }

    public static final boolean isSuccess(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getInt(IdlKeys.ErrorCode, 0);
        if (r101 == 0) goto L5;
        if (r101 == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static final boolean isTaskId(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getBoolean(IdlKeys.IsTaskId);
    }

    public static final Bundle setGlobalCall(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "methodName");
        r100.putLong(IdlKeys.Args_Time, SystemClock.elapsedRealtime());
        r100.putString(IdlKeys.Call_Type, IdlKeys.Call_Type_CallGlobal);
        r100.putString(IdlKeys.MethodName, r101);
        AIVoiceConfig r102 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r102 == null) goto L5;
        r100.putLong(IdlKeys.Args_ProjectId, r102.getProjectId());
        r100.putLong(IdlKeys.Args_AppId, r102.getAppId());
        r100.putString(IdlKeys.Args_PackageName, r102.getPackageName());
    L5:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Bundle setBasicTypeRes(Bundle r100, T r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.putInt(IdlKeys.ErrorCode, r102);
        r100.putString(IdlKeys.ErrorInfo, null);
        boolean r103 = true;
        if (r102 != 1) goto L6;
        r103 = false;
    L6:
        r100.putBoolean(IdlKeys.IsFinish, r103);
        if ((r101 instanceof Integer) == false) goto L10;
        r100.putInt(IdlKeys.Result, ((Number) r101).intValue());
    L39:
        return r100;
    L10:
        if ((r101 instanceof int[]) == false) goto L13;
        r100.putIntArray(IdlKeys.Result, (int[]) r101);
        goto L39
    L13:
        if ((r101 instanceof Float) == false) goto L16;
        r100.putFloat(IdlKeys.Result, ((Number) r101).floatValue());
        goto L39
    L16:
        if ((r101 instanceof float[]) == false) goto L19;
        r100.putFloatArray(IdlKeys.Result, (float[]) r101);
        goto L39
    L19:
        if ((r101 instanceof String) == false) goto L22;
        r100.putString(IdlKeys.Result, (String) r101);
        goto L39
    L22:
        if ((r101 instanceof Byte) == false) goto L25;
        r100.putByte(IdlKeys.Result, ((Number) r101).byteValue());
        goto L39
    L25:
        if ((r101 instanceof byte[]) == false) goto L28;
        r100.putByteArray(IdlKeys.Result, (byte[]) r101);
        goto L39
    L28:
        if ((r101 instanceof Character) == false) goto L31;
        r100.putChar(IdlKeys.Result, ((Character) r101).charValue());
        goto L39
    L31:
        if ((r101 instanceof char[]) == false) goto L34;
        r100.putCharArray(IdlKeys.Result, (char[]) r101);
        goto L39
    L34:
        if ((r101 instanceof Boolean) == false) goto L37;
        r100.putBoolean(IdlKeys.Result, ((Boolean) r101).booleanValue());
        goto L39
    L37:
        if ((r101 instanceof boolean[]) == false) goto L39;
        r100.putBooleanArray(IdlKeys.Result, (boolean[]) r101);
        goto L39
    }

    public static final Bundle setBizCall(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "bizName");
        r100.putString(IdlKeys.Call_Type, IdlKeys.Call_Type_CallBiz);
        r100.putString(IdlKeys.MethodName, IdlKeys.Method_RunBiz);
        r100.putString(IdlKeys.Args_BizName, r101);
        r100.putString(IdlKeys.Args_PackageName, r102);
        return r100;
    }

    public static final Bundle setModelCall(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "modelName");
        Intrinsics.checkNotNullParameter(r102, "methodName");
        r100.putLong(IdlKeys.Args_Time, SystemClock.elapsedRealtime());
        r100.putString(IdlKeys.Call_Type, IdlKeys.Call_Type_CallModel);
        AIVoiceConfig r103 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r103 == null) goto L5;
        r100.putLong(IdlKeys.Args_ProjectId, r103.getProjectId());
        r100.putLong(IdlKeys.Args_AppId, r103.getAppId());
        r100.putString(IdlKeys.Args_PackageName, r103.getPackageName());
    L5:
        r100.putString(IdlKeys.Args_ModelName, r101);
        r100.putString(IdlKeys.MethodName, r102);
        return r100;
    }

    public static final Bundle setSceneCall(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "sceneName");
        Intrinsics.checkNotNullParameter(r102, "methodName");
        r100.putString(IdlKeys.Call_Type, IdlKeys.Call_Type_CallScene);
        AIVoiceConfig r103 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r103 == null) goto L5;
        r100.putLong(IdlKeys.Args_ProjectId, r103.getProjectId());
        r100.putLong(IdlKeys.Args_AppId, r103.getAppId());
        r100.putString(IdlKeys.Args_PackageName, r103.getPackageName());
    L5:
        r100.putString(IdlKeys.Args_ModelScene, r101);
        r100.putString(IdlKeys.MethodName, r102);
        return r100;
    }

    public static /* synthetic */ Bundle setBasicTypeRes$default(Bundle r100, Object r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return setBasicTypeRes(r100, r101, r102);
    }

    public static /* synthetic */ Bundle setBizCall$default(Bundle r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L9;
        AIVoiceConfig r105 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r105 == null) goto L7;
        r102 = r105.getPackageName();
        goto L9
    L7:
        r102 = null;
    L9:
        return setBizCall(r100, r101, r102);
    }
}
