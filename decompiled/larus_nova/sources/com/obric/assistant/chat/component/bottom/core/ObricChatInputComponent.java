package com.obric.assistant.chat.component.bottom.core;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.api.b0;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.ChatInputText;
import com.larus.bmhome.view.resourcebar.ResourceBar;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.view.ChatInputInnerView;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.home.api.main.HomeService;
import com.larus.im.bean.bot.BotModel;
import com.larus.nova.R;
import com.larus.platform.api.IShortcutPlatformService;
import com.larus.platform.model.EditPos;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.assistant.chat.component.bottom.core.mention.ObricMentionInputController;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.special_input.OSkillCache;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.t1;
import com.obric.assistant.util.ObricMentionHighlightHelper;
import com.obric.assistant.util.o1;
import com.obric.assistant.util.q2;
import com.obric.assistant.util.s1;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.b1;
import laa.v;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\r\n\u0002\b?*\u0002Ä\u0001\u0018\u0000 Â\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Â\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010Û\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010â\u0001\u001a\u00030Ú\u0001H\u0016J\n\u0010ã\u0001\u001a\u00030Ú\u0001H\u0016J\n\u0010ä\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010å\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010æ\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010ç\u0001\u001a\u00030Ú\u0001H\u0002J\u0014\u0010è\u0001\u001a\u00030\u00ad\u00012\b\u0010é\u0001\u001a\u00030«\u0001H\u0016J\u0014\u0010ê\u0001\u001a\u00030\u00ad\u00012\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0016J\u001e\u0010ê\u0001\u001a\u00030\u00ad\u00012\b\u0010í\u0001\u001a\u00030î\u00012\b\u0010ï\u0001\u001a\u00030«\u0001H\u0016J\u0012\u0010ð\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016¢\u0006\u0003\u0010ñ\u0001J\n\u0010ò\u0001\u001a\u00030Ú\u0001H\u0016J\n\u0010ó\u0001\u001a\u00030Ú\u0001H\u0016J.\u0010ô\u0001\u001a\u00030\u00ad\u00012\b\u0010õ\u0001\u001a\u00030\u00ad\u00012\b\u0010ö\u0001\u001a\u00030\u00ad\u00012\b\u0010÷\u0001\u001a\u00030¬\u0001H\u0016¢\u0006\u0003\u0010ø\u0001J\u0014\u0010ù\u0001\u001a\u00030Ú\u00012\b\u0010ú\u0001\u001a\u00030\u00ad\u0001H\u0016J\u0014\u0010û\u0001\u001a\u00030Ú\u00012\b\u0010ü\u0001\u001a\u00030«\u0001H\u0002J\n\u0010ý\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010þ\u0001\u001a\u00030\u00ad\u0001H\u0002J\u0016\u0010ÿ\u0001\u001a\u00030\u00ad\u00012\n\u0010ë\u0001\u001a\u0005\u0018\u00010ì\u0001H\u0002J\f\u0010\u0080\u0002\u001a\u0005\u0018\u00010¬\u0001H\u0016J\f\u0010\u0081\u0002\u001a\u0005\u0018\u00010¬\u0001H\u0016J\n\u0010\u0082\u0002\u001a\u00030Ú\u0001H\u0016J\u0016\u0010\u0083\u0002\u001a\u0005\u0018\u00010\u0084\u00022\b\u0010\u0085\u0002\u001a\u00030¬\u0001H\u0016J\n\u0010\u0086\u0002\u001a\u00030Ú\u0001H\u0016J\u0014\u0010\u0087\u0002\u001a\u00030Ú\u00012\b\u0010\u0088\u0002\u001a\u00030«\u0001H\u0016J\u001e\u0010\u0089\u0002\u001a\u00030Ú\u00012\b\u0010\u0088\u0002\u001a\u00030«\u00012\b\u0010\u008a\u0002\u001a\u00030\u00ad\u0001H\u0016J\u0014\u0010\u008b\u0002\u001a\u00030Ú\u00012\b\u0010ú\u0001\u001a\u00030\u00ad\u0001H\u0016J\n\u0010\u008c\u0002\u001a\u00030Ú\u0001H\u0016J%\u0010\u008d\u0002\u001a\u0005\u0018\u00010«\u00012\u0007\u0010\u008e\u0002\u001a\u00020m2\b\u0010\u008f\u0002\u001a\u00030«\u0001H\u0016¢\u0006\u0003\u0010\u0090\u0002J\u0014\u0010\u0091\u0002\u001a\u00030\u00ad\u00012\b\u0010\u0088\u0002\u001a\u00030«\u0001H\u0016J\n\u0010\u0092\u0002\u001a\u00030\u00ad\u0001H\u0002J\u0014\u0010\u0093\u0002\u001a\u00030\u00ad\u00012\b\u0010\u0094\u0002\u001a\u00030\u00ad\u0001H\u0016J\u0014\u0010\u0095\u0002\u001a\u00030Ú\u00012\b\u0010\u0096\u0002\u001a\u00030\u00ad\u0001H\u0016J\n\u0010\u0097\u0002\u001a\u00030\u00ad\u0001H\u0002J\n\u0010\u0098\u0002\u001a\u00030\u00ad\u0001H\u0016J\f\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0084\u0002H\u0016J\u0014\u0010\u009a\u0002\u001a\u00030Ú\u00012\b\u0010\u009b\u0002\u001a\u00030¬\u0001H\u0002J\n\u0010\u009c\u0002\u001a\u00030\u00ad\u0001H\u0002J\n\u0010\u009d\u0002\u001a\u00030\u00ad\u0001H\u0002J\u0014\u0010\u009e\u0002\u001a\u00030Ú\u00012\b\u0010\u0096\u0002\u001a\u00030\u00ad\u0001H\u0002J\u0014\u0010\u009f\u0002\u001a\u00030\u00ad\u00012\b\u0010 \u0002\u001a\u00030\u00ad\u0001H\u0002J\n\u0010¡\u0002\u001a\u00030Ú\u0001H\u0002J\n\u0010¢\u0002\u001a\u00030Ú\u0001H\u0002J\n\u0010£\u0002\u001a\u00030Ú\u0001H\u0002J\n\u0010¤\u0002\u001a\u00030Ú\u0001H\u0002J\n\u0010¥\u0002\u001a\u00030Ú\u0001H\u0002J\n\u0010¦\u0002\u001a\u00030Ú\u0001H\u0002J\u0016\u0010§\u0002\u001a\u00030Ú\u00012\n\b\u0002\u0010¨\u0002\u001a\u00030\u00ad\u0001H\u0002J\n\u0010©\u0002\u001a\u00030Ú\u0001H\u0002J\n\u0010ª\u0002\u001a\u00030Ú\u0001H\u0002J\n\u0010«\u0002\u001a\u00030Ú\u0001H\u0016J\n\u0010¬\u0002\u001a\u00030Ú\u0001H\u0016J\n\u0010\u00ad\u0002\u001a\u00030Ú\u0001H\u0016J\n\u0010®\u0002\u001a\u00030«\u0001H\u0002J\n\u0010¯\u0002\u001a\u00030Ú\u0001H\u0002J\u000e\u0010°\u0002\u001a\u00030Ú\u0001*\u00020mH\u0002J\n\u0010±\u0002\u001a\u00030Ú\u0001H\u0002J\u001c\u0010²\u0002\u001a\u00030Ú\u00012\u0006\u0010V\u001a\u00020m2\b\u0010³\u0002\u001a\u00030«\u0001H\u0016J\u001e\u0010´\u0002\u001a\u00030Ú\u00012\b\u0010µ\u0002\u001a\u00030«\u00012\b\u0010¶\u0002\u001a\u00030«\u0001H\u0016J\u0014\u0010·\u0002\u001a\u00030Ú\u00012\b\u0010\u0094\u0002\u001a\u00030\u00ad\u0001H\u0016J\f\u0010¸\u0002\u001a\u0005\u0018\u00010¬\u0001H\u0016J\u0014\u0010¹\u0002\u001a\u00030Ú\u00012\b\u0010º\u0002\u001a\u00030«\u0001H\u0002J\u0014\u0010»\u0002\u001a\u00030«\u00012\b\u0010º\u0002\u001a\u00030«\u0001H\u0002J\u0014\u0010¼\u0002\u001a\u00030«\u00012\b\u0010½\u0002\u001a\u00030«\u0001H\u0002J\u0014\u0010¾\u0002\u001a\u00030Ú\u00012\b\u0010¿\u0002\u001a\u00030\u00ad\u0001H\u0002J\u0010\u0010À\u0002\u001a\u00030\u00ad\u0001*\u0004\u0018\u00010WH\u0002J\u0010\u0010Á\u0002\u001a\u00030Ú\u0001*\u0004\u0018\u00010WH\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b<\u0010=R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\f\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\f\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\f\u001a\u0004\bK\u0010LR\u0016\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0016\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u001d\u0010V\u001a\u0004\u0018\u00010W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\f\u001a\u0004\bX\u0010YR\u001d\u0010[\u001a\u0004\u0018\u00010\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\f\u001a\u0004\b]\u0010^R\u001d\u0010`\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\f\u001a\u0004\bb\u0010cR\u001d\u0010e\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\f\u001a\u0004\bf\u0010cR\u0016\u0010h\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bi\u0010YR\u0016\u0010j\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010YR\u0016\u0010l\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0016\u0010p\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bq\u0010oR\u001d\u0010r\u001a\u0004\u0018\u00010W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\f\u001a\u0004\bs\u0010YR\u0016\u0010u\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bv\u0010YR\u0016\u0010w\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bx\u0010YR\u0016\u0010y\u001a\u0004\u0018\u00010z8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0016\u0010}\u001a\u0004\u0018\u00010z8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010|R\u0017\u0010\u007f\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010oR\u0018\u0010\u0081\u0001\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010YR\u0018\u0010\u0083\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010oR\u0018\u0010\u0085\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010oR\u0018\u0010\u0087\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010oR\u0018\u0010\u0089\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010oR\u0018\u0010\u008b\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010oR\u0018\u0010\u008d\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010oR\u0018\u0010\u008f\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010oR\u0018\u0010\u0091\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010oR\u0018\u0010\u0093\u0001\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010YR\u0018\u0010\u0095\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010oR\u0018\u0010\u0097\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010oR\u0018\u0010\u0099\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010oR\u0018\u0010\u009b\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010oR\u0018\u0010\u009d\u0001\u001a\u0004\u0018\u00010m8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010oR\u0012\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¥\u0001\u0010\f\u001a\u0006\b£\u0001\u0010¤\u0001R \u0010¦\u0001\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b¨\u0001\u0010\f\u001a\u0005\b§\u0001\u0010cR'\u0010©\u0001\u001a\u001a\u0012\u0005\u0012\u00030«\u0001\u0012\u0005\u0012\u00030¬\u0001\u0012\u0005\u0012\u00030\u00ad\u0001\u0018\u00010ª\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010®\u0001\u001a\u001a\u0012\u0005\u0012\u00030«\u0001\u0012\u0005\u0012\u00030¬\u0001\u0012\u0005\u0012\u00030\u00ad\u0001\u0018\u00010ª\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¯\u0001\u001a\u00030«\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010°\u0001\u001a\u00030«\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010±\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010²\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010³\u0001\u001a\u0005\u0018\u00010\u00ad\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010´\u0001R\u0015\u0010µ\u0001\u001a\u0005\u0018\u00010\u00ad\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010´\u0001R\u0010\u0010¶\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010º\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010»\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¼\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010½\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¾\u0001\u001a\u00030¿\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010À\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Á\u0001\u001a\u00030¿\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Â\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010Ã\u0001\u001a\u00030Ä\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Å\u0001R\u0010\u0010Æ\u0001\u001a\u00030Ç\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010È\u0001\u001a\u00030É\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÌ\u0001\u0010\f\u001a\u0006\bÊ\u0001\u0010Ë\u0001R \u0010Í\u0001\u001a\u00030Î\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÑ\u0001\u0010\f\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u0018\u0010Ò\u0001\u001a\u00030Ó\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u0010\u0010Ö\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010×\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ø\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010Ý\u0001\u001a\u0005\u0018\u00010Þ\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bá\u0001\u0010\f\u001a\u0006\bß\u0001\u0010à\u0001¨\u0006Ã\u0002"}, d2 = {"Lcom/obric/assistant/chat/component/bottom/core/ObricChatInputComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "Lcom/obric/assistant/chat/bottom/sub/IObricChatInputLogicAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "chatWindowComponent", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getChatWindowComponent", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "chatWindowComponent$delegate", "Lkotlin/Lazy;", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "coreInputUIAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getCoreInputUIAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "coreInputUIAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "chatPageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getChatPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "chatPageStateAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "skillAbility", "Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "getSkillAbility", "()Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "skillAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "obricMultimodalInputAbility", "Lcom/obric/assistant/chat/bottom/sub/IObricMultimodalInputAbility;", "getObricMultimodalInputAbility", "()Lcom/obric/assistant/chat/bottom/sub/IObricMultimodalInputAbility;", "obricMultimodalInputAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "chatConstraintLayout", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "getChatConstraintLayout", "()Lcom/larus/bmhome/view/ChatConstraintLayout;", "chatConstraintLayout$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "bottomLayout", "getBottomLayout", "bottomLayout$delegate", "inputAreaContainer", "getInputAreaContainer", "inputArea", "getInputArea", "multiArea", "Landroid/view/View;", "getMultiArea", "()Landroid/view/View;", "suggestActionContainer", "getSuggestActionContainer", "inputEditorContainer", "getInputEditorContainer", "inputEditorContainer$delegate", "inputAboveLayout", "getInputAboveLayout", "voiceVisualizerContainer", "getVoiceVisualizerContainer", "inputText", "Landroid/widget/TextView;", "getInputText", "()Landroid/widget/TextView;", "speakNormal", "getSpeakNormal", "actionSend", "getActionSend", "actionSendContainer", "getActionSendContainer", "actionSpeak", "getActionSpeak", "actionSpeakGroup", "getActionSpeakGroup", "actionInput", "getActionInput", "actionMenuEntrance", "getActionMenuEntrance", "actionMenuEntranceIcon", "getActionMenuEntranceIcon", "actionBreak", "getActionBreak", "actionModifyConfirm", "getActionModifyConfirm", "actionModifyCancel", "getActionModifyCancel", "speakArea", "getSpeakArea", "actionEntrance", "getActionEntrance", "actionEntranceIv", "getActionEntranceIv", "actionSpeech", "getActionSpeech", "actionFullScreen", "getActionFullScreen", "inputAboveDivider", "getInputAboveDivider", "mentionController", "Lcom/obric/assistant/chat/component/bottom/core/mention/ObricMentionInputController;", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "messageListParent", "getMessageListParent", "messageListParent$delegate", "originBottomPaddingInterceptor", "Lkotlin/Function2;", "", "", "", "windowBottomPaddingInterceptor", "currentBottomMenuHeight", "currentImeExtraBottomMargin", "keepBottomDuringBottomMenuImeOpening", "phoneOperationModeActiveInInput", "forceDisableInjectInputBeforePhoneOperationMode", "Ljava/lang/Boolean;", "forceCloseInjectInputBeforePhoneOperationMode", "phoneOperationCameraConfigApplied", "previousActionEntranceOuterInterceptor", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager$InputActionEntranceOuterInterceptor;", "phoneOperationActionEntranceOuterInterceptor", "previousTakeOverActionEntranceVisibility", "phoneOperationMediaEntrancesHidden", "shouldRestoreActionEntranceAfterPhoneOperationMediaHidden", "previousMediaTakeOverActionEntranceVisibility", "omniSkillStateScope", "Lkotlinx/coroutines/CoroutineScope;", "omniSkillStateObserverStarted", "phoneOperationAttachmentSendStateScope", "phoneOperationAttachmentSendStateObserverStarted", "phoneOperationAttachmentTextChangedListener", "com/obric/assistant/chat/component/bottom/core/ObricChatInputComponent$phoneOperationAttachmentTextChangedListener$1", "Lcom/obric/assistant/chat/component/bottom/core/ObricChatInputComponent$phoneOperationAttachmentTextChangedListener$1;", "speakNormalLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "portraitInputStrategy", "Lcom/obric/assistant/window/strategies/PortraitInputStrategy;", "getPortraitInputStrategy", "()Lcom/obric/assistant/window/strategies/PortraitInputStrategy;", "portraitInputStrategy$delegate", "landscapeInputStrategy", "Lcom/obric/assistant/window/strategies/LandscapeInputStrategy;", "getLandscapeInputStrategy", "()Lcom/obric/assistant/window/strategies/LandscapeInputStrategy;", "landscapeInputStrategy$delegate", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/obric/assistant/window/strategies/api/BaseInputStrategy;", "getStrategy", "()Lcom/obric/assistant/window/strategies/api/BaseInputStrategy;", "perceptionInputStatusApplied", "resettingPerceptionInputStatus", "perceptionPreferSpeakStatus", "setupInputArea", "", "setInputActionButton", "setupBottomMenuImeAnimation", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "onParentViewCreated", LiveCommonConstants.REASON_ON_DEDTROY, "observeOmniSkillStateForDraftRestore", "observePhoneOperationAttachmentSendState", "setWindowBottomPaddingInterceptor", "restoreWindowBottomPaddingInterceptor", "replaceInputAreaBackgroundResource", "resId", "replaceInputAreaBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "corner", "", "color", "getCustomActionSendImageResource", "()Ljava/lang/Integer;", "performHapticFeedback4SendClick", "performHapticFeedback4SendClick4VirtualKey", "addDynamicShortcut", "canShowCamera", "canShowRealtime", "cvsID", "(ZZLjava/lang/String;)Ljava/lang/Boolean;", "changeInputUi", "isChatWindow", "updateInputContainerPadding", GXTemplateKey.FLEXBOX_PADDING, "refreshInputForegroundColors", "isSceneMatch", "replaceInputBgDrawable", "getReferenceMessageId", "getReferenceMessageContent", "onResume", "buildRestoreTextDraftContent", "", "text", "onTextDraftRestoreFinished", "onInputStatusChanged", "status", "switchStatus", "saveStatus", "onChatStyleChanged", "updateInputTextFiltersForChatInput", "getMentionPanelMaxHeight", "panelView", "currentMaxHeight", "(Landroid/view/View;I)Ljava/lang/Integer;", "interceptInputStatus", "isPerceptionActionPanel", "interceptActionMenuEntranceVisibility", "visible", "onPhoneOperationModeChanged", "active", "isCurrentMainConversation", "isActionSendForceDisabled", "getAttachmentInputHintOverride", "refreshPhoneOperationAttachmentSendState", "reason", "shouldDisablePhoneOperationAttachmentSend", "isPhoneOperationAttachmentTextRequiredScene", "updateMediaPickerInputForPhoneOperationMode", "shouldHidePhoneOperationMediaEntrances", "specialInputOpen", "hidePhoneOperationMediaEntrances", "applyPhoneOperationMediaEntrancesHidden", "restorePhoneOperationMediaEntrances", "activateInputActionEntrancesForPhoneOperationMode", "configurePhoneOperationCamera", "restoreInputActionEntrancesAfterPhoneOperationMode", "restorePhoneOperationCameraConfig", "force", "renderPerceptionInputStatus", "renderPerceptionSpeakStatus", "resetPerceptionInputStatus", "preparePerceptionInputStatus", "refreshPerceptionInputBackground", "getObricInputBackgroundColor", "hidePerceptionUnsupportedActions", "showEnabled", "resetInputTextEndMargin", "updateInputBottomMargin", "bottomMargin", "updateBottomMenuHeight", "curHeight", "normalHeight", "onBottomMenuVisibleChanged", "getInputTextContent", "updateMessageListBottomMargin", "bottomLayoutMargin", "getInputExtraBottomMargin", "getImeExtraBottomMargin", "imeInsetsBottom", "scrollToLatestIfNeeded", "shouldScroll", "isAtBottom", "scrollToLatest", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatInputComponent extends ComponentFeature implements ada.c, ada.b, hca.b {
    public static final /* synthetic */ int L0 = 0;
    public ObricMentionInputController A;
    public final Lazy B;
    public final Lazy C;
    public Function2<? super Integer, ? super String, Boolean> D;
    public com.obric.assistant.chat.component.bottom.core.j E;
    public int F;
    public int G;
    public boolean H;
    public final Lazy H0;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Boolean f386701J;
    public Boolean K;
    public boolean L;
    public z8.c M;
    public z8.c N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public final CoroutineScope S;
    public boolean T;
    public final CoroutineScope U;
    public boolean V;
    public final b W;
    public final Lazy X;
    public final Lazy Y;
    public boolean Z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f386702h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f386703i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f386704j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f386705k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f386706k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f386707l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f386708m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f386709n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f386710o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f386711p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f386712p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f386713q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f386714r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f386715s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f386716t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f386717u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f386718v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f386719w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f386720x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f386721y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f386722z;

    public static final class a {
    }

    public static final class b implements ICoreInputAbility.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricChatInputComponent f386723a;

        public b(ObricChatInputComponent r100) {
            this.f386723a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
        public final void h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
        public final void i(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            ObricChatInputComponent r101 = this.f386723a;
            int r102 = ObricChatInputComponent.L0;
            r101.a4("text_changed");
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility.e
        public final void j(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
        }
    }

    public static final class c implements Function0<paa.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386724a;

        public c(AttachReceiver r100) {
            this.f386724a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [paa.c, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final paa.c invoke() {
            AttachReceiver r100 = this.f386724a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(paa.c.class));
        }
    }

    public static final class d implements Function0<p1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386725a;

        public d(AttachReceiver r100) {
            this.f386725a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.p1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final p1 invoke() {
            AttachReceiver r100 = this.f386725a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(p1.class));
        }
    }

    public static final class e implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386726a;

        public e(AttachReceiver r100) {
            this.f386726a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.multimodal.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.bottom.multimodal.g invoke() {
            AttachReceiver r100 = this.f386726a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    public static final class f implements Function0<ada.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386727a;

        public f(AttachReceiver r100) {
            this.f386727a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ada.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ada.d invoke() {
            AttachReceiver r100 = this.f386727a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ada.d.class));
        }
    }

    public static final class g implements Function0<laa.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386728a;

        public g(AttachReceiver r100) {
            this.f386728a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.m, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.m invoke() {
            AttachReceiver r100 = this.f386728a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.m.class));
        }
    }

    public static final class h implements Function0<f1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386729a;

        public h(AttachReceiver r100) {
            this.f386729a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.bottommenu.f1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final f1 invoke() {
            AttachReceiver r100 = this.f386729a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(f1.class));
        }
    }

    public static final class i implements Function0<va8.o> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386730a;

        public i(AttachReceiver r100) {
            this.f386730a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.o] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.o invoke() {
            AttachReceiver r100 = this.f386730a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class j implements Function0<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386731a;

        public j(AttachReceiver r100) {
            this.f386731a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final y invoke() {
            AttachReceiver r100 = this.f386731a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class k implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386732a;

        public k(AttachReceiver r100) {
            this.f386732a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f386732a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class l implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386733a;

        public l(AttachReceiver r100) {
            this.f386733a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f386733a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class m implements Function0<com.larus.bmhome.instruction.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386734a;

        public m(AttachReceiver r100) {
            this.f386734a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.instruction.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.instruction.g invoke() {
            AttachReceiver r100 = this.f386734a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class n implements Function0<g1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386735a;

        public n(AttachReceiver r100) {
            this.f386735a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.attachment.g1, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final g1 invoke() {
            AttachReceiver r100 = this.f386735a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(g1.class));
        }
    }

    public static final class o implements Function0<laa.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f386736a;

        public o(AttachReceiver r100) {
            this.f386736a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.j, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.j invoke() {
            AttachReceiver r100 = this.f386736a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    static {
    }

    @Override // ada.c
    public final void K50() {
        this.f386712p0 = true;
    }

    public final void c4() {
        this.Z = true;
        this.f386712p0 = false;
        G3();
        View r100 = P2();
        if (r100 == null) goto L5;
        l4(r100);
    L5:
        va8.c r101 = C3();
        ChatInputInnerView r102 = null;
        if (r101 == null) goto L8;
        AppCompatImageView r103 = ((com.larus.bmhome.chat.component.bottom.core.a) r101).t();
    L9:
        if (r103 == null) goto L11;
        l4(r103);
    L11:
        va8.c r104 = C3();
        if (r104 == null) goto L14;
        View r105 = ((com.larus.bmhome.chat.component.bottom.core.a) r104).F();
    L16:
        if (r105 == null) goto L18;
        r105.setVisibility(8);
    L18:
        va8.c r106 = C3();
        if (r106 == null) goto L21;
        r102 = ((com.larus.bmhome.chat.component.bottom.core.a) r106).H();
    L21:
        if (r102 == null) goto L23;
        r102.setVisibility(0);
    L23:
        TextView r107 = B3();
        if (r107 == null) goto L26;
        r107.setVisibility(8);
    L26:
        e4();
        return;
    L14:
        r105 = null;
        goto L16
    L8:
        r103 = null;
        goto L9
    }

    @Override // ada.c
    public final void jr() {
        this.f386712p0 = false;
        if (this.Z == true) goto L5;
        return;
    L5:
        this.Z = false;
        int r100 = 1;
        this.f386706k0 = true;
        e4();     // Catch: Throwable -> L24
        TextView r101 = B3();     // Catch: Throwable -> L24
        if (r101 == null) goto L16;
        CharSequence r102 = r101.getText();     // Catch: Throwable -> L24
        if (r102 == null) goto L16;
        if (r102.length() <= 0) goto L13;
        boolean r103 = true;
    L14:
        if (r103 != true) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
        r100 = 3;
    L19:
        ICoreInputAbility r105 = h3();     // Catch: Throwable -> L24
        if (r105 == null) goto L22;
        r105.g2(r100, false);     // Catch: Throwable -> L24
    L22:
        this.f386706k0 = false;
        return;
    L13:
        r103 = false;
    L16:
        r104 = false;
    L24:
        th = move-exception;
        this.f386706k0 = false;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.obric.assistant.chat.component.bottom.core.k] */
    /* JADX WARN: Type inference failed for: r6v30, types: [com.obric.assistant.chat.component.bottom.core.j, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r7v7, types: [com.obric.assistant.chat.component.bottom.core.h] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        if (Y2() != null) goto L5;
        FLogger.f375446a.w("ConfigCoreInputComponent", "onParentViewCreated: not found chatPageStateAbility");
    L5:
        laa.d r100 = Y2();
        if (r100 == null) goto L9;
        r100.HU(this);
    L9:
        if (s1a.a.e(this) == false) goto L11;
    L12:
        int r101 = ContextCompat.getColor(getContext(), R.color.larus_neutral_100);
        va8.c r102 = C3();
        if (r102 == null) goto L15;
        ((com.larus.bmhome.chat.component.bottom.core.a) r102).l(new va8.a(Integer.valueOf(r101), Integer.valueOf(r101), Integer.valueOf(r101), Integer.valueOf(r101)));
    L15:
        TextView r103 = B3();
        AppCompatImageView r104 = null;
        if ((r103 instanceof EditText) == false) goto L18;
        EditText r105 = (EditText) r103;
    L19:
        if (r105 == null) goto L21;
        final ObricMentionInputController r106 = new ObricMentionInputController(getContext(), r105, (paa.c) this.f386713q.getValue(), (p1) this.f386714r.getValue(), (com.larus.bmhome.instruction.g) this.f386709n.getValue(), h3(), new com.obric.assistant.chat.component.bottom.core.k(this));
    L22:
        this.A = r106;
        if (r106 == null) goto L35;
        if (r106.f386768k == true) goto L35;
        r106.f386768k = true;
        CopyOnWriteArraySet<com.obric.assistant.task.skill.f.a> r107 = com.obric.assistant.task.skill.f.f393409a;
        com.obric.assistant.task.skill.f.a(r106.f386769l);
        r106.b();
        paa.c r108 = r106.f386760c;
        if (r108 == null) goto L30;
        r108.hM(r106.f386770m);
    L30:
        paa.c r109 = r106.f386760c;
        if (r109 == null) goto L33;
        r109.nz(r106.f386771n);
    L33:
        r106.f386759b.post(new com.obric.assistant.chat.component.bottom.core.mention.i(r106));
    L35:
        if (this.T == true) goto L39;
        this.T = true;
        BuildersKt.launch$default(this.S, null, null, new ObricChatInputComponent$observeOmniSkillStateForDraftRestore$1(this, null), 3, null);
    L39:
        if (this.V == true) goto L45;
        this.V = true;
        ICoreInputAbility r110 = h3();
        if (r110 == null) goto L44;
        r110.QG(this.W);
    L44:
        BuildersKt.launch$default(this.U, null, null, new ObricChatInputComponent$observePhoneOperationAttachmentSendState$1(this, null), 3, null);
        BuildersKt.launch$default(this.U, null, null, new ObricChatInputComponent$observePhoneOperationAttachmentSendState$2(this, null), 3, null);
        a4("init");
    L45:
        W00();
        ViewGroup r111 = z3();
        if (r111 == null) goto L49;
        r111.setClickable(true);
    L49:
        if (s1a.a.e(this) == false) goto L246;
        FrameLayout r112 = X2();
        if (r112 == null) goto L53;
        r112.setClipToPadding(false);
        r112.setClipChildren(false);
    L53:
        final ChatConstraintLayout r113 = (ChatConstraintLayout) this.f386719w.getValue();
        if (r113 != 0) goto L57;
    L60:
        FrameLayout r114 = (FrameLayout) this.f386720x.getValue();
        if (r114 == null) goto L63;
        ViewExtKt.l(r114, new com.obric.assistant.chat.component.bottom.core.g(this), new com.obric.assistant.chat.component.bottom.core.h(this), null, new com.obric.assistant.chat.component.bottom.core.i(this), 4);
    L63:
        FrameLayout r115 = X2();
        if (r115 == null) goto L75;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L68;
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
    L69:
        if (r117 != null) goto L71;
        r117 = null;
    L74:
        r115.setLayoutParams(r117);
        goto L75
    L71:
        if (r117.bottomMargin > 0) goto L74;
        r117.bottomMargin = 56;
        goto L74
    L68:
        r117 = null;
    L75:
        ViewGroup r118 = z3();
        if (r118 == null) goto L78;
        int r119 = aia.e.f3865a;
        int r120 = c7.b(12);
        r118.setPadding(r120, r120, r120, r120);
    L78:
        TextView r121 = B3();
        if (r121 == null) goto L85;
        r121.setVerticalScrollBarEnabled(false);
        r121.setVerticalFadingEdgeEnabled(true);
        r121.setFadingEdgeLength(c7.b(22));
        int r122 = aia.e.f3865a;
        int r123 = c7.b(8);
        r121.setPadding(r123, r123, r121.getPaddingRight(), r123);
        r121.setMinHeight(aia.e.b());
        ViewGroup.LayoutParams r124 = r121.getLayoutParams();
        if (r124 == null) goto L84;
        ConstraintLayout.LayoutParams r125 = (ConstraintLayout.LayoutParams) r124;
        ((ViewGroup.MarginLayoutParams) r125).bottomMargin = 0;
        r121.setLayoutParams(r125);
        r121.setLayoutParams(r125);
        r121.setHintTextColor(ContextCompat.getColor(getContext(), R.color.oui_basic_text_3b));
        goto L85
    L84:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L85:
        va8.c r126 = C3();
        if (r126 == null) goto L88;
        ChatInputInnerView r127 = ((com.larus.bmhome.chat.component.bottom.core.a) r126).H();
    L90:
        if (r127 == null) goto L96;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if (r128 == null) goto L95;
        r128.height = aia.e.b();
        r127.setLayoutParams(r128);
        goto L96
    L95:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L96:
        va8.c r129 = C3();
        if (r129 == null) goto L99;
        TextView r130 = ((com.larus.bmhome.chat.component.bottom.core.a) r129).I();
    L100:
        if (r130 == null) goto L102;
        r130.setLetterSpacing(0.0f);
        q2.a(r130);
    L102:
        ViewGroup r131 = p3();
        if (r131 == null) goto L105;
        int r132 = aia.e.f3865a;
        int r133 = c7.b(8);
        r131.setPadding(r133, r131.getPaddingTop(), r133, r131.getPaddingBottom());
    L105:
        va8.c r134 = C3();
        if (r134 == null) goto L108;
        View r135 = ((com.larus.bmhome.chat.component.bottom.core.a) r134).j();
    L109:
        if (r135 == null) goto L120;
        ViewGroup.LayoutParams r136 = r135.getLayoutParams();
        if (r136 == null) goto L119;
        r136.height = i5.a();
        r135.setLayoutParams(r136);
        r135.setBackgroundColor(ContextCompat.getColor(r135.getContext(), R.color.neutral_transparent_1));
        Object r137 = r135.getParent();
        if ((r137 instanceof View) == false) goto L115;
        View r138 = (View) r137;
    L116:
        if (r138 == null) goto L120;
        r138.setBackgroundColor(ContextCompat.getColor(r135.getContext(), R.color.neutral_transparent_1));
        goto L120
    L115:
        r138 = null;
        goto L116
    L119:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L120:
        View r139 = L2();
        if (r139 == null) goto L127;
        ViewGroup.LayoutParams r140 = r139.getLayoutParams();
        if (r140 == null) goto L126;
        r140.height = aia.e.b();
        r140.width = c7.b(40);
        r139.setLayoutParams(r140);
        r139.setPadding(0, 0, 0, 0);
        goto L127
    L126:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L127:
        va8.c r141 = C3();
        if (r141 == null) goto L130;
        ((com.larus.bmhome.chat.component.bottom.core.a) r141).z();
    L130:
        va8.c r142 = C3();
        if (r142 == null) goto L133;
        AppCompatImageView r143 = ((com.larus.bmhome.chat.component.bottom.core.a) r142).n();
    L134:
        if (r143 == null) goto L140;
        ViewGroup.LayoutParams r144 = r143.getLayoutParams();
        if (r144 == null) goto L139;
        int r145 = aia.e.f3865a;
        r144.width = c7.b(40);
        r144.height = aia.e.b();
        r143.setLayoutParams(r144);
        goto L140
    L139:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L140:
        va8.c r146 = C3();
        if (r146 == null) goto L143;
        ((com.larus.bmhome.chat.component.bottom.core.a) r146).B();
    L143:
        va8.c r147 = C3();
        if (r147 == null) goto L146;
        AppCompatImageView r148 = ((com.larus.bmhome.chat.component.bottom.core.a) r147).t();
    L147:
        if (r148 == null) goto L153;
        ViewGroup.LayoutParams r149 = r148.getLayoutParams();
        if (r149 == null) goto L152;
        r149.width = aia.e.a();
        r149.height = aia.e.b();
        r148.setLayoutParams(r149);
        r148.setPadding(0, 0, 0, 0);
        goto L153
    L152:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L153:
        va8.c r150 = C3();
        if (r150 == null) goto L156;
        View r151 = ((com.larus.bmhome.chat.component.bottom.core.a) r150).F();
    L157:
        if (r151 == null) goto L163;
        ViewGroup.LayoutParams r152 = r151.getLayoutParams();
        if (r152 == null) goto L162;
        r152.height = aia.e.b();
        r151.setLayoutParams(r152);
        goto L163
    L162:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L163:
        va8.c r153 = C3();
        if (r153 == null) goto L166;
        ((com.larus.bmhome.chat.component.bottom.core.a) r153).E();
    L166:
        va8.c r154 = C3();
        if (r154 == null) goto L169;
        AppCompatImageView r155 = ((com.larus.bmhome.chat.component.bottom.core.a) r154).G();
    L170:
        if (r155 == null) goto L176;
        ViewGroup.LayoutParams r156 = r155.getLayoutParams();
        if (r156 == null) goto L175;
        r156.width = aia.e.a();
        r156.height = aia.e.b();
        r155.setLayoutParams(r156);
        r155.setPadding(0, 0, 0, 0);
        goto L176
    L175:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L176:
        View r157 = P2();
        if (r157 == null) goto L179;
        ViewParent r158 = r157.getParent();
    L181:
        if ((r158 instanceof ViewGroup) == false) goto L183;
        ViewGroup r159 = (ViewGroup) r158;
    L184:
        if (r159 == null) goto L190;
        ViewGroup.LayoutParams r160 = r159.getLayoutParams();
        if (r160 == null) goto L189;
        r160.height = aia.e.b();
        r159.setLayoutParams(r160);
        r159.setPadding(0, 0, 0, 0);
        goto L190
    L189:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L190:
        va8.c r161 = C3();
        if (r161 == null) goto L193;
        ((com.larus.bmhome.chat.component.bottom.core.a) r161).D();
    L193:
        View r162 = P2();
        if (r162 == null) goto L200;
        ViewGroup.LayoutParams r163 = r162.getLayoutParams();
        if (r163 == null) goto L199;
        r163.width = aia.e.a();
        r163.height = aia.e.b();
        r162.setLayoutParams(r163);
        r162.setPadding(0, 0, 0, 0);
        goto L200
    L199:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L200:
        View r164 = N2();
        if (r164 == null) goto L203;
        ViewParent r165 = r164.getParent();
    L205:
        if ((r165 instanceof ViewGroup) == false) goto L207;
        ViewGroup r166 = (ViewGroup) r165;
    L208:
        if (r166 == null) goto L214;
        ViewGroup.LayoutParams r167 = r166.getLayoutParams();
        if (r167 == null) goto L213;
        r167.height = aia.e.b();
        r166.setLayoutParams(r167);
        goto L214
    L213:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L214:
        View r168 = N2();
        if (r168 == null) goto L221;
        ViewGroup.LayoutParams r169 = r168.getLayoutParams();
        if (r169 == null) goto L220;
        r169.width = aia.e.a();
        r169.height = aia.e.b();
        r168.setLayoutParams(r169);
        r168.setPadding(0, 0, 0, 0);
        goto L221
    L220:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L221:
        va8.c r170 = C3();
        if (r170 == null) goto L224;
        ((com.larus.bmhome.chat.component.bottom.core.a) r170).C();
    L224:
        va8.c r171 = C3();
        if (r171 == null) goto L227;
        AppCompatImageView r172 = ((com.larus.bmhome.chat.component.bottom.core.a) r171).u();
    L228:
        if (r172 == null) goto L234;
        ViewGroup.LayoutParams r173 = r172.getLayoutParams();
        if (r173 == null) goto L233;
        r173.width = aia.e.a();
        r173.height = aia.e.b();
        r172.setLayoutParams(r173);
        goto L234
    L233:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L234:
        va8.c r174 = C3();
        if (r174 == null) goto L237;
        ((com.larus.bmhome.chat.component.bottom.core.a) r174).A();
    L237:
        va8.c r175 = C3();
        if (r175 == null) goto L240;
        r104 = ((com.larus.bmhome.chat.component.bottom.core.a) r175).o();
    L240:
        if (r104 == null) goto L246;
        ViewGroup.LayoutParams r176 = r104.getLayoutParams();
        if (r176 == null) goto L245;
        r176.width = aia.e.a();
        r104.setLayoutParams(r176);
        r104.setPadding(0, 0, 0, 0);
        goto L246
    L245:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L227:
        r172 = null;
        goto L228
    L207:
        r166 = null;
        goto L208
    L203:
        r165 = null;
        goto L205
    L183:
        r159 = null;
        goto L184
    L179:
        r158 = null;
        goto L181
    L169:
        r155 = null;
        goto L170
    L156:
        r151 = null;
        goto L157
    L146:
        r148 = null;
        goto L147
    L133:
        r143 = null;
        goto L134
    L108:
        r135 = null;
        goto L109
    L99:
        r130 = null;
        goto L100
    L88:
        r127 = null;
        goto L90
    L57:
        if (this.E != null) goto L60;
        final Function2<Integer, String, Boolean> r177 = r113.getInterruptBottomPaddingUpdate();
        this.D = r177;
        ?? r178 = new com.obric.assistant.chat.component.bottom.core.j(r177, this, r113);
        this.E = r178;
        r113.setInterruptBottomPaddingUpdate(r178);
    L246:
        b5(com.obric.assistant.task.skill.f.d());
        return;
    L21:
        r106 = null;
        goto L22
    L18:
        r105 = null;
        goto L19
    L11:
        if (Y2() == null) goto L15;
        goto L12
    }

    public final laa.j D3() {
        return (laa.j) this.f386711p.getValue();
    }

    @Override // ada.c
    public final void Ep() {
        if (s1a.a.e(this) == false) goto L5;
        int r100 = 0;
    L15:
        float r101 = c7.a(R.dimen.dp_16);
        ViewGroup r102 = (ViewGroup) this.f386722z.getValue();
        if (r102 != null) goto L18;
    L20:
        boolean r103 = false;
    L21:
        if (r103 == true) goto L32;
        va8.c r104 = C3();
        if (r104 == null) goto L25;
        ViewGroup r105 = ((com.larus.bmhome.chat.component.bottom.core.a) r104).p();
    L26:
        if (r105 == null) goto L28;
        int r106 = r105.getMeasuredHeight();
    L29:
        if (r106 > 0) goto L32;
        boolean r107 = false;
    L34:
        if (r107 == false) goto L36;
        float r108 = 0.0f;
    L37:
        float[] r109 = {r108, r108, r108, r108, r101, r101, r101, r101};
        ViewGroup r110 = p3();
        if (r110 == null) goto L40;
        GradientDrawable r111 = new GradientDrawable();
        r111.setCornerRadii(r109);
        r111.setColor(r100);
        r110.setBackground(r111);
    L40:
        va8.c r112 = C3();
        if (r112 == null) goto L43;
        ViewGroup r113 = ((com.larus.bmhome.chat.component.bottom.core.a) r112).K();
    L44:
        if (r113 == null) goto L46;
        r113.setBackgroundColor(r100);
    L46:
        float[] r114 = {r101, r101, r101, r101, 0.0f, 0.0f, 0.0f, 0.0f};
        ViewGroup r115 = (ViewGroup) this.f386722z.getValue();
        if (r115 == null) goto L49;
        GradientDrawable r116 = new GradientDrawable();
        r116.setCornerRadii(r114);
        r116.setColor(r100);
        r115.setBackground(r116);
    L49:
        va8.c r117 = C3();
        if (r117 == null) goto L52;
        View r118 = ((com.larus.bmhome.chat.component.bottom.core.a) r117).j();
    L53:
        if (r118 == null) goto L55;
        Object r119 = r118.getParent();
    L57:
        if ((r119 instanceof View) == false) goto L59;
        View r120 = (View) r119;
    L60:
        if (r120 == null) goto L62;
        r120.setBackgroundColor(r100);
    L62:
        va8.c r121 = C3();
        if (r121 == null) goto L65;
        ResourceBar r122 = ((com.larus.bmhome.chat.component.bottom.core.a) r121).x();
    L66:
        if (r122 == null) goto L68;
        Drawable r123 = r122.getBackground();
    L70:
        if ((r123 instanceof GradientDrawable) == false) goto L72;
        GradientDrawable r124 = (GradientDrawable) r123;
    L73:
        if (r124 == null) goto L75;
        r124.setColor(r100);
    L75:
        View r125 = E3();
        if (r125 == null) goto L78;
        Drawable r126 = r125.getBackground();
    L80:
        if ((r126 instanceof ColorDrawable) == false) goto L82;
        ColorDrawable r127 = (ColorDrawable) r126;
    L83:
        if (r127 == null) goto L94;
        Drawable r128 = r127.mutate();
        if ((r128 instanceof ColorDrawable) == false) goto L87;
        ColorDrawable r129 = (ColorDrawable) r128;
    L88:
        if (r129 == null) goto L96;
        View r130 = E3();
        if (r130 == null) goto L95;
        r129.setColor(r100);
        r130.setBackground(r129);
        return;
    L95:
        return;
    L96:
        return;
    L87:
        r129 = null;
        goto L88
    L94:
        return;
    L82:
        r127 = null;
        goto L83
    L78:
        r126 = null;
        goto L80
    L72:
        r124 = null;
        goto L73
    L68:
        r123 = null;
        goto L70
    L65:
        r122 = null;
        goto L66
    L59:
        r120 = null;
        goto L60
    L55:
        r119 = null;
        goto L57
    L52:
        r118 = null;
        goto L53
    L43:
        r113 = null;
        goto L44
    L36:
        r108 = r101;
        goto L37
    L28:
        r106 = 0;
        goto L29
    L25:
        r105 = null;
    L32:
        r107 = true;
        goto L34
    L18:
        if (r102.getVisibility() != 0) goto L20;
        r103 = true;
        goto L21
    L5:
        Context r131 = getContext();
        laa.d r132 = Y2();
        if (r132 != null) goto L8;
    L10:
        boolean r133 = false;
    L11:
        if (r133 == false) goto L13;
        int r134 = R.color.obric_action_bar_input_bg_color_chat_window;
    L14:
        r100 = ContextCompat.getColor(r131, r134);
        goto L15
    L13:
        r134 = R.color.obric_action_bar_input_bg_color;
        goto L14
    L8:
        if (r132.aF() != true) goto L10;
        r133 = true;
        goto L11
    }

    @Override // ada.b
    public final void H7() {
        ObricMentionInputController r100 = this.A;
        if (r100 == null) goto L12;
        r100.f386767j = true;
        FLogger.f375446a.i("ObricMentionInputController", "onTextDraftRestoreFinished");
        paa.c r101 = r100.f386760c;
        if (r101 == null) goto L7;
        List<paa.e> r102 = r101.Zm();
    L8:
        if (r102 != null) goto L10;
        r102 = CollectionsKt.emptyList();
    L10:
        r100.l(r102);
        r100.d();
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // ada.c
    public final CharSequence I3() {
        if (t1.f393353a.Q0() == false) goto L6;
        return null;
    L6:
        if (X3() == true) goto L9;
        return null;
    L9:
        return getContext().getString(R.string.input_hint_send_msg);
    }

    @Override // ada.c
    public final void O6() {
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
    }

    public final va8.l U2() {
        return (va8.l) this.f386717u.getValue();
    }

    public final boolean V3() {
        y r100 = (y) this.f386705k.getValue();
        if (r100 == null) goto L5;
        wc9.e r101 = r100.h();
    L7:
        return com.larus.bmhome.utils.i.h(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // ada.c
    public final void V8() {
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.obric.assistant.chat.component.bottom.core.a] */
    @Override // ada.c
    public final void W00() {
        IObricChatUIService r100 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L12;
        FLogger.f375446a.i("ConfigCoreInputComponent", "updateInputTextFiltersForChatInput: return by ObricInputLengthFilter disabled");
        return;
    L12:
        int r102 = t1.f393353a.I0().getOChatInputMaxLength();
        o1 r103 = new o1(r102, new com.obric.assistant.chat.component.bottom.core.a(this));
        FLogger.f375446a.i("ConfigCoreInputComponent", "updateInputTextFiltersForChatInput: filter: " + r103 + ", maxLength = " + r102);
        va8.o r104 = m3();
        if (r104 == null) goto L16;
        r104.oD(new InputFilter[]{r103});
        return;
    L16:
        return;
    L5:
        if (r100.p() == true) goto L7;
        r101 = true;
        goto L9
    }

    public final boolean W3() {
        if (this.Z == false) goto L5;
        return true;
    L5:
        if (this.f386712p0 == true) goto L30;
        com.larus.bmhome.instruction.g r100 = (com.larus.bmhome.instruction.g) this.f386709n.getValue();
        if (r100 != null) goto L10;
    L12:
        boolean r101 = false;
    L13:
        if (r101 == true) goto L15;
        return false;
    L15:
        com.larus.bmhome.instruction.g r102 = (com.larus.bmhome.instruction.g) this.f386709n.getValue();
        if (r102 == null) goto L20;
        z0 r103 = r102.yF();
        if (r103 == null) goto L20;
        String r104 = r103.f295606b;
    L22:
        if (Intrinsics.areEqual(r104, "obric_web_perception") == false) goto L24;
        return true;
    L24:
        if (Intrinsics.areEqual(r104, "obric_video_perception") == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        r104 = null;
        goto L22
    L10:
        if (r100.z0() != true) goto L12;
        r101 = true;
        goto L13
    L30:
        return true;
    }

    public final FrameLayout X2() {
        return (FrameLayout) this.f386721y.getValue();
    }

    public final laa.d Y2() {
        return (laa.d) this.f386707l.getValue();
    }

    public final g1 f70() {
        return (g1) this.f386710o.getValue();
    }

    public final ICoreInputAbility h3() {
        return (ICoreInputAbility) this.H0.getValue();
    }

    public final void i4() {
        if (this.P == true) goto L5;
        return;
    L5:
        boolean r100 = this.Q;
        this.P = false;
        ICoreInputAbility r101 = h3();
        if (r101 == null) goto L10;
        CoreInputAbility r102 = r101.JO();
        if (r102 == null) goto L10;
        r102.S8(this.R);
    L10:
        this.Q = false;
        this.R = false;
        if (r101 == null) goto L13;
        r101.uq(true);
    L13:
        CharSequence r103 = null;
        if (r101 == null) goto L20;
        EditPos r104 = new EditPos(0);
        y r105 = (y) this.f386705k.getValue();
        if (r105 == null) goto L18;
        BotModel r106 = r105.j0();
    L19:
        r101.eQ(r104, r106);
        goto L20
    L18:
        r106 = null;
    L20:
        if (r101 == null) goto L22;
        r101.rE();
    L22:
        if (r101 == null) goto L24;
        r101.zM();
    L24:
        if (r100 == false) goto L41;
        TextView r107 = B3();
        if (r107 == null) goto L28;
        r103 = r107.getText();
    L28:
        if (r103 != null) goto L30;
    L33:
        boolean r108 = true;
    L34:
        if (r108 == false) goto L41;
        ICoreInputAbility r109 = h3();
        if (r109 == null) goto L38;
        r109.Dr(true);
    L38:
        View r110 = L2();
        if (r110 == null) goto L41;
        r110.setVisibility(0);
        goto L41
    L30:
        if (r103.length() == 0) goto L33;
        r108 = false;
    L41:
        FLogger.f375446a.i("ConfigCoreInputComponent", "[PhoneOperationMedia] camera and plus entrances restored");
    }

    public final boolean j4() {
        if (t1.f393353a.Q0() == false) goto L6;
        return false;
    L6:
        if (X3() == true) goto L8;
        return false;
    L8:
        g1 r100 = f70();
        boolean r101 = true;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L26;
        g1 r103 = f70();
        if (r103 == null) goto L22;
        b1 r104 = r103.Ry();
        if (r104 == null) goto L22;
        if (((Boolean) r104.getValue()).booleanValue() != true) goto L22;
        boolean r105 = true;
    L23:
        if (r105 == true) goto L26;
        r101 = false;
    L22:
        r105 = false;
    L26:
        if (r101 == true) goto L28;
        return false;
    L28:
        TextView r106 = B3();
        if (r106 == null) goto L33;
        CharSequence r107 = r106.getText();
        if (r107 == null) goto L33;
        String r108 = r107.toString();
    L34:
        if (r108 != null) goto L37;
        r108 = "";
    L37:
        return StringsKt.isBlank(r108);
    L33:
        r108 = null;
        goto L34
    L11:
        if (r100.isVisible() != true) goto L13;
        r102 = true;
        goto L14
    }

    public final va8.o m3() {
        return (va8.o) this.f386704j.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        ObricMentionInputController r100 = this.A;
        if (r100 == null) goto L6;
        r100.i();
        OSkillCache.f392527a.getClass();
        OSkillCache.g();
        r100.f386759b.post(new com.obric.assistant.chat.component.bottom.core.mention.c(r100));
        return;
    }

    public ObricChatInputComponent() {
        this.f386702h = LazyKt.lazy(new g(this));
        this.f386703i = LazyKt.lazy(new h(this));
        this.f386704j = LazyKt.lazy(new i(this));
        this.f386705k = LazyKt.lazy(new j(this));
        this.f386707l = LazyKt.lazy(new k(this));
        this.f386708m = LazyKt.lazy(new l(this));
        this.f386709n = LazyKt.lazy(new m(this));
        this.f386710o = LazyKt.lazy(new n(this));
        this.f386711p = LazyKt.lazy(new o(this));
        this.f386713q = LazyKt.lazy(new c(this));
        this.f386714r = LazyKt.lazy(new d(this));
        this.f386715s = LazyKt.lazy(new e(this));
        this.f386716t = LazyKt.lazy(new f(this));
        this.f386717u = LazyKt.lazy(new com.obric.assistant.chat.component.bottom.core.n(this));
        this.f386718v = LazyKt.lazy(new q(this));
        this.f386719w = LazyKt.lazy(new r(this));
        this.f386720x = LazyKt.lazy(new s(this));
        this.f386721y = LazyKt.lazy(new com.obric.assistant.chat.component.bottom.core.b(this));
        this.f386722z = LazyKt.lazy(new com.obric.assistant.chat.component.bottom.core.c(this));
        this.B = LazyKt.lazy(new com.obric.assistant.chat.component.bottom.core.d(this));
        this.C = LazyKt.lazy(new com.obric.assistant.chat.component.bottom.core.e(this));
        this.S = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.U = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.W = new b(this);
        this.X = LazyKt.lazy(new com.obric.assistant.chat.component.bottom.core.f(this));
        this.Y = LazyKt.lazy(new com.obric.assistant.chat.component.bottom.core.o(this));
        this.H0 = LazyKt.lazy(new p(this));
    }

    public final TextView B3() {
        va8.c r100 = C3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    @Override // ada.c
    public final Integer B7() {
        return Integer.valueOf(R.drawable.obric_ic_obric_send);
    }

    public final va8.c C3() {
        va8.o r100 = m3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Uv();
    }

    public final View E3() {
        va8.c r100 = C3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }

    public final void F2() {
        final ICoreInputAbility r100 = h3();
        if (r100 != null) goto L5;
        return;
    L5:
        final ada.d r101 = (ada.d) this.f386716t.getValue();
        if (r101 != null) goto L8;
        return;
    L8:
        CoreInputAbility r102 = r100.JO();
        if (this.L == true) goto L16;
        z8.a r103 = r100.Jd();
        z8.c r104 = r103.f299539h;
        this.M = r104;
        this.O = r103.f299552u;
        Function2 r105 = new com.obric.assistant.chat.component.bottom.core.m(r101, this, r100);
        if (r104 == null) goto L13;
        Function0<Boolean> r106 = r104.f299559b;
    L14:
        z8.c r107 = new z8.c(r105, r106);
        this.N = r107;
        r102.W8(r107);
        this.L = true;
        goto L16
    L13:
        r106 = null;
    L16:
        if (r100.Jd().f299539h != this.N) goto L18;
        r102.S8(false);
    L18:
        r100.s20(1);
        r100.rE();
    }

    public final void G3() {
        View r100 = L2();
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        va8.c r101 = C3();
        View r102 = null;
        if (r101 == null) goto L8;
        AppCompatImageView r103 = ((com.larus.bmhome.chat.component.bottom.core.a) r101).J();
    L9:
        if (r103 == null) goto L11;
        r103.setVisibility(8);
    L11:
        va8.c r104 = C3();
        if (r104 == null) goto L14;
        AppCompatImageView r105 = ((com.larus.bmhome.chat.component.bottom.core.a) r104).o();
    L15:
        if (r105 == null) goto L17;
        r105.setVisibility(8);
    L17:
        View r106 = N2();
        if (r106 == null) goto L20;
        r106.setVisibility(8);
    L20:
        va8.c r107 = C3();
        if (r107 == null) goto L23;
        AppCompatImageView r108 = ((com.larus.bmhome.chat.component.bottom.core.a) r107).m();
    L24:
        if (r108 == null) goto L26;
        r108.setVisibility(8);
    L26:
        va8.c r109 = C3();
        if (r109 == null) goto L29;
        View r110 = ((com.larus.bmhome.chat.component.bottom.core.a) r109).w();
    L30:
        if (r110 == null) goto L32;
        r110.setVisibility(8);
    L32:
        va8.c r111 = C3();
        if (r111 == null) goto L35;
        r102 = ((com.larus.bmhome.chat.component.bottom.core.a) r111).v();
    L35:
        if (r102 == null) goto L38;
        r102.setVisibility(8);
        return;
    L38:
        return;
    L29:
        r110 = null;
        goto L30
    L23:
        r108 = null;
        goto L24
    L14:
        r105 = null;
        goto L15
    L8:
        r103 = null;
        goto L9
    }

    public final void H3() {
        ICoreInputAbility r100 = h3();
        if (this.P == false) goto L5;
    L24:
        va8.o r101 = m3();
        if (r101 == null) goto L27;
        r101.k3(false);
    L27:
        View r102 = L2();
        if (r102 == null) goto L30;
        r102.setVisibility(8);
    L30:
        View r103 = N2();
        if (r103 == null) goto L33;
        r103.setVisibility(8);
    L33:
        if (r100 == null) goto L38;
        CoreInputAbility r104 = r100.JO();
        if (r104 == null) goto L39;
        r104.S8(true);
        return;
    L39:
        return;
    L38:
        return;
    L5:
        if (this.L == false) goto L7;
        boolean r105 = this.O;
    L14:
        h4(true);
        this.R = r105;
        View r106 = L2();
        if (r106 != null) goto L17;
    L19:
        boolean r107 = false;
    L20:
        this.Q = r107;
        this.P = true;
        if (r100 == null) goto L23;
        r100.uq(false);
    L23:
        FLogger.f375446a.i("ConfigCoreInputComponent", "[PhoneOperationMedia] camera and plus entrances hidden, isWindowHost=" + s1a.a.e(this) + ", shouldRestoreActionEntrance=" + this.Q + ", previousTakeOverVisibility=" + this.R);
        goto L24
    L17:
        if (r106.getVisibility() != 0) goto L19;
        r107 = true;
        goto L20
    L7:
        if (r100 == null) goto L13;
        z8.a r108 = r100.Jd();
        if (r108 == null) goto L13;
        if (r108.f299552u != true) goto L13;
        r105 = true;
    L13:
        r105 = false;
        goto L14
    }

    public final View L2() {
        va8.c r100 = C3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.e();
    }

    public final View N2() {
        va8.c r100 = C3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    @Override // ada.c
    public final String N5() {
        TextView r100 = B3();
        if (r100 == null) goto L7;
        CharSequence r101 = r100.getText();
        if (r101 == null) goto L7;
        return r101.toString();
    L7:
        return null;
    }

    public final View P2() {
        va8.c r100 = C3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ((com.larus.bmhome.chat.component.bottom.core.a) r100).y();
    }

    @Override // ada.b
    public final String St() {
        laa.j r100 = D3();
        if (r100 == null) goto L15;
        b1 r101 = r100.i80();
        if (r101 == null) goto L15;
        v r102 = (v) r101.getValue();
        if (r102 == null) goto L15;
        DMTaskState r103 = r102.f508238a;
        if (r103 == null) goto L15;
        DMTaskInfo r104 = r103.getTaskInfo();
        if (r104 == null) goto L15;
        IMMessage r105 = r104.getMessage();
        if (r105 == null) goto L15;
        return r105.getMessageId();
    L15:
        return null;
    }

    public final boolean X3() {
        laa.j r100 = D3();
        if (r100 == null) goto L9;
        b1 r101 = r100.O4();
        if (r101 == null) goto L9;
        if (((Boolean) r101.getValue()).booleanValue() != true) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return true;
    L13:
        if (com.obric.assistant.task.skill.f.d() == true) goto L15;
        return false;
    L15:
        if (V3() == false) goto L19;
        return true;
    L19:
        return false;
    L9:
        r102 = false;
        goto L10
    }

    public final boolean Z3() {
        laa.d r100 = Y2();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L12;
        boolean r102 = v19.h.f552477a;
        if (v19.h.b(getContext()) == false) goto L12;
    L13:
        return true;
    L12:
        if (s1a.a.e(this) == true) goto L13;
        return false;
    L5:
        if (r100.isVisible() != true) goto L7;
        r101 = true;
        goto L8
    }

    public final void e4() {
        TextView r100 = B3();
        ConstraintLayout.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        r101 = (ConstraintLayout.LayoutParams) r102;
    L9:
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.getMarginEnd() == 0) goto L17;
        r101.setMarginEnd(0);
        TextView r103 = B3();
        if (r103 == null) goto L18;
        r103.setLayoutParams(r101);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        i4();
        h4(true);
        ICoreInputAbility r100 = h3();
        if (r100 == null) goto L5;
        r100.Vs(this.W);
    L5:
        laa.d r101 = Y2();
        if (r101 == null) goto L8;
        r101.AN(this);
    L8:
        ObricMentionInputController r102 = this.A;
        if (r102 != null) goto L11;
    L37:
        this.A = null;
        CoroutineScopeKt.cancel$default(this.S, null, 1, null);
        CoroutineScopeKt.cancel$default(this.U, null, 1, null);
        if (s1a.a.e(this) == false) goto L53;
        ChatConstraintLayout r103 = (ChatConstraintLayout) this.f386719w.getValue();
        if (r103 == null) goto L54;
        com.obric.assistant.chat.component.bottom.core.j r104 = this.E;
        if (r104 != null) goto L46;
        return;
    L46:
        if (r103.getInterruptBottomPaddingUpdate() != r104) goto L51;
        Function2<? super Integer, ? super String, Boolean> r105 = this.D;
        if (r105 != null) goto L50;
        r105 = new com.obric.assistant.chat.component.bottom.core.l();
    L50:
        r103.setInterruptBottomPaddingUpdate(r105);
    L51:
        this.D = null;
        this.E = null;
        return;
    L54:
        return;
    L53:
        return;
    L11:
        if (r102.f386768k == false) goto L37;
        r102.f386768k = false;
        CopyOnWriteArraySet<com.obric.assistant.task.skill.f.a> r106 = com.obric.assistant.task.skill.f.f393409a;
        com.obric.assistant.chat.component.bottom.core.mention.f r107 = r102.f386769l;
        Intrinsics.checkNotNullParameter(r107, "listener");
        com.obric.assistant.task.skill.f.f393409a.remove(r107);
        paa.c r108 = r102.f386760c;
        if (r108 == null) goto L16;
        r108.p70(r102.f386770m);
    L16:
        paa.c r109 = r102.f386760c;
        if (r109 == null) goto L19;
        r109.hJ(r102.f386771n);
    L19:
        r102.f386766i = null;
        r102.f386767j = false;
        ObricMentionHighlightHelper.a r110 = r102.f386765h;
        if (r110 == null) goto L31;
        r110.f393599a.removeTextChangedListener(r110);
        EditText r111 = r110.f393599a;
        if ((r111 instanceof ChatInputText) == false) goto L24;
        ChatInputText r112 = (ChatInputText) r111;
    L25:
        if (r112 == null) goto L27;
        s1 r113 = r110.f393614p;
        Intrinsics.checkNotNullParameter(r113, "interceptor");
        ((ArrayList) r112.f315419f).remove(r113);
    L27:
        Editable r114 = r110.f393599a.getText();
        if (r114 == null) goto L30;
        r114.removeSpan(r110.f393613o);
    L30:
        r110.f393599a.setOnKeyListener(r110.f393611m);
        r110.f393611m = null;
        r110.e();
        goto L31
    L24:
        r112 = null;
    L31:
        r102.f386765h = null;
        ICoreInputAbility r115 = r102.f386763f;
        if (r115 == null) goto L34;
        r115.oz(false);
    L34:
        paa.c r116 = r102.f386760c;
        if (r116 == null) goto L37;
        r116.CZ();
        goto L37
    }

    public final ViewGroup p3() {
        va8.c r100 = C3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ((com.larus.bmhome.chat.component.bottom.core.a) r100).q();
    }

    @Override // ada.c
    public final boolean v8() {
        return j4();
    }

    @Override // ada.b
    public final String vx() {
        laa.j r100 = D3();
        if (r100 == null) goto L15;
        b1 r101 = r100.i80();
        if (r101 == null) goto L15;
        v r102 = (v) r101.getValue();
        if (r102 == null) goto L15;
        DMTaskState r103 = r102.f508238a;
        if (r103 == null) goto L15;
        DMTaskInfo r104 = r103.getTaskInfo();
        if (r104 == null) goto L15;
        IMMessage r105 = r104.getMessage();
        if (r105 == null) goto L15;
        return com.larus.bmhome.chat.bean.d.H(com.obric.assistant.special_input.util.i.a(r105));
    L15:
        return null;
    }

    public final ViewGroup z3() {
        va8.c r100 = C3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return ((com.larus.bmhome.chat.component.bottom.core.a) r100).h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean Q3(RecyclerView r100) {
        if ((r100 instanceof b0) == false) goto L5;
        b0 r101 = (b0) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.i() == false) goto L12;
    L13:
        return true;
    L12:
        if (r101.m().canScrollVertically(1) == false) goto L13;
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public static void l4(View r100) {
        r100.setVisibility(0);
        r100.setEnabled(true);
        r100.setAlpha(1.0f);
    }

    @Override // ada.c
    public final void F3(boolean r100) {
        va8.l r101 = U2();
        if (r101 == null) goto L8;
        GridLayout r102 = r101.a();
        if (r102 == null) goto L9;
        r102.setClipChildren(!r100);
        r102.setClipToPadding(!r100);
        return;
    L9:
        return;
    }

    @Override // ada.c
    public final boolean H8(int r100) {
        if (this.f386706k0 == false) goto L6;
        return false;
    L6:
        if (W3() == true) goto L9;
        return false;
    L9:
        if (r100 == 1) goto L11;
    L14:
        if (r100 != 1) goto L16;
    L21:
        this.f386712p0 = false;
        this.Z = true;
        G3();
        View r101 = P2();
        if (r101 == null) goto L24;
        l4(r101);
    L24:
        va8.c r102 = C3();
        ChatInputInnerView r103 = null;
        if (r102 == null) goto L27;
        View r104 = ((com.larus.bmhome.chat.component.bottom.core.a) r102).F();
    L28:
        if (r104 == null) goto L30;
        l4(r104);
    L30:
        va8.c r105 = C3();
        if (r105 == null) goto L33;
        AppCompatImageView r106 = ((com.larus.bmhome.chat.component.bottom.core.a) r105).t();
    L34:
        if (r106 == null) goto L36;
        r106.setVisibility(8);
    L36:
        va8.c r107 = C3();
        if (r107 == null) goto L39;
        r103 = ((com.larus.bmhome.chat.component.bottom.core.a) r107).H();
    L39:
        if (r103 == null) goto L41;
        r103.setVisibility(4);
    L41:
        TextView r108 = B3();
        if (r108 == null) goto L44;
        r108.setVisibility(0);
    L44:
        e4();
    L45:
        return true;
    L33:
        r106 = null;
        goto L34
    L27:
        r104 = null;
        goto L28
    L16:
        if (r100 != 2) goto L18;
        c4();
        goto L45
    L18:
        if (r100 == 3) goto L21;
        return false;
    L11:
        if (this.f386712p0 == false) goto L14;
        c4();
        return true;
    }

    @Override // ada.c
    public final boolean Ia(int r100) {
        if (W3() == false) goto L7;
        Ep();
        return true;
    L7:
        if (Z3() == true) goto L11;
        return false;
    L11:
        return d4(ContextCompat.getDrawable(getContext(), r100));
    }

    @Override // ada.c
    public final boolean S5(boolean r100) {
        laa.j r101 = D3();
        int r102 = 0;
        if (r101 == null) goto L9;
        b1 r103 = r101.O4();
        if (r103 == null) goto L9;
        if (((Boolean) r103.getValue()).booleanValue() != true) goto L9;
        boolean r104 = true;
    L11:
        if (k4(r104) == false) goto L14;
        H3();
        return true;
    L14:
        if (r104 == false) goto L59;
        i4();
        laa.j r105 = D3();
        if (r105 != null) goto L18;
    L20:
        boolean r106 = false;
    L21:
        g1 r107 = f70();
        if (r107 == null) goto L28;
        b1 r108 = r107.Ry();
        if (r108 == null) goto L28;
        if (((Boolean) r108.getValue()).booleanValue() != true) goto L28;
        boolean r109 = true;
    L29:
        TextView r110 = B3();
        if (r110 == null) goto L32;
        CharSequence r111 = r110.getText();
    L33:
        if (r111 != null) goto L35;
    L38:
        boolean r112 = true;
    L39:
        boolean r113 = !r112;
        if (r106 == false) goto L43;
        if (r113 == true) goto L43;
        boolean r114 = true;
    L44:
        if (r114 == false) goto L47;
        if (r109 == true) goto L47;
        boolean r115 = true;
    L48:
        va8.o r116 = m3();
        if (r116 == null) goto L51;
        r116.k3(r114);
    L51:
        View r117 = N2();
        if (r117 == null) goto L57;
        if (r115 == true) goto L56;
        r102 = 8;
    L56:
        r117.setVisibility(r102);
    L57:
        return true;
    L47:
        r115 = false;
    L43:
        r114 = false;
        goto L44
    L35:
        if (r111.length() == 0) goto L38;
        r112 = false;
        goto L39
    L32:
        r111 = null;
    L28:
        r109 = false;
        goto L29
    L18:
        if (r105.or() != true) goto L20;
        r106 = true;
        goto L21
    L59:
        if (W3() == false) goto L61;
        G3();
        return true;
    L61:
        if (com.obric.assistant.task.skill.f.d() == true) goto L63;
    L65:
        return false;
    L63:
        if (V3() == false) goto L65;
        i4();
        F2();
    L9:
        r104 = false;
        goto L11
    }

    @Override // ada.c
    public final boolean a3(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        if (W3() == false) goto L7;
        Ep();
        return true;
    L7:
        if (Z3() == true) goto L11;
        return false;
    L11:
        return d4(r100);
    }

    public final void a4(String r100) {
        boolean r101 = j4();
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[PhoneOperationAttachmentSend] refresh reason=");
        r103.append(r100);
        r103.append(", forceDisabled=");
        r103.append(r101);
        r103.append(", lastStatus=");
        ICoreInputAbility r104 = h3();
        if (r104 == null) goto L5;
        Integer r105 = Integer.valueOf(r104.Rp());
    L6:
        r103.append(r105);
        r102.i("ConfigCoreInputComponent", r103.toString());
        va8.o r106 = m3();
        if (r106 == null) goto L9;
        r106.Y4(1.0f);
    L9:
        ICoreInputAbility r107 = h3();
        if (r107 == null) goto L12;
        r107.eo();
    L12:
        if (r101 == true) goto L29;
        g1 r108 = f70();
        if (r108 == null) goto L20;
        b1 r109 = r108.Ry();
        if (r109 == null) goto L20;
        if (((Boolean) r109.getValue()).booleanValue() != true) goto L20;
        boolean r110 = true;
    L21:
        if (r110 == false) goto L30;
        va8.o r111 = m3();
        if (r111 == null) goto L31;
        g1 r112 = f70();
        if (r112 == null) goto L27;
        r112.qe();
    L27:
        r111.SB(true);
        return;
    L31:
        return;
    L30:
        return;
    L20:
        r110 = false;
        goto L21
    L29:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // ada.c
    public final void b5(boolean r210) {
        ObricMentionInputController r100 = this.A;
        if (r100 == null) goto L5;
        r100.i();
    L5:
        boolean r101 = true;
        if (r210 == true) goto L8;
    L10:
        boolean r102 = false;
    L11:
        com.larus.bmhome.chat.component.bottom.multimodal.g r103 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f386715s.getValue();
        BotModel r104 = null;
        if (r103 == null) goto L45;
        boolean r105 = r103.Fb();
        if (r102 == true) goto L17;
        Boolean r106 = this.f386701J;
        if (r106 == null) goto L26;
        boolean r107 = r106.booleanValue();
    L27:
        r103.pd(r107);
        Boolean r108 = this.K;
        if (r108 == null) goto L30;
        boolean r109 = r108.booleanValue();
    L31:
        r103.bh(r109);
        this.f386701J = null;
        this.K = null;
    L33:
        if (r105 == r103.Fb()) goto L45;
        f1 r110 = (f1) this.f386703i.getValue();
        if (r110 != null) goto L37;
    L39:
        boolean r111 = false;
    L40:
        if (r111 == false) goto L45;
        ICoreInputAbility r112 = h3();
        if (r112 == null) goto L45;
        r112.C1(false, false, "phone_operation_mode_changed");
        goto L45
    L37:
        if (r110.sL() != true) goto L39;
        r111 = true;
        goto L40
    L30:
        r109 = false;
        goto L31
    L26:
        r107 = false;
        goto L27
    L17:
        if (this.f386701J != null) goto L20;
        this.f386701J = Boolean.valueOf(r103.yz());
    L20:
        if (this.K != null) goto L22;
        this.K = Boolean.valueOf(r103.Fb());
    L22:
        r103.pd(true);
        r103.bh(true);
    L45:
        if (r102 == false) goto L64;
        this.I = true;
        if (W3() == false) goto L49;
        return;
    L49:
        laa.j r113 = D3();
        if (r113 == null) goto L56;
        b1 r114 = r113.O4();
        if (r114 == null) goto L56;
        if (((Boolean) r114.getValue()).booleanValue() != true) goto L56;
    L58:
        if (k4(r101) == false) goto L60;
        H3();
    L132:
        a4("phone_operation_mode_changed");
        return;
    L60:
        i4();
        FLogger.f375446a.i("ConfigCoreInputComponent", "activateInputActionEntrancesForPhoneOperationMode");
        F2();
        ICoreInputAbility r115 = h3();
        if (r115 == null) goto L132;
        r115.zM();
    L56:
        r101 = false;
        goto L58
    L64:
        if (this.I == false) goto L104;
        ObricMentionInputController r116 = this.A;
        if (r116 == null) goto L104;
        paa.c r117 = r116.f386760c;
        if (r117 == null) goto L70;
        List<paa.e> r118 = r117.Nh();
    L71:
        if (r118 != null) goto L73;
        r118 = CollectionsKt.emptyList();
    L73:
        List<paa.e> r119 = r118;
        paa.c r120 = r116.f386760c;
        if (r120 == null) goto L76;
        List<paa.e> r121 = r120.a00();
    L77:
        if (r121 != null) goto L79;
        r121 = CollectionsKt.emptyList();
    L79:
        List r122 = CollectionsKt.plus(r119, r121);
        HashSet r123 = new HashSet();
        ArrayList r124 = new ArrayList();
        Iterator r125 = r122.iterator();
    L81:
        if (r125.hasNext() == false) goto L86;
        Object r126 = r125.next();
        if (r123.add(((paa.e) r126).f528396a) == false) goto L81;
        r124.add(r126);
        goto L81
    L86:
        if (r124.isEmpty() == true) goto L104;
        FLogger.f375446a.i("ObricMentionInputController", "clearMentionsForPhoneOperationModeExit: skillIds=" + CollectionsKt.joinToString$default(r124, null, null, null, 0, null, new com.obric.assistant.chat.component.bottom.core.mention.a(), 31, null));
        r116.b();
        Iterator r127 = r124.iterator();
    L90:
        if (r127.hasNext() == false) goto L100;
        paa.e r128 = (paa.e) r127.next();
    L92:
        ObricMentionHighlightHelper.a r129 = r116.f386765h;
        if (r129 != null) goto L95;
    L97:
        boolean r130 = false;
    L98:
        if (r130 == true) goto L92;
    L95:
        if (r129.n(r128) != true) goto L97;
        r130 = true;
        goto L98
    L100:
        paa.c r131 = r116.f386760c;
        if (r131 == null) goto L103;
        r131.CZ();
    L103:
        r116.g();
        r116.h();
        goto L104
    L76:
        r121 = null;
        goto L77
    L70:
        r118 = null;
    L104:
        this.I = false;
        i4();
        FLogger r132 = FLogger.f375446a;
        r132.i("ConfigCoreInputComponent", "restoreInputActionEntrancesAfterPhoneOperationMode");
        laa.j r133 = D3();
        if (r133 == null) goto L111;
        b1 r134 = r133.O4();
        if (r134 == null) goto L111;
        if (((Boolean) r134.getValue()).booleanValue() != true) goto L111;
        boolean r135 = true;
    L112:
        if (r135 == false) goto L114;
        r132.i("ConfigCoreInputComponent", "restoreInputActionEntrancesAfterPhoneOperationMode skip, special input is open");
        goto L132
    L114:
        h4(false);
        ICoreInputAbility r136 = h3();
        if (r136 == null) goto L118;
        r136.uq(true);
    L118:
        if (W3() == false) goto L120;
        G3();
        goto L132
    L120:
        ICoreInputAbility r137 = h3();
        if (r137 == null) goto L126;
        EditPos r138 = new EditPos(0);
        y r139 = (y) this.f386705k.getValue();
        if (r139 == null) goto L125;
        r104 = r139.j0();
    L125:
        r137.eQ(r138, r104);
    L126:
        ICoreInputAbility r140 = h3();
        if (r140 == null) goto L129;
        r140.rE();
    L129:
        ICoreInputAbility r141 = h3();
        if (r141 == null) goto L132;
        r141.zM();
    L111:
        r135 = false;
        goto L112
    L8:
        if (V3() == false) goto L10;
        r102 = true;
        goto L11
    }

    public final boolean d4(Drawable r100) {
        if (s1a.a.e(this) == false) goto L8;
        FLogger.f375446a.i("ConfigCoreInputComponent", "is window host user inputAreaContainerBg");
        ViewGroup r101 = p3();
        if (r101 == null) goto L7;
        r101.setBackground(new ColorDrawable(0));
    L7:
        return true;
    L8:
        if (r100 != null) goto L10;
        return false;
    L10:
        Context r102 = getContext();
        laa.d r103 = Y2();
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L18;
        int r105 = R.color.obric_action_bar_input_bg_color_chat_window;
    L19:
        int r106 = ContextCompat.getColor(r102, r105);
        FLogger.f375446a.i("ConfigCoreInputComponent", "replaceInputBgDrawable: drawable = " + r100 + ", isWindowHost = " + s1a.a.e(this));
        if ((r100 instanceof GradientDrawable) == false) goto L25;
        ((GradientDrawable) r100).setColor(r106);
        ViewGroup r107 = p3();
        if (r107 == null) goto L24;
        r107.setBackground(r100);
    L24:
        return true;
    L25:
        return false;
    L18:
        r105 = R.color.obric_action_bar_input_bg_color;
        goto L19
    L13:
        if (r103.aF() != true) goto L15;
        r104 = true;
        goto L16
    }

    public final void h4(boolean r100) {
        if (this.L == true) goto L9;
        ada.d r101 = (ada.d) this.f386716t.getValue();
        if (r101 == null) goto L41;
        r101.Iy();
        return;
    L41:
        return;
    L9:
        if (r100 == true) goto L20;
        laa.j r102 = D3();
        if (r102 == null) goto L17;
        b1 r103 = r102.O4();
        if (r103 == null) goto L17;
        boolean r104 = true;
        if (((Boolean) r103.getValue()).booleanValue() != true) goto L17;
    L18:
        if (r104 == false) goto L20;
        return;
    L17:
        r104 = false;
    L20:
        ICoreInputAbility r105 = h3();
        if (r105 == null) goto L23;
        CoreInputAbility r106 = r105.JO();
    L24:
        if (r105 == null) goto L28;
        z8.a r107 = r105.Jd();
        if (r107 == null) goto L28;
        z8.c r108 = r107.f299539h;
    L30:
        if (r108 != this.N) goto L37;
        if (r106 == null) goto L33;
        r106.W8(this.M);
    L33:
        if (r106 == null) goto L35;
        r106.S8(this.O);
    L35:
        if (r105 == null) goto L37;
        r105.s20(0);
    L37:
        this.M = null;
        this.N = null;
        this.O = false;
        this.L = false;
        ada.d r109 = (ada.d) this.f386716t.getValue();
        if (r109 == null) goto L42;
        r109.Iy();
        return;
    L42:
        return;
    L28:
        r108 = null;
        goto L30
    L23:
        r106 = null;
        goto L24
    }

    @Override // ada.b
    public final void h90(int r100) {
        final ObricMentionInputController r101 = this.A;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 != 1) goto L7;
    L15:
        r101.f386759b.post(new com.obric.assistant.chat.component.bottom.core.mention.d(r101));
        return;
    L7:
        if (r100 != 2) goto L9;
        paa.c r102 = r101.f386760c;
        if (r102 == null) goto L14;
        r102.CZ();
    L14:
        r101.g();
        r101.h();
        return;
    L9:
        if (r100 == 3) goto L15;
    }

    public final boolean k4(boolean r100) {
        if (r100 == false) goto L11;
        if (s1a.a.e(this) == false) goto L7;
    L8:
        return true;
    L7:
        if (t1.f393353a.o1() == false) goto L8;
        return false;
    L11:
        if (com.obric.assistant.task.skill.f.d() == true) goto L13;
    L15:
        boolean r101 = false;
    L16:
        if (r101 == true) goto L18;
        return false;
    L18:
        if (s1a.a.e(this) == false) goto L20;
    L21:
        return true;
    L20:
        if (t1.f393353a.r() == false) goto L21;
        return false;
    L13:
        if (V3() == false) goto L15;
        r101 = true;
        goto L16
    }

    public final void p4(int r110) {
        boolean r100 = false;
        int r101 = RangesKt.coerceAtLeast(r110 - 56, 0);
        f1 r102 = (f1) this.f386703i.getValue();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        int r104 = this.F;
        if (r104 <= 0) goto L11;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        int r106 = this.G;
    L20:
        if (this.H == false) goto L22;
        int r107 = Math.max(r104, r106);
    L23:
        if (r105 == true) goto L25;
    L27:
        Integer r108 = null;
        if (r100 == false) goto L36;
        NestedScrollingChild r109 = (RecyclerView) this.B.getValue();
        if ((r109 instanceof b0) == false) goto L32;
        b0 r111 = (b0) r109;
    L33:
        if (r111 == null) goto L36;
        r111.setBottomReached(true);
        b0.a.a(r111, false, 0, null, null, 0, 30);
        goto L36
    L32:
        r111 = null;
    L36:
        FrameLayout r112 = (FrameLayout) this.C.getValue();
        if (r112 == null) goto L39;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
    L41:
        if ((r113 instanceof ViewGroup.MarginLayoutParams) == false) goto L43;
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
    L44:
        if (r114 == null) goto L46;
        r108 = Integer.valueOf(r114.bottomMargin);
    L46:
        if (r108 != null) goto L49;
    L51:
        FLogger.f375446a.i("ConfigCoreInputComponent", "updateMessageListBottomMargin, targetBottomMargin: " + r107 + ", bottomLayoutMargin: " + r110 + ", bottomMenuHeight: " + this.F + ", currentImeExtraBottomMargin: " + this.G + ", isFromBottomMenuToIme: " + r105 + ", shouldScrollToLatest: " + r100);
        FrameLayout r115 = (FrameLayout) this.C.getValue();
        if (r115 == null) goto L58;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L57;
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        r117.bottomMargin = r107;
        r115.setLayoutParams(r117);
        return;
    L57:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L58:
        return;
    L49:
        if (r108.intValue() != r107) goto L51;
        return;
    L43:
        r114 = null;
        goto L44
    L39:
        r113 = null;
        goto L41
    L25:
        if (Q3((RecyclerView) this.B.getValue()) == false) goto L27;
        r100 = true;
        goto L27
    L22:
        r107 = Math.max(r101, Math.max(r104, r106));
        goto L23
    L18:
        r106 = 0;
        goto L20
    L11:
        if (this.H == true) goto L15;
        if (r103 == true) goto L15;
        r105 = false;
        goto L16
    L5:
        if (r102.sL() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // hca.b
    public final void r2(boolean r100) {
        if (m3() != null) goto L5;
        FLogger.f375446a.w("ConfigCoreInputComponent", "changeInputUi: not found coreInputUIAbility");
    L87:
        if (s1a.a.e(this) == true) goto L89;
        return;
    L89:
        if (s1a.a.d(this) == false) goto L91;
        eia.v r101 = (dia.b) this.Y.getValue();
    L92:
        r101.a();
        if (W3() == false) goto L97;
        G3();
        return;
    L97:
        return;
    L91:
        r101 = (dia.f) this.X.getValue();
        goto L92
    L5:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("changeInputUi: isChatWindow = ");
        r103.append(r100);
        r103.append(", inputAboveLayout?.measuredHeight = ");
        va8.c r104 = C3();
        GradientDrawable r105 = null;
        if (r104 == null) goto L8;
        ViewGroup r106 = ((com.larus.bmhome.chat.component.bottom.core.a) r104).p();
    L9:
        if (r106 == null) goto L11;
        Integer r107 = Integer.valueOf(r106.getMeasuredHeight());
    L12:
        r103.append(r107);
        r103.append(", isWindowHost = ");
        r103.append(s1a.a.e(this));
        r102.i("ConfigCoreInputComponent", r103.toString());
        if (s1a.a.e(this) == true) goto L23;
        va8.o r108 = m3();
        if (r108 == null) goto L23;
        if (r100 == false) goto L18;
    L21:
        int r109 = R.drawable.obric_bg_obric_input_area;
    L22:
        r108.fq(r109);
        goto L23
    L18:
        if ((z3() instanceof ShadowLayout) == true) goto L21;
        r109 = R.drawable.larus_chat_common_shadow_bg;
    L23:
        int r110 = i5.h();
        if (s1a.a.e(this) == false) goto L26;
        int r111 = 0;
    L32:
        if ((z3() instanceof ShadowLayout) == true) goto L36;
        va8.o r112 = m3();
        if (r112 == null) goto L36;
        r112.AK(r110, r110, r110, r110);
    L36:
        float r113 = c7.a(R.dimen.dp_16);
        va8.c r114 = C3();
        if (r114 == null) goto L39;
        ViewGroup r115 = ((com.larus.bmhome.chat.component.bottom.core.a) r114).p();
    L41:
        if (r115 != null) goto L43;
    L45:
        boolean r116 = false;
    L46:
        if (r116 == false) goto L48;
        float r117 = r113;
    L49:
        float[] r118 = {r117, r117, r117, r117, r113, r113, r113, r113};
        va8.o r119 = m3();
        if (r119 == null) goto L52;
        GradientDrawable r120 = new GradientDrawable();
        r120.setCornerRadii(r118);
        r120.setColor(r111);
        r119.l70(r120, r111);
    L52:
        va8.c r121 = C3();
        if (r121 == null) goto L55;
        ResourceBar r122 = ((com.larus.bmhome.chat.component.bottom.core.a) r121).x();
    L56:
        if (r122 == null) goto L58;
        Drawable r123 = r122.getBackground();
    L60:
        if ((r123 instanceof GradientDrawable) == false) goto L62;
        GradientDrawable r124 = (GradientDrawable) r123;
    L63:
        if (r124 == null) goto L65;
        r124.setColor(r111);
    L65:
        View r125 = E3();
        if (r125 == null) goto L68;
        Drawable r126 = r125.getBackground();
    L70:
        if ((r126 instanceof ColorDrawable) == false) goto L72;
        ColorDrawable r127 = (ColorDrawable) r126;
    L73:
        if (r127 == null) goto L77;
        View r128 = E3();
        if (r128 == null) goto L77;
        Drawable r129 = r127.mutate();
        r127.setColor(r111);
        r128.setBackground(r129);
    L77:
        ViewGroup r130 = (ViewGroup) this.f386722z.getValue();
        if (r130 == null) goto L80;
        Drawable r131 = r130.getBackground();
    L82:
        if ((r131 instanceof GradientDrawable) == false) goto L84;
        r105 = (GradientDrawable) r131;
    L84:
        if (r105 == null) goto L87;
        r105.setColor(r111);
        goto L87
    L80:
        r131 = null;
        goto L82
    L72:
        r127 = null;
        goto L73
    L68:
        r126 = null;
        goto L70
    L62:
        r124 = null;
        goto L63
    L58:
        r123 = null;
        goto L60
    L55:
        r122 = null;
        goto L56
    L48:
        r117 = 0.0f;
        goto L49
    L43:
        if (r115.getMeasuredHeight() != 0) goto L45;
        r116 = true;
        goto L46
    L39:
        r115 = null;
        goto L41
    L26:
        Context r132 = getContext();
        if (r100 == false) goto L29;
        int r133 = R.color.obric_action_bar_input_bg_color_chat_window;
    L30:
        r111 = ContextCompat.getColor(r132, r133);
        goto L32
    L29:
        r133 = R.color.obric_action_bar_input_bg_color;
        goto L30
    L11:
        r107 = null;
        goto L12
    L8:
        r106 = null;
        goto L9
    }

    @Override // hca.b
    public final void x1(ObricFloatChatPageState r100) {
        Intrinsics.checkNotNullParameter(r100, "pageState");
    }

    @Override // ada.b
    public final CharSequence x9(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        ObricMentionInputController r101 = this.A;
        List<paa.e> r102 = null;
        if (r101 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "text");
        paa.c r103 = r101.f386760c;
        if (r103 == null) goto L7;
        r102 = r103.Zm();
    L7:
        if (r102 != null) goto L10;
        r102 = CollectionsKt.emptyList();
    L10:
        return r101.c(r100, r102, true);
    L11:
        return null;
    }

    @Override // ada.c
    public final void NE(int r100, int r101) {
        if (s1a.a.e(this) == true) goto L5;
        return;
    L5:
        int r102 = 0;
        if (r101 <= 0) goto L8;
        int r103 = RangesKt.coerceIn(r100, 0, r101);
    L9:
        int r104 = this.F;
        if (r104 != r103) goto L12;
        return;
    L12:
        ViewGroup.MarginLayoutParams r105 = null;
        if (r104 > 0) goto L26;
        if (r103 <= 0) goto L26;
        int r106 = this.G;
        FrameLayout r107 = X2();
        if (r107 == null) goto L24;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
    L21:
        if (r109 == null) goto L23;
        int r110 = r109.bottomMargin;
    L25:
        this.G = Math.max(r106, RangesKt.coerceAtLeast(r110 - 56, 0));
        goto L26
    L23:
        r110 = 0;
        goto L25
    L20:
        r109 = null;
        goto L21
    L24:
        r110 = 56;
    L26:
        this.F = r103;
        FrameLayout r111 = X2();
        if (r111 == null) goto L33;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L31;
        r105 = (ViewGroup.MarginLayoutParams) r112;
    L31:
        if (r105 == null) goto L33;
        r102 = r105.bottomMargin;
    L33:
        p4(r102);
        return;
    L8:
        r103 = RangesKt.coerceAtLeast(r100, 0);
        goto L9
    }

    @Override // ada.b
    public final void g2(int r100, boolean r101) {
        ICoreInputAbility r102 = h3();
        if (r102 == null) goto L5;
        r102.g2(3, r101);
    L5:
        a4(EventConstants.ExtraJson.SWITCH_STATUS);
    }

    @Override // ada.c
    public final boolean p5(float r100, int r101) {
        if (W3() == false) goto L7;
        Ep();
        return true;
    L7:
        if (Z3() == true) goto L9;
        return false;
    L9:
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setCornerRadius(c7.a(R.dimen.dp_16));
        r102.setColor(ContextCompat.getColor(getContext(), R.color.obric_action_bar_input_bg_color));
        return d4(r102);
    }

    @Override // ada.b
    public final Boolean s0(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "cvsID");
        if (HomeService.f344094a.H(AppHost.f326268a.getApplication()) == null) goto L7;
        IShortcutPlatformService r103 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);
        if (r103 == null) goto L11;
        r103.s0(r100, r101, r102);
    L11:
        return Boolean.TRUE;
    L7:
        IShortcutPlatformService r104 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);
        if (r104 == null) goto L11;
        r104.d();
        goto L11
    }
}
