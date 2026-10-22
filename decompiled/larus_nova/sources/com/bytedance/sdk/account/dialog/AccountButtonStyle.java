package com.bytedance.sdk.account.dialog;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/account/dialog/AccountButtonStyle;", "", EffectConstants.NORMAL, "WEAK", "BOLD", "HIGHLIGHT", "account-sdk-core_release"}, k = 1, mv = {1, 4, 0})
public final enum AccountButtonStyle extends Enum<AccountButtonStyle> {
    public static final AccountButtonStyle BOLD = null;
    public static final AccountButtonStyle HIGHLIGHT = null;
    public static final AccountButtonStyle NORMAL = null;
    public static final AccountButtonStyle WEAK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccountButtonStyle[] f268892a = null;

    static {
        AccountButtonStyle r100 = new AccountButtonStyle(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        AccountButtonStyle r101 = new AccountButtonStyle("WEAK", 1);
        WEAK = r101;
        AccountButtonStyle r102 = new AccountButtonStyle("BOLD", 2);
        BOLD = r102;
        AccountButtonStyle r103 = new AccountButtonStyle("HIGHLIGHT", 3);
        HIGHLIGHT = r103;
        f268892a = new AccountButtonStyle[]{r100, r101, r102, r103};
    }

    public static AccountButtonStyle valueOf(String r100) {
        return (AccountButtonStyle) a.a(AccountButtonStyle.class, r100);
    }

    public static AccountButtonStyle[] values() {
        return (AccountButtonStyle[]) f268892a.clone();
    }

    public AccountButtonStyle(String r100, int r101) {
        super(r100, r101);
    }
}
