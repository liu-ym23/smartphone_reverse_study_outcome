package com.larus.account.saas.jsb.core;

import android.app.Activity;
import com.larus.account.saas.ui.AccountCommonAlertAction;
import com.larus.account.saas.ui.AccountCommonAlertData;
import com.larus.account.saas.ui.IAccountCommonAlertUiService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class FlowAccountCommonAlertCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286331a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/account/saas/jsb/core/FlowAccountCommonAlertCore$Error;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "ACTIVITY_NULL", "NOT_HANDLED", "CANCELLED", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error ACTIVITY_NULL = null;
        public static final Error CANCELLED = null;
        public static final Error NOT_HANDLED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Error[] f286332a = null;
        private final int code;
        private final String message;

        public static Error valueOf(String r100) {
            return (Error) r27.a.a(Error.class, r100);
        }

        public static Error[] values() {
            return (Error[]) f286332a.clone();
        }

        static {
            Error r100 = new Error("ACTIVITY_NULL", 0, 1, "activity is null");
            ACTIVITY_NULL = r100;
            Error r101 = new Error("NOT_HANDLED", 1, 2, "activity cannot show common alert");
            NOT_HANDLED = r101;
            Error r102 = new Error("CANCELLED", 2, 3, "cancelled");
            CANCELLED = r102;
            f286332a = new Error[]{r100, r101, r102};
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public Error(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.code = r102;
            this.message = r103;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f286333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f286334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f286335c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f286333a, r101.f286333a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286334b, r101.f286334b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f286335c, r101.f286335c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f286333a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f286334b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f286335c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Action(id=" + this.f286333a + ", title=" + this.f286334b + ", style=" + this.f286335c + ')';
        }

        public a(String r100, String r101, Integer r102) {
            this.f286333a = r100;
            this.f286334b = r101;
            this.f286335c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f286336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f286337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f286338c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f286336a, r101.f286336a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286337b, r101.f286337b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f286338c, r101.f286338c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f286336a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f286337b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f286338c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(id=" + this.f286336a + ", title=" + this.f286337b + ", style=" + this.f286338c + ')';
        }

        public b(String r100, String r101, Integer r102) {
            this.f286336a = r100;
            this.f286337b = r101;
            this.f286338c = r102;
        }
    }

    static {
    }

    public static void a(Activity r100, String r101, String r102, List r110, final y38.b r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (r100 != null) goto L6;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("FlowAccountCommonAlertCore", "owner activity is null, abort common alert.");
        Error r103 = Error.ACTIVITY_NULL;
        r111.a(new x38.a(r103.getCode(), r103.getMessage(), null));
        return;
    L6:
        ArrayList r104 = new ArrayList();
        Iterator r112 = r110.iterator();
    L8:
        if (r112.hasNext() == false) goto L16;
        a r105 = (a) r112.next();
        if (r105 != null) goto L12;
        AccountCommonAlertAction r106 = null;
    L13:
        if (r106 == null) goto L8;
        r104.add(r106);
        goto L8
    L12:
        r106 = new AccountCommonAlertAction(r105.f286333a, r105.f286334b, r105.f286335c);
        goto L13
    L16:
        if (IAccountCommonAlertUiService.f286550b.b(r100, new AccountCommonAlertData(r101, r102, r104), new FlowAccountCommonAlertCore$handle$handled$1(r111), new FlowAccountCommonAlertCore$handle$handled$2(r111)) == true) goto L24;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("FlowAccountCommonAlertCore", "owner activity " + r100 + " cannot show common alert.");
        Error r107 = Error.NOT_HANDLED;
        r111.a(new x38.a(r107.getCode(), r107.getMessage(), null));
        return;
    }
}
