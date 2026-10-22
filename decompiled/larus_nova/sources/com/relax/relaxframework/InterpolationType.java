package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/relax/relaxframework/InterpolationType;", "", "", "value", "I", "getValue", "()I", "Raw", "Signal", "Reactive", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum InterpolationType extends Enum<InterpolationType> {
    public static final InterpolationType Raw = null;
    public static final InterpolationType Reactive = null;
    public static final InterpolationType Signal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterpolationType[] f404747a = null;
    private final int value;

    public static InterpolationType valueOf(String r100) {
        return (InterpolationType) r27.a.a(InterpolationType.class, r100);
    }

    public static InterpolationType[] values() {
        return (InterpolationType[]) f404747a.clone();
    }

    static {
        InterpolationType r100 = new InterpolationType("Raw", 0, 0);
        Raw = r100;
        InterpolationType r101 = new InterpolationType("Signal", 1, 1);
        Signal = r101;
        InterpolationType r102 = new InterpolationType("Reactive", 2, 2);
        Reactive = r102;
        f404747a = new InterpolationType[]{r100, r101, r102};
    }

    public final int getValue() {
        return this.value;
    }

    public InterpolationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
