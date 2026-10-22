package com.larus.im.internal.jni.dependency;

import com.larus.im.FlowRuntime;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import gd9.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\n\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\n\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0010J\u0016\u0010\n\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011J\u0016\u0010\n\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniSettingsCallByNative;", "", "<init>", "()V", "settings", "Lcom/larus/im/depend/ISettingsService;", "getSettings", "()Lcom/larus/im/depend/ISettingsService;", "settings$delegate", "Lkotlin/Lazy;", MonitorConstants.CONNECT_TYPE_GET, "", "key", "", "default", "", "", "", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniSettingsCallByNative {
    private final Lazy settings$delegate;

    public static /* synthetic */ y a() {
        return settings_delegate$lambda$0();
    }

    private final y getSettings() {
        return (y) this.settings$delegate.getValue();
    }

    public OmniSettingsCallByNative() {
        this.settings$delegate = LazyKt.lazy(new f());
    }

    private static final y settings_delegate$lambda$0() {
        return FlowRuntime.b().b();
    }

    public final String get(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        return getSettings().getValue(r100, r101);
    }

    public final double get(String r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getSettings().a(r100, r101);
    }

    public final int get(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getSettings().b(r100, r101);
    }

    public final long get(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getSettings().c(r100, r101);
    }

    public final boolean get(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return getSettings().d(r100, r101);
    }
}
