package se6;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes20.dex */
public final class o extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile Handler f541588c;

    public o() {
        super("lark_sdk_sub");
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        this.f541588c = new Handler(getLooper());
    }
}
