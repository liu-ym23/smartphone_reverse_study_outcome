package com.bytedance.locallife.poi.media.ui.indicator.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/base/PageSwipeDirection;", "", "", "direction", "I", "getDirection", "()I", "PAGE_SWIPE_DIRECTION_IDLE", "PAGE_SWIPE_DIRECTION_LEFT", "PAGE_SWIPE_DIRECTION_RIGHT", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PageSwipeDirection extends Enum<PageSwipeDirection> {
    public static final PageSwipeDirection PAGE_SWIPE_DIRECTION_IDLE = null;
    public static final PageSwipeDirection PAGE_SWIPE_DIRECTION_LEFT = null;
    public static final PageSwipeDirection PAGE_SWIPE_DIRECTION_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageSwipeDirection[] f262918a = null;
    private final int direction;

    public static PageSwipeDirection valueOf(String r100) {
        return (PageSwipeDirection) r27.a.a(PageSwipeDirection.class, r100);
    }

    public static PageSwipeDirection[] values() {
        return (PageSwipeDirection[]) f262918a.clone();
    }

    static {
        PageSwipeDirection r100 = new PageSwipeDirection("PAGE_SWIPE_DIRECTION_IDLE", 0, -1);
        PAGE_SWIPE_DIRECTION_IDLE = r100;
        PageSwipeDirection r101 = new PageSwipeDirection("PAGE_SWIPE_DIRECTION_LEFT", 1, 0);
        PAGE_SWIPE_DIRECTION_LEFT = r101;
        PageSwipeDirection r102 = new PageSwipeDirection("PAGE_SWIPE_DIRECTION_RIGHT", 2, 1);
        PAGE_SWIPE_DIRECTION_RIGHT = r102;
        f262918a = new PageSwipeDirection[]{r100, r101, r102};
    }

    public final int getDirection() {
        return this.direction;
    }

    public PageSwipeDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.direction = r102;
    }
}
