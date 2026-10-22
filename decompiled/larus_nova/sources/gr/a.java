package gr;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0012"}, d2 = {"Lgr/a;", "", "", "id", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "", "btmSet", "Ljava/util/Set;", "getBtmSet", "()Ljava/util/Set;", "preNodes", "b", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public class a {

    @SerializedName("btm_set")
    private final Set<String> btmSet;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f482293id;

    @SerializedName("pre_id_set")
    private final Set<String> preNodes;

    public final boolean d() {
        return StringsKt.startsWith$default(this.f482293id, "start", false, 2, null);
    }

    public a() {
        this.f482293id = "";
        this.btmSet = new LinkedHashSet();
        this.preNodes = new LinkedHashSet();
    }

    public final String a() {
        return this.f482293id;
    }

    public final Set<String> b() {
        return this.preNodes;
    }

    public final boolean c(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        Iterator<String> r102 = this.btmSet.iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        if (StringsKt.contains$default(r100, r102.next(), false, 2, null) == false) goto L13;
        return true;
    L17:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
