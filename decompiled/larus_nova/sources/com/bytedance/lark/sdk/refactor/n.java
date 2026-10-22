package com.bytedance.lark.sdk.refactor;

import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.lark.pb.tool.v1.MakeUserOfflineV2Request;
import com.bytedance.lark.pb.tool.v1.MakeUserOnlineV2Request;
import com.bytedance.lark.pb.tool.v1.SwitchUserStateRequest;
import com.bytedance.lark.sdk.refactor.state.LoginState;
import com.ss.android.lark.pb.improto.Command;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes20.dex */
public interface n extends e {
    Long a(String r100);

    LoginState f(String r100);

    Observable<Boolean> h(String r100, SwitchUserStateRequest.Builder r101);

    Pair<Long, Long> i(String r100);

    Observable<Boolean> k(String r100, MakeUserOnlineV2Request.Builder r101, com.ss.android.lark.sdk.h r102, boolean r103);

    int m(String r100, byte[] r101);

    Observable<Boolean> q(String r100, MakeUserOfflineV2Request.Builder r101, boolean r102);

    Observable<Boolean> t(String r100, SwitchUserStateRequest.Builder r101);

    void u(List<? extends Command> r100);

    Observable<Boolean> w(InitSDKRequest.Builder r100);
}
