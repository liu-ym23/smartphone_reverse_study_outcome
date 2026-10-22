package com.bytedance.ee.bear.middleground.permission.export.permsdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/export/permsdk/model/BizDomain;", "", "biz", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBiz", "()Ljava/lang/String;", "FileBizDomainCCM", "FileBizDomainIM", "FileBizDomainMAIL", "FileBizDomainVC", "FileBizDomainCALENDAR", "FileBizDomainTODO", "FileBizDomainOPENPLATFORM", "toFileBizDomain", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BizDomain extends Enum<BizDomain> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BizDomain[] $VALUES = null;

    @SerializedName("Calendar")
    public static final BizDomain FileBizDomainCALENDAR = null;

    @SerializedName("CCM")
    public static final BizDomain FileBizDomainCCM = null;

    @SerializedName("IM")
    public static final BizDomain FileBizDomainIM = null;

    @SerializedName("Mail")
    public static final BizDomain FileBizDomainMAIL = null;

    @SerializedName("OpenPlatform")
    public static final BizDomain FileBizDomainOPENPLATFORM = null;

    @SerializedName("TODO")
    public static final BizDomain FileBizDomainTODO = null;

    @SerializedName("VC")
    public static final BizDomain FileBizDomainVC = null;
    private final String biz;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BizDomain.values().length];
            r0[BizDomain.FileBizDomainCCM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[BizDomain.FileBizDomainIM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[BizDomain.FileBizDomainMAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[BizDomain.FileBizDomainCALENDAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[BizDomain.FileBizDomainTODO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    private static final /* synthetic */ BizDomain[] $values() {
        return new BizDomain[]{FileBizDomainCCM, FileBizDomainIM, FileBizDomainMAIL, FileBizDomainVC, FileBizDomainCALENDAR, FileBizDomainTODO, FileBizDomainOPENPLATFORM};
    }

    public static EnumEntries<BizDomain> getEntries() {
        return $ENTRIES;
    }

    static {
        FileBizDomainCCM = new BizDomain("FileBizDomainCCM", 0, "CCM");
        FileBizDomainIM = new BizDomain("FileBizDomainIM", 1, "IM");
        FileBizDomainMAIL = new BizDomain("FileBizDomainMAIL", 2, "Mail");
        FileBizDomainVC = new BizDomain("FileBizDomainVC", 3, "VC");
        FileBizDomainCALENDAR = new BizDomain("FileBizDomainCALENDAR", 4, "Calendar");
        FileBizDomainTODO = new BizDomain("FileBizDomainTODO", 5, "TODO");
        FileBizDomainOPENPLATFORM = new BizDomain("FileBizDomainOPENPLATFORM", 6, "OpenPlatform");
        BizDomain[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static BizDomain[] values() {
        return (BizDomain[]) $VALUES.clone();
    }

    public final FileBizDomain toFileBizDomain() {
        int r0 = a.a[ordinal()];
        if (r0 == 1) goto L18;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L22;
        if (r0 == 4) goto L21;
        if (r0 == 5) goto L20;
        return FileBizDomain.FileBizDomainUNKNOWN;
    L20:
        return FileBizDomain.FileBizDomainTODO;
    L21:
        return FileBizDomain.FileBizDomainCALENDAR;
    L22:
        return FileBizDomain.FileBizDomainMAIL;
    L23:
        return FileBizDomain.FileBizDomainIM;
    L18:
        return FileBizDomain.FileBizDomainCCM;
    }

    public final String getBiz() {
        return this.biz;
    }

    public static BizDomain valueOf(String r1) {
        return (BizDomain) r27.a.a(BizDomain.class, r1);
    }

    private BizDomain(String r1, int r2, String r3) {
        super(r1, r2);
        this.biz = r3;
    }
}
