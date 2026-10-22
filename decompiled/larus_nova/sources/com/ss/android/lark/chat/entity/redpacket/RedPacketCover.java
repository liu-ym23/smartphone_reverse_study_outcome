package com.ss.android.lark.chat.entity.redpacket;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.image.entity.PassThroughImage;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u00014Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J{\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016¨\u00065"}, d2 = {"Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover;", "Ljava/io/Serializable;", "id", "", "name", "", "coverType", "Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover$CoverType;", "mainCover", "Lcom/ss/android/lark/image/entity/PassThroughImage;", "messageCover", "headCover", "companyLogo", "selectCover", CommonConstant.KEY_DISPLAY_NAME, "Lcom/ss/android/lark/chat/entity/redpacket/RedPacketDisplayName;", "companyName", "<init>", "(JLjava/lang/String;Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover$CoverType;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/image/entity/PassThroughImage;Lcom/ss/android/lark/chat/entity/redpacket/RedPacketDisplayName;Ljava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getCoverType", "()Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover$CoverType;", "getMainCover", "()Lcom/ss/android/lark/image/entity/PassThroughImage;", "getMessageCover", "getHeadCover", "getCompanyLogo", "getSelectCover", "getDisplayName", "()Lcom/ss/android/lark/chat/entity/redpacket/RedPacketDisplayName;", "getCompanyName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "", "hashCode", "", "toString", "CoverType", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedPacketCover implements Serializable {
    private final PassThroughImage companyLogo;
    private final String companyName;
    private final CoverType coverType;
    private final RedPacketDisplayName displayName;
    private final PassThroughImage headCover;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f415358id;
    private final PassThroughImage mainCover;
    private final PassThroughImage messageCover;
    private final String name;
    private final PassThroughImage selectCover;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/redpacket/RedPacketCover$CoverType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TEMPLATE", "CUSTOMIZE", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CoverType extends Enum<CoverType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ CoverType[] $VALUES = null;
        public static final CoverType CUSTOMIZE = null;
        public static final CoverType TEMPLATE = null;
        public static final CoverType UNKNOWN = null;

        private static final /* synthetic */ CoverType[] $values() {
            return new CoverType[]{UNKNOWN, TEMPLATE, CUSTOMIZE};
        }

        public static EnumEntries<CoverType> getEntries() {
            return $ENTRIES;
        }

        static {
            UNKNOWN = new CoverType("UNKNOWN", 0);
            TEMPLATE = new CoverType("TEMPLATE", 1);
            CUSTOMIZE = new CoverType("CUSTOMIZE", 2);
            CoverType[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static CoverType[] values() {
            return (CoverType[]) $VALUES.clone();
        }

        public static CoverType valueOf(String r100) {
            return (CoverType) a.a(CoverType.class, r100);
        }

        private CoverType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ RedPacketCover copy$default(RedPacketCover r110, long r111, String r112, CoverType r113, PassThroughImage r114, PassThroughImage r115, PassThroughImage r116, PassThroughImage r210, PassThroughImage r211, RedPacketDisplayName r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        long r100 = r110.f415358id;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.name;
    L11:
        if ((r214 & 4) == 0) goto L13;
        CoverType r102 = r110.coverType;
    L15:
        if ((r214 & 8) == 0) goto L17;
        PassThroughImage r103 = r110.mainCover;
    L19:
        if ((r214 & 16) == 0) goto L21;
        PassThroughImage r104 = r110.messageCover;
    L23:
        if ((r214 & 32) == 0) goto L25;
        PassThroughImage r105 = r110.headCover;
    L27:
        if ((r214 & 64) == 0) goto L29;
        PassThroughImage r106 = r110.companyLogo;
    L31:
        if ((r214 & 128) == 0) goto L33;
        PassThroughImage r117 = r110.selectCover;
    L35:
        if ((r214 & 256) == 0) goto L37;
        RedPacketDisplayName r118 = r110.displayName;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r107 = r110.companyName;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117, r118, r107);
    L41:
        r107 = r213;
        goto L43
    L37:
        r118 = r212;
        goto L39
    L33:
        r117 = r211;
        goto L35
    L29:
        r106 = r210;
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
        return this.f415358id;
    }

    public final String component10() {
        return this.companyName;
    }

    public final String component2() {
        return this.name;
    }

    public final CoverType component3() {
        return this.coverType;
    }

    public final PassThroughImage component4() {
        return this.mainCover;
    }

    public final PassThroughImage component5() {
        return this.messageCover;
    }

    public final PassThroughImage component6() {
        return this.headCover;
    }

    public final PassThroughImage component7() {
        return this.companyLogo;
    }

    public final PassThroughImage component8() {
        return this.selectCover;
    }

    public final RedPacketDisplayName component9() {
        return this.displayName;
    }

    public final RedPacketCover copy(long r110, String r111, CoverType r112, PassThroughImage r113, PassThroughImage r114, PassThroughImage r210, PassThroughImage r211, PassThroughImage r212, RedPacketDisplayName r213, String r214) {
        Intrinsics.checkNotNullParameter(r111, "name");
        Intrinsics.checkNotNullParameter(r112, "coverType");
        return new RedPacketCover(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RedPacketCover) == true) goto L8;
        return false;
    L8:
        RedPacketCover r101 = (RedPacketCover) r100;
        if (this.f415358id == r101.f415358id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (this.coverType == r101.coverType) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mainCover, r101.mainCover) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageCover, r101.messageCover) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headCover, r101.headCover) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.companyLogo, r101.companyLogo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.selectCover, r101.selectCover) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.companyName, r101.companyName) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        long r100 = this.f415358id;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.name.hashCode()) * 31) + this.coverType.hashCode()) * 31;
        PassThroughImage r102 = this.mainCover;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        PassThroughImage r106 = this.messageCover;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        PassThroughImage r109 = this.headCover;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        PassThroughImage r112 = this.companyLogo;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        PassThroughImage r115 = this.selectCover;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        RedPacketDisplayName r118 = this.displayName;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.companyName;
        if (r121 == null) goto L31;
        r103 = r121.hashCode();
    L31:
        return r120 + r103;
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "RedPacketCover(id=" + this.f415358id + ", name=" + this.name + ", coverType=" + this.coverType + ", mainCover=" + this.mainCover + ", messageCover=" + this.messageCover + ", headCover=" + this.headCover + ", companyLogo=" + this.companyLogo + ", selectCover=" + this.selectCover + ", displayName=" + this.displayName + ", companyName=" + this.companyName + ')';
    }

    public final PassThroughImage getCompanyLogo() {
        return this.companyLogo;
    }

    public final String getCompanyName() {
        return this.companyName;
    }

    public final CoverType getCoverType() {
        return this.coverType;
    }

    public final RedPacketDisplayName getDisplayName() {
        return this.displayName;
    }

    public final PassThroughImage getHeadCover() {
        return this.headCover;
    }

    public final long getId() {
        return this.f415358id;
    }

    public final PassThroughImage getMainCover() {
        return this.mainCover;
    }

    public final PassThroughImage getMessageCover() {
        return this.messageCover;
    }

    public final String getName() {
        return this.name;
    }

    public final PassThroughImage getSelectCover() {
        return this.selectCover;
    }

    public RedPacketCover(long r100, String r101, CoverType r102, PassThroughImage r103, PassThroughImage r104, PassThroughImage r105, PassThroughImage r106, PassThroughImage r110, RedPacketDisplayName r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "coverType");
        this.f415358id = r100;
        this.name = r101;
        this.coverType = r102;
        this.mainCover = r103;
        this.messageCover = r104;
        this.headCover = r105;
        this.companyLogo = r106;
        this.selectCover = r110;
        this.displayName = r111;
        this.companyName = r112;
    }
}
