package com.larus.login.impl.loginfragment;

import android.animation.Animator;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.apm.ApmAgent;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.keva.Keva;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.router.SmartRouter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.model.PhoneOneKeyPlatform;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.home.api.main.IInitPeriodService;
import com.larus.home.impl.sdk.h2;
import com.larus.login.api.IAccountTrackApi;
import com.larus.login.api.TouristManager;
import com.larus.login.impl.AccountUtils;
import com.larus.login.impl.WhiteListChecker;
import com.larus.login.impl.databinding.LarusAccountBottomLoginButtonBinding;
import com.larus.login.impl.databinding.LarusAccountLoginButtonBinding;
import com.larus.login.impl.impl.AccountTrace;
import com.larus.login.impl.view.PhoneLoginButtonView;
import com.larus.login.impl.view.TouristTipLayout;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowAccountThemeConfigProvider;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import tx9.s1;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ·\u00012\u00020\u00012\u00020\u0002:\u0002·\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010E\u001a\u00020F2\u0006\u0010;\u001a\u00020<J\b\u0010G\u001a\u00020FH\u0002J\u0006\u0010H\u001a\u00020FJ\u0010\u0010I\u001a\u00020F2\u0006\u0010J\u001a\u00020,H\u0002J\b\u0010K\u001a\u00020FH\u0002J\b\u0010L\u001a\u00020FH\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020>H\u0002J,\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020,2\b\u0010R\u001a\u0004\u0018\u00010N2\b\u0010S\u001a\u0004\u0018\u00010,2\u0006\u0010O\u001a\u00020>H\u0002J,\u0010T\u001a\u00020-2\b\u0010R\u001a\u0004\u0018\u00010N2\b\u0010S\u001a\u0004\u0018\u00010,2\u0006\u0010O\u001a\u00020>2\u0006\u0010U\u001a\u00020\u000eH\u0002J,\u0010V\u001a\u00020-2\u0006\u0010Q\u001a\u00020,2\b\u0010R\u001a\u0004\u0018\u00010N2\b\u0010S\u001a\u0004\u0018\u00010,2\u0006\u0010O\u001a\u00020>H\u0002J,\u0010W\u001a\u00020F2\u0006\u0010X\u001a\u00020\u00042\u001c\b\u0002\u0010Y\u001a\u0016\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020F\u0018\u00010ZJ$\u0010[\u001a\u00020\\2\u0006\u0010Q\u001a\u00020,2\b\u0010R\u001a\u0004\u0018\u00010N2\b\b\u0002\u0010S\u001a\u00020,H\u0002J\"\u0010]\u001a\u00020\\2\u0006\u0010Q\u001a\u00020,2\b\u0010R\u001a\u0004\u0018\u00010N2\u0006\u0010S\u001a\u00020,H\u0002J\b\u0010^\u001a\u00020FH\u0002J \u0010_\u001a\b\u0012\u0004\u0012\u00020,0`2\u0006\u0010a\u001a\u00020>2\b\b\u0002\u0010b\u001a\u00020>H\u0002J\b\u0010c\u001a\u00020>H\u0002J\b\u0010d\u001a\u00020FH\u0002J\b\u0010e\u001a\u00020FH\u0002J\u0010\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020<H\u0002J\u0012\u0010h\u001a\u00020F2\b\b\u0002\u0010i\u001a\u00020>H\u0002J\u0010\u0010j\u001a\u00020F2\u0006\u0010k\u001a\u00020,H\u0002J\u0010\u0010l\u001a\u00020F2\u0006\u0010k\u001a\u00020,H\u0002J\b\u0010m\u001a\u00020FH\u0002J\u001e\u0010n\u001a\u00020F2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020,0`2\u0006\u0010p\u001a\u00020>H\u0002J\b\u0010q\u001a\u00020>H\u0002J\u0010\u0010r\u001a\u00020\u00042\u0006\u0010s\u001a\u00020,H\u0002J\u0018\u0010t\u001a\u00020F2\u0006\u0010s\u001a\u00020,2\u0006\u0010u\u001a\u00020\u0004H\u0002J\u0010\u0010v\u001a\u00020F2\u0006\u0010s\u001a\u00020,H\u0002J$\u0010w\u001a\u00020F2\u0006\u0010s\u001a\u00020,2\b\u0010x\u001a\u0004\u0018\u00010,2\b\u0010y\u001a\u0004\u0018\u00010,H\u0002J\b\u0010z\u001a\u00020FH\u0002J\b\u0010{\u001a\u00020FH\u0002J\u0006\u0010|\u001a\u00020FJ\u0012\u0010}\u001a\u00020F2\b\b\u0002\u0010~\u001a\u00020>H\u0002J\b\u0010\u007f\u001a\u00020>H\u0002J\t\u0010\u0080\u0001\u001a\u00020>H\u0002J\u0014\u0010\u0081\u0001\u001a\u00020F2\t\u0010\u0082\u0001\u001a\u0004\u0018\u000108H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020F2\u0007\u0010\u0084\u0001\u001a\u00020>H\u0002J\u0019\u0010\u0085\u0001\u001a\u00020F2\u000e\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020F0\u0087\u0001H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020F2\u0007\u0010\u0089\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u008a\u0001\u001a\u00020FH\u0002J\t\u0010\u008b\u0001\u001a\u00020FH\u0002J\t\u0010\u008c\u0001\u001a\u00020FH\u0002J\u0012\u0010\u008d\u0001\u001a\u00020F2\u0007\u0010\u008e\u0001\u001a\u00020,H\u0002J\t\u0010\u008f\u0001\u001a\u00020FH\u0002J\t\u0010\u0090\u0001\u001a\u00020FH\u0002J\u0011\u0010\u0091\u0001\u001a\u00020F2\u0006\u0010s\u001a\u00020,H\u0002J\u0011\u0010\u0092\u0001\u001a\u00020F2\u0006\u0010s\u001a\u00020,H\u0002J\t\u0010\u0093\u0001\u001a\u00020FH\u0002J\t\u0010\u0094\u0001\u001a\u00020FH\u0002J\t\u0010\u0095\u0001\u001a\u00020FH\u0002J\u0012\u0010\u0096\u0001\u001a\u00020F2\u0007\u0010\u0097\u0001\u001a\u00020,H\u0002J\u001e\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00042\u0007\u0010\u008e\u0001\u001a\u00020,H\u0002J\u0012\u0010\u009b\u0001\u001a\u00020,2\u0007\u0010\u009c\u0001\u001a\u00020\u0004H\u0002J\u001e\u0010\u009d\u0001\u001a\u00020F2\t\u0010\u0013\u001a\u0005\u0018\u00010\u009e\u00012\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\t\u0010\u009f\u0001\u001a\u00020>H\u0002J\t\u0010 \u0001\u001a\u00020>H\u0002J\t\u0010¡\u0001\u001a\u00020,H\u0002J\u0013\u0010¢\u0001\u001a\u00020F2\b\b\u0002\u0010J\u001a\u00020,H\u0002J\t\u0010£\u0001\u001a\u00020,H\u0002J\u0012\u0010¤\u0001\u001a\u00020F2\u0007\u0010\u0089\u0001\u001a\u00020\u0019H\u0016J\t\u0010¥\u0001\u001a\u00020,H\u0002J\u0012\u0010¦\u0001\u001a\u00020F2\u0007\u0010\u0089\u0001\u001a\u00020\u0019H\u0016J\u0012\u0010§\u0001\u001a\u00020F2\u0007\u0010¨\u0001\u001a\u00020\u0004H\u0016J\t\u0010©\u0001\u001a\u00020FH\u0002J\u0012\u0010ª\u0001\u001a\u00020F2\u0007\u0010«\u0001\u001a\u00020>H\u0002J\u0013\u0010¬\u0001\u001a\u00020F2\b\u0010\u00ad\u0001\u001a\u00030®\u0001H\u0002J\"\u0010¯\u0001\u001a\u00020F2\u0006\u0010Q\u001a\u00020,2\u0007\u0010°\u0001\u001a\u00020-2\u0006\u0010O\u001a\u00020>H\u0002J\"\u0010±\u0001\u001a\u00020F2\u0006\u0010Q\u001a\u00020,2\u0007\u0010°\u0001\u001a\u00020-2\u0006\u0010O\u001a\u00020>H\u0002J\t\u0010²\u0001\u001a\u00020FH\u0002J\u0011\u0010³\u0001\u001a\u00020F2\u0006\u0010X\u001a\u00020\u0004H\u0002J\t\u0010´\u0001\u001a\u00020FH\u0002J\u0019\u0010µ\u0001\u001a\u00020F2\u000e\u0010¶\u0001\u001a\t\u0012\u0004\u0012\u00020F0\u0087\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082D¢\u0006\u0002\n\u0000R*\u0010*\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+j\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-`.X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010/\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+j\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-`.X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00100\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u0002010+j\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u000201`.X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00102\u001a\u001e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00040+j\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0004`.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¸\u0001"}, d2 = {"Lcom/larus/login/impl/loginfragment/AccountLoginController;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/larus/login/api/IQuotaStateListener;", "loginWindowStyle", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "trackNode", "Lcom/larus/trace/tracknode/IFlowPageTrackNode;", "triggerSceneData", "Lcom/larus/login/impl/loginfragment/TriggerLoginSceneData;", "<init>", "(ILandroidx/fragment/app/Fragment;Lcom/larus/trace/tracknode/IFlowPageTrackNode;Lcom/larus/login/impl/loginfragment/TriggerLoginSceneData;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner$delegate", "lifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "resources", "Landroid/content/res/Resources;", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "arguments", "Landroid/os/Bundle;", "commonLoadDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "lastClickTime", "", "gapClick", "loginButtons", "Ljava/util/LinkedHashMap;", "", "Lcom/larus/login/impl/databinding/LarusAccountLoginButtonBinding;", "Lkotlin/collections/LinkedHashMap;", "loginDowngradeButtons", "loginBottomButtons", "Lcom/larus/login/impl/databinding/LarusAccountBottomLoginButtonBinding;", "loginButtonsPosition", "settingUpdateListener", "Lcom/bytedance/news/common/settings/SettingsUpdateListener;", "initStartTime", "clickType", "accountPhoneOneKeyInfo", "Lcom/larus/account/base/api/PhoneOneKeyInfo;", "carrierPhoneEntry", "Lcom/larus/login/impl/view/CarrierPhoneEntryDelegate;", "binding", "Lcom/larus/login/impl/loginfragment/ICommonLoginBinding;", "enterPageTraced", "", "openUrlFromPush", "firstResume", "isSingleBottomChannel", "touristReady", "autoJoinTourist", "canJumpToTouristNow", "initViews", "", "initViews1", "traceViewCreated", "traceLoginTypeShow", "loginType", "initDowngradeLogin", "setFeedBackColor", "getEnterpriseLoginIcon", "Landroid/graphics/drawable/Drawable;", "isPrimary", "addLoginButtonView", "loginChannel", "drawable", "text", "addPhoneLoginButtonView", "ctx", "addDowngradeLoginButtonView", "handlePhoneLoginClick", "position", "clickLoginTrack", "Lkotlin/Function2;", "addLoginBottomButtonView", "Landroid/widget/Button;", "addSingleLoginBottomButtonView", "initLoginButton", "getLoginChannelList", "", "needWeixinInstall", "downgradeStrengthPhone", "shouldOnlyShowEnterpriseLoginWhenAddAccount", "strengThenDouyinOrGoogleLogin", "strengthenDouyinLogin", "adjustStrengthUI", "realBinding", "strengthenPhoneAndMinifyDouyin", GearStrategyConsts.EV_DOWNGRADE_TYPE, "enterDowngradeLogin", "strengthChannel", "exitDowngradeLogin", "initLoginFoldButton", "dealThirdLogin", "loginChannelList", "isLoginBottom", "enableLoginWithoutSms", "getLoginButtonPosition", "channel", "updateLoginButtonVisibility", RemoteMessageConst.Notification.VISIBILITY, "handleLoginSucReportEvent", "handleLoginErrorReportEvent", "errCode", "errMsg", "initViews2", "initTouristMode", "applyTouristClick", "gotoTourist", "needLoading", "enablePhoneOneKeyLogin", "shouldDirectCarrierOneKeyLogin", "onPhoneOneKeyInfoReady", "phoneOneKeyInfo", "updatePhoneLoginButtonText", "showOneKey", "showCarrierAgreementDialog", "onAgree", "Lkotlin/Function0;", LiveCommonConstants.REASON_ON_DEDTROY, "owner", "goPhoneLoginFragment", "goPhoneOneKeyLoginFragment", "setTextHighLight", "showDialog", "from", "douyinLogin", "weixinLogin", "overSeaThirdChannelLogin", "autoShowGoogleOneTapLogin", "openTermsLink", "openPrivacyLink", "openAccountPrivacy", "openLoginPolicyLink", "url", "getSpannableString", "Landroid/text/SpannableString;", "linkColor", "getString", "resId", "safeDismissDialog", "Landroid/app/Activity;", "isQuickClick", "checkActivityInValid", "getCurrentPageName", "trackLoginHomePhoneAction", "getPreviousPage", "onResume", "getPageStyle", "onPause", "onQuotaStateChanged", "state", "initLoginByLark", "updateBottomEnterpriseLoginVisible", "visible", "insertEnterpriseLoginEntry", "placement", "Lcom/larus/login/impl/loginfragment/EnterpriseLoginEntryResolver$Placement;", "updateLoginButtonStyle", "buttonBinding", "updateLoginButtonIcon", "refreshLoginButtonPositions", "handleEnterpriseLoginClick", "larkLogin", "runBeforeLoginAction", "action", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccountLoginController implements DefaultLifecycleObserver, com.larus.login.api.h0 {
    public static final int B = 0;
    public static final int C = 0;
    public static final HashMap<String, LoginPlatform> D = null;
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f357857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f357858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.trace.tracknode.a f357859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n1 f357860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f357861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f357862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f357863g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LifecycleCoroutineScope f357864h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Resources f357865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FragmentManager f357866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f357867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.common_ui.dialog.l0 f357868l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f357869m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f357870n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedHashMap<String, LarusAccountLoginButtonBinding> f357871o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinkedHashMap<String, LarusAccountBottomLoginButtonBinding> f357872p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinkedHashMap<String, Integer> f357873q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d0 f357874r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f357875s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f357876t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public n38.c0 f357877u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ck9.a f357878v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public k1 f357879w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f357880x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f357881y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f357882z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f357883a = null;

        static {
            int[] r100 = new int[PhoneOneKeyPlatform.values().length];
            r100[PhoneOneKeyPlatform.MOBILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PhoneOneKeyPlatform.UNICOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PhoneOneKeyPlatform.TELECOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f357883a = r100;
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountLoginController f357884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f357885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LarusAccountLoginButtonBinding[] f357886c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            int r101 = this.f357884a.f357871o.size();
        L3:
            r101 = r101 - 1;
            if (4 >= r101) goto L6;
            this.f357884a.P(this.f357885b[r101], 0);
            this.f357886c[r101].f357405d.setAlpha(0.0f);
            goto L3
        L6:
            k1 r102 = this.f357884a.f357879w;
            if (r102 == null) goto L13;
            View r103 = r102.j();
            if (r103 == null) goto L14;
            r103.setVisibility(8);
            return;
        L14:
            return;
        }

        public c(AccountLoginController r100, String[] r101, LarusAccountLoginButtonBinding[] r102) {
            this.f357884a = r100;
            this.f357885b = r101;
            this.f357886c = r102;
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountLoginController f357887a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        public d(AccountLoginController r100) {
            this.f357887a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            k1 r101 = this.f357887a.f357879w;
            if (r101 == null) goto L8;
            View r102 = r101.j();
            if (r102 == null) goto L9;
            r102.setVisibility(0);
            return;
        L9:
            return;
        }
    }

    public static final class e implements n38.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountLoginController f357888a;

        public e(AccountLoginController r100) {
            this.f357888a = r100;
        }

        @Override // n38.y
        public final void b(n38.c0 r100) {
            AccountLoginController r101 = this.f357888a;
            int r102 = AccountLoginController.B;
            r101.H(r100);
        }

        @Override // n38.y
        public final void a(String r100, String r101) {
            FLogger.f375446a.e("AccountLoginController", "errorType: -1, errorCode: " + r100 + ", errorMessage: " + r101);
            AccountLoginController r102 = this.f357888a;
            int r103 = AccountLoginController.B;
            r102.H(null);
        }
    }

    public static final class f implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f357889a;

        public f(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f357889a = r100;
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
            return this.f357889a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f357889a.invoke(r100);
        }
    }

    public static final class g implements com.larus.common_ui.dialog.p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountLoginController f357890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f357891b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            k1 r100 = this.f357890a.f357879w;
            if (r100 == null) goto L7;
            CheckBox r101 = r100.e();
            if (r101 == null) goto L7;
            r101.setChecked(true);
        L7:
            new AccountTrace().m("on_module", "agree", this.f357890a.u(), "landing");
            if (Intrinsics.areEqual(this.f357891b, "phone_verify_code") == false) goto L11;
            this.f357890a.A();
            return;
        L11:
            if (Intrinsics.areEqual(this.f357891b, "douyin") == false) goto L14;
            AccountLoginController r102 = this.f357890a;
            r102.f357876t = this.f357891b;
            r102.f357875s = System.currentTimeMillis();
            this.f357890a.s();
            return;
        L14:
            if (Intrinsics.areEqual(this.f357891b, "wechat") == false) goto L17;
            AccountLoginController r103 = this.f357890a;
            r103.f357876t = this.f357891b;
            r103.f357875s = System.currentTimeMillis();
            AccountLoginController r104 = this.f357890a;
            r104.getClass();
            com.larus.login.impl.h0 r105 = com.larus.login.impl.h0.f357729a;
            com.larus.common_ui.dialog.l0 r106 = r104.f357868l;
            Fragment r107 = r104.f357858b;
            String r108 = r104.u();
            String r109 = r104.f357860d.f357999c;
            r105.getClass();
            com.larus.login.impl.h0.s(r106, r107, r108, r109);
            return;
        L17:
            if (Intrinsics.areEqual(this.f357891b, "enterprise") == false) goto L23;
            this.f357890a.G();
            return;
        }

        public g(AccountLoginController r100, String r101) {
            this.f357890a = r100;
            this.f357891b = r101;
        }
    }

    public static final class h implements com.larus.common_ui.dialog.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccountLoginController f357892a;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            AccountTrace r100 = new AccountTrace();
            AccountLoginController r101 = this.f357892a;
            int r102 = AccountLoginController.B;
            r100.m("on_module", "disagree", r101.u(), "landing");
        }

        public h(AccountLoginController r100) {
            this.f357892a = r100;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onCreate(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStart(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStart(this, r100);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner r100) {
        DefaultLifecycleObserver.CC.$default$onStop(this, r100);
    }

    static {
        B = i5.y0(R.dimen.larus_dp_68);
        C = i5.y0(R.dimen.larus_dp_24);
        HashMap<String, LoginPlatform> r100 = new HashMap();
        r100.put("phone_verify_code", LoginPlatform.PHONE);
        r100.put("douyin", LoginPlatform.DOUYIN);
        r100.put("google", LoginPlatform.GOOGLE);
        r100.put("line", LoginPlatform.LINE);
        r100.put("facebook", LoginPlatform.FACEBOOK);
        D = r100;
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.f357862f.getValue();
    }

    private final Context getContext() {
        return (Context) this.f357861e.getValue();
    }

    public final void D() {
        this.f357873q.clear();
        this.f357871o.clear();
        r(w(false), false);
        E();
    }

    public final void E() {
        if (this.f357871o.size() <= 5) goto L21;
        k1 r100 = this.f357879w;
        if (r100 == null) goto L9;
        ImageView r101 = r100.g();
        if (r101 == null) goto L9;
        r101.setVisibility(0);
    L9:
        final String[] r102 = (String[]) this.f357871o.keySet().toArray(new String[0]);
        final LarusAccountLoginButtonBinding[] r103 = (LarusAccountLoginButtonBinding[]) this.f357871o.values().toArray(new LarusAccountLoginButtonBinding[0]);
        int r104 = this.f357871o.size();
    L10:
        r104 = r104 - 1;
        int r105 = 4;
        if (4 >= r104) goto L14;
        P(r102[r104], 8);
    L14:
        if ((-1) >= r105) goto L16;
        P(r102[r105], 0);
        r105 = r105 - 1;
        goto L14
    L16:
        k1 r106 = this.f357879w;
        if (r106 == null) goto L25;
        ImageView r107 = r106.g();
        if (r107 == null) goto L29;
        r107.setOnClickListener(new com.larus.login.impl.loginfragment.g(this, r102, r103));
        return;
    L29:
        return;
    L25:
        return;
    L21:
        Iterator<String> r108 = this.f357871o.keySet().iterator();
    L23:
        if (r108.hasNext() == false) goto L31;
        P(r108.next(), 0);
        goto L23
    }

    public final void G() {
        com.larus.login.impl.h0 r100 = com.larus.login.impl.h0.f357729a;
        com.larus.common_ui.dialog.l0 r101 = this.f357868l;
        Fragment r102 = this.f357858b;
        String r103 = u();
        String r104 = this.f357860d.f357999c;
        Bundle r105 = this.f357867k;
        if (r105 == null) goto L5;
        String r106 = r105.getString("key_trigger_app_id");
    L6:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "currentPage");
        Intrinsics.checkNotNullParameter(r104, "enterMethod");
        if (r102 == null) goto L21;
        FragmentActivity r107 = r102.getActivity();
        if (r107 == null) goto L21;
        if (NetworkUtils.isNetworkAvailable(r107) == true) goto L15;
        t19.s.f544207a.g(r107, R.string.larus_log_in_internet_error, false);
        return;
    L15:
        if (com.larus.utils.o0.d(r106) == false) goto L17;
        String r108 = "authorized";
    L18:
        String r110 = r108;
        ILoginService r111 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r111 == null) goto L24;
        r111.O(r107, r110, null, new com.larus.login.impl.j0(r103, r104, r106, r107, r101, r102, r110));
        return;
    L24:
        return;
    L17:
        r108 = "AccountLoginFragment";
    L21:
        FLogger.f375446a.e("CommonLoginUtils", "lark login, context is null, Abort");
        return;
    L5:
        r106 = null;
        goto L6
    }

    public final boolean L() {
        ck9.a r100 = this.f357878v;
        if (r100 == null) goto L12;
        PhoneLoginButtonView r101 = r100.f24068d;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 != true) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L15;
        return false;
    L15:
        n38.c0 r104 = this.f357877u;
        PhoneOneKeyPlatform r105 = null;
        if (r104 == null) goto L18;
        String r106 = r104.f516995a;
    L19:
        if (r106 != null) goto L21;
    L24:
        boolean r107 = true;
    L25:
        if (r107 == true) goto L31;
        n38.c0 r108 = this.f357877u;
        if (r108 == null) goto L29;
        r105 = r108.f516996b;
    L29:
        if (r105 == null) goto L31;
        return true;
    L31:
        return false;
    L21:
        if (r106.length() == 0) goto L24;
        r107 = false;
        goto L25
    L18:
        r106 = null;
        goto L19
    L7:
        if (r101.f358358f != true) goto L9;
        r102 = true;
    L12:
        r103 = false;
        goto L13
    }

    public final void O() {
        IApplog.Companion r100 = IApplog.f287053a;
        JSONObject r101 = new JSONObject();
        r101.put("login_type", "normal");
        if (this.f357857a != 1) goto L5;
        String r102 = "half";
    L6:
        r101.put("screen", r102);
        Unit r103 = Unit.INSTANCE;
        r100.reportEvent("degrade_login_type_show", r101);
        return;
    L5:
        r102 = "full";
        goto L6
    }

    public final void o() {
        FLogger.f375446a.i("AccountLoginController", "applyTouristClick");
        Bundle r100 = this.f357867k;
        DialogFragment r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r100.getBoolean("key_from_restricted_func", false));
    L6:
        final boolean r103 = true;
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L25;
        if (this.f357857a != 1) goto L20;
        Fragment r104 = this.f357858b;
        if ((r104 instanceof DialogFragment) == false) goto L13;
        r101 = (DialogFragment) r104;
    L13:
        if (r101 == null) goto L35;
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L36;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L36:
        return;
    L35:
        return;
    L20:
        FragmentActivity r106 = getActivity();
        if (r106 == null) goto L38;
        r106.finish();
        return;
    L38:
        return;
    L25:
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L28;
        t19.s.f544207a.g(AppHost.f326268a.getApplication(), R.string.larus_log_in_internet_error, false);
        return;
    L28:
        IAccountTrackApi.a.a(new AccountTrace(), "use_without_login", -1, u(), x(), this.f357860d.f357999c, "login_home_direct");
        IInitPeriodService r107 = (IInitPeriodService) ServiceManager.get().getService(IInitPeriodService.class);
        if (r107 == null) goto L31;
        r107.a();
    L31:
        LiveData<com.larus.network.http.a<Object>> r108 = TouristManager.f357001a.y();
        r108.removeObservers(z());
        final Ref.ObjectRef r109 = new Ref.ObjectRef();
        r108.observe(z(), new f(new x(this, r109, r103)));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void s() {
        com.larus.login.impl.h0 r100 = com.larus.login.impl.h0.f357729a;
        com.larus.common_ui.dialog.l0 r101 = this.f357868l;
        Fragment r102 = this.f357858b;
        String r103 = u();
        String r104 = this.f357860d.f357999c;
        Bundle r105 = this.f357867k;
        if (r105 == null) goto L5;
        String r106 = r105.getString("key_trigger_app_id");
    L7:
        if (this.f357857a == 1) goto L9;
    L17:
        boolean r107 = false;
    L18:
        r100.getClass();
        com.larus.login.impl.h0.i(r101, r102, r103, r104, r106, r107);
        return;
    L9:
        if (com.larus.login.impl.downgrade.b.f357663d == 0) goto L11;
    L14:
        boolean r108 = true;
    L15:
        if (r108 == false) goto L17;
        r107 = true;
        goto L18
    L11:
        if (com.larus.login.impl.downgrade.b.f357664e == true) goto L14;
        r108 = false;
        goto L15
    L5:
        r106 = null;
        goto L7
    }

    public final boolean t() {
        e10 r100 = e10.f368561a;
        if (e10.c0().contains("oneKey") == false) goto L5;
        return false;
    L5:
        IApplog.Companion r101 = IApplog.f287053a;
        JSONObject r102 = new JSONObject();
        if (this.f357877u != null) goto L8;
        int r103 = 0;
    L9:
        r102.put("has_carrier_info", r103);
        Unit r104 = Unit.INSTANCE;
        r101.reportEvent("has_carrier_info_when_click", r102);
        n38.c0 r105 = this.f357877u;
        PhoneOneKeyPlatform r106 = null;
        if (r105 == null) goto L12;
        String r107 = r105.f516995a;
    L13:
        if (r107 != null) goto L15;
    L18:
        boolean r108 = true;
    L19:
        if (r108 == true) goto L28;
        n38.c0 r109 = this.f357877u;
        if (r109 == null) goto L23;
        r106 = r109.f516996b;
    L23:
        if (r106 != null) goto L25;
        return false;
    L25:
        if (AppHost.f326268a.isOversea() == true) goto L30;
        return true;
    L30:
        return false;
    L28:
        return false;
    L15:
        if (r107.length() == 0) goto L18;
        r108 = false;
        goto L19
    L12:
        r107 = null;
        goto L13
    L8:
        r103 = 1;
        goto L9
    }

    public final String u() {
        return this.f357859c.k();
    }

    public final String x() {
        Bundle r100 = this.f357867k;
        if (r100 == null) goto L6;
        String r101 = r100.getString("account_previous_page");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "landing";
    }

    public final LifecycleOwner z() {
        return (LifecycleOwner) this.f357863g.getValue();
    }

    public final void A() {
        com.bytedance.router.i r100 = SmartRouter.buildRoute(getContext(), "//flow/phone_login");
        Bundle r101 = this.f357867k;
        if (r101 == null) goto L7;
        String r102 = r101.getString("pending_deeplink_schema");
        if (r102 == null) goto L7;
        FLogger.f375446a.i("AccountLoginController", "pass uri from push when route to ROUTER_PHONE_LOGIN");
        r100.j("pending_deeplink_schema", r102);
    L7:
        Bundle r103 = this.f357867k;
        if (r103 == null) goto L10;
        r100.k("key_from_restricted_func", r103.getBoolean("key_from_restricted_func"));
    L10:
        Bundle r104 = this.f357867k;
        if (r104 == null) goto L15;
        String r105 = r104.getString("key_trigger_app_id");
        if (r105 == null) goto L15;
        r100.j("key_trigger_app_id", r105);
    L15:
        String r106 = u();
        r100.f267554c.putExtra("account_previous_page", r106);
        String r107 = this.f357860d.f357999c;
        r100.f267554c.putExtra("account_enter_method", r107);
        k1 r108 = this.f357879w;
        if (r108 == null) goto L20;
        CheckBox r109 = r108.e();
        if (r109 == null) goto L20;
        Boolean r110 = Boolean.valueOf(r109.isChecked());
    L21:
        r100.f267554c.putExtra("key_has_agree_privacy", r110);
        r100.f267555d = R.anim.larus_router_slide_in_right;
        r100.f267556e = R.anim.larus_router_no_anim;
        r100.e(100);
        k1 r111 = this.f357879w;
        if (r111 == null) goto L27;
        CheckBox r112 = r111.e();
        if (r112 == null) goto L28;
        r112.setChecked(false);
        return;
    L28:
        return;
    L27:
        return;
    L20:
        r110 = null;
        goto L21
    }

    public final void B() {
        com.bytedance.router.i r100 = SmartRouter.buildRoute(getContext(), "//flow/phone_one_key_login");
        Bundle r101 = this.f357867k;
        if (r101 == null) goto L7;
        String r102 = r101.getString("pending_deeplink_schema");
        if (r102 == null) goto L7;
        FLogger.f375446a.i("AccountLoginController", "pass uri from push or other deeplink when route to ROUTER_PHONE_LOGIN");
        r100.j("pending_deeplink_schema", r102);
    L7:
        n38.c0 r103 = this.f357877u;
        PhoneOneKeyPlatform r104 = null;
        if (r103 == null) goto L10;
        String r105 = r103.f516995a;
    L11:
        r100.j("key_account_mask_phone_number", r105);
        k1 r106 = this.f357879w;
        if (r106 == null) goto L16;
        CheckBox r107 = r106.e();
        if (r107 == null) goto L16;
        Boolean r108 = Boolean.valueOf(r107.isChecked());
    L17:
        r100.i("key_has_agree_privacy", r108);
        Bundle r109 = this.f357867k;
        String r110 = "";
        if (r109 == null) goto L21;
        String r111 = r109.getString("key_trigger_app_id");
        if (r111 == null) goto L21;
    L22:
        r100.j("key_trigger_app_id", r111);
        r100.j("account_previous_page", u());
        r100.j("account_enter_method", this.f357860d.f357999c);
        n38.c0 r112 = this.f357877u;
        if (r112 == null) goto L25;
        r104 = r112.f516996b;
    L25:
        if (r104 != null) goto L27;
        int r113 = -1;
    L29:
        if (r113 != 1) goto L31;
        r110 = y(R.string.larus_doubao_login_tel_sdk_provider_china_mobile);
    L38:
        r100.j("key_account_CARRIER", r110);
        r100.f267555d = R.anim.larus_router_slide_in_right;
        r100.f267556e = R.anim.larus_router_no_anim;
        r100.d();
        k1 r114 = this.f357879w;
        if (r114 == null) goto L44;
        CheckBox r115 = r114.e();
        if (r115 == null) goto L45;
        r115.setChecked(false);
        return;
    L45:
        return;
    L44:
        return;
    L31:
        if (r113 != 2) goto L33;
        r110 = y(R.string.larus_doubao_login_tel_sdk_provider_china_mobile_china_unicom);
        goto L38
    L33:
        if (r113 != 3) goto L38;
        r110 = y(R.string.larus_doubao_login_tel_sdk_provider_china_mobile_china_telecom);
        goto L38
    L27:
        r113 = b.f357883a[r104.ordinal()];
    L21:
        r111 = "";
    L16:
        r108 = null;
        goto L17
    L10:
        r105 = null;
        goto L11
    }

    public final void p() {
        if (q() == false) goto L5;
        return;
    L5:
        AccountTrace r100 = new AccountTrace();
        String r101 = x();
        IAccountTrackApi.a.a(r100, "google_one_tap", -1, u(), r101, this.f357860d.f357999c, "login_home_direct_auto");
        LoginPlatform r102 = D.get("google");
        if (r102 != null) goto L8;
        return;
    L8:
        com.larus.common_ui.dialog.l0 r103 = this.f357868l;
        if (r103 != null) goto L11;
    L15:
        ILoginService r104 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r104 == null) goto L26;
        j0 r105 = new j0(this, r102);
        boolean r106 = AppHost.f326268a.isOversea();
        FragmentActivity r107 = getActivity();
        JSONObject r108 = new JSONObject();
        r108.put("current_page", u());
        Unit r109 = Unit.INSTANCE;
        if (r102 != LoginPlatform.GOOGLE) goto L20;
        boolean r110 = true;
    L21:
        ILoginService.a.a(r104, r102, r105, r106, "AccountLoginController", r107, r108, r110, false, null, 384);
        return;
    L20:
        r110 = false;
        goto L21
    L26:
        return;
    L11:
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(r103);
        goto L15
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L14:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L15
    }

    public final boolean q() {
        if (getActivity() == null) goto L20;
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L20;
        FragmentActivity r102 = getActivity();
        if (r102 != null) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L20;
        return false;
    L14:
        if (r102.isDestroyed() != true) goto L16;
        r103 = true;
        goto L17
    L7:
        if (r100.isFinishing() != true) goto L9;
        r101 = true;
    L20:
        return true;
    }

    public static Unit b(AccountLoginController r100) {
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L6;
        r101.finish();
    L6:
        return Unit.INSTANCE;
    }

    public static void f(com.larus.common_ui.dialog.l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final /* synthetic */ FragmentActivity g(AccountLoginController r100) {
        return r100.getActivity();
    }

    public static final /* synthetic */ Context h(AccountLoginController r100) {
        return r100.getContext();
    }

    public static final boolean j(AccountLoginController r100) {
        r100.getClass();
        long r101 = System.currentTimeMillis();
        if ((r101 - r100.f357869m) >= r100.f357870n) goto L5;
        boolean r102 = true;
    L6:
        r100.f357869m = r101;
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    public final void C(int r110) {
        FLogger.f375446a.i("AccountLoginController", "click lark login");
        AccountTrace r100 = new AccountTrace();
        String r101 = x();
        String r102 = u();
        String r103 = this.f357860d.f357999c;
        Bundle r104 = this.f357867k;
        if (r104 == null) goto L5;
        String r105 = r104.getString("key_trigger_app_id");
    L6:
        r100.r("enterprise", r110, r102, r101, r103, "login_home_direct", r105);
        K(new q(this));
        return;
    L5:
        r105 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [com.bytedance.news.common.settings.SettingsUpdateListener, com.larus.login.impl.loginfragment.d0] */
    public final void F(k1 r210) {
        Intrinsics.checkNotNullParameter(r210, "binding");
        this.f357879w = r210;
        Context r100 = getContext();
        String r101 = null;
        if (r100 == null) goto L5;
        com.larus.common_ui.dialog.l0 r102 = new com.larus.common_ui.dialog.l0(r100, 0.0f, true, 2);
    L6:
        this.f357868l = r102;
        Ref.BooleanRef r103 = new Ref.BooleanRef();
        r103.element = true;
        AppHost.Companion r104 = AppHost.f326268a;
        if (r104.isOversea() == false) goto L9;
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        String r106 = String.format(this.f357865i.getString(R.string.larus_log_in_page_bottom_note_android), Arrays.copyOf(new Object[]{this.f357865i.getString(R.string.app_name_replace)}, 1));
    L10:
        k1 r107 = this.f357879w;
        if (r107 == null) goto L15;
        UrlSpanTextView r108 = r107.m();
        if (r108 == null) goto L15;
        r108.setUrlSpannedText(r106);
    L15:
        k1 r109 = this.f357879w;
        if (r109 == null) goto L20;
        UrlSpanTextView r110 = r109.m();
        if (r110 == null) goto L20;
        r110.setOnClickListener(new l0(r103, this));
    L20:
        k1 r111 = this.f357879w;
        if (r111 == null) goto L23;
        TextView r112 = r111.h();
    L24:
        com.larus.utils.e1.d(r112, new g0(this));
        Context r113 = getContext();
        if (r113 == null) goto L37;
        Lazy r114 = uj9.d.f550448a;
        if (uj9.d.d() == false) goto L30;
        int r115 = ContextCompat.getColor(r113, R.color.larus_neutral_70);
    L31:
        k1 r116 = this.f357879w;
        if (r116 == null) goto L37;
        TextView r117 = r116.h();
        if (r117 == null) goto L37;
        r117.setTextColor(r115);
        goto L37
    L30:
        r115 = ContextCompat.getColor(r113, R.color.larus_primary_50);
    L37:
        if (r104.isOversea() == true) goto L59;
        k1 r118 = this.f357879w;
        if (r118 == null) goto L43;
        CheckBox r119 = r118.e();
        if (r119 == null) goto L43;
        r119.setVisibility(0);
    L43:
        k1 r120 = this.f357879w;
        if (r120 == null) goto L48;
        CheckBox r121 = r120.e();
        if (r121 == null) goto L48;
        r121.setChecked(false);
    L48:
        k1 r122 = this.f357879w;
        if (r122 == null) goto L53;
        LinearLayout r123 = r122.k();
        if (r123 == null) goto L53;
        r123.setOnClickListener(new w(this));
    L53:
        k1 r124 = this.f357879w;
        if (r124 == null) goto L58;
        CheckBox r125 = r124.e();
        if (r125 == null) goto L58;
        r125.setOnClickListener(new c0(this));
    L58:
        new AccountTrace().j("on_page", u(), "landing");
    L59:
        ?? r126 = new d0(this);
        this.f357874r = r126;
        SettingsManager.registerListener(r126, true);
        if (r104.isOversea() == false) goto L67;
        IAccountService.Companion r127 = IAccountService.f286094a;
        if (r127.r() == false) goto L67;
        if (com.larus.network.http.d.f360144e == true) goto L67;
        r127.q(false);
        p();
    L67:
        if (r104.isOversea() == true) goto L100;
        Fragment r128 = this.f357858b;
        if (r128 == null) goto L73;
        Bundle r129 = r128.getArguments();
        if (r129 == null) goto L73;
        String r130 = r129.getString("key_trigger_app_id");
    L74:
        if (r130 != null) goto L76;
    L79:
        boolean r131 = true;
    L80:
        if (r131 == false) goto L100;
        Lazy r132 = uj9.d.f550448a;
        if (uj9.d.d() == false) goto L100;
        k1 r133 = this.f357879w;
        if (r133 == null) goto L144;
        List r134 = w(false);
        if (Intrinsics.areEqual(CollectionsKt.first(r134), "douyin") == true) goto L89;
        D();
        goto L144
    L89:
        this.f357873q.clear();
        this.f357871o.clear();
        ArrayList r135 = new ArrayList();
        if (r134.size() != 2) goto L93;
        this.A = true;
    L93:
        if (r134.size() < 2) goto L99;
        Iterator r136 = r134.subList(1, r134.size()).iterator();
    L96:
        if (r136.hasNext() == false) goto L98;
        r135.add((String) r136.next());
        goto L96
    L98:
        r134 = CollectionsKt.listOf(CollectionsKt.first(r134));
        n(r133);
    L99:
        FLogger.f375446a.i("AccountLoginController", "strengthenDouyinLogin: loginChannelList=" + r134 + " loginBottomChannelList=" + r135);
        r(r134, false);
        r(r135, true);
        E();
    L144:
        if (AppHost.f326268a.isOversea() == true) goto L150;
        com.larus.login.impl.downgrade.b r137 = com.larus.login.impl.downgrade.b.f357660a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CopyOnWriteArrayList<com.larus.login.api.h0> r138 = com.larus.login.impl.downgrade.b.f357661b;
        if (r138.contains(this) == true) goto L149;
        r138.add(this);
    L149:
        BuildersKt.launch$default(this.f357864h, null, null, new AccountLoginController$initDowngradeLogin$1(this, null), 3, null);
        BuildersKt.launch$default(this.f357864h, null, null, new AccountLoginController$initLoginByLark$1(this, null), 3, null);
    L150:
        FLogger r139 = FLogger.f375446a;
        r139.i("AccountLoginController", "initViews2");
        int r140 = WhiteListChecker.f357247a;
        z1a.a.f569712a.getClass();
        z1a.a.a(true);
        Bundle r141 = this.f357867k;
        if (r141 == null) goto L153;
        String r142 = r141.getString("key_trigger_app_id");
    L154:
        if (r142 != null) goto L156;
    L159:
        boolean r143 = true;
    L160:
        if (r143 == false) goto L162;
        WhiteListChecker.a();
    L162:
        Bundle r144 = this.f357867k;
        if (r144 == null) goto L165;
        String r145 = r144.getString("pending_deeplink_schema");
    L166:
        this.f357881y = r145;
        AccountUtils r146 = AccountUtils.f357130a;
        AccountUtils.r(z());
        AccountUtils.p(z(), this.f357858b, this.f357868l, null, false, this.f357881y, this.f357860d.f357999c, null, null, 400);
        k1 r147 = this.f357879w;
        if (r147 == null) goto L171;
        TouristTipLayout r148 = r147.d();
        if (r148 == null) goto L171;
        r148.setVisibility(8);
    L171:
        TouristManager r149 = TouristManager.f357001a;
        if (r149.t() == false) goto L190;
        Bundle r150 = this.f357867k;
        if (r150 == null) goto L176;
        String r151 = r150.getString("key_trigger_app_id");
    L177:
        if (r151 != null) goto L179;
    L182:
        boolean r152 = true;
    L183:
        if (r152 == false) goto L190;
        r139.i("AccountLoginController", "initTouristMode");
        r149.m(getContext(), this.f357866j);
        k1 r153 = this.f357879w;
        if (r153 == null) goto L189;
        TouristTipLayout r154 = r153.d();
        if (r154 == null) goto L189;
        r154.a(this.f357857a, new h0(this));
    L189:
        LiveData<Boolean> r155 = r149.w();
        r155.removeObservers(z());
        r155.observe(z(), new f(new i0(this)));
        r149.r(this.f357864h, "enter_login_page");
        return;
    L179:
        if (r151.length() == 0) goto L182;
        r152 = false;
        goto L183
    L176:
        r151 = null;
    L190:
        Bundle r156 = this.f357867k;
        if (r156 == null) goto L194;
        r101 = r156.getString("key_trigger_app_id");
    L194:
        if (com.larus.utils.o0.d(r101) == false) goto L210;
        if (this.f357860d.f357997a == TriggerLoginScene.TRIGGER_LOGIN_ADD_ACCOUNT) goto L210;
        k1 r157 = this.f357879w;
        if (r157 == null) goto L202;
        TouristTipLayout r158 = r157.d();
        if (r158 == null) goto L202;
        r158.setVisibility(0);
    L202:
        k1 r159 = this.f357879w;
        if (r159 == null) goto L227;
        TouristTipLayout r160 = r159.d();
        if (r160 == null) goto L228;
        View r161 = r160.getCloseButton();
        if (r161 == null) goto L229;
        com.larus.utils.e1.d(r161, new com.larus.login.impl.loginfragment.b(this));
        return;
    L229:
        return;
    L228:
        return;
    L227:
        return;
    L210:
        if (this.f357857a != 1) goto L231;
        k1 r162 = this.f357879w;
        if (r162 == null) goto L216;
        TouristTipLayout r163 = r162.d();
        if (r163 == null) goto L216;
        r163.setVisibility(0);
    L216:
        k1 r164 = this.f357879w;
        if (r164 == null) goto L232;
        TouristTipLayout r165 = r164.d();
        if (r165 == null) goto L233;
        r165.a(this.f357857a, new com.larus.login.impl.loginfragment.c(this));
        return;
    L233:
        return;
    L232:
        return;
    L231:
        return;
    L165:
        r145 = null;
        goto L166
    L156:
        if (r142.length() == 0) goto L159;
        r143 = false;
        goto L160
    L153:
        r142 = null;
        goto L154
    L76:
        if (r130.length() == 0) goto L79;
        r131 = false;
    L73:
        r130 = null;
    L100:
        Lazy r166 = uj9.d.f550448a;
        if (r104.isTestChannel() == false) goto L103;
        boolean r167 = ((Keva) uj9.d.f550448a.getValue()).getBoolean("mock_always_local_login_exp", false);
    L104:
        if (r167 == false) goto L121;
        this.f357873q.clear();
        this.f357871o.clear();
        List r168 = w(false);
        ArrayList r169 = new ArrayList();
        if (r168.size() > 2) goto L108;
    L119:
        r(r168, false);
        r(r169, true);
        E();
        goto L144
    L108:
        if (r104.isOversea() == false) goto L114;
        Iterator r170 = r168.subList(1, r168.size()).iterator();
    L111:
        if (r170.hasNext() == false) goto L113;
        r169.add((String) r170.next());
        goto L111
    L113:
        r168 = CollectionsKt.listOf(CollectionsKt.first(r168));
        goto L119
    L114:
        Iterator r171 = r168.subList(1, r168.size()).iterator();
    L116:
        if (r171.hasNext() == false) goto L118;
        r169.add((String) r171.next());
        goto L116
    L118:
        r168 = CollectionsKt.listOf(CollectionsKt.first(r168));
        goto L119
    L121:
        if (uj9.d.f550449b != 2) goto L123;
    L126:
        boolean r172 = true;
    L127:
        if (r172 == false) goto L142;
        k1 r173 = this.f357879w;
        if (r173 == null) goto L144;
        List r174 = w(false);
        if (Intrinsics.areEqual(CollectionsKt.first(r174), "phone_verify_code") == true) goto L134;
        D();
        goto L144
    L134:
        this.f357873q.clear();
        this.f357871o.clear();
        ArrayList r175 = new ArrayList();
        if (r174.size() < 2) goto L141;
        Iterator r176 = r174.subList(1, r174.size()).iterator();
    L138:
        if (r176.hasNext() == false) goto L140;
        r175.add((String) r176.next());
        goto L138
    L140:
        r174 = CollectionsKt.listOf(CollectionsKt.first(r174));
        n(r173);
    L141:
        FLogger.f375446a.i("AccountLoginController", "strengthenPhoneAndMinifyDouyin: loginChannelList=" + r174 + " loginBottomChannelList=" + r175);
        r(r174, false);
        r(r175, true);
        E();
        goto L144
    L142:
        D();
        goto L144
    L123:
        if (uj9.d.b() == 2) goto L126;
        r172 = false;
        goto L127
    L103:
        r167 = false;
        goto L104
    L23:
        r112 = null;
        goto L24
    L9:
        StringCompanionObject r177 = StringCompanionObject.INSTANCE;
        r106 = String.format(this.f357865i.getString(R.string.larus_log_in_page_confirm_note_new), Arrays.copyOf(new Object[]{this.f357865i.getString(R.string.app_name_replace)}, 1));
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void H(n38.c0 r100) {
        this.f357877u = r100;
        com.larus.login.impl.h0 r101 = com.larus.login.impl.h0.f357729a;
        if (r100 == null) goto L5;
        String r102 = r100.f516995a;
    L6:
        r101.getClass();
        com.larus.login.impl.h0.f357730b = r102;
        if (this.f357858b.isAdded() == true) goto L9;
        return;
    L9:
        ck9.a r103 = this.f357878v;
        if (r103 == null) goto L13;
        r103.a(r100, true);
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void I(String r100) {
        com.bytedance.router.i r101 = SmartRouter.buildRoute(getContext(), "//flow/webview");
        r101.f267554c.putExtra("link_url", r100);
        if (this.f357857a != 1) goto L5;
        r101.k("can_be_covered", false);
    L5:
        r101.f267555d = R.anim.larus_router_slide_in_right;
        r101.f267556e = R.anim.larus_router_no_anim;
        r101.d();
    }

    public final void J(String r100) {
        com.larus.login.impl.h0 r101 = com.larus.login.impl.h0.f357729a;
        com.larus.common_ui.dialog.l0 r102 = this.f357868l;
        Fragment r103 = this.f357858b;
        String r104 = u();
        String r105 = this.f357860d.f357999c;
        r101.getClass();
        com.larus.login.impl.h0.p(r100, r102, r103, r104, r105);
    }

    public final void K(Function0<Unit> r100) {
        if (this.f357857a != 2) goto L12;
        IApplog.Companion r101 = IApplog.f287053a;
        String r102 = r101.getDeviceId();
        if (r102.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
    L11:
        r101.u(3000, null);
        goto L12
    L10:
        if (Intrinsics.areEqual(r102, "0") == false) goto L12;
    L7:
        r103 = false;
    L12:
        r100.invoke();
    }

    public final void M(Function0<Unit> r110) {
        if (q() == false) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f357871o.entrySet().iterator();
        PhoneOneKeyPlatform r101 = null;
        if (r100.hasNext() == true) goto L8;
        Object r102 = null;
    L23:
        Map.Entry r103 = (Map.Entry) r102;
        if (r103 == null) goto L28;
        LarusAccountLoginButtonBinding r104 = (LarusAccountLoginButtonBinding) r103.getValue();
        if (r104 == null) goto L28;
        Button r105 = r104.f357404c;
    L29:
        int r106 = com.larus.login.impl.utils.m.f358328b;
        Fragment r107 = this.f357858b;
        n38.c0 r108 = this.f357877u;
        if (r108 == null) goto L32;
        r101 = r108.f516996b;
    L32:
        PhoneOneKeyPlatform r109 = r101;
        boolean r111 = true;
        if (this.f357857a != 1) goto L36;
        r111 = false;
    L36:
        com.larus.login.impl.utils.m.d(r107, r109, Boolean.valueOf(r111), r105, r110, null);
        return;
    L28:
        r105 = null;
        goto L29
    L8:
        r102 = r100.next();
        if (r100.hasNext() == false) goto L23;
        Integer r112 = this.f357873q.get(((Map.Entry) r102).getKey());
        if (r112 == null) goto L14;
        int r113 = r112.intValue();
    L15:
        Object r114 = r100.next();
        Integer r115 = this.f357873q.get(((Map.Entry) r114).getKey());
        if (r115 == null) goto L18;
        int r116 = r115.intValue();
    L19:
        if (r113 <= r116) goto L22;
        r102 = r114;
        r113 = r116;
    L22:
        if (r100.hasNext() == true) goto L15;
    L18:
        r116 = Integer.MAX_VALUE;
        goto L19
    L14:
        r113 = Integer.MAX_VALUE;
        goto L15
    }

    public final void N(String r110) {
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        new AccountTrace().j("on_module", u(), "landing");
        int r101 = com.larus.login.impl.utils.j.a(r100);
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        String r103 = String.format(this.f357865i.getString(R.string.larus_log_in_page_confirm_note_new), Arrays.copyOf(new Object[]{this.f357865i.getString(R.string.app_name_replace)}, 1));
        if (Intrinsics.areEqual(r110, "enterprise") == false) goto L20;
        IFlowAccountThemeConfigProvider r104 = (IFlowAccountThemeConfigProvider) ServiceManager.get().getService(IFlowAccountThemeConfigProvider.class);
        if (r104 == null) goto L20;
        String r105 = r104.a();
        if (r105 == null) goto L20;
        if (r105.length() <= 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == true) goto L18;
        r105 = null;
    L18:
        if (r105 == null) goto L20;
        String r107 = r105;
    L21:
        Spanned r108 = HtmlCompat.fromHtml(StringsKt.replace$default(r107, "\n", "<br/>", false, 4, null), 0);
        if ((r108 instanceof SpannableStringBuilder) == false) goto L24;
        SpannableStringBuilder r109 = (SpannableStringBuilder) r108;
    L25:
        if (r109 != null) goto L27;
        SpannableString r111 = null;
    L32:
        if (r111 != null) goto L34;
        return;
    L34:
        Iterator<T> r112 = this.f357871o.entrySet().iterator();
        if (r112.hasNext() == true) goto L37;
        Object r113 = null;
    L52:
        Map.Entry r114 = (Map.Entry) r113;
        if (r114 == null) goto L57;
        LarusAccountLoginButtonBinding r115 = (LarusAccountLoginButtonBinding) r114.getValue();
        if (r115 == null) goto L57;
        Button r116 = r115.f357404c;
    L58:
        int r117 = com.larus.login.impl.utils.b.f358315a;
        FragmentManager r118 = this.f357866j;
        String r119 = y(R.string.larus_log_in_tos_confirmation_title);
        String r120 = y(R.string.larus_log_in_tos_confirmation_agree);
        g r121 = new g(this, r110);
        String r122 = y(R.string.larus_log_in_tos_confirmation_disagree);
        h r123 = new h(this);
        if (this.f357857a == 1) goto L61;
        boolean r124 = true;
    L62:
        com.larus.login.impl.utils.b.a(r100, r118, r119, r111, r120, r121, r122, r123, r116, r124);
        return;
    L61:
        r124 = false;
    L57:
        r116 = null;
        goto L58
    L37:
        r113 = r112.next();
        if (r112.hasNext() == false) goto L52;
        Integer r125 = this.f357873q.get(((Map.Entry) r113).getKey());
        if (r125 == null) goto L43;
        int r126 = r125.intValue();
    L44:
        Object r127 = r112.next();
        Integer r128 = this.f357873q.get(((Map.Entry) r127).getKey());
        if (r128 == null) goto L47;
        int r129 = r128.intValue();
    L48:
        if (r126 <= r129) goto L51;
        r113 = r127;
        r126 = r129;
    L51:
        if (r112.hasNext() == true) goto L44;
    L47:
        r129 = Integer.MAX_VALUE;
        goto L48
    L43:
        r126 = Integer.MAX_VALUE;
        goto L44
    L27:
        SpannableString r130 = SpannableString.valueOf(r109);
        Iterator r131 = ArrayIteratorKt.iterator((URLSpan[]) r130.getSpans(0, r130.length(), URLSpan.class));
    L29:
        if (r131.hasNext() == false) goto L31;
        URLSpan r132 = (URLSpan) r131.next();
        int r133 = r130.getSpanStart(r132);
        int r134 = r130.getSpanEnd(r132);
        int r135 = r130.getSpanFlags(r132);
        r130.removeSpan(r132);
        r130.setSpan(new k0(r132, this, r101), r133, r134, r135);
        goto L29
    L31:
        r111 = r130;
        goto L32
    L24:
        r109 = null;
        goto L25
    L14:
        r106 = false;
    L20:
        r107 = r103;
        goto L21
    }

    @Override // com.larus.login.api.h0
    public final void a(int r100) {
        FLogger.f375446a.i("AccountLoginController", "onQuotaStateChanged state=" + r100);
    }

    public final void n(k1 r100) {
        ConstraintLayout r101 = r100.f();
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        r103.verticalChainStyle = 2;
        ((ViewGroup.MarginLayoutParams) r103).height = -2;
        ((ViewGroup.MarginLayoutParams) r103).topMargin = 0;
        r101.setLayoutParams(r103);
        r101.setPadding(r101.getPaddingLeft(), r101.getPaddingTop(), r101.getPaddingRight(), 0);
    L5:
        LinearLayout r104 = r100.k();
        int r105 = -1;
        if (r104 == null) goto L17;
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        ConstraintLayout r108 = r100.f();
        if (r108 == null) goto L10;
        int r109 = r108.getId();
    L11:
        r107.topToBottom = r109;
        LinearLayout r110 = r100.b();
        if (r110 == null) goto L14;
        int r111 = r110.getId();
    L15:
        r107.bottomToTop = r111;
        r104.setLayoutParams(r107);
        goto L17
    L14:
        r111 = -1;
        goto L15
    L10:
        r109 = -1;
    L17:
        if (this.f357857a != 2) goto L24;
        LinearLayout r112 = r100.b();
        if (r112 == null) goto L35;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
        ConstraintLayout r115 = r100.c();
        if (r115 == null) goto L23;
        r105 = r115.getId();
    L23:
        r114.bottomToTop = r105;
        ((ViewGroup.MarginLayoutParams) r114).bottomMargin = i5.h();
        r112.setLayoutParams(r114);
        r112.setVisibility(0);
        return;
    L35:
        return;
    L24:
        LinearLayout r116 = r100.b();
        if (r116 == null) goto L37;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r117;
        ConstraintLayout r119 = r100.c();
        if (r119 == null) goto L29;
        int r120 = r119.getId();
    L30:
        r118.bottomToTop = r120;
        LinearLayout r121 = r100.k();
        if (r121 == null) goto L33;
        r105 = r121.getId();
    L33:
        r118.topToBottom = r105;
        ((ViewGroup.MarginLayoutParams) r118).bottomMargin = i5.h();
        ((ViewGroup.MarginLayoutParams) r118).topMargin = i5.k0();
        r116.setLayoutParams(r118);
        r116.setVisibility(0);
        return;
    L29:
        r120 = -1;
        goto L30
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onDestroy(this, r100);
        d0 r101 = this.f357874r;
        if (r101 == null) goto L5;
        SettingsManager.unregisterListener(r101);
    L5:
        ck9.a r102 = this.f357878v;
        if (r102 == null) goto L30;
        FLogger.f375446a.i(r102.f24067c, "hide");
        PhoneLoginButtonView r103 = r102.f24068d;
        if (r103 == null) goto L30;
        boolean r104 = r103.f358358f;
        r103.a();
        if (r104 == false) goto L30;
        r102.f24066b.invoke(Boolean.FALSE);
    L30:
        com.larus.common_ui.dialog.l0 r105 = this.f357868l;     // Catch: Exception -> L24
        if (r105 == null) goto L18;
        boolean r106 = true;
        if (r105.isShowing() != true) goto L18;
    L19:
        if (r106 == false) goto L26;
        com.larus.common_ui.dialog.l0 r107 = this.f357868l;     // Catch: Exception -> L24
        if (r107 == null) goto L26;
        f(r107);     // Catch: Exception -> L24
    L26:
        this.f357868l = null;
        com.larus.login.impl.downgrade.b r108 = com.larus.login.impl.downgrade.b.f357660a;
        Intrinsics.checkNotNullParameter(this, "listener");
        CopyOnWriteArrayList<com.larus.login.api.h0> r109 = com.larus.login.impl.downgrade.b.f357661b;
        if (r109.contains(this) == false) goto L32;
        r109.remove(this);
        return;
    L32:
        return;
    L18:
        r106 = false;
    L24:
        e = move-exception;
        FLogger.f375446a.e("AccountLoginController", "commonLoadDialog dismiss crash because: " + e.getMessage());
        goto L26
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        DefaultLifecycleObserver.CC.$default$onPause(this, r100);
        if (this.f357875s == 0) goto L14;
        String r101 = this.f357876t;
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L15;
        new AccountTrace();
        AccountTrace.v(this.f357876t, System.currentTimeMillis() - this.f357875s);
        this.f357876t = "";
        return;
    L15:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner r610) {
        Intrinsics.checkNotNullParameter(r610, "owner");
        DefaultLifecycleObserver.CC.$default$onResume(this, r610);
        if (this.f357880x == true) goto L37;
        String r110 = u();
        Bundle r100 = this.f357867k;
        if (r100 == null) goto L10;
        String r101 = r100.getString("key_trigger_app_id");
        if (r101 == null) goto L10;
        String r410 = r101;
    L11:
        String r102 = u();
        String r111 = x();
        com.larus.trace.tracknode.a r103 = this.f357859c;
        String r112 = this.f357860d.f357999c;
        JSONObject r113 = new JSONObject();
        if (this.f357857a != 1) goto L14;
        Object r104 = "half_screen";
    L15:
        r113.put("page_style", r104);
        if (z2.f365865a.setupPreInstallChannels() == false) goto L27;
        IFlowSdkDepend r105 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r105 == null) goto L27;
        r105.T();
        String r106 = h2.f346184a.c();
        if (r106 == null) goto L27;
        if (com.larus.utils.o0.d(r106) == true) goto L25;
        r106 = null;
    L25:
        if (r106 == null) goto L27;
        r113.put("pre_install_channel", r106);
    L27:
        tx9.a1.c(null, null, null, null, null, r102, null, null, r112, null, null, null, null, null, null, r110, r111, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r113, r103, r410, null, null, null, null, null, null, -1574017, -58720257, 7);
        JSONObject r107 = new JSONObject();
        r107.put("current_page", u());
        Bundle r108 = this.f357867k;
        if (r108 == null) goto L31;
        String r109 = r108.getString("key_trigger_app_id");
        if (r109 == null) goto L31;
    L32:
        r107.put("trigger_app", r109);
        r107.put("previous_page", x());
        r107.put("enter_method", this.f357860d.f357999c);
        if (this.f357857a != 1) goto L35;
        Object r114 = "half_screen";
    L36:
        r107.put("page_style", r114);
        n38.c0 r115 = null;
        ApmAgent.monitorEvent(CheckPointType.ENTER_PAGE, r107, null, null);
        this.f357880x = true;
    L39:
        if (AppHost.f326268a.isOversea() == true) goto L52;
        AccountUtils r116 = AccountUtils.f357130a;
        e10 r117 = e10.f368561a;
        if (e10.j() == true) goto L43;
        n38.c0 r118 = r115;
    L44:
        if (r118 != null) goto L46;
    L48:
        ILoginService r119 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r119 == null) goto L52;
        r119.i(new e(this), "AccountLoginController");
        goto L52
    L46:
        if (this.f357877u != null) goto L48;
        FLogger.f375446a.i("AccountLoginController", "onResume: preloadOneKeyInfo = " + r118);
        H(r118);
        goto L48
    L43:
        r118 = AccountUtils.f357132c;
    L52:
        if (this.f357882z == false) goto L59;
        Iterator<Map.Entry<String, LarusAccountLoginButtonBinding>> r120 = this.f357871o.entrySet().iterator();
    L55:
        if (r120.hasNext() == false) goto L59;
        Map.Entry<String, LarusAccountLoginButtonBinding> r121 = r120.next();
        String r122 = r121.getKey();
        LarusAccountLoginButtonBinding r123 = r121.getValue();
        if (Intrinsics.areEqual(r122, this.f357860d.f358001e) == false) goto L55;
        FLogger.f375446a.i("AccountLoginController", "onResume: autoTriggerLoginMethod = " + r122);
        r123.f357404c.performClick();
    L59:
        this.f357882z = false;
        return;
    L35:
        r114 = "full_screen";
    L31:
        r109 = "";
        goto L32
    L14:
        r104 = "full_screen";
    L10:
        r410 = "";
        goto L11
    L37:
        r115 = null;
        goto L39
    }

    public final int v(String r100) {
        Integer r101 = this.f357873q.get(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.intValue();
    }

    public final List w(boolean r100) {
        if (ObricAccountSPIServiceDelegate.f392812b.g() == true) goto L5;
        List<String> r101 = this.f357860d.f358000d;
        if (r101 != null) goto L10;
        Lazy r102 = uj9.d.f550448a;
        return uj9.d.a(true, r100);
    L10:
        return r101;
    L5:
        return CollectionsKt.emptyList();
    }

    public final String y(int r100) {
        return this.f357858b.getString(r100);
    }

    public static void d(AccountLoginController r100, SettingsData r101) {
        if (AppHost.f326268a.isOversea() == false) goto L11;
        IAccountService.Companion r102 = IAccountService.f286094a;
        if (r102.r() == false) goto L11;
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L11;
        if (com.larus.network.http.d.f360144e == true) goto L11;
        r102.q(false);
        r100.p();
    L11:
        Context r103 = r100.getContext();
        if (r103 == null) goto L15;
        IAccountService.f286094a.v(r101.getAppSettings(), r103);
        return;
    }

    public static Unit e(AccountLoginController r100, boolean r101) {
        LarusAccountLoginButtonBinding r102 = r100.f357871o.get("phone_verify_code");
        if (r102 == null) goto L25;
        Integer r103 = r100.f357873q.get("phone_verify_code");
        if (r103 == null) goto L11;
        boolean r104 = true;
        if (r103.intValue() != 1) goto L11;
    L12:
        if (r104 == false) goto L25;
        Context r105 = r100.getContext();
        String r106 = null;
        if (r105 == null) goto L17;
        String r107 = r105.getString(R.string.larus_login_phoneOneTap_cn);
    L18:
        Context r108 = r100.getContext();
        if (r108 == null) goto L21;
        r106 = r108.getString(R.string.larus_log_in_with_phone_button);
    L21:
        if (r101 == true) goto L24;
        r107 = r106;
    L24:
        r102.f357404c.setText(r107);
        goto L25
    L17:
        r107 = null;
    L11:
        r104 = false;
    L25:
        if (r101 == false) goto L28;
        IApplog.f287053a.reportEvent("login_tel_show", new JSONObject());
    L28:
        return Unit.INSTANCE;
    }

    public static final void i(final AccountLoginController r110, EnterpriseLoginEntryResolver.Placement r111) {
        if (r110.f357871o.containsKey("enterprise") == true) goto L96;
        int r100 = 0;
        if (r111 != EnterpriseLoginEntryResolver.Placement.PANEL_HEAD) goto L8;
    L11:
        boolean r101 = true;
    L12:
        int r102 = R.drawable.larus_ic_enterprise_login;
        if (r101 == false) goto L43;
        Iterator<Map.Entry<String, LarusAccountLoginButtonBinding>> r103 = r110.f357871o.entrySet().iterator();
    L16:
        if (r103.hasNext() == false) goto L43;
        Map.Entry<String, LarusAccountLoginButtonBinding> r104 = r103.next();
        String r105 = r104.getKey();
        LarusAccountLoginButtonBinding r106 = r104.getValue();
        r106.f357404c.setBackgroundResource(R.drawable.larus_bg_account_button);
        Context r107 = r110.getContext();
        if (r107 == null) goto L20;
        r106.f357404c.setTextColor(ContextCompat.getColor(r107, R.color.larus_neutral_100));
    L20:
        Context r108 = r110.getContext();
        if (r108 == null) goto L16;
        int r109 = r105.hashCode();
        if (r109 != (-1325936172)) goto L26;
        if (r105.equals("douyin") == false) goto L16;
        int r112 = R.drawable.larus_ic_douyin_phone_one_key;
    L42:
        r106.f357403b.setImageDrawable(AppCompatResources.getDrawable(r108, r112));
        goto L16
    L26:
        if (r109 != (-802737311)) goto L28;
        if (r105.equals("enterprise") == false) goto L16;
        r112 = R.drawable.larus_ic_enterprise_login;
        goto L42
    L28:
        if (r109 != 1903765666) goto L16;
        if (r105.equals("phone_verify_code") == false) goto L16;
        r112 = R.drawable.larus_ic_phone;
    L43:
        Context r113 = r110.getContext();
        if (r113 != null) goto L46;
        Drawable r114 = null;
    L49:
        LarusAccountLoginButtonBinding r115 = r110.m("enterprise", r114, r110.y(R.string.larus_enterprise_login_cn), r101);
        com.larus.utils.e1.d(r115.f357404c, new l(r110));
        if (r111 != EnterpriseLoginEntryResolver.Placement.PANEL_HEAD) goto L57;
        k1 r116 = r110.f357879w;
        if (r116 == null) goto L56;
        ViewGroup r117 = r116.a();
        if (r117 == null) goto L56;
        r117.removeView(r115.f357402a);
        r117.addView(r115.f357402a, 0);
    L56:
        r110.f357871o.remove("enterprise");
        LinkedHashMap r118 = new LinkedHashMap();
        r118.put("enterprise", r115);
        r118.putAll(r110.f357871o);
        r110.f357871o.clear();
        r110.f357871o.putAll(r118);
    L57:
        r110.f357873q.clear();
        Iterator<T> r119 = r110.f357871o.keySet().iterator();
    L59:
        if (r119.hasNext() == false) goto L64;
        Object r120 = r119.next();
        int r121 = r100 + 1;
        if (r100 >= 0) goto L63;
        CollectionsKt.throwIndexOverflow();
    L63:
        LinkedHashMap<String, Integer> r122 = r110.f357873q;
        r122.put((String) r120, Integer.valueOf(r121));
        r100 = r121;
        goto L59
    L64:
        k1 r123 = r110.f357879w;
        if (r123 == null) goto L69;
        ImageView r124 = r123.g();
        if (r124 == null) goto L69;
        com.larus.utils.e1.o(r124);
    L69:
        k1 r125 = r110.f357879w;
        if (r125 == null) goto L74;
        View r126 = r125.j();
        if (r126 == null) goto L74;
        com.larus.utils.e1.o(r126);
    L74:
        r110.E();
        return;
    L46:
        if (r101 == false) goto L48;
        r102 = R.drawable.larus_ic_enterprise_login_primary;
    L48:
        r114 = AppCompatResources.getDrawable(r113, r102);
        goto L49
    L8:
        if (r110.f357871o.isEmpty() == true) goto L11;
        r101 = false;
        goto L12
    }

    public static final void k(final AccountLoginController r100, boolean r101) {
        if (r101 == false) goto L18;
        k1 r102 = r100.f357879w;
        if (r102 == null) goto L8;
        TextView r103 = r102.l();
        if (r103 == null) goto L8;
        com.larus.utils.e1.x(r103);
    L8:
        k1 r104 = r100.f357879w;
        if (r104 == null) goto L13;
        View r105 = r104.i();
        if (r105 == null) goto L13;
        com.larus.utils.e1.x(r105);
    L13:
        k1 r106 = r100.f357879w;
        if (r106 == null) goto L29;
        TextView r107 = r106.l();
        if (r107 == null) goto L30;
        com.larus.utils.e1.d(r107, new com.larus.login.impl.loginfragment.a(r100));
        return;
    L30:
        return;
    L29:
        return;
    L18:
        k1 r108 = r100.f357879w;
        if (r108 == null) goto L23;
        TextView r109 = r108.l();
        if (r109 == null) goto L23;
        com.larus.utils.e1.o(r109);
    L23:
        k1 r110 = r100.f357879w;
        if (r110 == null) goto L32;
        View r111 = r110.i();
        if (r111 == null) goto L33;
        com.larus.utils.e1.o(r111);
        return;
    L33:
        return;
    }

    public final void P(String r100, int r101) {
        FLogger.f375446a.i("AccountLoginController", "updateLoginButtonVisibility channel=" + r100 + " visibility=" + r101);
        LarusAccountLoginButtonBinding r102 = this.f357871o.get(r100);
        if (r102 == null) goto L7;
        FrameLayout r103 = r102.f357405d;
        if (r103 == null) goto L7;
        r103.setVisibility(r101);
    L7:
        if (r101 != 0) goto L14;
        String r104 = u();
        String r105 = x();
        Long r106 = Long.valueOf(v(r100));
        JSONObject r107 = new JSONObject();
        if (this.f357857a != 1) goto L11;
        String r108 = "half_screen";
    L12:
        r107.put("page_style", r108);
        Unit r109 = Unit.INSTANCE;
        s1.d(r104, r105, r106, r100, r107, 32);
        return;
    L11:
        r108 = "full_screen";
        goto L12
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.login.impl.loginfragment.h] */
    public final void r(List<String> r110, boolean r111) {
        Iterator<String> r112 = r110.iterator();
    L4:
        if (r112.hasNext() == false) goto L127;
        final String r100 = r112.next();
        final ?? r101 = new com.larus.login.impl.loginfragment.h(this, r100);
        Context r102 = getContext();
        if (r102 == null) goto L4;
        String r103 = null;
        String r104 = null;
        String r105 = null;
        String r106 = null;
        Drawable r107 = null;
        String r108 = null;
        boolean r109 = false;
        switch(r100.hashCode()) {
            case -1325936172: goto L105;
            case -1240244679: goto L88;
            case -802737311: goto L76;
            case -791770330: goto L59;
            case 3321844: goto L42;
            case 497130182: goto L25;
            case 1903765666: goto L11;
            default: goto L4;
        };
    L11:
        if (r100.equals("phone_verify_code") == false) goto L4;
        boolean r113 = this.f357871o.isEmpty();
        if (r111 == true) goto L19;
        if (r113 == false) goto L17;
        Drawable r114 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_phone_primary);
    L18:
        Button r115 = m(r100, r114, r102.getString(R.string.larus_log_in_with_phone_button), r113).f357404c;
    L23:
        Intrinsics.checkNotNull(r115);
        com.larus.utils.e1.d(r115, new o(this, r101, r100));
        goto L4
    L17:
        r114 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_phone);
        goto L18
    L19:
        if (r113 == false) goto L21;
        Drawable r116 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_phone_primary);
    L22:
        r115 = l(r100, r116, r102.getString(R.string.larus_log_in_with_phone_button));
        goto L23
    L21:
        r116 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_phone);
        goto L22
    L25:
        if (r100.equals("facebook") == false) goto L4;
        ILoginService r117 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r117 != null) goto L30;
    L32:
        if (r109 == false) goto L4;
        if (r111 == true) goto L39;
        Drawable r118 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_facebook);
        Context r119 = getContext();
        if (r119 == null) goto L38;
        r104 = r119.getString(R.string.larus_log_in_with_facebook_button);
    L38:
        Button r120 = m(r100, r118, r104, this.f357871o.isEmpty()).f357404c;
    L40:
        Intrinsics.checkNotNull(r120);
        com.larus.utils.e1.d(r120, new n(r101, r100, this));
        goto L4
    L39:
        r120 = l(r100, AppCompatResources.getDrawable(r102, R.drawable.larus_ic_facebook), "");
        goto L40
    L30:
        if (r117.C(LoginPlatform.FACEBOOK) != true) goto L32;
        r109 = true;
        goto L32
    L42:
        if (r100.equals("line") == false) goto L4;
        ILoginService r121 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r121 != null) goto L47;
    L49:
        if (r109 == false) goto L4;
        if (r111 == true) goto L56;
        Drawable r122 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_line);
        Context r123 = getContext();
        if (r123 == null) goto L55;
        r105 = r123.getString(R.string.larus_log_in_with_line_button);
    L55:
        Button r124 = m(r100, r122, r105, this.f357871o.isEmpty()).f357404c;
    L57:
        Intrinsics.checkNotNull(r124);
        com.larus.utils.e1.d(r124, new m(r101, r100, this));
        goto L4
    L56:
        r124 = l(r100, AppCompatResources.getDrawable(r102, R.drawable.larus_ic_line), "");
        goto L57
    L47:
        if (r121.C(LoginPlatform.LINE) != true) goto L49;
        r109 = true;
        goto L49
    L59:
        if (r100.equals("wechat") == false) goto L4;
        ILoginService r125 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r125 != null) goto L64;
    L66:
        if (r109 == false) goto L4;
        if (r111 == true) goto L73;
        Drawable r126 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_wechat);
        Context r127 = getContext();
        if (r127 == null) goto L72;
        r106 = r127.getString(R.string.larus_wechat_login);
    L72:
        Button r128 = m(r100, r126, r106, this.f357871o.isEmpty()).f357404c;
    L74:
        Intrinsics.checkNotNull(r128);
        com.larus.utils.e1.d(r128, new k(r101, r100, this));
        goto L4
    L73:
        r128 = l(r100, AppCompatResources.getDrawable(r102, R.drawable.larus_ic_wechat), "");
        goto L74
    L64:
        if (r125.C(LoginPlatform.WEIXIN) != true) goto L66;
        r109 = true;
        goto L66
    L76:
        if (r100.equals("enterprise") == false) goto L4;
        if (r111 == true) goto L4;
        boolean r129 = this.f357871o.isEmpty();
        Context r130 = getContext();
        if (r130 == null) goto L86;
        if (r129 == false) goto L84;
        int r131 = R.drawable.larus_ic_enterprise_login_primary;
    L85:
        r107 = AppCompatResources.getDrawable(r130, r131);
        goto L86
    L84:
        r131 = R.drawable.larus_ic_enterprise_login;
    L86:
        com.larus.utils.e1.d(m(r100, r107, r102.getString(R.string.larus_enterprise_login_cn), r129).f357404c, new p(this, r100));
        goto L4
    L88:
        if (r100.equals("google") == false) goto L4;
        ILoginService r132 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r132 != null) goto L93;
    L95:
        if (r109 == false) goto L4;
        if (r111 == true) goto L102;
        Drawable r133 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_google);
        Context r134 = getContext();
        if (r134 == null) goto L101;
        r108 = r134.getString(R.string.larus_log_in_with_google_button);
    L101:
        Button r135 = m(r100, r133, r108, this.f357871o.isEmpty()).f357404c;
    L103:
        Intrinsics.checkNotNull(r135);
        com.larus.utils.e1.d(r135, new i(r101, r100, this));
        goto L4
    L102:
        r135 = l(r100, AppCompatResources.getDrawable(r102, R.drawable.larus_ic_google), "");
        goto L103
    L93:
        if (r132.C(LoginPlatform.GOOGLE) != true) goto L95;
        r109 = true;
        goto L95
    L105:
        if (r100.equals("douyin") == false) goto L4;
        ILoginService r136 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r136 != null) goto L110;
    L112:
        if (r109 == false) goto L4;
        boolean r137 = this.f357871o.isEmpty();
        if (r111 == true) goto L122;
        if (r137 == false) goto L117;
        Drawable r138 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_douyin);
    L118:
        Context r139 = getContext();
        if (r139 == null) goto L121;
        r103 = r139.getString(R.string.larus_log_in_with_oin_button_cn);
    L121:
        Button r140 = m(r100, r138, r103, this.f357871o.isEmpty()).f357404c;
    L126:
        Intrinsics.checkNotNull(r140);
        com.larus.utils.e1.d(r140, new j(r101, r100, this));
        goto L4
    L117:
        r138 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_douyin_phone_one_key);
        goto L118
    L122:
        if (r137 == false) goto L124;
        Drawable r141 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_douyin);
    L125:
        r140 = l(r100, r141, r102.getString(R.string.larus_log_in_with_oin_button_cn));
        goto L126
    L124:
        r141 = AppCompatResources.getDrawable(r102, R.drawable.larus_ic_douyin_phone_one_key);
        goto L125
    L110:
        if (r136.C(LoginPlatform.DOUYIN) != true) goto L112;
        r109 = true;
        goto L112
    }

    public final Button l(String r100, Drawable r101, String r102) {
        LinearLayout r103 = null;
        if (this.A == true) goto L12;
        Lazy r104 = uj9.d.f550448a;
        if (uj9.d.d() == true) goto L12;
        LayoutInflater r105 = LayoutInflater.from(getContext());
        k1 r106 = this.f357879w;
        if (r106 == null) goto L10;
        r103 = r106.b();
    L10:
        LarusAccountBottomLoginButtonBinding r107 = LarusAccountBottomLoginButtonBinding.a(r105, r103);
        r107.f357393b.setImageDrawable(r101);
        this.f357872p.put(r100, r107);
        this.f357873q.put(r100, Integer.valueOf(this.f357871o.size()));
        return r107.f357394c;
    L12:
        LayoutInflater r108 = LayoutInflater.from(getContext());
        k1 r109 = this.f357879w;
        if (r109 == null) goto L15;
        r103 = r109.b();
    L15:
        View r110 = r108.inflate(R.layout.larus_account_single_bottom_login_button, r103, false);
        r103.addView(r110);
        int r111 = R.id.button_iv;
        ImageView r112 = (ImageView) ViewBindings.findChildViewById(r110, R.id.button_iv);
        if (r112 == null) goto L22;
        r111 = R.id.button_login;
        Button r113 = (Button) ViewBindings.findChildViewById(r110, R.id.button_login);
        if (r113 == null) goto L22;
        FrameLayout r114 = (FrameLayout) r110;
        r112.setImageDrawable(r101);
        r113.setText(r102);
        this.f357873q.put(r100, Integer.valueOf(this.f357871o.size()));
        return r113;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r110.getResources().getResourceName(r111)));
    }

    public AccountLoginController(int r100, Fragment r101, com.larus.trace.tracknode.a r102, n1 r103) {
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "trackNode");
        Intrinsics.checkNotNullParameter(r103, "triggerSceneData");
        this.f357857a = r100;
        this.f357858b = r101;
        this.f357859c = r102;
        this.f357860d = r103;
        this.f357861e = LazyKt.lazy(new com.larus.login.impl.loginfragment.d(this));
        this.f357862f = LazyKt.lazy(new com.larus.login.impl.loginfragment.e(this));
        this.f357863g = LazyKt.lazy(new com.larus.login.impl.loginfragment.f(this));
        this.f357864h = LifecycleOwnerKt.getLifecycleScope(r101);
        this.f357865i = r101.getResources();
        this.f357866j = r101.getChildFragmentManager();
        Bundle r104 = r101.getArguments();
        this.f357867k = r104;
        this.f357870n = 500;
        this.f357871o = new LinkedHashMap();
        new LinkedHashMap();
        this.f357872p = new LinkedHashMap();
        this.f357873q = new LinkedHashMap();
        this.f357876t = "";
        this.f357882z = true;
        r101.getLifecycle().addObserver(this);
        FLogger.f375446a.d("AccountLoginController", "init " + r103 + ", " + r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit c(AccountLoginController r100, Ref.ObjectRef r101, boolean r110, com.larus.network.http.a r111) {
        FLogger.f375446a.i("AccountLoginController", "applyTouristClick cvsAsync is " + r111);
        String r102 = null;
        T r103 = 0;
        if ((r111 instanceof com.larus.network.http.w) == false) goto L17;
        FragmentActivity r104 = r100.getActivity();
        if (r104 == null) goto L9;
        if (r110 == false) goto L8;
        r103 = new com.larus.common_ui.dialog.l0(r104, 0.0f, false, 6);
    L8:
        r101.element = r103;
    L9:
        com.larus.common_ui.dialog.l0 r105 = (com.larus.common_ui.dialog.l0) r101.element;
        if (r105 == null) goto L38;
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L40;
        DialogLancet.handleBlockedDialogShow(r105);
        goto L38
    L40:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
    L15:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
    L38:
        return Unit.INSTANCE;
    L17:
        if ((r111 instanceof com.larus.network.http.y) == false) goto L23;
        com.larus.common_ui.dialog.l0 r106 = (com.larus.common_ui.dialog.l0) r101.element;
        if (r106 == null) goto L21;
        f(r106);
    L21:
        TouristManager r107 = TouristManager.f357001a;
        JSONObject r112 = new JSONObject();
        r112.put("current_page", r100.u());
        r107.q(r112);
        goto L38
    L23:
        if ((r111 instanceof com.larus.network.http.f) == false) goto L38;
        com.larus.common_ui.dialog.l0 r108 = (com.larus.common_ui.dialog.l0) r101.element;
        if (r108 == null) goto L27;
        f(r108);
    L27:
        String r109 = ((com.larus.network.http.f) r111).f360157d.getMessage();
        t19.s r113 = t19.s.f544207a;
        AppHost.Companion r114 = AppHost.f326268a;
        Application r115 = r114.getApplication();
        if (r109 != null) goto L30;
    L35:
        String r116 = r114.getApplication().getString(R.string.larus_log_in_internet_error);
    L36:
        t19.s.j(r113, r115, r116, null, false, 28);
        goto L38
    L30:
        if ((!StringsKt.isBlank(r109)) == false) goto L32;
        r102 = r109;
    L32:
        if (r102 == null) goto L35;
        r116 = r102;
        goto L36
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.util.AttributeSet] */
    /* JADX WARN: Type inference failed for: r12v1, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.LayoutInflater] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.larus.login.impl.loginfragment.e0] */
    /* JADX WARN: Type inference failed for: r6v12, types: [com.larus.login.impl.loginfragment.f0] */
    public final LarusAccountLoginButtonBinding m(String r110, Drawable r111, String r210, boolean r211) {
        Context r100 = getContext();
        int r101 = 0;
        ?? r112 = 0;
        ViewGroup r113 = null;
        if (Intrinsics.areEqual(r110, "phone_verify_code") == false) goto L34;
        Lazy r102 = com.larus.login.impl.utils.j.f358321a;
        if (AppHost.f326268a.isOversea() == true) goto L11;
        boolean r114 = true;
        if (com.larus.login.impl.utils.j.b() != 1) goto L9;
    L12:
        if (r114 == false) goto L34;
        if (r100 == null) goto L34;
        PhoneLoginButtonView r103 = new PhoneLoginButtonView(r100, r112, 6, r101);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-1, -2);
        r104.setMarginStart(i5.Q());
        r104.setMarginEnd(i5.Q());
        r104.bottomMargin = i5.h();
        k1 r115 = this.f357879w;
        if (r115 == null) goto L17;
        r113 = r115.a();
    L17:
        if (r113 == null) goto L20;
        r113.addView(r103, r104);
    L20:
        if (r103.getCarrierTargetHeight() <= 0) goto L23;
        if (r113 == null) goto L23;
        r113.setPadding(r113.getPaddingLeft(), r113.getPaddingTop(), r113.getPaddingRight(), r113.getPaddingBottom() + r103.getCarrierTargetHeight());
    L23:
        r103.getButtonIv().setImageDrawable(r111);
        r103.getButtonLogin().setText(r210);
        if (r211 == false) goto L26;
        r103.getButtonLogin().setBackgroundResource(R.drawable.larus_bg_account_button_white);
        r103.getButtonLogin().setTextColor(ContextCompat.getColor(r100, R.color.larus_base_1));
    L27:
        LarusAccountLoginButtonBinding r105 = LarusAccountLoginButtonBinding.a(r103);
        this.f357871o.put("phone_verify_code", r105);
        this.f357873q.put("phone_verify_code", Integer.valueOf(this.f357871o.size()));
        if (this.f357878v != null) goto L30;
        this.f357878v = new ck9.a(r100, new e0(this), new f0(this));
    L30:
        ck9.a r106 = this.f357878v;
        if (r106 == null) goto L33;
        n38.c0 r107 = this.f357877u;
        Intrinsics.checkNotNullParameter(r103, "view");
        FLogger.f375446a.i(r106.f24067c, "bindPhoneLoginButton");
        r106.f24068d = r103;
        r103.setOnCarrierEditClick(r106.f24065a);
        r106.a(r107, false);
    L33:
        return r105;
    L26:
        r103.getButtonLogin().setBackgroundResource(R.drawable.larus_bg_account_button);
        r103.getButtonLogin().setTextColor(ContextCompat.getColor(r100, R.color.larus_neutral_100));
        goto L27
    L9:
        if (com.larus.login.impl.utils.j.b() == 2) goto L12;
    L11:
        r114 = false;
    L34:
        ?? r108 = LayoutInflater.from(getContext());
        k1 r109 = this.f357879w;
        if (r109 == null) goto L37;
        r112 = r109.a();
    L37:
        View r116 = r108.inflate(R.layout.larus_account_login_button, r112, false);
        r112.addView(r116);
        LarusAccountLoginButtonBinding r117 = LarusAccountLoginButtonBinding.a(r116);
        r117.f357403b.setImageDrawable(r111);
        r117.f357404c.setText(r210);
        if (r211 == false) goto L42;
        r117.f357404c.setBackgroundResource(R.drawable.larus_bg_account_button_white);
        Context r118 = getContext();
        if (r118 == null) goto L45;
        r117.f357404c.setTextColor(ContextCompat.getColor(r118, R.color.larus_base_1));
    L45:
        this.f357871o.put(r110, r117);
        this.f357873q.put(r110, Integer.valueOf(this.f357871o.size()));
        return r117;
    L42:
        r117.f357404c.setBackgroundResource(R.drawable.larus_bg_account_button);
        Context r119 = getContext();
        if (r119 == null) goto L45;
        r117.f357404c.setTextColor(ContextCompat.getColor(r119, R.color.larus_neutral_100));
        goto L45
    }
}
