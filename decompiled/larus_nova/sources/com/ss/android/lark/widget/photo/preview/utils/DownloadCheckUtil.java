package com.ss.android.lark.widget.photo.preview.utils;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.lark.android.encryption.CipherManager;
import com.ss.lark.android.encryption.exception.DecryptException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class DownloadCheckUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f447128a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/widget/photo/preview/utils/DownloadCheckUtil$DownloadCheckResult;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "NULL", "CIPHER", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DownloadCheckResult extends Enum<DownloadCheckResult> {
        public static final DownloadCheckResult ALLOW = null;
        public static final DownloadCheckResult CIPHER = null;
        public static final DownloadCheckResult NULL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DownloadCheckResult[] f447129a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f447130b = null;

        public static EnumEntries<DownloadCheckResult> getEntries() {
            return f447130b;
        }

        static {
            DownloadCheckResult r100 = new DownloadCheckResult("ALLOW", 0);
            ALLOW = r100;
            DownloadCheckResult r101 = new DownloadCheckResult("NULL", 1);
            NULL = r101;
            DownloadCheckResult r102 = new DownloadCheckResult("CIPHER", 2);
            CIPHER = r102;
            DownloadCheckResult[] r103 = {r100, r101, r102};
            f447129a = r103;
            f447130b = EnumEntriesKt.enumEntries(r103);
        }

        public static DownloadCheckResult[] values() {
            return (DownloadCheckResult[]) f447129a.clone();
        }

        public static DownloadCheckResult valueOf(String r100) {
            return (DownloadCheckResult) r27.a.a(DownloadCheckResult.class, r100);
        }

        public DownloadCheckResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.utils.DownloadCheckUtil$a$a, reason: collision with other inner class name */
        public static final class C5415a {
        }

        static {
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f447131a = null;

        static {
            int[] r100 = new int[DownloadCheckResult.values().length];
            r100[DownloadCheckResult.CIPHER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f447131a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a() {
        com.ss.android.lark.widget.photopicker.f.a().o();     // Catch: DecryptException -> L4
        throw null;     // Catch: DecryptException -> L4
    L4:
        e = move-exception;
        Log.i("DownloadCheckUtil", "DecryptException / " + e.getErrorCode() + ", " + e.getMessage());
    }

    @JvmStatic
    public static final DownloadCheckResult b(PhotoItem r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100 != null) goto L8;
        DownloadCheckResult r102 = DownloadCheckResult.NULL;
        if (b.f447131a[r102.ordinal()] != 1) goto L7;
        UDToast.show(r101, R.string.Lark_Core_SecuritySettingKAToast);
        CipherManager.h();
    L7:
        return r102;
    L8:
        com.ss.android.lark.widget.photopicker.f.a().o();
        throw null;
    }
}
