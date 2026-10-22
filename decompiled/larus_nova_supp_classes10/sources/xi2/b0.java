package xi2;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0005\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lxi2/b0;", "Lcom/bytedance/android/ec/model/g;", "Lxi2/b0$b;", "data", "Lxi2/b0$b;", "a", "()Lxi2/b0$b;", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 extends com.bytedance.android.ec.model.g {

    @SerializedName("data")
    private final b data;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0005\n\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lxi2/b0$a;", "", "", "actionType", "I", "a", "()I", "Lxi2/b0$a$b;", "detailAction", "Lxi2/b0$a$b;", "b", "()Lxi2/b0$a$b;", "Lxi2/b0$a$c;", "toastAction", "Lxi2/b0$a$c;", "c", "()Lxi2/b0$a$c;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("action_type")
        private final int actionType;

        @SerializedName("detail_action")
        private final b detailAction;

        @SerializedName("toast_action")
        private final c toastAction;

        /* JADX INFO: renamed from: xi2.b0$a$a, reason: collision with other inner class name */
        public static final class C0188a {
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lxi2/b0$a$b;", "", "", "url", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class b {

            @SerializedName("url")
            private final String url;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof b) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.url, ((b) r2).url) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                String r0 = this.url;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
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

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lxi2/b0$a$c;", "", "", "toastMsg", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class c {

            @SerializedName("toast_msg")
            private final String toastMsg;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof c) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.toastMsg, ((c) r2).toastMsg) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                String r0 = this.toastMsg;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
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

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.actionType == r4.actionType) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.detailAction, r4.detailAction) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.toastAction, r4.toastAction) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = this.actionType * 31;
            b r1 = this.detailAction;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            c r5 = this.toastAction;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lxi2/b0$b;", "", "Lxi2/b0$a;", "action", "Lxi2/b0$a;", "a", "()Lxi2/b0$a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("action")
        private final a action;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.action, ((b) r2).action) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            a r0 = this.action;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
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

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof b0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.data, ((b0) r2).data) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        b r0 = this.data;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
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
