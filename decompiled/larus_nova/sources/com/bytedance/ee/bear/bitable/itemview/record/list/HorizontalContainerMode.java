package com.bytedance.ee.bear.bitable.itemview.record.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/HorizontalContainerMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "COMPACT", "ADAPTIVE", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HorizontalContainerMode extends Enum<HorizontalContainerMode> {
    public static final HorizontalContainerMode ADAPTIVE = null;
    public static final HorizontalContainerMode COMPACT = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HorizontalContainerMode[] f214094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214095b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<HorizontalContainerMode> getEntries() {
        return f214095b;
    }

    static {
        HorizontalContainerMode r100 = new HorizontalContainerMode("COMPACT", 0, 1);
        COMPACT = r100;
        HorizontalContainerMode r101 = new HorizontalContainerMode("ADAPTIVE", 1, 2);
        ADAPTIVE = r101;
        HorizontalContainerMode[] r102 = {r100, r101};
        f214094a = r102;
        f214095b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static HorizontalContainerMode[] values() {
        return (HorizontalContainerMode[]) f214094a.clone();
    }

    public static final /* synthetic */ int access$getValue$p(HorizontalContainerMode r100) {
        return r100.value;
    }

    public static HorizontalContainerMode valueOf(String r100) {
        return (HorizontalContainerMode) r27.a.a(HorizontalContainerMode.class, r100);
    }

    public HorizontalContainerMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
