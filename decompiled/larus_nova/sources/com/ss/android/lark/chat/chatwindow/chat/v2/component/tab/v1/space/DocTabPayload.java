package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space;

import com.bytedance.common.wschannel.WsConstants;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0002'(BQ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v1/space/DocTabPayload;", "Ljava/io/Serializable;", "key", "", "url", "name", "docType", "source", "app_id", "", "iconInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getUrl", "getName", "setName", "(Ljava/lang/String;)V", "getDocType", "getSource", "getApp_id", "()J", "getIconInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "DocType", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocTabPayload implements Serializable {
    public static final a Companion = null;
    public static final String VALUE_OPAI = "OAPI";
    private final long app_id;
    private final String docType;
    private final String iconInfo;
    private final String key;
    private String name;
    private final String source;
    private final String url;

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/tab/v1/space/DocTabPayload$DocType;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DocType {
        public static final String BITABLE = "3";
        public static final a Companion = null;
        public static final String DOC = "1";
        public static final String DOCX = "8";
        public static final String FILE = "5";
        public static final String MINDNOTE = "4";
        public static final String SHEET = "2";
        public static final String SLIDE = "6";
        public static final String SLIDES = "11";
        public static final String UNKNOWN = "0";
        public static final String WIKI = "7";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f414363a = null;

            static {
                f414363a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f414363a;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ DocTabPayload copy$default(DocTabPayload r100, String r110, String r111, String r112, String r113, String r114, long r115, String r116, int r117, Object r118) {
        if ((r117 & 1) == 0) goto L5;
        String r101 = r100.key;
    L7:
        if ((r117 & 2) == 0) goto L9;
        String r102 = r100.url;
    L11:
        if ((r117 & 4) == 0) goto L13;
        String r103 = r100.name;
    L15:
        if ((r117 & 8) == 0) goto L17;
        String r104 = r100.docType;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = r100.source;
    L23:
        if ((r117 & 32) == 0) goto L25;
        long r106 = r100.app_id;
    L27:
        if ((r117 & 64) == 0) goto L29;
        String r107 = r100.iconInfo;
    L31:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107);
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.docType;
    }

    public final String component5() {
        return this.source;
    }

    public final long component6() {
        return this.app_id;
    }

    public final String component7() {
        return this.iconInfo;
    }

    public final DocTabPayload copy(String r110, String r111, String r112, String r113, String r114, long r115, String r116) {
        return new DocTabPayload(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocTabPayload) == true) goto L8;
        return false;
    L8:
        DocTabPayload r101 = (DocTabPayload) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.docType, r101.docType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L24;
        return false;
    L24:
        if (this.app_id == r101.app_id) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.iconInfo, r101.iconInfo) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.key;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.url;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.name;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.docType;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.source;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.app_id;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        String r118 = this.iconInfo;
        if (r118 == null) goto L27;
        r101 = r118.hashCode();
    L27:
        return r117 + r101;
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

    public String toString() {
        return "DocTabPayload(key=" + this.key + ", url=" + this.url + ", name=" + this.name + ", docType=" + this.docType + ", source=" + this.source + ", app_id=" + this.app_id + ", iconInfo=" + this.iconInfo + ')';
    }

    public final long getApp_id() {
        return this.app_id;
    }

    public final String getDocType() {
        return this.docType;
    }

    public final String getIconInfo() {
        return this.iconInfo;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getUrl() {
        return this.url;
    }

    @JvmStatic
    public static final com.bytedance.lark.pb.space.doc.v1.DocTabPayload parsePbFromDocTabPayload(DocTabPayload r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        return new com.bytedance.lark.pb.space.doc.v1.DocTabPayload.Builder().key(r100.getKey()).url(r100.getUrl()).name(r100.getName()).build();
    }

    @JvmStatic
    public static final String parsePbFromDocTabPayloadToJson(DocTabPayload r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        JSONObject r101 = new JSONObject();
        String r102 = r100.getKey();
        if (r102 == null) goto L5;
        r101.put("key", r102);
    L5:
        String r103 = r100.getUrl();
        if (r103 == null) goto L8;
        r101.put("url", r103);
    L8:
        String r104 = r100.getName();
        if (r104 == null) goto L11;
        r101.put("name", r104);
    L11:
        String r105 = r100.getDocType();
        if (r105 == null) goto L14;
        r101.put("docType", r105);
    L14:
        String r106 = r100.getIconInfo();
        if (r106 == null) goto L18;
        r101.put("iconInfo", r106);
    L18:
        return r101.toString();
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public DocTabPayload(String r100, String r101, String r102, String r103, String r104, long r105, String r106) {
        this.key = r100;
        this.url = r101;
        this.name = r102;
        this.docType = r103;
        this.source = r104;
        this.app_id = r105;
        this.iconInfo = r106;
    }

    public /* synthetic */ DocTabPayload(String r110, String r111, String r112, String r113, String r114, long r115, String r116, int r117, DefaultConstructorMarker r210) {
        if ((r117 & 16) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r117 & 32) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r117 & 64) == 0) goto L13;
        String r102 = null;
    L14:
        this(r110, r111, r112, r113, r100, r101, r102);
        return;
    L13:
        r102 = r116;
        goto L14
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
