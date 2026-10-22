package com.obric.assistant;

import android.app.Application;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.EventsUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaPreloadHolder;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.news.common.settings.SettingsManager;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.account.base.api.ILoginService;
import com.larus.audio.ttsV2.f;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.login.api.LoginService;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.obric.assistant.settings.IObricPersonalContextSettingApi;
import com.obric.assistant.settings.config.ModelSettingsConfig;
import com.obric.assistant.settings.config.ObricImageUploadCompressConfig;
import com.obric.assistant.settings.config.ObricMmtVideoHardwareConfig;
import com.obric.assistant.settings.voiceprint.g;
import com.obric.assistant.settings.voiceprint.v;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import com.obric.assistant.voice.k;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import com.obric.audio.enroll.d;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import com.obric.performance.power.monitor.cpu.exception.CPUExceptionDiagnosisConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n38.j;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000Ü\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u009a\u00032\u00020\u0001:\u0004\u009a\u0003\u009b\u0003B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\b\b\u0003\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\u001a\u0010%\u001a\u00020#2\u0006\u0010!\u001a\u00020\u00132\b\b\u0003\u0010\"\u001a\u00020#H\u0003J\u001a\u0010&\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00132\b\b\u0001\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0003J\u0012\u0010)\u001a\u00020#2\b\b\u0001\u0010'\u001a\u00020#H\u0003J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J \u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020,2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u000101H\u0016J\b\u00102\u001a\u00020,H\u0017J\u0010\u00103\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0017J\b\u00104\u001a\u00020#H\u0017J\u0012\u00105\u001a\u00020\u00172\b\b\u0001\u0010'\u001a\u00020#H\u0016J\b\u00106\u001a\u00020,H\u0017J\u0010\u00107\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0017J\b\u00108\u001a\u00020#H\u0017J\u0012\u00109\u001a\u00020\u00172\b\b\u0001\u0010'\u001a\u00020#H\u0016J\b\u0010:\u001a\u00020,H\u0017J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0017J\b\u0010<\u001a\u00020,H\u0017J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0017J\b\u0010>\u001a\u00020,H\u0016J\b\u0010?\u001a\u00020,H\u0016J\u0010\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020,H\u0016J\b\u0010B\u001a\u00020#H\u0016J\u0012\u0010C\u001a\u00020\u00172\b\b\u0001\u0010'\u001a\u00020#H\u0016J\b\u0010D\u001a\u00020#H\u0017J\u0012\u0010E\u001a\u00020\u00172\b\b\u0001\u0010'\u001a\u00020#H\u0017J\b\u0010F\u001a\u00020#H\u0016J\u0012\u0010G\u001a\u00020\u00172\b\b\u0001\u0010'\u001a\u00020#H\u0016J\b\u0010H\u001a\u00020#H\u0016J\u0012\u0010I\u001a\u00020\u00172\b\b\u0001\u0010'\u001a\u00020#H\u0016J\b\u0010J\u001a\u00020#H\u0016J\u0012\u0010K\u001a\u00020\u00172\b\b\u0001\u0010'\u001a\u00020#H\u0016J\b\u0010L\u001a\u00020,H\u0016J\b\u0010M\u001a\u00020,H\u0017J\b\u0010N\u001a\u00020,H\u0016J\b\u0010O\u001a\u00020,H\u0016J\b\u0010P\u001a\u00020,H\u0016J\b\u0010Q\u001a\u00020,H\u0016J\b\u0010R\u001a\u00020\u0017H\u0016J\b\u0010S\u001a\u00020,H\u0016J\b\u0010T\u001a\u00020,H\u0002J\b\u0010W\u001a\u00020\u0017H\u0016J\b\u0010X\u001a\u00020\u0017H\u0016J\b\u0010Y\u001a\u00020\u0017H\u0002J\u0017\u0010Z\u001a\u00020\u00172\b\u0010[\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010\\J\b\u0010]\u001a\u00020\u0017H\u0016J!\u0010_\u001a\u00020\u00172\b\u0010[\u001a\u0004\u0018\u00010#2\b\u0010`\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010aJ\b\u0010b\u001a\u00020,H\u0017J\u0010\u0010c\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0017J\u0010\u0010e\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0002J\b\u0010f\u001a\u00020,H\u0016J\u0010\u0010g\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\b\u0010h\u001a\u00020,H\u0016J\u0010\u0010i\u001a\u00020\u00172\u0006\u0010A\u001a\u00020,H\u0016J\b\u0010j\u001a\u00020,H\u0016J\u0010\u0010k\u001a\u00020\u00172\u0006\u0010l\u001a\u00020,H\u0016J\b\u0010m\u001a\u00020,H\u0016J\b\u0010n\u001a\u00020\u0017H\u0017J\u001e\u0010n\u001a\u00020\u00172\u0014\u0010o\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0017\u0018\u00010pH\u0017J\b\u0010q\u001a\u00020\u0017H\u0016J\b\u0010r\u001a\u00020\u0017H\u0016J\u0010\u0010s\u001a\u00020\u00172\u0006\u0010t\u001a\u00020,H\u0016J\b\u0010u\u001a\u00020,H\u0016J\b\u0010v\u001a\u00020,H\u0016J\b\u0010w\u001a\u00020\u0017H\u0016J\u0010\u0010x\u001a\u00020,2\u0006\u0010y\u001a\u00020\u0013H\u0017J\u001a\u0010z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130{01H\u0017J\u000e\u0010|\u001a\b\u0012\u0004\u0012\u00020}01H\u0017J\u0018\u0010~\u001a\u00020\u00172\u0006\u0010y\u001a\u00020\u00132\u0006\u0010\u007f\u001a\u00020\u0013H\u0017J\u0011\u0010\u0080\u0001\u001a\u00020\u00172\u0006\u0010y\u001a\u00020\u0013H\u0017J'\u0010\u0080\u0001\u001a\u00020\u00172\u0006\u0010y\u001a\u00020\u00132\u0014\u0010o\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0017\u0018\u00010pH\u0017J\t\u0010\u0081\u0001\u001a\u00020,H\u0016J\t\u0010\u0082\u0001\u001a\u00020,H\u0016J)\u0010\u0083\u0001\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u0001j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0005\u0012\u00030\u0085\u0001`\u0086\u0001H\u0016J\t\u0010\u0087\u0001\u001a\u00020,H\u0016J\u0011\u0010\u0088\u0001\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\t\u0010\u0089\u0001\u001a\u00020,H\u0016J\u0011\u0010\u008a\u0001\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\t\u0010\u008c\u0001\u001a\u00020\u0017H\u0002J\t\u0010\u008d\u0001\u001a\u00020,H\u0016J\t\u0010\u008e\u0001\u001a\u00020,H\u0016J\t\u0010\u008f\u0001\u001a\u00020#H\u0016J\u0011\u0010\u0090\u0001\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\u0011\u0010\u0091\u0001\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\t\u0010\u0092\u0001\u001a\u00020,H\u0016J\u0011\u0010\u0093\u0001\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020\u00172\u0007\u0010\u0095\u0001\u001a\u00020#H\u0016J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0003\u0010\u0097\u0001J\f\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\u0019\u0010\u0099\u0001\u001a\u00020\u00172\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0002\u0010\\J\u0015\u0010\u009b\u0001\u001a\u00020\u00172\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\u0011\u0010\u009d\u0001\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010\u009e\u0001\u001a\u00020,H\u0016J\u0011\u0010\u009f\u0001\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010 \u0001\u001a\u00020,H\u0016J\t\u0010¡\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010¢\u0001\u001a\u00020\u00172\u0007\u0010£\u0001\u001a\u00020\u0013H\u0016J\u0011\u0010¤\u0001\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010¥\u0001\u001a\u00020,H\u0016J\t\u0010¦\u0001\u001a\u00020,H\u0016J\u0012\u0010§\u0001\u001a\u00020\u00172\u0007\u0010¨\u0001\u001a\u00020#H\u0016J\t\u0010©\u0001\u001a\u00020#H\u0016J\t\u0010ª\u0001\u001a\u00020,H\u0016J\u0012\u0010«\u0001\u001a\u00020\u00172\u0007\u0010¬\u0001\u001a\u00020,H\u0016J\t\u0010\u00ad\u0001\u001a\u00020,H\u0016J\u0013\u0010®\u0001\u001a\u00020\u00172\b\u0010¯\u0001\u001a\u00030°\u0001H\u0016J\n\u0010±\u0001\u001a\u00030°\u0001H\u0016J\u0012\u0010²\u0001\u001a\u00020\u00172\u0007\u0010³\u0001\u001a\u00020,H\u0016J\t\u0010´\u0001\u001a\u00020,H\u0016J\t\u0010µ\u0001\u001a\u00020\u0013H\u0017J\u0012\u0010¶\u0001\u001a\u00020\u00172\u0007\u0010£\u0001\u001a\u00020\u0013H\u0016J\u001b\u0010·\u0001\u001a\u00020\u00132\u0007\u0010¸\u0001\u001a\u00020\u00132\u0007\u0010¹\u0001\u001a\u00020\u0013H\u0016J\u0016\u0010º\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130»\u0001H\u0016J\u001b\u0010¼\u0001\u001a\u00020\u00172\u0007\u0010¸\u0001\u001a\u00020\u00132\u0007\u0010½\u0001\u001a\u00020\u0013H\u0016J\u0014\u0010¾\u0001\u001a\u00020\u00132\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0013H\u0003J\u0014\u0010¿\u0001\u001a\u00020\u00132\t\u0010£\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J\t\u0010À\u0001\u001a\u00020\u0013H\u0002J\u0012\u0010Á\u0001\u001a\u00020\u00132\u0007\u0010¸\u0001\u001a\u00020\u0013H\u0002J\u0018\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0002J\u0017\u0010Å\u0001\u001a\u00020\u0013*\u00030Ã\u00012\u0007\u0010Æ\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010Ç\u0001\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\t\u0010È\u0001\u001a\u00020,H\u0016J\t\u0010É\u0001\u001a\u00020,H\u0002J\u0011\u0010Ê\u0001\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\t\u0010Ë\u0001\u001a\u00020,H\u0016J\t\u0010Ì\u0001\u001a\u00020,H\u0016J\t\u0010Í\u0001\u001a\u00020\u0017H\u0016J\u0012\u0010Î\u0001\u001a\u00020\u00172\u0007\u0010Ï\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ð\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010Ñ\u0001\u001a\u00020\u00172\u0007\u0010Ò\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ó\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010Ô\u0001\u001a\u00020\u00172\u0007\u0010\u0095\u0001\u001a\u00020#H\u0016J\t\u0010Õ\u0001\u001a\u00020#H\u0016J\t\u0010Ö\u0001\u001a\u00020,H\u0016J\t\u0010×\u0001\u001a\u00020#H\u0016J\t\u0010Ø\u0001\u001a\u00020#H\u0016J\u0012\u0010Ù\u0001\u001a\u00020\u00172\u0007\u0010\u0095\u0001\u001a\u00020#H\u0016J\t\u0010Ú\u0001\u001a\u00020#H\u0016J\n\u0010Û\u0001\u001a\u00030Ü\u0001H\u0016J\u0012\u0010Ý\u0001\u001a\u00020#2\u0007\u0010Æ\u0001\u001a\u00020\u0013H\u0016J\u001a\u0010Þ\u0001\u001a\u00020\u00172\u0007\u0010Æ\u0001\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010ß\u0001\u001a\u00020\u00172\u0007\u0010Æ\u0001\u001a\u00020\u0013H\u0016J\u0012\u0010à\u0001\u001a\u00020\u00172\u0007\u0010\u0095\u0001\u001a\u00020#H\u0016J\t\u0010á\u0001\u001a\u00020#H\u0016J\u0013\u0010â\u0001\u001a\u00020\u00172\b\u0010ã\u0001\u001a\u00030°\u0001H\u0016J\n\u0010ä\u0001\u001a\u00030°\u0001H\u0016J\t\u0010å\u0001\u001a\u00020#H\u0016J\u0012\u0010æ\u0001\u001a\u00020\u00172\u0007\u0010ç\u0001\u001a\u00020#H\u0016J\n\u0010è\u0001\u001a\u00030°\u0001H\u0016J\u0013\u0010é\u0001\u001a\u00020\u00172\b\u0010ã\u0001\u001a\u00030°\u0001H\u0016J\n\u0010ê\u0001\u001a\u00030°\u0001H\u0016J\u0013\u0010ë\u0001\u001a\u00020\u00172\b\u0010ã\u0001\u001a\u00030°\u0001H\u0016J\n\u0010ì\u0001\u001a\u00030í\u0001H\u0016J\n\u0010î\u0001\u001a\u00030ï\u0001H\u0016J\u0012\u0010ð\u0001\u001a\u00020\u00172\u0007\u0010Ò\u0001\u001a\u00020\u0013H\u0016J\t\u0010ñ\u0001\u001a\u00020\u0013H\u0016J\n\u0010ò\u0001\u001a\u00030ó\u0001H\u0016J\n\u0010ô\u0001\u001a\u00030õ\u0001H\u0016J\n\u0010ö\u0001\u001a\u00030÷\u0001H\u0016J\n\u0010ø\u0001\u001a\u00030ù\u0001H\u0016J\n\u0010ú\u0001\u001a\u00030û\u0001H\u0016J\n\u0010ü\u0001\u001a\u00030ý\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030ÿ\u0001H\u0016J\n\u0010\u0080\u0002\u001a\u00030\u0081\u0002H\u0016J\n\u0010\u0082\u0002\u001a\u00030\u0083\u0002H\u0016J\n\u0010\u0084\u0002\u001a\u00030\u0085\u0002H\u0016J\n\u0010\u0086\u0002\u001a\u00030\u0087\u0002H\u0016J\u0016\u0010\u0088\u0002\u001a\u00030\u0089\u00022\n\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u008b\u0002H\u0016J\t\u0010\u008c\u0002\u001a\u00020,H\u0016J\n\u0010\u008d\u0002\u001a\u00030\u008e\u0002H\u0016J\n\u0010\u008f\u0002\u001a\u00030\u0090\u0002H\u0016J\n\u0010\u0091\u0002\u001a\u00030\u0092\u0002H\u0016J\n\u0010\u0093\u0002\u001a\u00030\u0094\u0002H\u0016J\n\u0010\u0095\u0002\u001a\u00030\u0096\u0002H\u0016J\n\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0016J\n\u0010\u0099\u0002\u001a\u00030\u009a\u0002H\u0016J\n\u0010\u009b\u0002\u001a\u00030\u009c\u0002H\u0016J\t\u0010\u009d\u0002\u001a\u00020\u0013H\u0016J\t\u0010\u009e\u0002\u001a\u00020,H\u0016J\t\u0010\u009f\u0002\u001a\u00020,H\u0016J\t\u0010 \u0002\u001a\u00020,H\u0016J\t\u0010¡\u0002\u001a\u00020,H\u0016J\u001d\u0010¢\u0002\u001a\u00020,2\u0007\u0010Æ\u0001\u001a\u00020\u00132\t\b\u0002\u0010¹\u0001\u001a\u00020,H\u0002J\u0012\u0010£\u0002\u001a\u00020\u00172\u0007\u0010¤\u0002\u001a\u00020\u0013H\u0016J\t\u0010¥\u0002\u001a\u00020\u0013H\u0016J\t\u0010¦\u0002\u001a\u00020\u0017H\u0016J\t\u0010§\u0002\u001a\u00020,H\u0016J\u0011\u0010¨\u0002\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\t\u0010©\u0002\u001a\u00020,H\u0016J\u0011\u0010ª\u0002\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\n\u0010«\u0002\u001a\u00030¬\u0002H\u0016J\n\u0010\u00ad\u0002\u001a\u00030®\u0002H\u0016J\"\u0010¯\u0002\u001a\u00020,*\u0005\u0018\u00010Ã\u00012\u0007\u0010Æ\u0001\u001a\u00020\u00132\u0007\u0010¹\u0001\u001a\u00020,H\u0002J\u0014\u0010°\u0002\u001a\u00020\u00132\t\u0010±\u0002\u001a\u0004\u0018\u00010\u0013H\u0016J\f\u0010²\u0002\u001a\u0005\u0018\u00010Ã\u0001H\u0016J\n\u0010³\u0002\u001a\u00030´\u0002H\u0016J\n\u0010µ\u0002\u001a\u00030¶\u0002H\u0016J\n\u0010·\u0002\u001a\u00030¸\u0002H\u0016J\n\u0010¹\u0002\u001a\u00030´\u0002H\u0016J\n\u0010º\u0002\u001a\u00030»\u0002H\u0016J\n\u0010¼\u0002\u001a\u00030½\u0002H\u0016J\t\u0010¾\u0002\u001a\u00020,H\u0016J\t\u0010¿\u0002\u001a\u00020,H\u0016J\t\u0010À\u0002\u001a\u00020,H\u0016J\t\u0010Á\u0002\u001a\u00020,H\u0016J\n\u0010Â\u0002\u001a\u00030Ã\u0002H\u0016J\t\u0010Ä\u0002\u001a\u00020#H\u0016J\t\u0010Å\u0002\u001a\u00020\u0013H\u0016J\u0012\u0010Æ\u0002\u001a\u00020\u00172\u0007\u0010Ç\u0002\u001a\u00020\u0013H\u0016J\t\u0010È\u0002\u001a\u00020,H\u0016J\u0011\u0010É\u0002\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\u0011\u0010Ê\u0002\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010Ë\u0002\u001a\u00020,H\u0016J\t\u0010Ì\u0002\u001a\u00020,H\u0016J\t\u0010Í\u0002\u001a\u00020,H\u0016J\n\u0010Î\u0002\u001a\u00030Ï\u0002H\u0016J\n\u0010Ð\u0002\u001a\u00030Ñ\u0002H\u0016J\u0015\u0010Ò\u0002\u001a\u0005\u0018\u00010Ã\u00012\u0007\u0010Æ\u0001\u001a\u00020\u0013H\u0016J\t\u0010Ó\u0002\u001a\u00020,H\u0016J\n\u0010Ô\u0002\u001a\u00030Õ\u0002H\u0016J\n\u0010Ö\u0002\u001a\u00030×\u0002H\u0016J\n\u0010Ø\u0002\u001a\u00030Ù\u0002H\u0016J\n\u0010Ú\u0002\u001a\u00030Û\u0002H\u0016J\t\u0010Ü\u0002\u001a\u00020,H\u0016J\u0011\u0010Ý\u0002\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\t\u0010Þ\u0002\u001a\u00020,H\u0016J\u0011\u0010ß\u0002\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\u0012\u0010à\u0002\u001a\u00020\u00172\u0007\u0010¨\u0001\u001a\u00020#H\u0016J\t\u0010á\u0002\u001a\u00020#H\u0016J\t\u0010â\u0002\u001a\u00020,H\u0016J\u0012\u0010ã\u0002\u001a\u00020\u00172\u0007\u0010ä\u0002\u001a\u00020,H\u0016J\n\u0010å\u0002\u001a\u00030æ\u0002H\u0016J\u0012\u0010ç\u0002\u001a\u00020\u00172\u0007\u0010è\u0002\u001a\u00020,H\u0016J\t\u0010é\u0002\u001a\u00020,H\u0016J\t\u0010ê\u0002\u001a\u00020,H\u0016J\u0011\u0010ë\u0002\u001a\u00020\u00172\u0006\u0010A\u001a\u00020,H\u0016J\u0014\u0010ì\u0002\u001a\u00020,2\t\u0010í\u0002\u001a\u0004\u0018\u00010\u0013H\u0016J\u001d\u0010î\u0002\u001a\u00020\u00172\t\u0010í\u0002\u001a\u0004\u0018\u00010\u00132\u0007\u0010ï\u0002\u001a\u00020,H\u0016J\u0012\u0010ð\u0002\u001a\u00020\u00132\u0007\u0010í\u0002\u001a\u00020\u0013H\u0002J\n\u0010ñ\u0002\u001a\u00030ò\u0002H\u0016J\n\u0010ó\u0002\u001a\u00030ô\u0002H\u0016J\n\u0010õ\u0002\u001a\u00030ö\u0002H\u0016J\n\u0010÷\u0002\u001a\u00030ø\u0002H\u0016J\n\u0010ù\u0002\u001a\u00030ú\u0002H\u0016J\n\u0010û\u0002\u001a\u00030ü\u0002H\u0016J\n\u0010ý\u0002\u001a\u00030þ\u0002H\u0016J\n\u0010ÿ\u0002\u001a\u00030\u0080\u0003H\u0016J\u0012\u0010\u0081\u0003\u001a\u00020\u00172\u0007\u0010\u0082\u0003\u001a\u00020\u000bH\u0016J\u0012\u0010\u0083\u0003\u001a\u00020\u00172\u0007\u0010\u0082\u0003\u001a\u00020\u000bH\u0016J\t\u0010\u0084\u0003\u001a\u00020\u0017H\u0016J\t\u0010\u0085\u0003\u001a\u00020,H\u0016J\t\u0010\u0086\u0003\u001a\u00020,H\u0016J\u0014\u0010\u0087\u0003\u001a\u00020\u00172\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J\u0014\u0010\u0088\u0003\u001a\u00020\u00172\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J\t\u0010\u0089\u0003\u001a\u00020,H\u0016J\u0011\u0010\u008a\u0003\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010\u008b\u0003\u001a\u00020,H\u0016J\u0011\u0010\u008c\u0003\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,H\u0016J\f\u0010\u008d\u0003\u001a\u0005\u0018\u00010\u008e\u0003H\u0016J\u0015\u0010\u008f\u0003\u001a\u00030°\u00012\t\b\u0001\u0010\u0095\u0001\u001a\u00020#H\u0017J \u0010\u0090\u0003\u001a\u00020\u00172\t\b\u0001\u0010\u0095\u0001\u001a\u00020#2\n\b\u0001\u0010\u0091\u0003\u001a\u00030°\u0001H\u0016J\t\u0010\u0092\u0003\u001a\u00020,H\u0016J\t\u0010\u0093\u0003\u001a\u00020,H\u0016J\u0011\u0010\u0094\u0003\u001a\u00020\u00172\u0006\u0010d\u001a\u00020,H\u0016J\u0014\u0010\u0095\u0003\u001a\u00020\u00132\t\b\u0001\u0010\u0095\u0001\u001a\u00020#H\u0002J\u0015\u0010\u0096\u0003\u001a\u00030°\u00012\t\b\u0001\u0010\u0095\u0001\u001a\u00020#H\u0003J\u001f\u0010\u0097\u0003\u001a\u00030°\u00012\t\b\u0001\u0010\u0095\u0001\u001a\u00020#2\b\u0010\u0091\u0003\u001a\u00030°\u0001H\u0003J\t\u0010\u0098\u0003\u001a\u00020#H\u0016J\t\u0010\u0099\u0003\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008b\u0001\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u009c\u0003"}, d2 = {"Lcom/obric/assistant/ObricSettingsServiceImpl;", "Lcom/obric/assistant/IObricSettingsApi;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "globalKeva", "obricCloudSettings", "Lcom/obric/assistant/IObricCloudSettings;", "settingsChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/IOnObricSettingsChangedListener;", "settingsNotifyExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "kevaChangeListener", "Lcom/bytedance/keva/Keva$OnChangeListener;", "globalKevaChangeListener", "userID", XmlPullParser.NO_NAMESPACE, "getUserID", "()Ljava/lang/String;", "initKeva", XmlPullParser.NO_NAMESPACE, "getDeviceUuidOwnerUid", "getDeviceUuidKeva", "ownerUid", "initGlobalKeva", "migrateSettings", "migrateImproveVoiceWakeupEnableKey", "migrateLockedUseVoicePrintSettings", "migrateLockedUseAuthenticationSettings", "migrateLockedUseAuthenticationSetting", "legacyKey", "defaultAuthType", XmlPullParser.NO_NAMESPACE, "migrateLocalDataMemoryMergeSettings", "getLockedUseAuthenticationType", "saveLockedUseAuthenticationType", "type", "getDefaultAuthTypeForBasicLockedUseItems", "normalizeLockedUseAuthenticationType", "saveLockedScreenUseEnabled", "enable", XmlPullParser.NO_NAMESPACE, "isLockedScreenUseEnabled", "saveVoicePrintAuthenticationTypeForLockedUseSettings", "isSetDefaultSettingItems", "currentSettingItems", XmlPullParser.NO_NAMESPACE, "isNewTopicLockedEnabled", "saveNewTopicLockedEnabled", "getAuthenticationTypeOfChatAndOnlineQAOnLockScreen", "saveAuthenticationTypeOfChatAndOnlineQAOnLockScreen", "isAutoGuiExecuteOnLockScreenEnabled", "saveAutoGuiExecuteOnLockScreenEnabled", "getAuthenticationTypeOfAutoGuiExecuteOnLockScreen", "saveAuthenticationTypeOfAutoGuiExecuteOnLockScreen", "isVoicePrintAuthenticateOnLockScreenEnabled", "saveVoicePrintAuthenticateOnLockScreenEnabled", "isVoicePrintAuthenticateAutoGuiEnabled", "setVoicePrintAuthenticateAutoGuiEnabled", "showVoicePrintAuthenticateAutoGuiEnabledRedPot", "isVoicePrintManagementRedPotShown", "setVoicePrintManagementRedPotShown", "shown", "getAuthenticationTypeOfGlobalMemoryAccessOnLockScreen", "saveAuthenticationTypeOfGlobalMemoryAccessOnLockScreen", "getAuthenticationTypeOfPersonalInfoAccessOnLockScreen", "saveAuthenticationTypeOfPersonalInfoAccessOnLockScreen", "getAuthenticationTypeOfChatHistoryAccessOnLockScreen", "saveAuthenticationTypeOfChatHistoryAccessOnLockScreen", "getAuthenticationTypeOfLocalAppDataAccessOnLockScreen", "saveAuthenticationTypeOfLocalAppDataAccessOnLockScreen", "getAuthenticationTypeOfSimpleCommandExecuteOnLockScreen", "saveAuthenticationTypeOfSimpleCommandExecuteOnLockScreen", "isUserHasSetAuthenticationTypeOfGlobalMemoryAccessOnLockScreen", "isUserHasSetAuthenticationTypeOfPersonalInfoAccessOnLockScreen", "isUserHasSetAuthenticationTypeOfChatHistoryAccessOnLockScreen", "isUserHasSetAuthenticationTypeOfLocalAppDataAccessOnLockScreen", "isUserHasSetAuthenticationTypeOfSimpleCommandExecuteOnLockScreen", "isUserGuideTipsShown", "setUserGuideTipsShown", "isMainBotIconEnabled", "isMainBotIconReallyEnabled", "iconAction", "Lcom/obric/assistant/ObricSettingsServiceImpl$IconAction;", "enableMainBotIcon", "disableMainBotIcon", "doDisableMainBotIcon", "doEnableMainBotIcon", "currentSelectAppIconId", "(Ljava/lang/Integer;)V", "preparePendingAction", "pendingAction", "executePendingAction", "cvsId", "(Ljava/lang/Integer;Ljava/lang/String;)V", "isVoiceWakeupEnabled", "setVoiceWakeupEnabled", "enabled", "setVoiceWakeupEnabledInternal", "isImproveVoiceWakeupEnabled", "setImproveVoiceWakeupEnabled", "isVoiceWakeupImproveNotificationShown", "setVoiceWakeupImproveNotificationShown", "isVoiceNoiseReductionUpgradeNoticeAcknowledged", "setVoiceNoiseReductionUpgradeNoticeAcknowledged", "acknowledged", "isVoicePrintExisted", "clearVoicePrint", "callback", "Lkotlin/Function1;", "uploadDefaultVoicePrintToCloud", "deleteDefaultVoicePrintFromCloud", "setDefaultVoicePrintTrainable", "isTrainable", "isDefaultVoicePrintUploadedToCloud", "isDefaultVoicePrintRecordedWithMic0Flow", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted", "getDeviceEnrollStatus", "macId", "getEnrolledDevices", "Lkotlin/Pair;", "getEnrolledDeviceInfos", "Lcom/obric/assistant/ObricEnrolledDeviceInfo;", "updateEnrolledDeviceName", "newName", "deleteEnrolledDevice", "isCheckUpdateDialogEnabled", "isCheckUpdateEntryEnabled", "obricPluginsConfig", "Ljava/util/HashMap;", XmlPullParser.NO_NAMESPACE, "Lkotlin/collections/HashMap;", "isMemoryEnabled", "saveMemoryEnabled", "isTtsPlayBackgroundEnabled", "setTtsPlayBackgroundEnabled", "ttsBackgroundPlayMigrated", "migrateTtsBackgroundPlaySettingIfNeeded", "isSemanticScreenShotEnabled", "isAutoImageUploadEnabled", "getAutoGuiEnabledScene", "setSemanticScreenShotEnabled", "setAutoImageUploadEnabled", "isAutoImageUploadEnabledInPrivacy", "setAutoImageUploadEnabledInPrivacy", "setAutoGuiEnabledScene", "scene", "getObricDefaultReplyMode", "()Ljava/lang/Integer;", "getObricDefaultReplyModeOption", "setObricDefaultReplyMode", "itemId", "setObricDefaultReplyOption", "option", "setOUseMemoryEnabled", "getOUseMemoryEnabled", "setOUseClipboardEnabled", "getOUseClipboardEnabled", "getAutoGuiFastModeUseSettings", "setAutoGuiFastModeUseSettings", "value", "setSkillExtensionEnabled", "getSkillExtensionEnabled", "hasSkillExtensionEnabledCache", "setOmniSkillAvailableState", "state", "getOmniSkillAvailableState", "isOmniSkillUsable", "setSkillExtensionActionBarNewHasTriggered", "triggered", "getSkillExtensionActionBarNewHasTriggered", "setSkillExtensionActionBarNewExpireAtMs", "expireAtMs", XmlPullParser.NO_NAMESPACE, "getSkillExtensionActionBarNewExpireAtMs", "setSkillExtensionActionBarNewConsumed", "consumed", "getSkillExtensionActionBarNewConsumed", "getRiskPreferenceSettings", "setRiskPreferenceSettings", "getAutoExecuteAuthorizationStatus", "authorizationKey", "defaultValue", "getAutoExecuteAuthorizationStatusMap", XmlPullParser.NO_NAMESPACE, "setAutoExecuteAuthorizationStatus", "status", "normalizeRiskPreferenceSettingsValue", "normalizeAutoGuiFastModeUseSettings", "defaultAutoGuiFastModeUseSettings", "autoExecuteAuthorizationStorageKey", "resolveAutoExecuteAuthorizationPageConfig", "Lcom/google/gson/JsonObject;", "configJson", "getAsSafeString", "key", "setDoubaoWhisperEnabled", "isDoubaoWhisperEnabled", "getDoubaoWhisperEnabledFromInteractor", "setDoubaoWhisperDataUploadEnabled", "isDoubaoWhisperDataUploadEnabled", "isNotFirstDoubaoWhisperEnabled", "setFirstDoubaoWhisperEnableFinished", "setComplexTaskMode", "mode", "getComplexTaskMode", "setComplexTaskLlmModel", "model", "getComplexTaskLlmModel", "setComplexTaskLocalSearchEnabled", "getComplexTaskLocalSearchEnabledScene", "isPersonalContextOpened", "getObricPowerLockTimeoutInSeconds", "getObricKeepFrontierAliveLoopIntervalInSeconds", "setObricIntentUploadStrategyForDebug", "getObricIntentUploadStrategyForDebug", "getComplexTaskSettingsConfig", "Lcom/obric/assistant/ComplexTaskSettingsConfig;", "getTtsPlayOptionEnable", "setTtsPlayOptionEnable", "clearTtsPlayOptionEnable", "setObricComplexTaskIslandStrategyForDebug", "getObricComplexTaskIslandStrategyForDebug", "setObricPerformanceMonitorKillTime", "timeMillis", "getObricPerformanceMonitorKillTime", "getObricLocalSettingsVersion", "setObricLocalSettingsVersion", "version", "getObricSettingsCheckTime", "setObricSettingsCheckTime", "getObricSettingsPullTime", "setObricSettingsPullTime", "getSelfUpdateSettingsConfig", "Lcom/obric/assistant/SelfUpdateSettingsConfig;", "getUpdateSettingsConfig", "Lcom/obric/assistant/UpdateSettingsConfig;", "setCurrentModel", "getCurrentModel", "getModelSettingsConfig", "Lcom/obric/assistant/settings/config/ModelSettingsConfig;", "getVoicePrintAuthenticateSettingsConfig", "Lcom/obric/assistant/VoicePrintAuthenticateSettingsConfig;", "getQueryAuthenticateConfig", "Lcom/obric/assistant/QueryAuthenticateConfig;", "getSecuritySettingsConfig", "Lcom/obric/assistant/SecuritySettingsConfig;", "getObricSecuritySettingsPackageWhitelistConfig", "Lcom/obric/assistant/ObricSecuritySettingsPackageWhitelistConfig;", "getFeatureConfigMap", "Lcom/obric/aiagent/assistant/idl/bean/FeatureConfigMap;", "getObricComplexTaskCaseFromPC", "Lcom/obric/assistant/ComplexTaskCaseFromPCConfig;", "getObricAutoIncreaseDelayedTimeConfig", "Lcom/obric/assistant/AutoIncreaseDelayedTimeConfig;", "getObricProcessesManagerConfig", "Lcom/obric/assistant/ObricProcessesManagerConfig;", "getObricAppLogSettingsConfig", "Lcom/obric/assistant/ObricAppLogSettingsConfig;", "getObricLogSettingsConfig", "Lcom/obric/assistant/ObricLogSettingsConfig;", "getObricSettingsListConfig", "Lcom/obric/assistant/ObricSettingsListConfig;", "appSettings", "Lorg/json/JSONObject;", "enableObricSettingsOverride", "getObricPerformanceMonitorConfig", "Lcom/obric/assistant/ObricPerformanceMonitorConfig;", "getObricMemoryReportConfig", "Lcom/obric/assistant/ObricMemoryReportConfig;", "getObricThresholdDumpHprofConfig", "Lcom/obric/assistant/ObricThresholdDumpHprofConfig;", "getObricThreshlodPssUploadFilesConfig", "Lcom/obric/assistant/ObricThresholdPssUploadFilesConfig;", "getObricCrashDumpHprofConfig", "Lcom/obric/assistant/ObricCrashDumpHprofConfig;", "getObricSettingsConfig", "Lcom/obric/assistant/ObricSettingsConfig;", "getObricOneLoginConfig", "Lcom/obric/assistant/ObricOneLoginConfig;", "getObricBreathWakeupDataTracker", "Lcom/obric/assistant/BreathWakeupDataTrackerConfig;", "getVoiceWakeupSidThresholdConfigForCurrentModel", "isBypassAdaptiveSid", "isPhoneOperationNormalFileUploadSupported", "isPhoneOperationSpecialFileUploadSupported", "isPhoneOperationOnlyAttachmentSendSupported", "getPhoneOperationFileUploadEnabled", "setDeviceUUID", "did", "getDeviceUUID", "resetDeviceUUID", "isPcInAsrEnabled", "setPcInAsrEnabled", "isPcInAsrPolicyAgreed", "setPcInAsrPolicyAgreed", "getObricAutoGuiBlacklistConfig", "Lcom/obric/assistant/AutoGuiBlacklistConfig;", "getAutoGuiAppScopeConfig", "Lcom/obric/assistant/AutoGuiAppScopeConfig;", "booleanOrDefault", "getObricFlowSettingsJson", "settingKey", "getOAutoSettings", "getObricActionBarItemsConfig", "Lcom/obric/assistant/ObricActionBarItemsConfig;", "getObricActionBarModelMenuConfig", "Lcom/obric/assistant/ObricActionBarModelMenuConfig;", "getObricBottomTabConfig", "Lcom/obric/assistant/ObricBottomTabConfig;", "getWindowActionBarItemsConfig", "getObricDeepThinkModeRestTimeConfig", "Lcom/obric/assistant/ObricDeepThinkModeRestTimeConfig;", "getObricPromptCellConfig", "Lcom/obric/assistant/ObricPromptCellConfig;", "isAsrFeedbackEnable", "isContTalkSwitchShowEnable", "isObricContTalkPvadSwitchShowEnable", "isReRecordWakeWordGuideEnable", "getWakeupSoundConfig", "Lcom/obric/assistant/ObricWakeupSoundConfig;", "getWakeupSoundConfigWhite", "getSelectedWakeupSoundId", "setSelectedWakeupSoundId", "soundId", "isLarkKnowledgeAuthorizationEnable", "setLarkKnowledgeAuthorizationEnable", "saveAlwaysRespondToVoiceWakeup", "isAlwaysRespondToVoiceWakeup", "isDoraFeatureEnable", "isDoraSettingEntranceDegrade", "getObricTaskTimeoutConfig", "Lcom/obric/assistant/ObricTimeoutConfig;", "getObricAiKeyConfig", "Lcom/obric/assistant/ObricAiKeyConfig;", "getObricCloudConfig", "isObricDoraGNewDeviceManageEnable", "getObricMemoryDataCollectConfig", "Lcom/obric/aiagent/assistant/idl/bean/ObricMemoryDataCollectConfig;", "getObricPowerLockConfig", "Lcom/obric/assistant/ObricPowerLockConfig;", "getObricStateMachineMultitaskConfig", "Lcom/obric/assistant/ObricStateMachineMultitaskConfig;", "getObricAigcGenerationStateConfig", "Lcom/obric/assistant/ObricAigcGenerationStateConfig;", "isConversationContentModelTrainingEnable", "setConversationContentModelTrainingEnable", "isUserExperiencePlanEnabled", "setUserExperiencePlanEnabled", "setStartAsDefaultAssistant", "getStartAsDefaultAssistant", "isSecurityCertificateReady", "setSecurityCertificateReady", "ready", "getObricLarkConfirmSettingsConfig", "Lcom/obric/assistant/ObricLarkConfirmConfig;", "setObricMinorModeInstructionsReadByUser", "alreadyRead", "getObricMinorModeInstructionsReadByUser", "isBatchRequestInitPermissionDialogShown", "setBatchRequestInitPermissionDialogShown", "isEnterpriseAccountTipNeverShow", "personalUid", "setEnterpriseAccountTipNeverShow", "neverShow", "getEnterpriseAccountTipNeverShowKey", "getObricImageUploadCompressConfig", "Lcom/obric/assistant/settings/config/ObricImageUploadCompressConfig;", "getObricAppIntentScreenshotCacheConfig", "Lcom/obric/assistant/ObricAppIntentScreenshotCacheConfig;", "getObricScreenshotUploadConfig", "Lcom/obric/assistant/ObricScreenshotUploadConfig;", "getObricPerformancePowerMonitorSettingsConfig", "Lcom/obric/performance/power/monitor/constants/ObricPerformancePowerMonitorConfig;", "getObricPerformanceCPUExceptionDiagnosisSettingsConfig", "Lcom/obric/performance/power/monitor/cpu/exception/CPUExceptionDiagnosisConfig;", "getObricAIagentNetworkInterceptConfig", "Lcom/obric/assistant/ObricAIagentNetworkInterceptConfig;", "getObricZeusAutoFetchConfig", "Lcom/obric/assistant/ZeusAutoFetchConfig;", "getObricLazyInitConfig", "Lcom/obric/assistant/ObricLazyInitConfig;", "registerSettingsChangedListener", "listener", "unregisterSettingsChangedListener", "registerMessageExt", "isCloseAudioConnAppBackGroundOnlyForObric", "isVoiceSectionTrackerEnableSlardar", "dispatchSettingsChanged", "notifySettingsChanged", "isContinueSpeakEnable", "setContinueSpeakerEnabled", "isContinueSpeakNoiseReductionEnable", "setContinueSpeakNoiseReductionEnabled", "getMmtVideoHardwareConfig", "Lcom/obric/assistant/settings/config/ObricMmtVideoHardwareConfig;", "getAutoEndConversationTime", "setAutoEndConversationTime", "time", "isObricGazeKeepDisplaySupported", "isObricGazeKeepDisplayEnabled", "setObricGazeKeepDisplayEnabled", "autoEndConversationKey", "defaultAutoEndConversationTime", "normalizeAutoEndConversationTime", "getObricPrivacyLaneType", "getVoiceWakeupStage1UserConfig", "Companion", "IconAction", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricSettingsServiceImpl implements IObricSettingsApi {
    public static final /* synthetic */ int k = 0;
    public Keva a;
    public Keva b;
    public final IObricCloudSettings c;
    public final CopyOnWriteArrayList<m> d;
    public final ExecutorService e;
    public final f2 f;
    public final q2 g;
    public IconAction h;
    public IconAction i;
    public boolean j;

    public static final class a implements j {
        public final /* synthetic */ ObricSettingsServiceImpl a;

        @Override // n38.j
        public final void a(n38.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public a(ObricSettingsServiceImpl r1) {
            this.a = r1;
        }

        @Override // n38.j
        public final void b(n38.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            ObricSettingsServiceImpl r3 = this.a;
            int r0 = ObricSettingsServiceImpl.k;
            r3.f2();
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean I() {
        return false;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricAigcGenerationStateConfig getObricAigcGenerationStateConfig() {
        JsonObject r2 = (JsonObject) l0.a(null, new j3(this));     // Catch: Exception -> L9
        if (r2 == null) goto L7;
        ObricAigcGenerationStateConfig r3 = (ObricAigcGenerationStateConfig) new Gson().fromJson(r2.toString(), ObricAigcGenerationStateConfig.class);     // Catch: Exception -> L9
        if (r3 == null) goto L7;
        return r3;
    L7:
        return new ObricAigcGenerationStateConfig(null, 1, null);
    L9:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricAigcGenerationStateConfig, error: " + e);
        return new ObricAigcGenerationStateConfig(null, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void h1() {
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean o1() {
        return c2("enable_special", true);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean r() {
        return c2("enable_normal", true);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final AutoGuiAppScopeConfig s0() {
        JsonObject r2 = (JsonObject) l0.a(null, new t3(this));     // Catch: Exception -> L24
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        if (r2 == null) goto L14;
        JsonElement r3 = r2.get("enable_saep_restricted_packages");     // Catch: Throwable -> L17
        if (r3 == null) goto L14;
        if (r3.isJsonNull() == false) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
        boolean r4 = r3.getAsBoolean();     // Catch: Throwable -> L17
    L15:
        Object r6 = Result.m49constructorimpl(Boolean.valueOf(r4));     // Catch: Throwable -> L17
    L19:
        Boolean r7 = Boolean.TRUE;     // Catch: Exception -> L24
        if (Result.m55isFailureimpl(r6) == false) goto L22;
        r6 = r7;
    L22:
        return new AutoGuiAppScopeConfig(((Boolean) r6).booleanValue());
    L14:
        r4 = true;
    L17:
        th = move-exception;
        Result.Companion r8 = Result.Companion;     // Catch: Exception -> L24
        r6 = Result.m49constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getAutoGuiAppScopeConfig, error", e);
        return new AutoGuiAppScopeConfig(false, 1, null);
    }

    public static String a2() {
        String r0 = ObricAccountSPIServiceDelegate.b.a();
        if (r0 == null) goto L11;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return d2();
    }

    public static String d2() {
        return ILoginService.a.getAccountInfo().c;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void A0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("voice_print_management_red_pot", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int A1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getInt("obric_settings_version", 0);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean B() {
        return VoiceEnrollServiceDelegate.c.f();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean D1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("continue_speak_noise_reduction_enable", false);
        FLogger.a.i("ObricSettingRepo", "isContinueSpeakNoiseReductionEnable: enabled = " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void E0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setSkillExtensionActionBarNewHasTriggered, triggered: true");
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("skill_extension_actionbar_new_has_triggered", true);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final long E1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getLong("performance_monitor_kill_time", 0);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final long G() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getLong("obric_settings_pull_time", 0);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean G0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("skill_extension_actionbar_new_consumed", false);
        FLogger.a.i("ObricSettingRepo", "getSkillExtensionActionBarNewConsumed, ret: " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @Deprecated(message = "use getAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    public final boolean G1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getBoolean("execute_auto_gui_locked_enabled", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int H() {
        int r0 = l0.a;
        return ((Number) l0.a(0, new t2(this))).intValue();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final SecuritySettingsConfig I0() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new SecuritySettingsConfig(false, false, false, false, 0, 31, null), new p3(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getSecuritySettingsConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        SecuritySettingsConfig r6 = (SecuritySettingsConfig) new Gson().fromJson(String.valueOf(r4), SecuritySettingsConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getSecuritySettingsConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getSecuritySettingsConfig, error: " + e);
        return new SecuritySettingsConfig(false, false, false, false, 0, 31, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean I1() {
        if (this.a != null) goto L6;
        f2();
    L6:
        if (ILoginService.a.getAccountInfo().g == false) goto L8;
        boolean r0 = false;
    L9:
        Keva r1 = this.a;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r1 = null;
    L13:
        return r1.getBoolean("auto_image_upload_enable", r0);
    L8:
        r0 = g0();
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean J0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getBoolean("conversation_content_model_training_enable", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void J1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("voice_wakeup_improve_notification_shown", true);
        FLogger.a.i("ObricSettingRepo", "setVoiceWakeupImproveNotificationShown: shown = true");
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean K0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("voice_wakeup_improve_notification_shown", false);
        FLogger.a.i("ObricSettingRepo", "isVoiceWakeupImproveNotificationShown: shown = " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean K1() {
        int r3 = l0.a;     // Catch: Exception -> L7
        Object r4 = l0.a(l.o, new y3(this));     // Catch: Exception -> L7
        ObricAsrFeedbackConfig r5 = (ObricAsrFeedbackConfig) new Gson().fromJson(String.valueOf(r4), ObricAsrFeedbackConfig.class);     // Catch: Exception -> L7
        FLogger.a.i("ObricSettingRepo", "getObricAsrFeedbackConfig, " + this.c + ", " + r4 + ", " + r5);     // Catch: Exception -> L7
        Boolean r0 = r5.getEnableAsrFeedback();     // Catch: Exception -> L7
        if (r0 == null) goto L9;
        return r0.booleanValue();
    L9:
        return false;
    L7:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricAsrFeedbackConfig, error: " + e);
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String L() {
        String r4 = null;
        JsonObject r3 = (JsonObject) l0.a(null, new l2(this));     // Catch: Exception -> L10
        if (r3 == null) goto L6;
        r4 = r3.toString();     // Catch: Exception -> L10
    L6:
        if (r4 != null) goto L8;
        r4 = XmlPullParser.NO_NAMESPACE;
    L8:
        FLogger.a.i("ObricSettingRepo", "getVoiceWakeupStage1UserConfig, result=".concat(r4));     // Catch: Exception -> L10
        return r4;
    L10:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getVoiceWakeupStage1UserConfig error: " + e);
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final UpdateSettingsConfig L0() {
        int r4 = l0.a;     // Catch: Exception -> L5
        Object r5 = l0.a(new UpdateSettingsConfig(0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 255, null), new h2(this));     // Catch: Exception -> L5
        FLogger r6 = FLogger.a;     // Catch: Exception -> L5
        r6.d("ObricSettingRepo", "getSelfUpdateSettingsConfig, " + this.c + ", " + r5);     // Catch: Exception -> L5
        UpdateSettingsConfig r7 = (UpdateSettingsConfig) new Gson().fromJson(String.valueOf(r5), UpdateSettingsConfig.class);     // Catch: Exception -> L5
        r6.i("ObricSettingRepo", "getSelfUpdateSettingsConfig, " + this.c + ", " + r5 + ", " + r7);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L5
        return r7;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getSelfUpdateSettingsConfig, error: " + e);
        return new UpdateSettingsConfig(0, 0, 0, 0, 0, 0.0f, 0.0f, 0, 255, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int M() {
        int r3 = l0.a;     // Catch: Exception -> L7
        Object r4 = l0.a(new ObricPowerLockConfig(null, null, null, null, null, 31, null), new c2(this));     // Catch: Exception -> L7
        FLogger r5 = FLogger.a;     // Catch: Exception -> L7
        r5.d("ObricSettingRepo", "getObricKeepFrontierAliveLoopIntervalInSeconds, " + this.c + ", " + r4);     // Catch: Exception -> L7
        ObricPowerLockConfig r6 = (ObricPowerLockConfig) new Gson().fromJson(String.valueOf(r4), ObricPowerLockConfig.class);     // Catch: Exception -> L7
        r5.i("ObricSettingRepo", "getObricKeepFrontierAliveLoopIntervalInSeconds, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L7
        Integer r0 = r6.getObricKeepFrontierAliveLoopInterval();     // Catch: Exception -> L7
        if (r0 == null) goto L9;
        return r0.intValue();
    L9:
        return 1;
    L7:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricKeepFrontierAliveLoopIntervalInSeconds, error: " + e);
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean N() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getBoolean("continue_speak_enable", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricThresholdPssUploadFilesConfig N0() {
        int r3 = l0.a;     // Catch: Exception -> L8
        Object r4 = l0.a(new ObricThresholdPssUploadFilesConfig(false, 0, null, 7, null), new a3(this));     // Catch: Exception -> L8
        ObricThresholdPssUploadFilesConfig r5 = (ObricThresholdPssUploadFilesConfig) new Gson().fromJson(String.valueOf(r4), ObricThresholdPssUploadFilesConfig.class);     // Catch: Exception -> L8
        if (r5 != null) goto L6;
        r5 = new ObricThresholdPssUploadFilesConfig(false, 0, null, 7, null);     // Catch: Exception -> L8
    L6:
        FLogger.a.i("ObricSettingRepo", "getObricThreshlodPssUploadFilesConfig, " + this.c + ", " + r4 + ", " + r5);     // Catch: Exception -> L8
        return r5;
    L8:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricThreshlodPssUploadFilesConfig, error: " + e);
        return new ObricThresholdPssUploadFilesConfig(false, 0, null, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final long N1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getLong("obric_settings_check_time", 0);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @RiskPreferenceSettings
    public final String O() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return "2";
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        String r1 = m2(r0.getString("risk_preference_settings", "2"));
        FLogger.a.i("ObricSettingRepo", "getRiskPreferenceSettings, ret: ".concat(r1));
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int O0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return -1;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        int r1 = r0.getInt("omni_skill_available_state", -1);
        FLogger.a.i("ObricSettingRepo", "getOmniSkillAvailableState, ret: " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean P() {
        int r3 = l0.a;     // Catch: Exception -> L7
        Object r4 = l0.a(l.p, new g4(this));     // Catch: Exception -> L7
        ObricContTalkConfig r5 = (ObricContTalkConfig) new Gson().fromJson(String.valueOf(r4), ObricContTalkConfig.class);     // Catch: Exception -> L7
        FLogger.a.i("ObricSettingRepo", "getObricContTalkConfig, " + this.c + ", " + r4 + ", " + r5);     // Catch: Exception -> L7
        Boolean r0 = r5.getEnableContTalk();     // Catch: Exception -> L7
        if (r0 == null) goto L9;
        return r0.booleanValue();
    L9:
        return false;
    L7:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricContTalkConfig, error: " + e);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.common.apphost.AppHost$Companion] */
    /* JADX WARN: Type inference failed for: r0v2 */
    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean P0() {
        ContentProviderClient r0 = AppHost.a;
        if (com.obric.assistant.utils.j.c(r0.getApplication()) == true) goto L6;
        FLogger.a.i("ObricSettingRepo", "isDoubaoWhisperDataUploadEnabled return false because current app is not an assitant role , just return");
        return false;
    L6:
        Bundle r1 = null;
        ContentProviderClient r2 = X1(r0.getApplication().getContentResolver(), k.a);     // Catch: Throwable -> L15 RemoteException -> L17
        if (r2 != null) goto L32;
    L13:
        if (r2 == null) goto L22;
    L14:
        r2.close();
    L22:
        if (r1 != null) goto L24;
        return false;
    L24:
        if (r1.getBoolean("status", false) != true) goto L36;
        return true;
    L36:
        return false;
    L32:
        r1 = r2.call("breath-upload-get-status", null, null);     // Catch: RemoteException -> L11 Throwable -> L27
    L11:
        e = e;
    L19:
        e.printStackTrace();     // Catch: Throwable -> L27
        if (r2 == null) goto L22;
    L27:
        Throwable th = th;
    L28:
        if (r0 == 0) goto L30;
        r0.close();
    L30:
        throw th;
    L17:
        e = e;
        r2 = null;
    L15:
        th = move-exception;
        th = th;
        r0 = 0;
        goto L28
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String Q() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return "claude-37";
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        String r0 = i0().getDefaultComplexTaskLlmModel();
        Keva r1 = this.a;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r1 = null;
    L12:
        String r2 = r1.getString("complex_task_llm_model", r0);
        FLogger.a.d("ObricSettingRepo", "getComplexTaskLlmModel, cloudDefaultModel: " + r0 + ", ret: " + r2);
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int Q1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L9;
        f2();
    L9:
        return b2("authentication_type_of_chat_history_access_on_lock_screen", 0);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final JsonObject S() {
        return this.c.getObricAutoSettingsJson();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean S1() {
        int r0 = l0.a;
        boolean r1 = ((Boolean) l0.a(Boolean.FALSE, new k3(this))).booleanValue();
        FLogger.a.i("ObricSettingRepo", "isObricDoraGNewDeviceManageEnable, enabled=" + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean T() {
        if (this.b != null) goto L5;
        e2();
    L5:
        Keva r0 = this.b;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r0 = null;
    L9:
        return r0.getBoolean("security_certificate_ready", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int T0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 1;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getInt("complex_task_local_search_enable", 1);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void U() {
        this.h = IconAction.ENABLE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean V1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getBoolean("voice_noise_reduction_upgrade_notice_acknowledged", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int W() {
        ILoginService.Companion r0 = ILoginService.a;
        int r2 = 0;
        if (r0.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L9;
        f2();
    L9:
        if (r0.getAccountInfo().g == true) goto L13;
        r2 = 2;
    L13:
        return b2("authentication_type_of_simple_command_execute_on_lock_screen", r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void W0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.b != null) goto L8;
        e2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setBatchRequestInitPermissionDialogShown, true");
        Keva r0 = this.b;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r0 = null;
    L11:
        r0.storeBoolean("batch_request_init_permission_dialog_shown", true);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean W1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.b != null) goto L8;
        e2();
    L8:
        Keva r0 = this.b;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("batch_request_init_permission_dialog_shown", false);
        FLogger.a.i("ObricSettingRepo", "isBatchRequestInitPermissionDialogShown, " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void X0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("voice_noise_reduction_upgrade_notice_acknowledged", true);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean Y() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return false;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        boolean r1 = r0.contains("skill_extension_enable");
        FLogger.a.i("ObricSettingRepo", "hasSkillExtensionEnabledCache, ret: " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ModelSettingsConfig Y0() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new ModelSettingsConfig(0, false, null, null, 15, null), new c3(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getModelSettingsConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ModelSettingsConfig r6 = (ModelSettingsConfig) new Gson().fromJson(String.valueOf(r4), ModelSettingsConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getModelSettingsConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getModelSettingsConfig, error: " + e);
        return new ModelSettingsConfig(0, false, null, null, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final long Z0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        long r1 = r0.getLong("skill_extension_actionbar_new_expire_at_ms", 0);
        FLogger.a.i("ObricSettingRepo", "getSkillExtensionActionBarNewExpireAtMs, ret: " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final BreathWakeupDataTrackerConfig a0() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new BreathWakeupDataTrackerConfig(false, null, null, 0, 15, null), new w1(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricBreathWakeupDataTracker, " + this.c + ", " + r4);     // Catch: Exception -> L5
        BreathWakeupDataTrackerConfig r6 = (BreathWakeupDataTrackerConfig) new Gson().fromJson(String.valueOf(r4), BreathWakeupDataTrackerConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricBreathWakeupDataTracker, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricBreathWakeupDataTracker, error: " + e);
        return new BreathWakeupDataTrackerConfig(false, null, null, 0, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void a1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("voice_wakeup_tips_shown", true);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean b() {
        AppHost.Companion r0 = AppHost.a;
        boolean r3 = false;
        if (com.obric.assistant.utils.j.c(r0.getApplication()) == true) goto L40;
        FLogger.a.i("ObricSettingRepo", "isVoiceWakeupEnabled ? false because current app is not an assitant role , just return");
        return false;
    L40:
        ContentProviderClient r1 = X1(r0.getApplication().getContentResolver(), k.a);     // Catch: Throwable -> L16 RemoteException -> L18
        if (r1 != null) goto L37;
        Bundle r4 = null;
    L14:
        if (r1 == null) goto L24;
        r1.close();
    L24:
        if (r4 != null) goto L26;
    L28:
        FLogger.a.i("ObricSettingRepo", "isVoiceWakeupEnabled: enabled = " + r3);
        if (r3 == false) goto L31;
        LoginService.a.N(AppHost.a.getApplication().getApplicationContext().getString(2131912241));
    L32:
        return r3;
    L31:
        LoginService.a.N(null);
        goto L32
    L26:
        if (r4.getBoolean("status", false) != true) goto L28;
        r3 = true;
        goto L28
    L37:
        r4 = r1.call("wakeup-get-status", null, null);     // Catch: RemoteException -> L11 Throwable -> L33
    L11:
        e = e;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r1 == null) goto L23;
        r1.close();
    L23:
        r4 = null;
    L33:
        Throwable th = th;
    L34:
        if (r1 == null) goto L36;
        r1.close();
    L36:
        throw th;
    L18:
        e = e;
        r1 = null;
    L16:
        th = move-exception;
        th = th;
        r1 = null;
        goto L34
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void b0() {
        this.h = IconAction.DISABLE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void b1() {
        q38.a r0 = ILoginService.a.getAccountInfo();
        FLogger r1 = FLogger.a;
        r1.i("ObricSettingRepo", "resetDeviceUUID isLogin " + r0.a + " current=" + com.obric.assistant.utils.j.d(d2()));
        if (r0.a == true) goto L6;
        return;
    L6:
        if (r0.g == false) goto L9;
        r1.i("ObricSettingRepo", "resetDeviceUUID skip: current account is enterprise");
        return;
    L9:
        String r2 = a2();
        r1.i("ObricSettingRepo", "resetDeviceUUID set to empty owner=" + com.obric.assistant.utils.j.d(r2));
        Z1(r2).storeString("device_uuid", XmlPullParser.NO_NAMESPACE);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean c() {
        return VoiceEnrollServiceDelegate.c.c();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean c0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("skill_extension_actionbar_new_has_triggered", false);
        FLogger.a.i("ObricSettingRepo", "getSkillExtensionActionBarNewHasTriggered, ret: " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean d() {
        return VoiceEnrollServiceDelegate.c.d();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String d0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        String r1 = r0.getString("voice_wakeup_sound_selected_id", XmlPullParser.NO_NAMESPACE);
        FLogger.a.d("ObricSettingRepo", "getSelectedWakeupSoundId, " + r1);
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int d1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getInt("intent_upload_strategy", 0);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int e0() {
        if (this.b != null) goto L5;
        e2();
    L5:
        Keva r0 = this.b;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r0 = null;
    L9:
        return r0.getInt("start_as_default_assistant", -1);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @ObricSettingsAuthenticationType
    public final int e1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L9;
        f2();
    L9:
        return b2("authentication_type_of_auto_gui_execute_on_lock_screen", 0);
    }

    public final void e2() {
        if (this.b == null) goto L5;
        return;
    L5:
        FLogger.a.d("ObricSettingRepo", "initGlobalKeva");
        Keva r0 = Keva.getRepo("obric_settings_global", 0);
        this.b = r0;
        Keva r2 = null;
        if (r0 == null) goto L18;
    L8:
        r0.unRegisterChangeListener(this.g);     // Catch: Exception -> L10
    L12:
        Keva r1 = this.b;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
    L16:
        r2.registerChangeListener(this.g);
        return;
    L15:
        r2 = r1;
    L10:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "unRegister global keva listener failed", e);
        goto L12
    L18:
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");     // Catch: Exception -> L10
        r0 = null;
        goto L8
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean enableObricSettingsOverride() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new n3(this))).booleanValue();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String f0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return "planexecute";
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        String r0 = i0().getDefaultComplexTaskMode();
        Keva r1 = this.a;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r1 = null;
    L12:
        String r2 = r1.getString("complex_task_mode", r0);
        FLogger.a.d("ObricSettingRepo", "getComplexTaskMode, cloudDefaultMode: " + r0 + ", ret: " + r2);
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    public final void f2() {
        String r0 = ILoginService.a.getAccountInfo().c;
        FLogger.a.d("ObricSettingRepo", "initKeva with user id " + com.obric.assistant.utils.j.d(r0));
        Keva r1 = this.a;
        if (r1 != null) goto L116;
    L8:
        this.a = Keva.getRepo("obric_settings_" + r0, 0);
        Keva r4 = null;
        if (ILoginService.a.getAccountInfo().a == true) goto L12;
    L25:
        boolean r2 = false;
    L27:
        if (r2 == true) goto L29;
    L52:
        int r5 = 2;
        k2("authentication_type_of_chat_and_online_qa_on_lock_screen", 2);
        k2("authentication_type_of_simple_command_execute_on_lock_screen", 2);
        k2("authentication_type_of_local_app_data_access_on_lock_screen", 0);
        k2("authentication_type_of_chat_history_access_on_lock_screen", 0);
        k2("authentication_type_of_global_memory_access_on_lock_screen", 0);
        k2("authentication_type_of_auto_gui_execute_on_lock_screen", 0);
        Keva r8 = this.a;
        if (r8 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r8 = null;
    L56:
        if (r8.getBoolean("local_data_memory_merge_migrated", false) == true) goto L80;
        Keva r9 = this.a;
        if (r9 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r9 = null;
    L61:
        boolean r10 = r9.contains("authentication_type_of_local_app_data_access_on_lock_screen");
        Keva r11 = this.a;
        if (r11 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r11 = null;
    L64:
        boolean r12 = r11.contains("authentication_type_of_global_memory_access_on_lock_screen");
        if (r10 == true) goto L71;
        if (r12 == true) goto L71;
        Keva r3 = this.a;
        if (r3 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r3 = null;
    L70:
        r3.storeBoolean("local_data_memory_merge_migrated", true);
        FLogger.a.i("ObricSettingRepo", "migrateLocalDataMemoryMergeSettings skip: brand-new account, no write");
    L71:
        int r13 = b2("authentication_type_of_local_app_data_access_on_lock_screen", 0);
        int r7 = b2("authentication_type_of_global_memory_access_on_lock_screen", 0);
        if (r13 != 2) goto L75;
        if (r7 != 2) goto L75;
    L76:
        p2("authentication_type_of_local_app_data_access_on_lock_screen", r5);
        Keva r6 = this.a;
        if (r6 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r6 = null;
    L79:
        r6.storeBoolean("local_data_memory_merge_migrated", true);
        FLogger.a.i("ObricSettingRepo", "migrateLocalDataMemoryMergeSettings localData=" + r13 + ", memory=" + r7 + ", merged=" + r5);
    L75:
        r5 = 0;
    L80:
        Keva r14 = this.a;
        if (r14 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r14 = null;
    L84:
        if (r14.contains("improve_voice_wakeup_enable") == true) goto L118;
        Keva r15 = this.a;
        if (r15 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r15 = null;
    L89:
        if (r15.contains("voice_wakeup_audio_upload_enable") == false) goto L118;
        Keva r16 = this.a;
        if (r16 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r16 = null;
    L94:
        boolean r17 = r16.getBoolean("voice_wakeup_audio_upload_enable", false);
        Keva r18 = this.a;
        if (r18 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r18 = null;
    L97:
        r18.storeBoolean("improve_voice_wakeup_enable", r17);
        Keva r19 = this.a;
        if (r19 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r19 = null;
    L100:
        r19.erase("voice_wakeup_audio_upload_enable");
        FLogger.a.i("ObricSettingRepo", "migrateImproveVoiceWakeupEnableKey enabled=" + r17);
    L118:
        Keva r20 = this.a;     // Catch: Exception -> L106
        if (r20 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("keva");     // Catch: Exception -> L106
        r20 = null;
    L104:
        r20.unRegisterChangeListener(this.f);     // Catch: Exception -> L106
    L108:
        Keva r21 = this.a;
        if (r21 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L112:
        r4.registerChangeListener(this.f);
        return;
    L111:
        r4 = r21;
    L106:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "unRegister current keva listener failed", e);
        goto L108
    L29:
        if (B() == false) goto L52;
        if (i2() == true) goto L34;
        t(1);
    L34:
        if (g2() == true) goto L37;
        F0(1);
    L37:
        if (j2() == true) goto L40;
        o2(1);
    L40:
        if (h2() == true) goto L43;
        n2(1);
    L43:
        if (ILoginService.a.getAccountInfo().a == false) goto L52;
        if (this.a != null) goto L48;
        f2();
    L48:
        Keva r22 = this.a;
        if (r22 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r22 = null;
    L51:
        r22.storeBoolean("voice_print_authenticate_locked_enabled", false);
        goto L52
    L12:
        if (this.a != null) goto L114;
        f2();
    L114:
        Object r23 = l0.a(new p4(0), new e4(this));     // Catch: Exception -> L17
        FLogger r24 = FLogger.a;     // Catch: Exception -> L17
        r24.d("ObricSettingRepo", "getVoicePrintAuthenticateSettingsConfig, " + this.c + ", " + r23);     // Catch: Exception -> L17
        p4 r25 = (p4) new Gson().fromJson(String.valueOf(r23), p4.class);     // Catch: Exception -> L17
        r24.i("ObricSettingRepo", "getVoicePrintAuthenticateSettingsConfig, " + this.c + ", " + r23 + ", " + r25);     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r25);     // Catch: Exception -> L17
    L20:
        if (r25.a() == false) goto L25;
        Keva r26 = this.a;
        if (r26 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r26 = null;
    L24:
        r2 = r26.getBoolean("voice_print_authenticate_locked_enabled", false);
    L17:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getVoicePrintAuthenticateSettingsConfig, error: " + e);
        r25 = new p4(0);
        goto L20
    L116:
        r1.unRegisterChangeListener(this.f);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "unRegister old keva listener failed", e);
        goto L8
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void g() {
        IObricChatService.a.getClass();
        IObricChatService r0 = IObricChatService.a.a();
        if (r0 == null) goto L6;
        r0.g();
        MessageApiImpl.a.g(new c());
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean g0() {
        if (this.b != null) goto L5;
        e2();
    L5:
        Keva r0 = this.b;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r0 = null;
    L9:
        return r0.getBoolean("auto_image_upload_enable_in_privacy", true);
    }

    public final boolean g2() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return false;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L13:
        return r0.contains("authentication_type_of_chat_history_access_on_lock_screen");
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int getAutoGuiEnabledScene() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 1;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        Keva r2 = null;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        if (r0.contains("auto_gui_enable_scene_2025_1225") == true) goto L23;
        Keva r1 = this.a;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r1 = null;
    L16:
        int r3 = r1.getInt("auto_gui_enable_scene_new", 1);
        FLogger.a.i("ObricSettingRepo", "getAutoGuiEnabledScene, migrate to NewAutoGuiSettingStatus, historyValue: " + r3);
        Keva r6 = this.a;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r6 = null;
    L19:
        int r7 = 2;
        if (r3 == 2) goto L22;
        r7 = 1;
    L22:
        r6.storeInt("auto_gui_enable_scene_2025_1225", r7);
    L23:
        Keva r4 = this.a;
        if (r4 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L27:
        int r5 = r2.getInt("auto_gui_enable_scene_2025_1225", 1);
        FLogger.a.i("ObricSettingRepo", "getAutoGuiEnabledScene, result: " + r5);
        return r5;
    L26:
        r2 = r4;
        goto L27
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String getAutoGuiFastModeUseSettings() {
        boolean r0 = ILoginService.a.getAccountInfo().a;
        String r1 = XmlPullParser.NO_NAMESPACE;
        if (r0 == true) goto L10;
        String r2 = ObricTaskSkillDelegate.b.i();
        if (r2 != null) goto L8;
        return XmlPullParser.NO_NAMESPACE;
    L8:
        return r2;
    L10:
        if (this.a != null) goto L12;
        f2();
    L12:
        Keva r3 = this.a;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r3 = null;
    L15:
        ObricTaskSkillDelegate r4 = ObricTaskSkillDelegate.b;
        String r5 = r4.i();
        if (r5 != null) goto L18;
        r5 = XmlPullParser.NO_NAMESPACE;
    L18:
        String r6 = r3.getString("auto_gui_fast_mode_use", r5);
        e.a.getClass();
        e.a r7 = e.a(r6);
        if (r7 == null) goto L21;
        String r8 = e.b(r7.a, r7.b);
    L26:
        FLogger.a.i("ObricSettingRepo", "getAutoGuiFastModeUseSettings, ret: " + r8);
        return r8;
    L21:
        String r9 = r4.i();
        if (r9 == null) goto L25;
        r1 = r9;
    L25:
        r8 = r1;
        goto L26
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final FeatureConfigMap getFeatureConfigMap() {
        int r5 = l0.a;     // Catch: Exception -> L5
        Object r6 = l0.a(new FeatureConfigMap(null, 1, null), new f4(this));     // Catch: Exception -> L5
        FLogger r7 = FLogger.a;     // Catch: Exception -> L5
        r7.d("ObricSettingRepo", "getFeatureConfigMap, " + this.c + ", " + r6);     // Catch: Exception -> L5
        FeatureConfigMap r8 = (FeatureConfigMap) new Gson().fromJson(String.valueOf(r6), FeatureConfigMap.class);     // Catch: Exception -> L5
        r7.i("ObricSettingRepo", "getFeatureConfigMap, " + this.c + ", " + r6 + ", " + r8);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getFeatureConfigMap, error: " + e);
        return new FeatureConfigMap(null, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricMmtVideoHardwareConfig getMmtVideoHardwareConfig() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m49constructorimpl(this.c.getMmtVideoHardwareConfig());     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.m52exceptionOrNullimpl(r1);
        if (r2 == null) goto L10;
        FLogger.a.e("ObricSettingRepo", "read Obric MMT video hardware config failed", r2);
    L10:
        if (Result.m55isFailureimpl(r1) == false) goto L13;
        r1 = null;
    L13:
        return (ObricMmtVideoHardwareConfig) r1;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean getOUseMemoryEnabled() {
        int r3 = l0.a;     // Catch: Exception -> L19
        OUseMemorySettingsConfig r4 = l.a;     // Catch: Exception -> L19
        OUseMemorySettingsConfig r5 = (OUseMemorySettingsConfig) new Gson().fromJson(String.valueOf(l0.a(r4, new b3(this))), OUseMemorySettingsConfig.class);     // Catch: Exception -> L19
        if (r5 == null) goto L7;
        r4 = r5;
    L7:
        boolean r6 = r4.getDefaultUseMemoryEnable();     // Catch: Exception -> L19
        if (ILoginService.a.getAccountInfo().a == true) goto L12;
        FLogger.a.i("ObricSettingRepo", "getAutoGuiUseMemoryEnabled not login: defaultUseMemoryEnable:" + r6);     // Catch: Exception -> L19
        return r6;
    L12:
        if (this.a != null) goto L14;
        f2();     // Catch: Exception -> L19
    L14:
        Keva r2 = this.a;     // Catch: Exception -> L19
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("keva");     // Catch: Exception -> L19
        r2 = null;
    L17:
        boolean r7 = r2.getBoolean("o_use_memory", r6);     // Catch: Exception -> L19
        FLogger.a.i("ObricSettingRepo", "getAutoGuiUseMemoryEnabled useMemoryEnable:" + r7);     // Catch: Exception -> L19
        return r7;
    L19:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getAutoGuiUseMemoryEnabled, error: " + e);
        return false;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricActionBarItemsConfig getObricActionBarItemsConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(l.i, new m3(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricActionBarItemsConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ObricActionBarItemsConfig r6 = (ObricActionBarItemsConfig) new Gson().fromJson(String.valueOf(r4), ObricActionBarItemsConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricActionBarItemsConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricActionBarItemsConfig, error: " + e);
        return l.i;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricActionBarModelMenuConfig getObricActionBarModelMenuConfig() {
        int r3 = l0.a;     // Catch: Exception -> L9
        ObricActionBarModelMenuConfig r4 = l.k;     // Catch: Exception -> L9
        Object r5 = l0.a(r4, new w2(this));     // Catch: Exception -> L9
        FLogger r6 = FLogger.a;     // Catch: Exception -> L9
        r6.i("ObricSettingRepo", "getObricActionBarModelMenuConfig, " + this.c + ", " + r5);     // Catch: Exception -> L9
        ObricActionBarModelMenuConfig r7 = (ObricActionBarModelMenuConfig) new Gson().fromJson(String.valueOf(r5), ObricActionBarModelMenuConfig.class);     // Catch: Exception -> L9
        if (r7 == null) goto L7;
        r4 = r7;
    L7:
        r6.i("ObricSettingRepo", "getObricActionBarModelMenuConfig, " + this.c + ", " + r5 + ", " + r4);     // Catch: Exception -> L9
        return r4;
    L9:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricActionBarModelMenuConfig, error: " + e);
        return l.k;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricAiKeyConfig getObricAiKeyConfig() {
        int r7 = l0.a;     // Catch: Exception -> L5
        Object r8 = l0.a(new ObricAiKeyConfig(0, 1, null), new w3(this));     // Catch: Exception -> L5
        FLogger r9 = FLogger.a;     // Catch: Exception -> L5
        r9.d("ObricSettingRepo", "getObricAiKeyConfig, " + this.c + ", " + r8);     // Catch: Exception -> L5
        ObricAiKeyConfig r10 = (ObricAiKeyConfig) new Gson().fromJson(String.valueOf(r8), ObricAiKeyConfig.class);     // Catch: Exception -> L5
        r9.i("ObricSettingRepo", "getObricAiKeyConfig, " + this.c + ", " + r8 + ", " + r10);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L5
        return r10;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricAiKeyConfig, error: " + e);
        return new ObricAiKeyConfig(0, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricAppIntentScreenshotCacheConfig getObricAppIntentScreenshotCacheConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        JsonObject r4 = (JsonObject) l0.a(new JsonObject(), new p2(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricAppIntentScreenshotCacheConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ObricAppIntentScreenshotCacheConfig r6 = (ObricAppIntentScreenshotCacheConfig) new Gson().fromJson(r4.toString(), ObricAppIntentScreenshotCacheConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricAppIntentScreenshotCacheConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricAppIntentScreenshotCacheConfig, error: " + e);
        return new ObricAppIntentScreenshotCacheConfig(0, 0, false, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricAppLogSettingsConfig getObricAppLogSettingsConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new ObricAppLogSettingsConfig(0, 0, 0, 0, 15, null), new x2(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricAppLogSettingsConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ObricAppLogSettingsConfig r6 = (ObricAppLogSettingsConfig) new Gson().fromJson(String.valueOf(r4), ObricAppLogSettingsConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricAppLogSettingsConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricAppLogSettingsConfig, error: " + e);
        return new ObricAppLogSettingsConfig(0, 0, 0, 0, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final AutoGuiBlacklistConfig getObricAutoGuiBlacklistConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new AutoGuiBlacklistConfig(null, null, null, null, null, null, 63, null), new i2(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricAutoGuiBlacklistConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        AutoGuiBlacklistConfig r6 = (AutoGuiBlacklistConfig) new Gson().fromJson(String.valueOf(r4), AutoGuiBlacklistConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricAutoGuiBlacklistConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricAutoGuiBlacklistConfig, error: " + e);
        return new AutoGuiBlacklistConfig(null, null, null, null, null, null, 63, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final AutoIncreaseDelayedTimeConfig getObricAutoIncreaseDelayedTimeConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new AutoIncreaseDelayedTimeConfig(0, 0, 3, null), new u2(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricAutoIncreaseDelayedTimeConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        AutoIncreaseDelayedTimeConfig r6 = (AutoIncreaseDelayedTimeConfig) new Gson().fromJson(String.valueOf(r4), AutoIncreaseDelayedTimeConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricAutoIncreaseDelayedTimeConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricAutoIncreaseDelayedTimeConfig, error: " + e);
        return new AutoIncreaseDelayedTimeConfig(0, 0, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricBottomTabConfig getObricBottomTabConfig() {
        int r3 = l0.a;     // Catch: Exception -> L9
        ObricBottomTabConfig r4 = l.l;     // Catch: Exception -> L9
        Object r5 = l0.a(r4, new e2(this));     // Catch: Exception -> L9
        FLogger r6 = FLogger.a;     // Catch: Exception -> L9
        r6.i("ObricSettingRepo", "getObricBottomTabConfig, " + this.c + ", " + r5);     // Catch: Exception -> L9
        ObricBottomTabConfig r7 = (ObricBottomTabConfig) new Gson().fromJson(String.valueOf(r5), ObricBottomTabConfig.class);     // Catch: Exception -> L9
        if (r7 == null) goto L7;
        r4 = r7;
    L7:
        r6.i("ObricSettingRepo", "getObricBottomTabConfig, " + this.c + ", " + r5 + ", " + r4);     // Catch: Exception -> L9
        return r4;
    L9:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricBottomTabConfig, error: " + e);
        return l.l;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ComplexTaskCaseFromPCConfig getObricComplexTaskCaseFromPC() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new ComplexTaskCaseFromPCConfig(0, 0, 0, 0, 15, null), new x3(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricComplexTaskCaseFromPC, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ComplexTaskCaseFromPCConfig r6 = (ComplexTaskCaseFromPCConfig) new Gson().fromJson(r4.toString(), ComplexTaskCaseFromPCConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricComplexTaskCaseFromPC, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricComplexTaskCaseFromPC, error: " + e);
        return new ComplexTaskCaseFromPCConfig(0, 0, 0, 0, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricCrashDumpHprofConfig getObricCrashDumpHprofConfig() {
        int r6 = l0.a;     // Catch: Exception -> L8
        Object r7 = l0.a(new ObricCrashDumpHprofConfig(false, null, 3, null), new k2(this));     // Catch: Exception -> L8
        ObricCrashDumpHprofConfig r8 = (ObricCrashDumpHprofConfig) new Gson().fromJson(String.valueOf(r7), ObricCrashDumpHprofConfig.class);     // Catch: Exception -> L8
        if (r8 != null) goto L6;
        r8 = new ObricCrashDumpHprofConfig(false, null, 3, null);     // Catch: Exception -> L8
    L6:
        FLogger.a.i("ObricSettingRepo", "getObricCrashDumpHprofConfig, " + this.c + ", " + r7 + ", " + r8);     // Catch: Exception -> L8
        return r8;
    L8:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricCrashDumpHprofConfig, error: " + e);
        return new ObricCrashDumpHprofConfig(false, null, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricImageUploadCompressConfig getObricImageUploadCompressConfig() {
        int r5 = l0.a;     // Catch: Exception -> L5
        Object r6 = l0.a(new ObricImageUploadCompressConfig(null, null, 3, null), new s3(this));     // Catch: Exception -> L5
        FLogger r7 = FLogger.a;     // Catch: Exception -> L5
        r7.d("ObricSettingRepo", "getObricImageUploadCompressConfig, " + this.c + ", " + r6);     // Catch: Exception -> L5
        ObricImageUploadCompressConfig r8 = (ObricImageUploadCompressConfig) new Gson().fromJson(String.valueOf(r6), ObricImageUploadCompressConfig.class);     // Catch: Exception -> L5
        r7.i("ObricSettingRepo", "getObricImageUploadCompressConfig, " + this.c + ", " + r6 + ", " + r8);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricImageUploadCompressConfig, error: " + e);
        return new ObricImageUploadCompressConfig(null, null, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricLarkConfirmConfig getObricLarkConfirmSettingsConfig() {
        int r6 = l0.a;     // Catch: Exception -> L5
        Object r7 = l0.a(new ObricLarkConfirmConfig(0, 1, null), new u3(this));     // Catch: Exception -> L5
        FLogger r8 = FLogger.a;     // Catch: Exception -> L5
        r8.d("ObricSettingRepo", "getObricLarkConfirmSettingsConfig, " + this.c + ", " + r7);     // Catch: Exception -> L5
        ObricLarkConfirmConfig r9 = (ObricLarkConfirmConfig) new Gson().fromJson(String.valueOf(r7), ObricLarkConfirmConfig.class);     // Catch: Exception -> L5
        r8.i("ObricSettingRepo", "getObricLarkConfirmSettingsConfig, " + this.c + ", " + r7 + ", " + r9);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L5
        return r9;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricLarkConfirmSettingsConfig, error: " + e);
        return new ObricLarkConfirmConfig(0, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricLazyInitConfig getObricLazyInitConfig() {
        ObricLazyInitConfig r2 = this.c.getObricLazyInitConfig();     // Catch: Exception -> L5
        FLogger.a.i("ObricSettingRepo", "getObricLazyInitConfig, config=" + r2);     // Catch: Exception -> L5
        return r2;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricLazyInitConfig, error: " + e);
        return new ObricLazyInitConfig(false, false, false, false, false, 31, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricLogSettingsConfig getObricLogSettingsConfig() {
        int r6 = l0.a;     // Catch: Exception -> L5
        Object r7 = l0.a(new ObricLogSettingsConfig(false, 1, null), new z3(this));     // Catch: Exception -> L5
        FLogger r8 = FLogger.a;     // Catch: Exception -> L5
        r8.d("ObricSettingRepo", "getObricLogSettingsConfig, " + this.c + ", " + r7);     // Catch: Exception -> L5
        ObricLogSettingsConfig r9 = (ObricLogSettingsConfig) new Gson().fromJson(String.valueOf(r7), ObricLogSettingsConfig.class);     // Catch: Exception -> L5
        r8.i("ObricSettingRepo", "getObricLogSettingsConfig, " + this.c + ", " + r7 + ", " + r9);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L5
        return r9;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricLogSettingsConfig, error: " + e);
        return new ObricLogSettingsConfig(false, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() {
        int r5 = l0.a;     // Catch: Exception -> L5
        Object r6 = l0.a(new ObricMemoryDataCollectConfig(null, 1, null), new g2(this));     // Catch: Exception -> L5
        FLogger r7 = FLogger.a;     // Catch: Exception -> L5
        r7.d("ObricSettingRepo", "getObricMemoryDataCollectConfig, " + this.c + ", " + r6);     // Catch: Exception -> L5
        ObricMemoryDataCollectConfig r8 = (ObricMemoryDataCollectConfig) new Gson().fromJson(String.valueOf(r6), ObricMemoryDataCollectConfig.class);     // Catch: Exception -> L5
        r7.i("ObricSettingRepo", "getObricMemoryDataCollectConfig, " + this.c + ", " + r6 + ", " + r8);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricMemoryDataCollectConfig, error: " + e);
        return new ObricMemoryDataCollectConfig(null, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricMemoryReportConfig getObricMemoryReportConfig() {
        int r4 = l0.a;     // Catch: Exception -> L8
        Object r5 = l0.a(new ObricMemoryReportConfig(false, false, 0, false, 0, false, 0, false, 255, null), new y1(this));     // Catch: Exception -> L8
        FLogger r6 = FLogger.a;     // Catch: Exception -> L8
        r6.i("ObricSettingRepo", "getObricMemoryReportConfig, " + this.c + ", " + r5);     // Catch: Exception -> L8
        ObricMemoryReportConfig r7 = (ObricMemoryReportConfig) new Gson().fromJson(String.valueOf(r5), ObricMemoryReportConfig.class);     // Catch: Exception -> L8
        if (r7 != null) goto L6;
        r7 = new ObricMemoryReportConfig(false, false, 0, false, 0, false, 0, false, 255, null);     // Catch: Exception -> L8
    L6:
        r6.i("ObricSettingRepo", "getObricMemoryReportConfig, " + this.c + ", " + r5 + ", " + r7);     // Catch: Exception -> L8
        return r7;
    L8:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricMemoryReportConfig, error: " + e);
        return new ObricMemoryReportConfig(false, false, 0, false, 0, false, 0, false, 255, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricOneLoginConfig getObricOneLoginConfig() {
        int r6 = l0.a;     // Catch: Exception -> L8
        Object r7 = l0.a(new ObricOneLoginConfig(false, 1, null), new c4(this));     // Catch: Exception -> L8
        FLogger r8 = FLogger.a;     // Catch: Exception -> L8
        r8.i("ObricSettingRepo", "getObricOneLoginConfig, " + this.c + ", " + r7);     // Catch: Exception -> L8
        ObricOneLoginConfig r9 = (ObricOneLoginConfig) new Gson().fromJson(String.valueOf(r7), ObricOneLoginConfig.class);     // Catch: Exception -> L8
        if (r9 != null) goto L6;
        r9 = new ObricOneLoginConfig(false, 1, null);     // Catch: Exception -> L8
    L6:
        r8.i("ObricSettingRepo", "getObricOneLoginConfig, " + this.c + ", " + r7 + ", " + r9);     // Catch: Exception -> L8
        return r9;
    L8:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricOneLoginConfig, error: " + e);
        return new ObricOneLoginConfig(false, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final CPUExceptionDiagnosisConfig getObricPerformanceCPUExceptionDiagnosisSettingsConfig() {
        int r4 = l0.a;     // Catch: Exception -> L5
        Object r5 = l0.a(new CPUExceptionDiagnosisConfig(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null), new i3(this));     // Catch: Exception -> L5
        FLogger r6 = FLogger.a;     // Catch: Exception -> L5
        r6.d("ObricSettingRepo", "getObricPerformanceCPUExceptionDiagnosisSettingsConfig, " + this.c + ", " + r5);     // Catch: Exception -> L5
        CPUExceptionDiagnosisConfig r7 = (CPUExceptionDiagnosisConfig) new Gson().fromJson(String.valueOf(r5), CPUExceptionDiagnosisConfig.class);     // Catch: Exception -> L5
        r6.i("ObricSettingRepo", "getObricPerformanceCPUExceptionDiagnosisSettingsConfig, " + this.c + ", " + r5 + ", " + r7);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L5
        return r7;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricPerformanceCPUExceptionDiagnosisSettingsConfig, error: " + e);
        return new CPUExceptionDiagnosisConfig(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricPerformanceMonitorConfig getObricPerformanceMonitorConfig() {
        int r3 = l0.a;     // Catch: Exception -> L8
        Object r4 = l0.a(new ObricPerformanceMonitorConfig(false, null, null, 7, null), new v3(this));     // Catch: Exception -> L8
        FLogger r5 = FLogger.a;     // Catch: Exception -> L8
        r5.i("ObricSettingRepo", "getObricPerformanceMonitorConfig, " + this.c + ", " + r4);     // Catch: Exception -> L8
        ObricPerformanceMonitorConfig r6 = (ObricPerformanceMonitorConfig) new Gson().fromJson(String.valueOf(r4), ObricPerformanceMonitorConfig.class);     // Catch: Exception -> L8
        if (r6 != null) goto L6;
        r6 = new ObricPerformanceMonitorConfig(false, null, null, 7, null);     // Catch: Exception -> L8
    L6:
        r5.i("ObricSettingRepo", "getObricPerformanceMonitorConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L8
        return r6;
    L8:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricPerformanceMonitorConfig, error: " + e);
        return new ObricPerformanceMonitorConfig(false, null, null, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricPerformancePowerMonitorConfig getObricPerformancePowerMonitorSettingsConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new ObricPerformancePowerMonitorConfig(false, false, 0, 0, 0.0f, 0.0f, 63, null), new j2(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricPerformancePowerMonitorSettingsConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ObricPerformancePowerMonitorConfig r6 = (ObricPerformancePowerMonitorConfig) new Gson().fromJson(String.valueOf(r4), ObricPerformancePowerMonitorConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricPerformancePowerMonitorSettingsConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricPerformancePowerMonitorSettingsConfig, error: " + e);
        return new ObricPerformancePowerMonitorConfig(false, false, 0, 0, 0.0f, 0.0f, 63, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricPowerLockConfig getObricPowerLockConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new ObricPowerLockConfig(null, null, null, null, null, 31, null), new r2(this));     // Catch: Exception -> L5
        ObricPowerLockConfig r5 = (ObricPowerLockConfig) new Gson().fromJson(String.valueOf(r4), ObricPowerLockConfig.class);     // Catch: Exception -> L5
        FLogger.a.i("ObricSettingRepo", "getObricPowerLockConfig, " + this.c + ", " + r4 + ", " + r5);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L5
        return r5;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricPowerLockConfig, error: " + e);
        return new ObricPowerLockConfig(null, null, null, null, null, 31, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int getObricPowerLockTimeoutInSeconds() {
        int r3 = l0.a;     // Catch: Exception -> L7
        Object r4 = l0.a(new ObricPowerLockConfig(null, null, null, null, null, 31, null), new e3(this));     // Catch: Exception -> L7
        FLogger r5 = FLogger.a;     // Catch: Exception -> L7
        r5.d("ObricSettingRepo", "getObricPowerLockTimeoutInSeconds, " + this.c + ", " + r4);     // Catch: Exception -> L7
        ObricPowerLockConfig r6 = (ObricPowerLockConfig) new Gson().fromJson(String.valueOf(r4), ObricPowerLockConfig.class);     // Catch: Exception -> L7
        r5.i("ObricSettingRepo", "getObricPowerLockTimeoutInSeconds, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L7
        Integer r0 = r6.getObricFrontierLockTimeout();     // Catch: Exception -> L7
        if (r0 == null) goto L9;
        return r0.intValue();
    L9:
        return 600;
    L7:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricPowerLockTimeoutInSeconds, error: " + e);
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int getObricPrivacyLaneType() {
        return this.c.getObricPrivacyLaneType();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricProcessesManagerConfig getObricProcessesManagerConfig() {
        int r4 = l0.a;     // Catch: Exception -> L5
        Object r5 = l0.a(new ObricProcessesManagerConfig(0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8191, null), new a4(this));     // Catch: Exception -> L5
        FLogger r6 = FLogger.a;     // Catch: Exception -> L5
        r6.d("ObricSettingRepo", "getObricProcessesManagerConfig, " + this.c + ", " + r5);     // Catch: Exception -> L5
        ObricProcessesManagerConfig r7 = (ObricProcessesManagerConfig) new Gson().fromJson(String.valueOf(r5), ObricProcessesManagerConfig.class);     // Catch: Exception -> L5
        r6.i("ObricSettingRepo", "getObricProcessesManagerConfig, " + this.c + ", " + r5 + ", " + r7);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L5
        return r7;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricProcessesManagerConfig, error: " + e);
        return new ObricProcessesManagerConfig(0, 0, false, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8191, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final q1 getObricPromptCellConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(l.n, new r3(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricPromptCellConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        q1 r6 = (q1) new Gson().fromJson(String.valueOf(r4), q1.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricPromptCellConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricPromptCellConfig, error: " + e);
        return l.n;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricScreenshotUploadConfig getObricScreenshotUploadConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        JsonObject r4 = (JsonObject) l0.a(new JsonObject(), new l3(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricScreenshotUploadConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ObricScreenshotUploadConfig r6 = (ObricScreenshotUploadConfig) new Gson().fromJson(r4.toString(), ObricScreenshotUploadConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricScreenshotUploadConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricScreenshotUploadConfig, error: " + e);
        return new ObricScreenshotUploadConfig(false, false, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricSecuritySettingsPackageWhitelistConfig getObricSecuritySettingsPackageWhitelistConfig() {
        int r5 = l0.a;     // Catch: Exception -> L11
        Object r6 = l0.a(new ObricSecuritySettingsPackageWhitelistConfig(null, null, 3, null), new o3(this));     // Catch: Exception -> L11
        FLogger r7 = FLogger.a;     // Catch: Exception -> L11
        r7.d("ObricSettingRepo", "getObricSecuritySettingsPackageWhitelistConfig, " + this.c + ", " + r6);     // Catch: Exception -> L11
        if (r6 != null) goto L6;
        ObricSecuritySettingsPackageWhitelistConfig r8 = new ObricSecuritySettingsPackageWhitelistConfig(null, null, 3, null);     // Catch: Exception -> L11
    L9:
        r7.i("ObricSettingRepo", "getObricSecuritySettingsPackageWhitelistConfig, " + this.c + ", " + r6 + ", " + r8);     // Catch: Exception -> L11
        return r8;
    L6:
        r8 = (ObricSecuritySettingsPackageWhitelistConfig) new Gson().fromJson(r6.toString(), ObricSecuritySettingsPackageWhitelistConfig.class);     // Catch: Exception -> L11
        if (r8 != null) goto L9;
        r8 = new ObricSecuritySettingsPackageWhitelistConfig(null, null, 3, null);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricSecuritySettingsPackageWhitelistConfig, error: " + e);
        return new ObricSecuritySettingsPackageWhitelistConfig(null, null, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricSettingsConfig getObricSettingsConfig() {
        int r4 = l0.a;     // Catch: Exception -> L8
        Object r5 = l0.a(new ObricSettingsConfig(0, false, 0, 0, 0, 0, 0, false, 255, null), new n2(this));     // Catch: Exception -> L8
        FLogger r6 = FLogger.a;     // Catch: Exception -> L8
        r6.i("ObricSettingRepo", "getObricSettingsConfig, " + this.c + ", " + r5);     // Catch: Exception -> L8
        ObricSettingsConfig r7 = (ObricSettingsConfig) new Gson().fromJson(String.valueOf(r5), ObricSettingsConfig.class);     // Catch: Exception -> L8
        if (r7 != null) goto L6;
        r7 = new ObricSettingsConfig(0, false, 0, 0, 0, 0, 0, false, 255, null);     // Catch: Exception -> L8
    L6:
        r6.i("ObricSettingRepo", "getObricSettingsConfig, " + this.c + ", " + r5 + ", " + r7);     // Catch: Exception -> L8
        return r7;
    L8:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricSettingsConfig, error: " + e);
        return new ObricSettingsConfig(0, false, 0, 0, 0, 0, 0, false, 255, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricStateMachineMultitaskConfig getObricStateMachineMultitaskConfig() {
        JsonObject r6 = (JsonObject) l0.a(null, new h3(this));     // Catch: Exception -> L10
        FLogger r7 = FLogger.a;     // Catch: Exception -> L10
        r7.d("ObricSettingRepo", "getObricStateMachineMultitaskConfig, " + this.c + ", " + r6);     // Catch: Exception -> L10
        if (r6 == null) goto L7;
        ObricStateMachineMultitaskConfig r8 = (ObricStateMachineMultitaskConfig) new Gson().fromJson(r6.toString(), ObricStateMachineMultitaskConfig.class);     // Catch: Exception -> L10
        if (r8 == null) goto L7;
    L8:
        r7.i("ObricSettingRepo", "getObricStateMachineMultitaskConfig, " + this.c + ", " + r6 + ", " + r8);     // Catch: Exception -> L10
        return r8;
    L7:
        r8 = new ObricStateMachineMultitaskConfig(false, false, 3, null);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricStateMachineMultitaskConfig, error: " + e);
        return new ObricStateMachineMultitaskConfig(false, false, 3, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricTimeoutConfig getObricTaskTimeoutConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(new ObricTimeoutConfig(null, null, null, 7, null), new x1(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getObricTaskTimeoutConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ObricTimeoutConfig r6 = (ObricTimeoutConfig) new Gson().fromJson(String.valueOf(r4), ObricTimeoutConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricTaskTimeoutConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricTaskTimeoutConfig, error: " + e);
        return new ObricTimeoutConfig(null, null, null, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricThresholdDumpHprofConfig getObricThresholdDumpHprofConfig() {
        int r3 = l0.a;     // Catch: Exception -> L8
        Object r4 = l0.a(new ObricThresholdDumpHprofConfig(false, 0, 0, 7, null), new z2(this));     // Catch: Exception -> L8
        ObricThresholdDumpHprofConfig r5 = (ObricThresholdDumpHprofConfig) new Gson().fromJson(String.valueOf(r4), ObricThresholdDumpHprofConfig.class);     // Catch: Exception -> L8
        if (r5 != null) goto L6;
        r5 = new ObricThresholdDumpHprofConfig(false, 0, 0, 7, null);     // Catch: Exception -> L8
    L6:
        FLogger.a.i("ObricSettingRepo", "getObricThresholdDumpHprofConfig, " + this.c + ", " + r4 + ", " + r5);     // Catch: Exception -> L8
        return r5;
    L8:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricThresholdDumpHprofConfig, error: " + e);
        return new ObricThresholdDumpHprofConfig(false, 0, 0, 7, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ZeusAutoFetchConfig getObricZeusAutoFetchConfig() {
        ZeusAutoFetchConfig r3 = this.c.getObricZeusAutoFetchConfig();     // Catch: Exception -> L5
        FLogger.a.i("ObricSettingRepo", "getObricZeusAutoFetchConfig, config=" + r3);     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricZeusAutoFetchConfig, error: " + e);
        return new ZeusAutoFetchConfig(false, 0, 0, false, 0, 0, 0, 0, 0, 511, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricActionBarItemsConfig getWindowActionBarItemsConfig() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(l.j, new z1(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getWindowActionBarItemsConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ObricActionBarItemsConfig r6 = (ObricActionBarItemsConfig) new Gson().fromJson(String.valueOf(r4), ObricActionBarItemsConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getWindowActionBarItemsConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricActionBarItemsConfig, error: " + e);
        return l.j;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void h0() {
        ILoginService.Companion r0 = ILoginService.a;
        if (r0.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        s2 r1 = new s2();
        if (((Boolean) r1.invoke(Integer.valueOf(k1()))).booleanValue() == false) goto L12;
        F1(2);
    L12:
        if (((Boolean) r1.invoke(Integer.valueOf(W()))).booleanValue() == false) goto L15;
        F(2);
    L15:
        if (((Boolean) r1.invoke(Integer.valueOf(v0()))).booleanValue() == false) goto L18;
        t(0);
    L18:
        if (((Boolean) r1.invoke(Integer.valueOf(Q1()))).booleanValue() == false) goto L21;
        F0(3);
    L21:
        if (r0.getAccountInfo().a == true) goto L24;
        int r2 = 0;
    L31:
        if (((Boolean) r1.invoke(Integer.valueOf(r2))).booleanValue() == false) goto L34;
        o2(0);
    L34:
        if (r0.getAccountInfo().a == true) goto L37;
        int r3 = 0;
    L41:
        if (((Boolean) r1.invoke(Integer.valueOf(r3))).booleanValue() == false) goto L44;
        n2(0);
    L44:
        if (((Boolean) r1.invoke(Integer.valueOf(e1()))).booleanValue() == false) goto L47;
        V0(0);
        return;
    L47:
        return;
    L37:
        if (this.a != null) goto L39;
        f2();
    L39:
        r3 = b2("authentication_type_of_global_memory_access_on_lock_screen", 0);
        goto L41
    L24:
        if (this.a != null) goto L26;
        f2();
    L26:
        Keva r4 = this.a;
        if (r4 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r4 = null;
    L29:
        r2 = r4.getInt("authentication_type_of_personal_info_access_on_lock_screen", 0);
        goto L31
    }

    public final boolean h2() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return false;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L13:
        return r0.contains("authentication_type_of_global_memory_access_on_lock_screen");
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean i() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return false;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L13:
        return r0.getBoolean("locked_screen_use_enabled", true);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ComplexTaskSettingsConfig i0() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(l.d, new a2(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.d("ObricSettingRepo", "getComplexTaskSettingsConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ComplexTaskSettingsConfig r6 = (ComplexTaskSettingsConfig) new Gson().fromJson(String.valueOf(r4), ComplexTaskSettingsConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getComplexTaskSettingsConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getComplexTaskSettingsConfig, error: " + e);
        return l.d;
    }

    public final boolean i2() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return false;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L13:
        return r0.contains("authentication_type_of_local_app_data_access_on_lock_screen");
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isBypassAdaptiveSid() {
        int r2 = l0.a;     // Catch: Exception -> L5
        boolean r3 = ((Boolean) l0.a(Boolean.TRUE, new o2(this))).booleanValue();     // Catch: Exception -> L5
        FLogger.a.i("ObricSettingRepo", "isBypassAdaptiveSid=" + r3);     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "isBypassAdaptiveSid, error: " + e);
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isCloseAudioConnAppBackGroundOnlyForObric() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new g3())).booleanValue();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isLarkKnowledgeAuthorizationEnable() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("lark_knowledge_authorization_enable", false);
        FLogger.a.d("ObricSettingRepo", "isLarkKnowledgeAuthorizationEnable, " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isObricContTalkPvadSwitchShowEnable() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new v2(this))).booleanValue();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isReRecordWakeWordGuideEnable() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new d4(this))).booleanValue();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean isTtsPlayBackgroundEnabled() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.j == true) goto L24;
        this.j = true;
        f r0 = f.a;
        String r2 = d2();
        r0.getClass();
        if (f.a(r2) == true) goto L24;
        if (this.a != null) goto L14;
        f2();
    L14:
        Keva r1 = this.a;
        Keva r3 = null;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r1 = null;
    L18:
        if (r1.contains("tts_play_background_enable") == false) goto L24;
        Keva r4 = this.a;
        if (r4 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L23:
        boolean r5 = r3.getBoolean("tts_play_background_enable", false);
        f.c(r5, d2());
        FLogger.a.i("ObricSettingRepo", "migrateTtsBackgroundPlay: migrated oldValue=" + r5 + " for userId=" + com.obric.assistant.utils.j.d(d2()));
        goto L24
    L22:
        r3 = r4;
    L24:
        f r6 = f.a;
        String r7 = d2();
        r6.getClass();
        return f.b(r7, false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @Deprecated(message = "use getAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    public final boolean isVoicePrintAuthenticateAutoGuiEnabled() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getBoolean("voice_print_authenticate_auto_gui_enabled", false);
    }

    @Deprecated(message = "2026/05/09.移除个人信息和偏好的设置。meego:/new_ocean/story/detail/7246098205")
    public final boolean j2() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return false;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L13:
        return r0.contains("authentication_type_of_personal_info_access_on_lock_screen");
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void k() {
        VoiceEnrollServiceDelegate.c.k();
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @ObricSettingsAuthenticationType
    public final int k1() {
        ILoginService.Companion r0 = ILoginService.a;
        int r2 = 0;
        if (r0.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L9;
        f2();
    L9:
        if (r0.getAccountInfo().g == true) goto L13;
        r2 = 2;
    L13:
        return b2("authentication_type_of_chat_and_online_qa_on_lock_screen", r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void l1() {
        this.i = this.h;
        this.h = null;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final List<ObricEnrolledDeviceInfo> m() {
        List r0 = VoiceEnrollServiceDelegate.c.m();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        d r3 = (d) r2.next();
        r1.add(new ObricEnrolledDeviceInfo(r3.a, r3.b, r3.c, r3.d));
        goto L4
    L6:
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean m0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getBoolean("voice_wakeup_tips_shown", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean o0() {
        String r0 = getObricFlowSettingsJson("obric_voice_section_tracker_enable_slardar");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.m49constructorimpl(Boolean.valueOf(new JSONObject(r0).optBoolean("enable")));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.m52exceptionOrNullimpl(r2);
        if (r3 == null) goto L10;
        FLogger.a.e("ObricSettingRepo", r3.getMessage());
    L10:
        Boolean r4 = Boolean.FALSE;
        if (Result.m55isFailureimpl(r2) == false) goto L13;
        r2 = r4;
    L13:
        boolean r5 = ((Boolean) r2).booleanValue();
        FLogger.a.i("ObricSettingRepo", "isVoiceSectionTrackerEnableSlardar ? " + r5);
        return r5;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r2 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String p() {
        String r4 = null;
        JsonObject r3 = (JsonObject) l0.a(null, new d2(this));     // Catch: Exception -> L10
        if (r3 == null) goto L6;
        r4 = r3.toString();     // Catch: Exception -> L10
    L6:
        if (r4 != null) goto L8;
        r4 = XmlPullParser.NO_NAMESPACE;
    L8:
        FLogger.a.i("ObricSettingRepo", "getVoiceWakeupSidThresholdConfigForCurrentModel, pass through full config to wakeup process, result=".concat(r4));     // Catch: Exception -> L10
        return r4;
    L10:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getVoiceWakeupSidThresholdConfigForCurrentModel, error: " + e);
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final QueryAuthenticateConfig p0() {
        int r6 = l0.a;     // Catch: Exception -> L5
        Object r7 = l0.a(new QueryAuthenticateConfig(0, 1, null), new m2(this));     // Catch: Exception -> L5
        FLogger r8 = FLogger.a;     // Catch: Exception -> L5
        r8.d("ObricSettingRepo", "getQueryAuthenticateConfig, " + this.c + ", " + r7);     // Catch: Exception -> L5
        QueryAuthenticateConfig r9 = (QueryAuthenticateConfig) new Gson().fromJson(String.valueOf(r7), QueryAuthenticateConfig.class);     // Catch: Exception -> L5
        r8.i("ObricSettingRepo", "getQueryAuthenticateConfig, " + this.c + ", " + r7 + ", " + r9);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L5
        return r9;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "queryAuthenticateConfigJson, error: " + e);
        return new QueryAuthenticateConfig(0, 1, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean p1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("skill_extension_enable", false);
        FLogger.a.i("ObricSettingRepo", "getSkillExtensionEnabled, ret: " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean q() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return false;
    L7:
        if (this.a != null) goto L11;
        f2();
        return true;
    L11:
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricDeepThinkModeRestTimeConfig q1() {
        int r3 = l0.a;     // Catch: Exception -> L5
        Object r4 = l0.a(l.m, new b4(this));     // Catch: Exception -> L5
        FLogger r5 = FLogger.a;     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricDeepThinkModeRestTimeConfig, " + this.c + ", " + r4);     // Catch: Exception -> L5
        ObricDeepThinkModeRestTimeConfig r6 = (ObricDeepThinkModeRestTimeConfig) new Gson().fromJson(String.valueOf(r4), ObricDeepThinkModeRestTimeConfig.class);     // Catch: Exception -> L5
        r5.i("ObricSettingRepo", "getObricDeepThinkModeRestTimeConfig, " + this.c + ", " + r4 + ", " + r6);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        return r6;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricDeepThinkModeRestTimeConfig, error: " + e);
        return l.m;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean r0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        return r0.getBoolean("memory_setting_enable", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean r1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("always_respond_to_voice_wakeup", false);
        FLogger.a.d("ObricSettingRepo", "isAlwaysRespondToVoiceWakeup, " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean t0() {
        IconAction r0 = this.h;
        if (r0 != null) goto L8;
        if (HomeService.a.A(AppHost.a.getApplication()) != null) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (r0 != IconAction.ENABLE) goto L10;
        return true;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean u() {
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        return false;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L13:
        return r0.getBoolean("voice_print_management_red_pot", true);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean u0() {
        if (com.obric.assistant.utils.j.c(AppHost.a.getApplication()) == true) goto L6;
        FLogger.a.i("ObricSettingRepo", "isDoubaoWhisperEnabled ? false because current app is not an assitant role , just return");
        return false;
    L6:
        String r0 = d2();
        if ((!StringsKt.isBlank(r0)) == true) goto L49;
        return false;
    L49:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        ObricEnrollInteropDelegate.b.p();     // Catch: Throwable -> L10
        Object r4 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r5 = Result.m52exceptionOrNullimpl(r4);
        if (r5 == null) goto L15;
        FLogger.a.e("ObricSettingRepo", "isDoubaoWhisperEnabled migrate failed: " + r5.getMessage());
    L15:
        Lazy r1 = pia.d.a;
        Intrinsics.checkNotNullParameter(r0, "uid");
        if (StringsKt.isBlank(r0) == false) goto L18;
        boolean r2 = false;
    L19:
        if (r2 == false) goto L56;
        ContentProviderClient r6 = null;
        Bundle r7 = null;
        r7 = null;
        r7 = null;
        ContentProviderClient r8 = X1(AppHost.a.getApplication().getContentResolver(), k.a);     // Catch: Throwable -> L29 RemoteException -> L31
        if (r8 != null) goto L51;
    L27:
        if (r8 != null) goto L35;
    L36:
        if (r7 != null) goto L38;
    L40:
        boolean r9 = false;
    L41:
        if (r9 == false) goto L57;
        return true;
    L57:
        return false;
    L38:
        if (r7.getBoolean("status", false) != true) goto L40;
        r9 = true;
    L35:
        r8.close();
        goto L36
    L51:
        r7 = r8.call("breath-get-status", null, null);     // Catch: RemoteException -> L25 Throwable -> L43
    L25:
        RemoteException e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L43
        if (r8 == null) goto L36;
    L43:
        th = move-exception;
        ContentProviderClient r10 = r8;
        th = th;
        r6 = r10;
    L45:
        if (r6 == null) goto L47;
        r6.close();
    L47:
        throw th;
    L31:
        e = move-exception;
        e = e;
        r8 = null;
    L29:
        th = th;
        goto L45
    L56:
        return false;
    L18:
        r2 = pia.d.i().getBoolean("breath_wakeup_enabled_" + r0, false);
    L10:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r4 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final Integer v() {
        Integer r1 = null;
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return null;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        Integer r2 = Integer.valueOf(r0.getInt("obric_default_reply_mode", -1));
        if (r2.intValue() < 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        r1 = r2;
    L17:
        FLogger.a.i("ObricSettingRepo", "getObricDefaultReplyMode, itemId=" + r1);
        return r1;
    L14:
        r3 = false;
        goto L15
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int v0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return 0;
    L6:
        if (this.a != null) goto L9;
        f2();
    L9:
        return b2("authentication_type_of_local_app_data_access_on_lock_screen", 0);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean v1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return true;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("o_use_clipboard", true);
        FLogger.a.i("ObricSettingRepo", "getOUseClipboardEnabled, ret: " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String w0() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("getDeviceUUID isLogin ");
        ILoginService.Companion r2 = ILoginService.a;
        r1.append(r2.getAccountInfo().a);
        r1.append(" current=");
        r1.append(com.obric.assistant.utils.j.d(d2()));
        r0.i("ObricSettingRepo", r1.toString());
        if (r2.getAccountInfo().a == true) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        String r3 = a2();
        String r4 = Z1(r3).getString("device_uuid", XmlPullParser.NO_NAMESPACE);
        r0.i("ObricSettingRepo", "getDeviceUUID " + com.obric.assistant.utils.j.d(r4) + " owner=" + com.obric.assistant.utils.j.d(r3) + " current=" + com.obric.assistant.utils.j.d(d2()));
        return r4;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean w1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("pc_in_asr", false);
        FLogger.a.d("ObricSettingRepo", "isPcInAsrEnabled, " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean x0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("improve_voice_wakeup_enable", false);
        FLogger.a.i("ObricSettingRepo", "isImproveVoiceWakeupEnabled: enabled = " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricWakeupSoundConfig x1() {
        int r3 = l0.a;     // Catch: Exception -> L7
        Object r4 = l0.a(new ObricWakeupSoundConfig(false, null, false, null, 15, null), new v1(this));     // Catch: Exception -> L7
        ObricWakeupSoundConfig r5 = (ObricWakeupSoundConfig) new Gson().fromJson(String.valueOf(r4), ObricWakeupSoundConfig.class);     // Catch: Exception -> L7
        FLogger.a.i("ObricSettingRepo", "getWakeupSoundConfig, " + this.c + ", " + r4 + ", " + r5);     // Catch: Exception -> L7
        if (r5 != null) goto L12;
        return new ObricWakeupSoundConfig(false, null, false, null, 15, null);
    L12:
        return r5;
    L7:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getWakeupSoundConfig, error: " + e);
        return new ObricWakeupSoundConfig(false, null, false, null, 15, null);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean y1() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return false;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        boolean r1 = r0.getBoolean("obric_minor_mode_instruction_read", false);
        FLogger.a.i("ObricSettingRepo", "getObricMinorModeInstructionsReadByUser, " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final Object z0() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return null;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        String r1 = r0.getString("obric_default_reply_mode_option", null);
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == true) goto L22;
        Gson r3 = z.a;
        return (ReplyOption) z.a(r1, ReplyOption.class);
    L22:
        return null;
    L14:
        if (r1.length() == 0) goto L17;
        r2 = false;
        goto L18
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.f2] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.q2] */
    public ObricSettingsServiceImpl() {
        this.c = (IObricCloudSettings) SettingsManager.obtain(IObricCloudSettings.class);
        this.d = new CopyOnWriteArrayList();
        this.e = PThreadExecutorsUtils.newSingleThreadExecutor(new u1());
        this.f = new f2(this);
        this.g = new q2(this);
        e2();
        ILoginService.a.c(ILoginService.a, new a(this));
        ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);
        ServiceManager.get().getService(IObricPersonalContextSettingApi.class);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean Q0() {
        return c2("support_only_attachment", false);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean R1() {
        if (t9a.b.a().c("obric_feature_gaze_keep_display") == false) goto L31;
        Application r0 = AppHost.a.getApplication();
        ArrayList r10 = new ArrayList();
        Object[] r12 = {"android.permission.BIND_ATTENTION_SERVICE"};
        f06.b r14 = new f06.b("auto_cert_com_obric_assistant_ObricSettingsServiceImpl_android_app_Application_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L7;
        f06.a[] r3 = r2.i;
    L8:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L10:
        if (r7 >= r8) goto L17;
        f06.a r6 = r9[r7];
        int r18 = r7;
        int r19 = r8;
        f06.a[] r20 = r9;
        f06.d r4 = r6.preInvoke(102608, "android/app/Application", "checkSelfPermission", r0, r12, "int", r14);     // Catch: Exception -> L25
        if (r4.a == true) goto L19;
        r10.add(r6);     // Catch: Exception -> L25
    L19:
        if (r4.a == false) goto L21;
        int r1 = ((Integer) r4.b).intValue();
    L22:
        if (r1 != 0) goto L32;
        return true;
    L32:
        return false;
    L21:
        r1 = r0.checkSelfPermission("android.permission.BIND_ATTENTION_SERVICE");
    L16:
        r7 = r18 + 1;
        r8 = r19;
        r9 = r20;
        goto L10
    L17:
        r4 = new f06.d(false, null);
        goto L19
    L7:
        r3 = ApiHookConfig.d;
        goto L8
    L31:
        return false;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String Z() {
        ModelSettingsConfig r0 = Y0();
        String r1 = r0.getDefaultModel().getKey();
        if (r1 != null) goto L6;
        r1 = XmlPullParser.NO_NAMESPACE;
    L6:
        if (ILoginService.a.getAccountInfo().a == true) goto L9;
        return r1;
    L9:
        if (this.a != null) goto L11;
        f2();
    L11:
        Keva r2 = this.a;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r2 = null;
    L14:
        String r3 = r2.getString("assistant_model", r1);
        Intrinsics.checkNotNull(r3);
        if (r0.getModel(r3) != null) goto L17;
        return r1;
    L17:
        return r3;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final Map<String, String> getAutoExecuteAuthorizationStatusMap() {
        String r0 = O();
        JSONObject r1 = new JSONObject();
        r1.put("risk_preference_settings", r0);
        JsonObject r2 = getObricCloudConfig("auto_gui_automatic_execution_authorization");
        if (r2 != null) goto L5;
        r2 = null;
    L18:
        if (r2 != null) goto L21;
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] map read skipped, reason=config_null");
        return MapsKt.mapOf(TuplesKt.to("o_automatic_execution_authorization", r1.toString()));
    L21:
        JsonArray r3 = r2.getAsJsonArray("authorizations");
        if (r3 != null) goto L25;
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] map read skipped, reason=authorizations_null");
        return MapsKt.mapOf(TuplesKt.to("o_automatic_execution_authorization", r1.toString()));
    L25:
        Iterator<JsonElement> r4 = r3.iterator();
        int r5 = 0;
    L27:
        if (r4.hasNext() == false) goto L42;
        JsonElement r6 = r4.next();
        if (r6.isJsonObject() == true) goto L32;
        r6 = null;
    L32:
        if (r6 == null) goto L27;
        JsonObject r7 = r6.getAsJsonObject();
        if (r7 == null) goto L27;
        String r8 = Y1(r7, "type");
        String r9 = Y1(r7, "key");
        if (Intrinsics.areEqual(r8, "switch") == false) goto L27;
        if (StringsKt.isBlank(r9) == true) goto L27;
        int r10 = c.a;
        r1.put(r9, P1(r9, c.a(Y1(r7, "default_value"))));
        r5 = r5 + 1;
        goto L27
    L42:
        if (r5 != 0) goto L45;
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] map read skipped, reason=no_switch_item");
        return MapsKt.mapOf(TuplesKt.to("o_automatic_execution_authorization", r1.toString()));
    L45:
        Map<String, String> r11 = MapsKt.mapOf(TuplesKt.to("o_automatic_execution_authorization", r1.toString()));
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] map read, size=" + r11.size() + ", switchCount=" + r5 + ", result=" + r11);
        return r11;
    L5:
        JsonElement r12 = r2.get("auto_gui_automatic_execution_authorization");
        if (r12 != null) goto L8;
    L13:
        JsonObject r13 = null;
    L14:
        if (r13 == null) goto L18;
        r2 = r13;
        goto L18
    L8:
        if (r12.isJsonObject() == true) goto L11;
        r12 = null;
    L11:
        if (r12 == null) goto L13;
        r13 = r12.getAsJsonObject();
        goto L14
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean j0() {
        if (p1() == false) goto L7;
        boolean r1 = true;
        if (O0() != 1) goto L7;
    L8:
        FLogger.a.i("ObricSettingRepo", "isOmniSkillUsable, ret: " + r1);
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean s1() {
        if (R1() == true) goto L6;
        return false;
    L6:
        if (ILoginService.a.getAccountInfo().a == true) goto L9;
        return false;
    L9:
        if (this.a != null) goto L11;
        f2();
    L11:
        Keva r0 = this.a;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L15:
        return r0.getBoolean("obric_gaze_keep_display_enabled", true);
    }

    public static Keva Z1(String r2) {
        return Keva.getRepo("obric_settings_" + r2, 0);
    }

    @RiskPreferenceSettings
    public static String m2(String r5) {
        if (r5 != null) goto L5;
        return "2";
    L5:
        switch(r5.hashCode()) {
            case -65436122: goto L29;
            case 48: goto L26;
            case 49: goto L22;
            case 50: goto L20;
            case 51: goto L17;
            case 2402104: goto L14;
            case 316487729: goto L11;
            case 2081150445: goto L8;
            default: goto L36;
        };
    L20:
        r5.equals("2");
        return "2";
    L29:
        r5.equals("SMART_BALANCE");
        return "2";
    L36:
        return "2";
    L8:
        if (r5.equals("AUTONOMY_FIRST") == true) goto L32;
        return "2";
    L32:
        return "3";
    L11:
        if (r5.equals("CONFIRM_FIRST") == true) goto L34;
        return "2";
    L34:
        return "1";
    L14:
        if (r5.equals("NONE") == true) goto L35;
        return "2";
    L35:
        return MiraMonitor.VALUE_DEFAULT;
    L17:
        if (r5.equals("3") == true) goto L32;
        return "2";
    L22:
        if (r5.equals("1") == true) goto L34;
        return "2";
    L26:
        if (r5.equals(MiraMonitor.VALUE_DEFAULT) == true) goto L35;
        return "2";
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void A(long r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeLong("obric_settings_pull_time", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void B0(m r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.d.contains(r2) == true) goto L6;
        this.d.add(r2);
        return;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void B1(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.d("ObricSettingRepo", "setPcInAsrPolicyAgreed, " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("pc_in_asr_policy", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void C0(Integer r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setObricDefaultReplyMode, itemId=" + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        r0.storeInt("obric_default_reply_mode", r5);
        return;
    L13:
        r5 = -1;
        goto L14
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void D(String r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeString("complex_task_llm_model", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void D0(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setAutoGuiUseClipboardEnabled, enable: " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("o_use_clipboard", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void E(long r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeLong("obric_settings_check_time", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void F(@ObricSettingsAuthenticationType int r2) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        p2("authentication_type_of_simple_command_execute_on_lock_screen", r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void F0(@ObricSettingsAuthenticationType int r2) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        p2("authentication_type_of_chat_history_access_on_lock_screen", r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void F1(@ObricSettingsAuthenticationType int r2) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        p2("authentication_type_of_chat_and_online_qa_on_lock_screen", r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void H0(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.d("ObricSettingRepo", "saveAlwaysRespondToVoiceWakeup, " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("always_respond_to_voice_wakeup", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void H1(String r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeString("complex_task_mode", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void J(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        e.a.getClass();
        e.a r5 = e.a(r4);
        if (r5 == null) goto L11;
        String r6 = e.b(r5.a, r5.b);
    L14:
        FLogger.a.i("ObricSettingRepo", "setAutoGuiFastModeUseSettings, value: " + r6);
        Keva r0 = this.a;
        if (r0 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L17:
        r0.storeString("auto_gui_fast_mode_use", r6);
        return;
    L11:
        r6 = ObricTaskSkillDelegate.b.i();
        if (r6 != null) goto L14;
        r6 = XmlPullParser.NO_NAMESPACE;
        goto L14
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void K(boolean r3) {
        if (R1() == true) goto L6;
        return;
    L6:
        if (ILoginService.a.getAccountInfo().a == true) goto L9;
        return;
    L9:
        if (this.a != null) goto L11;
        f2();
    L11:
        Keva r0 = this.a;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L14:
        r0.storeBoolean("obric_gaze_keep_display_enabled", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void L1(long r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setSkillExtensionActionBarNewExpireAtMs, expireAtMs: " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeLong("skill_extension_actionbar_new_expire_at_ms", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void M0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "did");
        if (ILoginService.a.getAccountInfo().a == true) goto L5;
        return;
    L5:
        String r0 = a2();
        FLogger.a.i("ObricSettingRepo", "setDeviceUUID " + com.obric.assistant.utils.j.d(r5) + " owner=" + com.obric.assistant.utils.j.d(r0) + " current=" + com.obric.assistant.utils.j.d(d2()));
        Z1(r0).storeString("device_uuid", r5);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @AutoEndConversationTime
    public final long M1(@AutoEndConversationScene int r7) {
        long r1 = 10000;
        if (ILoginService.a.getAccountInfo().a == true) goto L9;
        if (r7 != 0) goto L7;
        return 10000;
    L7:
        return 20000;
    L9:
        if (this.a != null) goto L11;
        f2();
    L11:
        Keva r0 = this.a;
        if (r0 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L14:
        if (r7 == 0) goto L16;
        String r5 = "auto_end_conversation_main_screen";
    L17:
        if (r7 == 0) goto L21;
        r1 = 20000;
    L21:
        return l2(r7, r0.getLong(r5, r1));
    L16:
        r5 = "auto_end_conversation_lock_screen";
        goto L17
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void O1(Object r5) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        String r1 = null;
        if ((r5 instanceof ReplyOption) == false) goto L11;
        ReplyOption r6 = (ReplyOption) r5;
    L12:
        FLogger.a.i("ObricSettingRepo", "setObricDefaultReplyOption, replyOption=" + r6);
        Keva r0 = this.a;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L15:
        if (r6 == null) goto L17;
        r1 = z.c(r6);
    L17:
        r0.storeString("obric_default_reply_mode_option", r1);
        return;
    L11:
        r6 = null;
        goto L12
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final ObricSettingsListConfig R(JSONObject r8) {
        OUseMemorySettingsConfig r4 = l.a;     // Catch: Exception -> L19
        if (r8 == null) goto L9;
        ObricSettingsListConfig r9 = (ObricSettingsListConfig) new Gson().fromJson(r8.optString("obric_settings_list_config"), ObricSettingsListConfig.class);     // Catch: Exception -> L19
        if (r9 != null) goto L8;
        r9 = l.e;     // Catch: Exception -> L19
    L8:
        FLogger.a.i("ObricSettingRepo", "getObricSettingsListConfig from appSettings, " + r9);     // Catch: Exception -> L19
        return r9;
    L9:
        int r10 = l0.a;     // Catch: Exception -> L19
        ObricSettingsListConfig r11 = l.e;     // Catch: Exception -> L19
        Object r3 = l0.a(r11, new b2(this));     // Catch: Exception -> L19
        Gson r5 = new Gson();     // Catch: Exception -> L19
        if (r3 == null) goto L12;
        String r6 = r3.toString();     // Catch: Exception -> L19
    L13:
        ObricSettingsListConfig r7 = (ObricSettingsListConfig) r5.fromJson(r6, ObricSettingsListConfig.class);     // Catch: Exception -> L19
        if (r7 == null) goto L17;
        r11 = r7;
    L17:
        FLogger.a.i("ObricSettingRepo", "getObricSettingsListConfig from cloud, " + this.c + ", " + r3 + ", " + r11);     // Catch: Exception -> L19
        return r11;
    L12:
        r6 = null;
    L19:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricSettingsListConfig, error", e);
        return l.e;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void R0(boolean r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("locked_screen_use_enabled", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void S0(m r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d.remove(r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void U0(boolean r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("continue_speak_enable", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void U1(String r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeString("assistant_model", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void V(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.d("ObricSettingRepo", "setPcInAsrEnabled, " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("pc_in_asr", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void V0(@ObricSettingsAuthenticationType int r2) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        p2("authentication_type_of_auto_gui_execute_on_lock_screen", r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "macId");
        return VoiceEnrollServiceDelegate.c.a(r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void c1(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setSkillExtensionActionBarNewConsumed, consumed: " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("skill_extension_actionbar_new_consumed", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void e(v r2) {
        VoiceEnrollServiceDelegate.c.e(r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void f(boolean r8) {
        Bundle r1 = new Bundle();
        r1.putBoolean("status", r8);
        AppHost.Companion r2 = AppHost.a;
        if (com.obric.assistant.utils.j.c(r2.getApplication()) == true) goto L5;
        FLogger.a.i("ObricSettingRepo", "setVoiceWakeupEnabled returned ! current app is not an assitant role , just return");
        return;
    L5:
        ContentProviderClient r3 = null;
        ContentProviderClient r5 = X1(r2.getApplication().getContentResolver(), k.a);     // Catch: Throwable -> L19 RemoteException -> L21
        if (r5 != null) goto L34;
    L9:
        FLogger.a.i("ObricSettingRepo", "setVoiceWakeupEnabled: enabled = " + r8);     // Catch: Throwable -> L15 RemoteException -> L17
        if (r8 == false) goto L12;
        LoginService.a.N(r2.getApplication().getApplicationContext().getString(2131912241));     // Catch: Throwable -> L15 RemoteException -> L17
    L13:
        if (r5 == null) goto L30;
        r5.close();
    L30:
        return;
    L12:
        LoginService.a.N(null);     // Catch: Throwable -> L15 RemoteException -> L17
        goto L13
    L34:
        r5.call("wakeup-set-status", null, r1);     // Catch: Throwable -> L15 RemoteException -> L17
    L17:
        e = e;
        r3 = r5;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r3 == null) goto L30;
        r3.close();
    L15:
        th = th;
    L27:
        if (r5 == null) goto L29;
        r5.close();
    L29:
        throw th;
    L19:
        th = th;
        r5 = r3;
    L21:
        e = e;
        goto L22
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void f1(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.d("ObricSettingRepo", "setLarkKnowledgeAuthorizationEnable, " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("lark_knowledge_authorization_enable", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void g1(boolean r3) {
        if (com.obric.assistant.utils.j.c(AppHost.a.getApplication()) == true) goto L6;
        FLogger.a.i("ObricSettingRepo", "setDoubaoWhisperEnabled return because current app is not an assitant role , just return");
        return;
    L6:
        String r0 = d2();
        if ((!StringsKt.isBlank(r0)) == false) goto L9;
        pia.d.n(r0, r3);
    L9:
        ObricEnrollInteropDelegate.b.j(r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final JsonObject getObricCloudConfig(final String r7) {
        Intrinsics.checkNotNullParameter(r7, "key");
        FLogger r4 = FLogger.a;     // Catch: Exception -> L5
        r4.e("ObricSettingRepo", "getObricCloudConfig key " + r7);     // Catch: Exception -> L5
        JsonObject r8 = (JsonObject) l0.a(null, new y2(r7, this));     // Catch: Exception -> L5
        r4.d("ObricSettingRepo", "getObricCloudConfig, " + this.c + ", " + r8);     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricCloudConfig, error: " + e);
        return null;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String getObricFlowSettingsJson(String r6) {
        String r7 = (String) l0.a(XmlPullParser.NO_NAMESPACE, new f3(r6, this));     // Catch: Exception -> L5
        FLogger.a.d("ObricSettingRepo", "getObricFlowSettingsJson, " + this.c + ", " + r7);     // Catch: Exception -> L5
        return r7;
    L5:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getObricFlowSettingsJson, error: " + e);
        return XmlPullParser.NO_NAMESPACE;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void h(boolean r2) {
        VoiceEnrollServiceDelegate.c.h(r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void i1(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("improve_voice_wakeup_enable", r4);
        VoiceEnrollServiceDelegate.c.h(r4);
        FLogger.a.i("ObricSettingRepo", "setImproveVoiceWakeupEnabled: enabled = " + r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void j1(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setObricMinorModeInstructionsReadByUser, " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("obric_minor_mode_instruction_read", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final boolean k0(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return false;
    L12:
        if (this.b != null) goto L14;
        e2();
    L14:
        Keva r2 = this.b;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r2 = null;
    L17:
        boolean r6 = r2.getBoolean("enterprise_account_tip_never_show_" + r5, false);
        FLogger.a.i("ObricSettingRepo", "isEnterpriseAccountTipNeverShow, ret=" + r6);
        return r6;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void l0(int r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setOmniSkillAvailableState, state: " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeInt("omni_skill_available_state", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void m1(int r3) {
        if (this.b != null) goto L5;
        e2();
    L5:
        Keva r0 = this.b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r0 = null;
    L8:
        r0.storeInt("start_as_default_assistant", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void n(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        if (this.b != null) goto L14;
        e2();
    L14:
        FLogger.a.i("ObricSettingRepo", "setEnterpriseAccountTipNeverShow, neverShow=true");
        Keva r2 = this.b;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r2 = null;
    L17:
        r2.storeBoolean("enterprise_account_tip_never_show_" + r5, true);
        return;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void n0(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        String r5 = m2(r4);
        FLogger.a.i("ObricSettingRepo", "setRiskPreferenceSettings, value: ".concat(r5));
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeString("risk_preference_settings", r5);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void n1(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setSkillExtensionEnabled, enable: " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("skill_extension_enable", r4);
    }

    public final void n2(@ObricSettingsAuthenticationType int r2) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        p2("authentication_type_of_global_memory_access_on_lock_screen", r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void o(long r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeLong("performance_monitor_kill_time", r3);
    }

    @Deprecated(message = "2026/05/09.移除个人信息和偏好的设置。meego:/new_ocean/story/detail/7246098205")
    public final void o2(@ObricSettingsAuthenticationType int r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeInt("authentication_type_of_personal_info_access_on_lock_screen", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void q0(boolean r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("conversation_content_model_training_enable", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final int s(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        FLogger.a.i("ObricSettingRepo", "getTtsPlayOptionEnable not login with key " + r6 + " , return -1");
        return -1;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        int r1 = r0.getInt(r6, -1);
        FLogger.a.e("ObricSettingRepo", "getTtsPlayOptionEnable key " + r6 + " , value " + r1);
        return r1;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void setAutoGuiEnabledScene(int r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setAutoGuiEnabledScene, scene: " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeInt("auto_gui_enable_scene_2025_1225", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void setAutoImageUploadEnabled(boolean r3) {
        if (this.a != null) goto L5;
        f2();
    L5:
        Keva r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L8:
        r0.storeBoolean("auto_image_upload_enable", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void setOUseMemoryEnabled(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.i("ObricSettingRepo", "setAutoGuiUseMemoryEnabled, enable: " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("o_use_memory", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void setSemanticScreenShotEnabled(boolean r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("semantic_screen_shot_enable_new", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    @Deprecated(message = "use saveAuthenticationTypeOfAutoGuiExecuteOnLockScreen instead")
    public final void setVoicePrintAuthenticateAutoGuiEnabled(boolean r5) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        Keva r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("voice_print_authenticate_auto_gui_enabled", r5);
        Keva r6 = this.a;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L15:
        r1.storeBoolean("voice_print_authenticate_auto_gui_enabled_red_pot", false);
        return;
    L14:
        r1 = r6;
        goto L15
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void t(@ObricSettingsAuthenticationType int r2) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        p2("authentication_type_of_local_app_data_access_on_lock_screen", r2);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void t1(String r4) {
        Intrinsics.checkNotNullParameter(r4, "soundId");
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        FLogger.a.d("ObricSettingRepo", "setSelectedWakeupSoundId, " + r4);
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeString("voice_wakeup_sound_selected_id", r4);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void u1(boolean r3) {
        if (this.b != null) goto L5;
        e2();
    L5:
        Keva r0 = this.b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r0 = null;
    L8:
        r0.storeBoolean("auto_image_upload_enable_in_privacy", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void w(int r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeInt("complex_task_local_search_enable", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void x(boolean r3) {
        if (this.b != null) goto L5;
        e2();
    L5:
        Keva r0 = this.b;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("globalKeva");
        r0 = null;
    L8:
        r0.storeBoolean("security_certificate_ready", r3);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void y(boolean r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeBoolean("continue_speak_noise_reduction_enable", r4);
        FLogger.a.i("ObricSettingRepo", "setContinueSpeakNoiseReductionEnabled: enable = " + r4);
        if (r4 == false) goto L15;
        VoiceEnrollServiceDelegate.c.k();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.common.apphost.AppHost$Companion] */
    /* JADX WARN: Type inference failed for: r1v1 */
    @Override // com.obric.assistant.IObricSettingsApi
    public final void y0(boolean r9) {
        ContentProviderClient r1 = AppHost.a;
        if (com.obric.assistant.utils.j.c(r1.getApplication()) == true) goto L6;
        FLogger.a.i("ObricSettingRepo", "setDoubaoWhisperDataUploadEnabled return because current app is not an assitant role , just return");
        return;
    L6:
        Bundle r2 = new Bundle();
        r2.putBoolean("status", r9);
        FLogger.a.i("ObricSettingRepo", "setDoubaoWhisperDataUploadEnabled, enabled = " + r9);
        ContentProviderClient r3 = X1(r1.getApplication().getContentResolver(), k.a);     // Catch: Throwable -> L15 RemoteException -> L17
        if (r3 != null) goto L28;
    L13:
        if (r3 == null) goto L22;
    L14:
        r3.close();
        return;
    L22:
        return;
    L28:
        r3.call("breath-upload-set-status", null, r2);     // Catch: RemoteException -> L11 Throwable -> L23
    L11:
        RemoteException e = e;
    L19:
        FLogger.a.e("ObricSettingRepo", "setDoubaoWhisperDataUploadEnabled, error = " + e);     // Catch: Throwable -> L23
        if (r3 != null) goto L14;
        return;
    L23:
        Throwable th = th;
    L24:
        if (r1 == 0) goto L26;
        r1.close();
    L26:
        throw th;
    L17:
        e = move-exception;
        r3 = null;
        e = e;
    L15:
        th = move-exception;
        r1 = 0;
        th = th;
        goto L24
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void z(boolean r1) {
        i1(r1);
        q0(r1);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void z1(int r3) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        r0.storeInt("obric_settings_version", r3);
    }

    public static ContentProviderClient X1(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static String Y1(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        if (r3.isJsonNull() == false) goto L8;
    L12:
        return XmlPullParser.NO_NAMESPACE;
    L8:
        if (r3.isJsonPrimitive() == false) goto L12;
        return r3.getAsJsonPrimitive().getAsString();
    }

    @AutoEndConversationTime
    public static long l2(@AutoEndConversationScene int r16, long r17) {
        Long r1 = Long.valueOf(KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME);
        long r2 = 20000;
        if (r16 != 0) goto L5;
        Set r0 = SetsKt.setOf(new Long[]{3500L, 10000L, 20000L, r1, -1L});
    L6:
        Long r3 = Long.valueOf(r17);
        if (r0.contains(Long.valueOf(r3.longValue())) == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L16;
        if (r16 != 0) goto L15;
        r2 = 10000;
    L15:
        return r2;
    L16:
        return r3.longValue();
    L5:
        r0 = SetsKt.setOf(new Long[]{3500L, 10000L, 20000L, r1, 60000L, -1L});
        goto L6
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void C(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        if (ILoginService.a.getAccountInfo().a == true) goto L7;
        FLogger.a.i("ObricSettingRepo", "setTtsPlayOptionEnable not login with key " + r5 + " , not set !");
        return;
    L7:
        if (this.a != null) goto L9;
        f2();
    L9:
        Keva r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L12:
        r0.storeInt(r5, r6 ? 1 : 0);
        Unit r1 = Unit.INSTANCE;
        FLogger.a.i("ObricSettingRepo", "setTtsPlayOptionEnable key " + r5 + " , value " + r6);
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void C1(Integer r2, String r3) {
        if (this.i != IconAction.DISABLE) goto L8;
        if (t0() == false) goto L8;
        HomeService.a.c0(AppHost.a.getApplication());
    L12:
        this.i = null;
        return;
    L8:
        if (this.i != IconAction.ENABLE) goto L12;
        if (t0() == true) goto L12;
        HomeService.a.W(AppHost.a.getApplication(), r2);
        goto L12
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final String P1(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "authorizationKey");
        Intrinsics.checkNotNullParameter(r9, "defaultValue");
        String r10 = c.a(r9);
        if (StringsKt.isBlank(r8) == false) goto L7;
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] read skipped, reason=blank_key, defaultStatus=" + r10);
        return r10;
    L7:
        if (ILoginService.a.getAccountInfo().a == true) goto L11;
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] read skipped, reason=not_login, key=" + r8 + ", defaultStatus=" + r10);
        return r10;
    L11:
        if (this.a != null) goto L13;
        f2();
    L13:
        String r0 = "auto_exec_" + r8;
        Keva r3 = this.a;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r3 = null;
    L16:
        String r4 = c.a(r3.getString(r0, r10));
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] read, key=" + r8 + ", storageKey=" + r0 + ", defaultStatus=" + r10 + ", storedStatus=" + r4);
        return r4;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void T1(@AutoEndConversationScene int r3, @AutoEndConversationTime long r4) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L8;
        f2();
    L8:
        Keva r0 = this.a;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L11:
        if (r3 == 0) goto L13;
        String r1 = "auto_end_conversation_main_screen";
    L14:
        r0.storeLong(r1, l2(r3, r4));
        return;
    L13:
        r1 = "auto_end_conversation_lock_screen";
        goto L14
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void X(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "authorizationKey");
        Intrinsics.checkNotNullParameter(r9, "status");
        if (StringsKt.isBlank(r8) == false) goto L7;
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] write skipped, reason=blank_key, targetStatus=" + c.a(r9));
        return;
    L7:
        if (ILoginService.a.getAccountInfo().a == true) goto L11;
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] write skipped, reason=not_login, key=" + r8 + ", targetStatus=" + c.a(r9));
        return;
    L11:
        if (this.a != null) goto L13;
        f2();
    L13:
        String r10 = c.a(r9);
        String r0 = "auto_exec_" + r8;
        Keva r4 = null;
        if (Intrinsics.areEqual(r10, MiraMonitor.VALUE_DEFAULT) == false) goto L21;
        Keva r3 = this.a;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L19:
        r4.erase(r0);
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] write erase, key=" + r8 + ", storageKey=" + r0 + ", targetStatus=" + r10);
        return;
    L18:
        r4 = r3;
        goto L19
    L21:
        Keva r5 = this.a;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L25:
        r4.storeString(r0, r10);
        FLogger.a.i("ObricSettingRepo", "[AutoExecuteAuth][Storage] write, key=" + r8 + ", storageKey=" + r0 + ", targetStatus=" + r10);
        return;
    L24:
        r4 = r5;
        goto L25
    }

    @ObricSettingsAuthenticationType
    public final int b2(String r4, @ObricSettingsAuthenticationType int r5) {
        Keva r0 = this.a;
        Keva r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L6:
        if (r0.contains(r4) == false) goto L13;
        Keva r2 = this.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L11:
        r5 = r1.getInt(r4, r5);
        goto L13
    L10:
        r1 = r2;
    L13:
        if (r5 == 2) goto L17;
        return 0;
    L17:
        return 2;
    }

    public final boolean c2(String r9, boolean r10) {
        String r3 = null;
        JsonObject r2 = (JsonObject) l0.a(null, new q3(this));     // Catch: Exception -> L15
        if (r2 == null) goto L6;
        JsonElement r4 = r2.get(r9);     // Catch: Exception -> L15
    L7:
        if (r4 == null) goto L9;
        boolean r5 = r4.getAsBoolean();     // Catch: Exception -> L15
    L10:
        FLogger r6 = FLogger.a;     // Catch: Exception -> L15
        StringBuilder r7 = new StringBuilder("getPhoneOperationFileUploadEnabled, key=");     // Catch: Exception -> L15
        r7.append(r9);     // Catch: Exception -> L15
        r7.append(", config=");     // Catch: Exception -> L15
        r7.append(r2);     // Catch: Exception -> L15
        r7.append(", value=");     // Catch: Exception -> L15
        r7.append(r4);     // Catch: Exception -> L15
        r7.append(", valueType=");     // Catch: Exception -> L15
        if (r4 == null) goto L13;
        r3 = r4.getClass().getSimpleName();     // Catch: Exception -> L15
    L13:
        r7.append(r3);     // Catch: Exception -> L15
        r7.append(", defaultValue=");     // Catch: Exception -> L15
        r7.append(r10);     // Catch: Exception -> L15
        r7.append(", result=");     // Catch: Exception -> L15
        r7.append(r5);     // Catch: Exception -> L15
        r6.i("ObricSettingRepo", r7.toString());     // Catch: Exception -> L15
        return r5;
    L9:
        r5 = r10;
        goto L10
    L6:
        r4 = null;
    L15:
        e = move-exception;
        FLogger.a.e("ObricSettingRepo", "getPhoneOperationFileUploadEnabled failed, key=".concat(r9), e);
        return r10;
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void j(String r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "macId");
        VoiceEnrollServiceDelegate.c.j(r2, r3);
    }

    public final void k2(String r5, @ObricSettingsAuthenticationType int r6) {
        Keva r0 = this.a;
        Keva r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L6:
        if (r0.contains(r5) == true) goto L8;
        return;
    L8:
        Keva r2 = this.a;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r2 = null;
    L11:
        int r7 = r2.getInt(r5, r6);
        int r3 = 2;
        if (r7 == 2) goto L15;
        r3 = 0;
    L15:
        Keva r4 = this.a;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
    L19:
        r1.storeInt(r5, r3);
        FLogger.a.i("ObricSettingRepo", "migrateLockedUseAuthenticationSetting key: " + r5 + ", oldAuthType: " + r7 + ", newAuthType: " + r3);
        return;
    L18:
        r1 = r4;
        goto L19
    }

    @Override // com.obric.assistant.IObricSettingsApi
    public final void l(boolean r4, List<String> r5) {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return;
    L6:
        if (this.a != null) goto L9;
        f2();
    L9:
        if (r5 == null) goto L40;
        Iterator<T> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L40;
        String r1 = (String) r6.next();
        switch(r1.hashCode()) {
            case -1596646719: goto L37;
            case -1505875665: goto L33;
            case -794954221: goto L29;
            case 667833384: goto L25;
            case 818210740: goto L21;
            case 1815567618: goto L17;
            default: goto L12;
        };
    L17:
        if (r1.equals("authentication_type_of_local_app_data_access_on_lock_screen") == false) goto L12;
        t(1);
        goto L12
    L21:
        if (r1.equals("authentication_type_of_auto_gui_execute_on_lock_screen") == false) goto L12;
        V0(1);
        goto L12
    L25:
        if (r1.equals("authentication_type_of_chat_and_online_qa_on_lock_screen") == false) goto L12;
        F1(1);
        goto L12
    L29:
        if (r1.equals("authentication_type_of_chat_history_access_on_lock_screen") == false) goto L12;
        F0(1);
        goto L12
    L33:
        if (r1.equals("authentication_type_of_global_memory_access_on_lock_screen") == false) goto L12;
        n2(1);
        goto L12
    L37:
        if (r1.equals("authentication_type_of_simple_command_execute_on_lock_screen") == false) goto L12;
        F(1);
    L40:
        if (r4 == true) goto L43;
        return;
    L43:
        if (i2() == true) goto L46;
        t(1);
    L46:
        if (g2() == true) goto L49;
        F0(1);
    L49:
        if (j2() == true) goto L52;
        o2(1);
    L52:
        if (h2() == true) goto L82;
        n2(1);
        return;
    }

    public final void p2(String r3, @ObricSettingsAuthenticationType int r4) {
        Keva r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("keva");
        r0 = null;
    L5:
        int r1 = 2;
        if (r4 == 2) goto L9;
        r1 = 0;
    L9:
        r0.storeInt(r3, r1);
    }
}
