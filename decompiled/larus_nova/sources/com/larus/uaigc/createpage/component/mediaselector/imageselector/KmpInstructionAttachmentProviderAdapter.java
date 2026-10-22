package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import androidx.lifecycle.FlowLiveDataConversions;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes31.dex */
public final class KmpInstructionAttachmentProviderAdapter implements dq8.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ry9.h f371957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KmpInstructionAttachmentProviderAdapter$special$$inlined$map$1 f371958b;

    @Override // dq8.f
    public final List<MediaAttachment> a() {
        return this.f371957a.DX();
    }

    @Override // dq8.f
    public final Flow<Unit> b() {
        return this.f371958b;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.uaigc.createpage.component.mediaselector.imageselector.KmpInstructionAttachmentProviderAdapter$special$$inlined$map$1] */
    public KmpInstructionAttachmentProviderAdapter(ry9.h r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f371957a = r100;
        final Flow r101 = FlowLiveDataConversions.asFlow(r100.ja());
        this.f371958b = new KmpInstructionAttachmentProviderAdapter$special$$inlined$map$1(r101);
    }
}
