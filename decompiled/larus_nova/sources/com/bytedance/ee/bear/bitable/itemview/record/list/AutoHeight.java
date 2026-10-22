package com.bytedance.ee.bear.bitable.itemview.record.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/AutoHeight;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "None", "Toolbar", "Bottom", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AutoHeight extends Enum<AutoHeight> {
    public static final AutoHeight Bottom = null;
    public static final a Companion = null;
    public static final AutoHeight None = null;
    public static final AutoHeight Toolbar = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoHeight[] f214079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214080b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AutoHeight> getEntries() {
        return f214080b;
    }

    static {
        AutoHeight r100 = new AutoHeight("None", 0, 0);
        None = r100;
        AutoHeight r101 = new AutoHeight("Toolbar", 1, 1);
        Toolbar = r101;
        AutoHeight r102 = new AutoHeight("Bottom", 2, 2);
        Bottom = r102;
        AutoHeight[] r103 = {r100, r101, r102};
        f214079a = r103;
        f214080b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static AutoHeight[] values() {
        return (AutoHeight[]) f214079a.clone();
    }

    public static final /* synthetic */ int access$getValue$p(AutoHeight r100) {
        return r100.value;
    }

    public static AutoHeight valueOf(String r100) {
        return (AutoHeight) r27.a.a(AutoHeight.class, r100);
    }

    public AutoHeight(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
