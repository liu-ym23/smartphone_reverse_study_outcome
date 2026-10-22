package com.larus.audio.flow.client;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.flow_audio.api.business.tts.config.FlowAudioTtsStreamType;
import com.bytedance.flow_audio.api.tracer.FlowTtsTraceHelper;
import com.bytedance.flow_audio.api.tracer.TtsTracer;
import com.f.android.quality.impl.Scene;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.audiov3.audio.player.AudioPlayerErrorEnum;
import com.larus.audio.audiov3.audio.player.AudioPlayerState;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.audiov3.task.TtsManager;
import com.larus.audio.audiov3.task.tts.TtsLifeState;
import com.larus.audio.audiov3.task.tts.TtsStopType;
import com.larus.audio.audiov3.task.tts.TtsType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.audio.audiov3.tts.TtsStep;
import com.larus.audio.flow.client.cache.TtsCacheManager;
import com.larus.audio.flow.client.cache.d;
import com.larus.audio.flow.client.mob.FlowAudioAsrAndTTSCostMobHelper;
import com.larus.audio.flow.client.mob.FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1;
import com.larus.audio.o;
import com.larus.audio.ttsV2.TtsClientManager;
import com.larus.audio.ttsV2.h;
import com.larus.audio.utils.a0;
import com.larus.audio.utils.e;
import com.larus.audio.utils.g1;
import com.larus.audio.utils.z;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import g78.b;
import g78.b0;
import g78.c0;
import g78.d0;
import g78.e0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k78.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m58.r;
import m58.s;
import m58.t;
import m58.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002©\u0001\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0016J\u0010\u0010O\u001a\u00020>2\u0006\u0010M\u001a\u00020\u0003H\u0016J+\u0010P\u001a\u00020>2!\u0010Q\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020>0:H\u0016J\b\u0010R\u001a\u00020*H\u0016J\b\u0010S\u001a\u00020TH\u0016J&\u0010U\u001a\u00020>2\u0006\u0010V\u001a\u00020\u00032\u0014\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020Y\u0018\u00010XH\u0016J&\u0010Z\u001a\u00020>2\u0006\u0010V\u001a\u00020\u00032\u0014\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020Y\u0018\u00010XH\u0016J¦\u0001\u0010[\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\u0010]\u001a\u0004\u0018\u00010\u00032\b\u0010M\u001a\u0004\u0018\u00010\u00032\u0006\u0010^\u001a\u00020*2\b\u0010_\u001a\u0004\u0018\u00010\u00032\b\u0010`\u001a\u0004\u0018\u00010\u00032\u0006\u0010a\u001a\u00020*2\u0016\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010X2\b\u0010c\u001a\u0004\u0018\u00010\u00032\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\r2\u0006\u0010j\u001a\u00020*2\u0006\u0010k\u001a\u00020\r2\u0006\u0010l\u001a\u00020*H\u0016J\u0096\u0001\u0010[\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\u0010]\u001a\u0004\u0018\u00010\u00032\b\u0010m\u001a\u0004\u0018\u00010\u00032\b\u0010_\u001a\u0004\u0018\u00010\u00032\b\u0010M\u001a\u0004\u0018\u00010\u00032\b\u0010c\u001a\u0004\u0018\u00010\u00032\u0016\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010X2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010\u00032\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\r2\u0006\u0010j\u001a\u00020*2\u0006\u0010k\u001a\u00020\r2\u0006\u0010l\u001a\u00020*H\u0016Jt\u0010n\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\u0010]\u001a\u0004\u0018\u00010\u00032\b\u0010m\u001a\u0004\u0018\u00010\u00032\b\u0010_\u001a\u0004\u0018\u00010\u00032\u0006\u0010o\u001a\u00020p2\b\u0010M\u001a\u0004\u0018\u00010\u00032\b\u0010c\u001a\u0004\u0018\u00010\u00032\u0016\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010X2\b\u0010d\u001a\u0004\u0018\u00010e2\u0006\u0010l\u001a\u00020*H\u0016JÎ\u0001\u0010[\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\u0010]\u001a\u0004\u0018\u00010\u00032\b\u0010M\u001a\u0004\u0018\u00010\u00032\u0006\u0010^\u001a\u00020*2\b\u0010_\u001a\u0004\u0018\u00010\u00032\b\u0010`\u001a\u0004\u0018\u00010\u00032\u0006\u0010a\u001a\u00020*2\u0016\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010X2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010o\u001a\u0004\u0018\u00010p2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010g\u001a\u00020h2\b\b\u0002\u0010i\u001a\u00020\r2\b\b\u0002\u0010j\u001a\u00020*2\b\b\u0002\u0010k\u001a\u00020\r2\b\b\u0002\u0010l\u001a\u00020*H\u0002J\b\u0010q\u001a\u0004\u0018\u00010(J\u0010\u0010r\u001a\u00020>2\u0006\u0010I\u001a\u00020*H\u0016J\u001a\u0010s\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010t\u001a\u00020>2\u000e\u0010u\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010DH\u0016J\u001a\u0010v\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\b\u0002\u0010w\u001a\u00020*H\u0002J%\u0010x\u001a\u00020>2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010{J\u001a\u0010|\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010}\u001a\u00020>2\b\u0010~\u001a\u0004\u0018\u00010\u007fH\u0002J»\u0001\u0010\u0080\u0001\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\u0010]\u001a\u0004\u0018\u00010\u00032\b\u0010M\u001a\u0004\u0018\u00010\u00032\u0006\u0010^\u001a\u00020*2\b\u0010_\u001a\u0004\u0018\u00010\u00032\u0006\u0010a\u001a\u00020*2\u0016\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010X2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010o\u001a\u0004\u0018\u00010p2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010g\u001a\u00020h2\b\b\u0002\u0010i\u001a\u00020\r2\b\u0010~\u001a\u0004\u0018\u00010\u007f2\b\b\u0002\u0010k\u001a\u00020\rH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020>2\b\u0010Q\u001a\u0004\u0018\u00010&H\u0016J\u0007\u0010\u0082\u0001\u001a\u00020>J\t\u0010\u0083\u0001\u001a\u00020\"H\u0016J\u0011\u0010\u0084\u0001\u001a\u00020>2\u0006\u0010=\u001a\u00020\u0003H\u0016J!\u0010\u0085\u0001\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010j\u001a\u00020*2\u0006\u0010=\u001a\u00020\u0003H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020>2\u0007\u0010\u0087\u0001\u001a\u00020*H\u0016J*\u0010\u0088\u0001\u001a\u00020>2\u001f\u0010\u0089\u0001\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\r\u0012\u0007\u0012\u0005\u0018\u00010\u008b\u0001\u0018\u00010\u008a\u0001H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020>2\u0007\u0010\u008d\u0001\u001a\u00020hH\u0016J\"\u0010\u008e\u0001\u001a\u00020>2\u0007\u0010\u008f\u0001\u001a\u00020*2\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0003H\u0002J\u001b\u0010\u0090\u0001\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u00032\b\b\u0002\u0010w\u001a\u00020*H\u0002J\t\u0010\u0091\u0001\u001a\u00020>H\u0002J\t\u0010\u0092\u0001\u001a\u00020>H\u0016J\t\u0010\u0093\u0001\u001a\u00020>H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020>2\u0007\u0010\u0095\u0001\u001a\u00020\"H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020>2\u0007\u0010\u0097\u0001\u001a\u00020\u0003H\u0016J4\u0010\u0098\u0001\u001a\u00020*2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00032\b\u0010c\u001a\u0004\u0018\u00010\u00032\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u009c\u0001\u001a\u00020>2\u0007\u0010\u0095\u0001\u001a\u00020\"H\u0002J\n\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J\u0013\u0010\u009f\u0001\u001a\u00020>2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\u0013\u0010¢\u0001\u001a\u00020>2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\u0012\u0010£\u0001\u001a\u00020>2\u0007\u0010\u0087\u0001\u001a\u00020*H\u0016J\u0011\u0010¤\u0001\u001a\u00020>2\u0006\u0010\\\u001a\u00020\u0003H\u0002J\t\u0010¥\u0001\u001a\u00020>H\u0002J\u0014\u0010¦\u0001\u001a\u00020>2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u0017H\u0016J9\u0010¨\u0001\u001a\u00030©\u00012\u0006\u0010\\\u001a\u00020\u00032\b\u0010ª\u0001\u001a\u00030«\u00012\u000b\b\u0002\u0010¬\u0001\u001a\u0004\u0018\u00010e2\b\u0010~\u001a\u0004\u0018\u00010\u007fH\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u009b\u0001\u0010®\u0001\u001a\u00030«\u00012\u0006\u0010\\\u001a\u00020\u00032\b\u0010]\u001a\u0004\u0018\u00010\u00032\b\u0010M\u001a\u0004\u0018\u00010\u00032\u0006\u0010^\u001a\u00020*2\b\u0010_\u001a\u0004\u0018\u00010\u00032\u0006\u0010a\u001a\u00020*2\u0017\u0010¯\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010X2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010g\u001a\u00020h2\b\b\u0002\u0010i\u001a\u00020\r2\b\b\u0002\u0010k\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R7\u00109\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020>\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006°\u0001"}, d2 = {"Lcom/larus/audio/flow/client/FlowTtsClientImpl;", "Lcom/larus/audio/IFlowTtsClientService;", "TAG", "", "<init>", "(Ljava/lang/String;)V", "commonConfig", "Lcom/larus/audio/audiov3/config/task/sami/CommonConfig;", "getCommonConfig", "()Lcom/larus/audio/audiov3/config/task/sami/CommonConfig;", "setCommonConfig", "(Lcom/larus/audio/audiov3/config/task/sami/CommonConfig;)V", "DEFAULT_TTS_SIMPLE_RATE", "", "getDEFAULT_TTS_SIMPLE_RATE", "()I", "preConversationId", "preMsgId", "curPlayingMsgId", "finalPlayingMsgId", "finalPlayingTaskId", "tryPlayMsgId", "mTimeoutStrategy", "Lcom/larus/audio/settings/tts/TtsTimeoutStrategy;", "mAudioPlayerListener", "Lcom/larus/audio/flow/client/AudioPlayerListenerWrapper;", "mAudioPlayer", "Lcom/larus/audio/audiov3/audio/player/IAudioPlayer;", "mTtsTasks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "mAudioDataQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "", "mAudioPlayState", "Lcom/larus/audio/audiov3/tts/PlayStateEnum;", "alreadyPlay", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mAudioPlayStateChangeCallback", "Lcom/larus/audio/audiov3/tts/AudioPlayStateChangeCallback;", "mTtsReporter", "Lcom/larus/audio/flow/client/report/TtsReporter;", "isStartFromManual", "", "isStopFromManual", "enableTtsAutoTimeoutCancel", "pendingTimeoutTaskId", "mTimeoutRunnable", "Ljava/lang/Runnable;", "ttsStartTime", "", "ttsDuration", "mAudioPlayerConfig", "Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfig;", "getMAudioPlayerConfig", "()Lcom/larus/audio/audiov3/config/audio/player/IAudioPlayerConfig;", "mAudioPlayerConfig$delegate", "Lkotlin/Lazy;", "cancelAllTtsCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "reason", "", "getCancelAllTtsCallback", "()Lkotlin/jvm/functions/Function1;", "setCancelAllTtsCallback", "(Lkotlin/jvm/functions/Function1;)V", "onStopAudioPlayListener", "Lkotlin/Function0;", "mExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "mNeedCancel", "mPlayUntilDataEmpty", "interruptStopTts", "logger", "Lcom/larus/audio/utils/AudioFormatLogger;", "doCostMobOnUserStartTTs", RemoteMessageConst.MSGID, "funcChannel", "doCostMobOnRecodeStep", "setTtsCancelCallback", "callback", "isPlayerPlaying", "getTtsManager", "Lcom/larus/audio/audiov3/task/ITtsManager;", "reportTtsStepStart", "step", "extraMap", "", "", "reportTtsStepSuccess", "startTts", DBDefinition.TASK_ID, "conversationId", "isFirstSpeak", "speakerStyleId", "llModelName", "enableTextReading", "payloadExtParams", "extra", "externalTtsListener", "Lcom/larus/audio/audiov3/task/tts/ITtsListener;", "audioMetrics", "targetLufs", "", "loudNormAlgoType", "isFromManual", "business", "hasAudioFocus", "text", "startTtsStream", "ttsStreamType", "Lcom/bytedance/flow_audio/api/business/tts/config/FlowAudioTtsStreamType;", "getTtsReporter", "setInterruptStopTts", "tryPlay", "setOnStopAudioPlayListener", "listener", "stopAudioPlay", "isCancel", "stopAudioPlayTrace", "errorCode", "errorMsg", "(Ljava/lang/Integer;Ljava/lang/String;)V", "startAudioPlay", "initAudioPlayer", "tracer", "Lcom/bytedance/flow_audio/api/tracer/TtsTracer;", "initTtsTask", "setAudioPlayStateChangeCallback", "removeAudioPlayStateChangeCallback", "getTtsAndPlayerState", "cancelAllTtsAndAudioPlay", "cancelTtsAndAudioPlay", "setKmpTtsCancelTaskIdCheckEnabled", "enable", "setKmpTtsAudioTrackProvider", ShortVideoSegments.KEY_PROP_PROVIDER, "Lkotlin/Function2;", "Landroid/media/AudioTrack;", "setVolume", "volumeFactor", "cancelTtsAndStopPlay", "shouldCancelAll", "stopAudioPlayAndRelease", "tryReportSenseSuccessWhenCancel", "resumeAudioPlay", "pauseAudioPlay", "changeAudioPlayState", "playStateEnum", "deleteTtsCache", "cacheKey", "enableTtsCache", "messageId", "voiceStyleId", "selectedText", "notifyAudioPlayState", "getAudioPlayerState", "Lcom/larus/audio/audiov3/audio/player/AudioPlayerState;", "addAudioPlayerListener", "audioPlayerListener", "Lcom/larus/audio/audiov3/audio/player/IAudioPlayerListener;", "removeAudioPlayerListener", "ttsAutoTimeoutCancel", "scheduleTimerTask", "cancelTimeoutTask", "setTtsTimeoutDuration", "timeoutStrategy", "initTtsListener", "com/larus/audio/flow/client/FlowTtsClientImpl$initTtsListener$1", "ttsConfig", "Lcom/larus/audio/audiov3/config/task/sami/tts/TtsConfig;", "external", "(Ljava/lang/String;Lcom/larus/audio/audiov3/config/task/sami/tts/TtsConfig;Lcom/larus/audio/audiov3/task/tts/ITtsListener;Lcom/bytedance/flow_audio/api/tracer/TtsTracer;)Lcom/larus/audio/flow/client/FlowTtsClientImpl$initTtsListener$1;", "createTtsConfig", "payloadParams", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTtsClientImpl implements IFlowTtsClientService {
    public Function0<Unit> A;
    public final PThreadPoolExecutor B;
    public volatile boolean C;
    public boolean D;
    public boolean E;
    public final e F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f289693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f289694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f289695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f289696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile String f289697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f289698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f289699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public u78.a f289700i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f289701j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p58.a f289702k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentLinkedQueue<String> f289703l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedBlockingQueue<byte[]> f289704m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PlayStateEnum f289705n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f289706o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public n68.a f289707p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f289708q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f289709r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f289710s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f289711t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f289712u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b0 f289713v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f289714w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f289715x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f289716y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function1<? super String, Unit> f289717z;

    public static final class a implements q58.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowTtsClientImpl f289718a;

        /* JADX INFO: renamed from: com.larus.audio.flow.client.FlowTtsClientImpl$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes24.dex */
        public /* synthetic */ class C3967a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f289719a = null;

            static {
                int[] r100 = new int[AudioPlayerState.values().length];
                r100[AudioPlayerState.PAUSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[AudioPlayerState.STOPPED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[AudioPlayerState.STARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f289719a = r100;
            }
        }

        public a(FlowTtsClientImpl r100) {
            this.f289718a = r100;
        }

        @Override // q58.b
        public final void a(AudioPlayerErrorEnum r110) {
            Intrinsics.checkNotNullParameter(r110, "code");
            int r100 = c68.b.f22600a;
            c68.b.a(this.f289718a.f289693b, "onAudioPlayer Failed code:" + r110);
            this.f289718a.v(PlayStateEnum.PLAY_STATE_FAIL);
            c r101 = this.f289718a.f289708q;
            if (r101 == null) goto L22;
            String r102 = TtsStep.STEP_TTS_PLAYER_PLAY_TIME.getTraceName();
            int r103 = r110.getCode();
            String r104 = r110.getMassage();
            Intrinsics.checkNotNullParameter(r102, "step");
            Intrinsics.checkNotNullParameter(r104, "errMsg");
            if (r101.f502054a.length() != 0) goto L7;
            boolean r111 = true;
        L8:
            if (r111 == true) goto L24;
            Scene r105 = r101.f502057d;
            if (r105 == null) goto L23;
            f68.a r112 = r101.f502056c;
            if (r112 == null) goto L19;
            Map<String, Object> r113 = r112.a();
            if (r113 == null) goto L19;
            Map<String, ? extends Object> r114 = MapsKt.toMutableMap(r113);
            if (r114 == null) goto L19;
            Unit r106 = Unit.INSTANCE;
        L20:
            r105.f(r102, null, false, Integer.valueOf(r103), r104, r114);
            return;
        L19:
            r114 = null;
            goto L20
        L23:
            return;
        L24:
            return;
        L7:
            r111 = false;
            goto L8
        }

        @Override // q58.b
        public final void b(AudioPlayerState r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            int r101 = c68.b.f22600a;
            c68.b.a(this.f289718a.f289693b, "onAudioPlayer StateChange state:" + r100);
            int r102 = C3967a.f289719a[r100.ordinal()];
            if (r102 != 1) goto L5;
            this.f289718a.v(PlayStateEnum.PLAY_STATE_PAUSED);
            return;
        L5:
            if (r102 != 2) goto L7;
            this.f289718a.v(PlayStateEnum.PLAY_STATE_STOPPED);
            return;
        L7:
            if (r102 != 3) goto L10;
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void o(h r100) {
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void q() {
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void s(boolean r100) {
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void w(x58.a r100) {
    }

    public FlowTtsClientImpl() {
        this("FlowTtsClient");
    }

    public final void D() {
        b0 r100 = this.f289713v;
        if (r100 == null) goto L6;
        g1.f290034a.removeCallbacks(r100);
        return;
    }

    public final void F() {
        int r100 = c68.b.f22600a;
        c68.b.a(this.f289693b, "initAudioPlayer");
        c r101 = this.f289708q;
        if (r101 == null) goto L5;
        r101.d(TtsStep.STEP_TTS_PLAYER_PLAY_TIME.getTraceName(), null);
    L5:
        this.f289702k.f((u58.a) this.f289716y.getValue());
        this.f289702k.g(this.f289701j);
        this.f289702k.start();
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final boolean a() {
        if (this.f289702k.f527799b != AudioPlayerState.STARTED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void k() {
        if (this.f289702k.f527799b != AudioPlayerState.STARTED) goto L6;
        int r100 = c68.b.f22600a;
        c68.b.d(this.f289693b, "resumeAudioPlay already started");
        return;
    L6:
        String r101 = this.f289698g;
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L31;
        String r104 = this.f289697f;
        if (r104 != null) goto L17;
    L20:
        if (r102 == true) goto L31;
        this.f289702k.resume();
        int r105 = c68.b.f22600a;
        c68.b.a(this.f289693b, "resumeAudioPlay");
        PlayStateEnum r106 = PlayStateEnum.PLAY_STATE_PLAYING;
        v(r106);
        String r107 = this.f289698g;
        if (r107 != null) goto L25;
        return;
    L25:
        if (this.f289705n != r106) goto L29;
        K(r107, this.f289697f);
        TtsManager r108 = TtsManager.f288522a;
        l68.b r109 = TtsManager.e(r107);
        if (r109 == null) goto L34;
        r109.e(TtsLifeState.TTS_RESUME, r107, null);
        return;
    L34:
        return;
    L29:
        c68.b.d(this.f289693b, "resumeAudioPlay failed audioPlayState=" + this.f289705n);
        return;
    L17:
        if (r104.length() == 0) goto L20;
        r102 = false;
    L31:
        int r110 = c68.b.f22600a;
        c68.b.d(this.f289693b, "resumeAudioPlay finalPlayingTaskId=" + this.f289698g + " finalPlayingMsgId=" + this.f289697f);
        return;
    L9:
        if (r101.length() == 0) goto L12;
        r103 = false;
        goto L13
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void l() {
        if (this.f289702k.f527799b != AudioPlayerState.PAUSED) goto L6;
        int r100 = c68.b.f22600a;
        c68.b.d(this.f289693b, "pauseAudioPlay already paused");
        return;
    L6:
        D();
        this.f289702k.pause();
        int r101 = c68.b.f22600a;
        c68.b.a(this.f289693b, "pauseAudioPlay");
        PlayStateEnum r102 = PlayStateEnum.PLAY_STATE_PAUSED;
        v(r102);
        String r103 = this.f289698g;
        if (r103 != null) goto L9;
        return;
    L9:
        if (this.f289705n != r102) goto L13;
        TtsManager r104 = TtsManager.f288522a;
        l68.b r105 = TtsManager.e(r103);
        if (r105 == null) goto L16;
        r105.e(TtsLifeState.TTS_PAUSE, r103, null);
        return;
    L16:
        return;
    L13:
        c68.b.d(this.f289693b, "pauseAudioPlay failed audioPlayState=" + this.f289705n);
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final PlayStateEnum m() {
        return this.f289705n;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void r() {
        TtsManager r100 = TtsManager.f288522a;
    }

    /* JADX WARN: Type inference failed for: r10v8, types: [g78.b0] */
    public FlowTtsClientImpl(String r110) {
        Intrinsics.checkNotNullParameter(r110, "TAG");
        this.f289693b = r110;
        this.f289694c = 24000;
        this.f289700i = new u78.a(0);
        this.f289702k = new p58.a();
        this.f289703l = new ConcurrentLinkedQueue();
        this.f289704m = new LinkedBlockingQueue();
        this.f289705n = PlayStateEnum.PLAY_STATE_STOPPED;
        this.f289706o = new AtomicBoolean(false);
        this.f289713v = new b0(this);
        this.f289714w = -1;
        this.f289715x = -1;
        this.f289716y = LazyKt.lazy(new c0(this));
        this.B = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("FlowTtsClientImpl"));
        this.F = new e("FlowTtsClient");
        this.f289701j = new b(new q58.b[]{new a(this)});
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void C(n68.a r100) {
        this.f289707p = r100;
    }

    public final void H(String r100) {
        if (this.f289711t == true) goto L5;
        return;
    L5:
        D();
        this.f289712u = r100;
        b0 r101 = this.f289713v;
        if (r101 == null) goto L9;
        g1.f290034a.postDelayed(r101, this.f289700i.f549067a);
        return;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        Lazy r101 = TtsCacheManager.f289720a;
        TtsCacheManager.c(r100);
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void c(o r100) {
        this.A = r100;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Lazy r101 = FlowAudioAsrAndTTSCostMobHelper.f289760a;
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        JSONObject r102 = (JSONObject) ((FlowAudioAsrAndTTSCostMobHelper$ttsMap$2$1) FlowAudioAsrAndTTSCostMobHelper.f289761b.getValue()).get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.has("on_tts_trace_step_start") == true) goto L9;
        r102.put("on_tts_trace_step_start", SystemClock.elapsedRealtime());
        return;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Function1<? super String, Unit> r101 = this.f289717z;
        if (r101 == null) goto L5;
        r101.invoke(r100);
    L5:
        String r102 = this.f289712u;
        if (r102 != null) goto L10;
        r102 = this.f289698g;
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        E(true, r102, r100);
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void j(boolean r100) {
        this.f289711t = r100;
        if (r100 == true) goto L6;
        D();
        return;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void n(boolean r100) {
        int r101 = c68.b.f22600a;
        c68.b.d(this.f289693b, "setInterruptStopTts " + r100);
        if (this.f289696e == null) goto L6;
        if (r100 == false) goto L6;
        this.E = true;
        return;
    L6:
        this.E = false;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void setVolume(float r100) {
        this.f289702k.setVolume(r100);
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void t(q58.b r100) {
        Intrinsics.checkNotNullParameter(r100, "audioPlayerListener");
        b r101 = this.f289701j;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        r101.f480264a.remove(r100);
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void v(PlayStateEnum r100) {
        Intrinsics.checkNotNullParameter(r100, "playStateEnum");
        int r101 = c68.b.f22600a;
        c68.b.a(this.f289693b, "changeAudioPlayState playStateEnum:" + r100);
        if (r100 == PlayStateEnum.PLAY_STATE_FAIL) goto L5;
        this.f289705n = r100;
    L6:
        n68.a r102 = this.f289707p;
        if (r102 == null) goto L10;
        r102.c(r100);
    L10:
        if (r100 == PlayStateEnum.PLAY_STATE_PLAYING) goto L15;
        n68.a r103 = this.f289707p;
        if (r103 == null) goto L16;
        r103.d(r100);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        this.f289705n = PlayStateEnum.PLAY_STATE_STOPPED;
        goto L6
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void x(q58.b r100) {
        Intrinsics.checkNotNullParameter(r100, "audioPlayerListener");
        b r101 = this.f289701j;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (r101.f480264a.contains(r100) == true) goto L7;
        r101.f480264a.add(r100);
        return;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void y(u78.a r100) {
        if (r100.f549067a > 0) goto L5;
        return;
    L5:
        this.f289700i = r100;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void z(com.larus.bmhome.chat.trace.c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f289717z = r100;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void A(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        c r102 = this.f289708q;
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }

    public final void J(String r110, boolean r111) {
        if (this.f289702k.f527799b == AudioPlayerState.STOPPED) goto L54;
        this.f289702k.stop();
        Function0<Unit> r100 = this.A;
        if (r100 == null) goto L7;
        r100.invoke();
    L7:
        c r101 = this.f289708q;
        if (r101 == null) goto L10;
        r101.e(TtsStep.STEP_TTS_PLAYER_PLAY_TIME.getTraceName(), null);
    L10:
        boolean r102 = true;
        if (r111 == false) goto L16;
        TtsTracer r103 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r110);
        if (r103 == null) goto L16;
        r103.playEnd(1);
    L16:
        String r104 = this.f289697f;
        if (r104 == null) goto L23;
        if (r104.length() == 0) goto L23;
        r102 = false;
    L23:
        if (r102 == true) goto L39;
        if (r111 == false) goto L31;
        Integer r105 = -1;
        if (this.f289714w <= 0) goto L30;
        this.f289715x = System.currentTimeMillis() - this.f289714w;
        n68.a r106 = this.f289707p;
        if (r106 == null) goto L30;
        r106.b(this.f289710s, this.f289697f, r110, this.f289715x);
    L30:
        String r107 = "tts_cancel";
    L32:
        u r108 = m58.h.f512141l;
        if (r108 == null) goto L35;
        r108.j(this.f289697f, "tts_tts_first_pkg_to_play_finish", r105, r107);
    L35:
        u r109 = m58.h.f512141l;
        if (r109 == null) goto L38;
        r109.k(this.f289697f, r105, r107, null);
    L38:
        this.f289697f = null;
        this.f289698g = null;
        goto L39
    L31:
        r107 = "";
        r105 = null;
    L39:
        int r112 = l78.a.f507818d;
        l78.a.f507816b = System.currentTimeMillis();
        if (r111 == false) goto L42;
        long r113 = l78.a.a();
    L43:
        long r114 = 1000;
        long r115 = (l78.a.f507816b - l78.a.f507815a) / r114;
        if (r115 > 0) goto L46;
    L53:
        l78.a.f507815a = 0;
        l78.a.f507816b = 0;
        l78.a.f507817c = 0;
        l78.a.f507818d = 0;
        l78.a.f507819e = 0;
        l78.a.f507821g = "";
        l78.a.f507820f = "";
        l78.a.f507822h = 0;
        l78.a.f507823i = 0;
        l78.a.f507824j = 0;
        goto L54
    L46:
        if (l78.a.f507818d <= 0) goto L53;
        int r116 = c68.b.f22600a;
        c68.b.d("FlowTtsLagTraceHelper", "reportTtsConsumeLag duration: " + r115 + ", stuckTime: " + l78.a.f507817c + ", stuckCount: " + l78.a.f507818d + ", stuckNetQuality: " + l78.a.f507819e + ", taskId: " + l78.a.f507821g + ", speakerStyleId: " + l78.a.f507820f);
        JSONObject r117 = new JSONObject();
        r117.put("task_id", l78.a.f507821g);
        int r118 = l78.a.f507818d;
        if (r118 <= 0) goto L50;
        r117.put("stuck_net_quality", l78.a.f507819e / r118);
    L50:
        r117.put("stuck_time", Float.valueOf(l78.a.f507817c / 1000));
        r117.put("duration", r115);
        r117.put("stuck_rate", Float.valueOf(l78.a.f507818d / r115));
        r117.put("stuck_rate_time", Float.valueOf(l78.a.f507817c / (r115 * r114)));
        r117.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, l78.a.f507820f);
        r117.put("stuck_count", l78.a.f507818d);
        r117.put("stuck_time_until_cancel", r113);
        s r119 = m58.h.f512131b;
        if (r119 == null) goto L53;
        r119.report("tts_stuck", r117);
        goto L53
    L42:
        r113 = 0;
    L54:
        this.f289696e = null;
        this.f289699h = null;
        this.f289714w = -1;
    }

    public final void K(final String r100, final String r101) {
        z r102 = this.F.b("[TTS] tryPlay");
        r102.f290167c.f290130b = CollectionsKt.listOf("TtsPlay");
        Pair[] r103 = new Pair[2];
        r103[0] = TuplesKt.to(a0.f290011b, r100);
        a0 r104 = a0.f290014e;
        if (r101 != null) goto L5;
        String r105 = "";
    L6:
        r103[1] = TuplesKt.to(r104, r105);
        r102.b(MapsKt.mapOf(r103));
        z.a(r102);
        this.f289699h = r101;
        this.B.submit(new d0(this, r100, r101));
        return;
    L5:
        r105 = r101;
        goto L6
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "funcChannel");
        FlowAudioAsrAndTTSCostMobHelper.c(r100, r101);
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        K(r100, r101);
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void p(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        c r102 = this.f289708q;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    public final synchronized void E(boolean r110, String r210, String r211) {
        monitor-enter(this);
        z r100 = this.F.a("[TTS][INTERRUPTED] cancelTtsAndAudioPlay shouldCancelAll=" + r110 + " , interruptStopTts:" + this.E);     // Catch: Throwable -> L41
        r100.f290167c.f290130b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L41
        Pair[] r101 = new Pair[3];     // Catch: Throwable -> L41
        r101[0] = TuplesKt.to(a0.f290011b, r210);     // Catch: Throwable -> L41
        a0 r102 = a0.f290014e;     // Catch: Throwable -> L41
        String r103 = this.f289699h;     // Catch: Throwable -> L41
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r101[1] = TuplesKt.to(r102, r103);     // Catch: Throwable -> L41
        r101[2] = TuplesKt.to(a0.f290012c, StringsKt.replace$default(r211, ' ', '_', false, 4, null));     // Catch: Throwable -> L41
        r100.b(MapsKt.mapOf(r101));     // Catch: Throwable -> L41
        z.a(r100);     // Catch: Throwable -> L41
        if (this.E == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        this.C = true;     // Catch: Throwable -> L41
        if (this.f289702k.f527799b != AudioPlayerState.STARTED) goto L14;
    L15:
        c r104 = this.f289708q;     // Catch: Throwable -> L41
        if (r104 == null) goto L18;
        r104.c(MapsKt.mapOf(TuplesKt.to("success_scene", "cancel")));     // Catch: Throwable -> L41
    L18:
        this.D = false;     // Catch: Throwable -> L41
        this.f289704m.clear();     // Catch: Throwable -> L41
        this.f289704m.offer(new byte[0]);     // Catch: Throwable -> L41
        J(r210, true);     // Catch: Throwable -> L41
        if (r110 == false) goto L26;
        Iterator<Map.Entry<String, l68.a>> r105 = TtsManager.f288523b.entrySet().iterator();     // Catch: Throwable -> L41
    L22:
        if (r105.hasNext() == false) goto L29;
        Map.Entry<String, l68.a> r106 = r105.next();     // Catch: Throwable -> L41
        l68.b r107 = r106.getValue().getListener();     // Catch: Throwable -> L41
        if (r107 == null) goto L22;
        z r108 = this.F.a("[TTS][CANCEL_ALL] cancelTtsAndAudioPlay cancelAll");     // Catch: Throwable -> L41
        r108.f290167c.f290130b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L41
        r108.b(MapsKt.mapOf(new Pair[]{TuplesKt.to(a0.f290011b, r106.getKey()), TuplesKt.to(a0.f290012c, StringsKt.replace$default(r211, ' ', '_', false, 4, null))}));     // Catch: Throwable -> L41
        z.a(r108);     // Catch: Throwable -> L41
        TtsLifeState r109 = TtsLifeState.TTS_STOP;     // Catch: Throwable -> L41
        String r111 = r106.getKey();     // Catch: Throwable -> L41
        LinkedHashMap r112 = new LinkedHashMap();     // Catch: Throwable -> L41
        r112.put("scene_from", TtsStopType.USER_CANCEL.getType());     // Catch: Throwable -> L41
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L41
        r107.e(r109, r111, r112);     // Catch: Throwable -> L41
    L29:
        D();     // Catch: Throwable -> L41
        if (r110 == false) goto L35;
        Iterator<String> r114 = this.f289703l.iterator();     // Catch: Throwable -> L41
    L33:
        if (r114.hasNext() == false) goto L37;
        String r115 = r114.next();     // Catch: Throwable -> L41
        TtsManager r116 = TtsManager.f288522a;     // Catch: Throwable -> L41
        Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L41
        r116.cancel(r115);     // Catch: Throwable -> L41
        r116.stop(r115);     // Catch: Throwable -> L41
        r116.c(r115);     // Catch: Throwable -> L41
        this.f289703l.remove(r115);     // Catch: Throwable -> L41
    L37:
        if (this.f289705n != PlayStateEnum.PLAY_STATE_PREPARE) goto L39;
        v(PlayStateEnum.PLAY_STATE_STOPPED);     // Catch: Throwable -> L41
    L39:
        monitor-exit(this);
        return;
    L35:
        TtsManager r117 = TtsManager.f288522a;     // Catch: Throwable -> L41
        r117.cancel(r210);     // Catch: Throwable -> L41
        this.f289703l.remove(r210);     // Catch: Throwable -> L41
        r117.stop(r210);     // Catch: Throwable -> L41
        r117.c(r210);     // Catch: Throwable -> L41
        goto L37
    L26:
        TtsManager r118 = TtsManager.f288522a;     // Catch: Throwable -> L41
        l68.b r119 = TtsManager.e(r210);     // Catch: Throwable -> L41
        if (r119 == null) goto L29;
        TtsLifeState r120 = TtsLifeState.TTS_STOP;     // Catch: Throwable -> L41
        LinkedHashMap r121 = new LinkedHashMap();     // Catch: Throwable -> L41
        r121.put("scene_from", TtsStopType.USER_CANCEL.getType());     // Catch: Throwable -> L41
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L41
        r119.e(r120, r210, r121);     // Catch: Throwable -> L41
        goto L29
    L14:
        if (this.f289702k.f527799b != AudioPlayerState.PAUSED) goto L18;
    L41:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void g(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "reason");
        this.f289710s = r101;
        E(false, r100, r102);
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final boolean h(String r100, String r101, String r102, String r103) {
        Lazy r104 = TtsCacheManager.f289720a;
        t r105 = m58.h.f512142m;
        if (r105 == null) goto L7;
        boolean r106 = true;
        if (r105.enableTtsCache() != true) goto L7;
    L8:
        if (r106 == true) goto L11;
        return false;
    L11:
        if (r102 != null) goto L13;
        r102 = SliceInitService.DEFAULT_SWITCH;
    L13:
        String r107 = new JSONObject(r102).optString("post_process");
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        return TtsCacheManager.b(d.a(r100, r101, r107, r103));
    L7:
        r106 = false;
        goto L8
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void B(String r110, String r210, String r211, String r212, String r213, String r214, Map<String, String> r215, l68.b r216, String r217, float r218, int r219, boolean r310, int r311, boolean r312) {
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        I(this, r110, r210, r213, true, r212, null, true, r215, r214, r211, r216, r217, r218, r219, r310, r311, r312);
    }

    public final void G(String r110, String r210, String r211, boolean r212, String r213, boolean r214, Map<String, String> r215, String r216, String r217, FlowAudioTtsStreamType r218, l68.b r219, String r310, float r311, int r312, TtsTracer r313, int r314) {
        x58.a r100 = m58.h.f512130a;
        if (r210 != null) goto L5;
        String r101 = "";
    L6:
        if (r211 != null) goto L8;
        String r102 = "";
    L9:
        if (r215 == null) goto L11;
        Map r103 = MapsKt.toMutableMap(r215);
    L12:
        Map r104 = r103;
        if (r213 != null) goto L15;
        String r105 = "";
    L16:
        if (r216 != null) goto L18;
        String r106 = "";
    L19:
        if (r310 != null) goto L21;
        String r111 = "";
    L22:
        z58.a r112 = new z58.a(r100, r110, r102, r101, r105, r106, r214, r212, r104, r111, r311, r312, r314, r217, 1967200);
        TtsManager r107 = TtsManager.f288522a;
        if (r217 != null) goto L25;
    L28:
        boolean r108 = true;
    L29:
        if (r108 == false) goto L31;
        TtsType r109 = TtsType.TTS_BY_MSG_ID;
    L32:
        r107.a(r110, r112, r109);
        r107.d(r110, new e0(this, r219, r112, r110, r313));
        if (r218 == null) goto L45;
        Intrinsics.checkNotNullParameter(r110, DBDefinition.TASK_ID);
        ConcurrentHashMap<String, l68.a> r113 = TtsManager.f288523b;
        if (r113.get(r110) != null) goto L37;
        int r114 = c68.b.f22600a;
        c68.b.b("TtsManager", "startStream cannot find task taskId=".concat(r110));
        return;
    L37:
        if (r217 != null) goto L39;
        int r115 = c68.b.f22600a;
        c68.b.b("TtsManager", "params maybe null ttsStreamType=" + r218 + " streamText=" + r217);
        return;
    L39:
        l68.a r116 = r113.get(r110);
        if (r116 == null) goto L42;
        r116.d(r218, r217);
    L42:
        TtsTracer r117 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r110);
        if (r117 == null) goto L49;
        r117.startCallSami();
        return;
    L49:
        return;
    L45:
        r107.start(r110);
        return;
    L31:
        r109 = TtsType.TTS_BY_TEXT;
        goto L32
    L25:
        if (r217.length() == 0) goto L28;
        r108 = false;
        goto L29
    L21:
        r111 = r310;
        goto L22
    L18:
        r106 = r216;
        goto L19
    L15:
        r105 = r213;
        goto L16
    L11:
        r103 = null;
        goto L12
    L8:
        r102 = r211;
        goto L9
    L5:
        r101 = r210;
        goto L6
    }

    @Override // com.larus.audio.IFlowTtsClientService
    public final void u(String r210, String r211, String r212, boolean r213, String r214, String r215, boolean r216, Map r217, String r218, TtsClientManager.e r219, String r310, float r311, int r312, boolean r313, int r314, boolean r315) {
        Intrinsics.checkNotNullParameter(r210, DBDefinition.TASK_ID);
        I(this, r210, r211, r212, r213, r214, r215, r216, r217, r218, null, r219, r310, r311, r312, r313, r314, r315);
    }

    public static void I(FlowTtsClientImpl r210, String r211, String r212, String r213, boolean r214, String r215, String r216, boolean r217, Map r218, String r219, String r310, l68.b r311, String r312, float r313, int r314, boolean r315, int r316, boolean r317) {
        String r110 = r213;
        monitor-enter(r210);
        z r100 = r210.F.b("[TTS] startTts");     // Catch: Throwable -> L164
        r100.f290167c.f290130b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L164
        Pair[] r101 = new Pair[6];     // Catch: Throwable -> L164
        a0 r102 = a0.f290011b;     // Catch: Throwable -> L164
        r101[0] = TuplesKt.to(r102, r211);     // Catch: Throwable -> L164
        a0 r103 = a0.f290013d;     // Catch: Throwable -> L164
        if (r212 != null) goto L7;
        String r104 = "";
    L8:
        r101[1] = TuplesKt.to(r103, r104);     // Catch: Throwable -> L164
        a0 r105 = a0.f290014e;     // Catch: Throwable -> L164
        if (r110 != null) goto L11;
        String r106 = "";
    L12:
        r101[2] = TuplesKt.to(r105, r106);     // Catch: Throwable -> L164
        a0 r107 = new a0("cur_playing_msg_id");     // Catch: Throwable -> L164
        String r108 = r210.f289696e;     // Catch: Throwable -> L164
        if (r108 != null) goto L15;
        r108 = "";
    L15:
        r101[3] = TuplesKt.to(r107, r108);     // Catch: Throwable -> L164
        a0 r109 = new a0("speaker_style_id");     // Catch: Throwable -> L164
        if (r215 != null) goto L18;
        String r111 = "";
    L19:
        r101[4] = TuplesKt.to(r109, r111);     // Catch: Throwable -> L164
        a0 r112 = new a0("ext");     // Catch: Throwable -> L164
        if (r218 != null) goto L22;
        Map r113 = MapsKt.emptyMap();     // Catch: Throwable -> L164
    L23:
        r101[5] = TuplesKt.to(r112, r113);     // Catch: Throwable -> L164
        r100.b(MapsKt.mapOf(r101));     // Catch: Throwable -> L164
        z.a(r100);     // Catch: Throwable -> L164
        r210.E = false;     // Catch: Throwable -> L164
        IAudioEventCommonParams r114 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);     // Catch: Throwable -> L164
        if (r114 == null) goto L30;
        m58.b r115 = m58.h.f512140k;     // Catch: Throwable -> L164
        if (r115 == null) goto L28;
        Application r116 = r115.getApplication();     // Catch: Throwable -> L164
    L29:
        r114.b(r116);     // Catch: Throwable -> L164
        goto L30
    L28:
        r116 = null;
    L30:
        if (r110 != null) goto L32;
    L35:
        boolean r117 = true;
    L36:
        if (r117 == false) goto L38;
    L49:
        r r118 = m58.h.f512132c;     // Catch: Throwable -> L164
        if (r118 == null) goto L69;
        if (r110 != null) goto L53;
        String r119 = "";
    L54:
        LinkedHashMap r120 = new LinkedHashMap();     // Catch: Throwable -> L164
        if (r110 != null) goto L57;
        String r121 = "";
    L58:
        r120.put(MusicAppletPage.KEY_MESSAGE_ID, r121);     // Catch: Throwable -> L164
        if (r212 != null) goto L61;
        String r122 = "";
    L62:
        r120.put("conversation_id", r122);     // Catch: Throwable -> L164
        TtsTracer r123 = FlowTtsTraceHelper.INSTANCE.getTracerByTaskId(r211);     // Catch: Throwable -> L164
        if (r123 == null) goto L65;
        String r124 = r123.getStartMethod();     // Catch: Throwable -> L164
    L66:
        if (r124 != null) goto L68;
        r124 = "";
    L68:
        r120.put(AiProactiveTaskViewModel.PARAM_START_METHOD, r124);     // Catch: Throwable -> L164
        r120.put("current_page", "chat");     // Catch: Throwable -> L164
        Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L164
        boolean r126 = r118.b(r211, r119, r120);     // Catch: Throwable -> L164
    L70:
        if (r126 == false) goto L84;
        z r127 = r210.F.b("[TTS][INTERCEPTED_BY_PREPROCESSOR]");     // Catch: Throwable -> L164
        r127.f290167c.f290130b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L164
        Pair[] r128 = new Pair[4];     // Catch: Throwable -> L164
        r128[0] = TuplesKt.to(r102, r211);     // Catch: Throwable -> L164
        if (r212 != null) goto L74;
        String r129 = "";
    L75:
        r128[1] = TuplesKt.to(r103, r129);     // Catch: Throwable -> L164
        if (r110 != null) goto L78;
        r110 = "";
    L78:
        r128[2] = TuplesKt.to(r105, r110);     // Catch: Throwable -> L164
        a0 r130 = new a0("cur_playing_msg_id");     // Catch: Throwable -> L164
        String r131 = r210.f289696e;     // Catch: Throwable -> L164
        if (r131 != null) goto L81;
        r131 = "";
    L81:
        r128[3] = TuplesKt.to(r130, r131);     // Catch: Throwable -> L164
        r127.b(MapsKt.mapOf(r128));     // Catch: Throwable -> L164
        z.a(r127);     // Catch: Throwable -> L164
        monitor-exit(r210);
        return;
    L74:
        r129 = r212;
        goto L75
    L84:
        Lazy r132 = TtsCacheManager.f289720a;     // Catch: Throwable -> L164
        TtsCacheManager.e();     // Catch: Throwable -> L164
        r210.f289696e = r110;     // Catch: Throwable -> L164
        r210.f289709r = r315;     // Catch: Throwable -> L164
        FlowTtsTraceHelper r133 = FlowTtsTraceHelper.INSTANCE;     // Catch: Throwable -> L164
        if (r110 != null) goto L87;
        String r134 = "";
    L88:
        TtsTracer r135 = r133.getTracerByTaskId(r134);     // Catch: Throwable -> L164
        if (r135 != null) goto L95;
        r135 = TtsTracer.Companion.generateTracer();     // Catch: Throwable -> L164
        r135.setTmpTracer(true);     // Catch: Throwable -> L164
        if (r110 != null) goto L93;
        String r136 = "";
    L94:
        r133.addTracer(r136, r135);     // Catch: Throwable -> L164
        goto L95
    L93:
        r136 = r110;
    L95:
        TtsTracer r137 = r135;
        if (r110 != null) goto L98;
        String r138 = "";
    L99:
        r133.replaceTracer(r138, r211);     // Catch: Throwable -> L164
        r137.appendExtra(r218, r219);     // Catch: Throwable -> L164
        if (r218 == null) goto L102;
        String r139 = (String) r218.get("bot_id");     // Catch: Throwable -> L164
    L103:
        r137.appendData(r211, r212, r213, r139, r215, null);     // Catch: Throwable -> L164
        r210.f289703l.add(r211);     // Catch: Throwable -> L164
        if (r215 != null) goto L106;
        String r140 = "";
    L107:
        if (r216 != null) goto L109;
        String r141 = "";
    L110:
        if (r218 == null) goto L112;
        String r142 = (String) r218.get("bot_id");     // Catch: Throwable -> L164
    L113:
        if (r142 != null) goto L115;
        r142 = "";
    L115:
        r210.f289708q = new c(r211, r140, r141, r213, r142);     // Catch: Throwable -> L164
        int r143 = l78.a.f507818d;     // Catch: Throwable -> L164
        Intrinsics.checkNotNullParameter(r211, DBDefinition.TASK_ID);     // Catch: Throwable -> L164
        if (r215 != null) goto L118;
        String r144 = "";
    L119:
        l78.a.f507820f = r144;     // Catch: Throwable -> L164
        l78.a.f507821g = r211;     // Catch: Throwable -> L164
        c r145 = r210.f289708q;     // Catch: Throwable -> L164
        if (r145 == null) goto L122;
        r145.b(null);     // Catch: Throwable -> L164
    L122:
        c r146 = r210.f289708q;     // Catch: Throwable -> L164
        if (r146 == null) goto L125;
        r146.d(TtsStep.STEP_TTS_PRE_SUB_TO_TEXT_SHOW.getTraceName(), null);     // Catch: Throwable -> L164
    L125:
        c r147 = r210.f289708q;     // Catch: Throwable -> L164
        if (r147 == null) goto L128;
        r147.d(TtsStep.STEP_TTS_GET_FIRST_AUDIO_DATA.getTraceName(), null);     // Catch: Throwable -> L164
    L128:
        c r148 = r210.f289708q;     // Catch: Throwable -> L164
        if (r148 == null) goto L131;
        Object r149 = null;
        r148.d(TtsStep.STEP_TTS_CREATE_HANDLER.getTraceName(), null);     // Catch: Throwable -> L164
    L132:
        if (r310 != null) goto L134;
        String r150 = "";
    L136:
        if (r150.length() <= 0) goto L138;
        boolean r151 = true;
    L139:
        r137.initTask(r151);     // Catch: Throwable -> L164
        r210.C = false;     // Catch: Throwable -> L164
        r210.D = false;     // Catch: Throwable -> L164
        r210.G(r211, r212, r213, r214, r215, r217, r218, r219, r310, null, r311, r312, r313, r314, r137, r316);     // Catch: Throwable -> L162
        c r152 = r210.f289708q;     // Catch: Throwable -> L146
        if (r152 == null) goto L148;
        r152.e(TtsStep.STEP_TTS_CREATE_HANDLER.getTraceName(), null);     // Catch: Throwable -> L146
    L148:
        r210.F();     // Catch: Throwable -> L146
        r210.f289702k.f527804g = r137;     // Catch: Throwable -> L146
        r210.f289706o.set(false);     // Catch: Throwable -> L146
        r210.f289695d = r213;     // Catch: Throwable -> L146
        r210.f289715x = -1;     // Catch: Throwable -> L146
        r210.H(r211);     // Catch: Throwable -> L146
        if (r317 == false) goto L151;
        Intrinsics.checkNotNullParameter(r211, DBDefinition.TASK_ID);     // Catch: Throwable -> L146
        r210.K(r211, r213);     // Catch: Throwable -> L146
    L152:
        r210.v(PlayStateEnum.PLAY_STATE_PREPARE);     // Catch: Throwable -> L146
        TtsManager.f288522a.b(r211, r210.f289702k.f527802e);     // Catch: Throwable -> L146
        t r153 = m58.h.f512142m;     // Catch: Throwable -> L146
        if (r153 != null) goto L155;
    L157:
        boolean r154 = false;
    L158:
        if (r154 == false) goto L160;
        fa9.e.f476067a.a("tts", r211);     // Catch: Throwable -> L146
    L160:
        monitor-exit(r210);
        return;
    L155:
        if (r153.enableKeepScreenOnDuringTTS() != true) goto L157;
        r154 = true;
        goto L158
    L151:
        int r155 = c68.b.f22600a;     // Catch: Throwable -> L146
        c68.b.d(r210.f289693b, "[TTS] skip startAudioPlay because audio focus is not ready, taskId=" + r211 + ", msgId=" + r213);     // Catch: Throwable -> L146
    L146:
        th = th;
    L166:
        monitor-exit(r210);
        throw th;
    L162:
        th = th;
        goto L166
    L138:
        r151 = false;
        goto L139
    L134:
        r150 = r310;
        goto L136
    L131:
        r149 = null;
        goto L132
    L118:
        r144 = r215;
        goto L119
    L112:
        r142 = null;
        goto L113
    L109:
        r141 = r216;
        goto L110
    L106:
        r140 = r215;
        goto L107
    L102:
        r139 = null;
        goto L103
    L98:
        r138 = r110;
        goto L99
    L87:
        r134 = r110;
        goto L88
    L65:
        r124 = null;
        goto L66
    L61:
        r122 = r212;
        goto L62
    L57:
        r121 = r110;
        goto L58
    L53:
        r119 = r110;
        goto L54
    L69:
        r126 = false;
        goto L70
    L38:
        if (Intrinsics.areEqual(r110, r210.f289696e) == false) goto L49;
        z r156 = r210.F.b("[TTS][CURRENT_MSG_IS_PLAYING]");     // Catch: Throwable -> L164
        r156.f290167c.f290130b = CollectionsKt.listOf("TtsPlay");     // Catch: Throwable -> L164
        Pair[] r157 = new Pair[4];     // Catch: Throwable -> L164
        r157[0] = TuplesKt.to(r102, r211);     // Catch: Throwable -> L164
        if (r212 != null) goto L42;
        String r158 = "";
    L43:
        r157[1] = TuplesKt.to(r103, r158);     // Catch: Throwable -> L164
        r157[2] = TuplesKt.to(r105, r110);     // Catch: Throwable -> L164
        a0 r159 = new a0("cur_playing_msg_id");     // Catch: Throwable -> L164
        String r160 = r210.f289696e;     // Catch: Throwable -> L164
        if (r160 != null) goto L46;
        r160 = "";
    L46:
        r157[3] = TuplesKt.to(r159, r160);     // Catch: Throwable -> L164
        r156.b(MapsKt.mapOf(r157));     // Catch: Throwable -> L164
        z.a(r156);     // Catch: Throwable -> L164
        monitor-exit(r210);
        return;
    L42:
        r158 = r212;
        goto L43
    L32:
        if (r213.length() == 0) goto L35;
        r117 = false;
        goto L36
    L22:
        r113 = r218;
        goto L23
    L18:
        r111 = r215;
        goto L19
    L11:
        r106 = r110;
        goto L12
    L7:
        r104 = r212;
    L164:
        th = th;
        goto L166
    }
}
