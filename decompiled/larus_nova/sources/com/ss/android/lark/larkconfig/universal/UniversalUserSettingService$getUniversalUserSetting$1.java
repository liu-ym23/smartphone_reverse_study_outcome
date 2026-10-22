package com.ss.android.lark.larkconfig.universal;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/ss/android/lark/larkconfig/universal/UniversalUserSettingService$getUniversalUserSetting$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "", "Lcom/bytedance/lark/pb/basic/v1/UniversalUserSetting;", "onSuccess", "", "universalUserSettingMap", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "universal_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalUserSettingService$getUniversalUserSetting$1 implements IGetDataCallback<Map<String, ? extends UniversalUserSetting>> {
    final /* synthetic */ IGetDataCallback<UniversalUserSetting> $callback;
    final /* synthetic */ String $key;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("UniversalUserSettingService", "get all universal user setting failed, " + r100.getDebugMsg());
    }

    public void onSuccess(Map<String, UniversalUserSetting> r100) {
        if (r100 != null) goto L5;
        Log.e("UniversalUserSettingService", "universal user setting map is null");
        return;
    L5:
        Iterator<Map.Entry<String, UniversalUserSetting>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<String, UniversalUserSetting> r102 = r101.next();
        String r103 = r102.getKey();
        UniversalUserSetting r104 = r102.getValue();
        a.f431126a.getClass();
        a.a(r103, r104);
        goto L7
    L9:
        this.$callback.onSuccess(e.f431131a.a(this.$key));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((Map) r100);
    }

    public UniversalUserSettingService$getUniversalUserSetting$1(IGetDataCallback<UniversalUserSetting> r100, String r101) {
        this.$callback = r100;
        this.$key = r101;
    }
}
