package com.ss.android.lark.todo.impl.features.common.helper;

import android.content.Context;
import android.view.View;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class OperationToastHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OperationToastHelper f442443a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/helper/OperationToastHelper$ToastType;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAIL", "PROMPT", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ToastType extends Enum<ToastType> {
        public static final ToastType FAIL = null;
        public static final ToastType PROMPT = null;
        public static final ToastType SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ToastType[] f442444a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f442445b = null;

        public static EnumEntries<ToastType> getEntries() {
            return f442445b;
        }

        static {
            ToastType r100 = new ToastType("SUCCESS", 0);
            SUCCESS = r100;
            ToastType r101 = new ToastType("FAIL", 1);
            FAIL = r101;
            ToastType r102 = new ToastType("PROMPT", 2);
            PROMPT = r102;
            ToastType[] r103 = {r100, r101, r102};
            f442444a = r103;
            f442445b = EnumEntriesKt.enumEntries(r103);
        }

        public static ToastType[] values() {
            return (ToastType[]) f442444a.clone();
        }

        public static ToastType valueOf(String r100) {
            return (ToastType) r27.a.a(ToastType.class, r100);
        }

        public ToastType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f442446a = null;

        static {
            int[] r100 = new int[ToastType.values().length];
            r100[ToastType.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ToastType.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ToastType.PROMPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f442446a = r100;
        }
    }

    static {
        f442443a = new OperationToastHelper();
    }

    public OperationToastHelper() {
    }

    public static void c(Context r110, int r111, String r112, int r113) {
        OperationToastHelper r100 = f442443a;
        if ((r113 & 4) == 0) goto L5;
        r112 = null;
    L5:
        ToastType r101 = ToastType.PROMPT;
        d(r100, r110, r101, r111, null, null, null, r112, null, null, 384);
    }

    public static /* synthetic */ void b(Context r100, int r101, String r102, Integer r110, Integer r111, int r112) {
        OperationToastHelper r103 = f442443a;
        if ((r112 & 4) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r112 & 8) == 0) goto L9;
        Integer r105 = null;
    L11:
        if ((r112 & 16) == 0) goto L13;
        Integer r106 = null;
    L14:
        r103.a(r100, r101, r104, r105, r106, null);
        return;
    L13:
        r106 = r111;
        goto L14
    L9:
        r105 = r110;
        goto L11
    L5:
        r104 = r102;
        goto L7
    }

    public static /* synthetic */ void f(Context r100, int r101, Integer r110, Integer r111, Integer r112, int r113) {
        OperationToastHelper r102 = f442443a;
        if ((r113 & 4) == 0) goto L5;
        Integer r103 = null;
    L7:
        if ((r113 & 8) == 0) goto L9;
        Integer r104 = null;
    L11:
        if ((r113 & 16) == 0) goto L13;
        Integer r105 = null;
    L14:
        r102.e(r100, r101, r103, r104, r105, null, null);
        return;
    L13:
        r105 = r112;
        goto L14
    L9:
        r104 = r111;
        goto L11
    L5:
        r103 = r110;
        goto L7
    }

    public final void a(Context r110, int r111, String r112, Integer r113, Integer r114, Integer r115) {
        d(this, r110, ToastType.FAIL, r111, r113, r114, r115, r112, null, null, 384);
    }

    public final void e(Context r110, int r111, Integer r112, Integer r113, Integer r114, String r115, View.OnClickListener r116) {
        d(this, r110, ToastType.SUCCESS, r111, r112, r113, r114, null, r115, r116, 64);
    }

    public static void d(OperationToastHelper r100, Context r101, ToastType r102, int r103, Integer r104, Integer r105, Integer r106, String r107, String r110, View.OnClickListener r111, int r112) {
        if ((r112 & 8) == 0) goto L6;
        r104 = null;
    L6:
        if ((r112 & 16) == 0) goto L9;
        r105 = null;
    L9:
        if ((r112 & 32) == 0) goto L12;
        r106 = null;
    L12:
        if ((r112 & 64) == 0) goto L15;
        r107 = null;
    L15:
        if ((r112 & 128) == 0) goto L18;
        r110 = null;
    L18:
        if ((r112 & 256) == 0) goto L20;
        r111 = null;
    L20:
        r100.getClass();
        if (r101 == null) goto L47;
        int r108 = a.f442446a[r102.ordinal()];
        if (r108 != 1) goto L26;
        int r109 = R.drawable.ud_icon_yes_outlined;
    L34:
        LKUIToast.cancelLoading();
        UDToast.a r113 = UDToast.build(r101);
        r113.d(r109);
        FlowToast.a r114 = r113.f285429b;
        r114.f417630d = -1;
        if (r107 == null) goto L37;
        r113.g(r107);
    L38:
        if (r104 == null) goto L42;
        if (r105 == null) goto L42;
        if (r106 == null) goto L42;
        r113.f285429b.c(r104.intValue(), r105.intValue(), r106.intValue());
    L42:
        if (r110 == null) goto L45;
        if (r111 == null) goto L45;
        r113.c(r110, new e(r111));
    L45:
        com.bytedance.ee.lark.infra.foundation.utils.c.a(new f(r113));
        return;
    L37:
        r114.e(r103);
        goto L38
    L26:
        if (r108 != 2) goto L28;
        r109 = R.drawable.ud_icon_more_close_outlined;
        goto L34
    L28:
        if (r108 != 3) goto L31;
        r109 = R.drawable.ud_icon_warning_outlined;
        goto L34
    L31:
        throw new NoWhenBranchMatchedException();
    }
}
