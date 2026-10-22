package com.relax.relaxframework;

import com.ttnetuploader.uploader.api.UploadCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/relax/relaxframework/ScrollViewAttributeKey;", "", "", "value", "I", "getValue", "()I", "ScrollX", "ScrollY", "LowerThreshold", "UpperThreshold", "EnableScroll", "EnableNestedScroll", "ScrollTop", "ScrollLeft", "ScrollToIndex", "Direction", "Bounce", "ScrollFling", "ScrollOffset", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ScrollViewAttributeKey extends Enum<ScrollViewAttributeKey> {
    public static final ScrollViewAttributeKey Bounce = null;
    public static final ScrollViewAttributeKey Direction = null;
    public static final ScrollViewAttributeKey EnableNestedScroll = null;
    public static final ScrollViewAttributeKey EnableScroll = null;
    public static final ScrollViewAttributeKey LowerThreshold = null;
    public static final ScrollViewAttributeKey ScrollFling = null;
    public static final ScrollViewAttributeKey ScrollLeft = null;
    public static final ScrollViewAttributeKey ScrollOffset = null;
    public static final ScrollViewAttributeKey ScrollToIndex = null;
    public static final ScrollViewAttributeKey ScrollTop = null;
    public static final ScrollViewAttributeKey ScrollX = null;
    public static final ScrollViewAttributeKey ScrollY = null;
    public static final ScrollViewAttributeKey UpperThreshold = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollViewAttributeKey[] f404952a = null;
    private final int value;

    public static ScrollViewAttributeKey valueOf(String r100) {
        return (ScrollViewAttributeKey) r27.a.a(ScrollViewAttributeKey.class, r100);
    }

    public static ScrollViewAttributeKey[] values() {
        return (ScrollViewAttributeKey[]) f404952a.clone();
    }

    static {
        ScrollViewAttributeKey r100 = new ScrollViewAttributeKey("ScrollX", 0, 20061);
        ScrollX = r100;
        ScrollViewAttributeKey r101 = new ScrollViewAttributeKey("ScrollY", 1, 20062);
        ScrollY = r101;
        ScrollViewAttributeKey r102 = new ScrollViewAttributeKey("LowerThreshold", 2, 20088);
        LowerThreshold = r102;
        ScrollViewAttributeKey r103 = new ScrollViewAttributeKey("UpperThreshold", 3, 20089);
        UpperThreshold = r103;
        ScrollViewAttributeKey r104 = new ScrollViewAttributeKey("EnableScroll", 4, 20066);
        EnableScroll = r104;
        ScrollViewAttributeKey r105 = new ScrollViewAttributeKey("EnableNestedScroll", 5, 20067);
        EnableNestedScroll = r105;
        ScrollViewAttributeKey r110 = new ScrollViewAttributeKey("ScrollTop", 6, 20083);
        ScrollTop = r110;
        ScrollViewAttributeKey r111 = new ScrollViewAttributeKey("ScrollLeft", 7, 20084);
        ScrollLeft = r111;
        ScrollViewAttributeKey r112 = new ScrollViewAttributeKey("ScrollToIndex", 8, 20085);
        ScrollToIndex = r112;
        ScrollViewAttributeKey r113 = new ScrollViewAttributeKey("Direction", 9, 20087);
        Direction = r113;
        ScrollViewAttributeKey r114 = new ScrollViewAttributeKey("Bounce", 10, 20065);
        Bounce = r114;
        ScrollViewAttributeKey r106 = new ScrollViewAttributeKey("ScrollFling", 11, UploadCode.TT_UPLOAD_SERVER_FILE_DEFECT);
        ScrollFling = r106;
        ScrollViewAttributeKey r107 = new ScrollViewAttributeKey("ScrollOffset", 12, 20226);
        ScrollOffset = r107;
        f404952a = new ScrollViewAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public final int getValue() {
        return this.value;
    }

    public ScrollViewAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
