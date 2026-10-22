package com.larus.office.experiment;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes29.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f362172a = 0;

    static {
    }

    public static boolean a(int r100) {
        Iterator<OfficeDocumentType> r101 = OfficeDocumentType.getEntries().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        OfficeDocumentType r102 = r101.next();
        if (r102.getValue() != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L4;
    L12:
        OfficeDocumentType r104 = r102;
        if (r104 == null) goto L29;
        String r105 = r104.getType();
        if (r105 == null) goto L29;
        int r106 = ua9.a.f549294a;
        AtomicReference<ga9.a.C5998a> r107 = ga9.a.f480591a;
        JSONArray r108 = ga9.a.a("office_conversation_task_mode_list", new JSONArray("[\"docx\",\"sheet\",\"slides\",\"bitable\",\"wiki\",\"file\"]"));
        Iterable r109 = RangesKt.until(0, r108.length());
        if ((r109 instanceof Collection) == true) goto L19;
    L21:
        Iterator r110 = r109.iterator();
    L23:
        if (r110.hasNext() == false) goto L27;
        if (Intrinsics.areEqual(r108.optString(((IntIterator) r110).nextInt()), r105) == false) goto L23;
        return true;
    L27:
        return false;
    L19:
        if (((Collection) r109).isEmpty() == false) goto L21;
    L29:
        return false;
    L8:
        r103 = false;
        goto L9
    L11:
        r102 = null;
        goto L12
    }
}
