package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/salamander/anniex/ContainerName;", "", "", "value", "I", "getValue", "()I", "AnnieX", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ContainerName extends Enum<ContainerName> {
    public static final ContainerName AnnieX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerName[] f267872a = null;
    private final int value;

    public static ContainerName valueOf(String r100) {
        return (ContainerName) r27.a.a(ContainerName.class, r100);
    }

    public static ContainerName[] values() {
        return (ContainerName[]) f267872a.clone();
    }

    static {
        ContainerName r100 = new ContainerName();
        AnnieX = r100;
        f267872a = new ContainerName[]{r100};
    }

    public ContainerName() {
        super("AnnieX", 0);
        this.value = 0;
    }

    public final int getValue() {
        return this.value;
    }
}
