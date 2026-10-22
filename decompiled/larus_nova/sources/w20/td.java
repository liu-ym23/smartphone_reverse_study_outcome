package w20;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import com.bytedance.android.live.browser.jsbridge.base.ScreenShotLocalTestResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.ByteArrayOutputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "screenShotLocalTest")
public final class td extends q5<JsonObject, ScreenShotLocalTestResultModel> {

    public static final class a {
    }

    static {
    }

    public td() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L6;
        ScreenShotLocalTestResultModel r102 = new ScreenShotLocalTestResultModel();
        r102.a(ScreenShotLocalTestResultModel.Code.NO_PERMISSION);
        Unit r103 = Unit.INSTANCE;
        finishWithResult(r102);
        return;
    L6:
        if (getCallContext().f249269d != null) goto L8;
        Bitmap r104 = null;
    L19:
        if (r104 == null) goto L35;
        ScreenShotLocalTestResultModel r105 = new ScreenShotLocalTestResultModel();
        r105.a(ScreenShotLocalTestResultModel.Code.Success);
        ScreenShotLocalTestResultModel.a r106 = new ScreenShotLocalTestResultModel.a();
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();
        int r108 = 800;
        if (800 >= r104.getWidth()) goto L23;
        float r109 = 800 / r104.getWidth();
    L25:
        if (r109 <= 0) goto L27;
        int r110 = (int) (r104.getHeight() * r109);
    L28:
        if (r110 <= 0) goto L31;
        if (r108 <= 0) goto L31;
        Bitmap.createScaledBitmap(r104, r108, r110, true).compress(Bitmap.CompressFormat.JPEG, 50, r107);
        String r111 = "data:image/jpg;base64," + Base64.encodeToString(r107.toByteArray(), 0);
    L32:
        r106.a(r111);
        Unit r112 = Unit.INSTANCE;
        r105.b(r106);
        finishWithResult(r105);
        return;
    L31:
        r111 = "";
        goto L32
    L27:
        r110 = 0;
        r108 = 0;
        goto L28
    L23:
        r109 = 0.0f;
        goto L25
    L35:
        return;
    L8:
        View r113 = getCallContext().f249269d;
        if (r113 == null) goto L11;
        int r114 = r113.getWidth();
    L12:
        View r115 = getCallContext().f249269d;
        if (r115 == null) goto L15;
        int r116 = r115.getHeight();
    L16:
        r104 = Bitmap.createBitmap(r114, r116, Bitmap.Config.ARGB_8888);
        Canvas r117 = new Canvas(r104);
        View r118 = getCallContext().f249269d;
        if (r118 == null) goto L19;
        r118.draw(r117);
        goto L19
    L15:
        r116 = com.bytedance.android.live.core.utils.s1.w();
        goto L16
    L11:
        r114 = com.bytedance.android.live.core.utils.s1.y();
        goto L12
    }
}
