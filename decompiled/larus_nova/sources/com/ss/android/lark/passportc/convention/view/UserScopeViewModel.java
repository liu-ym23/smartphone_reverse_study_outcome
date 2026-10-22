package com.ss.android.lark.passportc.convention.view;

import androidx.lifecycle.ViewModel;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.api.s;
import f0c.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passportc/convention/view/UserScopeViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/passportc/api/IUserScopeConvention;", "passport", "Lcom/ss/android/lark/passportc/api/IPassportUserService;", "<init>", "(Lcom/ss/android/lark/passportc/api/IPassportUserService;)V", "getPassport", "()Lcom/ss/android/lark/passportc/api/IPassportUserService;", "onCleared", "", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UserScopeViewModel extends ViewModel implements r {
    private final m passport;

    @Override // com.ss.android.lark.passportc.api.o
    public void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        s.b(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public m getPassport() {
        return this.passport;
    }

    public UserScopeViewModel(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        this.passport = r100;
        s.a(this);
    }
}
