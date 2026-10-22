package com.bytedance.applet.model.bottomsheet;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ai.api.AppletBottomSheetButtonRole;
import com.bytedance.ai.api.AppletBottomSheetCancelSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final Bundle a;
    public Function2<? super DialogFragment, ? super AppletBottomSheetButtonRole, Unit> b;
    public Function2<? super DialogFragment, ? super AppletBottomSheetCancelSource, Unit> c;

    /* JADX INFO: renamed from: com.bytedance.applet.model.bottomsheet.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0058a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AppletBottomSheetButtonRole.values().length];
            r0[AppletBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AppletBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AppletBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public a() {
        this.a = new Bundle();
    }
}
