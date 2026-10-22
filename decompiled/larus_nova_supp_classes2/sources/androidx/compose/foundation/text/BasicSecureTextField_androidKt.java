package androidx.compose.foundation.text;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.os.HandlerCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\b\u0010\u0010\u001a\u00020\u0011H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"0\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"TAG", "", "platformAllowsRevealLastTyped", "", "(Landroidx/compose/runtime/Composer;I)Z", "DefaultContentResolverForSecureTextField", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroidx/compose/foundation/text/ContentResolverForSecureTextField;", "contentResolverForSecureTextField", "getContentResolverForSecureTextField$annotations", "()V", "getContentResolverForSecureTextField", "()Lkotlin/jvm/functions/Function1;", "setContentResolverForSecureTextField", "(Lkotlin/jvm/functions/Function1;)V", "resetContentResolverForSecureTextField", "", "foundation_release", "state"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicSecureTextField_androidKt {
    private static final Function1<Context, ContentResolverForSecureTextField> DefaultContentResolverForSecureTextField = null;
    private static final String TAG = "BasicSecureTextField";
    private static Function1<? super Context, ? extends ContentResolverForSecureTextField> contentResolverForSecureTextField;

    public static /* synthetic */ BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1 a(Context r0) {
        return DefaultContentResolverForSecureTextField$lambda$8(r0);
    }

    public static /* synthetic */ DisposableEffectResult b(ContentResolverForSecureTextField r0, BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 r1, DisposableEffectScope r2) {
        return platformAllowsRevealLastTyped$lambda$7$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void getContentResolverForSecureTextField$annotations() {
    }

    static {
        Function1<Context, ContentResolverForSecureTextField> r0 = new o();
        DefaultContentResolverForSecureTextField = r0;
        contentResolverForSecureTextField = r0;
    }

    public static final void resetContentResolverForSecureTextField() {
        contentResolverForSecureTextField = DefaultContentResolverForSecureTextField;
    }

    public static final Function1<Context, ContentResolverForSecureTextField> getContentResolverForSecureTextField() {
        return contentResolverForSecureTextField;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.text.BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1] */
    private static final BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1 DefaultContentResolverForSecureTextField$lambda$8(Context r1) {
        final ContentResolver r2 = r1.getContentResolver();
        return new BasicSecureTextField_androidKt$DefaultContentResolverForSecureTextField$1$1(r2);
    }

    private static final boolean platformAllowsRevealLastTyped$lambda$2(MutableState<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    public static final void setContentResolverForSecureTextField(Function1<? super Context, ? extends ContentResolverForSecureTextField> r0) {
        contentResolverForSecureTextField = r0;
    }

    public static final /* synthetic */ void access$platformAllowsRevealLastTyped$lambda$3(MutableState r0, boolean r1) {
        platformAllowsRevealLastTyped$lambda$3(r0, r1);
    }

    public static final boolean platformAllowsRevealLastTyped(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1015272320, r5, -1, "androidx.compose.foundation.text.platformAllowsRevealLastTyped (BasicSecureTextField.android.kt:38)");
    L5:
        Context r6 = (Context) r4.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Function1<? super Context, ? extends ContentResolverForSecureTextField> r0 = contentResolverForSecureTextField;
        boolean r1 = r4.changed(r6);
        boolean r2 = r4.changed(r0) | r1;
        Object r3 = r4.rememberedValue();
        if (r2 == false) goto L8;
    L9:
        r3 = (ContentResolverForSecureTextField) contentResolverForSecureTextField.invoke(r6);
        r4.updateRememberedValue(r3);
    L10:
        final ContentResolverForSecureTextField r7 = (ContentResolverForSecureTextField) r3;
        boolean r8 = r4.changed(r7);
        Object r9 = r4.rememberedValue();
        if (r8 == false) goto L13;
    L14:
        r9 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r7.getShowPassword()), null, 2, null);
        r4.updateRememberedValue(r9);
    L15:
        final MutableState r10 = (MutableState) r9;
        boolean r11 = r4.changed(r7);
        Object r12 = r4.rememberedValue();
        if (r11 == false) goto L18;
    L19:
        final Handler r13 = HandlerCompat.createAsync(Looper.getMainLooper());
        r12 = new BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1(r7, r10, r13);
        r4.updateRememberedValue(r12);
    L20:
        final BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 r14 = (BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1) r12;
        boolean r15 = r4.changedInstance(r7) | r4.changedInstance(r14);
        Object r16 = r4.rememberedValue();
        if (r15 == false) goto L23;
    L24:
        r16 = new n(r7, r14);
        r4.updateRememberedValue(r16);
    L25:
        EffectsKt.DisposableEffect(r7, r14, (Function1) r16, r4, 0);
        boolean r17 = platformAllowsRevealLastTyped$lambda$2(r10);
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r17;
    L23:
        if (r16 != Composer.Companion.getEmpty()) goto L25;
    L18:
        if (r12 != Composer.Companion.getEmpty()) goto L20;
    L13:
        if (r9 != Composer.Companion.getEmpty()) goto L15;
    L8:
        if (r3 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    private static final void platformAllowsRevealLastTyped$lambda$3(MutableState<Boolean> r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    private static final DisposableEffectResult platformAllowsRevealLastTyped$lambda$7$lambda$6(final ContentResolverForSecureTextField r1, final BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$settingsObserver$1$1 r2, DisposableEffectScope r3) {
        r1.registerContentObserver(Settings.System.getUriFor("show_password"), false, r2);
        return new BasicSecureTextField_androidKt$platformAllowsRevealLastTyped$lambda$7$lambda$6$$inlined$onDispose$1(r1, r2);
    }
}
