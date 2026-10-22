package com.ss.android.ainote.list;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.common.CastMonitor;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ainote.AINoteEditEnterSource;
import com.ss.android.ainote.VCAINoteEditText;
import com.ss.android.ainote.model.AINoteBlockStatus;
import com.ss.android.ainote.model.AINoteListState;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import com.ss.android.ainote.r0;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b:\u0018\u0000 \u0084\u00022\u00020\u0001:\b\u0083\u0002\u0084\u0002\u0085\u0002\u0086\u0002B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010d\u001a\u00020\u0013J\u0010\u0010e\u001a\u0002072\u0006\u0010f\u001a\u00020\u0013H\u0016J\u0010\u0010g\u001a\u0002072\u0006\u0010h\u001a\u00020\u001aH\u0002J\"\u0010i\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010j\u001a\u00020.2\b\b\u0002\u0010k\u001a\u00020\"H\u0002J\b\u0010l\u001a\u000207H\u0014J0\u0010m\u001a\u0002072\u0006\u0010n\u001a\u00020\u00132\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u00072\u0006\u0010r\u001a\u00020\u0007H\u0014J(\u0010s\u001a\u0002072\u0006\u0010t\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u0007H\u0014J\b\u0010x\u001a\u000207H\u0014J\u001c\u0010y\u001a\u0002072\u0014\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0018\u00010AJ\"\u0010{\u001a\u0002072\u001a\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000207\u0018\u000106J\"\u0010|\u001a\u0002072\u001a\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000207\u0018\u000106J\u001c\u0010}\u001a\u0002072\u0014\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000207\u0018\u00010AJ\u0018\u0010~\u001a\u0002072\u0006\u0010\u007f\u001a\u00020\u00132\u0006\u0010k\u001a\u00020.H\u0002J\u0014\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J,\u0010\u0084\u0001\u001a\u0002072\u0007\u0010\u0085\u0001\u001a\u00020\u00132\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00072\u0006\u0010k\u001a\u00020.H\u0002J\u0017\u0010\u0088\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010j\u001a\u00020.J$\u0010\u0089\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010j\u001a\u00020.2\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u008b\u0001\u001a\u00020\u0013H\u0002J\t\u0010\u008c\u0001\u001a\u00020\u0013H\u0002J\u001a\u0010\u008d\u0001\u001a\u00020\u00132\u0007\u0010\u008e\u0001\u001a\u00020\u00182\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0019\u0010\u008f\u0001\u001a\u00020\u00132\b\u0010h\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0003\u0010\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u001aH\u0002J\u001b\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001a2\b\u0010h\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0003\u0010\u0093\u0001J\t\u0010\u0094\u0001\u001a\u000207H\u0002J\t\u0010\u0095\u0001\u001a\u000207H\u0002J\u001a\u0010\u0096\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0007\u0010\u0097\u0001\u001a\u00020.H\u0002J1\u0010\u0098\u0001\u001a\u0002072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u001b\u0010\u0099\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J(\u0010\u009c\u0001\u001a\u0002072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0007\u0010\u009d\u0001\u001a\u00020\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001f\u0010\u009e\u0001\u001a\u0002072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J(\u0010\u009f\u0001\u001a\u0002072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0007\u0010 \u0001\u001a\u00020\u001aJ'\u0010¡\u0001\u001a\u0002072\r\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010¤\u0001\u001a\u0002072\u0007\u0010¥\u0001\u001a\u00020FJ\t\u0010¦\u0001\u001a\u00020\u0007H\u0002J\u0007\u0010§\u0001\u001a\u00020\u0007J\u0007\u0010¨\u0001\u001a\u00020\u0007J\u0018\u0010©\u0001\u001a\u0002072\u000f\u0010ª\u0001\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u000104J#\u0010«\u0001\u001a\u0002072\u001a\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0018\u000106J+\u0010¬\u0001\u001a\u0002072\"\u0010z\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u000207\u0018\u000109J#\u0010\u00ad\u0001\u001a\u0002072\u001a\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000207\u0018\u000106J#\u0010®\u0001\u001a\u0002072\u001a\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000207\u0018\u000106J#\u0010¯\u0001\u001a\u0002072\u001a\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000207\u0018\u000106J#\u0010°\u0001\u001a\u0002072\u001a\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000207\u0018\u000106J)\u0010±\u0001\u001a\u0002072 \u0010z\u001a\u001c\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u000207\u0018\u000109J\u001d\u0010²\u0001\u001a\u0002072\u0014\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000207\u0018\u00010AJ\u0019\u0010³\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010k\u001a\u00020.H\u0002J\u0011\u0010´\u0001\u001a\u0002072\u0006\u0010j\u001a\u00020.H\u0002J\u0019\u0010µ\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010k\u001a\u00020.H\u0002J\u0011\u0010¶\u0001\u001a\u0002072\u0006\u0010j\u001a\u00020.H\u0002J\u000f\u0010·\u0001\u001a\u0004\u0018\u00010\u001a¢\u0006\u0003\u0010¸\u0001J\u0007\u0010¹\u0001\u001a\u000207J\u000f\u0010º\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001aJ\u0019\u0010»\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010h\u001a\u00020\u001aH\u0000¢\u0006\u0003\b¼\u0001J\u0011\u0010½\u0001\u001a\u0002072\b\b\u0002\u0010j\u001a\u00020.J\u000f\u0010¾\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001aJ\u0007\u0010¿\u0001\u001a\u00020\u0013J\u0011\u0010À\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010h\u001a\u00020\u001aJ\u0011\u0010Á\u0001\u001a\u0004\u0018\u00010?2\u0006\u0010h\u001a\u00020\u001aJ\u0014\u0010Â\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020?0Ã\u0001J!\u0010Ä\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001a2\b\b\u0002\u0010k\u001a\u00020\"H\u0000¢\u0006\u0003\bÅ\u0001J\u0017\u0010Æ\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001aH\u0000¢\u0006\u0003\bÇ\u0001J\u0007\u0010È\u0001\u001a\u000207J\t\u0010É\u0001\u001a\u000207H\u0002J\u000f\u0010Ê\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001aJ\u0007\u0010Ê\u0001\u001a\u00020\u0013J\u001f\u0010Ë\u0001\u001a\u00020\u00132\u0014\u0010Ì\u0001\u001a\u000f\u0012\u0005\u0012\u00030Í\u0001\u0012\u0004\u0012\u00020\u00130AH\u0002J'\u0010Î\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001a2\u0014\u0010Ï\u0001\u001a\u000f\u0012\u0005\u0012\u00030Í\u0001\u0012\u0004\u0012\u0002070AH\u0002J\u001b\u0010Ð\u0001\u001a\u0002072\u0007\u0010Ñ\u0001\u001a\u00020\u001a2\u0007\u0010Ò\u0001\u001a\u00020\u0013H\u0002J\t\u0010Ó\u0001\u001a\u000207H\u0002J\t\u0010Ô\u0001\u001a\u000207H\u0002J\u0011\u0010Õ\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0011\u0010Ö\u0001\u001a\u0002072\u0006\u0010j\u001a\u00020.H\u0002J\t\u0010×\u0001\u001a\u000207H\u0002J\u0017\u0010Ø\u0001\u001a\u0002072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J'\u0010Ù\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0007\u0010\u0097\u0001\u001a\u00020.2\u000b\b\u0002\u0010Ú\u0001\u001a\u0004\u0018\u00010.H\u0002J#\u0010Û\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0007\u0010\u0097\u0001\u001a\u00020.2\u0007\u0010Ü\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010Ý\u0001\u001a\u0004\u0018\u00010.2\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0019\u0010Þ\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010j\u001a\u00020.H\u0002J\t\u0010ß\u0001\u001a\u000207H\u0002J\t\u0010à\u0001\u001a\u000207H\u0002J\u0011\u0010á\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001aH\u0002J\t\u0010â\u0001\u001a\u00020\u0013H\u0002J\t\u0010ã\u0001\u001a\u00020\u0013H\u0002J\t\u0010ä\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010å\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001aH\u0002J!\u0010æ\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010j\u001a\u00020.2\u0006\u0010k\u001a\u00020.H\u0002J\u0011\u0010ç\u0001\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0003\u0010¸\u0001J\t\u0010è\u0001\u001a\u000207H\u0002J\u0011\u0010é\u0001\u001a\u0002072\u0006\u0010j\u001a\u00020.H\u0002J\u0011\u0010ê\u0001\u001a\u0002072\u0006\u0010j\u001a\u00020.H\u0002J\"\u0010ë\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0007\u0010¥\u0001\u001a\u00020\u001e2\u0006\u0010j\u001a\u00020.H\u0002J\u0019\u0010ì\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001a2\u0006\u0010j\u001a\u00020.H\u0002J\u0011\u0010í\u0001\u001a\u0002072\u0006\u0010j\u001a\u00020.H\u0002J\t\u0010î\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010ï\u0001\u001a\u0002072\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0012\u0010ð\u0001\u001a\u0002072\u0007\u0010ñ\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010ò\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0011\u0010ó\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0014\u0010ô\u0001\u001a\u0005\u0018\u00010Í\u00012\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0012\u0010õ\u0001\u001a\u00020\u00072\u0007\u0010ö\u0001\u001a\u00020\u0007H\u0002J\t\u0010÷\u0001\u001a\u000207H\u0002J\t\u0010ø\u0001\u001a\u000207H\u0002J\u001c\u0010ù\u0001\u001a\u0002072\u0006\u0010j\u001a\u00020.2\t\b\u0002\u0010ú\u0001\u001a\u00020\u0013H\u0002J\t\u0010û\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010ü\u0001\u001a\u00020\u00132\u0006\u0010h\u001a\u00020\u001aH\u0002J\u0011\u0010ý\u0001\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0003\u0010¸\u0001J\t\u0010þ\u0001\u001a\u000207H\u0002J\t\u0010\u0080\u0002\u001a\u000207H\u0002J\t\u0010\u0081\u0002\u001a\u000207H\u0002J\t\u0010\u0082\u0002\u001a\u000207H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0012\u0010 \u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010$\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0&j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0012\u0010*\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010+\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u00102\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a04X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R*\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u000207\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010<\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010=\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010>\u001a\u001c\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u000207\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000207\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010C\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000207\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000207\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010IR\u001c\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010P\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010IR\u000e\u0010Q\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010S\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010V\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010W\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010X\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010Y\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010[\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\\\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ÿ\u0001\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0087\u0002"}, d2 = {"Lcom/ss/android/ainote/list/AINoteListView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "emptyView", "Landroid/widget/TextView;", "adapter", "Lcom/ss/android/ainote/list/AINoteAdapter;", "delegate", "Lcom/ss/android/ainote/IAINoteDelegate;", "liveRewritingEnabled", "", "scene", "Lcom/ss/android/ainote/model/AINoteScene;", "items", "", "Lcom/ss/android/ainote/model/AINoteBlockModel;", "activeNoteId", "", "Ljava/lang/Long;", "editingTargetNoteId", "editingState", "Lcom/ss/android/ainote/list/AINoteListView$EditingState;", "focusedNoteId", "pendingFocusNoteId", "pendingFocusSource", "Lcom/ss/android/ainote/AINoteEditEnterSource;", "resumeFocusNoteId", "suppressAutoFocusUntilMs", "suppressedBlurUntilMsByNoteId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recyclerDescendantFocusabilityBackup", "Ljava/lang/Integer;", "scrollDescendantFocusabilityBackup", "scrollFocusBlocked", "imeHideFocusabilityBackup", "lastLoggedFocusState", "", "longClickMenu", "Lcom/larksuite/framework/ui/BasePopupWindow;", "longClickMenuNoteId", "longClickMenuDismissByAction", "timeProvider", "Lkotlin/Function0;", "onCreateNote", "Lkotlin/Function2;", "", "onNoteBlur", "Lkotlin/Function3;", "onNoteInputChanged", "onImageDelete", "onImageRetry", "onNoteDelete", "onCopyNote", "Lcom/ss/android/lark/widget/richtext/RichText;", "onRestoreOriginal", "Lkotlin/Function1;", "onAiPolishDisplayed", "onFinishToUseAnimationConsumed", "onEditingStabilized", "listState", "Lcom/ss/android/ainote/model/AINoteListState;", "imeVisible", "imeVisibleByInsets", "Ljava/lang/Boolean;", "onImeVisibilityChanged", "windowSoftInputModeHelper", "Lcom/ss/android/ainote/list/AINoteWindowSoftInputModeHelper;", "insetsListenerTarget", "Landroid/view/View;", "animationCallbackTarget", "lastDelegatedImeVisible", "lastDelegatedImeBottom", "lastDelegatedStableBottomInset", "pendingImeHideConfirmNoteId", "pendingImeHideConfirmRunnable", "Ljava/lang/Runnable;", "pendingEditingStabilizedNoteId", "pendingEditingStabilizedRunnable", "pendingProgrammaticBlurNoteId", "pendingProgrammaticBlurReason", "pendingImagePreviewReturn", "imagePreviewReturnFocusNoteId", "imagePreviewReturnTimeoutRunnable", "lastLayoutHeight", "pendingScrollToBottom", "baseFooterBlankHeightPx", "keyboardLayoutThresholdPx", "desiredKeyboardGapPx", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "consumeClickIfLongClickMenuShowing", "onWindowFocusChanged", "hasWindowFocus", "scheduleImeRestoreRetry", "noteId", "requestEditModeForBoundNote", "reason", "source", "onAttachedToWindow", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onSizeChanged", "w", "h", "oldw", "oldh", "onDetachedFromWindow", "setOnImeVisibilityChangedListener", "listener", "setOnAiPolishDisplayedListener", "setOnFinishToUseAnimationConsumedListener", "setOnEditingStabilizedListener", "refreshImeVisibility", "nowVisible", "extractKeyboardFacts", "Lcom/ss/android/ainote/list/AINoteListView$KeyboardFacts;", "insets", "Landroidx/core/view/WindowInsetsCompat;", "dispatchKeyboardHeightChanged", "visible", "imeBottom", "stableBottomInset", "protectEditorGap", "ensureEditorGapIfNeeded", "retries", "isKeyboardVisibleByLayout", "isKeyboardVisibleByInsets", "matchesUiNoteId", MapController.ITEM_LAYER_TAG, "hasUiNote", "(Ljava/lang/Long;)Z", "indexOfUiNote", "resolveUiNoteId", "(Ljava/lang/Long;)Ljava/lang/Long;", "maybeExitEditWhenOffscreen", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "handleItemInputChanged", "text", "bind", "dispatchImageClick", "clickedImage", "Lcom/ss/android/ainote/model/AINoteGalleryImage;", "patchNote", "note", "syncItemsSilently", "syncItemsFromSessionPreservingEditor", "protectedStableUiId", "remapTrackedNoteIdsByCid", "oldItems", "newItems", "showState", "state", "emptyPlaceholderResId", "getContentHeightPx", "getFooterHeightPx", "setTimeProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "setOnCreateNoteListener", "setOnNoteBlurListener", "setOnNoteInputChangedListener", "setOnImageDeleteListener", "setOnImageRetryListener", "setOnNoteDeleteListener", "setOnCopyNoteListener", "setOnRestoreOriginalListener", "scheduleEditingStabilizedConfirm", "cancelPendingEditingStabilizedConfirm", "scheduleImeHideConfirm", "cancelPendingImeHideConfirm", "getEditingNoteId", "()Ljava/lang/Long;", "clearCurrentEditingFocus", "clearEditingFocusForRemoteOverride", "peekPendingProgrammaticBlurReason", "peekPendingProgrammaticBlurReason$ai_note_release", "dismissCurrentEditingViaKeyboard", "prepareVisibleNoteForRemoval", "isStableWithoutEditing", "getNoteInputContent", "getNoteInputRichText", "exportDirtyVisibleInputRichTexts", "", "focusNote", "focusNote$ai_note_release", "restoreEditingAfterExternalImageInsert", "restoreEditingAfterExternalImageInsert$ai_note_release", "scrollToBottom", "performScrollToBottom", "insertTimeMark", "withActiveItemView", "block", "Lcom/ss/android/ainote/list/AINoteItemView;", "performOnNote", "action", "createLocalItemAndFocus", "timestampMs", "isMark", "handleCreateAreaClick", "createNoteFromFooter", "handleGalleryBlankClick", "dismissEditingViaKeyboard", "clearEditingFocus", "reconcileFocusState", "dispatchBlur", "blurReason", "deferDispatchBlurUntilIdle", "retriesLeft", "consumeProgrammaticBlurReason", "clearPendingProgrammaticBlurReason", "syncDesiredFocusToAdapter", "prepareImagePreviewReturnTracking", "shouldPreserveEditingForImagePreview", "isAppForeground", "isTrueBackground", "isForegroundWindowFocusLoss", "shouldPreserveEditingForInactiveState", "handleInactiveEditingLoss", "resolveRecoverableWindowRegainNoteId", "scheduleImagePreviewReturnTimeout", "cancelImagePreviewReturnTimeout", "clearImagePreviewReturnTracking", "updateEditingTracking", "moveEditingToRecoverableBlur", "clearEditingTracking", "hasAnyEditFocus", "showLongClickMenu", "dismissLongClickMenu", "markAsAction", "shouldShowRestore", "shouldShowCopy", "findNoteItemView", "dp", "value", "requestFooterBlankHeightUpdate", "updateFooterBlankHeightIfNeeded", "startSuppressAutoFocusWindow", "clearCurrentEditing", "shouldSuppressAutoFocus", "shouldIgnoreSuppressedBlur", "findEditingNoteIdByView", "blockRecyclerDescendantFocus", "restoreRecyclerDescendantFocusRunnable", "blockRecyclerDescendantFocusDuringScrollIfNeeded", "restoreRecyclerDescendantFocusAfterScroll", "blockRecyclerDescendantFocusTemporarilyForImeHide", "EditingState", "Companion", "KeyboardInsetsAnimationCallback", "KeyboardFacts", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AINoteListView extends FrameLayout {

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final /* synthetic */ int f406958k1 = 0;
    public Function2<? super Long, ? super String, Unit> A;
    public Function2<? super Long, ? super String, Unit> B;
    public Function2<? super Long, ? super String, Unit> C;
    public Function3<? super Long, ? super String, ? super RichText, Unit> D;
    public Function1<? super Long, Unit> E;
    public Function2<? super Long, ? super Long, Unit> F;
    public Function2<? super Long, ? super Long, Unit> G;
    public Function1<? super Long, Unit> H;
    public Runnable H0;
    public AINoteListState I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f406959J;
    public Function1<? super Boolean, Unit> K;
    public final c0 L;
    public int L0;
    public View M;
    public View N;
    public Boolean O;
    public int P;
    public boolean P0;
    public int Q;
    public Long R;
    public Runnable S;
    public Long T;
    public Runnable U;
    public Long V;
    public final int V0;
    public String W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f406960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f406961b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final int f406962b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AINoteAdapter f406963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r0 f406964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f406965e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AINoteScene f406966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<xra.a> f406967g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final int f406968g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f406969h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final g f406970h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f406971i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public EditingState f406972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f406973k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f406974k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f406975l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AINoteEditEnterSource f406976m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f406977n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashMap<Long, Long> f406978o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f406979p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Long f406980p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f406981q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f406982r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f406983s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f406984t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public BasePopupWindow f406985u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Long f406986v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function0<Long> f406987w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function2<? super Long, ? super Boolean, Unit> f406988x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function3<? super Long, ? super String, ? super String, Unit> f406989y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function2<? super Long, ? super String, Unit> f406990z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ainote/list/AINoteListView$EditingState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "EDITING", "RECOVERABLE_BLUR", "EXITING", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EditingState extends Enum<EditingState> {
        public static final EditingState EDITING = null;
        public static final EditingState EXITING = null;
        public static final EditingState IDLE = null;
        public static final EditingState RECOVERABLE_BLUR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EditingState[] f406992a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f406993b = null;

        public static EnumEntries<EditingState> getEntries() {
            return f406993b;
        }

        static {
            EditingState r100 = new EditingState("IDLE", 0);
            IDLE = r100;
            EditingState r101 = new EditingState("EDITING", 1);
            EDITING = r101;
            EditingState r102 = new EditingState("RECOVERABLE_BLUR", 2);
            RECOVERABLE_BLUR = r102;
            EditingState r103 = new EditingState("EXITING", 3);
            EXITING = r103;
            EditingState[] r104 = {r100, r101, r102, r103};
            f406992a = r104;
            f406993b = EnumEntriesKt.enumEntries(r104);
        }

        public static EditingState[] values() {
            return (EditingState[]) f406992a.clone();
        }

        public static EditingState valueOf(String r100) {
            return (EditingState) r27.a.a(EditingState.class, r100);
        }

        public EditingState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f406994a;

        public a(AINoteListView r100) {
            this.f406994a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101.getAction() == 1) goto L5;
        L12:
            return false;
        L5:
            if (this.f406994a.getEditingNoteId() == null) goto L12;
            RecyclerView r102 = this.f406994a.f406960a;
            if (r102 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            r102 = null;
        L10:
            if (r102.findChildViewUnder(r101.getX(), r101.getY()) != null) goto L12;
            int r103 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "recycler blank area clear editing, x=" + r101.getX() + ", y=" + r101.getY() + ", imeVisible=" + this.f406994a.f406959J + ", active=" + this.f406994a.f406969h + ", focused=" + this.f406994a.f406973k);
            this.f406994a.l("recycler_blank_click");
            return true;
        }
    }

    public static final class b {
    }

    public final class c extends WindowInsetsAnimationCompat.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f406997a;

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public final void onEnd(WindowInsetsAnimationCompat r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public final WindowInsetsCompat onProgress(WindowInsetsCompat r100, List<WindowInsetsAnimationCompat> r101) {
            Intrinsics.checkNotNullParameter(r100, "insets");
            Intrinsics.checkNotNullParameter(r101, "runningAnimations");
            return r100;
        }

        public c(AINoteListView r100) {
            this.f406997a = r100;
            super(1);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public final void onPrepare(WindowInsetsAnimationCompat r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onPrepare(r100);
            if ((r100.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) goto L5;
            return;
        L5:
            Interpolator r101 = r100.getInterpolator();
            if (r101 != null) goto L8;
            r101 = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
        L8:
            int r102 = com.ss.android.ainote.t.f407207a;
            StringBuilder r103 = new StringBuilder("onPrepare, durationMs=");
            r103.append(r100.getDurationMillis());
            r103.append(", hasInterpolator=");
            if (r100.getInterpolator() == null) goto L11;
            boolean r104 = true;
        L12:
            r103.append(r104);
            com.ss.android.ainote.t.d("AINoteListView", r103.toString());
            r0 r105 = this.f406997a.f406964d;
            if (r105 == null) goto L16;
            r105.a(r100.getDurationMillis(), r101);
            return;
        L16:
            return;
        L11:
            r104 = false;
            goto L12
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406998a = null;

        static {
            int[] r100 = new int[EditingState.values().length];
            r100[EditingState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[EditingState.EDITING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[EditingState.RECOVERABLE_BLUR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[EditingState.EXITING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f406998a = r100;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f406999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f407000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f407001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f407002d;

        public e(AINoteListView r100, long r101, String r102, int r103) {
            this.f406999a = r100;
            this.f407000b = r101;
            this.f407001c = r102;
            this.f407002d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AINoteListView r100 = this.f406999a;     // Catch: Throwable -> L4
            long r101 = this.f407000b;     // Catch: Throwable -> L4
            String r102 = this.f407001c;     // Catch: Throwable -> L4
            int r103 = this.f407002d - 1;     // Catch: Throwable -> L4
            int r104 = AINoteListView.f406958k1;     // Catch: Throwable -> L4
            r100.o(r101, r102, r103);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f407004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AINoteEditEnterSource f407005c;

        public f(AINoteListView r100, int r101, AINoteEditEnterSource r102) {
            this.f407003a = r100;
            this.f407004b = r101;
            this.f407005c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r100 = this.f407003a.f406960a;     // Catch: Throwable -> L14
            AINoteViewHolder r101 = null;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");     // Catch: Throwable -> L14
            r100 = null;
        L5:
            RecyclerView.ViewHolder r102 = r100.findViewHolderForAdapterPosition(this.f407004b);     // Catch: Throwable -> L14
            if ((r102 instanceof AINoteViewHolder) == false) goto L8;
            r101 = (AINoteViewHolder) r102;     // Catch: Throwable -> L14
        L8:
            if (r101 != null) goto L11;
            return;
        L11:
            if (r101.f407053a.h() == true) goto L21;
            r101.f407053a.k(this.f407005c);     // Catch: Throwable -> L14
            return;
        L21:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407006a;

        public g(AINoteListView r100) {
            this.f407006a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            View r100 = this.f407006a.getRootView();
            if (r100 != null) goto L5;
            return;
        L5:
            Rect r101 = new Rect();
            r100.getWindowVisibleDisplayFrame(r101);
            r100.getHeight();
            r101.height();
        }
    }

    public static final class h implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407007a;

        public h(AINoteListView r100) {
            this.f407007a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r110, WindowInsetsCompat r111) {
            Intrinsics.checkNotNullParameter(r110, "<unused var>");
            Intrinsics.checkNotNullParameter(r111, "insets");
            AINoteListView r100 = this.f407007a;
            int r101 = AINoteListView.f406958k1;
            r100.getClass();
            boolean r102 = r111.isVisible(WindowInsetsCompat.Type.ime());
            boolean r103 = false;
            if (r102 == false) goto L5;
            int r104 = r111.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        L6:
            int r105 = r111.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            int r106 = RangesKt.coerceAtLeast(r104 - r105, 0);
            if (r102 == false) goto L10;
            if (r106 <= 0) goto L10;
            r103 = true;
        L10:
            this.f407007a.getClass();
            AINoteListView r107 = this.f407007a;
            boolean r108 = r107.f406959J;
            if (r108 == r103) goto L39;
            r107.f406959J = r103;
            int r109 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.a("AINoteListView", "ime visible changed(by insets): " + r107.f406959J);
            Function1<? super Boolean, Unit> r112 = r107.K;
            if (r112 == null) goto L17;
            r112.invoke(Boolean.valueOf(r107.f406959J));
        L17:
            if (r107.f406959J == false) goto L21;
            r107.h("ime_visible:insets");
            Long r113 = r107.getEditingNoteId();
            if (r113 == null) goto L22;
            r107.K(r113.longValue(), "ime_visible:insets");
        L22:
            Long r114 = r107.getEditingNoteId();
            if (r108 == true) goto L25;
        L34:
            if (r108 == false) goto L39;
            if (r107.f406959J == true) goto L39;
            if (r114 == null) goto L39;
            r107.t(r114.longValue(), "ime_hidden_inactive", "insets");
            goto L39
        L25:
            if (r107.f406959J == true) goto L34;
            if (r114 == null) goto L34;
            if (r107.hasWindowFocus() == false) goto L34;
            if (AppLifecycle.a.f408803a.h() == false) goto L34;
            Long r115 = r107.I(Long.valueOf(r114.longValue()));
            if (r115 == null) goto L39;
            long r116 = r115.longValue();
            r107.h("reschedule:insets");
            r107.R = Long.valueOf(r116);
            v r117 = new v(r107, r116);
            r107.S = r117;
            com.ss.android.ainote.t.d("AINoteListView", "ime hidden while editing, schedule confirm, noteId=" + r116 + ", source=insets, delayMs=120, active=" + r107.f406969h + ", focused=" + r107.f406973k + ", editingState=" + r107.f406972j);
            r107.postDelayed(r117, 120);
            goto L39
        L21:
            r107.g("ime_hidden:insets");
        L39:
            AINoteListView r118 = this.f407007a;
            if (Intrinsics.areEqual(r118.O, Boolean.valueOf(r103)) == true) goto L42;
        L46:
            r118.O = Boolean.valueOf(r103);
            r118.P = r104;
            r118.Q = r105;
            int r119 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "delegate keyboard changed(by insets), visible=" + r103 + ", imeBottom=" + r104 + ", stableBottomInset=" + r105);
            r0 r120 = r118.f406964d;
            if (r120 == null) goto L49;
            r120.b(r103, r104, r105);
        L49:
            return r111;
        L42:
            if (r118.P != r104) goto L46;
            if (r118.Q != r105) goto L46;
        L5:
            r104 = 0;
            goto L6
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f407009b;

        public i(AINoteListView r100, long r101) {
            this.f407008a = r100;
            this.f407009b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Long r100 = this.f407008a.f406973k;     // Catch: Throwable -> L9
            long r101 = this.f407009b;     // Catch: Throwable -> L9
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.longValue() != r101) goto L16;
            this.f407008a.o(this.f407009b, "layout_height_changed", 2);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f407011b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Long f407012c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f407013d;

        public j(AINoteListView r100, long r101, long r102, Long r103, Long r104) {
            this.f407010a = r100;
            this.f407011b = r101;
            this.f407012c = r103;
            this.f407013d = r104;
        }

        public final void a() {
            if (this.f407010a.hasWindowFocus() == true) goto L5;
            return;
        L5:
            if (AppLifecycle.a.f408803a.h() == true) goto L7;
            return;
        L7:
            if (this.f407010a.v(Long.valueOf(this.f407011b)) == false) goto L37;
            Long r100 = this.f407010a.getEditingNoteId();
            if (this.f407010a.f406972j != EditingState.EDITING) goto L18;
            if (r100 == null) goto L18;
            Long r101 = this.f407012c;
            if (r101 != null) goto L15;
            return;
        L15:
            if (Intrinsics.areEqual(r100, r101) == false) goto L33;
            this.f407010a.k("window_regain_already_restored");
            return;
        L33:
            return;
        L18:
            int r102 = com.ss.android.ainote.t.f407207a;
            StringBuilder r103 = new StringBuilder("restore focus after window regain, noteId=");
            r103.append(this.f407011b);
            r103.append(", previewReturn=");
            boolean r104 = false;
            if (this.f407012c == null) goto L21;
            boolean r105 = true;
        L22:
            r103.append(r105);
            r103.append(", recoverableResume=");
            if (this.f407013d == null) goto L25;
            r104 = true;
        L25:
            r103.append(r104);
            com.ss.android.ainote.t.d("AINoteListView", r103.toString());
            if (AINoteListView.r(this.f407010a, this.f407011b) == true) goto L28;
            return;
        L28:
            if (this.f407012c == null) goto L30;
            this.f407010a.k("window_regain_restore_success");
        L30:
            this.f407010a.L(this.f407011b);
            return;
        L21:
            r105 = false;
            goto L22
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f407015b;

        public k(AINoteListView r100, int r101) {
            this.f407014a = r100;
            this.f407015b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r100 = this.f407014a.f406960a;     // Catch: Throwable -> L7
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");     // Catch: Throwable -> L7
            r100 = null;
        L5:
            r100.scrollToPosition(this.f407015b);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407016a;

        public l(AINoteListView r100) {
            this.f407016a = r100;
        }

        public final void a() {
            AINoteListView r100 = this.f407016a;
            int r101 = r100.f406963c.f406861v;
            RecyclerView r102 = r100.f406960a;
            RecyclerView r103 = null;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            r102 = null;
        L5:
            int r104 = r102.getHeight();
            RecyclerView r105 = r100.f406960a;
            if (r105 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            r105 = null;
        L8:
            boolean r106 = false;
            int r107 = RangesKt.coerceAtLeast(r105.computeVerticalScrollRange(), 0);
            int r108 = RangesKt.coerceAtLeast(r107 - r101, 0);
            if (r100.I != AINoteListState.CONTENT) goto L12;
            if (r104 <= 0) goto L12;
            int r109 = Math.max(r100.V0, r104 - r108);
        L13:
            int r110 = com.ss.android.ainote.t.f407207a;
            StringBuilder r111 = new StringBuilder("footer blank update, state=");
            r111.append(r100.I);
            r111.append(", recyclerHeight=");
            r111.append(r104);
            r111.append(", contentRange=");
            r111.append(r107);
            r111.append(", currentFooterBlankHeight=");
            r111.append(r101);
            r111.append(", rangeWithoutDynamicFooterBlank=");
            r111.append(r108);
            r111.append(", targetHeight=");
            r111.append(r109);
            r111.append(", itemCount=");
            r111.append(r100.f406963c.getItemCount());
            r111.append(", footerHintVisible=");
            r111.append(r100.f406963c.f406859t);
            r111.append(", computingLayout=");
            RecyclerView r112 = r100.f406960a;
            if (r112 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            r112 = null;
        L16:
            r111.append(r112.isComputingLayout());
            com.ss.android.ainote.t.a("AINoteListView", r111.toString());
            AINoteAdapter r113 = r100.f406963c;
            r113.getClass();
            int r114 = RangesKt.coerceAtLeast(r109, 0);
            if (r113.f406861v == r114) goto L20;
            r113.f406861v = r114;
            r106 = true;
        L20:
            if (r106 == false) goto L39;
            AINoteAdapter r115 = r100.f406963c;
            int r116 = -1;
            if (r115.f406853n == false) goto L25;
            r116 = (-1) + r115.getItemCount();
        L25:
            if (r116 >= 0) goto L27;
            return;
        L27:
            if (r116 >= r100.f406963c.getItemCount()) goto L37;
            RecyclerView r117 = r100.f406960a;
            if (r117 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        L33:
            if (r103.isComputingLayout() == true) goto L38;
            r100.f406963c.notifyItemChanged(r116);
            return;
        L38:
            return;
        L31:
            r103 = r117;
            goto L33
        L37:
            return;
        L39:
            return;
        L12:
            r109 = r100.V0;
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407017a;

        public m(AINoteListView r100) {
            this.f407017a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Integer r100 = this.f407017a.f406979p;     // Catch: Throwable -> L9
            if (r100 == null) goto L12;
            int r101 = r100.intValue();     // Catch: Throwable -> L9
            RecyclerView r102 = this.f407017a.f406960a;     // Catch: Throwable -> L9
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");     // Catch: Throwable -> L9
            r102 = null;
        L7:
            r102.setDescendantFocusability(r101);     // Catch: Throwable -> L9
            this.f407017a.f406979p = null;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f407019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f407020c;

        public n(AINoteListView r100, long r101, String r102) {
            this.f407018a = r100;
            this.f407019b = r101;
            this.f407020c = r102;
        }

        public final void a() {
            AINoteListView r100 = this.f407018a;
            r100.U = null;
            r100.T = null;
            if (r100.f406959J == false) goto L5;
        L8:
            boolean r101 = true;
        L9:
            Long r102 = this.f407018a.f406973k;
            long r103 = this.f407019b;
            if (r102 != null) goto L13;
        L27:
            int r104 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "skip editing stabilized, noteId=" + this.f407019b + ", source=" + this.f407020c + ", imeShown=" + r101 + ", active=" + this.f407018a.f406969h + ", focused=" + this.f407018a.f406973k + ", editingNoteId=" + this.f407018a.getEditingNoteId() + ", editingState=" + this.f407018a.f406972j);
            return;
        L13:
            if (r102.longValue() != r103) goto L27;
            Long r105 = this.f407018a.getEditingNoteId();
            long r106 = this.f407019b;
            if (r105 == null) goto L27;
            if (r105.longValue() != r106) goto L27;
            if (this.f407018a.u() == false) goto L27;
            if (r101 == false) goto L27;
            int r107 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "editing stabilized, noteId=" + this.f407019b + ", source=" + this.f407020c + ", imeVisible=" + this.f407018a.f406959J + ", active=" + this.f407018a.f406969h + ", focused=" + this.f407018a.f406973k);
            Function1<? super Long, Unit> r108 = this.f407018a.H;
            if (r108 == null) goto L29;
            r108.invoke(Long.valueOf(this.f407019b));
            return;
        L29:
            return;
        L5:
            if (r100.z() == true) goto L8;
            r101 = false;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f407022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f407023c;

        public o(AINoteListView r100, long r101, long r102) {
            this.f407021a = r100;
            this.f407022b = r101;
            this.f407023c = r102;
        }

        public final void a() {
            if (this.f407021a.hasWindowFocus() == true) goto L5;
        L27:
            int r100 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "skip ime restore retry (window/app state), noteId=" + this.f407022b + ", expectedUiNoteId=" + this.f407023c + ", hasWindowFocus=" + this.f407021a.hasWindowFocus() + ", appFront=" + AppLifecycle.a.f408803a.h());
            return;
        L5:
            if (AppLifecycle.a.f408803a.h() == false) goto L27;
            Long r101 = this.f407021a.I(Long.valueOf(this.f407023c));
            if (r101 == null) goto L10;
            long r102 = r101.longValue();
        L11:
            Long r103 = this.f407021a.getEditingNoteId();
            if (this.f407021a.f406959J == false) goto L15;
            int r104 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "skip ime restore retry (ime already visible), noteId=" + this.f407022b + ", expectedUiNoteId=" + this.f407023c + ", resolvedUiNoteId=" + r102 + ", editingNoteId=" + r103);
            return;
        L15:
            if (r103 != null) goto L18;
        L19:
            int r105 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "skip ime restore retry (editing note mismatch), noteId=" + this.f407022b + ", expectedUiNoteId=" + this.f407023c + ", resolvedUiNoteId=" + r102 + ", editingNoteId=" + r103);
            return;
        L18:
            if (r103.longValue() != r102) goto L19;
            if (this.f407021a.v(Long.valueOf(r102)) == true) goto L25;
            int r106 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "skip ime restore retry (ui note missing), noteId=" + this.f407022b + ", expectedUiNoteId=" + this.f407023c + ", resolvedUiNoteId=" + r102 + ", editingNoteId=" + r103);
            return;
        L25:
            int r107 = com.ss.android.ainote.t.f407207a;
            com.ss.android.ainote.t.d("AINoteListView", "retry focus to restore ime after window regain, noteId=" + this.f407022b + ", expectedUiNoteId=" + this.f407023c + ", resolvedUiNoteId=" + r102);
            AINoteListView.r(this.f407021a, r102);
            return;
        L10:
            r102 = this.f407023c;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407024a;

        public p(AINoteListView r100) {
            this.f407024a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AINoteListView.d(this.f407024a);
        }
    }

    public static final class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteListView f407025a;

        public q(AINoteListView r100) {
            this.f407025a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AINoteAdapter r100 = this.f407025a.f406963c;     // Catch: Throwable -> L10
            int r101 = -1;
            if (r100.f406853n == false) goto L5;
            r101 = (-1) + r100.getItemCount();     // Catch: Throwable -> L10
        L5:
            if (r101 >= 0) goto L7;
            return;
        L7:
            if (r101 >= this.f407025a.f406963c.getItemCount()) goto L17;
            this.f407025a.f406963c.notifyItemChanged(r101);     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
    }

    public AINoteListView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AINoteListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public static boolean y() {
        return AppLifecycle.a.f408803a.h();
    }

    public final void C() {
        AINoteAdapter r100 = this.f406963c;
        int r101 = -1;
        if (r100.f406853n == false) goto L5;
        r101 = (-1) + r100.getItemCount();
    L5:
        Integer r102 = Integer.valueOf(r101);
        if (r102.intValue() < 0) goto L8;
        boolean r103 = true;
    L9:
        RecyclerView r104 = null;
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L15;
        int r105 = r102.intValue();
    L16:
        if (r105 < 0) goto L23;
        RecyclerView r106 = this.f406960a;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L21:
        r104.post(new k(this, r105));
        return;
    L20:
        r104 = r106;
        goto L21
    L23:
        return;
    L15:
        r105 = this.f406963c.getItemCount() - 1;
        goto L16
    L8:
        r103 = false;
        goto L9
    }

    public final void E() {
        if (v(this.f406969h) == true) goto L6;
        this.f406969h = null;
    L6:
        if (v(this.f406971i) == true) goto L11;
        this.f406971i = null;
        EditingState r100 = this.f406972j;
        EditingState r101 = EditingState.IDLE;
        if (r100 == r101) goto L11;
        this.f406972j = r101;
    L11:
        if (v(this.f406980p0) == true) goto L14;
        k("reconcileFocusState:missing_preview_target");
    L14:
        if (v(this.f406977n) == true) goto L17;
        this.f406977n = null;
    L17:
        if (v(this.f406973k) == true) goto L20;
        this.f406973k = null;
    L20:
        if (this.f406972j == EditingState.RECOVERABLE_BLUR) goto L22;
        return;
    L22:
        if (this.f406971i != null) goto L26;
        this.f406972j = EditingState.IDLE;
        return;
    }

    public final void H() {
        RecyclerView r100 = this.f406960a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r100 = null;
    L5:
        r100.post(new l(this));
    }

    public final void O() {
        AINoteAdapter r100 = this.f406963c;
        r100.f406858s = this.f406986v;
        Long r101 = this.f406975l;
        AINoteEditEnterSource r102 = this.f406976m;
        Intrinsics.checkNotNullParameter(r102, "source");
        r100.f406856q = r101;
        r100.f406857r = r102;
        boolean r103 = false;
        if (u() == false) goto L5;
    L8:
        boolean r104 = true;
    L9:
        AINoteAdapter r105 = this.f406963c;
        boolean r106 = !r104;
        if (r105.f406859t == r106) goto L13;
        r105.f406859t = r106;
        r103 = true;
    L13:
        if (r103 == false) goto L18;
        RecyclerView r107 = this.f406960a;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r107 = null;
    L17:
        r107.post(new q(this));
    L18:
        String r108 = "active=" + this.f406969h + " target=" + this.f406971i + " state=" + this.f406972j + " focused=" + this.f406973k + " resume=" + this.f406977n + " pending=" + this.f406975l + " previewReturnPending=" + this.f406974k0 + " previewReturnNoteId=" + this.f406980p0;
        if (Intrinsics.areEqual(r108, this.f406984t) == true) goto L22;
        this.f406984t = r108;
        int r109 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.a("AINoteListView", "focusState: " + r108);
        return;
    L22:
        return;
    L5:
        if (getEditingNoteId() != null) goto L8;
        r104 = false;
        goto L9
    }

    public final int getContentHeightPx() {
        if (this.I == AINoteListState.CONTENT) goto L5;
        return 0;
    L5:
        RecyclerView r100 = this.f406960a;
        if (r100 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r100 = null;
    L9:
        return RangesKt.coerceAtLeast(r100.computeVerticalScrollRange(), 0);
    }

    public final Long getEditingNoteId() {
        EditingState r100 = this.f406972j;
        int r101 = d.f406998a[r100.ordinal()];
        if (r101 != 1) goto L5;
        Long r102 = null;
    L15:
        if (r102 != null) goto L20;
        r102 = this.f406973k;
        if (r102 != null) goto L20;
        r102 = this.f406977n;
    L20:
        return I(r102);
    L5:
        if (r101 != 2) goto L7;
    L13:
        r102 = this.f406971i;
        goto L15
    L7:
        if (r101 == 3) goto L13;
        if (r101 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    public final int getFooterHeightPx() {
        if (this.f406963c.f406859t == false) goto L5;
        int r100 = n(32);
    L7:
        return this.f406963c.f406861v + r100;
    L5:
        r100 = 0;
        goto L7
    }

    public final void i() {
        h("clearEditingFocus");
        g("clearEditingFocus");
        int r100 = com.ss.android.ainote.t.f407207a;
        StringBuilder r101 = new StringBuilder("clearEditingFocus start, active=");
        r101.append(this.f406969h);
        r101.append(", focused=");
        r101.append(this.f406973k);
        r101.append(", resume=");
        r101.append(this.f406977n);
        r101.append(", editingNoteId=");
        r101.append(getEditingNoteId());
        r101.append(", childCount=");
        RecyclerView r102 = this.f406960a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r102 = null;
    L5:
        r101.append(r102.getChildCount());
        r101.append(", editingState=");
        r101.append(this.f406972j);
        r101.append(", editingTarget=");
        r101.append(this.f406971i);
        com.ss.android.ainote.t.d("AINoteListView", r101.toString());
        m();
        this.f406975l = null;
        j("clearEditingFocus");
        O();
        RecyclerView r103 = this.f406960a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r103 = null;
    L8:
        int r104 = r103.getChildCount();
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L27;
        RecyclerView r106 = this.f406960a;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r106 = null;
    L13:
        View r107 = r106.getChildAt(r105);
        RecyclerView r108 = this.f406960a;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r108 = null;
    L16:
        RecyclerView.ViewHolder r109 = r108.getChildViewHolder(r107);
        if ((r109 instanceof AINoteViewHolder) == false) goto L19;
        AINoteViewHolder r110 = (AINoteViewHolder) r109;
    L20:
        if (r110 == null) goto L26;
        if (r110.f407053a.f() == false) goto L26;
        int r111 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "clearEditingFocus clear holder, index=" + r105 + ", adapterPosition=" + r110.getBindingAdapterPosition());
        r110.f407053a.b();
        return;
    L26:
        r105 = r105 + 1;
        goto L9
    L19:
        r110 = null;
        goto L20
    L27:
        com.ss.android.ainote.t.d("AINoteListView", "clearEditingFocus no focused holder found");
    }

    public final void m() {
        BasePopupWindow r100 = this.f406985u;
        if (r100 == null) goto L6;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L6:
        if (this.f406985u != null) goto L13;
        Long r101 = this.f406986v;
        this.f406986v = null;
        O();
        if (r101 == null) goto L14;
        AINoteItemView r102 = p(r101.longValue());
        if (r102 == null) goto L15;
        r102.setHighlighted(false);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        h("onDetachedFromWindow");
        g("onDetachedFromWindow");
        f("onDetachedFromWindow");
        int r100 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "onDetachedFromWindow, imeVisible=" + this.f406959J + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", resume=" + this.f406977n + ", editingNoteId=" + getEditingNoteId() + ", editingState=" + this.f406972j + ", editingTarget=" + this.f406971i + ", previewReturnPending=" + this.f406974k0 + ", previewReturnNoteId=" + this.f406980p0);
        m();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f406970h1);
        View r101 = this.N;
        if (r101 == null) goto L5;
        ViewCompat.setWindowInsetsAnimationCallback(r101, null);
    L5:
        this.N = null;
        View r102 = this.M;
        if (r102 == null) goto L8;
        ViewCompat.setOnApplyWindowInsetsListener(r102, null);
    L8:
        this.M = null;
        this.L.b("onDetachedFromWindow");
        this.O = null;
        this.P = Integer.MIN_VALUE;
        this.Q = Integer.MIN_VALUE;
        this.L0 = -1;
        super.onDetachedFromWindow();
    }

    public final boolean u() {
        RecyclerView r100 = this.f406960a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r100 = null;
    L5:
        int r101 = r100.getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L24;
        RecyclerView r103 = this.f406960a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r103 = null;
    L10:
        View r104 = r103.getChildAt(r102);
        RecyclerView r105 = this.f406960a;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r105 = null;
    L13:
        RecyclerView.ViewHolder r106 = r105.getChildViewHolder(r104);
        if ((r106 instanceof AINoteViewHolder) == false) goto L16;
        AINoteViewHolder r107 = (AINoteViewHolder) r106;
    L17:
        if (r107 == null) goto L23;
        if (r107.f407053a.f() == false) goto L23;
        return true;
    L23:
        r102 = r102 + 1;
        goto L6
    L16:
        r107 = null;
        goto L17
    L24:
        return false;
    }

    public final boolean z() {
        View r100 = this.M;
        if (r100 != null) goto L7;
        r100 = getRootView();
        if (r100 != null) goto L7;
        r100 = this;
    L7:
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(r100);
        if (r101 != null) goto L12;
        return false;
    L12:
        return r101.isVisible(WindowInsetsCompat.Type.ime());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c0 r100 = this.L;
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "hostView");
        Intrinsics.checkNotNullParameter("onAttachedToWindow", "reason");
        Context r101 = getContext();
    L4:
        if ((r101 instanceof ContextWrapper) == false) goto L9;
        if ((r101 instanceof Activity) == true) goto L7;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L4
    L7:
        Window r102 = ((Activity) r101).getWindow();
    L11:
        if (r102 != null) goto L14;
        int r103 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteWindowInputMode", "ensureAdjusted skip, reason=onAttachedToWindow, window=null, host=" + c0.a(this));
    L32:
        int r104 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "onAttachedToWindow, imeVisible=" + this.f406959J + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", resume=" + this.f406977n + ", editingState=" + this.f406972j + ", editingTarget=" + this.f406971i);
        View r105 = getRootView();
        if (r105 != null) goto L35;
        r105 = this;
    L35:
        View r106 = this.M;
        if (r106 == r105) goto L40;
        if (r106 == null) goto L39;
        ViewCompat.setOnApplyWindowInsetsListener(r106, null);
    L39:
        this.M = r105;
    L40:
        ViewCompat.setOnApplyWindowInsetsListener(r105, new h(this));
        View r107 = this.N;
        if (r107 == r105) goto L45;
        if (r107 == null) goto L44;
        ViewCompat.setWindowInsetsAnimationCallback(r107, null);
    L44:
        this.N = r105;
    L45:
        ViewCompat.setWindowInsetsAnimationCallback(r105, new c(this));
        ViewCompat.requestApplyInsets(r105);
        return;
    L14:
        if (r100.f407069a != r102) goto L16;
    L18:
        r100.f407069a = r102;
        int r108 = r102.getAttributes().softInputMode;
        if ((r108 & 240) != 16) goto L22;
        int r109 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteWindowInputMode", "ensureAdjusted skip, reason=onAttachedToWindow, already_resize, currentMode=" + c0.c(r108) + ", host=" + c0.a(this));
        goto L32
    L22:
        if (r100.f407070b != null) goto L24;
        r100.f407070b = Integer.valueOf(r108);
    L24:
        int r110 = (r108 & (-241)) | 16;
        if (r110 == r108) goto L32;
        r102.setSoftInputMode(r110);
        int r111 = com.ss.android.ainote.t.f407207a;
        StringBuilder r112 = new StringBuilder("ensureAdjusted apply, reason=onAttachedToWindow, original=");
        Integer r113 = r100.f407070b;
        if (r113 == null) goto L30;
        int r114 = r113.intValue();
    L31:
        r112.append(c0.c(r114));
        r112.append(", current=");
        r112.append(c0.c(r108));
        r112.append(", expected=");
        r112.append(c0.c(r110));
        r112.append(", host=");
        r112.append(c0.a(this));
        com.ss.android.ainote.t.d("AINoteWindowInputMode", r112.toString());
        goto L32
    L30:
        r114 = r108;
        goto L31
    L16:
        if (r100.f407070b == null) goto L18;
        r100.b("window_switched:onAttachedToWindow");
        goto L18
    L9:
        r102 = null;
        goto L11
    }

    public final void w() {
        Object r100 = getContext().getSystemService("input_method");
        if ((r100 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r101 = (InputMethodManager) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        r101.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static final void d(AINoteListView r310) {
        boolean r100 = true;
        if (r310.f406985u == null) goto L5;
        r310.m();
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        if (r310.u() == false) goto L11;
    L14:
        if (r100 == false) goto L16;
        r310.l("footer_click");
        return;
    L16:
        Function2<? super Long, ? super Boolean, Unit> r102 = r310.f406988x;
        if (r102 == null) goto L19;
        r102.invoke(r310.f406987w.invoke(), Boolean.FALSE);
        return;
    L19:
        long r110 = r310.f406987w.invoke().longValue();
        com.ss.android.ainote.t.d("AINoteListView", "createLocalItemAndFocus");
        AINoteType.Companion.getClass();
        xra.a r103 = new xra.a(r110, 0, null, null, null, null, null, null, AINoteType.REGULAR, 0, r110, 0, null, false, false, 0, 0, null, 0, false, AINoteBlockStatus.CREATING, 3144446);
        List<xra.a> r104 = CollectionsKt.plus(r310.f406967g, r103);
        r310.f406967g = r104;
        r310.f406969h = Long.valueOf(r103.f564896a);
        r310.O();
        r310.e(r104, r310.f406964d, r310.f406966f, r310.f406965e);
        r310.post(new com.ss.android.ainote.list.p(r310, r103));
        return;
    L11:
        if (r310.getEditingNoteId() != null) goto L14;
        r100 = false;
        goto L14
    L5:
        r101 = false;
        goto L6
    }

    public final String B(long r100) {
        Long r101 = this.V;
        if (r101 != null) goto L6;
    L8:
        return null;
    L6:
        if (r101.longValue() != r100) goto L8;
        return this.W;
    }

    public final void D(long r100) {
        Long r101 = I(Long.valueOf(r100));
        if (r101 == null) goto L67;
        long r102 = r101.longValue();
        Long r103 = this.f406973k;
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        Long r105 = this.f406969h;
        RecyclerView r106 = null;
        if (r105 != null) goto L15;
    L17:
        Long r107 = this.f406980p0;
        if (r107 != null) goto L21;
    L23:
        Long r108 = this.f406971i;
        if (r108 != null) goto L27;
    L29:
        Long r109 = this.f406973k;
        if (r109 != null) goto L33;
    L35:
        Long r110 = this.f406977n;
        if (r110 != null) goto L39;
    L41:
        Long r111 = this.f406986v;
        if (r111 != null) goto L45;
    L47:
        O();
        int r112 = x(r102);
        if (r112 >= 0) goto L50;
        return;
    L50:
        RecyclerView r113 = this.f406960a;
        if (r113 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r113 = null;
    L53:
        RecyclerView.ViewHolder r114 = r113.findViewHolderForAdapterPosition(r112);
        if ((r114 instanceof AINoteViewHolder) == false) goto L56;
        AINoteViewHolder r115 = (AINoteViewHolder) r114;
    L57:
        if (r115 != null) goto L59;
        return;
    L59:
        AINoteItemView r116 = r115.f407053a;
        r116.getClass();
        int r117 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteItemView", "prepareForRemoval, noteId=" + r116.f406946u + ", holder=" + System.identityHashCode(r116));
        r116.f406948w = false;
        r116.f406931f.o();
        r116.b();
        r116.c();
        r116.setHighlighted(false);
        r116.f406947v = true;
        r116.f406931f.setDraftRichText(new RichText());
        r116.f406947v = false;
        r116.H = false;
        r116.I = false;
        r116.f406932g.d();
        r116.f406933h.a(CollectionsKt.emptyList());
        r116.f406946u = 0;
        r116.setVisibility(4);
        if (r104 == false) goto L68;
        RecyclerView r118 = this.f406960a;
        if (r118 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L65:
        r106.clearFocus();
        return;
    L64:
        r106 = r118;
        goto L65
    L68:
        return;
    L56:
        r115 = null;
        goto L57
    L45:
        if (r111.longValue() != r102) goto L47;
        m();
        goto L47
    L39:
        if (r110.longValue() != r102) goto L41;
        this.f406977n = null;
        goto L41
    L33:
        if (r109.longValue() != r102) goto L35;
        this.f406973k = null;
        goto L35
    L27:
        if (r108.longValue() != r102) goto L29;
        this.f406971i = null;
        this.f406972j = EditingState.IDLE;
        goto L29
    L21:
        if (r107.longValue() != r102) goto L23;
        k("prepareVisibleNoteForRemoval:" + r102);
        goto L23
    L15:
        if (r105.longValue() != r102) goto L17;
        this.f406969h = null;
        goto L17
    L8:
        if (r103.longValue() != r102) goto L10;
        r104 = true;
        goto L11
    }

    public final Long I(Long r110) {
        Object r100 = null;
        if (r110 == null) goto L24;
        long r101 = r110.longValue();
        Iterator<T> r102 = this.f406967g.iterator();
    L6:
        if (r102.hasNext() == false) goto L18;
        Object r103 = r102.next();
        xra.a r104 = (xra.a) r103;
        if (r104.c() == r101) goto L15;
        long r105 = r104.f564896a;
        if (r105 == r101) goto L15;
        if (r105 == r101) goto L15;
        boolean r106 = false;
    L16:
        if (r106 == false) goto L6;
        r100 = r103;
    L15:
        r106 = true;
    L18:
        xra.a r107 = (xra.a) r100;
        if (r107 == null) goto L21;
        long r108 = r107.f564896a;
    L23:
        return Long.valueOf(r108);
    L21:
        r108 = r110.longValue();
        goto L23
    L24:
        return null;
    }

    public final void J(long r100) {
        Long r101 = I(Long.valueOf(r100));
        if (r101 == null) goto L38;
        long r102 = r101.longValue();
        if (v(Long.valueOf(r102)) == true) goto L7;
        return;
    L7:
        Long r103 = getEditingNoteId();
        Long r104 = null;
        if (hasWindowFocus() == true) goto L10;
    L35:
        this.f406969h = Long.valueOf(r102);
        int r105 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "defer external image restore until window regain, noteId=" + r102 + ", hasWindowFocus=" + hasWindowFocus() + ", appFront=" + y() + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", resume=" + this.f406977n + ", editingState=" + this.f406972j + ", trackedEditing=" + r103);
        A(r102, "external_image_insert_inactive");
        this.f406975l = null;
        O();
        return;
    L10:
        if (y() == false) goto L35;
        if (this.f406972j != EditingState.RECOVERABLE_BLUR) goto L22;
        if (r103 == null) goto L22;
        if (r103.longValue() != r102) goto L22;
        int r106 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "restore external image editing from recoverable blur, noteId=" + r102);
        if (r(this, r102) == false) goto L37;
        L(r102);
        return;
    L37:
        return;
    L22:
        if (r103 != null) goto L24;
    L31:
        if (r104 == null) goto L33;
        i();
    L33:
        r(this, r102);
        return;
    L24:
        if (r103.longValue() == r102) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == true) goto L30;
        r103 = null;
    L30:
        r104 = r103;
        goto L31
    L26:
        r107 = false;
        goto L27
    }

    public final void L(long r100) {
        Long r101 = I(Long.valueOf(r100));
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L6:
        postDelayed(new o(this, r100, r102), 180);
        return;
    L5:
        r102 = r100;
        goto L6
    }

    public final boolean M(long r100) {
        if (this.f406974k0 == true) goto L5;
        return false;
    L5:
        Long r101 = I(this.f406980p0);
        if (r101 == null) goto L14;
        long r102 = r101.longValue();
        Long r103 = I(Long.valueOf(r100));
        if (r103 != null) goto L11;
        return false;
    L11:
        if (r102 != r103.longValue()) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public final void N(AINoteListState r110) {
        Intrinsics.checkNotNullParameter(r110, "state");
        int r100 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "showState, state=" + r110);
        this.I = r110;
        RecyclerView r101 = this.f406960a;
        TextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r101 = null;
    L5:
        int r103 = 8;
        if (r110 != AINoteListState.CONTENT) goto L8;
        int r104 = 0;
    L9:
        r101.setVisibility(r104);
        TextView r105 = this.f406961b;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        r105 = null;
    L12:
        AINoteListState r106 = AINoteListState.EMPTY;
        if (r110 != r106) goto L15;
        r103 = 0;
    L15:
        r105.setVisibility(r103);
        if (r110 != r106) goto L36;
        com.ss.android.ainote.b r107 = com.ss.android.ainote.b.f406680a;
        TextView r111 = this.f406961b;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        TextView r108 = null;
    L21:
        com.ss.android.ainote.b.c(r107, r108, "vc-personal-notes-empty-state", "Personal Notes Empty State", "Tap to create the first personal note", "vc-personal-notes-note-item");
        TextView r112 = this.f406961b;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        r112 = null;
    L24:
        Context r109 = getContext();
        if (this.f406965e == false) goto L28;
        int r113 = R.string.View_PersonalNotes_RecordIdeasAIComplete_Placeholder;
    L31:
        r112.setText(r109.getString(r113));
        TextView r114 = this.f406961b;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
    L35:
        r102.setOnClickListener(new p(this));
    L40:
        H();
        return;
    L34:
        r102 = r114;
        goto L35
    L28:
        if (this.f406966f != AINoteScene.Meeting) goto L30;
        r113 = R.string.View_PersonalNotes_EnterSaveKeyMeetingPointsAIComplete_Placeholder;
        goto L31
    L30:
        r113 = R.string.View_PersonalNotes_RecordIdeasGenerateDoc_Placeholder;
        goto L31
    L20:
        r108 = r111;
        goto L21
    L36:
        TextView r115 = this.f406961b;
        if (r115 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        r115 = null;
    L39:
        r115.setOnClickListener(null);
        goto L40
    L8:
        r104 = 8;
        goto L9
    }

    public final void f(String r100) {
        Runnable r101 = this.H0;
        if (r101 != null) goto L5;
        return;
    L5:
        removeCallbacks(r101);
        this.H0 = null;
        int r102 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "cancelImagePreviewReturnTimeout, reason=" + r100 + ", noteId=" + this.f406980p0);
    }

    public final void g(String r100) {
        Runnable r101 = this.U;
        if (r101 != null) goto L5;
        return;
    L5:
        removeCallbacks(r101);
        int r102 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "cancel pending editing stabilized, reason=" + r100 + ", noteId=" + this.T + ", active=" + this.f406969h + ", focused=" + this.f406973k);
        this.U = null;
        this.T = null;
    }

    public final void h(String r100) {
        Runnable r101 = this.S;
        if (r101 != null) goto L5;
        return;
    L5:
        removeCallbacks(r101);
        int r102 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "cancel pending ime hide confirm, reason=" + r100 + ", noteId=" + this.R + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", editingState=" + this.f406972j);
        this.S = null;
        this.R = null;
    }

    public final void j(String r100) {
        this.f406971i = null;
        this.f406972j = EditingState.IDLE;
        this.f406973k = null;
        this.f406977n = null;
        int r101 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "clearEditingTracking, reason=" + r100 + ", active=" + this.f406969h);
    }

    public final void k(String r100) {
        if (this.f406974k0 == false) goto L5;
    L9:
        f("clear:" + r100);
        this.f406974k0 = false;
        this.f406980p0 = null;
        int r101 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "clearImagePreviewReturnTracking, reason=" + r100 + ", active=" + this.f406969h);
        return;
    L5:
        if (this.f406980p0 != null) goto L9;
        if (this.H0 != null) goto L9;
    }

    public final void l(String r100) {
        Long r101 = getEditingNoteId();
        k("dismiss:" + r100);
        if (r101 != null) goto L6;
        int r102 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "dismissEditingViaKeyboard fallback clear, reason=" + r100 + ", editingNoteId=null");
        i();
        return;
    L6:
        boolean r103 = true;
        if (this.f406959J == false) goto L9;
    L20:
        int r104 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "dismissEditingViaKeyboard, reason=" + r100 + ", noteId=" + r101 + ", imeShown=" + r103 + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", editingState=" + this.f406972j);
        this.V = r101;
        this.W = r100;
        long r105 = r101.longValue();
        EditingState r106 = EditingState.EXITING;
        StringBuilder r107 = new StringBuilder("dismiss:");
        r107.append(r100);
        Q(r105, r106, r107.toString());
        if (r103 == true) goto L24;
        i();
        return;
    L24:
        w();
        return;
    L9:
        if (z() == true) goto L20;
        View r108 = getRootView();
        if (r108 == null) goto L16;
        Rect r109 = new Rect();
        r108.getWindowVisibleDisplayFrame(r109);
        if ((r108.getHeight() - r109.height()) <= this.f406962b1) goto L16;
        boolean r110 = true;
    L17:
        if (r110 == true) goto L20;
        r103 = false;
    L16:
        r110 = false;
        goto L17
    }

    public final int n(int r100) {
        Resources r101 = getResources();
        return (int) (r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r110) {
        super.onWindowFocusChanged(r110);
        int r100 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "onWindowFocusChanged=" + r110 + ", imeVisible=" + this.f406959J + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", resume=" + this.f406977n + ", editingNoteId=" + getEditingNoteId() + ", editingState=" + this.f406972j + ", editingTarget=" + this.f406971i + ", previewReturnPending=" + this.f406974k0 + ", previewReturnNoteId=" + this.f406980p0);
        if (r110 == true) goto L5;
        return;
    L5:
        Long r111 = I(this.f406980p0);
        if (r111 == null) goto L15;
        long r101 = r111.longValue();
        if (this.f406974k0 == true) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L15;
        Long r103 = r111;
    L17:
        if (this.f406972j != EditingState.RECOVERABLE_BLUR) goto L33;
        Long r112 = this.f406977n;
        if (r112 != null) goto L27;
        r112 = this.f406971i;
        if (r112 != null) goto L27;
        r112 = this.f406969h;
        if (r112 == null) goto L33;
    L27:
        long r104 = r112.longValue();
        Long r113 = I(Long.valueOf(r104));
        if (r113 == null) goto L30;
        r104 = r113.longValue();
    L30:
        Long r114 = Long.valueOf(r104);
        if (v(r114) == false) goto L33;
        Long r105 = r114;
    L34:
        if (r103 == null) goto L37;
        long r106 = r103.longValue();
    L36:
        long r107 = r106;
        if (AppLifecycle.a.f408803a.h() == true) goto L42;
        return;
    L42:
        if (v(Long.valueOf(r107)) == false) goto L48;
        post(new j(this, r107, r107, r103, r105));
        return;
    L48:
        return;
    L37:
        if (r105 == null) goto L46;
        r106 = r105.longValue();
        goto L36
    L46:
        return;
    L33:
        r105 = null;
        goto L34
    L10:
        if (v(Long.valueOf(r101)) == false) goto L12;
        r102 = true;
    L15:
        r103 = null;
        goto L17
    }

    public final AINoteItemView p(long r100) {
        int r101 = x(r100);
        if (r101 >= 0) goto L5;
        return null;
    L5:
        RecyclerView r102 = this.f406960a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r102 = null;
    L8:
        RecyclerView.ViewHolder r103 = r102.findViewHolderForAdapterPosition(r101);
        if ((r103 instanceof AINoteViewHolder) == false) goto L11;
        AINoteViewHolder r104 = (AINoteViewHolder) r103;
    L12:
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.f407053a;
    L11:
        r104 = null;
        goto L12
    }

    public final RichText s(long r100) {
        Long r101 = I(Long.valueOf(r100));
        if (r101 == null) goto L18;
        int r102 = x(r101.longValue());
        if (r102 >= 0) goto L7;
        return null;
    L7:
        RecyclerView r103 = this.f406960a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r103 = null;
    L10:
        RecyclerView.ViewHolder r104 = r103.findViewHolderForAdapterPosition(r102);
        if ((r104 instanceof AINoteViewHolder) == false) goto L13;
        AINoteViewHolder r105 = (AINoteViewHolder) r104;
    L14:
        if (r105 != null) goto L17;
        return null;
    L17:
        return r105.f407053a.f406931f.w();
    L13:
        r105 = null;
        goto L14
    L18:
        return null;
    }

    public final void setOnAiPolishDisplayedListener(Function2<? super Long, ? super Long, Unit> r100) {
        this.F = r100;
    }

    public final void setOnCopyNoteListener(Function3<? super Long, ? super String, ? super RichText, Unit> r100) {
        this.D = r100;
    }

    public final void setOnCreateNoteListener(Function2<? super Long, ? super Boolean, Unit> r100) {
        this.f406988x = r100;
    }

    public final void setOnEditingStabilizedListener(Function1<? super Long, Unit> r100) {
        this.H = r100;
    }

    public final void setOnFinishToUseAnimationConsumedListener(Function2<? super Long, ? super Long, Unit> r100) {
        this.G = r100;
    }

    public final void setOnImageDeleteListener(Function2<? super Long, ? super String, Unit> r100) {
        this.A = r100;
    }

    public final void setOnImageRetryListener(Function2<? super Long, ? super String, Unit> r100) {
        this.B = r100;
    }

    public final void setOnImeVisibilityChangedListener(Function1<? super Boolean, Unit> r100) {
        this.K = r100;
    }

    public final void setOnNoteBlurListener(Function3<? super Long, ? super String, ? super String, Unit> r100) {
        this.f406989y = r100;
    }

    public final void setOnNoteDeleteListener(Function2<? super Long, ? super String, Unit> r100) {
        this.C = r100;
    }

    public final void setOnNoteInputChangedListener(Function2<? super Long, ? super String, Unit> r100) {
        this.f406990z = r100;
    }

    public final void setOnRestoreOriginalListener(Function1<? super Long, Unit> r100) {
        this.E = r100;
    }

    public final void setTimeProvider(Function0<Long> r100) {
        if (r100 != null) goto L4;
        r100 = C116951.INSTANCE;
    L4:
        this.f406987w = r100;
    }

    public final boolean v(Long r100) {
        if (r100 == null) goto L24;
        long r101 = r100.longValue();
        List<xra.a> r102 = this.f406967g;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L26;
        if (((xra.a) r103.next()).f564896a != r101) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L11;
        return true;
    L15:
        r104 = false;
        goto L16
    L26:
        return false;
    L7:
        if (r102.isEmpty() == false) goto L9;
        return false;
    L24:
        return false;
    }

    public final int x(long r100) {
        Iterator<xra.a> r101 = this.f406967g.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        if (r101.next().f564896a != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L16;
        r102 = r102 + 1;
        goto L4
    L16:
        return r102;
    L8:
        r103 = false;
        goto L9
    L12:
        return -1;
    }

    public static final String a(AINoteListView r100, long r101) {
        Long r102 = r100.V;
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.longValue() != r101) goto L11;
        String r103 = r100.W;
        r100.V = null;
        r100.W = null;
        return r103;
    L11:
        return null;
    }

    public static /* synthetic */ boolean r(AINoteListView r100, long r101) {
        return r100.q(r101, AINoteEditEnterSource.USER);
    }

    public final void A(long r100, String r101) {
        Long r102 = I(Long.valueOf(r100));
        if (r102 == null) goto L9;
        long r103 = r102.longValue();
        if (v(Long.valueOf(r103)) == true) goto L7;
        return;
    L7:
        Q(r103, EditingState.RECOVERABLE_BLUR, r101);
        return;
    }

    public final void F(List<xra.a> r100, List<xra.a> r101) {
        this.f406969h = G(r100, r101, this.f406969h);
        this.f406971i = G(r100, r101, this.f406971i);
        this.f406973k = G(r100, r101, this.f406973k);
        this.f406975l = G(r100, r101, this.f406975l);
        this.f406977n = G(r100, r101, this.f406977n);
        this.f406980p0 = G(r100, r101, this.f406980p0);
        this.f406986v = G(r100, r101, this.f406986v);
    }

    public final void K(long r100, String r101) {
        Long r102 = I(Long.valueOf(r100));
        if (r102 == null) goto L6;
        long r103 = r102.longValue();
        g("reschedule:" + r101);
        this.T = Long.valueOf(r103);
        n r104 = new n(this, r103, r101);
        this.U = r104;
        postDelayed(r104, 120);
        return;
    }

    public final void P(List<xra.a> r100, r0 r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        int r102 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "syncItemsSilently, itemCount=" + r100.size() + ", editingNoteId=" + getEditingNoteId());
        F(this.f406967g, r100);
        this.f406967g = r100;
        this.f406964d = r101;
        AINoteAdapter r103 = this.f406963c;
        r103.f406854o = r101;
        AINoteScene r104 = this.f406966f;
        Intrinsics.checkNotNullParameter(r104, "scene");
        r103.f406855p = r104;
        AINoteAdapter r105 = this.f406963c;
        r105.f406862w = this.f406965e;
        r105.f406860u = getEditingNoteId();
        AINoteAdapter r106 = this.f406963c;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r100, "newItems");
        r106.z2(r100, false);
        O();
        E();
        H();
    }

    public final boolean q(long r100, AINoteEditEnterSource r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        Long r102 = I(Long.valueOf(r100));
        if (r102 == null) goto L31;
        long r103 = r102.longValue();
        if (v(Long.valueOf(r103)) == true) goto L7;
        return false;
    L7:
        this.f406969h = Long.valueOf(r103);
        Q(r103, EditingState.EDITING, "focusNote");
        AINoteItemView r104 = p(r103);
        if (r104 != null) goto L11;
        boolean r105 = false;
    L15:
        RecyclerView r106 = null;
        if (r105 == false) goto L19;
        this.f406975l = null;
        this.f406976m = AINoteEditEnterSource.USER;
        O();
        return true;
    L19:
        this.f406975l = Long.valueOf(r103);
        this.f406976m = r101;
        O();
        int r107 = x(r103);
        if (r107 >= 0) goto L22;
        return false;
    L22:
        RecyclerView r108 = this.f406960a;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r108 = null;
    L25:
        r108.scrollToPosition(r107);
        RecyclerView r109 = this.f406960a;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L29:
        r106.post(new f(this, r107, r101));
        return true;
    L28:
        r106 = r109;
        goto L29
    L11:
        if (r104.h() == false) goto L13;
        int r110 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "skip requestEditMode on focusNote, noteId=" + r103 + " blocked=true");
    L14:
        r105 = true;
        goto L15
    L13:
        int r111 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "request edit mode on focusNote, noteId=" + r103 + ", source=" + r101);
        r104.k(r101);
        goto L14
    L31:
        return false;
    }

    public AINoteListView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        AINoteAdapter r100 = new AINoteAdapter(new AINoteListView$adapter$1(this), new AINoteListView$adapter$2(this), new AINoteListView$adapter$3(this), new AINoteListView$adapter$4(this), new AINoteListView$adapter$5(this), new AINoteListView$adapter$6(this), new AINoteListView$adapter$7(this), new AINoteListView$adapter$8(this), new AINoteListView$adapter$9(this), new AINoteListView$adapter$10(this), new AINoteListView$adapter$11(this), new AINoteListView$adapter$12(this));
        this.f406963c = r100;
        this.f406965e = true;
        this.f406966f = AINoteScene.UNKNOWN;
        this.f406967g = CollectionsKt.emptyList();
        this.f406972j = EditingState.IDLE;
        this.f406976m = AINoteEditEnterSource.USER;
        this.f406978o = new HashMap();
        this.f406987w = AINoteListView$timeProvider$1.INSTANCE;
        this.I = AINoteListState.EMPTY;
        this.L = new c0();
        this.P = Integer.MIN_VALUE;
        this.Q = Integer.MIN_VALUE;
        this.L0 = -1;
        int r101 = n(120);
        this.V0 = r101;
        this.f406962b1 = n(80);
        this.f406968g1 = n(120);
        g r102 = new g(this);
        this.f406970h1 = r102;
        LayoutInflater.from(r210).inflate(R.layout.ai_note_list_view, this, true);
        RecyclerView r110 = (RecyclerView) findViewById(R.id.ai_note_list);
        this.f406960a = r110;
        TextView r111 = (TextView) findViewById(R.id.ai_note_empty);
        this.f406961b = r111;
        com.ss.android.ainote.b r112 = com.ss.android.ainote.b.f406680a;
        com.ss.android.ainote.b.c(r112, this, "vc-personal-notes-list", "Personal Notes List", "Current view contains personal notes list", "vc-personal-notes-note-item");
        if (r110 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        RecyclerView r113 = null;
    L6:
        com.ss.android.ainote.b.c(r112, r113, "vc-personal-notes-list", "Personal Notes List", "Current view contains personal notes list", "vc-personal-notes-note-item");
        if (r111 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        TextView r114 = null;
    L10:
        com.ss.android.ainote.b.c(r112, r114, "vc-personal-notes-empty-state", "Personal Notes Empty State", "Tap to create the first personal note", "vc-personal-notes-note-item");
        if (r110 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        RecyclerView r103 = null;
    L14:
        r103.setFocusable(false);
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        RecyclerView r104 = null;
    L18:
        r104.setFocusableInTouchMode(false);
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        RecyclerView r105 = null;
    L22:
        r105.setLayoutManager(new LinearLayoutManager(r210));
        if (r110 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        RecyclerView r106 = null;
    L26:
        r106.setAdapter(r100);
        int r107 = RangesKt.coerceAtLeast(r101, 0);
        if (r100.f406861v == r107) goto L30;
        r100.f406861v = r107;
    L30:
        if (r110 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        RecyclerView r108 = null;
    L33:
        r108.addOnScrollListener(new AnonymousClass1(this));
        if (r110 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r110 = null;
    L36:
        r110.setOnTouchListener(new a(this));
        getViewTreeObserver().addOnGlobalLayoutListener(r102);
        new m(this);
        return;
    L32:
        r108 = r110;
        goto L33
    L25:
        r106 = r110;
        goto L26
    L21:
        r105 = r110;
        goto L22
    L17:
        r104 = r110;
        goto L18
    L13:
        r103 = r110;
        goto L14
    L9:
        r114 = r111;
        goto L10
    L5:
        r113 = r110;
        goto L6
    }

    public static final Long G(List<xra.a> r110, List<xra.a> r111, Long r112) {
        Object r100 = null;
        if (r112 == null) goto L49;
        long r101 = r112.longValue();
        Iterator<T> r113 = r110.iterator();
    L6:
        if (r113.hasNext() == false) goto L18;
        Object r114 = r113.next();
        xra.a r102 = (xra.a) r114;
        if (r102.c() != r101) goto L10;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L6;
    L19:
        xra.a r115 = (xra.a) r114;
        if (r115 == null) goto L22;
        long r104 = r115.f564896a;
    L23:
        List<xra.a> r116 = r111;
        Iterator<T> r117 = r116.iterator();
    L25:
        if (r117.hasNext() == false) goto L32;
        Object r118 = r117.next();
        if (((xra.a) r118).f564896a != r104) goto L29;
        boolean r105 = true;
    L30:
        if (r105 == false) goto L25;
    L33:
        xra.a r119 = (xra.a) r118;
        if (r119 != null) goto L45;
        Iterator<T> r120 = r116.iterator();
    L37:
        if (r120.hasNext() == false) goto L44;
        Object r121 = r120.next();
        if (((xra.a) r121).f564897b != r101) goto L41;
        boolean r122 = true;
    L42:
        if (r122 == false) goto L37;
        r100 = r121;
        goto L44
    L41:
        r122 = false;
    L44:
        r119 = (xra.a) r100;
    L45:
        if (r119 == null) goto L48;
        r101 = r119.f564896a;
    L48:
        return Long.valueOf(r101);
    L29:
        r105 = false;
        goto L30
    L32:
        r118 = null;
        goto L33
    L22:
        r104 = r101;
        goto L23
    L10:
        if (r102.f564896a == r101) goto L15;
        if (r102.f564897b == r101) goto L15;
        r103 = false;
        goto L16
    L18:
        r114 = null;
        goto L19
    L49:
        return null;
    }

    public final void Q(long r100, EditingState r101, String r102) {
        Long r103 = I(Long.valueOf(r100));
        if (r103 == null) goto L5;
        r100 = r103.longValue();
    L5:
        this.f406971i = Long.valueOf(r100);
        this.f406972j = r101;
        int r104 = d.f406998a[r101.ordinal()];
        if (r104 != 1) goto L8;
        this.f406973k = null;
        this.f406977n = null;
    L25:
        int r105 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "updateEditingTracking, reason=" + r102 + ", state=" + r101 + ", noteId=" + r100 + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", resume=" + this.f406977n);
        return;
    L8:
        if (r104 != 2) goto L10;
        this.f406973k = Long.valueOf(r100);
        this.f406977n = null;
        goto L25
    L10:
        if (r104 != 3) goto L12;
        Long r106 = this.f406973k;
        if (r106 != null) goto L20;
    L22:
        this.f406977n = Long.valueOf(r100);
        goto L25
    L20:
        if (r106.longValue() != r100) goto L22;
        this.f406973k = null;
        goto L22
    L12:
        if (r104 != 4) goto L15;
        this.f406977n = null;
        goto L25
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final void o(long r100, String r110, int r111) {
        Long r101 = this.f406973k;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.longValue() == r100) goto L9;
        return;
    L9:
        if (this.f406959J == false) goto L11;
    L13:
        View r102 = getRootView();
        if (r102 != null) goto L16;
        return;
    L16:
        Rect r103 = new Rect();
        r102.getWindowVisibleDisplayFrame(r103);
        int[] r104 = new int[2];
        getLocationInWindow(r104);
        int r105 = Math.min(r103.bottom, r104[1] + getHeight()) - this.f406968g1;
        if (r105 > 0) goto L19;
        return;
    L19:
        int r106 = x(r100);
        if (r106 >= 0) goto L22;
        return;
    L22:
        RecyclerView r107 = this.f406960a;
        RecyclerView r108 = null;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r107 = null;
    L25:
        RecyclerView.ViewHolder r109 = r107.findViewHolderForAdapterPosition(r106);
        if ((r109 instanceof AINoteViewHolder) == false) goto L28;
        AINoteViewHolder r112 = (AINoteViewHolder) r109;
    L29:
        if (r112 != null) goto L37;
        if (r111 <= 0) goto L49;
        RecyclerView r113 = this.f406960a;
        if (r113 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L35:
        r108.post(new e(this, r100, r110, r111));
        return;
    L34:
        r108 = r113;
        goto L35
    L49:
        return;
    L37:
        VCAINoteEditText r114 = r112.f407053a.getEditorView();
        if (r114.isShown() == true) goto L40;
        return;
    L40:
        int[] r115 = new int[2];
        r114.getLocationInWindow(r115);
        int r116 = (r115[1] + r114.getHeight()) - r105;
        if (r116 <= 0) goto L50;
        RecyclerView r117 = this.f406960a;
        if (r117 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L46:
        r108.smoothScrollBy(0, r116);
        return;
    L45:
        r108 = r117;
        goto L46
    L50:
        return;
    L28:
        r112 = null;
        goto L29
    L11:
        if (z() == true) goto L13;
    }

    public final boolean t(long r210, String r211, String r212) {
        if (hasWindowFocus() == true) goto L5;
    L7:
        Long r100 = I(Long.valueOf(r210));
        if (r100 == null) goto L10;
        long r101 = r100.longValue();
    L12:
        if (M(r101) == false) goto L15;
    L13:
        boolean r102 = true;
    L20:
        String r110 = "inactive";
        if (r102 == false) goto L35;
        if (M(r101) == false) goto L26;
        r110 = "image_preview";
    L33:
        String r103 = r110;
        int r111 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "preserve editing for inactive state, noteId=" + r101 + ", reason=" + r211 + ", source=" + r212 + ", inactiveKind=" + r103 + ", hasWindowFocus=" + hasWindowFocus() + ", appFront=" + y() + ", imeVisible=" + this.f406959J + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", resume=" + this.f406977n + ", editingState=" + this.f406972j + ", editingTarget=" + this.f406971i);
        StringBuilder r104 = new StringBuilder();
        r104.append(r211);
        r104.append(':');
        r104.append(r103);
        r104.append(':');
        r104.append(r212);
        A(r101, r104.toString());
    L38:
        O();
        return true;
    L26:
        if (hasWindowFocus() == false) goto L28;
    L30:
        boolean r112 = false;
    L31:
        if (r112 == false) goto L33;
        r110 = "window_focus_loss";
        goto L33
    L28:
        if (y() == false) goto L30;
        r112 = true;
        goto L31
    L35:
        if ((!y()) == false) goto L37;
        r110 = "background";
    L37:
        String r105 = r110;
        int r113 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "clear editing for inactive state, noteId=" + r101 + ", reason=" + r211 + ", source=" + r212 + ", inactiveKind=" + r105 + ", hasWindowFocus=" + hasWindowFocus() + ", appFront=" + y() + ", imeVisible=" + this.f406959J + ", active=" + this.f406969h + ", focused=" + this.f406973k + ", resume=" + this.f406977n + ", editingState=" + this.f406972j + ", editingTarget=" + this.f406971i);
        this.f406975l = null;
        StringBuilder r106 = new StringBuilder();
        r106.append(r211);
        r106.append(':');
        r106.append(r105);
        r106.append(':');
        r106.append(r212);
        j(r106.toString());
        goto L38
    L15:
        if (hasWindowFocus() == false) goto L17;
    L19:
        r102 = false;
        goto L20
    L17:
        if (y() == false) goto L19;
    L10:
        r101 = r210;
        goto L12
    L5:
        if (y() == false) goto L7;
        return false;
    }

    public /* synthetic */ AINoteListView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void b(AINoteListView r100, long r101, String r110, int r111) {
        r100.getClass();
        if (r111 > 0) goto L5;
        r100.post(new com.ss.android.ainote.list.q(r100, r101, r110));
        return;
    L5:
        r100.postDelayed(new r(r100, r101, r110, r111), 16);
    }

    public static final void c(AINoteListView r100, long r110, String r111, String r112) {
        Long r101 = r100.getEditingNoteId();
        if (r100.M(r110) == false) goto L6;
        int r113 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "dispatchBlur skip for image preview return, noteId=" + r110 + ", textLength=" + r111.length() + ", active=" + r100.f406969h + ", focused=" + r100.f406973k + ", previewReturnNoteId=" + r100.f406980p0);
        r100.A(r110, "image_preview_blur");
        r100.O();
        return;
    L6:
        if (r100.f406972j != EditingState.RECOVERABLE_BLUR) goto L12;
        if (r101 == null) goto L12;
        if (r101.longValue() != r110) goto L12;
        int r114 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "dispatchBlur skip for recoverable editing, noteId=" + r110 + ", textLength=" + r111.length() + ", active=" + r100.f406969h + ", focused=" + r100.f406973k + ", editingTarget=" + r100.f406971i);
        r100.f406973k = null;
        r100.O();
        return;
    L12:
        int r102 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteListView", "dispatchBlur, noteId=" + r110 + ", textLength=" + r111.length() + ", imeVisible=" + r100.f406959J + ", active=" + r100.f406969h + ", focused=" + r100.f406973k + ", resume=" + r100.f406977n + ", hasAnyEditFocus=" + r100.u() + ", hasWindowFocus=" + r100.hasWindowFocus() + ", editingState=" + r100.f406972j + ", editingTarget=" + r100.f406971i + ", blurReason=" + r112);
        r100.f406975l = null;
        StringBuilder r103 = new StringBuilder("dispatchBlur:");
        r103.append(r110);
        r100.j(r103.toString());
        r100.O();
        Function3<? super Long, ? super String, ? super String, Unit> r104 = r100.f406989y;
        if (r104 == null) goto L15;
        r104.invoke(Long.valueOf(r110), r111, r112);
    L15:
        r100.post(new s(r100));
    }

    public final void e(List<xra.a> r100, r0 r101, AINoteScene r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r110, "scene");
        long r102 = SystemClock.elapsedRealtime();
        int r103 = com.ss.android.ainote.t.f407207a;
        StringBuilder r104 = new StringBuilder("bind, itemCount=");
        r104.append(r100.size());
        r104.append(", hasDelegate=");
        if (r101 == null) goto L5;
        boolean r105 = true;
    L6:
        r104.append(r105);
        com.ss.android.ainote.t.d("AINoteListView", r104.toString());
        F(this.f406967g, r100);
        this.f406967g = r100;
        this.f406964d = r101;
        this.f406966f = r110;
        this.f406965e = r111;
        AINoteAdapter r106 = this.f406963c;
        r106.f406854o = r101;
        Intrinsics.checkNotNullParameter(r110, "scene");
        r106.f406855p = r110;
        this.f406963c.f406862w = r111;
        if (v(this.f406986v) == true) goto L9;
        m();
    L9:
        O();
        E();
        Long r107 = getEditingNoteId();
        com.ss.android.ainote.t.d("AINoteListView", "bind->setItemsFromSession, editingNoteId=" + r107 + ", focusState=active=" + this.f406969h + " focused=" + this.f406973k + " editingState=" + this.f406972j + " editingTarget=" + this.f406971i + " previewReturnPending=" + this.f406974k0 + " previewReturnNoteId=" + this.f406980p0);
        AINoteAdapter r112 = this.f406963c;
        r112.f406860u = r107;
        Intrinsics.checkNotNullParameter(r100, "newItems");
        r112.f406853n = true;
        r112.z2(r100, true);
        H();
        if (this.P0 == false) goto L13;
        this.P0 = false;
        C();
    L13:
        if (r100.isEmpty() == false) goto L15;
        AINoteListState r113 = AINoteListState.EMPTY;
    L16:
        N(r113);
        com.ss.android.ainote.t.d("AINoteListView", "[timing][bind], itemCount=" + r100.size() + ", editingNoteId=" + r107 + ", state=" + this.I + " costMs=" + (SystemClock.elapsedRealtime() - r102));
        return;
    L15:
        r113 = AINoteListState.CONTENT;
        goto L16
    L5:
        r105 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L6;
        if (r101 != r103) goto L6;
        return;
    L6:
        H();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        H();
        int r105 = r104 - r102;
        int r106 = this.L0;
        this.L0 = r105;
        if (r100 == false) goto L14;
        if (r106 < 0) goto L15;
        if (r106 == r105) goto L17;
        Long r107 = this.f406973k;
        if (r107 == null) goto L16;
        long r108 = r107.longValue();
        if (z() == true) goto L12;
        return;
    L12:
        post(new i(this, r108));
        return;
    L16:
        return;
    L17:
        return;
    L15:
        return;
    }
}
