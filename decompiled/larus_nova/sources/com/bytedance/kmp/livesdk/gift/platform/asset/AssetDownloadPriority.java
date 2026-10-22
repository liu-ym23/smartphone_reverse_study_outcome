package com.bytedance.kmp.livesdk.gift.platform.asset;

import com.obric.miniapp.alarm.AccountType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/asset/AssetDownloadPriority;", "", "", "priority", "I", "getPriority", "()I", EffectConstants.NORMAL, "OTHER_SEND", AccountType.LOCAL, "OPEN_DIY_PAGE", "livegift-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AssetDownloadPriority extends Enum<AssetDownloadPriority> {
    public static final AssetDownloadPriority LOCAL = null;
    public static final AssetDownloadPriority NORMAL = null;
    public static final AssetDownloadPriority OPEN_DIY_PAGE = null;
    public static final AssetDownloadPriority OTHER_SEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AssetDownloadPriority[] f252246a = null;
    private final int priority;

    static {
        AssetDownloadPriority r100 = new AssetDownloadPriority(EffectConstants.NORMAL, 0, 1);
        NORMAL = r100;
        AssetDownloadPriority r101 = new AssetDownloadPriority("OTHER_SEND", 1, 2);
        OTHER_SEND = r101;
        AssetDownloadPriority r102 = new AssetDownloadPriority(AccountType.LOCAL, 2, 3);
        LOCAL = r102;
        AssetDownloadPriority r103 = new AssetDownloadPriority("OPEN_DIY_PAGE", 3, 4);
        OPEN_DIY_PAGE = r103;
        f252246a = new AssetDownloadPriority[]{r100, r101, r102, r103};
    }

    public static AssetDownloadPriority valueOf(String r100) {
        return (AssetDownloadPriority) a.a(AssetDownloadPriority.class, r100);
    }

    public static AssetDownloadPriority[] values() {
        return (AssetDownloadPriority[]) f252246a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public AssetDownloadPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
