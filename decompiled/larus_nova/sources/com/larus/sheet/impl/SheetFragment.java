package com.larus.sheet.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.office.OfficeInputParam;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.office.base.preview.DocMeta;
import com.larus.office.base.view.CotHeaderView;
import com.larus.office.permission.DocPermissionFullData;
import com.larus.platform.api.f3;
import com.larus.platform.service.e2;
import com.larus.sheet.biz.impl.databinding.LarusLayoutSheetDetailFragmentBinding;
import com.larus.sheet.impl.view.SheetLoadLayout;
import com.larus.sheet.sdk.api.ISheetSdkProxyService;
import com.larus.sheet.sdk.api.ISheetSdkServiceV2;
import com.larus.sheet.sdk.api.orientation.TitleBarStates;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.a1;
import v19.c7;
import v19.i5;
import va8.g0;
import va8.n0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002AL\b\u0016\u0018\u0000 Ì\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002Ì\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010N\u001a\u00020\u000bH\u0016J\u0012\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020\rH\u0014J\u001a\u0010T\u001a\u00020\u00022\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010XH\u0014J\u0010\u0010Y\u001a\u00020P2\u0006\u0010Z\u001a\u00020[H\u0014J\u0012\u0010\\\u001a\u0004\u0018\u00010D2\u0006\u0010Z\u001a\u00020[H\u0014J\b\u0010]\u001a\u00020PH\u0016J\b\u0010^\u001a\u00020RH\u0014J\u001a\u0010_\u001a\u00020P2\u0006\u0010`\u001a\u00020a2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010b\u001a\u00020PH\u0002J\b\u0010c\u001a\u00020PH\u0002J\u0010\u0010d\u001a\u00020P2\u0006\u0010e\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020fH\u0002J\b\u0010i\u001a\u00020PH\u0002J\b\u0010j\u001a\u00020PH\u0002J\u0006\u0010k\u001a\u00020PJ\b\u0010l\u001a\u00020mH\u0002J\b\u0010n\u001a\u00020\u0014H\u0014J\b\u0010o\u001a\u00020\rH\u0014J\b\u0010p\u001a\u00020\u0014H\u0014J\u001c\u0010q\u001a\u00020P2\b\u00101\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010r\u001a\u00020PH\u0002J\b\u0010s\u001a\u00020PH\u0002J\b\u0010t\u001a\u00020\u000bH\u0016J\b\u0010u\u001a\u00020\rH\u0016J\b\u0010v\u001a\u00020PH\u0002J\n\u0010w\u001a\u0004\u0018\u00010XH\u0016J\u0012\u0010x\u001a\u00020P2\b\u0010y\u001a\u0004\u0018\u00010XH\u0016Jv\u0010z\u001a\u00020P2\b\u0010{\u001a\u0004\u0018\u00010|2\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020P0~2\u0006\u0010\u007f\u001a\u00020\r2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0012\b\u0002\u0010\u0082\u0001\u001a\u000b\u0012\u0004\u0012\u00020P\u0018\u00010\u0083\u00012\u0012\b\u0002\u0010\u0084\u0001\u001a\u000b\u0012\u0004\u0012\u00020P\u0018\u00010\u0083\u00012\u0012\b\u0002\u0010\u0085\u0001\u001a\u000b\u0012\u0004\u0012\u00020P\u0018\u00010\u0083\u0001H\u0002J \u0010\u0086\u0001\u001a\u00020P2\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020P\u0018\u00010~H\u0002J\t\u0010\u0088\u0001\u001a\u00020PH\u0002J\u0012\u0010\u0089\u0001\u001a\u00020P2\u0007\u0010\u008a\u0001\u001a\u00020\u000bH\u0002J\u001b\u0010\u008b\u0001\u001a\u00020P2\u0007\u0010\u008c\u0001\u001a\u00020\u000b2\u0007\u0010\u008d\u0001\u001a\u00020\rH\u0002J\t\u0010\u008e\u0001\u001a\u00020PH\u0002J\u001f\u0010\u008f\u0001\u001a\u00020P2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\r2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010\u0092\u0001\u001a\u00020PH\u0002J\t\u0010\u0093\u0001\u001a\u00020PH\u0002J\u0010\u0010\u0094\u0001\u001a\u00020P2\u0007\u0010\u008c\u0001\u001a\u00020\u000bJ\t\u0010\u0095\u0001\u001a\u00020PH\u0016J1\u0010\u0096\u0001\u001a\u00020P2\b\u00101\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u00102\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010\u0097\u0001\u001a\u00020PH\u0002J\t\u0010\u0098\u0001\u001a\u00020\rH\u0016J\u000b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010\u009a\u0001\u001a\u00020PH\u0016J\n\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0014H\u0002J\t\u0010 \u0001\u001a\u00020PH\u0002J\u0013\u0010£\u0001\u001a\u00020P2\b\u0010¤\u0001\u001a\u00030¢\u0001H\u0016J\u0010\u0010¥\u0001\u001a\u00020P2\u0007\u0010¦\u0001\u001a\u00020\u000bJ\t\u0010¨\u0001\u001a\u00020PH\u0002J\t\u0010©\u0001\u001a\u00020PH\u0002J\t\u0010ª\u0001\u001a\u00020PH\u0016J\t\u0010«\u0001\u001a\u00020PH\u0014J\t\u0010¬\u0001\u001a\u00020PH\u0016J\u0012\u0010\u00ad\u0001\u001a\u00020P2\u0007\u0010®\u0001\u001a\u00020\u0014H\u0016J\u0007\u0010¯\u0001\u001a\u00020PJ\u001b\u0010°\u0001\u001a\u00020P2\u0007\u0010±\u0001\u001a\u00020\u00142\u0007\u0010\u008d\u0001\u001a\u00020\rH\u0002J\u001d\u0010²\u0001\u001a\u00020P2\u0007\u0010\u008d\u0001\u001a\u00020\r2\t\b\u0002\u0010³\u0001\u001a\u00020<H\u0002J\t\u0010´\u0001\u001a\u00020\u0014H\u0002J\t\u0010µ\u0001\u001a\u00020\u0014H\u0002J\u000b\u0010¶\u0001\u001a\u0004\u0018\u00010\rH\u0002J\u000b\u0010·\u0001\u001a\u0004\u0018\u00010\rH\u0002J\t\u0010¸\u0001\u001a\u00020\u000bH\u0002J\t\u0010¹\u0001\u001a\u00020PH\u0002J\t\u0010º\u0001\u001a\u00020PH\u0002J\f\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J\u000b\u0010½\u0001\u001a\u0004\u0018\u00010DH\u0016J\u0014\u0010¾\u0001\u001a\u00020P2\t\u0010¿\u0001\u001a\u0004\u0018\u00010DH\u0016J\u000b\u0010À\u0001\u001a\u0004\u0018\u00010\rH\u0016J\t\u0010Á\u0001\u001a\u00020\u0014H\u0016J\t\u0010Â\u0001\u001a\u00020\u0014H\u0016J\u0019\u0010Ã\u0001\u001a\u00020P2\u000e\u0010Ä\u0001\u001a\t\u0012\u0004\u0012\u00020P0\u0083\u0001H\u0016J\u001a\u0010Å\u0001\u001a\u0004\u0018\u00010D2\u0006\u0010Z\u001a\u00020[H\u0096@¢\u0006\u0003\u0010Æ\u0001J\u000b\u0010Ç\u0001\u001a\u0004\u0018\u00010>H\u0002J\n\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u000b\u0010Ê\u0001\u001a\u0004\u0018\u00010[H\u0016J\t\u0010Ë\u0001\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r05X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00109\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020LX\u0082\u000e¢\u0006\u0004\n\u0002\u0010MR\u0012\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010§\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Í\u0001"}, d2 = {"Lcom/larus/sheet/impl/SheetFragment;", "Lcom/larus/office/base/OfficeBaseFragment;", "Lcom/larus/sheet/biz/impl/databinding/LarusLayoutSheetDetailFragmentBinding;", "Lcom/larus/bmhome/ability/FloatChatFoldStatusChangeListener;", "Lcom/larus/sheet/api/ISheetCotInfoListener;", "Lcom/larus/sheet/sdk/api/ISupportChangeScreenConfigPage;", "Lcom/larus/sheet/sdk/api/IGetTrackInfo;", "Lcom/larus/office/base/component/permission/NoPermissionPageHost;", "<init>", "()V", "customHeaderShowing", "", "slidesToken", "", "getSlidesToken", "()Ljava/lang/String;", "setSlidesToken", "(Ljava/lang/String;)V", "artifactVersionId", "resourceVersion", "", "conversationId", "sheetName", "firstInitChatFrag", "chatService", "Lcom/larus/sheet/sdk/api/IChatService;", "titleBarService", "Lcom/larus/office/base/service/ITitleBarService;", "selectionChangeService", "Lcom/larus/sheet/sdk/api/ISelectionChangeService;", "loadingService", "Lcom/larus/office/base/page/ILoadingService;", "enterMethod", "isSlidesDeleted", "hasReportPresentationBtnShow", "undoBtnEnabled", "hasReportUndoBtnShow", "redoBtnEnabled", "hasReportRedoBtnShow", "moreBtnEnabled", "hasReportMoreBtnShow", "renderStared", "isLandscapeMode", "()Z", "setLandscapeMode", "(Z)V", "isPad", "setPad", "cotRefArtifacts", "artifactMetaId", "boundMessageId", "botId", "deferredMsgId", "Lkotlinx/coroutines/CompletableDeferred;", "pendingSelectionData", "pendingSelectionPlainText", "latestSpreadsheetVersion", "lastAppBarHeight", "Ljava/lang/Integer;", "setServiceTimeStamp", "", "permissionAbility", "Lcom/larus/office/base/component/permission/IOfficePermissionChangeAbility;", "hasReceivedPermissionData", "permissionStateListener", "com/larus/sheet/impl/SheetFragment$permissionStateListener$1", "Lcom/larus/sheet/impl/SheetFragment$permissionStateListener$1;", "docContainerFragment", "Landroidx/fragment/app/Fragment;", "getDocContainerFragment", "()Landroidx/fragment/app/Fragment;", "setDocContainerFragment", "(Landroidx/fragment/app/Fragment;)V", "chatInputAndCotLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "speakStateListener", "com/larus/sheet/impl/SheetFragment$speakStateListener$1", "Lcom/larus/sheet/impl/SheetFragment$speakStateListener$1;", "canDelete", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "getLogTag", "getViewBinding", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onInitHostFragment", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initChameleonFragment", "onFloatChatFragmentInited", "getParamsBundle", "onViewCreated", "view", "Landroid/view/View;", "adapterSourceTitleBarContainerBeforeInjectToOfficeSDKLayout", "initParams", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getOrientationParam", "configuration", "adaptChatSpeakerInPad", "initHeadView", "onBackPressed", "getWebTrackParams", "Lcom/google/gson/JsonObject;", "getFloatChatFragmentContainerId", "getLocalConvIdSuffix", "getResourceType", "refreshArtifactInfo", "attachServices", "detachServices", "autoLogEnterPage", "generateDocLogicKeyForFindService", "initTitleBarService", "onObtainTitleBar", "onReadyInitTitleBar", "titleBar", "setupSearchMenuItem", "menuData", "Lcom/larus/office/base/service/BizMenuData;", "onMenuClick", "Lkotlin/Function1;", "itemId", "itemView", "Landroid/widget/ImageView;", "onMobShow", "Lkotlin/Function0;", "onMobClick", "onItemClick", "showMoreMenu", "moreMenuItemClick", "initChatService", "updateEditPanelHeight", "isActive", "updateChatInputVisibility", "isVisible", "from", "initSelectionChangeService", "applySelectionChange", "elementData", "plainText", "applyPendingSelectionChangeIfNeeded", "initLoadingService", "setSheetChatInputVisible", LiveCommonConstants.REASON_ON_DEDTROY, "updateArtifactInfo", "reportEnterPage", "getCurrentPageName", "getPreviousPage", "foldStatusChanged", "getTraceParams", "Lorg/json/JSONObject;", "getTrackingResourceType", "appBackgroundListener", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "initAppBackgroundListener", "curCotInfo", "Lcom/larus/bmhome/chat/bean/HeadTitleInfoSimplify;", "onCotInfoUpdate", "cotInfo", "setFullscreenMode", "fullScreenMode", "isHeaderViewLastVisible", "resetHeaderViewLastVisible", "interceptHeaderViewVisible", "changeOrientationMode", "adapterTitleBarOnOrientationMode", "onDestroyView", "toggleTitleBar", "states", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "updateHeaderViewVisibility", RemoteMessageConst.Notification.VISIBILITY, "notifyChatInputAndCotHeightChanged", "delay", "calculateChatInputHeight", "calculateChatInputAndCotHeight", "getArtifactCreateMethod", "getEnterMethod", "isSheetOwner", "attachComponent", "initPermissionAbility", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "getOfficeContainerFragment", "setOfficeContainerFragment", WidgetService.PARAM_FRAGMENT, "getToken", "getNoPermissionContainerId", "getOfficeContainerId", "runWhenAdded", "action", "createOfficeFragment", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPermissionAbility", "getNoPermissionBundleData", "Lcom/larus/office/base/component/permission/NoPermissionBundleData;", "getHostContext", "isHistoryVersion", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SheetFragment extends OfficeBaseFragment<LarusLayoutSheetDetailFragmentBinding> implements mw9.b, pw9.e, pw9.b, com.larus.office.base.component.permission.c {
    public static final /* synthetic */ int R = 0;
    public boolean A;
    public String B;
    public String C;
    public final CompletableDeferred<String> D;
    public String E;
    public String F;
    public String G;
    public final long H;
    public com.larus.office.base.component.permission.a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f368967J;
    public final b K;
    public Fragment L;
    public final com.larus.sheet.impl.c M;
    public final c N;
    public l O;
    public ic8.t P;
    public boolean Q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f368968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f368969j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f368970k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f368971l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f368972m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n f368973n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SheetFragment$initTitleBarService$1 f368974o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p f368975p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public o f368976q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f368977r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f368978s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f368979t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f368980u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f368981v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f368982w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f368983x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f368984y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f368985z;

    public static final class a {
    }

    public static final class b implements com.larus.office.base.component.permission.a.InterfaceC4430a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetFragment f368986a;

        public b(SheetFragment r100) {
            this.f368986a = r100;
        }

        @Override // com.larus.office.base.component.permission.a.InterfaceC4430a
        public final void a(DocPermissionFullData r100) {
            Intrinsics.checkNotNullParameter(r100, "permission");
            this.f368986a.f368967J = true;
        }
    }

    public static final class c implements com.larus.bmhome.chat.component.bottom.core.speaker.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetFragment f368987a;

        public c(SheetFragment r100) {
            this.f368987a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.h
        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            FLogger.f375446a.i("onStateChanged", "onStateChanged state=" + r100);
            boolean r101 = true;
            if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.f299421a) == false) goto L15;
            SheetFragment r102 = this.f368987a;
            int r103 = SheetFragment.R;
            LarusLayoutSheetDetailFragmentBinding r104 = (LarusLayoutSheetDetailFragmentBinding) r102.f360439e;
            if (r104 == null) goto L11;
            CotHeaderView r105 = r104.f368943e;
            if (r105 == null) goto L11;
            if (r105.getVisibility() != 0) goto L11;
        L12:
            if (r101 == false) goto L46;
            this.f368987a.sa0(4, "speakerStateChanged");
            return;
        L46:
            return;
        L11:
            r101 = false;
            goto L12
        L15:
            if (Intrinsics.areEqual(r100, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.f299420a) == false) goto L17;
            SheetFragment r106 = this.f368987a;
            r106.Q = false;
            r106.sa0(8, "speakerStateChanged");
            return;
        L17:
            SheetFragment r107 = this.f368987a;
            int r108 = SheetFragment.R;
            LarusLayoutSheetDetailFragmentBinding r109 = (LarusLayoutSheetDetailFragmentBinding) r107.f360439e;
            if (r109 == null) goto L24;
            CotHeaderView r110 = r109.f368943e;
            if (r110 == null) goto L24;
            if (r110.getVisibility() != 4) goto L24;
            boolean r111 = true;
        L25:
            if (r111 == false) goto L49;
            Fragment r112 = this.f368987a.f360440f;
            if (r112 != null) goto L29;
        L31:
            boolean r113 = false;
        L32:
            if (r113 == false) goto L50;
            Fragment r114 = this.f368987a.f360440f;
            if (r114 == null) goto L42;
            t1a.b r115 = s1a.a.g(r114);
            if (r115 == null) goto L42;
            g0 r116 = (g0) r115.getAbility(g0.class);
            if (r116 == null) goto L42;
            if (r116.YC() != true) goto L42;
        L43:
            if (r101 == true) goto L51;
            this.f368987a.ma0();
            return;
        L51:
            return;
        L42:
            r101 = false;
            goto L43
        L50:
            return;
        L29:
            if (r112.isAdded() != true) goto L31;
            r113 = true;
            goto L32
        L49:
            return;
        L24:
            r111 = false;
            goto L25
        }
    }

    /* JADX INFO: renamed from: com.larus.sheet.impl.SheetFragment$onCotInfoUpdate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.sheet.impl.SheetFragment$onCotInfoUpdate$1", f = "SheetFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ic8.t $cotInfo;
        final /* synthetic */ Ref.ObjectRef<ic8.t> $result;
        int label;
        final /* synthetic */ SheetFragment this$0;

        public AnonymousClass1(ic8.t r100, SheetFragment r101, Ref.ObjectRef<ic8.t> r102, Continuation<? super AnonymousClass1> r103) {
            this.$cotInfo = r100;
            this.this$0 = r101;
            this.$result = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$cotInfo, this.this$0, this.$result, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r5v14, types: [T, ic8.t] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r100);
            boolean r101 = false;
            if (this.$cotInfo.f489254f != 3) goto L7;
            SheetFragment r102 = this.this$0;
            r102.Q = false;
            r102.sa0(8, "onCotInfoUpdateDismiss");
        L22:
            SheetFragment r103 = this.this$0;
            int r104 = SheetFragment.R;
            LarusLayoutSheetDetailFragmentBinding r105 = (LarusLayoutSheetDetailFragmentBinding) r103.f360439e;
            if (r105 == null) goto L28;
            CotHeaderView r106 = r105.f368943e;
            if (r106 == null) goto L28;
            r106.R5(this.$result.element);
        L28:
            return Unit.INSTANCE;
        L7:
            SheetFragment r107 = this.this$0;
            int r108 = SheetFragment.R;
            r107.getClass();
            ic8.t r109 = this.$cotInfo;
            if (r109.f489254f != 2) goto L10;
            Ref.ObjectRef<ic8.t> r110 = this.$result;
            r110.element = ic8.t.a(r109);
            SheetFragment r111 = this.this$0;
            r111.Q = false;
            r111.sa0(8, "onCotInfoUpdateEnd");
            goto L22
        L10:
            Fragment r112 = this.this$0.f360440f;
            if (r112 == null) goto L19;
            t1a.b r113 = s1a.a.g(r112);
            if (r113 == null) goto L19;
            g0 r114 = (g0) r113.getAbility(g0.class);
            if (r114 == null) goto L19;
            if (r114.YC() != true) goto L19;
            r101 = true;
        L19:
            if (r101 == false) goto L21;
            this.this$0.sa0(4, "onCotInfoUpdateExpand");
            goto L22
        L21:
            this.this$0.ma0();
            goto L22
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.larus.office.base.component.permission.c
    public final int C3() {
        return R.id.doc_fragment_container;
    }

    @Override // com.larus.office.base.component.permission.c
    public final int J7() {
        return R.id.sheet_no_permission_fragment_container;
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final int V90() {
        return R.id.sheet_chat_input_container;
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final String W90() {
        return "-sheets-detail";
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final int Y90() {
        return 12;
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final String getLogTag() {
        return "SheetFragment";
    }

    @Override // pw9.e
    public final String ha() {
        return "";
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "aisheet_detail";
    }

    @Override // com.larus.office.base.component.permission.c
    public final com.larus.office.base.component.permission.b X2() {
        com.larus.office.base.component.permission.a r100 = this.I;
        if (r100 != null) goto L5;
        r100 = (com.larus.office.base.component.permission.a) s1a.a.g(this).getAbility(com.larus.office.base.component.permission.a.class);
    L5:
        ArrayList<DocMeta> r101 = null;
        if (r100 == null) goto L13;
        DocPermissionFullData r102 = r100.C4();
        if (r102 == null) goto L13;
        fo9.f r103 = r102.getOwner();
        if (r103 == null) goto L13;
        String r104 = r103.f478181a;
        if (r104 == null) goto L13;
    L30:
        String r105 = r104;
        Bundle r106 = getArguments();
        if (r106 == null) goto L33;
        String r107 = r106.getString("sheets_token");
    L34:
        String r108 = this.f368972m;
        Bundle r109 = getArguments();
        if (r109 == null) goto L37;
        String r110 = r109.getString("enter_method");
    L38:
        Bundle r111 = getArguments();
        if (r111 == null) goto L41;
        String r112 = r111.getString("key_apply_permission_message_id");
    L42:
        Bundle r113 = getArguments();
        if (r113 == null) goto L45;
        String r114 = r113.getString("key_apply_permission_conversation_id");
    L46:
        Bundle r115 = getArguments();
        if (r115 == null) goto L50;
        r101 = com.larus.office.base.preview.a.a(r115, "key_doc_list_to_apply_permission");
    L50:
        return new com.larus.office.base.component.permission.b(r107, r108, r105, 3, r110, r112, r114, r101);
    L45:
        r114 = null;
        goto L46
    L41:
        r112 = null;
        goto L42
    L37:
        r110 = null;
        goto L38
    L33:
        r107 = null;
    L13:
        if (r100 == null) goto L19;
        DocPermissionFullData r116 = r100.C4();
        if (r116 == null) goto L19;
        fo9.f r117 = r116.getOwner();
        if (r117 == null) goto L19;
        r104 = r117.f478182b;
    L20:
        if (r104 != null) goto L30;
        if (r100 == null) goto L27;
        DocPermissionFullData r118 = r100.C4();
        if (r118 == null) goto L27;
        fo9.f r119 = r118.getOwner();
        if (r119 == null) goto L27;
        r104 = r119.f478183c;
    L28:
        if (r104 != null) goto L30;
        r104 = "";
    L27:
        r104 = null;
    L19:
        r104 = null;
        goto L20
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final void ca0() {
        Fragment r100 = this.f360440f;
        if (r100 == null) goto L9;
        t1a.b r101 = s1a.a.g(r100);
        if (r101 == null) goto L9;
        va8.r r102 = (va8.r) r101.o(Reflection.getOrCreateKotlinClass(va8.r.class));
        if (r102 == null) goto L9;
        r102.JD("aisheet_detail");
    L9:
        Fragment r103 = this.f360440f;
        if (r103 == null) goto L16;
        t1a.b r104 = s1a.a.g(r103);
        if (r104 == null) goto L16;
        va8.o r105 = (va8.o) r104.o(Reflection.getOrCreateKotlinClass(va8.o.class));
        if (r105 == null) goto L16;
        int r106 = com.larus.office.k.f362219a;
        r105.S6(getString(R.string.larus_Doubao_sheet_input_placeholder_editOrAsk_cn));
    L16:
        Fragment r107 = this.f360440f;
        if (r107 == null) goto L23;
        t1a.b r108 = s1a.a.g(r107);
        if (r108 == null) goto L23;
        va8.o r109 = (va8.o) r108.o(Reflection.getOrCreateKotlinClass(va8.o.class));
        if (r109 == null) goto L23;
        int r110 = com.larus.office.k.f362219a;
        r109.HH(getString(R.string.larus_Doubao_sheet_input_placeholder_editOrAsk_cn));
    L23:
        Fragment r111 = this.f360440f;
        if (r111 == null) goto L30;
        t1a.b r112 = s1a.a.g(r111);
        if (r112 == null) goto L30;
        mw9.a r113 = (mw9.a) r112.o(Reflection.getOrCreateKotlinClass(mw9.a.class));
        if (r113 == null) goto L30;
        r113.f80(this);
    L30:
        Fragment r114 = this.f360440f;
        if (r114 == null) goto L37;
        t1a.b r115 = s1a.a.g(r114);
        if (r115 == null) goto L37;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r116 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r115.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r116 == null) goto L37;
        r116.e8(this.N);
    L37:
        Fragment r117 = this.f360440f;
        if (r117 == null) goto L42;
        boolean r118 = true;
        if (r117.isAdded() != true) goto L42;
    L43:
        if (r118 == false) goto L52;
        String r119 = this.E;
        if (r119 == null) goto L48;
    L50:
        String r120 = this.F;
        this.E = null;
        this.F = null;
        fa0(r119, r120);
        return;
    L48:
        if (this.F != null) goto L50;
        return;
    L52:
        return;
    L42:
        r118 = false;
        goto L43
    }

    public final void ea0() {
        if (e2.f365734a.isPad() == true) goto L5;
        return;
    L5:
        LarusLayoutSheetDetailFragmentBinding r100 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r100 == null) goto L12;
        if (r100 == null) goto L13;
        CotHeaderView r101 = r100.f368943e;
        if (r101 == null) goto L14;
        r101.setPadding(i5.h() + f3.a.b(), r101.getPaddingTop(), (i5.h() + f3.a.b()) + i5.Y(), r101.getPaddingBottom());
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // va8.d
    public final void foldStatusChanged() {
        Fragment r100 = this.f360440f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isAdded() == false) goto L62;
        g0 r101 = (g0) s1a.a.g(r100).getAbility(g0.class);
        boolean r102 = true;
        if (r101 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        Integer r104 = null;
        Drawable r105 = null;
        r105 = null;
        r104 = null;
        if (r103 == false) goto L40;
        g0 r106 = (g0) s1a.a.g(r100).getAbility(g0.class);
        if (r106 == null) goto L22;
        Context r107 = r100.getContext();
        if (r107 == null) goto L21;
        Resources r108 = r107.getResources();
        if (r108 == null) goto L21;
        r105 = r108.getDrawable(R.drawable.larus_float_chat_input_frag_bg);
    L21:
        r106.gA(r105);
    L22:
        LarusLayoutSheetDetailFragmentBinding r109 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r109 == null) goto L27;
        View r110 = r109.f368940b;
        if (r110 == null) goto L27;
        e1.x(r110);
    L27:
        ISheetSdkProxyService r111 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r111 == null) goto L30;
        r111.a();
    L30:
        FLogger.f375446a.i("SheetFragment", "foldStatusChanged loadingText invisible");
        LarusLayoutSheetDetailFragmentBinding r112 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r112 == null) goto L37;
        CotHeaderView r113 = r112.f368943e;
        if (r113 == null) goto L37;
        if (r113.getVisibility() != 0) goto L37;
    L38:
        if (r102 == false) goto L63;
        sa0(4, "foldStatusChangedExpand");
        return;
    L63:
        return;
    L37:
        r102 = false;
        goto L38
    L40:
        LarusLayoutSheetDetailFragmentBinding r114 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r114 == null) goto L45;
        View r115 = r114.f368940b;
        if (r115 == null) goto L45;
        e1.o(r115);
    L45:
        FLogger r116 = FLogger.f375446a;
        StringBuilder r117 = new StringBuilder("foldStatusChanged loadingText visibility=");
        LarusLayoutSheetDetailFragmentBinding r118 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r118 == null) goto L50;
        CotHeaderView r119 = r118.f368943e;
        if (r119 == null) goto L50;
        r104 = Integer.valueOf(r119.getVisibility());
    L50:
        r117.append(r104);
        r116.i("SheetFragment", r117.toString());
        LarusLayoutSheetDetailFragmentBinding r120 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r120 == null) goto L57;
        CotHeaderView r121 = r120.f368943e;
        if (r121 == null) goto L57;
        if (r121.getVisibility() != 4) goto L57;
    L58:
        if (r102 == false) goto L65;
        ma0();
        return;
    L65:
        return;
    L57:
        r102 = false;
        goto L58
    L9:
        if (r101.YC() != true) goto L11;
        r103 = true;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.sheet.impl.SheetFragment$initTitleBarService$1] */
    public final void ga0() {
        this.f368974o = new SheetFragment$initTitleBarService$1(this);
        ISheetSdkProxyService r100 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r100 == null) goto L5;
        r100.addTitleBarService(this.f368974o);
    L5:
        this.f368973n = new n(this);
        ISheetSdkProxyService r101 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r101 == null) goto L8;
        r101.f(this.f368973n);
    L8:
        this.f368975p = new p(this);
        ISheetSdkProxyService r102 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r102 == null) goto L11;
        r102.l(this.f368975p);
    L11:
        FLogger r103 = FLogger.f375446a;
        r103.d("SheetFragment", "initLoadingService");
        this.f368976q = new o(this);
        r103.d("SheetFragment", "addLoadingService loadingService=" + this.f368976q + " hashCode=" + hashCode());
        ISheetSdkProxyService r104 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r104 == null) goto L15;
        r104.addLoadingService(this.f368976q);
        return;
    }

    public final int ha0() {
        LarusLayoutSheetDetailFragmentBinding r100 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        Integer r101 = null;
        if (r100 == null) goto L5;
        CotHeaderView r102 = r100.f368943e;
    L6:
        boolean r103 = true;
        int r104 = 0;
        if (r102 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L23;
        Integer r106 = Integer.valueOf(r102.getHeight());
        if (r106.intValue() <= 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == true) goto L20;
        r106 = null;
    L20:
        if (r106 == null) goto L22;
        int r108 = r106.intValue();
    L24:
        LarusLayoutSheetDetailFragmentBinding r109 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r109 == null) goto L27;
        FrameLayout r110 = r109.f368944f;
    L28:
        if (r110 != null) goto L30;
    L32:
        boolean r111 = false;
    L33:
        if (r111 == false) goto L43;
        if (r110 == null) goto L43;
        Integer r112 = Integer.valueOf(r110.getHeight());
        if (r112.intValue() > 0) goto L39;
        r103 = false;
    L39:
        if (r103 == false) goto L41;
        r101 = r112;
    L41:
        if (r101 == null) goto L43;
        int r113 = r101.intValue();
    L44:
        if (r111 == false) goto L49;
        if (r113 <= 0) goto L47;
        r104 = r113;
        goto L49
    L47:
        r104 = ia0();
    L49:
        return r108 + r104;
    L43:
        r113 = 0;
        goto L44
    L30:
        if (r110.getVisibility() != 0) goto L32;
        r111 = true;
        goto L33
    L27:
        r110 = null;
        goto L28
    L22:
        r108 = r102.getMeasuredHeight();
        goto L24
    L16:
        r107 = false;
        goto L17
    L23:
        r108 = 0;
        goto L24
    L9:
        if (r102.getVisibility() != 0) goto L11;
        r105 = true;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final int ia0() {
        LarusLayoutSheetDetailFragmentBinding r100 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r100 == null) goto L7;
        FrameLayout r101 = r100.f368944f;
        if (r101 == null) goto L7;
        View r102 = r101.findViewById(R.id.input);
    L8:
        if (r102 == null) goto L10;
        int r103 = r102.getHeight();
    L11:
        if (r103 <= 0) goto L13;
        return r103;
    L13:
        return c7.b(110);
    L10:
        r103 = 0;
    L7:
        r102 = null;
        goto L8
    }

    public final int la0() {
        int r100 = com.larus.office.base.utils.o.f361178a;
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getInt("resource_type", 12));
    L6:
        Integer r103 = com.larus.office.base.utils.o.b(r102, 12);
        if (r103 != null) goto L9;
        return 12;
    L9:
        return r103.intValue();
    L5:
        r102 = null;
        goto L6
    }

    public final void ma0() {
        ic8.t r100 = this.P;
        if (r100 == null) goto L8;
        Map<String, String> r101 = r100.f489253e;
        if (r101 == null) goto L8;
        String r102 = r101.get("cot_ref_artifacts");
        if (r102 == null) goto L8;
    L10:
        if (this.f368985z == true) goto L31;
        boolean r103 = true;
        if (r102.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        String r105 = null;
        if (r104 == true) goto L18;
    L24:
        Bundle r106 = getArguments();
        if (r106 == null) goto L28;
        r105 = r106.getString("drive_override_current_page");
    L28:
        if (Intrinsics.areEqual(r105, "ai_space_detail") == false) goto L32;
    L29:
        sa0(0, "interceptHeaderViewVisible");
        return;
    L32:
        return;
    L18:
        if (this.B.length() > 0) goto L21;
        r103 = false;
    L21:
        if (r103 == false) goto L24;
        if (StringsKt.contains$default(r102, this.B, false, 2, null) == true) goto L29;
    L14:
        r104 = false;
        goto L15
    L31:
        return;
    L8:
        r102 = "";
        goto L10
    }

    @Override // com.larus.office.base.OfficeBaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        FLogger r100 = FLogger.f375446a;
        r100.i("SheetFragment", "[onDestroy]");
        Fragment r101 = this.f360440f;
        if (r101 != null) goto L5;
    L9:
        l r102 = this.O;
        if (r102 == null) goto L13;
        AppHost.f326268a.a().c(r102);
    L13:
        if (this.f368978s == true) goto L15;
        int r103 = nw9.a.f521014b;
        nw9.a.c("click_back", Long.valueOf(System.currentTimeMillis() - nw9.a.f521013a), t9());
    L15:
        Fragment r104 = this.f360440f;
        if (r104 == null) goto L22;
        t1a.b r105 = s1a.a.g(r104);
        if (r105 == null) goto L22;
        mw9.a r106 = (mw9.a) r105.o(Reflection.getOrCreateKotlinClass(mw9.a.class));
        if (r106 == null) goto L22;
        r106.iI(this);
    L22:
        Fragment r107 = this.f360440f;
        if (r107 == null) goto L29;
        t1a.b r108 = s1a.a.g(r107);
        if (r108 == null) goto L29;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r109 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) r108.getAbility(com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        if (r109 == null) goto L29;
        r109.B9(this.N);
    L29:
        com.larus.office.base.component.permission.a r110 = this.I;
        if (r110 == null) goto L32;
        r110.LR(this.K);
    L32:
        ISheetSdkProxyService r111 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r111 == null) goto L35;
        r111.e(this.f368973n);
    L35:
        ISheetSdkProxyService r112 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r112 == null) goto L38;
        r112.j(this.f368974o);
    L38:
        ISheetSdkProxyService r113 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r113 == null) goto L41;
        r113.g(this.f368975p);
    L41:
        r100.d("SheetFragment", "removeLoadingService loadingService=" + this.f368976q + " hashCode=" + hashCode());
        ISheetSdkProxyService r114 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r114 == null) goto L44;
        r114.h(this.f368976q);
    L44:
        super.onDestroy();
        return;
    L5:
        if (r101.isAdded() == false) goto L9;
        g0 r115 = (g0) s1a.a.g(r101).getAbility(g0.class);
        if (r115 == null) goto L9;
        r115.Zh(this);
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        LarusLayoutSheetDetailFragmentBinding r100 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r100 == null) goto L7;
        CotHeaderView r101 = r100.f368943e;
        if (r101 == null) goto L7;
        r101.removeOnLayoutChangeListener(this.M);
    L7:
        LarusLayoutSheetDetailFragmentBinding r102 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r102 == null) goto L12;
        FrameLayout r103 = r102.f368944f;
        if (r103 == null) goto L12;
        r103.removeOnLayoutChangeListener(this.M);
    L12:
        ISheetSdkProxyService r104 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r104 == null) goto L15;
        r104.a();
    L15:
        super.onDestroyView();
    }

    public final void pa0() {
        if (TextUtils.isEmpty(this.B) == false) goto L9;
        Bundle r100 = getArguments();
        if (r100 == null) goto L8;
        String r101 = r100.getString("artifact_meta_id");
        if (r101 == null) goto L8;
    L10:
        Bundle r102 = getArguments();
        String r103 = null;
        if (r102 == null) goto L16;
        String r104 = r102.getString("previous_page");
        if (r104 != null) goto L15;
        String r210 = "";
    L17:
        Bundle r105 = getArguments();
        if (r105 == null) goto L20;
        r103 = r105.getString("previous_page");
    L20:
        String r106 = "ai_space_list";
        if (Intrinsics.areEqual(r103, "ai_space_list") == true) goto L24;
        r106 = this.f368977r;
    L24:
        String r110 = r106;
        JSONObject r107 = new JSONObject();
        Bundle r108 = getArguments();
        if (r108 == null) goto L30;
        String r109 = r108.getString("resource_id");
        if (r109 == null) goto L29;
        r107.put("spreadsheet_id", r109);
        r107.put("resource_id", r109);
    L29:
        r107.put("resource_type", la0());
        r107.put("artifact_meta_id", r101);
        r107.put("artifact_type", 12);
    L30:
        a1.c(null, null, null, null, null, "aisheet_detail", null, null, r110, null, null, null, null, null, null, null, r210, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r107, null, null, null, null, null, null, null, null, -1049729, -8388609, 7);
        return;
    L15:
        r210 = r104;
        goto L17
    L16:
        r210 = null;
    L8:
        r101 = "";
        goto L10
    L9:
        r101 = this.B;
        goto L10
    }

    @Override // pw9.b
    public final JSONObject t9() {
        JSONObject r100 = new JSONObject();
        Object r101 = by7.h.a(this).getParams().get("previous_page");
        String r102 = null;
        if ((r101 instanceof String) == false) goto L5;
        String r103 = (String) r101;
    L6:
        r100.put("previous_page", r103);
        r100.put("current_page", "aisheet_detail");
        r100.put("canvas_type", "aisheet");
        r100.put("artifact_create_method", ka0());
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        r102 = r104.getString("previous_page");
    L9:
        String r105 = "ai_space_list";
        if (Intrinsics.areEqual(r102, "ai_space_list") == true) goto L13;
        r105 = this.f368977r;
    L13:
        if (r105 == null) goto L15;
        r100.put("enter_method", r105);
    L15:
        Bundle r106 = getArguments();
        if (r106 == null) goto L35;
        String r107 = r106.getString("resource_id");
        if (r107 == null) goto L20;
        r100.put("resource_id", r107);
        r100.put("spreadsheet_id", r107);
    L20:
        r100.put("resource_type", la0());
        String r108 = r106.getString("artifact_meta_id");
        if (r108 == null) goto L23;
        r100.put("artifact_meta_id", r108);
    L23:
        r100.put("artifact_type", 12);
        String r109 = r106.getString(MusicAppletPage.KEY_MESSAGE_ID);
        if (r109 == null) goto L26;
        r100.put(MusicAppletPage.KEY_MESSAGE_ID, r109);
    L26:
        String r110 = r106.getString("aippt_task_id");
        if (r110 == null) goto L29;
        r100.put("aippt_task_id", r110);
    L29:
        String r111 = r106.getString("conversation_id");
        if (r111 == null) goto L32;
        r100.put("conversation_id", r111);
    L32:
        String r112 = r106.getString("bot_id");
        if (r112 == null) goto L35;
        r100.put("bot_id", r112);
    L35:
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.sheet.impl.c] */
    public SheetFragment() {
        this.f368969j = "";
        this.f368970k = "";
        this.f368971l = "";
        this.B = "";
        this.D = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.H = System.currentTimeMillis();
        this.K = new b(this);
        this.M = new com.larus.sheet.impl.c(this);
        this.N = new c(this);
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final Bundle X90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L6;
        String r101 = r100.getString("previous_page");
        if (r101 == null) goto L6;
    L7:
        Bundle r102 = getArguments();
        String r103 = null;
        if (r102 == null) goto L10;
        String r104 = r102.getString("drive_override_current_page");
    L11:
        Pair[] r105 = new Pair[10];
        r105[0] = TuplesKt.to("sheets_token", this.f368969j);
        r105[1] = TuplesKt.to("artifact_version_id", this.f368970k);
        r105[2] = TuplesKt.to("conversation_id", this.f368971l);
        r105[3] = TuplesKt.to("artifact_meta_id", this.B);
        r105[4] = TuplesKt.to("argPreviousPage", r101);
        r105[5] = TuplesKt.to("token", this.f368969j);
        r105[6] = TuplesKt.to("drive_override_current_page", r104);
        Bundle r106 = getArguments();
        if (r106 == null) goto L14;
        String r107 = r106.getString("resource_id");
    L15:
        r105[7] = TuplesKt.to("resource_id", r107);
        Bundle r108 = getArguments();
        if (r108 == null) goto L18;
        Integer r109 = Integer.valueOf(r108.getInt("resource_type", 0));
    L19:
        r105[8] = TuplesKt.to("resource_type", r109);
        Bundle r110 = getArguments();
        if (r110 == null) goto L22;
        r103 = r110.getString("key_source_url_for_params");
    L22:
        r105[9] = TuplesKt.to("key_source_url_for_params", r103);
        return BundleKt.bundleOf(r105);
    L18:
        r109 = null;
        goto L19
    L14:
        r107 = null;
        goto L15
    L10:
        r104 = null;
    L6:
        r101 = "";
        goto L7
    }

    @Override // com.larus.office.base.component.permission.c
    public final Context getHostContext() {
        return getContext();
    }

    public final String ja0() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L6;
        String r101 = r100.getString("sheets_token");
        if (r101 == null) goto L6;
    L8:
        return r101 + '_' + this.H;
    L6:
        r101 = "";
        goto L8
    }

    public final String ka0() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("drive_override_current_page");
    L7:
        if (Intrinsics.areEqual(r101, "ai_space_detail") == true) goto L10;
        return "ai_space";
    L10:
        return null;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean na0() {
        Bundle r100 = getArguments();
        int r101 = -1;
        if (r100 == null) goto L5;
        r101 = r100.getInt("resource_version", -1);
    L5:
        if (r101 < 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.larus.office.base.component.permission.c
    public final FragmentManager y1() {
        return getChildFragmentManager();
    }

    @Override // com.larus.office.base.component.permission.c
    public final Fragment d5() {
        return this.L;
    }

    @Override // com.larus.office.base.component.permission.c
    public final String getToken() {
        return this.f368969j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.office.base.OfficeBaseFragment
    public final Fragment aa0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FLogger.f375446a.i("SheetFragment", "Init SheetFragment");
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SheetFragment$initChameleonFragment$1(r100, this, r101, null), 3, null);
        return (Fragment) r101.element;
    }

    @Override // pw9.e
    public final void d4(int r100) {
        if (r100 != TitleBarStates.VISIBLE.getStates()) goto L5;
        boolean r101 = true;
    L6:
        FLogger.f375446a.i("SheetFragment", "toggleTitleBar: isVisible -> " + r101 + ", isLandscapeMode -> " + this.f368985z);
        if (this.f368985z == false) goto L11;
        vm9.d r102 = com.larus.office.base.service.m.b();
        if (r102 == null) goto L14;
        r102.setTitleBarVisible(r101, true);
    L14:
        if (r101 == false) goto L20;
        LarusLayoutSheetDetailFragmentBinding r103 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r103 == null) goto L26;
        FrameLayout r104 = r103.f368950l;
        if (r104 == null) goto L27;
        e1.x(r104);
        return;
    L27:
        return;
    L26:
        return;
    L20:
        LarusLayoutSheetDetailFragmentBinding r105 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r105 == null) goto L29;
        FrameLayout r106 = r105.f368950l;
        if (r106 == null) goto L30;
        e1.o(r106);
        return;
    L30:
        return;
    L29:
        return;
    L11:
        vm9.d r107 = com.larus.office.base.service.m.b();
        if (r107 == null) goto L14;
        r107.setTitleBarVisible(r101, false);
        goto L14
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.office.base.component.permission.c
    public final void d7(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (isAdded() == false) goto L6;
        r100.invoke();
        return;
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final void da0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L74
        Bundle r102 = getArguments();     // Catch: Throwable -> L74
        String r103 = "";
        if (r102 == null) goto L8;
        String r104 = r102.getString("sheets_token");     // Catch: Throwable -> L74
        if (r104 == null) goto L8;
    L9:
        this.f368969j = r104;     // Catch: Throwable -> L74
        Bundle r105 = getArguments();     // Catch: Throwable -> L74
        if (r105 == null) goto L13;
        String r106 = r105.getString("artifact_version_id");     // Catch: Throwable -> L74
        if (r106 == null) goto L13;
    L14:
        this.f368970k = r106;     // Catch: Throwable -> L74
        Bundle r107 = getArguments();     // Catch: Throwable -> L74
        if (r107 == null) goto L17;
        r107.getInt("resource_version", -1);     // Catch: Throwable -> L74
    L17:
        Bundle r108 = getArguments();     // Catch: Throwable -> L74
        if (r108 == null) goto L23;
        String r109 = r108.getString("conversation_id");     // Catch: Throwable -> L74
        if (r109 == null) goto L23;
        r103 = r109;
    L23:
        this.f368971l = r103;     // Catch: Throwable -> L74
        Bundle r110 = getArguments();     // Catch: Throwable -> L74
        ConstraintLayout.LayoutParams r111 = null;
        if (r110 == null) goto L26;
        String r112 = r110.getString("enter_method");     // Catch: Throwable -> L74
    L27:
        this.f368977r = r112;     // Catch: Throwable -> L74
        int r113 = 0;
        if (this.f368969j.length() != 0) goto L31;
        boolean r114 = true;
    L33:
        if (r114 == false) goto L36;
        FLogger.f375446a.i("SheetFragment", "Invalid slides token");     // Catch: Throwable -> L74
        requireActivity().finish();     // Catch: Throwable -> L74
        return;
    L36:
        Fragment r115 = aa0(r100);     // Catch: Throwable -> L74
        if (r115 == null) goto L39;
        this.L = r115;     // Catch: Throwable -> L74
    L39:
        FLogger.f375446a.i("SheetFragment", "onInitHostFragment setupServices");     // Catch: Throwable -> L74
        ga0();     // Catch: Throwable -> L74
        VB r116 = this.f360439e;     // Catch: Throwable -> L74
        LarusLayoutSheetDetailFragmentBinding r117 = (LarusLayoutSheetDetailFragmentBinding) r116;     // Catch: Throwable -> L74
        if (r117 == null) goto L59;
        FrameLayout r118 = r117.f368950l;     // Catch: Throwable -> L74
        if (r118 == null) goto L59;
        LarusLayoutSheetDetailFragmentBinding r119 = (LarusLayoutSheetDetailFragmentBinding) r116;     // Catch: Throwable -> L74
        if (r119 == null) goto L48;
        FrameLayout r120 = r119.f368950l;     // Catch: Throwable -> L74
        if (r120 == null) goto L48;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();     // Catch: Throwable -> L74
    L50:
        if ((r121 instanceof ConstraintLayout.LayoutParams) == false) goto L52;
        ConstraintLayout.LayoutParams r122 = (ConstraintLayout.LayoutParams) r121;     // Catch: Throwable -> L74
    L53:
        if (r122 == null) goto L58;
        FragmentActivity r123 = getActivity();     // Catch: Throwable -> L74
        if (r123 == null) goto L57;
        r113 = com.larus.utils.u.c(r123);     // Catch: Throwable -> L74
    L57:
        ((ViewGroup.MarginLayoutParams) r122).topMargin = r113;     // Catch: Throwable -> L74
        r111 = r122;
    L58:
        r118.setLayoutParams(r111);     // Catch: Throwable -> L74
        goto L59
    L52:
        r122 = null;
    L48:
        r121 = null;
    L59:
        LarusLayoutSheetDetailFragmentBinding r124 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;     // Catch: Throwable -> L74
        if (r124 == null) goto L64;
        ImageView r125 = r124.f368949k;     // Catch: Throwable -> L74
        if (r125 == null) goto L64;
        e1.d(r125, new e(this));     // Catch: Throwable -> L74
    L64:
        LarusLayoutSheetDetailFragmentBinding r126 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;     // Catch: Throwable -> L74
        if (r126 == null) goto L69;
        LinearLayout r127 = r126.f368947i;     // Catch: Throwable -> L74
        if (r127 == null) goto L69;
        e1.d(r127, new f());     // Catch: Throwable -> L74
    L69:
        HashMap<String, MutableLiveData<Boolean>> r128 = com.larus.sheet.operation.f.f369099a;     // Catch: Throwable -> L74
        com.larus.sheet.operation.f.d(this.f368969j);     // Catch: Throwable -> L74
        if (TextUtils.isEmpty(this.f368971l) == true) goto L72;
        pa0();     // Catch: Throwable -> L74
    L72:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L74
        return;
    L31:
        r114 = false;
        goto L33
    L26:
        r112 = null;
    L13:
        r106 = "";
    L8:
        r104 = "";
    L74:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        ea0();
        if (r100.orientation != 2) goto L5;
        boolean r101 = true;
    L6:
        this.f368985z = r101;
        ISheetSdkProxyService r102 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r102 == null) goto L9;
        r102.a();
    L9:
        LarusLayoutSheetDetailFragmentBinding r103 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r103 == null) goto L14;
        ConstraintLayout r104 = r103.f368948j;
        if (r104 == null) goto L14;
        com.larus.bmhome.view.screenmenu.d r105 = com.larus.bmhome.view.screenmenu.d.f317270a;
        com.larus.bmhome.view.screenmenu.d.b(r104);
    L14:
        ConstraintLayout.LayoutParams r106 = null;
        if (this.f368985z == true) goto L17;
    L61:
        LarusLayoutSheetDetailFragmentBinding r107 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r107 == null) goto L66;
        ConstraintLayout r108 = r107.f368948j;
        if (r108 == null) goto L66;
        r108.setPadding(i5.r0(), 0, i5.r0(), 0);
    L66:
        LarusLayoutSheetDetailFragmentBinding r109 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r109 == null) goto L71;
        NovaTitleBarEx r110 = r109.f368951m;
        if (r110 == null) goto L71;
        r110.setPadding(0, 0, 0, 0);
    L71:
        LarusLayoutSheetDetailFragmentBinding r111 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r111 == null) goto L81;
        NovaTitleBarEx r112 = r111.f368951m;
        if (r112 == null) goto L81;
        if (r112.getVisibility() != 0) goto L78;
        boolean r113 = true;
    L79:
        if (r113 != true) goto L81;
        boolean r114 = true;
    L82:
        if (r114 == false) goto L84;
    L86:
        ra0(false, "setOrientationMode");
    L88:
        if (this.Q == false) goto L90;
        this.Q = false;
        ma0();
    L90:
        Fragment r115 = this.f360440f;
        if (r115 == null) goto L97;
        t1a.b r116 = s1a.a.g(r115);
        if (r116 == null) goto L97;
        va8.n r117 = (va8.n) r116.getAbility(va8.n.class);
        if (r117 == null) goto L97;
        r117.hideKeyboard();
    L97:
        LarusLayoutSheetDetailFragmentBinding r118 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r118 == null) goto L100;
        FrameLayout r119 = r118.f368941c;
    L101:
        if (r119 == null) goto L103;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
    L105:
        if ((r120 instanceof ConstraintLayout.LayoutParams) == false) goto L107;
        r106 = (ConstraintLayout.LayoutParams) r120;
    L107:
        if (r106 == null) goto L109;
        r106.topToTop = -1;
        r106.topToBottom = R.id.sheet_titlebar_container;
        r119.setLayoutParams(r106);
        r119.requestLayout();
    L109:
        vm9.d r121 = com.larus.office.base.service.m.b();
        if (r121 == null) goto L113;
        r121.changeNavigationNestedScrollState(false);
    L113:
        if (this.f368985z == true) goto L115;
    L119:
        vm9.d r122 = com.larus.office.base.service.m.b();
        if (r122 == null) goto L122;
        r122.onCustomHeaderPaddingChanged(0, 0);
    L122:
        FLogger.f375446a.i("SheetFragment", "onConfigurationChanged isLandscape=" + this.f368985z);
        return;
    L115:
        if (this.A == true) goto L119;
        vm9.d r123 = com.larus.office.base.service.m.b();
        if (r123 == null) goto L122;
        r123.onCustomHeaderPaddingChanged(i5.d0(), i5.d0());
        goto L122
    L103:
        r120 = null;
        goto L105
    L100:
        r119 = null;
        goto L101
    L84:
        if (this.f368968i == true) goto L86;
        ra0(true, "setOrientationMode");
        goto L88
    L78:
        r113 = false;
    L81:
        r114 = false;
        goto L82
    L17:
        if (this.A == true) goto L61;
        LarusLayoutSheetDetailFragmentBinding r124 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r124 == null) goto L24;
        ConstraintLayout r125 = r124.f368948j;
        if (r125 == null) goto L24;
        r125.setPadding(i5.k0(), 0, i5.k0(), 0);
    L24:
        LarusLayoutSheetDetailFragmentBinding r126 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r126 == null) goto L29;
        NovaTitleBarEx r127 = r126.f368951m;
        if (r127 == null) goto L29;
        r127.setPadding(i5.g0(), 0, i5.g0(), 0);
    L29:
        ra0(false, "setOrientationMode");
        LarusLayoutSheetDetailFragmentBinding r128 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r128 == null) goto L39;
        CotHeaderView r129 = r128.f368943e;
        if (r129 == null) goto L39;
        if (r129.getVisibility() != 0) goto L36;
        boolean r130 = true;
    L37:
        if (r130 != true) goto L39;
        boolean r131 = true;
    L40:
        if (r131 == false) goto L42;
        this.Q = true;
        sa0(8, "setOrientationMode");
    L42:
        Fragment r132 = this.f360440f;
        if (r132 == null) goto L49;
        t1a.b r133 = s1a.a.g(r132);
        if (r133 == null) goto L49;
        va8.n r134 = (va8.n) r133.getAbility(va8.n.class);
        if (r134 == null) goto L49;
        r134.hideKeyboard();
    L49:
        LarusLayoutSheetDetailFragmentBinding r135 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r135 == null) goto L52;
        FrameLayout r136 = r135.f368941c;
    L53:
        if (r136 == null) goto L55;
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
    L57:
        if ((r137 instanceof ConstraintLayout.LayoutParams) == false) goto L59;
        r106 = (ConstraintLayout.LayoutParams) r137;
    L59:
        if (r106 == null) goto L109;
        r106.topToBottom = -1;
        r106.topToTop = 0;
        r136.setLayoutParams(r106);
        r136.requestLayout();
        goto L109
    L55:
        r137 = null;
        goto L57
    L52:
        r136 = null;
        goto L53
    L36:
        r130 = false;
    L39:
        r131 = false;
        goto L40
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mw9.b
    public final void onCotInfoUpdate(ic8.t r110) {
        Intrinsics.checkNotNullParameter(r110, "cotInfo");
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = r110;
        this.P = r110;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onCotInfoUpdate cotInfo: title=");
        ic8.t r103 = this.P;
        if (r103 == null) goto L5;
        String r104 = r103.f489250b;
    L6:
        r102.append(r104);
        r102.append(" headerStatus=");
        ic8.t r105 = this.P;
        if (r105 == null) goto L9;
        Integer r106 = Integer.valueOf(r105.f489254f);
    L10:
        r102.append(r106);
        r102.append(" curCotRefArtifacts=");
        ic8.t r107 = this.P;
        if (r107 == null) goto L16;
        Map<String, String> r108 = r107.f489253e;
        if (r108 == null) goto L16;
        String r109 = r108.get("cot_ref_artifacts");
        if (r109 == null) goto L16;
    L17:
        r102.append(r109);
        r101.d("SheetFragment", r102.toString());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass1(r110, this, r100, null), 2, null);
        return;
    L16:
        r109 = "";
        goto L17
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = nw9.a.f521014b;
        nw9.a.f521013a = System.currentTimeMillis();
        l r102 = new l(this);
        AppHost.f326268a.a().j(r102);
        this.O = r102;
        if (getResources().getConfiguration().orientation != 2) goto L5;
        boolean r103 = true;
    L6:
        this.f368985z = r103;
        this.A = ku5.c.k(getContext());
        FLogger.f375446a.i("SheetFragment", "onCreate isPad=" + this.A + ", isLandscapeMode=" + this.f368985z);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void qa0(boolean r100) {
        int r101 = 0;
        ConstraintLayout.LayoutParams r102 = null;
        if (r100 == false) goto L21;
        VB r103 = this.f360439e;
        LarusLayoutSheetDetailFragmentBinding r104 = (LarusLayoutSheetDetailFragmentBinding) r103;
        if (r104 == null) goto L42;
        FrameLayout r105 = r104.f368950l;
        if (r105 == null) goto L43;
        LarusLayoutSheetDetailFragmentBinding r106 = (LarusLayoutSheetDetailFragmentBinding) r103;
        if (r106 == null) goto L13;
        FrameLayout r107 = r106.f368950l;
        if (r107 == null) goto L13;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
    L15:
        if ((r108 instanceof ConstraintLayout.LayoutParams) == false) goto L17;
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r108;
    L18:
        if (r109 == null) goto L20;
        ((ViewGroup.MarginLayoutParams) r109).topMargin = 0;
        r102 = r109;
    L20:
        r105.setLayoutParams(r102);
        return;
    L17:
        r109 = null;
    L13:
        r108 = null;
        goto L15
    L43:
        return;
    L42:
        return;
    L21:
        VB r110 = this.f360439e;
        LarusLayoutSheetDetailFragmentBinding r111 = (LarusLayoutSheetDetailFragmentBinding) r110;
        if (r111 == null) goto L45;
        FrameLayout r112 = r111.f368950l;
        if (r112 == null) goto L46;
        LarusLayoutSheetDetailFragmentBinding r113 = (LarusLayoutSheetDetailFragmentBinding) r110;
        if (r113 == null) goto L30;
        FrameLayout r114 = r113.f368950l;
        if (r114 == null) goto L30;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
    L32:
        if ((r115 instanceof ConstraintLayout.LayoutParams) == false) goto L34;
        ConstraintLayout.LayoutParams r116 = (ConstraintLayout.LayoutParams) r115;
    L35:
        if (r116 == null) goto L40;
        FragmentActivity r117 = getActivity();
        if (r117 == null) goto L39;
        r101 = com.larus.utils.u.c(r117);
    L39:
        ((ViewGroup.MarginLayoutParams) r116).topMargin = r101;
        r102 = r116;
    L40:
        r112.setLayoutParams(r102);
        return;
    L34:
        r116 = null;
    L30:
        r115 = null;
        goto L32
    L46:
        return;
    }

    @Override // com.larus.office.base.component.permission.c
    public final void x5(Fragment r100) {
        this.L = r100;
    }

    public static void oa0(SheetFragment r100, String r101) {
        int r102 = r100.ha0();
        ISheetSdkProxyService r103 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r103 == null) goto L5;
        r103.i(r102);
    L5:
        FLogger.f375446a.d("SheetFragment", "notifyChatInputAndCotHeightChanged from:" + r101 + " height:" + r102);
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final void D8(String r100, String r101) {
        Fragment r102 = this.f360440f;
        if (r102 == null) goto L10;
        t1a.b r103 = s1a.a.g(r102);
        if (r103 == null) goto L11;
        n0 r104 = (n0) r103.getAbility(n0.class);
        if (r104 == null) goto L12;
        r104.D8(r100, r101);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.larus.office.base.component.permission.c
    public final Object V3(Context r100, Continuation<? super Fragment> r101) {
        ISheetSdkServiceV2 r102 = (ISheetSdkServiceV2) ServiceManager.get().getService(ISheetSdkServiceV2.class);
        String r103 = null;
        if (r102 == null) goto L74;
        OfficeInputParam r104 = new OfficeInputParam();
        Bundle r105 = getArguments();
        String r106 = "";
        if (r105 == null) goto L8;
        String r107 = r105.getString("resource_id");
        if (r107 == null) goto L8;
    L9:
        r104.setResourceId(r107);
        Bundle r108 = getArguments();
        if (r108 == null) goto L13;
        String r109 = r108.getString("sheets_token");
        if (r109 == null) goto L13;
    L14:
        r104.setSlidesToken(r109);
        r104.setDocLogicKey(ja0());
        r104.setResourceType(12);
        Bundle r110 = getArguments();
        int r111 = -1;
        if (r110 == null) goto L17;
        r111 = r110.getInt("resource_version", -1);
    L17:
        r104.setResourceVersion(r111);
        Bundle r112 = getArguments();
        if (r112 == null) goto L21;
        String r113 = r112.getString("conversation_id");
        if (r113 == null) goto L21;
    L22:
        r104.setConversationId(r113);
        Bundle r114 = getArguments();
        if (r114 == null) goto L26;
        String r115 = r114.getString("artifact_meta_id");
        if (r115 == null) goto L26;
    L27:
        r104.setArtifactMetaId(r115);
        Bundle r116 = getArguments();
        if (r116 == null) goto L31;
        String r117 = r116.getString("enter_method");
        if (r117 == null) goto L31;
    L32:
        r104.setEnterMethod(r117);
        Bundle r118 = getArguments();
        if (r118 == null) goto L35;
        String r119 = r118.getString("doc_title");
    L36:
        r104.setDocTitle(r119);
        Bundle r120 = getArguments();
        if (r120 == null) goto L39;
        long r121 = r120.getLong("click_timestamp");
    L40:
        r104.setClickTimestamp(r121);
        r104.setBeginLoadTimestamp(System.currentTimeMillis());
        Bundle r122 = getArguments();
        boolean r123 = false;
        if (r122 == null) goto L43;
        boolean r124 = r122.getBoolean("has_report_finish_event");
    L44:
        r104.setHasReportFinishEvent(r124);
        Bundle r125 = getArguments();
        if (r125 == null) goto L48;
        String r126 = r125.getString("enter_from", "");
        if (r126 == null) goto L48;
    L49:
        r104.setEnterFrom(r126);
        Bundle r127 = getArguments();
        if (r127 == null) goto L55;
        String r128 = r127.getString(DocumentType.SHEET_NAME);
        if (r128 == null) goto L55;
        r106 = r128;
    L55:
        r104.setSheet(r106);
        r104.setObjType(Boxing.boxInt(3));
        Bundle r129 = getArguments();
        if (r129 != null) goto L58;
    L60:
        boolean r130 = false;
    L61:
        r104.setDocPreloaded(r130);
        Bundle r131 = getArguments();
        if (r131 == null) goto L64;
        r103 = r131.getString("key_source_url_for_params");
    L64:
        r104.setSourceUrlForParams(r103);
        Bundle r132 = getArguments();
        if (r132 != null) goto L67;
    L69:
        r104.setOpenChatWithNewLocalConv(r123);
        Unit r133 = Unit.INSTANCE;
        Object r134 = r102.T(r104, this.I, null, null, r101);
        if (r134 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L73;
        return r134;
    L73:
        return (Fragment) r134;
    L67:
        if (r132.getBoolean("open_chat_with_new_local_conv", false) != true) goto L69;
        r123 = true;
        goto L69
    L58:
        if (r129.getBoolean("key_office_preloaded", false) != true) goto L60;
        r130 = true;
    L48:
        r126 = "";
        goto L49
    L43:
        r124 = false;
        goto L44
    L39:
        r121 = System.currentTimeMillis();
        goto L40
    L35:
        r119 = null;
    L31:
        r117 = "";
    L26:
        r115 = "";
    L21:
        r113 = "";
    L13:
        r109 = "";
    L8:
        r107 = "";
        goto L9
    L74:
        return null;
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final ViewBinding Z90(LayoutInflater r210, ViewGroup r211) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_layout_sheet_detail_fragment, r211, false);
        int r101 = R.id.chat_input_bg_mask;
        View r102 = ViewBindings.findChildViewById(r100, R.id.chat_input_bg_mask);
        if (r102 == null) goto L43;
        r101 = R.id.doc_fragment_container;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.doc_fragment_container);
        if (r103 == null) goto L43;
        r101 = R.id.full_screen_view;
        View r104 = ViewBindings.findChildViewById(r100, R.id.full_screen_view);
        if (r104 == null) goto L43;
        r101 = R.id.header_view;
        CotHeaderView r105 = (CotHeaderView) ViewBindings.findChildViewById(r100, R.id.header_view);
        if (r105 == null) goto L43;
        r101 = R.id.sheet_chat_input_container;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.sheet_chat_input_container);
        if (r106 == null) goto L43;
        r101 = R.id.sheet_loading_view;
        SheetLoadLayout r107 = (SheetLoadLayout) ViewBindings.findChildViewById(r100, R.id.sheet_loading_view);
        if (r107 == null) goto L43;
        r101 = R.id.sheet_no_permission_fragment_container;
        FrameLayout r110 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.sheet_no_permission_fragment_container);
        if (r110 == null) goto L43;
        r101 = R.id.sheet_title_view;
        LinearLayout r111 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.sheet_title_view);
        if (r111 == null) goto L43;
        r101 = R.id.sheet_titlebar;
        ConstraintLayout r112 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar);
        if (r112 == null) goto L43;
        r101 = R.id.sheet_titlebar_back;
        ImageView r113 = (ImageView) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_back);
        if (r113 == null) goto L43;
        r101 = R.id.sheet_titlebar_complete;
        if (((ImageView) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_complete)) == null) goto L43;
        r101 = R.id.sheet_titlebar_container;
        FrameLayout r114 = (FrameLayout) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_container);
        if (r114 == null) goto L43;
        r101 = R.id.sheet_titlebar_history;
        NovaTitleBarEx r115 = (NovaTitleBarEx) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_history);
        if (r115 == null) goto L43;
        r101 = R.id.sheet_titlebar_more;
        ImageView r116 = (ImageView) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_more);
        if (r116 == null) goto L43;
        r101 = R.id.sheet_titlebar_redo;
        ImageView r117 = (ImageView) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_redo);
        if (r117 == null) goto L43;
        r101 = R.id.sheet_titlebar_search;
        ImageView r118 = (ImageView) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_search);
        if (r118 == null) goto L43;
        r101 = R.id.sheet_titlebar_subtitle;
        TextView r119 = (TextView) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_subtitle);
        if (r119 == null) goto L43;
        r101 = R.id.sheet_titlebar_title;
        TextView r212 = (TextView) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_title);
        if (r212 == null) goto L43;
        r101 = R.id.sheet_titlebar_undo;
        ImageView r213 = (ImageView) ViewBindings.findChildViewById(r100, R.id.sheet_titlebar_undo);
        if (r213 == null) goto L43;
        return new LarusLayoutSheetDetailFragmentBinding((ConstraintLayout) r100, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public final void fa0(String r100, String r101) {
        if (o0.d(r100) == false) goto L32;
        if (r101 != null) goto L44;
        r101 = "";
    L44:
    L30:
        e = move-exception;
        FLogger.f375446a.e("SheetFragment", "Parse selection data error: " + e.getMessage());
        Unit r102 = Unit.INSTANCE;
    L39:
        Lazy r103 = com.larus.office.base.service.m.f361113a;
        ym9.c r104 = com.larus.office.base.service.m.a(ja0());
        if (r104 == null) goto L42;
        r104.onEditPanelHeightChanged(200);
    L42:
        oa0(this, "applySelectionChange");
        return;
    L7:
        if (o0.d(r101) == false) goto L15;
        Fragment r105 = this.f360440f;     // Catch: Exception -> L30
        if (r105 == null) goto L22;
        t1a.b r106 = s1a.a.g(r105);     // Catch: Exception -> L30
        if (r106 == null) goto L22;
        com.larus.bmhome.chat.component.bottom.reference.a r107 = (com.larus.bmhome.chat.component.bottom.reference.a) r106.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);     // Catch: Exception -> L30
        if (r107 == null) goto L22;
        r107.Dk(r101);     // Catch: Exception -> L30
    L22:
        Fragment r108 = this.f360440f;     // Catch: Exception -> L30
        if (r108 == null) goto L39;
        t1a.b r109 = s1a.a.g(r108);     // Catch: Exception -> L30
        if (r109 == null) goto L39;
        n0 r110 = (n0) r109.getAbility(n0.class);     // Catch: Exception -> L30
        if (r110 == null) goto L39;
        r110.a6(r100);     // Catch: Exception -> L30
        Unit r111 = Unit.INSTANCE;     // Catch: Exception -> L30
        goto L39
    L15:
        Fragment r112 = this.f360440f;     // Catch: Exception -> L30
        if (r112 == null) goto L22;
        t1a.b r113 = s1a.a.g(r112);     // Catch: Exception -> L30
        if (r113 == null) goto L22;
        com.larus.bmhome.chat.component.bottom.reference.a r114 = (com.larus.bmhome.chat.component.bottom.reference.a) r113.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);     // Catch: Exception -> L30
        if (r114 == null) goto L22;
        r114.NR();     // Catch: Exception -> L30
        goto L22
    L32:
        Fragment r115 = this.f360440f;
        if (r115 == null) goto L39;
        t1a.b r116 = s1a.a.g(r115);
        if (r116 == null) goto L39;
        com.larus.bmhome.chat.component.bottom.reference.a r117 = (com.larus.bmhome.chat.component.bottom.reference.a) r116.getAbility(com.larus.bmhome.chat.component.bottom.reference.a.class);
        if (r117 == null) goto L39;
        r117.NR();
        goto L39
    }

    @Override // com.larus.office.base.OfficeBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Bundle r102 = getArguments();
        String r103 = "";
        if (r102 == null) goto L5;
        r102.getString("cot_ref_artifacts", "");
    L5:
        Bundle r104 = getArguments();
        if (r104 == null) goto L11;
        String r105 = r104.getString("artifact_meta_id", "");
        if (r105 == null) goto L11;
        r103 = r105;
    L11:
        this.B = r103;
        LarusLayoutSheetDetailFragmentBinding r106 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r106 == null) goto L16;
        CotHeaderView r107 = r106.f368943e;
        if (r107 == null) goto L16;
        e1.d(r107, new d(this));
    L16:
        ea0();
        LarusLayoutSheetDetailFragmentBinding r108 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r108 == null) goto L21;
        CotHeaderView r109 = r108.f368943e;
        if (r109 == null) goto L21;
        r109.addOnLayoutChangeListener(this.M);
    L21:
        LarusLayoutSheetDetailFragmentBinding r110 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r110 == null) goto L26;
        FrameLayout r111 = r110.f368944f;
        if (r111 == null) goto L26;
        r111.addOnLayoutChangeListener(this.M);
    L26:
        LarusLayoutSheetDetailFragmentBinding r112 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        ConstraintLayout.LayoutParams r113 = null;
        if (r112 == null) goto L31;
        FrameLayout r114 = r112.f368950l;
        if (r114 == null) goto L31;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
    L33:
        if ((r115 instanceof ConstraintLayout.LayoutParams) == false) goto L35;
        r113 = (ConstraintLayout.LayoutParams) r115;
    L35:
        if (r113 == null) goto L37;
        ((ViewGroup.MarginLayoutParams) r113).height = 0;
    L37:
        if (r113 == null) goto L39;
        r113.matchConstraintDefaultHeight = 2;
    L39:
        if (r113 == null) goto L41;
        r113.matchConstraintPercentHeight = 0.0f;
    L41:
        LarusLayoutSheetDetailFragmentBinding r116 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r116 == null) goto L46;
        FrameLayout r117 = r116.f368950l;
        if (r117 == null) goto L46;
        r117.setLayoutParams(r113);
    L46:
        LarusLayoutSheetDetailFragmentBinding r118 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r118 == null) goto L52;
        FrameLayout r119 = r118.f368950l;
        if (r119 == null) goto L53;
        r119.requestLayout();
        return;
    L53:
        return;
    L52:
        return;
    L31:
        r115 = null;
        goto L33
    }

    public final void ra0(boolean r100, String r101) {
        boolean r102 = false;
        boolean r103 = true;
        if (this.A == false) goto L8;
        if (r100 == true) goto L6;
    L14:
        boolean r104 = false;
    L15:
        LarusLayoutSheetDetailFragmentBinding r105 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r105 == null) goto L25;
        FrameLayout r106 = r105.f368944f;
        if (r106 == null) goto L25;
        if (r106.getVisibility() != 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 != true) goto L25;
        r102 = true;
        goto L25
    L22:
        r107 = false;
    L25:
        if (r104 == false) goto L31;
        LarusLayoutSheetDetailFragmentBinding r108 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r108 == null) goto L37;
        FrameLayout r109 = r108.f368944f;
        if (r109 == null) goto L37;
        e1.x(r109);
    L37:
        if (r102 == r104) goto L45;
        Lazy r110 = com.larus.office.base.service.m.f361113a;
        ym9.c r111 = com.larus.office.base.service.m.a(ja0());
        if (r111 == null) goto L41;
        r111.onEditPanelActive(r104);
    L41:
        ym9.c r112 = com.larus.office.base.service.m.a(ja0());
        if (r112 == null) goto L44;
        r112.onEditPanelHeightChanged(200);
    L44:
        oa0(this, "updateEditPanelHeight");
        FLogger.f375446a.i("SheetFragment", "updateEditPanelHeight, isActive:" + r104);
    L45:
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("updateChatInputVisibility, isPad:");
        r114.append(this.A);
        r114.append(", isLandscapeMode:");
        r114.append(this.f368985z);
        r114.append(", isVisible:");
        r114.append(r100);
        r114.append(", from:");
        r114.append(r101);
        r114.append(", isOwner:");
        Bundle r115 = getArguments();
        if (r115 != null) goto L49;
    L51:
        r114.append(r103);
        r114.append(", isHistoryVersion:");
        r114.append(na0());
        r113.d("SheetFragment", r114.toString());
        return;
    L49:
        if (r115.containsKey("is_sheet_owner") == false) goto L51;
        r103 = r115.getBoolean("is_sheet_owner");
        goto L51
    L31:
        LarusLayoutSheetDetailFragmentBinding r116 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r116 == null) goto L37;
        FrameLayout r117 = r116.f368944f;
        if (r117 == null) goto L37;
        e1.o(r117);
        goto L37
    L6:
        if (na0() == true) goto L14;
    L13:
        r104 = true;
        goto L15
    L8:
        if (r100 == false) goto L14;
        if (na0() == true) goto L14;
        if (this.f368985z == true) goto L14;
        goto L13
    }

    public final void sa0(int r100, String r101) {
        LarusLayoutSheetDetailFragmentBinding r102 = (LarusLayoutSheetDetailFragmentBinding) this.f360439e;
        if (r102 == null) goto L21;
        CotHeaderView r103 = r102.f368943e;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.getVisibility() != r100) goto L10;
        return;
    L10:
        if (r100 != 0) goto L12;
        e1.x(r103);
    L19:
        oa0(this, "headerView:".concat(r101));
        return;
    L12:
        if (r100 != 4) goto L14;
        e1.q(r103);
        goto L19
    L14:
        if (r100 == 8) goto L16;
        r103.setVisibility(r100);
        goto L19
    L16:
        e1.o(r103);
        goto L19
    }

    @Override // com.larus.office.base.OfficeBaseFragment
    public final void F8(String r110, String r111, String r112, String r113) {
        String r100 = "";
        if (r111 != null) goto L5;
        r111 = "";
    L5:
        this.f368970k = r111;
        if (r110 != null) goto L8;
        String r114 = "";
    L9:
        this.B = r114;
        if (r112 == null) goto L13;
        r100 = r112;
    L13:
        this.f368971l = r100;
        this.D.complete(r113);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new SheetFragment$updateArtifactInfo$1(this, r112, r110, r113, null), 2, null);
        pa0();
        return;
    L8:
        r114 = r110;
        goto L9
    }
}
