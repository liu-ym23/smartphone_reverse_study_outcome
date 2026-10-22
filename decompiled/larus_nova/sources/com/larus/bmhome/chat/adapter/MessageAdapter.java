package com.larus.bmhome.chat.adapter;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.ApmAgent;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.interceptor.IMessageRenderInterceptor;
import com.larus.bmhome.chat.interceptor.MessageRenderState;
import com.larus.bmhome.chat.list.base.MessageCellPagingAdapter;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterListUpdateCallback;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.bmhome.social.page.datasource.diff.ActionListDiffer;
import com.larus.bmhome.utils.ListMonitor;
import com.larus.bmhome.utils.u2;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.textview.impl.SelectorRestore;
import com.larus.bmhome.view.textview.impl.SelectorTextView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageContentType;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.list.arch.IFlowListCell;
import com.larus.platform.api.ISdkPerfDegradeService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.delegate.BaseCellComponentFeature;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.c1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 ×\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u00020\u0007:\u0002×\u0001Bi\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012&\b\u0002\u0010\f\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010H\u001a\u0004\u0018\u00010\u000e2\u0006\u0010I\u001a\u00020\u000eH\u0016J\b\u0010J\u001a\u00020\u0000H\u0016J\b\u0010K\u001a\u00020\u0000H\u0017J5\u0010\u0086\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030w0v2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u000e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u008a\u0001H\u0014J\u000e\u0010\u008b\u0001\u001a\u0007\u0012\u0002\b\u00030\u008c\u0001H\u0016J\u000f\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030<H\u0016J\u001f\u0010\u008e\u0001\u001a\u00020\u00112\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030wH\u0096@¢\u0006\u0003\u0010\u0090\u0001J\u0019\u0010\u0091\u0001\u001a\u00020\u00112\u000e\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0093\u0001H\u0016J\u0019\u0010\u0094\u0001\u001a\u00020\u00112\u000e\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0093\u0001H\u0016J\u000f\u0010\u0095\u0001\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u0010J\f\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\u0007\u0010\u0098\u0001\u001a\u00020\u0011J\t\u0010\u0099\u0001\u001a\u00020\u0011H\u0016J\t\u0010\u009a\u0001\u001a\u00020\u0011H\u0016J\u0013\u0010\u009b\u0001\u001a\u00020\u00112\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0016J\u0012\u0010\u009e\u0001\u001a\u00020\u000f2\u0007\u0010\u009f\u0001\u001a\u00020\u0003H\u0016J\u0013\u0010 \u0001\u001a\u00020\u00112\b\u0010¡\u0001\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010¢\u0001\u001a\u00020\u00112\b\u0010¡\u0001\u001a\u00030\u0097\u0001H\u0016J\u0010\u0010©\u0001\u001a\u00020\u00102\u0007\u0010\u009f\u0001\u001a\u00020\u000eJ\u0007\u0010ª\u0001\u001a\u00020\u0010J#\u0010«\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030¬\u00012\b\u0010\u00ad\u0001\u001a\u00030®\u00012\u0007\u0010¯\u0001\u001a\u00020\u000fH\u0016J\"\u0010°\u0001\u001a\u00020\u00112\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030¬\u00012\u0007\u0010²\u0001\u001a\u00020\u000fH\u0016J%\u0010³\u0001\u001a\u00020\u00112\u0007\u0010²\u0001\u001a\u00020\u000f2\u0007\u0010\u009f\u0001\u001a\u00020\u00032\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u001d\u0010¶\u0001\u001a\u00020\u00102\u0007\u0010·\u0001\u001a\u00020E2\t\b\u0001\u0010¸\u0001\u001a\u00020\u000fH\u0016J%\u0010¹\u0001\u001a\u00020\u00102\u0007\u0010·\u0001\u001a\u00020E2\u000b\b\u0001\u0010¸\u0001\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0003\u0010º\u0001J%\u0010»\u0001\u001a\u00020\u00112\u000e\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030¼\u00010<2\n\u0010½\u0001\u001a\u0005\u0018\u00010¤\u0001H\u0016J\u0012\u0010¾\u0001\u001a\u00020\u00112\u0007\u0010·\u0001\u001a\u00020EH\u0016J\u001d\u0010¿\u0001\u001a\u00020\u00102\u0007\u0010·\u0001\u001a\u00020E2\t\b\u0001\u0010¸\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010À\u0001\u001a\u00020\u00112\u0007\u0010²\u0001\u001a\u00020\u000fH\u0002J\u001b\u0010Á\u0001\u001a\u00020\u00102\u0007\u0010Â\u0001\u001a\u00020E2\u0007\u0010¸\u0001\u001a\u00020\u000fH\u0016J\u001b\u0010Ã\u0001\u001a\u00020\u00102\u0007\u0010Â\u0001\u001a\u00020E2\u0007\u0010¸\u0001\u001a\u00020\u000fH\u0002J\u001b\u0010Ä\u0001\u001a\u00020\u00102\u0007\u0010Â\u0001\u001a\u00020E2\u0007\u0010¸\u0001\u001a\u00020\u000fH\u0002J<\u0010Ê\u0001\u001a\u00020\u00062\u0007\u0010Ë\u0001\u001a\u00020E2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Í\u00012\u0007\u0010´\u0001\u001a\u00020\u00032\r\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050<H\u0016J$\u0010Ï\u0001\u001a\u00020\u00112\u0007\u0010Ë\u0001\u001a\u00020E2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Í\u0001H\u0016J$\u0010Ð\u0001\u001a\u00020\u00112\u0007\u0010Ë\u0001\u001a\u00020E2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Í\u0001H\u0016J$\u0010Ñ\u0001\u001a\u00020\u00112\u0007\u0010Ë\u0001\u001a\u00020E2\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00020\u00030Í\u0001H\u0016J\u0014\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010Ë\u0001\u001a\u00020EH\u0016J\t\u0010Ó\u0001\u001a\u00020,H\u0002J\u001b\u0010Ô\u0001\u001a\u00020\u00112\u0010\u0010Ì\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0003\u0018\u00010Õ\u0001H\u0016J\n\u0010Ö\u0001\u001a\u0005\u0018\u00010\u0083\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR2\u0010\f\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001b\u00101\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00100\u001a\u0004\b2\u00103R\u001c\u00105\u001a\u0004\u0018\u000106X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0<8VX\u0097\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u00020TX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u001a\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030<0XX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010Y\u001a\u0010\u0012\f\u0012\n [*\u0004\u0018\u00010\u00100\u00100ZX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00103\"\u0004\b`\u0010aR\u001b\u0010b\u001a\u00020c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u00100\u001a\u0004\bd\u0010eR\u001c\u0010g\u001a\u0004\u0018\u00010EX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001c\u0010l\u001a\u0004\u0018\u00010EX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010i\"\u0004\bn\u0010kR\u000e\u0010o\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010p\u001a\u0004\u0018\u00010q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u00100\u001a\u0004\br\u0010sR-\u0010u\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030w0v8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bz\u00100\u001a\u0004\bx\u0010yR\u0016\u0010{\u001a\u0004\u0018\u00010E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010iR\u001f\u0010}\u001a\u0004\u0018\u00010~8FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u00100\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030¤\u00010ZX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010¥\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030<0¦\u0001¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010¨\u0001R,\u0010Å\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060Æ\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bÉ\u0001\u00100\u001a\u0006\bÇ\u0001\u0010È\u0001¨\u0006Ø\u0001"}, d2 = {"Lcom/larus/bmhome/chat/adapter/MessageAdapter;", "Lcom/larus/bmhome/chat/list/base/MessageCellPagingAdapter;", "Lcom/larus/bmhome/chat/adapter/IMessageListAdapter;", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "Lcom/larus/bmhome/chat/adapter/component/IContextManager;", "Lcom/larus/bmhome/chat/cell/text/components/BaseComponent;", "Lcom/larus/bmhome/chat/adapter/text/TextComponentContextImpl;", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "msgActionCallback", "Lkotlin/Function4;", "Lcom/larus/im/bean/message/Message;", "", "", "", "immerseBgColor", "hostFragment", "Lkotlin/Function0;", "Landroidx/fragment/app/Fragment;", "componentFeature", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "<init>", "(Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;Lcom/larus/bmhome/chat/ChatParam;Lkotlin/jvm/functions/Function4;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;)V", "getLoader", "()Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "getMsgActionCallback", "()Lkotlin/jvm/functions/Function4;", "getImmerseBgColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHostFragment", "()Lkotlin/jvm/functions/Function0;", "getComponentFeature", "()Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "getProvider", "()Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "cutCellType", "Lcom/larus/bmhome/chat/list/cell/text/TextCellCutType;", "getCutCellType", "()Lcom/larus/bmhome/chat/list/cell/text/TextCellCutType;", "cutCellType$delegate", "Lkotlin/Lazy;", "cachedHistoryMsgEditable", "getCachedHistoryMsgEditable", "()Z", "cachedHistoryMsgEditable$delegate", "botMakerEventListener", "Lcom/larus/platform/model/bot/IBotMakerEventListener;", "getBotMakerEventListener", "()Lcom/larus/platform/model/bot/IBotMakerEventListener;", "setBotMakerEventListener", "(Lcom/larus/platform/model/bot/IBotMakerEventListener;)V", "currentList", "", "getCurrentList$annotations", "()V", "getCurrentList", "()Ljava/util/List;", "currentMessageCellStateList", "getCurrentMessageCellStateList", "mobCardIdCache", "Lcom/larus/bmhome/chat/search/LruSet;", "", "getMobCardIdCache", "()Lcom/larus/bmhome/chat/search/LruSet;", "findQuestionOrLast", "message", "asRecycleAdapter", "asContextManager", "chatMessageList", "Lcom/larus/bmhome/view/ChatMessageList;", "getChatMessageList", "()Lcom/larus/bmhome/view/ChatMessageList;", "setChatMessageList", "(Lcom/larus/bmhome/view/ChatMessageList;)V", "isMainBot", "itemShowHelper", "Lcom/larus/bmhome/utils/MessageListItemShowHelper;", "getItemShowHelper", "()Lcom/larus/bmhome/utils/MessageListItemShowHelper;", "onPagesUpdatedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "initialMessageListLoaded", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getInitialMessageListLoaded$impl_mainlandRelease", "()Landroidx/lifecycle/MutableLiveData;", "pendingInitialMessageListLoaded", "getPendingInitialMessageListLoaded$impl_mainlandRelease", "setPendingInitialMessageListLoaded$impl_mainlandRelease", "(Z)V", "listMonitor", "Lcom/larus/bmhome/utils/ListMonitor;", "getListMonitor", "()Lcom/larus/bmhome/utils/ListMonitor;", "listMonitor$delegate", "modifyId", "getModifyId", "()Ljava/lang/String;", "setModifyId", "(Ljava/lang/String;)V", "canModifyId", "getCanModifyId", "setCanModifyId", "enableTrackerOptimize", "chatPageMetrics", "Lcom/larus/bmhome/chat/ChatPageMetrics;", "getChatPageMetrics", "()Lcom/larus/bmhome/chat/ChatPageMetrics;", "chatPageMetrics$delegate", "differ", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;", "getDiffer", "()Lcom/larus/bmhome/social/page/datasource/diff/IPagingAdapterDiffer;", "differ$delegate", "curSecId", "getCurSecId", "cutMultipleCellNotifyManager", "Lcom/larus/mainbot/api/ICutMultipleCellNotify;", "getCutMultipleCellNotifyManager", "()Lcom/larus/mainbot/api/ICutMultipleCellNotify;", "cutMultipleCellNotifyManager$delegate", "selectorRestore", "Lcom/larus/bmhome/view/textview/impl/SelectorRestore;", "holdAnchor", "Lcom/larus/bmhome/view/textview/impl/SelectorTextView;", "createDiff", "updateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diff", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "asRecyclerViewAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getMessageList", "submitEvent", "event", "(Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerObserver", "observer", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingDataSourceObserver;", "unregisterObserver", "setIsMainBot", "getAttachedView", "Landroidx/recyclerview/widget/RecyclerView;", "notifyDataSetChangedSafely", "onPageResume", "onPagePause", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "getIndexOfData", "data", "onAttachedToRecyclerView", "recyclerView", "onDetachedFromRecyclerView", "notifyItemChangedLiveData", "", "listUpdatedLive", "Landroidx/lifecycle/MediatorLiveData;", "getListUpdatedLive", "()Landroidx/lifecycle/MediatorLiveData;", "needChangeViewAlpha", "isShareMode", "onCreateViewHolder", "Lcom/larus/list/arch/FlowListViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "tryUpdateMessageRenderStateForInterceptor", "state", "Lcom/larus/bmhome/chat/interceptor/MessageRenderState;", "notifyItemChanged", "messageId", "contentType", "notifyAllRelatedCell", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "notifyMultipleDeepThinkCutCellItemChanged", "Lcom/larus/bmhome/list/ICoreMessageCellState;", WsConstants.KEY_PAYLOAD, "setUpNotifyItemChangedLiveData", "newNotifyItemChanged", "notifyItemChangedSafely", "notifyLocalMessageIdItemChanged", "localMessageId", "oldNotifyLocalMessageIdItemChanged", "newNotifyLocalMessageIdItemChanged", "contextManager", "Lcom/larus/bmhome/chat/adapter/component/ContextManagerImpl;", "getContextManager", "()Lcom/larus/bmhome/chat/adapter/component/ContextManagerImpl;", "contextManager$delegate", "bindCell", "key", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/larus/bmhome/chat/list/cell/text/BaseCompositeTextCell;", "components", "unbindCell", "onCellAttachedToWindow", "onCellDetachedFromWindow", "getComponentContext", "getCutTextCellType", "cellAttachIfNeed", "Lcom/larus/list/arch/IFlowListCell;", "getSelectorRestoreInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MessageAdapter extends MessageCellPagingAdapter implements i<xc8.b>, dc8.c<bd8.b, ec8.b>, q0 {
    public static final MessageAdapter$Companion$diff$1 M = null;
    public final Lazy A;
    public String B;
    public String C;
    public final boolean D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final SelectorRestore H;
    public SelectorTextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final MutableLiveData<Object> f297025J;
    public final MediatorLiveData<List<xc8.b>> K;
    public final Lazy L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ChatParam f297026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function4<q0, Message, Integer, Boolean, Unit> f297027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f297028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function0<Fragment> f297029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ComponentFeature f297030o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q0.a f297031p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f297032q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f297033r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public nq9.e f297034s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LruSet<String> f297035t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ChatMessageList f297036u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f297037v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u2 f297038w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final MutableSharedFlow<List<xc8.b>> f297039x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final MutableLiveData<Boolean> f297040y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f297041z;

    public static final class a implements kf8.a {
        public a() {
        }
    }

    public static final class b {
    }

    public static final class c implements tt8.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MessageAdapter f297042a;

        @Override // tt8.a
        public final SelectorTextView b() {
            return this.f297042a.I;
        }

        public c(MessageAdapter r100) {
            this.f297042a = r100;
        }

        @Override // tt8.a
        public final void a(SelectorTextView r100) {
            this.f297042a.I = r100;
        }
    }

    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f297043a;

        public d(p r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f297043a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f297043a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f297043a.invoke(r100);
        }
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final MessageAdapter F7() {
        return this;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final MessageAdapter L7() {
        return this;
    }

    @Override // com.larus.bmhome.chat.adapter.i
    public final Object k1(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r100, Continuation<? super Unit> r101) {
        return L2(this, r100, r101);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.bmhome.chat.adapter.MessageAdapter$Companion$diff$1] */
    static {
        M = new MessageAdapter$Companion$diff$1();
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.h0 A7() {
        return new com.larus.bmhome.chat.api.h0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.l0 D9() {
        return new com.larus.bmhome.chat.api.l0(this);
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter
    public final com.larus.bmhome.social.page.datasource.diff.b<xc8.b, com.larus.bmhome.social.page.datasource.event.c<xc8.b>> F2() {
        return (com.larus.bmhome.social.page.datasource.diff.b) this.F.getValue();
    }

    public final ListMonitor H2() {
        return (ListMonitor) this.A.getValue();
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.n0 M7() {
        return new com.larus.bmhome.chat.api.n0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.i0 N7() {
        return new com.larus.bmhome.chat.api.i0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.o0 P7() {
        return new com.larus.bmhome.chat.api.o0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.k0 Q7() {
        return new com.larus.bmhome.chat.api.k0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.g0 a9() {
        return new com.larus.bmhome.chat.api.g0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.m0 i2() {
        return new com.larus.bmhome.chat.api.m0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.f0 s5() {
        return new com.larus.bmhome.chat.api.f0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.j0 y7() {
        return new com.larus.bmhome.chat.api.j0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final com.larus.bmhome.chat.api.p0 z7() {
        return new com.larus.bmhome.chat.api.p0(this);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final List<xc8.b> D7() {
        return z2();
    }

    public final Message I2() {
        Object r100 = null;
        if (s0() == false) goto L21;
        Iterator<T> r101 = getCurrentList().iterator();
    L7:
        if (r101.hasNext() == false) goto L15;
        Object r102 = r101.next();
        Message r103 = (Message) r102;
        String r104 = T1();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r104 != null) goto L11;
        boolean r105 = false;
    L12:
        if (r105 == false) goto L7;
        r100 = r102;
        goto L15
    L11:
        r105 = Intrinsics.areEqual(r103.getLocalMessageId(), r104);
    L15:
        return (Message) r100;
    L21:
        return null;
    }

    @Override // wq8.b
    public final List<Message> getCurrentList() {
        List<xc8.b> r100 = z2();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((xc8.b) r102.next()).getMessage());
        goto L4
    L6:
        return r101;
    }

    @Override // com.larus.bmhome.chat.adapter.i
    public final List<xc8.b> getMessageList() {
        return z2();
    }

    @Override // wq8.b
    public final boolean s0() {
        if (T1() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final ChatMessageList B7() {
        return this.f297036u;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final LruSet<String> E7() {
        return this.f297035t;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final u2 G7() {
        return this.f297038w;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final nq9.e H7() {
        return this.f297034s;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final Integer I7() {
        return this.f297028m;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final ComponentFeature J7() {
        return this.f297030o;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final Function4<q0, Message, Integer, Boolean, Unit> K7() {
        return this.f297027l;
    }

    @Override // wq8.b
    public final String T1() {
        return this.B;
    }

    @Override // wq8.b
    public final String W() {
        return this.C;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final ChatParam getChatParam() {
        return this.f297026k;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final Function0<Fragment> getHostFragment() {
        return this.f297029n;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final q0.a getProvider() {
        return this.f297031p;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final Message C7(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        List<xc8.b> r101 = z2();
        String r102 = r100.getReplyId();
        Message r103 = null;
        if (r102 == null) goto L16;
        Iterator<T> r104 = r101.iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((xc8.b) r105).getMessage().getMessageId(), r102) == false) goto L6;
    L11:
        xc8.b r106 = (xc8.b) r105;
        if (r106 == null) goto L14;
        Message r107 = r106.getMessage();
    L15:
        if (r107 == null) goto L16;
        return r107;
    L14:
        r107 = null;
        goto L15
    L10:
        r105 = null;
    L16:
        Iterator<xc8.b> r108 = r101.iterator();
        int r109 = 0;
    L18:
        if (r108.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(r108.next().getMessage(), r100) == true) goto L24;
        r109 = r109 + 1;
    L24:
        xc8.b r110 = (xc8.b) CollectionsKt.getOrNull(r101, r109 + 1);
        if (r110 == null) goto L28;
        r103 = r110.getMessage();
    L28:
        return r103;
    L23:
        r109 = -1;
        goto L24
    }

    @Override // wq8.b
    public final void F1(String r100) {
        this.B = r100;
    }

    public final void K2(boolean r100) {
        if (this.f297037v != r100) goto L5;
        return;
    L5:
        this.f297037v = r100;
        if (getItemCount() > 0) goto L8;
        return;
    L8:
        if (((xc8.b) ListProtector.get(z2(), 0)).getMessage().getContentType() != 2) goto L12;
        notifyItemChanged(0);
        return;
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final void R7(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        this.f297025J.setValue(r100);
    }

    @Override // dc8.c
    public final dc8.b X0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (ec8.b) ((dc8.a) this.L.getValue()).X0(r100);
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter, com.larus.list.arch.FlowListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        ListMonitor r101 = H2();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        r100.addOnScrollListener(r101.f314936l);
        boolean r102 = this.f297026k.f296894f;
        WeakHashMap<Object, e2a.a> r103 = j0.f297093a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        WeakHashMap<Object, e2a.a> r104 = j0.f297093a;
        e2a.a r105 = r104.get(this);
        if (r105 != null) goto L5;
        r105 = new i0(this);
        r104.put(this, r105);
    L5:
        CopyOnWriteArrayList r106 = (CopyOnWriteArrayList) e2a.e.f470849a;
        if (r106.contains(r105) == true) goto L9;
        r106.add(r105);
    L9:
        if ((r100 instanceof ChatMessageList) == false) goto L11;
        ChatMessageList r107 = (ChatMessageList) r100;
    L12:
        this.f297036u = r107;
        SelectorRestore r108 = this.H;
        com.larus.bmhome.chat.component.bottom.reference.a r109 = this.f297031p.N9();
        c r110 = new c(this);
        r100.addOnScrollListener(r108.f317442f);
        r100.addOnScrollListener(r108.f317443g);
        r108.f317440d = r109;
        r108.f317444h = r110;
        r108.f317437a = null;
        r108.f317439c = false;
        ((LinkedHashMap) r108.f317438b).clear();
        return;
    L11:
        r107 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter, com.larus.list.arch.FlowListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        ListMonitor r101 = H2();
        String r102 = this.f297026k.f296889a;
        com.larus.im.internal.stream.b r103 = r101.f314931g;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r103.e(r102, r101.f314935k);
        r101.f314933i = false;
        ListMonitor r104 = H2();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        r100.removeOnScrollListener(r104.f314936l);
        r104.a(r100, ISdkPerfDegradeService.ScrollState.DETACH);
        com.larus.bmhome.utils.p0 r105 = r104.f314930f;
        String r106 = r105.f315092k;
        JSONObject r107 = new JSONObject();
        r107.put("scene", r105.f315082a);
        Iterator<Map.Entry<String, Integer>> r108 = r105.f315085d.entrySet().iterator();
    L7:
        if (r108.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r109 = r108.next();
        r107.put(r109.getKey(), r109.getValue().intValue());
        goto L7
    L9:
        ApmAgent.monitorEvent(r106, r107, null, null);
        String r110 = r105.f315093l;
        JSONObject r111 = new JSONObject();
        r111.put("scene", r105.f315082a);
        Iterator<Map.Entry<String, Integer>> r112 = r105.f315086e.entrySet().iterator();
    L11:
        if (r112.hasNext() == false) goto L13;
        Map.Entry<String, Integer> r113 = r112.next();
        r111.put(r113.getKey(), r113.getValue().intValue());
        goto L11
    L13:
        ApmAgent.monitorEvent(r110, r111, null, null);
        WeakHashMap<Object, e2a.a> r114 = j0.f297093a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        WeakHashMap<Object, e2a.a> r115 = j0.f297093a;
        e2a.a r116 = r115.get(this);
        if (r116 == null) goto L16;
        ((CopyOnWriteArrayList) e2a.e.f470849a).remove(r116);
        e2a.a r117 = r115.remove(this);
    L16:
        this.f297036u = null;
        SelectorRestore r118 = this.H;
        r100.removeOnScrollListener(r118.f317442f);
        r100.removeOnScrollListener(r118.f317443g);
        tt8.a r119 = r118.f317444h;
        if (r119 == null) goto L19;
        r119.a(null);
    L19:
        r118.f317440d = null;
        r118.f317444h = null;
        r118.f317437a = null;
        r118.f317439c = false;
        ((LinkedHashMap) r118.f317438b).clear();
    }

    @Override // com.larus.bmhome.chat.adapter.i
    public final void p1(com.larus.bmhome.social.page.datasource.diff.c<xc8.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Intrinsics.checkNotNullParameter(r100, "observer");
        com.larus.bmhome.social.page.datasource.diff.b<xc8.b, com.larus.bmhome.social.page.datasource.event.c<xc8.b>> r101 = F2();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (r101.f314017c.contains(r100) == true) goto L7;
        r101.f314017c.add(r100);
        return;
    }

    @Override // com.larus.bmhome.chat.adapter.i
    public final void r1(com.larus.bmhome.social.page.datasource.diff.c<xc8.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        Intrinsics.checkNotNullParameter(r100, "observer");
        com.larus.bmhome.social.page.datasource.diff.b<xc8.b, com.larus.bmhome.social.page.datasource.event.c<xc8.b>> r101 = F2();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (r101.f314017c.contains(r100) == false) goto L7;
        r101.f314017c.remove(r100);
        return;
    }

    @Override // com.larus.list.arch.FlowListAdapter
    public final void y2(IFlowListCell<? super xc8.b> r100) {
        if ((r100 instanceof BaseCellComponentFeature) == false) goto L6;
        BaseCellComponentFeature r101 = (BaseCellComponentFeature) r100;
        ComponentFeature r102 = this.f297030o;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "value");
        r101.f375146a = r102;
        return;
    }

    @Override // com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter, com.larus.list.arch.FlowListAdapter
    public final void B2(FlowListViewHolder<xc8.b> r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        Intrinsics.checkNotNullParameter(r110, "holder");
        ei9.f r100 = (ei9.f) ListProtector.get(z2(), r111);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "state");
        IFlowListCell<? super ei9.f> r101 = r110.f355731b;
        boolean r102 = true;
        if (r101 == null) goto L7;
        View r103 = r110.f355732c;
        if (r103 == null) goto L7;
        boolean r104 = r101.shouldBindCell(r103, r100, r111);
    L9:
        if (r104 == false) goto L65;
        ListMonitor r105 = H2();
        String r106 = this.f297026k.f296889a;
        String r107 = "";
        if (((Boolean) r105.f314934j.getValue()).booleanValue() == true) goto L14;
    L21:
        com.larus.bmhome.utils.p0 r108 = H2().f314930f;
        r108.getClass();
        r108.f315084c = SystemClock.uptimeMillis();
        if (r111 >= 0) goto L24;
    L26:
        r102 = false;
    L27:
        if (r102 == false) goto L29;
        xc8.b r109 = (xc8.b) ListProtector.get(z2(), r111);
    L30:
        if (r109 != null) goto L32;
        return;
    L32:
        Message r112 = r109.getMessage();
        if (com.larus.im.bean.message.a.w0(r109.getMessage()) == true) goto L40;
        if (r109.getMessage().getMessageStatusLocal() != 11) goto L37;
    L38:
        FLogger.f375446a.i("MessageAdapter", "onBindViewHolder onStart pos=" + r111 + " index=" + r112.getServerIndex() + '_' + r112.getLocalIndex() + " msg_id=" + r112.getMessageId() + " conversation_id=" + r112.getConversationId() + " content_type=" + r112.getContentType());
        goto L40
    L37:
        if (r109.getMessage().getMessageStatusLocal() == 21) goto L38;
    L40:
        com.larus.bmhome.chat.trace.container.b r113 = com.larus.bmhome.chat.trace.container.b.f310187a;
        Message r114 = r109.getMessage();
        xc8.b r115 = r109;
        com.larus.bmhome.chat.trace.container.b.p(r115, r114);
        MessageRenderState r116 = MessageRenderState.START;
        IMessageRenderInterceptor r117 = IMessageRenderInterceptor.f303337a;
        String r118 = r115.getMessage().getMessageId();
        if (r118 != null) goto L43;
        r118 = "";
    L43:
        r117.a(r118, r116, r115.getMessage());
        super.B2(r110, r111);
        if (((Boolean) H2().f314934j.getValue()).booleanValue() == true) goto L46;
    L49:
        IFlowListCell<? super ei9.f> r119 = r110.f355731b;
        if (r119 == null) goto L52;
        ListMonitor r120 = H2();
        String r121 = r119.getClass().getSimpleName();
        Map<String, Object> r122 = r119.appendPerfMonitorParams(r115);
        r122.put(BytedCertConstant.IntentKey.VIEW_TYPE, Integer.valueOf(getItemViewType(r111)));
        r122.put("content_type", Integer.valueOf(r115.getMessage().getContentType()));
        r122.put("msg_id", r115.getMessage().getMessageId());
        Unit r123 = Unit.INSTANCE;
        r120.b(r121, r122);
    L53:
        com.larus.bmhome.chat.trace.container.b.i(r115, r115.getMessage());
        MessageRenderState r124 = MessageRenderState.FINISH;
        String r125 = r115.getMessage().getMessageId();
        if (r125 == null) goto L57;
        r107 = r125;
    L57:
        r117.a(r107, r124, r115.getMessage());
        if (com.larus.im.bean.message.a.w0(r115.getMessage()) == false) goto L60;
        return;
    L60:
        if (r115.getMessage().getMessageStatusLocal() != 11) goto L62;
    L63:
        FLogger.f375446a.i("MessageAdapter", "onBindViewHolder onEnd pos=" + r111 + " index=" + r112.getServerIndex() + '_' + r112.getLocalIndex() + " msg_id=" + r112.getMessageId() + " conversation_id=" + r112.getConversationId() + " content_type=" + r112.getContentType());
        return;
    L62:
        if (r115.getMessage().getMessageStatusLocal() == 21) goto L63;
        return;
    L52:
        H2().b("", null);
        goto L53
    L46:
        if (com.larus.bmhome.chat.bean.d.Q0(r115.getMessage()) == true) goto L53;
        if (com.larus.im.bean.message.a.A0(r115.getMessage()) == true) goto L53;
    L29:
        r109 = null;
        goto L30
    L24:
        if (r111 >= z2().size()) goto L26;
    L14:
        if (r105.f314933i == true) goto L21;
        if (com.larus.utils.o0.d(r106) == false) goto L21;
        r105.f314933i = true;
        com.larus.im.internal.stream.b r126 = r105.f314931g;
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        r126.b(r106, r105.f314935k);
        goto L21
    L65:
        return;
    L7:
        r104 = true;
        goto L9
    }

    @Override // com.larus.list.arch.FlowListAdapter
    public final FlowListViewHolder<xc8.b> C2(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        com.larus.bmhome.utils.p0 r100 = H2().f314930f;
        r100.getClass();
        r100.f315083b = SystemClock.uptimeMillis();
        com.larus.bmhome.chat.trace.container.b r101 = com.larus.bmhome.chat.trace.container.b.f310187a;
        com.larus.bmhome.chat.trace.container.b.q();
        FlowListViewHolder<xc8.b> r112 = super.C2(r110, r111);
        IFlowListCell<? super ei9.f> r102 = r112.f355731b;
        if (r102 == null) goto L5;
        String r103 = r102.getClass().getSimpleName();
    L6:
        ListMonitor r104 = H2();
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put(BytedCertConstant.IntentKey.VIEW_TYPE, Integer.valueOf(r111));
        Unit r113 = Unit.INSTANCE;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r105, "extraParams");
        com.larus.bmhome.utils.p0 r106 = r104.f314930f;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r105, "extraParams");
        long r107 = SystemClock.uptimeMillis() - r106.f315083b;
        boolean r108 = Intrinsics.areEqual(ThreadMethodProxy.currentThread(), (Thread) r106.f315088g.getValue());
        ArrayMap<String, Integer> r109 = r106.f315085d;
        Integer r114 = r109.get(r103);
        if (r114 == null) goto L9;
        int r115 = r114.intValue();
    L10:
        r109.put(r103, Integer.valueOf(r115 + 1));
        String r116 = r106.f315090i;
        JSONObject r117 = new JSONObject();
        r117.put("scene", r106.f315082a);
        r117.put("type", r103);
        r117.put("duration", r107);
        r117.put("isMainThread", r108);
        Iterator r118 = r105.entrySet().iterator();
    L12:
        if (r118.hasNext() == false) goto L14;
        Map.Entry r119 = (Map.Entry) r118.next();
        r117.put((String) r119.getKey(), r119.getValue());
        goto L12
    L14:
        ApmAgent.monitorEvent(r116, r117, null, null);
        if (com.larus.platform.exp.h.f365384a == false) goto L17;
        long r120 = ((Number) r106.f315087f.getValue()).longValue();
    L19:
        if (r107 < r120) goto L21;
        FLogger.f375446a.i("HolderTracker", "onCreateVHEnd scene=" + r106.f315082a + " type=" + r103 + " duration=" + r107 + " isMainThread=" + r108);
    L21:
        com.larus.bmhome.chat.trace.container.b r121 = com.larus.bmhome.chat.trace.container.b.f310187a;
        com.larus.bmhome.chat.trace.container.b.j();
        return r112;
    L17:
        r120 = z2.f365865a.openTraceExecuteThreshold();
        goto L19
    L9:
        r115 = 0;
        goto L10
    L5:
        r103 = "";
        goto L6
    }

    @Override // com.larus.bmhome.chat.list.base.MessageCellPagingAdapter, com.larus.bmhome.chat.list.datasource.adapter.PagingAdapter
    public final ActionListDiffer E2(PagingAdapterListUpdateCallback r100, DiffUtil.ItemCallback r101) {
        Intrinsics.checkNotNullParameter(r100, "updateCallback");
        Intrinsics.checkNotNullParameter(r101, "diff");
        return new ActionListDiffer(r100, r101, new u(this));
    }

    public final void J2(List<? extends wq8.a> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        gk9.a r102 = (gk9.a) this.G.getValue();
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // dc8.c
    public final void N1(String r100, BaseCompositeTextCell<? extends xc8.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        ((dc8.a) this.L.getValue()).N1(r100, r101);
    }

    @Override // dc8.c
    public final void S(String r100, BaseCompositeTextCell<? extends xc8.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        ((dc8.a) this.L.getValue()).S(r100, r101);
    }

    @Override // wq8.b
    public final boolean S3(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "localMessageId");
        boolean r100 = false;
        final int r101 = -1;
        if (((TextCellCutType) this.f297032q.getValue()) != TextCellCutType.NewCutThreeTextCell) goto L5;
    L27:
        List<xc8.b> r102 = z2();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L29:
        if (r104.hasNext() == false) goto L38;
        Object r105 = r104.next();
        xc8.b r106 = (xc8.b) r105;
        if (Intrinsics.areEqual(r106.getMessage().getLocalMessageId(), r110) == true) goto L33;
    L35:
        boolean r107 = false;
    L36:
        if (r107 == false) goto L29;
        r103.add(r105);
        goto L29
    L33:
        if (r106.getMessage().getContentType() != r111) goto L35;
        r107 = true;
        goto L36
    L38:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r108 = r103.iterator();
    L40:
        if (r108.hasNext() == false) goto L42;
        r112.add(Integer.valueOf(z2().indexOf((xc8.b) r108.next())));
        goto L40
    L42:
        ChatMessageList r109 = this.f297036u;
        Integer r113 = null;
        if (r109 == null) goto L45;
        RecyclerView.LayoutManager r114 = r109.getLayoutManager();
    L47:
        if ((r114 instanceof LinearLayoutManager) == false) goto L49;
        LinearLayoutManager r115 = (LinearLayoutManager) r114;
    L50:
        if (r115 == null) goto L52;
        Integer r116 = Integer.valueOf(r115.findFirstVisibleItemPosition());
    L53:
        if (r115 == null) goto L55;
        r113 = Integer.valueOf(r115.findLastVisibleItemPosition());
    L55:
        if (r116 == null) goto L73;
        if (r113 == null) goto L73;
        if (r116.intValue() == (-1)) goto L73;
        if (r113.intValue() == (-1)) goto L73;
        ArrayList r117 = new ArrayList();
        Iterator r118 = r112.iterator();
    L63:
        if (r118.hasNext() == false) goto L72;
        Object r119 = r118.next();
        int r120 = ((Number) r119).intValue();
        if (r116.intValue() <= r120) goto L67;
    L69:
        boolean r121 = false;
    L70:
        if (r121 == false) goto L63;
        r117.add(r119);
        goto L63
    L67:
        if (r120 > r113.intValue()) goto L69;
        r121 = true;
        goto L70
    L72:
        int r122 = r117.size();
    L78:
        Integer r123 = (Integer) CollectionsKt.firstOrNull(r112);
        if (r123 == null) goto L81;
        r101 = r123.intValue();
    L81:
        notifyItemRangeChanged(r101, r122);
        this.f297025J.setValue(r110);
    L82:
        return true;
    L73:
        FLogger.f375446a.e("streamService", "positionList = " + r112 + ", localMessageId = " + r110);
        int r124 = r112.size();
        ChatMessageList r125 = this.f297036u;
        if (r125 == null) goto L76;
        int r126 = r125.getChildCount();
    L77:
        r122 = RangesKt.coerceAtMost(r124, r126);
        goto L78
    L76:
        r126 = Integer.MAX_VALUE;
        goto L77
    L52:
        r116 = null;
        goto L53
    L49:
        r115 = null;
        goto L50
    L45:
        r114 = null;
        goto L47
    L5:
        if (((TextCellCutType) this.f297032q.getValue()) == TextCellCutType.DeepThinkCutMultipleCell) goto L27;
        Iterator<xc8.b> r127 = z2().iterator();
        int r128 = 0;
    L9:
        if (r127.hasNext() == false) goto L19;
        xc8.b r129 = r127.next();
        if (Intrinsics.areEqual(r129.getMessage().getLocalMessageId(), r110) == true) goto L13;
    L15:
        boolean r130 = false;
    L16:
        if (r130 == true) goto L17;
        r128 = r128 + 1;
        goto L9
    L17:
        r101 = r128;
        goto L19
    L13:
        if (r129.getMessage().getContentType() != r111) goto L15;
        r130 = true;
    L19:
        if (r101 >= 0) goto L21;
    L23:
        if (r100 == false) goto L25;
        t0.e(new w(this, r101));
    L26:
        this.f297025J.setValue(r110);
        goto L82
    L25:
        FLogger.f375446a.e("streamService", "position = " + r101 + ", localMessageId = " + r110);
        goto L26
    L21:
        if (r101 >= getItemCount()) goto L23;
        r100 = true;
        goto L23
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final boolean l3(String r100, @MessageContentType Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Iterator<xc8.b> r102 = z2().iterator();
        boolean r103 = false;
        final int r104 = 0;
    L4:
        if (r102.hasNext() == false) goto L15;
        xc8.b r105 = r102.next();
        if (Intrinsics.areEqual(r105.getMessage().getMessageId(), r100) == false) goto L11;
        if (r101 != null) goto L9;
    L10:
        boolean r106 = true;
    L12:
        if (r106 == true) goto L16;
        r104 = r104 + 1;
    L16:
        if (r104 >= 0) goto L18;
    L20:
        if (r103 == false) goto L22;
        t0.e(new v(this, r104));
    L23:
        this.f297025J.setValue(r100);
        return true;
    L22:
        FLogger.f375446a.d("streamService", "position = " + r104 + ", messageId = " + r100);
        goto L23
    L18:
        if (r104 >= getItemCount()) goto L20;
        r103 = true;
        goto L20
    L9:
        if (r105.getMessage().getContentType() == r101.intValue()) goto L10;
    L11:
        r106 = false;
        goto L12
    L15:
        r104 = -1;
        goto L16
    }

    @Override // dc8.c
    public final void u1(String r100, BaseCompositeTextCell<? extends xc8.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        ((dc8.a) this.L.getValue()).u1(r100, r101);
    }

    @Override // com.larus.bmhome.chat.api.q0
    public final boolean x7(String r210, @MessageContentType int r211) {
        Intrinsics.checkNotNullParameter(r210, "messageId");
        Iterator<T> r100 = z2().iterator();
    L3:
        final LinearLayoutManager r101 = null;
        if (r100.hasNext() == false) goto L13;
        Object r102 = r100.next();
        xc8.b r103 = (xc8.b) r102;
        if (Intrinsics.areEqual(r103.getMessage().getMessageId(), r210) == true) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L3;
    L14:
        xc8.b r105 = (xc8.b) r102;
        if (r105 != null) goto L18;
        return true;
    L18:
        if (((TextCellCutType) this.f297032q.getValue()) != TextCellCutType.NewCutThreeTextCell) goto L43;
        List<xc8.b> r106 = z2();
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L21:
        if (r108.hasNext() == false) goto L30;
        Object r109 = r108.next();
        xc8.b r110 = (xc8.b) r109;
        if (Intrinsics.areEqual(r110.getMessage().getMessageId(), r210) == true) goto L25;
    L27:
        boolean r111 = false;
    L28:
        if (r111 == false) goto L21;
        r107.add(r109);
        goto L21
    L25:
        if (r110.getMessage().getContentType() != r211) goto L27;
        r111 = true;
        goto L28
    L30:
        final ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r113 = r107.iterator();
    L32:
        if (r113.hasNext() == false) goto L34;
        r112.add(Integer.valueOf(z2().indexOf((xc8.b) r113.next())));
        goto L32
    L34:
        ChatMessageList r114 = this.f297036u;
        if (r114 == null) goto L37;
        RecyclerView.LayoutManager r115 = r114.getLayoutManager();
    L39:
        if ((r115 instanceof LinearLayoutManager) == false) goto L41;
        r101 = (LinearLayoutManager) r115;
    L41:
        t0.e(new m(r101, r112, this));
        FLogger.f375446a.d("streamService", "position = " + CollectionsKt.joinToString$default(r112, ",", null, null, 0, null, null, 62, null) + ", messageId = " + r210);
        this.f297025J.setValue(r210);
    L50:
        return true;
    L37:
        r115 = null;
        goto L39
    L43:
        if (((TextCellCutType) this.f297032q.getValue()) == TextCellCutType.DeepThinkCutMultipleCell) goto L45;
    L49:
        l3(r210, Integer.valueOf(r211));
        goto L50
    L45:
        if (com.larus.im.bean.message.a.f0(r105.getMessage()) == false) goto L49;
        gk9.a r116 = (gk9.a) this.G.getValue();
        if (r116 != null) goto L64;
        return false;
    L64:
        return r116.a(r105, r210, r211);
    L8:
        if (r103.getMessage().getContentType() != r211) goto L10;
        r104 = true;
        goto L11
    L13:
        r102 = null;
        goto L14
    }

    public static Object L2(MessageAdapter r100, com.larus.bmhome.social.page.datasource.event.c<xc8.b> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof MessageAdapter$submitEvent$1) == false) goto L7;
        MessageAdapter$submitEvent$1 r103 = (MessageAdapter$submitEvent$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r109 = (com.larus.bmhome.social.page.datasource.event.c) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L26:
        FLogger.f375446a.i("MsgRefreshFlow_MessageAdapter", "submitEvent listSize=" + r109.f314033a.size() + " dataVersion=" + r109.f314034b + " rt=" + r109.f314036d);
        List<com.larus.bmhome.social.page.datasource.event.b> r110 = r109.f314035c;
        if ((r110 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r111 = r110.iterator();
    L33:
        if (r111.hasNext() == false) goto L37;
        if ((((com.larus.bmhome.social.page.datasource.event.b) r111.next()) instanceof com.larus.bmhome.social.page.datasource.event.b.d) == false) goto L33;
    L38:
        if (r108 == false) goto L43;
        if (r109.f314033a.isEmpty() == false) goto L43;
        CompletableDeferred<Boolean> r112 = wr8.d.f560874a;
        wr8.d.b.c("adapter#submit empty data");
    L43:
        return Unit.INSTANCE;
    L37:
        r108 = false;
        goto L38
    L29:
        if (r110.isEmpty() == false) goto L31;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (com.larus.bmhome.social.page.datasource.event.c) r103.L$1;
        r100 = (MessageAdapter) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L22:
        r100.f297040y.setValue(Boxing.boxBoolean(r100.f297041z));
        MutableSharedFlow<List<xc8.b>> r113 = r100.f297039x;
        List<xc8.b> r114 = r101.f314033a;
        r103.L$0 = r101;
        r103.L$1 = null;
        r103.label = 2;
        if (r113.emit(r114, r103) != r106) goto L25;
        return r106;
    L25:
        r109 = r101;
        goto L26
    L16:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        Object r115 = r100.F2().b(r101, r103);
        if (r115 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        r115 = Unit.INSTANCE;
    L20:
        if (r115 != r106) goto L22;
        return r106;
    L7:
        r103 = new MessageAdapter$submitEvent$1(r100, r102);
        goto L8
    }

    @Override // dc8.c
    public final dc8.b I1(String r100, BaseCompositeTextCell r101, xc8.b r102, List<? extends bd8.b> r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r102, "state");
        Intrinsics.checkNotNullParameter(r103, "components");
        return (ec8.b) ((dc8.a) this.L.getValue()).I1(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.larus.bmhome.chat.adapter.p] */
    public MessageAdapter(vr8.a r100, ChatParam r101, Function4<? super q0, ? super Message, ? super Integer, ? super Boolean, Unit> r102, Integer r110, Function0<? extends Fragment> r111, ComponentFeature r112, q0.a r113) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        Intrinsics.checkNotNullParameter(r101, "chatParam");
        Intrinsics.checkNotNullParameter(r102, "msgActionCallback");
        Intrinsics.checkNotNullParameter(r111, "hostFragment");
        Intrinsics.checkNotNullParameter(r112, "componentFeature");
        Intrinsics.checkNotNullParameter(r113, ShortVideoSegments.KEY_PROP_PROVIDER);
        super(M, r100);
        this.f297026k = r101;
        this.f297027l = r102;
        this.f297028m = r110;
        this.f297029n = r111;
        this.f297030o = r112;
        this.f297031p = r113;
        this.f297032q = LazyKt.lazy(new a0(this));
        this.f297033r = LazyKt.lazy(new b0());
        this.f297035t = new LruSet(50);
        this.f297038w = new u2();
        MutableSharedFlow<List<xc8.b>> r103 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f297039x = r103;
        this.f297040y = new MutableLiveData(Boolean.FALSE);
        this.A = LazyKt.lazy(new c0(this));
        this.D = z2.f365865a.enableTrackerOptimize();
        this.E = LazyKt.lazy(new d0(this));
        this.F = LazyKt.lazy(new n(this));
        this.G = LazyKt.lazy(new o(this));
        this.H = new SelectorRestore();
        CopyOnWriteArraySet<xc8.f.a> r104 = xc8.f.f563237a;
        xc8.f.d(this);
        s1a.a.g((Fragment) r111.invoke()).c(new a(), kf8.a.class);
        MutableLiveData<Object> r105 = new MutableLiveData();
        this.f297025J = r105;
        final MediatorLiveData<List<xc8.b>> r114 = new MediatorLiveData();
        r114.addSource(FlowLiveDataConversions.asLiveData$default(new c1(new MessageAdapter$listUpdatedLive$lambda$22$$inlined$transform$1(r103, null, this)), null, 0, 3, null), new d(new p(r114)));
        r114.addSource(r105, new q(r114));
        this.K = r114;
        this.L = LazyKt.lazy(new r());
    }
}
