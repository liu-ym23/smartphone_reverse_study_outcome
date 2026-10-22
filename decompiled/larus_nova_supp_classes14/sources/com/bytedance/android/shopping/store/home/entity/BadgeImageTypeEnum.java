package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/BadgeImageTypeEnum;", "", "UNKNOWN", "UPDATE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BadgeImageTypeEnum extends Enum<BadgeImageTypeEnum> {
    public static final BadgeImageTypeEnum UNKNOWN = null;
    public static final BadgeImageTypeEnum UPDATE = null;
    public static final /* synthetic */ BadgeImageTypeEnum[] a = null;

    static {
        BadgeImageTypeEnum r1 = new BadgeImageTypeEnum("UNKNOWN", 0);
        UNKNOWN = r1;
        BadgeImageTypeEnum r2 = new BadgeImageTypeEnum("UPDATE", 1);
        UPDATE = r2;
        a = new BadgeImageTypeEnum[]{r1, r2};
    }

    public static BadgeImageTypeEnum valueOf(String r1) {
        return (BadgeImageTypeEnum) r27.a.a(BadgeImageTypeEnum.class, r1);
    }

    public static BadgeImageTypeEnum[] values() {
        return (BadgeImageTypeEnum[]) a.clone();
    }

    public BadgeImageTypeEnum(String r1, int r2) {
        super(r1, r2);
    }
}
