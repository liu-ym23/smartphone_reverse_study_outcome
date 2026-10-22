package mv0;

import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends qs0.a<AudienceGameContext> implements qs0.b {
    public a() {
        AudienceGameContext.Companion.getClass();
        super(AudienceGameContext.a.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qs0.b
    public final qs0.b.a j() {
        AudienceGameContext r100 = (AudienceGameContext) this.f534640a;
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.r> r101 = r100.getCurrentGame();
        if (r101 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.model.r r102 = r101.getValue();
        if (r102 == null) goto L9;
        return new qs0.b.a(r102.p(), r102.q());
    L9:
        return null;
    }
}
