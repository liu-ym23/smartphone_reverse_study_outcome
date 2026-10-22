package com.bytedance.ee.bear.bitable.itemview.record.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderType;", "", "value", "", "uniqueInt", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getUniqueInt", "Header", "TabContainer", "ContainerHeader", "HorizontalContainer", "Placeholder", "Hint", "Field", "HiddenInfo", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {
    public static final a Companion = null;
    public static final RenderType ContainerHeader = null;
    public static final RenderType Field = null;
    public static final RenderType Header = null;
    public static final RenderType HiddenInfo = null;
    public static final RenderType Hint = null;
    public static final RenderType HorizontalContainer = null;
    public static final RenderType Placeholder = null;
    public static final RenderType TabContainer = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderType[] f214126a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214127b = null;
    private final int uniqueInt;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<RenderType> getEntries() {
        return f214127b;
    }

    static {
        RenderType r100 = new RenderType("Header", 0, 1, -1);
        Header = r100;
        RenderType r101 = new RenderType("TabContainer", 1, 2, -2);
        TabContainer = r101;
        RenderType r102 = new RenderType("ContainerHeader", 2, 3, -3);
        ContainerHeader = r102;
        RenderType r103 = new RenderType("HorizontalContainer", 3, 4, -4);
        HorizontalContainer = r103;
        RenderType r104 = new RenderType("Placeholder", 4, 5, -5);
        Placeholder = r104;
        RenderType r110 = new RenderType("Hint", 5, 6, -6);
        Hint = r110;
        RenderType r111 = new RenderType("Field", 6, 7, -7);
        Field = r111;
        RenderType r112 = new RenderType("HiddenInfo", 7, 8, -8);
        HiddenInfo = r112;
        RenderType[] r105 = {r100, r101, r102, r103, r104, r110, r111, r112};
        f214126a = r105;
        f214127b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static RenderType[] values() {
        return (RenderType[]) f214126a.clone();
    }

    public final int getUniqueInt() {
        return this.uniqueInt;
    }

    public final int getValue() {
        return this.value;
    }

    public static RenderType valueOf(String r100) {
        return (RenderType) r27.a.a(RenderType.class, r100);
    }

    public RenderType(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.uniqueInt = r103;
    }
}
