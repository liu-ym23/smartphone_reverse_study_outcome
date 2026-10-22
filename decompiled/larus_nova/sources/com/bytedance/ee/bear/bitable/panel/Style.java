package com.bytedance.ee.bear.bitable.panel;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/Style;", "", "value", "", "colorRes", "textRes", "<init>", "(Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;)V", "getValue", "()I", "getColorRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTextRes", "Default", "Normal", "Desc", "Select", "Warning", "Disable", "TRANSLATE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Style extends Enum<Style> {
    public static final Style Default = null;
    public static final Style Desc = null;
    public static final Style Disable = null;
    public static final Style Normal = null;
    public static final Style Select = null;
    public static final Style TRANSLATE = null;
    public static final Style Warning = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Style[] f214836a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214837b = null;
    private final Integer colorRes;
    private final Integer textRes;
    private final int value;

    public static EnumEntries<Style> getEntries() {
        return f214837b;
    }

    static {
        Style r100 = new Style("Default", 0, 0, null, null);
        Default = r100;
        Style r101 = new Style("Normal", 1, 1, Integer.valueOf(R.color.icon_n1), Integer.valueOf(R.color.text_title));
        Normal = r101;
        Style r102 = new Style("Desc", 2, 2, Integer.valueOf(R.color.icon_n2), Integer.valueOf(R.color.text_caption));
        Desc = r102;
        Integer r110 = Integer.valueOf(R.color.primary_fill_default);
        Style r103 = new Style("Select", 3, 3, r110, r110);
        Select = r103;
        Integer r111 = Integer.valueOf(R.color.function_danger_fill_default);
        Style r104 = new Style("Warning", 4, 4, r111, r111);
        Warning = r104;
        Style r105 = new Style("Disable", 5, 5, Integer.valueOf(R.color.icon_disable), Integer.valueOf(R.color.text_disable));
        Disable = r105;
        Integer r112 = Integer.valueOf(R.color.transparent);
        Style r106 = new Style("TRANSLATE", 6, 6, r112, r112);
        TRANSLATE = r106;
        Style[] r107 = {r100, r101, r102, r103, r104, r105, r106};
        f214836a = r107;
        f214837b = EnumEntriesKt.enumEntries(r107);
    }

    public static Style[] values() {
        return (Style[]) f214836a.clone();
    }

    public final Integer getColorRes() {
        return this.colorRes;
    }

    public final Integer getTextRes() {
        return this.textRes;
    }

    public final int getValue() {
        return this.value;
    }

    public static Style valueOf(String r100) {
        return (Style) r27.a.a(Style.class, r100);
    }

    public Style(String r100, int r101, int r102, Integer r103, Integer r104) {
        super(r100, r101);
        this.value = r102;
        this.colorRes = r103;
        this.textRes = r104;
    }
}
