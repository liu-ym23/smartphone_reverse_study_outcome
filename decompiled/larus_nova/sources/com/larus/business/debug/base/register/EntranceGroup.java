package com.larus.business.debug.base.register;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/larus/business/debug/base/register/EntranceGroup;", "", "des", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDes", "()Ljava/lang/String;", "PMO", "BASE", "LARK_SOCIAL", "OFFICE_SDK", "APPS_FRAMEWORK", "NETWORK", "AUDIO", ServiceType.DORA, "IM", "ACCOUNT", "SECURITY", "HYBRID", "ONE_PARTY", "AI_CREATION", "MOA_OFFICE", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "COMMERCE", "ARCH", "ECOMMERCE", "LIVE", "COT", "OBRIC_COMMON", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntranceGroup extends Enum<EntranceGroup> {
    public static final EntranceGroup ACCOUNT = null;
    public static final EntranceGroup AI_CREATION = null;
    public static final EntranceGroup APPS_FRAMEWORK = null;
    public static final EntranceGroup ARCH = null;
    public static final EntranceGroup AUDIO = null;
    public static final EntranceGroup BASE = null;
    public static final EntranceGroup COMMERCE = null;
    public static final EntranceGroup COT = null;
    public static final EntranceGroup DOC = null;
    public static final EntranceGroup DORA = null;
    public static final EntranceGroup ECOMMERCE = null;
    public static final EntranceGroup HYBRID = null;
    public static final EntranceGroup IM = null;
    public static final EntranceGroup LARK_SOCIAL = null;
    public static final EntranceGroup LIVE = null;
    public static final EntranceGroup MOA_OFFICE = null;
    public static final EntranceGroup NETWORK = null;
    public static final EntranceGroup OBRIC_COMMON = null;
    public static final EntranceGroup OFFICE_SDK = null;
    public static final EntranceGroup ONE_PARTY = null;
    public static final EntranceGroup PMO = null;
    public static final EntranceGroup SECURITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EntranceGroup[] f320064a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f320065b = null;
    private final String des;

    public static EnumEntries<EntranceGroup> getEntries() {
        return f320065b;
    }

    static {
        EntranceGroup r100 = new EntranceGroup("PMO", 0, "验收反馈");
        PMO = r100;
        EntranceGroup r101 = new EntranceGroup("BASE", 1, "基础工具");
        BASE = r101;
        EntranceGroup r102 = new EntranceGroup("LARK_SOCIAL", 2, "真人聊天");
        LARK_SOCIAL = r102;
        EntranceGroup r103 = new EntranceGroup("OFFICE_SDK", 3, "OfficeSDK");
        OFFICE_SDK = r103;
        EntranceGroup r104 = new EntranceGroup("APPS_FRAMEWORK", 4, "小程序");
        APPS_FRAMEWORK = r104;
        EntranceGroup r105 = new EntranceGroup("NETWORK", 5, "网络");
        NETWORK = r105;
        EntranceGroup r110 = new EntranceGroup("AUDIO", 6, ServiceType.AUDIO);
        AUDIO = r110;
        EntranceGroup r111 = new EntranceGroup(ServiceType.DORA, 7, DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME);
        DORA = r111;
        EntranceGroup r112 = new EntranceGroup("IM", 8, "IM");
        IM = r112;
        EntranceGroup r113 = new EntranceGroup("ACCOUNT", 9, "登录与账号");
        ACCOUNT = r113;
        EntranceGroup r114 = new EntranceGroup("SECURITY", 10, "安全");
        SECURITY = r114;
        EntranceGroup r106 = new EntranceGroup("HYBRID", 11, "跨端");
        HYBRID = r106;
        EntranceGroup r107 = new EntranceGroup("ONE_PARTY", 12, "一方功能");
        ONE_PARTY = r107;
        EntranceGroup r108 = new EntranceGroup("AI_CREATION", 13, "AI创作");
        AI_CREATION = r108;
        EntranceGroup r109 = new EntranceGroup("MOA_OFFICE", 14, "moa办公模式");
        MOA_OFFICE = r109;
        EntranceGroup r115 = new EntranceGroup(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 15, "豆包文档");
        DOC = r115;
        EntranceGroup r116 = new EntranceGroup("COMMERCE", 16, "商业化积分/会员");
        COMMERCE = r116;
        EntranceGroup r117 = new EntranceGroup("ARCH", 17, "架构调试");
        ARCH = r117;
        EntranceGroup r118 = new EntranceGroup("ECOMMERCE", 18, "电商功能");
        ECOMMERCE = r118;
        EntranceGroup r119 = new EntranceGroup("LIVE", 19, "直播功能");
        LIVE = r119;
        EntranceGroup r120 = new EntranceGroup("COT", 20, "Cot详情页");
        COT = r120;
        EntranceGroup r121 = new EntranceGroup("OBRIC_COMMON", 21, "O Common");
        OBRIC_COMMON = r121;
        EntranceGroup[] r122 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121};
        f320064a = r122;
        f320065b = EnumEntriesKt.enumEntries(r122);
    }

    public static EntranceGroup[] values() {
        return (EntranceGroup[]) f320064a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public static EntranceGroup valueOf(String r100) {
        return (EntranceGroup) a.a(EntranceGroup.class, r100);
    }

    public EntranceGroup(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }

    public /* synthetic */ EntranceGroup(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102);
    }
}
