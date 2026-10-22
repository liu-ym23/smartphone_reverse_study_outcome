package com.larus.bmhome.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.google.android.material.tabs.TabLayout;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.ChatParam;
import com.larus.chat.ChatTitleBarIcon;
import com.larus.chat.common.databinding.LarusChatTitleAlignLeftStyleBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.ChatSubTitleStyle;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.trace.RealtimeCallEntry;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallConfigServiceDelegate;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0001A\b\u0016\u0018\u0000 \u009d\u00022\u00020\u00012\u00020\u0002:\u0004\u009d\u0002\u009e\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u000e\u0010C\u001a\u00020D2\u0006\u0010*\u001a\u00020\u001aJ\u000e\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\u001aJ\u000e\u0010G\u001a\u00020D2\u0006\u0010F\u001a\u00020\u001aJ\u0010\u0010H\u001a\u00020D2\u0006\u0010I\u001a\u00020\u001aH\u0016J\u0016\u0010J\u001a\u00020D2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/J\b\u0010L\u001a\u00020DH\u0002J\b\u0010R\u001a\u00020DH\u0016J\b\u0010S\u001a\u00020DH\u0016J\b\u0010T\u001a\u00020\u001aH\u0016J\u0012\u0010\u0095\u0001\u001a\u00020D2\u0007\u0010\u0096\u0001\u001a\u00020\u001aH\u0016J\t\u0010\u0097\u0001\u001a\u00020DH\u0002J\t\u0010\u0098\u0001\u001a\u00020DH\u0014J\t\u0010\u0099\u0001\u001a\u00020DH\u0002J\t\u0010\u009a\u0001\u001a\u00020DH\u0002J\t\u0010\u009b\u0001\u001a\u00020DH\u0002J\t\u0010\u009c\u0001\u001a\u00020DH\u0002J\u0013\u0010\u009d\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010 \u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010¡\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010¢\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u001f\u0010£\u0001\u001a\u00020D2\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001J\t\u0010¨\u0001\u001a\u00020DH\u0002J\t\u0010©\u0001\u001a\u00020\u001aH\u0002J\u0012\u0010ª\u0001\u001a\u00020\u001a2\u0007\u0010«\u0001\u001a\u000200H\u0002J\t\u0010¬\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u00ad\u0001\u001a\u00020DH\u0002J\t\u0010®\u0001\u001a\u00020DH\u0002J\u0012\u0010¯\u0001\u001a\u00020D2\t\u0010¦\u0001\u001a\u0004\u0018\u000108J\t\u0010°\u0001\u001a\u00020DH\u0002J\u0012\u0010±\u0001\u001a\u00020D2\u0007\u0010²\u0001\u001a\u00020:H\u0002J\t\u0010³\u0001\u001a\u00020:H\u0002J\u0011\u0010´\u0001\u001a\n\u0012\u0005\u0012\u00030¶\u00010µ\u0001H\u0002J\u0011\u0010·\u0001\u001a\n\u0012\u0005\u0012\u00030¶\u00010µ\u0001H\u0002J\u0012\u0010¸\u0001\u001a\u00020D2\u0007\u0010¹\u0001\u001a\u00020\u000bH\u0016J\u0011\u0010º\u0001\u001a\u00020D2\u0006\u0010I\u001a\u00020\u001aH\u0016J\u0013\u0010»\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010¼\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010½\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010¾\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J \u0010¿\u0001\u001a\u00020D2\u0015\u0010À\u0001\u001a\u0010\u0012\u0005\u0012\u00030¶\u0001\u0012\u0004\u0012\u00020D0Á\u0001H\u0016J\t\u0010Â\u0001\u001a\u00020\u001aH\u0002J\u0019\u0010Ã\u0001\u001a\u00020D2\u000e\u0010À\u0001\u001a\t\u0012\u0004\u0012\u00020D0Ä\u0001H\u0016J\u0013\u0010Å\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J$\u0010Æ\u0001\u001a\u00020D2\u0007\u0010Ç\u0001\u001a\u00020\u001c2\u0007\u0010È\u0001\u001a\u00020\u001c2\u0007\u0010É\u0001\u001a\u00020\u001aH\u0016J\u001c\u0010Ê\u0001\u001a\u00020D2\u0007\u0010Ë\u0001\u001a\u00020\u001c2\b\u0010Ì\u0001\u001a\u00030Í\u0001H\u0002J'\u0010Î\u0001\u001a\u00020D2\u0007\u0010Ï\u0001\u001a\u00020\u001c2\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\u0007\u0010Ò\u0001\u001a\u00020\u001aH\u0016J\u0015\u0010Ó\u0001\u001a\u00020D2\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0002J\t\u0010Ô\u0001\u001a\u00020DH\u0002J\t\u0010Õ\u0001\u001a\u00020DH\u0002J\u0012\u0010Ö\u0001\u001a\u00020D2\u0007\u0010×\u0001\u001a\u00020\u001aH\u0002J\u0011\u0010Ø\u0001\u001a\u00020D2\u0006\u0010I\u001a\u00020\u001aH\u0002J\t\u0010Ú\u0001\u001a\u00020DH\u0002J\u001f\u0010Û\u0001\u001a\u00020D2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u001c2\t\b\u0001\u0010Ý\u0001\u001a\u00020\u000bH\u0002J4\u0010Þ\u0001\u001a\u00020D2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u001c2\u0007\u0010É\u0001\u001a\u00020\u001a2\t\b\u0001\u0010Ý\u0001\u001a\u00020\u000b2\n\u0010ß\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J&\u0010à\u0001\u001a\u00020D2\t\u0010á\u0001\u001a\u0004\u0018\u00010\u000b2\n\u0010Ï\u0001\u001a\u0005\u0018\u00010â\u0001H\u0016¢\u0006\u0003\u0010ã\u0001J\u0010\u0010ä\u0001\u001a\u00020D2\u0007\u0010å\u0001\u001a\u00020\u000bJ\u0012\u0010æ\u0001\u001a\u00020D2\u0007\u0010ç\u0001\u001a\u00020\u001cH\u0016J\u0013\u0010è\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0012\u0010é\u0001\u001a\u00020D2\u0007\u0010á\u0001\u001a\u00020\u000bH\u0016J\t\u0010ê\u0001\u001a\u00020DH\u0016J\t\u0010ë\u0001\u001a\u00020DH\u0016J\u0013\u0010ì\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0013\u0010í\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0012\u0010î\u0001\u001a\u00020D2\u0007\u0010ï\u0001\u001a\u00020\u000bH\u0016J\t\u0010ð\u0001\u001a\u00020DH\u0002J\u0012\u0010ñ\u0001\u001a\u00020D2\u0007\u0010ò\u0001\u001a\u00020\u000bH\u0016J\u0011\u0010ó\u0001\u001a\u00020D2\u0006\u0010I\u001a\u00020\u001aH\u0016J\n\u0010ô\u0001\u001a\u00030õ\u0001H\u0016J\t\u0010ö\u0001\u001a\u00020\u0001H\u0016J\f\u0010÷\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J\n\u0010ø\u0001\u001a\u00030¶\u0001H\u0016J\u001f\u0010ù\u0001\u001a\u00020D2\n\u0010ú\u0001\u001a\u0005\u0018\u00010¶\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0016J\t\u0010û\u0001\u001a\u00020DH\u0016J\t\u0010ü\u0001\u001a\u00020\u001aH\u0004J\u0011\u0010ý\u0001\u001a\u00020D2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010þ\u0001\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0011\u0010ÿ\u0001\u001a\u00020D2\u0006\u0010I\u001a\u00020\u001aH\u0016J\f\u0010\u0080\u0002\u001a\u0005\u0018\u00010¶\u0001H\u0016J\f\u0010\u0081\u0002\u001a\u0005\u0018\u00010¶\u0001H\u0016J\f\u0010\u0082\u0002\u001a\u0005\u0018\u00010¶\u0001H\u0016J\n\u0010\u0083\u0002\u001a\u0005\u0018\u00010¶\u0001J\u0010\u0010\u0084\u0002\u001a\u00020D2\u0007\u0010\u0085\u0002\u001a\u00020\u001aJ\f\u0010\u0086\u0002\u001a\u0005\u0018\u00010¶\u0001H\u0016J\f\u0010\u0087\u0002\u001a\u0005\u0018\u00010¶\u0001H\u0016J7\u0010\u0088\u0002\u001a\u00020D2\u0007\u0010×\u0001\u001a\u00020\u001a2\u0007\u0010\u0089\u0002\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001a2\u0007\u0010\u008a\u0002\u001a\u00020\u001a2\t\b\u0002\u0010\u008b\u0002\u001a\u00020\u001aH\u0016J\u0011\u0010\u008c\u0002\u001a\u00020D2\u0006\u0010#\u001a\u00020\u001aH\u0017J\u0011\u0010\u008d\u0002\u001a\u00020D2\b\u0010\u009e\u0001\u001a\u00030\u008e\u0002J\u0017\u0010\u008f\u0002\u001a\u00020D2\u000e\u0010\u0090\u0002\u001a\t\u0012\u0004\u0012\u00020\u001c0µ\u0001J\u0010\u0010\u0091\u0002\u001a\u00020D2\u0007\u0010\u0092\u0002\u001a\u00020\u001aJ\u0013\u0010\u0093\u0002\u001a\u00020D2\n\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0095\u0002J\u0019\u0010\u0096\u0002\u001a\u00020D2\u0007\u0010\u0097\u0002\u001a\u00020\u000b2\u0007\u0010\u0098\u0002\u001a\u00020\u001aJ\u001d\u0010\u0099\u0002\u001a\u00020D2\u0007\u0010\u009a\u0002\u001a\u00020\u001c2\t\b\u0002\u0010\u0098\u0002\u001a\u00020\u001aH\u0002J\t\u0010\u009b\u0002\u001a\u00020DH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\u001aX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001cX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001cX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001cX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00102\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010&\"\u0004\b3\u00104R$\u00105\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010&\"\u0004\b6\u00104R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0018\u001a\u0004\b=\u0010>R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0018\u001a\u0004\bO\u0010PR$\u0010U\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010&\"\u0004\bW\u00104R$\u0010X\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010&\"\u0004\bZ\u00104R$\u0010[\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010&\"\u0004\b]\u00104R$\u0010^\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010&\"\u0004\b`\u00104R$\u0010b\u001a\u00020a2\u0006\u00101\u001a\u00020a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010g\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010&\"\u0004\bi\u00104R$\u0010j\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010&\"\u0004\bl\u00104R$\u0010m\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010&\"\u0004\bo\u00104R$\u0010p\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010&\"\u0004\bq\u00104R\u001e\u0010r\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bs\u00104R$\u0010t\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010&\"\u0004\bu\u00104R$\u0010v\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010&\"\u0004\bw\u00104R$\u0010x\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010&\"\u0004\by\u00104R$\u0010z\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010&\"\u0004\b{\u00104R$\u0010|\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010&\"\u0004\b~\u00104R&\u0010\u007f\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010&\"\u0005\b\u0081\u0001\u00104R'\u0010\u0082\u0001\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010&\"\u0005\b\u0084\u0001\u00104R'\u0010\u0085\u0001\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010&\"\u0005\b\u0086\u0001\u00104R'\u0010\u0087\u0001\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010&\"\u0005\b\u0089\u0001\u00104R'\u0010\u008a\u0001\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@VX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010&\"\u0005\b\u008b\u0001\u00104R'\u0010\u008c\u0001\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010&\"\u0005\b\u008e\u0001\u00104R'\u0010\u008f\u0001\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010&\"\u0005\b\u0091\u0001\u00104R\u000f\u0010\u0092\u0001\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Ù\u0001\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÙ\u0001\u0010&R\u0016\u0010\u009c\u0002\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0002\u0010&¨\u0006\u009f\u0002"}, d2 = {"Lcom/larus/bmhome/view/ChatTitleAlignLeftStyle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/platform/api/IChatTitle;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "createNewCvsDelegate", "Lcom/larus/bmhome/compose/TitleCreateNewCvsDelegate;", "binding", "Lcom/larus/chat/common/databinding/LarusChatTitleAlignLeftStyleBinding;", "getBinding", "()Lcom/larus/chat/common/databinding/LarusChatTitleAlignLeftStyleBinding;", "defaultTagStyle", "Lcom/larus/bmhome/view/ChatTitleAlignLeftStyle$TagDefaultStyle;", "getDefaultTagStyle", "()Lcom/larus/bmhome/view/ChatTitleAlignLeftStyle$TagDefaultStyle;", "defaultTagStyle$delegate", "Lkotlin/Lazy;", "isImmerse", "", "preIconTag", "", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "navigatorSimplify", "isOnlyRead", "useBlackStyle", "getUseBlackStyle", "()Z", "PLAYING_LOTTIE_FILE", "PLAYING_LOTTIE_ENTERPRISE", "PLAYING_LOTTIE_FILE_WHITE", "isHalfStyle", "forceHideBack", "forceHideSearch", "sideNavIconVisible", "titleBarVisibleIcons", "", "Lcom/larus/chat/ChatTitleBarIcon;", "value", "isCreateNewCvsForceHidden", "setCreateNewCvsForceHidden", "(Z)V", "isTopLeftCreateNewCvsAvailable", "setTopLeftCreateNewCvsAvailable", "titleBarIconAnimationProgressProvider", "Lcom/larus/chat/IChatTitleBarIconAnimationProgressProvider;", "titleBarIconAnimationProgress", "", "halfScreenInteractionHelper", "Lcom/larus/bmhome/view/title/ChatTitleHalfScreenInteractionHelper;", "getHalfScreenInteractionHelper", "()Lcom/larus/bmhome/view/title/ChatTitleHalfScreenInteractionHelper;", "halfScreenInteractionHelper$delegate", "titleBarIconAnimationProgressListener", "com/larus/bmhome/view/ChatTitleAlignLeftStyle$titleBarIconAnimationProgressListener$1", "Lcom/larus/bmhome/view/ChatTitleAlignLeftStyle$titleBarIconAnimationProgressListener$1;", "setNowHalfStyle", "", "setForceHideBack", "force", "setForceHideSearch", "setSideNavIconVisible", "isVisible", "setTitleBarVisibleIcons", "icons", "restoreTitleBarVisibleIconConfigBaseState", "disclaimerConfig", "Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "getDisclaimerConfig", "()Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "disclaimerConfig$delegate", "playTtsButtonLottie", "cancelTtsButtonLottie", "isTtsLottieAnimating", "hasMore", "getHasMore", "setHasMore", "moreBtnEnabled", "getMoreBtnEnabled", "setMoreBtnEnabled", "hasAddBot", "getHasAddBot", "setHasAddBot", "ttsChecked", "getTtsChecked", "setTtsChecked", "Lcom/larus/platform/model/audio/EarphoneStateModel;", "earphoneState", "getEarphoneState", "()Lcom/larus/platform/model/audio/EarphoneStateModel;", "setEarphoneState", "(Lcom/larus/platform/model/audio/EarphoneStateModel;)V", "ttsBanned", "getTtsBanned", "setTtsBanned", "ttsGrey", "getTtsGrey", "setTtsGrey", "audioBtnEnabled", "getAudioBtnEnabled", "setAudioBtnEnabled", "isMainBot", "setMainBot", "isLocalSubConv", "setLocalSubConv", "isDotEnable", "setDotEnable", "isRealTimeCallVisible", "setRealTimeCallVisible", "isRealtimeCallVisibleHookShow", "setRealtimeCallVisibleHookShow", "isRedDotVisible", "setRedDotVisible", "backBtnEnabled", "getBackBtnEnabled", "setBackBtnEnabled", "ttsContinuousTalkEnabled", "getTtsContinuousTalkEnabled", "setTtsContinuousTalkEnabled", "addBotEnabled", "getAddBotEnabled", "setAddBotEnabled", "isTtsContinuousTalkVisible", "setTtsContinuousTalkVisible", "ttsContinuousTalkChecked", "getTtsContinuousTalkChecked", "setTtsContinuousTalkChecked", "isTtsVisible", "setTtsVisible", "showHistory", "getShowHistory", "setShowHistory", "historyChecked", "getHistoryChecked", "setHistoryChecked", "viewInit", "showTabView", "iconFlag", "setIsLocalSubConvChange", "isLocalCoCoSub", "setupCreateNewCvsImmerse", "setupTtsButtonStatus", "setupTtsContinuousTalkStatus", "setupRealTimeCall", "switchTtsAndCall", "setupChatHistoryStatus", "setOnMoreClickListener", "listener", "Landroid/view/View$OnClickListener;", "setCreateNewCvsClickListener", "setOnSearchClickListener", "setOnSideNavClickListener", "setPageSizeSlotProvider", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/larus/chat/IChatPageSizeSlotProvider;", "clearPageSizeSlot", "hasPageSizeIconInSlot", "isTitleBarIconAllowed", "icon", "shouldShowSideNavIcon", "applySideNavIconVisibility", "applyTitleBarVisibleIconConfig", "setTitleBarIconAnimationProgressProvider", "clearTitleBarIconAnimationProgressProvider", "applyTitleBarIconAnimationProgress", "progress", "titleBarIconEnterTranslationDistance", "titleBarIconAnimationViews", "", "Landroid/view/View;", "titleBarIconInteractiveViews", "setSearchIcon", "resId", "setSearchIconRedDotVisible", "setOnMultitaskClickListener", "setOnAddBotClickListener", "setOnTtsCheckedListener", "setOnTtsContinuousTalkCheckedListener", "setOnTtsContinuousTalkLongClickListener", "longClickAction", "Lkotlin/Function1;", "checkAudioReady", "setOnTtsLongPressAction", "Lkotlin/Function0;", "setOnChatHistoryCheckedListener", "setAvatar", "iconUri", "iconUrl", "isAllow", "loadImg", "imgUrl", "builder", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", com.alipay.sdk.m.x.d.f25925o, "title", "tagConfig", "Lcom/larus/platform/api/ChatTitleTagConfig;", "isDefaultName", "applyTitleTagConfig", "resetTitleTagStyle", "adjustTitleWidth", "adjustNavigatorSimplify", "isMainCvs", "setSubtitleVisible", "isShowSubTitle", "initSubtitleVisible", "setCreateName", "creatorName", "type", "setCreatorName", "subTitleClickListener", "setSubtitleIconRes", "iconResId", "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "setReviewSubTitle", "disableTag", "setStatus", "status", "setOnMainClickListener", "setBackIconRes", "forbidBack", "forbidRedDot", "setOnBackClickListener", "setRedDotViewClickListener", "setRedDotUnreadCount", "count", "applyRoundBadgeStyle", "setRedDotBGType", "bgType", "setRedDotViewVisible", "getAvatar", "Lcom/larus/bmhome/view/TitleAvatarImageView;", "getTitle", "getMoreView", "getTitleView", "onViewCreated", "view", "onDestroyedView", "getImmerse", "setImmerse", "setRealtimeCallBtnClickListener", "setBackIconVisible", "getTtsView", "getBackIcon", "getMultitaskManagementIcon", "getSearchIcon", "setArrowVisible", "visible", "getRedDot", "getTitleText", "initView", "titleName", "isSideBar", "isEnterpriseColdStart", "setCvsOnlyRead", "addOnTabSelectedListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "setTabView", "names", "setTabAlignment", "alignCenter", "setupWithViewPager", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "setIconVisibility", ForwardDependency$ForwardLocation.FLAG, "animate", "updateAllIconVisibility", "enterFrom", "updateAllIconVisibilityForObric", "isShowCreateNewCvs", "Companion", "TagDefaultStyle", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ChatTitleAlignLeftStyle extends ConstraintLayout implements com.larus.platform.api.g0 {
    public static final /* synthetic */ int T = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f315491J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xo8.a f315492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusChatTitleAlignLeftStyleBinding f315493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f315494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f315495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f315496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f315497f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f315498g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f315499h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f315500i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f315501j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f315502k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f315503l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f315504m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f315505n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f315506o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Set<? extends ChatTitleBarIcon> f315507p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f315508q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f315509r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f315510s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f315511t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f315512u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f315513v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f315514w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f315515x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f315516y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public lq9.q f315517z;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f315518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable.ConstantState f315519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f315520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f315521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f315522e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f315523f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f315524g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Typeface f315525h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f315526i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f315518a, r101.f315518a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f315519b, r101.f315519b) == true) goto L15;
            return false;
        L15:
            if (Float.compare(this.f315520c, r101.f315520c) == 0) goto L18;
            return false;
        L18:
            if (this.f315521d == r101.f315521d) goto L21;
            return false;
        L21:
            if (this.f315522e == r101.f315522e) goto L24;
            return false;
        L24:
            if (this.f315523f == r101.f315523f) goto L27;
            return false;
        L27:
            if (this.f315524g == r101.f315524g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f315525h, r101.f315525h) == true) goto L33;
            return false;
        L33:
            if (this.f315526i == r101.f315526i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            ColorStateList r100 = this.f315518a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Drawable.ConstantState r104 = this.f315519b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((((((((((r103 + r105) * 31) + Float.floatToIntBits(this.f315520c)) * 31) + this.f315521d) * 31) + this.f315522e) * 31) + this.f315523f) * 31) + this.f315524g) * 31;
            Typeface r107 = this.f315525h;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return ((r106 + r101) * 31) + this.f315526i;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "TagDefaultStyle(textColors=" + this.f315518a + ", backgroundState=" + this.f315519b + ", textSizePx=" + this.f315520c + ", paddingStart=" + this.f315521d + ", paddingTop=" + this.f315522e + ", paddingEnd=" + this.f315523f + ", paddingBottom=" + this.f315524g + ", typeface=" + this.f315525h + ", gravity=" + this.f315526i + ')';
        }

        public b(ColorStateList r100, Drawable.ConstantState r101, float r102, int r103, int r104, int r105, int r106, Typeface r107, int r108) {
            this.f315518a = r100;
            this.f315519b = r101;
            this.f315520c = r102;
            this.f315521d = r103;
            this.f315522e = r104;
            this.f315523f = r105;
            this.f315524g = r106;
            this.f315525h = r107;
            this.f315526i = r108;
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f315527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatTitleAlignLeftStyle f315528b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f315527a.removeOnAttachStateChangeListener(this);
            this.f315528b.getBinding().D.cancelAnimation();
            this.f315528b.V6();
        }

        public c(LottieAdapterView r100, ChatTitleAlignLeftStyle r101) {
            this.f315527a = r100;
            this.f315528b = r101;
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class d implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f315529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatTitleAlignLeftStyle f315530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f315531c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f315529a.removeOnAttachStateChangeListener(this);
            this.f315530b.getBinding().D.setAnimation(this.f315531c);
            this.f315530b.getBinding().D.playAnimation();
        }

        public d(LottieAdapterView r100, ChatTitleAlignLeftStyle r101, String r102) {
            this.f315529a = r100;
            this.f315530b = r101;
            this.f315531c = r102;
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class e implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatTitleAlignLeftStyle f315532a;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(TabLayout.Tab r100) {
        }

        public e(ChatTitleAlignLeftStyle r100) {
            this.f315532a = r100;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab r100) {
            if (r100 == null) goto L9;
            View r101 = r100.getCustomView();
            if (r101 == null) goto L10;
            TextView r102 = (TextView) r101.findViewById(R.id.tv_title);
            if (r102 == null) goto L11;
            r102.setTextColor(ContextCompat.getColor(this.f315532a.getContext(), v19.c.b(R.attr.larus_neutral_100, this.f315532a.getContext(), R.color.larus_neutral_100)));
            return;
        L11:
            return;
        L10:
            return;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(TabLayout.Tab r100) {
            if (r100 == null) goto L9;
            View r101 = r100.getCustomView();
            if (r101 == null) goto L10;
            TextView r102 = (TextView) r101.findViewById(R.id.tv_title);
            if (r102 == null) goto L11;
            r102.setTextColor(ContextCompat.getColor(this.f315532a.getContext(), v19.c.b(R.attr.larus_neutral_50, this.f315532a.getContext(), R.color.larus_neutral_50)));
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    /* JADX INFO: loaded from: classes26.dex */
    public static final class f implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager2 f315533a;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(TabLayout.Tab r100) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(TabLayout.Tab r100) {
        }

        public f(ViewPager2 r100) {
            this.f315533a = r100;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab r100) {
            if (r100 == null) goto L7;
            int r101 = r100.getPosition();
            ViewPager2 r102 = this.f315533a;
            if (r102.getCurrentItem() == r101) goto L8;
            r102.setCurrentItem(r101);
            return;
        L8:
            return;
        }
    }

    public static final class g {
        public g() {
        }
    }

    static {
    }

    public View getSelectDone() {
        return null;
    }

    @Override // com.larus.platform.api.g0
    public View getTitleView() {
        return this;
    }

    public void o7() {
    }

    @Override // com.larus.platform.api.g0
    public void refresh() {
    }

    public void setParticipantNum(int r100) {
    }

    @Override // com.larus.platform.api.g0
    public void setTitleIcon(boolean r100) {
    }

    public static com.larus.platform.model.chat.q T5() {
        if (AppHost.f326268a.isOversea() == false) goto L7;
        return null;
    L7:
        return com.larus.platform.service.z2.f365865a.getDoubaoDisclaimerConfig();
    }

    public static boolean b6() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L7;
        r100.a0();
        com.larus.home.impl.sdk.g r101 = com.larus.home.impl.sdk.g.f346177a;
        return true;
    L7:
        return true;
    }

    private final b getDefaultTagStyle() {
        return (b) this.f315494c.getValue();
    }

    private final com.larus.platform.model.chat.q getDisclaimerConfig() {
        return (com.larus.platform.model.chat.q) this.f315512u.getValue();
    }

    private final wt8.o getHalfScreenInteractionHelper() {
        return (wt8.o) this.f315511t.getValue();
    }

    @Override // com.larus.platform.api.g0
    public final void E6() {
        com.larus.utils.e1.o(this.f315493b.f323920e);
        this.f315493b.f323920e.setDotGone(true);
    }

    @Override // com.larus.platform.api.g0
    public final boolean Ea() {
        return this.f315493b.D.isAnimating();
    }

    public final void N6() {
        Context r100 = null;
        if (this.f315495d == false) goto L5;
        this.f315493b.f323934s.setColorFilter(getResources().getColor(R.color.larus_static_white));
    L11:
        VoiceCallConfigServiceDelegate r101 = VoiceCallConfigServiceDelegate.f377084b;
        if (r101.e() == true) goto L14;
        return;
    L14:
        if (this.D == true) goto L16;
        return;
    L16:
        if (r101.i() == true) goto L18;
        return;
    L18:
        if (com.larus.platform.service.x1.f365857a.a() == true) goto L28;
        AppCompatImageView r102 = this.f315493b.f323934s;
        if (r102 == null) goto L29;
        if (r102 == null) goto L23;
        r100 = r102.getContext();
    L23:
        r102.setImageResource(v19.c.b(R.attr.larus_ic_video_call, r100, R.drawable.larus_ic_video_call));
        return;
    L29:
        return;
    L28:
        return;
    L5:
        this.f315493b.f323934s.clearColorFilter();
        AppCompatImageView r103 = this.f315493b.f323934s;
        if (r103 == null) goto L11;
        if (r103 == null) goto L9;
        Context r104 = r103.getContext();
    L10:
        r103.setImageResource(v19.c.b(R.attr.larus_ic_realtime_call_chat, r104, R.drawable.larus_ic_realtime_call_chat));
        goto L11
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.larus.platform.api.g0
    public final void Qa() {
        this.f315510s = 1.0f;
        Y5(1.0f);
        this.f315493b.f323933r.removeAllViews();
        com.larus.utils.e1.o(this.f315493b.f323933r);
        this.f315507p = null;
    }

    @Override // com.larus.platform.api.g0
    public final void Ua() {
        this.f315493b.D.setRepeatMode(1);
        this.f315493b.D.setRepeatCount(-1);
        com.larus.platform.service.z2.f365865a.w3();
        if (this.f315495d == false) goto L5;
        String r100 = this.f315502k;
    L6:
        LottieAdapterView r101 = this.f315493b.D;
        if (r101.isAttachedToWindow() == false) goto L9;
        getBinding().D.setAnimation(r100);
        getBinding().D.playAnimation();
        return;
    L9:
        r101.addOnAttachStateChangeListener(new d(r101, this, r100));
        return;
    L5:
        r100 = this.f315501j;
        goto L6
    }

    @Override // com.larus.platform.api.g0
    public final void Wa() {
        LottieAdapterView r100 = this.f315493b.D;
        if (r100.isAttachedToWindow() == false) goto L5;
        getBinding().D.cancelAnimation();
        V6();
        return;
    L5:
        r100.addOnAttachStateChangeListener(new c(r100, this));
    }

    public final void Z5() {
        Set<? extends ChatTitleBarIcon> r100 = this.f315507p;
        if (r100 != null) goto L5;
        return;
    L5:
        FLogger.f375446a.i("ChatTitleBarIconConfig", "visibleIcons=" + CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, new h1(), 30, null));
        if (r100.contains(ChatTitleBarIcon.BACK) == true) goto L11;
        if (r100.contains(ChatTitleBarIcon.COLLAPSE) == true) goto L11;
        com.larus.utils.e1.o(this.f315493b.f323919d);
    L11:
        if (r100.contains(ChatTitleBarIcon.PAGE_SIZE) == true) goto L14;
        com.larus.utils.e1.o(this.f315493b.f323933r);
    L14:
        if (r100.contains(ChatTitleBarIcon.SEARCH) == true) goto L17;
        com.larus.utils.e1.o(this.f315493b.f323937v);
    L17:
        if (r100.contains(ChatTitleBarIcon.SIDE_NAV) == true) goto L20;
        com.larus.utils.e1.o(this.f315493b.f323940y);
    L20:
        if (r100.contains(ChatTitleBarIcon.NEW_CONVERSATION) == true) goto L30;
        xo8.a r101 = this.f315492a;
        if (r101 == null) goto L30;
        List r102 = CollectionsKt.listOf(r101.f564685a);
        if (r102 == null) goto L30;
        Iterator r103 = r102.iterator();
    L27:
        if (r103.hasNext() == false) goto L30;
        com.larus.utils.e1.o((View) r103.next());
    L30:
        if (r100.contains(ChatTitleBarIcon.TTS) == true) goto L33;
        com.larus.utils.e1.o(this.f315493b.E);
    L33:
        if (r100.contains(ChatTitleBarIcon.MORE) == true) goto L35;
        com.larus.utils.e1.o(this.f315493b.f323930o);
    L37:
        if (r100.contains(ChatTitleBarIcon.ADD_BOT) == true) goto L40;
        com.larus.utils.e1.o(this.f315493b.f323917b);
    L40:
        if (r100.contains(ChatTitleBarIcon.REAL_TIME_CALL) == true) goto L43;
        com.larus.utils.e1.o(this.f315493b.f323935t);
    L43:
        if (r100.contains(ChatTitleBarIcon.HISTORY) == true) goto L46;
        com.larus.utils.e1.o(this.f315493b.f323923h);
    L46:
        if (r100.contains(ChatTitleBarIcon.MULTITASK_MANAGEMENT) == true) goto L50;
        com.larus.utils.e1.o(this.f315493b.f323932q);
        return;
    L50:
        return;
    L35:
        com.larus.utils.e1.x(this.f315493b.f323930o);
        goto L37
    }

    public final boolean c6() {
        if (this.f315493b.f323933r.getChildCount() == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L13:
        return false;
    L8:
        if (this.f315493b.f323933r.getVisibility() != 0) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L13;
        return true;
    L10:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final boolean f7() {
        if (this.f315506o == true) goto L5;
    L7:
        return false;
    L5:
        if (s6(ChatTitleBarIcon.SIDE_NAV) == false) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.g0
    public View getBackIcon() {
        return this.f315493b.f323919d;
    }

    public final ChatParam getChatParam() {
        return (ChatParam) this.f315497f.getValue();
    }

    @Override // com.larus.platform.api.g0
    public View getMoreView() {
        return this.f315493b.f323930o;
    }

    @Override // com.larus.platform.api.g0
    public View getMultitaskManagementIcon() {
        return this.f315493b.f323932q;
    }

    @Override // com.larus.platform.api.g0
    public View getRedDot() {
        return this.f315493b.f323920e;
    }

    public final View getSearchIcon() {
        return this.f315493b.f323937v;
    }

    @Override // com.larus.platform.api.g0
    public View getTitleText() {
        return this.f315493b.C;
    }

    @Override // com.larus.platform.api.g0
    public View getTtsView() {
        return this.f315493b.D;
    }

    public final boolean n6() {
        if (this.D == false) goto L9;
        com.larus.platform.service.z2 r100 = com.larus.platform.service.z2.f365865a;
        if (r100.e4() == false) goto L7;
    L8:
        return true;
    L7:
        if (r100.o0().f486637a == true) goto L8;
    L9:
        return false;
    }

    @Override // com.larus.platform.api.g0
    public final void va() {
        com.larus.utils.e1.o(this.f315493b.f323919d);
        com.larus.utils.e1.o(this.f315493b.f323920e);
        this.f315493b.f323920e.setDotGone(true);
        if (this.f315498g == false) goto L5;
        return;
    L5:
        ConstraintLayout r100 = this.f315493b.f323926k;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        r102.setMarginStart(i5.r0());
        r100.setLayoutParams(r102);
    }

    public void V6() {
        if (Ea() == false) goto L5;
        return;
    L5:
        this.f315493b.D.setTag("");
        if (this.f315495d == false) goto L8;
        this.f315493b.D.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), R.color.larus_static_white), PorterDuff.Mode.SRC_IN));
    L9:
        LottieAdapterView r100 = this.f315493b.D;
        if (getTtsChecked() == false) goto L12;
        int r101 = com.larus.utils.j0.f375426a;
        int r102 = R.string.larus_accessibility_icon_ttsOn;
    L13:
        r100.setContentDescription(com.larus.utils.j0.d(r102));
        boolean r103 = false;
        if (getTtsGrey() == false) goto L20;
        this.f315493b.D.setTag("tts_isGray");
        boolean r104 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L18;
        int r105 = R.drawable.larus_ic_tts_dora_dark;
    L52:
        Drawable r106 = ContextCompat.getDrawable(getContext(), r105);
        if (r103 == false) goto L57;
        IFlowThemeConfigProvider r107 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r107 == null) goto L57;
        ThemeConfigScene r108 = ThemeConfigScene.CHAT;
        IFlowThemeConfigProvider.a.a(r107, r106, ThemeColorKey.NAVIBAR_TTS_BUTTON_COLOR, r108, AdaptThemeFeatureKey.NAVIBAR_TTS_BUTTON);
    L57:
        this.f315493b.D.setImageDrawable(r106);
        return;
    L18:
        r105 = R.drawable.larus_ic_tts_dora_default;
        goto L52
    L20:
        if (getTtsBanned() == false) goto L26;
        if (this.f315495d == false) goto L24;
        r105 = R.drawable.larus_ic_tts_muted_immerse;
        goto L52
    L24:
        r105 = v19.c.b(R.attr.larus_ic_tts_muted, getContext(), R.drawable.larus_ic_tts_muted);
        goto L52
    L26:
        if (getEarphoneState().f510350a == false) goto L35;
        if (getEarphoneState().f510351b == true) goto L31;
        r105 = v19.c.b(R.attr.larus_ic_tts_earphone_close, getContext(), R.drawable.larus_ic_tts_earphone_close);
        goto L52
    L31:
        if (this.f315495d == false) goto L33;
        r105 = R.drawable.larus_ic_tts_earphone_open_immerse;
        goto L52
    L33:
        r105 = v19.c.b(R.attr.larus_ic_tts_earphone_open, getContext(), R.drawable.larus_ic_tts_earphone_open);
        goto L52
    L35:
        if (getTtsChecked() == true) goto L37;
        r105 = v19.c.b(R.attr.larus_ic_tts_disable, getContext(), R.drawable.larus_ic_tts_disable);
        goto L52
    L37:
        if (this.f315495d == false) goto L39;
        r105 = v19.c.b(R.attr.larus_ic_tts_enable_immerse, getContext(), R.drawable.larus_ic_tts_enable_immerse);
        goto L52
    L39:
        ChatParam r109 = getChatParam();
        if (r109 != null) goto L42;
    L44:
        boolean r110 = false;
    L45:
        if (r110 == false) goto L48;
        r105 = v19.c.b(R.attr.larus_ic_tts_enable_subscribed, getContext(), R.drawable.larus_ic_tts_enable_subscribed);
        goto L52
    L48:
        if (this.f315500i == false) goto L50;
        r105 = v19.c.b(R.attr.larus_ic_tts_enable_black, getContext(), R.drawable.larus_ic_tts_enable_black);
        goto L52
    L50:
        r105 = v19.c.b(R.attr.larus_ic_tts_enable, getContext(), R.drawable.larus_ic_tts_enable);
        r103 = true;
        goto L52
    L42:
        if (r109.f296894f != true) goto L44;
        r110 = true;
        goto L45
    L12:
        int r111 = com.larus.utils.j0.f375426a;
        r102 = R.string.larus_accessibility_icon_ttsOff;
        goto L13
    L8:
        this.f315493b.D.setColorFilter(null);
        goto L9
    }

    public final void W6() {
        boolean r100 = false;
        if (getTtsContinuousTalkChecked() == true) goto L5;
        int r101 = v19.c.b(R.attr.larus_ic_tts_disable, getContext(), R.drawable.larus_ic_tts_disable);
    L20:
        Drawable r102 = ContextCompat.getDrawable(getContext(), r101);
        if (r100 == false) goto L25;
        IFlowThemeConfigProvider r103 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r103 == null) goto L25;
        ThemeConfigScene r104 = ThemeConfigScene.CHAT;
        IFlowThemeConfigProvider.a.a(r103, r102, ThemeColorKey.NAVIBAR_TTS_BUTTON_COLOR, r104, AdaptThemeFeatureKey.NAVIBAR_TTS_BUTTON);
    L25:
        this.f315493b.F.setImageDrawable(r102);
        return;
    L5:
        if (this.f315495d == false) goto L7;
        r101 = v19.c.b(R.attr.larus_ic_tts_enable_immerse, getContext(), R.drawable.larus_ic_tts_enable_immerse);
        goto L20
    L7:
        ChatParam r105 = getChatParam();
        if (r105 != null) goto L10;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L16;
        r101 = v19.c.b(R.attr.larus_ic_tts_enable_subscribed, getContext(), R.drawable.larus_ic_tts_enable_subscribed);
        goto L20
    L16:
        if (this.f315500i == false) goto L18;
        r101 = v19.c.b(R.attr.larus_ic_tts_enable_black, getContext(), R.drawable.larus_ic_tts_enable_black);
        goto L20
    L18:
        r101 = v19.c.b(R.attr.larus_ic_tts_enable, getContext(), R.drawable.larus_ic_tts_enable);
        r100 = true;
        goto L20
    L10:
        if (r105.f296894f != true) goto L12;
        r106 = true;
        goto L13
    }

    public /* bridge */ /* synthetic */ View getAvatar() {
        return m8543getAvatar();
    }

    @Override // com.larus.platform.api.g0
    public /* bridge */ /* synthetic */ View getTitle() {
        return getTitle();
    }

    public final boolean o6() {
        com.larus.platform.model.chat.q r100 = getDisclaimerConfig();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return true;
    L10:
        if (com.larus.platform.service.z2.f365865a.o0().f486639c == false) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r100.a() != 0) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.larus.platform.api.g0
    public final boolean Da() {
        return this.D;
    }

    @Override // com.larus.platform.api.g0
    public final boolean Ja() {
        return this.E;
    }

    public boolean getAddBotEnabled() {
        return this.K;
    }

    @Override // com.larus.platform.api.g0
    public boolean getAudioBtnEnabled() {
        return this.C;
    }

    public boolean getBackBtnEnabled() {
        return this.I;
    }

    public final LarusChatTitleAlignLeftStyleBinding getBinding() {
        return this.f315493b;
    }

    @Override // com.larus.platform.api.g0
    public lq9.q getEarphoneState() {
        return this.f315517z;
    }

    @Override // com.larus.platform.api.g0
    public boolean getHasAddBot() {
        return this.f315515x;
    }

    public boolean getHasMore() {
        return this.f315513v;
    }

    public final boolean getHistoryChecked() {
        return this.P;
    }

    public final boolean getImmerse() {
        return this.f315495d;
    }

    public boolean getMoreBtnEnabled() {
        return this.f315514w;
    }

    public final boolean getShowHistory() {
        return this.O;
    }

    @Override // com.larus.platform.api.g0
    public boolean getTtsBanned() {
        return this.A;
    }

    @Override // com.larus.platform.api.g0
    public boolean getTtsChecked() {
        return this.f315516y;
    }

    @Override // com.larus.platform.api.g0
    public boolean getTtsContinuousTalkChecked() {
        return this.M;
    }

    @Override // com.larus.platform.api.g0
    public boolean getTtsContinuousTalkEnabled() {
        return this.f315491J;
    }

    public boolean getTtsGrey() {
        return this.B;
    }

    public final boolean getUseBlackStyle() {
        return this.f315500i;
    }

    @Override // com.larus.platform.api.g0
    public final boolean i() {
        return this.H;
    }

    public boolean k6() {
        return this.G;
    }

    /* JADX INFO: renamed from: getAvatar, reason: collision with other method in class */
    public TitleAvatarImageView m8543getAvatar() {
        return this.f315493b.f323918c;
    }

    @Override // com.larus.platform.api.g0
    public ConstraintLayout getTitle() {
        return this.f315493b.f323926k;
    }

    public ChatTitleAlignLeftStyle(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LarusChatTitleAlignLeftStyleBinding r101 = LarusChatTitleAlignLeftStyleBinding.a(LayoutInflater.from(getContext()), this);
        AppCompatImageView r102 = r101.f323921f;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r104 = (ConstraintLayout) r103;
    L5:
        this.f315492a = new xo8.a(r102);
        com.larus.utils.e1.d(r101.D, new s1(this));
        this.f315493b = r101;
        this.f315494c = LazyKt.lazy(new t1(this));
        this.f315497f = LazyKt.lazy(new u1(this));
        com.larus.platform.service.z2 r105 = com.larus.platform.service.z2.f365865a;
        this.f315498g = r105.getChatNavigatorConfig().f486625b;
        this.f315500i = r105.ttsSwitchConfig().b();
        this.f315501j = "lottie/text_msg_voice_playing.json";
        this.f315502k = "lottie/text_msg_voice_playing_white.json";
        this.f315510s = 1.0f;
        this.f315511t = LazyKt.lazy(new v1(this));
        new g();
        this.f315512u = LazyKt.lazy(new w1());
        this.f315513v = true;
        this.f315514w = true;
        boolean r106 = false;
        this.f315517z = new lq9.q(false, false);
        this.C = true;
        this.E = true;
        if (r105.R1().getRealtimeCallBtnShowTopRight() == true) goto L15;
        IFlowSdkDepend r107 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r107 == null) goto L12;
        r107.S();
        if (com.larus.home.impl.sdk.c1.f346148a.a() != true) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == true) goto L15;
    L25:
        this.F = r106;
        this.I = true;
        this.f315491J = true;
        this.K = true;
        this.M = true;
        this.N = true;
        this.S = 31;
        if (getId() != (-1)) goto L29;
        setId(R.id.chat_title_align_left_style_view);
        return;
    L29:
        return;
    L12:
        r108 = false;
    L15:
        if (r105.g() == false) goto L25;
        if (VoiceCallServiceDelegate.f377087a.z(1) == true) goto L25;
        if (com.larus.platform.service.x1.f365857a.a() == false) goto L23;
        if (AppHost.f326268a.isOversea() == true) goto L25;
    L23:
        if (AudioServiceDelegate.f288288a.getAudioConfig().B(this.D) == true) goto L25;
        r106 = true;
        goto L25
    }

    public static ChatParam R5(ChatTitleAlignLeftStyle r100) {
        ActivityResultCaller r101 = com.larus.utils.e1.k(r100);
        if ((r101 instanceof xe8.a) == false) goto L5;
        xe8.a r102 = (xe8.a) r101;
    L6:
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.getChatParam();
    L5:
        r102 = null;
        goto L6
    }

    public static b S5(ChatTitleAlignLeftStyle r110) {
        ColorStateList r100 = r110.f315493b.B.getTextColors();
        Drawable r101 = r110.f315493b.B.getBackground();
        if (r101 == null) goto L5;
        Drawable.ConstantState r102 = r101.getConstantState();
    L7:
        return new b(r100, r102, r110.f315493b.B.getTextSize(), r110.f315493b.B.getPaddingStart(), r110.f315493b.B.getPaddingTop(), r110.f315493b.B.getPaddingEnd(), r110.f315493b.B.getPaddingBottom(), r110.f315493b.B.getTypeface(), r110.f315493b.B.getGravity());
    L5:
        r102 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.view.l1] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.bmhome.view.m1] */
    public static wt8.o U5(final ChatTitleAlignLeftStyle r100) {
        return new wt8.o(r100.f315493b, r100.f315498g, new l1(r100), new m1(r100));
    }

    private final void setLocalSubConv(boolean r100) {
        if (r100 == false) goto L4;
        this.f315493b.f323930o.setAlpha(0.3f);
        return;
    L4:
        this.f315493b.f323930o.setAlpha(1.0f);
    }

    private final void setSubtitleVisible(boolean r100) {
        TextView r101 = this.f315493b.f323941z;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (r100 == false) goto L9;
        this.f315493b.C.setTextSize(0, i5.o());
        this.f315493b.C.setTypeface(Typeface.defaultFromStyle(0));
        return;
    L9:
        this.f315493b.C.setTextSize(0, i5.v());
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void H6(Fragment r100) {
        this.f315493b.f323933r.removeAllViews();
        com.larus.utils.e1.o(this.f315493b.f323933r);
    }

    public final void Y5(float r110) {
        float r111 = RangesKt.coerceIn(r110, 0.0f, 1.0f);
        this.f315510s = r111;
        ViewGroup.LayoutParams r100 = this.f315493b.f323921f.getLayoutParams();
        Integer r101 = Integer.valueOf(this.f315493b.f323921f.getWidth());
        int r102 = 0;
        if (r101.intValue() <= 0) goto L5;
        boolean r103 = true;
    L6:
        ViewGroup.MarginLayoutParams r104 = null;
        if (r103 == true) goto L10;
        r101 = null;
    L10:
        if (r101 != null) goto L38;
        r101 = Integer.valueOf(r100.width);
        if (r101.intValue() <= 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == true) goto L19;
        r101 = null;
    L19:
        if (r101 != null) goto L38;
        r101 = Integer.valueOf(this.f315493b.f323921f.getMeasuredWidth());
        if (r101.intValue() <= 0) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == true) goto L28;
        r101 = null;
    L28:
        if (r101 != null) goto L38;
        r101 = Integer.valueOf(this.f315493b.E.getWidth());
        if (r101.intValue() <= 0) goto L33;
        boolean r107 = true;
    L34:
        if (r107 == true) goto L37;
        r101 = null;
    L37:
        if (r101 != null) goto L38;
        int r108 = 0;
    L41:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L43;
        r104 = (ViewGroup.MarginLayoutParams) r100;
    L43:
        if (r104 == null) goto L45;
        int r109 = r104.getMarginStart();
    L46:
        float r112 = (r108 + r109) * (1.0f - this.f315510s);
        LarusChatTitleAlignLeftStyleBinding r113 = this.f315493b;
        Iterator r114 = CollectionsKt.listOf(new View[]{r113.f323919d, r113.f323940y, r113.f323933r, r113.f323937v, r113.E}).iterator();
    L48:
        if (r114.hasNext() == false) goto L51;
        ((View) r114.next()).setAlpha(r111);
        goto L48
    L51:
        if (n6() == true) goto L53;
    L55:
        this.f315493b.f323921f.setTranslationX(r112);
        this.f315493b.E.setTranslationX(r112);
        if (this.f315510s <= 0.0f) goto L58;
        boolean r115 = true;
    L59:
        LarusChatTitleAlignLeftStyleBinding r116 = this.f315493b;
        Iterator r117 = CollectionsKt.listOf(new View[]{r116.f323919d, r116.f323940y, r116.f323933r, r116.f323937v, r116.D, r116.F}).iterator();
    L61:
        if (r117.hasNext() == false) goto L63;
        ((View) r117.next()).setEnabled(r115);
        goto L61
    L63:
        int r118 = this.f315493b.f323933r.getChildCount();
    L64:
        if (r102 >= r118) goto L66;
        this.f315493b.f323933r.getChildAt(r102).setEnabled(r115);
        r102 = r102 + 1;
        goto L64
    L66:
        return;
    L58:
        r115 = false;
        goto L59
    L53:
        if ((this.S & 4) == 0) goto L55;
        this.f315493b.f323921f.setAlpha(1.0f);
        goto L55
    L45:
        r109 = 0;
        goto L46
    L33:
        r107 = false;
        goto L34
    L24:
        r106 = false;
        goto L25
    L15:
        r105 = false;
    L38:
        r108 = r101.intValue();
        goto L41
    L5:
        r103 = false;
        goto L6
    }

    public final boolean s6(ChatTitleBarIcon r100) {
        Set<? extends ChatTitleBarIcon> r101 = this.f315507p;
        if (r101 != null) goto L5;
        return true;
    L5:
        boolean r102 = false;
        if (r101 == null) goto L11;
        if (r101.contains(r100) == true) goto L11;
        r102 = true;
    L11:
        return !r102;
    }

    public void setAddBotEnabled(boolean r100) {
        if (r100 != this.K) goto L5;
        return;
    L5:
        this.K = r100;
        if (r100 == false) goto L8;
        this.f315493b.f323917b.clearColorFilter();
        return;
    L8:
        this.f315493b.f323917b.setColorFilter(ContextCompat.getColor(getContext(), R.color.neutral_30));
    }

    public final void setArrowVisible(boolean r100) {
        if (r100 == false) goto L4;
        com.larus.utils.e1.x(this.f315493b.f323922g);
        return;
    L4:
        com.larus.utils.e1.o(this.f315493b.f323922g);
    }

    @Override // com.larus.platform.api.g0
    public void setAudioBtnEnabled(boolean r100) {
        if (this.C == r100) goto L6;
        this.C = r100;
        this.f315493b.D.setAlpha(1.0f);
        this.f315493b.f323934s.setAlpha(1.0f);
        return;
    }

    public void setAvatarClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // com.larus.platform.api.g0
    public void setBackBtnEnabled(boolean r100) {
        if (r100 != this.I) goto L5;
        return;
    L5:
        this.I = r100;
        if (r100 == false) goto L8;
        this.f315493b.f323919d.clearColorFilter();
        return;
    L8:
        this.f315493b.f323919d.setColorFilter(ContextCompat.getColor(getContext(), R.color.neutral_30));
    }

    @Override // com.larus.platform.api.g0
    public void setBackIconRes(int r100) {
        this.f315493b.f323919d.setImageResource(r100);
    }

    @Override // com.larus.platform.api.g0
    public void setBackIconVisible(boolean r100) {
        if (s6(ChatTitleBarIcon.BACK) == false) goto L5;
    L8:
        if (r100 == false) goto L10;
        this.f315493b.f323919d.setVisibility(0);
        return;
    L10:
        this.f315493b.f323919d.setVisibility(4);
        return;
    L5:
        if (s6(ChatTitleBarIcon.COLLAPSE) == true) goto L8;
        com.larus.utils.e1.o(this.f315493b.f323919d);
    }

    @Override // com.larus.platform.api.g0
    public void setCreateNewCvsClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        xo8.a r101 = this.f315492a;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.c(r101.f564685a, r100);
    L5:
        com.larus.utils.e1.c(this.f315493b.f323925j, r100);
    }

    public final void setCreateNewCvsForceHidden(boolean r100) {
        if (this.f315508q == r100) goto L6;
        this.f315508q = r100;
        l7("isCreateNewCvsForceHidden", false);
        return;
    }

    @Deprecated(message = "使用 IChatUIBlockAbility 通过 vContext.getAbility() 配置化控制 TitleBar 按钮显隐", replaceWith = @ReplaceWith(expression = "vContext.getAbility(IChatUIBlockAbility::class.java)?.isBlocked(ChatUIBlockConfig.HIDE_TITLE_BAR_BUTTONS)", imports = {}))
    public void setCvsOnlyRead(boolean r100) {
        if (this.f315499h == r100) goto L31;
        this.f315499h = r100;
        LottieAdapterView r101 = this.f315493b.D;
        com.larus.platform.service.z2 r102 = com.larus.platform.service.z2.f365865a;
        boolean r103 = true;
        int r104 = 0;
        if (r102.m3() == false) goto L10;
        if (r100 == true) goto L10;
        if (s6(ChatTitleBarIcon.TTS) == false) goto L10;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        int r106 = 0;
    L15:
        r101.setVisibility(r106);
        FrameLayout r107 = this.f315493b.f323935t;
        if (this.F == false) goto L25;
        if (r100 == true) goto L25;
        if (n6() == false) goto L23;
        if (r102.e4() == false) goto L25;
    L23:
        if (s6(ChatTitleBarIcon.REAL_TIME_CALL) == false) goto L25;
    L26:
        if (r103 == true) goto L29;
        r104 = 8;
    L29:
        r107.setVisibility(r104);
        return;
    L25:
        r103 = false;
        goto L26
    L14:
        r106 = 8;
    L10:
        r105 = false;
        goto L12
    }

    @Override // com.larus.platform.api.g0
    public void setDotEnable(boolean r100) {
        this.E = r100;
        this.f315493b.f323920e.setDotInvisible(!r100);
    }

    @Override // com.larus.platform.api.g0
    public void setEarphoneState(lq9.q r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(this.f315517z, r100) == true) goto L6;
        this.f315517z = r100;
        V6();
        return;
    }

    public final void setForceHideBack(boolean r100) {
        this.f315504m = r100;
    }

    public final void setForceHideSearch(boolean r100) {
        this.f315505n = r100;
        if (this.Q == false) goto L6;
        l7("setForceHideSearch", false);
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setHasAddBot(boolean r100) {
        boolean r101 = this.f315515x;
        if (r100 != r101) goto L6;
        return;
    L6:
        if (r101 == false) goto L12;
        if (r100 == true) goto L12;
        setClickable(false);
        AppCompatImageView r102 = this.f315493b.f323917b;
        if (r102 == null) goto L11;
        r102.setImageResource(v19.c.b(R.attr.larus_ic_bot_check, r102.getContext(), R.drawable.larus_ic_bot_check));
    L11:
        postDelayed(new i1(this), 1000);
        return;
    L12:
        if (r100 == false) goto L16;
        AppCompatImageView r103 = this.f315493b.f323917b;
        if (r103 == null) goto L16;
        r103.setImageResource(v19.c.b(R.attr.ic_bot_add, r103.getContext(), R.drawable.ic_bot_add));
    L16:
        this.f315515x = r100;
        l7("hasAddBot", false);
    }

    @Override // com.larus.platform.api.g0
    public void setHasMore(boolean r100) {
        if (this.f315513v == r100) goto L6;
        this.f315513v = r100;
        l7("hasMore", false);
        return;
    }

    public final void setHistoryChecked(boolean r100) {
        this.P = r100;
        if (r100 == false) goto L5;
        int r101 = R.drawable.larus_ic_history_open;
    L6:
        this.f315493b.f323923h.setImageResource(r101);
        return;
    L5:
        r101 = R.drawable.larus_ic_history_close;
        goto L6
    }

    @Override // com.larus.platform.api.g0
    public void setImmerse(boolean r100) {
        this.f315495d = r100;
        V6();
        W6();
        N6();
        if (this.f315495d == false) goto L8;
        xo8.a r101 = this.f315492a;
        if (r101 == null) goto L7;
        int r102 = getResources().getColor(R.color.larus_static_white);
        r101.f564685a.setColorFilter(r102);
    L7:
        this.f315493b.f323925j.setColorFilter(getResources().getColor(R.color.larus_static_white));
    L15:
        if (r100 == false) goto L17;
        this.f315493b.f323941z.setTextColor(ContextCompat.getColor(getContext(), R.color.static_white_transparent_4));
        this.f315493b.f323919d.setImageTintList(ContextCompat.getColorStateList(getContext(), R.color.larus_static_white));
        this.f315493b.C.setTextColor(getResources().getColor(R.color.larus_static_white));
        this.f315493b.f323922g.setImageTintList(ContextCompat.getColorStateList(getContext(), R.color.larus_static_white));
        this.f315493b.D.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(getContext(), R.color.larus_static_white), PorterDuff.Mode.SRC_IN));
        this.f315493b.F.setColorFilter(ContextCompat.getColor(getContext(), R.color.larus_static_white));
        this.f315493b.f323930o.setImageTintList(ContextCompat.getColorStateList(getContext(), R.color.larus_static_white));
        this.f315493b.f323940y.setImageTintList(ContextCompat.getColorStateList(getContext(), R.color.larus_static_white));
        this.f315493b.f323932q.setImageTintList(ContextCompat.getColorStateList(getContext(), R.color.larus_static_white));
        return;
    L17:
        com.larus.utils.e1.o(this.f315493b.f323923h);
        return;
    L8:
        xo8.a r103 = this.f315492a;
        if (r103 == null) goto L11;
        r103.f564685a.clearColorFilter();
    L11:
        xo8.a r104 = this.f315492a;
        if (r104 == null) goto L14;
        int r105 = com.larus.bmhome.utils.t.b();
        r104.f564685a.setImageResource(r105);
    L14:
        this.f315493b.f323925j.clearColorFilter();
        this.f315493b.f323925j.setImageResource(com.larus.bmhome.utils.t.b());
        goto L15
    }

    @Override // com.larus.platform.api.g0
    public void setIsLocalSubConvChange(boolean r100) {
        setLocalSubConv(r100);
    }

    @Override // com.larus.platform.api.g0
    public void setMainBot(boolean r100) {
        this.D = r100;
        N6();
        V6();
        W6();
        l7("isMainBot", false);
    }

    @Override // com.larus.platform.api.g0
    public void setMoreBtnEnabled(boolean r100) {
        if (r100 != this.f315514w) goto L5;
        return;
    L5:
        this.f315514w = r100;
        if (r100 == false) goto L8;
        this.f315493b.f323930o.clearColorFilter();
        return;
    L8:
        this.f315493b.f323930o.setColorFilter(ContextCompat.getColor(getContext(), R.color.neutral_30));
    }

    public final void setNowHalfStyle(boolean r100) {
        this.f315503l = r100;
    }

    @Override // com.larus.platform.api.g0
    public void setOnAddBotClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.c(this.f315493b.f323917b, r100);
    }

    @Override // com.larus.platform.api.g0
    public void setOnBackClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.d(this.f315493b.f323919d, new r1(r100));
    }

    @Override // com.larus.platform.api.g0
    public void setOnChatHistoryCheckedListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.c(this.f315493b.f323923h, r100);
    }

    @Override // com.larus.platform.api.g0
    public void setOnMainClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.d(this.f315493b.f323926k, new d1(this, r100));
    }

    @Override // com.larus.platform.api.g0
    public void setOnMoreClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.c(this.f315493b.f323930o, r100);
    }

    @Override // com.larus.platform.api.g0
    public void setOnMultitaskClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.c(this.f315493b.f323932q, r100);
    }

    @Override // com.larus.platform.api.g0
    public void setOnSearchClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.c(this.f315493b.f323937v, r100);
    }

    @Override // com.larus.platform.api.g0
    public void setOnSideNavClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.c(this.f315493b.f323940y, r100);
    }

    @Override // com.larus.platform.api.g0
    public void setOnTtsCheckedListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.d(this.f315493b.D, new f1(this, r100));
    }

    @Override // com.larus.platform.api.g0
    public void setOnTtsContinuousTalkCheckedListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.d(this.f315493b.F, new e1(this, r100));
    }

    @Override // com.larus.platform.api.g0
    public void setOnTtsContinuousTalkLongClickListener(final Function1<? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "longClickAction");
        this.f315493b.F.setOnLongClickListener(new p1(r100));
    }

    @Override // com.larus.platform.api.g0
    public void setOnTtsLongPressAction(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "longClickAction");
        this.f315493b.D.setOnLongClickListener(new k1(r100));
    }

    @Override // com.larus.platform.api.g0
    public void setRealTimeCallVisible(boolean r100) {
        if (this.F == r100) goto L10;
        FLogger.f375446a.i("tts_isGray", "isRealTimeCallVisible setter: " + this.F + " -> " + r100 + '\n' + ExceptionsKt.stackTraceToString(new Throwable()));
        if (this.F == true) goto L8;
        if (r100 == false) goto L8;
        tx9.c3.c(RealtimeCallEntry.CHAT_TITLE_BAR);
    L8:
        this.F = r100;
        l7("isRealTimeCallVisible", false);
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setRealtimeCallBtnClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.d(this.f315493b.f323935t, new c1(r100, this));
    }

    @Override // com.larus.platform.api.g0
    public void setRealtimeCallVisibleHookShow(boolean r100) {
        if (this.G == r100) goto L6;
        this.G = r100;
        l7("isRealtimeCallVisibleHookShow", false);
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setRedDotBGType(int r100) {
        this.f315493b.f323920e.setRedDotBG(r100);
    }

    @Override // com.larus.platform.api.g0
    public void setRedDotUnreadCount(int r100) {
        if (com.larus.platform.service.z2.f365865a.getChatNavigatorConfig().f486630g != 1) goto L6;
        this.f315493b.f323920e.setForceCircleBadgeDiameter(Integer.valueOf(i5.v()));
        this.f315493b.f323920e.setTextSize(0, i5.g());
        RedDotTextView r101 = this.f315493b.f323920e;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        ((ViewGroup.MarginLayoutParams) r103).width = i5.v();
        ((ViewGroup.MarginLayoutParams) r103).height = i5.v();
        r103.setMarginStart(((Number) i5.F.getValue()).intValue());
        r101.setLayoutParams(r103);
        FLogger.f375446a.i("tts_isGray", "[setRedDotUnreadCount] apply experimental badge style, count=" + r100);
    L6:
        if (this.f315495d == false) goto L8;
        this.f315493b.f323920e.A(r100);
        return;
    L8:
        this.f315493b.f323920e.z(r100);
    }

    @Override // com.larus.platform.api.g0
    public void setRedDotViewClickListener(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.utils.e1.d(this.f315493b.f323920e, new g1(r100));
    }

    @Override // com.larus.platform.api.g0
    public void setRedDotViewVisible(boolean r100) {
        if (r100 == false) goto L4;
        this.f315493b.f323920e.setVisibility(0);
        return;
    L4:
        this.f315493b.f323920e.setVisibility(4);
    }

    @Override // com.larus.platform.api.g0
    public void setRedDotVisible(boolean r100) {
        if (this.H == r100) goto L10;
        this.H = r100;
        TextView r101 = this.f315493b.f323936u;
        if (r100 == false) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 8;
        goto L8
    }

    public final void setReviewSubTitle(int r100) {
        TextView r101 = this.f315493b.f323941z;
        if (r100 != (-50)) goto L5;
    L13:
        r101.setText(r101.getContext().getString(R.string.larus_tag_review_failed));
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.larus_danger_50));
    L14:
        Intrinsics.checkNotNull(r101);
        r101.setVisibility(0);
        return;
    L5:
        if (r100 == (-30)) goto L13;
        if (r100 != (-20)) goto L14;
        r101.setText(r101.getContext().getString(R.string.larus_under_review));
        if (this.f315495d == false) goto L12;
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), R.color.static_white_transparent_4));
        goto L14
    L12:
        r101.setTextColor(ContextCompat.getColor(r101.getContext(), v19.c.b(R.attr.larus_neutral_50, r101.getContext(), R.color.larus_neutral_50)));
        goto L14
    }

    public void setSearchIcon(int r100) {
        if (r100 != 0) goto L4;
        this.f315493b.f323938w.setImageResource(R.drawable.larus_ic_chat_title_search);
        return;
    L4:
        this.f315493b.f323938w.setImageResource(r100);
    }

    public void setSearchIconRedDotVisible(boolean r100) {
        View r101 = this.f315493b.f323939x;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setShowHistory(boolean r100) {
        if (this.O == r100) goto L14;
        this.O = r100;
        int r101 = 0;
        l7("showHistory", false);
        if (this.f315493b.f323923h.getVisibility() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        r101 = i5.u0();
    L11:
        if (this.f315498g == false) goto L15;
        this.f315493b.C.setMaxWidth((com.larus.utils.i.d(getContext()) - (i5.d() * 2)) - r101);
        return;
    L15:
        return;
    L7:
        r102 = false;
        goto L8
    }

    public void setSideNavIconVisible(boolean r100) {
        this.f315506o = r100;
        int r101 = 0;
        if (this.Q == false) goto L5;
        l7("setSideNavIconVisible", false);
        return;
    L5:
        AppCompatImageView r102 = this.f315493b.f323940y;
        if (f7() == true) goto L9;
        r101 = 8;
    L9:
        r102.setVisibility(r101);
    }

    @Override // com.larus.platform.api.g0
    public void setStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "status");
        TextView r101 = this.f315493b.f323941z;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        Intrinsics.checkNotNull(r101);
        r101.setVisibility(8);
    L9:
        r101.setClickable(false);
        return;
    L8:
        Intrinsics.checkNotNull(r101);
        r101.setVisibility(0);
        r101.setText(r100);
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public final void setTabAlignment(boolean r100) {
        ViewGroup.LayoutParams r101 = this.f315493b.A.getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
    L7:
        if (r100 == false) goto L12;
        if (r102 == null) goto L10;
        r102.startToStart = 0;
    L10:
        if (r102 == null) goto L18;
        r102.endToEnd = 0;
    L18:
        if (r102 == null) goto L20;
        r102.topToTop = 0;
    L20:
        if (r102 == null) goto L22;
        r102.bottomToBottom = 0;
    L22:
        this.f315493b.A.setLayoutParams(r102);
        return;
    L12:
        if (r102 == null) goto L14;
        r102.startToEnd = this.f315493b.f323919d.getId();
    L14:
        if (r102 == null) goto L16;
        r102.endToStart = this.f315493b.f323927l.getId();
    L16:
        if (r102 == null) goto L18;
        r102.horizontalBias = 0.0f;
        goto L18
    L5:
        r102 = null;
        goto L7
    }

    public final void setTabView(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "names");
        this.R = true;
        com.larus.utils.e1.o(this.f315493b.f323926k);
        this.f315493b.A.addOnTabSelectedListener(new e(this));
        Iterator<String> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        TabLayout.Tab r103 = this.f315493b.A.newTab();
        r103.setCustomView(R.layout.larus_multi_col_title);
        View r104 = r103.getCustomView();
        if (r104 == null) goto L10;
        TextView r105 = (TextView) r104.findViewById(R.id.tv_title);
        if (r105 == null) goto L10;
        r105.setText(r102);
    L10:
        this.f315493b.A.addTab(r103);
        goto L4
    }

    public final void setTitleBarIconAnimationProgressProvider(qy8.e r100) {
        float r101 = 1.0f;
        if (r100 == null) goto L5;
        r101 = RangesKt.coerceIn(r100.a(), 0.0f, 1.0f);
    L5:
        this.f315510s = r101;
        if (r100 == null) goto L9;
        r100.b();
    L9:
        if (this.Q == false) goto L11;
        l7("setTitleBarIconAnimationProgressProvider", false);
        return;
    L11:
        Y5(this.f315510s);
    }

    public final void setTitleBarVisibleIcons(Set<? extends ChatTitleBarIcon> r100) {
        if (r100 == null) goto L4;
        Set<? extends ChatTitleBarIcon> r101 = CollectionsKt.toSet(r100);
    L5:
        this.f315507p = r101;
        if (r101 != null) goto L8;
    L11:
        com.larus.utils.e1.x(this.f315493b.f323919d);
    L12:
        if (r101 != null) goto L14;
    L15:
        com.larus.utils.e1.x(this.f315493b.E);
    L17:
        if (this.Q == false) goto L19;
        l7("setTitleBarVisibleIcons", false);
        return;
    L19:
        Z5();
        return;
    L14:
        if (r101.contains(ChatTitleBarIcon.TTS) == false) goto L17;
    L8:
        if (r101.contains(ChatTitleBarIcon.BACK) == true) goto L11;
        if (r101.contains(ChatTitleBarIcon.COLLAPSE) == false) goto L12;
    L4:
        r101 = null;
        goto L5
    }

    public final void setTopLeftCreateNewCvsAvailable(boolean r100) {
        if (this.f315509r == r100) goto L6;
        this.f315509r = r100;
        l7("isTopLeftCreateNewCvsAvailable", false);
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setTtsBanned(boolean r100) {
        if (this.A == r100) goto L6;
        this.A = r100;
        V6();
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setTtsChecked(boolean r100) {
        if (this.f315516y == r100) goto L6;
        this.f315516y = r100;
        V6();
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setTtsContinuousTalkChecked(boolean r100) {
        if (this.M == r100) goto L6;
        this.M = r100;
        W6();
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setTtsContinuousTalkEnabled(boolean r100) {
        if (r100 != this.f315491J) goto L5;
        return;
    L5:
        this.f315491J = r100;
        if (r100 == false) goto L8;
        this.f315493b.F.clearColorFilter();
        return;
    L8:
        this.f315493b.F.setColorFilter(ContextCompat.getColor(getContext(), R.color.neutral_30));
    }

    @Override // com.larus.platform.api.g0
    public void setTtsContinuousTalkVisible(boolean r100) {
        if (this.L == r100) goto L6;
        this.L = r100;
        l7("isTtsContinuousTalkVisible", false);
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setTtsGrey(boolean r100) {
        if (this.B == r100) goto L6;
        this.B = r100;
        V6();
        return;
    }

    @Override // com.larus.platform.api.g0
    public void setTtsVisible(boolean r100) {
        if (this.N == r100) goto L6;
        this.N = r100;
        l7("isTtsVisible", false);
        return;
    }

    public final void setupWithViewPager(ViewPager2 r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f315493b.A.addOnTabSelectedListener(new f(r100));
        r100.registerOnPageChangeCallback(new AnonymousClass2(this));
    }

    public ChatTitleAlignLeftStyle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LarusChatTitleAlignLeftStyleBinding r102 = LarusChatTitleAlignLeftStyleBinding.a(LayoutInflater.from(getContext()), this);
        AppCompatImageView r103 = r102.f323921f;
        ViewParent r104 = r103.getParent();
        if ((r104 instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r105 = (ConstraintLayout) r104;
    L5:
        this.f315492a = new xo8.a(r103);
        com.larus.utils.e1.d(r102.D, new s1(this));
        this.f315493b = r102;
        this.f315494c = LazyKt.lazy(new t1(this));
        this.f315497f = LazyKt.lazy(new u1(this));
        com.larus.platform.service.z2 r106 = com.larus.platform.service.z2.f365865a;
        this.f315498g = r106.getChatNavigatorConfig().f486625b;
        this.f315500i = r106.ttsSwitchConfig().b();
        this.f315501j = "lottie/text_msg_voice_playing.json";
        this.f315502k = "lottie/text_msg_voice_playing_white.json";
        this.f315510s = 1.0f;
        this.f315511t = LazyKt.lazy(new v1(this));
        new g();
        this.f315512u = LazyKt.lazy(new w1());
        this.f315513v = true;
        this.f315514w = true;
        boolean r107 = false;
        this.f315517z = new lq9.q(false, false);
        this.C = true;
        this.E = true;
        if (r106.R1().getRealtimeCallBtnShowTopRight() == true) goto L15;
        IFlowSdkDepend r108 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r108 == null) goto L12;
        r108.S();
        if (com.larus.home.impl.sdk.c1.f346148a.a() != true) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == true) goto L15;
    L25:
        this.F = r107;
        this.I = true;
        this.f315491J = true;
        this.K = true;
        this.M = true;
        this.N = true;
        this.S = 31;
        if (getId() != (-1)) goto L29;
        setId(R.id.chat_title_align_left_style_view);
        return;
    L29:
        return;
    L12:
        r109 = false;
    L15:
        if (r106.g() == false) goto L25;
        if (VoiceCallServiceDelegate.f377087a.z(1) == true) goto L25;
        if (com.larus.platform.service.x1.f365857a.a() == false) goto L23;
        if (AppHost.f326268a.isOversea() == true) goto L25;
    L23:
        if (AudioServiceDelegate.f288288a.getAudioConfig().B(this.D) == true) goto L25;
        r107 = true;
        goto L25
    }

    public final void C6(String r100, @ChatSubTitleStyle int r101) {
        TextView r102 = this.f315493b.f323941z;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
    L36:
        setSubtitleVisible(false);
        return;
    L11:
        if (o6() == false) goto L36;
        setSubtitleVisible(true);
        if (r101 != 0) goto L16;
        r102.setText(r100);
        if (this.f315495d == false) goto L33;
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), R.color.static_white_transparent_4));
    L34:
        r102.setTextSize(0, i5.h());
        return;
    L33:
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), v19.c.b(R.attr.larus_neutral_70, r102.getContext(), R.color.larus_neutral_70)));
        goto L34
    L16:
        if (r101 != 1) goto L18;
        r102.setText(r100);
        if (this.f315495d == false) goto L28;
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), R.color.static_white_transparent_4));
    L29:
        r102.setTextSize(0, i5.g());
        return;
    L28:
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), v19.c.b(R.attr.larus_neutral_50, r102.getContext(), R.color.larus_neutral_50)));
        goto L29
    L18:
        if (r101 != 2) goto L40;
        r102.setText(r100);
        if (this.f315495d == false) goto L23;
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), R.color.static_white_transparent_4));
    L24:
        r102.setTextSize(0, i5.h());
        return;
    L23:
        r102.setTextColor(ContextCompat.getColor(r102.getContext(), v19.c.b(R.attr.larus_neutral_50, r102.getContext(), R.color.larus_neutral_50)));
        goto L24
    L40:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.larus.platform.api.g0
    public final void Na(Integer r100, CharSequence r101) {
        if (r100 == null) goto L11;
        Drawable r102 = ContextCompat.getDrawable(getContext(), r100.intValue());
        if (r102 == null) goto L9;
        Drawable r103 = r102.mutate();
        if (r103 == null) goto L9;
        r103.setBounds(0, 0, i5.h(), i5.h());
    L10:
        this.f315493b.f323941z.setCompoundDrawablePadding(i5.Y());
        this.f315493b.f323941z.setCompoundDrawablesRelative(r103, null, null, null);
    L12:
        if (r101 == null) goto L15;
        this.f315493b.f323941z.setText(r101);
        return;
    L15:
        return;
    L9:
        r103 = null;
        goto L10
    L11:
        this.f315493b.f323941z.setCompoundDrawablesRelative(null, null, null, null);
        goto L12
    }

    public final void l7(String r110, boolean r111) {
        FLogger.f375446a.i("tts_isGray", "updateAllIconVisibility: ".concat(r110));
        ArrayList r112 = new ArrayList();
        ArrayList r100 = new ArrayList();
        boolean r101 = false;
        if (this.f315498g == false) goto L31;
        com.larus.platform.service.z2 r102 = com.larus.platform.service.z2.f365865a;
        if (r102.getAppsFrameworkConfig().f486665d == true) goto L7;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L16;
        r112.add(this.f315493b.f323932q);
        r100.add(this.f315493b.f323937v);
        goto L31
    L16:
        r100.add(this.f315493b.f323932q);
        if (r102.getChatNavigatorConfig().f486627d == true) goto L19;
    L25:
        boolean r104 = false;
    L26:
        if (r104 == false) goto L28;
        ArrayList r105 = r112;
    L29:
        r105.add(this.f315493b.f323937v);
        goto L31
    L28:
        r105 = r100;
        goto L29
    L19:
        if (f7() == true) goto L25;
        if (r102.e4() == true) goto L25;
        if (s6(ChatTitleBarIcon.SEARCH) == false) goto L25;
        r104 = true;
        goto L26
    L7:
        if (r102.getMultiTaskEntranceConfig().d() == true) goto L13;
        if (AccountService.f365697a.a() == true) goto L13;
        if (s6(ChatTitleBarIcon.MULTITASK_MANAGEMENT) == false) goto L13;
        r103 = true;
    L31:
        if (f7() == false) goto L33;
        r112.add(this.f315493b.f323940y);
    L35:
        if (getHasMore() == true) goto L37;
    L47:
        boolean r106 = false;
    L48:
        if (r106 == false) goto L50;
        r112.add(this.f315493b.f323930o);
    L52:
        if (getHasAddBot() == true) goto L54;
    L62:
        boolean r107 = false;
    L63:
        if (r107 == false) goto L65;
        r112.add(this.f315493b.f323917b);
    L66:
        com.larus.platform.service.z2 r108 = com.larus.platform.service.z2.f365865a;
        if (r108.m3() == true) goto L69;
    L75:
        boolean r109 = false;
    L76:
        if (r109 == false) goto L78;
        r112.add(this.f315493b.D);
    L79:
        boolean r113 = r108.e4();
        if (this.f315508q == false) goto L82;
    L86:
        boolean r114 = false;
    L88:
        if (this.D == false) goto L94;
        if (r113 == false) goto L94;
        if (r114 == false) goto L94;
        if (this.f315509r == false) goto L94;
        boolean r115 = true;
    L96:
        if (n6() == false) goto L100;
        if (r113 == true) goto L100;
        if (r114 == false) goto L100;
        boolean r116 = true;
    L101:
        FrameLayout r117 = this.f315493b.f323933r;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
        if (r115 == false) goto L104;
        int r120 = this.f315493b.f323925j.getId();
    L105:
        r119.startToEnd = r120;
        r117.setLayoutParams(r119);
        if (this.f315498g == true) goto L112;
        ConstraintLayout r121 = this.f315493b.f323926k;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r123 = (ConstraintLayout.LayoutParams) r122;
        if (r115 == false) goto L110;
        r123.startToStart = -1;
        r123.startToEnd = this.f315493b.f323924i.getId();
        r123.setMarginStart(i5.j0());
    L111:
        r121.setLayoutParams(r123);
        goto L112
    L110:
        r123.startToEnd = -1;
        r123.startToStart = 0;
        r123.setMarginStart(i5.i0());
    L112:
        if (r115 == false) goto L114;
        r112.add(this.f315493b.f323925j);
    L115:
        xo8.a r124 = this.f315492a;
        if (r124 == null) goto L124;
        List r125 = CollectionsKt.listOf(r124.f564685a);
        if (r125 == null) goto L124;
        if (r116 == false) goto L121;
        ArrayList r126 = r112;
    L122:
        r126.addAll(r125);
        goto L124
    L121:
        r126 = r100;
    L124:
        if (this.F == true) goto L126;
    L139:
        boolean r127 = false;
    L140:
        if (r127 == false) goto L142;
        r112.add(this.f315493b.f323935t);
    L144:
        if (this.O == true) goto L146;
    L150:
        boolean r128 = false;
    L151:
        if (r128 == false) goto L153;
        r112.add(this.f315493b.f323923h);
    L155:
        if (this.L == true) goto L157;
    L161:
        if (r101 == false) goto L163;
        r112.add(this.f315493b.F);
    L164:
        Iterator r129 = r112.iterator();
    L166:
        if (r129.hasNext() == false) goto L171;
        View r130 = (View) r129.next();
        r130.animate().cancel();
        if (r111 == true) goto L169;
        com.larus.utils.e1.x(r130);
        goto L166
    L169:
        com.larus.utils.e1.h(r130, 250);
        goto L166
    L171:
        Iterator r131 = r100.iterator();
    L173:
        if (r131.hasNext() == false) goto L178;
        View r132 = (View) r131.next();
        r132.animate().cancel();
        if (r111 == true) goto L176;
        com.larus.utils.e1.o(r132);
        goto L173
    L176:
        com.larus.utils.e1.i(r132, 250);
        goto L173
    L178:
        IFlowChatThemeConfigProvider r133 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r133 == null) goto L181;
        r133.b(this.f315493b.f323935t, AdaptThemeFeatureKey.CHAT_NAV_REALTIME_CALL);
    L181:
        if (r113 == true) goto L186;
        if (r114 == false) goto L186;
        IFlowChatThemeConfigProvider r134 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r134 == null) goto L186;
        r134.c(this.f315493b.f323921f, AdaptThemeFeatureKey.CHAT_NAV_CREATE_NEW_CVS);
    L186:
        com.larus.platform.service.z2 r135 = com.larus.platform.service.z2.f365865a;
        r135.w3();
        if (this.f315503l == false) goto L192;
        if (r135.getChatNavigatorConfig().f486632i == false) goto L192;
        com.larus.utils.e1.o(this.f315493b.E);
    L192:
        if (this.f315503l == false) goto L197;
        if (r135.getChatNavigatorConfig().f486633j == false) goto L197;
        com.larus.utils.e1.o(this.f315493b.f323919d);
    L197:
        if (this.f315505n == false) goto L200;
        com.larus.utils.e1.o(this.f315493b.f323937v);
    L200:
        if (this.f315504m == false) goto L203;
        com.larus.utils.e1.o(this.f315493b.f323919d);
    L203:
        if (this.f315507p == null) goto L206;
        Z5();
        Y5(this.f315510s);
    L206:
        if (f7() == false) goto L208;
        com.larus.utils.e1.o(this.f315493b.f323937v);
    L208:
        final wt8.o r136 = getHalfScreenInteractionHelper();
        if (r136.f561252b == false) goto L212;
        r136.f561251a.f323916a.post(new wt8.n(r136));
    L212:
        getHalfScreenInteractionHelper().b();
        o7();
        return;
    L163:
        r100.add(this.f315493b.F);
        goto L164
    L157:
        if ((this.S & 2) == 0) goto L161;
        if (s6(ChatTitleBarIcon.TTS) == false) goto L161;
        r101 = true;
        goto L161
    L153:
        r100.add(this.f315493b.f323923h);
        goto L155
    L146:
        if ((this.S & 16) == 0) goto L150;
        if (s6(ChatTitleBarIcon.HISTORY) == false) goto L150;
        r128 = true;
        goto L151
    L142:
        r100.add(this.f315493b.f323935t);
        goto L144
    L126:
        if (this.f315499h == true) goto L139;
        if (n6() == false) goto L131;
        if (r113 == false) goto L139;
    L131:
        if (r108.getChatNavigatorConfig().f486628e == false) goto L139;
        if ((this.S & 8) == 0) goto L139;
        if (k6() == true) goto L139;
        if (s6(ChatTitleBarIcon.REAL_TIME_CALL) == false) goto L139;
        r127 = true;
        goto L140
    L114:
        r100.add(this.f315493b.f323925j);
        goto L115
    L104:
        r120 = this.f315493b.f323919d.getId();
    L100:
        r116 = false;
    L94:
        r115 = false;
        goto L96
    L82:
        if ((this.S & 4) == 0) goto L86;
        if (s6(ChatTitleBarIcon.NEW_CONVERSATION) == false) goto L86;
        r114 = true;
        goto L88
    L78:
        r100.add(this.f315493b.D);
        goto L79
    L69:
        if ((this.S & 2) == 0) goto L75;
        if (this.N == false) goto L75;
        if (s6(ChatTitleBarIcon.TTS) == false) goto L75;
        r109 = true;
        goto L76
    L65:
        r100.add(this.f315493b.f323917b);
        goto L66
    L54:
        if (this.f315498g == false) goto L58;
        if (this.R == false) goto L62;
    L58:
        if ((this.S & 1) == 0) goto L62;
        if (s6(ChatTitleBarIcon.ADD_BOT) == false) goto L62;
        r107 = true;
        goto L63
    L50:
        r100.add(this.f315493b.f323930o);
        goto L52
    L37:
        if (this.f315498g == false) goto L43;
        if (this.R == true) goto L43;
        if (com.larus.platform.service.z2.f365865a.getChatNavigatorConfig().f486629f == false) goto L47;
    L43:
        if ((this.S & 1) == 0) goto L47;
        if (s6(ChatTitleBarIcon.MORE) == false) goto L47;
        r106 = true;
        goto L48
    L33:
        r100.add(this.f315493b.f323940y);
        goto L35
    }

    public final void u6(String r100, final PipelineDraweeControllerBuilder r101) {
        FLogger.f375446a.i("tts_isGray", "loadImage chat.bot_avatar url=" + r100);
        ImageLoaderKt.w(this.f315493b.f323918c, r100, "chat.bot_avatar", new n1(r101), null);
    }

    public ChatTitleAlignLeftStyle(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LarusChatTitleAlignLeftStyleBinding r103 = LarusChatTitleAlignLeftStyleBinding.a(LayoutInflater.from(getContext()), this);
        AppCompatImageView r104 = r103.f323921f;
        ViewParent r105 = r104.getParent();
        if ((r105 instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r106 = (ConstraintLayout) r105;
    L5:
        this.f315492a = new xo8.a(r104);
        com.larus.utils.e1.d(r103.D, new s1(this));
        this.f315493b = r103;
        this.f315494c = LazyKt.lazy(new t1(this));
        this.f315497f = LazyKt.lazy(new u1(this));
        com.larus.platform.service.z2 r107 = com.larus.platform.service.z2.f365865a;
        this.f315498g = r107.getChatNavigatorConfig().f486625b;
        this.f315500i = r107.ttsSwitchConfig().b();
        this.f315501j = "lottie/text_msg_voice_playing.json";
        this.f315502k = "lottie/text_msg_voice_playing_white.json";
        this.f315510s = 1.0f;
        this.f315511t = LazyKt.lazy(new v1(this));
        new g();
        this.f315512u = LazyKt.lazy(new w1());
        this.f315513v = true;
        this.f315514w = true;
        boolean r108 = false;
        this.f315517z = new lq9.q(false, false);
        this.C = true;
        this.E = true;
        if (r107.R1().getRealtimeCallBtnShowTopRight() == true) goto L15;
        IFlowSdkDepend r109 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r109 == null) goto L12;
        r109.S();
        if (com.larus.home.impl.sdk.c1.f346148a.a() != true) goto L12;
        boolean r110 = true;
    L13:
        if (r110 == true) goto L15;
    L25:
        this.F = r108;
        this.I = true;
        this.f315491J = true;
        this.K = true;
        this.M = true;
        this.N = true;
        this.S = 31;
        if (getId() != (-1)) goto L29;
        setId(R.id.chat_title_align_left_style_view);
        return;
    L29:
        return;
    L12:
        r110 = false;
    L15:
        if (r107.g() == false) goto L25;
        if (VoiceCallServiceDelegate.f377087a.z(1) == true) goto L25;
        if (com.larus.platform.service.x1.f365857a.a() == false) goto L23;
        if (AppHost.f326268a.isOversea() == true) goto L25;
    L23:
        if (AudioServiceDelegate.f288288a.getAudioConfig().B(this.D) == true) goto L25;
        r108 = true;
        goto L25
    }

    @Override // com.larus.platform.api.g0
    public void Ia(String r100, final com.larus.platform.api.j r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        if (this.R == false) goto L5;
        return;
    L5:
        this.f315493b.f323926k.setVisibility(0);
        com.larus.platform.service.z2 r103 = com.larus.platform.service.z2.f365865a;
        r103.w3();
        boolean r104 = true;
        if (com.larus.utils.o0.d(r100) == false) goto L15;
        r103.w3();
        if (r102 == false) goto L14;
        int r105 = com.larus.utils.j0.f375426a;
        if (Intrinsics.areEqual(r100, com.larus.utils.j0.d(R.string.larus_new_chat_default)) == false) goto L14;
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L14;
        r100 = com.larus.utils.j0.d(R.string.larus_new_task_cn);
    L14:
        this.f315493b.C.setText(r100);
        ConstraintLayout r106 = this.f315493b.f323926k;
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        int r108 = com.larus.utils.j0.f375426a;
        r106.setContentDescription(String.format(com.larus.utils.j0.d(R.string.larus_accessibility_titleBar_botName), Arrays.copyOf(new Object[]{r100}, 1)));
    L15:
        Drawable r109 = null;
        if (r101 == null) goto L18;
        String r110 = r101.f365163a;
    L19:
        if (r110 != null) goto L21;
    L24:
        if (r104 == false) goto L26;
        this.f315493b.B.setVisibility(8);
    L61:
        post(new j1(r101, this));
        return;
    L26:
        b r111 = getDefaultTagStyle();
        ColorStateList r112 = r111.f315518a;
        if (r112 == null) goto L29;
        this.f315493b.B.setTextColor(r112);
    L29:
        TextView r113 = this.f315493b.B;
        Drawable.ConstantState r114 = r111.f315519b;
        if (r114 == null) goto L34;
        Drawable r115 = r114.newDrawable();
        if (r115 == null) goto L34;
        r109 = r115.mutate();
    L34:
        r113.setBackground(r109);
        this.f315493b.B.setTextSize(0, r111.f315520c);
        this.f315493b.B.setPaddingRelative(r111.f315521d, r111.f315522e, r111.f315523f, r111.f315524g);
        this.f315493b.B.setTypeface(r111.f315525h);
        this.f315493b.B.setGravity(r111.f315526i);
        this.f315493b.B.setVisibility(0);
        this.f315493b.B.setText(r101.f365163a);
        Integer r116 = r101.f365164b;
        if (r116 == null) goto L37;
        this.f315493b.B.setTextColor(ContextCompat.getColor(getContext(), r116.intValue()));
    L37:
        Integer r117 = r101.f365165c;
        if (r117 == null) goto L40;
        this.f315493b.B.setBackgroundResource(r117.intValue());
    L40:
        Float r118 = r101.f365166d;
        if (r118 == null) goto L43;
        this.f315493b.B.setTextSize(0, r118.floatValue());
    L43:
        Integer r119 = r101.f365167e;
        if (r119 == null) goto L46;
    L47:
        if (r119 == null) goto L49;
        int r120 = r119.intValue();
    L50:
        Integer r121 = r101.f365168f;
        if (r121 == null) goto L53;
        int r122 = r121.intValue();
    L54:
        this.f315493b.B.setPaddingRelative(r120, r122, r120, r122);
    L55:
        Integer r123 = r101.f365169g;
        if (r123 == null) goto L58;
        this.f315493b.B.setTypeface(Typeface.DEFAULT, r123.intValue());
    L58:
        Integer r124 = r101.f365170h;
        if (r124 == null) goto L61;
        this.f315493b.B.setGravity(r124.intValue());
        goto L61
    L53:
        r122 = this.f315493b.B.getPaddingTop();
        goto L54
    L49:
        r120 = this.f315493b.B.getPaddingStart();
        goto L50
    L46:
        if (r101.f365168f == null) goto L55;
    L21:
        if (r110.length() == 0) goto L24;
        r104 = false;
        goto L24
    L18:
        r110 = null;
        goto L19
    }

    @Override // com.larus.platform.api.g0
    public final void Sa(String r100, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "iconUri");
        Intrinsics.checkNotNullParameter(r110, "iconUrl");
        if (r111 == true) goto L5;
        return;
    L5:
        if (this.f315498g == false) goto L7;
        return;
    L7:
        if (this.R == true) goto L42;
        boolean r101 = false;
        this.f315493b.f323918c.setVisibility(0);
        if (TextUtils.isEmpty(r110) == false) goto L13;
        this.f315493b.f323918c.setActualImageResource(R.drawable.larus_common_ui_avatar_placeholder);
        this.f315496e = null;
        return;
    L13:
        String r112 = UriProtector.parse(r110).getPath();
        if (r112 == null) goto L24;
        String r113 = StringsKt.substringBefore$default(r112, ".jpg", null, 2, null);
        if (r113 == null) goto L24;
        String r114 = StringsKt.substringBefore$default(r113, RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, null, 2, null);
        if (r114 == null) goto L24;
        String r115 = StringsKt.substringBefore$default(r114, ".jpeg", null, 2, null);
        if (r115 == null) goto L24;
        String r116 = StringsKt.substringBefore$default(r115, ".webp", null, 2, null);
        if (r116 == null) goto L24;
    L26:
        if (r100.length() <= 0) goto L28;
        r101 = true;
    L28:
        if (r101 == true) goto L30;
    L32:
        this.f315496e = r116;
        this.f315493b.f323918c.getHierarchy().setFadeDuration(200);
        Object r102 = getContext();
        if ((r102 instanceof LifecycleOwner) == true) goto L35;
    L37:
        u6(r110, Fresco.newDraweeControllerBuilder());
        return;
    L35:
        if (com.larus.platform.service.z2.f365865a.isLazyMainComponentEnable() == false) goto L37;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) r102), Dispatchers.getIO(), null, new ChatTitleAlignLeftStyle$setAvatar$1(this, r110, null), 2, null);
        return;
    L30:
        if (Intrinsics.areEqual(this.f315496e, r116) == false) goto L32;
        return;
    L24:
        r116 = "";
        goto L26
    }

    @Override // com.larus.platform.api.g0
    public final void Fa(String r100, boolean r101, @ChatSubTitleStyle int r102, final View.OnClickListener r103) {
        if (r101 == true) goto L4;
        return;
    L4:
        C6(r100, r102);
        if (r103 == null) goto L7;
        com.larus.utils.e1.d(this, new q1(r103));
        return;
    L7:
        setClickable(false);
    }

    public void i6(boolean r110, String r111, boolean r112, boolean r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r111, "titleName");
        com.larus.utils.e1.x(this.f315493b.f323916a);
        this.f315493b.f323927l.setReferencedIds(new int[]{R.id.min_end_space, R.id.iv_history, R.id.real_time_call_ic_container, R.id.create_new_cvs, R.id.tts_container, R.id.more_add_bot});
        this.f315493b.f323924i.setReferencedIds(new int[]{R.id.back_icon, R.id.larus_chat_top_left_create_new_cvs, R.id.page_size_icon_slot, R.id.search_icon, R.id.side_nav_icon, R.id.multitask_management_icon});
        int r100 = 0;
        if (this.f315498g == false) goto L26;
        ConstraintLayout r101 = this.f315493b.f323926k;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        r103.startToStart = -1;
        r103.startToEnd = this.f315493b.f323928m.getId();
        r103.horizontalBias = 0.5f;
        r103.setMarginStart(i5.q());
        r101.setLayoutParams(r103);
        this.f315493b.f323927l.addOnLayoutChangeListener(new o1(this));
        TextView r104 = this.f315493b.C;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        ((ViewGroup.MarginLayoutParams) r106).width = -2;
        r106.setMarginStart(0);
        r106.setMarginEnd(0);
        r106.goneEndMargin = 0;
        r106.constrainedWidth = true;
        r106.horizontalChainStyle = 2;
        r106.horizontalBias = 0.5f;
        r106.startToStart = this.f315493b.f323926k.getId();
        r106.endToStart = this.f315493b.B.getId();
        r104.setLayoutParams(r106);
        r104.setMaxWidth(com.larus.utils.i.d(getContext()) - (i5.d() * 2));
        TextView r107 = this.f315493b.B;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r108;
        ((ViewGroup.MarginLayoutParams) r109).width = -2;
        r109.setMarginStart(i5.Y());
        r109.setMarginEnd(0);
        r109.goneStartMargin = 0;
        r109.goneEndMargin = 0;
        r109.constrainedWidth = true;
        r109.startToEnd = this.f315493b.C.getId();
        r109.endToStart = this.f315493b.f323922g.getId();
        r109.endToEnd = -1;
        r107.setLayoutParams(r109);
        AppCompatImageView r113 = this.f315493b.f323922g;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r115 = (ConstraintLayout.LayoutParams) r114;
        r115.setMarginStart(0);
        r115.goneStartMargin = 0;
        r115.startToEnd = this.f315493b.B.getId();
        r113.setLayoutParams(r115);
        if (r110 == false) goto L7;
        com.larus.platform.service.z2.f365865a.w3();
    L7:
        com.larus.utils.e1.x(this.f315493b.f323922g);
        TextView r116 = this.f315493b.f323941z;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r117;
        ((ViewGroup.MarginLayoutParams) r118).width = -2;
        r118.horizontalBias = 0.5f;
        r118.setMarginStart(0);
        r118.goneStartMargin = 0;
        r116.setLayoutParams(r118);
        r116.setMaxWidth(com.larus.utils.i.d(getContext()) - (i5.d() * 2));
        com.larus.platform.service.z2 r119 = com.larus.platform.service.z2.f365865a;
        if (r119.getAppsFrameworkConfig().f486665d == true) goto L10;
    L16:
        com.larus.utils.e1.o(this.f315493b.f323932q);
        if (r119.getChatNavigatorConfig().f486627d == true) goto L19;
    L25:
        com.larus.utils.e1.o(this.f315493b.f323937v);
        goto L26
    L19:
        if (f7() == true) goto L25;
        if (r119.e4() == true) goto L25;
        if (s6(ChatTitleBarIcon.SEARCH) == false) goto L25;
        com.larus.utils.e1.x(this.f315493b.f323937v);
        tx9.i3.b("chat", null, null, null, null, "chat", null, null, 222);
        goto L26
    L10:
        if (r119.getMultiTaskEntranceConfig().d() == true) goto L16;
        if (AccountService.f365697a.a() == true) goto L16;
        if (s6(ChatTitleBarIcon.MULTITASK_MANAGEMENT) == false) goto L16;
        com.larus.utils.e1.x(this.f315493b.f323932q);
        com.larus.utils.e1.o(this.f315493b.f323937v);
    L26:
        com.larus.platform.api.g0.a.b(this, r111, false, 6);
        if (o6() == false) goto L29;
        setSubtitleVisible(false);
    L30:
        com.larus.platform.model.chat.q r120 = getDisclaimerConfig();
        if (r120 != null) goto L33;
    L35:
        boolean r121 = false;
    L36:
        if (r121 == false) goto L72;
        com.larus.platform.model.chat.q r122 = getDisclaimerConfig();
        if (r122 != null) goto L40;
    L42:
        boolean r123 = false;
    L43:
        if (r123 == false) goto L72;
        com.larus.platform.service.n0 r124 = com.larus.platform.service.n0.f365775a;
        if (r124.b() == false) goto L49;
        if (r211 == false) goto L49;
        int r125 = R.string.larus_enterprise_bot_desc_disclaimer_cn;
    L71:
        C6(getContext().getString(r125), 1);
    L91:
        if (r110 == true) goto L93;
    L97:
        AppCompatImageView r126 = this.f315493b.f323919d;
        int r127 = R.string.larus_accessibility_icon_back;
        if (r210 == false) goto L103;
        int r128 = com.larus.utils.j0.f375426a;
        if (r110 == false) goto L102;
        r127 = R.string.larus_accessibility_icon_backToChatList;
    L102:
        String r129 = com.larus.utils.j0.d(r127);
    L107:
        r126.setContentDescription(r129);
        setTtsChecked(r112);
        if (this.f315498g == true) goto L110;
    L115:
        TextView r130 = this.f315493b.f323936u;
        AudioServiceDelegate r131 = AudioServiceDelegate.f288288a;
        if (r131.m() == true) goto L118;
    L122:
        boolean r132 = false;
    L123:
        if (r132 == true) goto L126;
        r100 = 8;
    L126:
        r130.setVisibility(r100);
        xo8.a r133 = this.f315492a;
        if (r133 == null) goto L129;
        int r134 = com.larus.bmhome.utils.t.b();
        r133.f564685a.setImageResource(r134);
    L129:
        this.f315493b.f323925j.setImageResource(com.larus.bmhome.utils.t.b());
        setMainBot(r110);
        this.Q = true;
        return;
    L118:
        if (r131.i() == false) goto L122;
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L122;
        r132 = true;
        goto L123
    L110:
        if (com.larus.platform.service.z2.f365865a.o0().f486638b == false) goto L115;
        xo8.a r135 = this.f315492a;
        if (r135 == null) goto L114;
        int r136 = this.f315493b.f323931p.getId();
        ImageView r137 = r135.f564685a;
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
        Intrinsics.checkNotNull(r138, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r139 = (ConstraintLayout.LayoutParams) r138;
        r139.endToStart = r136;
        r137.setLayoutParams(r139);
    L114:
        FrameLayout r140 = this.f315493b.E;
        ViewGroup.LayoutParams r141 = r140.getLayoutParams();
        Intrinsics.checkNotNull(r141, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r142 = (ConstraintLayout.LayoutParams) r141;
        r142.endToStart = this.f315493b.f323935t.getId();
        r140.setLayoutParams(r142);
        goto L115
    L103:
        int r143 = com.larus.utils.j0.f375426a;
        if (r110 == false) goto L106;
        r127 = R.string.larus_accessibility_icon_backToChatList;
    L106:
        r129 = com.larus.utils.j0.d(r127);
        goto L107
    L93:
        if (com.larus.platform.service.z2.f365865a.getChatNavigatorConfig().f486626c == false) goto L97;
        AppCompatImageView r144 = this.f315493b.f323919d;
        if (r144 == null) goto L97;
        r144.setImageResource(v19.c.b(R.attr.larus_ic_drawer_back, r144.getContext(), R.drawable.larus_ic_drawer_back));
    L49:
        if (r124.b() == false) goto L53;
        if (r110 == false) goto L53;
        r125 = R.string.larus_enterprise_mainBot_desc_genByAI_cn;
    L53:
        if (r124.b() == false) goto L56;
        r125 = R.string.larus_enterprise_otherBot_desc_genByDBAI_cn;
        goto L71
    L56:
        if (r110 == false) goto L62;
        if (getContext().getResources().getConfiguration().screenWidthDp <= 350) goto L69;
        r125 = R.string.larus_mainBot_desc_genByAI;
    L69:
        r125 = R.string.larus_Bot_desc_genByAI;
        goto L71
    L62:
        if (AppHost.f326268a.isOversea() == false) goto L68;
        if (getContext().getResources().getConfiguration().screenWidthDp <= 350) goto L69;
        r125 = R.string.larus_otherBot_desc_genByDolaAI;
        goto L71
    L68:
        if (getContext().getResources().getConfiguration().screenWidthDp <= 350) goto L69;
        r125 = R.string.larus_otherBot_desc_genByDBAI_cn;
        goto L71
    L40:
        if (r122.a() != 0) goto L42;
        r123 = true;
    L72:
        AppHost.Companion r145 = AppHost.f326268a;
        if (r145.isOversea() == false) goto L77;
        hq9.g0 r146 = com.larus.platform.service.z2.f365865a.K1();
        if (r146 == null) goto L80;
        String r147 = r146.f486610c;
    L81:
        if (r147 != null) goto L83;
    L89:
        r147 = r145.f();
    L90:
        C6(r147, 0);
        goto L91
    L83:
        if (r147.length() != 0) goto L85;
        boolean r148 = true;
    L86:
        if (r148 == false) goto L88;
        r147 = r145.f();
    L88:
        if (r147 != null) goto L90;
    L85:
        r148 = false;
    L80:
        r147 = null;
        goto L81
    L77:
        hq9.g0 r149 = com.larus.platform.service.z2.f365865a.K1();
        if (r149 == null) goto L80;
        r147 = r149.f486608a;
        goto L81
    L33:
        if (r120.b() != true) goto L35;
        r121 = true;
        goto L36
    L29:
        setSubtitleVisible(true);
        goto L30
    }

    public static void V5(ChatTitleAlignLeftStyle r100, View r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r109) {
        if (r102 != r106) goto L6;
        if (r103 != r107) goto L6;
        if (r104 != r108) goto L6;
        if (r105 != r109) goto L6;
        return;
    L6:
        int r110 = r100.f315493b.f323916a.getMeasuredWidth();
        ViewGroup.LayoutParams r111 = r100.f315493b.f323928m.getLayoutParams();
        if ((r111 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r111;
    L10:
        if (r112 == null) goto L12;
        int r113 = r112.guideBegin;
    L14:
        if (com.larus.utils.i.h(r100.getContext()) == false) goto L18;
        int r114 = r110 - r101.getRight();
        if (r114 >= r113) goto L26;
        r100.f315493b.f323928m.setGuidelineBegin(r114);
        return;
    L26:
        return;
    L18:
        int r115 = r110 - r101.getLeft();
        if (r115 <= r113) goto L22;
        r100.f315493b.f323928m.setGuidelineBegin(r115);
        return;
    L22:
        if (r100.c6() == false) goto L29;
        r100.getHalfScreenInteractionHelper().b();
        return;
    L29:
        return;
    L12:
        r113 = 0;
        goto L14
    L9:
        r112 = null;
        goto L10
    }
}
