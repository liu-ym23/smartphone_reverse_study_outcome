package pq0;

import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.comment.AudienceCommentContextService;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends yo0.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f530260f;

    @Override // yo0.a
    public final String b() {
        return this.f530260f;
    }

    @Override // yo0.a
    public void call(JSONObject r100, yo0.a.b r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        JSONObject r102 = new JSONObject();
        Map<Long, Integer> r103 = ((AudienceCommentContextService) this.f568619b.getService(AudienceCommentContextService.class)).f84782a;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r104 = AudienceMiniAppDataContext.a.a();
        if (r104 == null) goto L9;
        n<ShelfInfo> r105 = r104.m8183getShelfInfo();
        if (r105 == null) goto L9;
        ShelfInfo r106 = r105.getValue();
        if (r106 == null) goto L9;
        long r107 = r106.startId;
    L10:
        LinkedHashMap r108 = (LinkedHashMap) r103;
        Object r109 = r108.get(Long.valueOf(r107));
        if (r109 != null) goto L13;
        r109 = 0;
    L13:
        r102.put("commentCount", ((Number) r109).intValue());
        Unit r110 = Unit.INSTANCE;
        r101.c(r102);
        return;
    L9:
        r107 = 0;
        goto L10
    }

    public a(OpenPlatformContext r100, Queue<Long> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r101, "callHistory");
        Intrinsics.checkNotNullParameter(r102, "appId");
        super(r100, r101, r102);
        this.f530260f = "getSelfCommentCountDuringPluginRunning";
    }
}
