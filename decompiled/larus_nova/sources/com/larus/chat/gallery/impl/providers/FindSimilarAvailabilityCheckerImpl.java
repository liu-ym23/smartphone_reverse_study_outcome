package com.larus.chat.gallery.impl.providers;

import com.google.gson.annotations.SerializedName;
import com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/larus/chat/gallery/impl/providers/FindSimilarAvailabilityCheckerImpl;", "Lcom/larus/chat/gallery/api/IFindSimilarAvailabilityChecker;", "<init>", "()V", "checkAvailability", "Lcom/larus/chat/gallery/api/FindSimilarAvailability;", "imageUri", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FindSimilarResp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FindSimilarAvailabilityCheckerImpl implements IFindSimilarAvailabilityChecker {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/larus/chat/gallery/impl/providers/FindSimilarAvailabilityCheckerImpl$FindSimilarResp;", "", "findButtonAvailable", "", "findEntranceText", "", "findSendText", "artifactType", "bizPayload", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFindButtonAvailable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFindEntranceText", "()Ljava/lang/String;", "getFindSendText", "getArtifactType", "getBizPayload", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/chat/gallery/impl/providers/FindSimilarAvailabilityCheckerImpl$FindSimilarResp;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FindSimilarResp {

        @SerializedName("artifact_type")
        private final String artifactType;

        @SerializedName("biz_payload")
        private final String bizPayload;

        @SerializedName("find_button_available")
        private final Boolean findButtonAvailable;

        @SerializedName("find_entrance_text")
        private final String findEntranceText;

        @SerializedName("find_send_text")
        private final String findSendText;

        public FindSimilarResp() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ FindSimilarResp copy$default(FindSimilarResp r100, Boolean r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
            if ((r106 & 1) == 0) goto L6;
            r101 = r100.findButtonAvailable;
        L6:
            if ((r106 & 2) == 0) goto L8;
            r102 = r100.findEntranceText;
        L8:
            String r111 = r102;
            if ((r106 & 4) == 0) goto L11;
            r103 = r100.findSendText;
        L11:
            String r107 = r103;
            if ((r106 & 8) == 0) goto L14;
            r104 = r100.artifactType;
        L14:
            String r108 = r104;
            if ((r106 & 16) == 0) goto L17;
            r105 = r100.bizPayload;
        L17:
            Boolean r109 = r101;
            return r100.copy(r109, r111, r107, r108, r105);
        }

        public final Boolean component1() {
            return this.findButtonAvailable;
        }

        public final String component2() {
            return this.findEntranceText;
        }

        public final String component3() {
            return this.findSendText;
        }

        public final String component4() {
            return this.artifactType;
        }

        public final String component5() {
            return this.bizPayload;
        }

        public final FindSimilarResp copy(Boolean r100, String r101, String r110, String r111, String r112) {
            return new FindSimilarResp(r100, r101, r110, r111, r112);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof FindSimilarResp) == true) goto L8;
            return false;
        L8:
            FindSimilarResp r101 = (FindSimilarResp) r100;
            if (Intrinsics.areEqual(this.findButtonAvailable, r101.findButtonAvailable) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.findEntranceText, r101.findEntranceText) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.findSendText, r101.findSendText) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.artifactType, r101.artifactType) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.bizPayload, r101.bizPayload) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            Boolean r100 = this.findButtonAvailable;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.findEntranceText;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.findSendText;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.artifactType;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.bizPayload;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return r112 + r101;
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
            return "FindSimilarResp(findButtonAvailable=" + this.findButtonAvailable + ", findEntranceText=" + this.findEntranceText + ", findSendText=" + this.findSendText + ", artifactType=" + this.artifactType + ", bizPayload=" + this.bizPayload + ')';
        }

        public final String getArtifactType() {
            return this.artifactType;
        }

        public final String getBizPayload() {
            return this.bizPayload;
        }

        public final Boolean getFindButtonAvailable() {
            return this.findButtonAvailable;
        }

        public final String getFindEntranceText() {
            return this.findEntranceText;
        }

        public final String getFindSendText() {
            return this.findSendText;
        }

        public FindSimilarResp(Boolean r100, String r101, String r102, String r103, String r104) {
            this.findButtonAvailable = r100;
            this.findEntranceText = r101;
            this.findSendText = r102;
            this.artifactType = r103;
            this.bizPayload = r104;
        }

        public /* synthetic */ FindSimilarResp(Boolean r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
            if ((r105 & 1) == 0) goto L5;
            r100 = Boolean.FALSE;
        L5:
            String r106 = "";
            if ((r105 & 2) == 0) goto L8;
            String r111 = "";
        L10:
            if ((r105 & 4) == 0) goto L12;
            String r107 = "";
        L14:
            if ((r105 & 8) == 0) goto L16;
            String r108 = "";
        L18:
            if ((r105 & 16) != 0) goto L21;
            r106 = r104;
        L21:
            this(r100, r111, r107, r108, r106);
            return;
        L16:
            r108 = r103;
            goto L18
        L12:
            r107 = r102;
            goto L14
        L8:
            r111 = r101;
            goto L10
        }
    }

    public static final class a {
    }

    static {
    }

    public FindSimilarAvailabilityCheckerImpl() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker
    public final Object a(String r110, Continuation<? super com.larus.chat.gallery.api.h> r111) {
        String r100 = r110;
        if ((r111 instanceof FindSimilarAvailabilityCheckerImpl$checkAvailability$1) == false) goto L7;
        FindSimilarAvailabilityCheckerImpl$checkAvailability$1 r101 = (FindSimilarAvailabilityCheckerImpl$checkAvailability$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        FindSimilarAvailabilityCheckerImpl$checkAvailability$1 r112 = r101;
        Object r103 = r112.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r112.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (String) r112.L$0;
        ResultKt.throwOnFailure(r103);
        Object r106 = r103;
    L17:
        com.larus.network.http.a r107 = (com.larus.network.http.a) r106;
        if ((r107 instanceof y) == false) goto L55;
        FLogger.f375446a.i("FindSimilarAvailability", "checkAvailability Success " + r100);
        y r108 = (y) r107;
        FindSimilarResp r109 = (FindSimilarResp) r108.f360135b;
        if (r109 == null) goto L24;
        Boolean r113 = r109.getFindButtonAvailable();
        if (r113 == null) goto L24;
        boolean r114 = r113.booleanValue();
    L25:
        FindSimilarResp r115 = (FindSimilarResp) r108.f360135b;
        if (r115 == null) goto L31;
        String r116 = r115.getFindEntranceText();
        if (r116 == null) goto L31;
        String r117 = r116;
    L32:
        FindSimilarResp r118 = (FindSimilarResp) r108.f360135b;
        if (r118 == null) goto L38;
        String r119 = r118.getFindSendText();
        if (r119 == null) goto L38;
        String r120 = r119;
    L39:
        FindSimilarResp r121 = (FindSimilarResp) r108.f360135b;
        if (r121 == null) goto L45;
        String r122 = r121.getArtifactType();
        if (r122 == null) goto L45;
        String r123 = r122;
    L46:
        FindSimilarResp r124 = (FindSimilarResp) r108.f360135b;
        if (r124 == null) goto L52;
        String r125 = r124.getBizPayload();
        if (r125 == null) goto L52;
        String r126 = r125;
    L60:
        return new com.larus.chat.gallery.api.h(r114, r117, r120, r123, r126);
    L52:
        r126 = "";
    L45:
        r123 = "";
    L38:
        r120 = "";
    L31:
        r117 = "";
    L24:
        r114 = false;
        goto L25
    L55:
        if ((r107 instanceof com.larus.network.http.f) == true) goto L58;
        FLogger.f375446a.w(r15, "checkAvailability Null " + r100);
        return com.larus.chat.gallery.api.h.f324156f;
    L58:
        FLogger r127 = FLogger.f375446a;
        StringBuilder r128 = new StringBuilder("checkAvailability Fail ");
        r128.append(r100);
        r128.append(", error=");
        com.larus.network.http.f r129 = (com.larus.network.http.f) r107;
        r128.append(r129.f360157d);
        r127.w(r15, r128.toString());
        throw r129.f360157d;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        FLogger.f375446a.i("FindSimilarAvailability", "checkAvailability stub, imageUri=" + r100);
        JSONObject r130 = new JSONObject();
        r130.put("image_url", r100);
        Unit r131 = Unit.INSTANCE;
        r112.L$0 = r100;
        r112.label = 1;
        r106 = HttpExtKt.k(ServiceType.ECOMMERCE, FindSimilarResp.class, "/alice/e_commerce/image_intent_recognize", r130, null, null, false, null, null, null, r112, 1008);
        if (r106 != r104) goto L17;
        return r104;
    L7:
        r101 = new FindSimilarAvailabilityCheckerImpl$checkAvailability$1(this, r111);
        goto L8
    }
}
