package com.ss.android.lark.forsetiutils;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.biz.im.api.extension.message.TaskType;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forsetiutils/BizType;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "VC", "CCM", "MAIL", "OPEN_PLATFORM", "SECURITY", "CALENDAR", "PASSPORT", "BASE", "SEARCH", "IM", "MIN_APP", "MEEGO", "WORKPLACE", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BizType extends Enum<BizType> {
    public static final BizType BASE = null;
    public static final BizType CALENDAR = null;
    public static final BizType CCM = null;
    public static final BizType IM = null;
    public static final BizType MAIL = null;
    public static final BizType MEEGO = null;
    public static final BizType MIN_APP = null;
    public static final BizType OPEN_PLATFORM = null;
    public static final BizType PASSPORT = null;
    public static final BizType SEARCH = null;
    public static final BizType SECURITY = null;
    public static final BizType VC = null;
    public static final BizType WORKPLACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BizType[] f424747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f424748b = null;
    private final String key;

    public static EnumEntries<BizType> getEntries() {
        return f424748b;
    }

    static {
        BizType r100 = new BizType("VC", 0, ThumbGlideUrl.SOURCE_VC);
        VC = r100;
        BizType r101 = new BizType("CCM", 1, ChameleonResConstants.CCM_ROOT_DIR);
        CCM = r101;
        BizType r102 = new BizType("MAIL", 2, IOfflineExtraParser.ParserType.MAIL);
        MAIL = r102;
        BizType r103 = new BizType("OPEN_PLATFORM", 3, "open_platform");
        OPEN_PLATFORM = r103;
        BizType r104 = new BizType("SECURITY", 4, AppConstants.API_HOST_SI_PREFIX);
        SECURITY = r104;
        BizType r105 = new BizType("CALENDAR", 5, "calendar");
        CALENDAR = r105;
        BizType r110 = new BizType("PASSPORT", 6, "passport");
        PASSPORT = r110;
        BizType r111 = new BizType("BASE", 7, "base");
        BASE = r111;
        BizType r112 = new BizType("SEARCH", 8, "search");
        SEARCH = r112;
        BizType r113 = new BizType("IM", 9, "im");
        IM = r113;
        BizType r114 = new BizType("MIN_APP", 10, "min_app");
        MIN_APP = r114;
        BizType r106 = new BizType("MEEGO", 11, TaskType.MEEGO_TASK);
        MEEGO = r106;
        BizType r107 = new BizType("WORKPLACE", 12, "workplace");
        WORKPLACE = r107;
        BizType[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
        f424747a = r108;
        f424748b = EnumEntriesKt.enumEntries(r108);
    }

    public static BizType[] values() {
        return (BizType[]) f424747a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static BizType valueOf(String r100) {
        return (BizType) r27.a.a(BizType.class, r100);
    }

    public BizType(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
