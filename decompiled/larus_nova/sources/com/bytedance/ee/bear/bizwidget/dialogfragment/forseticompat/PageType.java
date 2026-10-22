package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/PageType;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "FLOAT", "BOTTOM_SHEET", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageType extends Enum<PageType> {
    public static final PageType BOTTOM_SHEET = null;
    public static final PageType FLOAT = null;
    public static final PageType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageType[] f216462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f216463b = null;

    public static EnumEntries<PageType> getEntries() {
        return f216463b;
    }

    static {
        PageType r100 = new PageType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        PageType r101 = new PageType("FLOAT", 1);
        FLOAT = r101;
        PageType r102 = new PageType("BOTTOM_SHEET", 2);
        BOTTOM_SHEET = r102;
        PageType[] r103 = {r100, r101, r102};
        f216462a = r103;
        f216463b = EnumEntriesKt.enumEntries(r103);
    }

    public static PageType[] values() {
        return (PageType[]) f216462a.clone();
    }

    public static PageType valueOf(String r100) {
        return (PageType) r27.a.a(PageType.class, r100);
    }

    public PageType(String r100, int r101) {
        super(r100, r101);
    }
}
