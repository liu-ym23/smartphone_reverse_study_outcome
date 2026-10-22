package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/relax/relaxframework/ListUpdateAnimationType;", "", "", "value", "I", "getValue", "()I", "ListUpdateAnimationDefault", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ListUpdateAnimationType extends Enum<ListUpdateAnimationType> {
    public static final ListUpdateAnimationType ListUpdateAnimationDefault = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ListUpdateAnimationType[] f404777a = null;
    private final int value;

    public static ListUpdateAnimationType valueOf(String r100) {
        return (ListUpdateAnimationType) r27.a.a(ListUpdateAnimationType.class, r100);
    }

    public static ListUpdateAnimationType[] values() {
        return (ListUpdateAnimationType[]) f404777a.clone();
    }

    static {
        ListUpdateAnimationType r100 = new ListUpdateAnimationType();
        ListUpdateAnimationDefault = r100;
        f404777a = new ListUpdateAnimationType[]{r100};
    }

    public ListUpdateAnimationType() {
        super("ListUpdateAnimationDefault", 0);
        this.value = 40011;
    }

    public final int getValue() {
        return this.value;
    }
}
