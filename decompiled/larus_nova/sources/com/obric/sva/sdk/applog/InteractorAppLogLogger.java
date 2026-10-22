package com.obric.sva.sdk.applog;

import com.larus.utils.logger.FLogger;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import ita.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/sva/sdk/applog/InteractorAppLogLogger;", "Lcom/ss/android/common/util/ILogger;", "tag", "", "<init>", "(Ljava/lang/String;)V", BaseSwitches.V, "", "msg", "t", "", "d", "w", RXScreenCaptureService.KEY_INDEX, "e", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractorAppLogLogger implements h {
    private final String tag;

    public InteractorAppLogLogger(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.tag = r100;
    }

    @Override // ita.h
    public void d(String r100, Throwable r101) {
        if (r101 == null) goto L4;
        FLogger.f375446a.w(this.tag, r100, r101);
        return;
    L4:
        FLogger.f375446a.d(this.tag, r100);
    }

    @Override // ita.h
    public void e(String r100, Throwable r101) {
        FLogger.f375446a.e(this.tag, r100, r101);
    }

    @Override // ita.h
    public void i(String r100, Throwable r101) {
        if (r101 == null) goto L4;
        FLogger.f375446a.w(this.tag, r100, r101);
        return;
    L4:
        FLogger.f375446a.i(this.tag, r100);
    }

    @Override // ita.h
    public void v(String r100, Throwable r101) {
        if (r101 == null) goto L4;
        FLogger.f375446a.w(this.tag, r100, r101);
        return;
    L4:
        FLogger.f375446a.v(this.tag, r100);
    }

    @Override // ita.h
    public void w(String r100, Throwable r101) {
        FLogger.f375446a.w(this.tag, r100, r101);
    }
}
