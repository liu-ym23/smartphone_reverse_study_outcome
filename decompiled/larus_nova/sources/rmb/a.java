package rmb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class a implements cza.a {

    /* JADX INFO: renamed from: rmb.a$a, reason: collision with other inner class name */
    public static final class C7502a {
    }

    public static final class b extends SimpleTarget<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback<Drawable> f538619a;

        public b(IGetDataCallback<Drawable> r100) {
            this.f538619a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onLoadFailed(Drawable r100) {
            super.onLoadFailed(r100);
            IGetDataCallback<Drawable> r101 = this.f538619a;
            Exception r102 = new Exception(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
            ErrorResult r103 = new ErrorResult(0);
            ErrorResult.access$002(r103, 0);
            ErrorResult.access$102(r103, -9999);
            ErrorResult.access$202(r103, 0);
            ErrorResult.access$302(r103, r102);
            ErrorResult.access$402(r103, "");
            ErrorResult.access$502(r103, "");
            ErrorResult.access$602(r103, "");
            ErrorResult.access$702(r103, "");
            ErrorResult.access$802(r103, 0);
            ErrorResult.access$902(r103, null);
            ErrorResult.access$1002(r103, null);
            ErrorResult.access$1102(r103, null);
            r101.onError(r103);
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Drawable r101 = (Drawable) r100;
            super.onResourceReady(r101);
            this.f538619a.onSuccess(r101);
        }
    }

    static {
    }

    @Inject
    public a() {
    }

    @Override // cza.a
    public final void a(Context r100, cza.b r101, IGetDataCallback<Drawable> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Log.i("OfficeAvatarService", "load avatar, " + r101.f466135a + ", " + r101.f466136b + ", " + r101.f466137c + ", " + r101.f466138d);
        ImageLoader.with(r100).load(AvatarImage.Builder.obtain(r101.f466135a, r101.f466136b, r101.f466137c, r101.f466138d).build()).override(r101.f466137c, r101.f466138d).asDrawable().into(new b(r102));
    }
}
