package vka;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a implements b<JsonArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b<? extends JsonElement>> f555547a;

    @Override // vka.b
    public final Object execute() {
        Intrinsics.checkNotNullParameter(f.f555548a, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonArray r100 = new JsonArray();
        Iterator<T> r101 = this.f555547a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add((JsonElement) ((b) r101.next()).execute());
        goto L4
    L6:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends b<? extends JsonElement>> r100) {
        Intrinsics.checkNotNullParameter(r100, "ops");
        this.f555547a = r100;
    }
}
