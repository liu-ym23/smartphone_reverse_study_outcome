package m8b;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.security.compliance.infra.util.f;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/model/response/FixedDecisionData;", "", "<init>", "()V", SlcCommonAction.KEY_ACTIONS, "Ljava/util/LinkedList;", "Lcom/ss/android/lark/conditional/access/network/model/response/FixedDecisionData$FixedAction;", "getActions", "()Ljava/util/LinkedList;", "setActions", "(Ljava/util/LinkedList;)V", "toString", "", "FixedAction", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private LinkedList<a> actions;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/conditional/access/network/model/response/FixedDecisionData$FixedAction;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "params", "Ljava/util/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "toString", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("name")
        private String name;

        @SerializedName("params")
        private HashMap<String, Object> params;

        public a() {
            this.name = "";
            this.params = new HashMap();
        }

        public final String toString() {
            return f.c(this);
        }

        public final String a() {
            return this.name;
        }

        public final HashMap<String, Object> b() {
            return this.params;
        }

        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        public final void d(HashMap<String, Object> r100) {
            this.params = r100;
        }
    }

    public b() {
        this.actions = new LinkedList();
    }

    public final String toString() {
        return f.c(this);
    }

    public final LinkedList<a> a() {
        return this.actions;
    }
}
