package com.obric.assistant.component;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.nova.R;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.ObricChatService;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.view.ObricIconSwipeUpView;
import com.obric.assistant.view.continuespeech.AudioGradientView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 Þ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004Þ\u0001ß\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0099\u0001\u001a\u00020]H\u0016J\t\u0010\u009a\u0001\u001a\u00020]H\u0002J\u0013\u0010\u009d\u0001\u001a\u00020]2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010 \u0001\u001a\u00020]2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0002J\n\u0010¡\u0001\u001a\u00030\u009f\u0001H\u0002J\t\u0010¢\u0001\u001a\u00020]H\u0016J\t\u0010£\u0001\u001a\u00020]H\u0016J\t\u0010¤\u0001\u001a\u00020]H\u0016J\u0013\u0010ª\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010¬\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010\u00ad\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u0001H\u0016J\u001d\u0010\u00ad\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u00012\b\u0010®\u0001\u001a\u00030\u009f\u0001H\u0016J4\u0010\u00ad\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u00012\b\u0010®\u0001\u001a\u00030\u009f\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u00012\t\u0010±\u0001\u001a\u0004\u0018\u00010`H\u0016J\u001d\u0010²\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0016J\u0013\u0010µ\u0001\u001a\u00020]2\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\u0013\u0010¶\u0001\u001a\u00020]2\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\n\u0010·\u0001\u001a\u00030\u009f\u0001H\u0002J\t\u0010¸\u0001\u001a\u00020]H\u0016J\u0017\u0010[\u001a\u00020]2\r\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0016J\t\u0010º\u0001\u001a\u00020gH\u0002J\t\u0010»\u0001\u001a\u00020gH\u0002J\t\u0010¼\u0001\u001a\u00020gH\u0002J\u0019\u0010½\u0001\u001a\u00020g2\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0016¢\u0006\u0003\u0010À\u0001J\u0013\u0010Á\u0001\u001a\u00020]2\b\u0010Â\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010Ã\u0001\u001a\u00020]2\b\u0010«\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010Ä\u0001\u001a\u00020]2\b\u0010Å\u0001\u001a\u00030\u009f\u0001H\u0016J\u001c\u0010Æ\u0001\u001a\u00020]2\u0007\u0010Ç\u0001\u001a\u00020g2\b\u0010È\u0001\u001a\u00030\u009f\u0001H\u0016JX\u0010É\u0001\u001a\u00020]2\u000e\u0010Ê\u0001\u001a\t\u0012\u0004\u0012\u00020D0Ë\u00012\u000e\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020t0Ë\u00012\u000f\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Î\u00010Ë\u00012\b\u0010Ï\u0001\u001a\u00030\u009f\u00012\b\u0010Ð\u0001\u001a\u00030\u009f\u00012\b\u0010Ñ\u0001\u001a\u00030\u009f\u0001H\u0002J\u001f\u0010Ò\u0001\u001a\u00020]2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\n\b\u0002\u0010Å\u0001\u001a\u00030\u009f\u0001H\u0002J\f\u0010Ó\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\u0013\u0010Ô\u0001\u001a\u00020]2\b\u0010Õ\u0001\u001a\u00030\u009f\u0001H\u0002J\u0012\u0010Ö\u0001\u001a\u00020]2\u0007\u0010×\u0001\u001a\u00020gH\u0016J\r\u0010Ø\u0001\u001a\u00020]*\u00020DH\u0002J\u0019\u0010Ù\u0001\u001a\u00020]2\u0006\u0010c\u001a\u00020`2\u0006\u0010e\u001a\u00020dH\u0002J\u001b\u0010Ú\u0001\u001a\u00020]2\u0007\u0010Û\u0001\u001a\u00020g2\u0007\u0010Ü\u0001\u001a\u00020gH\u0002J\n\u0010m\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010Ý\u0001\u001a\u00030\u009f\u00012\u0006\u0010e\u001a\u00020dH\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bE\u0010FR\u0016\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0016\u0010L\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010AR\u0016\u0010N\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010AR\u0016\u0010P\u001a\u0004\u0018\u00010D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010FR\u001d\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bT\u0010UR\u0016\u0010W\u001a\u0004\u0018\u00010?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010AR\u0016\u0010Y\u001a\u0004\u0018\u00010D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010FR\u0016\u0010[\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010^\u001a4\u0012\u0013\u0012\u00110`¢\u0006\f\ba\u0012\b\bb\u0012\u0004\b\b(c\u0012\u0013\u0012\u00110d¢\u0006\f\ba\u0012\b\bb\u0012\u0004\b\b(e\u0012\u0004\u0012\u00020]\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010k\u001a\u00020l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u000b\u001a\u0004\bm\u0010nR\u001b\u0010p\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u000b\u001a\u0004\bq\u0010FR\u001b\u0010s\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u000b\u001a\u0004\bu\u0010vR\u001b\u0010x\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\u000b\u001a\u0004\by\u0010FR\u001b\u0010{\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010\u000b\u001a\u0004\b}\u0010~R\u001e\u0010\u0080\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u000b\u001a\u0005\b\u0081\u0001\u0010~R\u001e\u0010\u0083\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\u000b\u001a\u0005\b\u0084\u0001\u0010~R\u001e\u0010\u0086\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u000b\u001a\u0005\b\u0087\u0001\u0010~R\u001e\u0010\u0089\u0001\u001a\u00020|8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010\u000b\u001a\u0005\b\u008a\u0001\u0010~R \u0010\u008c\u0001\u001a\u00030\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010\u000b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R \u0010\u0091\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0095\u0001\u0010\u000b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001e\u0010\u0096\u0001\u001a\u00020D8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010\u000b\u001a\u0005\b\u0097\u0001\u0010FR\u0010\u0010\u009b\u0001\u001a\u00030\u009c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¥\u0001\u001a\u00030\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¦\u0001\u001a\u00030\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010§\u0001\u001a\u00030\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006à\u0001"}, d2 = {"Lcom/obric/assistant/component/OrionChatWindowComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "photoActionAbility", "Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "getPhotoActionAbility", "()Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "photoActionAbility$delegate", "Lkotlin/Lazy;", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "input", "Landroid/view/View;", "getInput", "()Landroid/view/View;", "input$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "inputArea", "getInputArea", "speakArea", "getSpeakArea", "actionSend", "getActionSend", "bottomLayout", "Landroid/widget/FrameLayout;", "getBottomLayout", "()Landroid/widget/FrameLayout;", "bottomLayout$delegate", "actionBarContainer", "getActionBarContainer", "actionFullScreen", "getActionFullScreen", "onCancel", "Lkotlin/Function0;", "", "onStateChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "botId", "Lcom/obric/assistant/state/api/multitask/ForegroundInteractionPhase;", "phase", "minLightAlpha", "", "maxLightAlpha", "minShadowAlpha", "maxShadowAlpha", "lightView", "Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "getLightView", "()Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "lightView$delegate", "lightReferView", "getLightReferView", "lightReferView$delegate", "bgView", "Landroid/widget/ImageView;", "getBgView", "()Landroid/widget/ImageView;", "bgView$delegate", "bgTopView", "getBgTopView", "bgTopView$delegate", "spaceLeft", "Landroid/widget/Space;", "getSpaceLeft", "()Landroid/widget/Space;", "spaceLeft$delegate", "spaceRight", "getSpaceRight", "spaceRight$delegate", "spaceTop", "getSpaceTop", "spaceTop$delegate", "spaceBottom", "getSpaceBottom", "spaceBottom$delegate", "gestureReferView", "getGestureReferView", "gestureReferView$delegate", "gestureView", "Lcom/obric/assistant/view/ObricIconSwipeUpView;", "getGestureView", "()Lcom/obric/assistant/view/ObricIconSwipeUpView;", "gestureView$delegate", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "interceptView", "getInterceptView", "interceptView$delegate", "onParentViewCreated", "adaptChatRootView", "interactionProjectionObserver", "Lcom/obric/assistant/state/api/multitask/InteractionProjectionObserver;", "onChatStyleChanged", "isChatWindow", "", "updateGestureViewVisibility", "isAiKeyWakeupHolding", "onResume", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "speakerVisible", "voiceVisible", "mockSpeakerVisible", "voiceViewAppearAnimator", "Landroid/animation/AnimatorSet;", "onSpeakerVisibilityChanged", "visible", "onMockSpeakerVisibleChanged", "setVoiceViewVisible", "isResumeClickTalk", "listeningUiHandle", "Lcom/obric/assistant/ability/ObricListeningUiHandle;", "startupAttemptId", "setVoiceViewVisibleAnimated", "duration", "", "animateVoiceViewAppear", "animateVoiceViewDisappear", "isSpeakerVisible", "setInputTextListener", "callback", "getShadowViewBaseAlpha", "getLightViewBaseAlpha", "getSpeakerBgViewBaseAlpha", "getBaseAlpha", "id", "", "(I)Ljava/lang/Float;", "onInstructionVisibleChanged", "instructionOpen", "onAttachmentPanelVisibleChanged", "onSpeakerStatusSwitch", "toCancel", "resetChatWindowLightAlpha", "alpha", "half", "setBottomMenuStyle", "areaViews", "", "iconArray", "textViews", "Landroid/widget/TextView;", "useNewStyle", "isImmerse", "isHalf", "updateLightViewAlpha", "getBottomGestureView", "onInputHeightChanged", "panelVisible", "updateBottomMenuProgress", "progress", "removeFromParent", "onStateChanged", "startAnimator", "startValue", "endValue", "isActivatePhase", "Companion", "InterceptView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrionChatWindowComponent extends BaseContentWidget implements laa.m, hca.b {
    public static final /* synthetic */ int T = 0;
    public Function0<Unit> A;
    public w5 B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f388309J;
    public final Lazy K;
    public final Lazy L;
    public final Lazy M;
    public final Lazy N;
    public final e5 O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public AnimatorSet S;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f388310m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f388311n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f388312o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f388313p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f388314q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f388315r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f388316s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f388317t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f388318u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f388319v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f388320w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f388321x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f388322y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f388323z;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements ObricIconSwipeUpView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrionChatWindowComponent f388324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObricIconSwipeUpView f388325b;

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void c() {
        }

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void b(float r110) {
            OrionChatWindowComponent r100 = this.f388324a;
            int r101 = OrionChatWindowComponent.T;
            laa.d r102 = r100.B3();
            if (r102 == null) goto L6;
            laa.d.a.d(r102, true, com.obric.assistant.util.m2.f393770b, Float.valueOf(r110), true, false, null, 48);
            return;
        }

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void onClick(boolean r110) {
            if (r110 == false) goto L6;
            OrionChatWindowComponent r111 = this.f388324a;
            int r100 = OrionChatWindowComponent.T;
            laa.d r101 = r111.B3();
            if (r101 == null) goto L22;
            laa.d.a.d(r101, true, com.obric.assistant.util.m2.f393770b, null, true, false, null, 52);
            return;
        L22:
            return;
        L6:
            laa.h r112 = (laa.h) this.f388324a.f388310m.getValue();
            if (r112 == null) goto L11;
            boolean r102 = true;
            if (r112.W10() != true) goto L11;
        L12:
            if (r102 == false) goto L17;
            FLogger.f375446a.i("OrionWindowStyleComponent", "close secondary menu");
            laa.h r113 = (laa.h) this.f388324a.f388310m.getValue();
            if (r113 == null) goto L21;
            r113.X30();
            return;
        L21:
            return;
        L17:
            laa.d r114 = this.f388324a.B3();
            if (r114 == null) goto L24;
            r114.Gm(false);
            return;
        L24:
            return;
        L11:
            r102 = false;
            goto L12
        }

        public b(OrionChatWindowComponent r100, ObricIconSwipeUpView r101) {
            this.f388324a = r100;
            this.f388325b = r101;
        }

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void d(float r100, boolean r110) {
            OrionChatWindowComponent r101 = this.f388324a;
            int r102 = OrionChatWindowComponent.T;
            laa.d r103 = r101.B3();
            boolean r104 = true;
            if (r103 == null) goto L9;
            ObricFloatChatPageState r105 = r103.getPageState();
            if (r105 == null) goto L9;
            if (r105.getHeight() != 0) goto L9;
            boolean r106 = true;
        L10:
            int r107 = Integer.MAX_VALUE;
            if (r106 == true) goto L24;
            laa.d r108 = this.f388324a.B3();
            if (r108 == null) goto L17;
            ObricFloatChatPageState r109 = r108.getPageState();
            if (r109 == null) goto L17;
            int r111 = r109.getHeight();
        L19:
            if (r111 > com.obric.assistant.util.m2.f393773e) goto L24;
            laa.d r112 = this.f388324a.B3();
            if (r112 == null) goto L50;
            laa.d.a.c(r112, null, false, null, 7);
        L50:
            this.f388325b.c();
            return;
        L17:
            r111 = Integer.MAX_VALUE;
        L24:
            if (r100 <= (-v19.i5.k0())) goto L32;
            laa.d r113 = this.f388324a.B3();
            if (r113 == null) goto L31;
            ObricFloatChatPageState r114 = r113.getPageState();
            if (r114 == null) goto L31;
            r107 = r114.getHeight();
        L31:
            if (r107 <= com.obric.assistant.util.m2.f393770b) goto L32;
        L47:
            laa.d r115 = this.f388324a.B3();
            if (r115 == null) goto L50;
            laa.d.a.a(r115, 0.0f, false, 3);
        L32:
            if (r110 == false) goto L47;
            laa.d r116 = this.f388324a.B3();
            if (r116 == null) goto L42;
            ObricFloatChatPageState r117 = r116.getPageState();
            if (r117 == null) goto L42;
            ObricFloatChatPageState r118 = r117.getPreviousState();
            if (r118 == null) goto L42;
            ObricFloatChatPageData.Companion.getClass();
            if ((r118 instanceof vda.a) != true) goto L42;
        L43:
            if (r104 == false) goto L47;
            laa.d r119 = this.f388324a.B3();
            if (r119 == null) goto L50;
            laa.d.a.d(r119, true, com.obric.assistant.util.m2.f393770b, null, true, false, null, 52);
        L42:
            r104 = false;
        L9:
            r106 = false;
            goto L10
        }

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void a(float r100, float r101, boolean r102) {
            GradientMaskView r103 = null;
            if (r102 == false) goto L25;
            OrionChatWindowComponent r104 = this.f388324a;
            int r105 = OrionChatWindowComponent.T;
            laa.d r106 = r104.B3();
            int r107 = 0;
            if (r106 == null) goto L11;
            ObricFloatChatPageState r108 = r106.getPageState();
            if (r108 == null) goto L11;
            ObricFloatChatPageData.Companion.getClass();
            boolean r109 = true;
            if ((r108 instanceof vda.a) != true) goto L11;
        L12:
            if (r109 == false) goto L17;
            int r110 = com.obric.assistant.util.m2.f393769a;
            ViewGroup r111 = (ViewGroup) this.f388324a.f388321x.getValue();
            View r112 = this.f388324a.m3();
            FrameLayout r113 = (FrameLayout) this.f388324a.f388323z.getValue();
            va8.c r114 = this.f388324a.p3();
            if (r114 == null) goto L16;
            r103 = ((com.larus.bmhome.chat.component.bottom.core.a) r114).a();
        L16:
            r107 = com.obric.assistant.util.m2.b(r111, r112, r113, r103);
        L22:
            laa.d r115 = this.f388324a.B3();
            if (r115 == null) goto L33;
            r115.o2(r107 + ((int) r101));
            return;
        L33:
            return;
        L17:
            laa.d r116 = this.f388324a.B3();
            if (r116 == null) goto L22;
            ObricFloatChatPageState r117 = r116.getPageState();
            if (r117 == null) goto L22;
            r107 = r117.getHeight();
        L11:
            r109 = false;
            goto L12
        L25:
            OrionChatWindowComponent r118 = this.f388324a;
            int r119 = OrionChatWindowComponent.T;
            laa.d r120 = r118.B3();
            if (r120 == null) goto L31;
            int r121 = com.obric.assistant.util.m2.f393769a;
            ViewGroup r122 = (ViewGroup) this.f388324a.f388321x.getValue();
            View r123 = this.f388324a.m3();
            FrameLayout r124 = (FrameLayout) this.f388324a.f388323z.getValue();
            va8.c r125 = this.f388324a.p3();
            if (r125 == null) goto L30;
            r103 = ((com.larus.bmhome.chat.component.bottom.core.a) r125).a();
        L30:
            r120.o2(com.obric.assistant.util.m2.b(r122, r123, r124, r103));
        L31:
            this.f388325b.d(((v19.i5.q() * 0.15f) * r100) / (v19.i5.q() + (r100 * 0.15f)));
        }
    }

    public static final class c implements Function0<com.larus.bmhome.chat.component.bottom.bottommenu.f1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388326a;

        public c(AttachReceiver r100) {
            this.f388326a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.bottommenu.f1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.bottommenu.f1 invoke() {
            AttachReceiver r100 = this.f388326a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class));
        }
    }

    public static final class d implements Function0<laa.h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388327a;

        public d(AttachReceiver r100) {
            this.f388327a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.h, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.h invoke() {
            AttachReceiver r100 = this.f388327a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.h.class));
        }
    }

    public static final class e implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388328a;

        public e(AttachReceiver r100) {
            this.f388328a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f388328a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class f implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388329a;

        public f(AttachReceiver r100) {
            this.f388329a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f388329a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class g implements Function0<ICoreInputAbility> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388330a;

        public g(AttachReceiver r100) {
            this.f388330a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ICoreInputAbility invoke() {
            AttachReceiver r100 = this.f388330a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class h implements Function0<va8.o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388331a;

        public h(AttachReceiver r100) {
            this.f388331a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.o] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.o invoke() {
            AttachReceiver r100 = this.f388331a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class i implements Function0<va8.a0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388332a;

        public i(AttachReceiver r100) {
            this.f388332a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.a0] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.a0 invoke() {
            AttachReceiver r100 = this.f388332a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.a0.class));
        }
    }

    public static final class j implements Function0<com.larus.bmhome.chat.component.bottom.attachment.g1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388333a;

        public j(AttachReceiver r100) {
            this.f388333a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.attachment.g1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.attachment.g1 invoke() {
            AttachReceiver r100 = this.f388333a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.attachment.g1.class));
        }
    }

    public static final class k implements Function0<laa.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388334a;

        public k(AttachReceiver r100) {
            this.f388334a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.f, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.f invoke() {
            AttachReceiver r100 = this.f388334a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    public static final class l implements Function0<com.larus.bmhome.instruction.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388335a;

        public l(AttachReceiver r100) {
            this.f388335a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.instruction.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.instruction.g invoke() {
            AttachReceiver r100 = this.f388335a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    static {
    }

    @Override // laa.m
    public final void C0(boolean r100, boolean r101) {
    }

    @Override // laa.m
    public final void Rb() {
        GC(false, false, null, null);
    }

    @Override // laa.m
    public final void Tb() {
        GC(true, true, null, null);
    }

    @Override // laa.m
    public final void a7(boolean r100) {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onViewCreated ");
        va8.c r102 = p3();
        if (r102 == null) goto L5;
        ConstraintLayout r103 = ((com.larus.bmhome.chat.component.bottom.core.a) r102).q();
    L6:
        r101.append(r103);
        r100.e("OrionWindowStyleComponent", r101.toString());
        this.B = new w5(this);
        laa.d r104 = B3();
        if (r104 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L21;
        G3((View) this.D.getValue());
        G3(z3());
        G3((Space) this.G.getValue());
        G3((Space) this.H.getValue());
        G3((Space) this.I.getValue());
        G3((Space) this.f388309J.getValue());
        G3((View) this.F.getValue());
        ViewGroup r106 = (ViewGroup) this.f388321x.getValue();
        if (r106 == null) goto L21;
        int r107 = r106.indexOfChild(m3()) - 1;
        Space r108 = (Space) this.G.getValue();
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(v19.i5.m0(), 0);
        r109.endToStart = R.id.input;
        r109.topToTop = R.id.input;
        r109.bottomToBottom = R.id.input;
        Unit r110 = Unit.INSTANCE;
        r106.addView(r108, r107, r109);
        Space r111 = (Space) this.H.getValue();
        ConstraintLayout.LayoutParams r112 = new ConstraintLayout.LayoutParams(v19.i5.m0(), 0);
        r112.startToEnd = R.id.input;
        r112.topToTop = R.id.input;
        r112.bottomToBottom = R.id.input;
        r106.addView(r111, r107, r112);
        Space r113 = (Space) this.I.getValue();
        ConstraintLayout.LayoutParams r114 = new ConstraintLayout.LayoutParams(0, v19.i5.A());
        r114.bottomToTop = R.id.input;
        r114.startToStart = R.id.input;
        r114.endToEnd = R.id.input;
        r106.addView(r113, r107, r114);
        Space r115 = (Space) this.f388309J.getValue();
        ConstraintLayout.LayoutParams r116 = new ConstraintLayout.LayoutParams(0, v19.i5.m0());
        r116.topToBottom = R.id.input;
        r116.startToStart = R.id.input;
        r116.endToEnd = R.id.input;
        r106.addView(r115, r107, r116);
        View r117 = (View) this.D.getValue();
        ConstraintLayout.LayoutParams r118 = new ConstraintLayout.LayoutParams(0, v19.i5.a0());
        r118.topToTop = R.id.bottom_layout;
        r118.startToStart = 0;
        r118.endToEnd = 0;
        r106.addView(r117, r107, r118);
        AudioGradientView r119 = z3();
        ConstraintLayout.LayoutParams r120 = new ConstraintLayout.LayoutParams(0, 0);
        r120.startToStart = R.id.obric_speaker_space_left_view;
        r120.endToEnd = R.id.obric_speaker_space_right_view;
        r120.topToTop = R.id.obric_speaker_space_top_view;
        r120.bottomToBottom = R.id.obric_speaker_space_bottom_view;
        r120.setMarginStart(v19.i5.m());
        r120.setMarginEnd(v19.i5.m());
        ((ViewGroup.MarginLayoutParams) r120).topMargin = v19.i5.q();
        ((ViewGroup.MarginLayoutParams) r120).bottomMargin = v19.i5.m();
        r106.addView(r119, r107, r120);
        View r121 = (View) this.F.getValue();
        ConstraintLayout.LayoutParams r122 = new ConstraintLayout.LayoutParams(0, v19.i5.d());
        r122.bottomToTop = R.id.input;
        r122.startToStart = R.id.input;
        r122.endToEnd = R.id.input;
        ((ViewGroup.MarginLayoutParams) r122).bottomMargin = v19.i5.c0();
        r106.addView(r121, r107, r122);
        ImageView r123 = (ImageView) this.E.getValue();
        ViewGroup r124 = (ViewGroup) this.f388321x.getValue();
        if (r124 == null) goto L19;
        float r125 = r124.getPaddingBottom();
    L20:
        r123.setTranslationY(r125);
        ConstraintLayout.LayoutParams r126 = new ConstraintLayout.LayoutParams(0, 0);
        r126.startToStart = 0;
        r126.endToEnd = 0;
        r126.topToTop = R.id.obric_speaker_bg_top_view;
        r126.bottomToBottom = 0;
        r106.addView(r123, r107, r126);
        Space r127 = (Space) this.K.getValue();
        ConstraintLayout.LayoutParams r128 = new ConstraintLayout.LayoutParams(0, v19.i5.h());
        r128.startToStart = 0;
        r128.topToTop = R.id.input;
        r106.addView(r127, 0, r128);
        ObricIconSwipeUpView r129 = (ObricIconSwipeUpView) this.L.getValue();
        ConstraintLayout.LayoutParams r130 = new ConstraintLayout.LayoutParams(0, v19.c7.b(160));
        r130.startToStart = 0;
        r130.endToEnd = 0;
        r130.bottomToBottom = R.id.obric_gesture_refer_view;
        r106.addView(r129, r130);
        View r131 = (View) this.N.getValue();
        ConstraintLayout.LayoutParams r132 = new ConstraintLayout.LayoutParams(0, 0);
        r132.startToStart = 0;
        r132.endToEnd = 0;
        r132.topToTop = 0;
        r132.bottomToBottom = 0;
        r106.addView(r131, r132);
        goto L21
    L19:
        r125 = 0.0f;
    L21:
        laa.d r133 = B3();
        if (r133 == null) goto L25;
        r133.HU(this);
        return;
    L25:
        return;
    L9:
        if (r104.Da() != true) goto L11;
        r105 = true;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public final laa.d B3() {
        return (laa.d) this.f388312o.getValue();
    }

    public final ValueAnimator h3() {
        return (ValueAnimator) this.M.getValue();
    }

    public final View m3() {
        return (View) this.f388322y.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        ObricInteractionProjectionDelegate.f392943b.c(this.O);
        laa.d r100 = B3();
        if (r100 == null) goto L6;
        r100.AN(this);
        return;
    }

    public final va8.c p3() {
        va8.o r100 = (va8.o) this.f388314q.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Uv();
    }

    @Override // laa.m
    public final ObricIconSwipeUpView qR() {
        return (ObricIconSwipeUpView) this.L.getValue();
    }

    public final AudioGradientView z3() {
        return (AudioGradientView) this.C.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v52, types: [com.obric.assistant.component.e5] */
    public OrionChatWindowComponent() {
        this.f388310m = LazyKt.lazy(new d(this));
        this.f388311n = LazyKt.lazy(new e(this));
        this.f388312o = LazyKt.lazy(new f(this));
        this.f388313p = LazyKt.lazy(new g(this));
        this.f388314q = LazyKt.lazy(new h(this));
        this.f388315r = LazyKt.lazy(new i(this));
        this.f388316s = LazyKt.lazy(new j(this));
        this.f388317t = LazyKt.lazy(new k(this));
        this.f388318u = LazyKt.lazy(new l(this));
        this.f388319v = LazyKt.lazy(new c(this));
        this.f388320w = LazyKt.lazy(new x5(this));
        this.f388321x = LazyKt.lazy(new f5(this));
        this.f388322y = LazyKt.lazy(new g5(this));
        this.f388323z = LazyKt.lazy(new h5(this));
        this.C = LazyKt.lazy(new i5(this));
        this.D = LazyKt.lazy(new j5(this));
        this.E = LazyKt.lazy(new k5(this));
        this.F = LazyKt.lazy(new l5(this));
        this.G = LazyKt.lazy(new n5(this));
        this.H = LazyKt.lazy(new o5(this));
        this.I = LazyKt.lazy(new y5(this));
        this.f388309J = LazyKt.lazy(new z5(this));
        this.K = LazyKt.lazy(new a6(this));
        this.L = LazyKt.lazy(new b6(this));
        this.M = LazyKt.lazy(new c5());
        this.N = LazyKt.lazy(new d5(this));
        this.O = new e5(this);
    }

    public final ViewGroup C3() {
        va8.c r100 = p3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ((com.larus.bmhome.chat.component.bottom.core.a) r100).H();
    }

    @Override // laa.m
    public final View LD() {
        return z3();
    }

    public final View Y2() {
        va8.c r100 = p3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ((com.larus.bmhome.chat.component.bottom.core.a) r100).y();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        laa.d r100 = B3();
        final boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L17;
        List<com.obric.assistant.chat.a> r103 = ObricChatService.f386560m;
        laa.d r104 = B3();
        if (r104 != null) goto L12;
    L14:
        r101 = false;
    L15:
        com.larus.utils.t0.a(new com.obric.assistant.chat.x(r101));
        return;
    L12:
        if (r104.aF() != true) goto L14;
    L17:
        return;
    L5:
        if (r100.Da() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        laa.d r100 = B3();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        List<com.obric.assistant.chat.a> r102 = ObricChatService.f386560m;
        com.larus.utils.t0.a(new com.obric.assistant.chat.y());
        return;
    L10:
        return;
    L5:
        if (r100.Da() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // laa.m
    public final void x8() {
        va8.c r100 = p3();
        if (r100 == null) goto L6;
        r100.g(new r5(this));
        return;
    }

    public final void D3(final boolean r100) {
        if (((Space) this.I.getValue()).getParent() != null) goto L5;
        return;
    L5:
        if (((Space) this.I.getValue()).getLayoutParams() == null) goto L13;
        View r101 = m3();
        if (r101 == null) goto L12;
        r101.post(new u5(this, r100));
        return;
    L12:
        return;
    }

    @Override // laa.m
    public final void DH(boolean r110) {
        FLogger.f375446a.i("OrionWindowStyleComponent", "setVoiceViewVisibleAnimated visible=" + r110 + ", duration=150");
        AnimatorSet r100 = this.S;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.S = null;
        boolean r101 = true;
        float r102 = 0.0f;
        if (r110 == false) goto L103;
        ICoreInputAbility r111 = (ICoreInputAbility) this.f388313p.getValue();
        if (r111 == null) goto L10;
        r111.g2(2, true);
    L10:
        va8.o r112 = (va8.o) this.f388314q.getValue();
        if (r112 == null) goto L13;
        r112.ra();
    L13:
        ICoreInputAbility r113 = (ICoreInputAbility) this.f388313p.getValue();
        if (r113 == null) goto L16;
        r113.qp(false);
    L16:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r114 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388316s.getValue();
        if (r114 != null) goto L19;
    L21:
        boolean r115 = false;
    L22:
        if (r115 == false) goto L30;
        View r116 = Y2();
        if (r116 == null) goto L46;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L29;
        r117.width = 0;
        r116.setLayoutParams(r117);
        goto L46
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L46:
        laa.f r118 = (laa.f) this.f388317t.getValue();
        if (r118 != null) goto L49;
    L51:
        boolean r119 = false;
    L52:
        if (r119 == false) goto L78;
        laa.f r120 = (laa.f) this.f388317t.getValue();
        if (r120 == null) goto L56;
        r120.LE(true);
    L56:
        laa.d r121 = B3();
        if (r121 == null) goto L59;
        r121.C00(true);
    L59:
        this.Q = true;
        ViewGroup r122 = C3();
        if (r122 == null) goto L62;
        r122.setScaleX(0.0f);
    L62:
        ViewGroup r123 = C3();
        if (r123 == null) goto L65;
        r123.setScaleY(0.0f);
    L65:
        laa.d r124 = B3();
        if (r124 != null) goto L68;
    L70:
        boolean r125 = false;
    L71:
        H3(r125);
        laa.d r126 = B3();
        if (r126 != null) goto L74;
    L76:
        r101 = false;
    L77:
        Q3(r101, false);
        return;
    L74:
        if (r126.aF() != true) goto L76;
    L68:
        if (r124.aF() != true) goto L70;
        r125 = true;
        goto L71
    L78:
        com.larus.utils.t0.d(new b5(this), 150);
        laa.d r127 = B3();
        if (r127 == null) goto L81;
        r127.C00(true);
    L81:
        this.Q = true;
        laa.d r128 = B3();
        if (r128 != null) goto L84;
    L86:
        boolean r129 = false;
    L87:
        H3(r129);
        ArrayList r130 = new ArrayList();
        ViewGroup r103 = C3();
        if (r103 == null) goto L90;
        r103.setAlpha(1.0f);
        r103.setScaleX(1.0f);
        r103.setScaleY(1.0f);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r103, View.ALPHA, new float[]{1.0f, 0.0f});
        r104.setDuration(150);
        r104.addListener(new c6(this, r103));
        r130.add(r104);
    L90:
        laa.d r105 = B3();
        if (r105 != null) goto L93;
    L95:
        boolean r106 = false;
    L96:
        boolean r107 = v19.h.f552477a;
        boolean r108 = v19.h.b(getContext());
        if (r106 == false) goto L99;
        float r109 = 1.0f;
    L102:
        ObjectAnimator r131 = ObjectAnimator.ofFloat(z3(), View.ALPHA, new float[]{z3().getAlpha(), r109});
        r131.setDuration(150);
        r131.setStartDelay(150);
        r130.add(r131);
        AnimatorSet r132 = new AnimatorSet();
        r132.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r132.playTogether(r130);
        r132.addListener(new d6(this));
        r132.start();
        this.S = r132;
        return;
    L99:
        if (r108 == false) goto L101;
        r109 = 0.6f;
        goto L102
    L101:
        r109 = 0.32f;
        goto L102
    L93:
        if (r105.aF() != true) goto L95;
        r106 = true;
        goto L96
    L84:
        if (r128.aF() != true) goto L86;
        r129 = true;
        goto L87
    L49:
        if (r118.kT() != true) goto L51;
        r119 = true;
        goto L52
    L30:
        View r133 = Y2();
        if (r133 == null) goto L37;
        ViewGroup.LayoutParams r134 = r133.getLayoutParams();
        if (r134 == null) goto L37;
        if (r134.width != v19.i5.c0()) goto L37;
        boolean r135 = true;
    L38:
        if (r135 == true) goto L46;
        View r136 = Y2();
        if (r136 == null) goto L46;
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
        if (r137 == null) goto L45;
        r137.width = v19.i5.c0();
        r136.setLayoutParams(r137);
        goto L46
    L45:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L37:
        r135 = false;
        goto L38
    L19:
        if (r114.isVisible() != true) goto L21;
        r115 = true;
        goto L22
    L103:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r138 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388316s.getValue();
        if (r138 != null) goto L106;
    L108:
        boolean r139 = false;
    L109:
        if (r139 == true) goto L126;
        View r140 = Y2();
        if (r140 == null) goto L117;
        ViewGroup.LayoutParams r141 = r140.getLayoutParams();
        if (r141 == null) goto L117;
        if (r141.width != v19.i5.c0()) goto L117;
        boolean r142 = true;
    L118:
        if (r142 == true) goto L126;
        View r143 = Y2();
        if (r143 == null) goto L126;
        ViewGroup.LayoutParams r144 = r143.getLayoutParams();
        if (r144 == null) goto L125;
        r144.width = v19.i5.c0();
        r143.setLayoutParams(r144);
        goto L126
    L125:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L117:
        r142 = false;
    L126:
        Function0<Unit> r145 = this.A;
        if (r145 == null) goto L129;
        r145.invoke();
    L129:
        laa.d r146 = B3();
        if (r146 == null) goto L132;
        r146.C00(false);
    L132:
        this.Q = false;
        laa.d r147 = B3();
        if (r147 != null) goto L135;
    L137:
        boolean r148 = false;
    L138:
        H3(r148);
        ArrayList r149 = new ArrayList();
        ViewGroup r150 = C3();
        if (r150 == null) goto L141;
        r150.setAlpha(0.0f);
        r150.setScaleX(1.0f);
        r150.setScaleY(1.0f);
        ObjectAnimator r151 = ObjectAnimator.ofFloat(r150, View.ALPHA, new float[]{0.0f, 1.0f});
        r151.setDuration(150);
        r151.setStartDelay(150);
        r149.add(r151);
    L141:
        laa.d r152 = B3();
        if (r152 != null) goto L144;
    L146:
        boolean r153 = false;
    L147:
        if (r153 == false) goto L149;
        r102 = 0.4f;
    L149:
        ObjectAnimator r154 = ObjectAnimator.ofFloat(z3(), View.ALPHA, new float[]{z3().getAlpha(), r102});
        r154.setDuration(150);
        r149.add(r154);
        com.larus.utils.t0.d(new m5(this), 150);
        AnimatorSet r155 = new AnimatorSet();
        r155.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r155.playTogether(r149);
        r155.addListener(new e6(this));
        r155.start();
        this.S = r155;
        return;
    L144:
        if (r152.aF() != true) goto L146;
        r153 = true;
        goto L147
    L135:
        if (r147.aF() != true) goto L137;
        r148 = true;
        goto L138
    L106:
        if (r138.isVisible() != true) goto L108;
        r139 = true;
        goto L109
    }

    public final void E3(ForegroundInteractionPhase r100) {
        laa.d r101 = B3();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        Object r104 = h3().getAnimatedValue();
        if ((r104 instanceof Float) == false) goto L13;
        Float r105 = (Float) r104;
    L14:
        final float r106 = 1.0f;
        if (r105 == null) goto L18;
        final float r107 = r105.floatValue();
    L32:
        if (r100 != ForegroundInteractionPhase.Activate) goto L34;
    L41:
        if (r102 == true) goto L44;
        r106 = 0.0f;
    L44:
        com.larus.utils.t0.e(new t5(r107, r106, this));
        return;
    L34:
        if (r100 == ForegroundInteractionPhase.Connecting) goto L41;
        if (r100 == ForegroundInteractionPhase.Thinking) goto L41;
        if (r100 == ForegroundInteractionPhase.Listen) goto L41;
        r102 = false;
        goto L41
    L18:
        if (r100 != ForegroundInteractionPhase.Activate) goto L20;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == false) goto L30;
        r107 = 0.0f;
        goto L32
    L30:
        r107 = 1.0f;
        goto L32
    L20:
        if (r100 == ForegroundInteractionPhase.Connecting) goto L27;
        if (r100 == ForegroundInteractionPhase.Thinking) goto L27;
        if (r100 == ForegroundInteractionPhase.Listen) goto L27;
        r108 = false;
        goto L28
    L13:
        r105 = null;
        goto L14
    L5:
        if (r101.aF() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // laa.m
    public final void F0(boolean r100) {
        com.larus.bmhome.instruction.g r101 = (com.larus.bmhome.instruction.g) this.f388318u.getValue();
        boolean r102 = false;
        if (r101 == null) goto L5;
        boolean r103 = r101.z0();
    L6:
        if (r103 == true) goto L8;
        if (r100 == true) goto L8;
    L9:
        D3(r102);
        return;
    L8:
        r102 = true;
        goto L9
    L5:
        r103 = false;
        goto L6
    }

    public final void G3(View r100) {
        if (r100.getParent() != null) goto L5;
        return;
    L5:
        if ((r100.getParent() instanceof ViewGroup) == false) goto L14;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L9;
        ViewGroup r102 = (ViewGroup) r101;
    L10:
        if (r102 == null) goto L15;
        r102.removeView(r100);
        return;
    L15:
        return;
    L9:
        r102 = null;
        goto L10
    }

    public final void H3(boolean r100) {
        ObricInteractDelegate r101 = ObricInteractDelegate.f392884b;
        Boolean r102 = r101.isAiKeyPressing();
        Boolean r103 = Boolean.TRUE;
        boolean r104 = true;
        if (Intrinsics.areEqual(r102, r103) == false) goto L5;
    L8:
        boolean r105 = true;
    L9:
        FLogger.f375446a.i("OrionWindowStyleComponent", "updateGestureViewVisibility, isChatWindow=" + r100 + ", hideForAiKeyWakeup=" + r105);
        ObricIconSwipeUpView r106 = (ObricIconSwipeUpView) this.L.getValue();
        if (r100 == false) goto L13;
        if (r105 == true) goto L13;
    L14:
        r106.setEnabled(r104);
        if (r100 == false) goto L18;
        if (r105 == true) goto L18;
        com.larus.utils.e1.x((ObricIconSwipeUpView) this.L.getValue());
        return;
    L18:
        com.larus.utils.e1.o((ObricIconSwipeUpView) this.L.getValue());
        return;
    L13:
        r104 = false;
        goto L14
    L5:
        if (Intrinsics.areEqual(r101.isAiKeyLongPress(), r103) == true) goto L8;
        r105 = false;
        goto L9
    }

    @Override // laa.m
    public final void I2(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.A = r100;
    }

    @Override // laa.m
    public final void L10(float r100) {
        laa.d r101 = B3();
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.aF() != true) goto L7;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        if (r100 >= 0.0f) goto L13;
        r100 = 0.0f;
    L15:
        ((ImageView) this.E.getValue()).setAlpha(r100);
        return;
    L13:
        if (r100 <= 1.0f) goto L15;
        r100 = 1.0f;
    L7:
        r102 = false;
        goto L8
    }

    @Override // laa.m
    public final void MP(laa.n r100) {
        GC(true, false, r100, null);
    }

    @Override // laa.m
    public final void N60(boolean r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onSpeakerStatusSwitch toCancel ");
        r102.append(r100);
        r102.append(", pageState is ");
        laa.d r103 = B3();
        if (r103 == null) goto L5;
        ObricFloatChatPageState r104 = r103.getPageState();
    L6:
        r102.append(r104);
        r101.i("OrionWindowStyleComponent", r102.toString());
        z3().setWarning(r100);
        laa.d r105 = B3();
        boolean r106 = false;
        if (r105 != null) goto L9;
    L11:
        Q3(r106, r100);
        return;
    L9:
        if (r105.aF() != true) goto L11;
        r106 = true;
        goto L11
    L5:
        r104 = null;
        goto L6
    }

    @Override // laa.m
    public final void j1(boolean r100) {
        com.larus.bmhome.chat.component.bottom.attachment.g1 r101 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388316s.getValue();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        if (r100 == true) goto L10;
    L11:
        D3(r102);
        return;
    L10:
        r102 = true;
        goto L11
    L5:
        if (r101.isVisible() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // hca.b
    public final void r2(boolean r100) {
        FLogger.f375446a.i("OrionWindowStyleComponent", "onChatStyleChanged isChatWindow = " + r100);
        if (r100 == false) goto L7;
        va8.a0 r101 = (va8.a0) this.f388315r.getValue();
        if (r101 == null) goto L8;
        r101.Z7(new v5(this));
    L8:
        H3(r100);
        return;
    L7:
        ObricInteractionProjectionDelegate.f392943b.c(this.O);
        goto L8
    }

    @Override // laa.m
    public final void rT(boolean r100) {
        this.R = r100;
        laa.d r101 = B3();
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.aF() != true) goto L7;
    L8:
        Q3(r102, false);
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // laa.m
    public final void v00(boolean r100) {
        this.P = r100;
        laa.d r101 = B3();
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.aF() != true) goto L7;
    L8:
        Q3(r102, false);
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // hca.b
    public final void x1(ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
    }

    public final void Q3(boolean r100, boolean r101) {
        IAssistantChatWindow r102 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r103 = true;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        float r105 = 0.0f;
        if (r104 == false) goto L12;
        z3().setAlpha(0.0f);
        z3().setVisibility(8);
        return;
    L12:
        z3().setVisibility(0);
        AudioGradientView r106 = z3();
        if (this.P == false) goto L15;
    L20:
        if (r103 == false) goto L29;
        boolean r107 = v19.h.f552477a;
        boolean r108 = v19.h.b(getContext());
        if (r100 == false) goto L24;
        r105 = 1.0f;
    L31:
        r106.setAlpha(r105);
        return;
    L24:
        if (r101 == true) goto L28;
        if (r108 == true) goto L28;
        r105 = 0.32f;
    L28:
        r105 = 0.6f;
        goto L31
    L29:
        if (r100 == false) goto L31;
        r105 = 0.4f;
        goto L31
    L15:
        if (this.Q == true) goto L20;
        if (this.R == true) goto L20;
        r103 = false;
        goto L20
    L5:
        if (r102.isWindowMode() != true) goto L7;
        r104 = true;
        goto L8
    }

    @Override // laa.m
    public final void uA(float r100, final boolean r101) {
        FLogger.f375446a.i("OrionWindowStyleComponent", "resetChatWindowLightAlpha " + r100 + ' ' + r101);
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r102 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) this.f388319v.getValue();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        ((ImageView) this.E.getValue()).setAlpha(r100);
    L22:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r104 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) this.f388319v.getValue();
        if (r104 == null) goto L25;
        r104.t00(new p5(this, r101));
    L25:
        Q3(!r101, false);
        return;
    L10:
        if (r101 == false) goto L22;
        if (((ImageView) this.E.getValue()).getAlpha() != 0.0f) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == true) goto L22;
        if (r100 != 0.0f) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
        ((ImageView) this.E.getValue()).setAlpha(r100);
        goto L22
    L19:
        r106 = false;
        goto L20
    L14:
        r105 = false;
        goto L15
    L5:
        if (r102.sL() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // laa.m
    public final void GC(boolean r100, boolean r101, laa.n r102, String r103) {
        FLogger.f375446a.i("OrionWindowStyleComponent", "setVoiceViewVisible " + r100 + ", playWelcomeAnimation " + r101);
        boolean r104 = true;
        if (r100 == false) goto L20;
        IAssistantChatWindow r105 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r105 != null) goto L7;
    L9:
        boolean r106 = false;
    L10:
        if (r106 == true) goto L20;
        ICoreInputAbility r107 = (ICoreInputAbility) this.f388313p.getValue();
        if (r107 == null) goto L14;
        r107.g2(2, true);
    L14:
        va8.o r108 = (va8.o) this.f388314q.getValue();
        if (r108 == null) goto L17;
        r108.ra();
    L17:
        ICoreInputAbility r109 = (ICoreInputAbility) this.f388313p.getValue();
        if (r109 == null) goto L20;
        r109.qp(false);
        goto L20
    L7:
        if (r105.isWindowMode() != true) goto L9;
        r106 = true;
    L20:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r110 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.f388316s.getValue();
        if (r110 != null) goto L23;
    L25:
        boolean r111 = false;
    L27:
        if (r111 == false) goto L36;
        if (r100 == false) goto L36;
        View r112 = Y2();
        if (r112 == null) goto L52;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L35;
        r113.width = 0;
        r112.setLayoutParams(r113);
        goto L52
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L52:
        float r114 = 1.0f;
        if (r100 == false) goto L55;
        float r115 = 0.0f;
    L56:
        ViewGroup r116 = C3();
        if (r116 == null) goto L59;
        r116.setScaleX(r115);
    L59:
        ViewGroup r117 = C3();
        if (r117 == null) goto L62;
        r117.setScaleY(r115);
    L62:
        va8.a0 r118 = (va8.a0) this.f388315r.getValue();
        if (r118 == null) goto L65;
        wc9.e r119 = r118.h();
    L66:
        ViewGroup r120 = C3();
        if (r120 == null) goto L80;
        if (r119 != null) goto L70;
    L79:
        r120.setAlpha(r114);
        goto L80
    L70:
        if (com.larus.bmhome.utils.i.h(r119) == true) goto L79;
        ViewGroup r121 = C3();
        if (r121 != null) goto L74;
    L76:
        boolean r122 = false;
    L77:
        if (r122 == true) goto L79;
        r114 = 0.3f;
        goto L79
    L74:
        if (r121.isEnabled() != true) goto L76;
        r122 = true;
    L80:
        if (r100 == true) goto L84;
        Function0<Unit> r123 = this.A;
        if (r123 == null) goto L84;
        r123.invoke();
    L84:
        laa.f r124 = (laa.f) this.f388317t.getValue();
        if (r124 == null) goto L87;
        r124.Fj(r100, r101, r102, r103);
    L87:
        laa.d r125 = B3();
        if (r125 == null) goto L90;
        r125.C00(r100);
    L90:
        this.Q = r100;
        laa.d r126 = B3();
        if (r126 != null) goto L93;
    L95:
        boolean r127 = false;
    L96:
        H3(r127);
        laa.d r128 = B3();
        if (r128 != null) goto L99;
    L101:
        r104 = false;
    L102:
        Q3(r104, false);
        return;
    L99:
        if (r128.aF() != true) goto L101;
    L93:
        if (r126.aF() != true) goto L95;
        r127 = true;
        goto L96
    L65:
        r119 = null;
        goto L66
    L55:
        r115 = 1.0f;
    L36:
        View r129 = Y2();
        if (r129 == null) goto L43;
        ViewGroup.LayoutParams r130 = r129.getLayoutParams();
        if (r130 == null) goto L43;
        if (r130.width != v19.i5.c0()) goto L43;
        boolean r131 = true;
    L44:
        if (r131 == true) goto L52;
        View r132 = Y2();
        if (r132 == null) goto L52;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if (r133 == null) goto L51;
        r133.width = v19.i5.c0();
        r132.setLayoutParams(r133);
        goto L52
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L43:
        r131 = false;
        goto L44
    L23:
        if (r110.isVisible() != true) goto L25;
        r111 = true;
        goto L27
    }
}
