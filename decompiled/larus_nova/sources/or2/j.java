package or2;

import com.bytedance.android.livesdkapi.roomplayer.ComposerResult;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IVideoEffectControl;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements or2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILivePlayerClient f524926a;

    public static final class a implements ComposerResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.effect.g f524927a;

        public a(com.bytedance.android.livesdk.revenue.service.effect.g r100) {
            this.f524927a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.ComposerResult
        public final void onResult(int r100) {
            this.f524927a.onResult(r100);
        }
    }

    public static final class b implements ComposerResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.revenue.service.effect.g f524928a;

        public b(com.bytedance.android.livesdk.revenue.service.effect.g r100) {
            this.f524928a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.ComposerResult
        public final void onResult(int r100) {
            this.f524928a.onResult(r100);
        }
    }

    @Override // or2.f
    public final boolean M() {
        return IVideoEffectControl.DefaultImpls.isEffectUsed$default(this.f524926a, 0, 1, null);
    }

    public final i b() {
        return new i(this.f524926a.context());
    }

    public final String c() {
        return this.f524926a.getCurrentResolution();
    }

    public final m d() {
        return new m(this.f524926a.getEventHub());
    }

    public final boolean e() {
        return this.f524926a.getHasFirstFrame();
    }

    public final JSONObject f() {
        return this.f524926a.getStatsLog();
    }

    public final void g() {
        this.f524926a.releaseEffect();
    }

    @Override // or2.b
    public final int getVoiceDB() {
        return this.f524926a.getVoiceDB();
    }

    @Override // or2.f
    public final boolean isEffectInited() {
        return this.f524926a.isEffectInited();
    }

    public j(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f524926a = r100;
    }

    public final void i(boolean r100) {
        this.f524926a.setEnable(r100, 1);
    }

    public final void j(String r100) {
        this.f524926a.setRenderCacheStringValue("LiveGrids", r100);
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resolution");
        this.f524926a.smoothSwitchResolution(r100, 2, true);
    }

    public final void h(String[] r100, com.bytedance.android.livesdk.revenue.service.effect.g r101) {
        Intrinsics.checkNotNullParameter(r101, "composerResult");
        this.f524926a.removeComposerNodes(r100, new b(r101));
    }

    public final void a(String[] r100, String[] r101, com.bytedance.android.livesdk.revenue.service.effect.g r102) {
        Intrinsics.checkNotNullParameter(r102, "composerResult");
        this.f524926a.appendComposerNodes(r100, r101, new a(r102));
    }

    @Override // or2.f
    public final void sendMessage(int r100, int r101, int r102, String r103) {
        this.f524926a.sendMessage(r100, r101, r102, r103);
    }
}
