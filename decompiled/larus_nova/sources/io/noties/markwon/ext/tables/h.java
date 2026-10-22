package io.noties.markwon.ext.tables;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import lsc.y;
import org.commonmark.ext.gfm.tables.TableBlock;
import uvc.b;

/* JADX INFO: loaded from: classes5.dex */
public final class h<N extends uvc.b> implements lsc.m.c<TableBlock> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.c f492535a;

    public h(g.c r100) {
        this.f492535a = r100;
    }

    @Override // lsc.m.c
    public final void a(lsc.m r210, uvc.b r211) {
        uvc.b r100 = (TableBlock) r211;
        g.c r101 = this.f492535a;
        ((ArrayList) r101.f492530a).clear();
        ((ArrayList) r101.f492531b).clear();
        r101.f492532c = false;
        r101.f492533d = 0;
        r210.C(r100);
        g.c r102 = this.f492535a;
        r102.getClass();
        int r103 = r210.length();
        r210.c(r100);
        ctc.a r110 = new ctc.a(0.0f);
        List r111 = CollectionsKt.toList(r102.f492531b);
        Iterator r112 = ((ArrayList) r102.f492531b).iterator();
    L4:
        if (r112.hasNext() == false) goto L16;
        g.b r113 = (g.b) r112.next();
        int r114 = r210.length();
        if (r102.f492534e.f492519b.f492567q != 1) goto L11;
        Iterator<g.a> r104 = r113.f492528b.iterator();
    L9:
        if (r104.hasNext() == false) goto L15;
        g.a r105 = r104.next();
        int r115 = r210.length();
        y r106 = r210.builder();
        String r107 = StringsKt.replace$default(r105.f492526e.toString(), "\n", " ", false, 4, null);
        Iterator<g.a> r116 = r104;
        r106.f510625a.append(r107);
        r106.c(" ");
        r105.f492522a = r115;
        r105.f492523b = r210.length() - 1;
        r104 = r116;
    L15:
        r210.a();
        g r108 = r102.f492534e;
        r210.o(r114, new TableRowSpan2(r108.f492519b, r108.f492520c, r111, r113, r110));
        goto L4
    L11:
        r210.builder().c(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        Iterator<g.a> r109 = r113.f492528b.iterator();
    L13:
        if (r109.hasNext() == false) goto L15;
        g.a r117 = r109.next();
        int r118 = r210.length();
        y r119 = r210.builder();
        r119.f510625a.append(" ");
        String r120 = StringsKt.replace$default(r117.f492526e.toString(), "\n", " ", false, 4, null);
        Iterator<g.a> r121 = r109;
        r119.f510625a.append(r120);
        r119.c(" |");
        r117.f492522a = r118;
        r117.f492523b = r210.length() - 1;
        r109 = r121;
        goto L13
    L16:
        r210.o(r103, r110);
        r210.o(r103, new s());
        r210.q(r100);
        g.c r122 = this.f492535a;
        ((ArrayList) r122.f492530a).clear();
        ((ArrayList) r122.f492531b).clear();
        r122.f492532c = false;
        r122.f492533d = 0;
    }
}
