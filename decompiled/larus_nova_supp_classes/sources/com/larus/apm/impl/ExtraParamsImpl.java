package com.larus.apm.impl;

import android.os.Process;
import android.util.EventsUtils;
import com.bytedance.apm.d;
import com.larus.apm.api.IExtraParams;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/apm/impl/ExtraParamsImpl;", "Lcom/larus/apm/api/IExtraParams;", "<init>", "()V", "_staticParams", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "staticParams", "getStaticParams", "()Ljava/util/Map;", "getAppVariant", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ExtraParamsImpl implements IExtraParams {
    public final Map<String, String> b;

    @Override // com.larus.apm.api.IExtraParams
    public final String b() {
        return "obric";
    }

    public ExtraParamsImpl() {
        this.b = MapsKt.mapOf(new Pair[]{TuplesKt.to("flow_git_commit_id", o0.a("fc4b8ba9c915")), TuplesKt.to("flow_build_job_id", o0.a("887485629")), TuplesKt.to("flow_build_branch", o0.a("obric/rls/15.2.0.1")), TuplesKt.to("flow_process_name", o0.a(d.c())), TuplesKt.to("flow_process_id", o0.a(String.valueOf(Process.myPid()))), TuplesKt.to("flow_app_variant", "obric")});
    }

    @Override // com.larus.apm.api.IExtraParams
    public final Map<String, String> c() {
        return this.b;
    }
}
