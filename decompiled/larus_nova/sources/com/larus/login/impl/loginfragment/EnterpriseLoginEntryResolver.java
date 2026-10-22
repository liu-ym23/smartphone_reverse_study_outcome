package com.larus.login.impl.loginfragment;

import android.content.Context;
import com.larus.abtest.api.IAbTest;
import com.larus.account.base.provider.ILarkLoginProvider;
import com.larus.common.apphost.AppHost;
import com.larus.settings.provider.account.LarkAuthConfig;
import com.larus.settings.value.e10;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class EnterpriseLoginEntryResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnterpriseLoginEntryResolver f357924a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/login/impl/loginfragment/EnterpriseLoginEntryResolver$EnterpriseLoginCapability;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "NEED_INTRANET", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EnterpriseLoginCapability extends Enum<EnterpriseLoginCapability> {
        public static final EnterpriseLoginCapability DISABLED = null;
        public static final EnterpriseLoginCapability ENABLED = null;
        public static final EnterpriseLoginCapability NEED_INTRANET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnterpriseLoginCapability[] f357925a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f357926b = null;

        public static EnumEntries<EnterpriseLoginCapability> getEntries() {
            return f357926b;
        }

        static {
            EnterpriseLoginCapability r100 = new EnterpriseLoginCapability("ENABLED", 0);
            ENABLED = r100;
            EnterpriseLoginCapability r101 = new EnterpriseLoginCapability("DISABLED", 1);
            DISABLED = r101;
            EnterpriseLoginCapability r102 = new EnterpriseLoginCapability("NEED_INTRANET", 2);
            NEED_INTRANET = r102;
            EnterpriseLoginCapability[] r103 = {r100, r101, r102};
            f357925a = r103;
            f357926b = EnumEntriesKt.enumEntries(r103);
        }

        public static EnterpriseLoginCapability[] values() {
            return (EnterpriseLoginCapability[]) f357925a.clone();
        }

        public static EnterpriseLoginCapability valueOf(String r100) {
            return (EnterpriseLoginCapability) r27.a.a(EnterpriseLoginCapability.class, r100);
        }

        public EnterpriseLoginCapability(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/login/impl/loginfragment/EnterpriseLoginEntryResolver$Placement;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "BOTTOM", "PANEL_TAIL", "PANEL_HEAD", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Placement extends Enum<Placement> {
        public static final Placement BOTTOM = null;
        public static final Placement HIDDEN = null;
        public static final Placement PANEL_HEAD = null;
        public static final Placement PANEL_TAIL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Placement[] f357927a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f357928b = null;

        public static EnumEntries<Placement> getEntries() {
            return f357928b;
        }

        static {
            Placement r100 = new Placement("HIDDEN", 0);
            HIDDEN = r100;
            Placement r101 = new Placement("BOTTOM", 1);
            BOTTOM = r101;
            Placement r102 = new Placement("PANEL_TAIL", 2);
            PANEL_TAIL = r102;
            Placement r103 = new Placement("PANEL_HEAD", 3);
            PANEL_HEAD = r103;
            Placement[] r104 = {r100, r101, r102, r103};
            f357927a = r104;
            f357928b = EnumEntriesKt.enumEntries(r104);
        }

        public static Placement[] values() {
            return (Placement[]) f357927a.clone();
        }

        public static Placement valueOf(String r100) {
            return (Placement) r27.a.a(Placement.class, r100);
        }

        public Placement(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Placement f357929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f357930b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f357929a == r101.f357929a) goto L12;
            return false;
        L12:
            if (this.f357930b == r101.f357930b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f357929a.hashCode() * 31;
            if (this.f357930b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ResolveResult(placement=" + this.f357929a + ", shouldPreheatCapability=" + this.f357930b + ')';
        }

        public a(Placement r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "placement");
            this.f357929a = r100;
            this.f357930b = r101;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f357931a = null;

        static {
            int[] r100 = new int[EnterpriseLoginCapability.values().length];
            r100[EnterpriseLoginCapability.ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[EnterpriseLoginCapability.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[EnterpriseLoginCapability.NEED_INTRANET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f357931a = r100;
        }
    }

    static {
        f357924a = new EnterpriseLoginEntryResolver();
    }

    public EnterpriseLoginEntryResolver() {
    }

    public static boolean a(String r100) {
        EnterpriseLoginCapability r101 = c(r100);
        int r102 = b.f357931a[r101.ordinal()];
        if (r102 != 1) goto L5;
        return true;
    L5:
        if (r102 != 2) goto L7;
        return false;
    L7:
        if (r102 != 3) goto L10;
        boolean r103 = lm9.b.f509897a;
        return lm9.b.f509897a;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static EnterpriseLoginCapability c(String r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        if (r101.isOversea() == true) goto L5;
        if (r100 != null) goto L8;
        e10 r102 = e10.f368561a;
        LarkAuthConfig r103 = e10.Z();
        if (r103.getEnableEnterpriseLogin() == false) goto L14;
        return EnterpriseLoginCapability.ENABLED;
    L14:
        if (r103.getEnableEnterpriseLoginForIntranet() == true) goto L18;
        return EnterpriseLoginCapability.DISABLED;
    L18:
        if (r101.isTestChannel() == true) goto L25;
        if (Intrinsics.areEqual(r101.getBuildChannel(), "inhouse") == true) goto L25;
        return EnterpriseLoginCapability.NEED_INTRANET;
    L25:
        return EnterpriseLoginCapability.ENABLED;
    L8:
        return EnterpriseLoginCapability.DISABLED;
    L5:
        return EnterpriseLoginCapability.DISABLED;
    }

    public static boolean d(String r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        if (r101.isOversea() == true) goto L17;
        if (r100 != null) goto L17;
        e10 r102 = e10.f368561a;
        LarkAuthConfig r103 = e10.Z();
        if (r103.getEnableEnterpriseLogin() == true) goto L17;
        if (r103.getEnableEnterpriseLoginForIntranet() == false) goto L17;
        if (r101.isTestChannel() == true) goto L17;
        if (Intrinsics.areEqual(r101.getBuildChannel(), "inhouse") == true) goto L17;
        boolean r104 = lm9.b.f509897a;
        if (lm9.b.f509897a == true) goto L17;
        return true;
    L17:
        return false;
    }

    public final Object b(Context r100, String r110, Continuation<? super a> r111) {
        if ((r111 instanceof EnterpriseLoginEntryResolver$resolve$1) == false) goto L7;
        EnterpriseLoginEntryResolver$resolve$1 r101 = (EnterpriseLoginEntryResolver$resolve$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r112);
    L57:
        if (((Boolean) r112).booleanValue() == false) goto L60;
        return new a(Placement.BOTTOM, false);
    L60:
        return new a(Placement.HIDDEN, false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        if (AppHost.f326268a.isOversea() == true) goto L62;
        if (r110 != null) goto L62;
        if (r100 == null) goto L27;
        ILarkLoginProvider r113 = (ILarkLoginProvider) ServiceManager.get().getService(ILarkLoginProvider.class);
        if (r113 != null) goto L22;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == false) goto L27;
        boolean r107 = true;
    L29:
        if (r107 == false) goto L34;
        int r108 = ((Number) IAbTest.f286085a.r("enterprise_login_entry_mode", Integer.TYPE, 1)).intValue();
        if (r108 == 1) goto L36;
        if (r108 != 2) goto L34;
        Placement r109 = Placement.PANEL_HEAD;
    L37:
        if (r109 != null) goto L39;
        r101.label = 1;
        int r114 = b.f357931a[c(r110).ordinal()];
        if (r114 == 1) goto L52;
        if (r114 != 2) goto L47;
        r105 = false;
        goto L52
    L47:
        if (r114 != 3) goto L50;
        Object r115 = BuildersKt.withContext(Dispatchers.getIO(), new EnterpriseLoginEntryResolver$canShowEnterpriseLoginAfterPing$2(null), r101);
    L53:
        r112 = r115;
        if (r112 != r103) goto L57;
        return r103;
    L50:
        throw new NoWhenBranchMatchedException();
    L52:
        r115 = Boxing.boxBoolean(r105);
        goto L53
    L39:
        if (a(r110) == false) goto L42;
        return new a(r109, false);
    L42:
        return new a(Placement.HIDDEN, d(r110));
    L36:
        r109 = Placement.PANEL_TAIL;
    L34:
        r109 = null;
        goto L37
    L22:
        if (r113.e(r100) != true) goto L24;
        r106 = true;
    L27:
        r107 = false;
    L62:
        return new a(Placement.HIDDEN, false);
    L7:
        r101 = new EnterpriseLoginEntryResolver$resolve$1(this, r111);
        goto L8
    }
}
