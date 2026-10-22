package com.obric.matrix.sdk.push;

import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.PushSupporter;
import com.matrix.MatrixPushAdapter;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements jka.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f397032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f397033b;

    @Override // jka.a
    public final void onCallback(List<Object> r100) {
        kka.b.a(this.f397032a.f397031a, "on  register_channel method callback , params is " + r100);
        if (r100 == null) goto L20;
        b r101 = this.f397033b;
        Object r102 = ListProtector.get(r100, 0);
        if (r102 == null) goto L19;
        String r103 = (String) r102;
        Object r104 = ListProtector.get(r100, 1);
        if (r104 == null) goto L17;
        String r105 = (String) r104;
        if (TextUtils.equals(r103, "success") == false) goto L14;
        MatrixPushAdapter.a r106 = (MatrixPushAdapter.a) r101;
        r106.getClass();
        PushSupporter.logger().i("MatrixPushAdapter", "onSuccess,deviceToken:".concat(r105));
        if (TextUtils.isEmpty(r105) == true) goto L13;
        PushSupporter.thirdService().registerSenderSuccessAndUploadToken(r106.f384373a, MatrixPushAdapter.getMatrixPushType(), r105);
    L15:
        Unit r107 = Unit.INSTANCE;
    L21:
        if (r107 != null) goto L24;
        ((MatrixPushAdapter.a) this.f397033b).a(BDLocationException.ERROR_UID_IS_EMPTY, "error when call push_service!");
        return;
    L24:
        return;
    L13:
        PushSupporter.monitor().monitorRegisterSenderFailed(r106.f384374b, 102, "0", "token is null");
        goto L15
    L14:
        ((MatrixPushAdapter.a) r101).a(IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX, r105);
        goto L15
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L20:
        r107 = null;
        goto L21
    }

    public e(d r100, MatrixPushAdapter.a r101) {
        this.f397032a = r100;
        this.f397033b = r101;
    }
}
