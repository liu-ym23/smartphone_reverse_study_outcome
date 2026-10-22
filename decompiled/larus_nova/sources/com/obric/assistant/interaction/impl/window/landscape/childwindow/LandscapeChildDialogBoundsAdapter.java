package com.obric.assistant.interaction.impl.window.landscape.childwindow;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.AssistantChatDialog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.vivo.push.PushClientConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0010¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001«\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u00104\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\f2\u0006\u00105\u001a\u00020\u0005H\u0007J\u001a\u00106\u001a\u0002072\b\u00103\u001a\u0004\u0018\u00010\f2\u0006\u00105\u001a\u00020\u0005H\u0002J\u0012\u00108\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u00109\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\fH\u0007J\r\u0010:\u001a\u000202H\u0000¢\u0006\u0002\b;J\r\u0010<\u001a\u00020\u0007H\u0000¢\u0006\u0002\b=J\u0015\u0010>\u001a\u0002022\u0006\u00103\u001a\u00020\fH\u0000¢\u0006\u0002\b?J\u0015\u0010@\u001a\u0002022\u0006\u00103\u001a\u00020\fH\u0000¢\u0006\u0002\bAJ\u001d\u0010B\u001a\u0002022\u0006\u00103\u001a\u00020\f2\u0006\u0010C\u001a\u00020\u0007H\u0000¢\u0006\u0002\bDJ#\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010F2\u0006\u00103\u001a\u00020\fH\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020\u00122\u0006\u00103\u001a\u00020\fH\u0000¢\u0006\u0002\bIJ\u0012\u0010J\u001a\u0004\u0018\u00010\u001c2\u0006\u00103\u001a\u00020\fH\u0002J\"\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001cH\u0002J\u0018\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\u0007H\u0002J\u0017\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010VJ \u0010W\u001a\u00020\u00072\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001cH\u0002J)\u0010X\u001a\u0004\u0018\u00010\u00072\b\u0010Y\u001a\u0004\u0018\u00010!2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\\J\u0018\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0007H\u0002J\u0018\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0002J\u0018\u0010c\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0010\u0010f\u001a\u0002022\u0006\u0010d\u001a\u00020\rH\u0002J\u0010\u0010g\u001a\u0002022\u0006\u0010d\u001a\u00020\rH\u0002J\u0018\u0010h\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0005H\u0002J0\u0010i\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010e\u001a\u00020\u0005H\u0002J0\u0010l\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010e\u001a\u00020\u0005H\u0002J0\u0010m\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010e\u001a\u00020\u0005H\u0002J0\u0010n\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010e\u001a\u00020\u0005H\u0002J2\u0010o\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\b\b\u0002\u0010p\u001a\u00020\u0012H\u0002J0\u0010q\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'2\b\b\u0002\u0010p\u001a\u00020\u0012H\u0002J(\u0010r\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J(\u0010s\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J*\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J(\u0010v\u001a\u0004\u0018\u00010u2\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'H\u0002J\u0018\u0010w\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010x\u001a\u00020\u001cH\u0002J.\u0010y\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001c2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'2\u0006\u0010z\u001a\u00020\u0007H\u0002J\u0018\u0010{\u001a\u00020\u00072\u0006\u0010j\u001a\u00020!2\u0006\u0010P\u001a\u00020\u001cH\u0002J \u0010|\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020!2\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u0007H\u0002J\u0012\u0010\u007f\u001a\u0004\u0018\u00010u2\u0006\u0010j\u001a\u00020!H\u0002J\u0019\u0010\u0080\u0001\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!H\u0002J)\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J\u0019\u0010\u0082\u0001\u001a\u00020\u00122\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00122\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00122\b\u0010d\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0084\u0001J\u0019\u0010\u0085\u0001\u001a\u00020\u00122\b\u0010d\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0084\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u0005H\u0002J!\u0010\u0087\u0001\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!H\u0002J!\u0010\u0088\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0019\u0010\u0089\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!H\u0002J\u001f\u0010\u008a\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'H\u0002J\u0019\u0010\u008b\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0019\u0010\u008c\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0005H\u0002J!\u0010\u008d\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u0006\u0010e\u001a\u00020\u0005H\u0002J%\u0010\u008e\u0001\u001a\u0002022\u0006\u0010j\u001a\u00020!2\u0007\u0010\u008f\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0012H\u0002J\u001f\u0010\u0091\u0001\u001a\u0002022\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'2\u0006\u0010~\u001a\u00020\u0007H\u0002J \u0010\u0092\u0001\u001a\u0002022\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'2\u0007\u0010\u0093\u0001\u001a\u00020\u0007H\u0002J\u001b\u0010\u0094\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\u001b\u0010\u0097\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\u001a\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0096\u00012\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'H\u0002J\u0013\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u001c2\u0006\u0010Y\u001a\u00020!H\u0002J\u0019\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010M\u001a\u00020.H\u0002¢\u0006\u0003\u0010\u009b\u0001J\u0019\u0010\u009c\u0001\u001a\u00020\u00122\u0006\u00103\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0005H\u0002J\u0011\u0010\u009d\u0001\u001a\u00020\u00122\u0006\u00103\u001a\u00020\fH\u0002J\"\u0010\u009e\u0001\u001a\u00020\u00122\u000e\u0010\u009f\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010 \u00012\u0007\u0010¡\u0001\u001a\u00020\u0005H\u0002J\u000e\u0010¢\u0001\u001a\u00020\u0012*\u00030£\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010!0 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010&\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\f\u0012\n\u0012\u0004\u0012\u00020!\u0018\u00010'0 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R(\u0010*\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u001c0 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010\u00070 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010#\"\u0004\b0\u0010%¨\u0006¬\u0001"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter;", "", "<init>", "()V", "TAG", "", "UNSET_TOP", "", "WARM_UP_SAMPLE_LIMIT", "DRIFT_THRESHOLD_PX", "states", "Ljava/util/WeakHashMap;", "Landroid/app/Dialog;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BoundsState;", "preAddViewBoundsSessions", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$PreAddViewBoundsSession;", "landscapeRestrictionActiveResolver", "Lkotlin/Function0;", "", "getLandscapeRestrictionActiveResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setLandscapeRestrictionActiveResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "windowTokenResolver", "Landroid/os/IBinder;", "getWindowTokenResolver$impl_mainlandRelease", "setWindowTokenResolver$impl_mainlandRelease", "hostVisibleBoundsResolver", "Landroid/graphics/Rect;", "getHostVisibleBoundsResolver$impl_mainlandRelease", "setHostVisibleBoundsResolver$impl_mainlandRelease", "bottomSheetViewResolver", "Lkotlin/Function1;", "Landroid/view/View;", "getBottomSheetViewResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setBottomSheetViewResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "bottomSheetBehaviorResolver", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBottomSheetBehaviorResolver$impl_mainlandRelease", "setBottomSheetBehaviorResolver$impl_mainlandRelease", "viewGlobalVisibleRectResolver", "getViewGlobalVisibleRectResolver$impl_mainlandRelease", "setViewGlobalVisibleRectResolver$impl_mainlandRelease", "screenWidthResolver", "Landroid/view/Window;", "getScreenWidthResolver$impl_mainlandRelease", "setScreenWidthResolver$impl_mainlandRelease", "beginPreAddViewBoundsSession", "", "dialog", "onDialogPreAddView", "trigger", "applyPreAddViewBounds", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$PreAddViewBoundsApplyResult;", "onDialogShown", "onDialogDismissed", "clearForTest", "clearForTest$impl_mainlandRelease", "trackedStateCountForTest", "trackedStateCountForTest$impl_mainlandRelease", "restoreStableBoundsForTest", "restoreStableBoundsForTest$impl_mainlandRelease", "sampleAndRestoreForTest", "sampleAndRestoreForTest$impl_mainlandRelease", "dispatchStateForTest", "newState", "dispatchStateForTest$impl_mainlandRelease", "stableBoundsForTest", "Lkotlin/Pair;", "stableBoundsForTest$impl_mainlandRelease", "hasBehaviorCallbackForTest", "hasBehaviorCallbackForTest$impl_mainlandRelease", "resolveTargetChildDialogHostBounds", "resolveOnStartHorizontalBounds", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$HorizontalBounds;", LiveEndPageData.TAG_WINDOW, "attrs", "Landroid/view/WindowManager$LayoutParams;", "hostBounds", "resolveHostCenterOffset", "screenWidth", "resolveSizeRequestMode", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "size", "(Ljava/lang/Integer;)Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "measureWrapContentWidth", "measureViewWidth", "view", "widthSpec", "heightSpec", "(Landroid/view/View;II)Ljava/lang/Integer;", "resolveMeasureHeight", "height", "hostHeight", "replaceHorizontalGravityPreservingVertical", "originalGravity", "horizontalGravity", "postSampleAndRestore", "state", "reason", "installStableListeners", "removeSheetPreDrawListener", "sampleAndRestoreStableBounds", "sampleStableBounds", DocumentType.SHEET_NAME, "behavior", "refreshStableBehavior", "installOrRefreshSettledFullHeightTarget", "installOrRefreshOverflowFitToHostTarget", "applyFullHeightExpandedParams", "forceExpandedState", "applyOverflowFitToHostParams", "shouldApplyFullHeightExpandedParams", "shouldPromoteCurrentLayoutToFullHeight", "resolveSettledFullHeightTarget", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$StableSheetTarget;", "resolveOverflowFitToHostTarget", "resolveOverflowFitTargetBottom", "sheetRect", "canExpandOverflowSheet", "targetHeight", "resolveBottomSheetDesiredContentHeight", "measureViewDesiredHeight", "width", "maxHeight", "resolveSettledSheetStableTarget", "hasFullHeightRequest", "hasFullHeightExpandedIntent", "isExpandedOrSkipCollapsed", "isUnsettledBottomSheetState", "(Ljava/lang/Integer;)Z", "isHiddenBottomSheetState", "isLayoutSamplingReason", "resolveBottomSheetBehavior", "updateStableBoundsFromCurrentLayout", "recordSheetLayoutRequest", "installBehaviorCallback", "restoreStableBounds", "restoreStableSheetBounds", "normalizeStableSheetBounds", "syncSheetHeight", "stableHeight", "forceRequestLayout", "setMaxHeightCompat", "setExpandedOffsetCompat", "expandedOffset", "setBottomSheetCallback", "callback", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "clearBottomSheetCallback", "getSingleBottomSheetCallback", "resolveGlobalVisibleRect", "resolveScreenWidth", "(Landroid/view/Window;)Ljava/lang/Integer;", "shouldDeferToBottomSheetOnStart", "isMaterialBottomSheetDialog", "isClassOrSuperclassNamed", "type", "Ljava/lang/Class;", PushClientConstants.TAG_CLASS_NAME, "isStrongStableMode", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;", "CallbackInstallMode", "BottomSheetStableMode", "SizeRequestMode", "HorizontalBounds", "StableSheetTarget", "PreAddViewBoundsSession", "PreAddViewBoundsApplyResult", "BoundsState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeChildDialogBoundsAdapter {
    private static final int DRIFT_THRESHOLD_PX = 1;
    public static final LandscapeChildDialogBoundsAdapter INSTANCE = null;
    private static final String TAG = "LandscapeChildDialogBounds";
    private static final int UNSET_TOP = Integer.MIN_VALUE;
    private static final int WARM_UP_SAMPLE_LIMIT = 3;
    private static Function1<? super View, ? extends BottomSheetBehavior<View>> bottomSheetBehaviorResolver;
    private static Function1<? super Dialog, ? extends View> bottomSheetViewResolver;
    private static Function0<Rect> hostVisibleBoundsResolver;
    private static Function0<Boolean> landscapeRestrictionActiveResolver;
    private static final WeakHashMap<Dialog, PreAddViewBoundsSession> preAddViewBoundsSessions = null;
    private static Function1<? super Window, Integer> screenWidthResolver;
    private static final WeakHashMap<Dialog, BoundsState> states = null;
    private static Function1<? super View, Rect> viewGlobalVisibleRectResolver;
    private static Function0<? extends IBinder> windowTokenResolver;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "FULL_HEIGHT_EXPANDED", "OVERFLOW_FIT_TO_HOST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BottomSheetStableMode extends Enum<BottomSheetStableMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ BottomSheetStableMode[] $VALUES = null;
        public static final BottomSheetStableMode FULL_HEIGHT_EXPANDED = null;
        public static final BottomSheetStableMode NONE = null;
        public static final BottomSheetStableMode OVERFLOW_FIT_TO_HOST = null;

        private static final /* synthetic */ BottomSheetStableMode[] $values() {
            return new BottomSheetStableMode[]{NONE, FULL_HEIGHT_EXPANDED, OVERFLOW_FIT_TO_HOST};
        }

        public static EnumEntries<BottomSheetStableMode> getEntries() {
            return $ENTRIES;
        }

        static {
            NONE = new BottomSheetStableMode(UserProfileEvent.POSITION_NONE, 0);
            FULL_HEIGHT_EXPANDED = new BottomSheetStableMode("FULL_HEIGHT_EXPANDED", 1);
            OVERFLOW_FIT_TO_HOST = new BottomSheetStableMode("OVERFLOW_FIT_TO_HOST", 2);
            BottomSheetStableMode[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static BottomSheetStableMode[] values() {
            return (BottomSheetStableMode[]) $VALUES.clone();
        }

        public static BottomSheetStableMode valueOf(String r100) {
            return (BottomSheetStableMode) r27.a.a(BottomSheetStableMode.class, r100);
        }

        private BottomSheetStableMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bC\b\u0002\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\u001d\u0012\b\b\u0002\u0010$\u001a\u00020\u001d\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010\u001e\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010S\"\u0004\bV\u0010UR\u001a\u0010\u001f\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010S\"\u0004\bW\u0010UR\u001a\u0010 \u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010S\"\u0004\bX\u0010UR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010#\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010S\"\u0004\b]\u0010UR\u001a\u0010$\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010S\"\u0004\b_\u0010UR\u001e\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c¨\u0006e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BoundsState;", "", "dialogRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "decorRef", "Landroid/view/View;", "sheetRef", "hostBounds", "Landroid/graphics/Rect;", "stableGlobalTop", "", "stableLocalTop", "stableHeight", "warmUpSamples", "stableLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "preDrawObserver", "Landroid/view/ViewTreeObserver;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "behaviorCallback", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "previousBehaviorCallback", "callbackInstallMode", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;", "hasObservedMatchParentHeight", "", "isSamplingEnabled", "isHidden", "isRestoring", "stableMode", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;", "isStableInstalled", "hasNormalizedStableBounds", "currentBehaviorState", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Landroid/graphics/Rect;IIIILandroid/view/View$OnLayoutChangeListener;Landroid/view/ViewTreeObserver$OnPreDrawListener;Landroid/view/ViewTreeObserver;Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;ZZZZLcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;ZZLjava/lang/Integer;)V", "getDialogRef", "()Ljava/lang/ref/WeakReference;", "getDecorRef", "getSheetRef", "getHostBounds", "()Landroid/graphics/Rect;", "getStableGlobalTop", "()I", "setStableGlobalTop", "(I)V", "getStableLocalTop", "setStableLocalTop", "getStableHeight", "setStableHeight", "getWarmUpSamples", "setWarmUpSamples", "getStableLayoutListener", "()Landroid/view/View$OnLayoutChangeListener;", "setStableLayoutListener", "(Landroid/view/View$OnLayoutChangeListener;)V", "getPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setPreDrawListener", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "getPreDrawObserver", "()Landroid/view/ViewTreeObserver;", "setPreDrawObserver", "(Landroid/view/ViewTreeObserver;)V", "getBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "getBehaviorCallback", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "setBehaviorCallback", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;)V", "getPreviousBehaviorCallback", "setPreviousBehaviorCallback", "getCallbackInstallMode", "()Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;", "setCallbackInstallMode", "(Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;)V", "getHasObservedMatchParentHeight", "()Z", "setHasObservedMatchParentHeight", "(Z)V", "setSamplingEnabled", "setHidden", "setRestoring", "getStableMode", "()Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;", "setStableMode", "(Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;)V", "setStableInstalled", "getHasNormalizedStableBounds", "setHasNormalizedStableBounds", "getCurrentBehaviorState", "()Ljava/lang/Integer;", "setCurrentBehaviorState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BoundsState {
        private BottomSheetBehavior<View> behavior;
        private BottomSheetBehavior.BottomSheetCallback behaviorCallback;
        private CallbackInstallMode callbackInstallMode;
        private Integer currentBehaviorState;
        private final WeakReference<View> decorRef;
        private final WeakReference<Dialog> dialogRef;
        private boolean hasNormalizedStableBounds;
        private boolean hasObservedMatchParentHeight;
        private final Rect hostBounds;
        private boolean isHidden;
        private boolean isRestoring;
        private boolean isSamplingEnabled;
        private boolean isStableInstalled;
        private ViewTreeObserver.OnPreDrawListener preDrawListener;
        private ViewTreeObserver preDrawObserver;
        private BottomSheetBehavior.BottomSheetCallback previousBehaviorCallback;
        private final WeakReference<View> sheetRef;
        private int stableGlobalTop;
        private int stableHeight;
        private View.OnLayoutChangeListener stableLayoutListener;
        private int stableLocalTop;
        private BottomSheetStableMode stableMode;
        private int warmUpSamples;

        public final BottomSheetBehavior<View> getBehavior() {
            return this.behavior;
        }

        public final BottomSheetBehavior.BottomSheetCallback getBehaviorCallback() {
            return this.behaviorCallback;
        }

        public final CallbackInstallMode getCallbackInstallMode() {
            return this.callbackInstallMode;
        }

        public final Integer getCurrentBehaviorState() {
            return this.currentBehaviorState;
        }

        public final WeakReference<View> getDecorRef() {
            return this.decorRef;
        }

        public final WeakReference<Dialog> getDialogRef() {
            return this.dialogRef;
        }

        public final boolean getHasNormalizedStableBounds() {
            return this.hasNormalizedStableBounds;
        }

        public final boolean getHasObservedMatchParentHeight() {
            return this.hasObservedMatchParentHeight;
        }

        public final Rect getHostBounds() {
            return this.hostBounds;
        }

        public final ViewTreeObserver.OnPreDrawListener getPreDrawListener() {
            return this.preDrawListener;
        }

        public final ViewTreeObserver getPreDrawObserver() {
            return this.preDrawObserver;
        }

        public final BottomSheetBehavior.BottomSheetCallback getPreviousBehaviorCallback() {
            return this.previousBehaviorCallback;
        }

        public final WeakReference<View> getSheetRef() {
            return this.sheetRef;
        }

        public final int getStableGlobalTop() {
            return this.stableGlobalTop;
        }

        public final int getStableHeight() {
            return this.stableHeight;
        }

        public final View.OnLayoutChangeListener getStableLayoutListener() {
            return this.stableLayoutListener;
        }

        public final int getStableLocalTop() {
            return this.stableLocalTop;
        }

        public final BottomSheetStableMode getStableMode() {
            return this.stableMode;
        }

        public final int getWarmUpSamples() {
            return this.warmUpSamples;
        }

        public final boolean isHidden() {
            return this.isHidden;
        }

        public final boolean isRestoring() {
            return this.isRestoring;
        }

        public final boolean isSamplingEnabled() {
            return this.isSamplingEnabled;
        }

        public final boolean isStableInstalled() {
            return this.isStableInstalled;
        }

        public final void setBehavior(BottomSheetBehavior<View> r100) {
            this.behavior = r100;
        }

        public final void setBehaviorCallback(BottomSheetBehavior.BottomSheetCallback r100) {
            this.behaviorCallback = r100;
        }

        public final void setCallbackInstallMode(CallbackInstallMode r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.callbackInstallMode = r100;
        }

        public final void setCurrentBehaviorState(Integer r100) {
            this.currentBehaviorState = r100;
        }

        public final void setHasNormalizedStableBounds(boolean r100) {
            this.hasNormalizedStableBounds = r100;
        }

        public final void setHasObservedMatchParentHeight(boolean r100) {
            this.hasObservedMatchParentHeight = r100;
        }

        public final void setHidden(boolean r100) {
            this.isHidden = r100;
        }

        public final void setPreDrawListener(ViewTreeObserver.OnPreDrawListener r100) {
            this.preDrawListener = r100;
        }

        public final void setPreDrawObserver(ViewTreeObserver r100) {
            this.preDrawObserver = r100;
        }

        public final void setPreviousBehaviorCallback(BottomSheetBehavior.BottomSheetCallback r100) {
            this.previousBehaviorCallback = r100;
        }

        public final void setRestoring(boolean r100) {
            this.isRestoring = r100;
        }

        public final void setSamplingEnabled(boolean r100) {
            this.isSamplingEnabled = r100;
        }

        public final void setStableGlobalTop(int r100) {
            this.stableGlobalTop = r100;
        }

        public final void setStableHeight(int r100) {
            this.stableHeight = r100;
        }

        public final void setStableInstalled(boolean r100) {
            this.isStableInstalled = r100;
        }

        public final void setStableLayoutListener(View.OnLayoutChangeListener r100) {
            this.stableLayoutListener = r100;
        }

        public final void setStableLocalTop(int r100) {
            this.stableLocalTop = r100;
        }

        public final void setStableMode(BottomSheetStableMode r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.stableMode = r100;
        }

        public final void setWarmUpSamples(int r100) {
            this.warmUpSamples = r100;
        }

        public BoundsState(WeakReference<Dialog> r100, WeakReference<View> r101, WeakReference<View> r110, Rect r111, int r112, int r113, int r114, int r115, View.OnLayoutChangeListener r116, ViewTreeObserver.OnPreDrawListener r117, ViewTreeObserver r118, BottomSheetBehavior<View> r119, BottomSheetBehavior.BottomSheetCallback r210, BottomSheetBehavior.BottomSheetCallback r211, CallbackInstallMode r212, boolean r213, boolean r214, boolean r215, boolean r216, BottomSheetStableMode r217, boolean r218, boolean r219, Integer r310) {
            Intrinsics.checkNotNullParameter(r100, "dialogRef");
            Intrinsics.checkNotNullParameter(r101, "decorRef");
            Intrinsics.checkNotNullParameter(r111, "hostBounds");
            Intrinsics.checkNotNullParameter(r212, "callbackInstallMode");
            Intrinsics.checkNotNullParameter(r217, "stableMode");
            this.dialogRef = r100;
            this.decorRef = r101;
            this.sheetRef = r110;
            this.hostBounds = r111;
            this.stableGlobalTop = r112;
            this.stableLocalTop = r113;
            this.stableHeight = r114;
            this.warmUpSamples = r115;
            this.stableLayoutListener = r116;
            this.preDrawListener = r117;
            this.preDrawObserver = r118;
            this.behavior = r119;
            this.behaviorCallback = r210;
            this.previousBehaviorCallback = r211;
            this.callbackInstallMode = r212;
            this.hasObservedMatchParentHeight = r213;
            this.isSamplingEnabled = r214;
            this.isHidden = r215;
            this.isRestoring = r216;
            this.stableMode = r217;
            this.isStableInstalled = r218;
            this.hasNormalizedStableBounds = r219;
            this.currentBehaviorState = r310;
        }

        public /* synthetic */ BoundsState(WeakReference r210, WeakReference r211, WeakReference r310, Rect r311, int r312, int r313, int r314, int r315, View.OnLayoutChangeListener r316, ViewTreeObserver.OnPreDrawListener r317, ViewTreeObserver r318, BottomSheetBehavior r319, BottomSheetBehavior.BottomSheetCallback r410, BottomSheetBehavior.BottomSheetCallback r411, CallbackInstallMode r412, boolean r413, boolean r414, boolean r415, boolean r416, BottomSheetStableMode r417, boolean r418, boolean r419, Integer r510, int r511, DefaultConstructorMarker r512) {
            if ((r511 & 16) == 0) goto L5;
            int r100 = Integer.MIN_VALUE;
        L7:
            if ((r511 & 32) == 0) goto L9;
            int r101 = Integer.MIN_VALUE;
        L11:
            if ((r511 & 64) == 0) goto L13;
            int r110 = 0;
        L15:
            if ((r511 & 128) == 0) goto L17;
            int r111 = 0;
        L19:
            if ((r511 & 256) == 0) goto L21;
            View.OnLayoutChangeListener r112 = null;
        L23:
            if ((r511 & 512) == 0) goto L25;
            ViewTreeObserver.OnPreDrawListener r113 = null;
        L27:
            if ((r511 & 1024) == 0) goto L29;
            ViewTreeObserver r114 = null;
        L31:
            if ((r511 & 2048) == 0) goto L33;
            BottomSheetBehavior r115 = null;
        L35:
            if ((r511 & 4096) == 0) goto L37;
            BottomSheetBehavior.BottomSheetCallback r116 = null;
        L39:
            if ((r511 & 8192) == 0) goto L41;
            BottomSheetBehavior.BottomSheetCallback r117 = null;
        L43:
            if ((r511 & 16384) == 0) goto L45;
            CallbackInstallMode r118 = CallbackInstallMode.NONE;
        L47:
            if ((32768 & r511) == 0) goto L49;
            boolean r119 = false;
        L51:
            if ((65536 & r511) == 0) goto L53;
            boolean r212 = false;
        L55:
            if ((131072 & r511) == 0) goto L57;
            boolean r213 = false;
        L59:
            if ((262144 & r511) == 0) goto L61;
            boolean r214 = false;
        L63:
            if ((524288 & r511) == 0) goto L65;
            BottomSheetStableMode r215 = BottomSheetStableMode.NONE;
        L67:
            if ((1048576 & r511) == 0) goto L69;
            boolean r216 = false;
        L71:
            if ((2097152 & r511) == 0) goto L73;
            boolean r217 = false;
        L75:
            if ((r511 & 4194304) == 0) goto L77;
            Integer r218 = null;
        L78:
            this(r210, r211, r310, r311, r100, r101, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214, r215, r216, r217, r218);
            return;
        L77:
            r218 = r510;
            goto L78
        L73:
            r217 = r419;
            goto L75
        L69:
            r216 = r418;
            goto L71
        L65:
            r215 = r417;
            goto L67
        L61:
            r214 = r416;
            goto L63
        L57:
            r213 = r415;
            goto L59
        L53:
            r212 = r414;
            goto L55
        L49:
            r119 = r413;
            goto L51
        L45:
            r118 = r412;
            goto L47
        L41:
            r117 = r411;
            goto L43
        L37:
            r116 = r410;
            goto L39
        L33:
            r115 = r319;
            goto L35
        L29:
            r114 = r318;
            goto L31
        L25:
            r113 = r317;
            goto L27
        L21:
            r112 = r316;
            goto L23
        L17:
            r111 = r315;
            goto L19
        L13:
            r110 = r314;
            goto L15
        L9:
            r101 = r313;
            goto L11
        L5:
            r100 = r312;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "ADD_REMOVE", "SET_SINGLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CallbackInstallMode extends Enum<CallbackInstallMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ CallbackInstallMode[] $VALUES = null;
        public static final CallbackInstallMode ADD_REMOVE = null;
        public static final CallbackInstallMode NONE = null;
        public static final CallbackInstallMode SET_SINGLE = null;

        private static final /* synthetic */ CallbackInstallMode[] $values() {
            return new CallbackInstallMode[]{NONE, ADD_REMOVE, SET_SINGLE};
        }

        public static EnumEntries<CallbackInstallMode> getEntries() {
            return $ENTRIES;
        }

        static {
            NONE = new CallbackInstallMode(UserProfileEvent.POSITION_NONE, 0);
            ADD_REMOVE = new CallbackInstallMode("ADD_REMOVE", 1);
            SET_SINGLE = new CallbackInstallMode("SET_SINGLE", 2);
            CallbackInstallMode[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static CallbackInstallMode[] values() {
            return (CallbackInstallMode[]) $VALUES.clone();
        }

        public static CallbackInstallMode valueOf(String r100) {
            return (CallbackInstallMode) r27.a.a(CallbackInstallMode.class, r100);
        }

        private CallbackInstallMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$HorizontalBounds;", "", "width", "", "x", "<init>", "(II)V", "getWidth", "()I", "getX", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HorizontalBounds {
        private final int width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final int f389847x;

        public static /* synthetic */ HorizontalBounds copy$default(HorizontalBounds r100, int r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.width;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f389847x;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.f389847x;
        }

        public final HorizontalBounds copy(int r100, int r101) {
            return new HorizontalBounds(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof HorizontalBounds) == true) goto L8;
            return false;
        L8:
            HorizontalBounds r101 = (HorizontalBounds) r100;
            if (this.width == r101.width) goto L12;
            return false;
        L12:
            if (this.f389847x == r101.f389847x) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.width * 31) + this.f389847x;
        }

        public String toString() {
            return "HorizontalBounds(width=" + this.width + ", x=" + this.f389847x + ')';
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getX() {
            return this.f389847x;
        }

        public HorizontalBounds(int r100, int r101) {
            this.width = r100;
            this.f389847x = r101;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$PreAddViewBoundsApplyResult;", "", "<init>", "(Ljava/lang/String;I)V", "APPLIED", "UNCHANGED", "SKIPPED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PreAddViewBoundsApplyResult extends Enum<PreAddViewBoundsApplyResult> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PreAddViewBoundsApplyResult[] $VALUES = null;
        public static final PreAddViewBoundsApplyResult APPLIED = null;
        public static final PreAddViewBoundsApplyResult SKIPPED = null;
        public static final PreAddViewBoundsApplyResult UNCHANGED = null;

        private static final /* synthetic */ PreAddViewBoundsApplyResult[] $values() {
            return new PreAddViewBoundsApplyResult[]{APPLIED, UNCHANGED, SKIPPED};
        }

        public static EnumEntries<PreAddViewBoundsApplyResult> getEntries() {
            return $ENTRIES;
        }

        static {
            APPLIED = new PreAddViewBoundsApplyResult("APPLIED", 0);
            UNCHANGED = new PreAddViewBoundsApplyResult("UNCHANGED", 1);
            SKIPPED = new PreAddViewBoundsApplyResult("SKIPPED", 2);
            PreAddViewBoundsApplyResult[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static PreAddViewBoundsApplyResult[] values() {
            return (PreAddViewBoundsApplyResult[]) $VALUES.clone();
        }

        public static PreAddViewBoundsApplyResult valueOf(String r100) {
            return (PreAddViewBoundsApplyResult) r27.a.a(PreAddViewBoundsApplyResult.class, r100);
        }

        private PreAddViewBoundsApplyResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$PreAddViewBoundsSession;", "", "isConsumed", "", "<init>", "(Z)V", "()Z", "setConsumed", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreAddViewBoundsSession {
        private boolean isConsumed;

        public PreAddViewBoundsSession() {
            boolean r100 = false;
            this(r100, 1, null);
        }

        public static /* synthetic */ PreAddViewBoundsSession copy$default(PreAddViewBoundsSession r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.isConsumed;
        L6:
            return r100.copy(r101);
        }

        public final boolean component1() {
            return this.isConsumed;
        }

        public final PreAddViewBoundsSession copy(boolean r100) {
            return new PreAddViewBoundsSession(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PreAddViewBoundsSession) == true) goto L9;
            return false;
        L9:
            if (this.isConsumed == ((PreAddViewBoundsSession) r100).isConsumed) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            if (this.isConsumed == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public String toString() {
            return "PreAddViewBoundsSession(isConsumed=" + this.isConsumed + ')';
        }

        public final boolean isConsumed() {
            return this.isConsumed;
        }

        public PreAddViewBoundsSession(boolean r100) {
            this.isConsumed = r100;
        }

        public final void setConsumed(boolean r100) {
            this.isConsumed = r100;
        }

        public /* synthetic */ PreAddViewBoundsSession(boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = false;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "", "<init>", "()V", "MatchParent", "Fixed", "WrapContent", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$Fixed;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$MatchParent;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$WrapContent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class SizeRequestMode {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$Fixed;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "size", "", "<init>", "(I)V", "getSize", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Fixed extends SizeRequestMode {
            private final int size;

            public static /* synthetic */ Fixed copy$default(Fixed r100, int r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = r100.size;
            L6:
                return r100.copy(r101);
            }

            public final int component1() {
                return this.size;
            }

            public final Fixed copy(int r100) {
                return new Fixed(r100);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof Fixed) == true) goto L9;
                return false;
            L9:
                if (this.size == ((Fixed) r100).size) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.size;
            }

            public String toString() {
                return "Fixed(size=" + this.size + ')';
            }

            public final int getSize() {
                return this.size;
            }

            public Fixed(int r100) {
                super(null);
                this.size = r100;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$MatchParent;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class MatchParent extends SizeRequestMode {
            public static final MatchParent INSTANCE = null;

            static {
                INSTANCE = new MatchParent();
            }

            private MatchParent() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$WrapContent;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class WrapContent extends SizeRequestMode {
            public static final WrapContent INSTANCE = null;

            static {
                INSTANCE = new WrapContent();
            }

            private WrapContent() {
                super(null);
            }
        }

        private SizeRequestMode() {
        }

        public /* synthetic */ SizeRequestMode(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$StableSheetTarget;", "", "globalTop", "", "localTop", "height", "<init>", "(III)V", "getGlobalTop", "()I", "getLocalTop", "getHeight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StableSheetTarget {
        private final int globalTop;
        private final int height;
        private final int localTop;

        public static /* synthetic */ StableSheetTarget copy$default(StableSheetTarget r100, int r101, int r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.globalTop;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.localTop;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.height;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final int component1() {
            return this.globalTop;
        }

        public final int component2() {
            return this.localTop;
        }

        public final int component3() {
            return this.height;
        }

        public final StableSheetTarget copy(int r100, int r101, int r102) {
            return new StableSheetTarget(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof StableSheetTarget) == true) goto L8;
            return false;
        L8:
            StableSheetTarget r101 = (StableSheetTarget) r100;
            if (this.globalTop == r101.globalTop) goto L12;
            return false;
        L12:
            if (this.localTop == r101.localTop) goto L15;
            return false;
        L15:
            if (this.height == r101.height) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.globalTop * 31) + this.localTop) * 31) + this.height;
        }

        public String toString() {
            return "StableSheetTarget(globalTop=" + this.globalTop + ", localTop=" + this.localTop + ", height=" + this.height + ')';
        }

        public final int getGlobalTop() {
            return this.globalTop;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getLocalTop() {
            return this.localTop;
        }

        public StableSheetTarget(int r100, int r101, int r102) {
            this.globalTop = r100;
            this.localTop = r101;
            this.height = r102;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[CallbackInstallMode.values().length];
            r100[CallbackInstallMode.ADD_REMOVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CallbackInstallMode.SET_SINGLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CallbackInstallMode.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private LandscapeChildDialogBoundsAdapter() {
    }

    public static /* synthetic */ IBinder a() {
        return windowTokenResolver$lambda$1();
    }

    public static /* synthetic */ BottomSheetBehavior b(View r100) {
        return bottomSheetBehaviorResolver$lambda$5(r100);
    }

    public static /* synthetic */ void c(BoundsState r100, String r101) {
        postSampleAndRestore$lambda$19(r100, r101);
    }

    public static /* synthetic */ Rect d() {
        return hostVisibleBoundsResolver$lambda$2();
    }

    public static /* synthetic */ void e(BoundsState r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        installStableListeners$lambda$20(r100, r101, r102, r103, r104, r105, r106, r107, r108, r109);
    }

    public static /* synthetic */ View f(Dialog r100) {
        return bottomSheetViewResolver$lambda$3(r100);
    }

    public static /* synthetic */ boolean g() {
        return landscapeRestrictionActiveResolver$lambda$0();
    }

    public static /* synthetic */ Rect h(View r100) {
        return viewGlobalVisibleRectResolver$lambda$6(r100);
    }

    public static /* synthetic */ Integer i(Window r100) {
        return screenWidthResolver$lambda$7(r100);
    }

    private final int replaceHorizontalGravityPreservingVertical(int r100, int r101) {
        return ((r100 & (-8)) & (-8388616)) | r101;
    }

    static {
        INSTANCE = new LandscapeChildDialogBoundsAdapter();
        states = new WeakHashMap();
        preAddViewBoundsSessions = new WeakHashMap();
        landscapeRestrictionActiveResolver = new c();
        windowTokenResolver = new d();
        hostVisibleBoundsResolver = new e();
        bottomSheetViewResolver = new f();
        bottomSheetBehaviorResolver = new g();
        viewGlobalVisibleRectResolver = new h();
        screenWidthResolver = new i();
    }

    private static final Rect hostVisibleBoundsResolver$lambda$2() {
        return WindowHost.INSTANCE.getLandscapeWindowVisibleBounds$impl_mainlandRelease();
    }

    private static final boolean landscapeRestrictionActiveResolver$lambda$0() {
        return WindowHost.INSTANCE.isLandscapeRestrictionActive();
    }

    private static final IBinder windowTokenResolver$lambda$1() {
        return WindowHost.INSTANCE.getWindowToken();
    }

    public final void clearForTest$impl_mainlandRelease() {
        Iterator r100 = CollectionsKt.toList(states.keySet()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        onDialogDismissed((Dialog) r100.next());
        goto L4
    L6:
        states.clear();
        preAddViewBoundsSessions.clear();
    }

    public final int trackedStateCountForTest$impl_mainlandRelease() {
        return states.size();
    }

    public final Function1<View, BottomSheetBehavior<View>> getBottomSheetBehaviorResolver$impl_mainlandRelease() {
        return bottomSheetBehaviorResolver;
    }

    public final Function1<Dialog, View> getBottomSheetViewResolver$impl_mainlandRelease() {
        return bottomSheetViewResolver;
    }

    public final Function0<Rect> getHostVisibleBoundsResolver$impl_mainlandRelease() {
        return hostVisibleBoundsResolver;
    }

    public final Function0<Boolean> getLandscapeRestrictionActiveResolver$impl_mainlandRelease() {
        return landscapeRestrictionActiveResolver;
    }

    public final Function1<Window, Integer> getScreenWidthResolver$impl_mainlandRelease() {
        return screenWidthResolver;
    }

    public final Function1<View, Rect> getViewGlobalVisibleRectResolver$impl_mainlandRelease() {
        return viewGlobalVisibleRectResolver;
    }

    public final Function0<IBinder> getWindowTokenResolver$impl_mainlandRelease() {
        return windowTokenResolver;
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    @JvmStatic
    public static final void beginPreAddViewBoundsSession(Dialog r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof AssistantChatDialog) == false) goto L8;
        preAddViewBoundsSessions.remove(r100);
        return;
    L8:
        boolean r101 = false;
        preAddViewBoundsSessions.put(r100, new PreAddViewBoundsSession(r101, 1, null));
    }

    private static final BottomSheetBehavior bottomSheetBehaviorResolver$lambda$5(View r100) {
        Intrinsics.checkNotNullParameter(r100, DocumentType.SHEET_NAME);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(BottomSheetBehavior.from(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (BottomSheetBehavior) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final View bottomSheetViewResolver$lambda$3(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        return r100.findViewById(R.id.design_bottom_sheet);
    }

    private final BottomSheetBehavior.BottomSheetCallback getSingleBottomSheetCallback(BottomSheetBehavior<View> r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Field r103 = r100.getClass().getDeclaredField("callback");     // Catch: Throwable -> L9
        r103.setAccessible(true);     // Catch: Throwable -> L9
        Object r104 = r103.get(r100);     // Catch: Throwable -> L9
        if ((r104 instanceof BottomSheetBehavior.BottomSheetCallback) == false) goto L6;
        BottomSheetBehavior.BottomSheetCallback r105 = (BottomSheetBehavior.BottomSheetCallback) r104;     // Catch: Throwable -> L9
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r106) == true) goto L16;
        r101 = r106;
    L16:
        return (BottomSheetBehavior.BottomSheetCallback) r101;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private final void installStableListeners(final BoundsState r100) {
        WeakReference<View> r101 = r100.getSheetRef();
        if (r101 == null) goto L11;
        View r102 = r101.get();
        if (r102 == null) goto L13;
        View.OnLayoutChangeListener r103 = new a(r100);
        r100.setStableLayoutListener(r103);
        r102.addOnLayoutChangeListener(r103);
        ViewTreeObserver.OnPreDrawListener r104 = new LandscapeChildDialogBoundsAdapter$installStableListeners$preDrawListener$1(r100);
        ViewTreeObserver r105 = r102.getViewTreeObserver();
        if (r105.isAlive() == false) goto L12;
        r100.setPreDrawListener(r104);
        r100.setPreDrawObserver(r105);
        r105.addOnPreDrawListener(r104);
        return;
    L12:
        return;
    L13:
        return;
    }

    private final boolean isExpandedOrSkipCollapsed(BottomSheetBehavior<View> r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L18;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r100.getSkipCollapsed() != true) goto L13;
        r102 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r100.getState() != 3) goto L7;
        r101 = true;
        goto L8
    }

    private final boolean isHiddenBottomSheetState(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.intValue() != 5) goto L7;
        return true;
    }

    private final boolean isLayoutSamplingReason(String r100) {
        return Intrinsics.areEqual(r100, "layout");
    }

    private final boolean isMaterialBottomSheetDialog(Dialog r100) {
        return isClassOrSuperclassNamed(r100.getClass(), "com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    private final boolean isStrongStableMode(BottomSheetStableMode r100) {
        if (r100 != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L5;
    L8:
        return true;
    L5:
        if (r100 == BottomSheetStableMode.OVERFLOW_FIT_TO_HOST) goto L8;
        return false;
    }

    private final boolean isUnsettledBottomSheetState(BottomSheetBehavior<View> r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L18;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r100.getState() != 2) goto L13;
        r102 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r100.getState() != 1) goto L7;
        r101 = true;
        goto L8
    }

    @JvmStatic
    public static final void onDialogDismissed(Dialog r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        preAddViewBoundsSessions.remove(r100);
        BoundsState r101 = states.remove(r100);
        if (r101 != null) goto L7;
        return;
    L7:
        WeakReference<View> r102 = r101.getSheetRef();
        if (r102 == null) goto L10;
        View r103 = r102.get();
    L11:
        if (r103 == null) goto L13;
        r103.removeOnLayoutChangeListener(r101.getStableLayoutListener());
    L13:
        LandscapeChildDialogBoundsAdapter r104 = INSTANCE;
        r104.removeSheetPreDrawListener(r101);
        BottomSheetBehavior.BottomSheetCallback r105 = r101.getBehaviorCallback();
        if (r105 == null) goto L16;
        r104.clearBottomSheetCallback(r101, r105);
    L16:
        r101.setStableLayoutListener(null);
        r101.setPreDrawListener(null);
        r101.setPreDrawObserver(null);
        r101.setBehaviorCallback(null);
        r101.setPreviousBehaviorCallback(null);
        r101.setBehavior(null);
        r101.setHasObservedMatchParentHeight(false);
        r101.setSamplingEnabled(false);
        r101.setStableGlobalTop(Integer.MIN_VALUE);
        r101.setStableLocalTop(Integer.MIN_VALUE);
        r101.setStableHeight(0);
        r101.setWarmUpSamples(0);
        r101.setStableMode(BottomSheetStableMode.NONE);
        r101.setStableInstalled(false);
        r101.setHasNormalizedStableBounds(false);
        r101.setCurrentBehaviorState(null);
        return;
    L10:
        r103 = null;
        goto L11
    }

    @JvmStatic
    public static final void onDialogShown(Dialog r310) {
        if (r310 != null) goto L5;
        return;
    L5:
        onDialogDismissed(r310);
        Rect r100 = INSTANCE.resolveTargetChildDialogHostBounds(r310);
        if (r100 != null) goto L8;
        return;
    L8:
        Window r101 = r310.getWindow();
        if (r101 != null) goto L26;
        return;
    L26:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101));     // Catch: Throwable -> L13
    L15:
        WeakReference r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L18;
        r103 = null;
    L18:
        View r105 = (View) r103;
        if (r105 != null) goto L21;
        return;
    L21:
        View r106 = bottomSheetViewResolver.invoke(r310);
        WeakReference r107 = new WeakReference(r310);
        WeakReference r108 = new WeakReference(r105);
        if (r106 == null) goto L24;
        r104 = new WeakReference(r106);
    L24:
        BoundsState r109 = new BoundsState(r107, r108, r104, new Rect(r100), 0, 0, 0, 0, null, null, null, null, null, null, null, false, false, false, false, null, false, false, null, 8388592, null);
        states.put(r310, r109);
        LandscapeChildDialogBoundsAdapter r110 = INSTANCE;
        r110.installStableListeners(r109);
        r110.postSampleAndRestore(r109, "postShow");
        return;
    L13:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    private final void removeSheetPreDrawListener(BoundsState r100) {
        ViewTreeObserver.OnPreDrawListener r101 = r100.getPreDrawListener();
        if (r101 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r102 = r100.getPreDrawObserver();
        boolean r103 = false;
        if (r102 != null) goto L8;
    L10:
        if (r103 == false) goto L13;
        r102.removeOnPreDrawListener(r101);
        return;
    L13:
        WeakReference<View> r104 = r100.getSheetRef();
        if (r104 == null) goto L26;
        View r105 = r104.get();
        if (r105 == null) goto L27;
        ViewTreeObserver r106 = r105.getViewTreeObserver();
        if (r106 != null) goto L20;
        return;
    L20:
        if (r106.isAlive() == true) goto L23;
        r106 = null;
    L23:
        if (r106 == null) goto L29;
        r106.removeOnPreDrawListener(r101);
        return;
    L29:
        return;
    L27:
        return;
    L26:
        return;
    L8:
        if (r102.isAlive() != true) goto L10;
        r103 = true;
        goto L10
    }

    private final Rect resolveGlobalVisibleRect(View r100) {
        Rect r101 = new Rect();
        if (r100.getGlobalVisibleRect(r101) == true) goto L5;
        return null;
    L5:
        if (r101.isEmpty() == true) goto L10;
        return r101;
    L10:
        return null;
    }

    private final Integer resolveScreenWidth(Window r100) {
        Point r101 = new Point();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Display r103 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).getDisplay();     // Catch: Throwable -> L11
        if (r103 != null) goto L6;
        r103 = r100.getWindowManager().getDefaultDisplay();     // Catch: Throwable -> L11
    L6:
        if (r103 == null) goto L8;
        r103.getRealSize(r101);     // Catch: Throwable -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(r104);     // Catch: Throwable -> L11
    L13:
        Integer r105 = Integer.valueOf(r101.x);
        boolean r106 = true;
        if (r105.intValue() <= 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == true) goto L20;
        r105 = null;
    L20:
        if (r105 != null) goto L22;
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getContext().getResources()).widthPixels));     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r108) == false) goto L30;
        r108 = null;
    L30:
        Integer r109 = (Integer) r108;
        if (r109 != null) goto L33;
        return null;
    L33:
        if (r109.intValue() > 0) goto L36;
        r106 = false;
    L36:
        if (r106 == true) goto L38;
        return null;
    L38:
        return r109;
    L25:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L22:
        return Integer.valueOf(r105.intValue());
    L16:
        r107 = false;
        goto L17
    L8:
        r104 = null;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final StableSheetTarget resolveSettledSheetStableTarget(View r100) {
        Rect r101 = viewGlobalVisibleRectResolver.invoke(r100);
        if (r101 == null) goto L24;
        boolean r102 = true;
        if ((!r101.isEmpty()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L24;
        Integer r103 = Integer.valueOf(r101.height());
        if (r103.intValue() > 0) goto L14;
        r102 = false;
    L14:
        if (r102 == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L19;
        int r104 = r103.intValue();
    L20:
        if (r104 > 0) goto L22;
        return null;
    L22:
        int r105 = r101.top - r100.getTop();
        int r106 = r101.top;
        return new StableSheetTarget(r106, r106 - r105, r104);
    L19:
        r104 = r100.getHeight();
    L24:
        return null;
    }

    private final SizeRequestMode resolveSizeRequestMode(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 == null) goto L12;
        if (r100.intValue() <= 0) goto L12;
        return new SizeRequestMode.Fixed(r100.intValue());
    L12:
        return SizeRequestMode.WrapContent.INSTANCE;
    L5:
        if (r100.intValue() != (-1)) goto L7;
        return SizeRequestMode.MatchParent.INSTANCE;
    }

    private final Rect resolveTargetChildDialogHostBounds(Dialog r100) {
        if ((r100 instanceof AssistantChatDialog) == false) goto L6;
        return null;
    L6:
        if (landscapeRestrictionActiveResolver.invoke().booleanValue() == true) goto L8;
        return null;
    L8:
        IBinder r101 = windowTokenResolver.invoke();
        if (r101 != null) goto L11;
        return null;
    L11:
        Window r102 = r100.getWindow();
        if (r102 == null) goto L33;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        if (r103 == null) goto L34;
        IBinder r104 = r103.token;
        if (r104 == null) goto L37;
        if (r104 == r101) goto L20;
        return null;
    L20:
        Rect r105 = hostVisibleBoundsResolver.invoke();
        if (r105 != null) goto L23;
        return null;
    L23:
        if (r105.isEmpty() == false) goto L25;
    L29:
        boolean r106 = false;
    L30:
        if (r106 == true) goto L32;
        return null;
    L32:
        return r105;
    L25:
        if (r105.width() <= 0) goto L29;
        if (r105.height() <= 0) goto L29;
        r106 = true;
        goto L30
    L37:
        return null;
    L34:
        return null;
    L33:
        return null;
    }

    private static final Integer screenWidthResolver$lambda$7(Window r100) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        return INSTANCE.resolveScreenWidth(r100);
    }

    private static final Rect viewGlobalVisibleRectResolver$lambda$6(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return INSTANCE.resolveGlobalVisibleRect(r100);
    }

    public final boolean hasBehaviorCallbackForTest$impl_mainlandRelease(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        BoundsState r101 = states.get(r100);
        if (r101 == null) goto L5;
        BottomSheetBehavior.BottomSheetCallback r102 = r101.getBehaviorCallback();
    L6:
        if (r102 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public final void restoreStableBoundsForTest$impl_mainlandRelease(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        BoundsState r101 = states.get(r100);
        if (r101 == null) goto L6;
        INSTANCE.restoreStableBounds(r101, EffectConstants.CHANNEL_TEST);
        return;
    }

    public final void sampleAndRestoreForTest$impl_mainlandRelease(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        BoundsState r101 = states.get(r100);
        if (r101 == null) goto L6;
        INSTANCE.sampleAndRestoreStableBounds(r101, EffectConstants.CHANNEL_TEST);
        return;
    }

    public final void setBottomSheetBehaviorResolver$impl_mainlandRelease(Function1<? super View, ? extends BottomSheetBehavior<View>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        bottomSheetBehaviorResolver = r100;
    }

    public final void setBottomSheetViewResolver$impl_mainlandRelease(Function1<? super Dialog, ? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        bottomSheetViewResolver = r100;
    }

    public final void setHostVisibleBoundsResolver$impl_mainlandRelease(Function0<Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        hostVisibleBoundsResolver = r100;
    }

    public final void setLandscapeRestrictionActiveResolver$impl_mainlandRelease(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        landscapeRestrictionActiveResolver = r100;
    }

    public final void setScreenWidthResolver$impl_mainlandRelease(Function1<? super Window, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        screenWidthResolver = r100;
    }

    public final void setViewGlobalVisibleRectResolver$impl_mainlandRelease(Function1<? super View, Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        viewGlobalVisibleRectResolver = r100;
    }

    public final void setWindowTokenResolver$impl_mainlandRelease(Function0<? extends IBinder> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        windowTokenResolver = r100;
    }

    public final Pair<Integer, Integer> stableBoundsForTest$impl_mainlandRelease(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        BoundsState r101 = states.get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.isStableInstalled() == true) goto L9;
        return null;
    L9:
        return TuplesKt.to(Integer.valueOf(r101.getStableGlobalTop()), Integer.valueOf(r101.getStableHeight()));
    }

    private final boolean isUnsettledBottomSheetState(Integer r100) {
        if (r100 != null) goto L6;
    L7:
        if (r100 != null) goto L10;
    L12:
        return false;
    L10:
        if (r100.intValue() != 2) goto L12;
        return true;
    L6:
        if (r100.intValue() != 1) goto L7;
        return true;
    }

    private final PreAddViewBoundsApplyResult applyPreAddViewBounds(Dialog r100, String r101) {
        if (r100 != null) goto L6;
        return PreAddViewBoundsApplyResult.SKIPPED;
    L6:
        if ((r100 instanceof AssistantChatDialog) == false) goto L10;
        return PreAddViewBoundsApplyResult.SKIPPED;
    L10:
        if (landscapeRestrictionActiveResolver.invoke().booleanValue() == false) goto L12;
        IBinder r102 = windowTokenResolver.invoke();
        if (r102 == null) goto L16;
        Window r103 = r100.getWindow();
        if (r103 == null) goto L20;
        WindowManager.LayoutParams r104 = r103.getAttributes();
        if (r104 == null) goto L24;
        IBinder r105 = r104.token;
        if (r105 == null) goto L28;
        if (r105 != r102) goto L31;
        Rect r106 = hostVisibleBoundsResolver.invoke();
        boolean r107 = false;
        boolean r108 = true;
        if (r106 != null) goto L35;
    L44:
        r106 = null;
    L45:
        if (r106 == null) goto L47;
        HorizontalBounds r109 = resolveOnStartHorizontalBounds(r103, r104, r106);
        if (r109 == null) goto L51;
        int r110 = replaceHorizontalGravityPreservingVertical(r104.gravity, 1);
        if (r104.width == r109.getWidth()) goto L55;
        r104.width = r109.getWidth();
        boolean r111 = true;
    L57:
        if (r104.x == r109.getX()) goto L60;
        r104.x = r109.getX();
        r111 = true;
    L60:
        if (r104.gravity == r110) goto L62;
        r104.gravity = r110;
        r107 = true;
    L63:
        if (r108 == false) goto L65;
        r103.setAttributes(r104);
        if (r107 == false) goto L70;
        r103.setGravity(r104.gravity);
    L70:
        return PreAddViewBoundsApplyResult.APPLIED;
    L65:
        return PreAddViewBoundsApplyResult.UNCHANGED;
    L62:
        r108 = r111;
        goto L63
    L55:
        r111 = false;
        goto L57
    L51:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L47:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L35:
        if (r106.isEmpty() == false) goto L37;
    L41:
        boolean r112 = false;
    L42:
        if (r112 == false) goto L44;
    L37:
        if (r106.width() <= 0) goto L41;
        if (r106.height() <= 0) goto L41;
        r112 = true;
        goto L42
    L31:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L28:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L24:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L20:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L16:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L12:
        return PreAddViewBoundsApplyResult.SKIPPED;
    }

    private final void clearBottomSheetCallback(BoundsState r110, BottomSheetBehavior.BottomSheetCallback r111) {
        BottomSheetBehavior<View> r100 = r110.getBehavior();
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = WhenMappings.$EnumSwitchMapping$0[r110.getCallbackInstallMode().ordinal()];
        if (r101 != 1) goto L8;
        Method[] r102 = r100.getClass().getMethods();
        int r103 = r102.length;
        int r104 = 0;
    L26:
        Object r105 = null;
        if (r104 >= r103) goto L39;
        Method r106 = r102[r104];
        if (Intrinsics.areEqual(r106.getName(), "removeBottomSheetCallback") == true) goto L31;
    L35:
        boolean r107 = false;
    L36:
        if (r107 == true) goto L53;
        r104 = r104 + 1;
    L53:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L45
        if (r106 == null) goto L43;
        r105 = r106.invoke(r100, new Object[]{r111});     // Catch: Throwable -> L45
    L43:
        Object r112 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L45
    L47:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r112);
        if (r109 == null) goto L50;
        FLogger.f375446a.w(TAG, "removeBottomSheetCallback failed", r109);
    L50:
        Result.m9448boximpl(r112);
    L51:
        r110.setCallbackInstallMode(CallbackInstallMode.NONE);
        return;
    L45:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L31:
        if (r106.getParameterTypes().length != 1) goto L35;
        if (r106.getParameterTypes()[0].isAssignableFrom(BottomSheetBehavior.BottomSheetCallback.class) == false) goto L35;
        r107 = true;
        goto L36
    L39:
        r106 = null;
        goto L53
    L8:
        if (r101 != 2) goto L10;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L19
        if (getSingleBottomSheetCallback(r100) != r111) goto L17;
        r100.setBottomSheetCallback(r110.getPreviousBehaviorCallback());     // Catch: Throwable -> L19
    L17:
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L24;
        FLogger.f375446a.w(TAG, "restoreBottomSheetCallback failed", r116);
    L24:
        Result.m9448boximpl(r115);
    L19:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L10:
        if (r101 != 3) goto L13;
        Unit r118 = Unit.INSTANCE;
        goto L51
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private final boolean hasFullHeightRequest(BoundsState r100, View r101) {
        if (r100.getHasObservedMatchParentHeight() == true) goto L14;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r102.height != (-1)) goto L9;
        r103 = true;
        goto L10
    L14:
        return true;
    }

    private final void installBehaviorCallback(BoundsState r100, BottomSheetBehavior<View> r101) {
        if (r100.getBehaviorCallback() == null) goto L5;
        return;
    L5:
        LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1 r102 = new LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1(r100);
        r100.setBehavior(r101);
        r100.setBehaviorCallback(r102);
        setBottomSheetCallback(r100, r102);
    }

    private final boolean isClassOrSuperclassNamed(Class<?> r100, String r101) {
    L2:
        if (r100 == null) goto L8;
        if (Intrinsics.areEqual(r100.getName(), r101) == true) goto L5;
        r100 = r100.getSuperclass();
        goto L2
    L5:
        return true;
    L8:
        return false;
    }

    @JvmStatic
    public static final void onDialogPreAddView(Dialog r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "trigger");
        if (r100 != null) goto L5;
    L7:
        if (r100 == null) goto L9;
        PreAddViewBoundsSession r102 = preAddViewBoundsSessions.get(r100);
    L10:
        if (r100 == null) goto L14;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r100 == null) goto L22;
        boolean r103 = false;
        if (r102 != null) goto L18;
    L20:
        if (r103 == false) goto L22;
        return;
    L18:
        if (r102.isConsumed() != true) goto L20;
        r103 = true;
    L22:
        PreAddViewBoundsApplyResult r104 = INSTANCE.applyPreAddViewBounds(r100, r101);
        if (r102 != null) goto L25;
        return;
    L25:
        if (r104 == PreAddViewBoundsApplyResult.SKIPPED) goto L29;
        r102.setConsumed(true);
        return;
    L29:
        return;
    L9:
        r102 = null;
        goto L10
    L5:
        if (INSTANCE.shouldDeferToBottomSheetOnStart(r100, r101) == false) goto L7;
    }

    private final void postSampleAndRestore(final BoundsState r100, final String r101) {
        View r102 = r100.getDecorRef().get();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.post(new b(r100, r101));
    }

    private static final void postSampleAndRestore$lambda$19(BoundsState r100, String r101) {
        r100.setSamplingEnabled(true);
        INSTANCE.sampleAndRestoreStableBounds(r100, r101);
    }

    private final void recordSheetLayoutRequest(BoundsState r100, View r101) {
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        if (r103 == false) goto L10;
        r100.setHasObservedMatchParentHeight(true);
        return;
    L10:
        return;
    L5:
        if (r102.height != (-1)) goto L7;
        r103 = true;
        goto L7
    }

    private final BottomSheetBehavior<View> resolveBottomSheetBehavior(BoundsState r100, View r101) {
        BottomSheetBehavior<View> r102 = r100.getBehavior();
        if (r102 != null) goto L9;
        BottomSheetBehavior<View> r103 = bottomSheetBehaviorResolver.invoke(r101);
        if (r103 == null) goto L7;
        r100.setBehavior(r103);
        return r103;
    L7:
        return null;
    L9:
        return r102;
    }

    private final int resolveBottomSheetDesiredContentHeight(View r100, Rect r110) {
        int r101 = r110.width();
        int r111 = r110.height();
        if (r101 <= 0) goto L46;
        if (r111 <= 0) goto L46;
        Integer r102 = Integer.valueOf(r100.getWidth());
        if (r102.intValue() <= 0) goto L9;
        boolean r103 = true;
    L10:
        ViewGroup.MarginLayoutParams r104 = null;
        if (r103 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L17;
        r101 = Math.min(r102.intValue(), r101);
    L17:
        if ((r100 instanceof ViewGroup) == false) goto L19;
        ViewGroup r105 = (ViewGroup) r100;
    L20:
        if (r105 == null) goto L22;
        View r106 = r105.getChildAt(0);
    L23:
        if (r106 == null) goto L45;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r104 = (ViewGroup.MarginLayoutParams) r107;
    L27:
        if (r104 == null) goto L29;
        int r108 = r104.leftMargin;
    L30:
        if (r104 == null) goto L32;
        int r109 = r104.rightMargin;
    L33:
        int r112 = r108 + r109;
        if (r104 == null) goto L36;
        int r113 = r104.topMargin;
    L37:
        if (r104 == null) goto L39;
        int r114 = r104.bottomMargin;
    L40:
        int r115 = r113 + r114;
        ViewGroup r116 = (ViewGroup) r100;
        int r117 = measureViewDesiredHeight(r106, RangesKt.coerceAtLeast(((r101 - r116.getPaddingLeft()) - r116.getPaddingRight()) - r112, 0), RangesKt.coerceAtLeast(((r111 - r116.getPaddingTop()) - r116.getPaddingBottom()) - r115, 0));
        if (r117 <= 0) goto L45;
        return ((r117 + r116.getPaddingTop()) + r116.getPaddingBottom()) + r115;
    L39:
        r114 = 0;
        goto L40
    L36:
        r113 = 0;
        goto L37
    L32:
        r109 = 0;
        goto L33
    L29:
        r108 = 0;
    L45:
        return measureViewDesiredHeight(r100, r101, r111);
    L22:
        r106 = null;
        goto L23
    L19:
        r105 = null;
        goto L20
    L9:
        r103 = false;
    L46:
        return 0;
    }

    private final int resolveHostCenterOffset(Rect r100, int r101) {
        return r100.centerX() - (r101 / 2);
    }

    private final int resolveMeasureHeight(int r100, int r101) {
        if (r100 > 0) goto L4;
        return r101;
    L4:
        return Math.min(r100, r101);
    }

    private final int resolveOverflowFitTargetBottom(Rect r100, Rect r101) {
        int r102 = r100.width();
        int r103 = r100.height();
        if (r100.top <= 0) goto L11;
        boolean r104 = true;
        if (Math.abs(r101.left) > 1) goto L11;
        if (Math.abs(r101.right - r102) > 1) goto L11;
        if (Math.abs(r101.bottom - r103) > 1) goto L11;
    L12:
        if (r104 == false) goto L15;
        return r103;
    L15:
        return r100.bottom;
    L11:
        r104 = false;
        goto L12
    }

    private final void restoreStableBounds(BoundsState r100, String r101) {
        if (r100.isHidden() == false) goto L5;
        return;
    L5:
        if (r100.isRestoring() == true) goto L17;
        r100.setRestoring(true);
        restoreStableSheetBounds(r100, r101);     // Catch: Throwable -> L11
        r100.setRestoring(false);
        return;
    L11:
        th = move-exception;
        r100.setRestoring(false);
        throw th;
    }

    private final void restoreStableSheetBounds(BoundsState r110, String r111) {
        if (r110.isStableInstalled() == true) goto L5;
        return;
    L5:
        if (isStrongStableMode(r110.getStableMode()) == true) goto L7;
        return;
    L7:
        if (r110.getStableGlobalTop() != Integer.MIN_VALUE) goto L9;
        return;
    L9:
        if (r110.getStableHeight() <= 0) goto L126;
        WeakReference<View> r100 = r110.getSheetRef();
        if (r100 == null) goto L125;
        View r101 = r100.get();
        if (r101 != null) goto L17;
        return;
    L17:
        if (isLayoutSamplingReason(r111) == false) goto L19;
        return;
    L19:
        Rect r102 = viewGlobalVisibleRectResolver.invoke(r101);
        if (r102 != null) goto L22;
        return;
    L22:
        int r103 = r110.getStableGlobalTop() - r102.top;
        boolean r104 = false;
        if (r103 <= 1) goto L25;
        boolean r105 = true;
    L26:
        int r106 = r102.height() - r110.getStableHeight();
        int r107 = r101.getHeight() - r110.getStableHeight();
        if (r106 <= 1) goto L29;
        boolean r112 = true;
    L30:
        if (r107 <= 1) goto L32;
        boolean r113 = true;
    L34:
        if (isUnsettledBottomSheetState(r110.getBehavior()) == false) goto L36;
    L39:
        boolean r114 = true;
    L41:
        if (r110.isHidden() == true) goto L52;
        BottomSheetBehavior<View> r115 = r110.getBehavior();
        if (r115 == null) goto L45;
        Integer r116 = Integer.valueOf(r115.getState());
    L47:
        if (isHiddenBottomSheetState(r116) == true) goto L52;
        if (isHiddenBottomSheetState(r110.getCurrentBehaviorState()) == true) goto L52;
        boolean r117 = false;
    L53:
        BottomSheetBehavior<View> r118 = r110.getBehavior();
        if (r118 != null) goto L56;
    L58:
        boolean r119 = false;
    L59:
        if (r119 == true) goto L74;
        Integer r120 = r110.getCurrentBehaviorState();
        if (r120 != null) goto L64;
    L65:
        BottomSheetBehavior<View> r121 = r110.getBehavior();
        if (r121 != null) goto L68;
    L70:
        boolean r122 = false;
    L71:
        if (r122 == true) goto L74;
        boolean r123 = false;
    L75:
        if (r114 == true) goto L78;
        if (r123 == false) goto L78;
        boolean r124 = true;
    L79:
        if (r124 == true) goto L81;
    L83:
        boolean r125 = false;
    L84:
        if (r124 == true) goto L86;
    L88:
        boolean r108 = false;
    L89:
        if (r124 == true) goto L91;
    L93:
        boolean r109 = false;
    L94:
        if (r105 == true) goto L98;
        if (r125 == true) goto L98;
        boolean r126 = false;
    L99:
        if (r112 == true) goto L105;
        if (r113 == true) goto L105;
        if (r108 == true) goto L105;
        if (r109 == true) goto L105;
        boolean r127 = false;
    L107:
        if (r110.getStableMode() != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L110;
        if (r105 == false) goto L110;
        r104 = true;
    L110:
        if (r117 == false) goto L112;
        return;
    L112:
        if (r114 == false) goto L115;
        if (r104 == true) goto L115;
        return;
    L115:
        if (r126 == true) goto L118;
        if (r127 == true) goto L118;
        return;
    L118:
        if (r127 == false) goto L120;
        syncSheetHeight(r101, r110.getStableHeight(), true);
    L120:
        int r128 = r101.getTop() + r103;
        r101.layout(r101.getLeft(), r128, r101.getRight(), r110.getStableHeight() + r128);
        FLogger.f375446a.i(TAG, "restore stable bounds, reason=" + r111 + ", top=" + r101.getTop() + ", height=" + r101.getHeight() + ", globalTop=" + r102.top + ", stableGlobalTop=" + r110.getStableGlobalTop() + ", stableHeight=" + r110.getStableHeight());
        return;
    L105:
        r127 = true;
    L98:
        r126 = true;
        goto L99
    L91:
        if (Math.abs(r107) <= 1) goto L93;
        r109 = true;
        goto L94
    L86:
        if (Math.abs(r106) <= 1) goto L88;
        r108 = true;
        goto L89
    L81:
        if (Math.abs(r103) <= 1) goto L83;
        r125 = true;
    L78:
        r124 = false;
        goto L79
    L68:
        if (r121.getSkipCollapsed() != true) goto L70;
        r122 = true;
        goto L71
    L64:
        if (r120.intValue() != 3) goto L65;
    L74:
        r123 = true;
        goto L75
    L56:
        if (r118.getState() != 3) goto L58;
        r119 = true;
        goto L59
    L45:
        r116 = null;
    L52:
        r117 = true;
        goto L53
    L36:
        if (isUnsettledBottomSheetState(r110.getCurrentBehaviorState()) == true) goto L39;
        r114 = false;
        goto L41
    L32:
        r113 = false;
        goto L34
    L29:
        r112 = false;
        goto L30
    L25:
        r105 = false;
        goto L26
    L125:
        return;
    }

    private final void sampleAndRestoreStableBounds(BoundsState r100, String r101) {
        Dialog r102 = r100.getDialogRef().get();
        if (r102 != null) goto L6;
        return;
    L6:
        if (states.get(r102) == r100) goto L8;
        return;
    L8:
        if (r100.isHidden() == false) goto L10;
        return;
    L10:
        if (r100.isRestoring() == false) goto L12;
        return;
    L12:
        if (r100.isSamplingEnabled() == false) goto L56;
        Rect r103 = resolveTargetChildDialogHostBounds(r102);
        if (r103 != null) goto L17;
        return;
    L17:
        r100.getHostBounds().set(r103);
        WeakReference<View> r104 = r100.getSheetRef();
        BottomSheetBehavior<View> r105 = null;
        if (r104 == null) goto L20;
        View r106 = r104.get();
    L21:
        if (r106 == null) goto L23;
        r105 = INSTANCE.resolveBottomSheetBehavior(r100, r106);
    L23:
        if (r105 == null) goto L25;
        r100.setCurrentBehaviorState(Integer.valueOf(r105.getState()));
        installBehaviorCallback(r100, r105);
    L25:
        if (r106 == null) goto L51;
        LandscapeChildDialogBoundsAdapter r107 = INSTANCE;
        r107.recordSheetLayoutRequest(r100, r106);
        if (r107.isLayoutSamplingReason(r101) == true) goto L29;
    L31:
        boolean r108 = false;
    L32:
        if (r108 == false) goto L36;
        if (r100.getStableMode() == BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L36;
    L40:
        if (r107.installOrRefreshOverflowFitToHostTarget(r100, r106, r105, r101) == false) goto L44;
        r107.restoreStableBounds(r100, r101);
        return;
    L44:
        if (r100.isStableInstalled() == true) goto L48;
        if (r108 == true) goto L51;
        r107.sampleStableBounds(r100, r106, r105, r101);
        goto L51
    L48:
        if (r107.isStrongStableMode(r100.getStableMode()) == true) goto L51;
        if (r108 == true) goto L51;
        r107.refreshStableBehavior(r100, r106, r105, r101);
    L36:
        if (r107.installOrRefreshSettledFullHeightTarget(r100, r106, r105, r101) == false) goto L40;
        r107.restoreStableBounds(r100, r101);
        return;
    L29:
        if (r107.hasFullHeightExpandedIntent(r100, r106, r105) == false) goto L31;
        r108 = true;
    L51:
        restoreStableBounds(r100, r101);
        return;
    L20:
        r106 = null;
        goto L21
    }

    private final void setBottomSheetCallback(BoundsState r110, final BottomSheetBehavior.BottomSheetCallback r111) {
        BottomSheetBehavior<View> r100 = r110.getBehavior();
        if (r100 != null) goto L5;
        return;
    L5:
        Method[] r101 = r100.getClass().getMethods();
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L19;
        Method r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getName(), "addBottomSheetCallback") == true) goto L11;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == true) goto L21;
        r103 = r103 + 1;
    L21:
        if (r104 != null) goto L41;
    L32:
        final BottomSheetBehavior.BottomSheetCallback r106 = getSingleBottomSheetCallback(r100);
        r110.setPreviousBehaviorCallback(r106);
        BottomSheetBehavior.BottomSheetCallback r107 = new LandscapeChildDialogBoundsAdapter$setBottomSheetCallback$chainedCallback$1(r106, r111);
        r110.setBehaviorCallback(r107);
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L35
        r100.setBottomSheetCallback(r107);     // Catch: Throwable -> L35
        r110.setCallbackInstallMode(CallbackInstallMode.SET_SINGLE);     // Catch: Throwable -> L35
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);
        if (r112 == null) goto L47;
        r110.setBehaviorCallback(r111);
        FLogger.f375446a.w(TAG, "setBottomSheetCallback failed", r112);
        return;
    L47:
        return;
    L35:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    L41:
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L24
        r104.invoke(r100, new Object[]{r111});     // Catch: Throwable -> L24
        r110.setCallbackInstallMode(CallbackInstallMode.ADD_REMOVE);     // Catch: Throwable -> L24
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L30;
        FLogger.f375446a.w(TAG, "addBottomSheetCallback failed", r116);
    L30:
        if (r110.getCallbackInstallMode() != CallbackInstallMode.ADD_REMOVE) goto L32;
        return;
    L24:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L11:
        if (r104.getParameterTypes().length != 1) goto L15;
        if (r104.getParameterTypes()[0].isAssignableFrom(BottomSheetBehavior.BottomSheetCallback.class) == false) goto L15;
        r105 = true;
        goto L16
    L19:
        r104 = null;
        goto L21
    }

    private final void setExpandedOffsetCompat(BottomSheetBehavior<View> r110, int r111) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L19
        Method[] r101 = r110.getClass().getMethods();     // Catch: Throwable -> L19
        int r102 = r101.length;     // Catch: Throwable -> L19
        int r103 = 0;
    L3:
        Object r104 = null;
        if (r103 >= r102) goto L14;
        Method r105 = r101[r103];     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(r105.getName(), "setExpandedOffset") == true) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == true) goto L15;
        r103 = r103 + 1;     // Catch: Throwable -> L19
    L15:
        if (r105 == null) goto L17;
        r104 = r105.invoke(r110, new Object[]{Integer.valueOf(r111)});     // Catch: Throwable -> L19
    L17:
        Object r112 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L19
    L21:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L29;
        FLogger.f375446a.w(TAG, "setExpandedOffsetCompat failed", r113);
        return;
    L29:
        return;
    L8:
        if (Arrays.equals(r105.getParameterTypes(), new Class[]{Integer.TYPE}) == false) goto L10;
        r106 = true;
        goto L11
    L14:
        r105 = null;
    L19:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final void setMaxHeightCompat(BottomSheetBehavior<View> r110, int r111) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L19
        Method[] r101 = r110.getClass().getMethods();     // Catch: Throwable -> L19
        int r102 = r101.length;     // Catch: Throwable -> L19
        int r103 = 0;
    L3:
        Object r104 = null;
        if (r103 >= r102) goto L14;
        Method r105 = r101[r103];     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(r105.getName(), "setMaxHeight") == true) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == true) goto L15;
        r103 = r103 + 1;     // Catch: Throwable -> L19
    L15:
        if (r105 == null) goto L17;
        r104 = r105.invoke(r110, new Object[]{Integer.valueOf(r111)});     // Catch: Throwable -> L19
    L17:
        Object r112 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L19
    L21:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L29;
        FLogger.f375446a.w(TAG, "setMaxHeightCompat failed", r113);
        return;
    L29:
        return;
    L8:
        if (Arrays.equals(r105.getParameterTypes(), new Class[]{Integer.TYPE}) == false) goto L10;
        r106 = true;
        goto L11
    L14:
        r105 = null;
    L19:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final boolean shouldDeferToBottomSheetOnStart(Dialog r100, String r101) {
        if (Intrinsics.areEqual(r101, "componentDialog:onStart") == true) goto L5;
    L7:
        return false;
    L5:
        if (isMaterialBottomSheetDialog(r100) == false) goto L7;
        return true;
    }

    public final void dispatchStateForTest$impl_mainlandRelease(Dialog r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        BoundsState r102 = states.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        WeakReference<View> r103 = r102.getSheetRef();
        if (r103 == null) goto L14;
        View r104 = r103.get();
        if (r104 == null) goto L16;
        BottomSheetBehavior.BottomSheetCallback r105 = r102.getBehaviorCallback();
        if (r105 == null) goto L15;
        r105.onStateChanged(r104, r101);
        return;
    L15:
        return;
    L16:
        return;
    }

    public static final /* synthetic */ void access$restoreStableBounds(LandscapeChildDialogBoundsAdapter r100, BoundsState r101, String r102) {
        r100.restoreStableBounds(r101, r102);
    }

    public static final /* synthetic */ void access$sampleAndRestoreStableBounds(LandscapeChildDialogBoundsAdapter r100, BoundsState r101, String r102) {
        r100.sampleAndRestoreStableBounds(r101, r102);
    }

    private final boolean hasFullHeightExpandedIntent(BoundsState r100, View r101, BottomSheetBehavior<View> r102) {
        if (hasFullHeightRequest(r100, r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (isExpandedOrSkipCollapsed(r102) == false) goto L7;
        return true;
    }

    private final int measureViewDesiredHeight(View r100, int r101, int r102) {
        if (r101 <= 0) goto L29;
        if (r102 <= 0) goto L31;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L18
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();     // Catch: Throwable -> L18
        if (r104 == null) goto L9;
        int r105 = r104.height;     // Catch: Throwable -> L18
    L10:
        if (r105 <= 0) goto L13;
        r102 = Math.min(r105, r102);     // Catch: Throwable -> L18
    L13:
        if (r105 <= 0) goto L15;
        int r106 = 1073741824;
    L16:
        r100.measure(View.MeasureSpec.makeMeasureSpec(r101, 1073741824), View.MeasureSpec.makeMeasureSpec(r102, r106));     // Catch: Throwable -> L18
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(r100.getMeasuredHeight()));     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r107) == false) goto L23;
        r107 = null;
    L23:
        Integer r108 = (Integer) r107;
        if (r108 != null) goto L26;
        return 0;
    L26:
        return r108.intValue();
    L15:
        r106 = Integer.MIN_VALUE;
        goto L16
    L9:
        r105 = -2;
    L18:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L31:
        return 0;
    L29:
        return 0;
    }

    private final Integer measureViewWidth(View r100, int r101, int r102) {
        Object r103 = null;
        if (r100 != null) goto L15;
        return null;
    L15:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        r100.measure(r101, r102);     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(r100.getMeasuredWidth()));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r105) == true) goto L14;
        r103 = r105;
    L14:
        return (Integer) r103;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final int measureWrapContentWidth(Window r100, WindowManager.LayoutParams r101, Rect r102) {
        int r103 = r102.width();
        int r104 = r102.height();
        if (r103 <= 0) goto L40;
        if (r104 <= 0) goto L42;
        int r105 = Integer.MIN_VALUE;
        int r106 = View.MeasureSpec.makeMeasureSpec(r103, Integer.MIN_VALUE);
        int r107 = resolveMeasureHeight(r101.height, r104);
        if (r101.height <= 0) goto L9;
        r105 = 1073741824;
    L9:
        int r108 = View.MeasureSpec.makeMeasureSpec(r107, r105);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L12
        Object r110 = Result.m9449constructorimpl(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100));     // Catch: Throwable -> L12
    L14:
        ViewGroup r111 = null;
        if (Result.m9455isFailureimpl(r110) == false) goto L17;
        r110 = null;
    L17:
        View r112 = (View) r110;
        if (r112 == null) goto L20;
        r111 = (ViewGroup) r112.findViewById(android.R.id.content);
    L20:
        List r113 = CollectionsKt.listOfNotNull(new Integer[]{measureViewWidth(r112, r106, r108), measureViewWidth(r111, r106, r108)});
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
    L22:
        if (r115.hasNext() == false) goto L29;
        Object r116 = r115.next();
        if (((Number) r116).intValue() <= 0) goto L26;
        boolean r117 = true;
    L27:
        if (r117 == false) goto L22;
        r114.add(r116);
        goto L22
    L26:
        r117 = false;
        goto L27
    L29:
        Integer r118 = (Integer) CollectionsKt.maxOrNull(r114);
        if (r118 != null) goto L32;
        return 0;
    L32:
        return r118.intValue();
    L12:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L42:
        return 0;
    L40:
        return 0;
    }

    private final void normalizeStableSheetBounds(BoundsState r100, View r101, String r102) {
        if (r100.getHasNormalizedStableBounds() == false) goto L5;
        return;
    L5:
        if (r100.isStableInstalled() == true) goto L7;
        return;
    L7:
        if (isStrongStableMode(r100.getStableMode()) == true) goto L9;
        return;
    L9:
        if (r100.getStableGlobalTop() != Integer.MIN_VALUE) goto L11;
        return;
    L11:
        if (r100.getStableHeight() <= 0) goto L48;
        Rect r103 = viewGlobalVisibleRectResolver.invoke(r101);
        if (r103 != null) goto L16;
        return;
    L16:
        Integer r104 = Integer.valueOf(r103.height());
        boolean r105 = false;
        if (r104.intValue() <= 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == true) goto L23;
        r104 = null;
    L23:
        if (r104 == null) goto L25;
        int r107 = r104.intValue();
    L26:
        int r108 = r100.getStableGlobalTop() - r103.top;
        if (Math.abs(r108) <= 1) goto L29;
        boolean r109 = true;
    L31:
        if (Math.abs(r107 - r100.getStableHeight()) <= 1) goto L33;
    L34:
        r105 = true;
    L35:
        if (r109 == true) goto L40;
        if (r105 == true) goto L40;
        r100.setHasNormalizedStableBounds(true);
        return;
    L40:
        if (isLayoutSamplingReason(r102) == false) goto L42;
        return;
    L42:
        syncSheetHeight(r101, r100.getStableHeight(), true);
        int r110 = r101.getTop() + r108;
        r101.layout(r101.getLeft(), r110, r101.getRight(), r100.getStableHeight() + r110);
        r100.setHasNormalizedStableBounds(true);
        return;
    L33:
        if (Math.abs(r101.getHeight() - r100.getStableHeight()) <= 1) goto L35;
    L29:
        r109 = false;
        goto L31
    L25:
        r107 = r101.getHeight();
        goto L26
    L19:
        r106 = false;
        goto L20
    }

    private final HorizontalBounds resolveOnStartHorizontalBounds(Window r100, WindowManager.LayoutParams r101, Rect r102) {
        int r103 = r102.width();
        Integer r104 = screenWidthResolver.invoke(r100);
        if (r104 == null) goto L24;
        int r105 = r104.intValue();
        if (r103 <= 0) goto L24;
        if (r105 <= 0) goto L24;
        int r106 = resolveHostCenterOffset(r102, r105);
        SizeRequestMode r107 = resolveSizeRequestMode(Integer.valueOf(r101.width));
        if (Intrinsics.areEqual(r107, SizeRequestMode.MatchParent.INSTANCE) == false) goto L12;
        return new HorizontalBounds(r103, r106);
    L12:
        if ((r107 instanceof SizeRequestMode.Fixed) == false) goto L16;
        HorizontalBounds r108 = new HorizontalBounds(Math.min(((SizeRequestMode.Fixed) r107).getSize(), r103), r106);
    L26:
        return r108;
    L16:
        if (Intrinsics.areEqual(r107, SizeRequestMode.WrapContent.INSTANCE) == false) goto L23;
        int r109 = measureWrapContentWidth(r100, r101, r102);
        if (r109 <= 0) goto L21;
        r108 = new HorizontalBounds(Math.min(r109, r103), r106);
        goto L26
    L21:
        return new HorizontalBounds(-2, r106);
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        return null;
    }

    private final StableSheetTarget resolveOverflowFitToHostTarget(BoundsState r100, View r110, BottomSheetBehavior<View> r111) {
        Rect r101 = r100.getHostBounds();
        boolean r102 = false;
        if (r101.isEmpty() == false) goto L5;
    L9:
        boolean r103 = false;
    L11:
        if (r103 == true) goto L14;
        r101 = null;
    L14:
        if (r101 != null) goto L16;
        return null;
    L16:
        int r104 = r101.height();
        Rect r105 = viewGlobalVisibleRectResolver.invoke(r110);
        if (r105 != null) goto L19;
    L56:
        return null;
    L19:
        if ((!r105.isEmpty()) == true) goto L22;
        r105 = null;
    L22:
        if (r105 == null) goto L56;
        Integer r106 = Integer.valueOf(r105.height());
        if (r106.intValue() <= 0) goto L27;
        boolean r107 = true;
    L28:
        if (r107 == true) goto L31;
        r106 = null;
    L31:
        if (r106 == null) goto L33;
        int r108 = r106.intValue();
    L34:
        if (r108 > 0) goto L36;
        return null;
    L36:
        int r109 = resolveBottomSheetDesiredContentHeight(r110, r101);
        if (r109 > 0) goto L39;
        return null;
    L39:
        int r112 = Math.min(r109, r104);
        if (r112 > 0) goto L43;
        return null;
    L43:
        if (r100.getStableMode() != BottomSheetStableMode.OVERFLOW_FIT_TO_HOST) goto L45;
        r102 = true;
    L45:
        if (r102 == false) goto L47;
    L49:
        int r113 = resolveOverflowFitTargetBottom(r101, r105);
        if (r102 == false) goto L52;
    L54:
        int r114 = r113 - r112;
        return new StableSheetTarget(r114, r114 - (r105.top - r110.getTop()), r112);
    L52:
        if (canExpandOverflowSheet(r105, r101, r111, r112) == true) goto L54;
        return null;
    L47:
        if (r112 > (r108 + 1)) goto L49;
        return null;
    L33:
        r108 = r110.getHeight();
        goto L34
    L27:
        r107 = false;
        goto L28
    L5:
        if (r101.width() <= 0) goto L9;
        if (r101.height() <= 0) goto L9;
        r103 = true;
        goto L11
    }

    private final StableSheetTarget resolveSettledFullHeightTarget(BoundsState r100, View r101, BottomSheetBehavior<View> r102) {
        if (hasFullHeightExpandedIntent(r100, r101, r102) == true) goto L5;
        return null;
    L5:
        if (isUnsettledBottomSheetState(r102) == false) goto L8;
        return null;
    L8:
        if (r100.isStableInstalled() == false) goto L14;
        if (r100.getStableMode() != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L14;
        return new StableSheetTarget(r100.getStableGlobalTop(), r100.getStableLocalTop(), r100.getStableHeight());
    L14:
        return resolveSettledSheetStableTarget(r101);
    }

    private final boolean shouldApplyFullHeightExpandedParams(BoundsState r100, View r101, BottomSheetBehavior<View> r102) {
        if (r100.getStableHeight() > 0) goto L6;
        return false;
    L6:
        if (hasFullHeightExpandedIntent(r100, r101, r102) == true) goto L8;
        return false;
    L8:
        if (isUnsettledBottomSheetState(r102) == true) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean shouldPromoteCurrentLayoutToFullHeight(BoundsState r100, View r101, BottomSheetBehavior<View> r102) {
        if (r100.getStableMode() != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L5;
        return false;
    L5:
        if (hasFullHeightExpandedIntent(r100, r101, r102) == true) goto L7;
        return false;
    L7:
        if (isUnsettledBottomSheetState(r102) == true) goto L28;
        Rect r103 = viewGlobalVisibleRectResolver.invoke(r101);
        if (r103 != null) goto L12;
        return false;
    L12:
        Integer r104 = Integer.valueOf(r103.height());
        if (r104.intValue() <= 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L19;
        r104 = null;
    L19:
        if (r104 == null) goto L21;
        int r106 = r104.intValue();
    L22:
        if (r106 <= 0) goto L27;
        return true;
    L27:
        return false;
    L21:
        r106 = r101.getHeight();
        goto L22
    L15:
        r105 = false;
        goto L16
    L28:
        return false;
    }

    private final void syncSheetHeight(View r100, int r101, boolean r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 != null) goto L6;
        return;
    L6:
        if (r103.height != r101) goto L10;
        if (r102 == false) goto L12;
        r100.requestLayout();
        return;
    L12:
        return;
    L10:
        r103.height = r101;
        r100.setLayoutParams(r103);
        r100.requestLayout();
    }

    private final void updateStableBoundsFromCurrentLayout(BoundsState r100, View r101, String r102) {
        if (r100.getStableMode() == BottomSheetStableMode.NONE) goto L5;
        return;
    L5:
        Rect r103 = viewGlobalVisibleRectResolver.invoke(r101);
        if (r103 != null) goto L8;
        return;
    L8:
        Integer r104 = Integer.valueOf(r103.height());
        if (r104.intValue() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L17;
        int r106 = r104.intValue();
    L19:
        if (r103.top == Integer.MIN_VALUE) goto L29;
        if (r106 > 0) goto L23;
        return;
    L23:
        if (r100.getStableGlobalTop() == r103.top) goto L25;
    L27:
        r100.setStableGlobalTop(r103.top);
        r100.setStableLocalTop(r101.getTop());
        r100.setStableHeight(r106);
        FLogger.f375446a.i(TAG, "refresh stable bounds for full height sheet, reason=" + r102 + ", dialog=" + r100.getDialogRef().get() + ", globalTop=" + r100.getStableGlobalTop() + ", localTop=" + r100.getStableLocalTop() + ", height=" + r100.getStableHeight());
        return;
    L25:
        if (r100.getStableHeight() != r106) goto L27;
        return;
    L29:
        return;
    L17:
        r106 = r101.getHeight();
        goto L19
    L11:
        r105 = false;
        goto L12
    }

    private final void applyFullHeightExpandedParams(BoundsState r100, View r101, BottomSheetBehavior<View> r102, boolean r110) {
        syncSheetHeight$default(this, r101, r100.getStableHeight(), false, 4, null);
        if (r102 == null) goto L41;
        INSTANCE.setMaxHeightCompat(r102, r100.getStableHeight());
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        r102.setPeekHeight(r100.getStableHeight());     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L39;
        FLogger.f375446a.w(TAG, "setPeekHeight failed", r105);
    L39:
        r102.setSkipCollapsed(true);     // Catch: Throwable -> L15
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L21;
        FLogger.f375446a.w(TAG, "setSkipCollapsed failed", r107);
    L21:
        if (r102.isFitToContents() == false) goto L23;
    L25:
        if (r110 == true) goto L37;
        return;
    L37:
        r102.setState(3);     // Catch: Throwable -> L29
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L43;
        FLogger.f375446a.w(TAG, "setExpandedState failed", r109);
        return;
    L43:
        return;
    L29:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L23:
        if (r100.getStableLocalTop() == Integer.MIN_VALUE) goto L25;
        INSTANCE.setExpandedOffsetCompat(r102, r100.getStableLocalTop());
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    private final void applyOverflowFitToHostParams(BoundsState r100, View r101, BottomSheetBehavior<View> r102, boolean r110) {
        syncSheetHeight$default(this, r101, r100.getStableHeight(), false, 4, null);
        setMaxHeightCompat(r102, r100.getStableHeight());
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        r102.setPeekHeight(r100.getStableHeight());     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L11;
        FLogger.f375446a.w(TAG, "setOverflowPeekHeight failed", r105);
    L11:
        if (r102.isFitToContents() == false) goto L13;
    L15:
        if (r110 == true) goto L25;
        return;
    L25:
        r102.setState(3);     // Catch: Throwable -> L19
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L30;
        FLogger.f375446a.w(TAG, "setOverflowExpandedState failed", r107);
        return;
    L30:
        return;
    L19:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L13:
        if (r100.getStableLocalTop() == Integer.MIN_VALUE) goto L15;
        setExpandedOffsetCompat(r102, r100.getStableLocalTop());
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final boolean canExpandOverflowSheet(Rect r100, Rect r101, BottomSheetBehavior<View> r102, int r103) {
        if (r100.top <= (r101.top + 1)) goto L5;
        return true;
    L5:
        int r104 = r102.getState();
        if (r104 != 4) goto L8;
        return true;
    L8:
        if (r104 == 6) goto L19;
        int r105 = r102.getPeekHeight();
        if (1 > r105) goto L13;
        if (r105 >= r103) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L20;
        return false;
    L20:
        return true;
    L13:
        r106 = false;
        goto L14
    L19:
        return true;
    }

    private final boolean installOrRefreshOverflowFitToHostTarget(BoundsState r100, View r101, BottomSheetBehavior<View> r102, String r103) {
        boolean r104 = false;
        if (r100.getStableMode() == BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L38;
        if (r102 == null) goto L38;
        if (hasFullHeightExpandedIntent(r100, r101, r102) == true) goto L38;
        if (isUnsettledBottomSheetState(r102) == true) goto L38;
        if (isHiddenBottomSheetState(Integer.valueOf(r102.getState())) == true) goto L38;
        if (isHiddenBottomSheetState(r100.getCurrentBehaviorState()) == true) goto L38;
        StableSheetTarget r105 = resolveOverflowFitToHostTarget(r100, r101, r102);
        if (r105 != null) goto L18;
        return false;
    L18:
        if (r100.isStableInstalled() == true) goto L20;
    L29:
        boolean r106 = true;
    L30:
        if (r106 == false) goto L32;
        r100.setStableGlobalTop(r105.getGlobalTop());
        r100.setStableLocalTop(r105.getLocalTop());
        r100.setStableHeight(r105.getHeight());
        r100.setWarmUpSamples(3);
        r100.setStableInstalled(true);
        r100.setStableMode(BottomSheetStableMode.OVERFLOW_FIT_TO_HOST);
        r100.setHasNormalizedStableBounds(false);
    L32:
        if (r106 == false) goto L34;
    L35:
        r104 = true;
    L36:
        applyOverflowFitToHostParams(r100, r101, r102, r104);
        normalizeStableSheetBounds(r100, r101, r103);
        return true;
    L34:
        if (isUnsettledBottomSheetState(r102) == true) goto L36;
    L20:
        if (r100.getStableMode() != BottomSheetStableMode.OVERFLOW_FIT_TO_HOST) goto L29;
        if (r100.getStableGlobalTop() != r105.getGlobalTop()) goto L29;
        if (r100.getStableLocalTop() != r105.getLocalTop()) goto L29;
        if (r100.getStableHeight() != r105.getHeight()) goto L29;
        r106 = false;
    L38:
        return false;
    }

    private final boolean installOrRefreshSettledFullHeightTarget(BoundsState r100, View r101, BottomSheetBehavior<View> r102, String r103) {
        boolean r104 = false;
        if (isUnsettledBottomSheetState(r102) == false) goto L5;
        return false;
    L5:
        StableSheetTarget r105 = resolveSettledFullHeightTarget(r100, r101, r102);
        if (r105 != null) goto L9;
        return false;
    L9:
        if (r100.isStableInstalled() == true) goto L11;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
        r100.setStableGlobalTop(r105.getGlobalTop());
        r100.setStableLocalTop(r105.getLocalTop());
        r100.setStableHeight(r105.getHeight());
        r100.setWarmUpSamples(3);
        r100.setStableInstalled(true);
        r100.setStableMode(BottomSheetStableMode.FULL_HEIGHT_EXPANDED);
        r100.setHasNormalizedStableBounds(false);
    L23:
        if (r106 == false) goto L25;
    L26:
        r104 = true;
    L27:
        applyFullHeightExpandedParams(r100, r101, r102, r104);
        normalizeStableSheetBounds(r100, r101, r103);
        return true;
    L25:
        if (isUnsettledBottomSheetState(r102) == true) goto L27;
    L11:
        if (r100.getStableMode() != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L20;
        if (r100.getStableGlobalTop() != r105.getGlobalTop()) goto L20;
        if (r100.getStableLocalTop() != r105.getLocalTop()) goto L20;
        if (r100.getStableHeight() != r105.getHeight()) goto L20;
        r106 = false;
        goto L21
    }

    private final void refreshStableBehavior(BoundsState r110, View r111, BottomSheetBehavior<View> r112, String r113) {
        if (r110.getStableHeight() > 0) goto L5;
        return;
    L5:
        if (r112 == null) goto L8;
        INSTANCE.installBehaviorCallback(r110, r112);
    L8:
        if (isUnsettledBottomSheetState(r112) == false) goto L11;
        return;
    L11:
        if (shouldPromoteCurrentLayoutToFullHeight(r110, r111, r112) == false) goto L14;
        updateStableBoundsFromCurrentLayout(r110, r111, r113);
    L14:
        if (shouldApplyFullHeightExpandedParams(r110, r111, r112) == true) goto L16;
        return;
    L16:
        BottomSheetStableMode r100 = r110.getStableMode();
        BottomSheetStableMode r101 = BottomSheetStableMode.FULL_HEIGHT_EXPANDED;
        if (r100 != r101) goto L19;
        boolean r102 = true;
    L20:
        updateStableBoundsFromCurrentLayout(r110, r111, r113);
        r110.setStableMode(r101);
        applyFullHeightExpandedParams$default(this, r110, r111, r112, false, 8, null);
        if (r102 == true) goto L23;
        normalizeStableSheetBounds(r110, r111, r113);
    L23:
        FLogger.f375446a.i(TAG, "activate full height stable behavior, reason=" + r113 + ", dialog=" + r110.getDialogRef().get() + ", stableTop=" + r110.getStableGlobalTop() + ", stableHeight=" + r110.getStableHeight());
        return;
    L19:
        r102 = false;
        goto L20
    }

    private final void sampleStableBounds(BoundsState r100, View r110, BottomSheetBehavior<View> r111, String r112) {
        if (r100.isStableInstalled() == false) goto L5;
        return;
    L5:
        if (r100.getWarmUpSamples() < 3) goto L8;
        return;
    L8:
        if (isUnsettledBottomSheetState(r111) == false) goto L10;
        return;
    L10:
        Rect r101 = viewGlobalVisibleRectResolver.invoke(r110);
        if (r101 != null) goto L13;
        return;
    L13:
        Integer r102 = Integer.valueOf(r101.height());
        boolean r103 = false;
        if (r102.intValue() <= 0) goto L16;
        boolean r104 = true;
    L17:
        if (r104 == true) goto L20;
        r102 = null;
    L20:
        if (r102 == null) goto L22;
        int r105 = r102.intValue();
    L24:
        if (r101.top == Integer.MIN_VALUE) goto L44;
        if (r105 > 0) goto L28;
        return;
    L28:
        if (r100.getStableGlobalTop() != Integer.MIN_VALUE) goto L30;
    L31:
        r100.setStableGlobalTop(r101.top);
        r100.setStableLocalTop(r110.getTop());
        r103 = true;
    L33:
        if (r100.getStableHeight() > 0) goto L35;
    L36:
        r100.setStableHeight(r105);
        r103 = true;
    L37:
        r100.setWarmUpSamples(r100.getWarmUpSamples() + 1);
        if (r100.getWarmUpSamples() >= 3) goto L41;
        FLogger.f375446a.i(TAG, "warm up stable bounds, reason=" + r112 + ", samples=" + r100.getWarmUpSamples() + ", globalTop=" + r100.getStableGlobalTop() + ", localTop=" + r100.getStableLocalTop() + ", height=" + r100.getStableHeight() + ", changed=" + r103);
        return;
    L41:
        r100.setStableInstalled(true);
        refreshStableBehavior(r100, r110, r111, r112);
        FLogger.f375446a.i(TAG, "install stable bounds, reason=" + r112 + ", dialog=" + r100.getDialogRef().get() + ", globalTop=" + r100.getStableGlobalTop() + ", localTop=" + r100.getStableLocalTop() + ", height=" + r100.getStableHeight() + ", stableMode=" + r100.getStableMode());
        return;
    L35:
        if (r105 >= r100.getStableHeight()) goto L37;
    L30:
        if (r101.top <= r100.getStableGlobalTop()) goto L33;
    L44:
        return;
    L22:
        r105 = r110.getHeight();
        goto L24
    L16:
        r104 = false;
        goto L17
    }

    public static /* synthetic */ void syncSheetHeight$default(LandscapeChildDialogBoundsAdapter r100, View r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.syncSheetHeight(r101, r102, r103);
    }

    public static /* synthetic */ void applyFullHeightExpandedParams$default(LandscapeChildDialogBoundsAdapter r100, BoundsState r101, View r102, BottomSheetBehavior r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = true;
    L5:
        r100.applyFullHeightExpandedParams(r101, r102, r103, r104);
    }

    public static /* synthetic */ void applyOverflowFitToHostParams$default(LandscapeChildDialogBoundsAdapter r100, BoundsState r101, View r102, BottomSheetBehavior r103, boolean r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L5;
        r104 = true;
    L5:
        r100.applyOverflowFitToHostParams(r101, r102, r103, r104);
    }

    private static final void installStableListeners$lambda$20(BoundsState r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        INSTANCE.sampleAndRestoreStableBounds(r100, "layout");
    }
}
