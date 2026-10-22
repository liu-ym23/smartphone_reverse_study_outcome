package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006)"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/StickerUploadAuthKeyModel;", "", "session_token", "", "access_key", "secret_key", "expired_time", "current_time", "space_name", "upload_domain", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccess_key", "()Ljava/lang/String;", "setAccess_key", "(Ljava/lang/String;)V", "getCurrent_time", "setCurrent_time", "getExpired_time", "setExpired_time", "getSecret_key", "setSecret_key", "getSession_token", "setSession_token", "getSpace_name", "setSpace_name", "getUpload_domain", "setUpload_domain", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class StickerUploadAuthKeyModel {
    private String access_key;
    private String current_time;
    private String expired_time;
    private String secret_key;
    private String session_token;
    private String space_name;
    private String upload_domain;

    public StickerUploadAuthKeyModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ StickerUploadAuthKeyModel copy$default(StickerUploadAuthKeyModel r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.session_token;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.access_key;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.secret_key;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.expired_time;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.current_time;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.space_name;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.upload_domain;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.session_token;
    }

    public final String component2() {
        return this.access_key;
    }

    public final String component3() {
        return this.secret_key;
    }

    public final String component4() {
        return this.expired_time;
    }

    public final String component5() {
        return this.current_time;
    }

    public final String component6() {
        return this.space_name;
    }

    public final String component7() {
        return this.upload_domain;
    }

    public final StickerUploadAuthKeyModel copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        return new StickerUploadAuthKeyModel(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StickerUploadAuthKeyModel) == false) goto L20;
        StickerUploadAuthKeyModel r101 = (StickerUploadAuthKeyModel) r100;
        if (Intrinsics.areEqual(this.session_token, r101.session_token) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.access_key, r101.access_key) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secret_key, r101.secret_key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expired_time, r101.expired_time) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.current_time, r101.current_time) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.space_name, r101.space_name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.upload_domain, r101.upload_domain) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.session_token;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.access_key;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.secret_key;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.expired_time;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.current_time;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.space_name;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.upload_domain;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "StickerUploadAuthKeyModel(session_token=" + this.session_token + ", access_key=" + this.access_key + ", secret_key=" + this.secret_key + ", expired_time=" + this.expired_time + ", current_time=" + this.current_time + ", space_name=" + this.space_name + ", upload_domain=" + this.upload_domain + ")";
    }

    public final String getAccess_key() {
        return this.access_key;
    }

    public final String getCurrent_time() {
        return this.current_time;
    }

    public final String getExpired_time() {
        return this.expired_time;
    }

    public final String getSecret_key() {
        return this.secret_key;
    }

    public final String getSession_token() {
        return this.session_token;
    }

    public final String getSpace_name() {
        return this.space_name;
    }

    public final String getUpload_domain() {
        return this.upload_domain;
    }

    public final void setAccess_key(String r100) {
        this.access_key = r100;
    }

    public final void setCurrent_time(String r100) {
        this.current_time = r100;
    }

    public final void setExpired_time(String r100) {
        this.expired_time = r100;
    }

    public final void setSecret_key(String r100) {
        this.secret_key = r100;
    }

    public final void setSession_token(String r100) {
        this.session_token = r100;
    }

    public final void setSpace_name(String r100) {
        this.space_name = r100;
    }

    public final void setUpload_domain(String r100) {
        this.upload_domain = r100;
    }

    public StickerUploadAuthKeyModel(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.session_token = r100;
        this.access_key = r101;
        this.secret_key = r102;
        this.expired_time = r103;
        this.current_time = r104;
        this.space_name = r105;
        this.upload_domain = r106;
    }

    public /* synthetic */ StickerUploadAuthKeyModel(String r100, String r101, String r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
