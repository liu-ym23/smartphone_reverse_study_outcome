package com.ss.android.lark.forseti.chain;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.api.api.ForsetiBaseChainFragment;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.global.ForsetiActivityChainManager;
import com.ss.android.lark.forseti.global.ForsetiAttachInfo;
import com.ss.android.lark.forseti.node.ForsetiFragmentDisplayControllerImpl;
import com.ss.android.lark.forseti.node.ForsetiNode;
import com.ss.android.lark.forseti.node.piece.FragmentLifecycleObserver;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingLayout;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroupCompat;
import com.ss.android.lark.forsetiutils.BizType;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ß\u00012\u00020\u0001:\u0006ß\u0001à\u0001á\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010d\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010e\u001a\u0002052\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J$\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010\u000b2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\u001a\u0010l\u001a\u0002052\u0006\u0010m\u001a\u00020\u000e2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\b\u0010n\u001a\u000205H\u0002J\u0010\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0-H\u0002J\b\u0010p\u001a\u000205H\u0002J\b\u0010q\u001a\u000205H\u0002J\b\u0010r\u001a\u000205H\u0002J\u000e\u0010s\u001a\u0002052\u0006\u0010;\u001a\u00020<J\u0006\u0010t\u001a\u00020#J\u0006\u0010u\u001a\u00020#J\b\u0010v\u001a\u000205H\u0002J\u0010\u0010w\u001a\u0002052\u0006\u0010x\u001a\u00020\u0014H\u0002J\b\u0010y\u001a\u000205H\u0016J\u0006\u0010z\u001a\u00020#JY\u0010{\u001a\u0002052\u0006\u0010|\u001a\u00020b2\u0006\u0010}\u001a\u00020\u00142\n\b\u0002\u0010~\u001a\u0004\u0018\u00010b2\b\b\u0002\u0010\u007f\u001a\u00020#2\t\b\u0002\u0010\u0080\u0001\u001a\u00020#2\t\b\u0002\u0010\u0081\u0001\u001a\u00020#2\f\b\u0002\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020>J\u000f\u0010\u0085\u0001\u001a\u0002052\u0006\u0010|\u001a\u00020bJ\u000f\u0010\u0086\u0001\u001a\u00020c2\u0006\u0010|\u001a\u00020bJ\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010/2\u0006\u0010|\u001a\u00020bJ\u0007\u0010\u0088\u0001\u001a\u000205J\u000f\u0010\u0089\u0001\u001a\u0002052\u0006\u0010P\u001a\u00020OJ\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010bJ\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010bJ\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010/J\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010/J\u0011\u0010\u008e\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0011\u0010\u0092\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u000205J\u0011\u0010\u0095\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0096\u0001J\u0007\u0010\u0097\u0001\u001a\u000205J\u0011\u0010\u0098\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0099\u0001J\u0011\u0010\u009a\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0099\u0001J\u0007\u0010\u009b\u0001\u001a\u000205J\u0011\u0010\u009c\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u009d\u0001J\u0011\u0010\u009e\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u009d\u0001J\u0007\u0010\u009f\u0001\u001a\u000205J\u0011\u0010 \u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030¡\u0001J\u0011\u0010¢\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030¡\u0001J\u0007\u0010£\u0001\u001a\u000205J\u0011\u0010¤\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030¥\u0001J\u0011\u0010¦\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030¥\u0001J\u0007\u0010§\u0001\u001a\u000205J\u000f\u0010¨\u0001\u001a\u0004\u0018\u000103¢\u0006\u0003\u0010©\u0001J\u000f\u0010ª\u0001\u001a\u0004\u0018\u000103¢\u0006\u0003\u0010©\u0001J\u000f\u0010«\u0001\u001a\u0004\u0018\u000103¢\u0006\u0003\u0010©\u0001J\u001a\u0010¬\u0001\u001a\u0002052\u0006\u0010x\u001a\u00020\u00142\u0007\u0010\u00ad\u0001\u001a\u000208H\u0002J\u0011\u0010®\u0001\u001a\u00020#2\u0006\u0010x\u001a\u00020\u0014H\u0002J@\u0010¯\u0001\u001a\u00020527\u0010\u008f\u0001\u001a2\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002050.J@\u0010°\u0001\u001a\u00020527\u0010\u008f\u0001\u001a2\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002050.J\u0007\u0010±\u0001\u001a\u000205J\u0011\u0010²\u0001\u001a\u0004\u0018\u00010b2\u0006\u0010}\u001a\u00020\u0014J\u001b\u0010³\u0001\u001a\u0002052\t\u0010´\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010µ\u0001\u001a\u00020#J\u0019\u0010¶\u0001\u001a\u0002052\u0007\u0010·\u0001\u001a\u00020b2\u0007\u0010µ\u0001\u001a\u00020#J\u000f\u0010¸\u0001\u001a\u0002032\u0006\u0010|\u001a\u00020bJ\u0017\u0010¹\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010|\u001a\u00020b¢\u0006\u0003\u0010º\u0001J\u001e\u0010»\u0001\u001a\u0002052\u0006\u0010|\u001a\u00020b2\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u0002050ZJ\t\u0010½\u0001\u001a\u0004\u0018\u00010\u0005J\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0012J\n\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001J\u0013\u0010Á\u0001\u001a\u0002052\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\t\u0010Â\u0001\u001a\u000205H\u0016J\t\u0010Ã\u0001\u001a\u000205H\u0016J\t\u0010Ä\u0001\u001a\u000205H\u0016J\t\u0010Å\u0001\u001a\u000205H\u0016J\u0012\u0010Æ\u0001\u001a\u0002052\u0007\u0010Ç\u0001\u001a\u00020gH\u0016J\t\u0010È\u0001\u001a\u000205H\u0016J\t\u0010É\u0001\u001a\u000205H\u0002J\t\u0010Ê\u0001\u001a\u000205H\u0016J\u0016\u0010Ë\u0001\u001a\u0002052\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u0002050ZJ\u0018\u0010Ì\u0001\u001a\u0002052\u000f\u0010Í\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010ZJ\u0012\u0010Î\u0001\u001a\u0002052\t\b\u0002\u0010Ï\u0001\u001a\u00020#J\u0012\u0010Ð\u0001\u001a\u0002052\t\b\u0002\u0010Ï\u0001\u001a\u00020#J\u0010\u0010Ñ\u0001\u001a\u0002052\u0007\u0010Ò\u0001\u001a\u000203J\b\u0010Ó\u0001\u001a\u00030Ô\u0001J\u001c\u0010Õ\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030Ö\u00012\t\b\u0002\u0010×\u0001\u001a\u00020#J\u0011\u0010Ø\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030Ö\u0001J\u0010\u0010Ù\u0001\u001a\u0002052\u0007\u0010Ú\u0001\u001a\u00020#J\u0010\u0010Û\u0001\u001a\u0002052\u0007\u0010Ü\u0001\u001a\u000203J\u0010\u0010Ý\u0001\u001a\u0002052\u0007\u0010Þ\u0001\u001a\u00020#R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+RD\u0010,\u001a8\u00124\u00122\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002050.0-X\u0082\u0004¢\u0006\u0002\n\u0000R \u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002080-07X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\b@\u0010AR\u001b\u0010C\u001a\u00020D8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\t\u001a\u0004\bE\u0010FR\u001b\u0010H\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010JR\u001e\u0010P\u001a\u00020O2\u0006\u0010N\u001a\u00020O@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u0002050ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020c07X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006â\u0001"}, d2 = {"Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment;", "Lcom/ss/android/lark/api/api/ForsetiBaseChainFragment;", "<init>", "()V", "draggingHelper", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "getDraggingHelper", "()Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "draggingHelper$delegate", "Lkotlin/Lazy;", "chainViewGroup", "Landroid/view/ViewGroup;", "parentViewGroup", "draggingLayout", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "chainHelper", "Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;", "keyChainHelperPendingAction", "", "keyForsetiNormalChainDraggingLayout", "keyChainAdapter", "attachInfo", "Lcom/ss/android/lark/forseti/global/ForsetiAttachInfo;", "getAttachInfo", "()Lcom/ss/android/lark/forseti/global/ForsetiAttachInfo;", "attachInfo$delegate", "chainContainerClickListener", "Landroid/view/View$OnClickListener;", "getChainContainerClickListener", "()Landroid/view/View$OnClickListener;", "setChainContainerClickListener", "(Landroid/view/View$OnClickListener;)V", "provideDraggingSupport", "", "triggerAnimation", "Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment$ITriggerAnimation;", "rightForsetiNodeWith", "Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment$IRightForsetiNodeWith;", "getRightForsetiNodeWith", "()Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment$IRightForsetiNodeWith;", "setRightForsetiNodeWith", "(Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment$IRightForsetiNodeWith;)V", "nodeRemovedListeners", "", "Lkotlin/Function2;", "Lcom/ss/android/lark/forseti/node/ForsetiNode;", "Lkotlin/ParameterName;", "name", "removed", "", "count", "", "pendingActionsMap", "", "Ljava/lang/Runnable;", "forsetiStructureNotifier", "Lcom/ss/android/lark/forseti/global/ForsetiActivityChainManager$ForsetiStructureNotifier;", "forsetiChainConfig", "Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "forsetiInnerOptions", "Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "multiStackDisableFG", "getMultiStackDisableFG", "()Z", "multiStackDisableFG$delegate", "chainType", "Lcom/ss/android/lark/api/bean/ForsetiChainType;", "getChainType", "()Lcom/ss/android/lark/api/bean/ForsetiChainType;", "chainType$delegate", "chainConfig", "getChainConfig", "()Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "chainConfig$delegate", "latestChainConfig", "getLatestChainConfig", "value", "Lcom/ss/android/lark/forseti/chain/ForsetiChainState;", "state", "getState", "()Lcom/ss/android/lark/forseti/chain/ForsetiChainState;", "chainAdapter", "Lcom/ss/android/lark/forseti/chain/IForsetiChainAdapter;", "getChainAdapter", "()Lcom/ss/android/lark/forseti/chain/IForsetiChainAdapter;", "setChainAdapter", "(Lcom/ss/android/lark/forseti/chain/IForsetiChainAdapter;)V", "closeHandler", "Lkotlin/Function0;", "status", "Lcom/ss/android/lark/forseti/chain/ForsetiStackChainStatus;", "getStatus", "()Lcom/ss/android/lark/forseti/chain/ForsetiStackChainStatus;", "setStatus", "(Lcom/ss/android/lark/forseti/chain/ForsetiStackChainStatus;)V", "fragmentDisplayControllerCache", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/api/api/IForsetiFragmentDisplayController;", "onAttach", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "onViewCreated", "view", "initListeners", "findAllViews", "setupDraggingHelper", "setupChainHelper", "setupForsetiChainConfig", "refreshForsetiChainConfig", "isDraggingSupport", "popNodeExcludeHead", "afterChainHelperInit", "executePendingActions", "key", "onDestroyView", "dispatchBackPressedEvent", "addForsetiFragment", "f", "tag", "anchorFragment", "openNextNode", "half", "isNextNodeFull", "fragmentLifecycleCallbacks", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "options", "removeForsetiFragment", "getFragmentDisplayController", "findForsetiNode", "switchCModeCompact", "changeState", "findHeadFragment", "findTailFragment", "findTailForsetiNode", "findFirstForsetiNode", "addFirstNodeLayoutChangeListener", "listener", "Landroid/view/View$OnLayoutChangeListener;", "removeFirstNodeLayoutChangeListener", "addUpdateScaleFactor", "Lcom/ss/android/lark/api/ui/IForsetiNodeScaleListener;", "removeUpdateScaleFactor", "addNodeShowOverlayListener", "Lcom/ss/android/lark/api/ui/IForsetiNodeShowOverlayListener;", "removeNodeShowOverlayListener", "addForsetiNodeWidthChangeListener", "Lcom/ss/android/lark/api/ui/IForsetiNodeWidthListener;", "removeForsetiNodeWidthChangeListener", "removeForsetiNodeWidthChangeListeners", "addLastNodeLeftChangeListener", "Lcom/ss/android/lark/api/ui/IForsetiNodeLeftChangeListener;", "removeLastNodeLeftChangeListener", "removeLastNodeLeftChangeListeners", "addNavigationModeChangedListener", "Lcom/ss/android/lark/api/ui/IForsetiNavigationModeChangedListener;", "removeNavigationModeChangedListener", "removeNavigationModeChangedListeners", "addSplitRatioChangedListener", "Lcom/ss/android/lark/api/ui/IForsetiSplitRatioChangedListener;", "removeSplitRatioChangedListener", "removeSplitRatioChangedListeners", "getFirstNodeWidth", "()Ljava/lang/Integer;", "getContainerWidth", "getContainerHeight", "executeOrPendingAction", "runnable", "checkPropertyInitialized", "addForsetiNodeRemovedListener", "removeForsetiNodeRemovedListener", "removeForsetiNodeRemovedListeners", "findFragmentByTag", "clearAllForsetiNodesAfter", "anchorNode", "inclusive", "clearAllBizFragmentAfter", "bizFragment", "findIndex", "isTailNode", "(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;", "tailNodeHandler", "handler", "getForsetiColumnsDraggingHelper", "getForsetiChainHelper", "getDraggingView", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView;", "onViewStateRestored", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", "onSaveInstanceState", "outState", LiveCommonConstants.REASON_ON_DEDTROY, "clear", "onDetach", "setCloseHandler", "setClickInterceptor", "interceptor", "setSwipeToDismissDisabled", "disabled", "setSwipeToDismissDisabledV2", "setPeekHeight", "peekHeightInPx", "getCurrentPageViewType", "Lcom/ss/android/lark/api/bean/ForsetiPageViewType;", "addPageViewTypeChangeListener", "Lcom/ss/android/lark/api/ui/IForsetiPageViewTypeListener;", "isSticky", "removePageViewTypeChangeListener", "skipCollapsed", "skip", "updateStyle", "style", "setMaskVisible", "visible", "Companion", "ITriggerAnimation", "IRightForsetiNodeWith", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiChainFragment extends ForsetiBaseChainFragment {
    public static final /* synthetic */ int E = 0;
    public s A;
    public Function0<Unit> B;
    public ForsetiStackChainStatus C;
    public final Map<Fragment, tua.c> D;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f424306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f424307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f424308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f424309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Context f424310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ForsetiChainHelper f424311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f424312k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f424313l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f424314m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f424315n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f424316o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f424317p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f424318q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<Function2<ForsetiNode, Integer, Unit>> f424319r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, List<Runnable>> f424320s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ForsetiActivityChainManager.b f424321t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public com.ss.android.lark.api.bean.config.a f424322u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public uua.a f424323v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f424324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f424325x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f424326y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ForsetiChainState f424327z;

    public static final class a {
    }

    public interface b {
        void a(ForsetiWidth r100, ForsetiWidth r101);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForsetiChainFragment f424340a;

        public c(ForsetiChainFragment r100) {
            this.f424340a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ForsetiChainHelper r100 = this.f424340a.f424311j;     // Catch: Throwable -> L7
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("chainHelper");     // Catch: Throwable -> L7
            r100 = null;
        L5:
            r100.b();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.api.api.ForsetiBaseChainFragment
    public final ForsetiChainType S90() {
        return (ForsetiChainType) this.f424325x.getValue();
    }

    public final boolean W90() {
        if (V90(this.f424312k) == true) goto L6;
        Log.w("Forseti_ChainFragment", "chainHelper is not initialized, enqueuing back press handling.");
        X90(this.f424312k, new c(this));
        return true;
    L6:
        ForsetiChainHelper r100 = this.f424311j;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r100 = null;
    L10:
        return r100.b();
    }

    public final ForsetiNode aa0() {
        ForsetiChainHelper r100 = this.f424311j;
        if (r100 == null) goto L8;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r100 = null;
    L7:
        return r100.f424352i;
    L8:
        return null;
    }

    public final Fragment ba0() {
        ForsetiChainHelper r100 = null;
        if (V90(this.f424312k) == false) goto L10;
        ForsetiChainHelper r101 = this.f424311j;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L9:
        return (Fragment) CollectionsKt.lastOrNull(r100.f424352i.f424503i);
    L7:
        r100 = r101;
        goto L9
    L10:
        return null;
    }

    public final s ca0() {
        s r100 = this.A;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chainAdapter");
        return null;
    }

    public final ForsetiColumnsDraggingHelper da0() {
        return (ForsetiColumnsDraggingHelper) this.f424306e.getValue();
    }

    public ForsetiChainFragment() {
        this.f424306e = LazyKt.lazy(new ForsetiChainFragment$draggingHelper$2(this));
        this.f424312k = "chainHelper";
        this.f424313l = "forsetiNormalChainDraggingLayout";
        this.f424314m = "chainAdapter";
        this.f424315n = LazyKt.lazy(new ForsetiChainFragment$attachInfo$2(this));
        this.f424319r = new ArrayList();
        this.f424320s = new ConcurrentHashMap();
        this.f424324w = LazyKt.lazy(ForsetiChainFragment$multiStackDisableFG$2.INSTANCE);
        this.f424325x = LazyKt.lazy(new ForsetiChainFragment$chainType$2(this));
        this.f424326y = LazyKt.lazy(new ForsetiChainFragment$chainConfig$2(this));
        this.f424327z = ForsetiChainState.STOPPED;
        this.B = ForsetiChainFragment$closeHandler$1.INSTANCE;
        this.C = ForsetiStackChainStatus.NORMAL;
        this.D = new LinkedHashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Log.i("Forseti_ChainFragment", LiveCommonConstants.REASON_ON_DEDTROY);
        ((ConcurrentHashMap) this.f424320s).clear();
        ((ArrayList) this.f424319r).clear();
        this.f424316o = null;
        this.f424317p = null;
        this.f424318q = null;
        View r100 = this.f424309h;
        boolean r101 = r100 instanceof ForsetiNormalChainDraggingLayout;
        if (r101 == false) goto L5;
        ForsetiNormalChainDraggingLayout r102 = (ForsetiNormalChainDraggingLayout) r100;
    L5:
        if (r101 == false) goto L7;
        ForsetiNormalChainDraggingLayout r103 = (ForsetiNormalChainDraggingLayout) r100;
    L7:
        ForsetiColumnsDraggingHelper r104 = da0();
        r104.B.reset();
        r104.C.reset();
        r104.D.reset();
        r104.E.reset();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Log.i("Forseti_ChainFragment", "onDestroyView");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        Log.i("Forseti_ChainFragment", "onDetach");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Log.i("Forseti_ChainFragment", "onPause");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Log.i("Forseti_ChainFragment", "onResume");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Log.i("Forseti_ChainFragment", WidgetCostModule.TYPE_ON_START);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        Log.i("Forseti_ChainFragment", "onStop");
    }

    public final void U90(ForsetiChainState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f424327z != r100) goto L5;
        return;
    L5:
        this.f424327z = r100;
        if (this.f424307f == null) goto L23;
        ViewGroup r101 = this.f424308g;
        ForsetiNormalChainViewGroupCompat r102 = null;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r101 = null;
    L11:
        if ((r101 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L13;
        r102 = (ForsetiNormalChainViewGroupCompat) r101;
    L13:
        if (r102 == null) goto L24;
        Lazy r103 = ForsetiFGHelpers.f424763a;
        if (ForsetiFGHelpers.c(BizType.IM, "opt_nav_width") == false) goto L17;
        Intrinsics.checkNotNullParameter(r100, "state");
        r102.f424660d = r100;
    L17:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getValue() != ForsetiChainState.RESUMED.getValue()) goto L20;
        boolean r104 = true;
    L21:
        r102.f424659c = r104;
        r102.requestLayout();
        return;
    L20:
        r104 = false;
        goto L21
    L24:
        return;
    }

    public final boolean V90(String r100) {
        if (Intrinsics.areEqual(r100, this.f424312k) == false) goto L9;
        if (this.f424311j != null) goto L19;
    L7:
        return false;
    L19:
        return true;
    L9:
        if (Intrinsics.areEqual(r100, this.f424313l) == false) goto L14;
        if (this.f424311j == null) goto L7;
        return true;
    L14:
        if (Intrinsics.areEqual(r100, this.f424314m) == false) goto L7;
        if (this.A == null) goto L7;
        return true;
    }

    public final ForsetiNode Y90(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "f");
        ForsetiChainHelper r101 = null;
        if (V90(this.f424312k) == false) goto L10;
        ForsetiChainHelper r102 = this.f424311j;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L9:
        return r101.c(r100);
    L7:
        r101 = r102;
        goto L9
    L10:
        return null;
    }

    public final Fragment Z90(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ForsetiChainHelper r101 = this.f424311j;
        Fragment r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r101 = null;
    L5:
        r101.getClass();
        Function1<ForsetiNode, Fragment> r103 = new ForsetiChainHelper$findFragmentByTag$1(r100);
        Intrinsics.checkNotNullParameter(r103, "action");
        ForsetiNode r104 = r101.f424350g.f424499e;
    L6:
        if (r104 == null) goto L12;
        if (r103.invoke(r104) != null) goto L9;
        r104 = r104.f424499e;
        goto L6
    L9:
        r102 = r103.invoke(r104);
    L12:
        return r102;
    }

    public final tua.c ea0(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "f");
        int r101 = fib.a.f477428a;
        ForsetiChainHelper r102 = null;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.notification_not_use_object.disabled") == true) goto L16;
        tua.c r103 = (tua.c) ((LinkedHashMap) this.D).get(r100);
        if (r103 == null) goto L7;
        return r103;
    L7:
        ForsetiChainHelper r104 = this.f424311j;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L11:
        ForsetiFragmentDisplayControllerImpl r105 = new ForsetiFragmentDisplayControllerImpl(r100, r102);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.fragment_display_controller_cache_disabled") == true) goto L14;
        r100.getLifecycle().addObserver(new FragmentLifecycleObserver(r100, this.D));
    L14:
        this.D.put(r100, r105);
        return r105;
    L10:
        r102 = r104;
        goto L11
    L16:
        ForsetiChainHelper r106 = this.f424311j;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L21:
        return new ForsetiFragmentDisplayControllerImpl(r100, r102);
    L19:
        r102 = r106;
        goto L21
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        this.f424310i = r100;
        Log.i("Forseti_ChainFragment", "onAttach, chainType: " + S90());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Log.i("Forseti_ChainFragment", WidgetCostModule.TYPE_ON_CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        Log.i("Forseti_ChainFragment", "onSaveInstanceState");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle r100) {
        super.onViewStateRestored(r100);
        Log.i("Forseti_ChainFragment", "onViewStateRestored");
    }

    public final void X90(String r100, Runnable r101) {
        if (V90(r100) == false) goto L5;
        r101.run();
        return;
    L5:
        ConcurrentHashMap r102 = (ConcurrentHashMap) this.f424320s;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L8;
        r103 = new ArrayList();
        r102.put(r100, r103);
    L8:
        ((List) r103).add(r101);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Log.i("Forseti_ChainFragment", "onViewCreated");
        ViewGroup r100 = this.f424307f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r100 = null;
    L5:
        this.f424309h = (View) SequencesKt.lastOrNull(ViewGroupKt.getChildren(r100));
        if (S90() != ForsetiChainType.TYPE_NORMAL) goto L9;
        this.f424317p = new f(this);
        this.f424318q = new g(this);
    L9:
        ViewGroup r101 = this.f424308g;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r101 = null;
    L13:
        if ((r101 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L15;
        ForsetiNormalChainViewGroupCompat r102 = (ForsetiNormalChainViewGroupCompat) r101;
    L16:
        if (r102 == null) goto L18;
        r102.setForsetiDraggingHelper(da0());
    L18:
        ViewGroup r103 = this.f424308g;
        if (r103 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r103 = null;
    L22:
        if ((r103 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L24;
        ForsetiNormalChainViewGroupCompat r104 = (ForsetiNormalChainViewGroupCompat) r103;
    L25:
        if (r104 == null) goto L30;
        com.ss.android.lark.api.bean.config.a r105 = this.f424322u;
        if (r105 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiChainConfig");
        r105 = null;
    L29:
        r104.setForsetiChainConfig(r105);
    L30:
        FragmentManager r112 = getChildFragmentManager();
        ViewGroup r106 = this.f424308g;
        if (r106 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        ViewGroup r113 = null;
    L34:
        FragmentActivity r107 = requireActivity();
        ForsetiAttachInfo r108 = (ForsetiAttachInfo) this.f424315n.getValue();
        f r109 = this.f424317p;
        ForsetiColumnsDraggingHelper r114 = da0();
        ForsetiActivityChainManager.b r115 = this.f424321t;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiStructureNotifier");
        ForsetiActivityChainManager.b r116 = null;
    L38:
        this.f424311j = new ForsetiChainHelper(r112, r113, new com.ss.android.lark.forseti.global.e(r107, r108, r109, r114, r116, (com.ss.android.lark.api.bean.config.a) this.f424326y.getValue(), ca0(), this), S90());
        Log.i("Forseti_ChainFragment", "chainHelper is initialized");
        ForsetiChainHelper r117 = this.f424311j;
        if (r117 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r117 = null;
    L41:
        r117.f424351h = new e(this);
        Iterator r118 = ((ConcurrentHashMap) this.f424320s).keySet().iterator();
    L43:
        if (r118.hasNext() == false) goto L52;
        String r119 = (String) r118.next();
        List r120 = (List) ((ConcurrentHashMap) this.f424320s).get(r119);
        if (r120 == null) goto L51;
        Iterator r121 = r120.iterator();
    L48:
        if (r121.hasNext() == false) goto L50;
        ((Runnable) r121.next()).run();
        goto L48
    L50:
        r120.clear();
    L51:
        ((ConcurrentHashMap) this.f424320s).remove(r119);
        goto L43
    L52:
        ViewGroup r122 = this.f424308g;
        if (r122 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r122 = null;
    L56:
        if ((r122 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L58;
        ForsetiNormalChainViewGroupCompat r123 = (ForsetiNormalChainViewGroupCompat) r122;
    L59:
        if (r123 == null) goto L70;
        ForsetiChainHelper r124 = this.f424311j;
        if (r124 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        ForsetiChainHelper r125 = null;
    L64:
        r123.setForsetiChainHelper(r125);
        return;
    L63:
        r125 = r124;
        goto L64
    L70:
        return;
    L58:
        r123 = null;
        goto L59
    L37:
        r116 = r115;
        goto L38
    L33:
        r113 = r106;
        goto L34
    L24:
        r104 = null;
        goto L25
    L15:
        r102 = null;
        goto L16
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Log.i("Forseti_ChainFragment", "onCreateView");
        if (S90() != ForsetiChainType.TYPE_NORMAL) goto L8;
        Context r103 = this.f424310i;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r103 = null;
    L7:
        s r104 = new ForsetiNormalChainAdapter(r103, da0());
    L38:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.A = r104;
        StringBuilder r105 = new StringBuilder("ForsetiPopoverParams: ");
        uua.a r106 = this.f424323v;
        if (r106 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiInnerOptions");
        r106 = null;
    L41:
        r105.append(r106.f551784c);
        Log.d("Forseti_ChainFragment", r105.toString());
        ViewGroup r107 = ca0().h();
        this.f424307f = r107;
        if (r107 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r107 = null;
    L44:
        r107.setTag(this);
        ca0().e();
        ViewGroup r108 = this.f424307f;
        if (r108 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r108 = null;
    L47:
        r108.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.f424316o == null) goto L53;
        ViewGroup r109 = this.f424307f;
        if (r109 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r109 = null;
    L52:
        r109.setOnClickListener(this.f424316o);
    L53:
        this.f424308g = ca0().j();
        ca0().i(new AnonymousClass1(this));
        ViewGroup r110 = this.f424307f;
        if (r110 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        return null;
    L57:
        return r110;
    L8:
        int r111 = eib.a.f472822a;
        uua.a r112 = this.f424323v;
        if (r112 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiInnerOptions");
        r112 = null;
    L11:
        Context r113 = this.f424310i;
        if (r113 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r113 = null;
    L14:
        Intrinsics.checkNotNullParameter(r112, "<this>");
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        vua.a r114 = r112.f551784c;
        if (r114 == null) goto L17;
        View r115 = r114.f557367a;
    L18:
        if (r115 != null) goto L25;
        if (r114 == null) goto L21;
        Rect r116 = r114.f557368b;
    L22:
        if (r116 != null) goto L25;
        boolean r117 = false;
    L26:
        if (r117 == false) goto L34;
        Context r118 = this.f424310i;
        if (r118 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r118 = null;
    L30:
        ForsetiChainType r119 = S90();
        uua.a r120 = this.f424323v;
        if (r120 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiInnerOptions");
        r120 = null;
    L33:
        r104 = new ForsetiPopoverChainAdapter(r118, r119, r120);
        goto L38
    L34:
        Context r121 = this.f424310i;
        if (r121 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r121 = null;
    L37:
        r104 = new ForsetiStackChainAdapter(r121, S90());
        goto L38
    L21:
        r116 = null;
    L25:
        r117 = true;
        goto L26
    L17:
        r115 = null;
        goto L18
    }

    public static void T90(final ForsetiChainFragment r110, final Fragment r111, final String r112, Fragment r113, boolean r114, boolean r115, boolean r116, final uua.a r210, int r211) {
        if ((r211 & 4) == 0) goto L5;
        final Fragment r100 = null;
    L7:
        if ((r211 & 8) == 0) goto L9;
        final boolean r101 = true;
    L11:
        if ((r211 & 16) == 0) goto L13;
        final boolean r102 = false;
    L15:
        if ((r211 & 32) == 0) goto L17;
        final boolean r103 = false;
    L18:
        final FragmentManager.FragmentLifecycleCallbacks r104 = null;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "f");
        Intrinsics.checkNotNullParameter(r112, "tag");
        Intrinsics.checkNotNullParameter(r210, "options");
        r110.X90(r110.f424312k, new ForsetiChainFragment$addForsetiFragment$1(r111, r110, r103, r112, r100, r101, r104, r210, r102));
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
