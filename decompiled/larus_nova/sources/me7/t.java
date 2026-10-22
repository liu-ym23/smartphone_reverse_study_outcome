package me7;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class t extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f513559h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f513560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f513561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f513562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f513563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f513564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f513565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f513566g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"mainUrl", "subRes", "containerType", "usePreloadJson", "processType", "enableMemory"});
    }

    public t() {
    }
}
