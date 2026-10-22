package com.larus.bmhome.chat.block.base.config;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/block/base/config/RichMediaCreationVideoButtonAction;", "", "<init>", "(Ljava/lang/String;I)V", HttpMethod.DOWNLOAD, "CITE", "EXTEND", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RichMediaCreationVideoButtonAction extends Enum<RichMediaCreationVideoButtonAction> {
    public static final RichMediaCreationVideoButtonAction CITE = null;
    public static final RichMediaCreationVideoButtonAction DOWNLOAD = null;
    public static final RichMediaCreationVideoButtonAction EXTEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RichMediaCreationVideoButtonAction[] f297456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297457b = null;

    public static EnumEntries<RichMediaCreationVideoButtonAction> getEntries() {
        return f297457b;
    }

    static {
        RichMediaCreationVideoButtonAction r100 = new RichMediaCreationVideoButtonAction(HttpMethod.DOWNLOAD, 0);
        DOWNLOAD = r100;
        RichMediaCreationVideoButtonAction r101 = new RichMediaCreationVideoButtonAction("CITE", 1);
        CITE = r101;
        RichMediaCreationVideoButtonAction r102 = new RichMediaCreationVideoButtonAction("EXTEND", 2);
        EXTEND = r102;
        RichMediaCreationVideoButtonAction[] r103 = {r100, r101, r102};
        f297456a = r103;
        f297457b = EnumEntriesKt.enumEntries(r103);
    }

    public static RichMediaCreationVideoButtonAction[] values() {
        return (RichMediaCreationVideoButtonAction[]) f297456a.clone();
    }

    public static RichMediaCreationVideoButtonAction valueOf(String r100) {
        return (RichMediaCreationVideoButtonAction) a.a(RichMediaCreationVideoButtonAction.class, r100);
    }

    public RichMediaCreationVideoButtonAction(String r100, int r101) {
        super(r100, r101);
    }
}
