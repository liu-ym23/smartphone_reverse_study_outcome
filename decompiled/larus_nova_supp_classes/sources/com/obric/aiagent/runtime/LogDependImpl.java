package com.obric.aiagent.runtime;

import android.util.EventsUtils;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.platform.depend.ILogDepend;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J2\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072 \u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/runtime/LogDependImpl;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "<init>", "()V", "v", XmlPullParser.NO_NAMESPACE, "tag", XmlPullParser.NO_NAMESPACE, "msg", "d", "i", "w", "tr", XmlPullParser.NO_NAMESPACE, "e", "isDebug", XmlPullParser.NO_NAMESPACE, "getDirPath", "uploadAllLog", "scene", "callback", "Lkotlin/Function3;", XmlPullParser.NO_NAMESPACE, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class LogDependImpl implements ILogDepend {
    public LogDependImpl() {
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public final String getDirPath() {
        return FLogger.a.getDirPath();
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public final boolean isDebug() {
        return FLogger.a.isDebug();
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.d(r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.e(r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.i(r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.w(r2, r3);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.e(r2, r3, r4);
    }

    @Override // com.obric.aiagent.platform.depend.ILogDepend
    public final void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        FLogger.a.w(r2, r3, r4);
    }
}
