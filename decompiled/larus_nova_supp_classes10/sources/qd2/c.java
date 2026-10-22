package qd2;

import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.live.datacontext.k;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends g<a, Object> {
    public final o a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lqd2/c$a;", "", "", "source", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "tab_name", "b", "setTab_name", "(Ljava/lang/String;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("source")
        private final String source;

        @SerializedName("tab_name")
        private String tab_name;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.source, r4.source) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.tab_name, r4.tab_name) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.source;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.tab_name;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(source=" + this.source + ", tab_name=" + this.tab_name + ")";
        }

        public final String a() {
            return this.source;
        }

        public final String b() {
            return this.tab_name;
        }
    }

    public c(o r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        this.a = r2;
    }

    public final Object invoke(Object r4, CallContext r5) {
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r6, "p0");
        Intrinsics.checkNotNullParameter(r5, "p1");
        KtvContext.Companion.getClass();
        KtvContext r7 = KtvContext.a.g();
        if (r7 == null) goto L8;
        k<od2.b> r8 = r7.getOpenKtvRoomDialogEvent();
        if (r8 == null) goto L8;
        r8.post(new od2.b(r6.a(), false, r6.b()));
    L8:
        return Boolean.TRUE;
    }
}
