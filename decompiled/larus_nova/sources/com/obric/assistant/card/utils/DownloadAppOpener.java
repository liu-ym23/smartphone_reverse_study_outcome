package com.obric.assistant.card.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: classes32.dex */
public final class DownloadAppOpener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f386546a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/card/utils/DownloadAppOpener$Result;", "", "failureType", "", "messageRes", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)V", "getFailureType", "()Ljava/lang/String;", "getMessageRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", EventConstant.Event.EVENT_NFC_OPENED, "NOT_INSTALLED", "NO_LAUNCHER", "FAILED", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Result extends Enum<Result> {
        public static final Result FAILED = null;
        public static final Result NOT_INSTALLED = null;
        public static final Result NO_LAUNCHER = null;
        public static final Result OPENED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Result[] f386547a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f386548b = null;
        private final String failureType;
        private final Integer messageRes;

        public static EnumEntries<Result> getEntries() {
            return f386548b;
        }

        static {
            Result r100 = new Result(EventConstant.Event.EVENT_NFC_OPENED, 0, null, null);
            OPENED = r100;
            Result r101 = new Result("NOT_INSTALLED", 1, "app_not_exist", Integer.valueOf(R.string.obric_card_app_not_found));
            NOT_INSTALLED = r101;
            Result r102 = new Result("NO_LAUNCHER", 2, "app_not_launchable", Integer.valueOf(R.string.obric_card_app_not_launchable));
            NO_LAUNCHER = r102;
            Result r103 = new Result("FAILED", 3, "app_open_failed", Integer.valueOf(R.string.obric_card_app_open_failed));
            FAILED = r103;
            Result[] r104 = {r100, r101, r102, r103};
            f386547a = r104;
            f386548b = EnumEntriesKt.enumEntries(r104);
        }

        public static Result[] values() {
            return (Result[]) f386547a.clone();
        }

        public final String getFailureType() {
            return this.failureType;
        }

        public final Integer getMessageRes() {
            return this.messageRes;
        }

        public static Result valueOf(String r100) {
            return (Result) r27.a.a(Result.class, r100);
        }

        public Result(String r100, int r101, String r102, Integer r103) {
            super(r100, r101);
            this.failureType = r102;
            this.messageRes = r103;
        }
    }

    static {
    }

    public static Result a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L27;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        Result r103 = Result.NOT_INSTALLED;     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
    L23:
        Integer r104 = r103.getMessageRes();
        if (r104 == null) goto L26;
        s.j(s.f544207a, r100, r100.getString(r104.intValue()), null, false, 28);
    L26:
        return r103;
    L13:
        PackageManager r105 = r100.getPackageManager();     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        if (r105.getApplicationInfo(r101, 0).enabled == true) goto L16;
        r103 = Result.FAILED;     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        goto L23
    L16:
        Intent r106 = r105.getLaunchIntentForPackage(r101);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        if (r106 != null) goto L19;
        r103 = Result.NO_LAUNCHER;     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        goto L23
    L19:
        r106.addFlags(268435456);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        r100.startActivity(r106);     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        r103 = Result.OPENED;     // Catch: Exception -> L8 PackageManager.NameNotFoundException -> L22
        goto L23
    L27:
    L22:
        r103 = Result.NOT_INSTALLED;
    L8:
        e = move-exception;
        FLogger.f375446a.e("DownloadAppOpener", "Failed to open " + r101, e);
        r103 = Result.FAILED;
        goto L23
    L5:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r102 = false;
        goto L11
    }
}
