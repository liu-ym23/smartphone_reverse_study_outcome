package com.ss.android.lark.diskmanage;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/diskmanage/Biz;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "RUST", "MESSENGER", "PASSPORT", "CALENDAR", "DOCS", "VC", "MIN_APP", "MAIL", "SECURITY_AND_COMPLIANCE", "WEB_CONTAINER_DOWNLOAD", "VC_MINUTES", "WORKPLACE", "disk-manage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Biz extends Enum<Biz> {
    public static final Biz CALENDAR = null;
    public static final Biz DEFAULT = null;
    public static final Biz DOCS = null;
    public static final Biz MAIL = null;
    public static final Biz MESSENGER = null;
    public static final Biz MIN_APP = null;
    public static final Biz PASSPORT = null;
    public static final Biz RUST = null;
    public static final Biz SECURITY_AND_COMPLIANCE = null;
    public static final Biz VC = null;
    public static final Biz VC_MINUTES = null;
    public static final Biz WEB_CONTAINER_DOWNLOAD = null;
    public static final Biz WORKPLACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Biz[] f420449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420450b = null;
    private final String value;

    public static EnumEntries<Biz> getEntries() {
        return f420450b;
    }

    static {
        Biz r100 = new Biz("DEFAULT", 0, "default");
        DEFAULT = r100;
        Biz r101 = new Biz("RUST", 1, "rust");
        RUST = r101;
        Biz r102 = new Biz("MESSENGER", 2, "messenger");
        MESSENGER = r102;
        Biz r103 = new Biz("PASSPORT", 3, "passport");
        PASSPORT = r103;
        Biz r104 = new Biz("CALENDAR", 4, "calendar");
        CALENDAR = r104;
        Biz r105 = new Biz("DOCS", 5, "docs");
        DOCS = r105;
        Biz r110 = new Biz("VC", 6, ThumbGlideUrl.SOURCE_VC);
        VC = r110;
        Biz r111 = new Biz("MIN_APP", 7, "min_app");
        MIN_APP = r111;
        Biz r112 = new Biz("MAIL", 8, IOfflineExtraParser.ParserType.MAIL);
        MAIL = r112;
        Biz r113 = new Biz("SECURITY_AND_COMPLIANCE", 9, "security_and_compliance");
        SECURITY_AND_COMPLIANCE = r113;
        Biz r114 = new Biz("WEB_CONTAINER_DOWNLOAD", 10, "web_container_download");
        WEB_CONTAINER_DOWNLOAD = r114;
        Biz r106 = new Biz("VC_MINUTES", 11, "vc_minutes");
        VC_MINUTES = r106;
        Biz r107 = new Biz("WORKPLACE", 12, "workplace");
        WORKPLACE = r107;
        Biz[] r108 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
        f420449a = r108;
        f420450b = EnumEntriesKt.enumEntries(r108);
    }

    public static Biz[] values() {
        return (Biz[]) f420449a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static Biz valueOf(String r100) {
        return (Biz) a.a(Biz.class, r100);
    }

    public Biz(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
