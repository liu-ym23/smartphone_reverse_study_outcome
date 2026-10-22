package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes23.dex */
public final class BulletViewMethodFinder extends MethodFinder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<IDLXBridgeMethod> f278377d;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final String f() {
        return "";
    }

    public BulletViewMethodFinder() {
        this.f278377d = new HashSet();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.MethodFinder
    public final IDLXBridgeMethod h(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        return (IDLXBridgeMethod) SequencesKt.firstOrNull(SequencesKt.filter(CollectionsKt.asSequence(this.f278377d), new BulletViewMethodFinder$loadMethod$1(r100)));
    }
}
