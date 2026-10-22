package xi2;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifyRiskSmsVM;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0005\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lxi2/b0;", "Lcom/bytedance/android/ec/model/g;", "Lxi2/b0$b;", "data", "Lxi2/b0$b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lxi2/b0$b;", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 extends com.bytedance.android.ec.model.g {

    @SerializedName("data")
    private final b data;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0005\n\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lxi2/b0$a;", "", "", ReportConstant.COMMON_ACTION_TYPE, "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "Lxi2/b0$a$b;", "detailAction", "Lxi2/b0$a$b;", "b", "()Lxi2/b0$a$b;", "Lxi2/b0$a$c;", "toastAction", "Lxi2/b0$a$c;", "c", "()Lxi2/b0$a$c;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("action_type")
        private final int actionType;

        @SerializedName("detail_action")
        private final b detailAction;

        @SerializedName("toast_action")
        private final c toastAction;

        /* JADX INFO: renamed from: xi2.b0$a$a, reason: collision with other inner class name */
        public static final class C8242a {
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lxi2/b0$a$b;", "", "", "url", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class b {

            @SerializedName("url")
            private final String url;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.url, ((b) r100).url) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                String r100 = this.url;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "DetailAction(url=" + this.url + ")";
            }

            public b() {
                this.url = null;
            }

            public final String a() {
                return this.url;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lxi2/b0$a$c;", "", "", "toastMsg", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class c {

            @SerializedName(UnifyPreVerifyRiskSmsVM.KEY_TOAST_MSG)
            private final String toastMsg;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof c) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.toastMsg, ((c) r100).toastMsg) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                String r100 = this.toastMsg;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "ToastAction(toastMsg=" + this.toastMsg + ")";
            }

            public c() {
                this.toastMsg = null;
            }

            public final String a() {
                return this.toastMsg;
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.actionType == r101.actionType) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.detailAction, r101.detailAction) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.toastAction, r101.toastAction) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r100 = this.actionType * 31;
            b r101 = this.detailAction;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            c r105 = this.toastAction;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "ECPublicCommentJumpAction(actionType=" + this.actionType + ", detailAction=" + this.detailAction + ", toastAction=" + this.toastAction + ")";
        }

        public a() {
            this.actionType = 0;
            this.detailAction = null;
            this.toastAction = null;
        }

        public final int a() {
            return this.actionType;
        }

        public final b b() {
            return this.detailAction;
        }

        public final c c() {
            return this.toastAction;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lxi2/b0$b;", "", "Lxi2/b0$a;", "action", "Lxi2/b0$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lxi2/b0$a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("action")
        private final a action;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.action, ((b) r100).action) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            a r100 = this.action;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "ECPublicCommentJumpData(action=" + this.action + ")";
        }

        public b() {
            this.action = null;
        }

        public final a a() {
            return this.action;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.data, ((b0) r100).data) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        b r100 = this.data;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ECPublicCommentJumpResponse(data=" + this.data + ")";
    }

    public b0() {
        this.data = null;
    }

    public final b a() {
        return this.data;
    }
}
