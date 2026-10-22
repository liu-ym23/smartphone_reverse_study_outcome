package androidx.biometric;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class FingerprintDialogFragment extends DialogFragment {
    private static final int MESSAGE_DISPLAY_TIME_MS = 2000;
    static final int STATE_FINGERPRINT = 1;
    static final int STATE_FINGERPRINT_AUTHENTICATED = 3;
    static final int STATE_FINGERPRINT_ERROR = 2;
    static final int STATE_NONE = 0;
    private static final String TAG = "FingerprintFragment";
    private int mErrorTextColor;
    private ImageView mFingerprintIcon;
    final Handler mHandler;
    TextView mHelpMessageView;
    private int mNormalTextColor;
    final Runnable mResetDialogRunnable;
    BiometricViewModel mViewModel;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void startAnimation(Drawable r1) {
            if ((r1 instanceof AnimatedVectorDrawable) == false) goto L6;
            ((AnimatedVectorDrawable) r1).start();
            return;
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static int getColorErrorAttr() {
            return 2130969567;
        }
    }

    private boolean shouldAnimateForTransition(int r4, int r5) {
        if (r4 != 0) goto L7;
        if (r5 != 1) goto L7;
        return false;
    L7:
        if (r4 != 1) goto L10;
        if (r5 != 2) goto L10;
        return true;
    L10:
        if (r4 != 2) goto L13;
        if (r5 != 1) goto L13;
        return true;
    L13:
        return false;
    }

    public static FingerprintDialogFragment newInstance() {
        return new FingerprintDialogFragment();
    }

    public FingerprintDialogFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mResetDialogRunnable = new AnonymousClass1(this);
    }

    private void connectViewModel() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        BiometricViewModel r1 = (BiometricViewModel) new ViewModelProvider(r0).get(BiometricViewModel.class);
        this.mViewModel = r1;
        r1.getFingerprintDialogState().observe(this, new AnonymousClass3(this));
        this.mViewModel.getFingerprintDialogHelpMessage().observe(this, new AnonymousClass4(this));
    }

    public void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        this.mViewModel.setFingerprintDialogPreviousState(0);
        this.mViewModel.setFingerprintDialogState(1);
        this.mViewModel.setFingerprintDialogHelpMessage(getString(2131897021));
    }

    public void resetDialog() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        this.mViewModel.setFingerprintDialogState(1);
        this.mViewModel.setFingerprintDialogHelpMessage(r0.getString(2131897021));
    }

    private int getThemedColorFor(int r6) {
        Context r0 = getContext();
        FragmentActivity r1 = getActivity();
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        TypedValue r3 = new TypedValue();
        r0.getTheme().resolveAttribute(r6, r3, true);
        TypedArray r7 = r1.obtainStyledAttributes(r3.data, new int[]{r6});
        int r2 = r7.getColor(0, 0);
        r7.recycle();
        return r2;
    L8:
        return 0;
    }

    public void onCancel(DialogInterface r2) {
        super.onCancel(r2);
        this.mViewModel.setFingerprintDialogCancelPending(true);
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        connectViewModel();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mErrorTextColor = getThemedColorFor(Api26Impl.getColorErrorAttr());
    L10:
        this.mNormalTextColor = getThemedColorFor(R.attr.textColorSecondary);
        return;
    L5:
        Context r3 = getContext();
        if (r3 == null) goto L8;
        int r4 = ContextCompat.getColor(r3, 2131100574);
    L9:
        this.mErrorTextColor = r4;
        goto L10
    L8:
        r4 = 0;
        goto L9
    }

    public Dialog onCreateDialog(Bundle r7) {
        AlertDialog.Builder r8 = new AlertDialog.Builder(requireContext());
        r8.setTitle(this.mViewModel.getTitle());
        View r0 = LayoutInflater.from(r8.getContext()).inflate(2131561112, null);
        TextView r1 = (TextView) r0.findViewById(2131372567);
        if (r1 == null) goto L8;
        CharSequence r4 = this.mViewModel.getSubtitle();
        if (TextUtils.isEmpty(r4) == false) goto L7;
        r1.setVisibility(8);
        goto L8
    L7:
        r1.setVisibility(0);
        r1.setText(r4);
    L8:
        TextView r2 = (TextView) r0.findViewById(2131372560);
        if (r2 == null) goto L14;
        CharSequence r5 = this.mViewModel.getDescription();
        if (TextUtils.isEmpty(r5) == false) goto L13;
        r2.setVisibility(8);
        goto L14
    L13:
        r2.setVisibility(0);
        r2.setText(r5);
    L14:
        this.mFingerprintIcon = (ImageView) r0.findViewById(2131372564);
        this.mHelpMessageView = (TextView) r0.findViewById(2131372561);
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators()) == false) goto L17;
        CharSequence r3 = getString(2131896000);
    L18:
        r8.setNegativeButton(r3, new AnonymousClass2(this));
        r8.setView(r0);
        AlertDialog r9 = r8.create();
        r9.setCanceledOnTouchOutside(false);
        return r9;
    L17:
        r3 = this.mViewModel.getNegativeButtonText();
        goto L18
    }

    public void updateFingerprintIcon(int r4) {
        if (this.mFingerprintIcon != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L15;
        int r0 = this.mViewModel.getFingerprintDialogPreviousState();
        Drawable r1 = getAssetForTransition(r0, r4);
        if (r1 != null) goto L10;
        return;
    L10:
        this.mFingerprintIcon.setImageDrawable(r1);
        if (shouldAnimateForTransition(r0, r4) == false) goto L13;
        Api21Impl.startAnimation(r1);
    L13:
        this.mViewModel.setFingerprintDialogPreviousState(r4);
        return;
    }

    public void updateHelpMessageColor(int r3) {
        TextView r0 = this.mHelpMessageView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != 2) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        int r5 = this.mErrorTextColor;
    L11:
        r0.setTextColor(r5);
        return;
    L10:
        r5 = this.mNormalTextColor;
        goto L11
    L7:
        r4 = false;
        goto L8
    }

    public void updateHelpMessageText(CharSequence r2) {
        TextView r0 = this.mHelpMessageView;
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }

    private Drawable getAssetForTransition(int r6, int r7) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = 2131235406;
        if (r6 != 0) goto L10;
        if (r7 != 1) goto L10;
    L20:
        return ContextCompat.getDrawable(r0, r2);
    L10:
        if (r6 != 1) goto L13;
        if (r7 != 2) goto L13;
        r2 = 2131235405;
    L13:
        if (r6 != 2) goto L16;
        if (r7 == 1) goto L20;
    L16:
        if (r6 == 1) goto L18;
    L21:
        return null;
    L18:
        if (r7 != 3) goto L21;
        goto L21
    }
}
