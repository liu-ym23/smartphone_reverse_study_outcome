package com.bytedance.lynx.service.settings;

import com.bytedance.mira.conig.Constants;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "succeed", "", "urlString", "", "errorCode", "", "errorMessage", "settingsString", "settingsTime", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class LynxSettingsDownloader$fetchSettings$1 extends Lambda implements Function6<Boolean, String, Integer, String, String, Long, Unit> {
    final /* synthetic */ Function2<Boolean, String, Unit> $callback;
    final /* synthetic */ boolean $shouldScheduleNext;
    final /* synthetic */ LynxSettingsDownloader.LynxSettingsSource $source;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxSettingsDownloader$fetchSettings$1(LynxSettingsDownloader.LynxSettingsSource r100, boolean r101, Function2<? super Boolean, ? super String, Unit> r102) {
        this.$source = r100;
        this.$shouldScheduleNext = r101;
        this.$callback = r102;
        super(6);
    }

    public final void invoke(boolean r110, String r111, int r112, String r210, String r211, long r212) {
        LynxSettingsDownloader r100 = LynxSettingsDownloader.f264959a;
        LynxSettingsDownloader.LynxSettingsSource r101 = this.$source;
        boolean r102 = this.$shouldScheduleNext;
        Function2<Boolean, String, Unit> r103 = this.$callback;
        TraceEvent.instant(1, "LynxSettingsDownloader.fetchSettings.finish");
        boolean r104 = false;
        if (r211 != null) goto L5;
    L10:
        String r113 = null;
    L12:
        if (r110 == false) goto L20;
        if (r113 == null) goto L20;
        LynxSettingsDownloader.b(true, r111, r101, r112, r210, r211);
        TraceEvent.instant(1, "LynxSettingsDownloader.updateSettingsData");
        LLog.i("LynxSettingsDownloader", "Will update settings: ".concat(r113));
        h.c().e(r113, r212);
        LynxSettingsDownloader.a().edit().putLong("lynx_settings_last_sync_time", System.currentTimeMillis()).apply();
        LynxSettingsDownloader.f264966h = 3;
        if (r102 == false) goto L17;
        LynxSettingsDownloader.c(Random.Default.nextLong(86400000, Constants.DOWNLOAD_TEMP_FILE_PAST_TIME));
    L17:
        if (r103 == null) goto L41;
        r103.invoke(Boolean.TRUE, null);
        return;
    L41:
        return;
    L20:
        if (r110 == false) goto L27;
        if (r211 != null) goto L23;
    L24:
        r104 = true;
    L25:
        if (r104 == false) goto L27;
        String r114 = "Lynx settings response is empty.";
    L28:
        LynxSettingsDownloader.b(false, r111, r101, r112, r114, r211);
        LLog.e("LynxSettingsDownloader", "Download settings failed");
        if (r102 == false) goto L35;
        int r105 = LynxSettingsDownloader.f264966h;
        if (r105 <= 0) goto L34;
        LynxSettingsDownloader.f264966h = r105 - 1;
        LynxSettingsDownloader.c(30000);
        goto L35
    L34:
        LynxSettingsDownloader.f264966h = 3;
        LynxSettingsDownloader.c(Random.Default.nextLong(86400000, Constants.DOWNLOAD_TEMP_FILE_PAST_TIME));
    L35:
        if (r103 == null) goto L43;
        Boolean r106 = Boolean.FALSE;
        if (r114 != null) goto L39;
        r114 = "Download settings failed.";
    L39:
        r103.invoke(r106, r114);
        return;
    L43:
        return;
    L23:
        if (r211.length() != 0) goto L25;
    L27:
        r114 = r210;
        goto L28
    L5:
        if (r211.length() <= 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == false) goto L10;
        r113 = r211;
        goto L12
    L7:
        r107 = false;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, String r110, Integer r111, String r112, String r113, Long r114) {
        invoke(r100.booleanValue(), r110, r111.intValue(), r112, r113, r114.longValue());
        return Unit.INSTANCE;
    }
}
