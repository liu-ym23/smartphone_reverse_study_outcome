package eu8;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f474096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonElement f474097b;

    public abstract String a();

    public final String toString() {
        StringBuilder r100 = new StringBuilder("CmdExecutorBase{sourceJson=");
        JsonElement r101 = this.f474097b;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = "";
        goto L6
    }

    @Override // eu8.d
    public final Object execute() {
        return a();
    L4:
        e = move-exception;
        String r100 = nu8.a.f520610a;
        Intrinsics.checkNotNullParameter("CmdExecutorBase", "text");
        Intrinsics.checkNotNullParameter(e, LynxError.LYNX_THROWABLE);
        FLogger r101 = FLogger.f375446a;
        if (r101.a() == false) goto L9;
        r101.e("bootprotector", "CmdExecutorBase", e);
    L9:
        return e.toString();
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L20:
        return r100;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == false) goto L20;
        IBootProtectorLauncher.f317602a.getClass();
        String r102 = IBootProtectorLauncher.a.b().getDid();
        if (TextUtils.isEmpty(r102) == true) goto L16;
        r100 = r100.replace("{did}", r102);
    L16:
        String r103 = IBootProtectorLauncher.a.b().getUid();
        if (TextUtils.isEmpty(r103) == true) goto L19;
        r100 = r100.replace("{uid}", r103);
    L19:
        nu8.a.h("CmdExecutorBase", "replacePlaceHolder result: " + r100);
        goto L20
    L7:
        if (r100.contains("{did}") == false) goto L9;
    L10:
        r101 = true;
        goto L12
    L9:
        if (r100.contains("{uid}") == false) goto L11;
        goto L10
    }

    public a(Context r100, JsonElement r101) {
        this.f474096a = r100;
        this.f474097b = r101;
    }
}
