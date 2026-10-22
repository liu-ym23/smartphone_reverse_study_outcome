package com.ss.android.downloadlib.runtime.impl;

import android.text.TextUtils;
import com.ss.android.download.api.config.DownloadLoggerListener;
import com.ss.android.download.api.runtime.IAdLogProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import t6.a;
import t6.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J$\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdALogProviderImpl;", "Lcom/ss/android/download/api/runtime/IAdLogProvider;", "enableRuntime", "", "enableALog", "(ZZ)V", "d", "", "tag", "", "msg", "e", "tr", "", RXScreenCaptureService.KEY_INDEX, "onSendLog", "message", "level", "", BaseSwitches.V, "w", "Companion", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class AdALogProviderImpl implements IAdLogProvider {
    public static final Companion Companion = null;
    public static final String TAG = "AdALogProviderImpl";
    private final boolean enableALog;
    private final boolean enableRuntime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdALogProviderImpl$Companion;", "", "()V", "TAG", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AdALogProviderImpl(boolean r100, boolean r101) {
        this.enableRuntime = r100;
        this.enableALog = r101;
    }

    @Override // com.ss.android.download.api.runtime.IAdLogProvider
    public void d(String r100, String r101) {
        if (this.enableRuntime == true) goto L5;
        return;
    L5:
        if (this.enableALog == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        b r102 = a.f544652a;
        l6.a r103 = (l6.a) a.C7690a.a(l6.a.class, null);
        if (r103 == null) goto L15;
        r103.d();
        return;
    L15:
        return;
    }

    @Override // com.ss.android.download.api.runtime.IAdLogProvider
    public void i(String r100, String r101) {
        if (this.enableRuntime == true) goto L5;
        return;
    L5:
        if (this.enableALog == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        b r102 = a.f544652a;
        l6.a r103 = (l6.a) a.C7690a.a(l6.a.class, null);
        if (r103 == null) goto L15;
        r103.i();
        return;
    L15:
        return;
    }

    @Override // com.ss.android.download.api.runtime.IAdLogProvider
    public void onSendLog(String r100, int r101) {
        if (GlobalInfo.getDownloadLoggerListener() != null) goto L5;
        return;
    L5:
        if (r101 > 3) goto L9;
        DownloadLoggerListener r102 = GlobalInfo.getDownloadLoggerListener();
        if (r102 == null) goto L14;
        r102.logD(r100);
        return;
    L14:
        return;
    L9:
        DownloadLoggerListener r103 = GlobalInfo.getDownloadLoggerListener();
        if (r103 == null) goto L16;
        r103.logE(r100);
        return;
    }

    @Override // com.ss.android.download.api.runtime.IAdLogProvider
    public void v(String r100, String r101) {
        if (this.enableRuntime == true) goto L5;
        return;
    L5:
        if (this.enableALog == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        b r102 = a.f544652a;
        l6.a r103 = (l6.a) a.C7690a.a(l6.a.class, null);
        if (r103 == null) goto L15;
        r103.v();
        return;
    L15:
        return;
    }

    @Override // com.ss.android.download.api.runtime.IAdLogProvider
    public void e(String r100, String r101, Throwable r102) {
        if (this.enableRuntime == true) goto L5;
        return;
    L5:
        if (this.enableALog == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (r102 == null) goto L16;
        b r103 = a.f544652a;
        l6.a r104 = (l6.a) a.C7690a.a(l6.a.class, null);
        if (r104 == null) goto L17;
        r104.e();
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.ss.android.download.api.runtime.IAdLogProvider
    public void w(String r100, String r101, Throwable r102) {
        if (this.enableRuntime == true) goto L5;
        return;
    L5:
        if (this.enableALog == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (r102 == null) goto L16;
        b r103 = a.f544652a;
        l6.a r104 = (l6.a) a.C7690a.a(l6.a.class, null);
        if (r104 == null) goto L17;
        r104.a();
        return;
    L17:
        return;
    L16:
        return;
    }
}
