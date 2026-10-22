package com.larus.bmhome.chat.component.input;

import com.larus.bmhome.chat.component.camera.CameraInputFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class InputServiceProviderImpl$createInjectToCameraService$1 extends FunctionReferenceImpl implements Function0<CameraInputFragment> {
    public static final InputServiceProviderImpl$createInjectToCameraService$1 INSTANCE = null;

    static {
        INSTANCE = new InputServiceProviderImpl$createInjectToCameraService$1();
    }

    public InputServiceProviderImpl$createInjectToCameraService$1() {
        super(0, CameraInputFragment.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CameraInputFragment invoke() {
        return new CameraInputFragment();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CameraInputFragment invoke() {
        return invoke();
    }
}
