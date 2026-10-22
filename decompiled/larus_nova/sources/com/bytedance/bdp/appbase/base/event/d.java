package com.bytedance.bdp.appbase.base.event;

import com.bytedance.bdp.bdpbase.schema.SchemaInfo;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements c.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SchemaInfo f200560a;

    @Override // com.bytedance.bdp.appbase.base.event.c.g
    public final JSONObject getParams() {
        SchemaInfo r100 = this.f200560a;
        Lazy r101 = BdpAppEventHelper.f200541a;
        JSONObject r102 = new JSONObject();
        BdpAppEventHelper.d(r100, r102);
        return r102;
    }

    public d(SchemaInfo r100) {
        this.f200560a = r100;
    }
}
