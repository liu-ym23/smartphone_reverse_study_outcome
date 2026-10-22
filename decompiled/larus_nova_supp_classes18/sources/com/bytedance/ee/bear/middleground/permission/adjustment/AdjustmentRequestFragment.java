package com.bytedance.ee.bear.middleground.permission.adjustment;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.escape.SecretLevelEscapeViewModel;
import com.bytedance.ee.bear.middleground.permission.escape.model.Reviewer;
import com.bytedance.ee.bear.middleground.permission.secret.b0;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u001a\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0016\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J\"\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\"\u0010+\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(H\u0002J\b\u00100\u001a\u00020\u0010H\u0016J\b\u00101\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/adjustment/AdjustmentRequestFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/adjustment/BaseAdjustmentRequestViewModel;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/adjustment/BaseAdjustmentRequestViewModel;)V", "titleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "downloadMsg", "Landroid/widget/TextView;", "input", "Landroid/widget/EditText;", "doneBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "cancelBtn", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "isLoading", "", "requestFocusAndSelection", "onResume", "onViewCreated", "view", "setButtonsEnabled", "enabled", "showAvartarUi", "list", "", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/Reviewer;", "setNameView", "nameView", "name", "", "maxWidth", "", "loadIcon", "avatar", "Lcom/larksuite/component/universe_design/image/UDAvatar;", ResourceData.KEY_URL, "uerId", "onStart", "addWatermark", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdjustmentRequestFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int o = 0;
    public final BaseAdjustmentRequestViewModel h;
    public BaseTitleBar i;
    public TextView j;
    public EditText k;
    public UDButton l;
    public UDButton m;
    public boolean n;

    public static final class a {
    }

    public static final class b extends t {
        public final /* synthetic */ AdjustmentRequestFragment c;
        public final /* synthetic */ String d;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            if (this.c.n == false) goto L5;
            return;
        L5:
            ((k) org.koin.java.a.c(k.class, null, null, 6)).e(this.d, "");
        }

        public b(AdjustmentRequestFragment r1, String r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    public static final class c extends t {
        public final /* synthetic */ AdjustmentRequestFragment c;

        public c(AdjustmentRequestFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            rcb.c.d(this.c.k);
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            this.c.h.cancel();
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L9;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ AdjustmentRequestFragment a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public d(AdjustmentRequestFragment r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r4) {
            boolean r0 = false;
            if (r4 == null) goto L5;
            int r5 = r4.length();
        L6:
            AdjustmentRequestFragment r1 = this.a;
            UDButton r2 = r1.l;
            if (r2 == null) goto L14;
            if (r5 > 0) goto L10;
        L12:
            r2.setEnabled(r0);
            return;
        L10:
            if (r1.n == true) goto L12;
            r0 = true;
            goto L12
        L14:
            return;
        L5:
            r5 = 0;
            goto L6
        }
    }

    public static final class e extends t {
        public final /* synthetic */ AdjustmentRequestFragment c;

        public e(AdjustmentRequestFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            rcb.c.d(this.c.k);
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            this.c.h.cancel();
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L9;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public static final class f extends t {
        public final /* synthetic */ AdjustmentRequestFragment c;

        public f(AdjustmentRequestFragment r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            EditText r3 = this.c.k;
            if (r3 == null) goto L7;
            Editable r4 = r3.getText();
            if (r4 == null) goto L7;
            int r5 = r4.length();
        L9:
            if (r5 <= 1024) goto L12;
            Toast.showText(this.c.getContext(), 2131887385);
            return;
        L12:
            AdjustmentRequestFragment r6 = this.c;
            BaseAdjustmentRequestViewModel r0 = r6.h;
            EditText r7 = r6.k;
            if (r7 == null) goto L17;
            Editable r8 = r7.getText();
            if (r8 == null) goto L17;
            String r9 = r8.toString();
        L18:
            if (r9 != null) goto L20;
            r9 = "";
        L20:
            r0.confirm(r9);
            return;
        L17:
            r9 = null;
        L7:
            r5 = 0;
            goto L9
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ AdjustmentRequestFragment a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BaseAdjustmentRequestViewModel.AdjustmentStatus.values().length];
                r0[BaseAdjustmentRequestViewModel.AdjustmentStatus.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[BaseAdjustmentRequestViewModel.AdjustmentStatus.ADJUSTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[BaseAdjustmentRequestViewModel.AdjustmentStatus.ADJUST_SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[BaseAdjustmentRequestViewModel.AdjustmentStatus.ADJUST_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public g(AdjustmentRequestFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            BaseAdjustmentRequestViewModel.AdjustmentStatus r7 = (BaseAdjustmentRequestViewModel.AdjustmentStatus) r6;
            if (r7 != null) goto L5;
            int r0 = -1;
        L6:
            boolean r1 = true;
            if (r0 == 1) goto L56;
            String r4 = null;
            if (r0 != 2) goto L11;
            AdjustmentRequestFragment.Z90(this.a, false);
            AdjustmentRequestFragment r8 = this.a;
            r8.n = true;
            String r9 = r8.h.getLoadingToast();
            if (r9.length() > 0) goto L52;
            r1 = false;
        L52:
            if (r1 == false) goto L54;
            r4 = r9;
        L54:
            if (r4 == null) goto L65;
            Toast.showLoading(this.a.getContext(), r4);
            return;
        L65:
            return;
        L11:
            if (r0 != 3) goto L13;
            Toast.cancelLoading();
            AdjustmentRequestFragment r10 = this.a;
            r10.n = false;
            rcb.c.d(r10.k);
            String r11 = this.a.h.getSuccessToast();
            if (r11.length() > 0) goto L37;
            r1 = false;
        L37:
            if (r1 == false) goto L39;
            r4 = r11;
        L39:
            if (r4 == null) goto L58;
            Toast.showSuccessText(this.a.getContext(), r4);
        L58:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L44
            return;
        L44:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r12 = DialogFragmentLancet.sLastShowStack;
            if (r12 == null) goto L63;
            com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L63:
            return;
        L13:
            if (r0 == 4) goto L15;
            tt5.a.d("AdjustmentRequestFragment", "unknown status: " + r7);
            return;
        L15:
            Toast.cancelLoading();
            AdjustmentRequestFragment.Z90(this.a, true);
            AdjustmentRequestFragment r13 = this.a;
            r13.n = false;
            UDButton r14 = r13.l;
            if (r14 == null) goto L25;
            CharSequence r2 = r14.getText();
            if (r2 == null) goto L20;
            int r3 = r2.length();
        L21:
            if (r3 <= 0) goto L23;
            boolean r5 = true;
        L24:
            r14.setEnabled(r5);
            goto L25
        L23:
            r5 = false;
            goto L24
        L20:
            r3 = 0;
        L25:
            String r15 = this.a.h.getFailedToast();
            if (r15.length() > 0) goto L29;
            r1 = false;
        L29:
            if (r1 == false) goto L31;
            r4 = r15;
        L31:
            if (r4 == null) goto L61;
            Toast.showFailureText(this.a.getContext(), r4);
            return;
        L61:
            return;
        L56:
            Toast.cancelLoading();
            this.a.n = false;
            return;
        L5:
            r0 = a.a[r7.ordinal()];
            goto L6
        }
    }

    static {
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        View r0 = getView();
        if (r0 == null) goto L8;
        EditText r1 = (EditText) r0.findViewById(2131375324);
        if (r1 == null) goto L9;
        r1.requestFocus();
        r1.setFocusable(true);
        r1.setFocusableInTouchMode(true);
        r1.setSelection(r1.getSelectionStart());
        new Handler(Looper.getMainLooper()).postDelayed(new ig5.a(r1), 100);
        return;
    L9:
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        return;
    L9:
        return;
    }

    public AdjustmentRequestFragment(SecretLevelEscapeViewModel r1) {
        this.h = r1;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.h.onCreate();
    }

    public static final void Z90(AdjustmentRequestFragment r1, boolean r2) {
        UDButton r0 = r1.l;
        if (r0 == null) goto L5;
        r0.setEnabled(r2);
    L5:
        UDButton r3 = r1.m;
        if (r3 == null) goto L8;
        r3.setEnabled(r2);
    L8:
        EditText r4 = r1.k;
        if (r4 == null) goto L11;
        r4.setEnabled(r2);
    L11:
        BaseTitleBar r5 = r1.i;
        if (r5 == null) goto L16;
        LinearLayout r6 = r5.getLeftLayout();
        if (r6 == null) goto L16;
        r6.setEnabled(r2);
    L16:
        Dialog r7 = r1.getDialog();
        if (r7 == null) goto L19;
        r7.setCancelable(r2);
    L19:
        Dialog r8 = r1.getDialog();
        if (r8 == null) goto L23;
        r8.setCanceledOnTouchOutside(r2);
        return;
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r13, r14);
        this.i = (BaseTitleBar) r13.findViewById(2131388775);
        this.j = (TextView) r13.findViewById(2131370181);
        this.k = (EditText) r13.findViewById(2131375324);
        this.l = r13.findViewById(2131369397);
        this.m = r13.findViewById(2131365115);
        BaseTitleBar r15 = this.i;
        if (r15 == null) goto L5;
        r15.setTitle(this.h.getTitle());
    L5:
        TextView r16 = this.j;
        if (r16 == null) goto L8;
        r16.setText(this.h.getDescription());
    L8:
        EditText r17 = this.k;
        if (r17 == null) goto L11;
        r17.setHint(this.h.getInputHint());
    L11:
        List<Reviewer> r18 = this.h.getReviewers();
        View r19 = getView();
        if (r19 == null) goto L14;
        LinearLayout r110 = (LinearLayout) r19.findViewById(2131363704);
    L15:
        View r1 = getView();
        if (r1 == null) goto L18;
        LinearLayout r2 = (LinearLayout) r1.findViewById(2131363722);
    L19:
        View r3 = getView();
        if (r3 == null) goto L22;
        LinearLayout r4 = (LinearLayout) r3.findViewById(2131363748);
    L23:
        View r5 = getView();
        if (r5 == null) goto L26;
        LinearLayout r6 = (LinearLayout) r5.findViewById(2131363740);
    L28:
        if (r18.isEmpty() == false) goto L32;
        if (r110 == null) goto L119;
        r110.setVisibility(8);
    L119:
        BaseTitleBar r111 = this.i;
        if (r111 == null) goto L122;
        r111.setLeftClickListener(new c(this));
    L122:
        EditText r112 = this.k;
        if (r112 == null) goto L125;
        r112.addTextChangedListener(new d(this));
    L125:
        UDButton r113 = this.m;
        if (r113 == null) goto L128;
        r113.setOnClickListener(new e(this));
    L128:
        UDButton r114 = this.l;
        if (r114 == null) goto L131;
        r114.setOnClickListener(new f(this));
    L131:
        this.h.getStatus().observe(this, new g(this));
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).j(this.h.getToken(), this.h.getType(), getDialog());
        return;
    L32:
        if (r110 == null) goto L34;
        r110.setVisibility(0);
    L34:
        if (r2 == null) goto L36;
        r2.setVisibility(8);
    L36:
        if (r4 == null) goto L38;
        r4.setVisibility(8);
    L38:
        if (r6 == null) goto L40;
        r6.setVisibility(8);
    L40:
        Iterator<Reviewer> r115 = r18.iterator();
        int r7 = 0;
    L42:
        if (r115.hasNext() == false) goto L119;
        Reviewer r8 = r115.next();
        if (r8.getUserAvatarTosUrl().length() != 0) goto L46;
        boolean r9 = true;
    L47:
        if (r9 == true) goto L118;
        int r10 = b0.b(r18.size());
        if (r7 == 0) goto L97;
        if (r7 != 1) goto L53;
        if (r4 == null) goto L78;
        r4.setVisibility(0);
    L78:
        if (r4 == null) goto L80;
        UDAvatar r11 = (UDAvatar) r4.findViewById(2131392467);
    L82:
        if ((r11 instanceof UDAvatar) == true) goto L85;
        r11 = null;
    L85:
        aa0(r11, r8.getUserAvatarTosUrl(), r8.getUserId());
        if (r4 == null) goto L88;
        TextView r12 = (TextView) r4.findViewById(2131363719);
    L90:
        if ((r12 instanceof TextView) == true) goto L93;
        r12 = null;
    L93:
        String r20 = r8.getUserName();
        if (r12 == null) goto L118;
        r12.setText(r20);
        r12.setMaxWidth(r10);
        goto L118
    L88:
        r12 = null;
        goto L90
    L80:
        r11 = null;
        goto L82
    L53:
        if (r7 != 2) goto L118;
        if (r6 == null) goto L57;
        r6.setVisibility(0);
    L57:
        if (r6 == null) goto L59;
        UDAvatar r21 = (UDAvatar) r6.findViewById(2131392467);
    L61:
        if ((r21 instanceof UDAvatar) == true) goto L64;
        r21 = null;
    L64:
        aa0(r21, r8.getUserAvatarTosUrl(), r8.getUserId());
        if (r6 == null) goto L67;
        TextView r22 = (TextView) r6.findViewById(2131363719);
    L69:
        if ((r22 instanceof TextView) == true) goto L72;
        r22 = null;
    L72:
        String r23 = r8.getUserName();
        if (r22 == null) goto L118;
        r22.setText(r23);
        r22.setMaxWidth(r10);
        goto L118
    L67:
        r22 = null;
        goto L69
    L59:
        r21 = null;
        goto L61
    L97:
        if (r2 == null) goto L99;
        r2.setVisibility(0);
    L99:
        if (r2 == null) goto L101;
        UDAvatar r24 = (UDAvatar) r2.findViewById(2131392467);
    L103:
        if ((r24 instanceof UDAvatar) == true) goto L106;
        r24 = null;
    L106:
        aa0(r24, r8.getUserAvatarTosUrl(), r8.getUserId());
        if (r2 == null) goto L109;
        TextView r25 = (TextView) r2.findViewById(2131363719);
    L111:
        if ((r25 instanceof TextView) == true) goto L114;
        r25 = null;
    L114:
        String r26 = r8.getUserName();
        if (r25 == null) goto L118;
        r25.setText(r26);
        r25.setMaxWidth(r10);
        goto L118
    L109:
        r25 = null;
        goto L111
    L101:
        r24 = null;
    L118:
        r7 = r7 + 1;
        goto L42
    L46:
        r9 = false;
        goto L47
    L26:
        r6 = null;
        goto L28
    L22:
        r4 = null;
        goto L23
    L18:
        r2 = null;
        goto L19
    L14:
        r110 = null;
        goto L15
    }

    public final void aa0(UDAvatar r3, String r4, String r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        Glide.with(this).load(new BearGlideUrl(r4)).placeholder(2131235295).into(r3);
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r3.setOnClickListener(new b(this, r5));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564173, r3, false);
    }
}
