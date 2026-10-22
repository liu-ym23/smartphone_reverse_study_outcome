package com.larus.bmhome.chat.block.base.config;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationImageButtonAction;", "", "<init>", "(Ljava/lang/String;I)V", HttpMethod.DOWNLOAD, "SHARE", "IMAGE_EDIT", "VIDEO_EDIT", "CITE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RichMediaCreationImageButtonAction extends Enum<RichMediaCreationImageButtonAction> {
    public static final RichMediaCreationImageButtonAction CITE = null;
    public static final RichMediaCreationImageButtonAction DOWNLOAD = null;
    public static final RichMediaCreationImageButtonAction IMAGE_EDIT = null;
    public static final RichMediaCreationImageButtonAction SHARE = null;
    public static final RichMediaCreationImageButtonAction VIDEO_EDIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RichMediaCreationImageButtonAction[] f297454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297455b = null;

    public static EnumEntries<RichMediaCreationImageButtonAction> getEntries() {
        return f297455b;
    }

    static {
        RichMediaCreationImageButtonAction r100 = new RichMediaCreationImageButtonAction(HttpMethod.DOWNLOAD, 0);
        DOWNLOAD = r100;
        RichMediaCreationImageButtonAction r101 = new RichMediaCreationImageButtonAction("SHARE", 1);
        SHARE = r101;
        RichMediaCreationImageButtonAction r102 = new RichMediaCreationImageButtonAction("IMAGE_EDIT", 2);
        IMAGE_EDIT = r102;
        RichMediaCreationImageButtonAction r103 = new RichMediaCreationImageButtonAction("VIDEO_EDIT", 3);
        VIDEO_EDIT = r103;
        RichMediaCreationImageButtonAction r104 = new RichMediaCreationImageButtonAction("CITE", 4);
        CITE = r104;
        RichMediaCreationImageButtonAction[] r105 = {r100, r101, r102, r103, r104};
        f297454a = r105;
        f297455b = EnumEntriesKt.enumEntries(r105);
    }

    public static RichMediaCreationImageButtonAction[] values() {
        return (RichMediaCreationImageButtonAction[]) f297454a.clone();
    }

    public static RichMediaCreationImageButtonAction valueOf(String r100) {
        return (RichMediaCreationImageButtonAction) a.a(RichMediaCreationImageButtonAction.class, r100);
    }

    public RichMediaCreationImageButtonAction(String r100, int r101) {
        super(r100, r101);
    }
}
