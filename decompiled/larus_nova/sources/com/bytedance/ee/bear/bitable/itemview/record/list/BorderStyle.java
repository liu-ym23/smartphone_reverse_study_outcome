package com.bytedance.ee.bear.bitable.itemview.record.list;

import com.bytedance.android.ecom.arch.slice.render.SlcBorderStyle;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/BorderStyle;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Soli", "Dashed", "Dotted", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BorderStyle extends Enum<BorderStyle> {
    public static final a Companion = null;
    public static final BorderStyle Dashed = null;
    public static final BorderStyle Dotted = null;
    public static final BorderStyle Soli = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, BorderStyle> f214081a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ BorderStyle[] f214082b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214083c = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BorderStyle> getEntries() {
        return f214083c;
    }

    static {
        int r100 = 0;
        BorderStyle r101 = new BorderStyle("Soli", 0, SlcBorderStyle.SOLID);
        Soli = r101;
        BorderStyle r102 = new BorderStyle("Dashed", 1, "dashed");
        Dashed = r102;
        BorderStyle r103 = new BorderStyle("Dotted", 2, "dotted");
        Dotted = r103;
        BorderStyle[] r104 = {r101, r102, r103};
        f214082b = r104;
        f214083c = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
        BorderStyle[] r105 = values();
        LinkedHashMap r106 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r105.length), 16));
        int r107 = r105.length;
    L3:
        if (r100 >= r107) goto L5;
        BorderStyle r108 = r105[r100];
        r106.put(r108.value.toLowerCase(Locale.ROOT), r108);
        r100 = r100 + 1;
        goto L3
    L5:
        f214081a = r106;
    }

    public static BorderStyle[] values() {
        return (BorderStyle[]) f214082b.clone();
    }

    public static final /* synthetic */ Map access$getMap$cp() {
        return f214081a;
    }

    public final String getValue() {
        return this.value;
    }

    public static BorderStyle valueOf(String r100) {
        return (BorderStyle) r27.a.a(BorderStyle.class, r100);
    }

    public BorderStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
