package com.bytedance.common.utility.android;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class ClipboardCompat {
    private static final ClipboardImpl IMPL = null;

    public interface ClipboardImpl {
        void setText(Context r100, CharSequence r101, CharSequence r102);
    }

    public static class HoneycombClipboardImpl implements ClipboardImpl {
        public HoneycombClipboardImpl() {
        }

        @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
        public static void INVOKEVIRTUAL_com_bytedance_common_utility_android_ClipboardCompat$HoneycombClipboardImpl_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(ClipboardManager r100, ClipData r101) {
            Intrinsics.checkNotNullParameter(r101, "clip");
            FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
            com_bytedance_common_utility_android_ClipboardCompat$HoneycombClipboardImpl_android_content_ClipboardManager_setPrimaryClip(r100, r101);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
            FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
        }

        private static void com_bytedance_common_utility_android_ClipboardCompat$HoneycombClipboardImpl_android_content_ClipboardManager_setPrimaryClip(ClipboardManager r110, ClipData r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            b r112 = new b();
            a r102 = ApiHookConfig.f245611b.get(101807);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L21
        L17:
            if (r107.f474982a == false) goto L19;
            return;
        L19:
            r110.setPrimaryClip(r111);
            return;
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // com.bytedance.common.utility.android.ClipboardCompat.ClipboardImpl
        public void setText(Context r100, CharSequence r101, CharSequence r102) {
            INVOKEVIRTUAL_com_bytedance_common_utility_android_ClipboardCompat$HoneycombClipboardImpl_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip((ClipboardManager) r100.getSystemService(DataType.CLIPBOARD), ClipData.newPlainText(r101, r102));
        }
    }

    static {
        IMPL = new HoneycombClipboardImpl();
    }

    public static void setText(Context r100, CharSequence r101, CharSequence r102) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L12;
        if (r102 == null) goto L13;
        IMPL.setText(r100, r101, r102);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }
}
