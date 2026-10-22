package xd8;

import android.content.res.Resources;
import android.text.TextPaint;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.chat.list.cell.text.cells.base.CellComponentType;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.platform.api.f3;
import com.larus.platform.service.e2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import dg8.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class i implements td8.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Integer f563294b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f563295a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f563296a = null;

        static {
            int[] r100 = new int[TextCellCutType.values().length];
            r100[TextCellCutType.DeepThinkCutMultipleCell.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TextCellCutType.NewCutThreeTextCell.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f563296a = r100;
        }
    }

    @Override // td8.b
    public final void b() {
    }

    static {
        gw8.c.f483071a.getClass();
        gw8.c r100 = gw8.c.a.b();
        lw8.h r101 = null;
        if (r100 == null) goto L5;
        lw8.h r102 = r100.createCacheMarkwonStruct(AppHost.f326268a.getApplication(), null, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31), null, false);
    L7:
        if ((r102 instanceof MarkwonStruct) == false) goto L9;
        MarkwonStruct r103 = (MarkwonStruct) r102;
    L9:
        gw8.c r104 = gw8.c.a.b();
        if (r104 == null) goto L13;
        r101 = r104.createCacheMarkwonStruct(AppHost.f326268a.getApplication(), null, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31), null, true);
    L13:
        if ((r101 instanceof MarkwonStruct) == false) goto L16;
        MarkwonStruct r105 = (MarkwonStruct) r101;
        return;
    L16:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.TRANSFORM_TO_MARK_WIDGET;
    }

    public i(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f563295a = LazyKt.lazy(new h(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        List r100 = CollectionsKt.toMutableList(r110.f314033a);
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L65;
        xc8.b r103 = (xc8.b) r102.next();
        if ((r103 instanceof l) == true) goto L7;
        r101.add(r103);
        goto L4
    L7:
        int r104 = b.f563296a[((TextCellCutType) this.f563295a.getValue()).ordinal()];
        if (r104 != 1) goto L10;
        r101.add(r103);
        goto L4
    L10:
        if (r104 != 2) goto L11;
        List<TextTagInfo> r105 = com.larus.bmhome.chat.bean.d.O(r103.getMessage());
        if (r105 == null) goto L25;
        List<TextTagInfo> r106 = r105;
        if ((r106 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r107 = r106.iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(TagEnum.TagEnum_InsertText.value), Integer.valueOf(TagEnum.TagEnum_InsertText_V2.value), Integer.valueOf(TagEnum.TagEnum_InsertText_Lynx.value), Integer.valueOf(TagEnum.TagEnum_InsertText_APPLET.value)}).contains(Integer.valueOf(((TextTagInfo) r107.next()).type)) == false) goto L21;
        boolean r108 = true;
    L26:
        int r109 = wf9.b.f559489a;
        Message r111 = r103.getMessage();
        Intrinsics.checkNotNullParameter(r111, "message");
        String r112 = com.larus.im.bean.message.a.K(r111);
        if (r112 == null) goto L29;
        int r113 = r112.length();
    L30:
        Integer r114 = f563294b;
        if (r114 != null) goto L38;
        TextPaint r115 = new TextPaint();
        r115.setTextSize(we8.a.a(i5.o(), false));
        float r116 = r115.measureText(DownloadConstants.VULNERABILITY_PATH);
        float r117 = r115.measureText("...") - r116;
        if (e2.f365734a.isPad() == false) goto L36;
        Resources r118 = AppHost.f326268a.getApplication().getResources();
        int r119 = RangesKt.coerceAtMost(WindowDisplayMetricsOverride.apply(r118, r118.getDisplayMetrics()).widthPixels, f3.a.a());
    L37:
        r114 = Integer.valueOf((int) (((r119 - r116) / r117) + 2));
        f563294b = r114;
        goto L38
    L36:
        Resources r120 = AppHost.f326268a.getApplication().getResources();
        r119 = WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()).widthPixels;
    L38:
        if (r114 == null) goto L40;
        int r121 = r114.intValue();
        FLogger.f375446a.i("TransformToMarkWidgetTask", "getMaxContentLength: " + r121);
        int r122 = r114.intValue();
    L41:
        if (r113 < r122) goto L43;
        boolean r123 = true;
    L44:
        if (r113 == 0) goto L46;
        boolean r124 = true;
    L47:
        if (r108 == true) goto L49;
        if (r123 == true) goto L49;
    L51:
        boolean r125 = false;
    L52:
        if (r125 == true) goto L53;
        r101.add(r103);
        goto L4
    L53:
        l r126 = (l) r103;
        ArrayList r127 = new ArrayList();
        List r128 = CollectionsKt.listOf(new gg8.g(r126.f563233a, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.TOP_CELL_COMPONENT, 0, 1, 56)));
        int r129 = r128.size() + 2;
        List r130 = r128;
        Iterator r131 = r130.iterator();
        int r132 = 0;
    L55:
        if (r131.hasNext() == false) goto L60;
        Object r133 = r131.next();
        int r134 = r132 + 1;
        if (r132 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();
    L59:
        com.larus.bmhome.chat.list.cell.text.cells.base.a r135 = (com.larus.bmhome.chat.list.cell.text.cells.base.a) r133;
        r135.i().f306024d = r132;
        r135.i().f306025e = r129;
        r132 = r134;
        goto L55
    L60:
        fg8.f r136 = new fg8.f(r126.f563233a, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.MIDDLE_CELL_COMPONENT, 0, 1, 56));
        r136.f476904g.f306024d = r128.size();
        r136.f476904g.f306025e = r129;
        eg8.g r137 = new eg8.g(r126.f563233a, new com.larus.bmhome.chat.list.cell.text.cells.base.c(CellComponentType.BOTTOM_CELL_COMPONENT, 0, 1, 56));
        r137.f472614g.f306024d = r128.size() + 1;
        r137.f472614g.f306025e = r129;
        r127.add(r137);
        r127.add(r136);
        r127.addAll(CollectionsKt.reversed(r130));
        r101.addAll(CollectionsKt.toMutableList(r127));
    L49:
        if (r124 == false) goto L51;
        r125 = true;
        goto L52
    L46:
        r124 = false;
        goto L47
    L43:
        r123 = false;
        goto L44
    L40:
        r122 = Integer.MAX_VALUE;
        goto L41
    L29:
        r113 = 0;
        goto L30
    L17:
        if (r106.isEmpty() == false) goto L19;
    L25:
        r108 = false;
        goto L26
    L11:
        r101.add(r103);
        goto L4
    L65:
        return com.larus.bmhome.social.page.datasource.event.c.a(r110, r101, 0, null, null, 14);
    }
}
