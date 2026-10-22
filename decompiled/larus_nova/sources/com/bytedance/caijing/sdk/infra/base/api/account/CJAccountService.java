package com.bytedance.caijing.sdk.infra.base.api.account;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import xc4.a;
import xc4.b;
import xc4.c;
import xc4.d;
import xc4.e;
import xc4.f;
import xc4.g;
import xc4.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J*\u0010\r\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J \u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001fH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016J\u0018\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\"H\u0016J,\u0010#\u001a\u00020\t2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u0013\u001a\u00020\"H\u0016J3\u0010-\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00022!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006."}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/account/CJAccountService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "", "getUserId", "", "switchAccountNeedKeepActivitys", "Lxc4/f;", "getHostCurrentUserInfo", "Lkotlin/Function1;", "", "onSuc", "Lkotlin/Function0;", "onFail", "getLatestUserInfoOpt", "Landroid/app/Activity;", "activity", "Lxc4/b;", "params", "Lxc4/d;", "callback", "hostShowLogin", "Lxc4/e;", "listener", "addHostLoginStatusChangeListener", "removeHostLoginStatusChangeListener", "Lxc4/c;", "handler", "addHostAccountKickOutHandler", "removeHostAccountKickOutHandler", "", "isTTTokenInit", "Lxc4/h;", "addTokenInitListener", "allUidList", "Lxc4/g;", "showSwitchAccount", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "enterFrom", "Lxc4/a;", "avoidRestartData", "accountType", "Lkotlin/ParameterName;", "name", Keys.API_RETURN_KEY_IS_LOGIN, "queryShareAccount", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface CJAccountService extends ICJService {
    void addHostAccountKickOutHandler(c r100);

    void addHostLoginStatusChangeListener(e r100);

    void addTokenInitListener(h r100);

    List<String> allUidList();

    f getHostCurrentUserInfo();

    void getLatestUserInfoOpt(Function1<? super f, Unit> r100, Function0<Unit> r101);

    String getUserId();

    void hostShowLogin(Activity r100, b r101, d r102);

    boolean isTTTokenInit();

    void queryShareAccount(String r100, Function1<? super Boolean, Unit> r101);

    void removeHostAccountKickOutHandler(c r100);

    void removeHostLoginStatusChangeListener(e r100);

    void showSwitchAccount(Activity r100, g r101);

    void showSwitchAccount(LifecycleOwner r100, String r101, a r102, g r103);

    List<String> switchAccountNeedKeepActivitys();
}
