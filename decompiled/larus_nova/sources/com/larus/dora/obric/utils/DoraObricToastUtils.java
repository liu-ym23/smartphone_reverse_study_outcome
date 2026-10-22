package com.larus.dora.obric.utils;

import android.content.Context;
import com.larus.nova.R;
import com.larus.utils.t0;
import com.obric.oui.toast.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraObricToastUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<f> f340969a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/obric/utils/DoraObricToastUtils$ToastIcon;", "", "drawableRes", "", "tintColorRes", "<init>", "(Ljava/lang/String;IILjava/lang/Integer;)V", "getDrawableRes", "()I", "getTintColorRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Success", "Failure", "Warning", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ToastIcon extends Enum<ToastIcon> {
        public static final ToastIcon Failure = null;
        public static final ToastIcon Success = null;
        public static final ToastIcon Warning = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ToastIcon[] f340970a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f340971b = null;
        private final int drawableRes;
        private final Integer tintColorRes;

        public static EnumEntries<ToastIcon> getEntries() {
            return f340971b;
        }

        static {
            ToastIcon r100 = new ToastIcon("Success", 0, R.drawable.o_icon_toast_success, null, 2, null);
            Success = r100;
            ToastIcon r101 = new ToastIcon("Failure", 1, R.drawable.o_icon_toast_failed, null, 2, null);
            Failure = r101;
            ToastIcon r102 = new ToastIcon("Warning", 2, R.drawable.oui_icon_oic_exclamation_mark_circle_fill, Integer.valueOf(R.color.oui_functional_orange_6));
            Warning = r102;
            ToastIcon[] r103 = {r100, r101, r102};
            f340970a = r103;
            f340971b = EnumEntriesKt.enumEntries(r103);
        }

        public static ToastIcon[] values() {
            return (ToastIcon[]) f340970a.clone();
        }

        public final int getDrawableRes() {
            return this.drawableRes;
        }

        public final Integer getTintColorRes() {
            return this.tintColorRes;
        }

        public static ToastIcon valueOf(String r100) {
            return (ToastIcon) r27.a.a(ToastIcon.class, r100);
        }

        public ToastIcon(String r100, int r101, int r102, Integer r103) {
            super(r100, r101);
            this.drawableRes = r102;
            this.tintColorRes = r103;
        }

        public /* synthetic */ ToastIcon(String r100, int r101, int r102, Integer r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 2) == 0) goto L5;
            r103 = null;
        L5:
            this(r100, r101, r102, r103);
        }
    }

    static {
        f340969a = new WeakReference(null);
    }

    public static void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ToastIcon r101 = ToastIcon.Success;
        c(r100, r100.getString(R.string.larus_text_copied_tip), r101);
    }

    public static void a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ToastIcon r102 = ToastIcon.Failure;
        c(r100, r100.getString(r101), r102);
    }

    public static void b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        c(r100, r101, ToastIcon.Failure);
    }

    public static void e(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ToastIcon r102 = ToastIcon.Warning;
        c(r100, r100.getString(r101), r102);
    }

    public static void c(final Context r100, final String r101, final ToastIcon r102) {
        t0.e(new d(r100, r101, r102));
    }
}
