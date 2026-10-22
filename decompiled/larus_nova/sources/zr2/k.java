package zr2;

import android.os.Bundle;
import com.bytedance.android.livesdk.revenue.toolbar.RevRedDot;
import com.bytedance.android.livesdkapi.room.handler.enterroom.EnterKey;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessSession;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class k implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.util.l f573391a;

    public static final class a implements ILiveEnterRoomCallback {

        /* JADX INFO: renamed from: zr2.k$a$a, reason: collision with other inner class name */
        public static final class C8487a implements ILiveEnterRoomParams {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final EnterKey.PreviewToolbar.Revenue f573392a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Bundle f573393b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f573394c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Map<String, String> f573395d;

            @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams
            public final Bundle getFirstRoomLogParams() {
                return null;
            }

            public C8487a() {
                this.f573392a = EnterKey.PreviewToolbar.Revenue.INSTANCE;
                this.f573393b = new Bundle();
                this.f573394c = "";
                this.f573395d = MapsKt.emptyMap();
            }

            @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams
            public final Bundle getBusinessBundle() {
                return this.f573393b;
            }

            @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams
            public final String getClickMethod() {
                return this.f573394c;
            }

            @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams
            public final Map<String, String> getCommonLogParams() {
                return this.f573395d;
            }

            @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomParams
            public final EnterKey getEnterKey() {
                return this.f573392a;
            }
        }

        public a() {
        }

        @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback
        public final ILiveEnterRoomParams getEnterParams(ILivePreviewBusinessSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            return new C8487a();
        }

        @Override // com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback
        public final void onBeforeEnterRoom(ILivePreviewBusinessSession r100) {
            Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            ILiveEnterRoomCallback.DefaultImpls.onBeforeEnterRoom(this, r100);
        }
    }

    @Override // zr2.b
    public RevRedDot h7() {
        return null;
    }

    @Override // zr2.b
    public boolean showRedDot() {
        return false;
    }

    public k() {
        this.f573391a = new com.bytedance.android.live.revenue.core.util.l();
    }

    @Override // zr2.b, com.bytedance.android.live.revlink.impl.behavior.d
    public void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r100, "command");
    }

    @Override // zr2.b
    public void d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "button");
        Intrinsics.checkNotNullParameter(r100, "button");
    }

    @Override // zr2.b
    public ILiveEnterRoomCallback k(ILivePreviewBusinessBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        return new a();
    }
}
