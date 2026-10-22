package io.opentelemetry.sdk.logs.data;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
final enum EmptyBody extends Enum<EmptyBody> implements Body {
    public static final EmptyBody INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyBody[] f492719a = null;

    public String asString() {
        return "";
    }

    static {
        EmptyBody r100 = new EmptyBody();
        INSTANCE = r100;
        f492719a = new EmptyBody[]{r100};
    }

    public EmptyBody() {
        super("INSTANCE", 0);
    }

    public static EmptyBody[] values() {
        return (EmptyBody[]) f492719a.clone();
    }

    @Override // io.opentelemetry.sdk.logs.data.Body
    public Body.Type getType() {
        return Body.Type.EMPTY;
    }

    public static EmptyBody valueOf(String r100) {
        return (EmptyBody) a.a(EmptyBody.class, r100);
    }
}
