package eq;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R2\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u000e\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Leq/a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", SlcCommonAction.KEY_PARAMS, "Ljava/util/Map;", "b", "()Ljava/util/Map;", "eventControlFlow", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", TeaEventTrack.ACTION_DRAMA_NEXT, "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("event_control_flow")
    private final String eventControlFlow;

    @SerializedName(SlcCommonAction.KEY_PARAMS)
    private final Map<String, Object> fields;

    @SerializedName(TeaEventTrack.ACTION_DRAMA_NEXT)
    private final Map<String, List<a>> next;

    @SerializedName("type")
    private final String type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fields, r101.fields) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.eventControlFlow, r101.eventControlFlow) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.next, r101.next) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.fields;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.eventControlFlow;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, List<a>> r110 = this.next;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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

    public final String toString() {
        return "Event(type=" + this.type + ", fields=" + this.fields + ", eventControlFlow=" + this.eventControlFlow + ", next=" + this.next + ")";
    }

    public final String a() {
        return this.eventControlFlow;
    }

    public final Map<String, Object> b() {
        return this.fields;
    }

    public final Map<String, List<a>> c() {
        return this.next;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, Map<String, ? extends Object> r101, String r102, Map<String, ? extends List<a>> r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
        this.fields = r101;
        this.eventControlFlow = r102;
        this.next = r103;
    }
}
