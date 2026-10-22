package com.larus.chat.gallery.api;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewSourceAction;", "", "<init>", "(Ljava/lang/String;I)V", "SHARE", HttpMethod.DOWNLOAD, "RENAME", "MOVE", "DELETE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewSourceAction extends Enum<PreviewSourceAction> {
    public static final PreviewSourceAction DELETE = null;
    public static final PreviewSourceAction DOWNLOAD = null;
    public static final PreviewSourceAction MOVE = null;
    public static final PreviewSourceAction RENAME = null;
    public static final PreviewSourceAction SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewSourceAction[] f324120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324121b = null;

    public static EnumEntries<PreviewSourceAction> getEntries() {
        return f324121b;
    }

    static {
        PreviewSourceAction r100 = new PreviewSourceAction("SHARE", 0);
        SHARE = r100;
        PreviewSourceAction r101 = new PreviewSourceAction(HttpMethod.DOWNLOAD, 1);
        DOWNLOAD = r101;
        PreviewSourceAction r102 = new PreviewSourceAction("RENAME", 2);
        RENAME = r102;
        PreviewSourceAction r103 = new PreviewSourceAction("MOVE", 3);
        MOVE = r103;
        PreviewSourceAction r104 = new PreviewSourceAction("DELETE", 4);
        DELETE = r104;
        PreviewSourceAction[] r105 = {r100, r101, r102, r103, r104};
        f324120a = r105;
        f324121b = EnumEntriesKt.enumEntries(r105);
    }

    public static PreviewSourceAction[] values() {
        return (PreviewSourceAction[]) f324120a.clone();
    }

    public static PreviewSourceAction valueOf(String r100) {
        return (PreviewSourceAction) r27.a.a(PreviewSourceAction.class, r100);
    }

    public PreviewSourceAction(String r100, int r101) {
        super(r100, r101);
    }
}
