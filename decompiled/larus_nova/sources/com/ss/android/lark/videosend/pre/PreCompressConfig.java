package com.ss.android.lark.videosend.pre;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/videosend/pre/PreCompressConfig;", "", "switch", "Lcom/ss/android/lark/videosend/pre/SwitchConfig;", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "Lcom/ss/android/lark/videosend/pre/LimitConfig;", "<init>", "(Lcom/ss/android/lark/videosend/pre/SwitchConfig;Lcom/ss/android/lark/videosend/pre/LimitConfig;)V", "getSwitch", "()Lcom/ss/android/lark/videosend/pre/SwitchConfig;", "setSwitch", "(Lcom/ss/android/lark/videosend/pre/SwitchConfig;)V", "getLimit", "()Lcom/ss/android/lark/videosend/pre/LimitConfig;", "setLimit", "(Lcom/ss/android/lark/videosend/pre/LimitConfig;)V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreCompressConfig {

    @SerializedName(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT)
    private LimitConfig limit;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private SwitchConfig f119switch;

    /* JADX WARN: Multi-variable type inference failed */
    public PreCompressConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final LimitConfig getLimit() {
        return this.limit;
    }

    public final SwitchConfig getSwitch() {
        return this.f119switch;
    }

    public final void setLimit(LimitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.limit = r100;
    }

    public final void setSwitch(SwitchConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119switch = r100;
    }

    public PreCompressConfig(SwitchConfig r100, LimitConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "switch");
        Intrinsics.checkNotNullParameter(r101, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT);
        this.f119switch = r100;
        this.limit = r101;
    }

    public /* synthetic */ PreCompressConfig(SwitchConfig r110, LimitConfig r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r110 = new SwitchConfig(0, 0, 0, 0, 15, null);
    L6:
        if ((r112 & 2) == 0) goto L8;
        r111 = new LimitConfig(0, 0, 0, 0, 0, 31, null);
    L8:
        this(r110, r111);
    }
}
