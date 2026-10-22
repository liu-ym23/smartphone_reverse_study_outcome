package com.bytedance.ee.bear.more.office;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/more/office/OfficeLongPressLarkAction;", "", "<init>", "(Ljava/lang/String;I)V", "MOVE_TO", "ADD_SHORTCUT", "SECRET_SETTING", HttpMethod.DOWNLOAD, "EXPORT_AS", "RENAME", "MAKE_COPY", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLongPressLarkAction extends Enum<OfficeLongPressLarkAction> {
    public static final OfficeLongPressLarkAction ADD_SHORTCUT = null;
    public static final OfficeLongPressLarkAction DOWNLOAD = null;
    public static final OfficeLongPressLarkAction EXPORT_AS = null;
    public static final OfficeLongPressLarkAction MAKE_COPY = null;
    public static final OfficeLongPressLarkAction MOVE_TO = null;
    public static final OfficeLongPressLarkAction RENAME = null;
    public static final OfficeLongPressLarkAction SECRET_SETTING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeLongPressLarkAction[] f234680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f234681b = null;

    public static EnumEntries<OfficeLongPressLarkAction> getEntries() {
        return f234681b;
    }

    static {
        OfficeLongPressLarkAction r100 = new OfficeLongPressLarkAction("MOVE_TO", 0);
        MOVE_TO = r100;
        OfficeLongPressLarkAction r101 = new OfficeLongPressLarkAction("ADD_SHORTCUT", 1);
        ADD_SHORTCUT = r101;
        OfficeLongPressLarkAction r102 = new OfficeLongPressLarkAction("SECRET_SETTING", 2);
        SECRET_SETTING = r102;
        OfficeLongPressLarkAction r103 = new OfficeLongPressLarkAction(HttpMethod.DOWNLOAD, 3);
        DOWNLOAD = r103;
        OfficeLongPressLarkAction r104 = new OfficeLongPressLarkAction("EXPORT_AS", 4);
        EXPORT_AS = r104;
        OfficeLongPressLarkAction r105 = new OfficeLongPressLarkAction("RENAME", 5);
        RENAME = r105;
        OfficeLongPressLarkAction r110 = new OfficeLongPressLarkAction("MAKE_COPY", 6);
        MAKE_COPY = r110;
        OfficeLongPressLarkAction[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f234680a = r111;
        f234681b = EnumEntriesKt.enumEntries(r111);
    }

    public static OfficeLongPressLarkAction[] values() {
        return (OfficeLongPressLarkAction[]) f234680a.clone();
    }

    public static OfficeLongPressLarkAction valueOf(String r100) {
        return (OfficeLongPressLarkAction) r27.a.a(OfficeLongPressLarkAction.class, r100);
    }

    public OfficeLongPressLarkAction(String r100, int r101) {
        super(r100, r101);
    }
}
