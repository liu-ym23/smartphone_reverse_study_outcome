package w64;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.manager.PseudoCodeManager;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeResult;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.badger.collect.impl.utils.NetworkTypeUtils;
import com.bytedance.badger.collect.impl.utils.SimUtils;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataString;
import com.bytedance.badger.j;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.badger.network.d0;
import com.bytedance.badger.network.z0;
import com.bytedance.badger.v.w;
import com.bytedance.badger.z.u0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends u0 {
    public c() {
    }

    public static JSONObject c(PseudoCodeResult r100, Context r101) {
        JSONObject r102 = new JSONObject();
        r102.putOpt("AppID", Integer.valueOf(BadgerCollectApi.getAppId()));
        r102.putOpt("AC", NetworkTypeUtils.getNetworkStatus(r101));
        r102.putOpt("CarrierCode", Integer.valueOf(SimUtils.getSimType(r101)));
        r102.putOpt("UserPseudoCode", r100.data);
        r102.putOpt("OS", "android");
        r102.putOpt("Time", Long.valueOf(System.currentTimeMillis()));
        r102.putOpt("VersionCode", "0.2.0-rc.18.3-bugfix-badger");
        BadgerCore.Companion.getClass();
        r102.putOpt("DeviceID", j.a().getDeviceId());
        r102.putOpt("Province", "");
        r102.putOpt("ErrorMsg", r100.errorMsg);
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, org.json.JSONObject] */
    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r110, BadgerModuleBase.BadgerRequestData r111) {
        CountDownLatch r112 = new CountDownLatch(1);
        AtomicInteger r113 = new AtomicInteger(0);
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = null;
        long r100 = System.currentTimeMillis();
        PseudoCodeManager.getInstance().executeMobilePseudoCode(new a(this, r113, r114, r110, r111, r100, r112));
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r101 = com.bytedance.badger.v.d.f199325i;
        KProperty r102 = com.bytedance.badger.v.d.f199311a[8];
        w r103 = (w) r101.a();
        if (r112.await(r103.f199356a, r103.f199357b) == true) goto L5;
        r113.compareAndSet(0, 2);
        throw new RuntimeException("Timeout");
    L5:
        if (((JSONObject) r114.element) != null) goto L8;
        r114.element = new JSONObject();
    L8:
        return new BadgerResult.Success(new DataString(String.valueOf((JSONObject) r114.element)));
    }

    public static final void d(c r100, Context r101, PseudoCodeResult r102, BadgerModuleBase.BadgerRequestData r103, long r104) {
        r100.getClass();
        if (TextUtils.isEmpty(r102.data) == true) goto L9;
        boolean r105 = u0.b(Long.valueOf(r103.getToken()), new DataString(c(r102, r101).toString()), System.currentTimeMillis() - r104);
        if (r105 == false) goto L7;
        z0 r106 = d0.f199093a;
        d0.b(23, z64.h.b.f570472a, new b(), false);
        return;
    L7:
        KLog.w(Constants.TAGS.PSEUDO, "error status: " + r105);
        return;
    }
}
