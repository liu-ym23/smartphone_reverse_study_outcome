package com.larus.chat.gallery.impl.preview.toolbar;

import com.alibaba.gaiax.template.GXMode;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/larus/chat/gallery/impl/preview/toolbar/ToolbarButtonType;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "SHARE", HttpMethod.DOWNLOAD, "MARK", "CROP", "PUBLISH", "SET_PRIVATE", "VIEW_SOURCE", "DELETE", "RENAME", "MOVE", "MORE", "WATERMARK", "SELECT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToolbarButtonType extends Enum<ToolbarButtonType> {
    public static final ToolbarButtonType CROP = null;
    public static final a Companion = null;
    public static final ToolbarButtonType DELETE = null;
    public static final ToolbarButtonType DOWNLOAD = null;
    public static final ToolbarButtonType MARK = null;
    public static final ToolbarButtonType MORE = null;
    public static final ToolbarButtonType MOVE = null;
    public static final ToolbarButtonType PUBLISH = null;
    public static final ToolbarButtonType RENAME = null;
    public static final ToolbarButtonType SELECT = null;
    public static final ToolbarButtonType SET_PRIVATE = null;
    public static final ToolbarButtonType SHARE = null;
    public static final ToolbarButtonType VIEW_SOURCE = null;
    public static final ToolbarButtonType WATERMARK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ToolbarButtonType[] f324675a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324676b = null;
    private final String key;

    public static EnumEntries<ToolbarButtonType> getEntries() {
        return f324676b;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType$a] */
    static {
        ToolbarButtonType r100 = new ToolbarButtonType("SHARE", 0, "share");
        SHARE = r100;
        ToolbarButtonType r101 = new ToolbarButtonType(HttpMethod.DOWNLOAD, 1, "download");
        DOWNLOAD = r101;
        ToolbarButtonType r102 = new ToolbarButtonType("MARK", 2, "mark");
        MARK = r102;
        ToolbarButtonType r103 = new ToolbarButtonType("CROP", 3, GXMode.MODE_TYPE_CROP);
        CROP = r103;
        ToolbarButtonType r104 = new ToolbarButtonType("PUBLISH", 4, "publish");
        PUBLISH = r104;
        ToolbarButtonType r105 = new ToolbarButtonType("SET_PRIVATE", 5, ShareChannel.SET_PRIVATE);
        SET_PRIVATE = r105;
        ToolbarButtonType r110 = new ToolbarButtonType("VIEW_SOURCE", 6, "view_source");
        VIEW_SOURCE = r110;
        ToolbarButtonType r111 = new ToolbarButtonType("DELETE", 7, "delete");
        DELETE = r111;
        ToolbarButtonType r112 = new ToolbarButtonType("RENAME", 8, "rename");
        RENAME = r112;
        ToolbarButtonType r113 = new ToolbarButtonType("MOVE", 9, "move");
        MOVE = r113;
        ToolbarButtonType r106 = new ToolbarButtonType("MORE", 10, "more");
        MORE = r106;
        ToolbarButtonType r107 = new ToolbarButtonType("WATERMARK", 11, "watermark");
        WATERMARK = r107;
        ToolbarButtonType r108 = new ToolbarButtonType("SELECT", 12, "select");
        SELECT = r108;
        ToolbarButtonType[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108};
        f324675a = r109;
        f324676b = EnumEntriesKt.enumEntries(r109);
        Companion = new a();
    }

    public static ToolbarButtonType[] values() {
        return (ToolbarButtonType[]) f324675a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static ToolbarButtonType valueOf(String r100) {
        return (ToolbarButtonType) r27.a.a(ToolbarButtonType.class, r100);
    }

    public ToolbarButtonType(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
