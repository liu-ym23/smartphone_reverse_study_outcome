package com.ss.android.lark.qrcode.utils;

import android.app.ActivityManager;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class QRScanUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f439101a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/qrcode/utils/QRScanUtils$ProcessSuffix;", "", "suffix", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SUFFIX_P0", "SUFFIX_MINI_APP", "value", "getValue", "qrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ProcessSuffix extends Enum<ProcessSuffix> {
        public static final ProcessSuffix SUFFIX_MINI_APP = null;
        public static final ProcessSuffix SUFFIX_P0 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProcessSuffix[] f439102a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f439103b = null;
        private final String value;

        public static EnumEntries<ProcessSuffix> getEntries() {
            return f439103b;
        }

        static {
            ProcessSuffix r100 = new ProcessSuffix("SUFFIX_P0", 0, ":p0");
            SUFFIX_P0 = r100;
            ProcessSuffix r101 = new ProcessSuffix("SUFFIX_MINI_APP", 1, ":miniapp");
            SUFFIX_MINI_APP = r101;
            ProcessSuffix[] r102 = {r100, r101};
            f439102a = r102;
            f439103b = EnumEntriesKt.enumEntries(r102);
        }

        public static ProcessSuffix[] values() {
            return (ProcessSuffix[]) f439102a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ProcessSuffix valueOf(String r100) {
            return (ProcessSuffix) a.a(ProcessSuffix.class, r100);
        }

        public ProcessSuffix(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
    }

    public static boolean a(ProcessSuffix r100) {
        ActivityManager r101 = (ActivityManager) LarkContext.getApplication().getSystemService("activity");
        if (r101 == null) goto L14;
        List<ActivityManager.RunningAppProcessInfo> r102 = r101.getRunningAppProcesses();
        if (r102 == null) goto L14;
        if ((!r102.isEmpty()) == false) goto L14;
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        if (StringsKt.contains$default(r103.next().processName, r100.getValue(), false, 2, null) == false) goto L10;
        return true;
    L14:
        return false;
    }
}
