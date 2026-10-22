package com.larus.common_ui.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.monitor.CommonUIMessageImageLoader;
import com.larus.bmhome.monitor.CommonUIMessageImageType;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.image.loader.b0;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MediaScene;
import com.larus.media.MixPriority;
import com.larus.nova.R;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.platform.api.n0;
import com.larus.platform.api.p0;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.d7;
import v19.i5;
import v19.m5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0016*\u0002\u0088\u0001\b\u0016\u0018\u0000 ¢\u00022\u00020\u0001:\u000e¡\u0002¢\u0002£\u0002¤\u0002¥\u0002¦\u0002§\u0002B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0016J\u001a\u0010m\u001a\u00020\u00162\u0006\u0010n\u001a\u00020E2\b\b\u0002\u0010o\u001a\u00020\u0010H\u0002J\u0010\u0010p\u001a\u00020\u00102\u0006\u0010q\u001a\u00020jH\u0002J-\u0010¨\u0001\u001a\u00020\u00162\u0007\u0010©\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u00072\u0007\u0010¬\u0001\u001a\u00020\u0007H\u0014J\u0010\u0010\u00ad\u0001\u001a\u00020\u00162\u0007\u0010®\u0001\u001a\u00020\u0010J\u0007\u0010¯\u0001\u001a\u00020\u0016J\t\u0010°\u0001\u001a\u00020\u0016H\u0014J\t\u0010±\u0001\u001a\u00020\u0016H\u0014J\u0007\u0010²\u0001\u001a\u00020\u0016JR\u0010³\u0001\u001a\u00020\u00162\t\u0010´\u0001\u001a\u0004\u0018\u00010[2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010·\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010¸\u0001\u001a\u0004\u0018\u00010EJ\u0012\u0010¹\u0001\u001a\u00020\u00162\t\u0010´\u0001\u001a\u0004\u0018\u00010[J\u0007\u0010º\u0001\u001a\u00020\u0010J{\u0010»\u0001\u001a\u00020\u00162\u000b\b\u0002\u0010¼\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010E2\u000b\b\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010¿\u0001\u001a\u0004\u0018\u00010\u00072\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u00010G2\u0011\b\u0002\u0010Á\u0001\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010I2\u000b\b\u0002\u0010Â\u0001\u001a\u0004\u0018\u00010E¢\u0006\u0003\u0010Ã\u0001J\t\u0010Ä\u0001\u001a\u00020\u0016H\u0014J\u0007\u0010Å\u0001\u001a\u00020\u0016J\u0007\u0010Æ\u0001\u001a\u00020\u0016J\u0007\u0010Ç\u0001\u001a\u00020\u0010J\u000f\u0010È\u0001\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u0010J\u0012\u0010É\u0001\u001a\u00020\u00162\u0007\u0010Ê\u0001\u001a\u000207H\u0002J\t\u0010Ë\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010Ì\u0001\u001a\u00020\u00162\u0007\u0010Í\u0001\u001a\u00020EH\u0002J\u0012\u0010Î\u0001\u001a\u00020\u00162\u0007\u0010Í\u0001\u001a\u00020EH\u0002J\u0012\u0010Ï\u0001\u001a\u00020\u00162\u0007\u0010Ð\u0001\u001a\u00020EH\u0002J\t\u0010Ñ\u0001\u001a\u00020\u0016H\u0002J\u0007\u0010Ò\u0001\u001a\u00020\u0016J\u0007\u0010Ó\u0001\u001a\u00020EJ\u0019\u0010Ô\u0001\u001a\u00020\u00162\u0007\u0010¿\u0001\u001a\u00020\u00072\u0007\u0010¾\u0001\u001a\u00020\u0007J\u0007\u0010Õ\u0001\u001a\u00020jJ\u0007\u0010Ö\u0001\u001a\u00020jJ\u0007\u0010×\u0001\u001a\u00020\u0016J\u0007\u0010Ø\u0001\u001a\u00020\u0016J\u001d\u0010Ü\u0001\u001a\u00020\u00162\t\b\u0002\u0010Ý\u0001\u001a\u00020\u00102\t\b\u0002\u0010Þ\u0001\u001a\u00020\u0007J\u001b\u0010ß\u0001\u001a\u00020\u00162\u0007\u0010Ý\u0001\u001a\u00020\u00102\u0007\u0010Þ\u0001\u001a\u00020\u0007H\u0002J\u001d\u0010à\u0001\u001a\u00020\u00162\t\b\u0002\u0010Ý\u0001\u001a\u00020\u00102\t\b\u0002\u0010Þ\u0001\u001a\u00020\u0007J\u0010\u0010á\u0001\u001a\u00020\u00162\u0007\u0010â\u0001\u001a\u00020\u0007J\t\u0010ã\u0001\u001a\u00020\u0010H\u0002J\t\u0010ä\u0001\u001a\u00020\u0010H\u0002J\t\u0010å\u0001\u001a\u00020\u0010H\u0002J\u0010\u0010æ\u0001\u001a\u00020\u00162\u0007\u0010ç\u0001\u001a\u00020\u0010J\u0013\u0010è\u0001\u001a\u00020\u00102\b\u0010é\u0001\u001a\u00030ê\u0001H\u0016J\u0013\u0010ë\u0001\u001a\u00020\u00102\b\u0010é\u0001\u001a\u00030ê\u0001H\u0016J\u001c\u0010ì\u0001\u001a\u00020\u00162\u0007\u0010í\u0001\u001a\u00020\u00072\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001J\u0007\u0010ð\u0001\u001a\u00020\u0016J\u0007\u0010ñ\u0001\u001a\u00020\u0016J\u0007\u0010ò\u0001\u001a\u00020\u0016J\u0007\u0010ó\u0001\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0007J+\u0010ô\u0001\u001a\u00020\u00162\"\u0010õ\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019J+\u0010ö\u0001\u001a\u00020\u00162\"\u0010õ\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00160\u0019J,\u0010\u001e\u001a\u00020\u00162$\u0010÷\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019J\u0012\u0010ø\u0001\u001a\u00020\u00162\t\u0010÷\u0001\u001a\u0004\u0018\u00010%J\u0007\u0010ù\u0001\u001a\u00020\u0010J\u0007\u0010ú\u0001\u001a\u00020\u0010J\u0007\u0010û\u0001\u001a\u00020\u0016J\u001c\u0010ü\u0001\u001a\u00020\u00162\u000b\b\u0002\u0010ý\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010þ\u0001J\t\u0010ÿ\u0001\u001a\u00020\u0016H\u0002J\u0012\u0010\u0080\u0002\u001a\u00020\u00162\u0007\u0010\u0081\u0002\u001a\u00020EH\u0002J$\u0010\u0082\u0002\u001a\u00020j2\u0007\u0010\u0083\u0002\u001a\u00020j2\u0007\u0010\u0084\u0002\u001a\u00020j2\u0007\u0010\u0085\u0002\u001a\u00020\u0007H\u0002J\u0014\u0010\u0086\u0002\u001a\u00020E2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010EH\u0002J\u0014\u0010\u0087\u0002\u001a\u00020E2\t\u0010½\u0001\u001a\u0004\u0018\u00010EH\u0002J\u0007\u0010\u0088\u0002\u001a\u00020\u0016J\u0007\u0010\u0089\u0002\u001a\u00020\u0016J\u001b\u0010\u008a\u0002\u001a\u00020\u00162\u0007\u0010¿\u0001\u001a\u00020\u00072\u0007\u0010¾\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008b\u0002\u001a\u00020\u0016H\u0014J\u0016\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008d\u00022\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0002J\u0017\u0010\u0090\u0002\u001a\u00020\u00072\f\u0010\u0091\u0002\u001a\u00030\u0092\u0002\"\u00020\u0007H\u0002J\u0012\u0010\u0093\u0002\u001a\u00020\u00162\t\b\u0001\u0010\u0094\u0002\u001a\u00020\u0007J\u0007\u0010\u0095\u0002\u001a\u00020\u0016J\t\u0010\u0096\u0002\u001a\u00020\u0016H\u0002J\t\u0010\u0097\u0002\u001a\u00020\u0016H\u0016J\t\u0010\u0098\u0002\u001a\u00020\u0016H\u0002J\u0012\u0010\u0099\u0002\u001a\u00020\u00162\u0007\u0010\u009a\u0002\u001a\u00020wH\u0002J\t\u0010\u009b\u0002\u001a\u00020\u0010H\u0002J\u0012\u0010\u009c\u0002\u001a\u00020\u00162\u0007\u0010\u009a\u0002\u001a\u00020wH\u0002J\t\u0010\u009d\u0002\u001a\u00020\u0016H\u0002J\t\u0010\u009e\u0002\u001a\u00020\u0016H\u0002J\u001b\u0010\u009f\u0002\u001a\u00020\u00162\u0007\u0010¿\u0001\u001a\u00020\u00072\u0007\u0010¾\u0001\u001a\u00020\u0007H\u0002J\t\u0010 \u0002\u001a\u00020\u0016H\u0002R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000207X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u000207X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001a\u0010?\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u000e\u0010B\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010M\u001a\u0004\u0018\u00010EX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0010\u0010R\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0012\"\u0004\bc\u0010\u0014R\u001a\u0010d\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0012\"\u0004\bf\u0010\u0014R\u000e\u0010g\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020jX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020sX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010u\u001a\u0016\u0012\u0004\u0012\u00020w\u0018\u00010vj\n\u0012\u0004\u0012\u00020w\u0018\u0001`xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u000207X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010{\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u001d\u0010\u0080\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010}\"\u0005\b\u0082\u0001\u0010\u007fR\u000f\u0010\u0083\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0085\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0089\u0001R\u0012\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008c\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0012\"\u0005\b\u008e\u0001\u0010\u0014R\u001d\u0010\u008f\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0012\"\u0005\b\u0091\u0001\u0010\u0014R\u001d\u0010\u0092\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0012\"\u0005\b\u0094\u0001\u0010\u0014R\u000f\u0010\u0095\u0001\u001a\u00020wX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R(\u0010\u009e\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u009f\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u000f\u0010¤\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¥\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010Ù\u0001\u001a\u00020\u0010X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÚ\u0001\u0010\u0012\"\u0005\bÛ\u0001\u0010\u0014¨\u0006¨\u0002"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/common_ui/video/DisplayMode;", "displayMode", "getDisplayMode", "()Lcom/larus/common_ui/video/DisplayMode;", "enableCreationPreviewCoverLoadOpt", "", "getEnableCreationPreviewCoverLoadOpt", "()Z", "setEnableCreationPreviewCoverLoadOpt", "(Z)V", "setCenterCrop", "", "setAspectFit", "mOnBufferingUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "percent", "mOnPlayingProgressUpdate", "onPlayStatusChanged", "status", "getOnPlayStatusChanged", "()Lkotlin/jvm/functions/Function1;", "setOnPlayStatusChanged", "(Lkotlin/jvm/functions/Function1;)V", "mVideoEngineCallback", "Lcom/larus/platform/api/IFlowVideoEngineCallback;", "mVideoView", "Landroid/view/TextureView;", "getMVideoView", "()Landroid/view/TextureView;", "setMVideoView", "(Landroid/view/TextureView;)V", "mCoverView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getMCoverView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "mPlayButton", "Landroid/widget/ImageView;", "mLoadingView", "Lcom/larus/common_ui/view/ActivityIndicatorView;", "mSurface", "Landroid/view/Surface;", "mViewAspectRatio", "", "getMViewAspectRatio", "()F", "setMViewAspectRatio", "(F)V", "mVideoAspectRatio", "getMVideoAspectRatio", "setMVideoAspectRatio", "banInnerDismiss", "getBanInnerDismiss", "setBanInnerDismiss", "startX", "startY", "mVideoId", "", "coverBitmap", "Landroid/graphics/Bitmap;", "loadCoverControllerListener", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "isMuted", "mCoverThumbUrl", "mCoverImageUrl", "getMCoverImageUrl", "()Ljava/lang/String;", "setMCoverImageUrl", "(Ljava/lang/String;)V", "mMessageId", "mVideoModel", "Lcom/larus/platform/api/IFlowVideoModel;", "videoModelString", "videoLocalPath", "videoLocalUri", "videoRemotePath", "videoRemoteCacheKey", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "parentSlideDirection", "currentPlaySourceType", "Lcom/larus/common_ui/video/VideoPlayView$PlaySourceType;", "hasTriedVideoModelFallback", "isPlaybackFallbackPending", "showCoverWhenPause", "getShowCoverWhenPause", "setShowCoverWhenPause", "forceRefreshSurface", "getForceRefreshSurface", "setForceRefreshSurface", "isSurfaceDestroyed", "mShouldBePlaying", "playRequestId", "", "lastLoggedDropRequestId", "hasPreparedSource", "logPlayback", "event", "debugOnly", "canStart", "requestId", "mMainHandler", "Landroid/os/Handler;", "mExecutingActions", "mPendingActions", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "touchSlop", "dismissOffset", "videoWidth", "getVideoWidth", "()I", "setVideoWidth", "(I)V", "videoHeight", "getVideoHeight", "setVideoHeight", "suppressRelayoutDuringTransition", "hasDeferredRelayout", "deferredVideoSize", "Lkotlin/Pair;", "mSurfaceTextureListener", "com/larus/common_ui/video/VideoPlayView$mSurfaceTextureListener$1", "Lcom/larus/common_ui/video/VideoPlayView$mSurfaceTextureListener$1;", "mProgressUpdateTask", "Lcom/larus/common_ui/video/VideoPlayView$ProgressUpdateTask;", "ignoreClick", "getIgnoreClick", "setIgnoreClick", "forceUpdateProgress", "getForceUpdateProgress", "setForceUpdateProgress", "diablePlayButton", "getDiablePlayButton", "setDiablePlayButton", "showLoadingRunable", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "afterClickCallBack", "Lcom/larus/common_ui/video/VideoPlayView$AfterClickCallBack;", "getAfterClickCallBack", "()Lcom/larus/common_ui/video/VideoPlayView$AfterClickCallBack;", "setAfterClickCallBack", "(Lcom/larus/common_ui/video/VideoPlayView$AfterClickCallBack;)V", "dismissCallback", "Lkotlin/Function0;", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "pausedByMediaOccupy", "skipAbandonFocusForMediaPause", "mediaApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "onSizeChanged", "w", "h", "oldw", "oldh", "setRelayoutSuppressedDuringTransition", "suppress", "flushDeferredRelayout", "onAttachedToWindow", "onDetachedFromWindow", "clearBackground", "bindVideoWithViewModel", "videoController", "localPath", "remotePath", "remoteCacheKey", "localUri", "bindVideoController", "isVideoContainsAudio", "initCover", "thumbUrl", "url", "height", "width", SimplayerImageStrategy.RESULT_BITMAP, "controllerListener", "messageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/Bitmap;Lcom/facebook/drawee/controller/BaseControllerListener;Ljava/lang/String;)V", "onLoadCoverImageBefore", "clearCover", "start", "videoIsMuted", "setIsMuted", "setVolumeFactor", ITTVideoEngineEventSource.KEY_VOLUME, "realStart", "playByLocalPath", "path", "playByRemotePath", "playByVideoModel", "videoModel", "resetSurfaceAndPlay", "retryStart", "getPlaySourceTypeForReport", "setVideoAspectRatio", "getCurrentPlaybackTime", "getDuration", "stop", "release", "mResumeOrPauseByUser", "getMResumeOrPauseByUser", "setMResumeOrPauseByUser", "resume", "byUser", "scene", "doResume", "pause", "setParentSlideDirection", "direction", "getParentSlideHorizontal", "getParentSlideVertical", "getParentSlideBoth", "changePlayButtonVisible", "visible", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "seekTo", "msec", "listener", "Lcom/larus/platform/api/IFlowSeekCompletionListener;", "showLoadingWithDelay", "removeLoadingAndPlayView", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "onBufferingUpdate", "block", "onPlayingProgressUpdate", "callback", "setVideoEngineCallback", "isPlaying", "isPaused", "onSingleTap", "updateProgress", "forceProgress", "(Ljava/lang/Integer;)V", "resetProgressUpdateTask", "stopProgressUpdate", "reason", "getProgressUpdateDelay", "current", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "progress", "buildVideoModelLogInfo", "buildUrlLogInfo", "showCoverView", "resetViewVisible", "fitCoverImage", "setupCoverViewParams", "buildCoverResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "config", "Lcom/larus/platform/model/chat/CreationPreviewPerformanceOptConfig;", "firstValidSize", "sizes", "", "setFallbackCoverResource", "resId", "loadCoverImage", "fitVideoSize", "fitVideoViewSize", "abandonAudioFocus", "execAction", "action", "isSurfaceValid", "enqueueAction", "execPendingActions", "clearPendingActions", "applyVideoSize", "markRelayoutDeferred", "AfterClickCallBack", "Companion", "PlaySourceType", "PlayType", "EngineListener", "ProgressUpdateTask", "GestureDetectorListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class VideoPlayView extends FrameLayout {

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final /* synthetic */ int f327971y1 = 0;
    public String A;
    public String B;
    public IVideoController C;
    public int D;
    public PlaySourceType E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean H0;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f327972J;
    public long K;
    public long L;
    public boolean L0;
    public boolean M;
    public final Handler N;
    public boolean O;
    public ArrayList<Runnable> P;
    public boolean P0;
    public final int Q;
    public final float R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public final com.larus.common_ui.video.c V0;
    public Pair<Integer, Integer> W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.common_ui.video.b f327973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f327974b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final com.larus.common_ui.video.e f327975b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Integer, Unit> f327976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f327977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n0 f327978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextureView f327979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SimpleDraweeView f327980g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public a f327981g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f327982h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public Function0<Unit> f327983h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ActivityIndicatorView f327984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Surface f327985j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f327986k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final f f327987k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f327988k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f327989l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f327990m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f327991n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f327992o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f327993p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public c f327994p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f327995p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bitmap f327996q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BaseControllerListener<Object> f327997r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f327998s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f327999t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f328000u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f328001v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final com.larus.media.model.a f328002v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public p0 f328003w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f328004x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f328005x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f328006y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f328007z;

    public static final class Companion {

        @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView$Companion$PlayStatus;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PlayStatus {
            public static final a Companion = null;
            public static final int PLAY_COMPLETE = 2;
            public static final int PLAY_FAIL = 1;
            public static final int PLAY_PAUSE = 3;
            public static final int PLAY_SUCCESS = 0;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f328008a = null;

                static {
                    f328008a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f328008a;
            }
        }

        @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView$Companion$VideoParentOrientation;", "", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface VideoParentOrientation {
            public static final a Companion = null;
            public static final int ORIENTATION_BOTH = 3;
            public static final int ORIENTATION_HORIZONTAL = 2;
            public static final int ORIENTATION_VERTICAL = 1;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ a f328009a = null;

                static {
                    f328009a = new a();
                }

                public a() {
                }
            }

            static {
                Companion = a.f328009a;
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView$PlaySourceType;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.LOCAL, "DIRECT_URL", "MODEL", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PlaySourceType extends Enum<PlaySourceType> {
        public static final PlaySourceType DIRECT_URL = null;
        public static final PlaySourceType LOCAL = null;
        public static final PlaySourceType MODEL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlaySourceType[] f328010a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f328011b = null;

        public static EnumEntries<PlaySourceType> getEntries() {
            return f328011b;
        }

        static {
            PlaySourceType r100 = new PlaySourceType(AccountType.LOCAL, 0);
            LOCAL = r100;
            PlaySourceType r101 = new PlaySourceType("DIRECT_URL", 1);
            DIRECT_URL = r101;
            PlaySourceType r102 = new PlaySourceType("MODEL", 2);
            MODEL = r102;
            PlaySourceType[] r103 = {r100, r101, r102};
            f328010a = r103;
            f328011b = EnumEntriesKt.enumEntries(r103);
        }

        public static PlaySourceType[] values() {
            return (PlaySourceType[]) f328010a.clone();
        }

        public static PlaySourceType valueOf(String r100) {
            return (PlaySourceType) r27.a.a(PlaySourceType.class, r100);
        }

        public PlaySourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/common_ui/video/VideoPlayView$PlayType;", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PlayType {
    }

    public interface a {
        void a(String r100);

        void onPause(String r100);
    }

    public static final class b implements n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<VideoPlayView> f328012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f328013b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f328014a = null;

            static {
                int[] r100 = new int[PlaySourceType.values().length];
                r100[PlaySourceType.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[PlaySourceType.DIRECT_URL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[PlaySourceType.MODEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f328014a = r100;
            }
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepare() {
        }

        @Override // com.larus.platform.api.n0
        public final void onPrepared() {
        }

        @Override // com.larus.platform.api.n0
        public final void onCompletion() {
            FLogger.f375446a.d("VideoPlayView", "onPlaybackStateChanged: onCompletion");
            VideoPlayView r100 = this.f328012a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            r100.v(2);
            r100.P(100);
            n0 r101 = r100.f327978e;
            if (r101 == null) goto L9;
            r101.onCompletion();
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void onRenderStart() {
            VideoPlayView r100 = this.f328012a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            int r101 = VideoPlayView.f327971y1;
            r100.P(null);
            r100.n();
            Function1<Integer, Unit> r102 = r100.getOnPlayStatusChanged();
            if (r102 == null) goto L8;
            r102.invoke(0);
        L8:
            n0 r103 = r100.f327978e;
            if (r103 == null) goto L11;
            r103.onRenderStart();
        L11:
            r100.getMCoverView().setVisibility(8);
            FLogger.f375446a.d("VideoPlayView", "onRenderStart");
        }

        public b(WeakReference<VideoPlayView> r100) {
            Intrinsics.checkNotNullParameter(r100, "viewRef");
            this.f328012a = r100;
        }

        public static boolean e(final VideoPlayView r110) {
            if (r110.G == false) goto L6;
            return true;
        L6:
            if (r110.f327972J == true) goto L8;
            return false;
        L8:
            PlaySourceType r100 = r110.E;
            int[] r101 = a.f328014a;
            int r102 = r101[r100.ordinal()];
            if (r102 == 1) goto L24;
            if (r102 == 2) goto L15;
            if (r102 != 3) goto L14;
        L32:
            final PlaySourceType r111 = null;
        L33:
            if (r111 != null) goto L35;
            return false;
        L35:
            PlaySourceType r103 = PlaySourceType.MODEL;
            if (r111 == r103) goto L38;
        L40:
            final PlaySourceType r112 = r110.E;
            r110.G = true;
            int r104 = r101[r112.ordinal()];
            if (r104 == 1) goto L48;
            if (r104 == 2) goto L47;
            if (r104 != 3) goto L46;
        L49:
            if (r111 != r103) goto L51;
            r110.F = true;
        L51:
            final long r105 = r110.K;
            r110.post(new o(r110, r105, r112, r111));
            return true;
        L46:
            throw new NoWhenBranchMatchedException();
        L47:
            r110.A = null;
            goto L49
        L48:
            r110.f328006y = null;
            r110.f328007z = null;
            goto L49
        L38:
            if (Intrinsics.areEqual(r110.B, "") == false) goto L40;
            return false;
        L14:
            throw new NoWhenBranchMatchedException();
        L15:
            PlaySourceType r106 = PlaySourceType.MODEL;
            if (r110.F == false) goto L18;
        L20:
            boolean r107 = false;
        L21:
            if (r107 == false) goto L32;
        L31:
            r111 = r106;
            goto L33
        L18:
            if (o0.d(r110.f328004x) == false) goto L20;
            r107 = true;
            goto L21
        L24:
            if (o0.d(r110.A) == false) goto L27;
            r106 = PlaySourceType.DIRECT_URL;
            goto L31
        L27:
            if (r110.F == true) goto L32;
            if (o0.d(r110.f328004x) == false) goto L32;
            r106 = PlaySourceType.MODEL;
            goto L31
        }

        @Override // com.larus.platform.api.n0
        public final void c(int r100) {
            VideoPlayView r101 = this.f328012a.get();
            if (r101 != null) goto L5;
            return;
        L5:
            Integer r102 = this.f328013b;
            if (r102 != null) goto L9;
        L10:
            this.f328013b = Integer.valueOf(r100);
            int r103 = VideoPlayView.f327971y1;
            r101.t("engine_state=" + r100, false);
        L11:
            if (r100 != 0) goto L13;
            int r104 = VideoPlayView.f327971y1;
            r101.O("playback stopped");
            r101.c();
        L33:
            n0 r105 = r101.f327978e;
            if (r105 == null) goto L37;
            r105.c(r100);
            return;
        L37:
            return;
        L13:
            if (r100 != 1) goto L15;
            r101.i(false);
            r101.n();
            r101.getMCoverView().setVisibility(8);
            Function1<Integer, Unit> r106 = r101.getOnPlayStatusChanged();
            if (r106 == null) goto L31;
            r106.invoke(0);
        L31:
            r101.P(null);
            boolean r107 = x19.a.f562148a;
            Intrinsics.checkNotNullParameter(r101, "videoView");
            x19.a.f562149b = r101.getCurrentPlaybackTime();
            goto L33
        L15:
            if (r100 == 2) goto L21;
            if (r100 != 3) goto L33;
            int r108 = VideoPlayView.f327971y1;
            r101.O("playback error");
            if (e(r101) == true) goto L33;
            r101.n();
            r101.v(1);
            goto L33
        L21:
            int r109 = VideoPlayView.f327971y1;
            r101.O("playback paused");
            if (r101.getShowCoverWhenPause() == false) goto L24;
            r101.f327996q = r101.getMVideoView().getBitmap();
            r101.s();
        L24:
            r101.v(3);
            if (r101.f327995p1 == false) goto L27;
            r101.f327995p1 = false;
            goto L33
        L27:
            r101.c();
            goto L33
        L9:
            if (r102.intValue() == r100) goto L11;
            goto L10
        }

        @Override // com.larus.platform.api.n0
        public final void d(int r100) {
            FLogger.f375446a.i("VideoPlayView", "onLoadStateChanged: " + r100);
            VideoPlayView r101 = this.f328012a.get();
            if (r101 != null) goto L6;
            return;
        L6:
            if (r100 != 1) goto L8;
            r101.n();
            Function1<Integer, Unit> r102 = r101.getOnPlayStatusChanged();
            if (r102 == null) goto L21;
            r102.invoke(0);
        L21:
            n0 r103 = r101.f327978e;
            if (r103 == null) goto L25;
            r103.d(r100);
            return;
        L25:
            return;
        L8:
            if (r100 != 2) goto L10;
            r101.N.removeCallbacks(r101.V0);
            r101.N.postDelayed(r101.V0, 500);
            if (NetworkUtils.isNetworkAvailable(r101.getContext()) == true) goto L21;
            t19.s r104 = t19.s.f544207a;
            Context r105 = r101.getContext();
            String r106 = r101.getContext().getResources().getString(R.string.larus_internet_connection_failed);
            r104.getClass();
            t19.s.c(r105, r106);
            goto L21
        L10:
            if (r100 != 3) goto L21;
            if (e(r101) == true) goto L21;
            r101.v(1);
            r101.n();
            goto L21
        }

        @Override // com.larus.platform.api.n0
        public final void onVideoStatusException(int r100) {
            FLogger.f375446a.d("VideoPlayView", "onVideoStatusException: " + r100);
            final VideoPlayView r101 = this.f328012a.get();
            if (r101 != null) goto L6;
            return;
        L6:
            if (e(r101) == false) goto L12;
            n0 r102 = r101.f327978e;
            if (r102 == null) goto L21;
            r102.onVideoStatusException(r100);
            return;
        L21:
            return;
        L12:
            if (r101.E != PlaySourceType.LOCAL) goto L17;
            r101.n();
            r101.v(1);
            n0 r103 = r101.f327978e;
            if (r103 == null) goto L22;
            r103.onVideoStatusException(r100);
            return;
        L22:
            return;
        L17:
            final long r104 = r101.K;
            r101.post(new n(r101, r104));
            n0 r105 = r101.f327978e;
            if (r105 == null) goto L23;
            r105.onVideoStatusException(r100);
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void a(Integer r100, Integer r101) {
            FLogger.f375446a.d("VideoPlayView", "onError: " + r100);
            VideoPlayView r102 = this.f328012a.get();
            if (r102 != null) goto L6;
            return;
        L6:
            if (e(r102) == true) goto L11;
            r102.v(1);
            n0 r103 = r102.f327978e;
            if (r103 == null) goto L10;
            r103.a(r100, r101);
        L10:
            r102.n();
            return;
        L11:
            n0 r104 = r102.f327978e;
            if (r104 == null) goto L16;
            r104.a(r100, r101);
            return;
        }

        @Override // com.larus.platform.api.n0
        public final void b(final Integer r100, final Integer r101) {
            final VideoPlayView r102 = this.f328012a.get();
            if (r102 != null) goto L5;
            return;
        L5:
            if (r100 == null) goto L8;
            if (r101 == null) goto L8;
            r102.post(new p(r102, r100, r101));
        L8:
            n0 r103 = r102.f327978e;
            if (r103 == null) goto L12;
            r103.b(r100, r101);
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final VideoPlayView f328015a;

        @Override // java.lang.Runnable
        public final void run() {
            VideoPlayView r100 = this.f328015a;     // Catch: Throwable -> L4
            int r101 = VideoPlayView.f327971y1;     // Catch: Throwable -> L4
            r100.P(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(VideoPlayView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f328015a = r100;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328016a = null;

        static {
            int[] r100 = new int[PlaySourceType.values().length];
            r100[PlaySourceType.DIRECT_URL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PlaySourceType.LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PlaySourceType.MODEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f328016a = r100;
        }
    }

    public static final class e extends BaseControllerListener<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f328017a;

        public e(VideoPlayView r100) {
            this.f328017a = r100;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFailure(String r100, Throwable r101) {
            super.onFailure(r100, r101);
            FLogger.f375446a.e("VideoPlayView", "[loadCoverImage] fail " + VideoPlayView.f(this.f328017a.getMCoverImageUrl()));
            this.f328017a.getMCoverView().setVisibility(8);
            BaseControllerListener<Object> r102 = this.f328017a.f327997r;
            if (r102 == null) goto L6;
            r102.onFailure(r100, r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onIntermediateImageSet(String r100, Object r101) {
            super.onIntermediateImageSet(r100, r101);
            BaseControllerListener<Object> r102 = this.f328017a.f327997r;
            if (r102 == null) goto L6;
            r102.onIntermediateImageSet(r100, r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onSubmit(String r100, Object r101) {
            super.onSubmit(r100, r101);
            BaseControllerListener<Object> r102 = this.f328017a.f327997r;
            if (r102 == null) goto L6;
            r102.onSubmit(r100, r101);
            return;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, r101, r102);
            BaseControllerListener<Object> r103 = this.f328017a.f327997r;
            if (r103 == null) goto L5;
            r103.onFinalImageSet(r100, r101, r102);
        L5:
            FLogger.f375446a.i("VideoPlayView", "[loadCoverImage] success " + VideoPlayView.f(this.f328017a.getMCoverImageUrl()));
        }
    }

    public static final class f implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f328018a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
        }

        public f(VideoPlayView r100) {
            this.f328018a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            r100.release();
            Surface r101 = this.f328018a.f327985j;
            if (r101 == null) goto L5;
            r101.release();
        L5:
            VideoPlayView r102 = this.f328018a;
            r102.f327985j = null;
            r102.getClass();
            this.f328018a.t("surface_destroyed", true);
            IVideoController r103 = this.f328018a.C;
            if (r103 == null) goto L8;
            r103.releaseSurface();
        L8:
            this.f328018a.s();
            FLogger.f375446a.d("VideoPlayView", "[" + this.f328018a.hashCode() + "], onSurfaceTextureDestroyed, vid: " + this.f328018a.f327993p);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "surface");
            VideoPlayView r103 = this.f328018a;
            int r104 = VideoPlayView.f327971y1;
            Surface r105 = r103.f327985j;
            if (r105 != null) goto L5;
        L7:
            boolean r106 = false;
        L8:
            if (r106 == true) goto L10;
        L11:
            FLogger.f375446a.d("VideoPlayView", "[" + this.f328018a.hashCode() + "], mSurface bind, vid: " + this.f328018a.f327993p);
            this.f328018a.f327985j = new Surface(r100);
        L12:
            this.f328018a.getClass();
            this.f328018a.t("surface_available", true);
            VideoPlayView r107 = this.f328018a;
            IVideoController r108 = r107.C;
            if (r108 != null) goto L15;
        L17:
            VideoPlayView r109 = this.f328018a;
            if (r109.O == true) goto L32;
            ArrayList<Runnable> r110 = r109.P;
            if (r110 == null) goto L29;
            r109.O = true;
            Iterator r111 = new ArrayList(r110).iterator();
        L24:
            if (r111.hasNext() == false) goto L26;
            ((Runnable) r111.next()).run();
            goto L24
        L26:
            ArrayList<Runnable> r112 = r109.P;
            if (r112 == null) goto L29;
            r112.clear();
        L29:
            r109.O = false;
            return;
        L32:
            return;
        L15:
            if (r107.f327972J == false) goto L17;
            r108.setSurface(r107.f327985j);
            goto L17
        L10:
            if (this.f328018a.getForceRefreshSurface() == false) goto L12;
        L5:
            if (r105.isValid() != true) goto L7;
            r106 = true;
            goto L8
        }
    }

    public static final class g implements com.larus.media.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ValueAnimator f328019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f328020b;

        public g(VideoPlayView r100) {
            this.f328020b = r100;
        }

        @Override // com.larus.media.v
        public final boolean b(lk9.g r100) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            if (Intrinsics.areEqual(r100.getScene(), MediaScene.TTS_SAMPLE) == false) goto L6;
            return true;
        L6:
            return false;
        }

        @Override // com.larus.media.v
        public final void e(lk9.g r100) {
            com.larus.media.v.a.d(r100);
        }

        @Override // com.larus.media.v
        public final void f(MediaResourceManager.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // com.larus.media.v
        public final void a(lk9.g r100, final float r101) {
            Intrinsics.checkNotNullParameter(r100, "applicant");
            final VideoPlayView r102 = this.f328020b;
            r102.N.post(new s(r102, r101, this));
            com.larus.media.v.a.f(r100, r101);
        }

        @Override // com.larus.media.v
        public final void d(lk9.g r100, lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            com.larus.media.v.a.c(r100, r101);
            final VideoPlayView r102 = this.f328020b;
            r102.N.post(new r(r102, this));
        }

        @Override // com.larus.media.v
        public final void g(lk9.g r100, float r101) {
            com.larus.media.v.a.g(r100, r101);
        }

        @Override // com.larus.media.v
        public final void i(lk9.g r100, final lk9.g r101) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            com.larus.media.v.a.e(r100, r101);
            final VideoPlayView r102 = this.f328020b;
            final long r103 = r102.K;
            r102.N.post(new q(r102, r103, r101));
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy c(lk9.g r100, lk9.g r101, int r102) {
            return com.larus.media.v.a.a(this, r100, r101, r102);
        }

        @Override // com.larus.media.v
        public final MediaOccupyStrategy h(lk9.g r100, lk9.g r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "current");
            Intrinsics.checkNotNullParameter(r101, "applicant");
            return MediaOccupyStrategy.PAUSE;
        }
    }

    public static final class h implements l4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlayView f328021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f328022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IVideoController f328023c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f328024d;

        @Override // com.larus.platform.api.l4
        public final void a(String r100, com.larus.video.impl.sdk.a r101) {
            VideoPlayView r102 = this.f328021a;
            long r103 = this.f328022b;
            int r104 = VideoPlayView.f327971y1;
            if (r102.h(r103) == false) goto L21;
            IVideoController r105 = this.f328023c;
            VideoPlayView r106 = this.f328021a;
            if (r105 != r106.C) goto L25;
            StringBuilder r107 = new StringBuilder("model_ready success=");
            if (r101 == null) goto L10;
            boolean r108 = true;
        L11:
            r107.append(r108);
            r106.t(r107.toString(), false);
            if (Intrinsics.areEqual(r100, this.f328024d) == true) goto L14;
            return;
        L14:
            if (Intrinsics.areEqual(r100, this.f328021a.f328004x) == false) goto L23;
            if (r101 == null) goto L24;
            VideoPlayView r109 = this.f328021a;
            IVideoController r110 = r109.C;
            if (r110 == null) goto L19;
            r110.j(r101, true);
        L19:
            r109.f328003w = r101;
            FLogger.f375446a.i("VideoPlayView", "[resetSurfaceAndPlay]");
            r109.G();
            return;
        L24:
            return;
        L23:
            return;
        L10:
            r108 = false;
            goto L11
        L25:
            return;
        }

        public h(VideoPlayView r100, long r101, IVideoController r102, String r103) {
            this.f328021a = r100;
            this.f328022b = r101;
            this.f328023c = r102;
            this.f328024d = r103;
        }
    }

    static {
    }

    public VideoPlayView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VideoPlayView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void G() {
        t("engine_play", false);
        this.M = true;
        IVideoController r100 = this.C;
        if (r100 == null) goto L5;
        r100.setSurface(this.f327985j);
    L5:
        IVideoController r101 = this.C;
        if (r101 == null) goto L8;
        r101.p(new b(new WeakReference(this)));
    L8:
        IVideoController r102 = this.C;
        if (r102 == null) goto L12;
        r102.play();
        return;
    }

    public final void I() {
        t("retry_start", false);
        if (r() == false) goto L5;
        return;
    L5:
        this.K++;
        this.f327972J = true;
        this.N.removeCallbacks(this.V0);
        this.N.postDelayed(this.V0, 1000);
        IVideoController r100 = this.C;
        if (r100 == null) goto L8;
        r100.stop();
    L8:
        p0 r101 = this.f328003w;
        if (r101 == null) goto L13;
        this.E = PlaySourceType.MODEL;
        IVideoController r102 = this.C;
        if (r102 == null) goto L13;
        r102.j(r101, true);
    L13:
        IVideoController r103 = this.C;
        if (r103 == null) goto L17;
        r103.play();
        return;
    }

    public void u() {
    }

    private final boolean getParentSlideBoth() {
        if ((this.D & 3) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getParentSlideHorizontal() {
        if ((this.D & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getParentSlideVertical() {
        if ((this.D & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void E() {
        removeView(this.f327984i);
        removeView(this.f327982h);
    }

    public final void F() {
        c r100 = this.f327994p0;
        O(BasicTestActionHandler.TEST_ACTION_RESET);
        Integer r101 = null;
        if (this.f327976c != null) goto L9;
        this.f327994p0 = null;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[progressUpdate] reset skip no listener, view:");
        r103.append(hashCode());
        r103.append(", source:");
        r103.append(this.E);
        r103.append(", oldTask:");
        if (r100 == null) goto L7;
        r101 = Integer.valueOf(r100.hashCode());
    L7:
        r103.append(r101);
        r102.i("VideoPlayView", r103.toString());
        return;
    L9:
        this.f327994p0 = new c(this);
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("[progressUpdate] reset, view:");
        r105.append(hashCode());
        r105.append(", source:");
        r105.append(this.E);
        r105.append(", oldTask:");
        if (r100 == null) goto L12;
        Integer r106 = Integer.valueOf(r100.hashCode());
    L13:
        r105.append(r106);
        r105.append(", newTask:");
        c r107 = this.f327994p0;
        if (r107 == null) goto L16;
        r101 = Integer.valueOf(r107.hashCode());
    L16:
        r105.append(r101);
        r104.i("VideoPlayView", r105.toString());
        return;
    L12:
        r106 = null;
        goto L13
    }

    public final void K() {
        if (this.f327973a != null) goto L11;
        FLogger.f375446a.i("VideoPlayView", "init displayMode DISPLAY_MODE_ASPECT_FIT");
        com.larus.common_ui.video.b r100 = new com.larus.common_ui.video.b();
        this.f327973a = r100;
        r100.f328029d = this;
        r100.a();
        com.larus.common_ui.video.b r101 = this.f327973a;
        if (r101 == null) goto L7;
        r101.f328028c = 4;
        r101.a();
    L7:
        com.larus.common_ui.video.b r102 = this.f327973a;
        if (r102 == null) goto L12;
        r102.f328030e = this.f327979f;
        r102.a();
        return;
    L12:
        return;
    }

    public void L() {
        if (this.f327979f.getWidth() != 0) goto L5;
    L7:
        int r100 = getWidth();
        float r101 = getWidth() / this.f327989l;
        if (Float.isNaN(r101) == false) goto L10;
        r101 = 0.0f;
    L10:
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(r100, MathKt.roundToInt(r101));
        r102.gravity = 17;
        this.f327980g.setLayoutParams(r102);
        return;
    L5:
        if (this.f327979f.getHeight() == 0) goto L7;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(this.f327979f.getWidth(), this.f327979f.getHeight());
        r103.gravity = 17;
        this.f327980g.setLayoutParams(r103);
    }

    public final void M() {
        final long r100 = this.K + 1;
        this.K = r100;
        this.f327972J = true;
        t("start_request", false);
        if (this.f327998s == false) goto L6;
        long r101 = this.K;
        t("start_source", false);
        this.N.postDelayed(this.V0, 1000);
        j(new m(this, r101));
        return;
    L6:
        Lazy r102 = MediaResourceManager.f358950a;
        MediaResourceManager.m(this.f328002v1, new k(this, r100), new l(this, r100), 0, 8);
    }

    public final void N() {
        this.K++;
        this.f327972J = false;
        this.M = false;
        t("stop", false);
        this.f327988k1 = false;
        this.f327995p1 = false;
        ArrayList<Runnable> r100 = this.P;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        this.O = false;
        O("stop");
        IVideoController r101 = null;
        this.N.removeCallbacksAndMessages(null);
        this.f327994p0 = null;
        IVideoController r102 = this.C;
        if (r102 == null) goto L8;
        r102.l();
    L8:
        IVideoController r103 = this.C;
        if (r103 != null) goto L11;
    L15:
        c();
        return;
    L11:
        if (r103.isReleased() == true) goto L13;
        r101 = r103;
    L13:
        if (r101 == null) goto L15;
        r101.stop();
        goto L15
    }

    public final void c() {
        if (this.f327998s == false) goto L5;
        return;
    L5:
        t("focus_abandon applicant=" + this.f328002v1.hashCode(), false);
        Lazy r100 = MediaResourceManager.f358950a;
        MediaResourceManager.a(this.f328002v1);
    }

    public final long getCurrentPlaybackTime() {
        IVideoController r100 = this.C;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurrentPlaybackTime();
    }

    public final long getDuration() {
        IVideoController r100 = this.C;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.n();
    }

    public final String getPlaySourceTypeForReport() {
        PlaySourceType r100 = this.E;
        int r101 = d.f328016a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "direct_url";
    L5:
        if (r101 != 2) goto L7;
    L11:
        return DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL;
    L7:
        if (r101 == 3) goto L11;
        throw new NoWhenBranchMatchedException();
    }

    public void m() {
        boolean r100 = true;
        if (this.U == false) goto L6;
        this.V = true;
        return;
    L6:
        com.larus.common_ui.video.b r101 = this.f327973a;
        FrameLayout.LayoutParams r102 = null;
        if (r101 == null) goto L9;
        Integer r103 = Integer.valueOf(r101.f328028c);
    L10:
        float r104 = getHeight();
        float r105 = getWidth();
        float r106 = r105 / RangesKt.coerceAtLeast(r104, 1.0f);
        if (r103 == null) goto L26;
        if (r103.intValue() != 4) goto L26;
        l(-1, -1);
        ViewGroup.LayoutParams r107 = this.f327979f.getLayoutParams();
        if ((r107 instanceof FrameLayout.LayoutParams) == false) goto L18;
        r102 = (FrameLayout.LayoutParams) r107;
    L18:
        if (r102 == null) goto L20;
        r102.gravity = 17;
    L20:
        if (r102 == null) goto L22;
        r102.width = -1;
    L22:
        if (r102 == null) goto L24;
        r102.height = -1;
    L24:
        this.f327979f.setLayoutParams(r102);
        return;
    L26:
        if (r103 == null) goto L51;
        if (r103.intValue() != 3) goto L51;
        float r108 = this.f327989l;
        if (r108 == 0.0f) goto L34;
        r100 = false;
    L34:
        if (r100 == false) goto L37;
        return;
    L37:
        if (r108 < r106) goto L39;
        r104 = r105 / r108;
    L40:
        ViewGroup.LayoutParams r109 = this.f327979f.getLayoutParams();
        if ((r109 instanceof FrameLayout.LayoutParams) == false) goto L43;
        r102 = (FrameLayout.LayoutParams) r109;
    L43:
        if (r102 == null) goto L45;
        r102.gravity = 17;
    L45:
        if (r102 == null) goto L47;
        r102.width = (int) r105;
    L47:
        if (r102 == null) goto L49;
        r102.height = (int) r104;
    L49:
        this.f327979f.setLayoutParams(r102);
        return;
    L39:
        r105 = r104 * r108;
    L51:
        if (this.f327986k != 0.0f) goto L53;
        boolean r110 = true;
    L54:
        if (r110 == true) goto L86;
        float r111 = this.f327989l;
        if (r111 == 0.0f) goto L59;
        r100 = false;
    L59:
        if (r100 == false) goto L62;
        return;
    L62:
        if (r111 < 1.0f) goto L65;
    L63:
        float r112 = r105 / r111;
        float r113 = r105;
    L72:
        ViewGroup.LayoutParams r114 = this.f327979f.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r114;
        if (Float.isNaN(r113) == false) goto L76;
        r113 = r105;
    L76:
        if (Float.isNaN(r112) == false) goto L78;
        r112 = r104;
    L78:
        int r116 = RangesKt.coerceAtMost(MathKt.roundToInt(r113), (int) r105);
        int r117 = RangesKt.coerceAtMost(MathKt.roundToInt(r112), (int) r104);
        l(r116, r117);
        FLogger.f375446a.d("VideoPlayView", "containerRatio:" + r106 + ", videoRatio:" + this.f327989l + "\ncontainerHeight:" + r104 + ",containerWidth:" + r105 + "\ndisplayHeight:" + r117 + ",displayWidth:" + r116);
        if (r115.height == r117) goto L81;
    L82:
        r115.gravity = 17;
        r115.width = r116;
        r115.height = r117;
        this.f327979f.setLayoutParams(r115);
        this.S = r116;
        this.T = r117;
        return;
    L81:
        if (r115.width != r116) goto L82;
        return;
    L65:
        if (r111 >= 1.0f) goto L70;
        if (r111 >= r106) goto L70;
        r113 = r111 * r104;
        r112 = r104;
    L70:
        if (r111 >= 1.0f) goto L63;
        int r118 = (r111 > r106 ? 1 : (r111 == r106 ? 0 : -1));
        goto L63
    L86:
        return;
    L53:
        r110 = false;
        goto L54
    L9:
        r103 = null;
        goto L10
    }

    public final void n() {
        this.N.removeCallbacks(this.V0);
        this.f327984i.setVisibility(8);
    }

    public final boolean q() {
        IVideoController r100 = this.C;
        if (r100 == null) goto L5;
        IVideoController.PlayType r101 = r100.d();
    L7:
        if (r101 != IVideoController.PlayType.PAUSE) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean r() {
        IVideoController r100 = this.C;
        if (r100 == null) goto L5;
        IVideoController.PlayType r101 = r100.d();
    L7:
        if (r101 != IVideoController.PlayType.PLAY) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.common_ui.video.j] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void s() {
        if (this.f328000u == null) goto L15;
        L();
        GenericDraweeHierarchy r100 = GenericDraweeHierarchyBuilder.newInstance(getResources()).build();
        this.f327980g.setHierarchy(r100);
        Bitmap r101 = this.f327996q;
        if (r101 == null) goto L7;
        this.f327980g.setImageBitmap(r101);
    L14:
        this.f327980g.setVisibility(0);
        return;
    L7:
        ImageDecodeOptions r102 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        String r103 = this.f327999t;
        if (r103 == null) goto L12;
        Uri r104 = b0.a(r103, "chat.video_cover.thumb", false, false, 6);
        if (r104 == null) goto L12;
        ImageRequestBuilder r105 = ImageRequestBuilder.newBuilderWithSource(r104);
        r105.setResizeOptions(new ResizeOptions(i5.B(), i5.B()));
        final ImageRequest r106 = r105.setImageDecodeOptions(r102).build();
    L13:
        CommonUIMessageImageLoader.f312707a.a(this.f328001v, CommonUIMessageImageType.VIDEO, this.f327980g, this.f328000u, "chat.video_cover", null, new j(r106, this));
    L12:
        r106 = null;
        goto L13
    L15:
        this.f327980g.setVisibility(8);
    }

    public final void x() {
        FLogger.f375446a.d("VideoPlayView", "[onSingleTap]");
        if (this.H0 == false) goto L6;
        return;
    L6:
        if (this.f327972J == false) goto L8;
    L16:
        z(this, 2, 1);
        a r100 = this.f327981g1;
        if (r100 == null) goto L23;
        r100.onPause(this.f327993p);
        return;
    L23:
        return;
    L8:
        if (r() == true) goto L16;
        if (q() == false) goto L15;
        H(this, 2, 1);
        a r101 = this.f327981g1;
        if (r101 == null) goto L20;
        r101.a(this.f327993p);
        return;
    L20:
        return;
    L15:
        M();
    }

    public final void D() {
        N();
        t("release", false);
        IVideoController r100 = this.C;
        if (r100 == null) goto L5;
        r100.l();
    L5:
        IVideoController r101 = this.C;
        if (r101 == null) goto L9;
        r101.release();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.f327975b1);
        t(LynxViewpagerItem.BIND_ON_ATTACH, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.f327975b1);
        t("detach", true);
        com.larus.common_ui.video.b r100 = this.f327973a;
        if (r100 == null) goto L7;
        View r101 = r100.f328030e;
        if (r101 == null) goto L7;
        r101.removeCallbacks(r100.f328031f);
    L7:
        N();
    }

    public final a getAfterClickCallBack() {
        return this.f327981g1;
    }

    public final boolean getBanInnerDismiss() {
        return this.f327990m;
    }

    public final boolean getDiablePlayButton() {
        return this.P0;
    }

    public final Function0<Unit> getDismissCallback() {
        return this.f327983h1;
    }

    public final com.larus.common_ui.video.b getDisplayMode() {
        return this.f327973a;
    }

    public final boolean getEnableCreationPreviewCoverLoadOpt() {
        return this.f327974b;
    }

    public final boolean getForceRefreshSurface() {
        return this.I;
    }

    public final boolean getForceUpdateProgress() {
        return this.L0;
    }

    public final boolean getIgnoreClick() {
        return this.H0;
    }

    public final String getMCoverImageUrl() {
        return this.f328000u;
    }

    public final SimpleDraweeView getMCoverView() {
        return this.f327980g;
    }

    public final boolean getMResumeOrPauseByUser() {
        return this.f328005x1;
    }

    public final float getMVideoAspectRatio() {
        return this.f327989l;
    }

    public final TextureView getMVideoView() {
        return this.f327979f;
    }

    public final float getMViewAspectRatio() {
        return this.f327986k;
    }

    public final Function1<Integer, Unit> getOnPlayStatusChanged() {
        return this.f327977d;
    }

    public final boolean getShowCoverWhenPause() {
        return this.H;
    }

    public final int getVideoHeight() {
        return this.T;
    }

    public final int getVideoWidth() {
        return this.S;
    }

    public static String f(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return "null";
    L12:
        return "hash:" + r100.hashCode() + ", length:" + r100.length();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static String g(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L22;
        return "null";
    L22:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L14
        JSONObject r103 = new JSONObject(r100);     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl("videoId:" + r103.optString("video_id") + ", duration:" + r103.optDouble("video_duration") + ", length:" + r100.length());     // Catch: Throwable -> L14
    L17:
        if (Result.m9452exceptionOrNullimpl(r104) == null) goto L21;
        r104 = "parseFail,length:" + r100.length();
    L21:
        return (String) r104;
    L14:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static int k(int... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        int r103 = r100[r102];
        boolean r104 = true;
        if (r103 > 1) goto L8;
        r104 = false;
    L8:
        if (r104 == true) goto L9;
        r102 = r102 + 1;
        goto L3
    L9:
        Integer r105 = Integer.valueOf(r103);
    L12:
        if (r105 != null) goto L14;
        return 0;
    L14:
        return r105.intValue();
    L11:
        r105 = null;
        goto L12
    }

    private final void setVolumeFactor(float r100) {
        if (this.f327998s == false) goto L5;
        return;
    L5:
        IVideoController r101 = this.C;
        if (r101 == null) goto L9;
        r101.c(r100);
        return;
    }

    public final void A(String r100) {
        FLogger.f375446a.i("VideoPlayView", "[playByLocalPath] path:".concat(r100));
        this.E = PlaySourceType.LOCAL;
        F();
        IVideoController r101 = this.C;
        if (r101 == null) goto L5;
        r101.setLocalURL(r100);
    L5:
        G();
    }

    public final void B(String r100) {
        FLogger.f375446a.i("VideoPlayView", "[playByRemotePath] path:" + f(r100));
        this.E = PlaySourceType.DIRECT_URL;
        F();
        IVideoController r101 = this.C;
        if (r101 == null) goto L5;
        r101.r(r100);
    L5:
        IVideoController r102 = this.C;
        if (r102 == null) goto L11;
        String r103 = this.B;
        if (r103 != null) goto L10;
        int r104 = d7.f552459a;
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        r103 = StringsKt.padStart(new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(r100.getBytes(Charsets.UTF_8))).toString(16), 64, '0');
    L10:
        r102.setDirectUrlUseDataLoader(r100, r103);
    L11:
        G();
    }

    public final void C(String r100) {
        FLogger.f375446a.i("VideoPlayView", "[playByVideoModel] videoModel:" + g(r100));
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        this.E = PlaySourceType.MODEL;
        F();
        long r102 = this.K;
        IVideoController r103 = this.C;
        if (r103 == null) goto L12;
        r103.f(r100, new h(this, r102, r103, r100));
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void J(int r100) {
        IVideoController r101 = this.C;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.d() == IVideoController.PlayType.PLAY) goto L7;
        r101.play();
    L7:
        r101.A(r100, null);
    }

    public final void O(String r100) {
        c r101 = this.f327994p0;
        if (r101 == null) goto L12;
        removeCallbacks(r101);
        if (Intrinsics.areEqual(r100, BasicTestActionHandler.TEST_ACTION_RESET) == true) goto L13;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[progressUpdate] stop, reason:");
        r103.append(r100);
        r103.append(", view:");
        r103.append(hashCode());
        r103.append(", task:");
        r103.append(r101.hashCode());
        r103.append(", playStatus:");
        IVideoController r104 = this.C;
        if (r104 == null) goto L9;
        IVideoController.PlayType r105 = r104.d();
    L10:
        r103.append(r105);
        r103.append(", source:");
        r103.append(this.E);
        r102.i("VideoPlayView", r103.toString());
        return;
    L9:
        r105 = null;
        goto L10
    L13:
        return;
    }

    public final void P(Integer r110) {
        IVideoController.PlayType r100 = null;
        boolean r101 = true;
        int r102 = 0;
        if (this.f327976c != null) goto L13;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("[progressUpdate] skip no listener, view:");
        r104.append(hashCode());
        r104.append(", forceArg:");
        if (r110 != null) goto L8;
        r101 = false;
    L8:
        r104.append(r101);
        r104.append(", playStatus:");
        IVideoController r111 = this.C;
        if (r111 == null) goto L11;
        r100 = r111.d();
    L11:
        r104.append(r100);
        r103.d("VideoPlayView", r104.toString());
        O("no listener");
        return;
    L13:
        c r105 = this.f327994p0;
        if (r105 != null) goto L18;
        F();
        r105 = this.f327994p0;
        if (r105 != null) goto L18;
        return;
    L18:
        if (r110 == null) goto L20;
    L23:
        long r106 = getCurrentPlaybackTime();
        long r107 = getDuration();
        if (this.L0 == true) goto L28;
        r110 = null;
    L28:
        if (r107 == 0) goto L33;
        if (r110 == null) goto L32;
        r102 = r110.intValue();
        goto L33
    L32:
        r102 = (int) ((((long) 100) * r106) / r107);
    L33:
        Function1<? super Integer, Unit> r112 = this.f327976c;
        if (r112 == null) goto L37;
        r112.invoke(Integer.valueOf(r102));
    L37:
        if (r() == false) goto L45;
        if (r107 > 0) goto L40;
        long r108 = 500;
    L43:
        removeCallbacks(r105);
        postDelayed(r105, r108);
        return;
    L40:
        if (r102 < 100) goto L42;
        r108 = 30;
        goto L43
    L42:
        r108 = RangesKt.coerceIn((((((long) (r102 + 1)) * r107) + 99) / 100) - r106, 30, 500);
        goto L43
    L45:
        return;
    L20:
        if (r() == true) goto L23;
        O("not playing");
    }

    public final boolean h(long r100) {
        if (r100 == this.K) goto L5;
    L14:
        boolean r101 = false;
    L15:
        if (r101 == true) goto L19;
        long r102 = this.L;
        long r103 = this.K;
        if (r102 == r103) goto L19;
        this.L = r103;
        t("drop_start callbackRequest=" + r100, false);
    L19:
        return r101;
    L5:
        if (this.f327972J == false) goto L14;
        IVideoController r104 = this.C;
        r101 = true;
        if (r104 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == false) goto L14;
    L9:
        if (r104.isReleased() == true) goto L11;
        r105 = true;
        goto L12
    }

    public final void i(boolean r100) {
        ImageView r101 = this.f327982h;
        if (r100 == true) goto L5;
    L7:
        int r102 = 8;
    L8:
        r101.setVisibility(r102);
        return;
    L5:
        if (this.P0 == true) goto L7;
        r102 = 0;
        goto L8
    }

    public final void j(Runnable r100) {
        Surface r101 = this.f327985j;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isValid() != true) goto L7;
    L8:
        if (r102 == false) goto L11;
        r100.run();
        return;
    L11:
        if (this.P != null) goto L13;
        this.P = new ArrayList();
    L13:
        ArrayList<Runnable> r103 = this.P;
        if (r103 == null) goto L16;
        r103.add(r100);
    L16:
        FLogger r104 = FLogger.f375446a;
        r104.d("VideoPlayView", "[" + hashCode() + "], enqueueAction, vid: " + this.f327993p);
        if (this.f327979f.isAvailable() == false) goto L23;
        r104.d("VideoPlayView", "[" + hashCode() + "], mVideoView isAvailable, vid: " + this.f327993p);
        SurfaceTexture r105 = this.f327979f.getSurfaceTexture();
        if (r105 == null) goto L24;
        this.f327987k0.onSurfaceTextureAvailable(r105, this.f327979f.getWidth(), this.f327979f.getHeight());
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f327990m == true) goto L5;
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L9;
        this.f327991n = r100.getX();
        this.f327992o = r100.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L40:
        return super.onInterceptTouchEvent(r100);
    L9:
        if (r101 != 1) goto L11;
    L37:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L40
    L11:
        if (r101 != 2) goto L13;
        float r102 = r100.getX() - this.f327991n;
        float r103 = r100.getY() - this.f327992o;
        if (Math.abs(r103) > this.Q) goto L18;
    L22:
        boolean r104 = false;
    L24:
        if (Math.abs(r102) > this.Q) goto L26;
    L30:
        boolean r105 = false;
    L31:
        if (r104 == true) goto L35;
        if (r105 == true) goto L35;
        getParent().requestDisallowInterceptTouchEvent(false);
    L35:
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L26:
        if (Math.abs(r102) <= Math.abs(r103)) goto L30;
        if (this.D != 1) goto L30;
        r105 = true;
        goto L31
    L18:
        if (Math.abs(r103) <= Math.abs(r102)) goto L22;
        if (this.D != 0) goto L22;
        r104 = true;
        goto L24
    L13:
        if (r101 == 3) goto L37;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f327990m == false) goto L7;
        return super.onTouchEvent(r100);
    L7:
        if (r100.getActionMasked() != 2) goto L47;
        float r101 = r100.getX() - this.f327991n;
        float r102 = r100.getY() - this.f327992o;
        getParentSlideBoth();
        boolean r103 = false;
        if (Math.abs(r102) > this.Q) goto L11;
    L15:
        boolean r104 = false;
    L17:
        if (Math.abs(r101) > this.Q) goto L19;
    L23:
        boolean r105 = false;
    L24:
        if (r104 == true) goto L28;
        if (r105 == true) goto L28;
        getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        getParent().requestDisallowInterceptTouchEvent(true);
        float r106 = this.R;
        if (r102 > r106) goto L31;
    L33:
        boolean r107 = false;
    L35:
        if (r101 > r106) goto L37;
    L39:
        if (r107 == true) goto L41;
        if (r103 == true) goto L41;
    L45:
        return true;
    L41:
        Function0<Unit> r108 = this.f327983h1;
        if (r108 == null) goto L44;
        r108.invoke();
    L44:
        this.H0 = true;
        goto L45
    L37:
        if (this.D != 1) goto L39;
        r103 = true;
        goto L39
    L31:
        if (this.D != 0) goto L33;
        r107 = true;
        goto L35
    L19:
        if (Math.abs(r101) <= Math.abs(r102)) goto L23;
        if (this.D != 1) goto L23;
        r105 = true;
        goto L24
    L11:
        if (Math.abs(r102) <= Math.abs(r101)) goto L15;
        if (this.D != 0) goto L15;
        r104 = true;
    L47:
        return super.onTouchEvent(r100);
    }

    public final void setAfterClickCallBack(a r100) {
        this.f327981g1 = r100;
    }

    public final void setBanInnerDismiss(boolean r100) {
        this.f327990m = r100;
    }

    public final void setDiablePlayButton(boolean r100) {
        this.P0 = r100;
    }

    public final void setDismissCallback(Function0<Unit> r100) {
        this.f327983h1 = r100;
    }

    public final void setEnableCreationPreviewCoverLoadOpt(boolean r100) {
        this.f327974b = r100;
    }

    public final void setFallbackCoverResource(int r100) {
        L();
        GenericDraweeHierarchyBuilder r101 = GenericDraweeHierarchyBuilder.newInstance(getResources());
        r101.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchy r102 = r101.build();
        this.f327980g.setHierarchy(r102);
        this.f327980g.setActualImageResource(r100);
        this.f327980g.setVisibility(0);
    }

    public final void setForceRefreshSurface(boolean r100) {
        this.I = r100;
    }

    public final void setForceUpdateProgress(boolean r100) {
        this.L0 = r100;
    }

    public final void setIgnoreClick(boolean r100) {
        this.H0 = r100;
    }

    public final void setIsMuted(boolean r100) {
        this.f327998s = r100;
        IVideoController r101 = this.C;
        if (r101 == null) goto L6;
        r101.C(r100);
        return;
    }

    public final void setMCoverImageUrl(String r100) {
        this.f328000u = r100;
    }

    public final void setMResumeOrPauseByUser(boolean r100) {
        this.f328005x1 = r100;
    }

    public final void setMVideoAspectRatio(float r100) {
        this.f327989l = r100;
    }

    public final void setMVideoView(TextureView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f327979f = r100;
    }

    public final void setMViewAspectRatio(float r100) {
        this.f327986k = r100;
    }

    public final void setOnPlayStatusChanged(Function1<? super Integer, Unit> r100) {
        this.f327977d = r100;
    }

    public final void setParentSlideDirection(int r100) {
        this.D = r100;
    }

    public final void setRelayoutSuppressedDuringTransition(boolean r100) {
        if (this.U != r100) goto L5;
        return;
    L5:
        this.U = r100;
        if (r100 == false) goto L8;
        return;
    L8:
        if (this.V == false) goto L10;
    L12:
        Pair<Integer, Integer> r101 = this.W;
        this.V = false;
        this.W = null;
        if (r101 == null) goto L21;
        int r102 = r101.component1().intValue();
        int r103 = r101.component2().intValue();
        if (r102 == 0) goto L18;
        if (r103 == 0) goto L18;
        this.f327989l = r102 / r103;
    L18:
        m();
        L();
        com.larus.common_ui.video.b r104 = this.f327973a;
        if (r104 == null) goto L26;
        r104.f328026a = r102;
        r104.f328027b = r103;
        r104.a();
        return;
    L26:
        return;
    L21:
        m();
        com.larus.common_ui.video.b r105 = this.f327973a;
        if (r105 == null) goto L28;
        r105.a();
        return;
    L28:
        return;
    L10:
        if (this.W != null) goto L12;
    }

    public final void setShowCoverWhenPause(boolean r100) {
        this.H = r100;
    }

    public final void setVideoEngineCallback(n0 r100) {
        this.f327978e = r100;
    }

    public final void setVideoHeight(int r100) {
        this.T = r100;
    }

    public final void setVideoWidth(int r100) {
        this.S = r100;
    }

    public final void v(int r100) {
        Function1<? super Integer, Unit> r101 = this.f327977d;
        if (r101 == null) goto L6;
        r101.invoke(Integer.valueOf(r100));
        return;
    }

    public final void w(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f327976c = r100;
        if (this.f327994p0 != null) goto L10;
        if (this.f327972J == false) goto L7;
    L8:
        F();
        goto L10
    L7:
        if (r() == true) goto L8;
    L10:
        if (r() == false) goto L13;
        P(null);
        return;
    }

    public static final /* synthetic */ void d(VideoPlayView r100, float r101) {
        r100.setVolumeFactor(r101);
    }

    public void l(int r100, int r101) {
        boolean r102 = true;
        if (this.f327986k != 0.0f) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        if (this.f327989l == 0.0f) goto L11;
        r102 = false;
    L11:
        if (r102 == false) goto L13;
        return;
    L13:
        if (this.f327980g.getVisibility() != 0) goto L23;
        ImageView.ScaleType r104 = ImageView.ScaleType.FIT_CENTER;
        ViewGroup.LayoutParams r105 = this.f327980g.getLayoutParams();
        r105.width = r100;
        r105.height = r101;
        this.f327980g.setLayoutParams(r105);
        this.f327980g.setScaleType(r104);
        if (this.f328000u == null) goto L18;
        this.f327980g.setVisibility(0);
        return;
    L18:
        this.f327980g.setVisibility(8);
        return;
    L23:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void t(final String r100, boolean r101) {
        Function0<String> r102 = new com.larus.common_ui.video.g(r100, this);
        if (r101 == false) goto L5;
        FLogger.f375446a.g("VideoPlayView", r102);
        return;
    L5:
        FLogger.f375446a.i("VideoPlayView", r102);
    }

    public final void y(boolean r100, int r101) {
        this.K++;
        this.f327972J = false;
        ArrayList<Runnable> r102 = this.P;
        if (r102 == null) goto L5;
        r102.clear();
    L5:
        this.O = false;
        if (r101 == 1) goto L8;
        this.f327988k1 = false;
    L8:
        t("pause byUser=" + r100 + " scene=" + r101, false);
        IVideoController r103 = this.C;
        IVideoController r104 = null;
        if (r103 == null) goto L11;
        IVideoController.PlayType r105 = r103.d();
    L13:
        if (r105 != IVideoController.PlayType.PLAY) goto L17;
        Function1<? super Integer, Unit> r106 = this.f327977d;
        if (r106 == null) goto L17;
        r106.invoke(3);
    L17:
        O("pause");
        this.f328005x1 = r100;
        IVideoController r107 = this.C;
        if (r107 != null) goto L20;
    L24:
        if (r101 == 1) goto L26;
        c();
    L26:
        i(r100);
        n();
        return;
    L20:
        if (r107.isReleased() == true) goto L22;
        r104 = r107;
    L22:
        if (r104 == null) goto L24;
        r104.b();
        goto L24
    L11:
        r105 = null;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [com.larus.common_ui.video.c] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.larus.common_ui.video.e] */
    public VideoPlayView(Context r210, AttributeSet r211, int r212) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r210, r211, r212);
        this.f327979f = new TextureView(r210);
        SimpleDraweeView r100 = new SimpleDraweeView(r210);
        this.f327980g = r100;
        ImageView r101 = new ImageView(r210);
        this.f327982h = r101;
        ActivityIndicatorView r102 = new ActivityIndicatorView(r210, null);
        this.f327984i = r102;
        this.D = 2;
        this.E = PlaySourceType.MODEL;
        this.I = true;
        this.L = -1;
        this.N = new Handler(Looper.getMainLooper());
        this.Q = ViewConfiguration.get(r210).getScaledTouchSlop();
        this.R = 150.0f;
        f r103 = new f(this);
        this.f327987k0 = r103;
        this.V0 = new com.larus.common_ui.video.c(this);
        this.f327975b1 = new com.larus.common_ui.video.e(this);
        this.f328002v1 = new com.larus.media.model.a(null, "VIDEO", false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, false, MediaLevel.PLAY_HIGH.getValue(), false, new g(this), 1453);
        setBackgroundColor(ContextCompat.getColor(r210, R.color.larus_static_black));
        int r104 = j0.f375426a;
        setContentDescription(j0.d(R.string.larus_accessibility_message_video));
        r100.setAdjustViewBounds(true);
        addView(this.f327979f, -1, -1);
        int r105 = (int) UIUtils.dip2Px(r210, 80.0f);
        int r106 = (int) UIUtils.dip2Px(r210, 32.0f);
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(r106, r106);
        r107.gravity = 17;
        r102.f328120d = true;
        r102.setColor(getResources().getColor(v19.c.b(R.attr.larus_neutral_50, null, R.color.larus_neutral_50)));
        r102.setStrokeWidth(i5.Y());
        r102.setVisibility(8);
        addView(r100, -1, -1);
        addView(r102, r107);
        this.f327979f.setSurfaceTextureListener(r103);
        e1.d(this, new com.larus.common_ui.video.f(this));
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(r105, r105);
        r108.gravity = 17;
        addView(r101, r108);
        r101.setImageResource(R.drawable.larus_tiktok_video_play);
    }

    public static void H(final VideoPlayView r100, int r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        final boolean r101 = true;
    L7:
        if ((r111 & 2) == 0) goto L9;
        final int r102 = 0;
    L11:
        if (r100.M == true) goto L13;
        r100.M();
        return;
    L13:
        final long r112 = r100.K + 1;
        r100.K = r112;
        r100.f327972J = true;
        r100.t("resume byUser=" + r101 + " scene=" + r102, false);
        if (r101 == true) goto L16;
    L20:
        r100.j(new com.larus.common_ui.video.d(r100, r100.K, r101));
        return;
    L16:
        if (r100.f327988k1 == false) goto L20;
        if (r100.f327998s == true) goto L20;
        Lazy r103 = MediaResourceManager.f358950a;
        MediaResourceManager.m(r100.f328002v1, new com.larus.common_ui.video.h(r100, r112, r101, r102), new i(r100, r112), 0, 8);
        return;
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = false;
        goto L7
    }

    public static Unit a(VideoPlayView r100, long r101, float r102) {
        if (r100.h(r101) == false) goto L5;
        r100.t("focus_success", false);
        r100.setVolumeFactor(r102);
        long r103 = r100.K;
        r100.t("start_source", false);
        r100.N.postDelayed(r100.V0, 1000);
        r100.j(new m(r100, r103));
        return Unit.INSTANCE;
    L5:
        if (r100.f327972J == true) goto L10;
        r100.c();
    L10:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void z(VideoPlayView r100, int r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r102 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        r100.y(r103, r101);
        return;
    L5:
        r103 = false;
        goto L7
    }

    public /* synthetic */ VideoPlayView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.U == false) goto L6;
        this.V = true;
        return;
    L6:
        m();
        com.larus.common_ui.video.b r104 = this.f327973a;
        if (r104 == null) goto L10;
        r104.a();
        return;
    }

    public static Unit b(VideoPlayView r100, long r101, boolean r102, int r103, float r104) {
        if (r100.h(r101) == false) goto L7;
        r100.f327988k1 = false;
        r100.setVolumeFactor(r104);
        r100.j(new com.larus.common_ui.video.d(r100, r100.K, r102));
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }

    public static void e(VideoPlayView r100, IVideoController r101, String r102, String r103, String r104, String r110, String r111, int r112) {
        String r105 = null;
        if ((r112 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r112 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r112 & 8) == 0) goto L12;
        r104 = null;
    L12:
        if ((r112 & 16) == 0) goto L15;
        r110 = null;
    L15:
        if ((r112 & 32) == 0) goto L17;
        r111 = null;
    L17:
        r100.getClass();
        if (r111 == null) goto L42;
        String r113 = StringsKt.trim(r111).toString();
        if (r113 == null) goto L42;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L23
        Object r107 = Result.m9449constructorimpl(UriProtector.parse(r113).getScheme());     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r107) == false) goto L28;
        r107 = null;
    L28:
        String r108 = (String) r107;
        if (r108 != null) goto L31;
    L39:
        boolean r109 = false;
    L40:
        if (r109 == false) goto L42;
    L43:
        FLogger.f375446a.i("VideoPlayView", "[bindVideoWithViewModel] localPathExists:" + m5.c(r103) + ", hasLocalUri:" + o0.d(r113) + ", hasRemotePath:" + o0.d(r104) + ", videoModel:" + g(r102));
        if (r101 == null) goto L48;
        if (r101 == r100.C) goto L48;
    L61:
        r100.N();
        r100.f328003w = null;
    L62:
        r100.f328004x = r102;
        if (m5.c(r103) == false) goto L65;
        r105 = r103;
    L65:
        r100.f328006y = r105;
        r100.f328007z = r113;
        r100.A = r104;
        r100.B = r110;
        r100.F = false;
        r100.G = false;
        r100.E = PlaySourceType.MODEL;
        r100.f327986k = 0.0f;
        r100.f327980g.setVisibility(0);
        r100.i(false);
        if (r101 == null) goto L71;
        r100.C = r101;
        r101.setLooping(true);
        return;
    L71:
        return;
    L48:
        if (Intrinsics.areEqual(r100.f328004x, r102) == false) goto L61;
        String r114 = r100.f328006y;
        if (r103 != null) goto L52;
    L54:
        String r115 = null;
    L56:
        if (Intrinsics.areEqual(r114, r115) == false) goto L61;
        if (Intrinsics.areEqual(r100.f328007z, r113) == false) goto L61;
        if (Intrinsics.areEqual(r100.A, r104) == true) goto L62;
    L52:
        if (m5.c(r103) == false) goto L54;
        r115 = r103;
        goto L56
    L31:
        if (StringsKt.equals(r108, "content", true) == false) goto L33;
    L36:
        boolean r116 = true;
    L37:
        if (r116 != true) goto L39;
        r109 = true;
        goto L40
    L33:
        if (StringsKt.equals(r108, "file", true) == true) goto L36;
        r116 = false;
    L23:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L42:
        r113 = null;
        goto L43
    }

    public final void o(String r100, String r101, String r102, Integer r103, Integer r104, Bitmap r105, BaseControllerListener<Object> r110, String r111) {
        FLogger.f375446a.i("VideoPlayView", "[initCover] thumbUrl:" + r100 + ", localPath:" + r102 + ", height:" + r103 + ", width:" + r104);
        if (r103 != null) goto L6;
    L8:
        int r106 = 0;
        if (r104 == null) goto L11;
        int r107 = r104.intValue();
    L12:
        float r108 = r107;
        if (r103 == null) goto L15;
        r106 = r103.intValue();
    L15:
        float r109 = r108 / r106;
    L16:
        this.f327989l = r109;
        if (m5.c(r102) == true) goto L25;
        if (r102 != null) goto L20;
        String r112 = "";
    L22:
        if (m5.c(UriProtector.parse(r112).getPath()) == true) goto L25;
        this.f327999t = r100;
    L26:
        this.f328000u = r101;
        this.f327996q = r105;
        this.f327997r = r110;
        this.f328001v = r111;
        u();
        s();
        return;
    L20:
        r112 = r102;
    L25:
        r101 = r102;
        goto L26
    L11:
        r107 = 0;
        goto L12
    L6:
        if (r103.intValue() != 0) goto L8;
        r109 = 0.0f;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void p(VideoPlayView r100, String r101, String r102, String r103, Integer r104, Integer r105, Bitmap r106, BaseControllerListener r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r104 = 0;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r105 = 0;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r106 = null;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r110 = null;
    L24:
        if ((r112 & 128) == 0) goto L26;
        r111 = null;
    L26:
        r100.o(r101, r102, r103, r104, r105, r106, r110, r111);
    }
}
