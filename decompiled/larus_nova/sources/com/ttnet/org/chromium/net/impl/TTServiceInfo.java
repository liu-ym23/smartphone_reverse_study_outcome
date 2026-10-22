package com.ttnet.org.chromium.net.impl;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public class TTServiceInfo {
    public boolean connected;
    public int identity;
    public boolean lazy;
    public CronetFrontierClient.IServiceMessageReceiver listener;
    public ServicePriority priority;
    public boolean sequence;

    public static final enum ServicePriority extends Enum<ServicePriority> {
        private static final /* synthetic */ ServicePriority[] $VALUES = null;
        public static final ServicePriority High = null;
        public static final ServicePriority Low = null;
        public static final ServicePriority Medium = null;
        final int priority;

        static {
            ServicePriority r100 = new ServicePriority("Low", 0, 0);
            Low = r100;
            ServicePriority r101 = new ServicePriority("Medium", 1, 1);
            Medium = r101;
            ServicePriority r102 = new ServicePriority("High", 2, 2);
            High = r102;
            $VALUES = new ServicePriority[]{r100, r101, r102};
        }

        public static ServicePriority[] values() {
            return (ServicePriority[]) $VALUES.clone();
        }

        public int getValue() {
            return this.priority;
        }

        public static ServicePriority valueOf(String r100) {
            return (ServicePriority) a.a(ServicePriority.class, r100);
        }

        private ServicePriority(String r100, int r101, int r102) {
            super(r100, r101);
            this.priority = r102;
        }
    }

    public TTServiceInfo(int r100, CronetFrontierClient.IServiceMessageReceiver r101) {
        this.sequence = true;
        this.priority = ServicePriority.Low;
        if (r100 <= 0) goto L10;
        if (r101 == null) goto L8;
        this.identity = r100;
        this.listener = r101;
        return;
    L8:
        throw new IllegalArgumentException("Service listener must not be null.");
    L10:
        throw new IllegalArgumentException("Service identity must be set greater than 0.");
    }
}
