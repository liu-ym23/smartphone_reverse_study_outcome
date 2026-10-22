package com.larus.platform.spi;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import by7.e;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.o1;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.instruction.helper.f;
import com.larus.bmhome.instruction.m;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.view.actionbar.custom.cache.k;
import com.larus.bmhome.view.actionbar.custom.router.b;
import com.larus.bmhome.view.actionbar.custom.w2;
import com.larus.bmhome.view.actionbar.custom.x2;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.g0;
import com.larus.uaigc.createpage.component.instruction.CreationEditorComponent;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import fn8.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;
import mr9.j;
import nr9.g;
import org.json.JSONObject;
import vp8.i;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000ü\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\bg\u0018\u0000 \u008b\u00022\u00020\u0001:\u0002\u008b\u0002J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u000bH&J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH&J`\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\r2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0+H&J*\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u000b2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d0+H¦@¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u000202H&J\u0018\u00103\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`6H&J\u0089\u0001\u00107\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010'\u001a\u00020(2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010F\u001a\u0004\u0018\u0001022\u0016\b\u0002\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010HH&¢\u0006\u0002\u0010IJ6\u0010J\u001a\u0004\u0018\u00010\u00072\b\u0010K\u001a\u0004\u0018\u00010\u00072\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u0002022\u0006\u0010O\u001a\u0002022\b\b\u0002\u0010P\u001a\u00020\rH&J\u0010\u0010Q\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020TH&JL\u0010Z\u001a\u00020\u001d*\u00020>2\u0006\u0010L\u001a\u00020T2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010]\u001a\u0004\u0018\u00010^2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010bH&J\b\u0010c\u001a\u00020dH&J\u0010\u0010e\u001a\u00020f2\u0006\u0010\u001e\u001a\u00020\u001fH&JR\u0010g\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u0002022\u0006\u0010o\u001a\u00020\r2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u000bH'JÒ\u0001\u0010g\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010h\u001a\u00020i2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u0002022\u0006\u0010o\u001a\u00020\r2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u000b2\u0006\u0010q\u001a\u00020\u000b2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010t2\u0014\u0010u\u001a\u0010\u0012\u0004\u0012\u00020v\u0012\u0004\u0012\u00020\u001d\u0018\u00010+2*\u0010w\u001a&\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010z\u0012\u0004\u0012\u00020\u001d\u0018\u00010x2\u0016\u0010{\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010;\u0012\u0004\u0012\u00020\u001d\u0018\u00010+2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010}H&J\u008d\u0002\u0010~\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u007f\u001a\u00020D2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010p\u001a\u0004\u0018\u00010\u000b2\u0006\u0010o\u001a\u00020\r2\u008b\u0001\u0010\u0083\u0001\u001a\u0085\u0001\u0012\u0015\u0012\u00130D¢\u0006\u000e\b\u0084\u0001\u0012\t\b\u0085\u0001\u0012\u0004\b\b(\u007f\u0012\u0016\u0012\u00140\u000b¢\u0006\u000f\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0086\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010H¢\u0006\u000f\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0087\u0001\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010H¢\u0006\u000f\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0088\u0001\u0012\u0004\u0012\u00020\u001d\u0018\u00010x2\u0017\b\u0002\u0010\u0088\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010H2\u0017\b\u0002\u0010\u0089\u0001\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001d\u0018\u00010+H&J\u001f\u0010\u008a\u0001\u001a\u0004\u0018\u00010T2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010<\u001a\u0004\u0018\u00010\u000bH&J\u0016\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H&J\n\u0010\u008f\u0001\u001a\u00030\u0090\u0001H&J6\u0010\u0091\u0001\u001a\u00020\u001d*\u00020>2\u0006\u0010L\u001a\u00020T2\t\u0010C\u001a\u0005\u0018\u00010\u0092\u00012\b\u0010[\u001a\u0004\u0018\u00010\\2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010bH&J\u001f\u0010\u0093\u0001\u001a\u00020\u001d*\u00020>2\u0006\u0010L\u001a\u00020T2\b\u0010[\u001a\u0004\u0018\u00010\\H&J\u0016\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\b\u0010S\u001a\u0004\u0018\u00010TH&J\u0016\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0092\u00012\b\u0010S\u001a\u0004\u0018\u00010TH&J³\u0001\u0010\u0097\u0001\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010C\u001a\u0004\u0018\u00010D2\u0007\u0010\u0098\u0001\u001a\u00020B2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(2\t\b\u0002\u0010\u009a\u0001\u001a\u00020\r2\t\b\u0002\u0010\u009b\u0001\u001a\u00020\r2\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010b2\u0016\b\u0002\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010H2\u000b\b\u0002\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u000b2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\r2'\u0010\u009f\u0001\u001a\"\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u001d0xH&Jb\u0010 \u0001\u001a\u00020\u001d2\b\u0010¡\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020v2\u0014\u0010¤\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0¥\u00012&\u0010¦\u0001\u001a!\u0012\u0006\u0012\u0004\u0018\u00010v\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u001d0§\u0001H&J&\u0010¨\u0001\u001a\u00030©\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0007\u0010ª\u0001\u001a\u0002022\u0007\u0010«\u0001\u001a\u00020\rH&J\u0011\u0010¬\u0001\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&Jc\u0010\u00ad\u0001\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010®\u0001\u001a\f\u0018\u00010¯\u0001j\u0005\u0018\u0001`°\u00012\u0007\u0010±\u0001\u001a\u00020m2\t\u0010²\u0001\u001a\u0004\u0018\u00010\r2\t\b\u0002\u0010³\u0001\u001a\u00020\r2\u000b\b\u0002\u0010´\u0001\u001a\u0004\u0018\u00010\u00122\u000b\b\u0002\u0010µ\u0001\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0003\u0010¶\u0001J\n\u0010·\u0001\u001a\u00030¸\u0001H&JQ\u0010¹\u0001\u001a\u0010\u0012\u0004\u0012\u00020m\u0012\u0005\u0012\u00030»\u00010º\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\u0007\u0010À\u0001\u001a\u00020\r2\u000f\u0010Á\u0001\u001a\n\u0012\u0005\u0012\u00030Ã\u00010Â\u00012\b\u0010Ä\u0001\u001a\u00030Å\u0001H&J\n\u0010Æ\u0001\u001a\u00030Å\u0001H&J\n\u0010Ç\u0001\u001a\u00030È\u0001H&J9\u0010É\u0001\u001a\u00020\u001d2\u0007\u0010Ê\u0001\u001a\u00020>2\u0006\u0010L\u001a\u00020T2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010[\u001a\u0004\u0018\u00010\\2\t\b\u0002\u0010Ë\u0001\u001a\u00020\rH&J.\u0010Ì\u0001\u001a\u00020\u001d2\u0007\u0010Ê\u0001\u001a\u00020>2\u0006\u0010L\u001a\u00020T2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010[\u001a\u0004\u0018\u00010\\H&J\u0012\u0010Ñ\u0001\u001a\u00030Ò\u00012\u0006\u0010\u001e\u001a\u00020\u001fH&J\n\u0010Ó\u0001\u001a\u00030Ô\u0001H&J2\u0010Õ\u0001\u001a\u00020\u001d2\u0007\u0010Ö\u0001\u001a\u00020\u000b2\b\u0010r\u001a\u0004\u0018\u00010\u000b2\b\u0010s\u001a\u0004\u0018\u00010t2\n\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001H&JL\u0010Ù\u0001\u001a\u00020\u001d2\u0007\u0010Ú\u0001\u001a\u00020\r2\t\u0010Û\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\b\u0002\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\f\b\u0002\u0010Þ\u0001\u001a\u0005\u0018\u00010Ø\u00012\t\b\u0002\u0010\u009e\u0001\u001a\u00020\rH&J\u001a\u0010ß\u0001\u001a\u00020\u001d2\b\u0010à\u0001\u001a\u00030á\u0001H¦@¢\u0006\u0003\u0010â\u0001J\n\u0010ã\u0001\u001a\u00030ä\u0001H&J\n\u0010å\u0001\u001a\u00030æ\u0001H&J\u001a\u0010ç\u0001\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020D2\u0007\u0010è\u0001\u001a\u00020BH&J\t\u0010é\u0001\u001a\u00020\rH&J\u0012\u0010ê\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010Î\u0001H&J\t\u0010ë\u0001\u001a\u00020\rH&J(\u0010ì\u0001\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020\u000b2\u0015\u0010í\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0HH&J\n\u0010î\u0001\u001a\u00030ï\u0001H&J\t\u0010ð\u0001\u001a\u00020\rH&J\u0017\u0010ñ\u0001\u001a\u0004\u0018\u00010\u000b2\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H&J\u0016\u0010ô\u0001\u001a\u0004\u0018\u00010$2\t\u0010õ\u0001\u001a\u0004\u0018\u00010$H&J\u0018\u0010ö\u0001\u001a\u0005\u0018\u00010ó\u00012\n\u0010õ\u0001\u001a\u0005\u0018\u00010ó\u0001H&J\u0015\u0010÷\u0001\u001a\u00020\r2\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H&J\u0017\u0010ø\u0001\u001a\u0004\u0018\u00010\u000b2\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H&J-\u0010ù\u0001\u001a\u0004\u0018\u00010D2\b\u0010-\u001a\u0004\u0018\u00010\u000b2\t\u0010õ\u0001\u001a\u0004\u0018\u00010D2\u000b\b\u0002\u0010ú\u0001\u001a\u0004\u0018\u00010\u000bH&J-\u0010û\u0001\u001a\u0004\u0018\u00010D2\b\u0010-\u001a\u0004\u0018\u00010\u000b2\t\u0010õ\u0001\u001a\u0004\u0018\u00010D2\u000b\b\u0002\u0010ú\u0001\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010ü\u0001\u001a\u0005\u0018\u00010ó\u00012\n\u0010õ\u0001\u001a\u0005\u0018\u00010ó\u0001H&JK\u0010ý\u0001\u001a\u00020\u000b2\u0007\u0010þ\u0001\u001a\u00020\u000b2\u0006\u0010`\u001a\u00020\u000b2\u0007\u0010\u009d\u0001\u001a\u00020\u000b2\u0007\u0010ÿ\u0001\u001a\u00020\u000b2\t\b\u0002\u0010\u009e\u0001\u001a\u00020\r2\u000b\b\u0002\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0003\u0010\u0081\u0002J1\u0010\u0082\u0002\u001a\u0004\u0018\u00010D2\u0006\u0010\u007f\u001a\u00020D2\b\b\u0002\u0010`\u001a\u00020\u000b2\u000b\b\u0002\u0010ú\u0001\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0003\u0010\u0083\u0002J\t\u0010\u0084\u0002\u001a\u00020\u001dH&J#\u0010\u0085\u0002\u001a\u00020\u001d2\u0006\u0010q\u001a\u00020\u000b2\u0007\u0010\u0086\u0002\u001a\u00020\u000b2\u0007\u0010\u0087\u0002\u001a\u00020\u000bH&J\u0012\u0010\u0088\u0002\u001a\u00020\u001d2\u0007\u0010\u0089\u0002\u001a\u00020\u000bH&J\t\u0010\u008a\u0002\u001a\u00020\u001dH&R\u0012\u0010U\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0012\u0010X\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010WR\u001c\u0010Í\u0001\u001a\t\u0012\u0004\u0012\u0002020Î\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001¨\u0006\u008c\u0002"}, d2 = {"Lcom/larus/platform/spi/IAIChatUgcAIGCService;", "", "getInstructionUtils", "Lcom/larus/bmhome/instruction/IInstructionUtils;", "createInstructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getOriginalRatioId", "", "getActionBarLanguage", "", "isChatDoubleTabActivity", "", "activity", "Landroid/app/Activity;", "handleCreationSendUiEventResult", "bundle", "Landroid/os/Bundle;", "createAiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", "createTemplatePrefetchHelper", "Lcom/larus/bmhome/instruction/ITemplatePrefetchHelper;", "getBachDetectMessageExtKey", "openMusicDetailApplet", "arguments", "page", "routeMode", "saveMusicCreationAndLoading", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewParent", "Landroid/view/ViewGroup;", "downloadTaskKey", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "currentPage", "clickFrom", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sendMusicSave", "completeCallback", "Lkotlin/Function1;", "collectMusicDownLoadingStatus", "vid", "loadingAction", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRedDotNotShow", "instructionType", "", "getActionBarRouterProcessors", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/actionbar/custom/router/IOpenBySchemaRouterProcessor;", "Lkotlin/collections/ArrayList;", "shareVideo", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "shareFragment", "Landroidx/fragment/app/DialogFragment;", "messageId", "shareContainer", "Landroid/view/View;", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "eventParams", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "videoContent", "Lcom/larus/platform/model/video/VideoPlayData;", "initUrl", "reportType", "metaDataMap", "", "(Landroid/content/Context;Lcom/larus/platform/model/share/ShareItemConfig;Landroidx/fragment/app/DialogFragment;Ljava/lang/String;Landroid/view/View;Lcom/larus/bmhome/share/ShareScene;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/utils/VideoDetailEventParams;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "createMixedVideoDetailFragment", "parentFragment", "data", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "initPosition", "position", "isReadonlyForwardDetail", "createChatSpeakerView", "isShowProgressLoadingMsg", "message", "Lcom/larus/im/bean/message/Message;", "globalShowShare", "getGlobalShowShare", "()Z", "globalShowDownload", "getGlobalShowDownload", "bindImageLongClickHelper", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "imageItemInfo", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;", "parentScrollView", "scene", "extraParams", "Lorg/json/JSONObject;", "getVideoPlayerEngineManager", "Lcom/larus/bmhome/video/player/IVideoPlayerEngineManager;", "getIVideoPlayControl", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "handleImageBeautifyAction", "params", "Lcom/larus/bmhome/chat/bean/AiEditFunctionParams;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "actionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "imageBeautifyId", "openNewChatPage", "creationTaskId", "cvsId", "botId", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "doSend", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "sendImageRemoveMessage", "Lkotlin/Function4;", "Ljava/io/Serializable;", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "showDialogFragment", "dismissCreationPage", "Lkotlin/Function0;", "handleVideoExtendAction", "videoPlayData", RemoteMessageConst.MSGID, EventConstant.Key.RETAIN_PROMPT, "refImageUrl", "sendRemoteVideo", "Lkotlin/ParameterName;", "name", "text", "extMap", "trackerExt", "onResult", "findMessageFromAdapter", "createSketchLoadingController", "Lcom/larus/bmhome/chat/layout/holder/progressloading/ISketchLoadingController;", "viewStub", "Landroid/view/ViewStub;", "getVideoGenerateSaver", "Lcom/larus/bmhome/video/save_share/IVideoGenerateSaver;", "bindVideoGenerateLongClickHelper", "Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "bindSearchVideoLongClickHelper", "convertDataBean", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageContentData;", "convertVideoGenerateDataBean", "saveVideoAndLoading", "videoDetailEventParams", "clickMethod", "needTrace", "enableUseSRDownLoad", "customTraceParams", "subScene", "isAIGC", "dismissLoadingCallback", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "ext", "", "originalLogic", "Lkotlin/Function3;", "createRightLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "orientation", "reverseLayout", "getInstructionEditorViewModel", "executeOnClickCustomActionBarAction", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", MapController.ITEM_LAYER_TAG, "switchCheckState", "notReport", "bizArgs", "sendMsgMenuKey", "(Landroidx/fragment/app/Fragment;Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;ZLandroid/os/Bundle;Ljava/lang/String;)V", "createInstructionBizAdapterFactory", "Lcom/larus/bmhome/instruction/biz/IInstructionBizAdapterFactory;", "createCustomActionBarAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "segmentFactory", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "actionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "createActionBarShowTipCache", "createActionBarRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/IActionBarRedDotCacheHelper;", "bindCommonLongClickListener", "targetView", "useSimpleMenuGroupCreator", "bindLyricsToSongListBoxLongClickListener", "curChatDoubleTabPageIndex", "Lkotlinx/coroutines/flow/StateFlow;", "getCurChatDoubleTabPageIndex", "()Lkotlinx/coroutines/flow/StateFlow;", "createChatTitle", "Lcom/larus/platform/api/IChatTitle;", "getLoadingResource", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingResource;", "reportClickReEditEvent", "reeditType", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "downloadImg", "share", "imgUrl", "sharePanelEventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "uploadImage", "param", "Lcom/larus/platform/model/upload/ResourceUploadParam;", "(Lcom/larus/platform/model/upload/ResourceUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActionBarContentBuilder", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarContentBuilder;", "getMediaMessageWatcher", "Lcom/larus/bmhome/chat/model/media/IMediaMessageWatcher;", "createCreationDetailPromptVideoFragment", "eventParam", "isZDisableWcb", "zLotteryGuideMsgShowFlow", "canShowZLotteryGuideMsg", "setSendMessageTrackExtMap", "sendMsgTrackMap", "getChatConversationComponent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "isNoWatermarkEnabled", "resolveUserCreationVideoCoverResourceUri", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "selectUserCreation", "original", "resolveNoWatermarkUserCreationImageInfo", "isUserCreationImageNoWatermarkSelected", "getUserCreationNoWatermarkImageDownloadUrl", "selectVideoPlayData", "coverKey", "selectPreviewVideoPlayData", "resolvePreviewUserCreationImageInfo", "resolveFileFinalDownloadUrlIfNeeded", "url", "contentType", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveNoWatermarkVideoPlayData", "(Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMembershipStatusChanged", "setChatTraceCreationInfo", "creationId", "creationType", "logSendStart", "traceId", "tryBreakMusic", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAIChatUgcAIGCService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f365905a = null;

    @Metadata(d1 = {"\u0000þ\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096\u0001JG\u0010\u0018\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J-\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J\u001f\u0010!\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0001J3\u0010\"\u001a\u00020\r*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0001J\t\u0010%\u001a\u00020\u0017H\u0096\u0001J*\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r0)H\u0096A¢\u0006\u0002\u0010*J\u0015\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0015\u0010.\u001a\u0004\u0018\u00010$2\b\u0010-\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\t\u0010/\u001a\u000200H\u0096\u0001J\t\u00101\u001a\u000202H\u0096\u0001J\u0011\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0096\u0001J\u0011\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209H\u0096\u0001J\u0011\u0010:\u001a\u00020;2\u0006\u00108\u001a\u000209H\u0096\u0001J\u0019\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0096\u0001JE\u0010A\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D0B2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00172\f\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K2\u0006\u0010M\u001a\u000202H\u0096\u0001J\t\u0010N\u001a\u00020OH\u0096\u0001J\u0011\u0010P\u001a\u00020Q2\u0006\u00105\u001a\u000206H\u0096\u0001J5\u0010R\u001a\u0004\u0018\u0001062\b\u0010S\u001a\u0004\u0018\u0001062\u0006\u0010\u0010\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020\u0017H\u0096\u0001J#\u0010Y\u001a\u00020Z2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010[\u001a\u00020V2\u0006\u0010\\\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0096\u0001J\t\u0010a\u001a\u00020bH\u0096\u0001J?\u0010c\u001a\u00020\r2\u0006\u0010d\u001a\u00020\u00172\b\u0010e\u001a\u0004\u0018\u00010\u00052\u0006\u00108\u001a\u0002092\b\u0010f\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010j\u001a\u00020\u0017H\u0096\u0001JT\u0010k\u001a\u00020\r2\u0006\u00105\u001a\u0002062\u000e\u0010l\u001a\n\u0018\u00010mj\u0004\u0018\u0001`n2\u0006\u0010o\u001a\u00020C2\b\u0010p\u001a\u0004\u0018\u00010\u00172\u0006\u0010q\u001a\u00020\u00172\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010\u0005H\u0096\u0001¢\u0006\u0002\u0010uJ\u001f\u0010v\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010w\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\t\u0010x\u001a\u00020yH\u0096\u0001J\t\u0010z\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010{\u001a\u0012\u0012\u0004\u0012\u00020}0|j\b\u0012\u0004\u0012\u00020}`~H\u0096\u0001J\t\u0010\u007f\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0096\u0001J\u0013\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u00108\u001a\u000209H\u0096\u0001J\u0012\u0010\u0084\u0001\u001a\u00020Q2\u0006\u00105\u001a\u000206H\u0096\u0001J\u000b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0096\u0001J\u000b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0096\u0001J\u000b\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0096\u0001J\u000b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0096\u0001J\u0018\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00052\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001J\u000b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0096\u0001J\u000b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0096\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u00172\u0006\u00105\u001a\u0002062\u0007\u0010\u0095\u0001\u001a\u00020sH\u0096\u0001JZ\u0010\u0096\u0001\u001a\u00020\r2\u0006\u00108\u001a\u0002092\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010\u009c\u0001\u001a\u00020V2\u0007\u0010\u009d\u0001\u001a\u00020\u00172\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0005H\u0097\u0001Jä\u0001\u0010\u0096\u0001\u001a\u00020\r2\u0006\u00108\u001a\u0002092\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010\u009c\u0001\u001a\u00020V2\u0007\u0010\u009d\u0001\u001a\u00020\u00172\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u009f\u0001\u001a\u00020\u00052\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00052\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\u0016\u0010£\u0001\u001a\u0011\u0012\u0005\u0012\u00030¤\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010)2.\u0010¥\u0001\u001a)\u0012\u0005\u0012\u00030§\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0007\u0012\u0005\u0018\u00010¨\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010¦\u00012\u0018\u0010©\u0001\u001a\u0013\u0012\u0007\u0012\u0005\u0018\u00010ª\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010)2\u0010\u0010«\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010¬\u0001H\u0096\u0001J\u0091\u0002\u0010\u00ad\u0001\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010=\u001a\u00020>2\t\u0010®\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u009d\u0001\u001a\u00020\u00172\u008e\u0001\u0010±\u0001\u001a\u0088\u0001\u0012\u0015\u0012\u00130>¢\u0006\u000e\b²\u0001\u0012\t\b³\u0001\u0012\u0004\b\b(=\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b²\u0001\u0012\n\b³\u0001\u0012\u0005\b\b(´\u0001\u0012%\u0012#\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u0001¢\u0006\u000f\b²\u0001\u0012\n\b³\u0001\u0012\u0005\b\b(¶\u0001\u0012%\u0012#\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u0001¢\u0006\u000f\b²\u0001\u0012\n\b³\u0001\u0012\u0005\b\b(·\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010¦\u00012\u0016\u0010·\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u00012\u0015\u0010¸\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r\u0018\u00010)H\u0096\u0001J\u0014\u0010¹\u0001\u001a\u00020\u00172\b\u0010º\u0001\u001a\u00030»\u0001H\u0096\u0001J\n\u0010¼\u0001\u001a\u00020\u0017H\u0096\u0001J\u0012\u0010½\u0001\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0011H\u0096\u0001J\u0016\u0010¾\u0001\u001a\u00020\u00172\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001J\n\u0010¿\u0001\u001a\u00020\u0017H\u0096\u0001J\u0013\u0010À\u0001\u001a\u00020\r2\u0007\u0010Á\u0001\u001a\u00020\u0005H\u0096\u0001J\n\u0010Â\u0001\u001a\u00020\rH\u0096\u0001J%\u0010Ã\u0001\u001a\u00020\u00172\u0007\u0010Ä\u0001\u001a\u00020s2\u0007\u0010Å\u0001\u001a\u00020\u00052\u0007\u0010Æ\u0001\u001a\u00020\u0005H\u0096\u0001J5\u0010Ç\u0001\u001a\u00020\r2\u0007\u0010È\u0001\u001a\u00020\u00052\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00052\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\t\u0010É\u0001\u001a\u0004\u0018\u00010iH\u0096\u0001JF\u0010Ê\u0001\u001a\u00020\u00052\u0007\u0010Ë\u0001\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0007\u0010Ì\u0001\u001a\u00020\u00052\u0007\u0010Í\u0001\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u00172\t\u0010Î\u0001\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0003\u0010Ï\u0001J\u0019\u0010Ð\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001J-\u0010Ò\u0001\u001a\u0004\u0018\u00010>2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001d\u001a\u00020\u00052\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0005H\u0096A¢\u0006\u0003\u0010Ô\u0001J\u0019\u0010Õ\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001J\u0018\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00052\n\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0096\u0001Jl\u0010×\u0001\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u0001092\u0007\u0010Ø\u0001\u001a\u00020\u001c2\u0007\u0010Ù\u0001\u001a\u00020\u00052\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u00012\u0007\u0010Ü\u0001\u001a\u00020\u00052\u0007\u0010Ý\u0001\u001a\u00020\u00052\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010Þ\u0001\u001a\u00020\u00172\u0013\u0010ß\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r0)H\u0096\u0001J\u00ad\u0001\u0010à\u0001\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010#\u001a\u0004\u0018\u00010>2\u0007\u0010á\u0001\u001a\u00020@2\u0007\u0010â\u0001\u001a\u00020\u00052\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010ã\u0001\u001a\u00020\u00172\u0007\u0010ä\u0001\u001a\u00020\u00172\t\u0010å\u0001\u001a\u0004\u0018\u00010\u001f2\u0016\u0010æ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u00012\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010j\u001a\u00020\u00172)\u0010ç\u0001\u001a$\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u008c\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\r0¦\u0001H\u0096\u0001J,\u0010è\u0001\u001a\u0004\u0018\u00010>2\b\u0010'\u001a\u0004\u0018\u00010\u00052\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010>2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u0019\u0010é\u0001\u001a\u0005\u0018\u00010Û\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Û\u0001H\u0096\u0001J,\u0010ê\u0001\u001a\u0004\u0018\u00010>2\b\u0010'\u001a\u0004\u0018\u00010\u00052\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010>2\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J%\u0010ë\u0001\u001a\u00020\r2\u0007\u0010\u009f\u0001\u001a\u00020\u00052\u0007\u0010ì\u0001\u001a\u00020\u00052\u0007\u0010í\u0001\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010î\u0001\u001a\u00020\r2\u0007\u0010ï\u0001\u001a\u00020VH\u0096\u0001J+\u0010ð\u0001\u001a\u00020\r2\u0007\u0010\u009f\u0001\u001a\u00020\u00052\u0016\u0010ñ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050µ\u0001H\u0096\u0001J\u0096\u0001\u0010ò\u0001\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010ó\u0001\u001a\u00030ô\u00012\n\u0010õ\u0001\u001a\u0005\u0018\u00010ª\u00012\u0006\u0010w\u001a\u00020\u00052\u0007\u0010ö\u0001\u001a\u00020\u000f2\b\u0010÷\u0001\u001a\u00030ø\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010ù\u0001\u001a\u00020@2\b\u0010#\u001a\u0004\u0018\u00010>2\t\u0010ú\u0001\u001a\u0004\u0018\u00010\u00052\t\u0010û\u0001\u001a\u0004\u0018\u00010V2\u0016\u0010æ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010µ\u0001H\u0096\u0001¢\u0006\u0003\u0010ü\u0001J\n\u0010ý\u0001\u001a\u00020\rH\u0096\u0001Jf\u0010þ\u0001\u001a\u00020\r2\b\u0010ÿ\u0001\u001a\u00030\u0080\u00022\u0007\u0010\u0081\u0002\u001a\u00020\u00052\b\u0010\u0097\u0001\u001a\u00030¤\u00012\u0014\u0010\u0082\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0083\u00022'\u0010\u0084\u0002\u001a\"\u0012\u0007\u0012\u0005\u0018\u00010¤\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\r0\u0085\u0002H\u0096\u0001J\u001a\u0010\u0086\u0002\u001a\u00020\r2\b\u0010\u0087\u0002\u001a\u00030\u0088\u0002H\u0096A¢\u0006\u0003\u0010\u0089\u0002J\u0013\u0010\u008a\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u008b\u0002H\u0096\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u008c\u0002\u001a\t\u0012\u0004\u0012\u00020V0\u008b\u0002X\u0096\u0005¢\u0006\b\u001a\u0006\b\u008d\u0002\u0010\u008e\u0002R\u0015\u0010\u008f\u0002\u001a\u00020\u0017X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0015\u0010\u0092\u0002\u001a\u00020\u0017X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0093\u0002\u0010\u0091\u0002¨\u0006\u0094\u0002"}, d2 = {"Lcom/larus/platform/spi/IAIChatUgcAIGCService$Companion;", "Lcom/larus/platform/spi/IAIChatUgcAIGCService;", "<init>", "()V", "KEY_MUSIC_APPLET_MESSAGE_ID", "", "KEY_MUSIC_APPLET_CONVERSATION_ID", "KEY_MUSIC_APPLET_SOURCE", "KEY_MUSIC_APPLET_DATA_KEY", "KEY_MUSIC_APPLET_AUTO_OPEN_INPUT_PANEL", "MUSIC_APPLET_SOURCE_CHAT_CARD", "MUSIC_APPLET_SOURCE_ACTION_BAR_SCHEMA", "bindCommonLongClickListener", "", "targetView", "Landroid/view/View;", "data", "Lcom/larus/im/bean/message/Message;", "adapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "useSimpleMenuGroupCreator", "", "bindImageLongClickHelper", "imageItemInfo", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageItemInfo;", "parentScrollView", "Landroid/view/ViewGroup;", "scene", "extraParams", "Lorg/json/JSONObject;", "bindLyricsToSongListBoxLongClickListener", "bindSearchVideoLongClickHelper", "bindVideoGenerateLongClickHelper", "videoContent", "Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "canShowZLotteryGuideMsg", "collectMusicDownLoadingStatus", "vid", "loadingAction", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertDataBean", "Lcom/larus/bmhome/chat/layout/holder/image/bean/ImageContentData;", "message", "convertVideoGenerateDataBean", "createActionBarRedDotCacheHelper", "Lcom/larus/bmhome/view/actionbar/custom/cache/IActionBarRedDotCacheHelper;", "createActionBarShowTipCache", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarShowTipCache;", "createAiBeautifyPickPhotoHelper", "Lcom/larus/bmhome/instruction/helper/IAiBeautifyPickPhotoHelper;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "createChatSpeakerView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createChatTitle", "Lcom/larus/platform/api/IChatTitle;", "createCreationDetailPromptVideoFragment", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "eventParam", "Lcom/larus/bmhome/utils/VideoDetailEventParams;", "createCustomActionBarAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isImmerseStyle", "segmentFactory", "", "Lcom/larus/bmhome/view/actionbar/api/IActionBarSegment;", "actionBarShowTipCache", "createInstructionBizAdapterFactory", "Lcom/larus/bmhome/instruction/biz/IInstructionBizAdapterFactory;", "createInstructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "createMixedVideoDetailFragment", "parentFragment", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "initPosition", "", "position", "isReadonlyForwardDetail", "createRightLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "orientation", "reverseLayout", "createSketchLoadingController", "Lcom/larus/bmhome/chat/layout/holder/progressloading/ISketchLoadingController;", "viewStub", "Landroid/view/ViewStub;", "createTemplatePrefetchHelper", "Lcom/larus/bmhome/instruction/ITemplatePrefetchHelper;", "downloadImg", "share", "imgUrl", "sharePanelEventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "isAIGC", "executeOnClickCustomActionBarAction", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", MapController.ITEM_LAYER_TAG, "switchCheckState", "notReport", "bizArgs", "Landroid/os/Bundle;", "sendMsgMenuKey", "(Landroidx/fragment/app/Fragment;Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/Boolean;ZLandroid/os/Bundle;Ljava/lang/String;)V", "findMessageFromAdapter", "messageId", "getActionBarContentBuilder", "Lcom/larus/bmhome/view/actionbar/custom/IActionBarContentBuilder;", "getActionBarLanguage", "getActionBarRouterProcessors", "Ljava/util/ArrayList;", "Lcom/larus/bmhome/view/actionbar/custom/router/IOpenBySchemaRouterProcessor;", "Lkotlin/collections/ArrayList;", "getBachDetectMessageExtKey", "getChatConversationComponent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "getIVideoPlayControl", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "getInstructionEditorViewModel", "getInstructionUtils", "Lcom/larus/bmhome/instruction/IInstructionUtils;", "getLoadingResource", "Lcom/larus/bmhome/chat/layout/holder/progressloading/LoadingResource;", "getMediaMessageWatcher", "Lcom/larus/bmhome/chat/model/media/IMediaMessageWatcher;", "getOriginalRatioId", "", "getUserCreationNoWatermarkImageDownloadUrl", "imageInfo", "Lcom/larus/platform/api/ImageInfo;", "getVideoGenerateSaver", "Lcom/larus/bmhome/video/save_share/IVideoGenerateSaver;", "getVideoPlayerEngineManager", "Lcom/larus/bmhome/video/player/IVideoPlayerEngineManager;", "handleCreationSendUiEventResult", "bundle", "handleImageBeautifyAction", "params", "Lcom/larus/bmhome/chat/bean/AiEditFunctionParams;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "actionBarItem", "imageBeautifyId", "openNewChatPage", "creationTaskId", "cvsId", "botId", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "doSend", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "sendImageRemoveMessage", "Lkotlin/Function4;", "Ljava/io/Serializable;", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "showDialogFragment", "Landroidx/fragment/app/DialogFragment;", "dismissCreationPage", "Lkotlin/Function0;", "handleVideoExtendAction", RemoteMessageConst.MSGID, EventConstant.Key.RETAIN_PROMPT, "refImageUrl", "sendRemoteVideo", "Lkotlin/ParameterName;", "name", "text", "", "extMap", "trackerExt", "onResult", "isChatDoubleTabActivity", "activity", "Landroid/app/Activity;", "isNoWatermarkEnabled", "isShowProgressLoadingMsg", "isUserCreationImageNoWatermarkSelected", "isZDisableWcb", "logSendStart", "traceId", "onMembershipStatusChanged", "openMusicDetailApplet", "arguments", "page", "routeMode", "reportClickReEditEvent", "reeditType", "trackNode", "resolveFileFinalDownloadUrlIfNeeded", "url", "subScene", "contentType", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveNoWatermarkUserCreationImageInfo", "original", "resolveNoWatermarkVideoPlayData", "coverKey", "(Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolvePreviewUserCreationImageInfo", "resolveUserCreationVideoCoverResourceUri", "saveMusicCreationAndLoading", "viewParent", "downloadTaskKey", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "currentPage", "clickFrom", "sendMusicSave", "completeCallback", "saveVideoAndLoading", "videoDetailEventParams", "clickMethod", "needTrace", "enableUseSRDownLoad", "customTraceParams", "metaDataMap", "dismissLoadingCallback", "selectPreviewVideoPlayData", "selectUserCreation", "selectVideoPlayData", "setChatTraceCreationInfo", "creationId", "creationType", "setRedDotNotShow", "instructionType", "setSendMessageTrackExtMap", "sendMsgTrackMap", "shareVideo", "shareItemConfig", "Lcom/larus/platform/model/share/ShareItemConfig;", "shareFragment", "shareContainer", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "eventParams", "initUrl", "reportType", "(Landroid/content/Context;Lcom/larus/platform/model/share/ShareItemConfig;Landroidx/fragment/app/DialogFragment;Ljava/lang/String;Landroid/view/View;Lcom/larus/bmhome/share/ShareScene;Lkotlinx/coroutines/CoroutineScope;Lcom/larus/bmhome/utils/VideoDetailEventParams;Lcom/larus/platform/model/video/VideoPlayData;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "tryBreakMusic", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "ext", "", "originalLogic", "Lkotlin/Function3;", "uploadImage", "param", "Lcom/larus/platform/model/upload/ResourceUploadParam;", "(Lcom/larus/platform/model/upload/ResourceUploadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zLotteryGuideMsgShowFlow", "Lkotlinx/coroutines/flow/StateFlow;", "curChatDoubleTabPageIndex", "getCurChatDoubleTabPageIndex", "()Lkotlinx/coroutines/flow/StateFlow;", "globalShowDownload", "getGlobalShowDownload", "()Z", "globalShowShare", "getGlobalShowShare", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IAIChatUgcAIGCService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f365906c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IAIChatUgcAIGCService f365907b;

        static {
            f365906c = new Companion();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void A0(int r100) {
            this.f365907b.A0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final qs8.a B0(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f365907b.B0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void C0(View r110, Message r111, q0.a r112, df8.a r113, ViewGroup r114, String r115, JSONObject r116) {
            Intrinsics.checkNotNullParameter(r110, "<this>");
            Intrinsics.checkNotNullParameter(r111, "data");
            this.f365907b.C0(r110, r111, r112, r113, r114, r115, r116);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Object D(String r100, String r110, String r111, String r112, boolean r113, String r114, Continuation<? super String> r115) {
            return this.f365907b.D(r100, r110, r111, r112, r113, r114, r115);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final g D0(String r100, g r101, String r102) {
            return this.f365907b.D0(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final i1<Boolean> E() {
            return this.f365907b.E();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean E0() {
            return this.f365907b.E0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean F(Fragment r100, Bundle r101) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, "bundle");
            return this.f365907b.F(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final String F0() {
            return this.f365907b.F0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final com.larus.bmhome.video.save_share.a G() {
            return this.f365907b.G();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void G0(Context r110, g r111, String r112, String r113, String r114, String r115, boolean r116, Function4<? super g, ? super String, ? super Map<String, String>, ? super Map<String, String>, Unit> r210, Map<String, String> r211, Function1<? super Boolean, Unit> r212) {
            Intrinsics.checkNotNullParameter(r111, "videoPlayData");
            this.f365907b.G0(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void H() {
            this.f365907b.H();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final f H0(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            return this.f365907b.H0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final c I(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            return this.f365907b.I(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Object I0(j r100, Continuation<? super Unit> r101) {
            return this.f365907b.I0(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean J() {
            return this.f365907b.J();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void J0(String r100, Context r101, h r110, e r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f365907b.J0(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final View K(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f365907b.K(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final String K0() {
            return this.f365907b.K0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ps8.a L() {
            return this.f365907b.L();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Object L0(g r100, String r101, String r102, Continuation<? super g> r103) {
            return this.f365907b.L0(r100, r101, r102, r103);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final i M() {
            return this.f365907b.M();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void M0(w r100, Message r101, q0.a r102) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f365907b.M0(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean N(Bundle r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "arguments");
            Intrinsics.checkNotNullParameter(r101, "page");
            Intrinsics.checkNotNullParameter(MusicAppletPage.ROUTE_MODE_RELAUNCH, "routeMode");
            return this.f365907b.N(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final g0 O(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f365907b.O(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ArrayList<b> P() {
            return this.f365907b.P();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void Q(View r100, Message r101, q0 r110, q0.a r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "targetView");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f365907b.Q(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final long R() {
            return this.f365907b.R();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void S(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            Intrinsics.checkNotNullParameter(r101, "creationId");
            Intrinsics.checkNotNullParameter(r102, "creationType");
            this.f365907b.S(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void T(View r100, Message r101, AiGenVideoContentData r110, q0.a r111, JSONObject r112) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f365907b.T(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean U() {
            return this.f365907b.U();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Fragment V(g r100, c4 r101) {
            Intrinsics.checkNotNullParameter(r100, "videoPlayData");
            Intrinsics.checkNotNullParameter(r101, "eventParam");
            return this.f365907b.V(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final x2 W() {
            return this.f365907b.W();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ComponentFeature X() {
            return this.f365907b.X();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ISketchLoadingController Y(ViewStub r100) {
            return this.f365907b.Y(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final String Z(ImageInfo r100) {
            return this.f365907b.Z(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void a(y8 r100, String r101, ICoreInputAbility.OnSendParams r110, Map r111, o1 r112) {
            Intrinsics.checkNotNullParameter(r100, "dependency");
            Intrinsics.checkNotNullParameter(r101, "originContent");
            Intrinsics.checkNotNullParameter(r110, "params");
            Intrinsics.checkNotNullParameter(r111, "ext");
            Intrinsics.checkNotNullParameter(r112, "originalLogic");
            this.f365907b.a(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void a0(Fragment r110, CreationEditorComponent r111, z0 r112, Boolean r113, boolean r114, Bundle r115, String r116) {
            Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
            this.f365907b.a0(r110, r111, r112, r113, r114, r115, r116);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void b(Context r110, g r111, c4 r112, String r113, CoroutineScope r114, boolean r210, boolean r211, JSONObject r212, Map<String, String> r213, String r214, boolean r215, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r216) {
            Intrinsics.checkNotNullParameter(r112, "videoDetailEventParams");
            Intrinsics.checkNotNullParameter(r113, "clickMethod");
            Intrinsics.checkNotNullParameter(r114, "scope");
            Intrinsics.checkNotNullParameter(r216, "dismissLoadingCallback");
            this.f365907b.b(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final yh8.a b0() {
            return this.f365907b.b0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void c(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            Intrinsics.checkNotNullParameter(r101, "sendMsgTrackMap");
            this.f365907b.c(r100, r101);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void c0(Context r110, ViewGroup r111, String r112, UserCreation r113, String r114, String r115, LifecycleCoroutineScope r116, boolean r117, Function1 r210) {
            Intrinsics.checkNotNullParameter(r111, "viewParent");
            Intrinsics.checkNotNullParameter(r112, "downloadTaskKey");
            Intrinsics.checkNotNullParameter(r114, "currentPage");
            Intrinsics.checkNotNullParameter(r115, "clickFrom");
            Intrinsics.checkNotNullParameter(r116, "scope");
            Intrinsics.checkNotNullParameter(r210, "completeCallback");
            this.f365907b.c0(r110, r111, r112, r113, r114, r115, r116, r117, r210);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "traceId");
            this.f365907b.d(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ImageContentData d0(Message r100) {
            return this.f365907b.d0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final com.larus.bmhome.instruction.j e0() {
            return this.f365907b.e0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final k f0() {
            return this.f365907b.f0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean g0(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            return this.f365907b.g0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void h0(View r100, Message r101, q0 r102, q0.a r103) {
            Intrinsics.checkNotNullParameter(r100, "targetView");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f365907b.h0(r100, r101, r102, r103);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void i0(Context r110, ic8.f r111, CoroutineScope r112, z0 r210, int r211, boolean r212, String r213, String r214, String r215, wc9.e r216, Function1<? super ICoreInputAbility.OnSendParams, Unit> r217, Function4<? super Serializable, ? super String, ? super String, ? super zs8.a, Unit> r218, Function1<? super DialogFragment, Unit> r219, Function0<Unit> r310) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "params");
            Intrinsics.checkNotNullParameter(r214, "cvsId");
            this.f365907b.i0(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Object j0(String r100, com.larus.bmhome.bigimg.download.c r101, Continuation r102) {
            return this.f365907b.j0(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean k0(ImageInfo r100) {
            return this.f365907b.k0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean l0() {
            return this.f365907b.l0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ListAdapter m0(ChatParam r100, com.larus.uaigc.createpage.component.instruction.o1 r101, List r102, x2 r103) {
            Intrinsics.checkNotNullParameter(r101, "callback");
            Intrinsics.checkNotNullParameter(r102, "segmentFactory");
            Intrinsics.checkNotNullParameter(r103, "actionBarShowTipCache");
            return this.f365907b.m0(r100, r101, r102, r103);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final i1<Integer> n0() {
            return this.f365907b.n0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void n4() {
            this.f365907b.n4();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final ImageInfo o0(ImageInfo r100) {
            return this.f365907b.o0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void p0(String r100, wc9.e r101, e r102) {
            Intrinsics.checkNotNullParameter("music", "reeditType");
            this.f365907b.p0(r100, r101, r102);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final Fragment q0(Fragment r100, zo8.a r101, int r110, int r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r101, "data");
            return this.f365907b.q0(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final AiGenVideoContentData r0(Message r100) {
            return this.f365907b.r0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean s0(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            return this.f365907b.s0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final void t0(Context r110, jr9.a r111, String r112, View r113, ShareScene r114, CoroutineScope r115, c4 r116, g r210, Integer r211, Map r212) {
            Intrinsics.checkNotNullParameter(r111, "shareItemConfig");
            Intrinsics.checkNotNullParameter(r112, "messageId");
            Intrinsics.checkNotNullParameter(r113, "shareContainer");
            Intrinsics.checkNotNullParameter(r114, "shareScene");
            Intrinsics.checkNotNullParameter(r115, "scope");
            Intrinsics.checkNotNullParameter(r116, "eventParams");
            this.f365907b.t0(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final c u0(Fragment r100) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            return this.f365907b.u0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final LinearLayoutManager v0(Context r100) {
            return this.f365907b.v0(r100);
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final m w0() {
            return this.f365907b.w0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final com.larus.bmhome.chat.layout.holder.progressloading.e x0() {
            return this.f365907b.x0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final boolean y0() {
            return this.f365907b.y0();
        }

        @Override // com.larus.platform.spi.IAIChatUgcAIGCService
        public final w2 z0() {
            return this.f365907b.z0();
        }

        private Companion() {
            IAIChatUgcAIGCService r100 = (IAIChatUgcAIGCService) ServiceManager.get().getService(IAIChatUgcAIGCService.class);
            if (r100 != null) goto L5;
            r100 = new AIChatUgcAIGCServiceNoop();
        L5:
            this.f365907b = r100;
        }
    }

    public static final class a {
        public static /* synthetic */ Object d(Companion r100, String r101, String r110, String r111, Continuation r112) {
            return r100.D(r101, r110, r111, "file", false, null, r112);
        }

        public static /* synthetic */ void a(Companion r100, View r101, Message r110, q0.a r111, df8.a r112, ViewGroup r113, JSONObject r114) {
            r100.C0(r101, r110, r111, r112, r113, null, r114);
        }

        public static /* synthetic */ void c(Companion r110, Context r111, g r112, String r113, String r114, String r115, String r116, boolean r117, Function4 r118, Map r210) {
            r110.G0(r111, r112, r113, r114, r115, r116, r117, r118, r210, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void e(Companion r110, Context r111, g r112, c4 r113, String r210, CoroutineScope r211, JSONObject r212, Map r213, String r214, boolean r215, Function4 r216, int r217) {
            if ((r217 & 32) == 0) goto L5;
            boolean r100 = true;
        L7:
            if ((r217 & 128) == 0) goto L9;
            JSONObject r114 = null;
        L11:
            if ((r217 & 256) == 0) goto L13;
            Map r115 = null;
        L15:
            if ((r217 & 512) == 0) goto L17;
            String r116 = null;
        L19:
            if ((r217 & 1024) == 0) goto L21;
            boolean r117 = false;
        L22:
            r110.b(r111, r112, r113, r210, r211, r100, false, r114, r115, r116, r117, r216);
            return;
        L21:
            r117 = r215;
            goto L22
        L17:
            r116 = r214;
            goto L19
        L13:
            r115 = r213;
            goto L15
        L9:
            r114 = r212;
            goto L11
        L5:
            r100 = false;
            goto L7
        }

        public static /* synthetic */ void b(Companion r110, Context r111, ic8.f r112, CoroutineScope r113, z0 r114, int r210, boolean r211, String r212, String r213, wc9.e r214, Function1 r215, Function4 r216, Function1 r217, Function0 r218) {
            r110.i0(r111, r112, r113, r114, r210, r211, null, r212, r213, r214, r215, r216, r217, r218);
        }
    }

    static {
        f365905a = Companion.f365906c;
    }

    void A0(int r100);

    qs8.a B0(Context r100);

    void C0(View r100, Message r101, q0.a r102, df8.a r103, ViewGroup r104, String r105, JSONObject r106);

    Object D(String r100, String r101, String r102, String r103, boolean r104, String r105, Continuation<? super String> r106);

    g D0(String r100, g r101, String r102);

    i1<Boolean> E();

    boolean E0();

    boolean F(Fragment r100, Bundle r101);

    String F0();

    com.larus.bmhome.video.save_share.a G();

    void G0(Context r100, g r101, String r102, String r103, String r104, String r105, boolean r106, Function4<? super g, ? super String, ? super Map<String, String>, ? super Map<String, String>, Unit> r107, Map<String, String> r108, Function1<? super Boolean, Unit> r110);

    void H();

    f H0(Fragment r100);

    c I(Fragment r100);

    Object I0(j r100, Continuation<? super Unit> r101);

    boolean J();

    void J0(String r100, Context r101, h r102, e r103, boolean r104);

    View K(Context r100);

    String K0();

    ps8.a L();

    Object L0(g r100, String r101, String r102, Continuation<? super g> r103);

    i M();

    void M0(w r100, Message r101, q0.a r102);

    boolean N(Bundle r100, String r101);

    g0 O(Context r100);

    ArrayList<b> P();

    void Q(View r100, Message r101, q0 r102, q0.a r103, boolean r104);

    long R();

    void S(String r100, String r101, String r102);

    void T(View r100, Message r101, AiGenVideoContentData r102, q0.a r103, JSONObject r104);

    boolean U();

    Fragment V(g r100, c4 r101);

    x2 W();

    ComponentFeature X();

    ISketchLoadingController Y(ViewStub r100);

    String Z(ImageInfo r100);

    void a(y8 r100, String r101, ICoreInputAbility.OnSendParams r102, Map r103, o1 r104);

    void a0(Fragment r100, CreationEditorComponent r101, z0 r102, Boolean r103, boolean r104, Bundle r105, String r106);

    void b(Context r100, g r101, c4 r102, String r103, CoroutineScope r104, boolean r105, boolean r106, JSONObject r107, Map<String, String> r108, String r110, boolean r111, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r112);

    yh8.a b0();

    void c(String r100, Map<String, String> r101);

    void c0(Context r100, ViewGroup r101, String r102, UserCreation r103, String r104, String r105, LifecycleCoroutineScope r106, boolean r107, Function1 r108);

    void d(String r100);

    ImageContentData d0(Message r100);

    com.larus.bmhome.instruction.j e0();

    k f0();

    boolean g0(Message r100);

    void h0(View r100, Message r101, q0 r102, q0.a r103);

    void i0(Context r100, ic8.f r101, CoroutineScope r102, z0 r103, int r104, boolean r105, String r106, String r107, String r108, wc9.e r110, Function1<? super ICoreInputAbility.OnSendParams, Unit> r111, Function4<? super Serializable, ? super String, ? super String, ? super zs8.a, Unit> r112, Function1<? super DialogFragment, Unit> r113, Function0<Unit> r114);

    Object j0(String r100, com.larus.bmhome.bigimg.download.c r101, Continuation r102);

    boolean k0(ImageInfo r100);

    boolean l0();

    ListAdapter m0(ChatParam r100, com.larus.uaigc.createpage.component.instruction.o1 r101, List r102, x2 r103);

    i1<Integer> n0();

    void n4();

    ImageInfo o0(ImageInfo r100);

    void p0(String r100, wc9.e r101, e r102);

    Fragment q0(Fragment r100, zo8.a r101, int r102, int r103, boolean r104);

    AiGenVideoContentData r0(Message r100);

    boolean s0(FragmentActivity r100);

    void t0(Context r100, jr9.a r101, String r102, View r103, ShareScene r104, CoroutineScope r105, c4 r106, g r107, Integer r108, Map r110);

    c u0(Fragment r100);

    LinearLayoutManager v0(Context r100);

    m w0();

    com.larus.bmhome.chat.layout.holder.progressloading.e x0();

    boolean y0();

    w2 z0();
}
