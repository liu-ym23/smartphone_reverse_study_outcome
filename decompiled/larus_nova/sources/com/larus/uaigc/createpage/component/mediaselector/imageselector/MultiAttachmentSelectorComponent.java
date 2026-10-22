package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.MimeTypeMap;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.android.ttcjpaysdk.facelive.utils.CJPayUploadVideoUtil;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.CreationReferenceMediaType;
import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.VideoUploadInfo;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourcePhase;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ExpiredInfo;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.nova.R;
import com.larus.platform.AlbumHelper;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.creation.CreationMultiReferenceLogEvent;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.album.AlbumSelectItem;
import com.larus.platform.model.album.AlbumSelectionMediaType;
import com.larus.platform.model.album.AlbumSettingConfig;
import com.larus.platform.model.album.CreationReferenceAlbumAttachment;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import com.larus.platform.model.album.CreationReferenceAlbumMediaRule;
import com.larus.platform.model.album.CreationReferenceAlbumMediaType;
import com.larus.platform.model.album.CreationReferenceAlbumMixedRule;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentSource;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentState;
import com.larus.uaigc.bean.createpage.component.mediacontainer.CreationReferenceAttachmentType;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.uaigc.createpage.utils.CreationRemoteConversationHelper;
import com.larus.uaigc.helper.CreationResourceAccessPerfBridgeKt;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000Ô\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u0088\u00032\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0088\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\\\u001a\u00020/2\u0006\u0010J\u001a\u00020/2\b\u0010]\u001a\u0004\u0018\u00010/H\u0002J\u0012\u0010^\u001a\u00020E2\b\u0010_\u001a\u0004\u0018\u00010/H\u0016J\u0012\u0010`\u001a\u00020,2\b\u0010_\u001a\u0004\u0018\u00010/H\u0002J\t\u0010\u008a\u0001\u001a\u00020EH\u0016J\n\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\u001e\u0010\u008d\u0001\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020/\u0012\u0005\u0012\u00030\u008e\u000102\u0018\u00010dH\u0016J\u0012\u0010\u008f\u0001\u001a\u00020E2\u0007\u0010\u0090\u0001\u001a\u00020,H\u0016J\u0014\u0010\u0091\u0001\u001a\u00020E2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010/H\u0016JA\u0010\u0093\u0001\u001a\u00020E2\u0006\u0010l\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020,2\u0007\u0010\u0095\u0001\u001a\u00020m2\u0007\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u0097\u0001\u001a\u00020m2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0016JA\u0010\u009a\u0001\u001a\u00020E2\u0006\u0010l\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020,2\u0007\u0010\u0095\u0001\u001a\u00020m2\u0007\u0010\u0096\u0001\u001a\u00020,2\u0007\u0010\u0097\u0001\u001a\u00020m2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0002J\f\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0002J\t\u0010\u009d\u0001\u001a\u00020,H\u0002J\t\u0010\u009e\u0001\u001a\u00020EH\u0002J\t\u0010\u009f\u0001\u001a\u00020EH\u0002J%\u0010 \u0001\u001a\u00020E2\t\u0010¡\u0001\u001a\u0004\u0018\u00010/2\u0006\u0010p\u001a\u00020m2\u0007\u0010\u0094\u0001\u001a\u00020,H\u0016J+\u0010¢\u0001\u001a\u00020E2\b\u0010x\u001a\u0004\u0018\u00010/2\u0007\u0010\u0094\u0001\u001a\u00020,2\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020E0wH\u0016J\u0011\u0010¤\u0001\u001a\u00020E2\u0006\u0010l\u001a\u00020mH\u0016J\u0012\u0010¥\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0016J\t\u0010§\u0001\u001a\u00020EH\u0016J\t\u0010¨\u0001\u001a\u00020mH\u0002J\"\u0010©\u0001\u001a\u0004\u0018\u00010{2\n\u0010ª\u0001\u001a\u0005\u0018\u00010\u0099\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010/H\u0002J\u000f\u0010¬\u0001\u001a\u00030\u00ad\u0001*\u00030®\u0001H\u0002J\u0011\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001*\u00030±\u0001H\u0002J\t\u0010²\u0001\u001a\u00020EH\u0002J\u0013\u0010³\u0001\u001a\u00020E2\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u0012\u0010¶\u0001\u001a\u00020E2\u0007\u0010·\u0001\u001a\u00020AH\u0002J\u0013\u0010¸\u0001\u001a\u00020A2\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u0019\u0010¹\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0096@¢\u0006\u0003\u0010º\u0001J\u0012\u0010»\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0002J\u0012\u0010¼\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0002J.\u0010½\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;2\b\u0010¾\u0001\u001a\u00030¿\u00012\t\b\u0002\u0010À\u0001\u001a\u00020,H\u0082@¢\u0006\u0003\u0010Á\u0001J\u001a\u0010Â\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/H\u0002J\u0019\u0010Ä\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;H\u0082@¢\u0006\u0003\u0010º\u0001J%\u0010Å\u0001\u001a\u00030Æ\u00012\u0006\u0010J\u001a\u00020/2\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010¦\u0001\u001a\u00020;H\u0002J+\u0010É\u0001\u001a\u00020E2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\u0007\u0010¦\u0001\u001a\u00020;2\u0006\u0010J\u001a\u00020/H\u0082@¢\u0006\u0003\u0010Ì\u0001J8\u0010Í\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010¦\u0001\u001a\u00020;2\u0007\u0010Î\u0001\u001a\u00020/2\u0013\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/02H\u0002J*\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\u0007\u0010¦\u0001\u001a\u00020;2\u0013\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/02H\u0002J,\u0010Ò\u0001\u001a\u00020E2\u0007\u0010¦\u0001\u001a\u00020;2\b\u0010Ó\u0001\u001a\u00030Ô\u00012\u0007\u0010Î\u0001\u001a\u00020/H\u0082@¢\u0006\u0003\u0010Õ\u0001J%\u0010Ö\u0001\u001a\u00030×\u00012\u0006\u0010J\u001a\u00020/2\b\u0010Ç\u0001\u001a\u00030È\u00012\u0007\u0010¦\u0001\u001a\u00020;H\u0002J\u0012\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001*\u0004\u0018\u00010/H\u0002J\u0010\u0010Ú\u0001\u001a\u00020,*\u0005\u0018\u00010Ù\u0001H\u0002J#\u0010Û\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ü\u0001\u001a\u00020>2\u0007\u0010Ý\u0001\u001a\u00020,H\u0016J(\u0010Þ\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\f\b\u0002\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H\u0002J&\u0010á\u0001\u001a\u0005\u0018\u00010Ë\u00012\b\u0010â\u0001\u001a\u00030ã\u00012\u0007\u0010\u0092\u0001\u001a\u00020/H\u0082@¢\u0006\u0003\u0010ä\u0001J\u0015\u0010å\u0001\u001a\u0005\u0018\u00010æ\u00012\u0007\u0010Ã\u0001\u001a\u00020/H\u0002J\u0019\u0010ç\u0001\u001a\u00020E2\u0007\u0010·\u0001\u001a\u00020AH\u0082@¢\u0006\u0003\u0010è\u0001J\u001b\u0010é\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\b\u0010ê\u0001\u001a\u00030ë\u0001H\u0002J\u001a\u0010ì\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010í\u0001\u001a\u00020/H\u0002J\u0011\u0010î\u0001\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0002J\u0011\u0010ï\u0001\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002J\u0011\u0010ð\u0001\u001a\u00020,2\u0006\u0010J\u001a\u00020/H\u0002J\u0012\u0010ñ\u0001\u001a\u00020,2\u0007\u0010ò\u0001\u001a\u00020/H\u0002J(\u0010ó\u0001\u001a\u00020E2\u0007\u0010ô\u0001\u001a\u00020,2\t\u0010õ\u0001\u001a\u0004\u0018\u00010/2\t\b\u0002\u0010ö\u0001\u001a\u00020/H\u0002J\f\u0010÷\u0001\u001a\u0005\u0018\u00010ø\u0001H\u0002J\u000b\u0010ù\u0001\u001a\u0004\u0018\u00010/H\u0002J\t\u0010ú\u0001\u001a\u00020,H\u0002J-\u0010û\u0001\u001a\u00020E2\u0007\u0010ü\u0001\u001a\u00020/2\b\u0010ê\u0001\u001a\u00030ý\u00012\u0007\u0010Ã\u0001\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002J\u0014\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u00012\u0006\u0010J\u001a\u00020/H\u0002J6\u0010\u0080\u0002\u001a\u00020E2\u0007\u0010ü\u0001\u001a\u00020/2\b\u0010ê\u0001\u001a\u00030ý\u00012\u0007\u0010Ã\u0001\u001a\u00020/2\u0006\u0010J\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/H\u0002J\u000b\u0010\u0082\u0002\u001a\u0004\u0018\u00010/H\u0016J\t\u0010\u0083\u0002\u001a\u00020/H\u0002J\t\u0010\u0084\u0002\u001a\u00020/H\u0002JR\u0010\u0085\u0002\u001a\u00030×\u00012\u0007\u0010ü\u0001\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\u0007\u0010\u0086\u0002\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\u0016\u0010\u0087\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u0002H\u0002J@\u0010\u0089\u0002\u001a\u00030\u008a\u00022\u0007\u0010ü\u0001\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\u0016\u0010\u0087\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u0002H\u0002J!\u0010\u008b\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u00022\u0007\u0010Ã\u0001\u001a\u00020/H\u0002J\u0011\u0010\u008c\u0002\u001a\u00030\u008d\u0002H\u0082@¢\u0006\u0003\u0010\u008e\u0002J\t\u0010\u008f\u0002\u001a\u00020/H\u0002J\t\u0010\u0090\u0002\u001a\u00020/H\u0002J\u001c\u0010\u0091\u0002\u001a\u00030\u0092\u00022\u0007\u0010\u0081\u0002\u001a\u00020/2\u0007\u0010\u0086\u0002\u001a\u00020/H\u0002J\u0011\u0010\u0093\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0002J\u001b\u0010\u0094\u0002\u001a\u00020E2\b\u0010Ó\u0001\u001a\u00030Ô\u00012\u0006\u0010J\u001a\u00020/H\u0002J¶\u0001\u0010\u0095\u0002\u001a\u00020E2\u0007\u0010Ã\u0001\u001a\u00020/2\u0006\u0010J\u001a\u00020/2\u0007\u0010ü\u0001\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\f\b\u0002\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\u0018\b\u0002\u0010\u0087\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u00022\t\b\u0002\u0010\u0096\u0002\u001a\u00020/2\f\b\u0002\u0010\u0097\u0002\u001a\u0005\u0018\u00010Ë\u00012\u0014\u0010\u0098\u0002\u001a\u000f\u0012\u0005\u0012\u00030Ô\u0001\u0012\u0004\u0012\u00020E0@2\u0014\u0010\u0099\u0002\u001a\u000f\u0012\u0005\u0012\u00030ý\u0001\u0012\u0004\u0012\u00020E0@2\u0014\u0010\u009a\u0002\u001a\u000f\u0012\u0005\u0012\u00030ë\u0001\u0012\u0004\u0012\u00020E0@H\u0082@¢\u0006\u0003\u0010\u009b\u0002JP\u0010\u009c\u0002\u001a\u00030Ë\u00012\u0007\u0010Ã\u0001\u001a\u00020/2\u0007\u0010ü\u0001\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\u0016\u0010\u0087\u0002\u001a\u0011\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020m\u0018\u00010\u0088\u0002H\u0082@¢\u0006\u0003\u0010\u009d\u0002J\u001f\u0010\u009e\u0002\u001a\u00030\u009f\u00022\u0007\u0010Ã\u0001\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H\u0002J\u001a\u0010 \u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Î\u0001\u001a\u00020/H\u0002Jm\u0010¡\u0002\u001a\u00020E2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\u0006\u0010J\u001a\u00020/2\u0007\u0010\u0096\u0002\u001a\u00020/2\u0014\u0010\u0098\u0002\u001a\u000f\u0012\u0005\u0012\u00030Ô\u0001\u0012\u0004\u0012\u00020E0@2\u0014\u0010\u0099\u0002\u001a\u000f\u0012\u0005\u0012\u00030ý\u0001\u0012\u0004\u0012\u00020E0@2\u0014\u0010\u009a\u0002\u001a\u000f\u0012\u0005\u0012\u00030ë\u0001\u0012\u0004\u0012\u00020E0@H\u0082@¢\u0006\u0003\u0010¢\u0002J\u0013\u0010£\u0002\u001a\u00020A2\b\u0010¤\u0002\u001a\u00030µ\u0001H\u0002J\u0013\u0010¥\u0002\u001a\u00020E2\b\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\u001b\u0010¦\u0002\u001a\u00030¿\u00012\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0082@¢\u0006\u0003\u0010§\u0002J\t\u0010¨\u0002\u001a\u00020EH\u0016J\t\u0010©\u0002\u001a\u00020EH\u0016J\t\u0010ª\u0002\u001a\u00020EH\u0016J\t\u0010«\u0002\u001a\u00020EH\u0016J\u001c\u0010¬\u0002\u001a\u00020E2\u0007\u0010\u00ad\u0002\u001a\u00020m2\b\u0010®\u0002\u001a\u00030¯\u0002H\u0002J\u001a\u0010°\u0002\u001a\t\u0012\u0004\u0012\u00020;0±\u00022\b\u0010®\u0002\u001a\u00030¯\u0002H\u0002J%\u0010²\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\t\u0010³\u0002\u001a\u0004\u0018\u00010/H\u0016J\u001a\u0010´\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/H\u0016J\u0011\u0010µ\u0002\u001a\u00020,2\u0006\u0010J\u001a\u00020/H\u0002J\u0011\u0010¶\u0002\u001a\u00020,2\u0006\u0010J\u001a\u00020/H\u0002J\u0012\u0010®\u0002\u001a\u00030¯\u00022\u0006\u0010J\u001a\u00020/H\u0002J\u001a\u0010·\u0002\u001a\u00030¸\u00022\u000e\u0010¹\u0002\u001a\t\u0012\u0004\u0012\u00020;0±\u0002H\u0016J#\u0010º\u0002\u001a\u00020E2\u000f\u0010»\u0002\u001a\n\u0012\u0005\u0012\u00030\u008a\u00020¼\u00022\u0007\u0010½\u0002\u001a\u00020;H\u0002J\u0012\u0010¾\u0002\u001a\u00020E2\u0007\u0010¿\u0002\u001a\u00020/H\u0002J\u000f\u0010À\u0002\u001a\u00030Á\u0002*\u00030\u0099\u0001H\u0002J\u001a\u0010Â\u0002\u001a\u00030\u0099\u00012\u000e\u0010¹\u0002\u001a\t\u0012\u0004\u0012\u00020;0±\u0002H\u0016J\u000e\u0010Ã\u0002\u001a\u00030Ä\u0002*\u00020;H\u0002J\u000e\u0010Å\u0002\u001a\u00030Æ\u0002*\u00020;H\u0002J\u000f\u0010Ç\u0002\u001a\u00030È\u0002*\u00030É\u0002H\u0002J\u000f\u0010Ç\u0002\u001a\u00030È\u0002*\u00030Ê\u0002H\u0002J\u001a\u0010Ë\u0002\u001a\u00030¸\u00022\u000e\u0010¹\u0002\u001a\t\u0012\u0004\u0012\u00020;0±\u0002H\u0002J\u000e\u0010Ì\u0002\u001a\u00020,*\u00030¯\u0002H\u0002J-\u0010Í\u0002\u001a\u00020E2\u000f\u0010»\u0002\u001a\n\u0012\u0005\u0012\u00030\u008a\u00020¼\u00022\b\u0010Î\u0002\u001a\u00030É\u00022\u0007\u0010½\u0002\u001a\u00020;H\u0002J-\u0010Ï\u0002\u001a\u00020E2\u000f\u0010»\u0002\u001a\n\u0012\u0005\u0012\u00030\u008a\u00020¼\u00022\b\u0010Î\u0002\u001a\u00030É\u00022\u0007\u0010½\u0002\u001a\u00020;H\u0002J\u001b\u0010Ð\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000201020dH\u0016J\u0013\u0010Ñ\u0002\u001a\u0004\u0018\u0001012\u0006\u0010J\u001a\u00020/H\u0016J\u0012\u0010Ò\u0002\u001a\u00020E2\u0007\u0010Ó\u0002\u001a\u00020bH\u0016J\t\u0010Ô\u0002\u001a\u00020,H\u0002Jf\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u00022\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\n\b\u0002\u0010Ú\u0002\u001a\u00030Û\u00022\n\b\u0002\u0010Ü\u0002\u001a\u00030Û\u00022\t\b\u0002\u0010Ý\u0002\u001a\u00020,H\u0002JR\u0010Þ\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010/H\u0016JR\u0010à\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010/H\u0002J\u001e\u0010á\u0002\u001a\u00030â\u00022\u0007\u0010×\u0002\u001a\u00020/2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010/H\u0002J\u001c\u0010ã\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\t\u0010Î\u0001\u001a\u0004\u0018\u00010/H\u0002J2\u0010ä\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\n\u0010å\u0002\u001a\u0005\u0018\u00010â\u00022\u0013\u0010Ï\u0001\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/02H\u0002Ja\u0010æ\u0002\u001a\u00020E2\b\u0010Ê\u0001\u001a\u00030Ë\u00012\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,H\u0082@¢\u0006\u0003\u0010ç\u0002J\u000e\u0010è\u0002\u001a\u00020,*\u00030é\u0002H\u0002JZ\u0010ê\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\u0007\u0010\u0081\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,2\b\u0010ë\u0002\u001a\u00030ì\u0002H\u0002J5\u0010í\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010ò\u0001\u001a\u00020/2\u0007\u0010î\u0002\u001a\u00020/2\u0007\u0010Ý\u0001\u001a\u00020,2\u0007\u0010ß\u0002\u001a\u00020,H\u0002J\t\u0010ï\u0002\u001a\u00020,H\u0016J\t\u0010ð\u0002\u001a\u00020,H\u0016J\u0010\u0010ñ\u0002\u001a\t\u0012\u0004\u0012\u00020>0±\u0002H\u0016J\t\u0010ò\u0002\u001a\u00020,H\u0016J\\\u0010ó\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010×\u0002\u001a\u00020/2\b\u0010ô\u0002\u001a\u00030õ\u00022\u0007\u0010\u0092\u0001\u001a\u00020/2\u0007\u0010Ø\u0002\u001a\u00020/2\u0007\u0010Ù\u0002\u001a\u00020/2\t\b\u0002\u0010Ý\u0001\u001a\u00020,2\t\b\u0002\u0010ß\u0002\u001a\u00020,H\u0082@¢\u0006\u0003\u0010ö\u0002J8\u0010÷\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\b\u0010ô\u0002\u001a\u00030õ\u00022\t\b\u0002\u0010Ý\u0001\u001a\u00020,2\t\b\u0002\u0010ß\u0002\u001a\u00020,H\u0082@¢\u0006\u0003\u0010ø\u0002J.\u0010ù\u0002\u001a\u00020E2#\u0010ú\u0002\u001a\u001e\u0012\u0014\u0012\u00120A¢\u0006\r\bB\u0012\t\bC\u0012\u0005\b\b(¤\u0002\u0012\u0004\u0012\u00020E0@H\u0016J-\u0010û\u0002\u001a\u00020E2\"\u0010£\u0001\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020E0@H\u0016J-\u0010ü\u0002\u001a\u00020E2\"\u0010£\u0001\u001a\u001d\u0012\u0013\u0012\u00110/¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020E0@H\u0016J\u001d\u0010ý\u0002\u001a\u00020E2\t\u0010×\u0002\u001a\u0004\u0018\u00010/2\u0007\u0010ß\u0002\u001a\u00020,H\u0016J\u000b\u0010þ\u0002\u001a\u0004\u0018\u00010/H\u0016J\u0011\u0010ÿ\u0002\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0016J&\u0010\u0080\u0003\u001a\u00020E2\u0006\u0010J\u001a\u00020/2\u0007\u0010Ã\u0001\u001a\u00020/2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u0001H\u0016J\u0019\u0010\u0081\u0003\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\u0006\u0010J\u001a\u00020/H\u0002J\u0017\u0010\u0082\u0003\u001a\b\u0012\u0004\u0012\u000201002\u0006\u0010J\u001a\u00020/H\u0002J\u0011\u0010\u0083\u0003\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0002J!\u0010\u0084\u0003\u001a\u00020E2\u0007\u0010\u0085\u0003\u001a\u00020/2\r\u0010\u0086\u0003\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u0011\u0010\u0087\u0003\u001a\u00020E2\u0006\u0010J\u001a\u00020/H\u0002R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000Rf\u0010-\u001aZ\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \b*\n\u0012\u0004\u0012\u000201\u0018\u00010000 \b*,\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \b*\n\u0012\u0004\u0012\u000201\u0018\u00010000\u0018\u0001020.X\u0082\u0004¢\u0006\u0002\n\u0000R \u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002010204X\u0082\u0004¢\u0006\u0002\n\u0000Rf\u00105\u001aZ\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \b*\n\u0012\u0004\u0012\u000201\u0018\u00010000 \b*,\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000201 \b*\n\u0012\u0004\u0012\u000201\u0018\u00010000\u0018\u0001020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/07X\u0082\u0004¢\u0006\u0002\n\u0000RN\u00108\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\f\u0012\n \b*\u0004\u0018\u00010,0, \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\f\u0012\n \b*\u0004\u0018\u00010,0,\u0018\u00010909X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020;07X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020/07X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020>07X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010?\u001a%\u0012\u0013\u0012\u00110A¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020E\u0018\u00010@j\u0004\u0018\u0001`FX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010G\u001a\u001f\u0012\u0013\u0012\u00110;¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u00020E\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010I\u001a\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020E\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020L07X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020,07X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010N\u001aB\u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\f\u0012\n \b*\u0004\u0018\u00010,0, \b* \u0012\f\u0012\n \b*\u0004\u0018\u00010/0/\u0012\f\u0012\n \b*\u0004\u0018\u00010,0,\u0018\u00010909X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010T\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\bW\u0010X*\u0004\bU\u0010VR\u0010\u0010Y\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010a\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010b0b00X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020b0d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u001c\u0010g\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010h0h00X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020h0d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010fR\u000e\u0010k\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010q\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\f\u001a\u0004\bs\u0010tR\u0016\u0010v\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010}\u001a\u0004\u0018\u00010~8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0081\u0001\u001a\u00030\u0082\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R&\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u0002010\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0089\u0001\u0010\f\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001¨\u0006\u0089\u0003"}, d2 = {"Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/MultiAttachmentSelectorComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/IMultiAttachmentSelectorAbility;", "Lcom/larus/bmhome/instruction/kmp/IInstructionAttachmentHostAbility;", "<init>", "()V", "videoReferenceNoticeKeva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getVideoReferenceNoticeKeva", "()Lcom/bytedance/keva/Keva;", "videoReferenceNoticeKeva$delegate", "Lkotlin/Lazy;", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "getHitPointData", "()Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "hitPointData$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "instructionEditAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getInstructionEditAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "instructionEditAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "creationInputAbility", "Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "getCreationInputAbility", "()Lcom/larus/uaigc/bean/createpage/component/input/CreationIInputAbility;", "creationInputAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "disableReUpload", "", "attachmentLiveDataCacheMap", "", "", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MultiMediaSelectorStatus;", "", "allAttachmentLiveDataStatus", "Landroidx/lifecycle/MediatorLiveData;", "attachmentLiveDataRegisterMap", "attachmentIdentityRegisterMap", "Ljava/util/concurrent/ConcurrentHashMap;", "handoffUploadIdentifierSet", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "attachmentResourceItemBeanMap", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "instantUploadInfoJsonMap", "pipelineOriginalAttachmentMap", "Lcom/larus/bmhome/actionbar/model/MediaAttachment;", "onAlbumResultListener", "Lkotlin/Function1;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/AlbumResourceConfig;", "Lkotlin/ParameterName;", "name", "config", "", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/OnAlbumResultListener;", "onUploadAvatarImageCallback", "resourceItemBean", "onDeleteAvatarImageCallback", "resourceKey", "imageUploadJobRegistry", "Lkotlinx/coroutines/Job;", "uploadPerfStartedResourceKeyMap", "videoPreprocessFailedResourceKeys", "takePictureHelper", "Lcom/larus/bmhome/chat/picture/LocalTakePictureImpl;", "albumPipelinePrewarmerDelegate", "Lkotlin/Lazy;", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/CreationAlbumPipelinePrewarmer;", "albumPipelinePrewarmer", "getAlbumPipelinePrewarmer$delegate", "(Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/MultiAttachmentSelectorComponent;)Ljava/lang/Object;", "getAlbumPipelinePrewarmer", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/CreationAlbumPipelinePrewarmer;", "curLocalMessageId", "albumPrewarmSessionStarted", "albumPrewarmGeneratedLocalMessageId", "resolveAttachmentIdentifier", "fallbackIdentifier", "markUploadHandoffToSend", "fileIdentifier", "shouldKeepUploadForSend", "_passedImageUrlListLiveData", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/PassedImageUrlListData;", "passedImageUrlListLiveData", "Landroidx/lifecycle/LiveData;", "getPassedImageUrlListLiveData", "()Landroidx/lifecycle/LiveData;", "_updateUIStatus", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationUpdateUIStatus;", "updateUIStatus", "getUpdateUIStatus", "enableAlbumMultiSelect", "maxSelectCount", "", "currentReplaceIndex", "albumPrompt", "configInstructionType", "frescoCloseableHolder", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "getFrescoCloseableHolder", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "frescoCloseableHolder$delegate", "openAlbumCallback", "Lkotlin/Function0;", "clickFrom", "currentUploadedAvatarResourceKey", "activeCreationReferenceAlbumConfig", "Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "activeCreationReferenceReplaceKey", "currentSelectedVideoModelExtInfo", "Lcom/larus/bmhome/actionbar/model/VideoModelExtInfo;", "getCurrentSelectedVideoModelExtInfo", "()Lcom/larus/bmhome/actionbar/model/VideoModelExtInfo;", "currentCreationReferenceCapabilityState", "Lcom/larus/bmhome/actionbar/model/CreationReferenceCapabilityState;", "getCurrentCreationReferenceCapabilityState", "()Lcom/larus/bmhome/actionbar/model/CreationReferenceCapabilityState;", "creationUploadAndCheckObserver", "Landroidx/lifecycle/Observer;", "getCreationUploadAndCheckObserver", "()Landroidx/lifecycle/Observer;", "creationUploadAndCheckObserver$delegate", "onAttach", "getInstructionAttachmentProvider", "Lcom/larus/bmhome/instruction/core/platform/IInstructionAttachmentProvider;", "getInstructionAttachmentStatusLiveData", "", "openInstructionAlbum", "isReplace", "removeInstructionAttachment", LocationMonitorConst.IDENTIFIER, "openAlbum", "forceSingleSelect", "replaceIndex", "enableSeparateMediaSelection", "maxSelectVideoCount", "creationReferenceAttachmentSnapshot", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSnapshot;", "openAlbumInternal", "buildAlbumPrewarmLaunchExtras", "Landroid/os/Bundle;", "isAlbumSelectionPrewarmEnabled", "cancelAlbumSelectionPrewarm", "finishAlbumSelectionPrewarm", "openAlbumWithPrompt", EventConstant.Key.RETAIN_PROMPT, "handleAlbumOpenFromActionMenu", "callback", "setMaxAlbumSelectCount", "addResourceItemBean", "bean", WidgetCostModule.TYPE_ON_CREATE, "getRemainSelectCount", "buildCreationReferenceAlbumConfig", "snapshot", "replaceResourceKey", "toAlbumMediaType", "Lcom/larus/platform/model/album/CreationReferenceAlbumMediaType;", "Lcom/larus/bmhome/actionbar/model/CreationReferenceMediaType;", "toAlbumAttachment", "Lcom/larus/platform/model/album/CreationReferenceAlbumAttachment;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachment;", "initTakePictureHelper", "handleAlbumMultiSelectionForVideoUpload", "multiSelectItem", "Lcom/larus/platform/AlbumMultiSelectItem;", "showVideoReferenceQuotaNoticeIfNeeded", "resourceConfig", "buildResourceConfigForVideoUpload", "uploadResourceItemBean", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compressAndUploadImage", "preCheckAndUploadVideo", "toastVideoCheckFailed", "processResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "retainForRetry", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Lcom/larus/bmhome/chat/bean/ProcessFileResult;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadVideo", "localResPath", "startVideoResourceAccess", "buildVideoResourceAccessRequest", "Lcom/larus/uaigc/service/ResourceAccessSubmitRequest;", "uri", "Landroid/net/Uri;", "observeVideoResourceAccessTask", "task", "Lcom/larus/bmhome/resource/access/ResourceAccessTask;", "(Lcom/larus/bmhome/resource/access/ResourceAccessTask;Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVideoPreprocessReady", "localPath", "attributes", "buildPreprocessedVideoCover", "Lcom/larus/im/bean/message/Image;", "handleVideoResourceAccessFail", "error", "Lcom/larus/platform/model/upload/ResourceUploadError;", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;Lcom/larus/platform/model/upload/ResourceUploadError;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildVideoResourceCenterUploadParam", "Lcom/larus/platform/model/upload/ResourceCenterUploadParam;", "toProcessFileResultCode", "Lcom/larus/bmhome/chat/bean/ProcessFileResultCode;", "isVideoPreprocessError", "triggerVideoDownloadAndExplain", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "isPrivate", "parseUriAndStartUpload", "fileInfo", "Lcom/larus/bmhome/chat/bean/ProcessFileInfo;", "submitAlbumSelectionPrewarm", MapController.ITEM_LAYER_TAG, "Lcom/larus/platform/model/album/AlbumSelectionEventItem;", "(Lcom/larus/platform/model/album/AlbumSelectionEventItem;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveReadableLocalFile", "Ljava/io/File;", "onCompressUploadAndCheck", "(Lcom/larus/uaigc/bean/createpage/component/mediacontainer/AlbumResourceConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUploadProcess", "result", "Lcom/larus/platform/model/upload/ResourceUploadProgressResult;", "startUploadPerfIfNeeded", "parentScene", "clearUploadPerfStarted", "resolveUploadPerfParentScene", "shouldReportUploadPerfManually", "isPreprocessErrorCode", "errorCode", "mobUploadAttachmentStatus", "success", "errorMsg", "messageType", "getSlidesMobConfig", "Lcom/larus/platform/model/slides/SlidesMobConfig;", "getCurrentPageName", "isHalfInstructionFragment", "handleUploadVideoSuccess", "uploaderIdentifier", "Lcom/larus/platform/model/upload/ResourceUploadResult;", "getVideoUploadCoverInfoByResourceKey", "Lcom/larus/bmhome/actionbar/model/VideoUploadCoverInfo;", "handleUploadSuccess", "localMessageId", "getCurrentNestedFileLocalMessageId", "getOrCreateLocalMessageId", "getOrCreateAlbumPrewarmLocalMessageId", "buildResourceCenterUploadParam", "conversationId", "imageSize", "Lkotlin/Pair;", "buildImageUploadEntity", "Lcom/larus/im/bean/message/UplinkFileEntity;", "resolveImageSize", "resolveConversationBeforeUpload", "Lcom/larus/uaigc/createpage/utils/CreationRemoteConversationHelper$ResolveResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveResourceConversationId", "resolveResourceBotId", "buildResourceAttachmentExtra", "Lcom/larus/platform/model/upload/ResourceAttachmentExtra;", "requireSelectedImageUrlInBackground", "handleUploadFail", "submitImageResourceAccess", "perfParentScene", "reusableTask", "onFailed", "onSuccess", "processCallback", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ProcessFileInfo;Lkotlin/Pair;Ljava/lang/String;Lcom/larus/bmhome/resource/access/ResourceAccessTask;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitImageResourceAccessTask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ProcessFileInfo;Lkotlin/Pair;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildLocalImageResourceInput", "Lcom/larus/bmhome/resource/access/ResourceInput$LocalPath;", "updateImagePreprocessedLocalPath", "observeImageResourceAccessTask", "(Lcom/larus/bmhome/resource/access/ResourceAccessTask;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildResourceConfig", "multiConfig", "handleFailToast", "compressAlbumImg", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", LiveCommonConstants.REASON_ON_DEDTROY, "cancelResourceAccessForPageLeave", "updateResourceBarUI", "deleteAttachmentsIfNeeds", "deleteExceedMediaAttachments", "count", "resourceType", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceType;", "getCurrentMediaAttachmentList", "", "handleAttachmentRemove", "fromScene", "handleAttachmentRetry", "retryRemoteImage", "isResourceTypeVideo", "getCurrentNestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "resourceItemOrder", "addRemoteAudioEntityToList", "entities", "", "resourceItem", "logAttachmentChanged", "source", "toCreationMultiReferenceLogSummary", "Lcom/larus/platform/creation/CreationMultiReferenceLogSummary;", "getCreationReferenceAttachmentSnapshot", "toCreationReferenceAttachmentType", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentType;", "toCreationReferenceAttachmentSource", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentSource;", "toCreationReferenceAttachmentState", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/CreationReferenceAttachmentState;", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MediaSelectorStatus;", "Lcom/larus/bmhome/view/resourcebar/bean/ItemStatus;", "getPipelineNestedFileContent", "isSnapshotMedia", "addVideoEntityToList", "status", "addImageEntityToList", "getAllAttachmentLiveDataStatus", "getMultiMediaSelectorStatus", "clearAndSetPassedImageUrlList", "passedImageUrlListData", "isPrefilledImage", "createPrefilledImageFilledStatus", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/MediaSelectorStatus$Filled;", "url", "resourceId", "localFilePath", "bitmapWidth", "", "bitmapHeight", "allowRemoteUrlOnly", "triggerDownloadUrlAndExplain", "isAvatar", "submitRemoteImageResourceAccess", "buildRemoteResourceInput", "Lcom/larus/bmhome/resource/access/ResourceInput;", "rememberImageLocalPathForRetry", "rememberResourceInputLocalPathForRetry", "resourceInput", "observeRemoteResourceAccessTask", "(Lcom/larus/bmhome/resource/access/ResourceAccessTask;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldShowRemoteUploading", "Lcom/larus/bmhome/resource/access/ResourceAccessState$Running;", "handleRemoteResourceAccessSuccess", "state", "Lcom/larus/bmhome/resource/access/ResourceAccessState$Ready;", "handleRemoteResourceAccessFail", "errorMessage", "isParsingAttachment", "hasVideoAttachment", "getCurrentAttachments", "isParsingVideoAttachment", "explainResourceUrl", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reUploadImageOfPassedUrl", "(Ljava/lang/String;Landroid/graphics/Bitmap;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerOnAlbumResultListener", "onResult", "registerOnUploadAvatarImage", "registerOnDeleteAvatarImage", "triggerUploadAvatarImage", "getCurrentUploadedAvatarResourceKey", "triggerDeleteAvatarImage", "triggerUploadAndCheck", "getAttachmentLiveData", "getOrCreateAttachmentLiveData", "removeCreateAttachmentLiveData", "registerAttachmentLiveData", "key", "liveData", "unRegisterAttachmentLiveData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiAttachmentSelectorComponent extends Component implements ry9.h, com.larus.bmhome.instruction.kmp.a {
    public static final /* synthetic */ int Z = 0;
    public final ConcurrentHashMap<String, MediaAttachment> A;
    public Function1<? super ry9.a, Unit> B;
    public Function1<? super ResourceItemBean, Unit> C;
    public Function1<? super String, Unit> D;
    public final ConcurrentHashMap<String, Job> E;
    public final ConcurrentHashMap<String, Boolean> F;
    public final ConcurrentHashMap.KeySetView<String, Boolean> G;
    public final LocalTakePictureImpl H;
    public final Lazy<CreationAlbumPipelinePrewarmer> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f371961J;
    public boolean K;
    public String L;
    public final MutableLiveData<ry9.l> M;
    public final MutableLiveData<ry9.f> N;
    public final boolean O;
    public int P;
    public int Q;
    public String R;
    public int S;
    public final Lazy T;
    public Function0<Unit> U;
    public String V;
    public String W;
    public CreationReferenceAlbumConfig X;
    public final Lazy Y;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f371962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f371963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f371964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f371965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f371966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f371967q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f371968r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f371969s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, MutableLiveData<ry9.k>> f371970t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final MediatorLiveData<Map<String, ry9.k>> f371971u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, MutableLiveData<ry9.k>> f371972v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f371973w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView<String, Boolean> f371974x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ConcurrentHashMap<String, ResourceItemBean> f371975y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f371976z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371977a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f371978b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f371979c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f371980d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f371981e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f371982f = null;

        static {
            int[] r100 = new int[CreationReferenceMediaType.values().length];
            r100[CreationReferenceMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L81:
            r100[CreationReferenceMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L91:
            r100[CreationReferenceMediaType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L8:
            f371977a = r100;
            int[] r101 = new int[CreationReferenceAttachmentType.values().length];
            r101[CreationReferenceAttachmentType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L37
        L85:
            r101[CreationReferenceAttachmentType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L38
        L95:
            r101[CreationReferenceAttachmentType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L39
        L55:
            r101[CreationReferenceAttachmentType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L40
        L14:
            f371978b = r101;
            int[] r102 = new int[ResourcePhase.values().length];
            r102[ResourcePhase.PREPROCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L87:
            r102[ResourcePhase.UPLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L17:
            f371979c = r102;
            int[] r103 = new int[ProcessFileResultCode.values().length];
            r103[ProcessFileResultCode.PREPARE_OVER_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L75:
            r103[ProcessFileResultCode.PREPARE_TYPE_NO_MATCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L20:
            f371980d = r103;
            int[] r104 = new int[ResourceType.values().length];
            r104[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L45
        L63:
            r104[ResourceType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L46
        L77:
            r104[ResourceType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L47
        L24:
            f371981e = r104;
            int[] r105 = new int[ItemStatus.values().length];
            r105[ItemStatus.UPLINKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L48
        L79:
            r105[ItemStatus.UPLINK_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L49
        L89:
            r105[ItemStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L50
        L59:
            r105[ItemStatus.UPLINK_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L51
        L69:
            r105[ItemStatus.PARSE_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L52
        L83:
            r105[ItemStatus.INSPECT_FAILED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L53
        L93:
            r105[ItemStatus.EXPIRED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L54
        L32:
            f371982f = r105;
        }
    }

    static {
    }

    public static boolean G4() {
        if (com.larus.platform.service.k2.f365755a.x() == false) goto L9;
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L9;
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.c().a(), Boolean.TRUE) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // ry9.h
    public final List<MediaAttachment> DX() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = MapsKt.toList(this.f371972v).iterator();
    L4:
        if (r101.hasNext() == false) goto L34;
        String r102 = (String) ((Pair) r101.next()).component1();
        if (Intrinsics.areEqual(r102, this.W) == true) goto L4;
        Intrinsics.checkNotNull(r102);
        ry9.k r103 = Q00(r102);
        if (r103 == null) goto L4;
        ry9.j r104 = r103.f539945b;
        ry9.i r105 = r104.a();
        if ((r104 instanceof ry9.j.c) == false) goto L4;
        if (r105 == null) goto L4;
        boolean r106 = r105 instanceof ry9.i.a;
        if (r106 == true) goto L17;
        if ((r105 instanceof ry9.i.b) == false) goto L4;
    L17:
        MediaAttachment r107 = null;
        if (r106 == false) goto L20;
        ry9.i.a r108 = (ry9.i.a) r105;
    L21:
        if (r108 == null) goto L27;
        MediaAttachment r109 = r108.f539932a;
        if (r109 == null) goto L27;
        r107 = r109;
    L32:
        if (r107 == null) goto L4;
        r100.add(r107);
    L27:
        if ((r105 instanceof ry9.i.b) == false) goto L29;
        ry9.i.b r110 = (ry9.i.b) r105;
    L30:
        if (r110 == null) goto L32;
        r107 = r110.f539934a;
        goto L32
    L29:
        r110 = null;
        goto L30
    L20:
        r108 = null;
        goto L21
    L34:
        return r100;
    }

    @Override // ry9.h
    public final void N6() {
        if (this.I.isInitialized() == false) goto L25;
        CreationAlbumPipelinePrewarmer r100 = V3();
        Object r101 = r100.f371905c;
        monitor-enter(r101);
        String r102 = r100.f371906d;     // Catch: Throwable -> L22
        r100.f371906d = null;     // Catch: Throwable -> L22
        List r103 = CollectionsKt.distinct(CollectionsKt.plus(((LinkedHashMap) r100.f371907e).values(), ((LinkedHashMap) r100.f371908f).values()));     // Catch: Throwable -> L22
        ((LinkedHashMap) r100.f371907e).clear();     // Catch: Throwable -> L22
        ((LinkedHashMap) r100.f371908f).clear();     // Catch: Throwable -> L22
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r101);
        if (r102 == null) goto L12;
        ConcurrentHashMap<String, Function2<kq9.d, Boolean, Unit>> r105 = kq9.c.f505615a;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        if ((!StringsKt.isBlank(r102)) == false) goto L12;
        kq9.c.f505615a.remove(r102);
    L12:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r103.iterator();
    L14:
        if (r107.hasNext() == false) goto L21;
        Object r108 = r107.next();
        if (((CreationAlbumPipelinePrewarmer.b) r108).f371915e != CreationAlbumPipelinePrewarmer.TaskOwner.SEND) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == true) goto L14;
        r106.add(r108);
        goto L14
    L18:
        r109 = false;
        goto L19
    L21:
        r100.b(r106, ResourceCancelReason.PAGE_DESTROY);
    L22:
        th = move-exception;
        throw th;
    L25:
        this.K = false;
        this.L = null;
        List r110 = CollectionsKt.toList(this.E.keySet());
        Iterator<Map.Entry<String, Job>> r111 = this.E.entrySet().iterator();
    L27:
        if (r111.hasNext() == false) goto L44;
        Map.Entry<String, Job> r112 = r111.next();
        String r113 = r112.getKey();
        Job r114 = r112.getValue();
        String r115 = this.f371973w.get(r113);
        if (r115 != null) goto L31;
    L40:
        boolean r116 = false;
    L41:
        if (r116 == false) goto L43;
        FLogger.f375446a.i("MultiAttachmentSelector", "cancelResourceAccessForPageLeave keep resource access task for send, resourceKey=" + r113 + ", identifier=" + r115);
    L43:
        Job.DefaultImpls.cancel$default(r114, null, 1, null);
        goto L27
    L31:
        if (r115.length() <= 0) goto L33;
        boolean r117 = true;
    L34:
        if (r117 == false) goto L36;
        String r118 = r115;
    L37:
        if (r118 == null) goto L40;
        r116 = this.f371974x.contains(r118);
        goto L41
    L36:
        r118 = null;
        goto L37
    L33:
        r117 = false;
        goto L34
    L44:
        this.E.clear();
        Iterator<Map.Entry<String, String>> r119 = this.f371973w.entrySet().iterator();
    L46:
        if (r119.hasNext() == false) goto L73;
        Map.Entry<String, String> r120 = r119.next();
        String r121 = r120.getKey();
        String r122 = r120.getValue();
        if (r122 != null) goto L50;
    L59:
        boolean r123 = false;
    L60:
        if (r123 == true) goto L61;
        ICreationResourceAccessService.Companion r124 = ICreationResourceAccessService.f373925a;
        com.larus.bmhome.resource.access.z r125 = ICreationResourceAccessService.a.c(r124, r122, null, null, 14);
        if (r125 == null) goto L69;
        com.larus.bmhome.resource.access.a0 r126 = r125.f313784c;
        if (r126 == null) goto L69;
        if (com.larus.bmhome.resource.access.s.b(r126) != true) goto L69;
        boolean r127 = true;
    L70:
        if (r127 == true) goto L46;
        boolean r128 = r124.a(r122, ResourceCancelReason.PAGE_DESTROY);
        FLogger.f375446a.i("MultiAttachmentSelector", "cancelResourceAccessForPageLeave cancel resource access task, resourceKey=" + r121 + ", identifier=" + r122 + ", cancelled=" + r128);
        nz9.b.f(CJPayUploadVideoUtil.ERROR_CODE_FILE_NOT_EXIST, CollectionsKt.listOf(new String[]{"creation_page/album_upload", "creation_page/re_upload", "creation_page/album_upload/video"}), r121);
    L69:
        r127 = false;
        goto L70
    L61:
        FLogger.f375446a.i("MultiAttachmentSelector", "cancelResourceAccessForPageLeave keep resource access task for send, resourceKey=" + r121 + ", identifier=" + r122);
        goto L46
    L50:
        if (r122.length() <= 0) goto L52;
        boolean r129 = true;
    L53:
        if (r129 == false) goto L55;
        String r130 = r122;
    L56:
        if (r130 == null) goto L59;
        r123 = this.f371974x.contains(r130);
        goto L60
    L55:
        r130 = null;
        goto L56
    L52:
        r129 = false;
        goto L53
    L73:
        Set r131 = CollectionsKt.toSet(this.f371973w.keySet());
        ArrayList r132 = new ArrayList();
        Iterator r133 = r110.iterator();
    L75:
        if (r133.hasNext() == false) goto L79;
        Object r134 = r133.next();
        if ((!r131.contains((String) r134)) == false) goto L75;
        r132.add(r134);
        goto L75
    L79:
        Iterator r135 = r132.iterator();
    L81:
        if (r135.hasNext() == false) goto L93;
        String r136 = (String) r135.next();
        ICreationResourceAccessService.Companion r137 = ICreationResourceAccessService.f373925a;
        com.larus.bmhome.resource.access.z r138 = ICreationResourceAccessService.a.c(r137, r136, null, null, 14);
        if (r138 == null) goto L89;
        com.larus.bmhome.resource.access.a0 r139 = r138.f313784c;
        if (r139 == null) goto L89;
        if (com.larus.bmhome.resource.access.s.b(r139) != true) goto L89;
        boolean r140 = true;
    L90:
        if (r140 == true) goto L81;
        boolean r141 = r137.a(r136, ResourceCancelReason.PAGE_DESTROY);
        FLogger.f375446a.i("MultiAttachmentSelector", "cancelResourceAccessForPageLeave fallback cancel resource access task, resourceKey=" + r136 + ", cancelled=" + r141);
    L89:
        r140 = false;
        goto L90
    }

    @Override // ry9.h
    public final void Nn() {
        if ((Z3() instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L13;
        return;
    L13:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L7
        ResourceType r101 = ResourceType.VIDEO;     // Catch: Throwable -> L7
        List<ResourceItemBean> r102 = a4(r101);     // Catch: Throwable -> L7
        ResourceType r103 = ResourceType.IMAGE;     // Catch: Throwable -> L7
        List<ResourceItemBean> r104 = a4(r103);     // Catch: Throwable -> L7
        ResourceType r105 = ResourceType.AUDIO;     // Catch: Throwable -> L7
        List<ResourceItemBean> r110 = a4(r105);     // Catch: Throwable -> L7
        int r106 = ((ArrayList) r102).size();     // Catch: Throwable -> L7
        int r107 = ((ArrayList) r104).size();     // Catch: Throwable -> L7
        int r111 = ((ArrayList) r110).size();     // Catch: Throwable -> L7
        int r112 = r106 + r107;     // Catch: Throwable -> L7
        FLogger r113 = FLogger.f375446a;     // Catch: Throwable -> L7
        r113.i("MultiAttachmentSelector", "[deleteAttachmentsIfNeeds] curSize: " + r112 + ", curVideoSize: " + r106 + ", curImageSize: " + r107 + ", curAudioSize: " + r111);     // Catch: Throwable -> L7
        StringBuilder r108 = new StringBuilder("[deleteAttachmentsIfNeeds] delete video count = ");     // Catch: Throwable -> L7
        r108.append(r106);     // Catch: Throwable -> L7
        r113.i("MultiAttachmentSelector", r108.toString());     // Catch: Throwable -> L7
        Q3(r106, r101);     // Catch: Throwable -> L7
        StringBuilder r109 = new StringBuilder("[deleteAttachmentsIfNeeds] delete audio count = ");     // Catch: Throwable -> L7
        r109.append(r111);     // Catch: Throwable -> L7
        r113.i("MultiAttachmentSelector", r109.toString());     // Catch: Throwable -> L7
        Q3(r111, r105);     // Catch: Throwable -> L7
        int r114 = (r112 - r106) - this.P;     // Catch: Throwable -> L7
        r113.i("MultiAttachmentSelector", "[deleteAttachmentsIfNeeds] delete image count = " + r114);     // Catch: Throwable -> L7
        Q3(r114, r103);     // Catch: Throwable -> L7
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L15;
        r116.printStackTrace();
        com.larus.platform.service.g.f365738a.ensureNotReachHere(r116);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // ry9.h
    public final boolean SM() {
        return !a4(ResourceType.VIDEO).isEmpty();
    }

    public final CreationAlbumPipelinePrewarmer V3() {
        return this.I.getValue();
    }

    public final ny9.s W3() {
        return (ny9.s) this.f371964n.getValue();
    }

    @Override // ry9.h
    public final boolean Wb() {
        Map<String, ry9.k> r100 = this.f371971u.getValue();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, ry9.k>> r101 = r100.entrySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L30;
        Map.Entry<String, ry9.k> r102 = r101.next();
        ResourceItemBean r103 = this.f371975y.get(r102.getKey());
        if (r103 == null) goto L13;
        ResourceType r104 = r103.getResourceType();
    L15:
        if (r104 == ResourceType.VIDEO) goto L17;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L9;
        return true;
    L17:
        if ((r102.getValue().f539945b instanceof ry9.j.a) == false) goto L19;
        r105 = true;
        goto L20
    L13:
        r104 = null;
        goto L15
    L30:
        return false;
    L29:
        return false;
    }

    public final ny9.u c4() {
        return (ny9.u) this.f371963m.getValue();
    }

    public final ys8.a d4() {
        return (ys8.a) this.f371965o.getValue();
    }

    public final String h4() {
        String r100 = this.f371961J;
        if (r100 != null) goto L6;
        int r101 = wf9.b.f559489a;
        String r102 = com.flow.kmp.common.util.i.a();
        this.f371961J = r102;
        return r102;
    L6:
        return r100;
    }

    public final int j4() {
        Map<String, MutableLiveData<ry9.k>> r100 = this.f371972v;
        int r101 = 1;
        if (r100.isEmpty() == false) goto L5;
        int r102 = 0;
    L11:
        com.larus.bmhome.actionbar.model.w0 r103 = Z3();
        if ((r103 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L14;
        com.larus.bmhome.actionbar.model.w0.a r104 = (com.larus.bmhome.actionbar.model.w0.a) r103;
    L15:
        if (r104 == null) goto L21;
        wa8.d1 r105 = r104.f295535a;
        if (r105 == null) goto L21;
        if (r105.a(CreationReferenceMediaType.VIDEO) != true) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == true) goto L24;
    L26:
        r101 = 0;
    L27:
        int r107 = r102 + r101;
        com.larus.bmhome.actionbar.model.w0 r108 = Z3();
        if ((r108 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L34;
        Integer r109 = ((com.larus.bmhome.actionbar.model.w0.a) r108).f295535a.c();
        if (r109 == null) goto L32;
        int r110 = r109.intValue();
    L37:
        return RangesKt.coerceAtLeast(r110 - r107, 0);
    L32:
        r110 = 0;
        goto L37
    L34:
        if (Intrinsics.areEqual(r108, com.larus.bmhome.actionbar.model.w0.b.f295536a) == false) goto L39;
        r110 = this.P;
        goto L37
    L39:
        throw new NoWhenBranchMatchedException();
    L24:
        if (this.W == null) goto L26;
    L21:
        r106 = false;
        goto L22
    L14:
        r104 = null;
        goto L15
    L5:
        Iterator<Map.Entry<String, MutableLiveData<ry9.k>>> r111 = r100.entrySet().iterator();
        r102 = 0;
    L7:
        if (r111.hasNext() == false) goto L11;
        if ((!Intrinsics.areEqual(r111.next().getKey(), this.W)) == false) goto L7;
        r102 = r102 + 1;
        goto L7
    }

    @Override // ry9.h
    public final boolean jb() {
        Map<String, ry9.k> r100 = this.f371971u.getValue();
        if (r100 == null) goto L11;
        Iterator<Map.Entry<String, ry9.k>> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        if ((r101.next().getValue().f539945b instanceof ry9.j.a) == false) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        if (this.O == false) goto L5;
        LocalTakePictureImpl r100 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r101 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        MultiAttachmentSelectorComponent$initTakePictureHelper$1 r102 = new MultiAttachmentSelectorComponent$initTakePictureHelper$1(this);
        Function1<? super xp9.i, Unit> r103 = new d3(this);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter("instruction_multi_attachment_selector", "resultScene");
        Intrinsics.checkNotNullParameter(r102, "onCancel");
        Intrinsics.checkNotNullParameter(r103, "onSuccess");
        ((AlbumHelper) r100.f308463f.getValue()).d(r101, "instruction_multi_attachment_selector", r102, r103);
    L5:
        LocalTakePictureImpl r104 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r105 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Function1<? super AlbumSelectItem, Unit> r106 = new e3(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter("instruction_multi_attachment_selector", "resultScene");
        Intrinsics.checkNotNullParameter(r106, "onSuccess");
        ((AlbumHelper) r104.f308463f.getValue()).b(r105, "instruction_multi_attachment_selector", r106);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        ((c) this.T.getValue()).b();
        N6();
    }

    @Override // com.larus.bmhome.instruction.kmp.a
    public final KmpInstructionAttachmentProviderAdapter oy() {
        return new KmpInstructionAttachmentProviderAdapter(this);
    }

    @Override // com.larus.bmhome.instruction.kmp.a
    public final MediatorLiveData p30() {
        MediatorLiveData<Map<String, ry9.k>> r100 = this.f371971u;
        if ((r100 instanceof LiveData) == true) goto L7;
        return null;
    L7:
        return r100;
    }

    @Override // com.larus.ui.arch.component.external.api.Component, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ry9.h.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.instruction.kmp.a.class);
    }

    public MultiAttachmentSelectorComponent() {
        this.f371962l = LazyKt.lazy(new l1());
        this.f371963m = LazyKt.lazy(new m1(this));
        this.f371964n = LazyKt.lazy(new n1(this));
        this.f371965o = LazyKt.lazy(new o1(this));
        this.f371966p = LazyKt.lazy(new p1(this));
        this.f371967q = LazyKt.lazy(new q1(this));
        this.f371968r = LazyKt.lazy(new r1(this));
        com.larus.platform.service.z2 r100 = com.larus.platform.service.z2.f365865a;
        this.f371969s = r100.disableReUploadGeneratedImg();
        this.f371970t = Collections.synchronizedMap(new HashMap());
        this.f371971u = new MediatorLiveData(MapsKt.emptyMap());
        this.f371972v = Collections.synchronizedMap(new LinkedHashMap());
        this.f371973w = new ConcurrentHashMap();
        this.f371974x = ConcurrentHashMap.newKeySet();
        this.f371975y = new ConcurrentHashMap();
        this.f371976z = new ConcurrentHashMap();
        this.A = new ConcurrentHashMap();
        this.E = new ConcurrentHashMap();
        this.F = new ConcurrentHashMap();
        this.G = ConcurrentHashMap.newKeySet();
        this.H = new LocalTakePictureImpl();
        this.I = LazyKt.lazy(new s1(this));
        this.M = new MutableLiveData(new ry9.l(true, 6));
        this.N = new MutableLiveData(new ry9.f(null, 0, null, null, 15));
        this.O = r100.enableCreationMixSkillAlbumMultiSelect();
        this.Q = -1;
        this.S = -1;
        this.T = LazyKt.lazy(new t1());
        this.Y = LazyKt.lazy(new u1(this));
    }

    public final void G3() {
        CreationAlbumPipelinePrewarmer r100 = V3();
        r100.getClass();
        r100.a(ResourceCancelReason.USER_CANCEL);
        if (this.K == true) goto L5;
    L9:
        this.K = false;
        this.L = null;
        return;
    L5:
        if (Intrinsics.areEqual(this.f371961J, this.L) == false) goto L9;
        if (this.f371975y.isEmpty() == false) goto L9;
        this.f371961J = null;
        goto L9
    }

    public final com.larus.bmhome.actionbar.model.w0 Z3() {
        ys8.a r100 = d4();
        if (r100 == null) goto L7;
        com.larus.bmhome.actionbar.model.w0 r101 = r100.yn();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return com.larus.bmhome.actionbar.model.w0.b.f295536a;
    }

    @Override // ry9.h
    public final void vB() {
        AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), new MultiAttachmentSelectorComponent$updateResourceBarUI$1(this, null), 2);
    }

    public final String x5() {
        ny9.s r100 = W3();
        String r101 = null;
        if (r100 == null) goto L7;
        ChatParam r102 = r100.c();
        if (r102 == null) goto L7;
        String r103 = r102.f296890b;
    L8:
        String r104 = "";
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        boolean r105 = true;
        if (r103.length() != 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L37;
        ny9.u r107 = c4();
        if (r107 == null) goto L19;
        String r108 = r107.getBotId();
    L20:
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        if (r108.length() == 0) goto L26;
        r105 = false;
    L26:
        if (r105 == false) goto L38;
        com.larus.bmhome.chat.api.e0 r109 = AuthModelDelegate.f297134b.e().getValue();
        if (r109 == null) goto L32;
        LaunchInfo r110 = r109.f297186a;
        if (r110 == null) goto L32;
        r101 = r110.W();
    L32:
        if (r101 == null) goto L36;
        r104 = r101;
    L36:
        return r104;
    L38:
        return r108;
    L19:
        r108 = null;
        goto L20
    L37:
        return r103;
    L14:
        r106 = false;
    L7:
        r103 = null;
        goto L8
    }

    @Override // ry9.h
    public final MutableLiveData BV() {
        return this.N;
    }

    @Override // ry9.h
    public final MutableLiveData Bw() {
        return this.M;
    }

    @Override // ry9.h
    public final String J6() {
        return this.f371961J;
    }

    @Override // ry9.h
    public final LiveData<Map<String, ry9.k>> ja() {
        return this.f371971u;
    }

    @Override // ry9.h
    public final String yC() {
        return this.W;
    }

    public static final void P2(MultiAttachmentSelectorComponent r100) {
        CreationAlbumPipelinePrewarmer r101 = r100.V3();
        r101.getClass();
        r101.a(ResourceCancelReason.USER_CANCEL);
        r100.K = false;
        r100.L = null;
    }

    public static CreationReferenceAlbumMediaType T5(CreationReferenceMediaType r100) {
        int r101 = b.f371977a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return CreationReferenceAlbumMediaType.AUDIO;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return CreationReferenceAlbumMediaType.VIDEO;
    L13:
        return CreationReferenceAlbumMediaType.IMAGE;
    }

    public static final ICoreInputAbility U2(MultiAttachmentSelectorComponent r100) {
        return (ICoreInputAbility) r100.f371966p.getValue();
    }

    public static PolarisFileWrapper w5(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        return null;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L37;
        return r101;
    L37:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r103) == false) goto L18;
        r103 = null;
    L18:
        Uri r104 = (Uri) r103;
        if (r104 != null) goto L21;
    L26:
        String r105 = null;
    L27:
        if (r105 != null) goto L29;
        return null;
    L29:
        if ((!StringsKt.isBlank(r105)) == true) goto L32;
        r105 = null;
    L32:
        if (r105 == null) goto L40;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);
        if (r106.exists() == true) goto L36;
        return null;
    L36:
        return r106;
    L40:
        return null;
    L21:
        if (Intrinsics.areEqual(r104.getScheme(), "file") == true) goto L24;
        r104 = null;
    L24:
        if (r104 == null) goto L26;
        r105 = r104.getPath();
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    @Override // ry9.h
    public final void C2(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L13;
        return;
    L13:
        if (this.I.isInitialized() == false) goto L25;
        CreationAlbumPipelinePrewarmer r102 = V3();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        Object r103 = r102.f371905c;
        monitor-enter(r103);
        CreationAlbumPipelinePrewarmer.b r104 = (CreationAlbumPipelinePrewarmer.b) ((LinkedHashMap) r102.f371908f).get(r100);     // Catch: Throwable -> L22
        if (r104 == null) goto L19;
        CreationAlbumPipelinePrewarmer.TaskOwner r105 = CreationAlbumPipelinePrewarmer.TaskOwner.SEND;     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r105, "<set-?>");     // Catch: Throwable -> L22
        r104.f371915e = r105;     // Catch: Throwable -> L22
    L19:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r103);
    L22:
        th = move-exception;
        throw th;
    L25:
        this.f371974x.add(r100);
        FLogger.f375446a.i("MultiAttachmentSelector", "mark upload handoff to send");
        return;
    L6:
        r101 = false;
        goto L7
    }

    @Override // ry9.h
    public final void IR(com.larus.uaigc.instruction.z r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.C = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ry9.h
    public final void JZ(String r410) {
        DigitalAvatarInfoManager.f371542a.getClass();
        if (DigitalAvatarInfoManager.i() == false) goto L6;
        String r100 = ContextCompat.getString(getContext(), R.string.larus_replicaTemplate_label_creating);
    L9:
        Intrinsics.checkNotNull(r100);
        String r101 = UUID.randomUUID().toString();
        HashMap r102 = new HashMap();
        r102.put("ext_show_re_select_layout", Boolean.FALSE);
        r102.put("ext_avatar_subscript_desc", r100);
        ItemStatus r110 = ItemStatus.UPLINKING;
        ResourceType r210 = ResourceType.AVATAR;
        Map r310 = null;
        int r311 = 0;
        int r312 = 0;
        Object[] r411 = 0 == true ? 1 : 0;
        Object[] r412 = 0 == true ? 1 : 0;
        ResourceItemBean r103 = new ResourceItemBean(r101, null, null, null, new Image(UUID.randomUUID().toString(), null, new ImageObj(r410, r311, r312, r310, null, 30, null), null, null, null, null, r310, r411, null, r412, null, null, null, 16378, null), null, 0, r110, false, r210, i5.w0(), 0, 0, 0, false, false, false, false, 0, r102, 522542, null);
        this.W = r101;
        this.f371975y.put(r101, r103);
        Function1<? super ResourceItemBean, Unit> r104 = this.C;
        if (r104 == null) goto L12;
        r104.invoke(r103);
    L12:
        if (r410 != null) goto L14;
        String r105 = "";
    L15:
        q00(r101, r105, "", "", "", false, true, "");
        return;
    L14:
        r105 = r410;
        goto L15
    L6:
        if (DigitalAvatarInfoManager.h() == false) goto L8;
        r100 = ContextCompat.getString(getContext(), R.string.larus_replica_upload_preview_img_tag_replica);
        goto L9
    L8:
        r100 = "";
        goto L9
    }

    @Override // ry9.h
    public final void Lp(int r100) {
        this.P = r100;
    }

    @Override // ry9.h
    public final void OI(com.larus.uaigc.instruction.a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        this.B = r100;
    }

    @Override // ry9.h
    public final ry9.k Q00(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceKey");
        Map<String, ry9.k> r101 = this.f371971u.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get(r100);
    }

    @Override // ry9.h
    public final void QA(ry9.l r100) {
        Intrinsics.checkNotNullParameter(r100, "passedImageUrlListData");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$clearAndSetPassedImageUrlList$1(this, r100, null), 3, null);
    }

    public final void R4(String r210) {
        if ((Z3() instanceof com.larus.bmhome.actionbar.model.w0.a) == true) goto L5;
        return;
    L5:
        ry9.d r100 = yH(CollectionsKt.toList(this.f371975y.values()));
        Set<String> r101 = cq9.b.f465024a;
        CreationMultiReferenceLogEvent r102 = CreationMultiReferenceLogEvent.ATTACHMENT_CHANGED;
        Boolean r103 = Boolean.TRUE;
        com.larus.bmhome.actionbar.model.w0 r104 = Z3();
        if ((r104 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L8;
        com.larus.bmhome.actionbar.model.w0.a r105 = (com.larus.bmhome.actionbar.model.w0.a) r104;
    L10:
        if (r105 == null) goto L16;
        wa8.d1 r106 = r105.f295535a;
        if (r106 == null) goto L16;
        if (r106.a(CreationReferenceMediaType.VIDEO) != true) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        int r108 = r100.f539925b;
    L20:
        List<ry9.c> r109 = r100.f539924a;
        if ((r109 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r110 = r109.iterator();
        int r111 = 0;
    L27:
        if (r110.hasNext() == false) goto L36;
        if (((ry9.c) r110.next()).getType() != CreationReferenceAttachmentType.IMAGE) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == false) goto L27;
        r111 = r111 + 1;
        if (r111 >= 0) goto L27;
        CollectionsKt.throwCountOverflow();
        goto L27
    L31:
        r112 = false;
        goto L32
    L36:
        int r113 = r111;
    L37:
        List<ry9.c> r114 = r100.f539924a;
        if ((r114 instanceof Collection) == true) goto L40;
    L42:
        Iterator<T> r115 = r114.iterator();
        int r116 = 0;
    L44:
        if (r115.hasNext() == false) goto L53;
        if (((ry9.c) r115.next()).getType() != CreationReferenceAttachmentType.VIDEO) goto L48;
        boolean r117 = true;
    L49:
        if (r117 == false) goto L44;
        r116 = r116 + 1;
        if (r116 >= 0) goto L44;
        CollectionsKt.throwCountOverflow();
        goto L44
    L48:
        r117 = false;
    L53:
        int r118 = r116 + r108;
        List<ry9.c> r119 = r100.f539924a;
        if ((r119 instanceof Collection) == true) goto L56;
    L58:
        Iterator<T> r120 = r119.iterator();
        int r121 = 0;
    L60:
        if (r120.hasNext() == false) goto L69;
        if (((ry9.c) r120.next()).getType() != CreationReferenceAttachmentType.AUDIO) goto L64;
        boolean r122 = true;
    L65:
        if (r122 == false) goto L60;
        r121 = r121 + 1;
        if (r121 >= 0) goto L60;
        CollectionsKt.throwCountOverflow();
        goto L60
    L64:
        r122 = false;
        goto L65
    L69:
        int r123 = r121;
    L70:
        List<ry9.c> r124 = r100.f539924a;
        if ((r124 instanceof Collection) == true) goto L73;
    L75:
        Iterator<T> r125 = r124.iterator();
        int r126 = 0;
    L77:
        if (r125.hasNext() == false) goto L86;
        if (((ry9.c) r125.next()).getType() != CreationReferenceAttachmentType.UNKNOWN) goto L81;
        boolean r127 = true;
    L82:
        if (r127 == false) goto L77;
        r126 = r126 + 1;
        if (r126 >= 0) goto L77;
        CollectionsKt.throwCountOverflow();
        goto L77
    L81:
        r127 = false;
        goto L82
    L86:
        int r128 = r126;
    L87:
        List<ry9.c> r129 = r100.f539924a;
        ArrayList r130 = new ArrayList();
        Iterator<T> r131 = r129.iterator();
    L89:
        if (r131.hasNext() == false) goto L96;
        Object r132 = r131.next();
        if (((ry9.c) r132).getType() != CreationReferenceAttachmentType.VIDEO) goto L93;
        boolean r133 = true;
    L94:
        if (r133 == false) goto L89;
        r130.add(r132);
        goto L89
    L93:
        r133 = false;
        goto L94
    L96:
        Iterator r134 = r130.iterator();
        double r135 = 0.0d;
    L98:
        if (r134.hasNext() == false) goto L104;
        Double r136 = ((ry9.c) r134.next()).f539922j;
        if (r136 == null) goto L102;
        double r137 = r136.doubleValue();
    L103:
        r135 = r135 + r137;
        goto L98
    L102:
        r137 = 0.0d;
        goto L103
    L104:
        Double r138 = r100.f539926c;
        if (r138 == null) goto L107;
        double r139 = r138.doubleValue();
    L108:
        double r140 = r135 + r139;
        List<ry9.c> r141 = r100.f539924a;
        ArrayList r142 = new ArrayList();
        Iterator<T> r143 = r141.iterator();
    L110:
        if (r143.hasNext() == false) goto L118;
        Object r144 = r143.next();
        if (((ry9.c) r144).getType() != CreationReferenceAttachmentType.AUDIO) goto L114;
        boolean r145 = true;
    L115:
        if (r145 == false) goto L110;
        r142.add(r144);
        goto L110
    L114:
        r145 = false;
        goto L115
    L118:
        Iterator r146 = r142.iterator();
        double r147 = 0.0d;
    L120:
        if (r146.hasNext() == false) goto L126;
        Double r148 = ((ry9.c) r146.next()).f539922j;
        if (r148 == null) goto L124;
        double r149 = r148.doubleValue();
    L125:
        r147 = r147 + r149;
        goto L120
    L124:
        r149 = 0.0d;
        goto L125
    L126:
        cq9.b.a(r102, r103, "video_creation", r210, new cq9.a(r113, r118, r123, r128, r140, r147, 64), null, null, null, TTVideoEngineInterface.PLAYER_OPTION_DUMMYSURFACE_FORBID);
        return;
    L107:
        r139 = 0.0d;
        goto L108
    L73:
        if (r124.isEmpty() == false) goto L75;
        r128 = 0;
        goto L87
    L56:
        if (r119.isEmpty() == false) goto L58;
        r123 = 0;
        goto L70
    L40:
        if (r114.isEmpty() == false) goto L42;
        r116 = 0;
        goto L53
    L23:
        if (r109.isEmpty() == false) goto L25;
        r113 = 0;
        goto L37
    L19:
        r108 = 0;
    L16:
        r107 = false;
        goto L17
    L8:
        r105 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ry9.h
    public final NestedFileContent V20(List<ResourceItemBean> r410) {
        Intrinsics.checkNotNullParameter(r410, "resourceItemOrder");
        com.larus.uaigc.helper.f.f373014a.getClass();
        boolean r100 = true;
        if (com.larus.uaigc.helper.f.a() == false) goto L235;
        ArrayList r110 = new ArrayList();
        if ((r410 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r101 = r410.iterator();
        int r102 = 0;
    L11:
        if (r101.hasNext() == false) goto L33;
        ResourceItemBean r111 = (ResourceItemBean) r101.next();
        ResourceType r112 = r111.getResourceType();
        if (r112 != ResourceType.IMAGE) goto L15;
    L20:
        boolean r113 = true;
    L21:
        if (r113 == false) goto L23;
    L28:
        boolean r114 = true;
    L29:
        if (r114 == false) goto L11;
        r102 = r102 + 1;
        if (r102 >= 0) goto L11;
        CollectionsKt.throwCountOverflow();
        goto L11
    L23:
        if (r111.getResourceType() == ResourceType.AUDIO) goto L25;
    L27:
        r114 = false;
        goto L29
    L25:
        if (i4(this, r111) == false) goto L27;
    L15:
        if (r112 == ResourceType.AVATAR) goto L20;
        if (r112 == ResourceType.VIDEO) goto L20;
        r113 = false;
    L33:
        Iterator<T> r103 = r410.iterator();
    L35:
        if (r103.hasNext() == false) goto L231;
        ResourceItemBean r104 = (ResourceItemBean) r103.next();
        if (r104.getResourceType() == ResourceType.AUDIO) goto L39;
        ResourceType r115 = r104.getResourceType();
        if (r115 != ResourceType.IMAGE) goto L44;
    L49:
        boolean r116 = true;
    L50:
        if (r116 == false) goto L35;
        ResourceItemBean r117 = this.f371975y.get(r104.getKey());
        if (r117 != null) goto L55;
        ResourceItemBean r118 = r104;
    L56:
        MutableLiveData<ry9.k> r119 = this.f371970t.get(r104.getKey());
        if (r119 == null) goto L61;
        ry9.k r120 = r119.getValue();
        if (r120 == null) goto L61;
        ry9.j r121 = r120.f539945b;
    L62:
        MediaAttachment r122 = this.A.get(r104.getKey());
        if (r121 == null) goto L65;
        ry9.i r123 = r121.a();
    L67:
        if ((r123 instanceof ry9.i.a) == false) goto L70;
        String r124 = ((ry9.i.a) r123).f539932a.getIdentifier();
    L74:
        if (r124 != null) goto L76;
    L80:
        if (r122 == null) goto L86;
        r124 = r122.getIdentifier();
        if (r124 == null) goto L86;
        if ((!StringsKt.isBlank(r124)) == false) goto L86;
    L87:
        if (r124 != null) goto L114;
        Image r125 = r118.getImage();
        if (r125 == null) goto L95;
        r124 = r125.identifier;
        if (r124 == null) goto L95;
        if ((!StringsKt.isBlank(r124)) == false) goto L95;
    L96:
        if (r124 != null) goto L114;
        Image r126 = r118.getImage();
        if (r126 == null) goto L104;
        r124 = r126.f346641md5;
        if (r124 == null) goto L104;
        if ((!StringsKt.isBlank(r124)) == false) goto L104;
    L105:
        if (r124 != null) goto L114;
        mt8.b r127 = r118.getVideo();
        if (r127 == null) goto L113;
        r124 = r127.f515655f;
        if (r124 == null) goto L113;
        if ((!StringsKt.isBlank(r124)) == true) goto L114;
    L113:
        r124 = null;
    L104:
        r124 = null;
    L95:
        r124 = null;
    L114:
        String r128 = q5(r104.getKey(), r124);
        if (r118.getResourceType() != ResourceType.VIDEO) goto L117;
        boolean r105 = true;
    L118:
        ICreationResourceAccessService.Companion r129 = ICreationResourceAccessService.f373925a;
        if (r105 == false) goto L121;
        com.larus.bmhome.resource.access.x r130 = com.larus.uaigc.service.f.f373959c;
    L122:
        com.larus.bmhome.resource.access.x r106 = r130;
        if (r105 == false) goto L125;
        ResourceMediaType r131 = ResourceMediaType.VIDEO;
    L126:
        ResourceMediaType r107 = r131;
        if (r105 == false) goto L129;
        String r108 = "creation_video";
    L130:
        com.larus.bmhome.resource.access.z r109 = r129.d(r128, r106, r107, r108);
        if (r109 == null) goto L133;
        com.larus.bmhome.resource.access.a0 r132 = r109.f313784c;
    L135:
        if ((r132 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L137;
        com.larus.bmhome.resource.access.a0.d r133 = (com.larus.bmhome.resource.access.a0.d) r132;
    L138:
        if (r133 == null) goto L141;
        com.larus.bmhome.resource.access.f0 r134 = r133.f313618a;
        if (r134 == null) goto L141;
    L142:
        com.larus.bmhome.resource.access.f0 r135 = r134;
        if (r109 == null) goto L145;
        com.larus.bmhome.resource.access.a0 r136 = r109.f313784c;
    L147:
        if ((r136 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L149;
        com.larus.bmhome.resource.access.a0.e r137 = (com.larus.bmhome.resource.access.a0.e) r136;
    L150:
        if (r137 == null) goto L153;
        com.larus.bmhome.resource.access.j0 r138 = r137.f313621c;
        if (r138 == null) goto L153;
    L157:
        com.larus.bmhome.resource.access.j0 r139 = r138;
    L159:
        if (r109 == null) goto L165;
        Map<String, com.larus.bmhome.resource.access.q0> r140 = r109.f313788g;
        if (r140 == null) goto L165;
        com.larus.bmhome.resource.access.q0 r141 = r140.get("preprocess");
        if (r141 == null) goto L165;
        Map<String, String> r142 = r141.f313721f;
    L166:
        if (r142 != null) goto L168;
        r142 = MapsKt.emptyMap();
    L168:
        Map r143 = MapsKt.toMutableMap(r142);
        if (r137 == null) goto L171;
        Map<String, String> r144 = r137.f313622d;
    L172:
        if (r144 != null) goto L174;
        r144 = MapsKt.emptyMap();
    L174:
        r143.putAll(r144);
        int r145 = com.larus.uaigc.createpage.component.mediaselector.imageselector.b.f372023a;
        String r146 = this.f371976z.get(r104.getKey());
        ny9.s r147 = W3();
        if (r147 != null) goto L177;
    L179:
        boolean r210 = false;
    L180:
        UplinkFileEntity r148 = com.larus.uaigc.createpage.component.mediaselector.imageselector.b.a(r118, r121, r122, r128, r135, r139, r143, r146, r210);
        if (r105 == false) goto L226;
        if (r148 == null) goto L189;
        Integer r149 = r148.getUpLinkStatus();
        int r150 = UpLinkState.PROCESSING.getValue();
        if (r149 == null) goto L189;
        if (r149.intValue() != r150) goto L189;
        boolean r151 = true;
    L190:
        if (r151 == false) goto L226;
        ConcurrentHashMap<String, com.larus.uaigc.createpage.component.sendmessage.r0.a> r152 = com.larus.uaigc.createpage.component.sendmessage.r0.f372417a;
        ys8.a r153 = d4();
        if (r153 == null) goto L194;
        com.larus.bmhome.actionbar.model.e2 r154 = r153.tQ();
    L195:
        if (r154 == null) goto L199;
        Long r155 = r154.f295096d;
        if (r155 == null) goto L199;
        long r156 = r155.longValue();
    L200:
        Intrinsics.checkNotNullParameter(r128, LocationMonitorConst.IDENTIFIER);
        com.larus.uaigc.createpage.component.sendmessage.r0.a();
        if (StringsKt.isBlank(r128) == true) goto L226;
        if (r156 <= 0) goto L226;
        ConcurrentHashMap<String, com.larus.uaigc.createpage.component.sendmessage.r0.a> r157 = com.larus.uaigc.createpage.component.sendmessage.r0.f372417a;
        if (r157.size() < 64) goto L225;
        Iterator<T> r158 = r157.entrySet().iterator();
        if (r158.hasNext() == true) goto L210;
        Object r159 = null;
    L219:
        Map.Entry r160 = (Map.Entry) r159;
        if (r160 == null) goto L225;
        String r161 = (String) r160.getKey();
        if (r161 == null) goto L225;
        com.larus.uaigc.createpage.component.sendmessage.r0.a r162 = com.larus.uaigc.createpage.component.sendmessage.r0.f372417a.remove(r161);
        goto L225
    L210:
        r159 = r158.next();
        if (r158.hasNext() == false) goto L219;
        long r163 = ((com.larus.uaigc.createpage.component.sendmessage.r0.a) ((Map.Entry) r159).getValue()).f372419b;
    L214:
        Object r164 = r158.next();
        long r165 = ((com.larus.uaigc.createpage.component.sendmessage.r0.a) ((Map.Entry) r164).getValue()).f372419b;
        if (r163 <= r165) goto L218;
        r163 = r165;
        r159 = r164;
    L218:
        if (r158.hasNext() == true) goto L214;
    L225:
        com.larus.uaigc.createpage.component.sendmessage.r0.f372417a.put(r128, new com.larus.uaigc.createpage.component.sendmessage.r0.a(r156, System.currentTimeMillis()));
    L199:
        r156 = 0;
        goto L200
    L194:
        r154 = null;
    L189:
        r151 = false;
    L226:
        if (r148 == null) goto L35;
        r110.add(r148);
        goto L35
    L177:
        if (r147.x() != true) goto L179;
        r210 = true;
        goto L180
    L171:
        r144 = null;
    L165:
        r142 = null;
    L153:
        if (r109 == null) goto L158;
        com.larus.bmhome.resource.access.w r166 = r109.f313785d;
        if (r166 == null) goto L158;
        r138 = r166.f313763b;
    L158:
        r139 = null;
        goto L159
    L149:
        r137 = null;
        goto L150
    L145:
        r136 = null;
    L141:
        r134 = r129.c(r128);
        goto L142
    L137:
        r133 = null;
        goto L138
    L133:
        r132 = null;
        goto L135
    L129:
        r108 = null;
        goto L130
    L125:
        r131 = ResourceMediaType.IMAGE;
        goto L126
    L121:
        r130 = com.larus.uaigc.service.f.f373957a;
        goto L122
    L117:
        r105 = false;
    L86:
        r124 = null;
        goto L87
    L76:
        if ((!StringsKt.isBlank(r124)) == true) goto L79;
        r124 = null;
    L79:
        if (r124 != null) goto L114;
    L70:
        if ((r123 instanceof ry9.i.b) == false) goto L72;
        r124 = ((ry9.i.b) r123).f539934a.getIdentifier();
        goto L74
    L72:
        if (r123 != null) goto L229;
        r124 = null;
        goto L74
    L229:
        throw new NoWhenBranchMatchedException();
    L65:
        r123 = null;
    L61:
        r121 = null;
        goto L62
    L55:
        r118 = r117;
        goto L56
    L44:
        if (r115 == ResourceType.AVATAR) goto L49;
        if (r115 == ResourceType.VIDEO) goto L49;
        r116 = false;
        goto L50
    L39:
        if (i4(this, r104) == false) goto L35;
        B3(r110, r104);
        goto L35
    L231:
        if (r110.size() == r102) goto L233;
        FLogger.f375446a.e("MultiAttachmentSelector", "[getPipelineNestedFileContent] snapshot count mismatch, expected=" + r102 + ", actual=" + r110.size());
    L233:
        FLogger.f375446a.i("MultiAttachmentSelector", "[getPipelineNestedFileContent] finished, selected=" + r102 + ", entities=" + r110.size());
        return new NestedFileContent(r110, null, false, null, 14, null);
    L7:
        if (r410.isEmpty() == false) goto L9;
        r102 = 0;
        goto L33
    L235:
        ArrayList r167 = new ArrayList();
        FLogger r168 = FLogger.f375446a;
        StringBuilder r169 = new StringBuilder("[getCurrentNestedFileContent] start, resourceItemOrder size: ");
        ArrayList r170 = (ArrayList) r410;
        r169.append(r170.size());
        r168.i("MultiAttachmentSelector", r169.toString());
        Iterator r171 = r170.iterator();
    L237:
        if (r171.hasNext() == false) goto L487;
        ResourceItemBean r172 = (ResourceItemBean) r171.next();
        String r173 = r172.getKey();
        ResourceType r174 = r172.getResourceType();
        if (r174 == ResourceType.AUDIO) goto L241;
        MutableLiveData<ry9.k> r175 = this.f371970t.get(r173);
        if (r175 == null) goto L485;
        ry9.k r176 = r175.getValue();
        if (r176 == null) goto L485;
        ry9.j r177 = r176.f539945b;
        if ((r177 instanceof ry9.j.a) == false) goto L254;
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.c().d(), Boolean.TRUE) == false) goto L254;
    L264:
        if (r174 != ResourceType.IMAGE) goto L266;
    L272:
        ry9.i r178 = r177.a();
        if ((r178 instanceof ry9.i.a) == false) goto L275;
        ry9.i.a r179 = (ry9.i.a) r178;
    L276:
        if (r179 != null) goto L291;
        Image r180 = r172.getImage();
        if (r180 != null) goto L280;
    L290:
        r179 = null;
        goto L291
    L280:
        if (r180.localResPath == null) goto L290;
        String r211 = null;
        String r212 = null;
        ImageUploadInfo r213 = null;
        VideoUploadInfo r214 = null;
        Image r181 = r172.getImage();
        if (r181 == null) goto L284;
        String r215 = r181.localResPath;
    L285:
        String r182 = r172.getKey();
        Image r183 = r172.getImage();
        if (r183 == null) goto L288;
        String r184 = r183.f346641md5;
    L289:
        r179 = new ry9.i.a(new MediaAttachment(r211, r212, r213, r214, r215, q5(r182, r184), null, null, null, null, null, null, 4047, null), null);
        goto L291
    L288:
        r184 = null;
        goto L289
    L284:
        r215 = null;
    L291:
        if (r179 == null) goto L295;
        MediaAttachment r185 = r179.f539932a;
        if (r185 == null) goto L295;
        String r186 = r185.getUri();
    L296:
        if (r179 == null) goto L300;
        MediaAttachment r187 = r179.f539932a;
        if (r187 == null) goto L300;
        String r188 = r187.getLocalFilePath();
    L301:
        if (r179 == null) goto L305;
        MediaAttachment r189 = r179.f539932a;
        if (r189 == null) goto L305;
        String r190 = r189.getIdentifier();
    L306:
        if (r179 == null) goto L310;
        MediaAttachment r191 = r179.f539932a;
        if (r191 == null) goto L310;
        String r216 = r191.getResourceId();
    L311:
        String r310 = this.f371976z.get(r172.getKey());
        FLogger r192 = FLogger.f375446a;
        StringBuilder r193 = new StringBuilder("[addImageEntityToList] hasLocalFile=");
        if (r188 != null) goto L314;
    L317:
        boolean r194 = true;
    L318:
        r193.append(r194 ^ r100);
        r192.i("MultiAttachmentSelector", r193.toString());
        if (r188 != null) goto L321;
    L324:
        boolean r195 = true;
    L326:
        if (r195 == true) goto L390;
        if (new PolarisFileWrapper(r188).exists() == false) goto L390;
        ImFileUtil r196 = ImFileUtil.f314899a;
        PolarisFileWrapper r197 = new PolarisFileWrapper(r188);
        r196.getClass();
        String r217 = ImFileUtil.g(r197);
        String r218 = r179.f539932a.getUrl();
        ImageUploadInfo r198 = r179.f539932a.getImageUploadInfo();
        if (r198 == null) goto L334;
        Long r199 = r198.getWidth();
        if (r199 == null) goto L334;
        long r1100 = r199.longValue();
    L335:
        int r1101 = (int) r1100;
        ImageUploadInfo r200 = r179.f539932a.getImageUploadInfo();
        if (r200 == null) goto L340;
        Long r201 = r200.getHeight();
        if (r201 == null) goto L340;
        long r202 = r201.longValue();
    L341:
        ImageObj r219 = new ImageObj(r218, r1101, (int) r202, null, null, 24, null);
        ny9.s r203 = W3();
        if (r203 != null) goto L344;
    L346:
        boolean r204 = false;
    L348:
        if (Intrinsics.areEqual(r172.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L350;
        String r311 = "upload";
    L351:
        Boolean r312 = Boolean.valueOf(r204);
        ExpiredInfo r205 = null;
        String r220 = r186;
        String r221 = r188;
        String r222 = r190;
        UplinkFileInfo r206 = null;
        UplinkEntityContent r207 = new UplinkEntityContent(r206, new Image(r220, r217, null, r219, r216, r221, r222, null, null, null, r312, null, null, r311, 7044, null), 1, 0 == true ? 1 : 0);
        Integer r223 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        if (r186 != null) goto L354;
    L357:
        boolean r208 = true;
    L358:
        if (r208 == false) goto L360;
    L363:
        FileReviewState r209 = FileReviewState.DEFAULT;
    L364:
        Integer r224 = Integer.valueOf(r209.getValue());
        if (Intrinsics.areEqual(r177, ry9.j.a.f539936b) == false) goto L367;
        FileParseState r225 = FileParseState.PROCESSING;
    L368:
        Integer r226 = Integer.valueOf(r225.getValue());
        if (r186 != null) goto L371;
    L374:
        boolean r227 = true;
    L375:
        if (r227 == false) goto L377;
        int r228 = 0;
    L378:
        Integer r229 = Integer.valueOf(r228);
        if (r186 != null) goto L381;
    L384:
        boolean r230 = true;
    L385:
        if (r230 == false) goto L387;
        UpLinkState r231 = UpLinkState.PROCESSING;
    L388:
        r167.add(new UplinkFileEntity(r223, r207, r190, r205, r224, r226, r229, Integer.valueOf(r231.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r188)), r310, null, null, 13064, null));
    L486:
        r100 = true;
        goto L237
    L387:
        r231 = UpLinkState.SUCCESS;
        goto L388
    L381:
        if (r186.length() == 0) goto L384;
        r230 = false;
        goto L385
    L377:
        r228 = 100;
        goto L378
    L371:
        if (r186.length() == 0) goto L374;
        r227 = false;
        goto L375
    L367:
        r225 = FileParseState.SUCCESS;
        goto L368
    L360:
        if ((r177 instanceof ry9.j.g) == true) goto L363;
        r209 = FileReviewState.ACCESS;
        goto L364
    L354:
        if (r186.length() == 0) goto L357;
        r208 = false;
        goto L358
    L350:
        r311 = null;
        goto L351
    L344:
        if (r203.x() != true) goto L346;
        r204 = true;
    L340:
        r202 = 0;
    L334:
        r1100 = 0;
    L390:
        if (r179 == null) goto L394;
        MediaAttachment r232 = r179.f539932a;
        if (r232 == null) goto L394;
        String r1102 = r232.getUri();
    L395:
        if (r179 == null) goto L399;
        MediaAttachment r233 = r179.f539932a;
        if (r233 == null) goto L399;
        String r234 = r233.getUrl();
    L401:
        if (com.larus.utils.o0.d(r1102) == true) goto L403;
    L404:
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L407;
    L409:
        boolean r235 = false;
    L410:
        if (r235 == false) goto L486;
        if (r190 != null) goto L413;
    L419:
        String r236 = r172.getKey();
        Image r1103 = r172.getImage();
        if (r1103 == null) goto L422;
        String r1104 = r1103.f346641md5;
    L423:
        String r237 = q5(r236, r1104);
    L425:
        if (com.larus.utils.o0.d(r1102) == false) goto L427;
    L430:
        boolean r1105 = true;
    L431:
        if (r1102 != null) goto L433;
        String r238 = "";
    L435:
        if (r179 == null) goto L443;
        MediaAttachment r1106 = r179.f539932a;
        if (r1106 == null) goto L443;
        ImageUploadInfo r1107 = r1106.getImageUploadInfo();
        if (r1107 == null) goto L443;
        Long r1108 = r1107.getWidth();
        if (r1108 == null) goto L443;
        long r1109 = r1108.longValue();
    L444:
        int r1110 = (int) r1109;
        if (r179 == null) goto L453;
        MediaAttachment r239 = r179.f539932a;
        if (r239 == null) goto L453;
        ImageUploadInfo r240 = r239.getImageUploadInfo();
        if (r240 == null) goto L453;
        Long r241 = r240.getHeight();
        if (r241 == null) goto L453;
        long r1111 = r241.longValue();
    L454:
        ImageObj r242 = new ImageObj(r234, r1110, (int) r1111, null, null, 24, null);
        ny9.s r1112 = W3();
        if (r1112 != null) goto L457;
    L459:
        boolean r243 = false;
    L461:
        if (Intrinsics.areEqual(r172.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L463;
        String r313 = "upload";
    L464:
        ExpiredInfo r244 = null;
        String r245 = r188;
        String r246 = r237;
        UplinkFileInfo r247 = null;
        UplinkEntityContent r248 = new UplinkEntityContent(r247, new Image(r238, null, null, r242, r216, r245, r246, null, null, null, Boolean.valueOf(r243), null, null, r313, 7046, null), 1, 0 == true ? 1 : 0);
        Integer r249 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        if (r1105 == false) goto L467;
        int r250 = FileReviewState.ACCESS.getValue();
    L468:
        Integer r314 = Integer.valueOf(r250);
        Integer r315 = Integer.valueOf(FileParseState.SUCCESS.getValue());
        if (r1105 == false) goto L471;
        int r1113 = 100;
    L472:
        Integer r316 = Integer.valueOf(r1113);
        if (r1105 == false) goto L475;
        int r251 = UpLinkState.SUCCESS.getValue();
    L476:
        Integer r317 = Integer.valueOf(r251);
        Boolean r318 = null;
        boolean r319 = false;
        if (com.larus.utils.o0.d(r1102) == true) goto L480;
        r1102 = null;
    L480:
        if (r1102 == null) goto L483;
        r234 = r1102;
    L483:
        r167.add(new UplinkFileEntity(r249, r248, r237, r244, r314, r315, r316, r317, r318, r319, UriProtector.parse(r234), r310, null, null, 13064, null));
        goto L486
    L475:
        r251 = UpLinkState.PROCESSING.getValue();
        goto L476
    L471:
        r1113 = 0;
        goto L472
    L467:
        r250 = FileReviewState.DEFAULT.getValue();
        goto L468
    L463:
        r313 = null;
        goto L464
    L457:
        if (r1112.x() != true) goto L459;
        r243 = true;
    L453:
        r1111 = 0;
    L443:
        r1109 = 0;
        goto L444
    L433:
        r238 = r1102;
        goto L435
    L427:
        if (com.larus.utils.o0.d(r216) == true) goto L430;
        r1105 = false;
        goto L431
    L422:
        r1104 = null;
        goto L423
    L413:
        if ((!StringsKt.isBlank(r190)) == true) goto L416;
        r190 = null;
    L416:
        if (r190 == null) goto L419;
        r237 = r190;
        goto L425
    L407:
        if (com.larus.utils.o0.d(r234) == false) goto L409;
    L408:
        r235 = true;
        goto L410
    L403:
        if (com.larus.utils.o0.d(r234) == true) goto L408;
    L399:
        r234 = null;
    L394:
        r1102 = null;
        goto L395
    L321:
        if (r188.length() == 0) goto L324;
        r195 = false;
        goto L326
    L314:
        if (StringsKt.isBlank(r188) == true) goto L317;
        r194 = false;
    L310:
        r216 = null;
    L305:
        r190 = null;
    L300:
        r188 = null;
    L295:
        r186 = null;
        goto L296
    L275:
        r179 = null;
        goto L276
    L266:
        if (r174 == ResourceType.AVATAR) goto L272;
        if (r174 != ResourceType.VIDEO) goto L271;
        C3(r167, r177, r172);
        goto L486
    L271:
        FLogger.f375446a.e("MultiAttachmentSelector", "[getCurrentNestedFileContent] unsupported resource type");
    L254:
        if ((r177 instanceof ry9.j.h) == true) goto L264;
        if ((r177 instanceof ry9.j.g) == true) goto L264;
        if ((r177 instanceof ry9.j.c) == true) goto L260;
    L262:
        FLogger.f375446a.e("MultiAttachmentSelector", "[getCurrentNestedFileContent] attachment is not ready");
        goto L486
    L260:
        if (((ry9.j.c) r177).f539938b == null) goto L262;
    L485:
        FLogger.f375446a.e("MultiAttachmentSelector", "[getCurrentNestedFileContent] no live attachment state");
        goto L486
    L241:
        if ((Z3() instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L243;
    L244:
        B3(r167, r172);
        goto L486
    L243:
        if (Intrinsics.areEqual(r172.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == false) goto L486;
    L487:
        FLogger.f375446a.i("MultiAttachmentSelector", "[getCurrentNestedFileContent] finished, entities size: " + r167.size());
        return new NestedFileContent(r167, null, false, null, 14, null);
    }

    public final void V5(String r100) {
        FLogger.f375446a.i("MultiAttachmentSelector", "[unRegisterAttachmentLiveData] resourceKey = " + r100);
        MediatorLiveData<Map<String, ry9.k>> r101 = this.f371971u;
        Map<String, ry9.k> r102 = r101.getValue();
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        Map<String, ry9.k> r103 = MapsKt.toMutableMap(r102);
        r103.remove(r100);
        r101.setValue(r103);
        MutableLiveData<ry9.k> r104 = this.f371972v.get(r100);
        if (r104 == null) goto L8;
        this.f371971u.removeSource(r104);
    L8:
        this.f371972v.remove(r100);
    }

    public final MutableLiveData<ry9.k> X3(String r100) {
        return this.f371970t.get(r100);
    }

    public final List<ResourceItemBean> a4(ResourceType r100) {
        Map<String, MutableLiveData<ry9.k>> r101 = this.f371972v;
        ArrayList r102 = new ArrayList();
        Iterator<Map.Entry<String, MutableLiveData<ry9.k>>> r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        ResourceItemBean r104 = this.f371975y.get(r103.next().getKey());
        if (r104 == null) goto L8;
        ResourceType r105 = r104.getResourceType();
    L9:
        if (r105 == r100) goto L12;
        r104 = null;
    L12:
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        r105 = null;
        goto L9
    L14:
        return r102;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.larus.uaigc.createpage.component.mediaselector.imageselector.h2] */
    public final MutableLiveData<ry9.k> e4(final String r110) {
        MutableLiveData<ry9.k> r100 = this.f371970t.get(r110);
        if (r100 == null) goto L5;
        return r100;
    L5:
        FLogger r101 = FLogger.f375446a;
        r101.i("MultiAttachmentSelector", "[getOrCreateAttachmentLiveData] create liveData, resourceKey = " + r110);
        MutableLiveData<ry9.k> r102 = new MutableLiveData();
        this.f371970t.put(r110, r102);
        Intrinsics.checkNotNullParameter(this, "<this>");
        r102.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), (Observer) this.Y.getValue());
        r101.i("MultiAttachmentSelector", "[registerAttachmentLiveData] key = " + r110);
        if (this.f371972v.containsKey(r110) == false) goto L8;
        r101.i("MultiAttachmentSelector", "[registerAttachmentLiveData] containsKey = " + r110);
        V5(r110);
    L8:
        MediatorLiveData<Map<String, ry9.k>> r103 = this.f371971u;
        Map<String, ry9.k> r104 = r103.getValue();
        if (r104 != null) goto L11;
        r104 = MapsKt.emptyMap();
    L11:
        Map<String, ry9.k> r105 = MapsKt.toMutableMap(r104);
        ry9.k r106 = r102.getValue();
        if (r106 != null) goto L14;
        r106 = new ry9.k(null, null, 0, false, false, false, 63);
    L14:
        r105.put(r110, r106);
        r103.setValue(r105);
        this.f371971u.addSource(r102, new z3(new h2(this, r110)));
        this.f371972v.put(r110, r102);
        return r102;
    }

    @Override // ry9.h
    public final void ew(ResourceItemBean r110) {
        Intrinsics.checkNotNullParameter(r110, "bean");
        this.f371975y.put(r110.getKey(), r110);
        if (r110.getResourceType() != ResourceType.AUDIO) goto L26;
        Object r100 = r110.getExt().get("ext_audio_vid");
        Boolean r101 = null;
        if ((r100 instanceof String) == false) goto L7;
        String r102 = (String) r100;
    L9:
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        boolean r104 = !r103;
        MutableLiveData<ry9.k> r105 = e4(r110.getKey());
        String r106 = r110.getKey();
        if (r104 == false) goto L18;
        ry9.j r107 = new ry9.j.c(null);
    L19:
        ry9.j r108 = r107;
        Object r111 = r110.getExt().get("ext_audio_is_private");
        if ((r111 instanceof Boolean) == false) goto L22;
        r101 = (Boolean) r111;
    L22:
        if (r101 == null) goto L24;
        boolean r109 = r101.booleanValue();
    L25:
        r105.setValue(new ry9.k(r106, r108, 0, r109, false, false, 52));
        goto L26
    L24:
        r109 = false;
        goto L25
    L18:
        r107 = ry9.j.f.f539941b;
        goto L19
    L11:
        if (StringsKt.isBlank(r102) == true) goto L14;
        r103 = false;
        goto L15
    L7:
        r102 = null;
    L26:
        R4("prefill");
    }

    @Override // com.larus.bmhome.instruction.kmp.a
    public final void g80(boolean r100) {
        FLogger.f375446a.i("MultiAttachmentSelector", "[openInstructionAlbum] isReplace=" + r100 + ", remain=" + j4());
        ry9.h.a.a(this, j4(), r100, 0, 60);
    }

    public final com.larus.bmhome.actionbar.model.f2 k4(String r100) {
        ResourceItemBean r101 = this.f371975y.get(r100);
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("[getVideoUploadCoverInfoByResourceKey] hasVideo=");
        String r104 = null;
        if (r101 == null) goto L5;
        mt8.b r105 = r101.getVideo();
    L6:
        int r106 = 0;
        if (r105 == null) goto L9;
        boolean r107 = true;
    L10:
        r103.append(r107);
        r102.i("MultiAttachmentSelector", r103.toString());
        if (r101 == null) goto L17;
        mt8.b r108 = r101.getVideo();
        if (r108 == null) goto L17;
        Image r109 = r108.f515650a;
        if (r109 == null) goto L17;
        String r110 = r109.key;
    L18:
        if (r101 == null) goto L24;
        mt8.b r111 = r101.getVideo();
        if (r111 == null) goto L24;
        Image r112 = r111.f515650a;
        if (r112 == null) goto L24;
        r104 = r112.localResPath;
    L24:
        if (r101 == null) goto L28;
        mt8.b r113 = r101.getVideo();
        if (r113 == null) goto L28;
        int r114 = r113.f515652c;
    L29:
        if (r101 == null) goto L34;
        mt8.b r115 = r101.getVideo();
        if (r115 == null) goto L34;
        r106 = r115.f515653d;
    L34:
        return new com.larus.bmhome.actionbar.model.f2(r110, r104, Integer.valueOf(r106), Integer.valueOf(r114));
    L28:
        r114 = 0;
    L17:
        r110 = null;
        goto L18
    L9:
        r107 = false;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    @Override // ry9.h
    public final void lu(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resourceKey");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        Function1<? super String, Unit> r102 = this.D;
        if (r102 == null) goto L10;
        r102.invoke(r100);
    L10:
        this.W = null;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.kmp.a
    public final void nf(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L6;
        boolean r101 = true;
    L7:
        Object r102 = null;
        if (r101 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L37;
        Iterator<T> r103 = this.f371973w.entrySet().iterator();
    L15:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((Map.Entry) r104).getValue(), r100) == false) goto L15;
        r102 = r104;
    L19:
        Map.Entry r105 = (Map.Entry) r102;
        if (r105 == null) goto L23;
        String r106 = (String) r105.getKey();
        if (r106 == null) goto L23;
    L24:
        ResourceItemBean r107 = this.f371975y.get(r106);
        if (r107 == null) goto L30;
        Image r108 = r107.getImage();
        if (r108 == null) goto L30;
        String r109 = r108.localResPath;
        if (r109 == null) goto L30;
    L31:
        FLogger.f375446a.i("MultiAttachmentSelector", "[removeInstructionAttachment] identifier=" + r100 + ", resourceKey=" + r106);
        w60(r106, r109, "click_remove");
        return;
    L30:
        r109 = "";
    L23:
        r106 = r100;
        goto L24
    L37:
        return;
    L6:
        r101 = false;
        goto L7
    }

    public final void o5(String r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$requireSelectedImageUrlInBackground$1(this, r100, null), 3, null);
    }

    public final Object s5(Continuation<? super CreationRemoteConversationHelper.a> r100) {
        if ((r100 instanceof MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$1) == false) goto L7;
        MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$1 r101 = (MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L39:
        CreationRemoteConversationHelper.a r106 = (CreationRemoteConversationHelper.a) r103;
        if (r106.f372617b == false) goto L46;
        ny9.s r107 = W3();
        if (r107 == null) goto L46;
        ChatParam r108 = r107.c();
        if (r108 == null) goto L46;
        r108.f296889a = r106.f372616a;
    L46:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ny9.s r109 = W3();
        if (r109 == null) goto L19;
        ChatParam r110 = r109.c();
        if (r110 == null) goto L19;
        String r111 = r110.f296889a;
    L20:
        String r112 = "";
        if (r111 != null) goto L24;
        r111 = "";
    L24:
        if (r111.length() != 0) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L36;
        ny9.u r114 = c4();
        if (r114 == null) goto L31;
        String r115 = r114.Y1();
    L32:
        if (r115 == null) goto L35;
        r112 = r115;
    L35:
        r111 = r112;
        goto L36
    L31:
        r115 = null;
    L36:
        String r116 = x5();
        CoroutineDispatcher r117 = Dispatchers.getIO();
        MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1 r118 = new MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$result$1(r111, r116, null);
        r101.label = 1;
        r103 = BuildersKt.withContext(r117, r118, r101);
        if (r103 != r104) goto L39;
        return r104;
    L26:
        r113 = false;
    L19:
        r111 = null;
    L7:
        r101 = new MultiAttachmentSelectorComponent$resolveConversationBeforeUpload$1(this, r100);
        goto L8
    }

    @Override // ry9.h
    public final void tE(com.larus.uaigc.instruction.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.D = r100;
    }

    public final String y5(String r100) {
        ResourceItemBean r101 = this.f371975y.get(r100);
        if (r101 == null) goto L5;
        ResourceType r102 = r101.getResourceType();
    L7:
        if (r102 != ResourceType.VIDEO) goto L9;
        return "creation_page/album_upload/video";
    L9:
        return "creation_page/album_upload";
    L5:
        r102 = null;
        goto L7
    }

    @Override // ry9.h
    public final ry9.d yH(List<ResourceItemBean> r210) {
        Intrinsics.checkNotNullParameter(r210, "resourceItemOrder");
        List<ResourceItemBean> r100 = r210;
        int r101 = 1;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L16;
        if (((ResourceItemBean) r102.next()).getResourceType() != ResourceType.AVATAR) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L9;
        int r104 = 1;
    L17:
        if (r104 == 0) goto L21;
        DigitalAvatarInfoManager.f371542a.getClass();
        ey9.a r105 = DigitalAvatarInfoManager.f();
        if (r105 == null) goto L21;
        Double r106 = Double.valueOf(r105.c());
    L22:
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r100.iterator();
        int r109 = 0;
    L24:
        if (r108.hasNext() == false) goto L255;
        Object r110 = r108.next();
        int r111 = r109 + 1;
        if (r109 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        ResourceItemBean r112 = (ResourceItemBean) r110;
        if (r112.getResourceType() != ResourceType.ADD) goto L31;
    L250:
        ry9.c r113 = null;
    L251:
        if (r113 == null) goto L253;
        r107.add(r113);
    L253:
        r109 = r111;
        r101 = 1;
        goto L24
    L31:
        if (r112.getResourceType() == ResourceType.CUSTOM) goto L250;
        if (r112.getResourceType() == ResourceType.AVATAR) goto L250;
        MutableLiveData<ry9.k> r114 = this.f371970t.get(r112.getKey());
        if (r114 == null) goto L40;
        ry9.k r115 = r114.getValue();
        if (r115 == null) goto L40;
        ry9.j r116 = r115.f539945b;
    L42:
        if ((r116 instanceof ry9.j.c) == false) goto L44;
        ry9.j.c r117 = (ry9.j.c) r116;
    L45:
        if (r117 == null) goto L47;
        ry9.i r118 = r117.f539938b;
    L49:
        if ((r118 instanceof ry9.i.a) == false) goto L51;
        ry9.i.a r119 = (ry9.i.a) r118;
    L52:
        if (r119 == null) goto L56;
        MediaAttachment r120 = r119.f539932a;
        if (r120 == null) goto L56;
        ImageUploadInfo r121 = r120.getImageUploadInfo();
    L57:
        Image r122 = r112.getImage();
        if (r122 == null) goto L61;
        ImageObj r123 = r122.imageOri;
        if (r123 == null) goto L61;
    L70:
        String r124 = r112.getKey();
        int r125 = b.f371981e[r112.getResourceType().ordinal()];
        if (r125 != r101) goto L73;
        CreationReferenceAttachmentType r126 = CreationReferenceAttachmentType.IMAGE;
    L81:
        if (Intrinsics.areEqual(r112.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == false) goto L83;
        CreationReferenceAttachmentSource r127 = CreationReferenceAttachmentSource.DO_SAME;
    L111:
        if (r116 == null) goto L141;
        if (Intrinsics.areEqual(r116, ry9.j.b.f539937b) == false) goto L116;
        CreationReferenceAttachmentState r128 = CreationReferenceAttachmentState.SELECTED;
    L136:
        if (r128 == null) goto L141;
    L150:
        CreationReferenceAttachmentState r129 = r128;
        String r130 = r112.getMimeType();
        if ((!StringsKt.isBlank(r130)) == false) goto L153;
        String r131 = r130;
    L154:
        String r132 = r112.getFileSuffixes();
        if ((!StringsKt.isBlank(r132)) == false) goto L157;
        String r133 = r132;
    L158:
        mt8.b r134 = r112.getVideo();
        if (r134 == null) goto L168;
        Integer r135 = Integer.valueOf(r134.f515652c);
        if (r135.intValue() <= 0) goto L163;
        boolean r136 = true;
    L164:
        if (r136 == true) goto L167;
        r135 = null;
    L167:
        if (r135 == null) goto L168;
    L190:
        Integer r137 = r135;
    L191:
        mt8.b r138 = r112.getVideo();
        if (r138 == null) goto L201;
        Integer r139 = Integer.valueOf(r138.f515653d);
        if (r139.intValue() <= 0) goto L196;
        boolean r140 = true;
    L197:
        if (r140 == true) goto L200;
        r139 = null;
    L200:
        if (r139 == null) goto L201;
    L223:
        mt8.b r141 = r112.getVideo();
        if (r141 == null) goto L234;
        Float r142 = Float.valueOf(r141.f515651b);
        if (r142.floatValue() <= 0.0f) goto L228;
        boolean r143 = true;
    L229:
        if (r143 == true) goto L232;
        r142 = null;
    L232:
        if (r142 == null) goto L234;
        Double r144 = Double.valueOf(r142.floatValue());
    L240:
        Double r145 = r144;
    L242:
        Object r146 = r112.getExt().get("ext_creation_reference_file_size");
        if ((r146 instanceof Number) == false) goto L245;
        Number r147 = (Number) r146;
    L246:
        if (r147 == null) goto L248;
        Long r211 = Long.valueOf(r147.longValue());
    L249:
        r113 = new ry9.c(r124, r109, r126, r127, r129, r131, r133, r137, r139, r145, r211);
        goto L251
    L248:
        r211 = null;
        goto L249
    L245:
        r147 = null;
        goto L246
    L228:
        r143 = false;
    L234:
        Object r148 = r112.getExt().get("ext_audio_duration_seconds");
        if ((r148 instanceof Number) == false) goto L237;
        Number r149 = (Number) r148;
    L238:
        if (r149 == null) goto L241;
        r144 = Double.valueOf(r149.doubleValue());
        goto L240
    L241:
        r145 = null;
        goto L242
    L237:
        r149 = null;
        goto L238
    L196:
        r140 = false;
    L201:
        if (r123 == null) goto L208;
        r139 = Integer.valueOf(r123.height);
        if (r139.intValue() <= 0) goto L205;
        boolean r150 = true;
    L206:
        if (r150 == false) goto L208;
    L209:
        if (r139 != null) goto L223;
        if (r121 == null) goto L222;
        Long r151 = r121.getHeight();
        if (r151 == null) goto L222;
        if (r151.longValue() <= 0) goto L216;
        boolean r152 = true;
    L217:
        if (r152 == true) goto L220;
        r151 = null;
    L220:
        if (r151 == null) goto L222;
        r139 = Integer.valueOf((int) r151.longValue());
        goto L223
    L216:
        r152 = false;
    L222:
        r139 = null;
        goto L223
    L205:
        r150 = false;
    L208:
        r139 = null;
        goto L209
    L163:
        r136 = false;
    L168:
        if (r123 == null) goto L175;
        r135 = Integer.valueOf(r123.width);
        if (r135.intValue() <= 0) goto L172;
        boolean r153 = true;
    L173:
        if (r153 == false) goto L175;
    L176:
        if (r135 != null) goto L190;
        if (r121 == null) goto L189;
        Long r154 = r121.getWidth();
        if (r154 == null) goto L189;
        if (r154.longValue() <= 0) goto L183;
        boolean r155 = true;
    L184:
        if (r155 == true) goto L187;
        r154 = null;
    L187:
        if (r154 == null) goto L189;
        r137 = Integer.valueOf((int) r154.longValue());
        goto L191
    L183:
        r155 = false;
    L189:
        r137 = null;
        goto L191
    L172:
        r153 = false;
    L175:
        r135 = null;
        goto L176
    L157:
        r133 = null;
        goto L158
    L153:
        r131 = null;
        goto L154
    L116:
        if (Intrinsics.areEqual(r116, ry9.j.a.f539936b) == false) goto L119;
        r128 = CreationReferenceAttachmentState.COMPRESSING;
        goto L136
    L119:
        if (Intrinsics.areEqual(r116, ry9.j.h.f539943b) == false) goto L122;
        r128 = CreationReferenceAttachmentState.UPLOADING;
        goto L136
    L122:
        if (Intrinsics.areEqual(r116, ry9.j.g.f539942b) == false) goto L125;
        r128 = CreationReferenceAttachmentState.UPLOAD_SUCCESS;
        goto L136
    L125:
        if (Intrinsics.areEqual(r116, ry9.j.f.f539941b) == false) goto L128;
        r128 = CreationReferenceAttachmentState.UPLOAD_FAILED;
        goto L136
    L128:
        if (Intrinsics.areEqual(r116, ry9.j.e.f539940b) == false) goto L131;
        r128 = CreationReferenceAttachmentState.PARSE_FAILED;
        goto L136
    L131:
        if (Intrinsics.areEqual(r116, ry9.j.d.f539939b) == false) goto L134;
        r128 = CreationReferenceAttachmentState.INSPECT_FAILED;
        goto L136
    L134:
        if ((r116 instanceof ry9.j.c) == false) goto L139;
        r128 = CreationReferenceAttachmentState.UPLOAD_SUCCESS;
        goto L136
    L139:
        throw new NoWhenBranchMatchedException();
    L141:
        switch(b.f371982f[r112.getStatus().ordinal()]) {
            case 1: goto L149;
            case 2: goto L148;
            case 3: goto L148;
            case 4: goto L147;
            case 5: goto L146;
            case 6: goto L145;
            case 7: goto L144;
            default: goto L143;
        };
    L144:
        r128 = CreationReferenceAttachmentState.EXPIRED;
        goto L150
    L145:
        r128 = CreationReferenceAttachmentState.INSPECT_FAILED;
        goto L150
    L146:
        r128 = CreationReferenceAttachmentState.PARSE_FAILED;
        goto L150
    L147:
        r128 = CreationReferenceAttachmentState.UPLOAD_FAILED;
        goto L150
    L148:
        r128 = CreationReferenceAttachmentState.UPLOAD_SUCCESS;
        goto L150
    L149:
        r128 = CreationReferenceAttachmentState.UPLOADING;
        goto L150
    L143:
        throw new NoWhenBranchMatchedException();
    L83:
        Image r156 = r112.getImage();
        if (r156 == null) goto L86;
        String r157 = r156.localResPath;
    L87:
        if (r157 != null) goto L89;
    L92:
        boolean r158 = true;
    L93:
        if (r158 == false) goto L107;
        mt8.b r159 = r112.getVideo();
        if (r159 == null) goto L97;
        String r160 = r159.f515654e;
    L98:
        if (r160 != null) goto L100;
    L103:
        boolean r161 = true;
    L104:
        if (r161 == false) goto L107;
        boolean r162 = false;
    L108:
        if (r162 == false) goto L110;
        r127 = CreationReferenceAttachmentSource.MANUAL;
        goto L111
    L110:
        r127 = CreationReferenceAttachmentSource.UNKNOWN;
        goto L111
    L100:
        if (r160.length() == 0) goto L103;
        r161 = false;
        goto L104
    L97:
        r160 = null;
    L107:
        r162 = true;
        goto L108
    L89:
        if (r157.length() == 0) goto L92;
        r158 = false;
        goto L93
    L86:
        r157 = null;
        goto L87
    L73:
        if (r125 != 2) goto L75;
        r126 = CreationReferenceAttachmentType.VIDEO;
        goto L81
    L75:
        if (r125 == 3) goto L77;
        r126 = CreationReferenceAttachmentType.UNKNOWN;
        goto L81
    L77:
        r126 = CreationReferenceAttachmentType.AUDIO;
    L61:
        Image r163 = r112.getImage();
        if (r163 == null) goto L64;
        r123 = r163.imageThumb;
    L65:
        if (r123 != null) goto L70;
        Image r164 = r112.getImage();
        if (r164 == null) goto L69;
        r123 = r164.previewImage;
        goto L70
    L69:
        r123 = null;
        goto L70
    L64:
        r123 = null;
    L56:
        r121 = null;
        goto L57
    L51:
        r119 = null;
        goto L52
    L47:
        r118 = null;
        goto L49
    L44:
        r117 = null;
    L40:
        r116 = null;
        goto L42
    L255:
        return new ry9.d(CollectionsKt.toList(r107), r104, r106);
    L21:
        r106 = null;
        goto L22
    L13:
        r103 = false;
    L16:
        r104 = 0;
        goto L17
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    public final ResourceType z5(String r100) {
        ResourceItemBean r101 = this.f371975y.get(r100);
        if (r101 == null) goto L7;
        ResourceType r102 = r101.getResourceType();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return ResourceType.IMAGE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void B3(List r210, ResourceItemBean r211) {
        Object r100 = r211.getExt().get("ext_audio_vid");
        Image r101 = null;
        if ((r100 instanceof String) == false) goto L5;
        String r102 = (String) r100;
    L7:
        if (r102 != null) goto L9;
    L11:
        String r103 = null;
    L12:
        if (r103 != null) goto L15;
        FLogger.f375446a.w("MultiAttachmentSelector", "remote audio missing vid");
        return;
    L15:
        Object r104 = r211.getExt().get("ext_audio_type");
        if ((r104 instanceof String) == false) goto L18;
        String r105 = (String) r104;
    L20:
        if (r105 == null) goto L30;
        String r106 = StringsKt.trim(r105).toString();
        if (r106 == null) goto L30;
        String r107 = StringsKt.trimStart(r106, new char[]{'.'});
        if (r107 == null) goto L30;
        String r108 = r107.toLowerCase(Locale.ROOT);
        if (r108 == null) goto L30;
        if ((!StringsKt.isBlank(r108)) == false) goto L30;
        String r109 = r108;
    L31:
        String r110 = StringsKt.trim(r211.getTitle()).toString();
        if (r109 == null) goto L41;
        String r111 = StringsKt.substringBeforeLast(r110, '.', r110);
        if (StringsKt.isBlank(r111) == false) goto L36;
        r111 = "audio";
    L36:
        String r112 = r111 + '.' + r109;
        if (r112 == null) goto L41;
        r110 = r112;
    L44:
        Object r113 = r211.getExt().get("ext_audio_identifier");
        if ((r113 instanceof String) == false) goto L47;
        String r114 = (String) r113;
    L48:
        if (r114 != null) goto L50;
    L55:
        r114 = r211.getKey();
    L56:
        Integer r212 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        String r115 = null;
        String r116 = null;
        Integer r117 = Integer.valueOf(FileType.FileTypeAudio.getValue());
        Long r213 = null;
        String r214 = null;
        String r118 = null;
        Image r119 = null;
        String r120 = null;
        String r121 = null;
        Object r122 = r211.getExt().get("ext_audio_duration_seconds");
        if ((r122 instanceof Number) == false) goto L59;
        Number r123 = (Number) r122;
    L60:
        if (r123 == null) goto L62;
        Float r124 = Float.valueOf(r123.floatValue());
    L63:
        ((ArrayList) r210).add(new UplinkFileEntity(r212, new UplinkEntityContent(new UplinkFileInfo(r110, r115, r116, r117, r213, r214, new VideoExtension(r103, r118, r119, r109, r120, r121, r124, null, null, null, 950, null), r211.getMimeType(), null, null, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME, null), r101, 2, null == true ? 1 : 0), r114, null, Integer.valueOf(FileReviewState.ACCESS.getValue()), Integer.valueOf(FileParseState.SUCCESS.getValue()), 100, Integer.valueOf(UpLinkState.SUCCESS.getValue()), null, false, null, null, null, null, 16136, null));
        return;
    L62:
        r124 = null;
        goto L63
    L59:
        r123 = null;
        goto L60
    L50:
        if ((true ^ StringsKt.isBlank(r114)) == true) goto L53;
        r114 = null;
    L53:
        if (r114 == null) goto L55;
    L47:
        r114 = null;
    L41:
        if ((!StringsKt.isBlank(r110)) == true) goto L44;
        r110 = null;
    L30:
        r109 = null;
        goto L31
    L18:
        r105 = null;
        goto L20
    L9:
        if ((!StringsKt.isBlank(r102)) == false) goto L11;
        r103 = r102;
        goto L12
    L5:
        r102 = null;
        goto L7
    }

    public static final ry9.a F2(MultiAttachmentSelectorComponent r510, xp9.i r511) {
        r510.getClass();
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        boolean r102 = G4();
        Iterator<T> r103 = r511.f564765a.iterator();
    L4:
        if (r103.hasNext() == false) goto L63;
        Uri r104 = (Uri) r103.next();
        List<AlbumSelectItem> r105 = r511.f564767c;
        ImageObj r106 = null;
        if (r105 == null) goto L15;
        Iterator<T> r107 = r105.iterator();
    L9:
        if (r107.hasNext() == false) goto L13;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((AlbumSelectItem) r108).f365506a, r104) == false) goto L9;
    L14:
        AlbumSelectItem r109 = (AlbumSelectItem) r108;
    L64:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L18
        Object r111 = Result.m9449constructorimpl(vqc.d.d(r510.getContext(), r104));     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r111) == false) goto L23;
        r111 = null;
    L23:
        String r112 = (String) r111;
        if (r112 == null) goto L4;
        r100.add(r112);
        HashMap r113 = new HashMap();
        r113.put("ext_img_show_path", r112);
        boolean r114 = true;
        if (r109 == null) goto L37;
        Long r115 = Long.valueOf(r109.f365510e);
        if (r115.longValue() <= 0) goto L31;
        boolean r116 = true;
    L32:
        if (r116 == true) goto L35;
        r115 = null;
    L35:
        if (r115 == null) goto L37;
        r113.put("ext_creation_reference_file_size", Long.valueOf(r115.longValue()));
        goto L37
    L31:
        r116 = false;
    L37:
        com.larus.uaigc.helper.f.f373014a.getClass();
        Boolean r117 = com.larus.uaigc.helper.f.c().d();
        Boolean r118 = Boolean.TRUE;
        if (Intrinsics.areEqual(r117, r118) == false) goto L40;
        r113.put("ext_silent_upload", r118);
    L40:
        if (r102 == false) goto L42;
        String r119 = r510.V3().c(r104, AlbumSelectionMediaType.IMAGE);
    L43:
        if (r119 != null) goto L45;
        r119 = UUID.randomUUID().toString();
    L45:
        String r210 = r119;
        String r310 = StringsKt.substringAfterLast$default(r112, '.', null, 2, null);
        String r120 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast$default(r112, '.', null, 2, null));
        if (r120 != null) goto L48;
        r120 = "";
    L48:
        String r311 = r120;
        ItemStatus r312 = ItemStatus.UPLINKING;
        ResourceType r313 = ResourceType.IMAGE;
        String r121 = UUID.randomUUID().toString();
        if (r109 != null) goto L51;
    L61:
        ResourceItemBean r122 = new ResourceItemBean(r210, null, r310, r311, new Image(r121, "", null, r106, null, r112, null, null, null, null, null, null, null, null, 16340, null), null, 0, r312, false, r313, i5.w0(), 0, 0, 0, false, false, false, false, 0, r113, 522530, null);
        r101.add(r122);
        r510.f371975y.put(r122.getKey(), r122);
        goto L4
    L51:
        if (r109.f365507b > 0) goto L53;
    L55:
        r114 = false;
    L56:
        if (r114 == true) goto L59;
        r109 = null;
    L59:
        if (r109 == null) goto L61;
        r106 = new ImageObj(null, r109.f365507b, r109.f365508c, null, null, 25, null);
        goto L61
    L53:
        if (r109.f365508c <= 0) goto L55;
    L42:
        r119 = null;
    L18:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L13:
        r108 = null;
        goto L14
    L15:
        r109 = null;
        goto L64
    L63:
        return new ry9.a(r101, r100, r510.Q);
    }

    public static final ry9.a L2(MultiAttachmentSelectorComponent r210, xp9.i r211) {
        r210.getClass();
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        boolean r102 = G4();
        List<AlbumSelectItem> r103 = r211.f564767c;
        if (r103 == null) goto L47;
        Iterator<T> r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L47;
        AlbumSelectItem r105 = (AlbumSelectItem) r104.next();
        ResourceItemBean r106 = com.larus.uaigc.helper.o0.c(r105.f365506a, null);
        if (r106 == null) goto L6;
        ResourceType r107 = r106.getResourceType();
        ResourceType r108 = ResourceType.VIDEO;
        boolean r110 = true;
        if (r107 != r108) goto L17;
        mt8.b r111 = r106.getVideo();
        if (r111 == null) goto L15;
        mt8.b r109 = mt8.b.a(r111, null, RangesKt.coerceAtLeast(r105.f365509d, 0) / 1000.0f, RangesKt.coerceAtLeast(r105.f365507b, 0), RangesKt.coerceAtLeast(r105.f365508c, 0), null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_SET_FIRST_FRAME_MILLISECOND);
    L16:
        r106 = AlbumHelperKt.c(r106, null, r109, 1);
        goto L17
    L15:
        r109 = null;
    L17:
        Long r112 = Long.valueOf(r105.f365510e);
        if (r112.longValue() > 0) goto L21;
        r110 = false;
    L21:
        if (r110 == true) goto L24;
        r112 = null;
    L24:
        if (r112 == null) goto L27;
        r106.getExt().put("ext_creation_reference_file_size", Long.valueOf(r112.longValue()));
    L27:
        if (r106.getResourceType() == ResourceType.IMAGE) goto L29;
    L35:
        if (r102 == false) goto L43;
        Uri r113 = r105.f365506a;
        if (r113 == null) goto L43;
        CreationAlbumPipelinePrewarmer r114 = r210.V3();
        if (r106.getResourceType() != r108) goto L41;
        AlbumSelectionMediaType r115 = AlbumSelectionMediaType.VIDEO;
    L42:
        String r116 = r114.c(r113, r115);
    L44:
        if (r116 == null) goto L46;
        r106 = AlbumHelperKt.c(r106, r116, null, 2);
    L46:
        r101.add(r106);
        r210.f371975y.put(r106.getKey(), r106);
        goto L6
    L41:
        r115 = AlbumSelectionMediaType.IMAGE;
    L43:
        r116 = null;
        goto L44
    L29:
        if (r105.f365507b <= 0) goto L35;
        if (r105.f365508c <= 0) goto L35;
        Image r117 = r106.getImage();
        if (r117 == null) goto L35;
        r117.imageOri = new ImageObj(null, r105.f365507b, r105.f365508c, null, null, 25, null);
    L47:
        r210.R4("album");
        return new ry9.a(r101, r100, r210.Q);
    }

    public static final void X2(MultiAttachmentSelectorComponent r100, ic8.n0 r101) {
        r100.getClass();
        ProcessFileResultCode r102 = r101.f489244b;
        if (r102 != null) goto L5;
        int r103 = -1;
    L7:
        if (r103 != 1) goto L9;
        FLogger.f375446a.e("MultiAttachmentSelector", "tryAttachmentUpload ProcessResult for OverSize");
        t19.s r104 = t19.s.f544207a;
        Application r105 = AppHost.f326268a.getApplication();
        r104.getClass();
        t19.s.s(r105, R.string.larus_image_oversize);
        return;
    L9:
        if (r103 == 2) goto L11;
        t19.s r106 = t19.s.f544207a;
        Application r107 = AppHost.f326268a.getApplication();
        r106.getClass();
        t19.s.s(r107, R.string.larus_notification_system_error_toast);
        return;
    L11:
        FLogger.f375446a.e("MultiAttachmentSelector", "tryAttachmentUpload ProcessResult for PREPARE_TYPE_NO_MATCH");
        t19.s r108 = t19.s.f544207a;
        Application r109 = AppHost.f326268a.getApplication();
        r108.getClass();
        t19.s.s(r109, R.string.larus_image_upload_file_type_error);
        return;
    L5:
        r103 = b.f371980d[r102.ordinal()];
        goto L7
    }

    public static final boolean i4(MultiAttachmentSelectorComponent r100, ResourceItemBean r101) {
        if ((r100.Z3() instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r101.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L8;
        return false;
    }

    public static final Unit m3(final MultiAttachmentSelectorComponent r110, ry9.a r111) {
        r110.getClass();
        Iterator<T> r112 = r111.f539910a.iterator();
    L4:
        if (r112.hasNext() == false) goto L18;
        final ResourceItemBean r100 = (ResourceItemBean) r112.next();
        Image r101 = r100.getImage();
        if (r101 == null) goto L4;
        String r102 = r101.localResPath;
        if (r102 == null) goto L4;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == false) goto L4;
        nz9.b.h("creation_page/album_upload", "creation_page", r100.getKey(), null, 24);
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L15;
        com.larus.utils.t0.e(new p2(r110, r100));
        BuildersKt.async$default(LifecycleOwnerKt.getLifecycleScope(r110), Dispatchers.getIO(), null, new MultiAttachmentSelectorComponent$onCompressUploadAndCheck$2$2(r100, r110, r103, null), 2, null);
        goto L4
    L15:
        r110.f5(r100.getKey(), r102, null);
        goto L4
    L18:
        return Unit.INSTANCE;
    }

    @Override // ry9.h
    public final Object BM(ResourceItemBean r100, Continuation<? super Unit> r101) {
        Object r102 = BuildersKt.withContext(Dispatchers.getIO(), new MultiAttachmentSelectorComponent$uploadResourceItemBean$2(r100, this, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final void E5(String r100, String r101) {
        if (this.F.putIfAbsent(r100, Boolean.TRUE) != null) goto L6;
        nz9.b.h("upload", r101, r100, r100, 16);
        return;
    }

    public final void Q3(int r100, ResourceType r101) {
        AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), new MultiAttachmentSelectorComponent$deleteExceedMediaAttachments$1(this, r100, r101, null), 2);
    }

    @Override // ry9.h
    public final void f90(boolean r100, com.larus.uaigc.createpage.component.input.t r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.V = "plus_panel_preview";
        this.U = r101;
        ry9.h.a.a(this, j4(), r100, 0, 60);
    }

    public final void i5(String r100, String r101) {
        if (r101 == null) goto L24;
        boolean r102 = true;
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
    L8:
        r102 = false;
    L9:
        if (r102 == true) goto L12;
        r101 = null;
    L12:
        if (r101 == null) goto L26;
        ResourceItemBean r103 = this.f371975y.get(r100);
        if (r103 == null) goto L25;
        Image r104 = r103.getImage();
        if (r104 != null) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(r104.localResPath, r101) == false) goto L22;
        return;
    L22:
        FLogger.f375446a.i("MultiAttachmentSelector", "[rememberImageLocalPathForRetry] cached=true");
        r104.localResPath = r101;
        return;
    L25:
        return;
    L26:
        return;
    L6:
        if (new PolarisFileWrapper(r101).exists() == false) goto L8;
    }

    @Override // ry9.h
    public final void nE(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "resourceKey");
        Intrinsics.checkNotNullParameter(r101, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$handleAttachmentRetry$1(this, r100, r101, null), 3, null);
    }

    public final void p4(ResourceUploadError r100, final String r110) {
        com.larus.uaigc.helper.f r101 = com.larus.uaigc.helper.f.f373014a;
        r101.getClass();
        boolean r102 = false;
        if (com.larus.uaigc.helper.f.a() == true) goto L5;
    L8:
        com.larus.utils.t0.e(new l2(this, r110));
        r101.getClass();
        if ((!com.larus.uaigc.helper.f.a()) == false) goto L23;
        String r103 = r100.getCode();
        ProcessFileResultCode[] r104 = ProcessFileResultCode.values();
        int r105 = r104.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L21;
        ProcessFileResultCode r107 = r104[r106];
        if (Intrinsics.areEqual(r107.getValue(), r103) == true) goto L15;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == true) goto L19;
        r106 = r106 + 1;
        goto L11
    L19:
        r102 = true;
        goto L21
    L15:
        if (Intrinsics.areEqual(r107.getErrorType(), "send_file_preprocess_fail") == false) goto L17;
        r108 = true;
    L21:
        if (r102 == true) goto L23;
        E5(r110, y5(r110));
        nz9.b.e("upload", r100.getCode(), r110);
        this.F.remove(r110);
    L23:
        nz9.b.e(y5(r110), r100.getCode(), r110);
        return;
    L5:
        if (ICreationResourceAccessServiceKt.f(r100) == false) goto L8;
        com.larus.utils.t0.e(new k2(this, r110));
        T4(false, "review", "pic");
        nz9.b.e("creation_page/album_upload", "-103", r110);
    }

    public final void q4(final String r100, final mr9.k r101) {
        com.larus.uaigc.helper.f.f373014a.getClass();
        if ((!com.larus.uaigc.helper.f.a()) == false) goto L5;
        E5(r100, y5(r100));
    L5:
        com.larus.utils.t0.e(new v2(r101, this, r100));
    }

    public final String q5(String r100, String r101) {
        String r102 = this.f371973w.get(r100);
        boolean r103 = true;
        String r104 = null;
        if (r102 != null) goto L5;
    L13:
        if (r101 != null) goto L15;
    L22:
        if (r104 != null) goto L25;
        return r100;
    L25:
        return r104;
    L15:
        if (r101.length() > 0) goto L18;
        r103 = false;
    L18:
        if (r103 == true) goto L21;
        r101 = null;
    L21:
        r104 = r101;
        goto L22
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L13;
        return r102;
    L7:
        r105 = false;
        goto L8
    }

    public static /* synthetic */ void V4(MultiAttachmentSelectorComponent r100, boolean r101, String r102) {
        r100.T4(r101, r102, "pic");
    }

    public static final Object p3(final MultiAttachmentSelectorComponent r110, final ResourceItemBean r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof MultiAttachmentSelectorComponent$startVideoResourceAccess$1) == false) goto L7;
        MultiAttachmentSelectorComponent$startVideoResourceAccess$1 r100 = (MultiAttachmentSelectorComponent$startVideoResourceAccess$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 != 1) goto L19;
        Uri r105 = (Uri) r100.L$2;
        final String r106 = (String) r100.L$1;
        ResourceItemBean r107 = (ResourceItemBean) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 CancellationException -> L16
        ResourceItemBean r108 = r107;
        String r109 = r106;
    L78:
        com.larus.bmhome.resource.access.b0 r113 = (com.larus.bmhome.resource.access.b0) r102;     // Catch: CancellationException -> L16 Throwable -> L62
        if (r113 != null) goto L61;
        r113 = ICreationResourceAccessService.f373925a.b(r110.E3(r109, r105, r108));     // Catch: CancellationException -> L16 Throwable -> L62
    L61:
        Job r114 = AlbumHelperKt.f(LifecycleOwnerKt.getLifecycleScope(r110), Dispatchers.getIO(), CoroutineStart.LAZY, new MultiAttachmentSelectorComponent$startVideoResourceAccess$observerJob$1(r110, r113, r108, r109, null));
        r110.E.put(r109, r114);
        r114.start();
        return Unit.INSTANCE;
    L62:
        th = th;
        r106 = r109;
    L66:
        FLogger.f375446a.e("MultiAttachmentSelector", "[startVideoResourceAccess] submit failed, resourceKey=" + r106, th);
        com.larus.utils.t0.e(new g2(r110, r106));
        r110.T4(false, "upload", "video");
        nz9.b.e("creation_page/album_upload/video", "-101", r106);
        return Unit.INSTANCE;
    L14:
        th = th;
        goto L66
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
        Object r115 = null;
        nz9.b.h("creation_page/album_upload/video", "creation_page", r111.getKey(), null, 24);
        com.larus.utils.t0.e(new k1(r110, r111));
        final String r116 = r111.getKey();
        Object r117 = r111.getExt().get("ext_video_local_uri");
        if ((r117 instanceof String) == false) goto L23;
        String r118 = (String) r117;
    L74:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L30
        if (r118 != null) goto L27;
        String r120 = "";
    L28:
        Object r121 = Result.m9449constructorimpl(UriProtector.parse(r120));     // Catch: Throwable -> L30
    L33:
        if (Result.m9455isFailureimpl(r121) == true) goto L36;
        r115 = r121;
    L36:
        Uri r122 = (Uri) r115;
        FLogger r123 = FLogger.f375446a;
        StringBuilder r124 = new StringBuilder("[startVideoResourceAccess] hasUri=");
        if (r118 != null) goto L39;
    L42:
        boolean r125 = true;
    L43:
        r124.append(!r125);
        r123.i("MultiAttachmentSelector", r124.toString());
        if (r122 == null) goto L68;
        if (r118 != null) goto L47;
    L50:
        boolean r126 = true;
    L51:
        if (r126 == true) goto L68;
        r110.f371973w.put(r116, r116);
        tx9.l0.d(r116);
        ResourceCenter r127 = ResourceCenter.f313541a;
        FlowResourceScene r128 = FlowResourceScene.CreationUserVideoV2;
        r127.getClass();
        ResourceCenter.k(r116, r128);
        CreationAlbumPipelinePrewarmer r129 = r110.V3();     // Catch: CancellationException -> L16 Throwable -> L64
        r100.L$0 = r111;     // Catch: CancellationException -> L16 Throwable -> L64
        r100.L$1 = r116;     // Catch: CancellationException -> L16 Throwable -> L64
        r100.L$2 = r122;     // Catch: CancellationException -> L16 Throwable -> L64
        r100.label = 1;     // Catch: CancellationException -> L16 Throwable -> L64
        Object r130 = r129.e(r116, r100);     // Catch: CancellationException -> L16 Throwable -> L64
        if (r130 == r103) goto L81;
        r109 = r116;
        r108 = r111;
        r105 = r122;
        r102 = r130;
        goto L78
    L81:
        return r103;
    L64:
        th = th;
        r106 = r116;
        goto L66
    L47:
        if (StringsKt.isBlank(r118) == true) goto L50;
        r126 = false;
    L68:
        com.larus.utils.t0.e(new v1(r110, r116));
        r110.T4(false, "upload", "video");
        nz9.b.e("creation_page/album_upload/video", "-101", r116);
        return Unit.INSTANCE;
    L39:
        if (StringsKt.isBlank(r118) == true) goto L42;
        r125 = false;
        goto L43
    L27:
        r120 = r118;
    L30:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L23:
        r118 = null;
    L16:
        e = move-exception;
        throw e;
    L7:
        r100 = new MultiAttachmentSelectorComponent$startVideoResourceAccess$1(r110, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C3(List<UplinkFileEntity> r510, ry9.j r511, ResourceItemBean r512) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[addVideoEntityToList] start, resourceItem.key: ");
        r101.append(r512.getKey());
        r101.append(", current entities size: ");
        ArrayList r102 = (ArrayList) r510;
        r101.append(r102.size());
        r100.i("MultiAttachmentSelector", r101.toString());
        ry9.i r103 = r511.a();
        if ((r103 instanceof ry9.i.b) == false) goto L5;
        ry9.i.b r104 = (ry9.i.b) r103;
    L6:
        if (r104 != null) goto L21;
        mt8.b r105 = r512.getVideo();
        if (r105 != null) goto L10;
    L20:
        r104 = null;
        goto L21
    L10:
        if (r105.f515654e == null) goto L20;
        String r110 = r512.getKey();
        mt8.b r106 = r512.getVideo();
        if (r106 == null) goto L14;
        String r111 = r106.f515654e;
    L15:
        String r112 = null;
        com.larus.bmhome.actionbar.model.f2 r113 = k4(r512.getKey());
        mt8.b r107 = r512.getVideo();
        if (r107 == null) goto L18;
        Double r114 = Double.valueOf(r107.f515651b);
    L19:
        String r108 = null;
        String r109 = null;
        ImageUploadInfo r115 = null;
        r104 = new ry9.i.b(new MediaAttachment(r108, r109, r115, new VideoUploadInfo(r112, r113, r114, 1, null), r111, r110, null, null, null, null == true ? 1 : 0, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_THREAD_BUSY_COUNT, null));
        goto L21
    L18:
        r114 = null;
        goto L19
    L14:
        r111 = null;
    L21:
        if (r104 == null) goto L25;
        MediaAttachment r116 = r104.f539934a;
        if (r116 == null) goto L25;
        String r117 = r116.getUri();
    L26:
        if (r104 == null) goto L30;
        MediaAttachment r118 = r104.f539934a;
        if (r118 == null) goto L30;
        String r119 = r118.getLocalFilePath();
    L31:
        if (r104 == null) goto L35;
        MediaAttachment r120 = r104.f539934a;
        if (r120 == null) goto L35;
        String r310 = r120.getIdentifier();
    L36:
        if (r104 == null) goto L40;
        MediaAttachment r121 = r104.f539934a;
        if (r121 == null) goto L40;
        String r122 = r121.getResourceId();
    L41:
        if (r104 == null) goto L45;
        MediaAttachment r123 = r104.f539934a;
        if (r123 == null) goto L45;
        VideoUploadInfo r124 = r123.getVideoUploadInfo();
    L46:
        StringBuilder r125 = new StringBuilder("[addVideoEntityToList] hasLocalFile=");
        boolean r210 = true;
        if (r119 != null) goto L49;
    L52:
        boolean r126 = true;
    L53:
        r125.append(!r126);
        r125.append(", hasRemoteKey=");
        if (r117 != null) goto L56;
    L59:
        boolean r127 = true;
    L60:
        r125.append(!r127);
        r100.i("MultiAttachmentSelector", r125.toString());
        if (r119 != null) goto L63;
    L66:
        boolean r128 = true;
    L67:
        int r211 = 100;
        if (r128 == false) goto L70;
    L144:
        String r129 = r119;
        if (r124 == null) goto L147;
        String r130 = r124.getVid();
    L149:
        if (com.larus.utils.o0.d(r130) == false) goto L199;
        String r212 = null;
        String r213 = null;
        Integer r214 = Integer.valueOf(FileType.FileTypeVideo.getValue());
        Long r215 = null;
        if (r124 == null) goto L153;
        String r131 = r124.getVid();
    L155:
        if (r124 == null) goto L159;
        com.larus.bmhome.actionbar.model.f2 r132 = r124.getCover();
        if (r132 == null) goto L159;
        String r311 = r132.f295145a;
    L160:
        String r312 = null;
        ImageObj r410 = null;
        if (r124 == null) goto L165;
        com.larus.bmhome.actionbar.model.f2 r133 = r124.getCover();
        if (r133 == null) goto L165;
        String r216 = r133.f295145a;
    L166:
        if (r124 == null) goto L172;
        com.larus.bmhome.actionbar.model.f2 r134 = r124.getCover();
        if (r134 == null) goto L172;
        Integer r135 = r134.f295147c;
        if (r135 == null) goto L172;
        int r217 = r135.intValue();
    L173:
        if (r124 == null) goto L179;
        com.larus.bmhome.actionbar.model.f2 r136 = r124.getCover();
        if (r136 == null) goto L179;
        Integer r137 = r136.f295148d;
        if (r137 == null) goto L179;
        int r218 = r137.intValue();
    L180:
        Image r138 = new Image(r311, r312, r410, new ImageObj(r216, r218, r217, null, null, 24, null), null, null, null, null, null, null, null, null, null, null, 16374, null);
        String r139 = null;
        String r140 = null;
        String r141 = null;
        if (r124 == null) goto L185;
        Double r142 = r124.getDuration();
        if (r142 == null) goto L185;
        Float r143 = Float.valueOf((float) r142.doubleValue());
    L186:
        mt8.b r144 = r512.getVideo();
        if (r144 == null) goto L189;
        Integer r145 = Integer.valueOf(r144.f515653d);
    L190:
        mt8.b r146 = r512.getVideo();
        if (r146 == null) goto L193;
        Integer r147 = Integer.valueOf(r146.f515652c);
    L195:
        if (Intrinsics.areEqual(r512.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L197;
        String r148 = "upload";
    L198:
        String r149 = r117;
        String r150 = r122;
        UplinkEntityContent r151 = new UplinkEntityContent(new UplinkFileInfo(r212, r149, r213, r214, r215, r150, new VideoExtension(r131, r129, r138, r139, r140, r141, r143, r145, r147, r148, 56, null), null, null, null, 917, null), null, 2, null == true ? 1 : 0);
        String r219 = r310;
        r102.add(new UplinkFileEntity(Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue()), r151, r219, null, Integer.valueOf(FileReviewState.DEFAULT.getValue()), Integer.valueOf(FileParseState.SUCCESS.getValue()), 100, Integer.valueOf(UpLinkState.SUCCESS.getValue()), null, false, null, null, null, null, 16136, null));
        r100.i("MultiAttachmentSelector", "[addVideoEntityToList] added remote video, entityCount=" + r102.size());
        return;
    L197:
        r148 = null;
        goto L198
    L193:
        r147 = null;
        goto L195
    L189:
        r145 = null;
    L185:
        r143 = null;
    L179:
        r218 = 0;
    L172:
        r217 = 0;
    L165:
        r216 = null;
    L159:
        r311 = null;
        goto L160
    L153:
        r131 = null;
        goto L155
    L199:
        r100.w("MultiAttachmentSelector", "[addVideoEntityToList] Remote video but videoUploadInfo?.vid is null or empty, skipped");
        return;
    L147:
        r130 = null;
        goto L149
    L70:
        if (new PolarisFileWrapper(r119).exists() == false) goto L144;
        ImFileUtil r152 = ImFileUtil.f314899a;
        PolarisFileWrapper r153 = new PolarisFileWrapper(r119);
        r152.getClass();
        String r220 = ImFileUtil.g(r153);
        int r221 = FileType.FileTypeVideo.getValue();
        long r222 = new PolarisFileWrapper(r119).length();
        if (r124 == null) goto L74;
        String r154 = r124.getVid();
    L76:
        if (r124 == null) goto L80;
        com.larus.bmhome.actionbar.model.f2 r155 = r124.getCover();
        if (r155 == null) goto L80;
        String r313 = r155.f295145a;
    L81:
        String r314 = null;
        ImageObj r411 = null;
        if (r124 == null) goto L86;
        com.larus.bmhome.actionbar.model.f2 r156 = r124.getCover();
        if (r156 == null) goto L86;
        String r223 = r156.f295145a;
    L87:
        if (r124 == null) goto L93;
        com.larus.bmhome.actionbar.model.f2 r157 = r124.getCover();
        if (r157 == null) goto L93;
        Integer r158 = r157.f295147c;
        if (r158 == null) goto L93;
        int r315 = r158.intValue();
    L94:
        if (r124 == null) goto L100;
        com.larus.bmhome.actionbar.model.f2 r159 = r124.getCover();
        if (r159 == null) goto L100;
        Integer r160 = r159.f295148d;
        if (r160 == null) goto L100;
        int r224 = r160.intValue();
    L101:
        ImageObj r412 = new ImageObj(r223, r224, r315, null, null, 24, null);
        String r413 = null;
        if (r124 == null) goto L106;
        com.larus.bmhome.actionbar.model.f2 r161 = r124.getCover();
        if (r161 == null) goto L106;
        String r414 = r161.f295146b;
    L107:
        Image r162 = new Image(r313, r314, r411, r412, r413, r414, null, null, null, null, null, null, null, null, 16342, null);
        String r163 = null;
        String r164 = null;
        if (r124 == null) goto L112;
        Double r165 = r124.getDuration();
        if (r165 == null) goto L112;
        Float r166 = Float.valueOf((float) r165.doubleValue());
    L113:
        mt8.b r167 = r512.getVideo();
        if (r167 == null) goto L116;
        Integer r168 = Integer.valueOf(r167.f515653d);
    L117:
        mt8.b r169 = r512.getVideo();
        if (r169 == null) goto L120;
        Integer r170 = Integer.valueOf(r169.f515652c);
    L122:
        if (Intrinsics.areEqual(r512.getExt().get("ext_creation_reference_do_same"), Boolean.TRUE) == true) goto L124;
        String r171 = "upload";
    L125:
        String r172 = r154;
        String r173 = r119;
        VideoExtension r225 = new VideoExtension(r172, r173, r162, r163, r164, null, r166, r168, r170, r171, 56, null);
        String r174 = r119;
        Image r175 = null;
        UplinkEntityContent r176 = new UplinkEntityContent(new UplinkFileInfo(null, r117, r220, Integer.valueOf(r221), Long.valueOf(r222), r122, r225, null, r174, null, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK, null), r175, 2, null == true ? 1 : 0);
        Integer r177 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        ExpiredInfo r178 = null;
        Integer r179 = Integer.valueOf(FileReviewState.DEFAULT.getValue());
        Integer r180 = Integer.valueOf(FileParseState.SUCCESS.getValue());
        if (r117 != null) goto L128;
    L131:
        boolean r181 = true;
    L132:
        if (r181 == false) goto L134;
        r211 = 0;
    L134:
        Integer r182 = Integer.valueOf(r211);
        if (r117 != null) goto L137;
    L140:
        if (r210 == false) goto L142;
        UpLinkState r183 = UpLinkState.PROCESSING;
    L143:
        r102.add(new UplinkFileEntity(r177, r176, r310, r178, r179, r180, r182, Integer.valueOf(r183.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r174)), null, null, null, 15112, null));
        r100.i("MultiAttachmentSelector", "[addVideoEntityToList] added local video, entityCount=" + r102.size());
        return;
    L142:
        r183 = UpLinkState.SUCCESS;
        goto L143
    L137:
        if (r117.length() == 0) goto L140;
        r210 = false;
        goto L140
    L128:
        if (r117.length() == 0) goto L131;
        r181 = false;
        goto L132
    L124:
        r171 = null;
        goto L125
    L120:
        r170 = null;
        goto L122
    L116:
        r168 = null;
    L112:
        r166 = null;
    L106:
        r414 = null;
    L100:
        r224 = 0;
    L93:
        r315 = 0;
    L86:
        r223 = null;
    L80:
        r313 = null;
        goto L81
    L74:
        r154 = null;
        goto L76
    L63:
        if (r119.length() == 0) goto L66;
        r128 = false;
        goto L67
    L56:
        if (StringsKt.isBlank(r117) == true) goto L59;
        r127 = false;
        goto L60
    L49:
        if (StringsKt.isBlank(r119) == true) goto L52;
        r126 = false;
    L45:
        r124 = null;
    L40:
        r122 = null;
    L35:
        r310 = null;
    L30:
        r119 = null;
    L25:
        r117 = null;
        goto L26
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.larus.uaigc.service.p0 E3(String r310, Uri r311, ResourceItemBean r312) {
        int r100 = com.larus.uaigc.service.p0.f373964x;
        com.larus.bmhome.resource.access.j0.a r101 = new com.larus.bmhome.resource.access.j0.a(r311.toString());
        ResourceCenter.f313541a.getClass();
        boolean r102 = ResourceCenter.d(r310);
        int r103 = UplinkEntityType.EntityTypeFile.getValue();
        String r104 = null;
        String r105 = null;
        String r106 = null;
        Integer r107 = Integer.valueOf(FileType.FileTypeVideo.getValue());
        Long r108 = null;
        String r109 = null;
        VideoExtension r110 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);
        mt8.b r111 = r312.getVideo();
        if (r111 == null) goto L5;
        String r112 = r111.f515654e;
    L6:
        r110.setPath(r112);
        mt8.b r113 = r312.getVideo();
        if (r113 == null) goto L9;
        Image r114 = r113.f515650a;
    L10:
        r110.setCover(r114);
        mt8.b r115 = r312.getVideo();
        if (r115 == null) goto L13;
        int r116 = Integer.valueOf(r115.f515652c);
    L14:
        r110.setWidth(r116);
        mt8.b r117 = r312.getVideo();
        if (r117 == null) goto L17;
        int r118 = Integer.valueOf(r117.f515653d);
    L18:
        r110.setHeight(r118);
        r110.setSource("upload");
        Unit r119 = Unit.INSTANCE;
        Object[] r120 = null == true ? 1 : 0;
        UplinkEntityContent r121 = new UplinkEntityContent(new UplinkFileInfo(r104, r105, r106, r107, r108, r109, r110, null, null, null, 951, null), r120, 2, null == true ? 1 : 0);
        ExpiredInfo r210 = null;
        Integer r211 = null;
        Integer r212 = null;
        mr9.h r122 = new mr9.h(r102, null, new UplinkFileEntity(Integer.valueOf(r103), r121, r310, r210, r211, null, r212, null, null, false, r311, null, null, null, 15352, null), 26);
        CountDownLatch r123 = new CountDownLatch(1);
        String r124 = r312.getFileSuffixes();
        Boolean r125 = Boolean.TRUE;
        ys8.a r126 = d4();
        if (r126 == null) goto L21;
        com.larus.bmhome.actionbar.model.e2 r127 = r126.tQ();
    L22:
        if (r127 == null) goto L26;
        Long r128 = r127.f295096d;
        if (r128 == null) goto L26;
        long r129 = r128.longValue();
    L27:
        Map r130 = MapsKt.mapOf(TuplesKt.to("video_max_duration_seconds", String.valueOf(r129)));
        com.larus.bmhome.resource.access.d0 r131 = com.larus.uaigc.service.g.f373960a;
        return com.larus.uaigc.service.p0.a.f(r101, r310, r122, r123, r124, r125, r130, LifecycleOwnerKt.getLifecycleScope(this), AVMDLDataLoader.KeyIsPreloadTraceIdRecordMaxCntI32);
    L26:
        r129 = 0;
        goto L27
    L21:
        r127 = null;
        goto L22
    L17:
        r118 = 0;
        goto L18
    L13:
        r116 = 0;
        goto L14
    L9:
        r114 = null;
        goto L10
    L5:
        r112 = null;
        goto L6
    }

    @Override // ry9.h
    public final void Ke(final String r110, MediaAttachment r111, final boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "resourceKey");
        Intrinsics.checkNotNullParameter(r111, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT);
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L12;
        this.A.put(r110, r111);
        String r100 = r111.getIdentifier();
        if (r100 == null) goto L12;
        if ((!StringsKt.isBlank(r100)) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        String r101 = this.f371973w.putIfAbsent(r110, r100);
    L12:
        String r102 = r111.getLocalFilePath();
        if (r102 != null) goto L16;
        r102 = "";
    L16:
        if (new PolarisFileWrapper(r102).exists() == false) goto L18;
        final ry9.j.c r103 = new ry9.j.c(new ry9.i.b(r111));
        com.larus.utils.t0.e(new z1(this, r110, r103, r112));
        return;
    L18:
        com.larus.utils.t0.e(new a2(this, r110, r112));
        this.E.put(r110, AlbumHelperKt.g(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), new MultiAttachmentSelectorComponent$triggerVideoDownloadAndExplain$5(r111, r112, this, r110, null), 2));
    }

    public final void T4(boolean r510, String r511, String r512) {
        ny9.s r100 = W3();
        String r101 = null;
        if (r100 == null) goto L7;
        Bundle r102 = r100.f521269a;
        if (r102 == null) goto L7;
        String r103 = r102.getString("open_from", "");
    L8:
        boolean r104 = false;
        if (Intrinsics.areEqual(r103, "slides") == false) goto L48;
        ny9.s r105 = W3();
        if (r105 == null) goto L15;
        Bundle r106 = r105.f521269a;
        if (r106 == null) goto L15;
        String r107 = r106.getString("slides_mob_config", "");
    L16:
        if (r107 != null) goto L18;
    L19:
        r104 = true;
    L20:
        if (r104 == false) goto L121;
    L26:
        lr9.a r108 = null;
    L27:
        if (r510 == false) goto L29;
        String r110 = "1";
    L30:
        if (r108 == null) goto L32;
        String r410 = r108.e();
    L33:
        if (r108 == null) goto L35;
        String r411 = r108.f();
    L36:
        if (r108 == null) goto L38;
        Integer r412 = r108.g();
    L39:
        if (r108 == null) goto L41;
        String r413 = r108.b();
    L42:
        if (r108 == null) goto L44;
        Integer r414 = r108.c();
    L45:
        if (r108 == null) goto L47;
        r101 = r108.a();
    L47:
        tx9.y3.a(null, "aippt_new_detail", null, null, null, null, r110, null, null, "image_generate_page", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "aippt_new", r410, r411, r412, r413, r414, r101, null, null, null, null, null, null, null, -2115, 65027);
        return;
    L44:
        r414 = null;
        goto L45
    L41:
        r413 = null;
        goto L42
    L38:
        r412 = null;
        goto L39
    L35:
        r411 = null;
        goto L36
    L32:
        r410 = null;
        goto L33
    L29:
        r110 = "0";
        goto L30
    L121:
        r108 = (lr9.a) new Gson().fromJson(r107, lr9.a.class);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        FLogger.f375446a.e("MultiAttachmentSelector", "getSlidesMobConfig error", e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        goto L26
    L18:
        if (r107.length() != 0) goto L20;
    L15:
        r107 = null;
        goto L16
    L48:
        ny9.s r109 = W3();
        if (r109 == null) goto L53;
        ICoreInputAbility.SendMessageTrackExtMap r111 = r109.n();
        if (r111 == null) goto L53;
        Map<String, String> r112 = r111.f298404a;
    L54:
        ny9.u r113 = c4();
        if (r113 == null) goto L57;
        String r114 = r113.getClickFrom();
    L58:
        ny9.u r115 = c4();
        if (r115 == null) goto L61;
        String r116 = r115.m();
    L62:
        ny9.u r117 = c4();
        if (r117 == null) goto L65;
        String r210 = r117.i();
    L66:
        ny9.u r118 = c4();
        if (r118 == null) goto L69;
        String r211 = r118.c();
    L70:
        uy9.a r119 = (uy9.a) this.f371968r.getValue();
        if (r119 == null) goto L73;
        r119.Rq();
        String r120 = "template_page";
    L74:
        if (r120 != null) goto L76;
    L79:
        boolean r121 = true;
    L80:
        if (r121 == true) goto L82;
    L94:
        String r122 = r120;
    L95:
        uy9.a r123 = (uy9.a) this.f371968r.getValue();
        if (r123 == null) goto L98;
        String r124 = r123.PG();
    L99:
        ny9.u r125 = c4();
        if (r125 == null) goto L102;
        String r212 = r125.getEnterMethod();
    L103:
        ny9.u r126 = c4();
        if (r126 == null) goto L106;
        String r127 = r126.getBotId();
    L107:
        if (r510 == false) goto L109;
        String r128 = "1";
    L110:
        IAIChatControlTraceService.Companion r129 = IAIChatControlTraceService.f365889a;
        String r213 = r129.h(r129.gb());
        if (r112 == null) goto L113;
        String r310 = r112.get("from_template_id");
    L114:
        if (r112 == null) goto L116;
        String r311 = r112.get("from_template_sub_type");
    L117:
        if (r112 == null) goto L119;
        r101 = r112.get("template_rec_req_id");
    L119:
        tx9.y3.a(r127, r122, r124, r511, r512, null, r128, null, null, r114, null, r116, r210, r211, null, r212, null, r213, null, null, null, null, null, null, null, null, r310, r311, null, null, r101, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -806021216, 65533);
        return;
    L116:
        r311 = null;
        goto L117
    L113:
        r310 = null;
        goto L114
    L109:
        r128 = "0";
        goto L110
    L106:
        r127 = null;
        goto L107
    L102:
        r212 = null;
        goto L103
    L98:
        r124 = null;
        goto L99
    L82:
        if ((getContext() instanceof ny9.i) == true) goto L85;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof ny9.i) == true) goto L85;
    L86:
        if (r104 == false) goto L94;
        ny9.s r130 = W3();
        if (r130 == null) goto L93;
        Bundle r131 = r130.f521269a;
        if (r131 == null) goto L92;
        r120 = r131.getString("previous_page_name");
        goto L94
    L92:
        r120 = null;
        goto L94
    L93:
        r122 = null;
    L85:
        r104 = true;
        goto L86
    L76:
        if (r120.length() == 0) goto L79;
        r121 = false;
        goto L80
    L73:
        r120 = null;
        goto L74
    L69:
        r211 = null;
        goto L70
    L65:
        r210 = null;
        goto L66
    L61:
        r116 = null;
        goto L62
    L57:
        r114 = null;
    L53:
        r112 = null;
    L7:
        r103 = null;
        goto L8
    }

    public final void f5(final String r210, String r211, ic8.m0 r212) {
        PolarisFileWrapper r100 = w5(r211);
        if (r100 != null) goto L21;
        FLogger.f375446a.w("MultiAttachmentSelector", "[parseUriAndStartUpload] local file invalid");
        com.larus.utils.t0.e(new i2(this, r210));
        T4(false, "upload", "pic");
        nz9.b.e(y5(r210), "-101", r210);
        return;
    L21:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Uri.fromFile(r100));     // Catch: Throwable -> L8
    L11:
        if (Result.m9456isSuccessimpl(r102) == false) goto L18;
        Uri r103 = (Uri) r102;
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L15;
        this.f371973w.putIfAbsent(r210, r210);
        String r104 = (String) MapsKt.getValue(this.f371973w, r210);
    L16:
        Job r105 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new MultiAttachmentSelectorComponent$parseUriAndStartUpload$3$uploadJob$1(r104, this, r210, r100, r212, null), 2, null);
        this.E.put(r210, r105);
        goto L18
    L15:
        r104 = null;
    L18:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L23;
        com.larus.utils.t0.e(new j2(this, r210));
        T4(false, "upload", "pic");
        return;
    L23:
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // ry9.h
    public final void uz(String r110, String r111, ic8.m0 r112) {
        Intrinsics.checkNotNullParameter(r110, "resourceKey");
        Intrinsics.checkNotNullParameter(r111, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$triggerUploadAndCheck$1(this, r110, r111, r112, null), 3, null);
    }

    @Override // ry9.h
    public final void w60(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "resourceKey");
        Intrinsics.checkNotNullParameter(r111, "localResPath");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$handleAttachmentRemove$1(this, r110, r112, r111, null), 3, null);
    }

    @Override // ry9.h
    public final void xz(String r100, int r101, boolean r102) {
        this.R = r100;
        this.S = r101;
        ry9.h.a.a(this, j4(), r102, 0, 60);
    }

    public static final Object z3(MultiAttachmentSelectorComponent r100, kq9.d r110, String r111, Continuation r112) {
        r100.getClass();
        if ((r112 instanceof MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1) == false) goto L7;
        MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1 r101 = (MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1 r103 = r101;
        Object r113 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L19;
        if (r105 == 1) goto L18;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r113);
    L51:
        return r113;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r111 = (String) r103.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        String r106 = r111;
        String r114 = (String) r113;
        if (r114 == null) goto L53;
        PolarisFileWrapper r115 = w5(r114);
        if (r115 == null) goto L53;
        String r116 = r100.f371961J;
        if (r116 != null) goto L47;
        int r117 = wf9.b.f559489a;
        r116 = com.flow.kmp.common.util.i.a();
        r100.f371961J = r116;
        r100.L = r116;
    L47:
        String r107 = r116;
        ResourceCenter r118 = ResourceCenter.f313541a;
        FlowResourceScene r119 = FlowResourceScene.ImageVLM;
        r118.getClass();
        ResourceCenter.k(r106, r119);
        String r120 = r115.getAbsolutePath();
        r103.L$0 = null;
        r103.label = 3;
        r113 = r100.R5(r120, r106, r107, null, null, r103);
        if (r113 != r104) goto L51;
        return r104;
    L53:
        return null;
    L18:
        Uri r121 = (Uri) r103.L$1;
        r111 = (String) r103.L$0;
        ResultKt.throwOnFailure(r113);
    L31:
        ResourceItemBean r122 = (ResourceItemBean) r113;
        if (r122 == null) goto L53;
        ResourceCenter r108 = ResourceCenter.f313541a;
        FlowResourceScene r109 = FlowResourceScene.CreationUserVideoV2;
        r108.getClass();
        ResourceCenter.k(r111, r109);
        return ICreationResourceAccessService.f373925a.b(r100.E3(r111, r121, r122));
    L19:
        ResultKt.throwOnFailure(r113);
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L53;
        Uri r123 = r110.f505616a.f365506a;
        if (r123 == null) goto L53;
        if (r110.f505617b != AlbumSelectionMediaType.VIDEO) goto L35;
        CoroutineDispatcher r124 = Dispatchers.getIO();
        MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1 r125 = new MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$bean$1(r123, r111, null);
        r103.L$0 = r111;
        r103.L$1 = r123;
        r103.label = 1;
        Object r126 = BuildersKt.withContext(r124, r125, r103);
        if (r126 == r104) goto L54;
        r113 = r126;
        r121 = r123;
        goto L31
    L54:
        return r104;
    L35:
        CoroutineDispatcher r127 = Dispatchers.getIO();
        MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$localResPath$1 r128 = new MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$localResPath$1(r100, r123, null);
        r103.L$0 = r111;
        r103.label = 2;
        r113 = BuildersKt.withContext(r127, r128, r103);
        if (r113 != r104) goto L17;
        return r104;
    L7:
        r101 = new MultiAttachmentSelectorComponent$submitAlbumSelectionPrewarm$1(r100, r112);
        goto L8
    }

    public final void B4(final String r310, ResourceItemBean r311, String r410, Map<String, String> r411) {
        mt8.b r100 = r311.getVideo();
        if (r100 == null) goto L59;
        String r101 = r411.get("video_cover_key");
        if (r101 != null) goto L7;
        String r110 = "";
    L8:
        String r102 = r411.get("video_cover_local_path");
        if (r102 != null) goto L11;
        String r210 = "";
    L13:
        if (StringsKt.isBlank(r110) == true) goto L15;
    L20:
        String r312 = null;
        String r103 = r411.get("video_cover_width");
        if (r103 == null) goto L25;
        Integer r104 = StringsKt.toIntOrNull(r103);
        if (r104 == null) goto L25;
        int r313 = r104.intValue();
    L26:
        String r105 = r411.get("video_cover_height");
        if (r105 == null) goto L31;
        Integer r106 = StringsKt.toIntOrNull(r105);
        if (r106 == null) goto L31;
        int r314 = r106.intValue();
    L32:
        String r111 = null;
        ImageObj r112 = null;
        Image r107 = new Image(r110, r111, r112, new ImageObj(r312, r313, r314, null, null, 25, null), null, r210, null, null, null, null, null, null, null, null, 16342, null);
    L33:
        String r108 = r411.get("video_duration_ms");
        if (r108 == null) goto L38;
        Long r109 = StringsKt.toLongOrNull(r108);
        if (r109 == null) goto L38;
        long r113 = r109.longValue();
    L39:
        float r114 = r113 / 1000.0f;
        String r115 = r411.get("video_width");
        if (r115 == null) goto L44;
        Integer r116 = StringsKt.toIntOrNull(r115);
        if (r116 == null) goto L44;
        int r117 = r116.intValue();
    L48:
        String r118 = r411.get("video_height");
        if (r118 == null) goto L53;
        Integer r119 = StringsKt.toIntOrNull(r118);
        if (r119 == null) goto L53;
        int r120 = r119.intValue();
    L56:
        int r121 = r120;
    L58:
        mt8.b r122 = mt8.b.a(r100, r107, r114, r117, r121, r410, null, null, null, null, 480);
    L60:
        final ResourceItemBean r123 = AlbumHelperKt.c(r311, null, r122, 1);
        com.larus.uaigc.helper.f.f373014a.getClass();
        Boolean r124 = com.larus.uaigc.helper.f.c().d();
        Boolean r125 = Boolean.TRUE;
        if (Intrinsics.areEqual(r124, r125) == false) goto L63;
        r123.getExt().put("ext_silent_upload", r125);
    L63:
        this.f371975y.put(r310, r123);
        com.larus.utils.t0.e(new x2(this, r310, r123));
        return;
    L53:
        mt8.b r126 = r311.getVideo();
        if (r126 == null) goto L57;
        r120 = r126.f515653d;
        goto L56
    L57:
        r121 = 0;
    L44:
        mt8.b r127 = r311.getVideo();
        if (r127 == null) goto L47;
        r117 = r127.f515652c;
        goto L48
    L47:
        r117 = 0;
    L38:
        r113 = 0;
    L31:
        r314 = 0;
    L25:
        r313 = 0;
        goto L26
    L15:
        if (StringsKt.isBlank(r210) == false) goto L20;
        mt8.b r128 = r311.getVideo();
        if (r128 == null) goto L19;
        r107 = r128.f515650a;
        goto L33
    L19:
        r107 = null;
        goto L33
    L11:
        r210 = r102;
        goto L13
    L7:
        r110 = r101;
        goto L8
    L59:
        r122 = null;
        goto L60
    }

    public final Object F4(ResourceItemBean r110, ResourceUploadError r111, String r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1) == false) goto L7;
        MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1 r100 = (MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        String r115 = (String) r100.L$2;
        r111 = (ResourceUploadError) r100.L$1;
        ResourceItemBean r116 = (ResourceItemBean) r100.L$0;
        ResultKt.throwOnFailure(r114);
        r112 = r115;
        r110 = r116;
    L27:
        T4(false, "upload", "video");
        nz9.b.e("creation_page/album_upload/video", "-101", r110.getKey());
    L29:
        tx9.l0.c("video_edit", r110.getKey(), false, Boxing.boxLong(new PolarisFileWrapper(r112).length() / ((long) 1000)), mr9.i.a(r111.getCode()));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        FLogger.f375446a.w("MultiAttachmentSelector", "[handleVideoResourceAccessFail] errorCode=" + r111.getCode());
        String r117 = r111.getCode();
        ProcessFileResultCode[] r104 = ProcessFileResultCode.values();
        int r105 = r104.length;
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L21;
        ProcessFileResultCode r107 = r104[r106];
        if (Intrinsics.areEqual(r107.getValue(), r117) == true) goto L23;
        r106 = r106 + 1;
    L23:
        if (CollectionsKt.contains(SetsKt.setOf(new ProcessFileResultCode[]{ProcessFileResultCode.PREPARE_FILE_NOT_FOUND, ProcessFileResultCode.PREPARE_OVER_STORAGE_FREE_SPACE, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR, ProcessFileResultCode.PREPARE_RES_NOT_FOUND, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH, ProcessFileResultCode.PREPARE_OVER_SIZE, ProcessFileResultCode.PREPARE_OVER_DURATION, ProcessFileResultCode.PREPARE_OVER_META_LIMIT}), r107) == false) goto L28;
        ic8.n0 r118 = new ic8.n0(null, r107);
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r112;
        r100.label = 1;
        if (U5(r110, r118, true, r100) != r102) goto L27;
        return r102;
    L28:
        p4(r111, r110.getKey());
        goto L29
    L21:
        r107 = null;
    L7:
        r100 = new MultiAttachmentSelectorComponent$handleVideoResourceAccessFail$1(this, r113);
        goto L8
    }

    public final Object U5(ResourceItemBean r100, ic8.n0 r110, boolean r111, Continuation<? super Unit> r112) {
        Object r101 = BuildersKt.withContext(Dispatchers.getMain(), new MultiAttachmentSelectorComponent$toastVideoCheckFailed$2(r110, r111, this, r100, null), r112);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final void v4(String r310, mr9.l r410, String r411, final String r412) {
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L6;
        E5(r412, "creation_page/album_upload/video");
        nz9.b.e("upload", "0", r412);
        this.F.remove(r412);
    L6:
        if (this.E.get(r412) != null) goto L8;
        return;
    L8:
        ResourceItemBean r100 = this.f371975y.get(r412);
        if (r100 == null) goto L11;
        mt8.b r101 = r100.getVideo();
    L12:
        mr9.n r102 = r410.f515026e;
        if (r102 == null) goto L15;
        mr9.e r103 = r102.f515031c;
    L16:
        boolean r104 = false;
        if (r103 == null) goto L29;
        Integer r110 = r103.j();
        if (r110 == null) goto L29;
        if (r110.intValue() <= 0) goto L23;
        boolean r111 = true;
    L24:
        if (r111 == true) goto L27;
        r110 = null;
    L27:
        if (r110 == null) goto L29;
        int r112 = r110.intValue();
    L31:
        int r113 = r112;
    L33:
        if (r103 == null) goto L45;
        Integer r114 = r103.h();
        if (r114 == null) goto L45;
        if (r114.intValue() <= 0) goto L39;
        boolean r115 = true;
    L40:
        if (r115 == true) goto L43;
        r114 = null;
    L43:
        if (r114 == null) goto L45;
        int r116 = r114.intValue();
    L47:
        int r117 = r116;
    L49:
        if (r103 == null) goto L61;
        Long r105 = r103.d();
        if (r105 == null) goto L61;
        if (r105.longValue() <= 0) goto L55;
        boolean r118 = true;
    L56:
        if (r118 == true) goto L59;
        r105 = null;
    L59:
        if (r105 == null) goto L61;
        double r106 = r105.longValue() / 1000.0d;
    L71:
        double r119 = r106;
        if (r100 == null) goto L75;
        if (r101 == null) goto L75;
        boolean r107 = true;
        final ResourceItemBean r108 = AlbumHelperKt.c(r100, null, mt8.b.a(r101, null, (float) r119, r113, r117, null, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_SET_FIRST_FRAME_MILLISECOND), 1);
    L76:
        if (r108 == null) goto L78;
        this.f371975y.put(r412, r108);
    L78:
        String r210 = null;
        String r109 = r410.f515022a;
        ImageUploadInfo r211 = null;
        mr9.n r120 = r410.f515026e;
        if (r120 == null) goto L81;
        String r121 = r120.f515029a;
    L82:
        com.larus.bmhome.actionbar.model.f2 r122 = k4(r310);
        FLogger.f375446a.i("MultiAttachmentSelector", "[handleUploadVideoSuccess] coverReady=true");
        Unit r123 = Unit.INSTANCE;
        final ry9.j.c r124 = new ry9.j.c(new ry9.i.b(new MediaAttachment(r210, r109, r211, new VideoUploadInfo(r121, r122, Double.valueOf(r119)), r411, r310, r410.f515024c, null, null, null, null, null, 3973, null)));
        com.larus.utils.t0.e(new z2(r108, this, r412, r124));
        T4(r107, null, "video");
        nz9.b.e("creation_page/album_upload/video", "0", r412);
        return;
    L81:
        r121 = null;
    L75:
        r107 = true;
        r108 = null;
        goto L76
    L55:
        r118 = false;
    L61:
        if (r101 == null) goto L70;
        Float r125 = Float.valueOf(r101.f515651b);
        if (r125.floatValue() <= 0.0f) goto L65;
        r104 = true;
    L65:
        if (r104 == true) goto L68;
        r125 = null;
    L68:
        if (r125 == null) goto L70;
        r106 = r125.floatValue();
    L70:
        r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L71
    L39:
        r115 = false;
    L45:
        if (r101 == null) goto L48;
        r116 = r101.f515653d;
        goto L47
    L48:
        r117 = 0;
        goto L49
    L23:
        r111 = false;
    L29:
        if (r101 == null) goto L32;
        r112 = r101.f515652c;
        goto L31
    L32:
        r113 = 0;
        goto L33
    L15:
        r103 = null;
        goto L16
    L11:
        r101 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v15, types: [T, java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v22 */
    public static final Object h3(final MultiAttachmentSelectorComponent r110, final com.larus.bmhome.resource.access.b0 r111, final ResourceItemBean r210, final String r211, Continuation r212) {
        r110.getClass();
        if ((r212 instanceof MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1) == false) goto L7;
        MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1 r100 = (MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1 r102 = r100;
        Object r103 = r102.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r103);
    L93:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
    L94:
        return Unit.INSTANCE;
    L17:
        Ref.BooleanRef r105 = (Ref.BooleanRef) r102.L$3;
        Ref.ObjectRef r106 = (Ref.ObjectRef) r102.L$2;
        String r107 = (String) r102.L$1;
        ResourceItemBean r108 = (ResourceItemBean) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L28:
        com.larus.bmhome.resource.access.a0 r109 = (com.larus.bmhome.resource.access.a0) r103;
        if ((r109 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L73;
        if (r105.element == true) goto L57;
        com.larus.bmhome.resource.access.a0.d r113 = (com.larus.bmhome.resource.access.a0.d) r109;
        String r114 = r113.f313618a.f313648f.get("preprocess_result");
        if (r114 != null) goto L35;
    L38:
        boolean r115 = true;
    L39:
        if (r115 == true) goto L57;
        com.larus.bmhome.resource.access.j0 r116 = r113.f313618a.f313644b;
        if ((r116 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L43;
        com.larus.bmhome.resource.access.j0.b r117 = (com.larus.bmhome.resource.access.j0.b) r116;
    L44:
        if (r117 == null) goto L53;
        String r118 = r117.f313690b;
        if (r118 == null) goto L53;
        boolean r119 = !StringsKt.isBlank(r118);
        ?? r120 = r118;
        if (r119 == true) goto L51;
        r120 = 0;
    L51:
        if (r120 == 0) goto L53;
    L55:
        if ((!StringsKt.isBlank(r120)) == false) goto L57;
        r106.element = r120;
        r110.B4(r107, r108, r120, r113.f313618a.f313648f);
    L53:
        r120 = (String) r106.element;
        goto L55
    L43:
        r117 = null;
        goto L44
    L35:
        if (StringsKt.isBlank(r114) == true) goto L38;
        r115 = false;
    L57:
        mr9.l r121 = ICreationResourceAccessServiceKt.h(r109);
        if (r121 != null) goto L63;
        ResourceUploadError r122 = new ResourceUploadError("empty_upload_result", "upload result is null");
        String r123 = (String) r106.element;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.label = 2;
        if (r110.F4(r108, r122, r123, r102) != r112) goto L94;
        return r112;
    L63:
        FLogger.f375446a.i("MultiAttachmentSelector", "[observeVideoResourceAccessTask] success");
        r110.G.remove(r107);
        r110.v4(r107, r121, (String) r106.element, r107);
        mr9.n r124 = r121.f515026e;
        if (r124 == null) goto L70;
        mr9.e r125 = r124.f515031c;
        if (r125 == null) goto L70;
        Long r126 = r125.i();
        if (r126 == null) goto L70;
        long r127 = r126.longValue();
    L71:
        tx9.l0.c("video_edit", r107, true, Boxing.boxLong(r127 / ((long) 1000)), null);
    L70:
        r127 = new PolarisFileWrapper((String) r106.element).length();
        goto L71
    L73:
        if ((r109 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L87;
        if ((r109 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L87;
        if (Intrinsics.areEqual(r109, com.larus.bmhome.resource.access.a0.b.f313616a) == true) goto L93;
        if ((r109 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L93;
        if ((r109 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L93;
        throw new NoWhenBranchMatchedException();
    L87:
        if (ICreationResourceAccessServiceKt.d(r109) == false) goto L89;
        FLogger.f375446a.i("MultiAttachmentSelector", "[observeVideoResourceAccessTask] page destroy cancel");
        return Unit.INSTANCE;
    L89:
        ResourceUploadError r128 = ICreationResourceAccessServiceKt.g(r109);
        String r129 = (String) r106.element;
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.label = 3;
        if (r110.F4(r108, r128, r129, r102) != r112) goto L93;
        return r112;
    L18:
        ResultKt.throwOnFailure(r103);
        final Ref.ObjectRef r130 = new Ref.ObjectRef();
        mt8.b r131 = r210.getVideo();
        if (r131 == null) goto L21;
        ?? r132 = r131.f515654e;
    L22:
        if (r132 != 0) goto L24;
        r132 = "";
    L24:
        r130.element = r132;
        final Ref.BooleanRef r133 = new Ref.BooleanRef();
        Function1 r134 = new x1(r111, r110, r211, r130, r210, r133);
        Function1 r135 = new y1(r110, r211);
        r102.L$0 = r210;
        r102.L$1 = r211;
        r102.L$2 = r130;
        r102.L$3 = r133;
        r102.label = 1;
        r103 = CreationResourceAccessPerfBridgeKt.a(r111, "creation_page/album_upload/video", r211, r211, r134, r135, r102);
        if (r103 == r112) goto L96;
        r108 = r210;
        r107 = r211;
        r106 = r130;
        r105 = r133;
        goto L28
    L96:
        return r112;
    L21:
        r132 = 0;
    L7:
        r100 = new MultiAttachmentSelectorComponent$observeVideoResourceAccessTask$1(r110, r212);
        goto L8
    }

    @Override // ry9.h
    public final void YL(final int r110, final boolean r111, final int r112, final int r210, final ry9.d r211) {
        com.larus.bmhome.actionbar.model.w0 r100 = Z3();
        if ((r100 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L10;
        wa8.d1 r101 = ((com.larus.bmhome.actionbar.model.w0.a) r100).f295535a;
        if (r101.a(CreationReferenceMediaType.IMAGE) == false) goto L7;
    L11:
        com.larus.bmhome.actionbar.model.w0 r102 = Z3();
        if ((r102 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L18;
        if (((com.larus.bmhome.actionbar.model.w0.a) r102).f295535a.a(CreationReferenceMediaType.VIDEO) == false) goto L19;
        if (r210 <= 0) goto L19;
        final boolean r103 = true;
    L20:
        if (r103 == true) goto L22;
    L25:
        d5(r110, r111, r112, r103, r210, r211);
        return;
    L22:
        if (com.larus.platform.service.k2.f365755a.q() == false) goto L25;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.platform.api.g3.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), null, false, Boolean.TRUE, false, new b2(this, r110, r111, r112, r103, r210, r211), 22);
        return;
    L19:
        r103 = false;
        goto L20
    L18:
        if (Intrinsics.areEqual(r102, com.larus.bmhome.actionbar.model.w0.b.f295536a) == true) goto L19;
        throw new NoWhenBranchMatchedException();
    L7:
        if (r101.a(CreationReferenceMediaType.VIDEO) == true) goto L11;
        return;
    L10:
        if (Intrinsics.areEqual(r100, com.larus.bmhome.actionbar.model.w0.b.f295536a) == true) goto L11;
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Failed to calculate best type for var: r0v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v16 ??, new type: ny9.s
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v16 ??, new type: ny9.s
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v18 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v18 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v18 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v19 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v19 ??, new type: java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v22 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v22 ??, new type: ny9.u
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v23 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v23 ??, new type: ny9.u
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v24 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v24 ??, new type: ny9.u
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v25 ??, new type: ny9.u
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v29 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v29 ??, new type: java.lang.Integer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v30 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v30 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v31 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v31 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v32 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v33 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v33 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v34 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v34 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v35 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v35 ??, new type: android.os.Bundle
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v36 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v36 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v2 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v2 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v3 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v3 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v5 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r12v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r12v6 ??, new type: com.larus.bmhome.actionbar.model.z0
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r17v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r17v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r17v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r18v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r18v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r18v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r19v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r19v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r19v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r19v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r21v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r21v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r21v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r24v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r24v1 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r24v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r24v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r24v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r24v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r25v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v2 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r25v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v3 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r25v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r25v4 ??, new type: java.lang.String
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r41v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r41v0 'this'  ??, new type: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r41v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r41v0 'this'  ??, new type: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v18 ??, new type: java.lang.CharSequence
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderAllow(TypeUpdate.java:66)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryWiderObjects(FixTypesVisitor.java:795)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:249)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public final java.lang.Object h5(java.lang.String r42, android.graphics.Bitmap r43, boolean r44, boolean r45, kotlin.coroutines.Continuation<? super kotlin.Unit> r46) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01bb: INVOKE (r0v16 ?? I:ny9.s) = 
              (r41v0 'this' ?? I:com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent A[IMMUTABLE_TYPE, THIS])
             VIRTUAL call: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent.W3():ny9.s A[DECLARE_VAR, MD:():ny9.s (m)] (LINE:83886523) in method: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent.h5(java.lang.String, android.graphics.Bitmap, boolean, boolean, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: classes31.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent.h5(java.lang.String, android.graphics.Bitmap, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void l4(String r110, String r111, String r112, boolean r113, boolean r114) {
        tx9.l0.b("creation_page_passed_image_re_upload", r110, false, mr9.i.a(r111), null, null, 48);
        int r100 = com.larus.uaigc.service.e.f373956a;
        if (Intrinsics.areEqual(r111, "review_un_pass") == false) goto L5;
        T4(false, "review", "pic");
        ry9.j r101 = ry9.j.d.f539939b;
    L6:
        e4(r110).setValue(new ry9.k(r110, r101, 0, r113, r114, false, 36));
        nz9.b.e("creation_page/re_upload", r111, r110);
        FLogger.f375446a.e("MultiAttachmentSelector", "[handleRemoteResourceAccessFail] errorCode=" + r111 + ", errorMessage=" + r112);
        return;
    L5:
        T4(false, "upload", "pic");
        r101 = ry9.j.f.f539941b;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final mr9.h D3(String r410, String r411, String r412, String r413, ic8.m0 r414, Pair<Integer, Integer> r415) {
        boolean r100 = false;
        if (r410.length() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
        ResourceCenter.f313541a.getClass();
        boolean r110 = ResourceCenter.d(r410);
        String r102 = com.larus.platform.service.o.f365780a.getDeviceId();
        String r111 = x5();
        ny9.s r103 = W3();
        if (r103 == null) goto L17;
        Bundle r104 = r103.b();
        if (r104 == null) goto L15;
        String r105 = r104.getString("chat_section_id");
    L16:
        String r112 = r105;
    L18:
        ResourceAttachmentExtra r106 = new ResourceAttachmentExtra(r102, r412, r111, r112, r411);
        if (r415 != null) goto L26;
        BitmapFactory.Options r107 = new BitmapFactory.Options();
        r107.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r413, r107);
        int r108 = r107.outWidth;
        if (r108 > 0) goto L23;
    L25:
        Pair<Integer, Integer> r109 = null;
    L27:
        int r113 = UplinkEntityType.EntityTypeImage.getValue();
        Uri r210 = Uri.fromFile(new PolarisFileWrapper(r413));
        if (r414 == null) goto L31;
        String r114 = r414.f489228f;
        if (r114 == null) goto L31;
    L32:
        String r115 = r114;
        if (r109 == null) goto L35;
        ImageObj r116 = new ImageObj(null, r109.component1().intValue(), r109.component2().intValue(), null, null, 25, null);
    L36:
        if (r414 != null) goto L38;
    L40:
        if (r100 == false) goto L42;
        String r117 = "1";
    L43:
        ImageObj r118 = r116;
        UplinkFileInfo r119 = null;
        return new mr9.h(r110, r106, new UplinkFileEntity(Integer.valueOf(r113), new UplinkEntityContent(r119, new Image(null, r115, null, r118, null, r413, r410, MapsKt.mapOf(TuplesKt.to("is_marked", r117)), 0 == true ? 1 : 0, null, null, null, null, 0 == true ? 1 : 0, 16149, null), 1, 0 == true ? 1 : 0), r410, null, null, null, null, null, null, false, r210, null, null, null, 15352, null), 24);
    L42:
        r117 = "0";
        goto L43
    L38:
        if (r414.f489231i != true) goto L40;
        r100 = true;
        goto L40
    L35:
        r116 = null;
    L31:
        ImFileUtil r120 = ImFileUtil.f314899a;
        PolarisFileWrapper r121 = new PolarisFileWrapper(r413);
        r120.getClass();
        r114 = ImFileUtil.g(r121);
        goto L32
    L23:
        if (r107.outHeight <= 0) goto L25;
        r109 = TuplesKt.to(Integer.valueOf(r108), Integer.valueOf(r107.outHeight));
        goto L27
    L26:
        r109 = r415;
        goto L27
    L15:
        r105 = null;
        goto L16
    L17:
        r112 = null;
        goto L18
    L9:
        return new mr9.h(false, null, null, 31);
    L5:
        r101 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object R5(String r310, String r311, String r312, ic8.m0 r313, Pair<Integer, Integer> r410, Continuation<? super com.larus.bmhome.resource.access.b0> r411) {
        if ((r411 instanceof MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1) == false) goto L7;
        MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1 r100 = (MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ic8.m0 r104 = (ic8.m0) r110.L$2;
        String r105 = (String) r110.L$1;
        String r106 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        ic8.m0 r112 = r104;
        String r113 = r105;
        Object r107 = r102;
        String r108 = null;
    L24:
        mr9.h r114 = (mr9.h) r107;
        ICreationResourceAccessService.Companion r109 = ICreationResourceAccessService.f373925a;
        int r115 = com.larus.uaigc.service.p0.f373964x;
        if (r112 == null) goto L27;
        String r116 = r112.f489223a;
    L28:
        int r117 = com.larus.uaigc.helper.g.f373020a;
        if (r112 == null) goto L31;
        String r118 = r112.f489223a;
    L32:
        Boolean r119 = Boolean.valueOf(com.larus.uaigc.helper.g.b(r118));
        if (r112 == null) goto L40;
        Long r120 = Long.valueOf(r112.f489225c);
        if (r120.longValue() < 0) goto L37;
        boolean r121 = true;
    L38:
        if (r121 == false) goto L40;
        Long r122 = r120;
    L41:
        if (r112 == null) goto L43;
        mr9.c r123 = r112.f489234l;
    L44:
        com.larus.bmhome.resource.access.j0.b r124 = new com.larus.bmhome.resource.access.j0.b(r106, r116, r119, r122, r123);
        CountDownLatch r125 = new CountDownLatch(1);
        com.larus.bmhome.resource.access.d0 r314 = com.larus.uaigc.service.g.f373960a;
        return r109.b(com.larus.uaigc.service.p0.a.b(r124, r113, null, r114, true, r125, null, null, null, null, new m2(), new n2(), null, null, null, null, null, r314, false, null, 1304456));
    L43:
        r123 = r108;
        goto L44
    L37:
        r121 = false;
    L40:
        r122 = r108;
        goto L41
    L31:
        r118 = r108;
        goto L32
    L27:
        r116 = r108;
        goto L28
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Pair<Integer, Integer> r126 = (Pair) r110.L$4;
        ic8.m0 r127 = (ic8.m0) r110.L$3;
        String r128 = (String) r110.L$2;
        String r129 = (String) r110.L$1;
        String r130 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Pair<Integer, Integer> r131 = r126;
        ic8.m0 r132 = r127;
        String r133 = r129;
        String r134 = r130;
    L20:
        String r135 = ((CreationRemoteConversationHelper.a) r102).f372616a;
        CoroutineDispatcher r136 = Dispatchers.getIO();
        r112 = r132;
        String r137 = r133;
        MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1 r138 = new MultiAttachmentSelectorComponent$submitImageResourceAccessTask$resourceCenterUploadParam$1(this, r133, r128, r135, r134, r132, r131, null);
        r110.L$0 = r134;
        r110.L$1 = r137;
        r110.L$2 = r112;
        r108 = null;
        r110.L$3 = null;
        r110.L$4 = null;
        r110.label = 2;
        r107 = BuildersKt.withContext(r136, r138, r110);
        if (r107 != r111) goto L23;
        return r111;
    L23:
        r106 = r134;
        r113 = r137;
        goto L24
    L16:
        ResultKt.throwOnFailure(r102);
        r110.L$0 = r310;
        r110.L$1 = r311;
        r110.L$2 = r312;
        r110.L$3 = r313;
        r110.L$4 = r410;
        r110.label = 1;
        Object r139 = s5(r110);
        if (r139 != r111) goto L19;
        return r111;
    L19:
        r134 = r310;
        r133 = r311;
        r132 = r313;
        r131 = r410;
        r102 = r139;
        r128 = r312;
    L7:
        r100 = new MultiAttachmentSelectorComponent$submitImageResourceAccessTask$1(this, r411);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d5(int r310, boolean r311, int r312, boolean r313, int r314, ry9.d r315) {
        ry9.d r100 = r315;
        G3();
        if (r100 == null) goto L21;
        List<ry9.c> r101 = r100.f539924a;
        if (r101 == null) goto L21;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        ry9.c r110 = (ry9.c) r103;
        if (r311 == true) goto L12;
    L14:
        boolean r111 = false;
    L15:
        if (r111 == false) goto L8;
    L18:
        ry9.c r104 = (ry9.c) r103;
        if (r104 == null) goto L21;
        String r105 = r104.f539913a;
    L22:
        com.larus.bmhome.actionbar.model.w0 r106 = Z3();
        if ((r106 instanceof com.larus.bmhome.actionbar.model.w0.a) == false) goto L25;
        com.larus.bmhome.actionbar.model.w0.a r107 = (com.larus.bmhome.actionbar.model.w0.a) r106;
    L26:
        if (r107 == null) goto L80;
        wa8.d1 r108 = r107.f295535a;
        if (r108 == null) goto L80;
        if (r100 != null) goto L31;
        r100 = yH(CollectionsKt.toList(this.f371975y.values()));
    L31:
        Collection<wa8.g1> r112 = r108.f558847c.values();
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r114 = r112.iterator();
    L33:
        if (r114.hasNext() == false) goto L35;
        wa8.g1 r115 = (wa8.g1) r114.next();
        r113.add(new CreationReferenceAlbumMediaRule(T5(r115.getType()), r115.f558859b, r115.f558861d, r115.f558864g, r115.f558867j, r115.f558868k, r115.f558869l, r115.f558870m, r115.f558871n, r115.f558860c, r115.f558863f, r115.f558866i));
        r114 = r114;
        r105 = r105;
        goto L33
    L35:
        String r210 = r105;
        List<wa8.h1> r109 = r108.f558848d;
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r117 = r109.iterator();
    L37:
        if (r117.hasNext() == false) goto L43;
        wa8.h1 r118 = (wa8.h1) r117.next();
        List<CreationReferenceMediaType> r119 = r118.f558872a;
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator<T> r121 = r119.iterator();
    L40:
        if (r121.hasNext() == false) goto L42;
        r120.add(T5((CreationReferenceMediaType) r121.next()));
        goto L40
    L42:
        r116.add(new CreationReferenceAlbumMixedRule(r120, r118.f558873b, r118.f558875d, r118.f558874c, r118.f558877f));
        goto L37
    L43:
        List<ry9.c> r122 = r100.f539924a;
        ArrayList r123 = new ArrayList();
        Iterator<T> r124 = r122.iterator();
    L45:
        if (r124.hasNext() == false) goto L50;
        Object r125 = r124.next();
        String r126 = r210;
        if (Intrinsics.areEqual(((ry9.c) r125).f539913a, r126) == true) goto L49;
        r123.add(r125);
    L49:
        r210 = r126;
        goto L45
    L50:
        ArrayList r127 = new ArrayList();
        Iterator r128 = r123.iterator();
    L52:
        if (r128.hasNext() == false) goto L79;
        ry9.c r129 = (ry9.c) r128.next();
        int r130 = b.f371978b[r129.getType().ordinal()];
        if (r130 != 1) goto L56;
        CreationReferenceAlbumMediaType r131 = CreationReferenceAlbumMediaType.IMAGE;
    L67:
        CreationReferenceAlbumMediaType r132 = r131;
        Integer r133 = r129.f539920h;
        Integer r134 = r129.f539921i;
        Double r135 = r129.f539922j;
        if (r135 != null) goto L70;
    L75:
        Double r136 = null;
    L76:
        CreationReferenceAlbumAttachment r137 = new CreationReferenceAlbumAttachment(r132, r133, r134, r136, r129.f539923k);
    L77:
        if (r137 == null) goto L52;
        r127.add(r137);
        goto L52
    L70:
        if (r135.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L72;
        boolean r138 = true;
    L73:
        if (r138 == false) goto L75;
        r136 = r135;
        goto L76
    L72:
        r138 = false;
        goto L73
    L56:
        if (r130 != 2) goto L58;
        r131 = CreationReferenceAlbumMediaType.VIDEO;
        goto L67
    L58:
        if (r130 != 3) goto L60;
        r131 = CreationReferenceAlbumMediaType.AUDIO;
        goto L67
    L60:
        if (r130 != 4) goto L63;
        r137 = null;
        goto L77
    L63:
        throw new NoWhenBranchMatchedException();
    L79:
        CreationReferenceAlbumConfig r139 = new CreationReferenceAlbumConfig(r113, r116, r127, r108.f558845a, r100.f539925b, r100.f539926c);
    L81:
        this.X = r139;
        if (r311 == false) goto L90;
        this.Q = r312;
        AlbumSettingConfig.a r140 = new AlbumSettingConfig.a();
        r140.f365520f = this.V;
        if (r313 == true) goto L86;
    L88:
        boolean r141 = false;
    L89:
        r140.f365523i = r141;
        r140.f365517c = false;
        r140.f365537w = this.X;
        r140.f365539y = true;
        AlbumSettingConfig r142 = r140.a();
        this.V = null;
        LocalTakePictureImpl r143 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r143.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r142);
        com.larus.bmhome.actionbar.model.z0 r144 = null;
    L115:
        ny9.s r145 = W3();
        if (r145 == null) goto L118;
        com.larus.bmhome.actionbar.model.z0 r146 = r145.f();
    L119:
        ny9.u r147 = c4();
        if (r147 == null) goto L122;
        String r148 = r147.getBotId();
    L123:
        ny9.u r149 = c4();
        if (r149 == null) goto L126;
        String r150 = r149.getChatType();
    L127:
        ny9.u r151 = c4();
        if (r151 == null) goto L130;
        String r152 = r151.r();
    L131:
        ny9.u r153 = c4();
        if (r153 == null) goto L134;
        String r154 = r153.getEnterMethod();
    L135:
        if (r146 == null) goto L141;
        com.larus.bmhome.actionbar.model.r r155 = r146.f295621q;
        if (r155 == null) goto L141;
        Integer r156 = r155.f295408a;
        if (r156 == null) goto L141;
        String r157 = r156.toString();
    L142:
        if (r146 == null) goto L146;
        com.larus.bmhome.actionbar.model.r r158 = r146.f295621q;
        if (r158 == null) goto L146;
        String r159 = r158.f295414g;
    L147:
        ny9.u r160 = c4();
        if (r160 == null) goto L150;
        String r161 = r160.q();
    L151:
        tx9.c0.H(r148, r152, r154, null, r150, r161, null, r157, r159, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33553992);
        return;
    L150:
        r161 = r144;
    L146:
        r159 = r144;
    L141:
        r157 = r144;
        goto L142
    L134:
        r154 = r144;
        goto L135
    L130:
        r152 = r144;
        goto L131
    L126:
        r150 = r144;
        goto L127
    L122:
        r148 = r144;
        goto L123
    L118:
        r146 = r144;
        goto L119
    L86:
        if (r314 <= 0) goto L88;
        r141 = true;
        goto L89
    L90:
        this.Q = -1;
        if (this.O == false) goto L109;
        AlbumSettingConfig.a r162 = new AlbumSettingConfig.a();
        r162.f365520f = this.V;
        r162.f365523i = r313;
        r162.f365518d = r310;
        r162.f365533s = r313;
        r162.f365534t = r314;
        r162.f365517c = true;
        r162.f365537w = this.X;
        r162.f365539y = true;
        AlbumSettingConfig r163 = r162.a();
        r144 = null;
        this.V = null;
        if (G4() == true) goto L95;
        Bundle r164 = null;
    L103:
        if (r164 != null) goto L105;
        LocalTakePictureImpl r165 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r165.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r163);
        goto L115
    L105:
        LocalTakePictureImpl r166 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r167 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        MultiAttachmentSelectorComponent$openAlbumInternal$2 r168 = new MultiAttachmentSelectorComponent$openAlbumInternal$2(this);
        r166.getClass();
        Intrinsics.checkNotNullParameter(r167, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r163, "albumConfig");
        Intrinsics.checkNotNullParameter(r168, "onFail");
        r166.i(r167, r163, null, r164, new li8.l(), r168);
        goto L115
    L95:
        this.K = true;
        this.L = null;
        final CreationAlbumPipelinePrewarmer r169 = V3();
        r169.getClass();
        r169.a(ResourceCancelReason.REPLACED);
        final String r170 = UUID.randomUUID().toString();
        Object r171 = r169.f371905c;
        monitor-enter(r171);
        r169.f371906d = r170;     // Catch: Throwable -> L106
        Unit r172 = Unit.INSTANCE;     // Catch: Throwable -> L106
        monitor-exit(r171);
        ConcurrentHashMap<String, Function2<kq9.d, Boolean, Unit>> r173 = kq9.c.f505615a;
        Function2<kq9.d, Boolean, Unit> r174 = new com.larus.uaigc.createpage.component.mediaselector.imageselector.a(r169, r170);
        Intrinsics.checkNotNullParameter(r170, "sessionId");
        Intrinsics.checkNotNullParameter(r174, "listener");
        if ((!StringsKt.isBlank(r170)) == false) goto L102;
        kq9.c.f505615a.put(r170, r174);
    L102:
        Bundle r175 = new Bundle();
        r175.putString("extra.album.selection.session.id", r170);
        r164 = r175;
    L106:
        th = move-exception;
        throw th;
    L109:
        r144 = null;
        AlbumSettingConfig.a r176 = new AlbumSettingConfig.a();
        r176.f365520f = this.V;
        if (r313 == false) goto L113;
        if (r314 <= 0) goto L113;
        boolean r177 = true;
    L114:
        r176.f365523i = r177;
        r176.f365517c = false;
        r176.f365537w = this.X;
        r176.f365539y = true;
        AlbumSettingConfig r178 = r176.a();
        LocalTakePictureImpl r179 = this.H;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r179.g(com.larus.ui.arch.component.internal.attach.a.b(this, this), r178);
    L113:
        r177 = false;
    L80:
        r139 = null;
        goto L81
    L25:
        r107 = null;
        goto L26
    L12:
        if (r110.f539914b != r312) goto L14;
        r111 = true;
        goto L15
    L17:
        r103 = null;
    L21:
        r105 = null;
        goto L22
    }

    public final Object W4(final com.larus.bmhome.resource.access.b0 r100, final String r110, String r111, Function1<? super ResourceUploadError, Unit> r112, Function1<? super mr9.l, Unit> r113, final Function1<? super mr9.k, Unit> r114, Continuation<? super Unit> r115) {
        if ((r115 instanceof MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1) == false) goto L7;
        MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1 r101 = (MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1) r115;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1 r103 = r101;
        Object r116 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r113 = (Function1) r103.L$1;
        r112 = (Function1) r103.L$0;
        ResultKt.throwOnFailure(r116);
    L17:
        ICreationResourceAccessServiceKt.c((com.larus.bmhome.resource.access.a0) r116, r113, r112);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r116);
        Function1 r106 = new c2(r100, this, r110);
        Function1 r107 = new d2(r114);
        r103.L$0 = r112;
        r103.L$1 = r113;
        r103.label = 1;
        r116 = CreationResourceAccessPerfBridgeKt.a(r100, r111, r110, r110, r106, r107, r103);
        if (r116 != r104) goto L17;
        return r104;
    L7:
        r101 = new MultiAttachmentSelectorComponent$observeImageResourceAccessTask$1(this, r115);
        goto L8
    }

    @Override // ry9.h
    public final void q00(final String r310, String r311, String r312, String r313, String r314, final boolean r315, final boolean r410, String r411) {
        Intrinsics.checkNotNullParameter(r310, "resourceKey");
        Intrinsics.checkNotNullParameter(r311, "url");
        Intrinsics.checkNotNullParameter(r312, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r313, "resourceId");
        Intrinsics.checkNotNullParameter(r314, "localFilePath");
        String r316 = null;
        boolean r110 = false;
        if ((!StringsKt.isBlank(r311)) == true) goto L13;
        if (r411 != null) goto L6;
    L9:
        boolean r100 = true;
    L10:
        if (r100 == false) goto L13;
        MutableLiveData<ry9.k> r111 = null;
    L14:
        com.larus.uaigc.helper.f.f373014a.getClass();
        MutableLiveData<ry9.k> r317 = r111;
        final ry9.j.c r101 = H3(this, r310, r311, r411, r312, r313, r314, 0, 0, com.larus.uaigc.helper.f.a(), 192);
        if (com.larus.uaigc.helper.f.a() == true) goto L17;
    L38:
        if (r101 == null) goto L41;
        com.larus.utils.t0.e(new f3(this, r310, r101, r315, r410));
        return;
    L41:
        this.E.put(r310, BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MultiAttachmentSelectorComponent$triggerDownloadUrlAndExplain$uploadJob$1(r311, this, r312, r314, r310, r411, r313, r315, r410, null), 3, null));
        return;
    L17:
        if ((!StringsKt.isBlank(r311)) == true) goto L23;
        if (r411 != null) goto L20;
    L21:
        r110 = true;
    L22:
        if (r110 == true) goto L38;
    L20:
        if (StringsKt.isBlank(r411) == false) goto L22;
    L23:
        this.A.put(r310, new MediaAttachment(r311, r411, null, null, r314, r312, r313, null, null, null, null, null, 3980, null));
        if (r317 == null) goto L31;
        if (r101 == null) goto L28;
        ry9.j r102 = r101;
    L29:
        r317.setValue(new ry9.k(r310, r102, 0, r315, r410, false, 36));
        goto L31
    L28:
        r102 = ry9.j.h.f539943b;
    L31:
        if ((!StringsKt.isBlank(r312)) == false) goto L33;
        r316 = r312;
    L33:
        if (r316 != null) goto L35;
        StringBuilder r103 = new StringBuilder();
        r103.append(UUID.randomUUID());
        r103.append('_');
        r103.append(System.currentTimeMillis());
        String r104 = r103.toString();
    L36:
        this.f371973w.put(r310, r104);
        this.E.put(r310, BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new MultiAttachmentSelectorComponent$submitRemoteImageResourceAccess$uploadJob$1(this, r310, r104, r314, r311, r411, r313, r315, r410, null), 2, null));
        return;
    L35:
        r104 = r316;
        goto L36
    L6:
        if (StringsKt.isBlank(r411) == true) goto L9;
        r100 = false;
    L13:
        r111 = e4(r310);
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object N2(final MultiAttachmentSelectorComponent r310, String r311, String r312, Bitmap r313, String r314, String r315, String r316, boolean r317, boolean r318, Continuation r319) {
        r310.getClass();
        if ((r319 instanceof MultiAttachmentSelectorComponent$explainResourceUrl$1) == false) goto L7;
        MultiAttachmentSelectorComponent$explainResourceUrl$1 r100 = (MultiAttachmentSelectorComponent$explainResourceUrl$1) r319;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r102);
    L74:
        return Unit.INSTANCE;
    L17:
        boolean r106 = r100.Z$1;
        boolean r107 = r100.Z$0;
        String r108 = (String) r100.L$5;
        String r110 = (String) r100.L$4;
        String r111 = (String) r100.L$3;
        Bitmap r112 = (Bitmap) r100.L$2;
        String r113 = (String) r100.L$1;
        String r114 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r210 = r108;
        String r211 = r110;
        String r212 = r111;
        Bitmap r115 = r112;
        String r116 = r113;
    L27:
        com.larus.network.http.a r109 = (com.larus.network.http.a) r102;
        if ((r109 instanceof com.larus.network.http.y) == false) goto L72;
        com.larus.uaigc.api.s r117 = (com.larus.uaigc.api.s) ((com.larus.network.http.y) r109).f360135b;
        if (r117 == null) goto L34;
        List<com.larus.uaigc.api.q> r118 = r117.a();
        if (r118 == null) goto L34;
        com.larus.uaigc.api.q r119 = (com.larus.uaigc.api.q) CollectionsKt.firstOrNull(r118);
    L35:
        if (r119 == null) goto L37;
        String r120 = r119.c();
    L39:
        if (com.larus.utils.o0.d(r120) == false) goto L64;
        if (r119 == null) goto L42;
        r105 = Intrinsics.areEqual(r119.a(), Boxing.boxBoolean(false));
    L42:
        if (r105 == false) goto L64;
        FLogger.f375446a.i("MultiAttachmentSelector", "explainResourceUrl success");
        com.larus.uaigc.api.p r121 = r119.b();
        if (r121 == null) goto L52;
        com.larus.uaigc.api.n r122 = r121.a();
        if (r122 == null) goto L52;
        com.larus.uaigc.api.m r123 = r122.a();
        if (r123 == null) goto L52;
        Long r124 = r123.b();
        if (r124 == null) goto L52;
        long r125 = r124.longValue();
    L53:
        Long r126 = Boxing.boxLong(r125);
        com.larus.uaigc.api.p r127 = r119.b();
        if (r127 == null) goto L62;
        com.larus.uaigc.api.n r128 = r127.a();
        if (r128 == null) goto L62;
        com.larus.uaigc.api.m r129 = r128.a();
        if (r129 == null) goto L62;
        Long r130 = r129.a();
        if (r130 == null) goto L62;
        long r131 = r130.longValue();
    L63:
        final ry9.j.c r132 = new ry9.j.c(new ry9.i.a(new MediaAttachment(r116, r120, new ImageUploadInfo(r126, Boxing.boxLong(r131)), null, r210, r212, r211, null, null, null, null, null, 3976, null), null));
        final String r320 = r114;
        final boolean r321 = r107;
        final boolean r322 = r106;
        com.larus.utils.t0.e(new w1(r310, r320, r132, r321, r322));
    L62:
        r131 = r115.getHeight();
    L52:
        r125 = r115.getWidth();
    L64:
        FLogger r133 = FLogger.f375446a;
        StringBuilder r134 = new StringBuilder("explainResourceUrl success, but needRePush: ");
        if (r119 == null) goto L67;
        Boolean r135 = r119.a();
    L68:
        r134.append(r135);
        r133.i("MultiAttachmentSelector", r134.toString());
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 2;
        if (r310.h5(r114, r115, r107, r106, r100) != r103) goto L74;
        return r103;
    L67:
        r135 = null;
        goto L68
    L37:
        r120 = null;
    L34:
        r119 = null;
        goto L35
    L72:
        FLogger.f375446a.e("MultiAttachmentSelector", "explainResourceUrl failed");
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.L$5 = null;
        r100.label = 3;
        if (r310.h5(r114, r115, r107, r106, r100) != r103) goto L74;
        return r103;
    L18:
        ResultKt.throwOnFailure(r102);
        IBachDetectCenterAbility.Companion r136 = IBachDetectCenterAbility.f364932a;
        if (r136.b() == false) goto L23;
        Uri r137 = com.larus.utils.y0.j(r312);
        if (r137 == null) goto L23;
        r136.a(r137);
    L23:
        List r138 = CollectionsKt.listOf(r312);
        r100.L$0 = r311;
        r100.L$1 = r312;
        r115 = r313;
        r100.L$2 = r115;
        r100.L$3 = r314;
        r100.L$4 = r315;
        r100.L$5 = r316;
        r100.Z$0 = r317;
        r100.Z$1 = r318;
        r100.label = 1;
        r102 = com.larus.uaigc.api.o.a(r138, false, r100);
        if (r102 == r103) goto L76;
        r116 = r312;
        r212 = r314;
        r211 = r315;
        r210 = r316;
        r107 = r317;
        r114 = r311;
        r106 = r318;
        goto L27
    L76:
        return r103;
    L7:
        r100 = new MultiAttachmentSelectorComponent$explainResourceUrl$1(r310, r319);
        goto L8
    }

    public static ry9.j.c H3(MultiAttachmentSelectorComponent r210, String r211, String r212, String r213, String r214, String r310, String r311, long r312, long r313, boolean r314, int r315) {
        long r100 = 0;
        if ((r315 & 64) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r315 & 128) != 0) goto L10;
        r100 = r313;
    L10:
        boolean r102 = false;
        if ((r315 & 256) == 0) goto L13;
        boolean r103 = false;
    L14:
        ny9.s r104 = r210.W3();
        if (r104 == null) goto L22;
        Bundle r105 = r104.f521269a;
        if (r105 == null) goto L19;
        boolean r106 = r105.getBoolean("is_prefilled_image", false);
    L20:
        if (r106 != true) goto L22;
        boolean r107 = true;
    L24:
        if (r107 == true) goto L26;
        return null;
    L26:
        if (r210.f371969s == false) goto L78;
        ResourceItemBean r108 = r210.f371975y.get(r211);
        if (r108 == null) goto L34;
        Image r109 = r108.getImage();
        if (r109 == null) goto L34;
        ImageObj r110 = r109.imageOri;
        if (r110 == null) goto L34;
    L40:
        if (r311.length() != 0) goto L42;
        boolean r111 = true;
    L43:
        if (r111 == false) goto L52;
        if (r108 == null) goto L48;
        Image r112 = r108.getImage();
        if (r112 == null) goto L48;
        String r113 = r112.localResPath;
    L49:
        if (r113 != null) goto L51;
        r113 = "";
    L51:
        String r114 = r113;
    L53:
        if (r213 != null) goto L55;
    L58:
        boolean r115 = true;
    L59:
        if (r115 == false) goto L69;
        if (r114.length() != 0) goto L63;
        r102 = true;
    L63:
        if (r102 == false) goto L69;
        if (r103 == true) goto L66;
        return null;
    L66:
        if (StringsKt.isBlank(r212) == false) goto L69;
        return null;
    L69:
        if (r110 == null) goto L71;
        r101 = r110.width;
    L71:
        Long r116 = Long.valueOf(r101);
        if (r110 == null) goto L75;
        r100 = r110.height;
    L75:
        return new ry9.j.c(new ry9.i.a(new MediaAttachment(r212, r213, new ImageUploadInfo(r116, Long.valueOf(r100)), null, r114, r214, r310, null, null, null, null, null, 3976, null), null));
    L55:
        if (r213.length() == 0) goto L58;
        r115 = false;
    L48:
        r113 = null;
        goto L49
    L52:
        r114 = r311;
        goto L53
    L42:
        r111 = false;
    L34:
        if (r108 == null) goto L38;
        Image r117 = r108.getImage();
        if (r117 == null) goto L38;
        r110 = r117.imageThumb;
    L38:
        r110 = null;
        goto L40
    L78:
        return null;
    L19:
        r106 = false;
    L22:
        r107 = false;
        goto L24
    L13:
        r103 = r314;
        goto L14
    L5:
        r101 = r312;
        goto L7
    }

    public static final Object Y2(final MultiAttachmentSelectorComponent r310, final com.larus.bmhome.resource.access.b0 r311, final String r312, String r313, String r314, String r315, String r316, String r317, final boolean r318, final boolean r410, Continuation r411) {
        r310.getClass();
        if ((r411 instanceof MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1) == false) goto L7;
        MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1 r100 = (MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1) r411;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        boolean r104 = r110.Z$1;
        boolean r105 = r110.Z$0;
        String r106 = (String) r110.L$5;
        String r107 = (String) r110.L$4;
        String r108 = (String) r110.L$3;
        String r109 = (String) r110.L$2;
        String r112 = (String) r110.L$1;
        String r113 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        String r210 = r106;
        String r211 = r109;
        String r114 = r112;
    L18:
        com.larus.bmhome.resource.access.a0 r115 = (com.larus.bmhome.resource.access.a0) r102;
        if ((r115 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L113;
        com.larus.bmhome.resource.access.a0.d r116 = (com.larus.bmhome.resource.access.a0.d) r115;
        com.larus.bmhome.resource.access.f0 r117 = r116.f313618a;
        mr9.l r118 = r117.f313647e;
        if (r118 != null) goto L23;
        r118 = new mr9.l(r117.f313645c, null, r117.f313646d, null, null, false, null, 122);
    L23:
        String r119 = r118.f515022a;
        boolean r120 = false;
        if (r119 != null) goto L26;
    L29:
        boolean r121 = true;
    L30:
        if (r121 == false) goto L40;
        String r122 = r118.f515024c;
        if (r122 != null) goto L34;
    L37:
        boolean r123 = true;
    L38:
        if (r123 == false) goto L40;
        r310.l4(r113, "empty_upload_result", "upload result is null", r105, r104);
    L131:
        return Unit.INSTANCE;
    L34:
        if (r122.length() == 0) goto L37;
        r123 = false;
    L40:
        ResourceUploadInstantInfo r124 = r118.f515028g;
        if (r124 == null) goto L45;
        zd9.h.f571481a.getClass();
        String r125 = zd9.h.c(r124);
        if (r125 == null) goto L45;
        r310.f371976z.put(r113, r125);
    L45:
        tx9.l0.b("creation_page_passed_image_re_upload", r113, true, null, null, null, 56);
        ResourceItemBean r126 = r310.f371975y.get(r113);
        if (r126 == null) goto L51;
        Image r127 = r126.getImage();
        if (r127 == null) goto L51;
        ImageObj r128 = r127.imageOri;
        if (r128 == null) goto L51;
    L57:
        com.larus.bmhome.resource.access.j0 r129 = r116.f313618a.f313644b;
        if ((r129 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L60;
        com.larus.bmhome.resource.access.j0.b r130 = (com.larus.bmhome.resource.access.j0.b) r129;
    L61:
        if (r130 == null) goto L63;
        String r131 = r130.f313690b;
    L64:
        if (r131 != null) goto L67;
        r131 = "";
    L67:
        if ((!StringsKt.isBlank(r107)) == true) goto L69;
    L71:
        if (r120 == true) goto L74;
        r107 = null;
    L74:
        if (r107 == null) goto L77;
        r131 = r107;
    L77:
        r310.i5(r113, r131);
        mr9.d r132 = r118.f515025d;
        if (r132 == null) goto L80;
        long r133 = r132.f514992b;
    L92:
        mr9.d r134 = r118.f515025d;
        if (r134 == null) goto L95;
        long r135 = r134.f514991a;
    L107:
        String r136 = r118.f515022a;
        ImageUploadInfo r137 = new ImageUploadInfo(Long.valueOf(r133), Long.valueOf(r135));
        VideoUploadInfo r212 = null;
        String r138 = r118.f515024c;
        if (r138 != null) goto L110;
        String r213 = r108;
    L111:
        r310.e4(r113).setValue(new ry9.k(r113, new ry9.j.c(new ry9.i.a(new MediaAttachment(r114, r136, r137, r212, r131, r211, r213, r210, null, null, null, null, 3848, null), null)), 0, r105, r104, false, 36));
        r310.T4(true, null, "pic");
        nz9.b.e("creation_page/re_upload", "0", r113);
        r310.o5(r113);
        goto L131
    L110:
        r213 = r138;
        goto L111
    L95:
        String r139 = r116.f313618a.f313648f.get("height");
        if (r139 == null) goto L98;
        Long r140 = StringsKt.toLongOrNull(r139);
    L99:
        if (r140 != null) goto L105;
        if (r128 == null) goto L103;
        r140 = Long.valueOf(r128.height);
    L104:
        if (r140 != null) goto L105;
        r135 = 0;
        goto L107
    L103:
        r140 = null;
    L105:
        r135 = r140.longValue();
        goto L107
    L98:
        r140 = null;
        goto L99
    L80:
        String r141 = r116.f313618a.f313648f.get("width");
        if (r141 == null) goto L83;
        Long r142 = StringsKt.toLongOrNull(r141);
    L84:
        if (r142 != null) goto L90;
        if (r128 == null) goto L88;
        r142 = Long.valueOf(r128.width);
    L89:
        if (r142 != null) goto L90;
        r133 = 0;
        goto L92
    L88:
        r142 = null;
    L90:
        r133 = r142.longValue();
        goto L92
    L83:
        r142 = null;
        goto L84
    L69:
        if (new PolarisFileWrapper(r107).exists() == false) goto L71;
        r120 = true;
        goto L71
    L63:
        r131 = null;
        goto L64
    L60:
        r130 = null;
    L51:
        ResourceItemBean r143 = r310.f371975y.get(r113);
        if (r143 == null) goto L56;
        Image r144 = r143.getImage();
        if (r144 == null) goto L56;
        r128 = r144.imageThumb;
    L56:
        r128 = null;
        goto L57
    L26:
        if (r119.length() == 0) goto L29;
        r121 = false;
        goto L30
    L113:
        if ((r115 instanceof com.larus.bmhome.resource.access.a0.c) == false) goto L116;
        com.larus.bmhome.resource.access.r r145 = ((com.larus.bmhome.resource.access.a0.c) r115).f313617a;
        r310.l4(r113, r145.f313723b, r145.f313724c, r105, r104);
        goto L131
    L116:
        if ((r115 instanceof com.larus.bmhome.resource.access.a0.a) == false) goto L122;
        if (ICreationResourceAccessServiceKt.d(r115) == false) goto L120;
        FLogger.f375446a.i("MultiAttachmentSelector", "[observeRemoteResourceAccessTask] page destroy cancel");
        goto L131
    L120:
        ResourceUploadError r146 = ICreationResourceAccessServiceKt.g(r115);
        r310.l4(r113, r146.getCode(), r146.getMsg(), r105, r104);
        goto L131
    L122:
        if (Intrinsics.areEqual(r115, com.larus.bmhome.resource.access.a0.b.f313616a) == true) goto L131;
        if ((r115 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L131;
        if ((r115 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L131;
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Function1 r147 = new q2(r310, r312, r311, r318, r410);
        Function1 r148 = new s2(r311, r310, r312, r318, r410);
        r110.L$0 = r312;
        r110.L$1 = r313;
        r110.L$2 = r314;
        r110.L$3 = r315;
        r107 = r316;
        r110.L$4 = r107;
        r110.L$5 = r317;
        r110.Z$0 = r318;
        r110.Z$1 = r410;
        r110.label = 1;
        Object r149 = CreationResourceAccessPerfBridgeKt.a(r311, "creation_page/re_upload", r312, r312, r147, r148, r110);
        if (r149 == r111) goto L132;
        r113 = r312;
        r114 = r313;
        r211 = r314;
        r210 = r317;
        r102 = r149;
        r105 = r318;
        r104 = r410;
        r108 = r315;
        goto L18
    L132:
        return r111;
    L7:
        r100 = new MultiAttachmentSelectorComponent$observeRemoteResourceAccessTask$1(r310, r411);
        goto L8
    }

    public final Object I5(String r310, String r311, String r312, String r313, ic8.m0 r314, Pair<Integer, Integer> r315, String r316, com.larus.bmhome.resource.access.b0 r317, Function1<? super ResourceUploadError, Unit> r318, Function1<? super mr9.l, Unit> r319, Function1<? super mr9.k, Unit> r410, Continuation<? super Unit> r411) {
        Function1<? super mr9.l, Unit> r100 = r319;
        Function1<? super mr9.k, Unit> r110 = r410;
        if ((r411 instanceof MultiAttachmentSelectorComponent$submitImageResourceAccess$1) == false) goto L7;
        MultiAttachmentSelectorComponent$submitImageResourceAccess$1 r101 = (MultiAttachmentSelectorComponent$submitImageResourceAccess$1) r411;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MultiAttachmentSelectorComponent$submitImageResourceAccess$1 r111 = r101;
        Object r103 = r111.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r111.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        Function1<? super mr9.k, Unit> r105 = (Function1) r111.L$7;
        Function1<? super mr9.l, Unit> r106 = (Function1) r111.L$6;
        Function1<? super ResourceUploadError, Unit> r107 = (Function1) r111.L$5;
        Pair<Integer, Integer> r108 = (Pair) r111.L$4;
        ic8.m0 r109 = (ic8.m0) r111.L$3;
        String r113 = (String) r111.L$2;
        String r114 = (String) r111.L$1;
        String r115 = (String) r111.L$0;
        ResultKt.throwOnFailure(r103);
        Function1<? super mr9.k, Unit> r210 = r105;
        Function1<? super mr9.l, Unit> r211 = r106;
        Function1<? super ResourceUploadError, Unit> r212 = r107;
        ic8.m0 r116 = r109;
        String r117 = r113;
        String r118 = r114;
        String r119 = r115;
    L36:
        String r320 = r118;
        String r321 = r117;
        mr9.h r120 = D3(r320, r321, ((CreationRemoteConversationHelper.a) r103).f372616a, r119, r116, r108);
        ICreationResourceAccessService.Companion r121 = ICreationResourceAccessService.f373925a;
        int r122 = com.larus.uaigc.service.p0.f373964x;
        r121.b(com.larus.uaigc.service.p0.a.c(r119, r118, r116, r120, true, new CountDownLatch(1), null, null, null, r210, r211, r212, null, null, LifecycleOwnerKt.getLifecycleScope(this), 1033992));
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
    L31:
        return Unit.INSTANCE;
    L17:
        Function1<? super mr9.k, Unit> r123 = (Function1) r111.L$4;
        Function1<? super mr9.l, Unit> r124 = (Function1) r111.L$3;
        Function1<? super ResourceUploadError, Unit> r125 = (Function1) r111.L$2;
        String r126 = (String) r111.L$1;
        String r127 = (String) r111.L$0;
        ResultKt.throwOnFailure(r103);
        r110 = r123;
        r100 = r124;
    L25:
        com.larus.bmhome.resource.access.b0 r128 = (com.larus.bmhome.resource.access.b0) r103;
    L27:
        r111.L$0 = null;
        r111.L$1 = null;
        r111.L$2 = null;
        r111.L$3 = null;
        r111.L$4 = null;
        r111.label = 2;
        if (W4(r128, r127, r126, r125, r100, r110, r111) != r112) goto L31;
        return r112;
    L18:
        ResultKt.throwOnFailure(r103);
        com.larus.uaigc.helper.f.f373014a.getClass();
        if (com.larus.uaigc.helper.f.a() == false) goto L32;
        if (r317 != null) goto L26;
        r111.L$0 = r311;
        r111.L$1 = r316;
        r111.L$2 = r318;
        r111.L$3 = r100;
        r111.L$4 = r110;
        r111.label = 1;
        r103 = R5(r310, r312, r313, r314, r315, r111);
        if (r103 != r112) goto L24;
        return r112;
    L24:
        r125 = r318;
        r127 = r311;
        r126 = r316;
        goto L25
    L26:
        r128 = r317;
        r125 = r318;
        r127 = r311;
        r126 = r316;
        goto L27
    L32:
        r111.L$0 = r310;
        r111.L$1 = r312;
        r117 = r313;
        r111.L$2 = r117;
        r111.L$3 = r314;
        r111.L$4 = r315;
        r111.L$5 = r318;
        r111.L$6 = r100;
        r111.L$7 = r110;
        r111.label = 3;
        Object r129 = s5(r111);
        if (r129 != r112) goto L35;
        return r112;
    L35:
        r119 = r310;
        r118 = r312;
        r103 = r129;
        r116 = r314;
        r108 = r315;
        r212 = r318;
        r211 = r100;
        r210 = r110;
    L7:
        r101 = new MultiAttachmentSelectorComponent$submitImageResourceAccess$1(this, r411);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object Q5(MultiAttachmentSelectorComponent r110, String r111, String r112, String r113, String r210, ic8.m0 r211, Pair r212, String r213, com.larus.bmhome.resource.access.b0 r214, Function1 r215, Function1 r216, Function1 r217, Continuation r218, int r219) {
        if ((r219 & 16) == 0) goto L5;
        ic8.m0 r100 = null;
    L7:
        if ((r219 & 32) == 0) goto L9;
        Pair r101 = null;
    L11:
        if ((r219 & 64) == 0) goto L13;
        String r114 = "creation_page/album_upload";
    L15:
        if ((r219 & 128) == 0) goto L17;
        com.larus.bmhome.resource.access.b0 r115 = null;
    L19:
        return r110.I5(r111, r112, r113, r210, r100, r101, r114, r115, r215, r216, r217, r218);
    L17:
        r115 = r214;
        goto L19
    L13:
        r114 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
