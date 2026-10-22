package com.ss.android.lark.search.ui.result;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.openplatform.base.container.api.lifecycle.OPContainerLifecycleEventEnum;
import com.ss.android.lark.picker.base.utils.EmptyViewManager;
import com.ss.android.lark.search.baseview.SearchPtrFooter;
import com.ss.android.lark.search.doubao.chat.empty.DoubaoSearchEmptyView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.ui.result.constant.ShowExpandFoldBar;
import com.ss.android.lark.search.ui.result.utils.DataUpdateHelper;
import com.ss.android.lark.search.ui.result.view.NoNetView;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.utils.y0;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.tencent.open.SocialConstants;
import j4c.r;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v3c.j;
import v3c.k;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ÿ\u00012\u00020\u00012\u00020\u0002:\u0018ÿ\u0001\u0080\u0002\u0081\u0002\u0082\u0002\u0083\u0002\u0084\u0002\u0085\u0002\u0086\u0002\u0087\u0002\u0088\u0002\u0089\u0002\u008a\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010_\u001a\u00020`H\u0002J\u000e\u0010a\u001a\u00020`2\u0006\u0010b\u001a\u00020cJ.\u0010d\u001a\u00020`\"\u0004\b\u0000\u0010e2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002He0g2\u0012\u0010h\u001a\u000e\u0012\u0006\b\u0000\u0012\u0002He\u0012\u0002\b\u00030iJI\u0010d\u001a\u00020`\"\u0004\b\u0000\u0010e2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002He0g2-\u0010j\u001a)\u0012\u0013\u0012\u00110I¢\u0006\f\bl\u0012\b\bm\u0012\u0004\b\b(n\u0012\u0010\u0012\u000e\u0012\u0006\b\u0000\u0012\u0002He\u0012\u0002\b\u00030i0kJ\u000e\u0010o\u001a\u00020`2\u0006\u0010p\u001a\u00020qJ\b\u0010r\u001a\u00020`H\u0002J\b\u0010s\u001a\u00020`H\u0002J\u000e\u0010t\u001a\u00020`2\u0006\u0010u\u001a\u00020\u0011J\u000e\u0010v\u001a\u00020`2\u0006\u0010w\u001a\u00020PJ\u0014\u0010x\u001a\u00020`2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020>0zJ\u0014\u0010{\u001a\u00020`2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020>0zJ\u0014\u0010|\u001a\u00020`2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020>0zJ\b\u0010~\u001a\u00020`H\u0002J\b\u0010\u007f\u001a\u00020`H\u0002J\t\u0010\u0080\u0001\u001a\u00020`H\u0002J\t\u0010\u0081\u0001\u001a\u00020`H\u0002J\u0007\u0010\u0082\u0001\u001a\u00020`J\u0007\u0010\u0083\u0001\u001a\u00020`J\u0019\u0010\u0084\u0001\u001a\u00020`2\u0007\u0010\u0085\u0001\u001a\u00020A2\u0007\u0010\u0086\u0001\u001a\u00020JJ\u0007\u0010\u0087\u0001\u001a\u00020AJ\u000e\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010zJ\u0014\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010z*\u00020\u000bH\u0002J\u0007\u0010\u008b\u0001\u001a\u00020`J\u0012\u0010\u008b\u0001\u001a\u00020`2\t\b\u0002\u0010\u008c\u0001\u001a\u00020JJ.\u0010\u008d\u0001\u001a\u00020`2\u0007\u0010\u008e\u0001\u001a\u00020P2\u0007\u0010\u008f\u0001\u001a\u00020P2\u0007\u0010\u0090\u0001\u001a\u00020A2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001J\u0007\u0010\u0093\u0001\u001a\u00020`J\u0010\u0010\u0094\u0001\u001a\u00020`2\u0007\u0010\u0095\u0001\u001a\u00020PJ&\u0010\u0094\u0001\u001a\u00020`2\u0007\u0010\u0095\u0001\u001a\u00020P2\t\b\u0002\u0010\u0096\u0001\u001a\u00020J2\t\b\u0002\u0010\u0097\u0001\u001a\u00020AJ\u0007\u0010\u0098\u0001\u001a\u00020`J\u0007\u0010\u0099\u0001\u001a\u00020`J\u001a\u0010\u009a\u0001\u001a\u00020`2\u000b\b\u0002\u0010\u009b\u0001\u001a\u0004\u0018\u00010A¢\u0006\u0003\u0010\u009c\u0001J\u0010\u0010\u009d\u0001\u001a\u00020`2\u0007\u0010\u009e\u0001\u001a\u00020AJ\t\u0010\u009f\u0001\u001a\u00020`H\u0002J%\u0010 \u0001\u001a\u00020`2\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010A2\t\u0010¢\u0001\u001a\u0004\u0018\u00010A¢\u0006\u0003\u0010£\u0001J\t\u0010¤\u0001\u001a\u00020`H\u0002J\u0007\u0010¥\u0001\u001a\u00020`J\u0010\u0010¦\u0001\u001a\u00020`2\u0007\u0010§\u0001\u001a\u00020AJ\u001c\u0010¨\u0001\u001a\u00020`2\u0007\u0010§\u0001\u001a\u00020A2\n\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001J\u0010\u0010«\u0001\u001a\u00020`2\u0007\u0010¬\u0001\u001a\u00020JJ\u0013\u0010\u00ad\u0001\u001a\u00020`2\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001J\u0010\u0010°\u0001\u001a\u00020`2\u0007\u0010±\u0001\u001a\u00020AJ\u0012\u0010²\u0001\u001a\u00020`2\t\u0010³\u0001\u001a\u0004\u0018\u000103J\u0010\u0010´\u0001\u001a\u00020`2\u0007\u0010µ\u0001\u001a\u000205J\u0010\u0010¶\u0001\u001a\u00020`2\u0007\u0010·\u0001\u001a\u000207J\u0010\u0010¸\u0001\u001a\u00020`2\u0007\u0010¹\u0001\u001a\u000209J\u0010\u0010º\u0001\u001a\u00020`2\u0007\u0010»\u0001\u001a\u00020;J\u0010\u0010¼\u0001\u001a\u00020`2\u0007\u0010½\u0001\u001a\u00020AJ\u0007\u0010¾\u0001\u001a\u00020`J\u0012\u0010¿\u0001\u001a\u00020`2\u0007\u0010À\u0001\u001a\u00020JH\u0002J\u0007\u0010Á\u0001\u001a\u00020AJ\u0010\u0010Ã\u0001\u001a\u00020`2\u0007\u0010Ä\u0001\u001a\u00020JJ\u0011\u0010Ç\u0001\u001a\u00020`2\b\u0010È\u0001\u001a\u00030Æ\u0001J\u0011\u0010É\u0001\u001a\u00020`2\b\u0010Ê\u0001\u001a\u00030Ë\u0001J\u0011\u0010Ì\u0001\u001a\u00020`2\b\u0010Í\u0001\u001a\u00030Î\u0001J\u0011\u0010Ï\u0001\u001a\u00020`2\b\u0010Ð\u0001\u001a\u00030Ñ\u0001J\u0011\u0010Ò\u0001\u001a\u00020`2\b\u0010Ó\u0001\u001a\u00030Ô\u0001J\u0010\u0010Õ\u0001\u001a\u00020`2\u0007\u0010Ö\u0001\u001a\u00020JJ\u0010\u0010×\u0001\u001a\u00020`2\u0007\u0010Ø\u0001\u001a\u00020JJ\u0010\u0010Ù\u0001\u001a\u00020`2\u0007\u0010Ú\u0001\u001a\u00020JJ\u0010\u0010Û\u0001\u001a\u00020`2\u0007\u0010Ü\u0001\u001a\u00020JJ\u0010\u0010Ý\u0001\u001a\u00020`2\u0007\u0010Ý\u0001\u001a\u00020JJ\u0010\u0010Þ\u0001\u001a\u00020`2\u0007\u0010Þ\u0001\u001a\u00020JJ\u0011\u0010ß\u0001\u001a\u00020`2\b\u0010à\u0001\u001a\u00030á\u0001J\u0011\u0010â\u0001\u001a\u00020`2\b\u0010ã\u0001\u001a\u00030ä\u0001J\u001e\u0010å\u0001\u001a\u00020`2\u0015\u0010æ\u0001\u001a\u0010\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020A\u0018\u00010kJ\u0011\u0010ç\u0001\u001a\u00020`2\b\u0010æ\u0001\u001a\u00030è\u0001J\u0011\u0010é\u0001\u001a\u00020`2\b\u0010æ\u0001\u001a\u00030ê\u0001J\u0010\u0010ë\u0001\u001a\u00020`2\u0007\u0010ì\u0001\u001a\u00020\u0011J\u0011\u0010í\u0001\u001a\u00020`2\b\u0010ã\u0001\u001a\u00030î\u0001J\u0007\u0010ï\u0001\u001a\u00020`J\u0007\u0010ð\u0001\u001a\u00020`J\u0011\u0010ñ\u0001\u001a\u00020`2\b\u0010ò\u0001\u001a\u00030ó\u0001J\u0010\u0010ô\u0001\u001a\u00020`2\u0007\u0010õ\u0001\u001a\u00020>J\u0007\u0010ö\u0001\u001a\u00020`J\u0007\u0010÷\u0001\u001a\u00020`J\u0007\u0010ø\u0001\u001a\u00020`J\u0007\u0010ù\u0001\u001a\u00020`J\t\u0010ú\u0001\u001a\u00020`H\u0007J\t\u0010û\u0001\u001a\u00020`H\u0007J\t\u0010ü\u0001\u001a\u00020`H\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u0083.¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0083.¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001a\u001a\u00020\u001b8\u0002@\u0002X\u0083.¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001f\u0010\u0017R(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082.¢\u0006\u0002\n\u0000R$\u0010K\u001a\u00020J2\u0006\u0010 \u001a\u00020J8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010Q\u001a\u00020P2\u0006\u0010 \u001a\u00020P8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010V\u001a\u00020J2\u0006\u0010 \u001a\u00020J8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010M\"\u0004\bX\u0010OR\u000e\u0010Y\u001a\u00020ZX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Â\u0001\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Å\u0001\u001a\u0005\u0018\u00010Æ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ý\u0001\u001a\u00030þ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008b\u0002"}, d2 = {"Lcom/ss/android/lark/search/ui/result/SearchResultView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mResultRV", "Landroidx/recyclerview/widget/RecyclerView;", "mSearchResultPtrFL", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "searchLoadingTxt", "Landroid/widget/TextView;", "mSearchResultLoadingView", "Landroid/view/View;", "rvSkeletonScreen", "Lcom/ethanhua/skeleton/RecyclerViewSkeletonScreen;", "mSearchErrorInfoView", "mSearchResultEmptyView", "getMSearchResultEmptyView$annotations", "()V", "mSearchEmptyHintText", "getMSearchEmptyHintText$annotations", "mSearchEmptyHintImage", "Landroid/widget/ImageView;", "getMSearchEmptyHintImage$annotations", "emptyViewManager", "Lcom/ss/android/lark/search/ui/result/utils/EmptyViewManager;", "getEmptyViewManager$annotations", "value", "Lcom/ss/android/lark/search/ui/result/view/IColdAndHotEmptyView;", "mSearchResultEmptyViewInterface", "getMSearchResultEmptyViewInterface", "()Lcom/ss/android/lark/search/ui/result/view/IColdAndHotEmptyView;", "setMSearchResultEmptyViewInterface", "(Lcom/ss/android/lark/search/ui/result/view/IColdAndHotEmptyView;)V", "mSearchResultHeadContainer", "weakNetLimitView", "Lcom/ss/android/lark/search/ui/result/view/WeakNetLimitView;", "noNetView", "Lcom/ss/android/lark/search/ui/result/view/NoNetView;", "mSearchRsultRelatelayout", "Landroid/widget/RelativeLayout;", "ceilingExpandFoldBar", "Lcom/ss/android/lark/search/ui/result/view/CeilingExpandFoldBar;", "mSearchResultAdapter", "Lcom/ss/android/lark/search/ui/result/SearchResultAdapter;", "mClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "mOnLoadMore", "Lcom/ss/android/lark/search/ui/result/SearchResultView$IOnLoadMore;", "mWeakNetErrorCallback", "Lcom/ss/android/lark/search/ui/result/SearchResultView$WeakNetErrorCallback;", "mNoNetErrorCallback", "Lcom/ss/android/lark/search/ui/result/SearchResultView$NoNetErrorCallback;", "mExpandFoldDepartmentCallback", "Lcom/ss/android/lark/search/ui/result/SearchResultView$IExpandFoldDepartmentCallback;", "mResultData", "Ljava/util/LinkedHashSet;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/LinkedHashSet;", "itemHeight", "", "defaultItemCount", "mScrolledPx", "getMScrolledPx", "()I", "setMScrolledPx", "(I)V", "binderConfig", "Lcom/ss/android/lark/search/ui/result/BinderConfig;", "", "mIsEnableChatPreview", "getMIsEnableChatPreview", "()Z", "setMIsEnableChatPreview", "(Z)V", "", NativeDownloadModel.JsonKey.SCENE, "getMScene", "()Ljava/lang/String;", "setMScene", "(Ljava/lang/String;)V", "mBindTagWithDynamicTag", "getMBindTagWithDynamicTag", "setMBindTagWithDynamicTag", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "errorInfoManager", "Lcom/ss/android/lark/search/ui/result/utils/ErrorInfoManager;", "dataUpdateHelper", "Lcom/ss/android/lark/search/ui/result/utils/DataUpdateHelper;", "initViews", "", "resisterOuterFactory", "factory", "Lcom/ss/android/lark/search/ui/result/binder/factory/IItemBinderFactory;", "registerCustomDelegate", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "delegate", "Lcom/ss/android/lark/search/ui/result/adapter/ItemBinderDelegate;", "generalDelegate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "config", "showCeilingExpandFoldBarIfNeed", "showExpandFoldBar", "Lcom/ss/android/lark/search/ui/result/constant/ShowExpandFoldBar;", "initOnLoadMore", "resetViewBeforeShowData", "setLoadingFooter", ContainerPosition.FOOTER, "setLoadingText", "txt", "showResult", "data", "", "resetResult", "refreshResult", "selectedList", "observeShowCeilingExpandBar", "resetShowCeilingBarStatus", "showCeilingExpandBar", "hideCeilingExpandBar", "showDepartmentDetail", "hideDepartmentDetail", "resultScrollToPosition", "position", "smooth", "findFirstVisiblePosition", "findVisibleViewHolders", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getVisibleViewHolders", DyPayConstant.KEY_SHOW_LOADING, "withSkeleton", "showErrorInfo", SocialConstants.PARAM_APP_DESC, WikiFolderPushPlugin.OPT, "opType", "icon", "Lcom/bytedance/lark/pb/basic/v1/UDIcon;", "errorInfoOperatorLoadMore", "showEmpty", "query", "isChatDefault", "chatType", "hideAllResultAboutView", "emptyLoadMore", "showWeakNetNotice", "uiType", "(Ljava/lang/Integer;)V", "setWeakNetLimitViewTopMargin", "topMargin", "hideWeakNetNotice", "showNoNetNotice", "bgColor", "errorType", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "hideNoNetNotice", "hideUtilityView", "setColdAndHotType", "coldAndHotType", "setColdAndHotTypeAndRemindSetting", "remindSetting", "Lcom/ss/android/lark/search/dto/service/MessageRemindSetting;", "hotToColdLoadingView", "loading", "updateEmptyKnowledgeView", "knowledgeSearchInfo", "Lcom/ss/android/lark/search/dto/info/KnowledgeInSearchInfo;", "setBottomLoadingState", "bottomLoadingState", "setClickHandler", "clickHandler", "setOnLoadMore", "onLoadMore", "setWeakNetErrorCallback", "weakNetErrorCallback", "setNoNetErrorCallback", "nNetErrorCallback", "setExpandFoldDepartmentCallback", "callback", "updateLoadingTopMargin", "marginTop", "defaultShow", "showEmptyView", "show", "totalSize", "mNeedLoadMore", "setNeedLoadMore", "needLoadMore", "mOnResultScroll", "Lcom/ss/android/lark/search/ui/result/SearchResultView$IOnResultScroll;", "setOnResultScroll", "onResultScroll", "setOnClickEmptyView", "onClickEmptyView", "Lcom/ss/android/lark/search/ui/result/SearchResultView$IOnClickEmptyView;", "setEmptyViewColdAndHotListener", "emptyViewClickListener", "Lcom/ss/android/lark/search/ui/result/utils/EmptyViewManager$IEmptyViewColdAndHotListener;", "setColdAndHotDataHelper", "coldAndHotDataUpdateHelper", "Lcom/ss/android/lark/search/ui/result/utils/DataUpdateHelper$IColdAndHotDataHelper;", "setOnClickErrorOperatorListener", "operatorListener", "Lcom/ss/android/lark/search/ui/result/utils/ErrorInfoManager$IErrorInfoOperator;", "switchMultiple", "isMultiple", "setSingleChoiceMode", "isSingleChoice", "setDisableRightViewHolder", "disableRightViewHolder", "setDisableExtraInfoSummary", "disableExtraInfoSummary", "showDivider", "disableExternalChatter", "setCustomBinder", "customBinder", "Lcom/ss/android/lark/search/dto/SearchItemInterface$ISearchItemCustomBinder;", "setOnItemOnScreenListener", "listener", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemOnScreenListener;", "setCalendarColorProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "setListContextProvider", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IListContextProvider;", "setListContextProviderAdapter", "Lcom/ss/android/lark/search/dto/SearchItemInterface$ListContextProviderAdapter;", "setHeadCustomView", "customView", "setAppShortCutClickListener", "Lcom/ss/android/lark/search/ui/result/action/AppShortCutClickListener;", "clearHeadCustomView", "onConfigurationChanged", "updateFileContent", "fileContent", "Lcom/ss/android/lark/chat/entity/message/content/FileContent;", "notifyItemUpdate", "baseInfo", "erasePadding", "erasePaddingTop", "bgBase", "bgBody", "onPause", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "state", "Lcom/ss/android/lark/search/ui/result/SearchResultView$STATE;", "Companion", "IOnLoadMore", "IOnResultScroll", "IOnClickEmptyView", "CheckBoxBindStatus", "IOnBusinessConsumeItem", "STATE", "WeakNetErrorCallback", "NoNetErrorCallback", "IExpandFoldDepartmentCallback", "IOnWeakNetRetryClickListener", "ICeilingExpandBarListener", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchResultView extends FrameLayout implements LifecycleObserver {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public STATE B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f440256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LKUIPtrClassicFrameLayout f440257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f440258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f440259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public lt7.a f440260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f440261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f440262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f440263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f440264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i4c.a f440265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public r f440266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f440267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public NoNetView f440268m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RelativeLayout f440269n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SearchResultAdapter f440270o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public v3c.g f440271p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f440272q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f f440273r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinkedHashSet<SearchBaseInfo> f440274s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f440275t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f440276u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f440277v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BinderConfig f440278w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public UDLoadingDrawable f440279x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final i4c.d f440280y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DataUpdateHelper f440281z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/search/ui/result/SearchResultView$STATE;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LOADING", "RESULT_EMPTY", "RESULT", "ERROR_INFO", "search-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum STATE extends Enum<STATE> {
        public static final STATE DEFAULT = null;
        public static final STATE ERROR_INFO = null;
        public static final STATE LOADING = null;
        public static final STATE RESULT = null;
        public static final STATE RESULT_EMPTY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ STATE[] f440282a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440283b = null;

        public static EnumEntries<STATE> getEntries() {
            return f440283b;
        }

        static {
            STATE r100 = new STATE("DEFAULT", 0);
            DEFAULT = r100;
            STATE r101 = new STATE("LOADING", 1);
            LOADING = r101;
            STATE r102 = new STATE("RESULT_EMPTY", 2);
            RESULT_EMPTY = r102;
            STATE r103 = new STATE("RESULT", 3);
            RESULT = r103;
            STATE r104 = new STATE("ERROR_INFO", 4);
            ERROR_INFO = r104;
            STATE[] r105 = {r100, r101, r102, r103, r104};
            f440282a = r105;
            f440283b = EnumEntriesKt.enumEntries(r105);
        }

        public static STATE[] values() {
            return (STATE[]) f440282a.clone();
        }

        public static STATE valueOf(String r100) {
            return (STATE) r27.a.a(STATE.class, r100);
        }

        public STATE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
        boolean canLoadMore();

        void onLoadMore();
    }

    public interface e {
    }

    public interface f {
        void a();

        void retry();
    }

    public interface g {
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchResultView f440284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f440285b;

        public h(SearchResultView r100) {
            this.f440284a = r100;
            this.f440285b = false;
        }

        public final void a() {
            this.f440284a.B = STATE.LOADING;
            Log.d(com.ss.android.lark.picker.base.view.SearchResultView.TAG, "post showLoading");
            this.f440284a.e(false);
            View r100 = this.f440284a.f440261f;
            RecyclerView r101 = null;
            UDLoadingDrawable r102 = null;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchErrorInfoView");
            r100 = null;
        L5:
            r100.setVisibility(8);
            this.f440284a.b();
            if (this.f440285b == true) goto L21;
            View r103 = this.f440284a.f440259d;
            if (r103 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
            r103 = null;
        L10:
            r103.setVisibility(0);
            LKUIPtrClassicFrameLayout r104 = this.f440284a.f440257b;
            if (r104 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
            r104 = null;
        L13:
            r104.setVisibility(8);
            UDLoadingDrawable r105 = this.f440284a.f440279x;
            if (r105 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
            r105 = null;
        L16:
            r105.stop();
            UDLoadingDrawable r106 = this.f440284a.f440279x;
            if (r106 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        L20:
            r102.start();
            return;
        L19:
            r102 = r106;
            goto L20
        L21:
            View r107 = this.f440284a.f440259d;
            if (r107 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
            r107 = null;
        L24:
            r107.setVisibility(8);
            LKUIPtrClassicFrameLayout r108 = this.f440284a.f440257b;
            if (r108 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
            r108 = null;
        L27:
            r108.setVisibility(0);
            SearchResultView r109 = this.f440284a;
            lt7.a r110 = r109.f440260e;
            if (r110 == null) goto L31;
            r110.b();
            return;
        L31:
            if (r109.f440275t <= 0) goto L33;
            int r111 = (r109.getHeight() / r109.f440275t) + 1;
        L34:
            if (r111 > 0) goto L36;
            r111 = r109.f440276u;
        L36:
            RecyclerView r112 = r109.f440256a;
            if (r112 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("mResultRV");
            r112 = null;
        L39:
            lt7.a.C6735a r113 = new lt7.a.C6735a(r112);
            RecyclerView r114 = r109.f440256a;
            if (r114 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("mResultRV");
        L43:
            r113.f510682a = r101.getAdapter();
            r113.f510686e = R.layout.view_search_biz_skeleton_layout;
            r113.f510684c = true;
            r113.f510689h = 20;
            r113.f510687f = ContextCompat.getColor(r112.getContext(), R.color.bg_body);
            r113.f510685d = r111;
            r113.f510688g = 1000;
            r113.f510690i = true;
            lt7.a r115 = new lt7.a(r113);
            r115.b();
            r109.f440260e = r115;
            return;
        L42:
            r101 = r114;
            goto L43
        L33:
            r111 = r109.f440276u;
            goto L34
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

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchResultView f440286a;

        public i(SearchResultView r100, NoNetView r101) {
            this.f440286a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            f r101 = this.f440286a.f440273r;
            if (r101 == null) goto L6;
            r101.retry();
            return;
        }
    }

    static {
    }

    @Deprecated(message = "Use SearchResultView.mSearchResultEmptyViewInterface instead")
    private static /* synthetic */ void getEmptyViewManager$annotations() {
    }

    @Deprecated(message = "Use SearchResultView.mSearchResultEmptyViewInterface instead")
    private static /* synthetic */ void getMSearchEmptyHintImage$annotations() {
    }

    @Deprecated(message = "Use SearchResultView.mSearchResultEmptyViewInterface instead")
    private static /* synthetic */ void getMSearchEmptyHintText$annotations() {
    }

    @Deprecated(message = "Use SearchResultView.mSearchResultEmptyViewInterface instead")
    private static /* synthetic */ void getMSearchResultEmptyView$annotations() {
    }

    public final void setExpandFoldDepartmentCallback(b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    public final void setOnResultScroll(e r100) {
        Intrinsics.checkNotNullParameter(r100, "onResultScroll");
    }

    public final void setWeakNetErrorCallback(g r100) {
        Intrinsics.checkNotNullParameter(r100, "weakNetErrorCallback");
    }

    public final void setWeakNetLimitViewTopMargin(int r100) {
    }

    public final void a() {
        Log.d(com.ss.android.lark.picker.base.view.SearchResultView.TAG, "default_t!!!");
        STATE r100 = this.B;
        STATE r101 = STATE.DEFAULT;
        if (r100 != r101) goto L6;
        Log.d(com.ss.android.lark.picker.base.view.SearchResultView.TAG, "already default_t!!!");
        return;
    L6:
        this.B = r101;
        LKUIPtrClassicFrameLayout r102 = this.f440257b;
        SearchResultAdapter r103 = null;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r102 = null;
    L9:
        r102.setVisibility(0);
        View r104 = this.f440259d;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r104 = null;
    L12:
        r104.setVisibility(8);
        lt7.a r105 = this.f440260e;
        if (r105 == null) goto L15;
        r105.a();
    L15:
        e(false);
        View r106 = this.f440261f;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchErrorInfoView");
        r106 = null;
    L18:
        r106.setVisibility(8);
        b();
        LKUIPtrClassicFrameLayout r107 = this.f440257b;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r107 = null;
    L21:
        r107.refreshComplete();
        this.f440274s.clear();
        SearchResultAdapter r108 = this.f440270o;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r108 = null;
    L24:
        r108.clear();
        this.f440277v = 0;
        UDLoadingDrawable r109 = this.f440279x;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r109 = null;
    L27:
        r109.stop();
        LinkedHashSet<SearchBaseInfo> r110 = this.f440274s;
        DataUpdateHelper r111 = this.f440281z;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, "dataSet");
        DataUpdateHelper.b(r110);
        if (r110.size() <= 0) goto L30;
        r111.a(r110, false);
    L30:
        SearchResultAdapter r112 = this.f440270o;
        if (r112 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    L34:
        r103.diff(r110);
        return;
    L33:
        r103 = r112;
        goto L34
    }

    public final void b() {
        NoNetView r100 = this.f440268m;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        f r101 = this.f440273r;
        if (r101 == null) goto L8;
        r101.a();
    L8:
        SearchResultAdapter r102 = null;
        UIUtils.setViewVisibility(null, 8);
        SearchResultAdapter r103 = this.f440270o;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r103 = null;
    L11:
        r103.f440255c.getClass();
        SearchResultAdapter r104 = this.f440270o;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r104 = null;
    L14:
        r104.f440255c.getClass();
        SearchResultAdapter r105 = this.f440270o;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    L18:
        r102.f440255c.getClass();
        return;
    L17:
        r102 = r105;
        goto L18
    }

    public final void c() {
        STATE r100 = this.B;
        STATE r101 = STATE.RESULT;
        if (r100 != r101) goto L6;
        Log.d(com.ss.android.lark.picker.base.view.SearchResultView.TAG, "already RESULT.");
        return;
    L6:
        this.B = r101;
        Log.i(com.ss.android.lark.picker.base.view.SearchResultView.TAG, "switch view state.");
        LKUIPtrClassicFrameLayout r102 = this.f440257b;
        UDLoadingDrawable r103 = null;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r102 = null;
    L9:
        r102.setVisibility(0);
        View r104 = this.f440259d;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r104 = null;
    L12:
        r104.setVisibility(8);
        lt7.a r105 = this.f440260e;
        if (r105 == null) goto L15;
        r105.a();
    L15:
        e(false);
        View r106 = this.f440261f;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchErrorInfoView");
        r106 = null;
    L18:
        r106.setVisibility(8);
        NoNetView r107 = this.f440268m;
        if (r107 == null) goto L21;
        r107.setVisibility(8);
    L21:
        f r108 = this.f440273r;
        if (r108 == null) goto L24;
        r108.a();
    L24:
        UDLoadingDrawable r109 = this.f440279x;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L28:
        r103.stop();
        return;
    L27:
        r103 = r109;
        goto L28
    }

    public final boolean getMBindTagWithDynamicTag() {
        SearchResultAdapter r100 = this.f440270o;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r100 = null;
    L6:
        return r100.f440255c.f440251h;
    }

    public final boolean getMIsEnableChatPreview() {
        SearchResultAdapter r100 = this.f440270o;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r100 = null;
    L6:
        return r100.f440255c.f440249f;
    }

    public final String getMScene() {
        SearchResultAdapter r100 = this.f440270o;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r100 = null;
    L6:
        return r100.f440255c.f440250g;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        SearchResultAdapter r100 = this.f440270o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r100 = null;
    L5:
        r100.f440255c.f440247d.a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        SearchResultAdapter r100 = this.f440270o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r100 = null;
    L5:
        Iterator r101 = ((LinkedHashMap) r100.f440255c.f440247d.f471036a).values().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((e4c.a) r101.next()).getClass();
        com.larksuite.component.blockit.b.a.f282974a.b();
        OPContainerLifecycleEventEnum r102 = OPContainerLifecycleEventEnum.ON_CREATE;
        ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).h();
        goto L7
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        SearchResultAdapter r100 = this.f440270o;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r100 = null;
    L5:
        Iterator r101 = ((LinkedHashMap) r100.f440255c.f440247d.f471036a).values().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((e4c.a) r101.next()).getClass();
        com.larksuite.component.blockit.b.a.f282974a.b();
        OPContainerLifecycleEventEnum r102 = OPContainerLifecycleEventEnum.ON_CREATE;
        ((com.larksuite.component.blockit.d) ApiUtils.getApi(com.larksuite.component.blockit.d.class)).h();
        goto L7
    }

    public final int getMScrolledPx() {
        return this.f440277v;
    }

    public final r getMSearchResultEmptyViewInterface() {
        return this.f440266k;
    }

    public SearchResultView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "query");
        Intrinsics.checkNotNullParameter(r110, "query");
        STATE r100 = this.B;
        STATE r101 = STATE.RESULT_EMPTY;
        if (r100 != r101) goto L5;
        Log.d(com.ss.android.lark.picker.base.view.SearchResultView.TAG, "already RESULT_EMPTY.");
        return;
    L5:
        this.B = r101;
        LKUIPtrClassicFrameLayout r102 = this.f440257b;
        SearchResultAdapter r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r102 = null;
    L8:
        r102.refreshComplete();
        boolean r104 = true;
        e(true);
        View r105 = this.f440261f;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchErrorInfoView");
        r105 = null;
    L11:
        r105.setVisibility(8);
        LKUIPtrClassicFrameLayout r106 = this.f440257b;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r106 = null;
    L14:
        r106.setVisibility(8);
        View r107 = this.f440259d;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r107 = null;
    L17:
        r107.setVisibility(8);
        lt7.a r108 = this.f440260e;
        if (r108 == null) goto L20;
        r108.a();
    L20:
        b();
        i4c.a r109 = this.f440265j;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "query");
        String r111 = "";
        if (r109.f488248e != 4) goto L77;
        ImageView r112 = r109.f488247d;
        if (r112 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r112 = null;
    L25:
        r112.setImageResource(R.drawable.illustration_empty_neutral_no_message_logging);
        i4c.a.c r113 = r109.f488253j;
        if (r113 == null) goto L29;
        String r114 = r113.a();
        if (r114 == null) goto L29;
    L31:
        if (r114.length() != 0) goto L33;
        boolean r115 = true;
    L34:
        if (r115 == true) goto L54;
        int r116 = StringsKt.indexOf$default(r114, "<b>", 0, false, 6, null);
        if (r116 < 0) goto L39;
        String r117 = r114.substring(0, r116);
    L40:
        int r118 = StringsKt.lastIndexOf$default(r114, "<b>", 0, false, 6, null);
        if (r118 < 0) goto L43;
        String r119 = r114.substring(r116 + 3, r118);
    L45:
        if (r117.length() != 0) goto L47;
        boolean r120 = true;
    L48:
        if (r120 == true) goto L50;
    L55:
        i4c.a.c r121 = r109.f488253j;
        if ((r121 instanceof i4c.a.b) == false) goto L58;
        i4c.a.b r122 = (i4c.a.b) r121;
    L59:
        if (r122 != null) goto L61;
    L63:
        r104 = false;
    L64:
        if (r104 == false) goto L66;
        r111 = "\n";
    L66:
        Pair r123 = new Pair(r117.concat(r111), r119);
    L68:
        if (r123 == null) goto L73;
        int r124 = ((String) r123.getFirst()).length();
        int r125 = ((String) r123.getSecond()).length() + r124;
        CharSequence r126 = y0.b(((String) r123.getFirst()) + ((String) r123.getSecond()), r124, ((String) r123.getFirst()).length() + ((String) r123.getSecond()).length(), (String) r123.getSecond(), UIHelper.getColor(R.color.lkui_B500));
        Intrinsics.checkNotNull(r126);
        CharSequence r127 = r109.a(r126, r124, r125);
        TextView r128 = r109.f488246c;
        if (r128 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r128 = null;
    L72:
        r128.setText(r127);
    L116:
        if (r109.f488249f == false) goto L121;
        View r129 = r109.f488245b;
        if (r129 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r129 = null;
    L120:
        y9c.d.k(r129);
    L121:
        r r130 = this.f440266k;
        if (r130 == null) goto L124;
        r130.a(r110);
    L124:
        UDLoadingDrawable r131 = this.f440279x;
        if (r131 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r131 = null;
    L127:
        r131.stop();
        LinkedHashSet<SearchBaseInfo> r132 = this.f440274s;
        this.f440281z.getClass();
        DataUpdateHelper.b(r132);
        SearchResultAdapter r133 = this.f440270o;
        if (r133 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    L131:
        r103.diff(r132);
        return;
    L130:
        r103 = r133;
        goto L131
    L73:
        String r134 = r109.f488244a.getResources().getString(R.string.Lark_Search_NoResultsFromPast1YearViewEarlier_EmptyState);
        String r135 = r109.f488244a.getResources().getString(R.string.Lark_Search_NoResultsFromPast1YearViewEarlier_Variable);
        int r136 = StringsKt.indexOf$default(r134, "{", 0, false, 6, null);
        int r137 = r135.length() + r136;
        CharSequence r138 = y0.b(UIHelper.mustacheFormat(r134, EmptyViewManager.VIEW_EARLIER, r135), r136, r137, r135, UIHelper.getColor(R.color.lkui_B500));
        Intrinsics.checkNotNull(r138);
        CharSequence r139 = r109.a(r138, r136, r137);
        TextView r140 = r109.f488246c;
        if (r140 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r140 = null;
    L76:
        r140.setText(r139);
        goto L116
    L61:
        if (r122.a() != true) goto L63;
    L58:
        r122 = null;
        goto L59
    L50:
        if (r119.length() != 0) goto L52;
        boolean r141 = true;
    L53:
        if (r141 == false) goto L55;
    L52:
        r141 = false;
        goto L53
    L47:
        r120 = false;
        goto L48
    L43:
        r119 = "";
        goto L45
    L39:
        r117 = "";
    L54:
        r123 = null;
        goto L68
    L33:
        r115 = false;
    L29:
        r114 = "";
        goto L31
    L77:
        i4c.a.c r142 = r109.f488253j;
        if (r142 == null) goto L80;
        r142.b();
    L81:
        ImageView r143 = r109.f488247d;
        if (r143 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r143 = null;
    L84:
        r143.setImageResource(R.drawable.illustration_placeholder_common_search_failed);
        if (r111 != null) goto L87;
    L90:
        boolean r144 = true;
    L91:
        if (r144 == true) goto L97;
        TextView r145 = r109.f488246c;
        if (r145 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r145 = null;
    L95:
        r145.setText(r111);
        goto L116
    L97:
        if (StringsKt.isBlank(r110) == false) goto L103;
        TextView r146 = r109.f488246c;
        if (r146 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r146 = null;
    L101:
        r146.setText(r109.f488244a.getResources().getText(R.string.Lark_Legacy_SearchNoAnyResult));
        goto L116
    L103:
        if (r109.f488250g == 0.0f) goto L106;
        r104 = false;
    L106:
        if (r104 == false) goto L111;
        TextView r147 = r109.f488246c;
        if (r147 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r147 = null;
    L110:
        r147.post(new i4c.c(r109, r110));
        goto L116
    L111:
        TextView r148 = r109.f488246c;
        if (r148 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r148 = null;
    L114:
        r109.b(r110, r148);
        goto L116
    L87:
        if (r111.length() == 0) goto L90;
        r144 = false;
        goto L91
    L80:
        r111 = null;
        goto L81
    }

    public final void e(boolean r100) {
        r r101 = this.f440266k;
        int r102 = 0;
        View r103 = null;
        if (r101 == null) goto L15;
        DoubaoSearchEmptyView r104 = r101.asView();
        if (r104 == null) goto L10;
        if (r100 == true) goto L9;
        r102 = 8;
    L9:
        r104.setVisibility(r102);
    L10:
        View r105 = this.f440262g;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
    L14:
        r103.setVisibility(8);
        return;
    L13:
        r103 = r105;
        goto L14
    L15:
        View r106 = this.f440262g;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
    L19:
        if (r100 == true) goto L22;
        r102 = 8;
    L22:
        r103.setVisibility(r102);
        return;
    L18:
        r103 = r106;
        goto L19
    }

    public final void f(boolean r100) {
        STATE r101 = this.B;
        STATE r102 = STATE.LOADING;
        if (r101 != r102) goto L6;
        Log.d(com.ss.android.lark.picker.base.view.SearchResultView.TAG, "already LOADING.");
        return;
    L6:
        this.B = r102;
        Log.d(com.ss.android.lark.picker.base.view.SearchResultView.TAG, DyPayConstant.KEY_SHOW_LOADING);
        this.f440277v = 0;
        LKUIPtrClassicFrameLayout r103 = this.f440257b;
        SearchResultAdapter r104 = null;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r103 = null;
    L9:
        r103.refreshComplete();
        this.f440274s.clear();
        SearchResultAdapter r105 = this.f440270o;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    L13:
        r104.clear();
        post(new h(this));
        return;
    L12:
        r104 = r105;
        goto L13
    }

    public final void setAppShortCutClickListener(d4c.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.getClass();
    }

    public final void setBottomLoadingState(int r100) {
        this.f440281z.f440310c = r100;
    }

    public final void setCalendarColorProvider(Function1<? super String, Integer> r100) {
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.f440252i = r100;
    }

    public final void setClickHandler(v3c.g r100) {
        this.f440271p = r100;
    }

    public final void setColdAndHotDataHelper(DataUpdateHelper.a r100) {
        Intrinsics.checkNotNullParameter(r100, "coldAndHotDataUpdateHelper");
        this.f440281z.f440311d = r100;
    }

    public final void setColdAndHotType(int r100) {
        this.f440265j.f488248e = r100;
        r r101 = this.f440266k;
        if (r101 == null) goto L5;
        r101.setColdAndHotType(r100);
    L5:
        this.f440281z.f440309b = r100;
    }

    public final void setCustomBinder(j r100) {
        Intrinsics.checkNotNullParameter(r100, "customBinder");
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.getClass();
    }

    public final void setDisableExtraInfoSummary(boolean r100) {
        SearchResultAdapter r101 = this.f440270o;
        SearchResultAdapter r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.getClass();
        SearchResultAdapter r103 = this.f440270o;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    L9:
        r102.notifyDataSetChanged();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setDisableRightViewHolder(boolean r100) {
        SearchResultAdapter r101 = this.f440270o;
        SearchResultAdapter r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.getClass();
        SearchResultAdapter r103 = this.f440270o;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    L9:
        r102.notifyDataSetChanged();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public final void setEmptyViewColdAndHotListener(i4c.a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "emptyViewClickListener");
        r r101 = this.f440266k;
        if (r101 == null) goto L5;
        r101.setEmptyViewColdAndHotListener(r100);
    L5:
        i4c.a r102 = this.f440265j;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "coldAndHotClickListener");
        r102.f488253j = r100;
    }

    public final void setHeadCustomView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "customView");
        FrameLayout r101 = this.f440267l;
        FrameLayout r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultHeadContainer");
        r101 = null;
    L5:
        r101.setVisibility(0);
        FrameLayout r103 = this.f440267l;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultHeadContainer");
        r103 = null;
    L8:
        r103.removeAllViews();
        FrameLayout r104 = this.f440267l;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultHeadContainer");
    L12:
        r102.addView(r100);
        return;
    L11:
        r102 = r104;
        goto L12
    }

    public final void setListContextProvider(v3c.e r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.getClass();
    }

    public final void setListContextProviderAdapter(k r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setLoadingFooter(View r100) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.FOOTER);
        if ((r100 instanceof com.ss.android.lark.widget.ptr.a) == false) goto L13;
        LKUIPtrClassicFrameLayout r101 = this.f440257b;
        LKUIPtrClassicFrameLayout r102 = null;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r101 = null;
    L7:
        r101.setFooterView(r100);
        LKUIPtrClassicFrameLayout r103 = this.f440257b;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
    L11:
        r102.addPtrUIHandler((com.ss.android.lark.widget.ptr.a) r100);
        return;
    L10:
        r102 = r103;
        goto L11
    }

    public final void setLoadingText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "txt");
        TextView r101 = this.f440258c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("searchLoadingTxt");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public final void setMBindTagWithDynamicTag(boolean r100) {
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.f440251h = r100;
    }

    public final void setMIsEnableChatPreview(boolean r100) {
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.f440249f = r100;
    }

    public final void setMScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        BinderConfig r102 = r101.f440255c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f440250g = r100;
    }

    public final void setMScrolledPx(int r100) {
        this.f440277v = r100;
    }

    public final void setMSearchResultEmptyViewInterface(r r100) {
        if (r100 == null) goto L4;
        addView(r100.asView(), new FrameLayout.LayoutParams(-1, -1));
    L4:
        this.f440266k = r100;
    }

    public final void setNeedLoadMore(boolean r100) {
        this.A = r100;
    }

    public final void setNoNetErrorCallback(f r100) {
        Intrinsics.checkNotNullParameter(r100, "nNetErrorCallback");
        this.f440273r = r100;
    }

    public final void setOnClickEmptyView(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickEmptyView");
        r r101 = this.f440266k;
        if (r101 == null) goto L5;
        r101.setOnClickEmptyView(r100);
    L5:
        this.f440265j.getClass();
        Intrinsics.checkNotNullParameter(r100, "onClickEmptyView");
    }

    public final void setOnClickErrorOperatorListener(i4c.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "operatorListener");
        this.f440280y.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final void setOnItemOnScreenListener(v3c.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        SearchResultAdapter r101 = this.f440270o;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.f440248e = r100;
    }

    public final void setOnLoadMore(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onLoadMore");
        this.f440272q = r100;
    }

    public final void setSingleChoiceMode(boolean r100) {
        SearchResultAdapter r101 = this.f440270o;
        SearchResultAdapter r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r101 = null;
    L5:
        r101.f440255c.getClass();
        SearchResultAdapter r103 = this.f440270o;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    L9:
        r102.notifyDataSetChanged();
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public SearchResultView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        i4c.a r102 = new i4c.a(getContext());
        this.f440265j = r102;
        this.f440274s = new LinkedHashSet();
        this.f440276u = 15;
        i4c.d r103 = new i4c.d(getContext());
        this.f440280y = r103;
        this.f440281z = new DataUpdateHelper(getContext());
        this.A = true;
        this.B = STATE.RESULT_EMPTY;
        LayoutInflater.from(r100).inflate(R.layout.view_search_biz_result, this, true);
        this.f440256a = (RecyclerView) findViewById(R.id.search_result_rv);
        this.f440257b = (LKUIPtrClassicFrameLayout) findViewById(R.id.search_result_ptr_fl);
        this.f440259d = findViewById(R.id.search_result_loading);
        this.f440258c = (TextView) findViewById(R.id.search_result_loading_txt);
        this.f440261f = findViewById(R.id.search_error_info_view);
        this.f440262g = findViewById(R.id.search_result_empty);
        this.f440263h = (TextView) findViewById(R.id.search_empty_hint);
        this.f440264i = (ImageView) findViewById(R.id.search_empty_iv);
        this.f440267l = (FrameLayout) findViewById(R.id.search_result_head_container);
        this.f440269n = (RelativeLayout) findViewById(R.id.result_layout);
        View r104 = this.f440261f;
        UDLoadingDrawable r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchErrorInfoView");
        r104 = null;
    L5:
        Intrinsics.checkNotNullParameter(r104, "containerView");
        r103.f488259b = r104;
        TextView r106 = (TextView) r104.findViewById(R.id.search_error_desc);
        ImageView r107 = (ImageView) r104.findViewById(R.id.search_error_iv);
        View r108 = this.f440262g;
        if (r108 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r108 = null;
    L8:
        TextView r109 = this.f440263h;
        if (r109 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintText");
        r109 = null;
    L11:
        ImageView r110 = this.f440264i;
        if (r110 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEmptyHintImage");
        r110 = null;
    L14:
        Intrinsics.checkNotNullParameter(r108, "emptyView");
        Intrinsics.checkNotNullParameter(r109, "emptyHintText");
        Intrinsics.checkNotNullParameter(r110, "emptyHintImage");
        r102.f488245b = r108;
        r102.f488246c = r109;
        r102.f488247d = r110;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultEmptyView");
        r108 = null;
    L17:
        r108.setOnClickListener(new i4c.b(r102));
        this.f440270o = new SearchResultAdapter(getContext());
        this.f440278w = new BinderConfig(getContext());
        Context r111 = getContext();
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        ShowExpandFoldBar r112 = ShowExpandFoldBar.SHOW_EXPAND_FOLD_BAR;
        BinderConfig r113 = this.f440278w;
        if (r113 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binderConfig");
        r113 = null;
    L20:
        com.ss.android.lark.search.ui.result.d r114 = new com.ss.android.lark.search.ui.result.d(this);
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r113.f440246c = r114;
        Intrinsics.checkNotNullParameter(new com.ss.android.lark.search.ui.result.e(this), "<set-?>");
        Intrinsics.checkNotNullParameter(r113, "binderConfig");
        SearchResultAdapter r115 = this.f440270o;
        if (r115 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r115 = null;
    L23:
        Intrinsics.checkNotNullParameter(r115, "adapter");
        if ((r115 instanceof SearchResultAdapter) == false) goto L27;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r115.f440255c = r113;
    L27:
        final RecyclerView r116 = this.f440256a;
        if (r116 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mResultRV");
        r116 = null;
    L30:
        zdc.h.b(r116);
        SearchResultAdapter r117 = this.f440270o;
        if (r117 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
        r117 = null;
    L33:
        r116.setAdapter(r117);
        r116.setLayoutManager(new LinearLayoutManager(r116.getContext(), 1, false));
        r116.addOnScrollListener(new SearchResultView$initViews$2$1(this, r116));
        SearchPtrFooter r118 = new SearchPtrFooter(getContext());
        LKUIPtrClassicFrameLayout r119 = this.f440257b;
        if (r119 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r119 = null;
    L36:
        r119.setKeepHeaderWhenRefresh(true);
        LKUIPtrClassicFrameLayout r120 = this.f440257b;
        if (r120 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r120 = null;
    L39:
        r120.setFooterView(r118);
        LKUIPtrClassicFrameLayout r121 = this.f440257b;
        if (r121 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r121 = null;
    L42:
        r121.addPtrUIHandler(r118);
        LKUIPtrClassicFrameLayout r122 = this.f440257b;
        if (r122 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r122 = null;
    L45:
        r122.disableWhenHorizontalMove(true);
        LKUIPtrClassicFrameLayout r123 = this.f440257b;
        if (r123 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r123 = null;
    L48:
        r123.setForceBackWhenComplete(true);
        LKUIPtrClassicFrameLayout r124 = this.f440257b;
        if (r124 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r124 = null;
    L51:
        r124.setEnableScrollContentAfterLoad(true);
        LKUIPtrClassicFrameLayout r125 = this.f440257b;
        if (r125 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r125 = null;
    L54:
        r125.setPtrHandler(new com.ss.android.lark.search.ui.result.c(this));
        UDLoadingDrawable r126 = new UDLoadingDrawable(getContext());
        r126.setColorSchemeColors(new int[]{y9c.d.c(getContext(), R.color.primary_fill_default)});
        this.f440279x = r126;
        ImageView r127 = (ImageView) findViewById(R.id.search_result_loading_img);
        UDLoadingDrawable r128 = this.f440279x;
        if (r128 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
    L58:
        r127.setImageDrawable(r105);
        this.f440275t = com.larksuite.framework.utils.UIUtils.dp2px(getContext(), 66.0f);
        return;
    L57:
        r105 = r128;
        goto L58
    }

    public final void g(Integer r100, Integer r101) {
        STATE r102 = this.B;
        STATE r103 = STATE.RESULT_EMPTY;
        if (r102 != r103) goto L6;
        Log.d(com.ss.android.lark.picker.base.view.SearchResultView.TAG, "already RESULT_EMPTY and no internet");
        return;
    L6:
        this.B = r103;
        SearchResultAdapter r104 = null;
        if (this.f440268m != null) goto L14;
        if (r100 == null) goto L14;
        ViewStub r105 = (ViewStub) findViewById(R.id.vs_no_net_notice);
        if (r105 == null) goto L12;
        NoNetView r106 = (NoNetView) r105.inflate().findViewById(R.id.no_net_notice);
        r106.setBgColor(r100.intValue());
        ((TextView) r106.findViewById(R.id.tv_retry_click)).setOnClickListener(new i(this, r106));
    L13:
        this.f440268m = r106;
        goto L14
    L12:
        r106 = null;
    L14:
        NoNetView r107 = this.f440268m;
        if (r107 == null) goto L40;
        r107.setErrorType(r101);
        r107.setVisibility(0);
        f r108 = this.f440273r;
        if (r108 == null) goto L19;
        r108.a();
    L19:
        View r109 = this.f440259d;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultLoadingView");
        r109 = null;
    L22:
        r109.setVisibility(8);
        lt7.a r110 = this.f440260e;
        if (r110 == null) goto L25;
        r110.a();
    L25:
        e(false);
        View r111 = this.f440261f;
        if (r111 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchErrorInfoView");
        r111 = null;
    L28:
        r111.setVisibility(8);
        LKUIPtrClassicFrameLayout r112 = this.f440257b;
        if (r112 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultPtrFL");
        r112 = null;
    L31:
        r112.setVisibility(8);
        UDLoadingDrawable r113 = this.f440279x;
        if (r113 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");
        r113 = null;
    L34:
        r113.stop();
        LinkedHashSet<SearchBaseInfo> r114 = this.f440274s;
        this.f440281z.getClass();
        DataUpdateHelper.b(r114);
        SearchResultAdapter r115 = this.f440270o;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchResultAdapter");
    L38:
        r104.diff(r114);
        return;
    L37:
        r104 = r115;
        goto L38
    }
}
