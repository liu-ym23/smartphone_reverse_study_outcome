package lg;

import com.bytedance.android.ec.core.apt.ActionType;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Llg/j;", "Llg/d;", "", "name", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class j extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509124a;

    @SerializedName("name")
    private final String name;

    public Unit c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        return null;
    }

    public j() {
        this("");
    }

    @Override // lg.d
    public final String b() {
        return this.name;
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        super(ActionType.NetWork);
        this.f509124a = r100;
        StringBuilder r101 = new StringBuilder();
        ActionType r102 = getType();
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r101.append(r103);
        r101.append('/');
        r101.append(r100);
        this.name = r101.toString();
        return;
    L5:
        r103 = null;
        goto L6
    }
}
