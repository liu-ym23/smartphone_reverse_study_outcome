package com.larus.audio.flow.client.report;

import com.larus.audio.report.IAsrTracerFactory;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import k78.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t26\u0010\f\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\rH\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/audio/flow/client/report/AsrTracerFactory;", "Lcom/larus/audio/report/IAsrTracerFactory;", "<init>", "()V", "create", "Lcom/larus/audio/report/IAsrTracer;", "pressBtnTime", "", DBDefinition.TASK_ID, "", "convId", "botId", "appendBizParamsCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "eventName", "Lorg/json/JSONObject;", "eventParams", "", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsrTracerFactory implements IAsrTracerFactory {
    public AsrTracerFactory() {
    }

    @Override // com.larus.audio.report.IAsrTracerFactory
    public final b a(long r100, String r110, String r111, String r112, Function2 r113) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r111, "convId");
        Intrinsics.checkNotNullParameter(r112, "botId");
        Intrinsics.checkNotNullParameter(r113, "appendBizParamsCallback");
        return new b(r100, r110, r111, r112, r113);
    }
}
