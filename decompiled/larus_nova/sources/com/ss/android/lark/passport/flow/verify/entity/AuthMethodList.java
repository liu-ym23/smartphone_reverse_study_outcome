package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0003\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u001c\b\u0003\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethodList;", "Ljava/io/Serializable;", "title", "", "authMethodList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/passport/flow/verify/entity/AuthMethod;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getTitle", "()Ljava/lang/String;", "getAuthMethodList", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthMethodList implements Serializable {
    private final ArrayList<AuthMethod> authMethodList;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public AuthMethodList() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthMethodList copy$default(AuthMethodList r100, String r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.authMethodList;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.title;
    }

    public final ArrayList<AuthMethod> component2() {
        return this.authMethodList;
    }

    public final AuthMethodList copy(@JSONField(name = "title") String r100, @JSONField(name = "authn_methods") ArrayList<AuthMethod> r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        return new AuthMethodList(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AuthMethodList) == true) goto L8;
        return false;
    L8:
        AuthMethodList r101 = (AuthMethodList) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.authMethodList, r101.authMethodList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.title.hashCode() * 31;
        ArrayList<AuthMethod> r101 = this.authMethodList;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "AuthMethodList(title=" + this.title + ", authMethodList=" + this.authMethodList + ')';
    }

    public final ArrayList<AuthMethod> getAuthMethodList() {
        return this.authMethodList;
    }

    public final String getTitle() {
        return this.title;
    }

    public AuthMethodList(@JSONField(name = "title") String r100, @JSONField(name = "authn_methods") ArrayList<AuthMethod> r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.title = r100;
        this.authMethodList = r101;
    }

    public /* synthetic */ AuthMethodList(String r100, ArrayList r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new ArrayList();
    L8:
        this(r100, r101);
    }
}
