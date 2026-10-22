package com.ss.bytertc.engine;

import com.ss.bytertc.engine.type.LocalProxyConfiguration;
import com.ss.bytertc.engine.type.LocalProxyType;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public class InternalLocalProxyConfiguration {
    public String localProxyIp;
    public String localProxyPassword;
    public int localProxyPort;
    public InternalLocalProxyType localProxyType;
    public String localProxyUsername;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.InternalLocalProxyConfiguration$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$LocalProxyType = null;

        static {
            int[] r100 = new int[LocalProxyType.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$LocalProxyType = r100;
            r100[LocalProxyType.SOCKS5.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$type$LocalProxyType[LocalProxyType.HTTP_TUNNEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum InternalLocalProxyType extends Enum<InternalLocalProxyType> {
        private static final /* synthetic */ InternalLocalProxyType[] $VALUES = null;
        public static final InternalLocalProxyType HTTP_TUNNEL = null;
        public static final InternalLocalProxyType SOCKS5 = null;
        private int value;

        static {
            InternalLocalProxyType r100 = new InternalLocalProxyType("SOCKS5", 0, 1);
            SOCKS5 = r100;
            InternalLocalProxyType r101 = new InternalLocalProxyType("HTTP_TUNNEL", 1, 2);
            HTTP_TUNNEL = r101;
            $VALUES = new InternalLocalProxyType[]{r100, r101};
        }

        public static InternalLocalProxyType[] values() {
            return (InternalLocalProxyType[]) $VALUES.clone();
        }

        public int getIntValue() {
            return this.value;
        }

        public static InternalLocalProxyType valueOf(String r100) {
            return (InternalLocalProxyType) a.a(InternalLocalProxyType.class, r100);
        }

        private InternalLocalProxyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public String getLocalProxyIp() {
        return this.localProxyIp;
    }

    public String getLocalProxyPassword() {
        return this.localProxyPassword;
    }

    public int getLocalProxyPort() {
        return this.localProxyPort;
    }

    public InternalLocalProxyType getLocalProxyType() {
        return this.localProxyType;
    }

    public String getLocalProxyUsername() {
        return this.localProxyUsername;
    }

    public InternalLocalProxyConfiguration(LocalProxyConfiguration r100) {
        this.localProxyType = ConvertEnumValue(r100.localProxyType);
        this.localProxyIp = r100.localProxyIp;
        this.localProxyPort = r100.localProxyPort;
        this.localProxyUsername = r100.localProxyUsername;
        this.localProxyPassword = r100.localProxyPassword;
    }

    private InternalLocalProxyType ConvertEnumValue(LocalProxyType r100) {
        InternalLocalProxyType r101 = InternalLocalProxyType.SOCKS5;
        int r102 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$LocalProxyType[r100.ordinal()];
        if (r102 != 1) goto L5;
        return r101;
    L5:
        if (r102 == 2) goto L8;
        return r101;
    L8:
        return InternalLocalProxyType.HTTP_TUNNEL;
    }
}
