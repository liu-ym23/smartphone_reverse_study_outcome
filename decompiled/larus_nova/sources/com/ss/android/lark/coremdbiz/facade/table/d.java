package com.ss.android.lark.coremdbiz.facade.table;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.TableInfo;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import eab.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420172a = 0;

    static {
    }

    public static TableInfo a(Context r210, a r211, h r212) {
        h r100 = r212;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "parserFactory");
        Intrinsics.checkNotNullParameter(r100, "node");
        b r101 = r211.a(r210);
        TextLayoutBuilder r102 = r211.b(r210);
        TableInfo r103 = new TableInfo();
        r103.setColumnSpan(r100.f471753k.size());
        r103.setRowSpan(r100.f471754l.size());
        r103.setColumnInfo(new LinkedList(r100.f471753k));
        r103.setTableRootId(r100.f471752j);
        HashMap<Integer, TableInfo.TableRowPropertyWrapper> r104 = new HashMap();
        HashMap<Integer, TableInfo.TableCellPropertyWrapper> r105 = new HashMap();
        Iterator r106 = r100.f471754l.iterator();
        int r107 = 0;
        int r110 = 0;
    L4:
        if (r106.hasNext() == false) goto L24;
        Object r111 = r106.next();
        int r112 = r107 + 1;
        if (r107 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        h.b r113 = (h.b) r111;
        r104.put(Integer.valueOf(r107), new TableInfo.TableRowPropertyWrapper(r113.f471762b, r113.f471763c, r113.f471761a));
        Iterator r108 = r113.f471764d.iterator();
        int r109 = 0;
    L10:
        if (r108.hasNext() == false) goto L23;
        Object r114 = r108.next();
        int r115 = r109 + 1;
        if (r109 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        h.a r116 = (h.a) r114;
        if (r100.f471753k.size() <= r109) goto L17;
        Column r117 = (Column) ListProtector.get(r100.f471753k, r109);
    L18:
        Integer r118 = r117.getWidth();
        if (r118 == null) goto L21;
        int r119 = r118.intValue();
    L22:
        Integer r120 = Integer.valueOf(r110);
        Integer r121 = Integer.valueOf(r116.f471755a);
        Integer r213 = Integer.valueOf(r116.f471756b);
        HorizontalAlign r122 = r116.f471757c;
        VerticalAlign r123 = r116.f471758d;
        Integer r214 = Integer.valueOf(r119);
        boolean r124 = r116.f471759e;
        UIUtils.dp2px(r210, r119 * r116.f471755a);
        r102.h(r101.b(r116.f471760f));
        r105.put(r120, new TableInfo.TableCellPropertyWrapper(r121, r213, r122, r123, r214, r124, r102.a()));
        r100 = r212;
        r109 = r115;
        r110 = r110 + 1;
        r106 = r106;
        r108 = r108;
        goto L10
    L21:
        r119 = 100;
        goto L22
    L17:
        r117 = new Column(100, HorizontalAlign.HORIZONTAL_ALIGN_CENTER, VerticalAlign.VERTICAL_ALIGN_CENTER, false);
        goto L18
    L23:
        r100 = r212;
        r107 = r112;
        goto L4
    L24:
        r103.setTableCellPropertyMap(r105);
        r103.setTableRowPropertyMap(r104);
        return r103;
    }
}
