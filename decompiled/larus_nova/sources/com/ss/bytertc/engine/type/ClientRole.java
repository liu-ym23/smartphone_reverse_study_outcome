package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ClientRole extends Enum<ClientRole> {
    private static final /* synthetic */ ClientRole[] $VALUES = null;
    public static final ClientRole CLIENT_ROLE_BROADCASTER = null;
    public static final ClientRole CLIENT_ROLE_SILENT_AUDIENCE = null;

    static {
        ClientRole r100 = new ClientRole("CLIENT_ROLE_BROADCASTER", 0);
        CLIENT_ROLE_BROADCASTER = r100;
        ClientRole r101 = new ClientRole("CLIENT_ROLE_SILENT_AUDIENCE", 1);
        CLIENT_ROLE_SILENT_AUDIENCE = r101;
        $VALUES = new ClientRole[]{r100, r101};
    }

    public static ClientRole[] values() {
        return (ClientRole[]) $VALUES.clone();
    }

    public static ClientRole valueOf(String r100) {
        return (ClientRole) a.a(ClientRole.class, r100);
    }

    private ClientRole(String r100, int r101) {
        super(r100, r101);
    }
}
