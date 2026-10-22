package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final enum ProtoSyntax extends Enum<ProtoSyntax> {
    public static final ProtoSyntax PROTO2 = null;
    public static final ProtoSyntax PROTO3 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProtoSyntax[] f275833a = null;

    static {
        ProtoSyntax r100 = new ProtoSyntax("PROTO2", 0);
        PROTO2 = r100;
        ProtoSyntax r101 = new ProtoSyntax("PROTO3", 1);
        PROTO3 = r101;
        f275833a = new ProtoSyntax[]{r100, r101};
    }

    public static ProtoSyntax[] values() {
        return (ProtoSyntax[]) f275833a.clone();
    }

    public static ProtoSyntax valueOf(String r100) {
        return (ProtoSyntax) r27.a.a(ProtoSyntax.class, r100);
    }

    public ProtoSyntax(String r100, int r101) {
        super(r100, r101);
    }
}
