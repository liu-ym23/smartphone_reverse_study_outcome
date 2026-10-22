package com.relax.relaxframework;

import com.byted.cast.mediacommon.MediaCaptureError;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/relax/relaxframework/ScrollViewEventKey;", "", "", "value", "I", "getValue", "()I", "Scroll", "ScrollToUpper", "ScrollToLower", "ScrollToBounce", "ScrollStart", "ScrollEnd", "ContentSizeChanged", "ScrollStateChange", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ScrollViewEventKey extends Enum<ScrollViewEventKey> {
    public static final ScrollViewEventKey ContentSizeChanged = null;
    public static final ScrollViewEventKey Scroll = null;
    public static final ScrollViewEventKey ScrollEnd = null;
    public static final ScrollViewEventKey ScrollStart = null;
    public static final ScrollViewEventKey ScrollStateChange = null;
    public static final ScrollViewEventKey ScrollToBounce = null;
    public static final ScrollViewEventKey ScrollToLower = null;
    public static final ScrollViewEventKey ScrollToUpper = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollViewEventKey[] f404954a = null;
    private final int value;

    public static ScrollViewEventKey valueOf(String r100) {
        return (ScrollViewEventKey) r27.a.a(ScrollViewEventKey.class, r100);
    }

    public static ScrollViewEventKey[] values() {
        return (ScrollViewEventKey[]) f404954a.clone();
    }

    static {
        ScrollViewEventKey r100 = new ScrollViewEventKey("Scroll", 0, 30005);
        Scroll = r100;
        ScrollViewEventKey r101 = new ScrollViewEventKey("ScrollToUpper", 1, MediaCaptureError.ERROR_CAST_CONNECTION_NOT_BUILT);
        ScrollToUpper = r101;
        ScrollViewEventKey r102 = new ScrollViewEventKey("ScrollToLower", 2, 30007);
        ScrollToLower = r102;
        ScrollViewEventKey r103 = new ScrollViewEventKey("ScrollToBounce", 3, 30008);
        ScrollToBounce = r103;
        ScrollViewEventKey r104 = new ScrollViewEventKey("ScrollStart", 4, 30009);
        ScrollStart = r104;
        ScrollViewEventKey r105 = new ScrollViewEventKey("ScrollEnd", 5, 30010);
        ScrollEnd = r105;
        ScrollViewEventKey r110 = new ScrollViewEventKey("ContentSizeChanged", 6, 30011);
        ContentSizeChanged = r110;
        ScrollViewEventKey r111 = new ScrollViewEventKey("ScrollStateChange", 7, 30012);
        ScrollStateChange = r111;
        f404954a = new ScrollViewEventKey[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final int getValue() {
        return this.value;
    }

    public ScrollViewEventKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
