package com.bytedance.android.shopping.verify;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.common.utility.UIUtils;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lh3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/verify/LawHintDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LawHintDialogFragment extends DialogFragment {
    public static final /* synthetic */ int p = 0;
    public View d;
    public TextView e;
    public TextView f;
    public TextView g;
    public CheckBox h;
    public TextView i;
    public TextView j;
    public boolean k;
    public boolean l;
    public CompositeDisposable m;
    public long n;
    public Function2<? super Boolean, ? super Boolean, Unit> o;

    public static final class a {
    }

    static {
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if (this.l == true) goto L8;
        Function2<? super Boolean, ? super Boolean, Unit> r0 = this.o;
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.invoke(Boolean.valueOf(this.k), Boolean.FALSE);
        return;
    L9:
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        this.l = false;
        int r1 = lh3.b.a;
        Lazy r2 = ECSettingKeys.a;     // Catch: Exception -> L16
        int r3 = p.a;     // Catch: Exception -> L16
        Object r4 = "{\"main_title\":\"服务授权\",\"desc\":\"同意授权小店获取你的账号信息（昵称、头像信息）\",\"agree_desc\":\"已经阅读并同意%laws_placeholder及%laws_placeholder\",\"laws\":[{\"link\":\"https://school.jinritemai.com/doudian/web/article/104868?noNav=true&from=douyin_shop_detail\",\"title\":\"《平台用户协议》\"},{\"link\":\"https://school.jinritemai.com/doudian/web/article/104870?noNav=true&from=douyin_shop_detail\",\"title\":\"《平台隐私政策》\"}],\"confirm\":\"授权\",\"later\":\"下次再说\"}";
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        jj4.b r6 = jj4.b.b;     // Catch: Throwable -> L8
        Object r7 = jj4.a.a("ec_disclaimer_description_new", String.class, "{\"main_title\":\"服务授权\",\"desc\":\"同意授权小店获取你的账号信息（昵称、头像信息）\",\"agree_desc\":\"已经阅读并同意%laws_placeholder及%laws_placeholder\",\"laws\":[{\"link\":\"https://school.jinritemai.com/doudian/web/article/104868?noNav=true&from=douyin_shop_detail\",\"title\":\"《平台用户协议》\"},{\"link\":\"https://school.jinritemai.com/doudian/web/article/104870?noNav=true&from=douyin_shop_detail\",\"title\":\"《平台隐私政策》\"}],\"confirm\":\"授权\",\"later\":\"下次再说\"}", false);     // Catch: Throwable -> L8
        if (r7 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L8
    L14:
        Gson r8 = new Gson();     // Catch: Exception -> L16
        i r9 = (i) r8.fromJson((String) r7, i.class);     // Catch: Exception -> L16
    L17:
        Context r10 = getContext();
        if (r10 == null) goto L92;
        TextView r11 = this.e;
        if (r11 == null) goto L27;
        if (r9 == null) goto L25;
        String r12 = r9.f();
        if (r12 == null) goto L25;
    L26:
        r11.setText(r12);
    L25:
        int r13 = g1.a;
        r12 = g1.a.c(r10, 2131895825, new Object[0]);
    L27:
        TextView r14 = this.j;
        if (r14 == null) goto L35;
        if (r9 == null) goto L33;
        String r15 = r9.b();
        if (r15 == null) goto L33;
    L34:
        r14.setText(r15);
    L33:
        int r16 = g1.a;
        r15 = g1.a.c(r10, 2131895821, new Object[0]);
    L35:
        TextView r17 = this.f;
        if (r17 == null) goto L43;
        if (r9 == null) goto L41;
        String r18 = r9.c();
        if (r18 == null) goto L41;
    L42:
        r17.setText(r18);
    L41:
        int r19 = g1.a;
        r18 = g1.a.c(r10, 2131895822, new Object[0]);
    L43:
        TextView r20 = this.i;
        if (r20 == null) goto L52;
        if (r9 == null) goto L49;
        String r21 = r9.d();
        if (r21 == null) goto L49;
    L50:
        r20.setText(r21);
    L49:
        int r22 = g1.a;
        r21 = g1.a.c(r10, 2131895823, new Object[0]);
    L52:
        if (r9 == null) goto L55;
        String r23 = r9.a();
        if (r23 == null) goto L55;
    L56:
        if (r9 == null) goto L66;
        List r24 = r9.e();
        if (r24 == null) goto L66;
        Iterator r25 = r24.iterator();
    L61:
        if (r25.hasNext() == false) goto L66;
        String r26 = ((lh3.d) r25.next()).b();
        if (r26 != null) goto L65;
        r26 = "";
    L65:
        r23 = StringsKt.replaceFirst(r23, "%laws_placeholder", r26, false);
    L66:
        String r27 = a2.d(r23);
        if (r27 != null) goto L69;
        int r28 = g1.a;
        r27 = g1.a.c(r10, 2131895820, new Object[0]);
    L69:
        SpannableString r110 = new SpannableString(r27);
        if (r9 == null) goto L73;
        List r29 = r9.e();
        List r30 = r29;
        if (r29 == null) goto L73;
    L74:
        Iterator r31 = r30.iterator();
    L76:
        if (r31.hasNext() == false) goto L89;
        lh3.d r32 = (lh3.d) r31.next();
        if (r32 == null) goto L76;
        String r111 = r32.b();
        if (r111 == null) goto L76;
        String r33 = r32.a();
        if (r33 == null) goto L76;
        int r34 = g1.a;     // Catch: Exception -> L87
        f r112 = new f(r33, g1.a.a(r10, 2131101238), new LawHintDialogFragment$setClickableSpan$span$1(this));     // Catch: Exception -> L87
        int r35 = StringsKt.indexOf$default(r110, r111, 0, false, 6, null);     // Catch: Exception -> L87
        r110.setSpan(r112, r35, r111.length() + r35, 34);     // Catch: Exception -> L87
    L87:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L76
    L89:
        TextView r36 = this.g;
        if (r36 == null) goto L92;
        r36.setText(r110);
        r36.setMovementMethod(LinkMovementMethod.getInstance());
    L73:
        int r37 = AuthUtils.a;
        ArrayList r38 = new ArrayList();
        lh3.d r39 = new lh3.d();
        r39.e(j.c(2131895966));
        r39.c("https://school.jinritemai.com/doudian/web/article/104868?noNav=true&from=douyin_shop_detail");
        Unit r40 = Unit.INSTANCE;
        r38.add(r39);
        lh3.d r41 = new lh3.d();
        r41.e(j.c(2131895853));
        r41.c("https://school.jinritemai.com/doudian/web/article/104870?noNav=true&from=douyin_shop_detail");
        r38.add(r41);
        r30 = r38;
    L55:
        r23 = "";
    L92:
        Lazy r42 = ECAppInfoService.a;
        if (ECAppInfoService.l() == true) goto L101;
        Context r43 = getContext();
        if (r43 == null) goto L101;
        Resources r44 = th.a.f(r43);
        if (r44 == null) goto L101;
        int r45 = r44.getColor(2131100007);
        TextView r46 = this.g;
        if (r46 == null) goto L101;
        r46.setHighlightColor(r45);
    L101:
        TextView r47 = this.i;
        if (r47 == null) goto L104;
        r47.setOnClickListener(new d(this));
    L104:
        TextView r48 = this.j;
        if (r48 == null) goto L107;
        r48.setOnClickListener(new e(this));
    L107:
        S90("show");
        Dialog r49 = getDialog();
        if (r49 == null) goto L136;
        Window r50 = r49.getWindow();
        if (r50 == null) goto L137;
        WindowManager.LayoutParams r51 = r50.getAttributes();
        r51.gravity = 17;
        r51.width = (int) UIUtils.dip2Px(getContext(), 280.0f);
        r51.height = -2;
        View r52 = r50.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L116;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r53 = ThreadMethodProxy.currentThread();
        if (r53 == com.larus.home.impl.utils.c.a) goto L116;
        com.larus.home.impl.utils.c.a(r53, "getDecorView");
    L116:
        r52.setPadding(0, 0, 0, 0);
        r50.setAttributes(r51);
        return;
    L137:
        return;
    L136:
        return;
    L8:
        th = move-exception;
        Result.Companion r54 = Result.Companion;     // Catch: Exception -> L16
        Object r55 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L16
        if (Result.isFailure-impl(r55) == true) goto L13;
        r4 = r55;
    L13:
        r7 = r4;
    L16:
        r9 = null;
        goto L17
    }

    public LawHintDialogFragment() {
    }

    public final void S90(String r6) {
        in.b r0 = new in.b();
        r0.a = r6;
        if (this.n != 10) goto L5;
        int r7 = 1;
    L6:
        r0.b = r7;
        r0.post(null, null);
        return;
    L5:
        r7 = 0;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.requestFeature(1);
    L5:
        r4.setCanceledOnTouchOutside(false);
        return r4;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        this.e = (TextView) r2.findViewById(2131377400);
        this.f = (TextView) r2.findViewById(2131377397);
        this.h = (CheckBox) r2.findViewById(2131377395);
        this.g = (TextView) r2.findViewById(2131377394);
        this.j = (TextView) r2.findViewById(2131377396);
        this.i = (TextView) r2.findViewById(2131377399);
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: IllegalStateException -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);     // Catch: IllegalStateException -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L16;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L7:
        super.show(r2, r3);     // Catch: IllegalStateException -> L9
        return;
    L16:
        return;
    L9:
        ECExceptionMonitor.c("LawHintDialogFragment show exception");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Dialog r5 = getDialog();
        if (r5 == null) goto L7;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L7;
        r6.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        Context r7 = getContext();
        if (r7 == null) goto L10;
        View r8 = th.a.c(r7, 2131560665, r3, false);
    L11:
        this.d = r8;
        return r8;
    L10:
        r8 = null;
        goto L11
    }
}
