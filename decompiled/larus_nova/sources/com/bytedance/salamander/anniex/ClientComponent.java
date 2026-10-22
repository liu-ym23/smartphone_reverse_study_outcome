package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/salamander/anniex/ClientComponent;", "", "", "value", "I", "getValue", "()I", "View", "Activity", "DialogFragment", "Fragment", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ClientComponent extends Enum<ClientComponent> {
    public static final ClientComponent Activity = null;
    public static final ClientComponent DialogFragment = null;
    public static final ClientComponent Fragment = null;
    public static final ClientComponent View = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClientComponent[] f267871a = null;
    private final int value;

    public static ClientComponent valueOf(String r100) {
        return (ClientComponent) r27.a.a(ClientComponent.class, r100);
    }

    public static ClientComponent[] values() {
        return (ClientComponent[]) f267871a.clone();
    }

    static {
        ClientComponent r100 = new ClientComponent("View", 0, 0);
        View = r100;
        ClientComponent r101 = new ClientComponent("Activity", 1, 1);
        Activity = r101;
        ClientComponent r102 = new ClientComponent("DialogFragment", 2, 2);
        DialogFragment = r102;
        ClientComponent r103 = new ClientComponent("Fragment", 3, 3);
        Fragment = r103;
        f267871a = new ClientComponent[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ClientComponent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
