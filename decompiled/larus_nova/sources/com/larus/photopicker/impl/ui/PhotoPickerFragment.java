package com.larus.photopicker.impl.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.creativex.mediaimport.preview.internal.main.MaterialAndPreviewCombiner;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import com.bytedance.creativex.mediaimport.repository.internal.main.DefaultMaterialRepositoryReleaser;
import com.bytedance.creativex.mediaimport.repository.internal.main.MediaItemInternal;
import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import com.bytedance.creativex.mediaimport.view.internal.MultiSelectStrategy;
import com.bytedance.creativex.mediaimport.view.internal.viewmodel.MaterialIndexedSelectorViewModel;
import com.bytedance.creativex.mediaimport.view.internal.viewmodel.MediaSelectFolderListViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.InjectInputContainer;
import com.larus.nova.R;
import com.larus.photopicker.impl.ui.holder.InputPaddingFooterViewHolder;
import com.larus.platform.model.album.AlbumInputState;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.chat.ObricChatUIDelegate;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 í\u00012\u00020\u00012\u00020\u0002:\u0004í\u0001î\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010a\u001a\u00020\r2\u0006\u0010b\u001a\u00020\bH\u0002J\b\u0010c\u001a\u00020\tH\u0002J\u0016\u0010d\u001a\u00020\t2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020#0\fH\u0002J3\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020\r2!\u0010h\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\t0\u0006H\u0002J\u0010\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020<H\u0002J\u0018\u0010y\u001a\u00020\r2\u000e\u0010z\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002J\b\u0010{\u001a\u00020\tH\u0002J\b\u0010|\u001a\u00020\tH\u0002J\b\u0010}\u001a\u00020\tH\u0002J\u0015\u0010\u0080\u0001\u001a\u00020\t2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J-\u0010\u0083\u0001\u001a\u0004\u0018\u00010<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J\u001d\u0010\u0088\u0001\u001a\u00020\t2\u0006\u0010x\u001a\u00020<2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J\t\u0010\u0089\u0001\u001a\u00020\tH\u0002J\u0011\u0010\u008a\u0001\u001a\u00020\t2\u0006\u0010x\u001a\u00020<H\u0002J\t\u0010\u008d\u0001\u001a\u00020\rH\u0002J\t\u0010\u008e\u0001\u001a\u00020\tH\u0002J\t\u0010\u008f\u0001\u001a\u00020\tH\u0002J\u001c\u0010\u0090\u0001\u001a\u00020\t2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0094\u0001\u001a\u00020\tH\u0002J\t\u0010\u0095\u0001\u001a\u00020\tH\u0002J\t\u0010\u0096\u0001\u001a\u00020\tH\u0002J\u0019\u0010\u0097\u0001\u001a\u00020\t2\u000e\u0010z\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002J\t\u0010\u0098\u0001\u001a\u00020\tH\u0002J\n\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0002J\t\u0010\u009b\u0001\u001a\u00020\tH\u0002J\t\u0010\u009c\u0001\u001a\u00020#H\u0002J\u0011\u0010\u009d\u0001\u001a\u0004\u0018\u00010#*\u0004\u0018\u00010)H\u0002J\u000f\u0010\u009e\u0001\u001a\u00020\u001d*\u0004\u0018\u00010)H\u0002J\u0013\u0010\u009f\u0001\u001a\u00020\t2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002J\u0013\u0010¢\u0001\u001a\u00020\t2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002J\u0019\u0010£\u0001\u001a\u00020\t2\u000e\u0010z\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002J\u0019\u0010¤\u0001\u001a\u00020\t2\u000e\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020\b0¦\u0001H\u0002J\u0019\u0010©\u0001\u001a\u00020\t2\u000e\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020\b0¦\u0001H\u0002J\t\u0010ª\u0001\u001a\u00020@H\u0002J\u0019\u0010«\u0001\u001a\u00020\t2\u000e\u0010¬\u0001\u001a\t\u0012\u0004\u0012\u00020\b0\u00ad\u0001H\u0002J\t\u0010®\u0001\u001a\u00020\tH\u0016J\t\u0010¯\u0001\u001a\u00020\tH\u0016J\t\u0010°\u0001\u001a\u00020#H\u0016J\u0013\u0010±\u0001\u001a\u00020\t2\b\u0010²\u0001\u001a\u00030³\u0001H\u0016J\t\u0010´\u0001\u001a\u00020\rH\u0016J\t\u0010µ\u0001\u001a\u00020\tH\u0016J\u000b\u0010¶\u0001\u001a\u0004\u0018\u00010#H\u0002J\u000b\u0010·\u0001\u001a\u0004\u0018\u00010#H\u0002J\u0014\u0010¸\u0001\u001a\u00020\t2\t\u0010¹\u0001\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010º\u0001\u001a\u00020\t2\u0007\u0010»\u0001\u001a\u00020WJ\u0010\u0010¼\u0001\u001a\u00020\r2\u0007\u0010½\u0001\u001a\u00020\u001dJ\u0012\u0010¾\u0001\u001a\u00020\t2\u0007\u0010»\u0001\u001a\u00020WH\u0002J\t\u0010¿\u0001\u001a\u00020\tH\u0002J\u001f\u0010À\u0001\u001a\u00020\t2\t\u0010Á\u0001\u001a\u0004\u0018\u00010#2\t\u0010Â\u0001\u001a\u0004\u0018\u00010#H\u0002J\f\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0002J\n\u0010Å\u0001\u001a\u0005\u0018\u00010\u0087\u0001J\t\u0010Æ\u0001\u001a\u0004\u0018\u00010<J\t\u0010Ç\u0001\u001a\u0004\u0018\u00010<J\u0013\u0010È\u0001\u001a\u00020\t2\n\u0010É\u0001\u001a\u0005\u0018\u00010Ê\u0001J\u001a\u0010Ë\u0001\u001a\u00020\t2\u000f\u0010Ì\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\fH\u0002J\u0014\u0010Í\u0001\u001a\u0004\u0018\u00010\b2\u0007\u0010Î\u0001\u001a\u00020#H\u0002Jv\u0010Ï\u0001\u001a\u00020\b2\b\u0010É\u0001\u001a\u00030Ê\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u00012\u0007\u0010Ò\u0001\u001a\u00020#2\u0007\u0010Ó\u0001\u001a\u00020#2\u0007\u0010Ô\u0001\u001a\u00020\u001f2\u0007\u0010Õ\u0001\u001a\u00020\u001f2\u0007\u0010Ö\u0001\u001a\u00020\u001d2\u0006\u0010k\u001a\u00020\u001d2\u0007\u0010×\u0001\u001a\u00020\u001f2\u0007\u0010Ø\u0001\u001a\u00020#2\u0007\u0010Ù\u0001\u001a\u00020#2\u0007\u0010Ú\u0001\u001a\u00020#H\u0002J\n\u0010Û\u0001\u001a\u00030Ü\u0001H\u0002J\u0012\u0010Ý\u0001\u001a\u00020\t2\u0007\u0010Þ\u0001\u001a\u00020\bH\u0002J\u001b\u0010ß\u0001\u001a\u00020\t2\u0007\u0010à\u0001\u001a\u00020\b2\u0007\u0010á\u0001\u001a\u00020\rH\u0002J\u0012\u0010â\u0001\u001a\u00020\t2\u0007\u0010à\u0001\u001a\u00020\bH\u0002J\u0012\u0010ã\u0001\u001a\u00020\t2\u0007\u0010ä\u0001\u001a\u00020\bH\u0002J\f\u0010å\u0001\u001a\u0005\u0018\u00010æ\u0001H\u0002J\u0007\u0010ç\u0001\u001a\u00020\rJ\u0016\u0010è\u0001\u001a\u0011\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#\u0018\u00010é\u0001J\u000f\u0010ê\u0001\u001a\u00020\t2\u0006\u0010V\u001a\u00020\rJ\u000f\u0010ë\u0001\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001dJ\t\u0010ì\u0001\u001a\u00020\rH\u0016R \u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020.0-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010H\u001a\b\u0012\u0004\u0012\u00020\t0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR(\u0010M\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR(\u0010S\u001a\u0010\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010P\"\u0004\bU\u0010RR(\u0010X\u001a\u0004\u0018\u00010W2\b\u0010V\u001a\u0004\u0018\u00010W@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010]\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001d\u0010l\u001a\u0004\u0018\u00010m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\bn\u0010oR\u000e\u0010r\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010d\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020# u*\n\u0012\u0004\u0012\u00020#\u0018\u00010t0t0sX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010~\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010q\u001a\u0004\b~\u0010^R\u0012\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ï\u0001"}, d2 = {"Lcom/larus/photopicker/impl/ui/PhotoPickerFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/injectinput/IInjectInputPhotoPickerPage;", "<init>", "()V", "onConfirm", "Lkotlin/Function1;", "Lcom/bytedance/creativex/mediaimport/view/internal/ConfirmInfo;", "Lcom/bytedance/creativex/mediaimport/repository/api/IMaterialItem;", "", "onMultiConfirm", "Lkotlin/Function2;", "", "", "onTryToClose", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "mediaViewModel", "Lcom/bytedance/creativex/mediaimport/view/internal/viewmodel/MediaSelectViewModel;", "selectorViewModel", "Lcom/bytedance/creativex/mediaimport/view/internal/viewmodel/MaterialSelectorViewModel;", "previewViewModel", "Lcom/bytedance/creativex/mediaimport/preview/internal/IPreviewViewModel;", "cancelSelectAll", "Lkotlin/Function0;", "onlyDisplayVideo", "supportVideo", "enableSeparateMediaSelection", "maxSelectVideoCount", "", "maxVideoDuration", "", "isMultiSelect", "isUseSingleDefault", "clickFrom", "", "maxSelectCount", "albumSpanCount", "isFirstLandingTab", "defaultTabIndex", "curShowingCategory", "Lcom/bytedance/creativex/mediaimport/repository/api/MaterialCategoryType;", "isSupportOriginalImage", "isOriginalImageChecked", "lastDispatchedSelectedItems", "", "Lcom/larus/platform/model/album/AlbumSelectionEventItem;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "combiner", "Lcom/bytedance/creativex/mediaimport/preview/internal/main/MaterialAndPreviewCombiner;", "mediaRootView", "Landroid/widget/FrameLayout;", "inputContainerView", "previewRootView", "containerRootView", "containerPageRootView", "containerInputView", "Lcom/larus/common_ui/widget/InjectInputContainer;", "inputViewTouchOutsideView", "Landroid/view/View;", "screenshotAnimationView", "Landroid/widget/ImageView;", "previewView", "Lcom/bytedance/creativex/mediaimport/preview/internal/main/PreviewView;", "selectorOriginalImageCheckbox", "lastDataList", "loadFromRequestPermissions", "maxSelectCountLimitManager", "Lcom/larus/photopicker/impl/util/MaxSelectCountLimitManager;", "albumConfig", "Lcom/larus/platform/model/album/AlbumSettingConfig;", "cancelCallback", "getCancelCallback", "()Lkotlin/jvm/functions/Function0;", "setCancelCallback", "(Lkotlin/jvm/functions/Function0;)V", "resultCallback", "Lcom/larus/platform/AlbumMultiSelectItem;", "getResultCallback", "()Lkotlin/jvm/functions/Function1;", "setResultCallback", "(Lkotlin/jvm/functions/Function1;)V", "multiResultCallback", "getMultiResultCallback", "setMultiResultCallback", "value", "Lcom/larus/platform/model/album/ExternalAlbumUIConfig;", "externalUiConfig", "getExternalUiConfig", "()Lcom/larus/platform/model/album/ExternalAlbumUIConfig;", "setExternalUiConfig", "(Lcom/larus/platform/model/album/ExternalAlbumUIConfig;)V", "isForceDayMode", "()Z", "setForceDayMode", "(Z)V", "isOverMaxVideoDuration", "data", "showMaxVideoDurationToast", "requestPermissions", ComplianceResult.JsonKey.PERMISSIONS, "updateBottomPaddingToRecyclerView", "isBottomPaddingShow", "paddingPostProcessor", "Lkotlin/ParameterName;", "name", "height", "photoPickerInputService", "Lcom/larus/bmhome/injectinput/IInjectInputService;", "getPhotoPickerInputService", "()Lcom/larus/bmhome/injectinput/IInjectInputService;", "photoPickerInputService$delegate", "Lkotlin/Lazy;", "currentFooterPadding", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "captureScreen", "Landroid/graphics/Bitmap;", "view", "checkAndUpdateDataList", "dataList", "updateDataListWithAnimation", "updateDataListNoAnimation", "onAnimationEnd", "isInjectInputInSingleMode", "isInjectInputInSingleMode$delegate", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "mobPhotoPickerPageShow", "initViews", "injectInputHostCallback", "Lcom/larus/bmhome/injectinput/IInjectInputHostCallback;", "isInjectInput", "setupInjectInputFragment", "setupInjectInputSafeBottom", "addFragmentSafely", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "containerId", "loadMediaDataToView", "observeSelectionChanges", "observerOnMediaDataChanged", "onMediaDataChanged", "initViewModel", "initMediaView", "Lcom/bytedance/creativex/mediaimport/view/api/IMaterialSelectView;", "initWithExternalUIConfig", "isLandingTabForMob", "toTabName", "toTabIndex", "configTabView", "viewConfigure", "Lcom/bytedance/creativex/mediaimport/view/internal/main/MaterialSelectView$ViewConfigure;", "configTitleView", "configSwitchMultiModeBtnVisibility", "configAddPartImageView", "listConfig", "Lcom/bytedance/creativex/mediaimport/view/internal/base/BaseMediaSelectListView$ViewConfigure;", "inputPaddingFooterViewHolder", "Lcom/larus/photopicker/impl/ui/holder/InputPaddingFooterViewHolder;", "configAddFooterView", "initPreView", "initValidator", "viewModel", "Lcom/bytedance/creativex/mediaimport/view/internal/IMaterialSelectorViewModel;", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "autoLogEnterPage", "logEnterPage", "getActualEnterMethod", "getActualClickFrom", "mobClickAlbumButtonEventHelper", "buttonName", "updatePageUI", "config", "consumeExternalOnKeyDownEvent", "keyCode", "mobTabShowOnUIConfigChanged", "mobTabShowOnTabSelected", "mobAlbumTabShow", "tabName", "isLandingTab", "getAlbumActivity", "Landroidx/fragment/app/FragmentActivity;", "getTitleView", "getTabView", "getContentView", "removeSelectedItemByUri", "uri", "Landroid/net/Uri;", "refreshMediaDataAndSelectNewItem", "uriList", "queryPhotoInfoFromSystemGallery", "uriString", "createMediaItemFromCursorInfo", "type", "Lcom/bytedance/creativex/mediaimport/repository/api/MediaType;", "path", CommonConstant.KEY_DISPLAY_NAME, "dateModified", "size", "width", "duration", DBDefinition.MIME_TYPE, "folderName", "folderId", "getCurrentMaterialType", "Lcom/bytedance/creativex/mediaimport/repository/api/BuiltInMaterialType;", "insertPhotoToListAndSelect", "newPhotoItem", "simulateItemSelection", MapController.ITEM_LAYER_TAG, "isScrollToTop", "syncItemToPreviewViewModel", "syncItemToFolderList", "newMaterialItem", "getCurrentListview", "Landroidx/recyclerview/widget/RecyclerView;", "switchToFirstFolder", "getCurrentFolderInfo", "Lkotlin/Pair;", "updateMultiSelectOpenPreviewConfig", "updateMaxSelectCount", "isInjectInputAlbumShowing", "Companion", "PhotoPickerInputCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoPickerFragment extends TraceFragment implements op8.h {

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final /* synthetic */ int f364051p0 = 0;
    public boolean A;
    public Map<String, kq9.d> B;
    public FragmentExtKt$addOnBackPressed$callback$1 C;
    public MaterialAndPreviewCombiner D;
    public FrameLayout E;
    public FrameLayout F;
    public FrameLayout G;
    public FrameLayout H;
    public FrameLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public InjectInputContainer f364052J;
    public View K;
    public ImageView L;
    public com.bytedance.creativex.mediaimport.preview.internal.main.m0 M;
    public ImageView N;
    public List<? extends ki4.r> O;
    public boolean P;
    public kp9.k Q;
    public AlbumSettingConfig R;
    public Function0<Unit> S;
    public Function1<? super xp9.i, Unit> T;
    public Function1<? super xp9.i, Unit> U;
    public kq9.m V;
    public final Lazy W;
    public int X;
    public final Lazy Y;
    public op8.g Z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w2 f364053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g0 f364054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h0 f364055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f364056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.creativex.mediaimport.view.internal.viewmodel.x f364057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaterialIndexedSelectorViewModel f364058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ji4.c f364059k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public InputPaddingFooterViewHolder f364060k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f364061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f364062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f364063n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f364064o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f364065p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f364066q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f364067r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f364068s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f364069t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f364070u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f364071v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f364072w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f364073x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ki4.a0 f364074y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f364075z;

    public static final class a {
    }

    public final class b extends op8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoPickerFragment f364079a;

        public b(PhotoPickerFragment r100) {
            this.f364079a = r100;
        }

        @Override // op8.c, op8.f
        public final void A3(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "uriList");
            FLogger.f375446a.i("PhotoPickerFragment", "onCameraCaptureSuccess " + r100);
            PhotoPickerFragment r101 = this.f364079a;
            int r102 = PhotoPickerFragment.f364051p0;
            r101.getClass();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r101), Dispatchers.getIO(), null, new PhotoPickerFragment$refreshMediaDataAndSelectNewItem$1(r100, r101, null), 2, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // op8.f
        public final boolean c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            Fragment r101 = this.f364079a;
        L3:
            if (r101 == 0) goto L8;
            if ((r101 instanceof lp9.c) == true) goto L6;
            r101 = r101.getParentFragment();
            goto L3
        L6:
            ((lp9.c) r101).zK();
        L8:
            Object r102 = this.f364079a.getContext();
        L9:
            if (r102 == null) goto L27;
            if ((r102 instanceof lp9.c) == true) goto L12;
            if ((r102 instanceof ContextWrapper) == false) goto L28;
            if ((r102 instanceof Activity) == true) goto L26;
            r102 = ((ContextWrapper) r102).getBaseContext();
            goto L9
        L26:
            return false;
        L28:
            return false;
        L12:
            ((lp9.c) r102).zK();
            return false;
        L27:
            return false;
        }

        @Override // op8.c, op8.f
        public final void f4(View r100) {
            Intrinsics.checkNotNullParameter(r100, "inputView");
            final PhotoPickerFragment r101 = this.f364079a;
            Function1 r102 = new x2(r101);
            FrameLayout r103 = r101.F;
            if (r103 == null) goto L6;
            r103.post(new a2(false, r101, r102));
            return;
        }

        @Override // op8.c, op8.f
        public final void h0(Uri r100) {
            FLogger.f375446a.i("PhotoPickerFragment", "onAttachmentDeleted " + r100);
            op8.g r101 = this.f364079a.Z;
            if (r101 == null) goto L5;
            r101.h0(r100);
        L5:
            this.f364079a.ha0(r100);
        }

        @Override // op8.c, op8.f
        public final void M7(View r100, final String r101) {
            Intrinsics.checkNotNullParameter(r100, "inputView");
            Intrinsics.checkNotNullParameter(r101, "addedItemUri");
            final PhotoPickerFragment r102 = this.f364079a;
            Function1 r103 = new y2(r102, r101);
            FrameLayout r104 = r102.F;
            if (r104 == null) goto L6;
            r104.post(new a2(true, r102, r103));
            return;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f364080a = null;

        static {
            int[] r100 = new int[MultiSelectStrategy.values().length];
            r100[MultiSelectStrategy.NON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MultiSelectStrategy.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f364080a = r100;
        }
    }

    public static final class d implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f364081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PhotoPickerFragment f364082b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f364081a.removeOnAttachStateChangeListener(this);
            kq9.m r101 = this.f364082b.V;
            if (r101 == null) goto L7;
            Boolean r102 = r101.f505640i;
            if (r102 == null) goto L7;
            boolean r103 = r102.booleanValue();
        L8:
            if (r103 == false) goto L11;
            com.larus.utils.i0.f375410a.getClass();
            int r104 = com.larus.utils.i0.g();
            int r105 = r100.getPaddingStart();
            int r106 = r100.getPaddingEnd();
            int r107 = r100.getPaddingBottom();
            FLogger.f375446a.i("updatePaddingRelative", "view:" + r100.getClass().getSimpleName() + ",source:,start:" + r105 + ",top:" + r104 + ",end:" + r106 + ",bottom:" + r107);
            r100.setPaddingRelative(r105, r104, r106, r107);
            return;
        L11:
            return;
        L7:
            r103 = true;
            goto L8
        }

        public d(View r100, PhotoPickerFragment r101) {
            this.f364081a = r100;
            this.f364082b = r101;
        }
    }

    public static final class e implements com.larus.platform.api.g1.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhotoPickerFragment f364083a;

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogDismiss(boolean r100) {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onGoSettingsDialogShow() {
        }

        @Override // com.larus.platform.api.g1.b
        public final void onSettingPageReturn() {
        }

        public e(PhotoPickerFragment r100) {
            this.f364083a = r100;
        }

        @Override // com.larus.platform.api.g1.c
        public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r101, "grantedList");
            Intrinsics.checkNotNullParameter(r102, "deniedList");
            if (r101.contains("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L31;
            PhotoPickerFragment r104 = this.f364083a;
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L25
            FLogger r106 = FLogger.f375446a;     // Catch: Throwable -> L25
            r106.i("PhotoPickerFragment", "READ_MEDIA_VISUAL_USER_SELECTED granted");     // Catch: Throwable -> L25
            if (r104.H != null) goto L9;
            return;
        L9:
            if (r104.L != null) goto L11;
            return;
        L11:
            r106.i("PhotoPickerFragment", "READ_MEDIA_VISUAL_USER_SELECTED granted");     // Catch: Throwable -> L25
            FrameLayout r107 = r104.H;     // Catch: Throwable -> L25
            Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L25
            Bitmap r108 = PhotoPickerFragment.W90(r107);     // Catch: Throwable -> L25
            ImageView r109 = r104.L;     // Catch: Throwable -> L25
            if (r109 == null) goto L14;
            r109.setImageBitmap(r108);     // Catch: Throwable -> L25
        L14:
            ImageView r110 = r104.L;     // Catch: Throwable -> L25
            if (r110 == null) goto L17;
            com.larus.utils.e1.x(r110);     // Catch: Throwable -> L25
        L17:
            FrameLayout r111 = r104.G;     // Catch: Throwable -> L25
            if (r111 == null) goto L20;
            r111.removeAllViews();     // Catch: Throwable -> L25
        L20:
            FrameLayout r112 = r104.E;     // Catch: Throwable -> L25
            if (r112 == null) goto L23;
            r112.removeAllViews();     // Catch: Throwable -> L25
        L23:
            r104.P = true;     // Catch: Throwable -> L25
            r104.ca0();     // Catch: Throwable -> L25
            Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
            if (r114 == null) goto L30;
            FLogger.f375446a.e("PhotoPickerFragment", "[requestPermissions] callback, " + r114);
        L30:
            Result.m9448boximpl(r113);
            return;
        L25:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L27
        L31:
            FLogger.f375446a.i("PhotoPickerFragment", "requestPermissions false");
        }
    }

    public static final class f implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f364084a;

        public f(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f364084a = r100;
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
            return this.f364084a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f364084a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "album";
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final void T90() {
        if (AppHost.f326268a.isTestChannel() == true) goto L5;
    L7:
        kq9.e r100 = lp9.d.f510246a;
        if (r100 == null) goto L10;
        String r101 = r100.f505623f;
    L12:
        if (com.larus.utils.o0.d("album") == true) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r101, "camera_slide_album_click") == false) goto L16;
        return;
    L16:
        if (Intrinsics.areEqual(r101, "chat_album_preview_click") == true) goto L60;
        kq9.e r102 = lp9.d.f510246a;
        if (r102 == null) goto L20;
        String r210 = r102.f505622e;
    L21:
        IAIChatRenderTraceService.Companion r103 = IAIChatRenderTraceService.f365896a;
        Map<String, String> r104 = r103.i();
        boolean r105 = false;
        if (r104 == null) goto L28;
        String r106 = r104.get("key_enter_method");
        if (r106 == null) goto L28;
        if (com.larus.utils.o0.d(r106) != true) goto L28;
        boolean r107 = true;
    L29:
        Map<String, String> r108 = r103.i();
        if (r108 == null) goto L32;
        String r109 = r108.get("key_has_album_pocket");
    L33:
        boolean r110 = Intrinsics.areEqual(r109, "1");
        if (r107 == false) goto L37;
        if (r110 == false) goto L37;
        r105 = true;
    L37:
        if (r105 == false) goto L41;
        Map<String, String> r111 = r103.i();
        if (r111 == null) goto L45;
        String r112 = r111.get("key_enter_method");
    L44:
        String r113 = r112;
    L46:
        kq9.e r114 = lp9.d.f510246a;
        if (r114 == null) goto L49;
        String r115 = r114.f505618a;
    L50:
        if (r114 == null) goto L52;
        String r116 = r114.f505621d;
    L53:
        if (r114 == null) goto L55;
        String r410 = r114.f505626i;
    L56:
        tx9.a1.c(r115, null, null, r116, null, null, null, null, r113, null, null, null, null, null, null, "album", r210, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r410, null, null, null, null, null, this, null, null, null, null, null, Z90(), null, -1573923, -17039361, 5);
        return;
    L55:
        r410 = null;
        goto L56
    L52:
        r116 = null;
        goto L53
    L49:
        r115 = null;
    L45:
        r113 = null;
        goto L46
    L41:
        kq9.e r117 = lp9.d.f510246a;
        if (r117 == null) goto L45;
        r112 = r117.f505623f;
        goto L44
    L32:
        r109 = null;
    L28:
        r107 = false;
        goto L29
    L20:
        r210 = null;
        goto L21
    L60:
        return;
    L10:
        r101 = null;
        goto L12
    L5:
        if ((getActivity() instanceof PhotoPickerActivity) == false) goto L7;
        t19.s.j(t19.s.f544207a, getContext(), "current use Old Album", null, false, 28);
        goto L7
    }

    public final String Z90() {
        IAIChatRenderTraceService.Companion r100 = IAIChatRenderTraceService.f365896a;
        Map<String, String> r101 = r100.i();
        boolean r102 = true;
        if (r101 == null) goto L9;
        String r103 = r101.get("key_click_from");
        if (r103 == null) goto L9;
        if (com.larus.utils.o0.d(r103) != true) goto L9;
        boolean r104 = true;
    L10:
        Map<String, String> r105 = r100.i();
        if (r105 == null) goto L13;
        String r106 = r105.get("key_has_album_pocket");
    L14:
        boolean r107 = Intrinsics.areEqual(r106, "1");
        Map<String, String> r108 = r100.i();
        if (r108 == null) goto L17;
        String r109 = r108.get("key_overview_click_form_addition");
    L18:
        boolean r110 = Intrinsics.areEqual(r109, "1");
        if (r104 == false) goto L22;
        if (r107 == false) goto L22;
    L23:
        if (r110 == false) goto L25;
        return "addition_menu";
    L25:
        if (r102 == false) goto L29;
        Map<String, String> r111 = r100.i();
        if (r111 != null) goto L35;
        return null;
    L35:
        return r111.get("key_click_from");
    L29:
        kq9.e r112 = lp9.d.f510246a;
        kq9.e r113 = lp9.d.f510246a;
        if (r113 != null) goto L32;
        return null;
    L32:
        return r113.f505623f;
    L22:
        r102 = false;
        goto L23
    L17:
        r109 = null;
        goto L18
    L13:
        r106 = null;
    L9:
        r104 = false;
        goto L10
    }

    public final BuiltInMaterialType ba0() {
        if (this.f364063n == false) goto L6;
        return BuiltInMaterialType.ALL;
    L6:
        return BuiltInMaterialType.IMAGE;
    }

    public final boolean c1() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("isInjectInput clickFrom=");
        r101.append(this.f364069t);
        r101.append(" isInjectInputConfig=");
        AlbumSettingConfig r102 = this.R;
        if (r102 == null) goto L5;
        Boolean r103 = Boolean.valueOf(r102.getEnableInjectInput());
    L6:
        r101.append(r103);
        r100.i("PhotoPickerFragment", r101.toString());
        AlbumSettingConfig r104 = this.R;
        if (r104 != null) goto L11;
        return false;
    L11:
        return r104.getEnableInjectInput();
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.larus.photopicker.impl.ui.b1] */
    /* JADX WARN: Type inference failed for: r16v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r19v0, types: [oi4.m] */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.Object, kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v40, types: [oi4.n] */
    /* JADX WARN: Type inference failed for: r1v41, types: [oi4.n] */
    /* JADX WARN: Type inference failed for: r1v43, types: [java.lang.Object, oi4.f] */
    /* JADX WARN: Type inference failed for: r1v52 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r23v0, types: [oi4.o] */
    /* JADX WARN: Type inference failed for: r2v15, types: [com.larus.photopicker.impl.ui.q0] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.larus.photopicker.impl.ui.s0] */
    /* JADX WARN: Type inference failed for: r3v13, types: [com.larus.photopicker.impl.ui.m1] */
    /* JADX WARN: Type inference failed for: r3v18, types: [com.larus.photopicker.impl.ui.u0] */
    /* JADX WARN: Type inference failed for: r3v19, types: [com.larus.photopicker.impl.ui.w0] */
    /* JADX WARN: Type inference failed for: r3v21, types: [com.larus.photopicker.impl.ui.y0] */
    /* JADX WARN: Type inference failed for: r3v22, types: [com.larus.photopicker.impl.ui.o0] */
    /* JADX WARN: Type inference failed for: r3v47, types: [oi4.m] */
    /* JADX WARN: Type inference failed for: r3v51, types: [oi4.m] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object, oi4.g] */
    /* JADX WARN: Type inference failed for: r4v8, types: [ji4.b] */
    /* JADX WARN: Type inference failed for: r6v13, types: [oi4.o] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5, types: [oi4.m] */
    public final void ca0() {
        final oi4.q r100 = new oi4.q(this);
        boolean r101 = this.f364063n;
        FLogger r102 = FLogger.f375446a;
        r102.i("DefaultMaterialRepositoryFactory", "[setSupportVideo] support:" + r101);
        r100.f523423u = r101;
        boolean r103 = this.f364062m;
        r102.i("DefaultMaterialRepositoryFactory", "[setOnlyDisplayVideo] onlyDisplayVideo:" + r103);
        r100.f523424v = r103;
        Function2<? super Long, ? super Long, Long> r104 = new n0();
        Intrinsics.checkNotNullParameter(r104, "cursorParserGetDateBlock");
        r100.f523407e = r104;
        r100.f523409g = new oi4.d();
        r100.f523410h = new oi4.h();
        boolean r110 = false;
        if (r100.f523423u == true) goto L5;
        final List r105 = CollectionsKt.listOf(ki4.l.b());
    L10:
        if (r100.f523423u == false) goto L12;
        List<? extends ki4.e0> r106 = CollectionsKt.listOf(new BuiltInMaterialType[]{BuiltInMaterialType.IMAGE, BuiltInMaterialType.VIDEO});
    L13:
        r102.i("DefaultMaterialRepositoryFactory", "[create] categoryList:" + r105 + ", sourceTypesInAllMaterial:" + r106);
        r100.f523420r = new oi4.i(r105);
        BuiltInMaterialType r111 = BuiltInMaterialType.ALL;
        List<? extends ki4.e0> r107 = CollectionsKt.listOf(r111);
        Intrinsics.checkNotNullParameter(r107, "sourceTypesInFolder");
        r100.f523413k = r107;
        r100.f523411i = r106;
        Function0<? extends ki4.o> r108 = r100.f523420r;
        if (r108 == null) goto L17;
        ki4.o r109 = r108.invoke();
        if (r109 == null) goto L17;
    L18:
        ki4.o r112 = r109;
        pi4.e r113 = r100.f523418p;
        if (r113 != null) goto L30;
        final oi4.j r114 = r100.f523403a;
        oi4.m r115 = r100.f523412j;
        final ?? r116 = r115;
        if (r115 != null) goto L23;
        ?? r117 = new oi4.m();
        r100.f523412j = r117;
        r116 = r117;
    L23:
        ?? r118 = new oi4.g(r100, r114, r116);
        ?? r119 = new oi4.f(r100);
        Function0<ki4.h0> r120 = r100.f523409g;
        if (r120 != null) goto L26;
        r120 = new oi4.p();
    L26:
        Function0<ki4.h0> r121 = r100.f523410h;
        if (r121 != null) goto L29;
        r121 = new oi4.e();
    L29:
        pi4.n r122 = new pi4.n(r100.f523416n);
        Intrinsics.checkNotNullParameter(r118, "cursorProvider");
        Intrinsics.checkNotNullParameter(r119, "cursorParserProvider");
        Intrinsics.checkNotNullParameter(r120, "imageQueryParamProvider");
        Intrinsics.checkNotNullParameter(r121, "videoQueryParamProvider");
        pi4.e r123 = new pi4.e(r118, r119, r120, r121, r122);
        r100.f523418p = r123;
        r113 = r123;
    L30:
        pi4.c r124 = r100.f523419q;
        if (r124 != null) goto L33;
        r124 = new pi4.c();
        r100.f523419q = r124;
    L33:
        qi4.d r125 = r100.f523415m;
        if (r125 != null) goto L36;
        r125 = new qi4.d();
        r100.f523415m = r125;
    L36:
        qi4.e r126 = r100.f523414l;
        if (r126 != null) goto L42;
        List<? extends ki4.e0> r127 = r100.f523413k;
        if (r127 != null) goto L41;
        r127 = CollectionsKt.listOf(new BuiltInMaterialType[]{BuiltInMaterialType.VIDEO, BuiltInMaterialType.IMAGE});
        r100.f523413k = r127;
    L41:
        Context r128 = (Context) r100.f523403a.invoke();
        Intrinsics.checkNotNullParameter(r128, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r127, "sourceTypesInFolder");
        qi4.e r129 = new qi4.e(r128, r127);
        r100.f523414l = r129;
    L43:
        oi4.o r130 = r100.f523421s;
        ?? r131 = r130;
        if (r130 != null) goto L46;
        ?? r132 = new oi4.o();
        r100.f523421s = r132;
        r131 = r132;
    L46:
        oi4.m r133 = r100.f523412j;
        ?? r134 = r133;
        if (r133 != null) goto L49;
        ?? r135 = new oi4.m();
        r100.f523412j = r135;
        r134 = r135;
    L49:
        List<? extends ki4.e0> r136 = r100.f523411i;
        if (r136 != null) goto L52;
        List<? extends ki4.e0> r137 = CollectionsKt.listOf(new BuiltInMaterialType[]{BuiltInMaterialType.VIDEO, BuiltInMaterialType.IMAGE});
        r100.f523411i = r137;
    L53:
        Map<Class<Object>, Function0<Object>> r138 = r100.f523417o;
        Intrinsics.checkNotNullParameter(r113, "materialFetcherProvider");
        Intrinsics.checkNotNullParameter(r138, "processorBuilderMap");
        Intrinsics.checkNotNullParameter(r134, "materialRangeProvider");
        Intrinsics.checkNotNullParameter(r124, "groupStrategyProvider");
        Intrinsics.checkNotNullParameter(r125, "categoryStrategy");
        Intrinsics.checkNotNullParameter(r129, "folderStrategy");
        Intrinsics.checkNotNullParameter(r131, "broadcastSourceIndexerProvider");
        Intrinsics.checkNotNullParameter(r137, "sourceTypesInAllMaterialSource");
        ni4.z r139 = new ni4.z(r113, r138, r134, r124, r125, r129, r131, r137);
        oi4.n r140 = r100.f523422t;
        ?? r141 = r140;
        if (r140 != null) goto L56;
        ?? r142 = new oi4.n();
        r100.f523422t = r142;
        r141 = r142;
    L56:
        Intrinsics.checkNotNullParameter(r139, "listIterableSource");
        Intrinsics.checkNotNullParameter(r141, "iteratorIndexerProvider");
        com.bytedance.creativex.mediaimport.repository.internal.publisher.i r143 = new com.bytedance.creativex.mediaimport.repository.internal.publisher.i(r139, r141, (DefaultMaterialRepositoryReleaser) r100.f523404b.getValue());
        oi4.n r144 = r100.f523422t;
        ?? r145 = r144;
        if (r144 != null) goto L59;
        ?? r146 = new oi4.n();
        r100.f523422t = r146;
        r145 = r146;
    L59:
        oi4.c r147 = new oi4.c(r139, r143, r112, r145, (DefaultMaterialRepositoryReleaser) r100.f523404b.getValue());
        MaterialIndexedSelectorViewModel r148 = new MaterialIndexedSelectorViewModel(this, new r0(this));
        if (this.f364067r == false) goto L67;
        kq9.m r149 = this.V;
        if (r149 == null) goto L64;
        boolean r150 = Intrinsics.areEqual(r149.f505635d, Boolean.TRUE);
    L65:
        if (r150 == true) goto L67;
        MultiSelectStrategy r151 = MultiSelectStrategy.ALL;
    L68:
        r148.updateMultiSelectStrategy(r151);
        if (((Boolean) this.Y.getValue()).booleanValue() == false) goto L71;
        r148.updateSingleSelectBehavior(ti4.j0.b.f546101c);
    L71:
        this.f364058j = r148;
        MediaSelectFolderListViewModel r152 = new MediaSelectFolderListViewModel(this, r147);
        kq9.m r153 = this.V;
        if (r153 == null) goto L76;
        Integer r154 = r153.f505641j;
        if (r154 == null) goto L76;
        int r155 = r154.intValue();
    L77:
        r152.updateImageListSize(r155);
        com.bytedance.creativex.mediaimport.view.internal.viewmodel.x r156 = new com.bytedance.creativex.mediaimport.view.internal.viewmodel.x(this, r147, new s0(), r111, r152, r148, new t0());
        this.f364057i = r156;
        Intrinsics.checkNotNull(r156);
        ti4.m<ki4.r> r157 = r156.f204159f;
        final String r158 = null;
        if (r157 == null) goto L90;
        Observable<ti4.a<ki4.r>> r159 = r157.observeSelectionConfirmed();
        final ?? r160 = new u0(this);
        Consumer<? super ti4.a<ki4.r>> r161 = new v0(r160);
        final ?? r162 = new w0();
        this.f364056h.add(r159.subscribe(r161, new x0(r162)));
        Observable<Pair<List<ki4.r>, Boolean>> r163 = r157.observeSelectionMultiConfirmed();
        final ?? r164 = new y0(this);
        Consumer<? super Pair<List<ki4.r>, Boolean>> r165 = new z0(r164);
        final ?? r166 = new o0();
        this.f364056h.add(r163.subscribe(r165, new p0(r166)));
        int r167 = this.f364070u;
        boolean r168 = this.f364063n;
        boolean r169 = this.f364064o;
        int r170 = this.f364065p;
        long r171 = this.f364066q;
        AlbumSettingConfig r172 = this.R;
        if (r172 == null) goto L82;
        CreationReferenceAlbumConfig r173 = r172.getCreationReferenceConfig();
    L83:
        kp9.k r174 = new kp9.k(r167, r168, r169, r170, r171, r173);
        this.Q = r174;
        Intrinsics.checkNotNullParameter(r157, "viewModel");
        if (r173 == null) goto L87;
        r157.addPreSelectValidator((ti4.a0) r174.f505548h.getValue());
        r157.addPostSelectValidator((ti4.z) r174.f505549i.getValue());
        r157.addConfirmValidator((ti4.b) r174.f505550j.getValue());
        goto L90
    L87:
        if (r171 <= 0) goto L89;
        r157.addPreSelectValidator((ti4.a0) r174.f505551k.getValue());
    L89:
        r157.addPreSelectValidator((ti4.a0) r174.f505552l.getValue());
        r157.addPostSelectValidator((ti4.z) r174.f505554n.getValue());
        r157.addConfirmValidator((ti4.b) r174.f505555o.getValue());
        r157.addPreSelectValidator((ti4.a0) r174.f505553m.getValue());
        goto L90
    L82:
        r173 = null;
    L90:
        int r175 = ji4.c.f499195d;
        final com.bytedance.creativex.mediaimport.view.internal.viewmodel.x r176 = this.f364057i;
        Intrinsics.checkNotNull(r176);
        Intrinsics.checkNotNullParameter(r176, "mediaSelectViewModel");
        this.f364059k = new ji4.c(r176.f204159f, new ji4.b(r176));
        com.bytedance.creativex.mediaimport.view.internal.viewmodel.x r177 = this.f364057i;
        Intrinsics.checkNotNull(r177);
        ti4.n r178 = r177.f204157d;
        if (r178 == null) goto L93;
        r178.loadMediaCategory();
    L93:
        Bundle r179 = getArguments();
        if (r179 == null) goto L109;
        String r180 = r179.getString("extra.album.selection.session.id");
        if (r180 == null) goto L109;
        if ((!StringsKt.isBlank(r180)) == false) goto L100;
        r158 = r180;
    L100:
        if (r158 == null) goto L109;
        if (this.f364067r == false) goto L109;
        this.B = MapsKt.emptyMap();
        MaterialIndexedSelectorViewModel r181 = this.f364058j;
        if (r181 == null) goto L109;
        LiveData<List<ki4.r>> r182 = r181.getSelectedMaterials();
        if (r182 == null) goto L109;
        r182.observe(getViewLifecycleOwner(), new f(new i1(this, r158)));
    L109:
        final com.bytedance.creativex.mediaimport.view.internal.main.a r183 = new com.bytedance.creativex.mediaimport.view.internal.main.a((ViewGroup) requireView().findViewById(R.id.media_root), this, this.f364057i, new a1(this));
        MaterialAndPreviewCombiner r184 = new MaterialAndPreviewCombiner(new q0(r183), new b1(this), new m1(this));
        this.D = r184;
        r184.f();
        kq9.m r185 = this.V;
        if (r185 == null) goto L152;
        Boolean r186 = r185.f505650s;
        if (r186 == null) goto L114;
        boolean r187 = r186.booleanValue();
    L115:
        Boolean r188 = r185.f505648q;
        if (r188 != null) goto L118;
    L123:
        Boolean r189 = r185.f505635d;
        if (r189 == null) goto L152;
        if (r189.booleanValue() == false) goto L130;
        this.f364067r = false;
        MaterialIndexedSelectorViewModel r190 = this.f364058j;
        if (r190 == null) goto L152;
        r190.updateMultiSelectStrategy(MultiSelectStrategy.NON);
        goto L152
    L130:
        AlbumSettingConfig r191 = this.R;
        if (r191 == null) goto L133;
        boolean r192 = r191.isMultiPick();
    L134:
        this.f364067r = r192;
        if (this.f364068s == false) goto L137;
        this.f364067r = false;
    L137:
        MaterialIndexedSelectorViewModel r193 = this.f364058j;
        if (r193 != null) goto L140;
    L144:
        MaterialIndexedSelectorViewModel r194 = this.f364058j;
        if (r194 == null) goto L152;
        if (r187 == true) goto L149;
    L151:
        r194.updateSelectMultipleBehavior(new ti4.f0(r110, 1));
        goto L152
    L149:
        if (this.f364067r == false) goto L151;
        r110 = true;
        goto L151
    L140:
        if (this.f364067r == false) goto L142;
        MultiSelectStrategy r195 = MultiSelectStrategy.ALL;
    L143:
        r193.updateMultiSelectStrategy(r195);
        goto L144
    L142:
        r195 = MultiSelectStrategy.NON;
        goto L143
    L133:
        r192 = false;
        goto L134
    L118:
        if (r188.booleanValue() == false) goto L123;
        if (r187 == false) goto L123;
        MaterialAndPreviewCombiner r196 = this.D;
        if (r196 == null) goto L123;
        r196.f203460e.f203470c = false;
        goto L123
    L114:
        r187 = false;
    L152:
        com.bytedance.creativex.mediaimport.view.internal.viewmodel.x r197 = this.f364057i;
        if (r197 == null) goto L159;
        ti4.r<ki4.r> r198 = r197.a(r111);
        if (r198 == null) goto L159;
        LiveData<List<ki4.r>> r199 = r198.getListData();
        if (r199 == null) goto L159;
        r199.observe(getViewLifecycleOwner(), new f(new c1(this)));
    L159:
        com.bytedance.creativex.mediaimport.view.internal.viewmodel.x r200 = this.f364057i;
        if (r200 == null) goto L166;
        ti4.r<ki4.r> r201 = r200.a(BuiltInMaterialType.IMAGE);
        if (r201 == null) goto L166;
        LiveData<List<ki4.r>> r202 = r201.getListData();
        if (r202 == null) goto L166;
        r202.observe(getViewLifecycleOwner(), new f(new d1(this)));
    L166:
        com.bytedance.creativex.mediaimport.view.internal.viewmodel.x r203 = this.f364057i;
        if (r203 == null) goto L174;
        ti4.r<ki4.r> r204 = r203.a(BuiltInMaterialType.VIDEO);
        if (r204 == null) goto L175;
        LiveData<List<ki4.r>> r205 = r204.getListData();
        if (r205 == null) goto L176;
        r205.observe(getViewLifecycleOwner(), new f(new e1(this)));
        return;
    L176:
        return;
    L175:
        return;
    L174:
        return;
    L76:
        r155 = -1;
        goto L77
    L64:
        r150 = false;
    L67:
        r151 = MultiSelectStrategy.NON;
        goto L68
    L52:
        r137 = r136;
        goto L53
    L42:
        r129 = r126;
    L17:
        r109 = new oi4.a(CollectionsKt.listOf(new ki4.z[]{ki4.l.a(), ki4.l.c(), ki4.l.b()}));
        goto L18
    L12:
        r106 = CollectionsKt.listOf(BuiltInMaterialType.IMAGE);
        goto L13
    L5:
        if (r100.f523424v == false) goto L7;
        r105 = CollectionsKt.listOf(ki4.l.c());
        goto L10
    L7:
        r105 = CollectionsKt.listOf(new ki4.z[]{ki4.l.a(), ki4.l.c(), ki4.l.b()});
        goto L10
    }

    public final void fa0() {
        ImageView r100 = this.L;
        if (r100 == null) goto L5;
        com.larus.utils.e1.o(r100);
    L5:
        ImageView r101 = this.L;
        if (r101 == null) goto L8;
        r101.setImageBitmap(null);
    L8:
        ImageView r102 = this.L;
        if (r102 == null) goto L11;
        r102.setAlpha(1.0f);
    L11:
        FrameLayout r103 = this.H;
        if (r103 == null) goto L15;
        r103.setAlpha(1.0f);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        AlbumSettingConfig r100 = this.R;
        if (r100 == null) goto L7;
        String r101 = r100.getAlbumNodeId();
        if (r101 == null) goto L7;
        kq9.b.b(r101);
    L7:
        super.onDestroy();
        ia0(null);
        FragmentExtKt$addOnBackPressed$callback$1 r102 = this.C;
        if (r102 == null) goto L10;
        r102.remove();
    L10:
        ((LinkedHashMap) di4.e.a().f483123a.f483125b).clear();
    }

    public PhotoPickerFragment() {
        this.f364053e = new w2(this);
        this.f364054f = new g0(this);
        this.f364055g = new h0(this);
        this.f364056h = new CompositeDisposable();
        this.f364065p = -1;
        this.f364069t = "";
        this.f364070u = -1;
        this.f364071v = 3;
        this.f364072w = true;
        this.B = MapsKt.emptyMap();
        this.S = new i0();
        this.W = LazyKt.lazy(new j0(this));
        registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new k0(this));
        this.Y = LazyKt.lazy(new l0(this));
    }

    @Override // op8.h
    public final boolean S0() {
        if (c1() == false) goto L13;
        op8.g r100 = this.Z;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.lr() != true) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    public final FragmentActivity aa0() {
        if ((getActivity() instanceof PhotoPickerActivity) == true) goto L5;
        return null;
    L5:
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f364056h.clear();
    }

    public static void U90(PhotoPickerFragment r100) {
        if (kp9.l.a() == true) goto L19;
        ImageView r101 = r100.L;
        boolean r102 = false;
        if (r101 != null) goto L7;
    L12:
        if (r102 == false) goto L15;
        return;
    L15:
        if (Build.VERSION.SDK_INT < 34) goto L17;
        r100.requestPermissions(CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED"}));
        r100.ea0("add_chosen_pic");
        FLogger.f375446a.i("PhotoPickerFragment", "request beyond UPSIDE_DOWN_CAKE");
        return;
    L17:
        FLogger.f375446a.i("PhotoPickerFragment", "request under UPSIDE_DOWN_CAKE");
        return;
    L7:
        if (r101.getVisibility() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L12;
        r102 = true;
        goto L12
    L9:
        r103 = false;
        goto L10
    }

    public static Bitmap W90(View r100) {
        Bitmap r101 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), Bitmap.Config.ARGB_8888);
        r100.draw(new Canvas(r101));
        return r101;
    }

    private final void requestPermissions(List<String> r100) {
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L6;
        com.larus.platform.service.i2 r102 = com.larus.platform.service.i2.f365748b;
        com.larus.platform.api.g1.a.c(this, r101, r100, new e(this));
        return;
    }

    public final void Y90(List<? extends ki4.r> r100) {
        FrameLayout r101 = this.H;
        if (r101 == null) goto L5;
        TextView r102 = (TextView) r101.findViewById(R.id.btn_switch_multi_mode);
    L6:
        if (r102 == null) goto L14;
        if (r100 != null) goto L9;
    L12:
        com.larus.utils.e1.o(r102);
        return;
    L9:
        if (r100.size() < 2) goto L12;
        r102.getVisibility();
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    public final void ea0(String r110) {
        kq9.e r100 = lp9.d.f510246a;
        IAIChatRenderTraceService.Companion r101 = IAIChatRenderTraceService.f365896a;
        Map<String, String> r102 = r101.i();
        ?? r103 = 0;
        if (r102 == null) goto L9;
        String r104 = r102.get("key_current_page");
        if (r104 == null) goto L9;
        boolean r105 = true;
        if (com.larus.utils.o0.d(r104) != true) goto L9;
    L10:
        String r106 = null;
        if (r105 == false) goto L16;
        Map<String, String> r107 = r101.i();
        if (r107 == null) goto L15;
        String r108 = r107.get("key_current_page");
    L17:
        String r111 = r108;
    L18:
        tx9.d2 r109 = tx9.d2.f547848a;
        if (r100 == null) goto L21;
        String r112 = r100.f505618a;
    L22:
        if (r100 == null) goto L24;
        String r113 = r100.f505621d;
    L25:
        String r114 = Z90();
        if (r100 == null) goto L28;
        r106 = r100.f505622e;
    L28:
        String r115 = r106;
        if (this.f364067r == false) goto L31;
        String r116 = "1";
    L32:
        String r117 = r116;
        if (r100 == null) goto L35;
        r103 = Intrinsics.areEqual(r100.f505627j, Boolean.TRUE);
    L35:
        tx9.d2.b(r109, r112, r113, r114, r110, r111, r115, r117, Integer.valueOf(r103));
        return;
    L31:
        r116 = "0";
        goto L32
    L24:
        r113 = null;
        goto L25
    L21:
        r112 = null;
        goto L22
    L15:
        r111 = null;
        goto L18
    L16:
        r108 = "album";
    L9:
        r105 = false;
        goto L10
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.trace.tracknode.a.C4500a.a(this, r100);
        r100.put("if_support_multi", Integer.valueOf(this.f364067r ? 1 : 0));
    }

    public final void ga0(List<? extends ki4.r> r110) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("onMediaDataChanged dataList=");
        Integer r102 = null;
        if (r110 == null) goto L5;
        Integer r103 = Integer.valueOf(r110.size());
    L6:
        r101.append(r103);
        r101.append(", loadFromRequestPermissions:");
        r101.append(this.P);
        r100.i("PhotoPickerFragment", r101.toString());
        if (this.P == false) goto L35;
        this.P = false;
        if (r110 == null) goto L11;
        Integer r104 = Integer.valueOf(r110.size());
    L12:
        List<? extends ki4.r> r105 = this.O;
        if (r105 == null) goto L16;
        r102 = Integer.valueOf(r105.size());
    L16:
        if (Intrinsics.areEqual(r104, r102) == false) goto L25;
        if (r110 != null) goto L19;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == false) goto L25;
        boolean r107 = false;
    L26:
        if (r107 == false) goto L29;
        this.O = r110;
    L29:
        if (r107 == false) goto L31;
        FrameLayout r108 = this.H;
        Intrinsics.checkNotNull(r108);
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r108, "alpha", new float[]{0.0f, 1.0f});
        ImageView r111 = this.L;
        Intrinsics.checkNotNull(r111);
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r111, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet r113 = new AnimatorSet();
        r113.playTogether(new Animator[]{r109, r112});
        r113.addListener(new a3(this));
        r113.setDuration(300);
        r113.start();
        jp9.g.f500005a.a();
    L34:
        Y90(r110);
        goto L35
    L31:
        ImageView r114 = this.L;
        if (r114 == null) goto L34;
        r114.postDelayed(new b2(this), 300);
        goto L34
    L19:
        if (r110.equals(this.O) != true) goto L21;
        r106 = true;
    L25:
        r107 = true;
        goto L26
    L11:
        r104 = null;
    L35:
        Y90(r110);
        this.O = r110;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void ha0(Uri r100) {
        FLogger r101 = FLogger.f375446a;
        r101.d("PhotoPickerFragment", "[removeSelectedItemByUri] Start uri: " + r100);
        if (r100 != null) goto L5;
        return;
    L5:
        MaterialAndPreviewCombiner r102 = this.D;
        if (r102 == null) goto L10;
        si4.a r103 = r102.c();
        if (r103 == null) goto L10;
        ti4.j<ki4.r> r104 = r103.e();
    L11:
        if (r104 != null) goto L13;
        r101.w("PhotoPickerFragment", "[removeSelectedItemByUri] SelectionListView is not available");
    L19:
        if (this.f364067r == true) goto L24;
        MaterialIndexedSelectorViewModel r105 = this.f364058j;
        if (r105 == null) goto L25;
        r105.cancel(r100);
        return;
    L25:
        return;
    L24:
        return;
    L13:
        if (r104.c(r100) == false) goto L15;
        String r106 = "success";
    L16:
        r101.i("PhotoPickerFragment", "[removeSelectedItemByUri] Remove ".concat(r106));
        goto L19
    L15:
        r106 = "failure";
    L10:
        r104 = null;
        goto L11
    }

    public final void ia0(kq9.m r100) {
        op8.g r101 = this.Z;
        if (r101 == null) goto L8;
        if (r100 == null) goto L6;
        boolean r102 = Intrinsics.areEqual(r100.f505649r, Boolean.TRUE);
    L7:
        r101.O9(r102);
        goto L8
    L6:
        r102 = false;
    L8:
        this.V = r100;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        di4.e.f468739b = new u2();
        di4.e.a().c((di4.e.b) di4.e.f468740c.getValue());
        Bundle r101 = getArguments();
        AlbumSettingConfig r102 = null;
        if (r101 == null) goto L5;
        Serializable r103 = r101.getSerializable("extra.album.config");
    L7:
        if ((r103 instanceof AlbumSettingConfig) == false) goto L9;
        r102 = (AlbumSettingConfig) r103;
    L9:
        this.R = r102;
        if (r102 == null) goto L14;
        String r104 = r102.getAlbumNodeId();
        if (r104 == null) goto L14;
        kq9.b.a(r104);
    L14:
        AlbumSettingConfig r105 = this.R;
        if (r105 == null) goto L24;
        this.f364062m = r105.getOnlyDisplayVideo();
        this.f364063n = r105.getSupportVideo();
        this.f364064o = r105.getEnableSeparateMediaSelection();
        this.f364065p = r105.getMaxSelectVideoCount();
        this.f364067r = r105.isMultiPick();
        this.f364070u = r105.getMaxSelectCount();
        Long r106 = r105.getMaxVideoDuration();
        if (r106 == null) goto L19;
        long r107 = r106.longValue();
    L20:
        this.f364066q = r107;
        String r108 = r105.getClickFrom();
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        this.f364069t = r108;
        goto L24
    L19:
        r107 = 0;
    L24:
        boolean r109 = true;
        if (((Boolean) this.Y.getValue()).booleanValue() == false) goto L27;
    L28:
        this.f364070u = 1;
    L29:
        AlbumSettingConfig r110 = this.R;
        int r111 = 0;
        if (r110 == null) goto L32;
        boolean r112 = r110.isUseSingleDefault();
    L33:
        if (r112 == true) goto L35;
    L37:
        r109 = false;
    L38:
        this.f364068s = r109;
        AlbumSettingConfig r113 = this.R;
        if (r113 == null) goto L41;
        int r114 = r113.getSpanCount();
    L42:
        this.f364071v = r114;
        if (this.f364068s == false) goto L45;
        this.f364067r = false;
    L45:
        AlbumSettingConfig r115 = this.R;
        if (r115 == null) goto L48;
        boolean r116 = r115.getSupportOriginalImage();
    L49:
        this.f364075z = r116;
        AlbumSettingConfig r117 = this.R;
        if (r117 == null) goto L54;
        Integer r118 = r117.getLandingTabIndex();
        if (r118 == null) goto L54;
        r111 = r118.intValue();
    L54:
        this.f364073x = r111;
        FLogger.f375446a.i("PhotoPickerFragment", "[onCreate] isMultiSelect:" + this.f364067r + ", maxSelectCount:" + this.f364070u + ", isUseSingleDefault:" + this.f364068s + ", albumSpanCount:" + this.f364071v);
        this.C = com.larus.utils.v.a(this, new v2(this));
        return;
    L48:
        r116 = false;
        goto L49
    L41:
        r114 = 3;
        goto L42
    L35:
        if (this.f364067r == false) goto L37;
    L32:
        r112 = false;
        goto L33
    L27:
        if (this.f364070u != 0) goto L29;
    L5:
        r103 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final MediaItemInternal V90(PhotoPickerFragment r410, String r411) {
        r410.getClass();
        Object r100 = "[queryPhotoInfoFromSystemGallery] Found media: ";
        Uri r101 = UriProtector.parse(r411);     // Catch: Exception -> L100
        boolean r102 = r101.getPathSegments().contains("video");     // Catch: Exception -> L100
        List r103 = CollectionsKt.mutableListOf(new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "_size", "width", "height", "mime_type", "bucket_display_name", "bucket_id"});     // Catch: Exception -> L100
        if (r102 == false) goto L7;
        r103.add("duration");     // Catch: Exception -> L100
    L7:
        boolean r104 = false;
        String[] r105 = (String[]) r103.toArray(new String[0]);     // Catch: Exception -> L100
        if (Intrinsics.areEqual(r101.getScheme(), "content") == false) goto L95;
        Context r106 = r410.getContext();     // Catch: Exception -> L100
        if (r106 == null) goto L95;
        ContentResolver r107 = r106.getContentResolver();     // Catch: Exception -> L100
        if (r107 == null) goto L95;
        Cursor r108 = X90(r107, r101, r105);     // Catch: Exception -> L100
        if (r108 == null) goto L95;
        Cursor r109 = r108;     // Catch: Exception -> L100
        Cursor r110 = r109;     // Catch: Throwable -> L88
        if (r110.moveToFirst() == false) goto L84;
        int r111 = r110.getColumnIndex(DBDefinition.ID);     // Catch: Throwable -> L88
        int r112 = r110.getColumnIndex("_display_name");     // Catch: Throwable -> L88
        int r113 = r110.getColumnIndex("date_modified");     // Catch: Throwable -> L88
        int r114 = r110.getColumnIndex("_size");     // Catch: Throwable -> L88
        int r115 = r110.getColumnIndex("width");     // Catch: Throwable -> L88
        int r116 = r110.getColumnIndex("height");     // Catch: Throwable -> L88
        int r117 = r110.getColumnIndex("mime_type");     // Catch: Throwable -> L88
        int r118 = r110.getColumnIndex("duration");     // Catch: Throwable -> L88
        int r119 = r110.getColumnIndex("bucket_display_name");     // Catch: Throwable -> L88
        int r120 = r110.getColumnIndex("bucket_id");     // Catch: Throwable -> L88
        long r121 = 0;
        if (r111 >= 0) goto L21;
        long r210 = 0;
    L24:
        if (r112 < 0) goto L27;
        String r122 = r110.getString(r112);     // Catch: Throwable -> L88
        if (r122 == null) goto L27;
    L28:
        if (r113 < 0) goto L32;
        long r123 = r110.getLong(r113);     // Catch: Throwable -> L88
        Cursor r412 = r109;
    L30:
        long r211 = r123;
        if (r114 >= 0) goto L105;
        long r310 = 0;
    L40:
        if (r115 < 0) goto L42;
        int r311 = r110.getInt(r115);     // Catch: Throwable -> L37
    L43:
        if (r116 < 0) goto L45;
        int r312 = r110.getInt(r116);     // Catch: Throwable -> L37
    L46:
        if (r117 < 0) goto L49;
        String r124 = r110.getString(r117);     // Catch: Throwable -> L37
    L50:
        if (r118 < 0) goto L52;
        r121 = r110.getLong(r118);     // Catch: Throwable -> L37
    L52:
        long r313 = r121;
        if (r119 < 0) goto L56;
        String r125 = r110.getString(r119);     // Catch: Throwable -> L37
        if (r125 == null) goto L56;
    L57:
        String r314 = r125;
        if (r120 < 0) goto L63;
        String r126 = r110.getString(r120);     // Catch: Throwable -> L37
        if (r126 == null) goto L63;
        String r315 = r126;
    L64:
        if (r124 != null) goto L66;
    L68:
        if (r104 == false) goto L72;
        MediaType r127 = MediaType.VIDEO;     // Catch: Throwable -> L37
    L73:
        MediaType r212 = r127;
        Uri r128 = ContentUris.withAppendedId(r212.getContentUri(), r210);     // Catch: Throwable -> L82
        FLogger.f375446a.i("PhotoPickerFragment", "[queryPhotoInfoFromSystemGallery] Found media: " + r122 + ", uri: " + r128);     // Catch: Throwable -> L82
        Intrinsics.checkNotNull(r124);     // Catch: Throwable -> L82
        BuiltInMaterialType r213 = r410.ba0();     // Catch: Throwable -> L82
        long r214 = ContentUris.parseId(r128);     // Catch: Throwable -> L82
        if (ri4.b.b() == false) goto L76;
        String r215 = "";
    L77:
        r100 = new MediaItemInternal(r213, r212, r211, r214, r215, r311, r312, r310, r313, r315, r314, r124, r122, null, 0, r128);     // Catch: Throwable -> L82
        CloseableKt.closeFinally(r412, null);     // Catch: Exception -> L100
    L104:
        return r100;
    L82:
        th = th;
        r109 = r412;
    L89:
        r100 = null;
        Throwable r129 = th;
    L107:
        throw r129;     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        CloseableKt.closeFinally(r109, r129);     // Catch: Exception -> L98
        throw th;     // Catch: Exception -> L98
    L76:
        r215 = r411;
    L37:
        th = move-exception;
        r129 = th;
        r109 = r412;
        r100 = null;
        goto L107
    L72:
        r127 = MediaType.IMAGE;     // Catch: Throwable -> L82
        goto L73
    L66:
        if (StringsKt.startsWith$default(r124, "video/", false, 2, null) != true) goto L68;
        r104 = true;
    L63:
        r315 = r314;
    L56:
        r125 = "Camera";
        goto L57
    L49:
        r124 = "image/jpeg";
        goto L50
    L45:
        r312 = 0;
        goto L46
    L42:
        r311 = 0;
        goto L43
    L105:
        r310 = r110.getLong(r114);     // Catch: Throwable -> L37
        goto L40
    L32:
        r412 = r109;
        r123 = System.currentTimeMillis() / ((long) 1000);     // Catch: Throwable -> L82
    L27:
        r122 = "";
        goto L28
    L21:
        r210 = r110.getLong(r111);     // Catch: Throwable -> L88
        goto L24
    L84:
        Unit r130 = Unit.INSTANCE;     // Catch: Throwable -> L88
        r100 = null;
        CloseableKt.closeFinally(r109, null);     // Catch: Exception -> L98
    L96:
        FLogger.f375446a.w("PhotoPickerFragment", "[queryPhotoInfoFromSystemGallery] Photo not found in system gallery: ".concat(r411));     // Catch: Exception -> L98
    L88:
        th = th;
    L95:
        r100 = null;
    L98:
        e = e;
    L102:
        FLogger.f375446a.e("PhotoPickerFragment", "[queryPhotoInfoFromSystemGallery] Error querying photo info", e);
    L100:
        e = e;
        r100 = null;
        goto L102
    }

    public final void da0(String r110, String r111) {
        kq9.e r100 = lp9.d.f510246a;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.f505623f;
    L6:
        Map<String, String> r103 = IAIChatRenderTraceService.f365896a.i();
        String r104 = "album";
        if (r103 == null) goto L34;
        String r105 = r103.get("key_current_page");
        if (r105 != null) goto L11;
    L16:
        String r106 = r103.get("key_click_from");
        if (r106 != null) goto L19;
    L24:
        String r107 = r103.get("spring_guide_card_id");
        if (r107 != null) goto L27;
    L32:
        r107 = null;
    L33:
        String r108 = r102;
        String r112 = r107;
    L35:
        String r109 = r104;
        tx9.d2 r113 = tx9.d2.f547848a;
        if (r100 == null) goto L38;
        r101 = r100.f505618a;
    L38:
        tx9.d2.a(r113, r109, r108, r101, r110, r111, r112);
        this.f364072w = false;
        return;
    L27:
        if (com.larus.utils.o0.d(r107) == true) goto L30;
        r107 = null;
    L30:
        if (r107 == null) goto L32;
    L19:
        if (com.larus.utils.o0.d(r106) == true) goto L22;
        r106 = null;
    L22:
        if (r106 == null) goto L24;
        r102 = r106;
        goto L24
    L11:
        if (com.larus.utils.o0.d(r105) == true) goto L14;
        r105 = null;
    L14:
        if (r105 == null) goto L16;
        r104 = r105;
        goto L16
    L34:
        r112 = null;
        r108 = r102;
        goto L35
    L5:
        r102 = null;
        goto L6
    }

    public final void ja0(ki4.r r100, boolean r101) {
        com.bytedance.creativex.mediaimport.view.internal.viewmodel.x r102 = this.f364057i;
        RecyclerView.LayoutManager r103 = null;
        if (r102 == null) goto L5;
        ti4.r<ki4.r> r104 = r102.a(ba0());
    L6:
        if (r104 == null) goto L38;
        int r105 = r104.getDataPosition(r100);
        if (r105 < 0) goto L36;
        FLogger r106 = FLogger.f375446a;
        r106.i("PhotoPickerFragment", "[simulateItemSelection] Simulating selection for item at position: " + r105);
        if (r101 == false) goto L20;
        FrameLayout r107 = this.E;
        if (r107 == null) goto L14;
        RecyclerView r108 = (RecyclerView) r107.findViewById(R.id.media_list);
    L15:
        if (r108 == null) goto L18;
        r103 = r108.getLayoutManager();
    L18:
        if ((r103 instanceof LinearLayoutManager) == false) goto L20;
        ((LinearLayoutManager) r103).scrollToPositionWithOffset(r105, 0);
        goto L20
    L14:
        r108 = null;
    L20:
        MaterialIndexedSelectorViewModel r109 = this.f364058j;
        if (r109 == null) goto L24;
        MaterialSelectedState r110 = r109.getSelectState(r100);
        if (r110 == null) goto L24;
    L26:
        if (r110.isSelected() == false) goto L28;
        r106.i("PhotoPickerFragment", "[simulateItemSelection] Item already selected, no action needed");
        return;
    L28:
        MaterialAndPreviewCombiner r111 = this.D;
        if (r111 == null) goto L33;
        si4.a r112 = r111.c();
        if (r112 == null) goto L33;
        r112.b(r100, r105, r110, ba0());
    L33:
        MaterialIndexedSelectorViewModel r113 = this.f364058j;
        if (r113 == null) goto L40;
        r113.changeSelectState(r100, r113.getSelectState(r100));
        return;
    L40:
        return;
    L24:
        r110 = MaterialSelectedState.NON_SELECTED;
        goto L26
    L36:
        FLogger.f375446a.w("PhotoPickerFragment", "[simulateItemSelection] Item position not found: " + r100.getPath());
        return;
    L38:
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v20, types: [androidx.fragment.app.Fragment] */
    /* JADX WARN: Type inference failed for: r13v15, types: [androidx.fragment.app.FragmentTransaction, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v16, types: [androidx.fragment.app.FragmentTransaction] */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        FLogger r112 = FLogger.f375446a;
        r112.i("PhotoPickerFragment", "onViewCreated PhotoPickerFragment=" + hashCode());
        tx9.d2 r100 = tx9.d2.f547848a;
        boolean r101 = getParentFragment() instanceof BottomPhotoPickerFragment;
        JSONObject r102 = lp9.d.a();
        r100.getClass();
        boolean r103 = false;
        tx9.d2.d(false, r101, false, r102);
        this.E = (FrameLayout) r110.findViewById(R.id.media_root);
        this.F = (FrameLayout) r110.findViewById(R.id.container_input);
        this.G = (FrameLayout) r110.findViewById(R.id.preview_root);
        this.L = (ImageView) r110.findViewById(R.id.iv_screenshot_animation);
        this.H = (FrameLayout) r110.findViewById(R.id.container_root);
        this.I = (FrameLayout) r110.findViewById(R.id.container_page_root);
        this.f364052J = (InjectInputContainer) r110.findViewById(R.id.container_input);
        this.K = r110.findViewById(R.id.input_view_touch_outside);
        if (c1() == false) goto L82;
        InjectInputContainer r113 = this.f364052J;
        if (r113 == null) goto L12;
        ObricChatUIDelegate r104 = ObricChatUIDelegate.f392858b;
        if (r104.m() == false) goto L10;
        PhotoPickerFragment$setupInjectInputSafeBottom$1 r105 = new PhotoPickerFragment$setupInjectInputSafeBottom$1(r104);
    L11:
        r113.setSafeBottomResolver(r105);
        goto L12
    L10:
        r105 = null;
    L12:
        kq9.e r114 = lp9.d.f510246a;
        String r106 = "";
        if (r114 == null) goto L16;
        String r107 = r114.f505618a;
        if (r107 == null) goto L16;
    L18:
        if (r114 == null) goto L21;
        String r108 = r114.f505623f;
        if (r108 == null) goto L21;
    L22:
        if (r114 == null) goto L25;
        String r115 = r114.f505619b;
        if (r115 == null) goto L25;
    L26:
        AlbumSettingConfig r109 = this.R;
        if (r109 == null) goto L29;
        String r116 = r109.getSuggestedActionProvider();
    L30:
        r112.d("PhotoPickerFragment", "setupInjectInputFragment botId:" + r107 + ", conversationId:" + r115 + ", injectInputScene:inject_input_photo_picker");
        op8.i r117 = (op8.i) this.W.getValue();
        if (r117 == null) goto L75;
        Boolean r118 = Boolean.TRUE;
        LinkedHashMap r119 = new LinkedHashMap();
        r119.put("conversation_id", r115);
        r119.put("click_from", r108);
        r119.put("current_page", "album");
        r119.put("enter_method", "album");
        r119.put("bot_id", r107);
        if (r116 == null) goto L35;
        String r120 = r119.put("suggested_action_provider", r116);
    L35:
        AlbumSettingConfig r121 = this.R;
        if (r121 == null) goto L45;
        AlbumInputState r122 = r121.getInitialInputState();
        if (r122 == null) goto L45;
        r119.put("inject_input_initial_text", r122.getText());
        String r123 = r122.getInputSnapshotId();
        if (r123 == null) goto L43;
        String r124 = r119.put("inject_input_initial_attachment_snapshot_id", r123);
    L43:
        if ((!r122.getAttachmentUris().isEmpty()) == false) goto L45;
        r119.put("inject_input_initial_attachment_uris", new JSONArray(r122.getAttachmentUris()).toString());
    L45:
        AlbumSettingConfig r125 = this.R;
        if (r125 == null) goto L55;
        r119.put("inject_input_album_node_id", r125.getAlbumNodeId());
        String r126 = r125.getUpstreamAlbumNodeId();
        if (kq9.b.c(r126) == true) goto L51;
        r126 = null;
    L51:
        if (r126 == null) goto L54;
        r106 = r126;
    L54:
        String r127 = r119.put("inject_input_upstream_album_node_id", r106);
    L55:
        AlbumSettingConfig r128 = this.R;
        if (r128 != null) goto L58;
    L60:
        r119.put("inject_input_hide_album_entrance", String.valueOf(r103));
        Unit r129 = Unit.INSTANCE;
        final ?? r130 = r117.b(r118, "inject_input_photo_picker", r119);
        if (r130 == 0) goto L75;
        if (isAdded() == false) goto L69;
        ?? r131 = getChildFragmentManager().beginTransaction();
        boolean r132 = LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r131, r130, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.container_input);
        ?? r133 = r131;
        if (r132 == true) goto L68;
        r133 = r131.add(R.id.container_input, r130);
    L68:
        r133.commitAllowingStateLoss();
    L71:
        if ((r130 instanceof op8.g) == false) goto L75;
        op8.g r134 = (op8.g) r130;
        this.Z = r134;
        kq9.m r135 = this.V;
        if (r135 == null) goto L75;
        r134.O9(Intrinsics.areEqual(r135.f505649r, r118));
        goto L75
    L69:
        getViewLifecycleOwner().getLifecycle().addObserver(new PhotoPickerFragment$addFragmentSafely$1(this, r130));
        goto L71
    L58:
        if (r128.getHideAlbumEntranceInInjectedInput() != true) goto L60;
        r103 = true;
    L75:
        InjectInputContainer r136 = this.f364052J;
        if (r136 == null) goto L78;
        Function0<Unit> r137 = new x1(this);
        Intrinsics.checkNotNullParameter(r137, "block");
        r136.f328472b = r137;
    L78:
        InjectInputContainer r138 = this.f364052J;
        if (r138 == null) goto L81;
        Function0<Unit> r139 = new i2(this);
        Intrinsics.checkNotNullParameter(r139, "block");
        r138.f328473c = r139;
    L81:
        com.larus.utils.e1.d(this.K, new t2(this));
        goto L82
    L29:
        r116 = null;
    L25:
        r115 = "";
    L21:
        r108 = "album";
    L16:
        r107 = "";
    L82:
        ca0();
    }

    public static Cursor X90(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = getLayoutInflater().inflate(R.layout.larus_fragment_photo_picker, r101, false);
        View r104 = r103.findViewById(R.id.media_root);
        if (r104.isAttachedToWindow() == false) goto L12;
        kq9.m r105 = this.V;
        if (r105 == null) goto L9;
        Boolean r106 = r105.f505640i;
        if (r106 == null) goto L9;
        boolean r107 = r106.booleanValue();
    L10:
        if (r107 == false) goto L13;
        com.larus.utils.i0.f375410a.getClass();
        int r108 = com.larus.utils.i0.g();
        int r109 = r104.getPaddingStart();
        int r110 = r104.getPaddingEnd();
        int r111 = r104.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r104.getClass().getSimpleName() + ",source:,start:" + r109 + ",top:" + r108 + ",end:" + r110 + ",bottom:" + r111);
        r104.setPaddingRelative(r109, r108, r110, r111);
    L13:
        return r103;
    L9:
        r107 = true;
        goto L10
    L12:
        r104.addOnAttachStateChangeListener(new d(r104, this));
        goto L13
    }
}
