package com.bytedance.dux.dialog.alert;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.button.DuxButton;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class ButtonStyleController implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f204911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DuxButton f204912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DuxButton f204913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DuxButton f204914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f204915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f204916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f204917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f204918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f204919i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/dux/dialog/alert/ButtonStyleController$ButtonStyle;", "", "dux_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ButtonStyle {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/dux/dialog/alert/ButtonStyleController$TextColorType;", "", "TextReverse", "TextReverse2", "Negative", "dux_release"}, k = 1, mv = {1, 7, 1})
    public static final enum TextColorType extends Enum<TextColorType> {
        public static final TextColorType Negative = null;
        public static final TextColorType TextReverse = null;
        public static final TextColorType TextReverse2 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TextColorType[] f204920a = null;

        public static TextColorType valueOf(String r100) {
            return (TextColorType) r27.a.a(TextColorType.class, r100);
        }

        public static TextColorType[] values() {
            return (TextColorType[]) f204920a.clone();
        }

        static {
            TextColorType r100 = new TextColorType("TextReverse", 0);
            TextReverse = r100;
            TextColorType r101 = new TextColorType("TextReverse2", 1);
            TextReverse2 = r101;
            TextColorType r102 = new TextColorType("Negative", 2);
            Negative = r102;
            f204920a = new TextColorType[]{r100, r101, r102};
        }

        public TextColorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204921a = null;

        static {
            int[] r100 = new int[TextColorType.values().length];
            r100[TextColorType.Negative.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TextColorType.TextReverse.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TextColorType.TextReverse2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f204921a = r100;
        }
    }

    static {
    }

    public ButtonStyleController(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f204911a = 0;
    }

    public static final void b(ButtonStyleController r100) {
        d r101 = r100.f204917g;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L34;
        if (r101 == null) goto L28;
        Handler r103 = DialogLancet.resolveDialogHandler(r101);
        if (r103 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r104 == null) goto L25;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L14:
        if (Looper.myLooper() == r103.getLooper()) goto L16;
        r103.post(DialogLancet.createDismissRunnable(r101));
        return;
    L28:
        return;
    L34:
        return;
    L5:
        if (r101.f204935r == true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.dux.dialog.alert.h
    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        this.f204917g = r100;
    }

    public static void c(DuxButton r100, TextColorType r101) {
        if (r101 == null) goto L16;
        int r102 = b.f204921a[r101.ordinal()];
        if (r102 != 1) goto L6;
        int r103 = R.color.Negative;
    L14:
        r100.setTextColor(ContextCompat.getColor(r100.getContext(), r103));
        return;
    L6:
        if (r102 != 2) goto L8;
        r103 = R.color.TextReverse;
        goto L14
    L8:
        if (r102 != 3) goto L11;
        r103 = R.color.TextReverse2;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }
}
