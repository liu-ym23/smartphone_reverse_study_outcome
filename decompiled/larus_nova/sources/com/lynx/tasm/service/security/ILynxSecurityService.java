package com.lynx.tasm.service.security;

import com.lynx.tasm.service.IServiceProvider;
import j8a.b;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxSecurityService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.security.ILynxSecurityService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxSecurityService r100) {
            return ILynxSecurityService.class;
        }
    }

    public static final enum LynxTasmType extends Enum<LynxTasmType> {
        public static final LynxTasmType TYPE_DYNAMIC_COMPONENT = null;
        public static final LynxTasmType TYPE_TEMPLATE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxTasmType[] f383774a = null;

        static {
            LynxTasmType r100 = new LynxTasmType("TYPE_TEMPLATE", 0);
            TYPE_TEMPLATE = r100;
            LynxTasmType r101 = new LynxTasmType("TYPE_DYNAMIC_COMPONENT", 1);
            TYPE_DYNAMIC_COMPONENT = r101;
            f383774a = new LynxTasmType[]{r100, r101};
        }

        public static LynxTasmType[] values() {
            return (LynxTasmType[]) f383774a.clone();
        }

        public static LynxTasmType valueOf(String r100) {
            return (LynxTasmType) a.a(LynxTasmType.class, r100);
        }

        public LynxTasmType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    b verifyTASM(j8a.a r100, byte[] r101, ByteBuffer r102, String r103, LynxTasmType r104);
}
