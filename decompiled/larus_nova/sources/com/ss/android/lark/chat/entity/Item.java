package com.ss.android.lark.chat.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001-BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003Jd\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001c¨\u0006."}, d2 = {"Lcom/ss/android/lark/chat/entity/Item;", "Ljava/io/Serializable;", "id", "", "entityId", "", "entityType", "Lcom/ss/android/lark/chat/entity/Item$Type;", "parentId", "orderWeight", "nameWeight", "version", "isHidden", "", "<init>", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/Item$Type;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;JZ)V", "getId", "()J", "getEntityId", "()Ljava/lang/String;", "getEntityType", "()Lcom/ss/android/lark/chat/entity/Item$Type;", "getParentId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOrderWeight", "getNameWeight", "getVersion", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/Item$Type;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;JZ)Lcom/ss/android/lark/chat/entity/Item;", "equals", "other", "", "hashCode", "", "toString", "Type", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Item implements Serializable {
    private final String entityId;
    private final Type entityType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f415094id;
    private final boolean isHidden;
    private final String nameWeight;
    private final Long orderWeight;
    private final Long parentId;
    private final long version;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/Item$Type;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT", "TEAM", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type CHAT = null;
        public static final a Companion = null;
        public static final Type TEAM = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f415095a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415096b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return f415096b;
        }

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("CHAT", 1, 1);
            CHAT = r101;
            Type r102 = new Type("TEAM", 2, 2);
            TEAM = r102;
            Type[] r103 = {r100, r101, r102};
            f415095a = r103;
            f415096b = EnumEntriesKt.enumEntries(r103);
            Companion = new a();
        }

        public static Type[] values() {
            return (Type[]) f415095a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r100) {
            Companion.getClass();
            Type r101 = CHAT;
            if (r100 == r101.getValue()) goto L10;
            Type r102 = TEAM;
            if (r100 != r102.getValue()) goto L9;
            return r102;
        L9:
            return UNKNOWN;
        L10:
            return r101;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static /* synthetic */ Item copy$default(Item r110, long r111, String r112, Type r113, Long r114, Long r115, String r116, long r117, boolean r210, int r211, Object r212) {
        if ((r211 & 1) == 0) goto L5;
        long r100 = r110.f415094id;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = r110.entityId;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Type r102 = r110.entityType;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Long r103 = r110.parentId;
    L19:
        if ((r211 & 16) == 0) goto L21;
        Long r104 = r110.orderWeight;
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r105 = r110.nameWeight;
    L27:
        if ((r211 & 64) == 0) goto L29;
        long r106 = r110.version;
    L31:
        if ((r211 & 128) == 0) goto L33;
        boolean r107 = r110.isHidden;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.f415094id;
    }

    public final String component2() {
        return this.entityId;
    }

    public final Type component3() {
        return this.entityType;
    }

    public final Long component4() {
        return this.parentId;
    }

    public final Long component5() {
        return this.orderWeight;
    }

    public final String component6() {
        return this.nameWeight;
    }

    public final long component7() {
        return this.version;
    }

    public final boolean component8() {
        return this.isHidden;
    }

    public final Item copy(long r110, String r111, Type r112, Long r113, Long r114, String r115, long r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r111, "entityId");
        Intrinsics.checkNotNullParameter(r112, "entityType");
        return new Item(r110, r111, r112, r113, r114, r115, r210, r211);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Item) == true) goto L8;
        return false;
    L8:
        Item r101 = (Item) r100;
        if (this.f415094id == r101.f415094id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityId, r101.entityId) == true) goto L15;
        return false;
    L15:
        if (this.entityType == r101.entityType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.orderWeight, r101.orderWeight) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.nameWeight, r101.nameWeight) == true) goto L27;
        return false;
    L27:
        if (this.version == r101.version) goto L30;
        return false;
    L30:
        if (this.isHidden == r101.isHidden) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        long r100 = this.f415094id;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.entityId.hashCode()) * 31) + this.entityType.hashCode()) * 31;
        Long r102 = this.parentId;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        Long r106 = this.orderWeight;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.nameWeight;
        if (r109 == null) goto L14;
        r103 = r109.hashCode();
    L14:
        int r110 = (r108 + r103) * 31;
        long r111 = this.version;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        if (this.isHidden == false) goto L17;
        int r113 = 1231;
    L19:
        return r112 + r113;
    L17:
        r113 = 1237;
        goto L19
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "Item(id=" + this.f415094id + ", entityId=" + this.entityId + ", entityType=" + this.entityType + ", parentId=" + this.parentId + ", orderWeight=" + this.orderWeight + ", nameWeight=" + this.nameWeight + ", version=" + this.version + ", isHidden=" + this.isHidden + ')';
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final Type getEntityType() {
        return this.entityType;
    }

    public final long getId() {
        return this.f415094id;
    }

    public final String getNameWeight() {
        return this.nameWeight;
    }

    public final Long getOrderWeight() {
        return this.orderWeight;
    }

    public final Long getParentId() {
        return this.parentId;
    }

    public final long getVersion() {
        return this.version;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public Item(long r100, String r101, Type r102, Long r103, Long r104, String r105, long r106, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "entityId");
        Intrinsics.checkNotNullParameter(r102, "entityType");
        this.f415094id = r100;
        this.entityId = r101;
        this.entityType = r102;
        this.parentId = r103;
        this.orderWeight = r104;
        this.nameWeight = r105;
        this.version = r106;
        this.isHidden = r110;
    }
}
