package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\b\u0018\u0000 :2\u00020\u0001:\u0001:B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%J\n\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\tHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u0006;"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/ReferenceSnapshot;", "", "id", "", "name", "protocolDestination", "iconUrl", "documentIconToken", "documentIconObjType", "", "documentIconInfo", "documentIconUrl", "accessTimeSec", "", "avatarKey", "avatarEntityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getProtocolDestination", "getIconUrl", "getDocumentIconToken", "getDocumentIconObjType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDocumentIconInfo", "getDocumentIconUrl", "getAccessTimeSec", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAvatarKey", "getAvatarEntityId", "toEntry", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionSearchEntry;", "type", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/InputReferenceType;", "restoreDocumentIcon", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/InputReferenceDocumentIcon;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/ReferenceSnapshot;", "equals", "", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f298911a = 0;

    @SerializedName("access_time_sec")
    private final Long accessTimeSec;

    @SerializedName("avatar_entity_id")
    private final String avatarEntityId;

    @SerializedName("avatar_key")
    private final String avatarKey;

    @SerializedName("document_icon_info")
    private final String documentIconInfo;

    @SerializedName("document_icon_obj_type")
    private final Integer documentIconObjType;

    @SerializedName("document_icon_token")
    private final String documentIconToken;

    @SerializedName("document_icon_url")
    private final String documentIconUrl;

    @SerializedName("icon_url")
    private final String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f298912id;

    @SerializedName("name")
    private final String name;

    @SerializedName("protocol_destination")
    private final String protocolDestination;

    public static final class a {
        public static e1 a(c1 r110) {
            Intrinsics.checkNotNullParameter(r110, "entry");
            com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r100 = r110.f298904a.f298720f;
            com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r101 = r110.f298904a;
            String r102 = r101.f298715a;
            String r103 = r101.f298716b;
            String r104 = r101.f298718d;
            String r105 = r101.f298719e;
            if (r100 == null) goto L5;
            String r106 = r100.f298746a;
        L6:
            if (r100 == null) goto L8;
            Integer r107 = Integer.valueOf(r100.f298747b);
        L9:
            if (r100 == null) goto L11;
            String r108 = r100.f298748c;
        L12:
            if (r100 == null) goto L14;
            String r109 = r100.f298749d;
        L15:
            Long r111 = r110.f298906c;
            com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r112 = r110.f298904a;
            return new e1(r102, r103, r104, r105, r106, r107, r108, r109, r111, r112.f298723i, r112.f298724j);
        L14:
            r109 = null;
            goto L15
        L11:
            r108 = null;
            goto L12
        L8:
            r107 = null;
            goto L9
        L5:
            r106 = null;
            goto L6
        }
    }

    static {
    }

    public e1() {
        this(null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r101 = (e1) r100;
        if (Intrinsics.areEqual(this.f298912id, r101.f298912id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.protocolDestination, r101.protocolDestination) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.documentIconToken, r101.documentIconToken) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.documentIconObjType, r101.documentIconObjType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.documentIconInfo, r101.documentIconInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.documentIconUrl, r101.documentIconUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.accessTimeSec, r101.accessTimeSec) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.avatarKey, r101.avatarKey) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.avatarEntityId, r101.avatarEntityId) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f298912id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.protocolDestination;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.iconUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.documentIconToken;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.documentIconObjType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.documentIconInfo;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.documentIconUrl;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.accessTimeSec;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.avatarKey;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.avatarEntityId;
        if (r131 == null) goto L47;
        r101 = r131.hashCode();
    L47:
        return r130 + r101;
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReferenceSnapshot(id=" + this.f298912id + ", name=" + this.name + ", protocolDestination=" + this.protocolDestination + ", iconUrl=" + this.iconUrl + ", documentIconToken=" + this.documentIconToken + ", documentIconObjType=" + this.documentIconObjType + ", documentIconInfo=" + this.documentIconInfo + ", documentIconUrl=" + this.documentIconUrl + ", accessTimeSec=" + this.accessTimeSec + ", avatarKey=" + this.avatarKey + ", avatarEntityId=" + this.avatarEntityId + ')';
    }

    public final c1 a(InputReferenceType r110) {
        Intrinsics.checkNotNullParameter(r110, "type");
        if (r110 != InputReferenceType.GROUP) goto L8;
        Regex r100 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.f298733a;
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r101 = com.larus.bmhome.chat.component.bottom.core.inputtext.f0.e(this.f298912id, this.name, this.avatarKey, this.avatarEntityId);
        if (r101 != null) goto L7;
        return null;
    L7:
        return new c1(r101, null, null, 6);
    L8:
        String r102 = this.f298912id;
        if (r102 == null) goto L63;
        boolean r111 = true;
        if ((!StringsKt.isBlank(r102)) == false) goto L13;
        String r103 = r102;
    L14:
        if (r103 == null) goto L63;
        String r104 = this.name;
        if (r104 == null) goto L63;
        if ((!StringsKt.isBlank(r104)) == false) goto L21;
        String r105 = r104;
    L22:
        if (r105 == null) goto L63;
        String r106 = this.protocolDestination;
        String r107 = this.iconUrl;
        String r108 = this.documentIconToken;
        String r109 = "";
        if (r108 != null) goto L27;
        r108 = "";
    L27:
        Integer r112 = this.documentIconObjType;
        if (r112 == null) goto L30;
        int r113 = r112.intValue();
    L31:
        String r114 = this.documentIconInfo;
        if (r114 != null) goto L34;
        r114 = "";
    L34:
        String r115 = this.documentIconUrl;
        if (r115 == null) goto L38;
        r109 = r115;
    L38:
        com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r116 = new com.larus.bmhome.chat.component.bottom.core.inputtext.i0(r108, r113, r114, r109);
        if ((!StringsKt.isBlank(r116.f298746a)) == false) goto L41;
    L48:
        boolean r117 = true;
    L49:
        if (r117 == false) goto L51;
        com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r118 = r116;
    L52:
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r119 = new com.larus.bmhome.chat.component.bottom.core.inputtext.d0(r103, r105, r110, r106, r107, r118, null, null, null, null, 960);
        Long r120 = this.accessTimeSec;
        if (r120 != null) goto L55;
    L60:
        r120 = null;
    L62:
        return new c1(r119, null, r120, 2);
    L55:
        if (r120.longValue() > 0) goto L58;
        r111 = false;
    L58:
        if (r111 == false) goto L60;
    L51:
        r118 = null;
        goto L52
    L41:
        if (r116.f298747b != 0) goto L48;
        if ((!StringsKt.isBlank(r116.f298748c)) == true) goto L48;
        if ((!StringsKt.isBlank(r116.f298749d)) == true) goto L48;
        r117 = false;
        goto L49
    L30:
        r113 = 0;
        goto L31
    L21:
        r105 = null;
        goto L22
    L13:
        r103 = null;
    L63:
        return null;
    }

    public e1(String r100, String r101, String r102, String r103, String r104, Integer r105, String r106, String r107, Long r108, String r110, String r111) {
        this.f298912id = r100;
        this.name = r101;
        this.protocolDestination = r102;
        this.iconUrl = r103;
        this.documentIconToken = r104;
        this.documentIconObjType = r105;
        this.documentIconInfo = r106;
        this.documentIconUrl = r107;
        this.accessTimeSec = r108;
        this.avatarKey = r110;
        this.avatarEntityId = r111;
    }
}
