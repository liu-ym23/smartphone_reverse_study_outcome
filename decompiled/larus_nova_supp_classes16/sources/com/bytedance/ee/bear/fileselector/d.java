package com.bytedance.ee.bear.fileselector;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.ui.j;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static boolean a(FragmentManager r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            Intrinsics.checkNotNullParameter(r3, "tag");
            tt5.a.h("FileSelectorManager", "dismiss() called with: manager = " + r2 + ", tag = " + r3);
            Fragment r4 = r2.findFragmentByTag(r3);
            if (r4 != null) goto L5;
        L8:
            StringBuilder r5 = new StringBuilder("dismiss fail: fragment:");
            r5.append(r4);
            r5.append(" isAdded:");
            if (r4 == null) goto L11;
            Boolean r6 = Boolean.valueOf(r4.isAdded());
        L12:
            r5.append(r6);
            tt5.a.d("FileSelectorManager", r5.toString());
            return false;
        L11:
            r6 = null;
            goto L12
        L5:
            if (r4.isAdded() == false) goto L8;
            r2.beginTransaction().remove(r4).commitAllowingStateLoss();
            return true;
        }

        @JvmStatic
        public static FileSelectFragment b(Context r3, FileSelectConfig r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "config");
            Bundle r0 = new Bundle();
            r0.putInt("select_type", r4.selectType);
            FileSelectFragment r5 = Fragment.instantiate(r3, FileSelectFragment.class.getName(), r0);
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.fileselector.FileSelectFragment");
            FileSelectFragment r6 = r5;
            r6.na0(r4);
            return r6;
        }

        @JvmStatic
        public static FileSelectFragment c(Context r21, FragmentManager r22, FileSelectConfig r23, String r24) {
            Intrinsics.checkNotNullParameter(r21, "context");
            Intrinsics.checkNotNullParameter(r22, "fm");
            Intrinsics.checkNotNullParameter(r23, "config");
            Intrinsics.checkNotNullParameter(r24, "tag");
            tt5.a.h("FileSelectorManager", "selectFile() called with: fm = " + r22 + ", config = " + r23 + ", tag = " + r24);
            g.a.getClass();
            Intrinsics.checkNotNullParameter(r21, "context");
            Intrinsics.checkNotNullParameter(r23, "config");
            if (Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE) == false) goto L15;
            int r0 = r23.selectType;
            boolean r14 = true;
            if (r0 == 1) goto L11;
            if (r0 == 2) goto L11;
            if (r0 == 3) goto L11;
            boolean r1 = false;
        L13:
            if (r1 == true) goto L17;
            tt5.a.k("OfficeMediaFileSelector", "selectFile unsupported selectType: " + r23.selectType);
            goto L15
        L17:
            if (com.bytedance.ee.util.ui.b.b(r21) == true) goto L19;
            tt5.a.k("OfficeMediaFileSelector", "selectFile failed, activity is not active");
            g.b(r23);
        L83:
            if (r14 == false) goto L86;
            return null;
        L86:
            if (com.bytedance.ee.util.ui.b.b(r21) == false) goto L109;
            FileSelectFragment r2 = r22.findFragmentByTag(r24);
            if (r2 != null) goto L90;
        L93:
            FileSelectFragment r3 = b(r21, r23);
            FragmentTransaction r4 = r22.beginTransaction();
            ViewGroup r5 = r23.container;
            if (r5 == null) goto L105;
            if (r5.getId() != (-1)) goto L98;
        L99:
            r23.container.setId(View.generateViewId());
        L100:
            int r6 = r23.container.getId();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r24, r6) == true) goto L108;
            r4.add(r6, r3, r24);
        L108:
            r4.commitAllowingStateLoss();
        L113:
            return r3;
        L98:
            if (r23.container.getId() != 0) goto L100;
        L105:
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r24, 0) == true) goto L108;
            r4.add(r3, r24);
            goto L108
        L90:
            if ((r2 instanceof FileSelectFragment) == false) goto L93;
            r3 = r2;
            r3.na0(r23);
            goto L113
        L109:
            tt5.a.k("FileSelectorManager", "activity is not active");
            return null;
        L19:
            FragmentActivity r7 = g.a(r21);
            if (r7 != null) goto L22;
            tt5.a.k("OfficeMediaFileSelector", "selectFile failed, context is not FragmentActivity");
            g.b(r23);
            goto L83
        L22:
            int r8 = r23.selectType;
            if (r8 == 1) goto L28;
            if (r8 == 2) goto L28;
            if (r8 == 3) goto L28;
            boolean r9 = false;
        L29:
            if (r9 == true) goto L111;
            tt5.a.k("OfficeMediaFileSelector", "selectFile unsupported selectType: " + r23.selectType);
            g.b(r23);
            goto L83
        L111:
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L33
            Object r11 = Result.constructor-impl((itb.e) LarkContext.spiByDwarf(itb.e.class));     // Catch: Throwable -> L33
        L35:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L39;
            tt5.a.e("OfficeMediaFileSelector", "get IOfficeMediaApi failed", r12, false);
            r11 = null;
        L39:
            itb.e r13 = (itb.e) r11;
            if (r13 != null) goto L42;
            g.b(r23);
            goto L83
        L42:
            int r16 = r23.selectType;
            if (r16 == 1) goto L49;
            if (r16 == 3) goto L46;
        L48:
            boolean r17 = false;
        L50:
            if (r17 == false) goto L57;
            if (r23.showTakePhoto == false) goto L54;
        L59:
            boolean r18 = true;
        L60:
            if (r17 == false) goto L62;
            boolean r19 = r23.showTakeVideo;
        L67:
            boolean r110 = r19;
        L70:
            if (r17 == false) goto L72;
            int r111 = 1;
        L74:
            if (r23.checkedKeepOrigin == false) goto L76;
        L81:
            boolean r112 = true;
        L82:
            itb.g r20 = new itb.g(r111, r18, r110, r112, 72);
            j.c(new e(r23, r13, r7, r20, new f(r23, r20)));
            goto L83
        L76:
            if (r23.isOrigin == true) goto L81;
            if (r23.isOriginFile == true) goto L81;
            r112 = false;
            goto L82
        L72:
            r111 = r23.maxSelectImageNum;
            goto L74
        L62:
            int r26 = r23.mediaType;
            if (r26 == 1) goto L68;
            if (r26 == 2) goto L68;
            if (r26 == 3) goto L68;
            r19 = r23.showVideo;
        L68:
            r110 = true;
            goto L70
        L54:
            if (r23.showTakeVideo == false) goto L59;
        L58:
            r18 = false;
            goto L60
        L57:
            if (r23.mediaType != 1) goto L59;
        L46:
            if (r23.sourceType != 1) goto L48;
        L49:
            r17 = true;
        L33:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
        L28:
            r9 = true;
        L11:
            r1 = true;
        L15:
            r14 = false;
            goto L83
        }
    }

    static {
    }
}
