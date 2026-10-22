package com.larus.video.impl.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyCharacterMap;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.media.o0;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.p0;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import com.tencent.connect.share.QzonePublish;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b)*\u0001W\u0018\u0000 ±\u00012\u00020\u0001:\u000e°\u0001±\u0001²\u0001³\u0001´\u0001µ\u0001¶\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0014J\b\u0010q\u001a\u00020\u000fH\u0014J\b\u0010r\u001a\u00020\u000fH\u0014J\u0006\u0010s\u001a\u00020\u0007J8\u0010t\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020@2\b\u0010v\u001a\u0004\u0018\u00010E2\b\u0010w\u001a\u0004\u0018\u00010G2\b\u0010x\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010y\u001a\u0004\u0018\u000106J8\u0010z\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020@2\b\u0010v\u001a\u0004\u0018\u00010E2\b\u0010w\u001a\u0004\u0018\u00010G2\b\u0010x\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010y\u001a\u0004\u0018\u000106J\u0006\u0010{\u001a\u00020\u000fJ\b\u0010|\u001a\u00020\u000fH\u0002J\u0010\u0010}\u001a\u00020\u000f2\u0006\u0010w\u001a\u00020GH\u0002J\b\u0010~\u001a\u00020\u000fH\u0002J\b\u0010\u007f\u001a\u00020\u000fH\u0002J\u0019\u0010\u0080\u0001\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u0007J\u0007\u0010\u0083\u0001\u001a\u00020\u0017J\u0007\u0010\u0084\u0001\u001a\u00020\u0017J\u0007\u0010\u0085\u0001\u001a\u00020\u000fJ\u0011\u0010\u0089\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ\u0011\u0010\u008a\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\u008b\u0001\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001J\u0007\u0010\u008f\u0001\u001a\u00020\u000fJ\u0007\u0010\u0090\u0001\u001a\u00020\u000fJ\u0016\u0010\u0091\u0001\u001a\u00020\u000f2\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014JU\u0010\u0093\u0001\u001a\u00020\u000f2L\u0010\u0092\u0001\u001aG\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f0\u0016J+\u0010\u0094\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0095\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0096\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0097\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110$¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0098\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0099\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u009a\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u009b\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f0\u000bJ\u0007\u0010\u009c\u0001\u001a\u00020\u001cJ\u0007\u0010\u009d\u0001\u001a\u00020\u001cJ\u0007\u0010\u009e\u0001\u001a\u00020\u000fJ\t\u0010\u009f\u0001\u001a\u00020\u000fH\u0002J\t\u0010 \u0001\u001a\u00020\u000fH\u0002J\u0012\u0010¡\u0001\u001a\u00020\u001c2\u0007\u0010¢\u0001\u001a\u00020$H\u0016J\u001b\u0010£\u0001\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u0007H\u0002J\u0007\u0010¤\u0001\u001a\u00020\u000fJ\t\u0010¥\u0001\u001a\u00020\u000fH\u0002J\u0010\u0010¦\u0001\u001a\u00020\u000f2\u0007\u0010§\u0001\u001a\u00020\u0007J\t\u0010¨\u0001\u001a\u00020\u000fH\u0002J\t\u0010©\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010ª\u0001\u001a\u00020\u000f2\u0007\u0010«\u0001\u001a\u00020TH\u0002J\t\u0010¬\u0001\u001a\u00020\u001cH\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020\u000f2\u0007\u0010«\u0001\u001a\u00020TH\u0002J\t\u0010®\u0001\u001a\u00020\u000fH\u0002J\t\u0010¯\u0001\u001a\u00020\u000fH\u0002R+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000RU\u0010\u0015\u001aI\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010#\u001a\u001f\u0012\u0013\u0012\u00110$¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bB\u0010CR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010XR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u000e\u0010j\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0086\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010L\"\u0005\b\u0088\u0001\u0010N¨\u0006·\u0001"}, d2 = {"Lcom/larus/video/impl/widget/VideoView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnLoadStateChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "loadState", "", "mOnBufferingUpdate", "percent", "mOnPlayingProgressUpdate", "mOnVideoPlay", "Lkotlin/Function0;", "mOnVideoStop", "Lkotlin/Function3;", "", "currentPlaybackTime", "duration", "completionCount", "mOnVideoResume", "", "byUser", "mOnVideoLoop", "count", "mOnVideoPause", "mOnVideoCompletion", QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, "mOnDoubleClick", "Landroid/view/MotionEvent;", "e", "mVideoView", "Landroid/view/TextureView;", "mCoverView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mPlayButton", "Landroid/widget/ImageView;", "mLoadingView", "Lcom/larus/common_ui/view/ActivityIndicatorView;", "mSurface", "Landroid/view/Surface;", "mViewAspectRatio", "", "mVideoAspectRatio", "mVideoDataSource", "Lcom/larus/video/impl/widget/VideoView$VideoDataSource;", "mVideoId", "", "mCoverImageUrl", "mVideoLocalUrl", "mVideoUrl", "mVideoCacheKey", "mVideoModel", "Lcom/larus/platform/api/IFlowVideoModel;", "mMediaEntity", "Lcom/larus/platform/uimodel/MediaEntity;", "mVideoViewHolder", "Lcom/larus/video/impl/widget/VideoViewHolder;", "mPlayType", "getMPlayType$annotations", "()V", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "mVideoEngine", "Lcom/ss/ttvideoengine/TTVideoEngine;", "mCompletionCount", "mShouldBePlaying", "allowGesture", "getAllowGesture", "()Z", "setAllowGesture", "(Z)V", "mMainHandler", "Landroid/os/Handler;", "mExecutingActions", "mPendingActions", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "mSurfaceTextureListener", "com/larus/video/impl/widget/VideoView$mSurfaceTextureListener$1", "Lcom/larus/video/impl/widget/VideoView$mSurfaceTextureListener$1;", "mGestureDetector", "Landroid/view/GestureDetector;", "mProgressUpdateTask", "Lcom/larus/video/impl/widget/VideoView$ProgressUpdateTask;", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "afterClickCallBack", "Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;", "getAfterClickCallBack", "()Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;", "setAfterClickCallBack", "(Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;)V", "dataChange", "getDataChange", "()Lkotlin/jvm/functions/Function0;", "setDataChange", "(Lkotlin/jvm/functions/Function0;)V", "mediaApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "getPlayType", "bindVideo", "videoViewHolder", "videoController", "videoEngine", "videoEntity", "category", "bindVideoWithViewModel", "start", "realStart", "resetSurfaceAndPlay", "requestFirstStreamData", "retryStart", "setVideoAspectRatio", "width", "height", "getCurrentPlaybackTime", "getDuration", "stop", "mResumeOrPauseByUser", "getMResumeOrPauseByUser", "setMResumeOrPauseByUser", "resume", "pause", "seekTo", "msec", "listener", "Lcom/ss/ttvideoengine/SeekCompletionListener;", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "onVideoPlay", "block", "onVideoStop", "onVideoResume", "onVideoLoop", "onVideoPause", "onDoubleClick", "onVideoCompletion", "onBufferingUpdate", "onLoadStateChanged", "onPlayingProgressUpdate", "isPlaying", "isPaused", "onSingleTap", "updateProgress", "resetViewVisible", "onTouchEvent", "event", "fitCoverImage", "loadCoverImage", "fitVideoSize", "setPlayButtonVisible", "visible", "fitVideoViewSize", "abandonAudioFocus", "execAction", "action", "isSurfaceValid", "enqueueAction", "execPendingActions", "clearPendingActions", "AfterClickCallBack", "Companion", "PlayType", "VideoDataSource", "EngineListener", "ProgressUpdateTask", "GestureDetectorListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoView extends FrameLayout {
    public static boolean G;
    public e A;
    public final com.larus.video.impl.widget.c B;
    public a C;
    public Function0<Unit> D;
    public final com.larus.media.model.a E;
    public boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Integer, Unit> f375939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Integer, Unit> f375940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextureView f375941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SimpleDraweeView f375942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f375943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ActivityIndicatorView f375944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Surface f375945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f375946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f375947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f375948j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f375949k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f375950l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f375951m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f375952n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p0 f375953o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MediaEntity f375954p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public VideoViewHolder f375955q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f375956r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IVideoController f375957s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TTVideoEngine f375958t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f375959u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f375960v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f375961w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f375962x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ArrayList<Runnable> f375963y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final GestureDetector f375964z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/video/impl/widget/VideoView$PlayType;", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PlayType {
    }

    public interface a {
        void onPause();

        void onPlay();
    }

    public static final class b {
    }

    public static final class c implements VideoEngineCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VideoView f375965a;

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ String getEncryptedLocalTime() {
            return VideoEngineCallback.CC.$default$getEncryptedLocalTime(this);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onABRPredictBitrate(int r100, int r101) {
            VideoEngineCallback.CC.$default$onABRPredictBitrate(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onAVBadInterlaced(Map r100) {
            VideoEngineCallback.CC.$default$onAVBadInterlaced(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onBufferEnd(int r100) {
            VideoEngineCallback.CC.$default$onBufferEnd(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine r100, int r101) {
            VideoEngineCallback.CC.$default$onCurrentPlaybackTimeUpdate(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onFirstAVSyncFrame(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onFrameAboutToBeRendered(TTVideoEngine r100, int r101, long r102, long r103, Map r104) {
            VideoEngineCallback.CC.$default$onFrameAboutToBeRendered(this, r100, r101, r102, r103, r104);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onFrameDraw(int r100, Map r101) {
            VideoEngineCallback.CC.$default$onFrameDraw(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onInfoIdChanged(int r100) {
            VideoEngineCallback.CC.$default$onInfoIdChanged(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onPlayUrlChanged(int r100, String r101, String r102) {
            VideoEngineCallback.CC.$default$onPlayUrlChanged(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onPrepare(TTVideoEngine r100) {
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onPrepared(TTVideoEngine r100) {
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onReadyForDisplay(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onReadyForDisplay(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onRefreshSurface(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onSARChanged(int r100, int r101) {
            VideoEngineCallback.CC.$default$onSARChanged(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ int onSetSurface(TTVideoEngine r100, VideoSurface r101, Surface r102) {
            return VideoEngineCallback.CC.$default$onSetSurface(this, r100, r101, r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onSilenceDetected(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onSilenceDetected(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r100) {
            VideoEngineCallback.CC.$default$onVideoSecondFrame(this, r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onVideoStreamBitrateChanged(Resolution r100, int r101) {
            VideoEngineCallback.CC.$default$onVideoStreamBitrateChanged(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final /* synthetic */ void onVideoURLRouteFailed(Error r100, String r101) {
            VideoEngineCallback.CC.$default$onVideoURLRouteFailed(this, r100, r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onCompletion(TTVideoEngine r100) {
            FLogger.f375446a.d("VideoView", "onCompletion");
            VideoView r101 = this.f375965a;
            boolean r102 = VideoView.G;
            r101.getClass();
            this.f375965a.getClass();
            if (r100 == null) goto L7;
            boolean r103 = true;
            if (r100.getLooping(true) != true) goto L7;
        L8:
            if (r103 == false) goto L10;
            this.f375965a.getClass();
            return;
        L10:
            if (r100 == null) goto L12;
            r100.play();
        L12:
            this.f375965a.getClass();
            return;
        L7:
            r103 = false;
            goto L8
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onError(Error r100) {
            FLogger.f375446a.d("VideoView", "onError: " + r100);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onRenderStart(TTVideoEngine r100) {
            VideoView r101 = this.f375965a;
            boolean r102 = VideoView.G;
            r101.getClass();
            VideoView.b(this.f375965a);
            this.f375965a.f375944f.setVisibility(8);
            this.f375965a.f375942d.setVisibility(8);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoStatusException(int r100) {
            FLogger.f375446a.d("VideoView", "onVideoStatusException: " + r100);
            this.f375965a.post(new j(this));
        }

        public c(VideoView r100, p0 r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f375965a = r100;
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onBufferingUpdate(TTVideoEngine r100, int r101) {
            Function1<? super Integer, Unit> r102 = this.f375965a.f375939a;
            if (r102 == null) goto L6;
            r102.invoke(Integer.valueOf(r101));
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onLoadStateChanged(TTVideoEngine r100, int r101) {
            FLogger.f375446a.d("VideoView", "onLoadStateChanged: " + r101);
            VideoView r102 = this.f375965a;
            boolean r103 = VideoView.G;
            r102.getClass();
            if (r101 != 1) goto L5;
            this.f375965a.f375944f.setVisibility(8);
            return;
        L5:
            if (r101 != 2) goto L7;
            VideoView r104 = this.f375965a;
            r104.f375943e.setVisibility(8);
            r104.f375944f.setVisibility(0);
            if (NetworkUtils.isNetworkAvailable(this.f375965a.getContext()) == true) goto L16;
            t19.s r105 = t19.s.f544207a;
            Context r106 = this.f375965a.getContext();
            String r107 = this.f375965a.getContext().getResources().getString(R.string.larus_internet_connection_failed);
            r105.getClass();
            t19.s.c(r106, r107);
            return;
        L16:
            return;
        L7:
            if (r101 != 3) goto L18;
            VideoView.a(this.f375965a);
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onPlaybackStateChanged(TTVideoEngine r100, int r101) {
            FLogger.f375446a.d("VideoView", "onPlaybackStateChanged: " + r101);
            if (r101 != 0) goto L5;
        L13:
            VideoView r102 = this.f375965a;
            boolean r103 = VideoView.G;
            r102.getClass();
            Lazy r104 = MediaResourceManager.f358950a;
            MediaResourceManager.a(r102.E);
            this.f375965a.getClass();
            return;
        L5:
            if (r101 != 1) goto L7;
            this.f375965a.f375943e.setVisibility(8);
            this.f375965a.f375944f.setVisibility(8);
            this.f375965a.getClass();
            return;
        L7:
            if (r101 == 2) goto L13;
            if (r101 != 3) goto L17;
            VideoView.a(this.f375965a);
            return;
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onStreamChanged(TTVideoEngine r100, int r101) {
            FLogger.f375446a.d("VideoView", "onStreamChanged: " + r101);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onBufferStart(int r100, int r101, int r102) {
            VideoEngineCallback.CC.$default$onBufferStart(this, r100, r101, r102);
            FLogger.f375446a.d("VideoView", "Stuttering  REASON : " + r100 + " TIME : " + r101 + "ACTION : " + r102);
        }

        @Override // com.ss.ttvideoengine.VideoEngineCallback
        public final void onVideoSizeChanged(TTVideoEngine r100, int r101, int r102) {
            VideoView r103 = this.f375965a;
            boolean r104 = VideoView.G;
            if (r103.f375946h <= r103.f375947i) goto L7;
            TTVideoEngine r105 = r103.f375958t;
            if (r105 == null) goto L11;
            r105.setIntOption(4, 2);
            return;
        L11:
            return;
        L7:
            TTVideoEngine r106 = r103.f375958t;
            if (r106 == null) goto L13;
            r106.setIntOption(4, 0);
            return;
        }
    }

    public static final class d extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VideoView f375966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f375967b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return true;
        }

        public d(VideoView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f375966a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f375967b = System.currentTimeMillis();
            VideoView r101 = this.f375966a;
            boolean r102 = VideoView.G;
            r101.getClass();
            return super.onDoubleTap(r100);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if ((System.currentTimeMillis() - this.f375967b) <= 500) goto L6;
            this.f375966a.f();
        L6:
            return super.onSingleTapConfirmed(r100);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VideoView f375968a;

        @Override // java.lang.Runnable
        public final void run() {
            VideoView.b(this.f375968a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(VideoView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f375968a = r100;
        }
    }

    public static final class f implements DataSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f375969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f375970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f375971c;

        @Override // com.ss.ttvideoengine.DataSource
        public final String apiForFetcher(Map<String, String> r100, int r101) {
            return "";
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f375969a, r101.f375969a) == true) goto L12;
            return false;
        L12:
            if (this.f375970b == r101.f375970b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f375971c, r101.f375971c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f375969a.hashCode() * 31;
            long r101 = this.f375970b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            String r103 = this.f375971c;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "VideoDataSource(videoID=" + this.f375969a + ", itemId=" + this.f375970b + ", category=" + this.f375971c + ')';
        }

        public f(String r100) {
            Intrinsics.checkNotNullParameter("", "videoID");
            this.f375969a = "";
            this.f375970b = 0;
            this.f375971c = r100;
        }
    }

    public static final class g implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoView f375972a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        public g(VideoView r100) {
            this.f375972a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            r100.release();
            Surface r101 = this.f375972a.f375945g;
            if (r101 == null) goto L5;
            r101.release();
        L5:
            this.f375972a.f375945g = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            VideoView r103 = this.f375972a;
            boolean r104 = VideoView.G;
            Surface r105 = r103.f375945g;
            if (r105 != null) goto L5;
        L7:
            boolean r106 = false;
        L8:
            if (r106 == true) goto L10;
            VideoView r107 = this.f375972a;
            r107.f375945g = new Surface(r100);
        L10:
            VideoView r108 = this.f375972a;
            TTVideoEngine r109 = r108.f375958t;
            if (r109 != null) goto L13;
        L15:
            VideoView r110 = this.f375972a;
            if (r110.f375962x == true) goto L30;
            ArrayList<Runnable> r111 = r110.f375963y;
            if (r111 == null) goto L27;
            r110.f375962x = true;
            Iterator r112 = new ArrayList(r111).iterator();
        L22:
            if (r112.hasNext() == false) goto L24;
            ((Runnable) r112.next()).run();
            goto L22
        L24:
            ArrayList<Runnable> r113 = r110.f375963y;
            if (r113 == null) goto L27;
            r113.clear();
        L27:
            r110.f375962x = false;
            return;
        L30:
            return;
        L13:
            if (r108.f375959u == false) goto L15;
            r109.setSurface(r108.f375945g);
            goto L15
        L5:
            if (r105.isValid() != true) goto L7;
            r106 = true;
            goto L8
        }
    }

    public static final class h implements com.larus.media.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueAnimator f375973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoView f375974b;

        public h(VideoView r100) {
            this.f375974b = r100;
        }

        @Override // com.larus.media.v
        public final boolean b(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            Map<String, o0.a> r101 = o0.f359131a;
            return o0.a("VIDEO", r100.getScene());
        }

        @Override // com.larus.media.v
        public final void e(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            com.larus.media.v.a.d(r100);
            final VideoView r101 = this.f375974b;
            r101.f375961w.post(new k(r101, this));
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(lk9.g r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            final VideoView r102 = this.f375974b;
            r102.f375961w.post(new l(r102, this));
            com.larus.media.v.a.f(r100, r101);
        }

        @Override // com.larus.media.v
        public final void d(lk9.g r100, lk9.g r101) {
            com.larus.media.v.a.c(r100, r101);
        }

        @Override // com.larus.media.v
        public final void g(lk9.g r100, float r101) {
            com.larus.media.v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            com.larus.media.v.a.e(r100, r101);
            final VideoView r102 = this.f375974b;
            r102.f375961w.post(new m(r102, this));
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
            return com.larus.media.v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            Map<String, o0.a> r103 = o0.f359131a;
            return o0.b("VIDEO", r101.getScene());
        }
    }

    public VideoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private static /* synthetic */ void getMPlayType$annotations() {
    }

    static {
        G = true;
    }

    public final void d() {
        boolean r100 = true;
        if (this.f375946h != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        if (this.f375947i != 0.0f) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L80;
        CommonVideoModel.Companion.getClass();
        if (CommonVideoModel.access$getTopBarHeight$cp() < 0) goto L16;
        CommonVideoModel.access$getTopBarHeight$cp();
    L18:
        if (CommonVideoModel.access$getBottomBarHeight$cp() < 0) goto L20;
        CommonVideoModel.access$getBottomBarHeight$cp();
    L28:
        int r103 = getHeight() - i5.b();
        int r104 = getWidth();
        float r105 = r104;
        float r106 = r103;
        float r107 = r105 / r106;
        float r108 = this.f375947i;
        if (r108 < 1.0f) goto L32;
    L48:
        r103 = (int) (r105 / r108);
    L49:
        ViewGroup.LayoutParams r109 = this.f375941c.getLayoutParams();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r109;
        if (this.f375946h != 0.0f) goto L52;
        boolean r111 = true;
    L53:
        if (r111 == true) goto L71;
        if (this.f375947i == 0.0f) goto L58;
        r100 = false;
    L58:
        if (r100 == true) goto L71;
        if (this.f375942d.getVisibility() != 0) goto L71;
        if (this.f375946h <= this.f375947i) goto L65;
        ImageView.ScaleType r112 = ImageView.ScaleType.CENTER_CROP;
    L66:
        ViewGroup.LayoutParams r113 = this.f375942d.getLayoutParams();
        r113.width = r104;
        r113.height = r103;
        this.f375942d.setLayoutParams(r113);
        this.f375942d.setScaleType(r112);
        if (this.f375950l == null) goto L69;
        this.f375942d.setVisibility(0);
        goto L71
    L69:
        this.f375942d.setVisibility(8);
        goto L71
    L65:
        r112 = ImageView.ScaleType.FIT_CENTER;
    L71:
        if (r110.height == r103) goto L73;
    L74:
        r110.gravity = 17;
        r110.width = r104;
        r110.height = r103;
        r110.bottomMargin = i5.b();
        this.f375941c.setLayoutParams(r110);
        return;
    L73:
        if (r110.width != r104) goto L74;
        return;
    L52:
        r111 = false;
        goto L53
    L32:
        if (r108 >= 1.0f) goto L37;
        if (r108 >= r107) goto L37;
    L47:
        r104 = (int) (r106 * r108);
    L37:
        if (r108 >= 1.0f) goto L44;
        if (r108 <= r107) goto L44;
        if (r108 >= 0.6d) goto L48;
    L44:
        if (r108 >= 0.6d) goto L48;
        if (r108 <= 0.0f) goto L48;
    L20:
        boolean r114 = KeyCharacterMap.deviceHasKey(3);
        i0.f375410a.getClass();
        int r115 = i0.f();
        if (r114 == false) goto L76;
        if (r115 > 0) goto L76;
        int r116 = 0;
    L26:
        CommonVideoModel.access$setBottomBarHeight$cp(r116);
    L76:
        r116 = i0.e();     // Catch: Throwable -> L27
    L16:
        i0.f375410a.getClass();
        CommonVideoModel.access$setTopBarHeight$cp(i0.g());
        goto L18
    L80:
        return;
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public final void e() {
        this.f375943e.setVisibility(8);
        this.f375944f.setVisibility(0);
        if (this.f375950l == null) goto L5;
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(com.larus.utils.i.d(getContext()), (int) (com.larus.utils.i.d(getContext()) / this.f375947i));
        r100.gravity = 17;
        this.f375942d.setLayoutParams(r100);
        this.f375942d.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(getResources()).setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.larus_video_cover_image_bg)).setPlaceholderImage(AppCompatResources.getDrawable(getContext(), R.drawable.larus_video_cover_image_bg)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
        ImageLoaderKt.u(this.f375942d, this.f375950l, "video_cover_img");
        this.f375942d.setVisibility(0);
        return;
    L5:
        this.f375942d.setVisibility(8);
    }

    public final void f() {
        FLogger.f375446a.d("VideoView", "[onSingleTap]");
        TTVideoEngine r100 = this.f375958t;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        g(this);
        a r103 = this.C;
        if (r103 == null) goto L23;
        r103.onPause();
        return;
    L23:
        return;
    L12:
        TTVideoEngine r104 = this.f375958t;
        if (r104 != null) goto L15;
    L17:
        if (r101 == false) goto L21;
        i(this);
        a r105 = this.C;
        if (r105 == null) goto L25;
        r105.onPlay();
        return;
    L25:
        return;
    L21:
        j();
        return;
    L15:
        if (r104.getPlaybackState() != 2) goto L17;
        r101 = true;
        goto L17
    L5:
        if (r100.getPlaybackState() != 1) goto L7;
        r102 = true;
        goto L8
    }

    public final long getCurrentPlaybackTime() {
        TTVideoEngine r100 = this.f375958t;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurrentPlaybackTime();
    }

    public final long getDuration() {
        TTVideoEngine r100 = this.f375958t;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDuration();
    }

    public final void j() {
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.m(this.E, new com.larus.video.impl.widget.g(this), new com.larus.video.impl.widget.h(this), 0, 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.B);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.B);
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.a(this.E);
    }

    public final a getAfterClickCallBack() {
        return this.C;
    }

    public final boolean getAllowGesture() {
        return this.f375960v;
    }

    public final Function0<Unit> getDataChange() {
        return this.D;
    }

    public final boolean getMResumeOrPauseByUser() {
        return this.F;
    }

    public final int getPlayType() {
        return this.f375956r;
    }

    public static final void a(VideoView r100) {
        r100.getClass();
        FLogger.f375446a.d("VideoView", "[retryStart]");
        if (NetworkUtils.isNetworkAvailable(r100.getContext()) == false) goto L47;
        TTVideoEngine r101 = r100.f375958t;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == true) goto L48;
        r101.stop();
        int r103 = r100.f375956r;
        if (r103 == (-1)) goto L37;
        if (r103 == 0) goto L32;
        if (r103 != 1) goto L20;
        return;
    L20:
        if (r103 != 2) goto L43;
        p0 r104 = r100.f375953o;
        VideoModel r105 = null;
        if (r104 == null) goto L25;
        VideoModel r106 = r104.getImpl();
    L26:
        if (r106 == null) goto L43;
        p0 r107 = r100.f375953o;
        if (r107 == null) goto L30;
        r105 = r107.getImpl();
    L30:
        r101.setVideoModel(r105);
        goto L43
    L25:
        r106 = null;
    L43:
        r101.play();
        return;
    L32:
        if (r100.f375948j == null) goto L43;
        String r108 = r100.f375949k;
        if (r108 == null) goto L43;
        r100.f375956r = 1;
        r101.setVideoID(r108);
        r101.setDataSource(r100.f375948j);
        goto L43
    L37:
        if (r100.f375951m == null) goto L42;
        r100.f375956r = 0;
        if (r101.isSystemPlayer() == false) goto L41;
        r101.setDirectURL(r100.f375951m);
        goto L43
    L41:
        r101.setDirectUrlUseDataLoader(r100.f375951m, r100.f375952n, r100.f375949k);
        goto L43
    L42:
        r100.f375956r = 1;
        r101.setVideoID(r100.f375949k);
        r101.setDataSource(r100.f375948j);
        goto L43
    L48:
        return;
    L10:
        if (r101.getPlaybackState() != 1) goto L12;
        r102 = true;
        goto L13
    }

    public static final void b(VideoView r100) {
        e r101 = r100.A;
        if (r101 == null) goto L17;
        TTVideoEngine r102 = r100.f375958t;
        if (r102 == null) goto L7;
        int r103 = r102.getCurrentPlaybackTime();
    L8:
        TTVideoEngine r104 = r100.f375958t;
        if (r104 == null) goto L11;
        int r105 = r104.getDuration();
    L12:
        Function1<? super Integer, Unit> r106 = r100.f375940b;
        if (r106 == null) goto L15;
        r106.invoke(Integer.valueOf((r103 * 100) / r105));
    L15:
        r100.postDelayed(r101, 500);
        return;
    L11:
        r105 = 100;
        goto L12
    L7:
        r103 = 0;
        goto L8
    }

    public static void g(final VideoView r100) {
        r100.getClass();
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("[pause] byUser:");
        final boolean r103 = true;
        r102.append(true);
        r101.d("VideoView", r102.toString());
        r100.c(new com.larus.video.impl.widget.e(r100, r103));
    }

    public static void i(final VideoView r100) {
        r100.getClass();
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("[resume] byUser:");
        final boolean r103 = true;
        r102.append(true);
        r101.d("VideoView", r102.toString());
        r100.c(new com.larus.video.impl.widget.f(r100, r103));
    }

    public final void c(Runnable r100) {
        Surface r101 = this.f375945g;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isValid() != true) goto L7;
    L8:
        if (r102 == false) goto L11;
        r100.run();
        return;
    L11:
        if (this.f375963y != null) goto L13;
        this.f375963y = new ArrayList();
    L13:
        ArrayList<Runnable> r103 = this.f375963y;
        if (r103 == null) goto L18;
        r103.add(r100);
        return;
    L18:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void h(TTVideoEngine r100) {
        FLogger.f375446a.d("VideoView", "[resetSurfaceAndPlay]");
        r100.setSurface(this.f375945g);
        r100.setVideoEngineCallback(new c(this, this.f375953o));
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L5;
    L9:
        r100.play();
        return;
    L5:
        if (NetworkUtils.isWifi(getContext()) == true) goto L9;
        if (G == false) goto L9;
        G = false;
        t19.s r101 = t19.s.f544207a;
        Context r102 = getContext();
        String r103 = getContext().getString(R.string.larus_use_4g_toast);
        r101.getClass();
        t19.s.t(r102, r103);
        goto L9
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f375960v == false) goto L9;
        if (this.f375964z.onTouchEvent(r100) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r100);
    }

    public final void setAfterClickCallBack(a r100) {
        this.C = r100;
    }

    public final void setAllowGesture(boolean r100) {
        this.f375960v = r100;
    }

    public final void setDataChange(Function0<Unit> r100) {
        this.D = r100;
    }

    public final void setMResumeOrPauseByUser(boolean r100) {
        this.F = r100;
    }

    public final void setPlayButtonVisible(int r100) {
        this.f375943e.setVisibility(r100);
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [com.larus.video.impl.widget.c] */
    public VideoView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        TextureView r100 = new TextureView(r210);
        this.f375941c = r100;
        SimpleDraweeView r101 = new SimpleDraweeView(r210);
        this.f375942d = r101;
        ImageView r102 = new ImageView(r210);
        this.f375943e = r102;
        ActivityIndicatorView r103 = new ActivityIndicatorView(r210, null);
        this.f375944f = r103;
        this.f375956r = -1;
        this.f375961w = new Handler(Looper.getMainLooper());
        g r104 = new g(this);
        this.f375964z = new GestureDetector(r210, new d(this));
        this.B = new com.larus.video.impl.widget.c(this);
        this.E = new com.larus.media.model.a(null, "VIDEO", false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, false, MediaLevel.PLAY_HIGH.getValue(), false, new h(this), 1453);
        setBackgroundColor(ContextCompat.getColor(r210, R.color.larus_static_black));
        r101.setAdjustViewBounds(true);
        addView(r100, -1, -1);
        int r105 = (int) UIUtils.dip2Px(r210, 56.0f);
        int r106 = (int) UIUtils.dip2Px(r210, 32.0f);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(r105, r105);
        r107.gravity = 17;
        addView(r102, r107);
        r102.setImageResource(R.drawable.larus_tiktok_video_play);
        e1.d(r102, new com.larus.video.impl.widget.d(this));
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(r106, r106);
        r108.gravity = 17;
        r103.f328120d = true;
        r103.setColor(getResources().getColor(R.color.larus_neutral_50));
        r103.setStrokeWidth(i5.Y());
        addView(r103, r108);
        r103.setVisibility(8);
        addView(r101, -1, -1);
        r100.setSurfaceTextureListener(r104);
    }

    public /* synthetic */ VideoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        d();
    }
}
