package androidx.biometric;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.crash.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class BiometricFragment extends Fragment {
    static final int CANCELED_FROM_CLIENT = 3;
    static final int CANCELED_FROM_INTERNAL = 0;
    static final int CANCELED_FROM_NEGATIVE_BUTTON = 2;
    static final int CANCELED_FROM_USER = 1;
    private static final int DISMISS_INSTANTLY_DELAY_MS = 500;
    private static final String FINGERPRINT_DIALOG_FRAGMENT_TAG = "androidx.biometric.FingerprintDialogFragment";
    private static final int HIDE_DIALOG_DELAY_MS = 2000;
    private static final int REQUEST_CONFIRM_CREDENTIAL = 1;
    private static final int SHOW_PROMPT_DELAY_MS = 600;
    private static final String TAG = "BiometricFragment";
    Handler mHandler;
    BiometricViewModel mViewModel;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Intent createConfirmDeviceCredentialIntent(KeyguardManager r0, CharSequence r1, CharSequence r2) {
            return r0.createConfirmDeviceCredentialIntent(r1, r2);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static BiometricPrompt buildPrompt(BiometricPrompt.Builder r0) {
            return r0.build();
        }

        public static BiometricPrompt.Builder createPromptBuilder(Context r1) {
            return new BiometricPrompt.Builder(r1);
        }

        public static void setDescription(BiometricPrompt.Builder r0, CharSequence r1) {
            r0.setDescription(r1);
        }

        public static void setSubtitle(BiometricPrompt.Builder r0, CharSequence r1) {
            r0.setSubtitle(r1);
        }

        public static void setTitle(BiometricPrompt.Builder r0, CharSequence r1) {
            r0.setTitle(r1);
        }

        public static void authenticate(BiometricPrompt r0, CancellationSignal r1, Executor r2, BiometricPrompt.AuthenticationCallback r3) {
            r0.authenticate(r1, r2, r3);
        }

        public static void setNegativeButton(BiometricPrompt.Builder r0, CharSequence r1, Executor r2, DialogInterface.OnClickListener r3) {
            r0.setNegativeButton(r1, r2, r3);
        }

        public static void authenticate(BiometricPrompt r0, BiometricPrompt.CryptoObject r1, CancellationSignal r2, Executor r3, BiometricPrompt.AuthenticationCallback r4) {
            r0.authenticate(r1, r2, r3, r4);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void setConfirmationRequired(BiometricPrompt.Builder r0, boolean r1) {
            r0.setConfirmationRequired(r1);
        }

        public static void setDeviceCredentialAllowed(BiometricPrompt.Builder r0, boolean r1) {
            r0.setDeviceCredentialAllowed(r1);
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static void setAllowedAuthenticators(BiometricPrompt.Builder r0, int r1) {
            r0.setAllowedAuthenticators(r1);
        }
    }

    public static class PromptExecutor implements Executor {
        private final Handler mPromptHandler;

        public PromptExecutor() {
            this.mPromptHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r2) {
            this.mPromptHandler.post(r2);
        }
    }

    public static class ShowPromptForAuthenticationRunnable implements Runnable {
        private final WeakReference<BiometricFragment> mFragmentRef;

        @Override // java.lang.Runnable
        public void run() {
            androidx_biometric_BiometricFragment$ShowPromptForAuthenticationRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_biometric_BiometricFragment$ShowPromptForAuthenticationRunnable__run$___twin___() {
            if (this.mFragmentRef.get() == null) goto L6;
            this.mFragmentRef.get().showPromptForAuthentication();
            return;
        }

        public ShowPromptForAuthenticationRunnable(BiometricFragment r2) {
            this.mFragmentRef = new WeakReference(r2);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_biometric_BiometricFragment$ShowPromptForAuthenticationRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ShowPromptForAuthenticationRunnable r1) {
            r1.androidx_biometric_BiometricFragment$ShowPromptForAuthenticationRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class StopDelayingPromptRunnable implements Runnable {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        @Override // java.lang.Runnable
        public void run() {
            androidx_biometric_BiometricFragment$StopDelayingPromptRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_biometric_BiometricFragment$StopDelayingPromptRunnable__run$___twin___() {
            if (this.mViewModelRef.get() == null) goto L6;
            this.mViewModelRef.get().setDelayingPrompt(false);
            return;
        }

        public StopDelayingPromptRunnable(BiometricViewModel r2) {
            this.mViewModelRef = new WeakReference(r2);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_biometric_BiometricFragment$StopDelayingPromptRunnable_com_larus_apm_impl_protector_RunnableLancet_run(StopDelayingPromptRunnable r1) {
            r1.androidx_biometric_BiometricFragment$StopDelayingPromptRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class StopIgnoringCancelRunnable implements Runnable {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        @Override // java.lang.Runnable
        public void run() {
            androidx_biometric_BiometricFragment$StopIgnoringCancelRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_biometric_BiometricFragment$StopIgnoringCancelRunnable__run$___twin___() {
            if (this.mViewModelRef.get() == null) goto L6;
            this.mViewModelRef.get().setIgnoringCancel(false);
            return;
        }

        public StopIgnoringCancelRunnable(BiometricViewModel r2) {
            this.mViewModelRef = new WeakReference(r2);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_biometric_BiometricFragment$StopIgnoringCancelRunnable_com_larus_apm_impl_protector_RunnableLancet_run(StopIgnoringCancelRunnable r1) {
            r1.androidx_biometric_BiometricFragment$StopIgnoringCancelRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private void dismissFingerprintDialog() {
        this.mViewModel.setPromptShowing(false);
        if (isAdded() == false) goto L11;
        FragmentManager r0 = getParentFragmentManager();
        FingerprintDialogFragment r1 = r0.findFragmentByTag(FINGERPRINT_DIALOG_FRAGMENT_TAG);
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isAdded() == false) goto L9;
        INVOKEVIRTUAL_androidx_biometric_BiometricFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r1);
        return;
    L9:
        r0.beginTransaction().remove(r1).commitAllowingStateLoss();
        return;
    }

    private boolean isFingerprintDialogNeededForErrorHandling() {
        if (Build.VERSION.SDK_INT == 28) goto L5;
    L7:
        return false;
    L5:
        if (PackageUtils.hasSystemFeatureFingerprint(getContext()) == true) goto L7;
        return true;
    }

    private boolean isUsingFingerprintDialog() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
    L10:
        return true;
    L5:
        if (isFingerprintDialogNeededForCrypto() == true) goto L10;
        if (isFingerprintDialogNeededForErrorHandling() == true) goto L10;
        return false;
    }

    public static BiometricFragment newInstance() {
        return new BiometricFragment();
    }

    private void sendFailureToClient() {
        if (this.mViewModel.isAwaitingResult() == true) goto L5;
        return;
    L5:
        this.mViewModel.getClientExecutor().execute(new AnonymousClass11(this));
    }

    public void dismiss() {
        this.mViewModel.setPromptShowing(false);
        dismissFingerprintDialog();
        if (this.mViewModel.isConfirmingDeviceCredential() == false) goto L5;
    L7:
        Context r0 = getContext();
        if (r0 != null) goto L10;
        return;
    L10:
        if (DeviceUtils.shouldDelayShowingPrompt(r0, Build.MODEL) == false) goto L14;
        this.mViewModel.setDelayingPrompt(true);
        this.mHandler.postDelayed(new StopDelayingPromptRunnable(this.mViewModel), 600);
        return;
    L14:
        return;
    L5:
        if (isAdded() == false) goto L7;
        getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        goto L7
    }

    public boolean isManagingDeviceCredentialButton() {
        if (Build.VERSION.SDK_INT <= 28) goto L5;
    L7:
        return false;
    L5:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators()) == false) goto L7;
        return true;
    }

    public void onCancelButtonPressed() {
        CharSequence r0 = this.mViewModel.getNegativeButtonText();
        if (r0 != null) goto L6;
        r0 = getString(2131896083);
    L6:
        sendErrorAndDismiss(13, r0);
        cancelAuthentication(2);
    }

    public void showPromptForAuthentication() {
        if (this.mViewModel.isPromptShowing() == false) goto L5;
        return;
    L5:
        if (getContext() != null) goto L7;
        return;
    L7:
        this.mViewModel.setPromptShowing(true);
        this.mViewModel.setAwaitingResult(true);
        if (isUsingFingerprintDialog() == false) goto L10;
        showFingerprintDialogForAuthentication();
        return;
    L10:
        showBiometricPromptForAuthentication();
    }

    public BiometricFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    private void connectViewModel() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        BiometricViewModel r0 = (BiometricViewModel) new ViewModelProvider(getActivity()).get(BiometricViewModel.class);
        this.mViewModel = r0;
        r0.getAuthenticationResult().observe(this, new AnonymousClass1(this));
        this.mViewModel.getAuthenticationError().observe(this, new AnonymousClass2(this));
        this.mViewModel.getAuthenticationHelpMessage().observe(this, new AnonymousClass3(this));
        this.mViewModel.isAuthenticationFailurePending().observe(this, new AnonymousClass4(this));
        this.mViewModel.isNegativeButtonPressPending().observe(this, new AnonymousClass5(this));
        this.mViewModel.isFingerprintDialogCancelPending().observe(this, new AnonymousClass6(this));
    }

    private int getDismissDialogDelay() {
        Context r0 = getContext();
        if (r0 != null) goto L5;
    L7:
        return HIDE_DIALOG_DELAY_MS;
    L5:
        if (DeviceUtils.shouldHideFingerprintDialog(r0, Build.MODEL) == false) goto L7;
        return 0;
    }

    private boolean isChangingConfigurations() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isChangingConfigurations() == false) goto L7;
        return true;
    }

    private boolean isFingerprintDialogNeededForCrypto() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mViewModel.getCryptoObject() == null) goto L9;
        if (DeviceUtils.shouldUseFingerprintForCrypto(r0, Build.MANUFACTURER, Build.MODEL) == false) goto L9;
        return true;
    }

    private void launchConfirmCredentialActivity() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        KeyguardManager r1 = KeyguardUtils.getKeyguardManager(r0);
        if (r1 != null) goto L9;
        sendErrorAndDismiss(12, getString(2131897285));
        return;
    L9:
        CharSequence r2 = this.mViewModel.getTitle();
        CharSequence r3 = this.mViewModel.getSubtitle();
        CharSequence r4 = this.mViewModel.getDescription();
        if (r3 != null) goto L13;
        r3 = r4;
    L13:
        Intent r5 = Api21Impl.createConfirmDeviceCredentialIntent(r1, r2, r3);
        if (r5 != null) goto L17;
        sendErrorAndDismiss(14, getString(2131897284));
        return;
    L17:
        this.mViewModel.setConfirmingDeviceCredential(true);
        if (isUsingFingerprintDialog() == false) goto L20;
        dismissFingerprintDialog();
    L20:
        r5.setFlags(134742016);
        startActivityForResult(r5, 1);
    }

    private void showBiometricPromptForAuthentication() {
        BiometricPrompt.Builder r0 = Api28Impl.createPromptBuilder(requireContext().getApplicationContext());
        CharSequence r1 = this.mViewModel.getTitle();
        CharSequence r2 = this.mViewModel.getSubtitle();
        CharSequence r3 = this.mViewModel.getDescription();
        if (r1 == null) goto L5;
        Api28Impl.setTitle(r0, r1);
    L5:
        if (r2 == null) goto L7;
        Api28Impl.setSubtitle(r0, r2);
    L7:
        if (r3 == null) goto L9;
        Api28Impl.setDescription(r0, r3);
    L9:
        CharSequence r4 = this.mViewModel.getNegativeButtonText();
        if (TextUtils.isEmpty(r4) == true) goto L12;
        Api28Impl.setNegativeButton(r0, r4, this.mViewModel.getClientExecutor(), this.mViewModel.getNegativeButtonListener());
    L12:
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 29) goto L15;
        Api29Impl.setConfirmationRequired(r0, this.mViewModel.isConfirmationRequired());
    L15:
        int r6 = this.mViewModel.getAllowedAuthenticators();
        if (r5 < 30) goto L18;
        Api30Impl.setAllowedAuthenticators(r0, r6);
    L20:
        authenticateWithBiometricPrompt(Api28Impl.buildPrompt(r0), getContext());
        return;
    L18:
        if (r5 < 29) goto L20;
        Api29Impl.setDeviceCredentialAllowed(r0, AuthenticatorUtils.isDeviceCredentialAllowed(r6));
        goto L20
    }

    private void showFingerprintDialogForAuthentication() {
        Context r0 = requireContext().getApplicationContext();
        FingerprintManagerCompat r1 = FingerprintManagerCompat.from(r0);
        int r2 = checkForFingerprintPreAuthenticationErrors(r1);
        if (r2 == 0) goto L7;
        sendErrorAndDismiss(r2, ErrorUtils.getFingerprintErrorString(r0, r2));
        return;
    L7:
        if (isAdded() == false) goto L13;
        this.mViewModel.setFingerprintDialogDismissedInstantly(true);
        if (DeviceUtils.shouldHideFingerprintDialog(r0, Build.MODEL) == true) goto L11;
        this.mHandler.postDelayed(new AnonymousClass7(this), 500);
        INVOKEVIRTUAL_androidx_biometric_BiometricFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(FingerprintDialogFragment.newInstance(), getParentFragmentManager(), FINGERPRINT_DIALOG_FRAGMENT_TAG);
    L11:
        this.mViewModel.setCanceledFrom(0);
        authenticateWithFingerprint(r1, r0);
        return;
    }

    public void onAuthenticationFailed() {
        if (isUsingFingerprintDialog() == false) goto L5;
        showFingerprintErrorMessage(getString(2131897027));
    L5:
        sendFailureToClient();
    }

    public void onStart() {
        super.onStart();
        if (Build.VERSION.SDK_INT == 29) goto L5;
        return;
    L5:
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators()) == false) goto L9;
        this.mViewModel.setIgnoringCancel(true);
        this.mHandler.postDelayed(new StopIgnoringCancelRunnable(this.mViewModel), 250);
        return;
    }

    public void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return;
    L5:
        if (this.mViewModel.isConfirmingDeviceCredential() == false) goto L7;
        return;
    L7:
        if (isChangingConfigurations() == true) goto L12;
        cancelAuthentication(0);
        return;
    }

    public void onDeviceCredentialButtonPressed() {
        launchConfirmCredentialActivity();
    }

    public static void INVOKEVIRTUAL_androidx_biometric_BiometricFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(FingerprintDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    private static int checkForFingerprintPreAuthenticationErrors(FingerprintManagerCompat r1) {
        if (r1.isHardwareDetected() == true) goto L7;
        return 12;
    L7:
        if (r1.hasEnrolledFingerprints() == true) goto L10;
        return 11;
    L10:
        return 0;
    }

    private void handleConfirmCredentialResult(int r3) {
        if (r3 != (-1)) goto L5;
        sendSuccessAndDismiss(new BiometricPrompt$AuthenticationResult(null, 1));
        return;
    L5:
        sendErrorAndDismiss(10, getString(2131897286));
    }

    private void sendSuccessAndDismiss(BiometricPrompt$AuthenticationResult r1) {
        sendSuccessToClient(r1);
        dismiss();
    }

    private void sendSuccessToClient(final BiometricPrompt$AuthenticationResult r3) {
        if (this.mViewModel.isAwaitingResult() == true) goto L5;
        return;
    L5:
        this.mViewModel.setAwaitingResult(false);
        this.mViewModel.getClientExecutor().execute(new AnonymousClass9(this, r3));
    }

    private void showFingerprintErrorMessage(CharSequence r3) {
        if (r3 != null) goto L5;
        r3 = getString(2131896083);
    L5:
        this.mViewModel.setFingerprintDialogState(2);
        this.mViewModel.setFingerprintDialogHelpMessage(r3);
    }

    public void cancelAuthentication(int r2) {
        if (r2 == 3) goto L8;
        if (this.mViewModel.isIgnoringCancel() == false) goto L8;
        return;
    L8:
        if (isUsingFingerprintDialog() == false) goto L12;
        this.mViewModel.setCanceledFrom(r2);
        if (r2 != 1) goto L12;
        sendErrorToClient(10, ErrorUtils.getFingerprintErrorString(getContext(), 10));
    L12:
        this.mViewModel.getCancellationSignalProvider().cancel();
    }

    public void onAuthenticationHelp(CharSequence r2) {
        if (isUsingFingerprintDialog() == false) goto L6;
        showFingerprintErrorMessage(r2);
        return;
    }

    public void onAuthenticationSucceeded(BiometricPrompt$AuthenticationResult r1) {
        sendSuccessAndDismiss(r1);
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        connectViewModel();
    }

    private void sendErrorToClient(final int r3, final CharSequence r4) {
        if (this.mViewModel.isConfirmingDeviceCredential() == false) goto L6;
        return;
    L6:
        if (this.mViewModel.isAwaitingResult() == true) goto L8;
        return;
    L8:
        this.mViewModel.setAwaitingResult(false);
        this.mViewModel.getClientExecutor().execute(new AnonymousClass10(this, r3, r4));
    }

    public void authenticate(BiometricPrompt.PromptInfo r4, BiometricPrompt$CryptoObject r5) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        this.mViewModel.setPromptInfo(r4);
        int r6 = AuthenticatorUtils.getConsolidatedAuthenticators(r4, r5);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 >= 23) goto L8;
    L13:
        this.mViewModel.setCryptoObject(r5);
    L15:
        if (isManagingDeviceCredentialButton() == false) goto L17;
        this.mViewModel.setNegativeButtonTextOverride(getString(2131896000));
    L19:
        if (isManagingDeviceCredentialButton() == false) goto L25;
        if (BiometricManager.from(r0).canAuthenticate(255) == 0) goto L25;
        this.mViewModel.setAwaitingResult(true);
        launchConfirmCredentialActivity();
        return;
    L25:
        if (this.mViewModel.isDelayingPrompt() == false) goto L27;
        this.mHandler.postDelayed(new ShowPromptForAuthenticationRunnable(this), 600);
        return;
    L27:
        showPromptForAuthentication();
        return;
    L17:
        this.mViewModel.setNegativeButtonTextOverride(null);
        goto L19
    L8:
        if (r1 >= 30) goto L13;
        if (r6 != 15) goto L13;
        if (r5 != null) goto L13;
        this.mViewModel.setCryptoObject(CryptoObjectUtils.createFakeCryptoObject());
        goto L15
    }

    public void authenticateWithBiometricPrompt(BiometricPrompt r5, Context r6) {
        BiometricPrompt.CryptoObject r0 = CryptoObjectUtils.wrapForBiometricPrompt(this.mViewModel.getCryptoObject());
        CancellationSignal r1 = this.mViewModel.getCancellationSignalProvider().getBiometricCancellationSignal();
        PromptExecutor r2 = new PromptExecutor();
        BiometricPrompt.AuthenticationCallback r3 = this.mViewModel.getAuthenticationCallbackProvider().getBiometricCallback();
        if (r0 != null) goto L5;
        Api28Impl.authenticate(r5, r1, r2, r3);     // Catch: NullPointerException -> L7
    L13:
        return;
    L5:
        Api28Impl.authenticate(r5, r0, r1, r2, r3);     // Catch: NullPointerException -> L7
    L8:
        if (r6 == null) goto L10;
        String r7 = r6.getString(2131896083);
    L11:
        sendErrorAndDismiss(1, r7);
        return;
    L10:
        r7 = "";
        goto L11
    }

    public void authenticateWithFingerprint(FingerprintManagerCompat r8, Context r9) {
        r8.authenticate(CryptoObjectUtils.wrapForFingerprintManager(this.mViewModel.getCryptoObject()), 0, this.mViewModel.getCancellationSignalProvider().getFingerprintCancellationSignal(), this.mViewModel.getAuthenticationCallbackProvider().getFingerprintCallback(), null);     // Catch: NullPointerException -> L5
        return;
    L5:
        sendErrorAndDismiss(1, ErrorUtils.getFingerprintErrorString(r9, 1));
    }

    public void onAuthenticationError(final int r4, final CharSequence r5) {
        if (ErrorUtils.isKnownError(r4) == true) goto L6;
        r4 = 8;
    L6:
        Context r0 = getContext();
        if (Build.VERSION.SDK_INT >= 29) goto L18;
        if (ErrorUtils.isLockoutError(r4) == false) goto L18;
        if (r0 == null) goto L18;
        if (KeyguardUtils.isDeviceSecuredWithCredential(r0) == false) goto L18;
        if (AuthenticatorUtils.isDeviceCredentialAllowed(this.mViewModel.getAllowedAuthenticators()) == false) goto L18;
        launchConfirmCredentialActivity();
        return;
    L18:
        if (isUsingFingerprintDialog() == false) goto L35;
        if (r5 != null) goto L23;
        r5 = ErrorUtils.getFingerprintErrorString(getContext(), r4);
    L23:
        if (r4 != 5) goto L31;
        int r1 = this.mViewModel.getCanceledFrom();
        if (r1 != 0) goto L27;
    L28:
        sendErrorToClient(r4, r5);
    L29:
        dismiss();
        return;
    L27:
        if (r1 != 3) goto L29;
    L31:
        if (this.mViewModel.isFingerprintDialogDismissedInstantly() == false) goto L33;
        sendErrorAndDismiss(r4, r5);
    L34:
        this.mViewModel.setFingerprintDialogDismissedInstantly(true);
        return;
    L33:
        showFingerprintErrorMessage(r5);
        this.mHandler.postDelayed(new AnonymousClass8(this, r4, r5), getDismissDialogDelay());
        goto L34
    L35:
        if (r5 != null) goto L38;
        r5 = getString(2131896083) + " " + r4;
    L38:
        sendErrorAndDismiss(r4, r5);
    }

    public void sendErrorAndDismiss(int r1, CharSequence r2) {
        sendErrorToClient(r1, r2);
        dismiss();
    }

    public static void INVOKEVIRTUAL_androidx_biometric_BiometricFragment_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(FingerprintDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        FingerprintDialogFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 != 1) goto L6;
        this.mViewModel.setConfirmingDeviceCredential(false);
        handleConfirmCredentialResult(r2);
        return;
    }
}
