package com.bytedance.ee.bear.unbundle;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001aB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/unbundle/BenefitStore;", "Lcom/bytedance/ee/util/io/NonProguard;", "ownerId", "", "benefitMap", "", "Lcom/bytedance/ee/bear/unbundle/BenefitStore$BenefitUIStatus;", "sourceBenefit", "from", "isFreeSuite", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Z)V", "getOwnerId", "()Ljava/lang/String;", "setOwnerId", "(Ljava/lang/String;)V", "getBenefitMap", "()Ljava/util/Map;", "getSourceBenefit", "getFrom", "()Z", "hasBenefit", "key", "Companion", "BenefitUIStatus", "UIStatus", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BenefitStore implements NonProguard {
    public static final b Companion = null;
    public static final String FROM_CACHE = "cache";
    public static final String FROM_MOCK = "mock";
    public static final String FROM_SERVER = "server";
    public static final String FROM_SETTINGS = "settings";
    private final Map<String, a> benefitMap;
    private final String from;
    private final boolean isFreeSuite;
    private String ownerId;
    private final String sourceBenefit;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/unbundle/BenefitStore$UIStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLE", "DISABLE", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UIStatus extends Enum<UIStatus> {
        public static final UIStatus DISABLE = null;
        public static final UIStatus ENABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UIStatus[] f239803a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f239804b = null;

        public static EnumEntries<UIStatus> getEntries() {
            return f239804b;
        }

        static {
            UIStatus r100 = new UIStatus("ENABLE", 0);
            ENABLE = r100;
            UIStatus r101 = new UIStatus("DISABLE", 1);
            DISABLE = r101;
            UIStatus[] r102 = {r100, r101};
            f239803a = r102;
            f239804b = EnumEntriesKt.enumEntries(r102);
        }

        public static UIStatus[] values() {
            return (UIStatus[]) f239803a.clone();
        }

        public static UIStatus valueOf(String r100) {
            return (UIStatus) r27.a.a(UIStatus.class, r100);
        }

        public UIStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UIStatus f239805a;

        public a(UIStatus r100) {
            Intrinsics.checkNotNullParameter(r100, "uiStatus");
            Intrinsics.checkNotNullParameter("", "reason");
            this.f239805a = r100;
        }
    }

    public static final class b {
        public b() {
        }

        public static BenefitStore a(String r100, String r101, String r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r100, "ownerId");
            Intrinsics.checkNotNullParameter(r101, "sourceBenefit");
            Intrinsics.checkNotNullParameter(r110, "from");
            LinkedHashMap r102 = new LinkedHashMap();
            JSONObject r103 = new JSONObject(r101);
            Iterator<String> r104 = r103.keys();
        L4:
            if (r104.hasNext() == false) goto L14;
            JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r103, r104.next());
            Iterator<String> r106 = r105.keys();
        L7:
            if (r106.hasNext() == false) goto L4;
            String r107 = r106.next();
            if (TextUtils.equals("enabled", JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r105, r107), "status")) == false) goto L11;
            a r108 = new a(UIStatus.ENABLE);
        L12:
            r102.put(r107, r108);
            goto L7
        L11:
            r108 = new a(UIStatus.DISABLE);
            goto L12
        L14:
            return new BenefitStore(r100, r102, r101, r110, r111);
        }

        public static /* synthetic */ BenefitStore b(b r100, String r101, String r102, String r103) {
            r100.getClass();
            return a(r101, r102, r103, true);
        }
    }

    static {
        Companion = new b();
    }

    public final Map<String, a> getBenefitMap() {
        return this.benefitMap;
    }

    public final String getFrom() {
        return this.from;
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final String getSourceBenefit() {
        return this.sourceBenefit;
    }

    public final boolean isFreeSuite() {
        return this.isFreeSuite;
    }

    public final boolean hasBenefit(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a r101 = this.benefitMap.get(r100);
        if (r101 == null) goto L12;
        UIStatus r102 = r101.f239805a;
        if (r102 != null) goto L8;
        return true;
    L8:
        if (r102 == UIStatus.ENABLE) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    public final void setOwnerId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownerId = r100;
    }

    public BenefitStore(String r100, Map<String, a> r101, String r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        Intrinsics.checkNotNullParameter(r101, "benefitMap");
        Intrinsics.checkNotNullParameter(r102, "sourceBenefit");
        Intrinsics.checkNotNullParameter(r103, "from");
        this.ownerId = r100;
        this.benefitMap = r101;
        this.sourceBenefit = r102;
        this.from = r103;
        this.isFreeSuite = r104;
    }

    public /* synthetic */ BenefitStore(String r100, Map r101, String r102, String r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        r110 = FROM_MOCK;
    L5:
        String r103 = r110;
        if ((r112 & 16) == 0) goto L8;
        boolean r104 = true;
    L9:
        this(r100, r101, r102, r103, r104);
        return;
    L8:
        r104 = r111;
        goto L9
    }
}
