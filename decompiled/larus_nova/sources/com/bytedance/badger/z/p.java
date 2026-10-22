package com.bytedance.badger.z;

import android.content.Context;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.data.EventReportEnum;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public class p extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventReportEnum f199485a;

    public p(EventReportEnum r100) {
        this.f199485a = r100;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r100, BadgerModuleBase.BadgerRequestData r101) {
        List r102 = com.bytedance.badger.y.g.f199442a;     // Catch: Exception -> L8
        JSONObject r103 = com.bytedance.badger.y.g.h(this.f199485a);     // Catch: Exception -> L8
        if (r103.optLong("create_time") != 0) goto L7;
        return new BadgerResult.Failure(-998, "not record");
    L7:
        return new BadgerResult.Success(new DataJson(r103));
    L8:
        e = move-exception;
        return new BadgerResult.Failure(-999, e.toString());
    }
}
