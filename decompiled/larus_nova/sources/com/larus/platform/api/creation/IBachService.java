package com.larus.platform.api.creation;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zp9.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/api/creation/IBachService;", "", "preLoad", "", "preLoadScene", "Lcom/larus/platform/api/creation/PreLoadScene;", "getDigitalAvatarBachAbility", "Lcom/larus/platform/api/creation/IBachAvatarDetectAbility;", "digitalAvatarReadyLive", "Landroidx/lifecycle/MutableLiveData;", "", "getDigitalAvatarReadyLive", "()Landroidx/lifecycle/MutableLiveData;", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBachService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f364935a = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/api/creation/IBachService$Companion;", "Lcom/larus/platform/api/creation/IBachService;", "<init>", "()V", "getDigitalAvatarBachAbility", "Lcom/larus/platform/api/creation/IBachAvatarDetectAbility;", "preLoad", "", "preLoadScene", "Lcom/larus/platform/api/creation/PreLoadScene;", "digitalAvatarReadyLive", "Landroidx/lifecycle/MutableLiveData;", "", "getDigitalAvatarReadyLive", "()Landroidx/lifecycle/MutableLiveData;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IBachService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f364936c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IBachService f364937b;

        static {
            f364936c = new Companion();
        }

        @Override // com.larus.platform.api.creation.IBachService
        public final i a() {
            return this.f364937b.a();
        }

        @Override // com.larus.platform.api.creation.IBachService
        public final MutableLiveData<Boolean> b() {
            return this.f364937b.b();
        }

        @Override // com.larus.platform.api.creation.IBachService
        public final void c(PreLoadScene r100) {
            Intrinsics.checkNotNullParameter(r100, "preLoadScene");
            this.f364937b.c(r100);
        }

        private Companion() {
            IBachService r100 = (IBachService) ServiceManager.get().getService(IBachService.class);
            if (r100 != null) goto L5;
            r100 = new BachServiceNoop();
        L5:
            this.f364937b = r100;
        }
    }

    static {
        f364935a = Companion.f364936c;
    }

    i a();

    MutableLiveData<Boolean> b();

    void c(PreLoadScene r100);
}
