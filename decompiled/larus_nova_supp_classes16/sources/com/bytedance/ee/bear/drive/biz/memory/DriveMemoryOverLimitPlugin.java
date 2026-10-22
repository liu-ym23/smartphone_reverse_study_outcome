package com.bytedance.ee.bear.drive.biz.memory;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.quoto.FullQuotoConfig;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.bear.quoto.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/memory/DriveMemoryOverLimitPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "onAttachToHost", "", "host", "onDetachFromHost", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMemoryOverLimitPlugin extends BasePlugin<DrivePluginHost> {
    public static final a Companion = null;
    private static final String TAG = "DriveMemoryOverLimitPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveMemoryOverLimitPlugin b;

        public b(DrivePluginHost r1, DriveMemoryOverLimitPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r9) {
            Integer r10 = (Integer) r9;
            tt5.a.h(DriveMemoryOverLimitPlugin.TAG, "memory over limit: " + r10);
            if ((this.a.c.getOpenEntity() instanceof BaseSpaceOpenEntity) == false) goto L28;
            t r1 = (t) org.koin.java.a.c(t.class, null, null, 6);
            String r3 = this.a.c.getOpenEntity().getFileId();
            Intrinsics.checkNotNull(r10);
            if (r1.q(r10.intValue()) == false) goto L9;
            r1.j(DriveMemoryOverLimitPlugin.access$getActivity(this.b), FullQuotoConfig.SAVE_TO_WPS);
            return;
        L9:
            if (r1.k(r10.intValue()) == false) goto L12;
            r1.c(DriveMemoryOverLimitPlugin.access$getActivity(this.b), r3, FileInfoPuller.CALLER_EXPLORER, false, false, "");
            return;
        L12:
            if (r1.s(r10.intValue()) == false) goto L15;
            r1.c(DriveMemoryOverLimitPlugin.access$getActivity(this.b), r3, FileInfoPuller.CALLER_EXPLORER, false, true, "");
            return;
        L15:
            if (r1.g(r10.intValue()) == false) goto L27;
            w75.a r11 = this.a.c.getFileModel();
            if (r11 == null) goto L21;
            w75.b r12 = r11.c();
            if (r12 == null) goto L21;
            long r2 = r12.c;
        L22:
            r1.f(DriveMemoryOverLimitPlugin.access$getActivity(this.b), SingleFileQuotaConfig.UPLOAD, Long.valueOf(r2));
            return;
        L21:
            r2 = 0;
            goto L22
        L27:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveMemoryOverLimitPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveMemoryOverLimitPlugin r0) {
        return r0.getActivity();
    }

    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        k75.a.i(r4).liveInnerMemoryOverLimit().observe(getLifecycleOwner(), new b(r4, this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public void onDetachFromHost(DrivePluginHost r1) {
        super.onDetachFromHost(r1);
    }
}
