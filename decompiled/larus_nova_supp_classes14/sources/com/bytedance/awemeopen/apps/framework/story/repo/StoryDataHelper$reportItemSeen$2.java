package com.bytedance.awemeopen.apps.framework.story.repo;

import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class StoryDataHelper$reportItemSeen$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<String> $aids;

    public StoryDataHelper$reportItemSeen$2(List<String> r1) {
        this.$aids = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1581invoke() {
        String r0 = c.a;
        List<String> r1 = this.$aids;
        Intrinsics.checkNotNullParameter(r1, "seenAids");
        JSONObject r2 = new JSONObject().put("items", new JSONArray(r1));     // Catch: Throwable -> L7
        Function0 r3 = AoNet.a;     // Catch: Throwable -> L7
        AoNetResponse r4 = AoNet.e(c.b, new LinkedHashMap(), r2);     // Catch: Throwable -> L7
        if (r4.isSuccessful() == false) goto L12;
        a r5 = (a) GsonHolder.a().fromJson(r4.stringBody(), a.class);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        new Exception(th);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1581invoke();
        return Unit.INSTANCE;
    }
}
