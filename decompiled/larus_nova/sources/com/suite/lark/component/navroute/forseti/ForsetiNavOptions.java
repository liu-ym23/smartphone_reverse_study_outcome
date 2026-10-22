package com.suite.lark.component.navroute.forseti;

import android.graphics.Rect;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.suite.lark.component.navroute.api.NavRouteNavigator;
import com.suite.lark.component.navroute.forseti.fragment.ForsetiFragmentExtras;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class ForsetiNavOptions extends com.suite.lark.component.navroute.api.g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f460315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DestinationStyle f460316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ForsetiNavigator.ForsetiNavExtras f460317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f460318j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f460319k;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/suite/lark/component/navroute/forseti/ForsetiNavOptions$DestinationStyle;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "FLOAT", "HALF_FLOAT", "FULL_SCREEN", "isFloat", "", "router-forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DestinationStyle extends Enum<DestinationStyle> {
        public static final DestinationStyle FLOAT = null;
        public static final DestinationStyle FULL_SCREEN = null;
        public static final DestinationStyle HALF_FLOAT = null;
        public static final DestinationStyle NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DestinationStyle[] f460320a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f460321b = null;

        public static EnumEntries<DestinationStyle> getEntries() {
            return f460321b;
        }

        static {
            DestinationStyle r100 = new DestinationStyle(EffectConstants.NORMAL, 0);
            NORMAL = r100;
            DestinationStyle r101 = new DestinationStyle("FLOAT", 1);
            FLOAT = r101;
            DestinationStyle r102 = new DestinationStyle("HALF_FLOAT", 2);
            HALF_FLOAT = r102;
            DestinationStyle r103 = new DestinationStyle("FULL_SCREEN", 3);
            FULL_SCREEN = r103;
            DestinationStyle[] r104 = {r100, r101, r102, r103};
            f460320a = r104;
            f460321b = EnumEntriesKt.enumEntries(r104);
        }

        public static DestinationStyle[] values() {
            return (DestinationStyle[]) f460320a.clone();
        }

        public final boolean isFloat() {
            if (this != FLOAT) goto L5;
        L8:
            return true;
        L5:
            if (this == HALF_FLOAT) goto L8;
            return false;
        }

        public static DestinationStyle valueOf(String r100) {
            return (DestinationStyle) r27.a.a(DestinationStyle.class, r100);
        }

        public DestinationStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f460322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f460323b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f460324c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f460325d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DestinationStyle f460326e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.suite.lark.component.navroute.api.g.a f460327f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f460328g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ForsetiNavigator.ForsetiNavExtras f460329h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f460330i;

        public final ForsetiNavOptions a() {
            boolean r100 = this.f460322a;
            String r101 = this.f460323b;
            boolean r102 = this.f460324c;
            int r103 = this.f460325d;
            DestinationStyle r104 = this.f460326e;
            return new ForsetiNavOptions(r100, r101, r102, this.f460327f, r103, r104, this.f460329h, this.f460328g, this.f460330i);
        }

        public a() {
            this.f460325d = -1;
            this.f460326e = DestinationStyle.NORMAL;
            this.f460328g = true;
        }

        public final void c(DestinationStyle r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f460326e = r100;
        }

        public final void b(Rect r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "visibleRect");
            this.f460326e = DestinationStyle.FLOAT;
            ForsetiFragmentExtras.a r102 = new ForsetiFragmentExtras.a();
            vua.a r103 = new vua.a(r100, -1, r101, true);
            r102.f460342d = r103;
            this.f460329h = new ForsetiFragmentExtras(r103, r102.f460249a, r102.f460250b, r102.f460251c);
        }
    }

    public static final class b {
    }

    static {
    }

    public ForsetiNavOptions() {
        this(0);
    }

    @Override // com.suite.lark.component.navroute.api.g
    public final String toString() {
        return "ForsetiNavOptions(singleTop=" + this.f460258b + ", clearTop=" + this.f460259c + ", inclusive=" + this.f460260d + ", animations=" + this.f460261e + ", requestCode=" + this.f460315g + ", style=" + this.f460316h + ", extras=" + this.f460317i + ", useForsetiAnimation=" + this.f460318j + ", isMultiModeDisplay=" + this.f460319k + ')';
    }

    @Override // com.suite.lark.component.navroute.api.g
    public final NavRouteNavigator.NavRouteExtras a() {
        return this.f460317i;
    }

    public /* synthetic */ ForsetiNavOptions(int r110) {
        this(false, null, false, null, -1, DestinationStyle.NORMAL, null, true, false);
    }

    public ForsetiNavOptions(boolean r110, String r111, boolean r112, com.suite.lark.component.navroute.api.g.a r113, int r114, DestinationStyle r115, ForsetiNavigator.ForsetiNavExtras r116, boolean r117, boolean r118) {
        Intrinsics.checkNotNullParameter(r115, "style");
        super(false, r110, r111, r112, r113, r116);
        this.f460315g = r114;
        this.f460316h = r115;
        this.f460317i = r116;
        this.f460318j = r117;
        this.f460319k = r118;
    }
}
