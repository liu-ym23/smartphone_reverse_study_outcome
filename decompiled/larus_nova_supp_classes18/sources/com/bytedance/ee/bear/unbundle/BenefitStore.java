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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        public static final /* synthetic */ UIStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<UIStatus> getEntries() {
            return b;
        }

        static {
            UIStatus r0 = new UIStatus("ENABLE", 0);
            ENABLE = r0;
            UIStatus r1 = new UIStatus("DISABLE", 1);
            DISABLE = r1;
            UIStatus[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static UIStatus[] values() {
            return (UIStatus[]) a.clone();
        }

        public static UIStatus valueOf(String r1) {
            return (UIStatus) r27.a.a(UIStatus.class, r1);
        }

        public UIStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final UIStatus a;

        public a(UIStatus r3) {
            Intrinsics.checkNotNullParameter(r3, "uiStatus");
            Intrinsics.checkNotNullParameter("", "reason");
            this.a = r3;
        }
    }

    public static final class b {
        public b() {
        }

        public static BenefitStore a(String r8, String r9, String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r8, "ownerId");
            Intrinsics.checkNotNullParameter(r9, "sourceBenefit");
            Intrinsics.checkNotNullParameter(r10, "from");
            LinkedHashMap r3 = new LinkedHashMap();
            JSONObject r0 = new JSONObject(r9);
            Iterator<String> r1 = r0.keys();
        L4:
            if (r1.hasNext() == false) goto L14;
            JSONObject r2 = JSONObjectProtectorUtils.getJSONObject(r0, r1.next());
            Iterator<String> r4 = r2.keys();
        L7:
            if (r4.hasNext() == false) goto L4;
            String r5 = r4.next();
            if (TextUtils.equals("enabled", JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r2, r5), "status")) == false) goto L11;
            a r6 = new a(UIStatus.ENABLE);
        L12:
            r3.put(r5, r6);
            goto L7
        L11:
            r6 = new a(UIStatus.DISABLE);
            goto L12
        L14:
            return new BenefitStore(r8, r3, r9, r10, r11);
        }

        public static /* synthetic */ BenefitStore b(b r0, String r1, String r2, String r3) {
            r0.getClass();
            return a(r1, r2, r3, true);
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

    public final boolean hasBenefit(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        a r4 = this.benefitMap.get(r3);
        if (r4 == null) goto L12;
        UIStatus r5 = r4.a;
        if (r5 != null) goto L8;
        return true;
    L8:
        if (r5 == UIStatus.ENABLE) goto L14;
        return false;
    L14:
        return true;
    L12:
        return true;
    }

    public final void setOwnerId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ownerId = r2;
    }

    public BenefitStore(String r2, Map<String, a> r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "ownerId");
        Intrinsics.checkNotNullParameter(r3, "benefitMap");
        Intrinsics.checkNotNullParameter(r4, "sourceBenefit");
        Intrinsics.checkNotNullParameter(r5, "from");
        this.ownerId = r2;
        this.benefitMap = r3;
        this.sourceBenefit = r4;
        this.from = r5;
        this.isFreeSuite = r6;
    }

    public /* synthetic */ BenefitStore(String r7, Map r8, String r9, String r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = FROM_MOCK;
    L5:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        boolean r5 = true;
    L9:
        this(r7, r8, r9, r4, r5);
        return;
    L8:
        r5 = r11;
        goto L9
    }
}
