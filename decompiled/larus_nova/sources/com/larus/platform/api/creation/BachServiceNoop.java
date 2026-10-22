package com.larus.platform.api.creation;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zp9.i;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/api/creation/BachServiceNoop;", "Lcom/larus/platform/api/creation/IBachService;", "<init>", "()V", "digitalAvatarReadyLive", "Landroidx/lifecycle/MutableLiveData;", "", "getDigitalAvatarReadyLive", "()Landroidx/lifecycle/MutableLiveData;", "preLoad", "", "preLoadScene", "Lcom/larus/platform/api/creation/PreLoadScene;", "getDigitalAvatarBachAbility", "Lcom/larus/platform/api/creation/IBachAvatarDetectAbility;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BachServiceNoop implements IBachService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f364905b;

    @Override // com.larus.platform.api.creation.IBachService
    public final i a() {
        return null;
    }

    @Override // com.larus.platform.api.creation.IBachService
    public final void c(PreLoadScene r100) {
        Intrinsics.checkNotNullParameter(r100, "preLoadScene");
    }

    public BachServiceNoop() {
        this.f364905b = new MutableLiveData(Boolean.FALSE);
    }

    @Override // com.larus.platform.api.creation.IBachService
    public final MutableLiveData<Boolean> b() {
        return this.f364905b;
    }
}
