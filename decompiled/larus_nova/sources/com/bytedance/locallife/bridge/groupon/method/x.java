package com.bytedance.locallife.bridge.groupon.method;

import java.util.LinkedHashMap;
import java.util.Map;
import ko6.d0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class x implements d0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qo6.r.b f257125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f257126b;

    @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
    public final Map<String, Object> convert() {
        LinkedHashMap r100 = new LinkedHashMap();
        qo6.r.b r101 = this.f257125a;
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
        return this.f257125a.getAddBtmChain();
    }

    @Override // ko6.d0.b
    public final String getBtm() {
        return this.f257125a.getBtm();
    }

    @Override // ko6.d0.b
    public final Number getChainLength() {
        return this.f257125a.getChainLength();
    }

    @Override // ko6.d0.b
    public final Boolean getEnterNewPage() {
        return this.f257125a.getEnterNewPage();
    }

    @Override // ko6.d0.b
    public final String getEventName() {
        return this.f257125a.getEventName();
    }

    @Override // com.bytedance.ies.xbridge.model.idl.XBaseModel
    public final JSONObject toJSON() {
        return mo6.b.b(convert());
    }

    @Override // ko6.d0.b
    public final Map<String, Object> getParams() {
        return this.f257126b;
    }

    public x(qo6.r.b r100, Map<String, Object> r101) {
        this.f257125a = r100;
        this.f257126b = r101;
    }
}
