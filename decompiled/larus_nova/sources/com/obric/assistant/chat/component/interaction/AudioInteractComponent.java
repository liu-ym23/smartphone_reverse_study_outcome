package com.obric.assistant.chat.component.interaction;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAudioInteractServiceDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import va8.a0;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/chat/component/interaction/AudioInteractComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "<init>", "()V", "audioInteractService", "Lcom/obric/assistant/audio/service/ObricAudioInteractServiceDelegate;", "chatTitleAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getChatTitleAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "chatTitleAbility$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "chatConversationAbility$delegate", "onAttach", "", "onStop", "readLatestMessage", "startTTS", "msg", "Lcom/larus/im/bean/message/Message;", "getCurrentActionMessage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioInteractComponent extends ComponentFeature {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f386836k = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ObricAudioInteractServiceDelegate f386837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f386838i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f386839j;

    public static final class a {
    }

    public static final class b implements Function0<ry8.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386840a;

        public b(AttachReceiver r100) {
            this.f386840a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ry8.b, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ry8.b invoke() {
            AttachReceiver r100 = this.f386840a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ry8.b.class));
        }
    }

    public static final class c implements Function0<a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386841a;

        public c(AttachReceiver r100) {
            this.f386841a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.a0] */
        @Override // kotlin.jvm.functions.Function0
        public final a0 invoke() {
            AttachReceiver r100 = this.f386841a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(a0.class));
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        FLogger.f375446a.i("AudioInteractBridge", "onStop");
        ObricAudioInteractServiceDelegate r100 = this.f386837h;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.assistant.chat.component.interaction.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        FLogger.f375446a.i("AudioInteractBridge", "onAttach");
        ObricAudioInteractServiceDelegate r100 = this.f386837h;
        if (r100 == 0) goto L6;
        r100.b(new com.obric.assistant.chat.component.interaction.a(this));
        return;
    }

    public AudioInteractComponent() {
        this.f386837h = ObricAudioInteractServiceDelegate.f385672b;
        this.f386838i = LazyKt.lazy(new b(this));
        this.f386839j = LazyKt.lazy(new c(this));
    }
}
