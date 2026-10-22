package gm2;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lgm2/a;", "", "", "behaviourType", "I", "", "values", "Ljava/lang/String;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class a {

    @SerializedName("behaviour_type")
    public int behaviourType;

    @SerializedName("values")
    public String values;

    public final List<Long> a() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = StringsKt.split$default(this.values, new String[]{","}, false, 0, 6, null).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        r100.add(Long.valueOf(CastLongProtector.parseLong((String) r101.next())));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L4
    L10:
        return r100;
    }

    public a() {
        this.values = "";
    }
}
