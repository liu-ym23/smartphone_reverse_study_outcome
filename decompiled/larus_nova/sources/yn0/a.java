package yn0;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements l81.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f568495a = null;

    public a() {
    }

    static {
        f568495a = new a();
    }

    @Override // l81.a
    public final Long getCurrentGameId() {
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r100 = AudienceGameContext.a.a();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.r> r101 = r100.getCurrentGame();
        if (r101 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.r r102 = r101.getValue();
        if (r102 == null) goto L9;
        return Long.valueOf(r102.p());
    L9:
        return null;
    }

    @Override // l81.a
    public final String getCurrentGameName() {
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r100 = AudienceGameContext.a.a();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.r> r101 = r100.getCurrentGame();
        if (r101 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.r r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.q();
    L9:
        return null;
    }
}
