package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/relax/relaxframework/SvgEventKey;", "", "", "value", "I", "getValue", "()I", "SvgLoad", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum SvgEventKey extends Enum<SvgEventKey> {
    public static final SvgEventKey SvgLoad = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SvgEventKey[] f404962a = null;
    private final int value;

    public static SvgEventKey valueOf(String r100) {
        return (SvgEventKey) r27.a.a(SvgEventKey.class, r100);
    }

    public static SvgEventKey[] values() {
        return (SvgEventKey[]) f404962a.clone();
    }

    static {
        SvgEventKey r100 = new SvgEventKey();
        SvgLoad = r100;
        f404962a = new SvgEventKey[]{r100};
    }

    public SvgEventKey() {
        super("SvgLoad", 0);
        this.value = 30115;
    }

    public final int getValue() {
        return this.value;
    }
}
