package xv0;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.a0;
import com.bytedance.android.live.recharge.deal.d;
import com.bytedance.android.live.recharge.deal.e;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.j;
import com.bytedance.android.live.recharge.platform.core.keyboard.LiveRechargeKeyBoardView;
import com.bytedance.android.live.recharge.viewmodel.CustomRechargeViewModel;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements dx0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditText f565141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.live.recharge.core.b f565142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CustomRechargeViewModel f565143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RechargeDialogContext f565144d;

    @Override // dx0.a
    public final void onDelete() {
        EditText r100 = this.f565141a;
        if (r100 == null) goto L9;
        int r101 = r100.getSelectionEnd();
        if (r101 > 0) goto L7;
        return;
    L7:
        r100.getText().delete(r101 - 1, r101);
        return;
    }

    @Override // dx0.a
    public final void onDone() {
        EditText r100 = this.f565141a;
        if (r100 == null) goto L25;
        d r101 = null;
        if (TextUtils.isEmpty(r100.getText()) == false) goto L8;
        this.f565143c.getSelectedCustomDeal().postValue(null);
        return;
    L8:
        Editable r102 = r100.getText();
        if (r102 == null) goto L13;
        String r103 = r102.toString();
        if (r103 == null) goto L13;
        long r104 = (long) (CastLongProtector.parseLong(r103) * 100.0f);
    L14:
        RechargeDialogContext r105 = this.f565144d;
        if (r105 == null) goto L23;
        a0 r106 = r105.getRepository();
        if (r106 == null) goto L23;
        PropertyOwner r107 = r106.C;
        if (r107 == null) goto L23;
        i r108 = (i) r107.f64752a;
        if (r108 == null) goto L23;
        r101 = j.a(r108, r104, false, 6);
    L23:
        this.f565143c.getSelectedCustomDeal().postValue(r101);
        return;
    L13:
        r104 = 0;
        goto L14
    }

    @Override // dx0.a
    public final void a() {
        Context r100 = s1.getContext();
        if (r100 == null) goto L5;
        Object r101 = r100.getSystemService("vibrator");
    L6:
        if (r101 == null) goto L10;
        ((Vibrator) r101).vibrate(15);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    L5:
        r101 = null;
        goto L6
    }

    @Override // dx0.a
    public final void onInput(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        EditText r101 = this.f565141a;
        if (r101 == null) goto L6;
        int r102 = r101.getSelectionEnd();
        r101.getText().insert(r102, r100);
        return;
    }

    public c(CustomRechargeViewModel r100, RechargeDialogContext r101) {
        Intrinsics.checkNotNullParameter(r100, "mViewModel");
        this.f565143c = r100;
        this.f565144d = r101;
    }

    public final void b(LiveRechargeKeyBoardView r100, EditText r101) {
        if (r100 == null) goto L4;
        r100.setKeyboardListener(this);
    L4:
        this.f565141a = r101;
        if (r101 == null) goto L7;
        r101.requestFocus();
    L7:
        EditText r102 = this.f565141a;
        if (r102 == null) goto L10;
        r102.setLongClickable(false);
    L10:
        int r103 = com.bytedance.android.live.recharge.util.b.f90423a;
        EditText r104 = this.f565141a;
        IBinder r105 = null;
        if (r104 == null) goto L13;
        Context r106 = r104.getContext();
    L14:
        Activity r107 = ContextUtil.contextToActivity(r106);
        if (r107 == null) goto L40;
        FragmentActivity r108 = (FragmentActivity) r107;
        Intrinsics.checkNotNullParameter(r108, "activity");
        r108.getWindow().setSoftInputMode(3);
        Method r109 = EditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L19
        r109.setAccessible(true);     // Catch: Exception -> L19
        r109.invoke(r104, new Object[]{Boolean.FALSE});     // Catch: Exception -> L19
    L21:
        EditText r110 = this.f565141a;
        if (r110 == null) goto L24;
        Context r111 = r110.getContext();
    L25:
        Activity r112 = ContextUtil.contextToActivity(r111);
        if (r112 == null) goto L28;
        Object r113 = r112.getSystemService("input_method");
    L30:
        if ((r113 instanceof InputMethodManager) == false) goto L35;
        InputMethodManager r114 = (InputMethodManager) r113;
        EditText r115 = this.f565141a;
        if (r115 == null) goto L34;
        r105 = r115.getWindowToken();
    L34:
        r114.hideSoftInputFromWindow(r105, 0);
    L35:
        long r116 = e.b(this.f565143c.getCustomChargeDeals().getValue());
        EditText r117 = this.f565141a;
        if (r117 == null) goto L43;
        r117.addTextChangedListener(new b(r117, this, r116));
        return;
    L43:
        return;
    L28:
        r113 = null;
        goto L30
    L24:
        r111 = null;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L40:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L13:
        r106 = null;
        goto L14
    }
}
