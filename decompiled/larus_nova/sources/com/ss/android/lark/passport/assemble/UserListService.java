package com.ss.android.lark.passport.assemble;

import android.content.Context;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport_user.api.IUserListService;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class UserListService implements IUserListService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<com.ss.android.lark.storage.kv.storage.a> f437688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.storage.a f437689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Gson f437690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f437691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f437692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public User f437693f;

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final void q() {
    }

    public final User a() {
        if (this.f437692e == true) goto L15;
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl((User) this.f437690c.fromJson(((KVRepo) this.f437691d.getValue()).getString("user", null), User.class));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == true) goto L13;
        r100 = r102;
    L13:
        this.f437693f = (User) r100;
        this.f437692e = true;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L15:
        return this.f437693f;
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final List<User> getAllValidUserList() {
        return CollectionsKt.listOfNotNull(a());
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final User getForegroundUser() {
        return a();
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final List<String> r() {
        User r100 = a();
        List<String> r101 = null;
        String r102 = null;
        if (r100 == null) goto L26;
        ArrayList r103 = new ArrayList();
        String r104 = r100.getSession();
        if (r104 != null) goto L7;
    L11:
        Map<String, SessionInfo> r105 = r100.getSessionWithDomainMap();
        if (r105 == null) goto L25;
        Collection<SessionInfo> r106 = r105.values();
        if (r106 == null) goto L25;
        Sequence r107 = CollectionsKt.asSequence(r106);
        if (r107 == null) goto L25;
        Sequence r108 = SequencesKt.filter(r107, UserListService$allPassportSessions$3.INSTANCE);
        if (r108 == null) goto L25;
        Sequence r109 = SequencesKt.mapNotNull(r108, UserListService$allPassportSessions$4.INSTANCE);
        if (r109 == null) goto L25;
        Iterator r110 = r109.iterator();
    L23:
        if (r110.hasNext() == false) goto L25;
        r103.add((String) r110.next());
    L25:
        r101 = CollectionsKt.distinct(r103);
        goto L26
    L7:
        if ((!StringsKt.isBlank(r104)) == false) goto L9;
        r102 = r104;
    L9:
        if (r102 == null) goto L11;
        r103.add(r102);
    L26:
        if (r101 == null) goto L28;
        return r101;
    L28:
        return CollectionsKt.emptyList();
    }

    public final void b(User r100) {
        User r101 = a();
        String r102 = null;
        if (r100 == null) goto L82;
        if (r101 == null) goto L83;
        String r103 = r100.userId;
        boolean r104 = false;
        if (r103 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L83;
        if (Intrinsics.areEqual(r100.userId, r101.userId) == false) goto L83;
        String r106 = r100.getSession();
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == false) goto L26;
        r100.setSession(r101.getSession());
    L26:
        String r108 = r100.getSlSession();
        if (r108 != null) goto L29;
    L32:
        boolean r109 = true;
    L33:
        if (r109 == false) goto L35;
        r100.setSlSession(r101.getSlSession());
    L35:
        String r110 = r100.getSessionUuid();
        if (r110 != null) goto L38;
    L41:
        boolean r111 = true;
    L42:
        if (r111 == false) goto L44;
        r100.setSessionUuid(r101.getSessionUuid());
    L44:
        String r112 = r100.getLogoutToken();
        if (r112 != null) goto L47;
    L50:
        boolean r113 = true;
    L51:
        if (r113 == false) goto L53;
        r100.setLogoutToken(r101.getLogoutToken());
    L53:
        String r114 = r100.getCurrentEnv();
        if (r114 != null) goto L56;
    L59:
        boolean r115 = true;
    L60:
        if (r115 == false) goto L62;
        r100.setCurrentEnv(r101.getCurrentEnv());
    L62:
        String r116 = r100.getDeviceLoginId();
        if (r116 != null) goto L65;
    L68:
        boolean r117 = true;
    L69:
        if (r117 == false) goto L71;
        r100.setDeviceLoginId(r101.getDeviceLoginId());
    L71:
        Map<String, SessionInfo> r118 = r100.getSessionWithDomainMap();
        if (r118 != null) goto L74;
    L75:
        r104 = true;
    L76:
        if (r104 == false) goto L79;
        r100.setSessionWithDomainMap(r101.getSessionWithDomainMap());
    L79:
        if (r100.getLastUseTimestamp() != 0) goto L81;
        r100.setLastUseTimestamp(r101.getLastUseTimestamp());
    L81:
        r100.setAnonymous(r101.isAnonymous());
        r100.setSessionValid(r101.hasValidSession());
        r100.setSessionValidOrForeground(r101.hasValidSessionOrForeground());
        r100.leanModeInfo = r101.leanModeInfo;
        goto L83
    L74:
        if (r118.isEmpty() == false) goto L76;
    L65:
        if (StringsKt.isBlank(r116) == true) goto L68;
        r117 = false;
        goto L69
    L56:
        if (StringsKt.isBlank(r114) == true) goto L59;
        r115 = false;
        goto L60
    L47:
        if (StringsKt.isBlank(r112) == true) goto L50;
        r113 = false;
        goto L51
    L38:
        if (StringsKt.isBlank(r110) == true) goto L41;
        r111 = false;
        goto L42
    L29:
        if (StringsKt.isBlank(r108) == true) goto L32;
        r109 = false;
        goto L33
    L20:
        if (StringsKt.isBlank(r106) == true) goto L23;
        r107 = false;
        goto L24
    L9:
        if (StringsKt.isBlank(r103) == true) goto L12;
        r105 = false;
    L83:
        if (r100 == null) goto L86;
        r102 = r100.userUnit;
    L86:
        if (Intrinsics.areEqual(r102, "eu_nc6") == false) goto L88;
        PassportLog.d("UserListService", "eu_nc6 2 eu_nc");
        r100.userUnit = "eu_nc";
    L88:
        this.f437693f = r100;
        this.f437692e = true;
        ((KVRepo) this.f437691d.getValue()).putString("user", GsonProtectorUtils.toJson(this.f437690c, r100));
        PassportUserApi.Companion.getClass();
        CoreThreadPool.getSerialTaskHandler().post(new h(r101, r100));
        return;
    L82:
        r100 = null;
        goto L83
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final l s(String r100) {
        User r101 = a();
        if (r101 == null) goto L5;
        String r102 = r101.userId;
    L7:
        if (Intrinsics.areEqual(r100, r102) == false) goto L13;
        User r103 = a();
        if (r103 != null) goto L12;
        return null;
    L12:
        return new l(r103);
    L13:
        return null;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final void u(User r100) {
        if (r100 == null) goto L12;
        String r101 = r100.userId;
        User r102 = a();
        if (r102 == null) goto L6;
        String r103 = r102.userId;
    L8:
        if (Intrinsics.areEqual(r101, r103) == false) goto L13;
        b(r100);
        return;
    L13:
        return;
    L6:
        r103 = null;
        goto L8
    }

    @Inject
    public UserListService(@ApplicationContext Context r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "kvStorage");
        this.f437688a = r101;
        this.f437689b = new com.ss.android.lark.storage.a("Passport");
        this.f437690c = new GsonBuilder().registerTypeAdapter(User.class, new UserTypeAdapter()).create();
        this.f437691d = LazyKt.lazy(new UserListService$kvRepo$2(this));
    }

    @Override // com.ss.android.lark.passport_user.api.IUserListService
    public final void t(List<? extends User> r100, String r101, IUserListService.UserLoginSource r102) {
        Intrinsics.checkNotNullParameter(r100, "loginUsers");
        Intrinsics.checkNotNullParameter(r102, "source");
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((User) r104).userId, r101) == false) goto L4;
    L9:
        b((User) r104);
        return;
    L8:
        r104 = null;
        goto L9
    }
}
