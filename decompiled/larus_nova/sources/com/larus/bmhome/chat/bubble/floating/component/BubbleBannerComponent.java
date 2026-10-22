package com.larus.bmhome.chat.bubble.floating.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerState;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import com.larus.bmhome.chat.bubble.floating.runtime.k;
import com.larus.bmhome.chat.bubble.floating.runtime.l;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.fastsend.e0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachRejectReason;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ns9.t;
import pc8.j;
import qc8.m;
import qc8.n;
import qc8.o;
import qc8.p;
import qc8.q;
import tc8.r;
import tc8.u;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0089\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0017*\u00014\u0018\u0000 Ñ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0010Ê\u0001Ë\u0001Ì\u0001Í\u0001Î\u0001Ï\u0001Ð\u0001Ñ\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020IH\u0016J\b\u0010K\u001a\u00020IH\u0016J\u0010\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020\u0017H\u0016J\b\u0010N\u001a\u00020IH\u0016J\u0010\u0010O\u001a\u00020I2\u0006\u0010P\u001a\u00020\rH\u0016J\u0010\u0010Q\u001a\u00020I2\u0006\u0010P\u001a\u00020\rH\u0002J\u0010\u0010R\u001a\u00020I2\u0006\u0010P\u001a\u00020\rH\u0002J\n\u0010S\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010T\u001a\u00020I2\u0006\u0010P\u001a\u00020\rH\u0002J\u0010\u0010U\u001a\u00020I2\u0006\u0010P\u001a\u00020\rH\u0002J\b\u0010V\u001a\u00020IH\u0002J\b\u0010W\u001a\u00020IH\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010P\u001a\u00020\rH\u0002J\u0010\u0010Z\u001a\u00020I2\u0006\u0010[\u001a\u00020YH\u0002J\u0010\u0010\\\u001a\u00020I2\u0006\u0010[\u001a\u00020YH\u0002J\u0010\u0010]\u001a\u00020I2\u0006\u0010[\u001a\u00020YH\u0002J\u0012\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010[\u001a\u00020YH\u0002J\u0010\u0010`\u001a\u00020+2\u0006\u0010[\u001a\u00020YH\u0002J\u0018\u0010a\u001a\u00020I2\u0006\u0010M\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u0017H\u0002J(\u0010c\u001a\u00020I2\u0006\u0010[\u001a\u00020Y2\u0006\u0010b\u001a\u00020\u00172\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020fH\u0002J\u0018\u0010g\u001a\u00020I2\u0006\u0010[\u001a\u00020Y2\u0006\u0010b\u001a\u00020\u0017H\u0002J\u0018\u0010h\u001a\u00020+2\u0006\u0010M\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\rH\u0002J(\u0010j\u001a\u00020I2\u0006\u0010[\u001a\u00020Y2\u0006\u0010M\u001a\u00020\u00172\u0006\u0010b\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\rH\u0002Jb\u0010k\u001a\u00020I2\u0006\u0010[\u001a\u00020Y2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020\r2\u0006\u0010b\u001a\u00020\u00172\u0006\u0010q\u001a\u00020f2\u0006\u0010r\u001a\u00020f2\u0006\u0010s\u001a\u00020f2\u0006\u0010t\u001a\u00020f2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020I0vH\u0002J\u0018\u0010w\u001a\u0004\u0018\u00010m*\u0004\u0018\u00010m2\u0006\u0010[\u001a\u00020YH\u0002J8\u0010x\u001a\u00020I2\u0006\u0010b\u001a\u00020\u00172\u0006\u0010q\u001a\u00020f2\u0006\u0010r\u001a\u00020f2\u0006\u0010s\u001a\u00020f2\u0006\u0010t\u001a\u00020f2\u0006\u0010y\u001a\u00020fH\u0002J\u000e\u0010y\u001a\u00020f*\u0004\u0018\u00010mH\u0002J\u0016\u0010z\u001a\u00020{*\u0004\u0018\u00010m2\u0006\u0010y\u001a\u00020fH\u0002J\u0010\u0010|\u001a\u00020I2\u0006\u0010[\u001a\u00020YH\u0002J\b\u0010}\u001a\u00020IH\u0002J\u0012\u0010~\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u007f\u001a\u00020\u0011H\u0002J\u0019\u0010\u0080\u0001\u001a\u00020I2\u0006\u0010M\u001a\u00020\u00172\u0006\u0010[\u001a\u00020YH\u0002J\u001a\u0010\u0081\u0001\u001a\u00020I2\u0006\u0010M\u001a\u00020\u00172\u0007\u0010\u0082\u0001\u001a\u00020\rH\u0002J\u0012\u0010\u0083\u0001\u001a\u00020+2\u0007\u0010\u0082\u0001\u001a\u00020\rH\u0002J\u0015\u0010\u0084\u0001\u001a\u00020I*\u00020\u00172\u0006\u0010[\u001a\u00020YH\u0002J&\u0010\u0085\u0001\u001a\u00020+2\u0007\u0010\u0086\u0001\u001a\u00020\u00172\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J8\u0010\u008b\u0001\u001a\u00020+2\u0007\u0010\u0086\u0001\u001a\u00020\u00172\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010[\u001a\u00020Y2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J'\u0010\u008e\u0001\u001a\u00020I2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\u001c\u0010\u008f\u0001\u001a\u00020+2\u0007\u0010\u0086\u0001\u001a\u00020\u00172\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0002J\u0012\u0010\u0090\u0001\u001a\u00020+2\u0007\u0010\u0086\u0001\u001a\u00020\u0017H\u0002J\u001a\u0010\u0091\u0001\u001a\u00020I2\u0006\u0010M\u001a\u00020\u00172\u0007\u0010\u0082\u0001\u001a\u00020\rH\u0002J\u001e\u0010\u0092\u0001\u001a\u00020I2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00172\b\u0010b\u001a\u0004\u0018\u00010\u0017H\u0002J\t\u0010\u0094\u0001\u001a\u00020IH\u0002J\u001a\u0010\u0095\u0001\u001a\u00020I2\u0006\u0010[\u001a\u00020Y2\u0007\u0010\u0096\u0001\u001a\u00020\rH\u0002J\f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0002J\u000b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J\u000b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0011H\u0002J\u0011\u0010\u009b\u0001\u001a\u00020I2\u0006\u0010\u007f\u001a\u00020\u0011H\u0002J\u0011\u0010\u009c\u0001\u001a\u00020I2\u0006\u0010M\u001a\u00020\u0017H\u0002J\u0013\u0010\u009d\u0001\u001a\u00020I2\b\u0010\u007f\u001a\u0004\u0018\u00010\u0011H\u0002J\u0013\u0010\u009e\u0001\u001a\u00020I2\b\u0010\u007f\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020I2\u0007\u0010 \u0001\u001a\u00020\u0011H\u0002J\t\u0010¡\u0001\u001a\u00020IH\u0002J\t\u0010¢\u0001\u001a\u00020IH\u0002J\u0011\u0010£\u0001\u001a\u00020I2\u0006\u0010\u007f\u001a\u00020\u0011H\u0002J\u0011\u0010¤\u0001\u001a\u00020I2\u0006\u0010\u007f\u001a\u00020\u0011H\u0002J\t\u0010¥\u0001\u001a\u00020IH\u0002J\u0011\u0010¦\u0001\u001a\u00020I2\u0006\u0010[\u001a\u00020YH\u0002J\u0011\u0010§\u0001\u001a\u00020\u00152\u0006\u0010\u007f\u001a\u00020\u0011H\u0002J,\u0010¨\u0001\u001a\u00020I2\u0006\u0010\u007f\u001a\u00020\u00112\u0007\u0010©\u0001\u001a\u00020\u00112\b\u0010ª\u0001\u001a\u00030«\u00012\u0006\u0010M\u001a\u00020\u0017H\u0002J\u0019\u0010¬\u0001\u001a\u00020I2\u0006\u0010\u007f\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u0017H\u0002J)\u0010\u00ad\u0001\u001a\u00030®\u0001*\u00020\u00112\u0007\u0010©\u0001\u001a\u00020\u00112\b\u0010ª\u0001\u001a\u00030«\u00012\u0006\u0010M\u001a\u00020\u0017H\u0002J\r\u0010¯\u0001\u001a\u00020I*\u00020\u0011H\u0002J\r\u0010°\u0001\u001a\u00020I*\u00020\u0011H\u0002J\t\u0010±\u0001\u001a\u00020IH\u0002J\u000e\u0010²\u0001\u001a\u00030«\u0001*\u00020\u0011H\u0002J\u0017\u0010³\u0001\u001a\u00020)*\u00020\u00112\b\u0010ª\u0001\u001a\u00030«\u0001H\u0002J\u001b\u0010´\u0001\u001a\u00020I2\u0006\u0010M\u001a\u00020\u00172\b\u0010µ\u0001\u001a\u00030®\u0001H\u0002J\u000f\u0010¶\u0001\u001a\u00020+*\u0004\u0018\u00010\u0017H\u0002J\r\u0010·\u0001\u001a\u00020+*\u00020\u0017H\u0002J\u0018\u0010¸\u0001\u001a\u0004\u0018\u00010\u0011*\u00020\u00172\u0007\u0010¹\u0001\u001a\u00020\u0007H\u0002J\u000e\u0010º\u0001\u001a\u00030»\u0001*\u00020\u0017H\u0002J\u000b\u0010¼\u0001\u001a\u0004\u0018\u00010\rH\u0002J\u0015\u0010½\u0001\u001a\u00020\u0007*\u00020\u00072\u0006\u0010M\u001a\u00020\u0017H\u0002J\u0015\u0010¾\u0001\u001a\u00020\u0007*\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010¿\u0001J\t\u0010À\u0001\u001a\u00020+H\u0002J\u0016\u0010Á\u0001\u001a\u00020\u0007*\u00020\u00172\u0007\u0010Â\u0001\u001a\u00020\u0017H\u0002J\u001f\u0010Ã\u0001\u001a\u00020\u0007*\u00020\u00172\u0007\u0010Ä\u0001\u001a\u00020\u00072\u0007\u0010Â\u0001\u001a\u00020\u0017H\u0002J\r\u0010Å\u0001\u001a\u00020\u0017*\u00020\u0017H\u0002J\r\u0010Æ\u0001\u001a\u00020I*\u00020\u0017H\u0002J\u001f\u0010Ç\u0001\u001a\u00020I*\u00020\u00172\u0007\u0010È\u0001\u001a\u00020\u00072\u0007\u0010É\u0001\u001a\u00020\u0007H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010=\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010=\u001a\u0004\bE\u0010F¨\u0006Ò\u0001"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/chat/bubble/floating/IBubbleBannerAbility;", "Lcom/larus/bmhome/chat/bubble/floating/runtime/BubbleBannerRuntime$RefreshListener;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "attachedConversationId", "", "floatingHostStub", "Landroid/view/ViewStub;", "floatingRoot", "Landroid/view/ViewGroup;", "floatingRootParent", "floatingRootIndex", "floatingRootLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "floatingView", "Landroid/view/View;", "renderingPromptId", "runningContentAnimationKey", "runningContentAnimator", "Landroid/animation/ValueAnimator;", "pendingRenderRetryKey", "renderRetryCounts", "", "hostAvailabilityRoot", "hostAvailabilityViewTreeObserver", "Landroid/view/ViewTreeObserver;", "hostAvailabilityListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "floatingAnchorViewsRoot", "floatingActionBar", "floatingInputArea", "floatingInputAbove", "lastHostLayoutSnapshot", "Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$HostLayoutSnapshot;", "lastCanHostBanner", "", "Ljava/lang/Boolean;", "pendingHostUnavailableConversationId", "hostUnavailableGeneration", "isPageResumed", "hostReadyOnce", "mainHandler", "Landroid/os/Handler;", "conversationChangeListener", "com/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$conversationChangeListener$1", "Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$conversationChangeListener$1;", "interpolator", "Landroid/view/animation/PathInterpolator;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", WidgetCostModule.TYPE_ON_CREATE, "", "onResume", "onPause", "onViewCreated", "view", LiveCommonConstants.REASON_ON_DEDTROY, "onBubbleBannerRefreshRequested", "conversationId", "attachConversationIfNeeded", "handleConversationAvailable", "syncCurrentConversationAttachment", "restoreBubbleBannerOnPageEnter", "refreshListForBubbleBanner", "scheduleRenderBubbleBanner", "renderBubbleBanner", "getRenderablePrompt", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerModel;", "prepareBubbleBanner", EventConstant.Key.RETAIN_PROMPT, "showBubbleBanner", "dismissBubbleBanner", "acquireRenderTarget", "Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$RenderTarget;", "shouldPlayEnterAnimation", "prepareContentForDisplay", "contentView", "startEnterAnimation", "enterKey", "animationDistance", "", "showContentWithoutEnterAnimation", "isDismissAnimationRunning", "dismissKey", "startDismissAnimation", "startContentTransition", "transition", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerTransition;", "expectedType", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerTransitionType;", "animationKey", "fromAlpha", "toAlpha", "fromTranslationY", "toTranslationY", "onEnd", "Lkotlin/Function0;", "takeIfUsableEnterTransition", "applyContentTransitionFrame", "progress", "remainingDuration", "", "markContentExitFinished", "cancelContentAnimation", "ensureFloatingView", RootDescription.ROOT_ELEMENT, "bindBubbleBanner", "handleBubbleBannerClick", "promptId", "isCurrentPromptShowing", "bindSwipeDismissGesture", "handleSwipeDown", "touchedView", "event", "Landroid/view/MotionEvent;", "state", "Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$SwipeDismissState;", "handleSwipeMove", "config", "Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$SwipeDismissConfig;", "updateSwipeDragState", "handleSwipeUp", "handleSwipeCancel", "disableStaleBubbleBannerInteraction", "disableBubbleBannerInteraction", "wrapper", "removeFloatingView", "scheduleRenderRetry", "skipReason", "findFloatingHost", "Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$FloatingHost;", "ensureFloatingRoot", "createFloatingRoot", "prepareFloatingRoot", "cacheFloatingRootSlot", "removeFloatingRootIfEmpty", "attachHostAvailabilityObserver", "registerReachHost", "overlay", "unregisterReachHost", "detachHostAvailabilityObserver", "onHostLayoutChanged", "scheduleHostUnavailableDismiss", "cancelPendingHostUnavailableDismiss", "scheduleHostUnavailableRenderRetry", "buildFloatingLayoutParams", "updateFloatingLayout", "anchorRoot", "anchors", "Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$FloatingAnchors;", "prepareClipForFloatingAnimation", "resolveFloatingLayoutSpec", "Lcom/larus/bmhome/chat/bubble/floating/component/BubbleBannerComponent$FloatingLayoutSpec;", "cacheFloatingAnchorViewsIfInvalid", "cacheFloatingAnchorViews", "clearFloatingAnchorViewsCache", "resolveFloatingAnchorsFromCache", "resolveHostLayoutSnapshot", "applyFloatingLayoutSpec", "layoutSpec", "isUsableAnchor", "hasMeasuredBounds", "findAncestorById", "id", "locationOnScreen", "", "getCurrentConversationId", "dp", "orZero", "(Ljava/lang/Integer;)I", "canHostBubbleBanner", "bubbleBannerHeightPx", "referenceView", "resolveBubbleBannerHeightPx", "widthPx", "bubbleBannerContentView", "enableSelfClipping", "applyFloatingClipBounds", "width", "height", "RenderTarget", "FloatingHost", "FloatingAnchors", "HostLayoutSnapshot", "FloatingLayoutSpec", "SwipeDismissConfig", "SwipeDismissState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BubbleBannerComponent extends BaseContentWidget implements j, k.a {
    public static final /* synthetic */ int S = 0;
    public ViewTreeObserver A;
    public o B;
    public ViewGroup C;
    public View D;
    public View E;
    public View F;
    public d G;
    public Boolean H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f297486J;
    public boolean K;
    public boolean L;
    public final Handler M;
    public final i N;
    public final PathInterpolator O;
    public final Lazy P;
    public final Lazy Q;
    public final Lazy R;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f297487m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f297488n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewStub f297489o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f297490p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f297491q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f297492r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup.LayoutParams f297493s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f297494t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f297495u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f297496v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ValueAnimator f297497w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f297498x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, Integer> f297499y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ViewGroup f297500z;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f297501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f297502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f297503c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f297501a, r101.f297501a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f297502b, r101.f297502b) == true) goto L15;
            return false;
        L15:
            if (this.f297503c == r101.f297503c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            View r100 = this.f297501a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            View r104 = this.f297502b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (r103 + r101) * 31;
            if (this.f297503c == false) goto L13;
            int r106 = 1231;
        L15:
            return r105 + r106;
        L13:
            r106 = 1237;
            goto L15
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "FloatingAnchors(bottomAnchor=" + this.f297501a + ", widthAnchor=" + this.f297502b + ", hostAvailable=" + this.f297503c + ')';
        }

        public final boolean a() {
            if (this.f297501a != null) goto L5;
        L9:
            return false;
        L5:
            if (this.f297502b == null) goto L9;
            if (this.f297503c == false) goto L9;
            return true;
        }

        public b(View r100, View r101, boolean r102) {
            this.f297501a = r100;
            this.f297502b = r101;
            this.f297503c = r102;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f297504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f297505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f297506c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f297504a, r101.f297504a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f297505b, r101.f297505b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f297506c, r101.f297506c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f297504a.hashCode() * 31) + this.f297505b.hashCode()) * 31) + this.f297506c.hashCode();
        }

        public final String toString() {
            return "FloatingHost(root=" + this.f297504a + ", anchorRoot=" + this.f297505b + ", anchors=" + this.f297506c + ')';
        }

        public c(ViewGroup r100, ViewGroup r101, b r102) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "anchorRoot");
            Intrinsics.checkNotNullParameter(r102, "anchors");
            this.f297504a = r100;
            this.f297505b = r101;
            this.f297506c = r102;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f297507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f297508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f297509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f297510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f297511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f297512f;

        public /* synthetic */ d() {
            this(false, -1, 0, -1, 0, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f297507a == r101.f297507a) goto L12;
            return false;
        L12:
            if (this.f297508b == r101.f297508b) goto L15;
            return false;
        L15:
            if (this.f297509c == r101.f297509c) goto L18;
            return false;
        L18:
            if (this.f297510d == r101.f297510d) goto L21;
            return false;
        L21:
            if (this.f297511e == r101.f297511e) goto L24;
            return false;
        L24:
            if (this.f297512f == r101.f297512f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            if (this.f297507a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((((((((r100 * 31) + this.f297508b) * 31) + this.f297509c) * 31) + this.f297510d) * 31) + this.f297511e) * 31) + this.f297512f;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "HostLayoutSnapshot(canHostBanner=" + this.f297507a + ", bottomAnchorId=" + this.f297508b + ", bottomAnchorTop=" + this.f297509c + ", widthAnchorId=" + this.f297510d + ", widthAnchorLeft=" + this.f297511e + ", widthAnchorWidth=" + this.f297512f + ')';
        }

        public d(boolean r100, int r101, int r102, int r103, int r104, int r105) {
            this.f297507a = r100;
            this.f297508b = r101;
            this.f297509c = r102;
            this.f297510d = r103;
            this.f297511e = r104;
            this.f297512f = r105;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f297513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f297514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f297515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f297516d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f297517e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f297513a, r101.f297513a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f297514b, r101.f297514b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f297515c, r101.f297515c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f297516d, r101.f297516d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f297517e, r101.f297517e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f297513a.hashCode() * 31) + this.f297514b.hashCode()) * 31) + this.f297515c.hashCode()) * 31) + this.f297516d.hashCode()) * 31) + this.f297517e.hashCode();
        }

        public final String toString() {
            return "RenderTarget(root=" + this.f297513a + ", anchorRoot=" + this.f297514b + ", anchors=" + this.f297515c + ", wrapper=" + this.f297516d + ", content=" + this.f297517e + ')';
        }

        public e(ViewGroup r100, ViewGroup r101, b r102, View r103, View r104) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "anchorRoot");
            Intrinsics.checkNotNullParameter(r102, "anchors");
            Intrinsics.checkNotNullParameter(r103, "wrapper");
            Intrinsics.checkNotNullParameter(r104, "content");
            this.f297513a = r100;
            this.f297514b = r101;
            this.f297515c = r102;
            this.f297516d = r103;
            this.f297517e = r104;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f297518a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f297518a == ((f) r100).f297518a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f297518a;
        }

        public final String toString() {
            return "SwipeDismissConfig(touchSlop=" + this.f297518a + ')';
        }

        public f(int r100) {
            this.f297518a = r100;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f297519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f297520b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f297521c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f297522d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f297523e;

        public g() {
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f297524a = null;

        static {
            int[] r100 = new int[BubbleBannerState.values().length];
            r100[BubbleBannerState.RESOLVED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[BubbleBannerState.ENTERING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[BubbleBannerState.VISIBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[BubbleBannerState.EXITING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f297524a = r100;
        }
    }

    public static final class i implements y.a<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BubbleBannerComponent f297525a;

        public i(BubbleBannerComponent r100) {
            this.f297525a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(wc9.e r100) {
            wc9.e r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "new");
            r r102 = r.f545439a;
            String r103 = r101.f559198a;
            u.f545490a.getClass();
            String r104 = u.a(r103);
            if (r104 == null) goto L6;
            r103 = r104;
        L6:
            t r105 = r.f545448j;
            if (r105 != null) goto L9;
        L14:
            r.a r106 = r.f545446h;
            if (r106 != null) goto L17;
        L19:
            r.w();
            BubbleBannerComponent r107 = this.f297525a;
            String r108 = r101.f559198a;
            int r109 = BubbleBannerComponent.S;
            r107.e4(r108);
            return;
        L17:
            if (Intrinsics.areEqual(r106.f545461d, r103) == true) goto L19;
            r102.n(r106.f545458a.f520408a.f520400h, ReachCloseReason.PAGE_LEAVE);
            goto L19
        L9:
            if ((!Intrinsics.areEqual(((LinkedHashMap) r.f545452n).get(r105.f520408a.f520400h), r103)) == true) goto L12;
            r105 = null;
        L12:
            if (r105 == null) goto L14;
            r.p(ReachRejectReason.NOT_TARGET_PAGE);
            goto L14
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.K = false;
        r r100 = r.f545439a;
        String r101 = a4();
        u.f545490a.getClass();
        String r102 = u.a(r101);
        if (r102 == null) goto L6;
        r101 = r102;
    L6:
        t r103 = r.f545448j;
        if (r103 != null) goto L9;
    L14:
        r.a r104 = r.f545446h;
        if (r104 != null) goto L17;
    L22:
        ViewGroup r105 = this.f297490p;
        if (r105 == null) goto L25;
        r.G(r105);
    L25:
        this.M.removeCallbacksAndMessages(null);
        y r106 = (y) this.P.getValue();
        if (r106 == null) goto L28;
        r106.lQ(this.N);
    L28:
        String r107 = this.f297488n;
        if (r107 == null) goto L36;
        int r108 = k.f297555a;
        Intrinsics.checkNotNullParameter(r107, "conversationId");
        IBubbleBannerRuntimeService r109 = k.c();
        if (r109 == null) goto L33;
        r109.a(r107);
    L33:
        Intrinsics.checkNotNullParameter(r107, "conversationId");
        Intrinsics.checkNotNullParameter(this, "listener");
        IBubbleBannerRuntimeService r110 = k.c();
        if (r110 == null) goto L36;
        r110.r(r107, this);
    L36:
        q4();
        H3();
        this.f297488n = null;
        return;
    L17:
        if (Intrinsics.areEqual(r104.f545461d, r101) == true) goto L20;
        r104 = null;
    L20:
        if (r104 == null) goto L22;
        r100.n(r104.f545458a.f520408a.f520400h, ReachCloseReason.PAGE_LEAVE);
        goto L22
    L9:
        if (Intrinsics.areEqual(((LinkedHashMap) r.f545452n).get(r103.f520408a.f520400h), r101) == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L14;
        r.p(ReachRejectReason.NOT_TARGET_PAGE);
        goto L14
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        boolean r100 = true;
        this.K = true;
        this.L = false;
        String r101 = null;
        this.G = null;
        this.H = null;
        this.f297486J++;
        this.I = null;
        String r102 = a4();
        if (r102 != null) goto L5;
    L7:
        X3();
        r r103 = r.f545439a;
        if (r101 != null) goto L10;
    L13:
        if (r100 == true) goto L15;
        r.w();
    L15:
        if (r101 == null) goto L18;
        e4(r101);
        return;
    L18:
        return;
    L10:
        if (StringsKt.isBlank(r101) == true) goto L13;
        r100 = false;
        goto L13
    L5:
        if ((!StringsKt.isBlank(r102)) == false) goto L7;
        r101 = r102;
        goto L7
    }

    public final void E3() {
        ValueAnimator r100 = this.f297497w;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f297497w = null;
        View r101 = this.f297494t;
        if (r101 == null) goto L15;
        View r102 = r101.findViewById(R.id.bubble_banner_container);
        if (r102 == null) goto L11;
        r101 = r102;
    L11:
        ViewPropertyAnimator r103 = r101.animate();
        if (r103 == null) goto L16;
        r103.cancel();
        return;
    L16:
        return;
    }

    public final void F4() {
        this.M.post(new qc8.a(this));
    }

    public final ViewGroup G3() {
        ViewGroup r100 = this.f297491q;
        Integer r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        FrameLayout r102 = new FrameLayout(r100.getContext());
        r102.setId(R.id.chat_bubble_banner_overlay_container);
        r102.setTranslationZ(2.0f);
        boolean r103 = false;
        r102.setClickable(false);
        r102.setFocusable(false);
        r102.setImportantForAccessibility(2);
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        Integer r104 = Integer.valueOf(this.f297492r);
        if (r104.intValue() < 0) goto L8;
        r103 = true;
    L8:
        if (r103 == false) goto L10;
        r101 = r104;
    L10:
        if (r101 == null) goto L12;
        int r105 = RangesKt.coerceAtMost(r101.intValue(), r100.getChildCount());
    L13:
        ViewGroup.LayoutParams r106 = this.f297493s;
        if (r106 == null) goto L16;
        r100.addView(r102, r105, r106);
    L17:
        this.f297490p = r102;
        D3(r102);
        p4(r102);
        return r102;
    L16:
        r100.addView(r102, r105);
        goto L17
    L12:
        r105 = r100.getChildCount();
        goto L13
    }

    public final void H3() {
        ViewGroup r100 = this.f297500z;
        ViewTreeObserver r101 = this.A;
        o r102 = this.B;
        if (r102 == null) goto L20;
        boolean r103 = false;
        if (r101 != null) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L12;
        r101.removeOnGlobalLayoutListener(r102);
        goto L20
    L12:
        if (r100 == null) goto L18;
        ViewTreeObserver r105 = r100.getViewTreeObserver();
        if (r105 == null) goto L18;
        if (r105.isAlive() != true) goto L18;
        r103 = true;
    L18:
        if (r103 == false) goto L20;
        r100.getViewTreeObserver().removeOnGlobalLayoutListener(r102);
        goto L20
    L7:
        if (r101.isAlive() != true) goto L9;
        r104 = true;
    L20:
        this.f297500z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.f297486J++;
        this.I = null;
    }

    public final ViewGroup X3() {
        ViewGroup r100 = this.f297490p;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L14:
        ViewStub r102 = this.f297489o;
        if (r102 == null) goto L33;
        if (r102.getParent() != null) goto L20;
        r101 = false;
    L20:
        if (r101 == true) goto L23;
        r102 = null;
    L23:
        if (r102 == null) goto L33;
        D3(r102);
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L27;
        ViewGroup r104 = (ViewGroup) r103;
    L28:
        if (r104 == null) goto L30;
        r104.removeView(r102);
    L30:
        this.f297489o = null;
        return G3();
    L27:
        r104 = null;
    L33:
        return G3();
    L5:
        if (r100.getParent() == null) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L14;
        p4(r100);
        return r100;
    L7:
        r105 = false;
        goto L8
    }

    public final String a4() {
        y r100 = (y) this.P.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Y1();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        r r100 = r.f545439a;
        String r101 = a4();
        u.f545490a.getClass();
        String r102 = u.a(r101);
        if (r102 == null) goto L6;
        r101 = r102;
    L6:
        t r103 = r.f545448j;
        if (r103 == null) goto L19;
        Map<String, String> r104 = r.f545452n;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        if (Intrinsics.areEqual(r105.get(r103.f520408a.f520400h), r101) == true) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L19;
        r.p(ReachRejectReason.NOT_TARGET_PAGE);
        goto L19
    L11:
        if (r.u(r103) == true) goto L13;
        r106 = true;
    L19:
        r.a r107 = r.f545446h;
        if (r107 != null) goto L23;
    L27:
        ViewGroup r108 = this.f297490p;
        if (r108 == null) goto L30;
        r.G(r108);
    L30:
        this.K = false;
        this.L = false;
        return;
    L23:
        if (Intrinsics.areEqual(r107.f545461d, r101) == false) goto L27;
        if (r.u(r107.f545458a) == true) goto L27;
        r100.n(r107.f545458a.f520408a.f520400h, ReachCloseReason.PAGE_LEAVE);
        goto L27
    }

    public final void q4() {
        View r100 = this.f297494t;
        if (r100 == null) goto L5;
        ViewParent r101 = r100.getParent();
    L7:
        if ((r101 instanceof ViewGroup) == false) goto L9;
        ViewGroup r102 = (ViewGroup) r101;
    L10:
        if (r102 != null) goto L12;
        r102 = this.f297490p;
    L12:
        E3();
        View r103 = this.f297494t;
        if (r103 == null) goto L17;
        ViewPropertyAnimator r104 = r103.animate();
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        View r105 = this.f297494t;
        if (r105 == null) goto L22;
        View r106 = r105.findViewById(R.id.bubble_banner_container);
        if (r106 != null) goto L23;
        r106 = r105;
    L23:
        Q3(r105, r106);
        View r107 = this.f297494t;
        if (r107 == null) goto L26;
        ViewParent r108 = r107.getParent();
    L28:
        if ((r108 instanceof ViewGroup) == false) goto L30;
        ViewGroup r109 = (ViewGroup) r108;
    L31:
        if (r109 == null) goto L33;
        r109.removeView(this.f297494t);
    L33:
        this.f297494t = null;
        this.f297495u = null;
        this.f297496v = null;
        if (r102 != null) goto L37;
        return;
    L37:
        if (r102.getChildCount() <= 0) goto L40;
        return;
    L40:
        if (this.K == true) goto L55;
        r r110 = r.f545439a;
        r.G(r102);
        D3(r102);
        ViewParent r111 = r102.getParent();
        if ((r111 instanceof ViewGroup) == false) goto L45;
        ViewGroup r112 = (ViewGroup) r111;
    L46:
        if (r112 == null) goto L49;
        r112.removeView(r102);
    L49:
        if (Intrinsics.areEqual(this.f297490p, r102) == false) goto L52;
        this.f297490p = null;
        return;
    L52:
        return;
    L45:
        r112 = null;
        goto L46
    L55:
        return;
    L30:
        r109 = null;
        goto L31
    L26:
        r108 = null;
        goto L28
    L22:
        r106 = null;
        goto L23
    L9:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public final void v4() {
        if (this.K == true) goto L5;
        return;
    L5:
        String r100 = T4();
        if (r100 != null) goto L9;
        r100 = "";
    L9:
        if (StringsKt.isBlank(r100) == false) goto L12;
        q4();
        return;
    L12:
        final pc8.e r101 = c4(r100);
        if (r101 != null) goto L16;
        q4();
        return;
    L16:
        int r102 = h.f297524a[r101.f528578c.ordinal()];
        boolean r103 = true;
        if (r102 == 1) goto L113;
        View r104 = null;
        if (r102 != 2) goto L21;
    L55:
        e r105 = Y2(r101);
        if (r105 == null) goto L130;
        ViewGroup r106 = r105.f297513a;
        b r107 = r105.f297515c;
        View r108 = r105.f297516d;
        View r110 = r105.f297517e;
        final String r111 = "enter_" + r101.f528576a;
        if (Intrinsics.areEqual(this.f297496v, r111) == true) goto L131;
        z3(r108, r101);
        V4(r106, r107, r108);
        pc8.i r109 = r101.f528585j;
        if (r109 != null) goto L64;
    L69:
        r109 = null;
    L71:
        if (r109 == null) goto L76;
        if (k4(r109) >= 1.0f) goto L76;
    L79:
        boolean r112 = true;
    L81:
        this.f297495u = r101.f528576a;
        this.f297496v = null;
        E3();
        r108.setEnabled(true);
        r108.setVisibility(0);
        r108.setClickable(true);
        r110.setEnabled(true);
        r110.setVisibility(0);
        r110.setClickable(true);
        if (r112 == false) goto L110;
        float r113 = B3(r108, r106);
        pc8.i r114 = r101.f528585j;
        if (r114 != null) goto L86;
    L105:
        r114 = null;
    L106:
        int r115 = k.f297555a;
        String r116 = r101.f528576a;
        Intrinsics.checkNotNullParameter(r116, "promptId");
        IBubbleBannerRuntimeService r117 = k.c();
        if (r117 == null) goto L109;
        r117.i(r116);
    L109:
        this.f297496v = r111;
        R4(r114, BubbleBannerTransitionType.ENTER, r111, r110, 0.0f, 1.0f, r113, 0.0f, new n(this, r111, r101));
        return;
    L86:
        if (r114.getType() != BubbleBannerTransitionType.ENTER) goto L88;
        boolean r118 = true;
    L89:
        if (r118 == true) goto L92;
        r114 = null;
    L92:
        if (r114 == null) goto L105;
        if (k4(r114) < 1.0f) goto L106;
        if (r101.f528582g == false) goto L100;
    L103:
        if (r103 == false) goto L105;
    L100:
        if (r101.f528583h == true) goto L103;
        r103 = false;
        goto L103
    L88:
        r118 = false;
        goto L89
    L110:
        r110.setAlpha(1.0f);
        r110.setTranslationY(0.0f);
        int r119 = k.f297555a;
        String r120 = r101.f528576a;
        Intrinsics.checkNotNullParameter(r120, "promptId");
        IBubbleBannerRuntimeService r121 = k.c();
        if (r121 == null) goto L126;
        r121.o(r120);
        return;
    L126:
        return;
    L76:
        if (Intrinsics.areEqual(this.f297495u, r101.f528576a) == false) goto L78;
    L80:
        r112 = false;
        goto L81
    L78:
        if (r101.f528582g == true) goto L80;
    L64:
        if (r109.getType() != BubbleBannerTransitionType.ENTER) goto L66;
        boolean r122 = true;
    L67:
        if (r122 == false) goto L69;
    L66:
        r122 = false;
        goto L67
    L131:
        return;
    L130:
        return;
    L21:
        if (r102 == 3) goto L55;
        if (r102 == 4) goto L26;
        q4();
        return;
    L26:
        if (r101.f528584i != BubbleBannerDismissReason.HOST_UNAVAILABLE) goto L28;
        q4();
        i4(r101);
        return;
    L28:
        View r123 = this.f297494t;
        if (r123 != null) goto L31;
    L54:
        i4(r101);
        return;
    L31:
        if (r123.getParent() == null) goto L33;
        boolean r124 = true;
    L34:
        if (r124 == false) goto L36;
        r104 = r123;
    L36:
        if (r104 == null) goto L54;
        if (Intrinsics.areEqual(this.f297495u, r101.f528576a) == true) goto L41;
        i4(r101);
        return;
    L41:
        final String r125 = "dismiss_" + r101.f528576a;
        if (Intrinsics.areEqual(r104.getTag(R.id.bubble_banner_wrapper), r125) == false) goto L44;
    L47:
        if (r103 == true) goto L129;
        View r126 = r104.findViewById(R.id.bubble_banner_container);
        if (r126 != null) goto L52;
        View r127 = r104;
    L53:
        r104.setTag(R.id.bubble_banner_wrapper, r125);
        Q3(r104, r127);
        this.f297496v = r125;
        float r128 = B3(r104, r104);
        E3();
        this.f297496v = r125;
        R4(r101.f528585j, BubbleBannerTransitionType.EXIT, r125, r127, r127.getAlpha(), 0.0f, r127.getTranslationY(), r128, new m(this, r125, r101));
        return;
    L52:
        r127 = r126;
        goto L53
    L129:
        return;
    L44:
        if (Intrinsics.areEqual(this.f297496v, r125) == true) goto L47;
        r103 = false;
        goto L47
    L33:
        r124 = false;
        goto L34
    L113:
        e r129 = Y2(r101);
        if (r129 == null) goto L132;
        z3(r129.f297516d, r101);
        r129.f297516d.setVisibility(8);
        r129.f297517e.setAlpha(0.0f);
        r129.f297517e.setTranslationY(0.0f);
        int r130 = k.f297555a;
        String r131 = r101.f528576a;
        BubbleBannerEnterTrigger r132 = BubbleBannerEnterTrigger.CONTAINER_READY;
        Intrinsics.checkNotNullParameter(r131, "promptId");
        Intrinsics.checkNotNullParameter(r132, "trigger");
        IBubbleBannerRuntimeService r133 = k.c();
        if (r133 == null) goto L128;
        r133.d(r131, r132);
        return;
    L128:
        return;
    }

    public BubbleBannerComponent() {
        this.f297487m = R.id.chat_bubble_banner_overlay_stub;
        this.f297492r = -1;
        this.f297499y = new LinkedHashMap();
        this.M = new Handler(Looper.getMainLooper());
        this.N = new i(this);
        this.O = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
        this.P = LazyKt.lazy(new qc8.h(this));
        this.Q = LazyKt.lazy(new qc8.i(this));
        this.R = LazyKt.lazy(new qc8.j(this));
    }

    public final String T4() {
        String r100 = a4();
        if (r100 == null) goto L16;
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L16;
        if (Intrinsics.areEqual(this.f297488n, r100) == true) goto L14;
        e4(r100);
    L14:
        return this.f297488n;
    L16:
        return this.f297488n;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        super.onCreate();
        y r100 = (y) this.P.getValue();
        if (r100 == null) goto L5;
        y.b.b(r100, this.N);
    L5:
        y r101 = (y) this.P.getValue();
        if (r101 == null) goto L16;
        String r102 = r101.Y1();
        if (r102 != null) goto L10;
        return;
    L10:
        if ((!StringsKt.isBlank(r102)) == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L18;
        m3(r102);
        F4();
        return;
    L18:
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f297487m;
    }

    public static ViewGroup Z3(View r100) {
    L3:
        if (r100 == null) goto L14;
        if (r100.getId() == R.id.chat_root) goto L7;
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == true) goto L12;
        r100 = null;
        goto L3
    L12:
        r100 = (View) r101;
        goto L3
    L7:
        if ((r100 instanceof ViewGroup) == true) goto L9;
        return null;
    L9:
        return (ViewGroup) r100;
    L14:
        return null;
    }

    public static pc8.e c4(String r100) {
        com.larus.bmhome.chat.bubble.floating.runtime.j.f297547a.getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        l r101 = com.larus.bmhome.chat.bubble.floating.runtime.j.f297548b;
        monitor-enter(r101);
        Intrinsics.checkNotNullParameter(r100, "conversationId");     // Catch: Throwable -> L22
        pc8.e r102 = r101.b(r100);     // Catch: Throwable -> L22
        if (r102 == null) goto L19;
        BubbleBannerState r103 = r102.f528578c;     // Catch: Throwable -> L22
        if (r103 != BubbleBannerState.RESOLVED) goto L9;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
    L20:
        monitor-exit(r101);
        return r102;
    L9:
        if (r103 == BubbleBannerState.ENTERING) goto L16;
        if (r103 == BubbleBannerState.VISIBLE) goto L16;
        if (r103 == BubbleBannerState.EXITING) goto L16;
        r104 = false;
    L19:
        r102 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public static boolean h4(View r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.isShown() == false) goto L10;
        if (r100.getWidth() <= 0) goto L10;
        if (r100.getHeight() <= 0) goto L10;
        return true;
    }

    public static void i4(pc8.e r100) {
        pc8.i r101 = r100.f528585j;
        if (r101 != null) goto L5;
    L10:
        r101 = null;
    L12:
        if (r101 != null) goto L17;
        int r102 = k.f297555a;
        String r103 = r100.f528576a;
        Intrinsics.checkNotNullParameter(r103, "promptId");
        IBubbleBannerRuntimeService r104 = k.c();
        if (r104 == null) goto L21;
        r104.b(r103);
        return;
    L21:
        return;
    L17:
        int r105 = k.f297555a;
        String r106 = r100.f528576a;
        String r107 = r101.f528598a;
        BubbleBannerRenderPart r108 = BubbleBannerRenderPart.CONTENT;
        Intrinsics.checkNotNullParameter(r106, "promptId");
        Intrinsics.checkNotNullParameter(r107, "transitionId");
        Intrinsics.checkNotNullParameter(r108, "part");
        IBubbleBannerRuntimeService r109 = k.c();
        if (r109 == null) goto L22;
        r109.k(r106, r107, r108);
        return;
    L22:
        return;
    L5:
        if (r101.getType() != BubbleBannerTransitionType.EXIT) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == false) goto L10;
    L7:
        r110 = false;
        goto L8
    }

    public static float k4(pc8.i r100) {
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        if (r100.f528601d > 0) goto L9;
        return 1.0f;
    L9:
        return RangesKt.coerceIn((SystemClock.uptimeMillis() - r100.f528600c) / r100.f528601d, 0.0f, 1.0f);
    }

    public final b B4(ViewGroup r100) {
        if (Intrinsics.areEqual(this.C, r100) == true) goto L5;
        C3(r100);
    L5:
        View r101 = this.D;
        View r102 = null;
        if (h4(r101) == true) goto L9;
        r101 = null;
    L9:
        View r103 = this.E;
        if (h4(r103) == true) goto L13;
        r103 = null;
    L13:
        boolean r104 = false;
        if (r101 == null) goto L16;
    L18:
        boolean r105 = false;
    L19:
        if (r101 != null) goto L22;
        if (r105 == true) goto L24;
        r102 = r103;
    L24:
        if (r103 == null) goto L27;
        r101 = r103;
    L27:
        if (r105 == true) goto L49;
        ViewGroup r106 = this.f297500z;
        if (r106 == null) goto L35;
        WindowInsetsCompat r107 = ViewCompat.getRootWindowInsets(r106);
        if (r107 == null) goto L35;
        if (r107.isVisible(WindowInsetsCompat.Type.ime()) != true) goto L35;
        boolean r108 = true;
    L36:
        if (r108 == true) goto L45;
        e0 r109 = (e0) this.R.getValue();
        if (r109 != null) goto L40;
    L42:
        boolean r110 = false;
    L43:
        if (r110 == true) goto L45;
        boolean r111 = true;
    L46:
        if (r111 == false) goto L49;
        r104 = true;
        goto L49
    L40:
        if (r109.bx() != true) goto L42;
        r110 = true;
    L45:
        r111 = false;
    L35:
        r108 = false;
    L49:
        return new b(r102, r101, r104);
    L22:
        r102 = r101;
        goto L24
    L16:
        if (h4(this.F) == false) goto L18;
        r105 = true;
        goto L19
    }

    public final void C3(ViewGroup r100) {
        this.C = r100;
        this.D = r100.findViewById(R.id.action_bar_container);
        this.E = r100.findViewById(R.id.input_area_container);
        this.F = r100.findViewById(R.id.input_above_layout);
    }

    public final void D3(View r100) {
        ViewParent r101 = r100.getParent();
        Integer r102 = null;
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r101;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        this.f297491q = r103;
        Integer r104 = Integer.valueOf(r103.indexOfChild(r100));
        if (r104.intValue() < 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        r102 = r104;
    L14:
        if (r102 == null) goto L16;
        this.f297492r = r102.intValue();
    L16:
        this.f297493s = r100.getLayoutParams();
        return;
    L11:
        r105 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.runtime.k.a
    public final void E(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        if (this.K == true) goto L5;
        return;
    L5:
        T4();
        String r101 = this.f297488n;
        if (r101 != null) goto L11;
        r101 = a4();
        if (r101 != null) goto L11;
        r101 = "";
    L11:
        if (Intrinsics.areEqual(r100, r101) == true) goto L13;
        return;
    L13:
        m3(r100);
        l4(r100);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f297487m = r100;
    }

    public final e Y2(pc8.e r110) {
        ViewGroup r100 = X3();
        if (r100 != null) goto L5;
        c r101 = null;
    L9:
        if (r101 != null) goto L12;
        G4(r110, "no_root");
        return null;
    L12:
        int r102 = 0;
        if (r101.f297506c.a() == true) goto L27;
        Integer r103 = (Integer) ((LinkedHashMap) this.f297499y).get(r110.f528576a);
        if (r103 == null) goto L18;
        r102 = r103.intValue();
    L18:
        if (r102 >= 6) goto L20;
        G4(r110, "host_unavailable");
    L26:
        return null;
    L20:
        if (this.L == false) goto L26;
        int r104 = k.f297555a;
        String r111 = r110.f528577b.f528569b;
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        IBubbleBannerRuntimeService r105 = k.c();
        if (r105 == null) goto L26;
        r105.e(r111);
        goto L26
    L27:
        ViewGroup r106 = r101.f297504a;
        if (r106.isAttachedToWindow() == true) goto L30;
    L34:
        boolean r107 = false;
    L35:
        if (r107 == true) goto L38;
        G4(r110, "root_not_ready");
        return null;
    L38:
        ViewGroup r108 = r101.f297504a;
        View r109 = this.f297494t;
        if (r109 != null) goto L41;
    L49:
        r109 = LayoutInflater.from(r108.getContext()).inflate(R.layout.larus_view_bubble_banner, r108, false);
        Intrinsics.checkNotNull(r109);
        if ((r109 instanceof ViewGroup) == false) goto L52;
        ViewGroup r112 = (ViewGroup) r109;
    L53:
        if (r112 == null) goto L55;
        r112.setClipChildren(true);
        r112.setClipToPadding(true);
    L55:
        r108.addView(r109, new ViewGroup.MarginLayoutParams(-2, -2));
        this.f297494t = r109;
    L56:
        View r113 = r109;
        if (r113 != null) goto L60;
        G4(r110, "no_view");
        return null;
    L60:
        this.f297498x = null;
        this.f297499y.remove(r110.f528576a);
        this.L = true;
        this.H = Boolean.TRUE;
        ViewGroup r114 = r101.f297504a;
        ViewGroup r115 = r101.f297505b;
        b r116 = r101.f297506c;
        View r117 = r113.findViewById(R.id.bubble_banner_container);
        if (r117 != null) goto L63;
        View r118 = r113;
    L65:
        return new e(r114, r115, r116, r113, r118);
    L63:
        r118 = r117;
        goto L65
    L52:
        r112 = null;
        goto L53
    L41:
        if (Intrinsics.areEqual(r109.getParent(), r108) == true) goto L56;
        ViewParent r119 = r109.getParent();
        if ((r119 instanceof ViewGroup) == false) goto L46;
        ViewGroup r120 = (ViewGroup) r119;
    L47:
        if (r120 == null) goto L49;
        r120.removeView(r109);
        goto L49
    L46:
        r120 = null;
        goto L47
    L30:
        if (r106.getWidth() <= 0) goto L34;
        if (r106.getHeight() <= 0) goto L34;
        r107 = true;
        goto L35
    L5:
        ViewGroup r121 = Z3(r100);
        if (r121 != null) goto L8;
        r121 = r100;
    L8:
        p3(r121);
        C3(r121);
        r101 = new c(r100, r121, B4(r121));
        goto L9
    }

    public final void e4(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        if (this.K == false) goto L28;
        m3(r100);
        int r101 = k.f297555a;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        IBubbleBannerRuntimeService r102 = k.c();
        if (r102 == null) goto L10;
        r102.f(r100);
    L10:
        com.larus.bmhome.chat.bubble.floating.runtime.j.f297547a.getClass();
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        l r103 = com.larus.bmhome.chat.bubble.floating.runtime.j.f297548b;
        monitor-enter(r103);
        Intrinsics.checkNotNullParameter(r100, "conversationId");     // Catch: Throwable -> L20
        if (r103.b(r100) == null) goto L15;
        boolean r104 = true;
    L16:
        monitor-exit(r103);
        if (r104 == true) goto L19;
        F4();
        return;
    L19:
        l4(r100);
        return;
    L15:
        r104 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public final void j4(final ViewGroup r110) {
        if (Intrinsics.areEqual(this.f297500z, r110) == true) goto L5;
        return;
    L5:
        if (r110.isAttachedToWindow() == true) goto L7;
        return;
    L7:
        if (this.K == false) goto L83;
        b r100 = B4(r110);
        boolean r101 = false;
        if (r100.a() == true) goto L12;
        d r102 = new d();
    L20:
        if (Intrinsics.areEqual(this.G, r102) == false) goto L22;
        return;
    L22:
        this.G = r102;
        boolean r103 = r100.a();
        Boolean r104 = this.H;
        this.H = Boolean.valueOf(r103);
        if (r103 == false) goto L59;
        this.L = true;
        this.f297486J++;
        r.c r105 = null;
        this.I = null;
        ViewGroup r106 = this.f297490p;
        if (r106 == null) goto L36;
        View r107 = this.f297494t;
        if (r107 == null) goto L36;
        if (r107.getParent() == null) goto L31;
        r101 = true;
    L31:
        if (r101 == true) goto L34;
        r107 = null;
    L34:
        if (r107 == null) goto L36;
        V4(r106, r100, r107);
    L36:
        r r108 = r.f545439a;
        r.d r109 = r.f545444f;
        if (r109 == null) goto L39;
        FrameLayout r111 = r109.b();
    L40:
        View r112 = r.m();
        if (r109 == null) goto L45;
        ViewGroup r113 = r109.a();
        if (r113 == null) goto L45;
        r105 = r.B(r113, r109);
    L45:
        if (r111 == null) goto L57;
        if (r112 == null) goto L57;
        if (r105 == null) goto L57;
        if (r105.a() == false) goto L57;
        r.a r114 = r.f545446h;
        if (r114 == null) goto L57;
        r.b r115 = (r.b) ((LinkedHashMap) r.f545453o).get(r114.f545458a.f520408a.f520400h);
        r.b r116 = r108.j(r111, r112, r105, r114);
        if (r116 == null) goto L57;
        if (Intrinsics.areEqual(r115, r116) == true) goto L57;
        r.z();
    L57:
        r.w();
        goto L59
    L39:
        r111 = null;
    L59:
        if (Intrinsics.areEqual(r104, Boolean.FALSE) == true) goto L73;
        if (r103 == true) goto L73;
        final String r117 = this.f297488n;
        if (r117 != null) goto L67;
        r117 = a4();
        if (r117 != null) goto L67;
        r117 = "";
    L67:
        if (StringsKt.isBlank(r117) == false) goto L69;
        return;
    L69:
        if (Intrinsics.areEqual(this.I, r117) == true) goto L84;
        this.I = r117;
        final int r118 = this.f297486J + 1;
        this.f297486J = r118;
        this.M.postDelayed(new qc8.g(this, r118, r117, r110), 80);
        return;
    L84:
        return;
    L73:
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == true) goto L81;
        if (r103 == false) goto L82;
        F4();
        return;
    L82:
        return;
    L81:
        return;
    L12:
        int[] r119 = new int[2];
        r110.getLocationOnScreen(r119);
        View r120 = r100.f297501a;
        if (r120 != null) goto L15;
        r102 = new d();
        goto L20
    L15:
        View r121 = r100.f297502b;
        if (r121 != null) goto L18;
        r102 = new d();
        goto L20
    L18:
        int[] r122 = new int[2];
        r120.getLocationOnScreen(r122);
        int[] r123 = new int[2];
        r121.getLocationOnScreen(r123);
        r102 = new d(true, r120.getId(), r122[1] - r119[1], r121.getId(), r123[0] - r119[0], r121.getWidth());
        goto L20
    }

    public final void l4(String r100) {
        pc8.e r101 = c4(r100);
        if (r101 == null) goto L5;
        BubbleBannerState r102 = r101.f528578c;
    L7:
        if (r102 != BubbleBannerState.EXITING) goto L9;
        v4();
    L9:
        u7 r103 = (u7) this.Q.getValue();
        if (r103 == null) goto L12;
        r103.C90();
    L12:
        F4();
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void m3(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f297488n, r100) == true) goto L21;
        String r101 = this.f297488n;
        if (r101 == null) goto L15;
        int r102 = k.f297555a;
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        IBubbleBannerRuntimeService r103 = k.c();
        if (r103 == null) goto L12;
        r103.a(r101);
    L12:
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(this, "listener");
        IBubbleBannerRuntimeService r104 = k.c();
        if (r104 == null) goto L15;
        r104.r(r101, this);
    L15:
        this.f297488n = r100;
        int r105 = k.f297555a;
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(this, "listener");
        IBubbleBannerRuntimeService r106 = k.c();
        if (r106 == null) goto L20;
        r106.l(r100, this);
        return;
    L20:
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
        ViewGroup r101 = null;
        if ((r100 instanceof ViewStub) == false) goto L12;
        ViewStub r102 = (ViewStub) r100;
        this.f297489o = r102;
        D3(r100);
        ViewGroup r103 = Z3(r100);
        if (r103 != null) goto L9;
        ViewParent r104 = r102.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L10;
        r101 = (ViewGroup) r104;
    L10:
        p3(r101);
        return;
    L9:
        r101 = r103;
        goto L10
    L12:
        if ((r100 instanceof ViewGroup) == false) goto L22;
        ViewGroup r105 = (ViewGroup) r100;
        this.f297490p = r105;
        r105.setTranslationZ(2.0f);
        r105.setClickable(false);
        r105.setFocusable(false);
        r105.setImportantForAccessibility(2);
        r105.setClipChildren(false);
        r105.setClipToPadding(false);
        D3(r100);
        ViewGroup r106 = Z3(r100);
        if (r106 != null) goto L18;
        ViewParent r107 = r105.getParent();
        if ((r107 instanceof ViewGroup) == false) goto L19;
        r101 = (ViewGroup) r107;
    L19:
        p3(r101);
        p4(r105);
        return;
    L18:
        r101 = r106;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewTreeObserver$OnGlobalLayoutListener, qc8.o] */
    public final void p3(final ViewGroup r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f297500z, r100) == true) goto L7;
        H3();
        C3(r100);
        ?? r101 = new o(this, r100);
        ViewTreeObserver r102 = r100.getViewTreeObserver();
        this.f297500z = r100;
        this.A = r102;
        this.B = r101;
        r102.addOnGlobalLayoutListener(r101);
        this.M.post(new p(this, r100));
        return;
    L7:
        if (Intrinsics.areEqual(this.C, r100) == false) goto L29;
        View r103 = this.D;
        boolean r104 = true;
        if (r103 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == true) goto L29;
        View r106 = this.E;
        if (r106 != null) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == true) goto L29;
        View r108 = this.F;
        if (r108 != null) goto L25;
    L27:
        r104 = false;
    L28:
        if (r104 == true) goto L29;
        return;
    L25:
        if (r108.isAttachedToWindow() == true) goto L27;
    L18:
        if (r106.isAttachedToWindow() == true) goto L20;
        r107 = true;
        goto L21
    L11:
        if (r103.isAttachedToWindow() == true) goto L13;
        r105 = true;
    L29:
        C3(r100);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, qc8.l] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, qc8.k] */
    public final void p4(ViewGroup r110) {
        if (this.K == true) goto L5;
        return;
    L5:
        final String r100 = null;
        if ((r110 instanceof FrameLayout) == false) goto L8;
        FrameLayout r101 = (FrameLayout) r110;
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        String r102 = a4();
        if (r102 != null) goto L14;
        return;
    L14:
        if ((!StringsKt.isBlank(r102)) == false) goto L16;
        r100 = r102;
    L16:
        if (r100 == null) goto L28;
        ViewGroup r111 = Z3(r110);
        if (r111 != null) goto L21;
        return;
    L21:
        final WeakReference r103 = new WeakReference(this);
        final WeakReference r104 = new WeakReference(r111);
        r r105 = r.f545439a;
        ?? r106 = new qc8.k(r103, r104);
        ?? r112 = new qc8.l(r103, r100);
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "overlay");
        Intrinsics.checkNotNullParameter(r111, "anchorRoot");
        Intrinsics.checkNotNullParameter(r106, "canHostBanner");
        Intrinsics.checkNotNullParameter(r112, "refreshList");
        u.f545490a.getClass();
        String r107 = u.a(r100);
        if (r107 != null) goto L24;
        String r108 = r100;
    L25:
        r.f545444f = new r.d(r108, new WeakReference(r101), new WeakReference(r111), r106, r112);
        r.w();
        return;
    L24:
        r108 = r107;
        goto L25
    L28:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public static int B3(View r100, View r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        boolean r103 = false;
        Integer r104 = null;
        if (r102 == null) goto L13;
        Integer r105 = Integer.valueOf(r102.height);
        if (r105.intValue() <= 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L11;
        r105 = null;
    L11:
        if (r105 == null) goto L13;
        return r105.intValue();
    L7:
        r106 = false;
    L13:
        Integer r107 = Integer.valueOf(r100.getHeight());
        if (r107.intValue() <= 0) goto L16;
        r103 = true;
    L16:
        if (r103 == false) goto L18;
        r104 = r107;
    L18:
        if (r104 == null) goto L21;
        return r104.intValue();
    L21:
        return W3(68, r101);
    }

    public static void Q3(View r100, View r101) {
        if (r100 == null) goto L5;
        r100.setEnabled(false);
    L5:
        if (r100 == null) goto L7;
        r100.setClickable(false);
    L7:
        if (r101 == null) goto L9;
        r101.setEnabled(false);
    L9:
        if (r101 == null) goto L11;
        r101.setClickable(false);
    L11:
        if (r101 == null) goto L14;
        r101.setOnTouchListener(null);
        return;
    }

    public static int W3(int r100, View r101) {
        Resources r102 = r101.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public final void G4(pc8.e r100, String r101) {
        final String r102 = r100.f528576a + '_' + r101;
        Integer r103 = (Integer) ((LinkedHashMap) this.f297499y).get(r100.f528576a);
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L7:
        if (r104 < 6) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(this.f297498x, r102) == false) goto L12;
        return;
    L12:
        this.f297499y.put(r100.f528576a, Integer.valueOf(r104 + 1));
        this.f297498x = r102;
        this.M.postDelayed(new qc8.b(this, r102), 50);
        return;
    L5:
        r104 = 0;
        goto L7
    }

    public final void V3(View r100, String r101) {
        Q3(this.f297494t, r100);
        if (Intrinsics.areEqual(this.f297495u, r101) == true) goto L10;
        pc8.e r102 = k.b(r101);
        if (r102 == null) goto L7;
        BubbleBannerState r103 = r102.f528578c;
    L9:
        if (r103 != BubbleBannerState.VISIBLE) goto L10;
        return;
    L7:
        r103 = null;
    L10:
        F4();
    }

    public final void d4(View r100, String r101) {
        if (Intrinsics.areEqual(this.f297495u, r101) == false) goto L11;
        pc8.e r102 = k.b(r101);
        if (r102 == null) goto L7;
        BubbleBannerState r103 = r102.f528578c;
    L9:
        if (r103 != BubbleBannerState.VISIBLE) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        V3(r100, r101);
        return;
    L15:
        int r105 = k.f297555a;
        Context r106 = r100.getContext();
        Intrinsics.checkNotNullParameter(r106, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "promptId");
        IBubbleBannerRuntimeService r107 = k.c();
        if (r107 == null) goto L19;
        r107.j(r106, r101);
        return;
    L19:
        return;
    L7:
        r103 = null;
    L11:
        r104 = false;
        goto L12
    }

    public final void z3(View r100, final pc8.e r101) {
        SimpleDraweeView r102 = (SimpleDraweeView) r100.findViewById(R.id.bubble_banner_icon);
        int r103 = 0;
        if (r102 == null) goto L24;
        String r104 = r101.f528577b.f528571d.f297482c;
        if (r104 != null) goto L7;
    L10:
        boolean r105 = true;
    L12:
        if ((!r105) == false) goto L14;
        int r106 = 0;
    L15:
        r102.setVisibility(r106);
        if (r104 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L24;
        ImageLoaderKt.u(r102, r104, "notification.banner");
        goto L24
    L18:
        if (StringsKt.isBlank(r104) == true) goto L21;
        r107 = false;
        goto L22
    L14:
        r106 = 8;
        goto L15
    L7:
        if (StringsKt.isBlank(r104) == true) goto L10;
        r105 = false;
    L24:
        String r108 = r101.f528577b.f528571d.f297483d;
        if (r108 != null) goto L27;
    L30:
        boolean r109 = true;
    L31:
        boolean r110 = !r109;
        TextView r111 = (TextView) r100.findViewById(R.id.bubble_banner_title);
        String r112 = "";
        if (r111 == null) goto L41;
        String r113 = r101.f528577b.f528571d.f297481b;
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        r111.setText(r113);
        if (r110 == false) goto L39;
        int r114 = 1;
    L40:
        r111.setMaxLines(r114);
        goto L41
    L39:
        r114 = 2;
    L41:
        TextView r115 = (TextView) r100.findViewById(R.id.bubble_banner_subtitle);
        if (r115 == null) goto L51;
        String r116 = r101.f528577b.f528571d.f297483d;
        if (r116 != null) goto L46;
        r116 = "";
    L46:
        r115.setText(r116);
        if (r110 == false) goto L49;
        int r117 = 0;
    L50:
        r115.setVisibility(r117);
        goto L51
    L49:
        r117 = 8;
    L51:
        TextView r118 = (TextView) r100.findViewById(R.id.bubble_banner_cta);
        if (r118 == null) goto L69;
        String r119 = r101.f528577b.f528571d.f297484e;
        if (r119 == null) goto L57;
        r112 = r119;
    L57:
        r118.setText(r112);
        String r120 = r101.f528577b.f528571d.f297484e;
        if (r120 != null) goto L60;
    L63:
        boolean r121 = true;
    L65:
        if ((!r121) == false) goto L67;
        int r122 = 0;
    L68:
        r118.setVisibility(r122);
        goto L69
    L67:
        r122 = 8;
        goto L68
    L60:
        if (StringsKt.isBlank(r120) == true) goto L63;
        r121 = false;
    L69:
        View r123 = r100.findViewById(R.id.bubble_banner_cta_container);
        if (r123 == null) goto L83;
        String r124 = r101.f528577b.f528571d.f297484e;
        if (r124 != null) goto L74;
    L77:
        boolean r125 = true;
    L79:
        if ((true ^ r125) == true) goto L82;
        r103 = 8;
    L82:
        r123.setVisibility(r103);
        r123.setOnClickListener(new qc8.c(this, r101));
        goto L83
    L74:
        if (StringsKt.isBlank(r124) == true) goto L77;
        r125 = false;
    L83:
        View r126 = r100.findViewById(R.id.bubble_banner_container);
        if (r126 == null) goto L87;
        r126.setOnClickListener(new qc8.d(this, r101));
        final f r127 = new f(ViewConfiguration.get(r126.getContext()).getScaledTouchSlop());
        final g r128 = new g();
        r126.setOnTouchListener(new qc8.f(this, r101, r128, r127));
        return;
    L87:
        return;
    L27:
        if (StringsKt.isBlank(r108) == true) goto L30;
        r109 = false;
        goto L31
    }

    public static void V4(ViewGroup r110, b r111, View r112) {
        r110.setClipChildren(false);
        r110.setClipToPadding(false);
        ViewGroup.MarginLayoutParams r100 = null;
        if ((r112 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r112;
    L7:
        if (r101 == null) goto L9;
        r101.setClipChildren(true);
        r101.setClipToPadding(true);
    L9:
        Integer r102 = Integer.valueOf(r110.getWidth());
        if (r102.intValue() <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L16;
        r102 = null;
    L16:
        if (r102 == null) goto L18;
        int r104 = r102.intValue();
    L19:
        View r105 = r111.f297502b;
        if (r105 == null) goto L30;
        Integer r106 = Integer.valueOf(r105.getWidth());
        if (r106.intValue() <= 0) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == true) goto L28;
        r106 = null;
    L28:
        if (r106 == null) goto L30;
        int r108 = r106.intValue();
    L31:
        int r109 = RangesKt.coerceAtMost(RangesKt.coerceAtMost(r108, W3(384, r110)), r104);
        r112.measure(View.MeasureSpec.makeMeasureSpec(r109, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Integer r113 = Integer.valueOf(r112.getMeasuredHeight());
        if (r113.intValue() <= 0) goto L34;
        boolean r114 = true;
    L35:
        if (r114 == true) goto L38;
        r113 = null;
    L38:
        if (r113 == null) goto L40;
        int r115 = r113.intValue();
    L41:
        int[] r116 = new int[2];
        r110.getLocationOnScreen(r116);
        View r117 = r111.f297501a;
        if (r117 == null) goto L44;
        int[] r118 = new int[2];
        r117.getLocationOnScreen(r118);
    L45:
        View r119 = r111.f297502b;
        if (r119 == null) goto L48;
        int[] r120 = new int[2];
        r119.getLocationOnScreen(r120);
    L49:
        if (r118 == null) goto L51;
        int r121 = r118[1] - r116[1];
    L52:
        if (r120 == null) goto L57;
        int r122 = r120[0] - r116[0];
        View r123 = r111.f297502b;
        if (r123 == null) goto L56;
        r108 = r123.getWidth();
    L56:
        int r124 = r122 + (r108 / 2);
    L58:
        float r125 = RangesKt.coerceIn(r124 - (r109 / 2), 0, RangesKt.coerceAtLeast(r104 - r109, 0));
        float r126 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost((r121 - r115) - W3(12, r110), r121), -r115);
        ViewGroup.LayoutParams r127 = r112.getLayoutParams();
        if ((r127 instanceof ViewGroup.MarginLayoutParams) == false) goto L61;
        r100 = (ViewGroup.MarginLayoutParams) r127;
    L61:
        if (r100 == null) goto L63;
        r100.width = r109;
        r100.height = r115;
        r100.leftMargin = 0;
        r100.rightMargin = 0;
        r100.topMargin = 0;
        r112.setLayoutParams(r100);
    L63:
        r112.setTranslationX(r125);
        r112.setTranslationY(r126);
        r112.setClipBounds(new Rect(0, 0, RangesKt.coerceAtLeast(r109, 0), RangesKt.coerceAtLeast(r115, 0)));
        return;
    L57:
        r124 = r104 / 2;
        goto L58
    L51:
        r121 = 0;
        goto L52
    L48:
        r120 = null;
        goto L49
    L44:
        r118 = null;
        goto L45
    L40:
        r115 = W3(68, r110);
        goto L41
    L34:
        r114 = false;
        goto L35
    L24:
        r107 = false;
    L30:
        r108 = r104;
        goto L31
    L18:
        Resources r128 = r110.getResources();
        r104 = WindowDisplayMetricsOverride.apply(r128, r128.getDisplayMetrics()).widthPixels;
        goto L19
    L12:
        r103 = false;
        goto L13
    L5:
        r101 = null;
        goto L7
    }

    public static void h3(View r100, float r101, float r102, float r103, float r104, float r105) {
        r100.setAlpha(r101 + ((r102 - r101) * r105));
        r100.setTranslationY(r103 + ((r104 - r103) * r105));
    }

    public final void R4(pc8.i r110, BubbleBannerTransitionType r111, String r112, final View r210, final float r211, final float r212, final float r213, final float r214, Function0 r215) {
        if (r110 != null) goto L5;
    L10:
        pc8.i r100 = null;
    L11:
        float r101 = k4(r100);
        if (r100 == null) goto L14;
        long r102 = r100.f528601d;
    L15:
        long r103 = RangesKt.coerceAtLeast((long) (r102 * (1.0f - r101)), 0);
        if (r101 < 1.0f) goto L18;
    L22:
        h3(r210, r211, r212, r213, r214, 1.0f);
        r215.invoke();
        return;
    L18:
        if (r103 <= 0) goto L22;
        h3(r210, r211, r212, r213, r214, this.O.getInterpolation(r101));
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{r101, 1.0f});
        r113.setDuration(r103);
        r113.setInterpolator(new LinearInterpolator());
        r113.addUpdateListener(new qc8.e(this, r210, r211, r212, r213, r214));
        r113.addListener(new q(this, r112, r210, r211, r212, r213, r214, r215));
        r113.start();
        this.f297497w = r113;
        return;
    L14:
        r102 = 500;
        goto L15
    L5:
        if (r110.getType() != r111) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r100 = r110;
        goto L11
    L7:
        r104 = false;
        goto L8
    }
}
