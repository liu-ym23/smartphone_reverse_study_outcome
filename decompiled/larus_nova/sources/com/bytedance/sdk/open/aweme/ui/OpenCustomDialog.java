package com.bytedance.sdk.open.aweme.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes22.dex */
public class OpenCustomDialog extends Dialog {
    Builder builder;

    public static class Builder {
        private Context context;
        private int height;
        private View mContentView;
        private String mMessage;
        private DialogInterface.OnClickListener mNegativeListener;
        private String mNegativeText;
        private boolean mOnlyConfirm;
        private DialogInterface.OnClickListener mPositiveListener;
        private String mPositiveText;

        public Builder(Context r100) {
            this.mOnlyConfirm = false;
            this.context = r100;
        }

        public static /* synthetic */ Context access$000(Builder r100) {
            return r100.context;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mMessage;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.mPositiveText;
        }

        public static /* synthetic */ DialogInterface.OnClickListener access$300(Builder r100) {
            return r100.mPositiveListener;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.mNegativeText;
        }

        public static /* synthetic */ DialogInterface.OnClickListener access$500(Builder r100) {
            return r100.mNegativeListener;
        }

        public static /* synthetic */ boolean access$600(Builder r100) {
            return r100.mOnlyConfirm;
        }

        public static /* synthetic */ View access$700(Builder r100) {
            return r100.mContentView;
        }

        public static /* synthetic */ int access$800(Builder r100) {
            return r100.height;
        }

        public OpenCustomDialog create() {
            return new OpenCustomDialog(this, null);
        }

        public Builder setContentView(View r100) {
            this.mContentView = r100;
            return this;
        }

        public Builder setHeight(int r100) {
            this.height = r100;
            return this;
        }

        public Builder setMessage(String r100) {
            this.mMessage = r100;
            return this;
        }

        public Builder setNegativeListener(DialogInterface.OnClickListener r100) {
            this.mNegativeListener = r100;
            return this;
        }

        public Builder setNegativeText(String r100) {
            this.mNegativeText = r100;
            return this;
        }

        public Builder setOnlyConfirm(boolean r100) {
            this.mOnlyConfirm = r100;
            return this;
        }

        public Builder setPositiveListener(DialogInterface.OnClickListener r100) {
            this.mPositiveListener = r100;
            return this;
        }

        public Builder setPositiveText(String r100) {
            this.mPositiveText = r100;
            return this;
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OpenCustomDialog f269622a;

        public a(OpenCustomDialog r100) {
            this.f269622a = r100;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            Builder.access$300(this.f269622a.builder).onClick(this.f269622a, 1);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OpenCustomDialog f269623a;

        public b(OpenCustomDialog r100) {
            this.f269623a = r100;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            Builder.access$500(this.f269623a.builder).onClick(this.f269623a, 0);
        }
    }

    private OpenCustomDialog(Builder r100) {
        super(Builder.access$000(r100), R.style.custom_dialog);
        this.builder = r100;
    }

    public /* synthetic */ OpenCustomDialog(Builder r100, a r101) {
        this(r100);
    }

    public static /* synthetic */ void access$000(Dialog r100) {
        super.show();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.openplatform_open_custom_dialog);
        if (TextUtils.isEmpty(Builder.access$100(this.builder)) == true) goto L5;
        ((TextView) findViewById(R.id.content_tv)).setText(Builder.access$100(this.builder));
    L5:
        TextView r101 = (TextView) findViewById(R.id.confirm);
        if (TextUtils.isEmpty(Builder.access$200(this.builder)) == true) goto L9;
        r101.setText(Builder.access$200(this.builder));
    L9:
        if (Builder.access$300(this.builder) == null) goto L11;
        r101.setOnClickListener(new a(this));
    L11:
        TextView r102 = (TextView) findViewById(R.id.cancel);
        if (TextUtils.isEmpty(Builder.access$400(this.builder)) == true) goto L15;
        r102.setText(Builder.access$400(this.builder));
    L15:
        if (Builder.access$500(this.builder) == null) goto L18;
        r102.setOnClickListener(new b(this));
    L18:
        if (Builder.access$600(this.builder) == false) goto L21;
        findViewById(R.id.vertical_divide).setVisibility(8);
        r102.setVisibility(8);
    L21:
        if (Builder.access$700(this.builder) == null) goto L24;
        FrameLayout r103 = (FrameLayout) findViewById(R.id.content_fl);
        ViewGroup.LayoutParams r104 = new ViewGroup.LayoutParams(-1, -1);
        r103.addView(Builder.access$700(this.builder), r104);
        r103.setVisibility(0);
        ((TextView) findViewById(R.id.content_tv)).setVisibility(8);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        Window r100 = getWindow();
        if (r100 == null) goto L11;
        WindowManager.LayoutParams r101 = r100.getAttributes();
        if (r101 == null) goto L11;
        if (Builder.access$800(this.builder) <= 0) goto L9;
        r101.height = Builder.access$800(this.builder);
    L10:
        r101.width = -2;
        r101.gravity = 17;
        goto L11
    L9:
        r101.height = -2;
    L11:
        super.onStart();
    }

    @Override // android.app.Dialog
    public void show() {
        INVOKESPECIAL_com_bytedance_sdk_open_aweme_ui_OpenCustomDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
    }

    public static void INVOKESPECIAL_com_bytedance_sdk_open_aweme_ui_OpenCustomDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(Dialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        access$000(r100);
        DialogLancet.afterDialogShow(r100);
    }
}
