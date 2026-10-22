package com.matrix;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.f;
import com.obric.matrix.push.common.cross_process.CrossProcessService;
import com.obric.matrix.sdk.push.PushApi;
import com.obric.matrix.sdk.push.b;
import com.obric.matrix.sdk.push.c;
import com.obric.matrix.sdk.push.d;
import com.obric.matrix.sdk.push.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.message.AppProvider;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class MatrixPushAdapter implements IPushAdapter {
    private static int MATRIX_PUSH = -1;
    private final String TAG;

    public class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f384373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f384374b;

        public a(Context r100, int r101) {
            this.f384373a = r100;
            this.f384374b = r101;
        }

        public final void a(String r100, String r101) {
            PushSupporter.logger().i("MatrixPushAdapter", "onFailed,errorCode:" + r100 + " errorMsg:" + r101);
            PushSupporter.monitor().monitorRegisterSenderFailed(this.f384374b, 104, r100, "errorCode = " + r100 + " ,errorMsg = " + r101);
        }
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean checkThirdPushConfig(String r100, Context r101) throws Exception {
        return true;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean requestRemoveVoipNotification(Context r100, int r101) {
        return false;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void setAlias(Context r100, String r101, int r102) {
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void trackPush(Context r100, int r101, Object r102) {
    }

    public static int getMatrixPushType() {
        if (MATRIX_PUSH != (-1)) goto L6;
        MATRIX_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(MatrixPushAdapter.class.getName());
    L6:
        return MATRIX_PUSH;
    }

    public MatrixPushAdapter() {
        this.TAG = "MatrixPushAdapter";
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public boolean isPushAvailable(Context r100, int r101) {
        Pair<String, String> r102 = PushSupporter.thirdService().getPushConfig(getMatrixPushType());
        f.g("MatrixPushAdapter", "[isPushAvailable]context:" + r100 + " push_type:" + r101 + " SDK_INT:" + Build.VERSION.SDK_INT + " ECLAIR:5 pair:" + r102);
        if (r102 == null) goto L5;
        f.g("MatrixPushAdapter", "[isPushAvailable]pair.first:" + ((String) r102.first) + " pair.second:" + ((String) r102.second));
    L5:
        if (r102 != null) goto L7;
    L11:
        return false;
    L7:
        if (TextUtils.isEmpty((CharSequence) r102.first) == true) goto L11;
        if (TextUtils.isEmpty((CharSequence) r102.second) == true) goto L11;
        return true;
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void registerPush(Context r100, int r101) {
        PushSupporter.logger().i("MatrixPushAdapter", "register is to be invoked.");
        if (r100 != null) goto L5;
    L24:
        if (r100 != null) goto L26;
        String r102 = "context is null";
    L28:
        if (PushSupporter.thirdService().isMainProcess(r100) == false) goto L30;
        PushSupporter.monitor().monitorRegisterSenderFailed(r101, 101, "0", r102);
    L30:
        PushSupporter.logger().i("MatrixPushAdapter", "register is return in advance for ".concat(r102));
        return;
    L26:
        r102 = "register channel error";
        goto L28
    L5:
        if (r101 != getMatrixPushType()) goto L24;
        Pair<String, String> r103 = PushSupporter.thirdService().getPushConfig(getMatrixPushType());
        if (r103 != null) goto L11;
        PushSupporter.logger().i("MatrixPushAdapter", "register failed because key is null");
        return;
    L11:
        c r104 = new c((String) r103.first, (String) r103.second);
        a r105 = new a(r100, r101);
        Lazy r106 = PushApi.f397023a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "pushConfiguration");
        Intrinsics.checkNotNullParameter(r105, "registerCallback");
        d r107 = (d) PushApi.f397023a.getValue();
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "pushConfiguration");
        Intrinsics.checkNotNullParameter(r105, "registerCallback");
        kka.b.a(r107.f397031a, "registerPush");
        if (TextUtils.isEmpty(r104.f397024a) == false) goto L15;
        r105.a("101", "appId is empty!");
    L22:
        PushSupporter.logger().i("MatrixPushAdapter", "register is invoked.");
        return;
    L15:
        if (TextUtils.isEmpty(r104.f397025b) == false) goto L17;
        r105.a("101", "appSecret is empty!");
        goto L22
    L17:
        ArrayList r108 = new ArrayList();
        r108.add(r104.f397024a);
        r108.add(r104.f397025b);
        kka.b.a(r107.f397031a, "invoke register_channel");
        d.a(r100);     // Catch: Throwable -> L20
        ((CrossProcessService) ika.a.f490286a.a(r100)).b("register_channel", r108, new e(r107, r105));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r105.a(BDLocationException.ERROR_UID_IS_EMPTY, "error when call push_service! " + th.getMessage());
        goto L22
    }

    @Override // com.bytedance.push.third.IPushAdapter
    public void unregisterPush(Context r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != getMatrixPushType()) goto L15;
        Lazy r102 = PushApi.f397023a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        d r103 = (d) PushApi.f397023a.getValue();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((CrossProcessService) ika.a.f490286a.a(r100)).b("un_register_channel", null, null);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        kka.b.a(r103.f397031a, "error when unRegister: " + th.getMessage());
        return;
    }
}
