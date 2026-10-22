package vw0;

import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.android.live.recharge.panel.aio.PanelMode;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes47.dex */
public final class f {
    public static final IPanelProperties a() {
        Class<?> r100 = ((JsonAdapter) IPanelProperties.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r101 = vh7.b.f554981a;
        Constructor r102 = r101.get(r100);
        if (r102 != null) goto L12;
        r102 = r100.getConstructor(new Class[0]);
        if (r102 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r103 = r101.putIfAbsent(r100, (Constructor<? extends SerializableObjectJsonAdapterBase>) r102);
        if (r103 == null) goto L12;
        r102 = r103;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r104 = ((SerializableObjectJsonAdapterBase) r102.newInstance(new Object[0])).createInstance();
        if (r104 == null) goto L17;
        IPanelProperties r105 = (IPanelProperties) r104;
        r105.setRechargeAgreementAccepted(null);
        r105.setCombinedPaySelected(null);
        r105.setCustomPrice(null);
        r105.setShowCenterLoading(null);
        r105.setHidePanel(null);
        r105.setPanelMode(PanelMode.NORMAL_MODE.getMode());
        return r105;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.aio.IPanelProperties");
    }
}
