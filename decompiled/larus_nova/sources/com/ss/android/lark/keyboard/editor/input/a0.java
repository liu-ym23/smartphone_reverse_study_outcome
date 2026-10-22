package com.ss.android.lark.keyboard.editor.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f428868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f428869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f428870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f428871d;

    public static final class a {
    }

    static {
    }

    public final View getReEditBtnCancel() {
        return this.f428870c;
    }

    public final View getReEditBtnConfirm() {
        return this.f428871d;
    }

    public final View getReEditBtnGroup() {
        return this.f428869b;
    }

    public final View getSendBtn() {
        return this.f428868a;
    }

    public a0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setId(R.id.btn_send);
        View r101 = com.ss.android.lark.keyboard.utils.h.b(r100);
        this.f428868a = r101;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.kb_richtext_btn_reedit_assembler, this, false);
        this.f428869b = r102;
        this.f428870c = r102.findViewById(R.id.btn_cancel);
        this.f428871d = r102.findViewById(R.id.btn_confirm);
        addView(r101);
        addView(r102);
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        r104.gravity = 17;
        r101.setLayoutParams(r104);
        ViewGroup.LayoutParams r105 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105;
        r106.gravity = 17;
        r102.setLayoutParams(r106);
        a(1);
    }

    public final void a(int r100) {
        if (r100 <= 2) goto L5;
    L21:
        Log.w("RichTextSendBtnCompat", "changeMode: invalid mode");
        return;
    L5:
        if (r100 < 1) goto L21;
        int r101 = 0;
        if (r100 != 1) goto L10;
        boolean r102 = true;
    L11:
        View r103 = this.f428868a;
        if (r102 == false) goto L14;
        int r104 = 0;
    L15:
        r103.setVisibility(r104);
        View r105 = this.f428869b;
        if ((!r102) == true) goto L19;
        r101 = 8;
    L19:
        r105.setVisibility(r101);
        return;
    L14:
        r104 = 8;
        goto L15
    L10:
        r102 = false;
        goto L11
    }
}
