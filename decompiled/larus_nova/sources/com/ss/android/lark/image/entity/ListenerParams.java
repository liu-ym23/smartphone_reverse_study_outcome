package com.ss.android.lark.image.entity;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.api.DataSource;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ListenerParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f426286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f426287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f426288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f426289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f426290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f426291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f426292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f426293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Biz f426294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Scene f426295j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FromType f426296k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ChatType f426297l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f426298m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f426299n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f426300o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f426301p;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$ChatType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SINGLE", "GROUP", "TOPIC", "THREAD_DETAIL", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatType extends Enum<ChatType> {
        public static final ChatType GROUP = null;
        public static final ChatType SINGLE = null;
        public static final ChatType THREAD_DETAIL = null;
        public static final ChatType TOPIC = null;
        public static final ChatType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatType[] f426302a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f426303b = null;
        private final int value;

        public static EnumEntries<ChatType> getEntries() {
            return f426303b;
        }

        static {
            ChatType r100 = new ChatType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ChatType r101 = new ChatType("SINGLE", 1, 1);
            SINGLE = r101;
            ChatType r102 = new ChatType("GROUP", 2, 2);
            GROUP = r102;
            ChatType r103 = new ChatType("TOPIC", 3, 3);
            TOPIC = r103;
            ChatType r104 = new ChatType("THREAD_DETAIL", 4, 4);
            THREAD_DETAIL = r104;
            ChatType[] r105 = {r100, r101, r102, r103, r104};
            f426302a = r105;
            f426303b = EnumEntriesKt.enumEntries(r105);
        }

        public static ChatType[] values() {
            return (ChatType[]) f426302a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatType valueOf(String r100) {
            return (ChatType) r27.a.a(ChatType.class, r100);
        }

        public ChatType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$ColorSpace;", "", "value", "", "index", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getIndex", "()I", "UNKNOWN", "ACES", "ACESCG", "ADOBE_RGB", "BT2020", "BT709", "CIE_LAB", "CIE_XYZ", "DCI_P3", "DISPLAY_P3", "EXTENDED_SRGB", "LINEAR_EXTENDED_SRGB", "LINEAR_SRGB", "NTSC_1953", "PRO_PHOTO_RGB", "SMPTE_C", "SRGB", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ColorSpace extends Enum<ColorSpace> {
        public static final ColorSpace ACES = null;
        public static final ColorSpace ACESCG = null;
        public static final ColorSpace ADOBE_RGB = null;
        public static final ColorSpace BT2020 = null;
        public static final ColorSpace BT709 = null;
        public static final ColorSpace CIE_LAB = null;
        public static final ColorSpace CIE_XYZ = null;
        public static final ColorSpace DCI_P3 = null;
        public static final ColorSpace DISPLAY_P3 = null;
        public static final ColorSpace EXTENDED_SRGB = null;
        public static final ColorSpace LINEAR_EXTENDED_SRGB = null;
        public static final ColorSpace LINEAR_SRGB = null;
        public static final ColorSpace NTSC_1953 = null;
        public static final ColorSpace PRO_PHOTO_RGB = null;
        public static final ColorSpace SMPTE_C = null;
        public static final ColorSpace SRGB = null;
        public static final ColorSpace UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ColorSpace[] f426304a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f426305b = null;
        private final int index;
        private final String value;

        public static EnumEntries<ColorSpace> getEntries() {
            return f426305b;
        }

        static {
            ColorSpace r100 = new ColorSpace("UNKNOWN", 0, "unknown", 0);
            UNKNOWN = r100;
            ColorSpace r101 = new ColorSpace("ACES", 1, "aces", 1);
            ACES = r101;
            ColorSpace r102 = new ColorSpace("ACESCG", 2, "acescg", 2);
            ACESCG = r102;
            ColorSpace r103 = new ColorSpace("ADOBE_RGB", 3, "adobe_rgb", 3);
            ADOBE_RGB = r103;
            ColorSpace r104 = new ColorSpace("BT2020", 4, "bt2020", 4);
            BT2020 = r104;
            ColorSpace r105 = new ColorSpace("BT709", 5, "bt709", 5);
            BT709 = r105;
            ColorSpace r110 = new ColorSpace("CIE_LAB", 6, "cie_lab", 6);
            CIE_LAB = r110;
            ColorSpace r111 = new ColorSpace("CIE_XYZ", 7, "cie_xyz", 7);
            CIE_XYZ = r111;
            ColorSpace r112 = new ColorSpace("DCI_P3", 8, "dci_p3", 8);
            DCI_P3 = r112;
            ColorSpace r113 = new ColorSpace("DISPLAY_P3", 9, "display_p3", 9);
            DISPLAY_P3 = r113;
            ColorSpace r114 = new ColorSpace("EXTENDED_SRGB", 10, "extended_srgb", 10);
            EXTENDED_SRGB = r114;
            ColorSpace r106 = new ColorSpace("LINEAR_EXTENDED_SRGB", 11, "linear_extended_srgb", 11);
            LINEAR_EXTENDED_SRGB = r106;
            ColorSpace r107 = new ColorSpace("LINEAR_SRGB", 12, "linear_srgb", 12);
            LINEAR_SRGB = r107;
            ColorSpace r108 = new ColorSpace("NTSC_1953", 13, "ntsc_1953", 13);
            NTSC_1953 = r108;
            ColorSpace r109 = new ColorSpace("PRO_PHOTO_RGB", 14, "pro_photo_rgb", 14);
            PRO_PHOTO_RGB = r109;
            ColorSpace r115 = new ColorSpace("SMPTE_C", 15, "smpte_c", 15);
            SMPTE_C = r115;
            ColorSpace r116 = new ColorSpace("SRGB", 16, "srgb", 16);
            SRGB = r116;
            ColorSpace[] r117 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116};
            f426304a = r117;
            f426305b = EnumEntriesKt.enumEntries(r117);
        }

        public static ColorSpace[] values() {
            return (ColorSpace[]) f426304a.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getValue() {
            return this.value;
        }

        public static ColorSpace valueOf(String r100) {
            return (ColorSpace) r27.a.a(ColorSpace.class, r100);
        }

        public ColorSpace(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.value = r102;
            this.index = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$ColorType;", "", "value", "", "index", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getValue", "()Ljava/lang/String;", "getIndex", "()I", "UNKNOWN", "ALPHA_8", "RGB_565", "ARGB_444", "RGBA_8888", "RGB_888X", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ColorType extends Enum<ColorType> {
        public static final ColorType ALPHA_8 = null;
        public static final ColorType ARGB_444 = null;
        public static final ColorType RGBA_8888 = null;
        public static final ColorType RGB_565 = null;
        public static final ColorType RGB_888X = null;
        public static final ColorType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ColorType[] f426306a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f426307b = null;
        private final int index;
        private final String value;

        public static EnumEntries<ColorType> getEntries() {
            return f426307b;
        }

        static {
            ColorType r100 = new ColorType("UNKNOWN", 0, "unknown", 0);
            UNKNOWN = r100;
            ColorType r101 = new ColorType("ALPHA_8", 1, "alpha_8", 1);
            ALPHA_8 = r101;
            ColorType r102 = new ColorType("RGB_565", 2, "rgb_565", 2);
            RGB_565 = r102;
            ColorType r103 = new ColorType("ARGB_444", 3, "argb_444", 3);
            ARGB_444 = r103;
            ColorType r104 = new ColorType("RGBA_8888", 4, "rgba_8888", 4);
            RGBA_8888 = r104;
            ColorType r105 = new ColorType("RGB_888X", 5, "rgb_888x", 5);
            RGB_888X = r105;
            ColorType[] r110 = {r100, r101, r102, r103, r104, r105};
            f426306a = r110;
            f426307b = EnumEntriesKt.enumEntries(r110);
        }

        public static ColorType[] values() {
            return (ColorType[]) f426306a.clone();
        }

        public final int getIndex() {
            return this.index;
        }

        public final String getValue() {
            return this.value;
        }

        public static ColorType valueOf(String r100) {
            return (ColorType) r27.a.a(ColorType.class, r100);
        }

        public ColorType(String r100, int r101, String r102, int r103) {
            super(r100, r101);
            this.value = r102;
            this.index = r103;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$FromType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "IMAGE", "POST", "STICKER", "MEDIA", "AVATAR", "REATION", "CARD", "URL_PREVIEW", "COVER", "CHAT_HISTORY", "CHAT_ALBUM", "MEMO_PICTURE", "ICON", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FromType extends Enum<FromType> {
        public static final FromType AVATAR = null;
        public static final FromType CARD = null;
        public static final FromType CHAT_ALBUM = null;
        public static final FromType CHAT_HISTORY = null;
        public static final FromType COVER = null;
        public static final FromType ICON = null;
        public static final FromType IMAGE = null;
        public static final FromType MEDIA = null;
        public static final FromType MEMO_PICTURE = null;
        public static final FromType POST = null;
        public static final FromType REATION = null;
        public static final FromType STICKER = null;
        public static final FromType UNKNOWN = null;
        public static final FromType URL_PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FromType[] f426308a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f426309b = null;
        private final int value;

        public static EnumEntries<FromType> getEntries() {
            return f426309b;
        }

        static {
            FromType r100 = new FromType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            FromType r101 = new FromType("IMAGE", 1, 1);
            IMAGE = r101;
            FromType r102 = new FromType("POST", 2, 2);
            POST = r102;
            FromType r103 = new FromType("STICKER", 3, 3);
            STICKER = r103;
            FromType r104 = new FromType("MEDIA", 4, 4);
            MEDIA = r104;
            FromType r105 = new FromType("AVATAR", 5, 5);
            AVATAR = r105;
            FromType r110 = new FromType("REATION", 6, 6);
            REATION = r110;
            FromType r111 = new FromType("CARD", 7, 7);
            CARD = r111;
            FromType r112 = new FromType("URL_PREVIEW", 8, 8);
            URL_PREVIEW = r112;
            FromType r113 = new FromType("COVER", 9, 9);
            COVER = r113;
            FromType r114 = new FromType("CHAT_HISTORY", 10, 10);
            CHAT_HISTORY = r114;
            FromType r115 = new FromType("CHAT_ALBUM", 11, 11);
            CHAT_ALBUM = r115;
            FromType r106 = new FromType("MEMO_PICTURE", 12, 12);
            MEMO_PICTURE = r106;
            FromType r107 = new FromType("ICON", 13, 13);
            ICON = r107;
            FromType[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
            f426308a = r108;
            f426309b = EnumEntriesKt.enumEntries(r108);
        }

        public static FromType[] values() {
            return (FromType[]) f426308a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FromType valueOf(String r100) {
            return (FromType) r27.a.a(FromType.class, r100);
        }

        public FromType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/image/entity/ListenerParams$LoadType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NET", "DISK_CACHE", "MEMORY_CACHE", "image-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadType extends Enum<LoadType> {
        public static final LoadType DISK_CACHE = null;
        public static final LoadType MEMORY_CACHE = null;
        public static final LoadType NET = null;
        public static final LoadType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadType[] f426310a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f426311b = null;
        private final int value;

        public static EnumEntries<LoadType> getEntries() {
            return f426311b;
        }

        static {
            LoadType r100 = new LoadType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            LoadType r101 = new LoadType("NET", 1, 1);
            NET = r101;
            LoadType r102 = new LoadType("DISK_CACHE", 2, 2);
            DISK_CACHE = r102;
            LoadType r103 = new LoadType("MEMORY_CACHE", 3, 3);
            MEMORY_CACHE = r103;
            LoadType[] r104 = {r100, r101, r102, r103};
            f426310a = r104;
            f426311b = EnumEntriesKt.enumEntries(r104);
        }

        public static LoadType[] values() {
            return (LoadType[]) f426310a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static LoadType valueOf(String r100) {
            return (LoadType) r27.a.a(LoadType.class, r100);
        }

        public LoadType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f426312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f426313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f426314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f426315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f426316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f426317f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f426318g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public b f426319h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Biz f426320i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Scene f426321j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public FromType f426322k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final ChatType f426323l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f426324m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f426325n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f426326o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f426327p;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f426312a == r101.f426312a) goto L12;
            return false;
        L12:
            if (this.f426313b == r101.f426313b) goto L15;
            return false;
        L15:
            if (this.f426314c == r101.f426314c) goto L18;
            return false;
        L18:
            if (this.f426315d == r101.f426315d) goto L21;
            return false;
        L21:
            if (this.f426316e == r101.f426316e) goto L24;
            return false;
        L24:
            if (this.f426317f == r101.f426317f) goto L27;
            return false;
        L27:
            if (this.f426318g == r101.f426318g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f426319h, r101.f426319h) == true) goto L33;
            return false;
        L33:
            if (this.f426320i == r101.f426320i) goto L36;
            return false;
        L36:
            if (this.f426321j == r101.f426321j) goto L39;
            return false;
        L39:
            if (this.f426322k == r101.f426322k) goto L42;
            return false;
        L42:
            if (this.f426323l == r101.f426323l) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f426324m, r101.f426324m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.f426325n, r101.f426325n) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f426326o, r101.f426326o) == true) goto L54;
            return false;
        L54:
            if (this.f426327p == r101.f426327p) goto L56;
            return false;
        L56:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f426312a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f426313b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (((((((((((r102 + r103) * 31) + this.f426314c) * 31) + this.f426315d) * 31) + this.f426316e) * 31) + this.f426317f) * 31) + this.f426318g) * 31;
            b r105 = this.f426319h;
            int r106 = 0;
            if (r105 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (((((((((r104 + r107) * 31) + this.f426320i.hashCode()) * 31) + this.f426321j.hashCode()) * 31) + this.f426322k.hashCode()) * 31) + this.f426323l.hashCode()) * 31;
            String r109 = this.f426324m;
            if (r109 != null) goto L17;
            int r110 = 0;
        L18:
            int r111 = (r108 + r110) * 31;
            String r112 = this.f426325n;
            if (r112 != null) goto L21;
            int r113 = 0;
        L22:
            int r114 = (r111 + r113) * 31;
            String r115 = this.f426326o;
            if (r115 == null) goto L26;
            r106 = r115.hashCode();
        L26:
            int r116 = (r114 + r106) * 31;
            if (this.f426327p == true) goto L31;
            r100 = 1237;
        L31:
            return r116 + r100;
        L21:
            r113 = r112.hashCode();
            goto L22
        L17:
            r110 = r109.hashCode();
            goto L18
        L13:
            r107 = r105.hashCode();
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Builder(needLoadMonitor=" + this.f426312a + ", isThumbnail=" + this.f426313b + ", loadWidth=" + this.f426314c + ", loadHeight=" + this.f426315d + ", resourceWidth=" + this.f426316e + ", resourceHeight=" + this.f426317f + ", resourceFrames=" + this.f426318g + ", requestListener=" + this.f426319h + ", biz=" + this.f426320i + ", scene=" + this.f426321j + ", fromType=" + this.f426322k + ", chatType=" + this.f426323l + ", page=" + this.f426324m + ", messageId=" + this.f426325n + ", imageKey=" + this.f426326o + ", isOrigin=" + this.f426327p + ')';
        }

        public a() {
            Biz r100 = Biz.Messenger;
            Scene r101 = Scene.Chat;
            FromType r102 = FromType.UNKNOWN;
            ChatType r103 = ChatType.UNKNOWN;
            Intrinsics.checkNotNullParameter(r100, "biz");
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r102, "fromType");
            Intrinsics.checkNotNullParameter(r103, "chatType");
            this.f426312a = false;
            this.f426313b = false;
            this.f426314c = 0;
            this.f426315d = 0;
            this.f426316e = 0;
            this.f426317f = 0;
            this.f426318g = 0;
            this.f426319h = null;
            this.f426320i = r100;
            this.f426321j = r101;
            this.f426322k = r102;
            this.f426323l = r103;
            this.f426324m = null;
            this.f426325n = null;
            this.f426326o = null;
            this.f426327p = false;
        }

        public final ListenerParams b() {
            return new ListenerParams(this.f426312a, this.f426313b, this.f426314c, this.f426315d, this.f426316e, this.f426317f, this.f426318g, this.f426319h, this.f426320i, this.f426321j, this.f426322k, this.f426323l, this.f426324m, this.f426325n, this.f426326o, this.f426327p);
        }

        public final void a(Biz r100) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            this.f426320i = r100;
        }

        public final void c(FromType r100) {
            Intrinsics.checkNotNullParameter(r100, "fromType");
            this.f426322k = r100;
        }

        public final void d(Scene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f426321j = r100;
        }
    }

    public interface b {
        void a(Exception r100);

        void b(Object r100, Object r101, DataSource r102, boolean r103);
    }

    public ListenerParams(boolean r100, boolean r101, int r102, int r103, int r104, int r105, int r106, b r110, Biz r111, Scene r112, FromType r113, ChatType r114, String r115, String r116, String r117, boolean r118) {
        this.f426286a = r100;
        this.f426287b = r101;
        this.f426288c = r102;
        this.f426289d = r103;
        this.f426290e = r104;
        this.f426291f = r105;
        this.f426292g = r106;
        this.f426293h = r110;
        this.f426294i = r111;
        this.f426295j = r112;
        this.f426296k = r113;
        this.f426297l = r114;
        this.f426298m = r115;
        this.f426299n = r116;
        this.f426300o = r117;
        this.f426301p = r118;
    }
}
