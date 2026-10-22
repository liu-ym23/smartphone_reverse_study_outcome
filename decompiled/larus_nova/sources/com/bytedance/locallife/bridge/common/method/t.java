package com.bytedance.locallife.bridge.common.method;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class t implements ko6.d0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ko6.m.d f257079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f257080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ko6.m.b f257081c;

    @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        LinkedHashMap r100 = new LinkedHashMap();
        ko6.m.b r101 = this.f257081c;
        r100.put("eventName", getEventName());
        r100.put("params", r101);
        String r102 = getBtm();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r100.put("btm", r102);
        Boolean r103 = getEnterNewPage();
        boolean r104 = false;
        if (r103 == null) goto L8;
        boolean r105 = r103.booleanValue();
    L9:
        r100.put("enter_new_page", Boolean.valueOf(r105));
        Boolean r106 = getAddBtmChain();
        if (r106 == null) goto L12;
        r104 = r106.booleanValue();
    L12:
        r100.put("add_btm_chain", Boolean.valueOf(r104));
        Object r107 = getChainLength();
        if (r107 != null) goto L16;
        r107 = Boolean.FALSE;
    L16:
        r100.put("chain_length", r107);
        return r100;
    L8:
        r105 = false;
        goto L9
    }

    @Override // ko6.d0.b
    public final Boolean getAddBtmChain() {
        return this.f257079a.getAddBtmChain();
    }

    @Override // ko6.d0.b
    public final String getBtm() {
        return this.f257079a.getBtm();
    }

    @Override // ko6.d0.b
    public final Number getChainLength() {
        return this.f257079a.getChainLength();
    }

    @Override // ko6.d0.b
    public final Boolean getEnterNewPage() {
        return this.f257079a.getEnterNewPage();
    }

    @Override // ko6.d0.b
    public final String getEventName() {
        return this.f257079a.getEventName();
    }

    @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return mo6.b.b(convert());
    }

    @Override // ko6.d0.b
    public final Map<String, Object> getParams() {
        return this.f257080b;
    }

    public t(ko6.m.d r100, Map<String, Object> r101, ko6.m.b r102) {
        this.f257079a = r100;
        this.f257080b = r101;
        this.f257081c = r102;
    }
}
