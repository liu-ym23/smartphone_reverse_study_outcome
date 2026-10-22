package com.bytedance.android.livesdk.linkvideo.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.utils.v6;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/ui/LinkVideoIntroduceDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkVideoIntroduceDialog extends LiveDialogFragment {
    public static String l;
    public static boolean m;
    public Button d;
    public ViewGroup e;
    public RecyclerView f;
    public ImageView g;
    public View h;
    public LinkVideoListAdapter i;
    public String j;
    public boolean k;

    public static final class a {
    }

    static {
        m = true;
    }

    public LinkVideoIntroduceDialog() {
        this.j = "";
    }

    public final void onDestroyView() {
        super.onDestroyView();
        l = null;
        m = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        int r0 = s1.f(484.0f);
        Dialog r1 = getDialog();
        if (r1 == null) goto L8;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L9;
        r2.setLayout(-1, r0);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954580);
        this.j = v6.a();
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        int r0 = 0;
        View r6 = r3.inflate(2131565592, r4, false);
        this.d = (Button) r6.findViewById(2131378029);
        this.e = (ViewGroup) r6.findViewById(2131378030);
        this.f = r6.findViewById(2131378032);
        this.h = r6.findViewById(2131380628);
        this.g = (ImageView) r6.findViewById(2131363762);
        Button r7 = this.d;
        if (r7 == null) goto L5;
        r7.setOnClickListener(new f(this));
    L5:
        ImageView r8 = this.g;
        if (r8 == null) goto L8;
        r8.setOnClickListener(new g(this));
    L8:
        ViewGroup r9 = this.e;
        if (r9 != null) goto L11;
    L15:
        ImageView r10 = this.g;
        if (r10 != null) goto L18;
    L22:
        View r11 = this.h;
        if (r11 != null) goto L25;
    L29:
        RecyclerView r12 = this.f;
        if (r12 == null) goto L81;
        r12.addOnScrollListener(new LinkVideoIntroduceDialog$initView$3(this));
    L81:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L46
        List r14 = (List) GsonHelper.get().fromJson(l, new e().getType());     // Catch: Throwable -> L46
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L46
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L46
    L34:
        if (r16.hasNext() == false) goto L38;
        List<hf2.b> r1 = ((hf2.c) r16.next()).a();     // Catch: Throwable -> L46
        if (r1 == null) goto L34;
        r15.addAll(r1);     // Catch: Throwable -> L46
        goto L34
    L38:
        this.i = new LinkVideoListAdapter(getContext(), r15);     // Catch: Throwable -> L46
        RecyclerView r17 = this.f;     // Catch: Throwable -> L46
        if (r17 == null) goto L41;
        r17.setLayoutManager(new LinearLayoutManager(getContext()));     // Catch: Throwable -> L46
    L41:
        RecyclerView r18 = this.f;     // Catch: Throwable -> L46
        if (r18 == null) goto L44;
        r18.setAdapter(this.i);     // Catch: Throwable -> L46
    L44:
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L48:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 != null) goto L79;
    L57:
        Dialog r21 = getDialog();
        WindowManager.LayoutParams r22 = null;
        if (r21 == null) goto L60;
        Window r23 = r21.getWindow();
    L61:
        if (r23 == null) goto L63;
        r22 = r23.getAttributes();
    L63:
        if (r22 == null) goto L65;
        r22.gravity = 80;
    L65:
        if (r22 == null) goto L67;
        r22.width = -1;
    L67:
        if (r23 == null) goto L69;
        r23.setAttributes(r22);
    L69:
        IRoomModuleService r24 = k.f(IRoomModuleService.class);
        if (r24 == null) goto L78;
        com.bytedance.android.livesdk.linkvideo.b r25 = r24.getLinkVideoTea();
        if (r25 == null) goto L78;
        if (m == false) goto L76;
        String r26 = "auto_play";
    L77:
        r25.k(r26, this.j);
        goto L78
    L76:
        r26 = "active_click";
    L78:
        return r6;
    L60:
        r23 = null;
        goto L61
    L79:
        dismiss();     // Catch: Exception -> L52
    L56:
        ALogger.e("LinkVideoIntroduceDialog", r20);
    L52:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r27 = DialogFragmentLancet.sLastShowStack;
        if (r27 == null) goto L56;
        com.bytedance.crash.d.d(r27, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L46:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L25:
        if (m == false) goto L28;
        r0 = 8;
    L28:
        r11.setVisibility(r0);
        goto L29
    L18:
        if (m == true) goto L20;
        int r2 = 0;
    L21:
        r10.setVisibility(r2);
        goto L22
    L20:
        r2 = 8;
        goto L21
    L11:
        if (m == false) goto L13;
        int r29 = 0;
    L14:
        r9.setVisibility(r29);
        goto L15
    L13:
        r29 = 8;
        goto L14
    }
}
