package i8a;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.IServiceProvider;

/* JADX INFO: loaded from: classes32.dex */
public interface b extends IServiceProvider {
    void onLynxEnvSetup();

    void onLynxViewDestroy(LynxContext r100);

    void onLynxViewSetup(LynxContext r100, LynxGroup r101, com.lynx.tasm.behavior.c r102);
}
