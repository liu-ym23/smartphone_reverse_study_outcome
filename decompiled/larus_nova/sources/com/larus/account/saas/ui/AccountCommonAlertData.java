package com.larus.account.saas.ui;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/larus/account/saas/ui/AccountCommonAlertData;", "Ljava/io/Serializable;", "title", "", "description", SlcCommonAction.KEY_ACTIONS, "", "Lcom/larus/account/saas/ui/AccountCommonAlertAction;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "account-saas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AccountCommonAlertData implements Serializable {
    private final List<AccountCommonAlertAction> actions;
    private final String description;
    private final String title;

    public AccountCommonAlertData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AccountCommonAlertData copy$default(AccountCommonAlertData r100, String r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.description;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.actions;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final List<AccountCommonAlertAction> component3() {
        return this.actions;
    }

    public final AccountCommonAlertData copy(String r100, String r101, List<AccountCommonAlertAction> r102) {
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        return new AccountCommonAlertData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AccountCommonAlertData) == true) goto L8;
        return false;
    L8:
        AccountCommonAlertData r101 = (AccountCommonAlertData) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.description;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.actions.hashCode();
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AccountCommonAlertData(title=" + this.title + ", description=" + this.description + ", actions=" + this.actions + ')';
    }

    public final List<AccountCommonAlertAction> getActions() {
        return this.actions;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public AccountCommonAlertData(String r100, String r101, List<AccountCommonAlertAction> r102) {
        Intrinsics.checkNotNullParameter(r102, SlcCommonAction.KEY_ACTIONS);
        this.title = r100;
        this.description = r101;
        this.actions = r102;
    }

    public /* synthetic */ AccountCommonAlertData(String r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        this(r100, r101, r102);
    }
}
