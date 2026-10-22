package com.larus.contextwindow.impl.membership;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f330361a = null;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.membership.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4198a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f330362a = null;

        static {
            int[] r100 = new int[MembershipQuotaRowKind.values().length];
            r100[MembershipQuotaRowKind.SUBSCRIPTION_TOTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[MembershipQuotaRowKind.H5.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[MembershipQuotaRowKind.D7.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[MembershipQuotaRowKind.M1.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f330362a = r100;
        }
    }

    static {
        f330361a = new Regex("\\s*/\\s*");
    }
}
