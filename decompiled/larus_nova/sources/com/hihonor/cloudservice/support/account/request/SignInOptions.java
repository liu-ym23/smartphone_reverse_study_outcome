package com.hihonor.cloudservice.support.account.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class SignInOptions extends AbstractSignInOptions {
    public static final Parcelable.Creator<SignInOptions> CREATOR = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SignInOptions f276495j = null;

    public class a implements Parcelable.Creator<SignInOptions> {
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SignInOptions createFromParcel(Parcel r100) {
            return null;
        }

        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SignInOptions[] newArray(int r100) {
            return new SignInOptions[r100];
        }
    }

    public SignInOptions() {
        throw null;
    }

    static {
        HashSet r100 = new HashSet();
        HashSet r101 = new HashSet();
        r100.add(AbstractSignInOptions.f276505i);
        r100.add(AbstractSignInOptions.f276504h);
        f276495j = new SignInOptions(r100, r101, "", "", "", true, true);
        CREATOR = new a();
    }

    @Override // com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions
    public final int hashCode() {
        ArrayList<Scope> r100 = this.f276506a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        ArrayList<PermissionInfo> r104 = this.f276507b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // com.hihonor.cloudservice.support.feature.request.AbstractSignInOptions
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SignInOptions) == true) goto L8;
        return false;
    L8:
        SignInOptions r101 = (SignInOptions) r100;
        if (AbstractSignInOptions.a(this.f276506a, r101.f276506a) == true) goto L11;
    L13:
        return false;
    L11:
        if (AbstractSignInOptions.a(this.f276507b, r101.f276507b) == false) goto L13;
        return true;
    }

    public SignInOptions(Set r100, Set r110, String r111, String r112, String r113, boolean r114, boolean r115) {
        super(new ArrayList(r100), new ArrayList(r110), r111, r112, r113, r114, r115);
    }
}
