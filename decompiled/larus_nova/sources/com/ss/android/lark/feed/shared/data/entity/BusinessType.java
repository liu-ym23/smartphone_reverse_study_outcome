package com.ss.android.lark.feed.shared.data.entity;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/shared/data/entity/BusinessType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "GROUP", "Companion", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BusinessType extends Enum<BusinessType> {
    public static final a Companion = null;
    public static final BusinessType FILTER = null;
    public static final BusinessType GROUP = null;
    public static final BusinessType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BusinessType[] f421140a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f421141b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BusinessType> getEntries() {
        return f421141b;
    }

    static {
        BusinessType r100 = new BusinessType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        BusinessType r101 = new BusinessType(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 1, 1);
        FILTER = r101;
        BusinessType r102 = new BusinessType("GROUP", 2, 2);
        GROUP = r102;
        BusinessType[] r103 = {r100, r101, r102};
        f421140a = r103;
        f421141b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static BusinessType[] values() {
        return (BusinessType[]) f421140a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BusinessType forNumber(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        return UNKNOWN;
    L14:
        return GROUP;
    L15:
        return FILTER;
    L12:
        return UNKNOWN;
    }

    public static BusinessType valueOf(String r100) {
        return (BusinessType) r27.a.a(BusinessType.class, r100);
    }

    public BusinessType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
