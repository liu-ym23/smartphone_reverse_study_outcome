package com.bytedance.live.richcontent.model.style;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class ImageStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdjustType f255752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f255753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f255754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f255755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f255756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f255757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PlaceHolderType f255758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PlaceHolderType f255759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f255760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f255761j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f255762k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AlignmentType f255763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f255764m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f255765n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f255766o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f255767p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f255768q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f255769r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f255770s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f255771t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f255772u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/live/richcontent/model/style/ImageStyle$AdjustType;", "", "ORIGIN", "EXACTLY", "SCALE", "ADJUST_WIDTH", "ADJUST_HEIGHT", "richcontent_release"}, k = 1, mv = {1, 4, 2})
    public static final enum AdjustType extends Enum<AdjustType> {
        public static final AdjustType ADJUST_HEIGHT = null;
        public static final AdjustType ADJUST_WIDTH = null;
        public static final AdjustType EXACTLY = null;
        public static final AdjustType ORIGIN = null;
        public static final AdjustType SCALE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AdjustType[] f255773a = null;

        static {
            AdjustType r100 = new AdjustType("ORIGIN", 0);
            ORIGIN = r100;
            AdjustType r101 = new AdjustType("EXACTLY", 1);
            EXACTLY = r101;
            AdjustType r102 = new AdjustType("SCALE", 2);
            SCALE = r102;
            AdjustType r103 = new AdjustType("ADJUST_WIDTH", 3);
            ADJUST_WIDTH = r103;
            AdjustType r104 = new AdjustType("ADJUST_HEIGHT", 4);
            ADJUST_HEIGHT = r104;
            f255773a = new AdjustType[]{r100, r101, r102, r103, r104};
        }

        public static AdjustType valueOf(String r100) {
            return (AdjustType) a.a(AdjustType.class, r100);
        }

        public static AdjustType[] values() {
            return (AdjustType[]) f255773a.clone();
        }

        public AdjustType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/live/richcontent/model/style/ImageStyle$AlignmentType;", "", "", "value", "I", "getValue", "()I", "CENTER_ALIGN_TO_LINE_CENTER", "CENTER_ALIGN_TO_TEXT_CENTER", "BOTTOM_ALIGN_TO_BASELINE", "BOTTOM_ALIGN_TO_DESCENT", "TOP_ALIGN_TO_ASCENT", "TOP_ALIGN_TO_TOP", "richcontent_release"}, k = 1, mv = {1, 4, 2})
    public static final enum AlignmentType extends Enum<AlignmentType> {
        public static final AlignmentType BOTTOM_ALIGN_TO_BASELINE = null;
        public static final AlignmentType BOTTOM_ALIGN_TO_DESCENT = null;
        public static final AlignmentType CENTER_ALIGN_TO_LINE_CENTER = null;
        public static final AlignmentType CENTER_ALIGN_TO_TEXT_CENTER = null;
        public static final AlignmentType TOP_ALIGN_TO_ASCENT = null;
        public static final AlignmentType TOP_ALIGN_TO_TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AlignmentType[] f255774a = null;
        private final int value;

        static {
            AlignmentType r100 = new AlignmentType("CENTER_ALIGN_TO_LINE_CENTER", 0, 1);
            CENTER_ALIGN_TO_LINE_CENTER = r100;
            AlignmentType r101 = new AlignmentType("CENTER_ALIGN_TO_TEXT_CENTER", 1, 2);
            CENTER_ALIGN_TO_TEXT_CENTER = r101;
            AlignmentType r102 = new AlignmentType("BOTTOM_ALIGN_TO_BASELINE", 2, 3);
            BOTTOM_ALIGN_TO_BASELINE = r102;
            AlignmentType r103 = new AlignmentType("BOTTOM_ALIGN_TO_DESCENT", 3, 4);
            BOTTOM_ALIGN_TO_DESCENT = r103;
            AlignmentType r104 = new AlignmentType("TOP_ALIGN_TO_ASCENT", 4, 6);
            TOP_ALIGN_TO_ASCENT = r104;
            AlignmentType r105 = new AlignmentType("TOP_ALIGN_TO_TOP", 5, 5);
            TOP_ALIGN_TO_TOP = r105;
            f255774a = new AlignmentType[]{r100, r101, r102, r103, r104, r105};
        }

        public static AlignmentType valueOf(String r100) {
            return (AlignmentType) a.a(AlignmentType.class, r100);
        }

        public static AlignmentType[] values() {
            return (AlignmentType[]) f255774a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public AlignmentType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/live/richcontent/model/style/ImageStyle$PlaceHolderType;", "", "EMPTY", CardAdapter.TEXT, "FIX_SIZE", "richcontent_release"}, k = 1, mv = {1, 4, 2})
    public static final enum PlaceHolderType extends Enum<PlaceHolderType> {
        public static final PlaceHolderType EMPTY = null;
        public static final PlaceHolderType FIX_SIZE = null;
        public static final PlaceHolderType TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlaceHolderType[] f255775a = null;

        static {
            PlaceHolderType r100 = new PlaceHolderType("EMPTY", 0);
            EMPTY = r100;
            PlaceHolderType r101 = new PlaceHolderType(CardAdapter.TEXT, 1);
            TEXT = r101;
            PlaceHolderType r102 = new PlaceHolderType("FIX_SIZE", 2);
            FIX_SIZE = r102;
            f255775a = new PlaceHolderType[]{r100, r101, r102};
        }

        public static PlaceHolderType valueOf(String r100) {
            return (PlaceHolderType) a.a(PlaceHolderType.class, r100);
        }

        public static PlaceHolderType[] values() {
            return (PlaceHolderType[]) f255775a.clone();
        }

        public PlaceHolderType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ImageStyle(AdjustType r110, int r111, int r210, float r211, int r212, int r213, PlaceHolderType r214, PlaceHolderType r215, String r216, int r217, int r218, AlignmentType r219, int r310, int r311, int r312, int r313) {
        if ((r313 & 1) == 0) goto L5;
        AdjustType r100 = AdjustType.ORIGIN;
    L7:
        if ((r313 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r313 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r313 & 8) == 0) goto L17;
        float r103 = 0.0f;
    L19:
        if ((r313 & 16) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r313 & 32) == 0) goto L25;
        int r105 = 0;
    L27:
        if ((r313 & 64) == 0) goto L29;
        PlaceHolderType r112 = PlaceHolderType.EMPTY;
    L31:
        if ((r313 & 128) == 0) goto L33;
        PlaceHolderType r113 = PlaceHolderType.EMPTY;
    L35:
        if ((r313 & 256) == 0) goto L37;
        String r114 = "";
    L39:
        if ((r313 & 512) == 0) goto L41;
        int r115 = 0;
    L43:
        if ((r313 & 1024) == 0) goto L45;
        int r116 = 0;
    L47:
        if ((r313 & 2048) == 0) goto L49;
        AlignmentType r117 = AlignmentType.CENTER_ALIGN_TO_LINE_CENTER;
    L51:
        if ((r313 & 4096) == 0) goto L53;
        int r106 = 0;
    L55:
        if ((r313 & 16384) == 0) goto L57;
        int r107 = 0;
    L59:
        if ((r313 & 1048576) == 0) goto L61;
        int r118 = 255;
    L62:
        Intrinsics.checkNotNullParameter(r100, "adjustType");
        Intrinsics.checkNotNullParameter(r112, "placeHolderTypeWhenLoad");
        Intrinsics.checkNotNullParameter(r113, "placeHolderTypeWhenFailed");
        Intrinsics.checkNotNullParameter(r114, "placeHolderText");
        Intrinsics.checkNotNullParameter(r117, "alignmentType");
        this.f255752a = r100;
        this.f255753b = r101;
        this.f255754c = r102;
        this.f255755d = r103;
        this.f255756e = r104;
        this.f255757f = r105;
        this.f255758g = r112;
        this.f255759h = r113;
        this.f255760i = r114;
        this.f255761j = r115;
        this.f255762k = r116;
        this.f255763l = r117;
        this.f255764m = r106;
        this.f255765n = 0;
        this.f255766o = r107;
        this.f255767p = 0;
        this.f255768q = false;
        this.f255769r = 0;
        this.f255770s = 0.0f;
        this.f255771t = 0;
        this.f255772u = r118;
        return;
    L61:
        r118 = r312;
        goto L62
    L57:
        r107 = r311;
        goto L59
    L53:
        r106 = r310;
        goto L55
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r112 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
