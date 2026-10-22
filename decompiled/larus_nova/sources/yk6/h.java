package yk6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes20.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f568233a = 0;

    static {
    }

    public static Integer a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "batchId");
        List r101 = StringsKt.split$default(r100, new String[]{"_"}, false, 0, 6, null);
        if (r101.size() == 4) goto L5;
        return null;
    L5:
        if ((!Intrinsics.areEqual((String) ListProtector.get(r101, 0), OPTrace.BATCH_DATA_KEY)) == false) goto L12;
        return null;
    L12:
        return Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r101, 2)));
    L10:
        int r102 = g.f568232a;
        String r103 = "parseSequenceFromBatchId failed: " + r100;
        Intrinsics.checkNotNullParameter("KTV-Download-Util", "tag");
        Intrinsics.checkNotNullParameter(r103, "msg");
        jy0.b.f("KTV-Download-Util", r103, null, 4);
        return null;
    }
}
