package com.larus.bmhome.chat.standarduikit.richmedia.view;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaItemAction;", "", "<init>", "(Ljava/lang/String;I)V", HttpMethod.DOWNLOAD, "SHARE", "IMAGE_EDIT", "VIDEO_EDIT", "CITE", "EXTEND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RichMediaItemAction extends Enum<RichMediaItemAction> {
    public static final RichMediaItemAction CITE = null;
    public static final RichMediaItemAction DOWNLOAD = null;
    public static final RichMediaItemAction EXTEND = null;
    public static final RichMediaItemAction IMAGE_EDIT = null;
    public static final RichMediaItemAction SHARE = null;
    public static final RichMediaItemAction VIDEO_EDIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RichMediaItemAction[] f309590a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f309591b = null;

    public static EnumEntries<RichMediaItemAction> getEntries() {
        return f309591b;
    }

    static {
        RichMediaItemAction r100 = new RichMediaItemAction(HttpMethod.DOWNLOAD, 0);
        DOWNLOAD = r100;
        RichMediaItemAction r101 = new RichMediaItemAction("SHARE", 1);
        SHARE = r101;
        RichMediaItemAction r102 = new RichMediaItemAction("IMAGE_EDIT", 2);
        IMAGE_EDIT = r102;
        RichMediaItemAction r103 = new RichMediaItemAction("VIDEO_EDIT", 3);
        VIDEO_EDIT = r103;
        RichMediaItemAction r104 = new RichMediaItemAction("CITE", 4);
        CITE = r104;
        RichMediaItemAction r105 = new RichMediaItemAction("EXTEND", 5);
        EXTEND = r105;
        RichMediaItemAction[] r110 = {r100, r101, r102, r103, r104, r105};
        f309590a = r110;
        f309591b = EnumEntriesKt.enumEntries(r110);
    }

    public static RichMediaItemAction[] values() {
        return (RichMediaItemAction[]) f309590a.clone();
    }

    public static RichMediaItemAction valueOf(String r100) {
        return (RichMediaItemAction) a.a(RichMediaItemAction.class, r100);
    }

    public RichMediaItemAction(String r100, int r101) {
        super(r100, r101);
    }
}
