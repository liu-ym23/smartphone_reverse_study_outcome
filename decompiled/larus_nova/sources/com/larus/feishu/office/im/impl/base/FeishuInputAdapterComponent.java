package com.larus.feishu.office.im.impl.base;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.asr.config.builder.ChatSpeakerElementKey;
import com.larus.asr.config.builder.ChatSpeakerScene;
import com.larus.asr.direct.IAsrDirectFillAbility;
import com.larus.asr.e2;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.e1;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.common_ui.view.SuggestedActionBar;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.keyboard.biz.plus.inject.PlusInnerEndPlugin;
import com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u008a\u0001\u0018\u0000 Ö\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Ö\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u008e\u0001\u001a\u000200H\u0016J\t\u0010\u008f\u0001\u001a\u000200H\u0016J\t\u0010\u0090\u0001\u001a\u000200H\u0016J\f\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0016J\f\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u0016J\u0014\u0010\u0094\u0001\u001a\u0002002\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010\u0096\u0001\u001a\u0002002\u0007\u0010\u0097\u0001\u001a\u00020DH\u0016J\u000b\u0010\u0098\u0001\u001a\u0004\u0018\u00010,H\u0016J\u000b\u0010\u0099\u0001\u001a\u0004\u0018\u00010,H\u0016J&\u0010\u009a\u0001\u001a\u0002002\u001b\u0010\u0097\u0001\u001a\u0016\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.H\u0016J\u001b\u0010\u009b\u0001\u001a\u0002002\u0007\u0010\u009c\u0001\u001a\u00020/2\u0007\u0010\u009d\u0001\u001a\u00020/H\u0016J\t\u0010\u009e\u0001\u001a\u000200H\u0016J\n\u0010\u009f\u0001\u001a\u00030 \u0001H\u0016J\n\u0010¡\u0001\u001a\u00030 \u0001H\u0016J\u001e\u0010¢\u0001\u001a\u0002002\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020402H\u0016J\u0013\u0010¤\u0001\u001a\u0002002\b\u0010¥\u0001\u001a\u00030 \u0001H\u0016J\t\u0010¦\u0001\u001a\u000200H\u0016J\t\u0010§\u0001\u001a\u000200H\u0016J\u000b\u0010¨\u0001\u001a\u0004\u0018\u000106H\u0016J\u000b\u0010©\u0001\u001a\u0004\u0018\u000106H\u0016J\t\u0010ª\u0001\u001a\u000200H\u0016J\t\u0010«\u0001\u001a\u000200H\u0016J\u0013\u0010«\u0001\u001a\u0002002\b\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\n\u0010®\u0001\u001a\u00030 \u0001H\u0002J\n\u0010¯\u0001\u001a\u00030 \u0001H\u0016J\u0011\u0010°\u0001\u001a\n\u0012\u0005\u0012\u00030 \u00010\u0085\u0001H\u0016J\u0016\u0010±\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0R0\u0085\u0001H\u0016J\u000f\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020S0RH\u0016J\u001a\u0010³\u0001\u001a\u00030 \u00012\u000e\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030µ\u00010RH\u0016J\u0012\u0010¶\u0001\u001a\u0002002\u0007\u0010·\u0001\u001a\u00020SH\u0016J\u0012\u0010¸\u0001\u001a\u0002002\u0007\u0010·\u0001\u001a\u00020SH\u0016J\u001a\u0010¹\u0001\u001a\u0002002\u000f\u0010º\u0001\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010RH\u0016J\t\u0010»\u0001\u001a\u000200H\u0016J\u0012\u0010¼\u0001\u001a\u0002002\u0007\u0010\u0097\u0001\u001a\u00020JH\u0016J\u0014\u0010½\u0001\u001a\u0002002\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010PH\u0016J\u0012\u0010¾\u0001\u001a\u0002002\u0007\u0010\u0097\u0001\u001a\u00020UH\u0016J\u0013\u0010¿\u0001\u001a\u0002002\b\u0010À\u0001\u001a\u00030Á\u0001H\u0016J\u0012\u0010Â\u0001\u001a\u0002002\u0007\u0010Ã\u0001\u001a\u00020/H\u0016J%\u0010Ä\u0001\u001a\u0002002\b\u0010Å\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u00020/2\u0007\u0010Ç\u0001\u001a\u00020/H\u0016J8\u0010È\u0001\u001a\u0002002\b\u0010Å\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u00020/2\u0007\u0010Ç\u0001\u001a\u00020/2\u0007\u0010É\u0001\u001a\u00020/2\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0016J/\u0010Ì\u0001\u001a\u0002002\b\u0010Å\u0001\u001a\u00030 \u00012\u0007\u0010Æ\u0001\u001a\u00020/2\u0007\u0010Ç\u0001\u001a\u00020/2\b\u0010Í\u0001\u001a\u00030 \u0001H\u0016J\u0016\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0016J\t\u0010Ò\u0001\u001a\u000200H\u0002J\u0012\u0010Ó\u0001\u001a\u0002032\u0007\u0010·\u0001\u001a\u00020SH\u0002J\n\u0010Ô\u0001\u001a\u00030 \u0001H\u0016J\u0013\u0010Õ\u0001\u001a\u0002002\b\u0010Ô\u0001\u001a\u00030 \u0001H\u0016R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010-\u001a\u0016\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020402X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00105\u001a\u0004\u0018\u0001068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u0001068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\f\u001a\u0004\b;\u00108R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010V\u001a\u0004\u0018\u00010W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\f\u001a\u0004\bX\u0010YR\u001d\u0010[\u001a\u0004\u0018\u00010\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\f\u001a\u0004\b]\u0010^R\u001d\u0010`\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\f\u001a\u0004\bb\u0010cR\u0016\u0010e\u001a\u0004\u0018\u00010f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u001d\u0010i\u001a\u0004\u0018\u00010j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\f\u001a\u0004\bk\u0010lR\u001d\u0010n\u001a\u0004\u0018\u00010o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\f\u001a\u0004\bp\u0010qR\u001d\u0010s\u001a\u0004\u0018\u00010t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\f\u001a\u0004\bu\u0010vR*\u0010x\u001a\u001e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020z0yj\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020z`{X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020}X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020}X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0084\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0R0\u0085\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0088\u0001\u0010\f\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010\u0089\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008d\u0001\u0010\f\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001¨\u0006×\u0001"}, d2 = {"Lcom/larus/feishu/office/im/impl/base/FeishuInputAdapterComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/feishu/office/im/impl/base/FeishuInput/FeishuAdapterAbility;", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendConfigAbility;", "Lcom/larus/bmhome/ability/IInputBottomMenuContainerAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "touchSpeakerAbility", "Lcom/larus/asr/ITouchSpeakerAbility;", "getTouchSpeakerAbility", "()Lcom/larus/asr/ITouchSpeakerAbility;", "touchSpeakerAbility$delegate", "asrDirectFillAbility", "Lcom/larus/asr/direct/IAsrDirectFillAbility;", "getAsrDirectFillAbility", "()Lcom/larus/asr/direct/IAsrDirectFillAbility;", "asrDirectFillAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "bottomMenuGridView", "Landroid/view/ViewGroup;", "bottomMenuHeightCallback", "Lkotlin/Function2;", "", "", "plusPanelChatParams", "", "", "", "touchSpeakView", "Landroid/view/View;", "getTouchSpeakView", "()Landroid/view/View;", "touchSpeakView$delegate", "touchSpeakFloatMaskView", "getTouchSpeakFloatMaskView", "touchSpeakFloatMaskView$delegate", "feishuVoiceContext", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/voice/VoiceInputExtension$VoiceContext;", "getFeishuVoiceContext", "()Lcom/ss/android/lark/biz/im/api/extension/keyboard/voice/VoiceInputExtension$VoiceContext;", "setFeishuVoiceContext", "(Lcom/ss/android/lark/biz/im/api/extension/keyboard/voice/VoiceInputExtension$VoiceContext;)V", "feishuCallback", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/voice/VoiceInputExtension$VoiceInputCallback;", "getFeishuCallback", "()Lcom/ss/android/lark/biz/im/api/extension/keyboard/voice/VoiceInputExtension$VoiceInputCallback;", "setFeishuCallback", "(Lcom/ss/android/lark/biz/im/api/extension/keyboard/voice/VoiceInputExtension$VoiceInputCallback;)V", "plusMenuCallback", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/menu/IKeyboardMenuCallback;", "getPlusMenuCallback", "()Lcom/ss/android/lark/biz/im/api/extension/keyboard/menu/IKeyboardMenuCallback;", "setPlusMenuCallback", "(Lcom/ss/android/lark/biz/im/api/extension/keyboard/menu/IKeyboardMenuCallback;)V", "attachmentEntityChangeCallback", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/IAttachmentEntityChangeCallback;", "previousAttachmentEntities", "", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkFileEntity;", "suggestButtonContentCallback", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/ISuggestButtonContentCallback;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "chatMessageAbility", "Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "getChatMessageAbility", "()Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "chatMessageAbility$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "multimodalPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility;", "getMultimodalPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility;", "multimodalPanelAbility$delegate", "plusPanelItemConfigs", "Ljava/util/LinkedHashMap;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility$PanelItemConfig;", "Lkotlin/collections/LinkedHashMap;", "plusPanelItemProcessor", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility$PanelItemConfigProcessor;", "plusPanelClickTraceProcessor", "runningTaskId", "runningTaskData", "", "componentScope", "Lkotlinx/coroutines/CoroutineScope;", "transformedAttachmentEntityListStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getTransformedAttachmentEntityListStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "transformedAttachmentEntityListStateFlow$delegate", "chatSpeakerStateListener", "com/larus/feishu/office/im/impl/base/FeishuInputAdapterComponent$chatSpeakerStateListener$2$1", "getChatSpeakerStateListener", "()Lcom/larus/feishu/office/im/impl/base/FeishuInputAdapterComponent$chatSpeakerStateListener$2$1;", "chatSpeakerStateListener$delegate", "onAttach", "onParentViewCreated", "onFragmentViewDestroyed", "takeTouchSpeakView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "takeTouchSpeakMaskView", "registerVoiceContext", "voiceContext", "registerVoiceInputCallback", "callback", "takeAttachmentPanelView", "takeBottomMenuGridView", "registerBottomMenuHeightCallback", "onBottomMenuHeightChanged", "curHeight", "normalHeight", LiveCommonConstants.REASON_ON_DEDTROY, "disableBottomMenuHoldSpace", "", "disableHideBottomMenu", "updatePlusPanelChatParams", "chatParams", "switchMenuEntranceStatus", "isSelect", "clearFastAlbumSelection", "restoreBottomMenuAfterSend", "takeSuggestedActionView", "obtainDividerActionbarView", "startAlbum", "startCamera", "uiConfig", "Lcom/larus/bmhome/camera/ChatCameraUiAbilityConfig;", "isAttachmentSizeExceedMax", "isVisible", "getHasAttachmentDisplayStateFlow", "getAttachmentEntityListStateFlow", "getAttachmentEntities", "pasteMediaUris", "uris", "Landroid/net/Uri;", "addAttachmentEntity", "entity", "updateAttachmentEntity", "removeAllAttachmentEntities", "entities", "closeAttachmentPanel", "registerKeyboardMenuCallback", "registerAttachmentEntityChangeCallback", "registerSuggestButtonContentCallback", "registerPanelItemConfig", "panelItemConfig", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/plus/PanelItemConfig;", "onImeWrapperHeightChange", "height", "onPanelHeightAnimationStart", "isShow", "from", RemoteMessageConst.TO, "onPanelHeightAnimationUpdate", "current", "fraction", "", "onPanelHeightAnimationEnd", "isCanceled", "getRejectInputTextTouchListener", "Landroid/view/View$OnTouchListener;", "editText", "Landroid/widget/EditText;", "doCloseBottomMenu", "entityCompareKey", "isVoiceInputMode", "setVoiceInputMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeishuInputAdapterComponent extends ComponentFeature implements w99.a, com.larus.bmhome.chat.component.fastsend.d0, va8.h0 {
    public static final /* synthetic */ int M = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final LinkedHashMap<String, com.larus.bmhome.chat.component.bottom.multimodal.h.a> E;
    public final x F;
    public final y G;
    public String H;
    public byte[] I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final CoroutineScope f343131J;
    public final Lazy K;
    public final Lazy L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f343132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f343133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f343134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f343135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f343136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f343137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f343138n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f343139o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, ? extends Object> f343140p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f343141q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f343142r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public fya.a.b f343143s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public fya.a.c f343144t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public dya.a f343145u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public wxa.c f343146v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List<UplinkFileEntity> f343147w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public wxa.d f343148x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f343149y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f343150z;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.component.bottom.core.speaker.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeishuInputAdapterComponent f343151a;

        public b(FeishuInputAdapterComponent r100) {
            this.f343151a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.h
        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.c) == false) goto L8;
            fya.a.c r101 = this.f343151a.f343144t;
            if (r101 == null) goto L30;
            r101.e(fya.a.AbstractC5966a.c.f479328a);
            return;
        L30:
            return;
        L8:
            if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L13;
            fya.a.c r102 = this.f343151a.f343144t;
            if (r102 == null) goto L32;
            r102.e(new fya.a.AbstractC5966a.e(((com.larus.bmhome.chat.component.bottom.core.speaker.g.e) r100).f299423a));
            return;
        L32:
            return;
        L13:
            if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.d) == false) goto L18;
            fya.a.c r103 = this.f343151a.f343144t;
            if (r103 == null) goto L34;
            r103.e(new fya.a.AbstractC5966a.d(((com.larus.bmhome.chat.component.bottom.core.speaker.g.d) r100).f299422a));
            return;
        L34:
            return;
        L18:
            if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.a) == false) goto L23;
            fya.a.c r104 = this.f343151a.f343144t;
            if (r104 == null) goto L36;
            r104.e(fya.a.AbstractC5966a.C5967a.f479326a);
            return;
        L36:
            return;
        L23:
            if ((r100 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.b) == false) goto L29;
            fya.a.c r105 = this.f343151a.f343144t;
            if (r105 == null) goto L38;
            r105.e(fya.a.AbstractC5966a.b.f479327a);
            return;
        L38:
            return;
        L29:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c implements Function1<rp8.d, rp8.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t1a.c f343152a;

        public c(rp8.d r100) {
            this.f343152a = r100;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [rp8.d, t1a.c] */
        @Override // kotlin.jvm.functions.Function1
        public final rp8.d invoke(rp8.d r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return this.f343152a;
        }
    }

    public static final class d implements Function1<rp8.c, rp8.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t1a.c f343153a;

        public d(rp8.c r100) {
            this.f343153a = r100;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [rp8.c, t1a.c] */
        @Override // kotlin.jvm.functions.Function1
        public final rp8.c invoke(rp8.c r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return this.f343153a;
        }
    }

    public static final class e implements gd8.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeishuInputAdapterComponent f343154a;

        public e(FeishuInputAdapterComponent r100) {
            this.f343154a = r100;
        }

        @Override // gd8.h
        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "content");
            Intrinsics.checkNotNullParameter(r101, "scene");
            FLogger.f375446a.i("FeishuInputAdapterComponent", "[MessageSendDelegate] sendText intercepted, content: " + r100);
        }

        @Override // gd8.h
        public final void a(String r100, String r101, List<com.larus.im.bean.message.UplinkFileEntity> r102, String r110, String r111, Boolean r112) {
            Intrinsics.checkNotNullParameter(r101, "content");
            Intrinsics.checkNotNullParameter(r102, "entities");
            Intrinsics.checkNotNullParameter(r110, "txtScene");
            FLogger.f375446a.i("FeishuInputAdapterComponent", "[MessageSendDelegate] sendFileAndTxt intercepted, content: " + r101 + ", entities size: " + ((ArrayList) r102).size());
            ArrayList r103 = new ArrayList();
            Iterator<T> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L51;
            com.larus.im.bean.message.UplinkFileEntity r113 = (com.larus.im.bean.message.UplinkFileEntity) r104.next();
            int r114 = v99.b.f553843a;
            Intrinsics.checkNotNullParameter(r113, "source");
            String[] r115 = new String[5];
            Uri r105 = r113.getUri();
            if (r105 == null) goto L8;
            String r106 = r105.toString();
        L9:
            boolean r107 = false;
            r115[0] = r106;
            UplinkEntityContent r108 = r113.getUplinkEntityContent();
            if (r108 == null) goto L14;
            UplinkFileInfo r109 = r108.getUplinkFileInfo();
            if (r109 == null) goto L14;
            String r116 = r109.getTosKey();
        L15:
            r115[1] = r116;
            UplinkEntityContent r117 = r113.getUplinkEntityContent();
            if (r117 == null) goto L22;
            UplinkFileInfo r118 = r117.getUplinkFileInfo();
            if (r118 == null) goto L22;
            VideoExtension r119 = r118.getVideo();
            if (r119 == null) goto L22;
            String r120 = r119.getVid();
        L23:
            r115[2] = r120;
            UplinkEntityContent r121 = r113.getUplinkEntityContent();
            if (r121 == null) goto L32;
            UplinkFileInfo r122 = r121.getUplinkFileInfo();
            if (r122 == null) goto L32;
            VideoExtension r123 = r122.getVideo();
            if (r123 == null) goto L32;
            Image r124 = r123.getCover();
            if (r124 == null) goto L32;
            String r125 = r124.key;
        L33:
            r115[3] = r125;
            UplinkEntityContent r126 = r113.getUplinkEntityContent();
            if (r126 == null) goto L38;
            Image r127 = r126.getUplinkImageInfo();
            if (r127 == null) goto L38;
            String r128 = r127.key;
        L39:
            r115[4] = r128;
            List r129 = CollectionsKt.listOfNotNull(r115);
            if ((r129 instanceof Collection) == true) goto L42;
        L44:
            Iterator r130 = r129.iterator();
        L46:
            if (r130.hasNext() == false) goto L50;
            if (StringsKt.startsWith$default((String) r130.next(), "imkey://", false, 2, null) == false) goto L46;
            r107 = true;
        L50:
            r103.add(v99.b.c(r113, r107));
            goto L4
        L42:
            if (r129.isEmpty() == false) goto L44;
        L38:
            r128 = null;
        L32:
            r125 = null;
        L22:
            r120 = null;
        L14:
            r116 = null;
            goto L15
        L8:
            r106 = null;
            goto L9
        L51:
            wxa.d r131 = this.f343154a.f343148x;
            if (r131 == null) goto L61;
            r131.a(r101, r103, r110);
            return;
        }
    }

    static {
    }

    @Override // w99.a
    public final void Lq() {
    }

    @Override // com.larus.bmhome.chat.component.fastsend.d0
    public final void o90() {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
    }

    @Override // va8.h0
    public final void sy(int r100, int r101) {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        com.larus.bmhome.chat.component.bottom.multimodal.h r100 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.D.getValue();
        if (r100 == null) goto L5;
        r100.q80(this.F);
    L5:
        com.larus.bmhome.chat.component.bottom.multimodal.h r101 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.D.getValue();
        if (r101 == null) goto L8;
        r101.q80(this.G);
    L8:
        this.E.clear();
        com.larus.bmhome.chat.component.bottom.core.speaker.l r102 = N2();
        if (r102 == null) goto L12;
        r102.B9((b) this.L.getValue());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.larus.feishu.office.im.impl.base.v] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.larus.feishu.office.im.impl.base.p] */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.larus.feishu.office.im.impl.base.o] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.larus.feishu.office.im.impl.base.q0] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.larus.feishu.office.im.impl.base.r0] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        FLogger.f375446a.i("FeishuInputAdapterComponent", "[onViewCreated]");
        boolean r100 = z2.f365865a.inputComponentConfig().getFeishuInputConfigEnable();
        z8 r101 = (z8) this.f343149y.getValue();
        if (r101 == null) goto L5;
        r101.z9(true);
    L5:
        z8 r102 = (z8) this.f343149y.getValue();
        if (r102 == null) goto L8;
        r102.w9(false);
    L8:
        String r103 = null;
        if (r100 == false) goto L16;
        rp8.d r104 = new rp8.d(Boolean.TRUE, Boolean.FALSE, null, null, 60);
        t1a.e r105 = s1a.d.a(this).p(Reflection.getOrCreateKotlinClass(rp8.d.class));
        if (r105 == null) goto L13;
        r105.a(new c(r104));
    L22:
        ICoreInputAbility r106 = L2();
        if (r106 == null) goto L25;
        r106.Dh(new k(this));
    L25:
        zb8.e r107 = (zb8.e) this.f343135k.getValue();
        if (r107 == null) goto L28;
        r107.wl();
    L28:
        IAsrDirectFillAbility r108 = (IAsrDirectFillAbility) this.f343137m.getValue();
        if (r108 == null) goto L31;
        r108.Il();
    L31:
        com.larus.bmhome.chat.component.bottom.multimodal.g r109 = r5();
        if (r109 == null) goto L34;
        r109.l90();
    L34:
        com.larus.bmhome.chat.component.bottom.multimodal.g r110 = r5();
        if (r110 == null) goto L37;
        r110.pd(true);
    L37:
        com.larus.bmhome.chat.component.bottom.multimodal.g r111 = r5();
        if (r111 == null) goto L40;
        r111.bh(true);
    L40:
        f1 r112 = F2();
        if (r112 == null) goto L43;
        r112.KO();
    L43:
        com.larus.bmhome.chat.component.bottom.multimodal.g r113 = r5();
        if (r113 == null) goto L46;
        r113.Xc(Boolean.TRUE);
    L46:
        com.larus.bmhome.chat.component.bottom.multimodal.g r114 = r5();
        if (r114 == null) goto L49;
        r114.pn();
    L49:
        com.larus.bmhome.chat.component.bottom.multimodal.g r115 = r5();
        if (r115 == null) goto L52;
        r115.pm();
    L52:
        if (r100 == false) goto L59;
        rp8.c r116 = new rp8.c(Boolean.FALSE, 7);
        t1a.e r117 = s1a.d.a(this).p(Reflection.getOrCreateKotlinClass(rp8.c.class));
        if (r117 == null) goto L56;
        r117.a(new d(r116));
    L62:
        com.larus.bmhome.chat.component.bottom.multimodal.h r118 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.D.getValue();
        if (r118 == null) goto L65;
        r118.xp(this.F);
    L65:
        com.larus.bmhome.chat.component.bottom.multimodal.h r119 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.D.getValue();
        if (r119 == null) goto L68;
        r119.xp(this.G);
    L68:
        com.larus.bmhome.chat.component.bottom.multimodal.g r120 = r5();
        if (r120 == null) goto L71;
        r120.x2(new ns8.b(true, true, true, true, true, 64));
    L71:
        g1 r121 = f70();
        if (r121 == null) goto L74;
        r121.o50();
    L74:
        g1 r122 = f70();
        if (r122 == null) goto L77;
        r122.yQ(new p0());
    L77:
        g1 r123 = f70();
        if (r123 == null) goto L80;
        r123.Za();
    L80:
        bc8.a r124 = (bc8.a) this.C.getValue();
        if (r124 == 0) goto L83;
        r124.G8(new q0());
    L83:
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new FeishuInputAdapterComponent$onParentViewCreated$4(this, null), 3, null);
        com.larus.bmhome.chat.component.fastsend.e0 r125 = (com.larus.bmhome.chat.component.fastsend.e0) this.f343138n.getValue();
        if (r125 == null) goto L99;
        com.larus.bmhome.chat.api.e0 r126 = AuthModelDelegate.f297134b.e().getValue();
        if (r126 == null) goto L90;
        LaunchInfo r127 = r126.f297186a;
        if (r127 == null) goto L90;
        String r128 = r127.W();
    L91:
        IAuthModelService r129 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r129 == null) goto L98;
        LiveData<wc9.e> r130 = r129.y();
        if (r130 == null) goto L98;
        wc9.e r131 = r130.getValue();
        if (r131 == null) goto L98;
        r103 = r131.f559198a;
    L98:
        r125.At(new kq9.e(r128, r103, 1, null, null, null, null, null, null, null, null, null, 4088));
    L90:
        r128 = null;
    L99:
        gd8.g r132 = (gd8.g) this.B.getValue();
        if (r132 == null) goto L102;
        r132.MU(new e(this));
    L102:
        x48.b r133 = new x48.b(new z48.a(new a58.a(new r0(this), 2), new b58.a(new s0(), new l(), new m()), 2), 6);
        if (y48.h.a() == false) goto L128;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r134 = N2();
        if (r134 == null) goto L131;
        int r135 = y48.f.f566092h;
        y48.f r136 = y48.f.a.a();
        ChatSpeakerScene r137 = ChatSpeakerScene.FeiShu;
        Intrinsics.checkNotNullParameter(r137, "scene");
        r136.f566093a = r137;
        r136.b(r133);
        Intrinsics.checkNotNullParameter(r136, "<this>");
        z48.a r138 = r133.f562448a;
        if (r138 == null) goto L127;
        final a58.a r139 = r138.f570033a;
        if (r139 == null) goto L115;
        Function1 r140 = new com.larus.feishu.office.im.impl.base.a(r139);
        Intrinsics.checkNotNullParameter(r140, "configure");
        ChatSpeakerElementKey r141 = ChatSpeakerElementKey.Tips;
        Map<ChatSpeakerElementKey, y48.i> r142 = r136.f566096d;
        y48.i r143 = r142.get(r141);
        if (r143 != null) goto L114;
        int r144 = y48.i.f566101j;
        r143 = y48.i.a.a(r141);
    L114:
        Intrinsics.checkNotNullParameter(r143, "source");
        y48.w r145 = new y48.w(r143);
        r140.invoke(r145);
        r142.put(r141, r145.a());
    L115:
        final b58.a r146 = r138.f570034b;
        if (r146 == null) goto L121;
        Function1 r147 = new com.larus.feishu.office.im.impl.base.b(r146);
        Intrinsics.checkNotNullParameter(r147, "configure");
        ChatSpeakerElementKey r148 = ChatSpeakerElementKey.CancelArea;
        Map<ChatSpeakerElementKey, y48.i> r149 = r136.f566096d;
        y48.i r150 = r149.get(r148);
        if (r150 != null) goto L120;
        int r151 = y48.i.f566101j;
        r150 = y48.i.a.a(r148);
    L120:
        Intrinsics.checkNotNullParameter(r150, "source");
        y48.b r152 = new y48.b(r150);
        r147.invoke(r152);
        r149.put(r148, r152.a());
    L121:
        final b58.a r153 = r138.f570035c;
        if (r153 == null) goto L127;
        Function1 r154 = new com.larus.feishu.office.im.impl.base.c(r153);
        Intrinsics.checkNotNullParameter(r154, "configure");
        ChatSpeakerElementKey r155 = ChatSpeakerElementKey.ActionArea;
        Map<ChatSpeakerElementKey, y48.i> r156 = r136.f566096d;
        y48.i r157 = r156.get(r155);
        if (r157 != null) goto L126;
        int r158 = y48.i.f566101j;
        r157 = y48.i.a.a(r155);
    L126:
        Intrinsics.checkNotNullParameter(r157, "source");
        y48.b r159 = new y48.b(r157);
        r154.invoke(r159);
        r156.put(r155, r159.a());
    L127:
        r134.kD(r136.a());
    L131:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r160 = N2();
        if (r160 == null) goto L134;
        r160.e8((b) this.L.getValue());
    L134:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r161 = N2();
        if (r161 == null) goto L137;
        r161.Sh(new n(this));
    L137:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r162 = N2();
        if (r162 == 0) goto L140;
        r162.ZS(new o(this));
    L140:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r163 = N2();
        if (r163 == 0) goto L143;
        r163.tT(new p(this));
    L143:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r164 = N2();
        if (r164 == 0) goto L146;
        r164.Ln(new v());
    L146:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r165 = N2();
        if (r165 == null) goto L149;
        r165.la(new g0(this), new m0(), new n0(this), new o0());
    L149:
        zb8.e r166 = (zb8.e) this.f343135k.getValue();
        if (r166 == null) goto L153;
        r166.md(zb8.b.f571157f);
        return;
    L153:
        return;
    L128:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r167 = N2();
        if (r167 == null) goto L131;
        r167.fp(r133);
        goto L131
    L56:
        x1a.b r168 = x1a.a.f562152c;
        if (r168 == null) goto L62;
        r168.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(rp8.c.class).getQualifiedName());
        goto L62
    L59:
        f1 r169 = F2();
        if (r169 == null) goto L62;
        r169.HN();
        goto L62
    L13:
        x1a.b r170 = x1a.a.f562152c;
        if (r170 == null) goto L22;
        r170.log(5, "ComponentArch", "updateData ignored: context destroyed for " + Reflection.getOrCreateKotlinClass(rp8.d.class).getQualifiedName());
        goto L22
    L16:
        z8 r171 = (z8) this.f343149y.getValue();
        if (r171 == null) goto L19;
        r171.s9();
    L19:
        z8 r172 = (z8) this.f343149y.getValue();
        if (r172 == null) goto L22;
        r172.r8(false, null);
        goto L22
    }

    @Override // w99.a
    public final ConstraintLayout GI() {
        View r100 = (View) this.f343141q.getValue();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if ((r102 instanceof ViewGroup) == false) goto L9;
        r101 = (ViewGroup) r102;
    L9:
        if (r101 == null) goto L11;
        r101.removeView((View) this.f343141q.getValue());
    L11:
        View r103 = (View) this.f343141q.getValue();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        return (ConstraintLayout) r103;
    L5:
        r102 = null;
        goto L7
    }

    @Override // w99.a
    public final void Im() {
        zb8.b r100 = zb8.b.f571157f;
        Intrinsics.checkNotNullParameter(r100, "uiConfig");
        if (P2() == false) goto L10;
        com.larus.bmhome.chat.component.bottom.multimodal.g r101 = r5();
        if (r101 == null) goto L7;
        int r102 = r101.zv(false, null);
    L8:
        int r103 = com.larus.utils.j0.f375426a;
        String r104 = com.larus.utils.j0.d(R.string.larus_multi_photo_uploading_toast_maximum_number);
        t19.s r105 = t19.s.f544207a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r106 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        String r108 = String.format(r104, Arrays.copyOf(new Object[]{Integer.valueOf(r102)}, 1));
        r105.getClass();
        t19.s.t(r106, r108);
        return;
    L7:
        r102 = 0;
        goto L8
    L10:
        ICoreInputAbility r109 = L2();
        if (r109 == null) goto L13;
        r109.qp(true);
    L13:
        zb8.e r110 = (zb8.e) this.f343135k.getValue();
        if (r110 == null) goto L16;
        r110.md(r100);
    L16:
        zb8.e r111 = (zb8.e) this.f343135k.getValue();
        if (r111 == null) goto L19;
        r111.D40(true);
    L19:
        com.larus.bmhome.chat.component.bottom.multimodal.g r112 = r5();
        if (r112 == null) goto L23;
        r112.n90(new e1(com.larus.bmhome.chat.component.bottom.multimodal.f1.b.f299771a, new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ChatInputCamera, false), null, null, 12));
        return;
    }

    public final ICoreInputAbility L2() {
        return (ICoreInputAbility) this.f343132h.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.l N2() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.f343134j.getValue();
    }

    @Override // w99.a
    public final ConstraintLayout cz() {
        View r100 = (View) this.f343142r.getValue();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if ((r102 instanceof ViewGroup) == false) goto L9;
        r101 = (ViewGroup) r102;
    L9:
        if (r101 == null) goto L11;
        r101.removeView((View) this.f343142r.getValue());
    L11:
        View r103 = (View) this.f343142r.getValue();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        return (ConstraintLayout) r103;
    L5:
        r102 = null;
        goto L7
    }

    public final g1 f70() {
        return (g1) this.f343150z.getValue();
    }

    @Override // w99.a
    public final i1<List<UplinkFileEntity>> k1() {
        return (i1) this.K.getValue();
    }

    @Override // w99.a
    public final List<UplinkFileEntity> q1() {
        List<UplinkFileEntity> r100 = CollectionsKt.toList((Iterable) ((i1) this.K.getValue()).getValue());
        int r101 = v99.z.f553877a;
        Intrinsics.checkNotNullParameter(r100, "entities");
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        v99.z.a("handoff", (UplinkFileEntity) r102.next());
        goto L4
    L6:
        return r100;
    }

    public final com.larus.bmhome.chat.component.bottom.multimodal.g r5() {
        return (com.larus.bmhome.chat.component.bottom.multimodal.g) this.A.getValue();
    }

    @Override // w99.a
    public final void wX() {
        com.larus.bmhome.chat.component.fastsend.e0 r100 = (com.larus.bmhome.chat.component.fastsend.e0) this.f343138n.getValue();
        if (r100 == null) goto L6;
        r100.wd();
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).c(this, w99.a.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).c(this, com.larus.bmhome.chat.component.fastsend.d0.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).c(this, va8.h0.class);
        FLogger.f375446a.i("FeishuInputAdapterComponent", "[onAttach]");
    }

    @Override // w99.a
    public final View y8() {
        bc8.a r100 = (bc8.a) this.C.getValue();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.y8();
    L6:
        if (r102 == null) goto L8;
        ViewParent r103 = r102.getParent();
    L10:
        if ((r103 instanceof ViewGroup) == false) goto L12;
        r101 = (ViewGroup) r103;
    L12:
        if (r101 == null) goto L14;
        r101.removeView(r102);
    L14:
        return r102;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // w99.a
    public final View yr() {
        StringBuilder r100 = new StringBuilder("@");
        int r101 = com.larus.utils.j0.f375426a;
        r100.append(com.larus.utils.j0.d(R.string.larus_db_feed_db_tab_name_cn));
        r100.append(' ');
        String r102 = r100.toString();
        bc8.a r103 = (bc8.a) this.C.getValue();
        if (r103 == null) goto L5;
        r103.Rg(r102);
    L5:
        bc8.a r104 = (bc8.a) this.C.getValue();
        ViewGroup r105 = null;
        if (r104 == null) goto L8;
        SuggestedActionBar r106 = r104.JU();
    L9:
        if (r106 == null) goto L11;
        ViewParent r107 = r106.getParent();
    L13:
        if ((r107 instanceof ViewGroup) == false) goto L15;
        r105 = (ViewGroup) r107;
    L15:
        if (r105 == null) goto L17;
        r105.removeView(r106);
    L17:
        return r106;
    L11:
        r107 = null;
        goto L13
    L8:
        r106 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v33, types: [com.larus.feishu.office.im.impl.base.x] */
    /* JADX WARN: Type inference failed for: r0v34, types: [com.larus.feishu.office.im.impl.base.y] */
    public FeishuInputAdapterComponent() {
        this.f343132h = LazyKt.lazy(new q(this));
        this.f343133i = LazyKt.lazy(new b0(this));
        this.f343134j = LazyKt.lazy(new c0(this));
        this.f343135k = LazyKt.lazy(new d0(this));
        this.f343136l = LazyKt.lazy(new e0(this));
        this.f343137m = LazyKt.lazy(new f0(this));
        this.f343138n = LazyKt.lazy(new h0(this));
        this.f343140p = MapsKt.emptyMap();
        this.f343141q = LazyKt.lazy(new i0(this));
        this.f343142r = LazyKt.lazy(new j0(this));
        this.f343147w = CollectionsKt.emptyList();
        this.f343149y = LazyKt.lazy(new k0(this));
        this.f343150z = LazyKt.lazy(new r(this));
        this.A = LazyKt.lazy(new s(this));
        this.B = LazyKt.lazy(new t(this));
        this.C = LazyKt.lazy(new u(this));
        this.D = LazyKt.lazy(new w(this));
        this.E = new LinkedHashMap();
        this.F = new x(this);
        this.G = new y(this);
        this.H = "";
        this.I = new byte[0];
        this.f343131J = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.K = LazyKt.lazy(new z(this));
        this.L = LazyKt.lazy(new a0(this));
    }

    public final f1 F2() {
        return (f1) s1a.d.a(this).getAbility(f1.class);
    }

    @Override // w99.a
    public final void LC() {
        f1 r100 = F2();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L13;
        f1 r102 = F2();
        if (r102 == null) goto L14;
        r102.Vx(true, 0);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r100.lt() != true) goto L7;
        r101 = true;
        goto L8
    }

    public final boolean P2() {
        g1 r100 = f70();
        if (r100 == null) goto L7;
        List<com.larus.im.bean.message.UplinkFileEntity> r101 = r100.q1();
        if (r101 == null) goto L7;
        int r102 = r101.size();
    L8:
        com.larus.bmhome.chat.component.bottom.multimodal.g r103 = r5();
        if (r103 == null) goto L11;
        int r104 = r103.zv(false, null);
    L12:
        if (r102 == 0) goto L16;
        if (r102 < r104) goto L17;
        return true;
    L17:
        return false;
    L16:
        return false;
    L11:
        r104 = 0;
    L7:
        r102 = 0;
        goto L8
    }

    @Override // w99.a
    public final void W0() {
        g1 r100 = f70();
        if (r100 == null) goto L6;
        r100.W0();
        return;
    }

    @Override // w99.a
    public final void hT() {
        com.larus.bmhome.chat.component.bottom.multimodal.g r100 = r5();
        if (r100 == null) goto L6;
        r100.n90(new e1(new com.larus.bmhome.chat.component.bottom.multimodal.f1.a(false, 0, 3), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.SuggestedActionAlbum, false), null, null, 12));
        return;
    }

    @Override // w99.a
    public final ViewGroup q2() {
        g1 r100 = f70();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        ViewGroup r102 = r100.YK();
    L6:
        if (r102 == null) goto L8;
        ViewParent r103 = r102.getParent();
    L10:
        if ((r103 instanceof ViewGroup) == false) goto L12;
        r101 = (ViewGroup) r103;
    L12:
        if (r101 == null) goto L14;
        r101.removeView(r102);
    L14:
        return r102;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // w99.a
    public final ViewGroup vh() {
        f1 r100 = F2();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        BottomMenuGridLayout r102 = r100.jJ();
    L6:
        if (r102 == null) goto L8;
        ViewParent r103 = r102.getParent();
    L10:
        if ((r103 instanceof ViewGroup) == false) goto L12;
        r101 = (ViewGroup) r103;
    L12:
        if (r101 == null) goto L14;
        r101.removeView(r102);
    L14:
        this.f343139o = r102;
        return r102;
    L8:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // w99.a
    public final boolean y3() {
        ICoreInputAbility r100 = L2();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.Rp() != 2) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // w99.a
    public final View.OnTouchListener D0(EditText r100) {
        Intrinsics.checkNotNullParameter(r100, "editText");
        e2 r101 = (e2) this.f343136l.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.D0(r100);
    }

    @Override // w99.a
    public final void J4(eya.a r100) {
        Intrinsics.checkNotNullParameter(r100, "panelItemConfig");
        int r101 = v99.b.f553843a;
        Intrinsics.checkNotNullParameter(r100, "source");
        String r102 = r100.f474823a;
        int r103 = r100.f474824b;
        int r104 = r100.f474825c;
        boolean r105 = r100.f474826d;
        boolean r106 = r100.f474827e;
        final Function0<Unit> r107 = r100.f474828f;
        if (r107 == null) goto L5;
        Function1 r108 = new v99.a(r107);
    L6:
        com.larus.bmhome.chat.component.bottom.multimodal.h.a r109 = new com.larus.bmhome.chat.component.bottom.multimodal.h.a(r102, r103, r104, r105, r106, r108);
        this.E.put(r109.f299779a, r109);
        com.larus.bmhome.chat.component.bottom.multimodal.h r110 = (com.larus.bmhome.chat.component.bottom.multimodal.h) this.D.getValue();
        if (r110 == null) goto L10;
        r110.d6();
        return;
    L10:
        return;
    L5:
        r108 = null;
        goto L6
    }

    @Override // w99.a
    public final void K3(PlusInnerEndPlugin.a r100) {
        this.f343146v = r100;
    }

    @Override // w99.a
    public final void S2(int r100) {
        Integer r101 = Integer.valueOf(r100);
        if (r101.intValue() <= 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        r101 = null;
    L10:
        f1 r103 = F2();
        if (r103 == null) goto L13;
        r103.U00(r101);
    L13:
        if (r101 != null) goto L18;
        f1 r104 = F2();
        if (r104 == null) goto L34;
        r104.vo(null);
        return;
    L34:
        return;
    L18:
        ViewGroup r105 = this.f343139o;
        if ((r105 instanceof BottomMenuGridLayout) == false) goto L21;
        BottomMenuGridLayout r106 = (BottomMenuGridLayout) r105;
    L22:
        if (r106 == null) goto L24;
        int r107 = r106.getBottomMenuHeight();
    L25:
        if (r107 > 0) goto L30;
        f1 r108 = F2();
        if (r108 == null) goto L35;
        r108.vo(null);
        return;
    L35:
        return;
    L30:
        int r109 = RangesKt.coerceAtLeast(r101.intValue() - r107, 0);
        f1 r110 = F2();
        if (r110 == null) goto L36;
        r110.vo(Integer.valueOf(r109));
        return;
    L36:
        return;
    L24:
        r107 = 0;
        goto L25
    L21:
        r106 = null;
        goto L22
    L5:
        r102 = false;
        goto L7
    }

    @Override // w99.a
    public final boolean Y5(List<? extends Uri> r110) {
        Intrinsics.checkNotNullParameter(r110, "uris");
        com.larus.bmhome.chat.component.bottom.multimodal.g r100 = r5();
        if (r100 != null) goto L5;
        return false;
    L5:
        ArrayList r101 = (ArrayList) r110;
        if (r101.isEmpty() == true) goto L25;
        g1 r102 = f70();
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L25;
        if (P2() == false) goto L19;
        int r111 = r100.zv(false, null);
        int r104 = com.larus.utils.j0.f375426a;
        String r105 = com.larus.utils.j0.d(R.string.larus_multi_photo_uploading_toast_maximum_number);
        t19.s r106 = t19.s.f544207a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r107 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        StringCompanionObject r108 = StringCompanionObject.INSTANCE;
        String r112 = String.format(r105, Arrays.copyOf(new Object[]{Integer.valueOf(r111)}, 1));
        r106.getClass();
        t19.s.t(r107, r112);
        return true;
    L19:
        FLogger.f375446a.i("FeishuInputAdapterComponent", "[pasteMediaUris] uri count:" + r101.size());
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r113 = r110.iterator();
    L21:
        if (r113.hasNext() == false) goto L23;
        r109.add(new com.larus.bmhome.chat.component.bottom.multimodal.a.C4037a((Uri) r113.next(), null, 2));
        goto L21
    L23:
        r100.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r109, new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.ChatPasteUri, false), null, null, null, 28));
        return true;
    L10:
        if (r102.mT() != true) goto L12;
        r103 = true;
    L25:
        return false;
    }

    @Override // w99.a
    public final void Z6(PlusInnerEndPlugin.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f343145u = r100;
    }

    @Override // w99.a
    public final void dQ(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "chatParams");
        this.f343140p = MapsKt.toMap(r100);
    }

    @Override // w99.a
    public final void db(fya.a.b r100) {
        this.f343143s = r100;
    }

    @Override // w99.a
    public final void gg(fya.a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f343144t = r100;
    }

    @Override // w99.a
    public final void o3(BaseRichTextInputPlugin.n r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f343148x = r100;
    }

    @Override // w99.a
    public final void v5(boolean r100) {
        ICoreInputAbility r101 = L2();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        int r102 = 2;
    L8:
        r101.g2(r102, true);
        return;
    L7:
        r102 = 1;
        goto L8
    }

    @Override // w99.a
    public final void wj(boolean r100) {
        ICoreInputAbility r101 = L2();
        if (r101 == null) goto L6;
        r101.C1(r100, false, "");
        return;
    }

    @Override // w99.a
    public final void C20(boolean r100, int r101, int r102) {
        f1 r103 = F2();
        if (r103 == null) goto L6;
        r103.zR(r100, r101, r102);
        return;
    }

    @Override // w99.a
    public final void kf(boolean r100, int r101, int r102, boolean r103) {
        f1 r104 = F2();
        if (r104 == null) goto L6;
        r104.tn(r100, r101, r102, r103);
        return;
    }

    @Override // w99.a
    public final void Fm(boolean r100, int r101, int r102, int r110, float r111) {
        f1 r103 = F2();
        if (r103 == null) goto L6;
        r103.Er(r100, r101, r102, r110, r111);
        return;
    }
}
