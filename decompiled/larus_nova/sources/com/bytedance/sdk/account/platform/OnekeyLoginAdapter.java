package com.bytedance.sdk.account.platform;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010B\u001b\b\u0016\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013JF\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J<\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/account/platform/OnekeyLoginAdapter;", "Lcom/bytedance/sdk/account/platform/OneKeyLoginBaseAdapter;", "", "token", "from", "providerAppId", "", "extendInfo", "Lva7/e;", "callback", "", "doQuickAuthLogin", "doQuickAuthLoginOnly", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "", "loginOnly", "(Landroid/content/Context;Z)V", "account-sdk-common-biz_release"}, k = 1, mv = {1, 4, 0})
public abstract class OnekeyLoginAdapter extends OneKeyLoginBaseAdapter {
    public OnekeyLoginAdapter(Context r100) {
        super(r100);
    }

    public OnekeyLoginAdapter(Context r100, boolean r101) {
        super(r100, r101);
    }

    @Override // com.bytedance.sdk.account.platform.OneKeyLoginBaseAdapter
    public void doQuickAuthLoginOnly(String r100, String r101, Map<String, String> r102, va7.e r103) {
        this.accountAPI.c(r100, r101, r102, r103);
    }

    @Override // com.bytedance.sdk.account.platform.OneKeyLoginBaseAdapter
    public void doQuickAuthLogin(String r100, String r101, String r102, Map<String, String> r110, va7.e r111) {
        this.accountAPI.e(r100, r101, r102, r110, r111);
    }
}
