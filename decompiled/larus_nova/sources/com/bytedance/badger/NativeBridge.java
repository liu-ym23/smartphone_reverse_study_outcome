package com.bytedance.badger;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0086 ¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/badger/NativeBridge;", "", "", WsConstants.KEY_PAYLOAD, MapBundleKey.MapObjKey.OBJ_SL_OBJ, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "([BLjava/lang/Object;)[B", "<init>", "()V", "badger-core_release"}, k = 1, mv = {1, 1, 15})
public final class NativeBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NativeBridge f199025a = null;

    static {
        f199025a = new NativeBridge();
    }

    private NativeBridge() {
    }

    public final native byte[] a(byte[] r100, Object r101);
}
