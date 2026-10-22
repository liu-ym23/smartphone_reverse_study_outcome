package pqb;

import com.ss.android.agilelogger.utils.FormatUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements nra.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530314a = null;

    static {
        f530314a = new a();
    }

    public a() {
    }

    @Override // nra.a
    public final void b() {
    }

    @Override // nra.a
    public final Queue<nra.d> a() {
        Queue<com.suite.component.logger.c> r100 = com.suite.component.logger.f.f460139a.a();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        com.suite.component.logger.c r103 = (com.suite.component.logger.c) r102.next();
        nra.d r104 = new nra.d();
        r104.f520267a = r103.f460115a.getValue();
        r104.f520268b = r103.f460116b;
        r104.f520269c = r103.f460117c;
        String.valueOf(r103.f460123i);
        r104.f520270d = FormatUtils.TYPE.MSG;
        r101.add(r104);
        goto L4
    L7:
        return new LinkedList(r101);
    }
}
