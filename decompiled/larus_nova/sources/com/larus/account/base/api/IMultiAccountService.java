package com.larus.account.base.api;

import com.larus.login.impl.multiaccount.g;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import n38.k;
import n38.w;
import q38.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u0000 #2\u00020\u0001:\u0002#$J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J(\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J\u001c\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001c\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&Jn\u0010\u0018\u001a\u00020\u00032d\u0010\u0019\u001a`\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00030\u001aH&¨\u0006%"}, d2 = {"Lcom/larus/account/base/api/IMultiAccountService;", "", "init", "", "getLocalAccountList", "", "Lcom/larus/account/base/model/AccountLocalItem;", "getCurrentAccount", "onLoginSuccess", "onLogout", "secUserId", "", "switchAccount", "targetAccount", "callback", "Lcom/larus/account/base/api/IAccountSwitchCallback;", "reason", "Lcom/larus/account/base/api/AccountSwitchReason;", "removeAccount", "addAccountRemovedListener", "listener", "Lcom/larus/account/base/api/IMultiAccountService$AccountRemovedListener;", "removeAccountRemovedListener", "switchToNextAfterLogout", "fetchServerAccountList", "onResult", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "success", "rawJson", "", "errorCode", "errorMsg", "Companion", "AccountRemovedListener", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMultiAccountService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f286100a = null;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016Jn\u0010\u001f\u001a\u00020\n2d\u0010 \u001a`\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110'¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\n0!H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006*"}, d2 = {"Lcom/larus/account/base/api/IMultiAccountService$Companion;", "Lcom/larus/account/base/api/IMultiAccountService;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/account/base/api/IMultiAccountService;", "impl$delegate", "Lkotlin/Lazy;", "init", "", "getLocalAccountList", "", "Lcom/larus/account/base/model/AccountLocalItem;", "getCurrentAccount", "onLoginSuccess", "onLogout", "secUserId", "", "switchAccount", "targetAccount", "callback", "Lcom/larus/account/base/api/IAccountSwitchCallback;", "reason", "Lcom/larus/account/base/api/AccountSwitchReason;", "switchToNextAfterLogout", "removeAccount", "addAccountRemovedListener", "listener", "Lcom/larus/account/base/api/IMultiAccountService$AccountRemovedListener;", "removeAccountRemovedListener", "fetchServerAccountList", "onResult", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "success", "rawJson", "", "errorCode", "errorMsg", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IMultiAccountService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f286101b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IMultiAccountService> f286102c = null;

        private Companion() {
        }

        static {
            f286101b = new Companion();
            f286102c = LazyKt.lazy(new w());
        }

        public static IMultiAccountService j() {
            return f286102c.getValue();
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final b c() {
            IMultiAccountService r100 = j();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.c();
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final List<b> g() {
            IMultiAccountService r100 = j();
            if (r100 == null) goto L5;
            List<b> r101 = r100.g();
        L6:
            if (r101 == null) goto L8;
            return r101;
        L8:
            return CollectionsKt.emptyList();
        L5:
            r101 = null;
            goto L6
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void init() {
            IMultiAccountService r100 = j();
            if (r100 == null) goto L6;
            r100.init();
            return;
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void onLoginSuccess() {
            IMultiAccountService r100 = j();
            if (r100 == null) goto L6;
            r100.onLoginSuccess();
            return;
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void b(a r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            IMultiAccountService r101 = j();
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void f(Function4<? super Boolean, ? super String, ? super Integer, ? super String, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "onResult");
            IMultiAccountService r101 = j();
            if (r101 == null) goto L6;
            r101.f(r100);
            return;
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "secUserId");
            IMultiAccountService r101 = j();
            if (r101 == null) goto L6;
            r101.h(r100);
            return;
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void i(a r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            IMultiAccountService r101 = j();
            if (r101 == null) goto L6;
            r101.i(r100);
            return;
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void a(b r100, k r101) {
            Intrinsics.checkNotNullParameter(r100, "targetAccount");
            IMultiAccountService r102 = j();
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void d(AccountSwitchReason r100, g r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            IMultiAccountService r102 = j();
            if (r102 == null) goto L6;
            r102.d(r100, r101);
            return;
        }

        @Override // com.larus.account.base.api.IMultiAccountService
        public final void e(b r100, k r101, AccountSwitchReason r102) {
            Intrinsics.checkNotNullParameter(r102, "reason");
            IMultiAccountService r103 = j();
            if (r103 == null) goto L6;
            r103.e(r100, r101, r102);
            return;
        }
    }

    public interface a {
        void a(String r100, String r101);
    }

    static {
        f286100a = Companion.f286101b;
    }

    void a(b r100, k r101);

    void b(a r100);

    b c();

    void d(AccountSwitchReason r100, g r101);

    void e(b r100, k r101, AccountSwitchReason r102);

    void f(Function4<? super Boolean, ? super String, ? super Integer, ? super String, Unit> r100);

    List<b> g();

    void h(String r100);

    void i(a r100);

    void init();

    void onLoginSuccess();
}
