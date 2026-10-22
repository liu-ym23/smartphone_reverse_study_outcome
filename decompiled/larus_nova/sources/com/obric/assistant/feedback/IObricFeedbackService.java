package com.obric.assistant.feedback;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000 \n2\u00020\u0001:\u0003\n\u000b\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\r"}, d2 = {"Lcom/obric/assistant/feedback/IObricFeedbackService;", "", "init", "", "feedback", "param", "Lcom/obric/assistant/feedback/IObricFeedbackService$FeedbackParam;", "isOAppSelfReport", "", "setOAppSelfReport", "Companion", "FeedbackParam", "CompleteParams", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricFeedbackService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f389211a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f389212a = null;

        static {
            f389212a = new a();
        }

        public a() {
        }

        public static IObricFeedbackService a() {
            return (IObricFeedbackService) ServiceManager.get().getService(IObricFeedbackService.class, false, false);
        }

        public static boolean b(String r100) {
            if (Intrinsics.areEqual(r100, "search") == false) goto L5;
        L10:
            return true;
        L5:
            if (Intrinsics.areEqual(r100, "memory_operate") == true) goto L10;
            if (Intrinsics.areEqual(r100, "memory_delete") == true) goto L10;
            return false;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f389213a;

        public b() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f389213a == ((b) r100).f389213a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f389213a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "CompleteParams(isPrivacyNotAgree=" + this.f389213a + ')';
        }

        public b(boolean r100) {
            this.f389213a = r100;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f389214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f389215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<String> f389216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f389217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f389218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f389219f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f389220g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f389221h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Boolean f389222i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Integer f389223j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f389224k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final List<String> f389225l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f389226m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f389227n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f389228o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f389229p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f389230q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f389231r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Function1<b, Unit> f389232s;

        public c() {
            this(null, null, null, null, null, null, null, null, null, null, false, null, false, false, false, null, false, null, 524287);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f389214a, r101.f389214a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f389215b, r101.f389215b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f389216c, r101.f389216c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f389217d, r101.f389217d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f389218e, r101.f389218e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f389219f, r101.f389219f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f389220g, r101.f389220g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f389221h, r101.f389221h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f389222i, r101.f389222i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f389223j, r101.f389223j) == true) goto L39;
            return false;
        L39:
            if (this.f389224k == r101.f389224k) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f389225l, r101.f389225l) == true) goto L45;
            return false;
        L45:
            if (this.f389226m == r101.f389226m) goto L48;
            return false;
        L48:
            if (this.f389227n == r101.f389227n) goto L51;
            return false;
        L51:
            if (this.f389228o == r101.f389228o) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.f389229p, r101.f389229p) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.f389230q, r101.f389230q) == true) goto L60;
            return false;
        L60:
            if (this.f389231r == r101.f389231r) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.f389232s, r101.f389232s) == true) goto L65;
            return false;
        L65:
            return true;
        }

        public final int hashCode() {
            List<String> r100 = this.f389214a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f389215b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            List<String> r107 = this.f389216c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            List<String> r110 = this.f389217d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f389218e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f389219f;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.f389220g;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.f389221h;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            Boolean r125 = this.f389222i;
            if (r125 != null) goto L37;
            int r126 = 0;
        L38:
            int r127 = (r124 + r126) * 31;
            Integer r128 = this.f389223j;
            if (r128 != null) goto L41;
            int r129 = 0;
        L42:
            int r130 = (r127 + r129) * 31;
            int r131 = 1231;
            if (this.f389224k == false) goto L45;
            int r132 = 1231;
        L46:
            int r133 = (r130 + r132) * 31;
            List<String> r134 = this.f389225l;
            if (r134 != null) goto L49;
            int r135 = 0;
        L50:
            int r136 = (r133 + r135) * 31;
            if (this.f389226m == false) goto L53;
            int r137 = 1231;
        L54:
            int r138 = (r136 + r137) * 31;
            if (this.f389227n == false) goto L57;
            int r139 = 1231;
        L58:
            int r140 = (r138 + r139) * 31;
            if (this.f389228o == false) goto L61;
            int r141 = 1231;
        L62:
            int r142 = (r140 + r141) * 31;
            String r143 = this.f389229p;
            if (r143 != null) goto L65;
            int r144 = 0;
        L66:
            int r145 = (r142 + r144) * 31;
            String r146 = this.f389230q;
            if (r146 != null) goto L69;
            int r147 = 0;
        L70:
            int r148 = (r145 + r147) * 31;
            if (this.f389231r == true) goto L74;
            r131 = 1237;
        L74:
            int r149 = (r148 + r131) * 31;
            Function1<b, Unit> r150 = this.f389232s;
            if (r150 == null) goto L79;
            r101 = r150.hashCode();
        L79:
            return r149 + r101;
        L69:
            r147 = r146.hashCode();
            goto L70
        L65:
            r144 = r143.hashCode();
            goto L66
        L61:
            r141 = 1237;
            goto L62
        L57:
            r139 = 1237;
            goto L58
        L53:
            r137 = 1237;
            goto L54
        L49:
            r135 = r134.hashCode();
            goto L50
        L45:
            r132 = 1237;
            goto L46
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
            return "FeedbackParam(tagList=" + this.f389214a + ", content=" + this.f389215b + ", urlList=" + this.f389216c + ", messageIdList=" + this.f389217d + ", feedbackMsgId=" + this.f389218e + ", feedbackSource=" + this.f389219f + ", feedbackBizType=" + this.f389220g + ", searchTool=" + this.f389221h + ", isConsentChecked=" + this.f389222i + ", score=" + this.f389223j + ", needUploadImage=" + this.f389224k + ", filePathList=" + this.f389225l + ", launchReportAppWhenNoPermission=" + this.f389226m + ", needReportToVoc=" + this.f389227n + ", needShowToast=" + this.f389228o + ", omniTaskId=" + this.f389229p + ", omniFeedbackType=" + this.f389230q + ", useRawContent=" + this.f389231r + ", onCompleteCallback=" + this.f389232s + ')';
        }

        public c(List r210, String r211, List r212, List r213, String r214, String r215, String r216, String r217, Boolean r218, Integer r310, boolean r311, List r312, boolean r313, boolean r314, boolean r315, String r316, boolean r317, Function1 r318, int r319) {
            if ((r319 & 1) == 0) goto L5;
            List r100 = null;
        L7:
            if ((r319 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r319 & 4) == 0) goto L13;
            List r102 = null;
        L15:
            if ((r319 & 8) == 0) goto L17;
            List r103 = null;
        L19:
            if ((r319 & 16) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r319 & 32) == 0) goto L25;
            String r105 = null;
        L27:
            if ((r319 & 64) == 0) goto L29;
            String r106 = null;
        L31:
            if ((r319 & 128) == 0) goto L33;
            String r110 = null;
        L35:
            if ((r319 & 256) == 0) goto L37;
            Boolean r111 = null;
        L39:
            if ((r319 & 512) == 0) goto L41;
            Integer r112 = null;
        L43:
            if ((r319 & 1024) == 0) goto L45;
            boolean r113 = true;
        L47:
            if ((r319 & 2048) == 0) goto L49;
            List r114 = null;
        L51:
            if ((r319 & 4096) == 0) goto L53;
            boolean r115 = false;
        L55:
            if ((r319 & 8192) == 0) goto L57;
            boolean r107 = false;
        L58:
            boolean r219 = r107;
            if ((r319 & 16384) == 0) goto L61;
            boolean r108 = false;
        L63:
            if ((r319 & 32768) == 0) goto L65;
            String r116 = null;
        L67:
            if ((r319 & 131072) == 0) goto L69;
            boolean r117 = false;
        L71:
            if ((r319 & 262144) == 0) goto L73;
            Function1 r109 = null;
        L74:
            this.f389214a = r100;
            this.f389215b = r101;
            this.f389216c = r102;
            this.f389217d = r103;
            this.f389218e = r104;
            this.f389219f = r105;
            this.f389220g = r106;
            this.f389221h = r110;
            this.f389222i = r111;
            this.f389223j = r112;
            this.f389224k = r113;
            this.f389225l = r114;
            this.f389226m = r115;
            this.f389227n = r219;
            this.f389228o = r108;
            this.f389229p = r116;
            this.f389230q = null;
            this.f389231r = r117;
            this.f389232s = r109;
            return;
        L73:
            r109 = r318;
            goto L74
        L69:
            r117 = r317;
            goto L71
        L65:
            r116 = r316;
            goto L67
        L61:
            r108 = r315;
            goto L63
        L57:
            r107 = r314;
            goto L58
        L53:
            r115 = r313;
            goto L55
        L49:
            r114 = r312;
            goto L51
        L45:
            r113 = r311;
            goto L47
        L41:
            r112 = r310;
            goto L43
        L37:
            r111 = r218;
            goto L39
        L33:
            r110 = r217;
            goto L35
        L29:
            r106 = r216;
            goto L31
        L25:
            r105 = r215;
            goto L27
        L21:
            r104 = r214;
            goto L23
        L17:
            r103 = r213;
            goto L19
        L13:
            r102 = r212;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    static {
        f389211a = a.f389212a;
    }

    void a(c r100);

    void init();
}
