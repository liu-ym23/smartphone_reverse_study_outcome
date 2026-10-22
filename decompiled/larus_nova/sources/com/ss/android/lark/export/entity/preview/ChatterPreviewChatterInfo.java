package com.ss.android.lark.export.entity.preview;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\"B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J7\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "avatarKey", "", "chatterId", "name", "chatterType", "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo$ChatterType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo$ChatterType;)V", "getAvatarKey", "()Ljava/lang/String;", "getChatterId", "getName", "setName", "(Ljava/lang/String;)V", "getChatterType", "()Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo$ChatterType;", "isItemSame", "", "diffable", "isContentSame", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "ChatterType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterPreviewChatterInfo implements Serializable, b<ChatterPreviewChatterInfo> {
    private final String avatarKey;
    private final String chatterId;
    private final ChatterType chatterType;
    private String name;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo$ChatterType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "getNumber", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatterType extends Enum<ChatterType> {
        public static final a Companion = null;
        public static final ChatterType UNKNOWN = null;
        public static final ChatterType USER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatterType[] f420660a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420661b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ChatterType> getEntries() {
            return f420661b;
        }

        static {
            ChatterType r100 = new ChatterType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatterType r101 = new ChatterType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
            USER = r101;
            ChatterType[] r102 = {r100, r101};
            f420660a = r102;
            f420661b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static ChatterType[] values() {
            return (ChatterType[]) f420660a.clone();
        }

        public final int getNumber() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatterType valueOf(String r100) {
            return (ChatterType) r27.a.a(ChatterType.class, r100);
        }

        public ChatterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ChatterPreviewChatterInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ChatterPreviewChatterInfo copy$default(ChatterPreviewChatterInfo r100, String r101, String r102, String r103, ChatterType r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.avatarKey;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.chatterId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.name;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.chatterType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.chatterId;
    }

    public final String component3() {
        return this.name;
    }

    public final ChatterType component4() {
        return this.chatterType;
    }

    public final ChatterPreviewChatterInfo copy(String r100, String r101, String r102, ChatterType r103) {
        Intrinsics.checkNotNullParameter(r103, "chatterType");
        return new ChatterPreviewChatterInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatterPreviewChatterInfo) == true) goto L8;
        return false;
    L8:
        ChatterPreviewChatterInfo r101 = (ChatterPreviewChatterInfo) r100;
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterId, r101.chatterId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (this.chatterType == r101.chatterType) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.avatarKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.chatterId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.chatterType.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ChatterPreviewChatterInfo(avatarKey=" + this.avatarKey + ", chatterId=" + this.chatterId + ", name=" + this.name + ", chatterType=" + this.chatterType + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public final ChatterType getChatterType() {
        return this.chatterType;
    }

    public final String getName() {
        return this.name;
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((ChatterPreviewChatterInfo) r100);
    }

    public boolean isItemSame(ChatterPreviewChatterInfo r100) {
        String r101 = this.chatterId;
        if (r100 == null) goto L5;
        String r102 = r100.chatterId;
    L7:
        return Intrinsics.areEqual(r101, r102);
    L5:
        r102 = null;
        goto L7
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public boolean isContentSame(ChatterPreviewChatterInfo r100) {
        return Intrinsics.areEqual(this, r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((ChatterPreviewChatterInfo) r100);
    }

    public ChatterPreviewChatterInfo(String r100, String r101, String r102, ChatterType r103) {
        Intrinsics.checkNotNullParameter(r103, "chatterType");
        this.avatarKey = r100;
        this.chatterId = r101;
        this.name = r102;
        this.chatterType = r103;
    }

    public /* synthetic */ ChatterPreviewChatterInfo(String r100, String r101, String r102, ChatterType r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = ChatterType.USER;
    L14:
        this(r100, r101, r102, r103);
    }
}
