package com.larus.caijing_pay.impl.init;

import com.larus.caijing_pay.api.ICJPayInitiator;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.t0;
import com.ss.android.bytedcert.BytedCertImpl;
import com.ss.android.cert.manager.BytedCertSdk;
import com.ss.android.cert.manager.BytedCertSdkInitParam;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.permission.PermissionEntity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/caijing_pay/impl/init/CJPayInitiator;", "Lcom/larus/caijing_pay/api/ICJPayInitiator;", "<init>", "()V", "initCJPay", "", "initAnnieXCJBid", "initBytedCertSdk", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJPayInitiator implements ICJPayInitiator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f321301a = 0;

    public static final class a {
    }

    static {
    }

    public CJPayInitiator() {
    }

    @Override // com.larus.caijing_pay.api.ICJPayInitiator
    public final void a() {
        BytedCertSdkInitParam r100 = new BytedCertSdkInitParam();
        AppHost.Companion r101 = AppHost.f326268a;
        BytedCertSdk.init(r100.setPermissionParam(new BytedCertSdkInitParam.PermissionParam(true, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(PermissionEntity.Group.PERMISSION_GROUP_CAMERA, r101.getApplication().getString(R.string.larus_camera_authorization_message)), TuplesKt.to(PermissionEntity.Group.PERMISSION_GROUP_MICROPHONE, r101.getApplication().getString(R.string.larus_microphone_authorization_text))}))).setUpgradeV3(true).setWebContainerType(BytedCertConstant.WebInfo.WEB_TYPE_NEW_CERT_WEB).setInfoDetectFrameBuff(10));
        CertManager.getInstance().registerBytedCert(new BytedCertImpl());
        t0.a(new b());
    }

    @Override // com.larus.caijing_pay.api.ICJPayInitiator
    public final void b() {
        t0.a(new com.larus.caijing_pay.impl.init.a(this));
    }
}
