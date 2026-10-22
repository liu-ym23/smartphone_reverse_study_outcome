package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.office.OfficeInputParam;
import com.larus.office.biz.docx.DocxApi;
import com.larus.office.plugins.inputv2.j1;
import com.larus.office.plugins.inputv2.k1;
import com.larus.utils.logger.FLogger;
import jo9.h;
import jo9.i;
import jo9.l;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<CoroutineScope> f362836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<OfficeInputParam> f362837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<com.larus.office.plugins.inputv2.adapter.g> f362838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Long> f362839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<String, Continuation<? super wc9.e>, Object> f362840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<wc9.e, Unit> f362841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f362842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f362843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f362844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f362845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f362846k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f362847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f362848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f362849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f362850d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f362851e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f362847a, r101.f362847a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362848b, r101.f362848b) == true) goto L15;
            return false;
        L15:
            if (this.f362849c == r101.f362849c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f362850d, r101.f362850d) == true) goto L21;
            return false;
        L21:
            if (this.f362851e == r101.f362851e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f362847a.hashCode() * 31) + this.f362848b.hashCode()) * 31) + this.f362849c) * 31;
            String r101 = this.f362850d;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f362851e;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "CachedMetadataRequest(conversationId=" + this.f362847a + ", resourceId=" + this.f362848b + ", resourceType=" + this.f362849c + ", previousPage=" + this.f362850d + ", generation=" + this.f362851e + ')';
        }

        public a(String r100, String r101, int r102, String r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "resourceId");
            this.f362847a = r100;
            this.f362848b = r101;
            this.f362849c = r102;
            this.f362850d = r103;
            this.f362851e = r104;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f362852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f362853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f362854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f362855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f362856e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f362852a, r101.f362852a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f362853b, r101.f362853b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f362854c, r101.f362854c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f362855d, r101.f362855d) == true) goto L21;
            return false;
        L21:
            if (this.f362856e == r101.f362856e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f362852a.hashCode() * 31;
            String r101 = this.f362853b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f362854c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f362855d;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            long r109 = this.f362856e;
            return ((r107 + r102) * 31) + ((int) (r109 ^ (r109 >>> 32)));
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ConversationMetadata(conversationId=" + this.f362852a + ", messageId=" + this.f362853b + ", artifactMetaId=" + this.f362854c + ", artifactVersionId=" + this.f362855d + ", generation=" + this.f362856e + ')';
        }

        public static c a(c r100, long r101) {
            String r102 = r100.f362852a;
            String r103 = r100.f362853b;
            String r104 = r100.f362854c;
            String r105 = r100.f362855d;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r102, "conversationId");
            return new c(r102, r103, r104, r105, r101);
        }

        public c(String r100, String r101, String r102, String r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f362852a = r100;
            this.f362853b = r101;
            this.f362854c = r102;
            this.f362855d = r103;
            this.f362856e = r104;
        }
    }

    static {
    }

    public final void c() {
        c r100 = this.f362843h;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.f362856e != this.f362839d.invoke().longValue()) goto L49;
        OfficeInputParam r101 = this.f362837b.invoke();
        String r102 = null;
        if (r101 == null) goto L10;
        String r103 = r101.getConversationId();
    L12:
        if (Intrinsics.areEqual(r103, r100.f362852a) == false) goto L57;
        com.larus.office.plugins.inputv2.adapter.g r104 = this.f362838c.invoke();
        if (r104 != null) goto L17;
        return;
    L17:
        OfficeInputParam r105 = this.f362837b.invoke();
        if (r105 == null) goto L20;
        r102 = r105.getType();
    L20:
        if (r102 == null) goto L50;
        int r106 = r102.hashCode();
        if (r106 == (-899647262)) goto L43;
        if (r106 == 3088960) goto L35;
        if (r106 == 109403487) goto L29;
        return;
    L29:
        if (r102.equals(DocumentType.SHEET_NAME) == false) goto L59;
        i r107 = (i) r104.g(i.class);
        if (r107 == null) goto L51;
        r107.D8(r100.f362854c, r100.f362855d);
        return;
    L51:
        return;
    L59:
        return;
    L35:
        if (r102.equals(DocumentType.DOCX_NAME) == false) goto L53;
        jo9.a r108 = (jo9.a) r104.g(jo9.a.class);
        if (r108 == null) goto L39;
        r108.o9(r100.f362855d);
    L39:
        h r109 = (h) r104.g(h.class);
        if (r109 == null) goto L54;
        r109.F8(r100.f362854c, r100.f362855d, r100.f362852a, r100.f362853b);
        return;
    L54:
        return;
    L53:
        return;
    L43:
        if (r102.equals("slides") == false) goto L60;
        l r110 = (l) r104.g(l.class);
        if (r110 == null) goto L56;
        r110.D8(r100.f362854c, r100.f362855d);
        return;
    L56:
        return;
    L60:
        return;
    L50:
        return;
    L57:
        return;
    L10:
        r103 = null;
        goto L12
    }

    public static final void a(g r100, c r101) {
        OfficeInputParam r102 = r100.f362837b.invoke();
        if (r102 == null) goto L26;
        r102.setConversationId(r101.f362852a);
        r102.setMessageId(r101.f362853b);
        String r103 = r101.f362854c;
        String r104 = "";
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r102.setArtifactMetaId(r103);
        String r105 = r101.f362855d;
        if (r105 == null) goto L12;
        r104 = r105;
    L12:
        r102.setArtifactVersionId(r104);
        r100.f362843h = r101;
        r100.c();
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("会话 metadata 已应用, conversation=");
        String r108 = r101.f362852a;
        if (r108 != null) goto L15;
    L18:
        boolean r109 = true;
    L19:
        if (r109 == false) goto L23;
        if (r108 != null) goto L22;
        String r110 = "null";
    L24:
        r107.append(r110);
        r106.i("OfficeChatConversation", r107.toString());
        return;
    L22:
        r110 = "empty";
        goto L24
    L23:
        r110 = "len=" + r108.length() + ",hash=" + r108.hashCode();
        goto L24
    L15:
        if (r108.length() == 0) goto L18;
        r109 = false;
        goto L19
    }

    public static final Object b(g r110, String r111, int r112, String r113, Continuation r114) {
        r110.getClass();
        if ((r114 instanceof OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$1) == false) goto L7;
        OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$1 r100 = (OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L21:
        dm9.a r106 = (dm9.a) r102;
        if ((r106 instanceof dm9.a.b) == true) goto L24;
        FLogger.f375446a.i("OfficeChatConversation", "远端会话 metadata 请求失败");
    L51:
        return null;
    L24:
        on9.e r107 = (on9.e) ((dm9.a.b) r106).f469231a.getData();
        if (r107 == null) goto L51;
        on9.a r108 = r107.a();
        if (r108 == null) goto L51;
        on9.b r109 = r108.a();
        if (r109 == null) goto L51;
        on9.f r115 = r109.b();
        if (r115 == null) goto L51;
        String r116 = r115.b();
        if (r116 == null) goto L51;
        if ((!StringsKt.isBlank(r116)) == false) goto L38;
        String r117 = r116;
    L39:
        if (r117 == null) goto L51;
        on9.b r118 = r108.a();
        if (r118 == null) goto L45;
        on9.f r119 = r118.b();
        if (r119 == null) goto L45;
        String r120 = r119.a();
    L46:
        String r121 = r108.b();
        on9.b r122 = r108.a();
        if (r122 == null) goto L52;
        r105 = r122.a();
    L52:
        return new c(r117, r120, r121, r105, r110.f362839d.invoke().longValue());
    L45:
        r120 = null;
        goto L46
    L38:
        r117 = null;
        goto L39
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (Intrinsics.areEqual(r113, "ai_space_list") == false) goto L17;
        Integer r123 = null;
    L18:
        boolean r124 = Intrinsics.areEqual(r113, "ai_space_list");
        DocxApi.a r125 = DocxApi.f361254a;
        OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1 r126 = new OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$response$1(r111, r112, r123, r124, null);
        r100.label = 1;
        r125.getClass();
        r102 = DocxApi.a.a(r126, r100);
        if (r102 != r103) goto L21;
        return r103;
    L17:
        r123 = Boxing.boxInt(1);
    L7:
        r100 = new OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$1(r110, r114);
        goto L8
    }

    public g(j1 r100, k1 r101, com.larus.office.plugins.inputv2.coordinator.runtime.conversation.c r102, d r103, Function2 r104, e r105) {
        Intrinsics.checkNotNullParameter(r100, "scopeProvider");
        Intrinsics.checkNotNullParameter(r101, "inputParamsProvider");
        Intrinsics.checkNotNullParameter(r102, "adapterProvider");
        Intrinsics.checkNotNullParameter(r103, "activeGenerationProvider");
        Intrinsics.checkNotNullParameter(r104, "findAvailableRemoteConversation");
        Intrinsics.checkNotNullParameter(r105, "onLegacyRemoteConversation");
        this.f362836a = r100;
        this.f362837b = r101;
        this.f362838c = r102;
        this.f362839d = r103;
        this.f362840e = r104;
        this.f362841f = r105;
    }
}
