package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.RichTextElement;
import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
public final class h0 {
    static {
    }

    @JvmStatic
    public static final RichTextElement.TableCellProperty a(com.ss.android.lark.widget.richtext.RichTextElement.TableCellProperty r100) {
        RichTextElement.TableCellProperty.Builder r101 = new RichTextElement.TableCellProperty.Builder();
        if (r100 == null) goto L7;
        HorizontalAlign r102 = r100.getHorizontalAlign();
        if (r102 == null) goto L7;
    L8:
        RichTextElement.TableCellProperty.Builder r103 = r101.horizontal_align(RichTextElement.HorizontalAlign.fromValue(r102.getNumber()));
        if (r100 == null) goto L13;
        VerticalAlign r104 = r100.getVerticalAlign();
        if (r104 == null) goto L13;
    L14:
        RichTextElement.TableCellProperty.Builder r105 = r103.vertical_align(RichTextElement.VerticalAlign.fromValue(r104.getNumber()));
        Integer r106 = null;
        if (r100 == null) goto L17;
        Integer r107 = Integer.valueOf(r100.getColumnSpan());
    L18:
        RichTextElement.TableCellProperty.Builder r108 = r105.colspan(Integer.valueOf(d(r107, 1)));
        if (r100 == null) goto L21;
        r106 = Integer.valueOf(r100.getRowSpan());
    L21:
        RichTextElement.TableCellProperty.Builder r109 = r108.rowspan(Integer.valueOf(d(r106, 1)));
        if (r100 == null) goto L24;
        boolean r110 = r100.isMerged();
    L25:
        r109.is_merged(Boolean.valueOf(r110));
        return r101.build();
    L24:
        r110 = false;
        goto L25
    L17:
        r107 = null;
    L13:
        r104 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L7:
        r102 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
        goto L8
    }

    @JvmStatic
    public static final RichTextElement.TableProperty b(com.ss.android.lark.widget.richtext.RichTextElement.TableProperty r100) {
        RichTextElement.TableProperty.Builder r101 = new RichTextElement.TableProperty.Builder();
        if (r100 == null) goto L20;
        LinkedList<Column> r102 = r100.getColumns();
        if (r102 == null) goto L20;
        ArrayList r103 = new ArrayList();
        Iterator<Column> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L18;
        Column r105 = r104.next();
        RichTextElement.TableProperty.Column.Builder r106 = new RichTextElement.TableProperty.Column.Builder().width(Integer.valueOf(d(r105.getWidth(), 100)));
        HorizontalAlign r107 = r105.getHorizontalAlign();
        if (r107 != null) goto L13;
        r107 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
    L13:
        RichTextElement.TableProperty.Column.Builder r108 = r106.horizontal_align(RichTextElement.HorizontalAlign.fromValue(r107.getNumber()));
        VerticalAlign r109 = r105.getVerticalAlign();
        if (r109 != null) goto L17;
        r109 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L17:
        r103.add(r108.vertical_align(RichTextElement.VerticalAlign.fromValue(r109.getNumber())).is_header(Boolean.valueOf(r105.isHeader())).build());
        goto L8
    L18:
        r101.columns(r103);
    L20:
        return r101.build();
    }

    @JvmStatic
    public static final RichTextElement.TableRowProperty c(com.ss.android.lark.widget.richtext.RichTextElement.TableRowProperty r100) {
        RichTextElement.TableRowProperty.Builder r101 = new RichTextElement.TableRowProperty.Builder();
        if (r100 == null) goto L7;
        HorizontalAlign r102 = r100.getHorizontalAlign();
        if (r102 == null) goto L7;
    L8:
        RichTextElement.TableRowProperty.Builder r103 = r101.horizontal_align(RichTextElement.HorizontalAlign.fromValue(r102.getNumber()));
        if (r100 == null) goto L13;
        VerticalAlign r104 = r100.getVerticalAlign();
        if (r104 == null) goto L13;
    L14:
        RichTextElement.TableRowProperty.Builder r105 = r103.vertical_align(RichTextElement.VerticalAlign.fromValue(r104.getNumber()));
        if (r100 == null) goto L17;
        boolean r106 = r100.isHeader();
    L18:
        r105.is_header(Boolean.valueOf(r106));
        return r101.build();
    L17:
        r106 = false;
    L13:
        r104 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L7:
        r102 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
        goto L8
    }

    public static int d(Integer r100, int r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        if (r100.intValue() <= 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L12;
        return r101;
    L12:
        return r100.intValue();
    L6:
        r102 = false;
        goto L7
    }
}
