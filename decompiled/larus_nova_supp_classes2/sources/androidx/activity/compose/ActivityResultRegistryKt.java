package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultRegistryKt {

    /* JADX INFO: renamed from: androidx.activity.compose.ActivityResultRegistryKt$rememberLauncherForActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "I", "O", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ ActivityResultRegistry $activityResultRegistry;
        final /* synthetic */ ActivityResultContract<I, O> $contract;
        final /* synthetic */ State<Function1<O, Unit>> $currentOnResult;
        final /* synthetic */ String $key;
        final /* synthetic */ ActivityResultLauncherHolder<I> $realLauncher;

        public AnonymousClass1(ActivityResultLauncherHolder<I> r1, ActivityResultRegistry r2, String r3, ActivityResultContract<I, O> r4, State<? extends Function1<? super O, Unit>> r5) {
            this.$realLauncher = r1;
            this.$activityResultRegistry = r2;
            this.$key = r3;
            this.$contract = r4;
            this.$currentOnResult = r5;
            super(1);
        }

        public static /* synthetic */ void a(State r0, Object r1) {
            invoke$lambda$0(r0, r1);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final DisposableEffectResult invoke(DisposableEffectScope r6) {
            ActivityResultLauncherHolder<I> r7 = this.$realLauncher;
            ActivityResultRegistry r0 = this.$activityResultRegistry;
            String r1 = this.$key;
            ActivityResultContract<I, O> r2 = this.$contract;
            final State<Function1<O, Unit>> r3 = this.$currentOnResult;
            r7.setLauncher((ActivityResultLauncher<I>) r0.register(r1, r2, new a(r3)));
            final ActivityResultLauncherHolder<I> r8 = this.$realLauncher;
            return new ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1(r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((DisposableEffectScope) r1);
        }

        private static final void invoke$lambda$0(State r0, Object r1) {
            ((Function1) r0.getValue()).invoke(r1);
        }
    }

    public static final <I, O> ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(ActivityResultContract<I, O> r13, Function1<? super O, Unit> r14, Composer r15, int r16) {
        r15.startReplaceableGroup(-1408504823);
        State r9 = SnapshotStateKt.rememberUpdatedState(r13, r15, 8);
        State r10 = SnapshotStateKt.rememberUpdatedState(r14, r15, (r16 >> 3) & 14);
        String r11 = (String) RememberSaveableKt.rememberSaveable(new Object[0], null, null, ActivityResultRegistryKt$rememberLauncherForActivityResult$key$1.INSTANCE, r15, 3080, 6);
        ActivityResultRegistryOwner r0 = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(r15, 6);
        if (r0 == null) goto L13;
        ActivityResultRegistry r1 = r0.getActivityResultRegistry();
        r15.startReplaceableGroup(-3687241);
        Object r2 = r15.rememberedValue();
        Composer.Companion r3 = Composer.Companion;
        if (r2 != r3.getEmpty()) goto L7;
        r2 = new ActivityResultLauncherHolder();
        r15.updateRememberedValue(r2);
    L7:
        r15.endReplaceableGroup();
        ActivityResultLauncherHolder r4 = (ActivityResultLauncherHolder) r2;
        r15.startReplaceableGroup(-3687241);
        Object r5 = r15.rememberedValue();
        if (r5 != r3.getEmpty()) goto L10;
        r5 = new ManagedActivityResultLauncher(r4, r9);
        r15.updateRememberedValue(r5);
    L10:
        r15.endReplaceableGroup();
        ManagedActivityResultLauncher<I, O> r12 = (ManagedActivityResultLauncher) r5;
        EffectsKt.DisposableEffect(r1, r11, r13, new AnonymousClass1(r4, r1, r11, r13, r10), r15, 520);
        r15.endReplaceableGroup();
        return r12;
    L13:
        throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
    }
}
