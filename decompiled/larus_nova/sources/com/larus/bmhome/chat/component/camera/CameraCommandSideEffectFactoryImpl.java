package com.larus.bmhome.chat.component.camera;

import com.larus.bmhome.chat.camera.command.CameraCommandSideEffectFactory;
import com.larus.bmhome.chat.camera.command.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import od8.m0;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/camera/CameraCommandSideEffectFactoryImpl;", "Lcom/larus/bmhome/chat/camera/command/CameraCommandSideEffectFactory;", "<init>", "()V", "create", "Lcom/larus/bmhome/chat/camera/command/CameraCommandSideEffect;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/chat/camera/command/CameraCommandSideEffectContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraCommandSideEffectFactoryImpl implements CameraCommandSideEffectFactory {
    public CameraCommandSideEffectFactoryImpl() {
    }

    @Override // com.larus.bmhome.chat.camera.command.CameraCommandSideEffectFactory
    public final m0 a(e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new m0(r100);
    }
}
