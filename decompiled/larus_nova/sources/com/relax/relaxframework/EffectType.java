package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/relax/relaxframework/EffectType;", "", "", "value", "J", "getValue", "()J", "Render", "Normal", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum EffectType extends Enum<EffectType> {
    public static final EffectType Normal = null;
    public static final EffectType Render = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EffectType[] f404712a = null;
    private final long value;

    public static EffectType valueOf(String r100) {
        return (EffectType) r27.a.a(EffectType.class, r100);
    }

    public static EffectType[] values() {
        return (EffectType[]) f404712a.clone();
    }

    static {
        EffectType r100 = new EffectType("Render", 0, 1);
        Render = r100;
        EffectType r101 = new EffectType("Normal", 1, 2);
        Normal = r101;
        f404712a = new EffectType[]{r100, r101};
    }

    public final long getValue() {
        return this.value;
    }

    public EffectType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
