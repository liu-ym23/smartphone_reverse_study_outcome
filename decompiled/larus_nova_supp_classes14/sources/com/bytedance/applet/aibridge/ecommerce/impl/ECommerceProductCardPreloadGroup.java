package com.bytedance.applet.aibridge.ecommerce.impl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/ECommerceProductCardPreloadGroup;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DISABLED", "CARD_EXPOSURE", "LATEST_NEW_MESSAGE", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ECommerceProductCardPreloadGroup extends Enum<ECommerceProductCardPreloadGroup> {
    public static final ECommerceProductCardPreloadGroup CARD_EXPOSURE = null;
    public static final a Companion = null;
    public static final ECommerceProductCardPreloadGroup DISABLED = null;
    public static final ECommerceProductCardPreloadGroup LATEST_NEW_MESSAGE = null;
    public static final /* synthetic */ ECommerceProductCardPreloadGroup[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ECommerceProductCardPreloadGroup> getEntries() {
        return b;
    }

    static {
        ECommerceProductCardPreloadGroup r0 = new ECommerceProductCardPreloadGroup("DISABLED", 0, 0);
        DISABLED = r0;
        ECommerceProductCardPreloadGroup r1 = new ECommerceProductCardPreloadGroup("CARD_EXPOSURE", 1, 1);
        CARD_EXPOSURE = r1;
        ECommerceProductCardPreloadGroup r3 = new ECommerceProductCardPreloadGroup("LATEST_NEW_MESSAGE", 2, 2);
        LATEST_NEW_MESSAGE = r3;
        ECommerceProductCardPreloadGroup[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ECommerceProductCardPreloadGroup[] values() {
        return (ECommerceProductCardPreloadGroup[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ECommerceProductCardPreloadGroup valueOf(String r1) {
        return (ECommerceProductCardPreloadGroup) r27.a.a(ECommerceProductCardPreloadGroup.class, r1);
    }

    public ECommerceProductCardPreloadGroup(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
