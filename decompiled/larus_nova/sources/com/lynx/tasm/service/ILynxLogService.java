package com.lynx.tasm.service;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxLogService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxLogService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxLogService r100) {
            return ILynxLogService.class;
        }
    }

    public static final enum LogOutputChannelType extends Enum<LogOutputChannelType> {
        public static final LogOutputChannelType Native = null;
        public static final LogOutputChannelType Platform = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogOutputChannelType[] f383735a = null;

        static {
            LogOutputChannelType r100 = new LogOutputChannelType("Native", 0);
            Native = r100;
            LogOutputChannelType r101 = new LogOutputChannelType("Platform", 1);
            Platform = r101;
            f383735a = new LogOutputChannelType[]{r100, r101};
        }

        public static LogOutputChannelType[] values() {
            return (LogOutputChannelType[]) f383735a.clone();
        }

        public static LogOutputChannelType valueOf(String r100) {
            return (LogOutputChannelType) a.a(LogOutputChannelType.class, r100);
        }

        public LogOutputChannelType(String r100, int r101) {
            super(r100, r101);
        }
    }

    long getDefaultWriteFunction();

    boolean getLogToSystemStatus();

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    boolean isLogOutputByPlatform();

    void logByPlatform(int r100, String r101, String r102);

    void switchLogToSystem(boolean r100);
}
