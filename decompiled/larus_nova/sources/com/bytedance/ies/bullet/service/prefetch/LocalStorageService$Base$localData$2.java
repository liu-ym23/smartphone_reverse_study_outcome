package com.bytedance.ies.bullet.service.prefetch;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3}, xi = 48)
final class LocalStorageService$Base$localData$2 extends Lambda implements Function0<Map<String, JSONObject>> {
    public static final LocalStorageService$Base$localData$2 INSTANCE = null;

    static {
        INSTANCE = new LocalStorageService$Base$localData$2();
    }

    public LocalStorageService$Base$localData$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, JSONObject> invoke2() {
        return new LinkedHashMap();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, JSONObject> invoke() {
        return invoke2();
    }
}
