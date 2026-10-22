package com.obric.assistant.interaction.impl.feedback;

import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.obric.assistant.interaction.base.feedback.IVibratorSmtFeedback;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import t9a.b;
import z9a.d;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\f\u0010\b\u001a\u00020\t*\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/feedback/VibratorSmtFeedbackImpl;", "Lcom/obric/assistant/interaction/base/feedback/IVibratorSmtFeedback;", "<init>", "()V", "perform", "", "effect", "Lcom/obric/assistant/interaction/base/feedback/VibratorSmtFeedbackEffect;", "toProductFeedbackType", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VibratorSmtFeedbackImpl implements IVibratorSmtFeedback {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[VibratorSmtFeedbackEffect.values().length];
            r100[VibratorSmtFeedbackEffect.EFFECT_WAKE_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[VibratorSmtFeedbackEffect.EFFECT_LONG_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[VibratorSmtFeedbackEffect.EFFECT_TICK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[VibratorSmtFeedbackEffect.EFFECT_WARNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[VibratorSmtFeedbackEffect.EFFECT_CONFIRM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[VibratorSmtFeedbackEffect.EFFECT_RIGID.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[VibratorSmtFeedbackEffect.EFFECT_SOFT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public VibratorSmtFeedbackImpl() {
    }

    private final FeedbackType toProductFeedbackType(VibratorSmtFeedbackEffect r100) {
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return FeedbackType.SOFT;
    L15:
        return FeedbackType.RIGID;
    L16:
        return FeedbackType.CONFIRM;
    L17:
        return FeedbackType.WARNING;
    L18:
        return FeedbackType.TICK;
    L19:
        return FeedbackType.LONG_PRESS;
    L13:
        return FeedbackType.WAKE_UP;
    }

    @Override // com.obric.assistant.interaction.base.feedback.IVibratorSmtFeedback
    public void perform(VibratorSmtFeedbackEffect r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        b.b().a();
        d.f571072a.a(toProductFeedbackType(r100));
    }
}
