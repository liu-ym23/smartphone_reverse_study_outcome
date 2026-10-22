package com.ss.android.lark.passport.signinsdk_api.feature.context;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import lzb.a;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKLogoutContext implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Action f438082a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/feature/context/OfficeSDKLogoutContext$Action;", "", "<init>", "(Ljava/lang/String;I)V", "LOGOUT", "SWITCH", "DOUBAO_CHANGE_BINDING", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Action extends Enum<Action> {
        public static final Action DOUBAO_CHANGE_BINDING = null;
        public static final Action LOGOUT = null;
        public static final Action SWITCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f438083a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f438084b = null;

        public static EnumEntries<Action> getEntries() {
            return f438084b;
        }

        static {
            Action r100 = new Action("LOGOUT", 0);
            LOGOUT = r100;
            Action r101 = new Action("SWITCH", 1);
            SWITCH = r101;
            Action r102 = new Action("DOUBAO_CHANGE_BINDING", 2);
            DOUBAO_CHANGE_BINDING = r102;
            Action[] r103 = {r100, r101, r102};
            f438083a = r103;
            f438084b = EnumEntriesKt.enumEntries(r103);
        }

        public static Action[] values() {
            return (Action[]) f438083a.clone();
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public Action(String r100, int r101) {
            super(r100, r101);
        }
    }

    public OfficeSDKLogoutContext() {
        this(Action.LOGOUT);
    }

    public OfficeSDKLogoutContext(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f438082a = r100;
    }
}
