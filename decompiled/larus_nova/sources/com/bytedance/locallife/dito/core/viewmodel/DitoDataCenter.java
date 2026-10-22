package com.bytedance.locallife.dito.core.viewmodel;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.locallife.dito.common.lynx.DitoLynxNativeModule;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.DitoFragment;
import com.bytedance.locallife.dito.core.c0;
import com.bytedance.locallife.dito.core.manager.DitoUpdateData;
import com.bytedance.locallife.dito.data.DitoActionModel;
import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.locallife.dito.data.DitoPageInfo;
import com.bytedance.locallife.dito.data.LayoutTypology;
import com.bytedance.locallife.dito.event.BusMutableLiveData;
import com.bytedance.locallife.dito.event.DitoDataObserver;
import com.bytedance.locallife.dito.event.DitoLiveData;
import com.bytedance.locallife.dito.event.DitoMutableLiveData;
import com.bytedance.locallife.dito.event.ThreadLiveData;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.qqmusic.third.api.contract.Keys;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000Ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0010\u0091\u0002\u0092\u0002^¤\u0001\u0096\u0001¨\u0001p<>L7B\t¢\u0006\u0006\b\u0090\u0002\u0010ã\u0001R)\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR+\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\bR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\bR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\bR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\bR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\bR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\bR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00028\u0006¢\u0006\f\n\u0004\b$\u0010\u0006\u001a\u0004\b%\u0010\bR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\bR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b(\u0010\u0006\u001a\u0004\b)\u0010\bR\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010\bR\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006¢\u0006\f\n\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\bR\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\u00028\u0006¢\u0006\f\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\bR\u001f\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\u00028\u0006¢\u0006\f\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u0010\bR\u001d\u00105\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001d\u00109\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\b9\u00106\u001a\u0004\b:\u00108R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u00108R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\b=\u00106\u001a\u0004\b>\u00108R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u00108R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\bA\u00106\u001a\u0004\bB\u00108R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\bC\u00106\u001a\u0004\bD\u00108R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\bE\u00106\u001a\u0004\bF\u00108R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\bG\u00106\u001a\u0004\bH\u00108R\u001d\u0010I\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\bI\u00106\u001a\u0004\bJ\u00108R\u001d\u0010K\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\bK\u00106\u001a\u0004\bL\u00108R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\bM\u00106\u001a\u0004\bN\u00108R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\bO\u00106\u001a\u0004\bP\u00108R!\u0010S\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030R0Q8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR!\u0010W\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030R038\u0006¢\u0006\f\n\u0004\bW\u00106\u001a\u0004\bX\u00108R\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0\u00028\u0006¢\u0006\f\n\u0004\bZ\u0010\u0006\u001a\u0004\b[\u0010\bR\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0\u00028\u0006¢\u0006\f\n\u0004\b]\u0010\u0006\u001a\u0004\b^\u0010\bR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020_0Q8\u0006¢\u0006\f\n\u0004\b`\u0010T\u001a\u0004\ba\u0010VR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020b0Q8\u0006¢\u0006\f\n\u0004\bc\u0010T\u001a\u0004\bd\u0010VR\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020e038\u0006¢\u0006\f\n\u0004\bf\u00106\u001a\u0004\bg\u00108R\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\f\n\u0004\bh\u00106\u001a\u0004\bi\u00108R)\u0010j\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003038\u0006¢\u0006\f\n\u0004\bj\u00106\u001a\u0004\bk\u00108R\u001d\u0010l\u001a\b\u0012\u0004\u0012\u00020#038\u0006¢\u0006\f\n\u0004\bl\u00106\u001a\u0004\bm\u00108R\u001d\u0010o\u001a\b\u0012\u0004\u0012\u00020n038\u0006¢\u0006\f\n\u0004\bo\u00106\u001a\u0004\bp\u00108R\u001d\u0010r\u001a\b\u0012\u0004\u0012\u00020q038\u0006¢\u0006\f\n\u0004\br\u00106\u001a\u0004\bs\u00108R\u001d\u0010t\u001a\b\u0012\u0004\u0012\u00020#038\u0006¢\u0006\f\n\u0004\bt\u00106\u001a\u0004\bu\u00108R\u001d\u0010w\u001a\b\u0012\u0004\u0012\u00020v038\u0006¢\u0006\f\n\u0004\bw\u00106\u001a\u0004\bx\u00108R*\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010y038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u00106\u001a\u0004\b{\u00108\"\u0004\b|\u0010}R*\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020~038\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u007f\u00106\u001a\u0005\b\u0080\u0001\u00108\"\u0005\b\u0081\u0001\u0010}R#\u0010\u0083\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u0001038\u0006¢\u0006\u000e\n\u0005\b\u0083\u0001\u00106\u001a\u0005\b\u0084\u0001\u00108R-\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u00106\u001a\u0005\b\u0087\u0001\u00108\"\u0005\b\u0088\u0001\u0010}R-\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u00106\u001a\u0005\b\u008b\u0001\u00108\"\u0005\b\u008c\u0001\u0010}R-\u0010\u008e\u0001\u001a\t\u0012\u0005\u0012\u00030\u008d\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008e\u0001\u00106\u001a\u0005\b\u008f\u0001\u00108\"\u0005\b\u0090\u0001\u0010}R!\u0010\u0092\u0001\u001a\t\u0012\u0005\u0012\u00030\u0091\u0001038\u0006¢\u0006\u000e\n\u0005\b\u0092\u0001\u00106\u001a\u0005\b\u0093\u0001\u00108R-\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0094\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0095\u0001\u00106\u001a\u0005\b\u0096\u0001\u00108\"\u0005\b\u0097\u0001\u0010}R2\u0010\u0098\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010R038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0001\u00106\u001a\u0005\b\u0099\u0001\u00108\"\u0005\b\u009a\u0001\u0010}R&\u0010\u009b\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010R038\u0006¢\u0006\u000e\n\u0005\b\u009b\u0001\u00106\u001a\u0005\b\u009c\u0001\u00108R!\u0010\u009e\u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u0001038\u0006¢\u0006\u000e\n\u0005\b\u009e\u0001\u00106\u001a\u0005\b\u009f\u0001\u00108R!\u0010 \u0001\u001a\t\u0012\u0005\u0012\u00030\u009d\u0001038\u0006¢\u0006\u000e\n\u0005\b \u0001\u00106\u001a\u0005\b¡\u0001\u00108R!\u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u0001038\u0006¢\u0006\u000e\n\u0005\b£\u0001\u00106\u001a\u0005\b¤\u0001\u00108R \u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\u000e\n\u0005\b¥\u0001\u00106\u001a\u0005\b¦\u0001\u00108R,\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020#038\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b§\u0001\u00106\u001a\u0005\b¨\u0001\u00108\"\u0005\b©\u0001\u0010}R!\u0010«\u0001\u001a\t\u0012\u0005\u0012\u00030ª\u00010\u00028\u0006¢\u0006\u000e\n\u0005\b«\u0001\u0010\u0006\u001a\u0005\b¬\u0001\u0010\bR!\u0010®\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010\u00028\u0006¢\u0006\u000e\n\u0005\b®\u0001\u0010\u0006\u001a\u0005\b¯\u0001\u0010\bR-\u0010±\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030R\u0018\u00010°\u00010\u00028\u0006¢\u0006\u000e\n\u0005\b±\u0001\u0010\u0006\u001a\u0005\b²\u0001\u0010\bR-\u0010³\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030R\u0018\u00010°\u00010\u00028\u0006¢\u0006\u000e\n\u0005\b³\u0001\u0010\u0006\u001a\u0005\b´\u0001\u0010\bR-\u0010µ\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030R\u0018\u00010°\u00010\u00028\u0006¢\u0006\u000e\n\u0005\bµ\u0001\u0010\u0006\u001a\u0005\b¶\u0001\u0010\bR-\u0010·\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030R\u0018\u00010°\u00010\u00028\u0006¢\u0006\u000e\n\u0005\b·\u0001\u0010\u0006\u001a\u0005\b¸\u0001\u0010\bRC\u0010»\u0001\u001a+\u0012'\u0012%\u0012\u0011\u0012\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030R\u0018\u00010°\u0001\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030º\u0001\u0018\u00010¹\u00010\u00030\u00028\u0006¢\u0006\u000e\n\u0005\b»\u0001\u0010\u0006\u001a\u0005\b¼\u0001\u0010\bR+\u0010½\u0001\u001a\u0013\u0012\u000f\u0012\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030R0¹\u0001038\u0006¢\u0006\u000e\n\u0005\b½\u0001\u00106\u001a\u0005\b¾\u0001\u00108R!\u0010À\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010\u00028\u0006¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\u0006\u001a\u0005\bÁ\u0001\u0010\bR!\u0010Â\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010\u00028\u0006¢\u0006\u000e\n\u0005\bÂ\u0001\u0010\u0006\u001a\u0005\bÃ\u0001\u0010\bR!\u0010Ä\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010\u00028\u0006¢\u0006\u000e\n\u0005\bÄ\u0001\u0010\u0006\u001a\u0005\bÅ\u0001\u0010\bR!\u0010Æ\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010\u00028\u0006¢\u0006\u000e\n\u0005\bÆ\u0001\u0010\u0006\u001a\u0005\bÇ\u0001\u0010\bR!\u0010È\u0001\u001a\t\u0012\u0005\u0012\u00030¿\u00010\u00028\u0006¢\u0006\u000e\n\u0005\bÈ\u0001\u0010\u0006\u001a\u0005\bÉ\u0001\u0010\bR \u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\u000e\n\u0005\bÊ\u0001\u0010\u0006\u001a\u0005\bË\u0001\u0010\bR1\u0010Ï\u0001\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0007\u0012\u0005\u0018\u00010Í\u0001\u0012\u0005\u0012\u00030Î\u00010Ì\u0001038\u0006¢\u0006\u000e\n\u0005\bÏ\u0001\u00106\u001a\u0005\bÐ\u0001\u00108R<\u0010Ó\u0001\u001a$\u0012 \u0012\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030Ò\u00010Ñ\u0001\u0012\u0005\u0012\u00030Î\u00010Ì\u00010\u00028\u0006¢\u0006\u000e\n\u0005\bÓ\u0001\u0010\u0006\u001a\u0005\bÔ\u0001\u0010\bR6\u0010Ö\u0001\u001a\u001e\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0012\u0005\u0012\u00030Õ\u00010¹\u0001\u0012\u0005\u0012\u00030Î\u00010Ì\u0001038\u0006¢\u0006\u000e\n\u0005\bÖ\u0001\u00106\u001a\u0005\b×\u0001\u00108R \u0010Ø\u0001\u001a\b\u0012\u0004\u0012\u00020e038\u0006¢\u0006\u000e\n\u0005\bØ\u0001\u00106\u001a\u0005\bÙ\u0001\u00108R \u0010Ú\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\u000e\n\u0005\bÚ\u0001\u00106\u001a\u0005\bÛ\u0001\u00108R \u0010Ü\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\u000e\n\u0005\bÜ\u0001\u00106\u001a\u0005\bÝ\u0001\u00108R \u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\u000e\n\u0005\bÞ\u0001\u00106\u001a\u0005\bß\u0001\u00108R+\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\bà\u0001\u00106\u0012\u0006\bâ\u0001\u0010ã\u0001\u001a\u0005\bá\u0001\u00108R \u0010ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\u000e\n\u0005\bä\u0001\u00106\u001a\u0005\bå\u0001\u00108R \u0010æ\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\u000e\n\u0005\bæ\u0001\u00106\u001a\u0005\bç\u0001\u00108R \u0010è\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\u000e\n\u0005\bè\u0001\u00106\u001a\u0005\bé\u0001\u00108R \u0010ê\u0001\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006¢\u0006\u000e\n\u0005\bê\u0001\u00106\u001a\u0005\bë\u0001\u00108R \u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020\t038\u0006¢\u0006\u000e\n\u0005\bì\u0001\u00106\u001a\u0005\bí\u0001\u00108R.\u0010ð\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0005\u0012\u00030ï\u00010î\u0001038\u0006¢\u0006\u000e\n\u0005\bð\u0001\u00106\u001a\u0005\bñ\u0001\u00108R-\u0010ò\u0001\u001a\b\u0012\u0004\u0012\u00020Y0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bò\u0001\u0010\u0006\u001a\u0005\bó\u0001\u0010\b\"\u0006\bô\u0001\u0010õ\u0001R!\u0010÷\u0001\u001a\t\u0012\u0005\u0012\u00030ö\u00010\u00028\u0006¢\u0006\u000e\n\u0005\b÷\u0001\u0010\u0006\u001a\u0005\bø\u0001\u0010\bR!\u0010ù\u0001\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\bù\u0001\u0010T\u001a\u0005\bú\u0001\u0010VR!\u0010û\u0001\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\bû\u0001\u0010T\u001a\u0005\bü\u0001\u0010VR!\u0010þ\u0001\u001a\t\u0012\u0005\u0012\u00030ý\u00010Q8\u0006¢\u0006\u000e\n\u0005\bþ\u0001\u0010T\u001a\u0005\bÿ\u0001\u0010VR!\u0010\u0080\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\b\u0080\u0002\u0010T\u001a\u0005\b\u0081\u0002\u0010VR!\u0010\u0082\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\b\u0082\u0002\u0010T\u001a\u0005\b\u0083\u0002\u0010VR!\u0010\u0084\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\b\u0084\u0002\u0010T\u001a\u0005\b\u0085\u0002\u0010VR!\u0010\u0086\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\b\u0086\u0002\u0010T\u001a\u0005\b\u0087\u0002\u0010VR!\u0010\u0088\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\b\u0088\u0002\u0010T\u001a\u0005\b\u0089\u0002\u0010VR!\u0010\u008a\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\b\u008a\u0002\u0010T\u001a\u0005\b\u008b\u0002\u0010VR!\u0010\u008c\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\b\u008c\u0002\u0010T\u001a\u0005\b\u008d\u0002\u0010VR!\u0010\u008e\u0002\u001a\t\u0012\u0005\u0012\u00030ö\u00010Q8\u0006¢\u0006\u000e\n\u0005\b\u008e\u0002\u0010T\u001a\u0005\b\u008f\u0002\u0010V¨\u0006\u0093\u0002"}, d2 = {"Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter;", "Lcom/bytedance/locallife/dito/core/c0;", "Lcom/bytedance/locallife/dito/event/DitoMutableLiveData;", "Lkotlin/Pair;", "", "pageStatusLiveData", "Lcom/bytedance/locallife/dito/event/DitoMutableLiveData;", "t0", "()Lcom/bytedance/locallife/dito/event/DitoMutableLiveData;", "", "updateStatusView", "U0", "Lcom/bytedance/locallife/dito/data/LayoutTypology;", "layoutTypology", "X", "Lcom/bytedance/locallife/dito/data/t;", "onAttach", "e0", WidgetCostModule.TYPE_ON_CREATE, "f0", "onCreateView", "g0", "onViewCreate", "q0", "onActivityCreate", "c0", WidgetCostModule.TYPE_ON_START, "o0", "onResume", "n0", "Lcom/bytedance/locallife/dito/data/p;", "onFmp", "k0", "onPause", Keys.API_PARAM_KEY_M0, "", "onAppEnterBackground", "d0", "onStop", "p0", "onDestroyView", "i0", LiveCommonConstants.REASON_ON_DEDTROY, "h0", "onDetach", "j0", "onHiddenChanged", "l0", "Lcom/bytedance/locallife/dito/data/DitoPageInfo;", "pageInfoCreate", "s0", "Lcom/bytedance/locallife/dito/event/BusMutableLiveData;", "Lcom/bytedance/locallife/dito/data/b;", "componentCreate", "Lcom/bytedance/locallife/dito/event/BusMutableLiveData;", ce.f26396k, "()Lcom/bytedance/locallife/dito/event/BusMutableLiveData;", "componentPreload", "o", "componentBindData", "h", "componentBindFinish", RXScreenCaptureService.KEY_INDEX, "componentResume", "p", "componentFcp", "m", "componentPause", OfficeSDKRequestTag.KEY_NEW_USER, "componentUnBindData", "t", "componentDestroy", "l", "componentShow", "q", "componentCompleteShow", ce.f26395j, "componentStatusCompleteShow", "s", "componentSizeChange", "r", "Lcom/bytedance/locallife/dito/event/ThreadLiveData;", "Lcom/bytedance/locallife/dito/model/BaseDitoModel;", "modelCreate", "Lcom/bytedance/locallife/dito/event/ThreadLiveData;", "b0", "()Lcom/bytedance/locallife/dito/event/ThreadLiveData;", "modelDestroy", "getModelDestroy", "", "pageErrorLiveData", "getPageErrorLiveData", "Lcom/bytedance/locallife/dito/core/viewmodel/a;", "actionCallback", "c", "Lcom/bytedance/locallife/dito/data/l;", "ditoRequestProcess", FaceService.neutralLabel, "Lsq6/b;", "ditoExceptionLiveData", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "Lcom/bytedance/locallife/dito/data/u;", "listScroll", "Y", "listScrollState", "Z", "updateRecyclePoolSize", "T0", "slideToBottom", "z0", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$b;", "cacheGroup", ce.f26391f, "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$d;", "getCacheGroup", "M", "request", "w0", "Lcom/bytedance/locallife/dito/data/k;", "requestParams", "x0", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$k;", "updateStickView", "V0", "setUpdateStickView", "(Lcom/bytedance/locallife/dito/event/BusMutableLiveData;)V", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$e;", "hasStick", "V", "setHasStick", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$g;", "stickState", "C0", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$f;", "scrollSubStickView", "y0", "setScrollSubStickView", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$j;", "subStickViewHeightChanged", "E0", "setSubStickViewHeightChanged", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$i;", "subStickState", "D0", "setSubStickState", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$h;", "updateStickViewWrapperBackground", "W0", "Lcom/bytedance/locallife/dito/core/viewmodel/DitoDataCenter$a;", "appendModel", "e", "setAppendModel", "removeModel", "v0", "setRemoveModel", "updateModel", "S0", "Lcom/bytedance/locallife/dito/core/viewmodel/z;", "topModel", "F0", "smoothTopModel", "B0", "Lcom/bytedance/locallife/dito/data/a;", "anchorPageTopModel", "d", "smoothScrollState", "A0", "backClickLiveData", "f", "setBackClickLiveData", "Lcom/bytedance/locallife/dito/data/j;", "ditoRequestLiveData", "G", "Lcom/bytedance/locallife/dito/data/n;", "ditoTreeNodeWakeUpLiveData", "I", "", "updateHeaderContainer", "Q0", "updateFloatContainer", "M0", "updateBackgroundContainer", "G0", "updateFooterContainer", "O0", "", "Lcom/bytedance/locallife/dito/core/manager/DitoUpdateData;", "updateBodyContainer", "I0", "updateBodyData", "K0", "Leq6/b;", "updateHeaderContainerNew", "R0", "updateBodyContainerNew", "J0", "updateFooterContainerNew", DiagnoseResult.DIAGNOSE_LEVEL_P0, "updateFloatContainerNew", "N0", "updateBackgroundContainerNew", "H0", "headContainerHeightChanged", ExifInterface.LONGITUDE_WEST, "Lkotlin/Function1;", "Lcom/bytedance/locallife/dito/core/DitoFragment;", "", "getFragment", "getGetFragment", "", "Landroid/view/View;", "getContainerMap", "N", "Landroid/view/ViewGroup;", "getRecycleVisibleList", "O", "ditoContainerScrollDistance", BaseSwitches.V, "halfContainerCollapsedOffset", "P", "halfContainerHalfExpandedOffset", "Q", "halfContainerScrollState", ExifInterface.LATITUDE_SOUTH, "halfContainerRvTop", "R", "getHalfContainerRvTop$annotations", "()V", "halfContainerStartClose", ExifInterface.GPS_DIRECTION_TRUE, "halfContainerStartShow", "U", "fullPageUnfold", "L", "fullPageScrollBack", "K", "updateCustomCardVisibility", "L0", "", "Lcom/bytedance/locallife/dito/data/DitoActionModel;", "pageStatusViewActions", "u0", "highlight", "getHighlight", "setHighlight", "(Lcom/bytedance/locallife/dito/event/DitoMutableLiveData;)V", "Lcom/bytedance/locallife/dito/data/v;", "wakeUpViewStubAfterFmp", "X0", "createDitoComponentModel", "u", "ditoParamsInit", "C", "Lcom/bytedance/locallife/dito/core/y;", "ditoParamsBuild", "B", "ditoLayoutInflate", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "ditoViewInit", "J", "ditoDataRefresh", "x", "ditoDataUpdate", "y", "ditoDataParse", "w", "ditoParseBuildNodeTree", "D", "ditoParseMergeNodeTree", FaceService.girlLabel, "ditoParseCreateModel", ExifInterface.LONGITUDE_EAST, "<init>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoDataCenter implements c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f258004d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f258005a;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.core.viewmodel.a> actionCallback;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.a> anchorPageTopModel;
    private BusMutableLiveData<a> appendModel;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, MutableLiveData<JSONObject>> f258006b;
    private BusMutableLiveData<Boolean> backClickLiveData;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, MutableLiveData<Object>> f258007c;
    private final BusMutableLiveData<b> cacheGroup;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentBindData;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentBindFinish;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentCompleteShow;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentCreate;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentDestroy;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentFcp;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentPause;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentPreload;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentResume;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentShow;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentSizeChange;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentStatusCompleteShow;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.b> componentUnBindData;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> createDitoComponentModel;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.u> ditoContainerScrollDistance;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoDataParse;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoDataRefresh;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoDataUpdate;
    private final ThreadLiveData<sq6.b> ditoExceptionLiveData;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoLayoutInflate;
    private final ThreadLiveData<com.bytedance.locallife.dito.core.y> ditoParamsBuild;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoParamsInit;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoParseBuildNodeTree;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoParseCreateModel;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoParseMergeNodeTree;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.j> ditoRequestLiveData;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.l> ditoRequestProcess;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.n> ditoTreeNodeWakeUpLiveData;
    private final ThreadLiveData<com.bytedance.locallife.dito.data.v> ditoViewInit;
    private final BusMutableLiveData<Integer> fullPageScrollBack;
    private final BusMutableLiveData<Integer> fullPageUnfold;
    private final BusMutableLiveData<d> getCacheGroup;
    private final DitoMutableLiveData<Function1<Map<String, ? extends View>, Unit>> getContainerMap;
    private final BusMutableLiveData<Function1<DitoFragment, Unit>> getFragment;
    private final BusMutableLiveData<Function1<List<? extends ViewGroup>, Unit>> getRecycleVisibleList;
    private final BusMutableLiveData<Integer> halfContainerCollapsedOffset;
    private final BusMutableLiveData<Integer> halfContainerHalfExpandedOffset;
    private final BusMutableLiveData<Integer> halfContainerRvTop;
    private final BusMutableLiveData<Integer> halfContainerScrollState;
    private final BusMutableLiveData<Integer> halfContainerStartClose;
    private final BusMutableLiveData<Integer> halfContainerStartShow;
    private BusMutableLiveData<e> hasStick;
    private final DitoMutableLiveData<Integer> headContainerHeightChanged;
    private DitoMutableLiveData<Object> highlight;
    private final DitoMutableLiveData<LayoutTypology> layoutTypology;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.u> listScroll;
    private final BusMutableLiveData<Integer> listScrollState;
    private final ThreadLiveData<BaseDitoModel<?>> modelCreate;
    private final BusMutableLiveData<BaseDitoModel<?>> modelDestroy;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onActivityCreate;
    private final DitoMutableLiveData<Boolean> onAppEnterBackground;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onAttach;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onCreate;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onCreateView;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onDestroy;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onDestroyView;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onDetach;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.p> onFmp;
    private final DitoMutableLiveData<Boolean> onHiddenChanged;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onPause;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onResume;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onStart;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onStop;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> onViewCreate;
    private final DitoMutableLiveData<Object> pageErrorLiveData;
    private final DitoMutableLiveData<DitoPageInfo> pageInfoCreate;
    private final DitoMutableLiveData<Pair<Integer, Integer>> pageStatusLiveData;
    private final BusMutableLiveData<Map<String, DitoActionModel>> pageStatusViewActions;
    private BusMutableLiveData<BaseDitoModel<?>> removeModel;
    private final BusMutableLiveData<Boolean> request;
    private final BusMutableLiveData<com.bytedance.locallife.dito.data.k> requestParams;
    private BusMutableLiveData<f> scrollSubStickView;
    private final BusMutableLiveData<Boolean> slideToBottom;
    private final BusMutableLiveData<Integer> smoothScrollState;
    private final BusMutableLiveData<z> smoothTopModel;
    private final BusMutableLiveData<g> stickState;
    private BusMutableLiveData<i> subStickState;
    private BusMutableLiveData<j> subStickViewHeightChanged;
    private final BusMutableLiveData<z> topModel;
    private final DitoMutableLiveData<List<BaseDitoModel<?>>> updateBackgroundContainer;
    private final DitoMutableLiveData<eq6.b> updateBackgroundContainerNew;
    private final DitoMutableLiveData<Pair<List<BaseDitoModel<?>>, List<DitoUpdateData>>> updateBodyContainer;
    private final DitoMutableLiveData<eq6.b> updateBodyContainerNew;
    private final BusMutableLiveData<List<BaseDitoModel<?>>> updateBodyData;
    private final BusMutableLiveData<String> updateCustomCardVisibility;
    private final DitoMutableLiveData<List<BaseDitoModel<?>>> updateFloatContainer;
    private final DitoMutableLiveData<eq6.b> updateFloatContainerNew;
    private final DitoMutableLiveData<List<BaseDitoModel<?>>> updateFooterContainer;
    private final DitoMutableLiveData<eq6.b> updateFooterContainerNew;
    private final DitoMutableLiveData<List<BaseDitoModel<?>>> updateHeaderContainer;
    private final DitoMutableLiveData<eq6.b> updateHeaderContainerNew;
    private final BusMutableLiveData<BaseDitoModel<?>> updateModel;
    private final BusMutableLiveData<Pair<Integer, Integer>> updateRecyclePoolSize;
    private final DitoMutableLiveData<Pair<String, Integer>> updateStatusView;
    private BusMutableLiveData<k> updateStickView;
    private final BusMutableLiveData<h> updateStickViewWrapperBackground;
    private final DitoMutableLiveData<com.bytedance.locallife.dito.data.v> wakeUpViewStubAfterFmp;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f258008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f258009b;

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "cacheKey");
            Intrinsics.checkNotNullParameter(r101, "groupTag");
            this.f258008a = r100;
            this.f258009b = r101;
        }
    }

    public static final class c {
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f258010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<DitoPage, Unit> f258011b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(String r100, Function1<? super DitoPage, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "cacheKey");
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f258010a = r100;
            this.f258011b = r101;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f258012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f258013b;

        public e(String r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f258012a = r100;
            this.f258013b = r101;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f258014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BaseDitoView<?> f258015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f258016c;

        public f(View r100, BaseDitoView<?> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "stickViewWrapper");
            Intrinsics.checkNotNullParameter(r101, "baseDitoView");
            Intrinsics.checkNotNullParameter(r102, "viewTag");
            this.f258014a = r100;
            this.f258015b = r101;
            this.f258016c = r102;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f258017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f258018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f258019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f258020d;

        public g(View r100, ViewGroup r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "stickViewWrapper");
            Intrinsics.checkNotNullParameter(r103, "viewTag");
            this.f258017a = r100;
            this.f258018b = r101;
            this.f258019c = r102;
            this.f258020d = r103;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f258021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f258022b;

        public h(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "nodeTag");
            this.f258021a = r100;
            this.f258022b = r101;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f258023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f258024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f258025c;

        public i(View r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "stickViewWrapper");
            Intrinsics.checkNotNullParameter(r102, "viewTag");
            this.f258023a = r100;
            this.f258024b = r101;
            this.f258025c = r102;
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f258026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BaseDitoView<?> f258027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f258028c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f258029d;

        public j(View r100, BaseDitoView<?> r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "stickViewWrapper");
            Intrinsics.checkNotNullParameter(r101, "baseDitoView");
            Intrinsics.checkNotNullParameter(r102, "viewTag");
            this.f258026a = r100;
            this.f258027b = r101;
            this.f258028c = r102;
            this.f258029d = r103;
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f258030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ViewGroup f258031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f258032c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f258033d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final BaseDitoView<?> f258034e;

        public k(View r100, ViewGroup r101, String r102, boolean r103, BaseDitoView<?> r104) {
            Intrinsics.checkNotNullParameter(r102, "nodeTag");
            this.f258030a = r100;
            this.f258031b = r101;
            this.f258032c = r102;
            this.f258033d = r103;
            this.f258034e = r104;
        }
    }

    static {
    }

    public DitoDataCenter() {
        this.f258006b = new LinkedHashMap();
        this.f258007c = new LinkedHashMap();
        this.pageStatusLiveData = new DitoMutableLiveData(null, null);
        this.updateStatusView = new DitoMutableLiveData(null, null);
        this.layoutTypology = new DitoMutableLiveData(null, null);
        this.onAttach = new DitoMutableLiveData(null, null);
        this.onCreate = new DitoMutableLiveData(null, null);
        this.onCreateView = new DitoMutableLiveData(null, null);
        this.onViewCreate = new DitoMutableLiveData(null, null);
        this.onActivityCreate = new DitoMutableLiveData(null, null);
        this.onStart = new DitoMutableLiveData(null, null);
        this.onResume = new DitoMutableLiveData(null, null);
        this.onFmp = new DitoMutableLiveData(null, null);
        this.onPause = new DitoMutableLiveData(null, null);
        this.onAppEnterBackground = new DitoMutableLiveData(null, null);
        this.onStop = new DitoMutableLiveData(null, null);
        this.onDestroyView = new DitoMutableLiveData(null, null);
        this.onDestroy = new DitoMutableLiveData(null, null);
        this.onDetach = new DitoMutableLiveData(null, null);
        this.onHiddenChanged = new DitoMutableLiveData(null, null);
        this.pageInfoCreate = new DitoMutableLiveData(null, null);
        this.componentCreate = new BusMutableLiveData();
        this.componentPreload = new BusMutableLiveData();
        this.componentBindData = new BusMutableLiveData();
        this.componentBindFinish = new BusMutableLiveData();
        this.componentResume = new BusMutableLiveData();
        this.componentFcp = new BusMutableLiveData();
        this.componentPause = new BusMutableLiveData();
        this.componentUnBindData = new BusMutableLiveData();
        this.componentDestroy = new BusMutableLiveData();
        this.componentShow = new BusMutableLiveData();
        this.componentCompleteShow = new BusMutableLiveData();
        this.componentStatusCompleteShow = new BusMutableLiveData();
        this.componentSizeChange = new BusMutableLiveData();
        this.modelCreate = new ThreadLiveData();
        this.modelDestroy = new BusMutableLiveData();
        this.pageErrorLiveData = new DitoMutableLiveData(null, null);
        this.actionCallback = new DitoMutableLiveData(null, null);
        this.ditoRequestProcess = new ThreadLiveData();
        this.ditoExceptionLiveData = new ThreadLiveData();
        this.listScroll = new BusMutableLiveData();
        this.listScrollState = new BusMutableLiveData();
        this.updateRecyclePoolSize = new BusMutableLiveData();
        this.slideToBottom = new BusMutableLiveData();
        this.cacheGroup = new BusMutableLiveData();
        this.getCacheGroup = new BusMutableLiveData();
        this.request = new BusMutableLiveData();
        this.requestParams = new BusMutableLiveData();
        this.updateStickView = new BusMutableLiveData();
        this.hasStick = new BusMutableLiveData();
        this.stickState = new BusMutableLiveData();
        this.scrollSubStickView = new BusMutableLiveData();
        this.subStickViewHeightChanged = new BusMutableLiveData();
        this.subStickState = new BusMutableLiveData();
        this.updateStickViewWrapperBackground = new BusMutableLiveData();
        this.appendModel = new BusMutableLiveData();
        this.removeModel = new BusMutableLiveData();
        this.updateModel = new BusMutableLiveData();
        this.topModel = new BusMutableLiveData();
        this.smoothTopModel = new BusMutableLiveData();
        this.anchorPageTopModel = new BusMutableLiveData();
        this.smoothScrollState = new BusMutableLiveData();
        this.backClickLiveData = new BusMutableLiveData();
        this.ditoRequestLiveData = new DitoMutableLiveData(null, null);
        this.ditoTreeNodeWakeUpLiveData = new DitoMutableLiveData(null, null);
        this.updateHeaderContainer = new DitoMutableLiveData(null, null);
        this.updateFloatContainer = new DitoMutableLiveData(null, null);
        this.updateBackgroundContainer = new DitoMutableLiveData(null, null);
        this.updateFooterContainer = new DitoMutableLiveData(null, null);
        this.updateBodyContainer = new DitoMutableLiveData(null, null);
        this.updateBodyData = new BusMutableLiveData();
        this.updateHeaderContainerNew = new DitoMutableLiveData(null, null);
        this.updateBodyContainerNew = new DitoMutableLiveData(null, null);
        this.updateFooterContainerNew = new DitoMutableLiveData(null, null);
        this.updateFloatContainerNew = new DitoMutableLiveData(null, null);
        this.updateBackgroundContainerNew = new DitoMutableLiveData(null, null);
        this.headContainerHeightChanged = new DitoMutableLiveData(null, null);
        this.getFragment = new BusMutableLiveData();
        this.getContainerMap = new DitoMutableLiveData(null, null);
        this.getRecycleVisibleList = new BusMutableLiveData();
        this.ditoContainerScrollDistance = new BusMutableLiveData();
        this.halfContainerCollapsedOffset = new BusMutableLiveData();
        this.halfContainerHalfExpandedOffset = new BusMutableLiveData();
        this.halfContainerScrollState = new BusMutableLiveData();
        this.halfContainerRvTop = new BusMutableLiveData();
        this.halfContainerStartClose = new BusMutableLiveData();
        this.halfContainerStartShow = new BusMutableLiveData();
        this.fullPageUnfold = new BusMutableLiveData();
        this.fullPageScrollBack = new BusMutableLiveData();
        this.updateCustomCardVisibility = new BusMutableLiveData();
        BusMutableLiveData<Map<String, DitoActionModel>> r100 = new BusMutableLiveData();
        r100.setValue(new LinkedHashMap());
        this.pageStatusViewActions = r100;
        this.highlight = new DitoMutableLiveData(null, null);
        this.wakeUpViewStubAfterFmp = new DitoMutableLiveData(null, null);
        this.createDitoComponentModel = new ThreadLiveData();
        this.ditoParamsInit = new ThreadLiveData();
        this.ditoParamsBuild = new ThreadLiveData();
        this.ditoLayoutInflate = new ThreadLiveData();
        this.ditoViewInit = new ThreadLiveData();
        this.ditoDataRefresh = new ThreadLiveData();
        this.ditoDataUpdate = new ThreadLiveData();
        this.ditoDataParse = new ThreadLiveData();
        this.ditoParseBuildNodeTree = new ThreadLiveData();
        this.ditoParseMergeNodeTree = new ThreadLiveData();
        this.ditoParseCreateModel = new ThreadLiveData();
        Field[] r101 = DitoDataCenter.class.getDeclaredFields();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L21;
        Field r104 = r101[r103];
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        Object r106 = r104.get(this);     // Catch: Throwable -> L14
        if ((r106 instanceof DitoLiveData) == false) goto L9;
        ((DitoLiveData) r106).f258275b = this;     // Catch: Throwable -> L14
        ((DitoLiveData) r106).f258274a = r104.getName();     // Catch: Throwable -> L14
    L12:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        rq6.a.f538927a.b(DitoLynxNativeModule.NAME, "ditoDataCenter declaredFields init error:" + r108.getMessage() + ',' + Log.getStackTraceString(r108));
    L20:
        r103 = r103 + 1;
        goto L3
    L9:
        if ((r106 instanceof DitoMutableLiveData) == false) goto L11;
        ((DitoMutableLiveData) r106).f258278b = this;     // Catch: Throwable -> L14
        ((DitoMutableLiveData) r106).f258277a = r104.getName();     // Catch: Throwable -> L14
        goto L12
    L11:
        rq6.a.f538927a.a(DitoLynxNativeModule.NAME, "======> 没有纳入统计的LiveData: " + r104.getName());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> A() {
        return this.ditoLayoutInflate;
    }

    public final BusMutableLiveData<Integer> A0() {
        return this.smoothScrollState;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.core.y> B() {
        return this.ditoParamsBuild;
    }

    public final BusMutableLiveData<z> B0() {
        return this.smoothTopModel;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> C() {
        return this.ditoParamsInit;
    }

    public final BusMutableLiveData<g> C0() {
        return this.stickState;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> D() {
        return this.ditoParseBuildNodeTree;
    }

    public final BusMutableLiveData<i> D0() {
        return this.subStickState;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> E() {
        return this.ditoParseCreateModel;
    }

    public final BusMutableLiveData<j> E0() {
        return this.subStickViewHeightChanged;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> F() {
        return this.ditoParseMergeNodeTree;
    }

    public final BusMutableLiveData<z> F0() {
        return this.topModel;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.j> G() {
        return this.ditoRequestLiveData;
    }

    public final DitoMutableLiveData<List<BaseDitoModel<?>>> G0() {
        return this.updateBackgroundContainer;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.l> H() {
        return this.ditoRequestProcess;
    }

    public final DitoMutableLiveData<eq6.b> H0() {
        return this.updateBackgroundContainerNew;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.n> I() {
        return this.ditoTreeNodeWakeUpLiveData;
    }

    public final DitoMutableLiveData<Pair<List<BaseDitoModel<?>>, List<DitoUpdateData>>> I0() {
        return this.updateBodyContainer;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> J() {
        return this.ditoViewInit;
    }

    public final DitoMutableLiveData<eq6.b> J0() {
        return this.updateBodyContainerNew;
    }

    public final BusMutableLiveData<Integer> K() {
        return this.fullPageScrollBack;
    }

    public final BusMutableLiveData<List<BaseDitoModel<?>>> K0() {
        return this.updateBodyData;
    }

    public final BusMutableLiveData<Integer> L() {
        return this.fullPageUnfold;
    }

    public final BusMutableLiveData<String> L0() {
        return this.updateCustomCardVisibility;
    }

    public final BusMutableLiveData<d> M() {
        return this.getCacheGroup;
    }

    public final DitoMutableLiveData<List<BaseDitoModel<?>>> M0() {
        return this.updateFloatContainer;
    }

    public final DitoMutableLiveData<Function1<Map<String, ? extends View>, Unit>> N() {
        return this.getContainerMap;
    }

    public final DitoMutableLiveData<eq6.b> N0() {
        return this.updateFloatContainerNew;
    }

    public final BusMutableLiveData<Function1<List<? extends ViewGroup>, Unit>> O() {
        return this.getRecycleVisibleList;
    }

    public final DitoMutableLiveData<List<BaseDitoModel<?>>> O0() {
        return this.updateFooterContainer;
    }

    public final BusMutableLiveData<Integer> P() {
        return this.halfContainerCollapsedOffset;
    }

    public final DitoMutableLiveData<eq6.b> P0() {
        return this.updateFooterContainerNew;
    }

    public final BusMutableLiveData<Integer> Q() {
        return this.halfContainerHalfExpandedOffset;
    }

    public final DitoMutableLiveData<List<BaseDitoModel<?>>> Q0() {
        return this.updateHeaderContainer;
    }

    public final BusMutableLiveData<Integer> R() {
        return this.halfContainerRvTop;
    }

    public final DitoMutableLiveData<eq6.b> R0() {
        return this.updateHeaderContainerNew;
    }

    public final BusMutableLiveData<Integer> S() {
        return this.halfContainerScrollState;
    }

    public final BusMutableLiveData<BaseDitoModel<?>> S0() {
        return this.updateModel;
    }

    public final BusMutableLiveData<Integer> T() {
        return this.halfContainerStartClose;
    }

    public final BusMutableLiveData<Pair<Integer, Integer>> T0() {
        return this.updateRecyclePoolSize;
    }

    public final BusMutableLiveData<Integer> U() {
        return this.halfContainerStartShow;
    }

    public final DitoMutableLiveData<Pair<String, Integer>> U0() {
        return this.updateStatusView;
    }

    public final BusMutableLiveData<e> V() {
        return this.hasStick;
    }

    public final BusMutableLiveData<k> V0() {
        return this.updateStickView;
    }

    public final DitoMutableLiveData<Integer> W() {
        return this.headContainerHeightChanged;
    }

    public final BusMutableLiveData<h> W0() {
        return this.updateStickViewWrapperBackground;
    }

    public final DitoMutableLiveData<LayoutTypology> X() {
        return this.layoutTypology;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.v> X0() {
        return this.wakeUpViewStubAfterFmp;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.u> Y() {
        return this.listScroll;
    }

    public final BusMutableLiveData<Integer> Z() {
        return this.listScrollState;
    }

    public final ThreadLiveData<BaseDitoModel<?>> b0() {
        return this.modelCreate;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.core.viewmodel.a> c() {
        return this.actionCallback;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> c0() {
        return this.onActivityCreate;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.a> d() {
        return this.anchorPageTopModel;
    }

    public final DitoMutableLiveData<Boolean> d0() {
        return this.onAppEnterBackground;
    }

    public final BusMutableLiveData<a> e() {
        return this.appendModel;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> e0() {
        return this.onAttach;
    }

    public final BusMutableLiveData<Boolean> f() {
        return this.backClickLiveData;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> f0() {
        return this.onCreate;
    }

    public final BusMutableLiveData<b> g() {
        return this.cacheGroup;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> g0() {
        return this.onCreateView;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> h() {
        return this.componentBindData;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> h0() {
        return this.onDestroy;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> i() {
        return this.componentBindFinish;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> i0() {
        return this.onDestroyView;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> j() {
        return this.componentCompleteShow;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> j0() {
        return this.onDetach;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> k() {
        return this.componentCreate;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.p> k0() {
        return this.onFmp;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> l() {
        return this.componentDestroy;
    }

    public final DitoMutableLiveData<Boolean> l0() {
        return this.onHiddenChanged;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> m() {
        return this.componentFcp;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> m0() {
        return this.onPause;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> n() {
        return this.componentPause;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> n0() {
        return this.onResume;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> o() {
        return this.componentPreload;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> o0() {
        return this.onStart;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> p() {
        return this.componentResume;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> p0() {
        return this.onStop;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> q() {
        return this.componentShow;
    }

    public final DitoMutableLiveData<com.bytedance.locallife.dito.data.t> q0() {
        return this.onViewCreate;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> r() {
        return this.componentSizeChange;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> s() {
        return this.componentStatusCompleteShow;
    }

    public final DitoMutableLiveData<DitoPageInfo> s0() {
        return this.pageInfoCreate;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.b> t() {
        return this.componentUnBindData;
    }

    public final DitoMutableLiveData<Pair<Integer, Integer>> t0() {
        return this.pageStatusLiveData;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> u() {
        return this.createDitoComponentModel;
    }

    public final BusMutableLiveData<Map<String, DitoActionModel>> u0() {
        return this.pageStatusViewActions;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.u> v() {
        return this.ditoContainerScrollDistance;
    }

    public final BusMutableLiveData<BaseDitoModel<?>> v0() {
        return this.removeModel;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> w() {
        return this.ditoDataParse;
    }

    public final BusMutableLiveData<Boolean> w0() {
        return this.request;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> x() {
        return this.ditoDataRefresh;
    }

    public final BusMutableLiveData<com.bytedance.locallife.dito.data.k> x0() {
        return this.requestParams;
    }

    public final ThreadLiveData<com.bytedance.locallife.dito.data.v> y() {
        return this.ditoDataUpdate;
    }

    public final BusMutableLiveData<f> y0() {
        return this.scrollSubStickView;
    }

    public final ThreadLiveData<sq6.b> z() {
        return this.ditoExceptionLiveData;
    }

    public final BusMutableLiveData<Boolean> z0() {
        return this.slideToBottom;
    }

    @Override // com.bytedance.locallife.dito.core.c0
    public final void a(DitoDataObserver<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        c0 r101 = this.f258005a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.bytedance.locallife.dito.core.c0
    public final void b(DitoDataObserver<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        c0 r101 = this.f258005a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final MutableLiveData<JSONObject> a0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        MutableLiveData<JSONObject> r102 = (MutableLiveData) ((LinkedHashMap) this.f258006b).get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        if (r101 != 1) goto L7;
        MutableLiveData<JSONObject> r103 = new BusMutableLiveData();
    L11:
        MutableLiveData<JSONObject> r104 = r103;
        this.f258006b.put(r100, r104);
        return r104;
    L7:
        if (r101 == 2) goto L9;
        r103 = new DitoMutableLiveData(r100, this);
        goto L11
    L9:
        r103 = new ThreadLiveData(r100, this);
        goto L11
    }

    public final MutableLiveData<Object> r0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        MutableLiveData<Object> r102 = (MutableLiveData) ((LinkedHashMap) this.f258007c).get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        if (r101 != 1) goto L7;
        MutableLiveData<Object> r103 = new BusMutableLiveData();
    L11:
        MutableLiveData<Object> r104 = r103;
        this.f258007c.put(r100, r104);
        return r104;
    L7:
        if (r101 == 2) goto L9;
        r103 = new DitoMutableLiveData(r100, this);
        goto L11
    L9:
        r103 = new ThreadLiveData(r100, this);
        goto L11
    }
}
