package com.bytedance.bdp.serviceapi.hostimpl.liveplayer;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/bdp/serviceapi/hostimpl/liveplayer/ITTLivePlayer$ObjectFit", "", "Lcom/bytedance/bdp/serviceapi/hostimpl/liveplayer/ITTLivePlayer$ObjectFit;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "CONTAIN", "FILLCROP", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public final enum ITTLivePlayer$ObjectFit extends Enum<ITTLivePlayer$ObjectFit> {
    public static final ITTLivePlayer$ObjectFit CONTAIN = null;
    public static final ITTLivePlayer$ObjectFit FILLCROP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ITTLivePlayer$ObjectFit[] f201610a = null;
    private final String value;

    static {
        ITTLivePlayer$ObjectFit r100 = new ITTLivePlayer$ObjectFit("CONTAIN", 0, LynxVideoManagerLite.CONTAIN);
        CONTAIN = r100;
        ITTLivePlayer$ObjectFit r101 = new ITTLivePlayer$ObjectFit("FILLCROP", 1, "fillCrop");
        FILLCROP = r101;
        f201610a = new ITTLivePlayer$ObjectFit[]{r100, r101};
    }

    public static ITTLivePlayer$ObjectFit valueOf(String r100) {
        return (ITTLivePlayer$ObjectFit) a.a(ITTLivePlayer$ObjectFit.class, r100);
    }

    public static ITTLivePlayer$ObjectFit[] values() {
        return (ITTLivePlayer$ObjectFit[]) f201610a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ITTLivePlayer$ObjectFit(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
