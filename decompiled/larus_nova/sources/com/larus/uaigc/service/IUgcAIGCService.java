package com.larus.uaigc.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.share.ShareScene;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.ui.arch.component.external.api.Component;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u0086\u00022\u00020\u0001:\u0002\u0086\u0002J\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H¦@¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J>\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H&J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J6\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH&J<\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 H&J\b\u0010!\u001a\u00020\u0007H&JM\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0002\u0010/J\b\u00100\u001a\u000201H&J\b\u00102\u001a\u00020\u0007H&J\u0010\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u000205H&J\u001e\u00106\u001a\u00020\u00072\f\u00107\u001a\b\u0012\u0004\u0012\u000209082\u0006\u00104\u001a\u000205H&J\u001a\u0010:\u001a\u00020\u00072\u0006\u00104\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020*H&J<\u0010=\u001a\u00020\u00072\u0006\u00104\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020*2\b\b\u0002\u0010>\u001a\u00020\u001a2\u0016\b\u0002\u0010?\u001a\u0010\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u0007\u0018\u00010@H&J\u0018\u0010B\u001a\u00020\u00072\u0006\u00104\u001a\u00020;2\u0006\u0010C\u001a\u00020DH&J\b\u0010E\u001a\u00020FH&J\u0010\u0010G\u001a\u0002092\u0006\u00104\u001a\u00020HH&J*\u0010I\u001a\u0004\u0018\u00010J2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010NJ*\u0010O\u001a\u0004\u0018\u00010J2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010NJ\b\u0010P\u001a\u00020QH&J*\u0010R\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0T2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010WH'J \u0010X\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020ZH&J\u0012\u0010\\\u001a\u00020J2\b\b\u0002\u0010]\u001a\u00020\u0004H&J\b\u0010^\u001a\u00020_H&J\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020,H&J.\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020,2\u0014\u0010h\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020k\u0018\u00010j0iH&J\n\u0010l\u001a\u0004\u0018\u00010mH&J\u0010\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH&J\n\u0010r\u001a\u0004\u0018\u00010\nH&J\u001e\u0010s\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020t2\u0006\u0010u\u001a\u000209H¦@¢\u0006\u0002\u0010vJ\u0010\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020yH&J\u008e\u0001\u0010z\u001a\u00020o2T\u0010{\u001aP\u0012\u0014\u0012\u00120}¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0080\u0001\u0012\u0016\u0012\u0014\u0018\u00010\u0004¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0081\u0001\u0012\u0016\u0012\u0014\u0018\u00010Z¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0082\u0001\u0012\u0004\u0012\u00020\u0007\u0018\u00010|2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0004H&J\u008f\u0001\u0010\u0087\u0001\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\f\b\u0002\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\f\b\u0002\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012\f\b\u0002\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\f\b\u0002\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00142\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010*2\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0003\u0010\u0096\u0001J\t\u0010\u0097\u0001\u001a\u00020\u0007H&Jd\u0010\u0098\u0001\u001a\u00020\u00072\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00042\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0014\u0010\u009e\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u009f\u00012&\u0010 \u0001\u001a!\u0012\u0007\u0012\u0005\u0018\u00010\u009d\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070|H&JÒ\u0001\u0010¡\u0001\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010$2\t\b\u0002\u0010¢\u0001\u001a\u00020\u00042\n\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\u0006\u0010g\u001a\u00020,2\u0011\b\u0002\u0010¥\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010 2\u0007\u0010¦\u0001\u001a\u00020\u001a2\f\b\u0002\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00142*\u0010§\u0001\u001a%\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020y\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u0007\u0018\u00010¨\u00012\u0011\b\u0002\u0010©\u0001\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010 2\"\b\u0002\u0010ª\u0001\u001a\u001b\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00040«\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010@H&¢\u0006\u0003\u0010¬\u0001J0\u0010\u00ad\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u000b\b\u0002\u0010®\u0001\u001a\u0004\u0018\u00010\u0004H&J/\u0010\u00ad\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00142\u000b\b\u0002\u0010®\u0001\u001a\u0004\u0018\u00010\u0004H&J0\u0010¯\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u000b\b\u0002\u0010®\u0001\u001a\u0004\u0018\u00010\u0004H&J/\u0010¯\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00142\u000b\b\u0002\u0010®\u0001\u001a\u0004\u0018\u00010\u0004H&J.\u0010°\u0001\u001a\u0005\u0018\u00010\u0092\u00012\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010´\u0001\u001a\u0004\u0018\u00010\u0004H&JL\u0010µ\u0001\u001a\u00020\u00042\u0007\u0010¶\u0001\u001a\u00020\u00042\u0007\u0010·\u0001\u001a\u00020\u00042\u0007\u0010¸\u0001\u001a\u00020\u00042\u0007\u0010¹\u0001\u001a\u00020\u00042\t\b\u0002\u0010º\u0001\u001a\u00020\u001a2\u000b\b\u0002\u0010»\u0001\u001a\u0004\u0018\u00010\u0004H¦@¢\u0006\u0003\u0010¼\u0001J \u0010½\u0001\u001a\u00020\u001a2\u0015\u0010¾\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J/\u0010¿\u0001\u001a\u00030À\u00012\r\u0010Á\u0001\u001a\b0Â\u0001j\u0003`Ã\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u0004H&J/\u0010Æ\u0001\u001a\u00030À\u00012\r\u0010Á\u0001\u001a\b0Â\u0001j\u0003`Ã\u00012\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010È\u0001\u001a\u0004\u0018\u00010\u0004H&J\u0011\u0010É\u0001\u001a\n\u0012\u0005\u0012\u00030Ë\u00010Ê\u0001H&J%\u0010Ì\u0001\u001a\u00030À\u00012\r\u0010Á\u0001\u001a\b0Â\u0001j\u0003`Ã\u00012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001H&JS\u0010Í\u0001\u001a\u00030Î\u00012\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u00012;\u0010Ñ\u0001\u001a6\u0012\u0015\u0012\u00130Ó\u0001¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(\u0080\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b~\u0012\t\b\u007f\u0012\u0005\b\b(Ô\u0001\u0012\u0004\u0012\u00020\u00070Ò\u0001H&J\u0013\u0010Õ\u0001\u001a\u00020\u001a2\b\u0010Ö\u0001\u001a\u00030×\u0001H&J%\u0010Ø\u0001\u001a\u00020\u001a2\b\u0010Ö\u0001\u001a\u00030×\u00012\u0007\u0010Ù\u0001\u001a\u00020\u00042\u0007\u0010Ú\u0001\u001a\u00020\u0004H&J\t\u0010Û\u0001\u001a\u00020\u001aH&J\t\u0010Ü\u0001\u001a\u00020\u001aH&J\t\u0010Ý\u0001\u001a\u00020\u001aH&J\t\u0010Þ\u0001\u001a\u00020\u0007H&J\u0013\u0010ß\u0001\u001a\f\u0012\u0005\u0012\u00030à\u0001\u0018\u00010Ê\u0001H&J\u0013\u0010á\u0001\u001a\f\u0012\u0005\u0012\u00030à\u0001\u0018\u00010Ê\u0001H&J\u0013\u0010â\u0001\u001a\f\u0012\u0005\u0012\u00030à\u0001\u0018\u00010Ê\u0001H&J\f\u0010ã\u0001\u001a\u0005\u0018\u00010à\u0001H&J\f\u0010ä\u0001\u001a\u0005\u0018\u00010å\u0001H&J\u0014\u0010æ\u0001\u001a\u00020\u00072\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u0004H&J\u0014\u0010è\u0001\u001a\u00020\u00072\t\u0010é\u0001\u001a\u0004\u0018\u00010\u0004H&J\t\u0010ê\u0001\u001a\u00020\u001aH&J\f\u0010ë\u0001\u001a\u0005\u0018\u00010ì\u0001H&J\u0011\u0010í\u0001\u001a\u0004\u0018\u00010\u0004H¦@¢\u0006\u0002\u0010\u0005J\t\u0010î\u0001\u001a\u00020\u0007H&J\t\u0010ï\u0001\u001a\u00020\u0007H&J\u0014\u0010ð\u0001\u001a\u00020\u001a2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010\u0004H&J\u0013\u0010ò\u0001\u001a\u00020\u00072\b\u0010\u009c\u0001\u001a\u00030ó\u0001H&J\f\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H&J0\u0010ö\u0001\u001a\u00020\u00072\t\u0010·\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010÷\u0001\u001a\u00020Z2\b\u0010ø\u0001\u001a\u00030ù\u00012\u0007\u0010ú\u0001\u001a\u00020yH&J\u0083\u0001\u0010û\u0001\u001a\u00020\u001a2\u0007\u0010ü\u0001\u001a\u00020\u00172\n\u0010ý\u0001\u001a\u0005\u0018\u00010Î\u00012\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u00012\u000b\b\u0002\u0010³\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010þ\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u00042\t\b\u0002\u0010\u0081\u0002\u001a\u00020\u00042\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H&J\f\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002H&J\u0012\u0010\u0084\u0002\u001a\u00030\u0085\u00022\u0006\u0010b\u001a\u00020,H&¨\u0006\u0087\u0002"}, d2 = {"Lcom/larus/uaigc/service/IUgcAIGCService;", "", "getCacheOrFetchSpringPocketData", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preFetchSpringPocketData", "", "startObservePollingConfig", "getSpringMainVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "getWorldCupMainRouterInterceptor", "onApplyPocket", "ownerActivity", "Landroid/app/Activity;", "data", "extra", "onPopNativePage", "pushCreationNotify", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "activity", "shareContainer", "Landroid/view/View;", "targetActivity", "skipChannel", "", "pushCreationDoSameNotify", "notifyInfo", "Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "enterMethod", "clickCallBack", "Lkotlin/Function0;", "dismissCreationNotify", "downloadCreation", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "reportParams", "Lorg/json/JSONObject;", "creationType", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "rootView", "creationId", "(Landroid/content/Context;Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;Lorg/json/JSONObject;Ljava/lang/Integer;Lkotlinx/coroutines/CoroutineScope;Landroid/view/View;Ljava/lang/String;)V", "reportHelper", "Lcom/larus/uaigc/bean/IUgcReportHelper;", "clearAvatarWhiteTUrl", "openCreatePage", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "openCreatePageForResult", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "sendRemoteImageAndTextMessage", "Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;", "instructionType", "sendImageAndTextMessage", "needPreprocessImage", "uploadSuccessCallback", "Lkotlin/Function1;", "Lcom/larus/uaigc/bean/UploadSuccessData;", "sendImageRemoveMessage", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "getAspectRatioSelectStrategy", "Lcom/larus/uaigc/bean/IAspectRatioSelectStrategy;", "getCreationIntent", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "saveBitmapToCleanableDir", "Ljava/io/File;", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "fileName", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitMapToFile", "createImageRemoveDialogFragment", "Lcom/larus/uaigc/bean/remove/IImageRemoveDialogFragment;", "openBigImagesFragment", "properties", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "galleryContext", "Lcom/larus/uaigc/bean/chat/gallery/CreationGalleryContext;", "copyUri", "sourceUri", "Landroid/net/Uri;", "destinationUri", "buildSendImgCacheFile", "formatSuffix", "creationPagePerfMonitorHelper", "Lcom/larus/uaigc/bean/createpage/trace/ICreationPagePerfMonitorHelper;", "createCreationQueuingTaskViewModel", "Lcom/larus/bmhome/chat/component/loading/ICreationQueuingTaskViewModel;", "viewModelScope", "createImageLoadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "sketchProgressLoadingViewStub", "Landroid/view/ViewStub;", "scope", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "createDigitalAvatarTemplateListDialogFragment", "Landroidx/fragment/app/DialogFragment;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/uaigc/avatar/DigitalAvatarTemplateModel;", "createDigitalAvatarRouteInterceptor", "tryDirectlyJumpImageTemplate", "Landroidx/appcompat/app/AppCompatActivity;", "intent", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportTemplateRecommendOpCounter", "templatePrimaryKey", "", "createImageTemplateListDialogFragment", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "conversationId", "localImagePath", "botId", "chatType", "recommendFrom", "cvsId", "showShareImagePanel", "imgUrl", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "userCreation", "taskType", "imageKey", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/ISharePanelClickListener;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/ixigua/lib/track/ITrackNode;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Integer;Ljava/lang/String;)V", "clearCreationActionbarDependencyCache", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "ext", "", "originalLogic", "saveAigcVideoAndLoading", "downloadTaskKey", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "traceBlk", "enableUseSRDownLoad", "finishCallback", "Lkotlin/Function4;", "saveCreationTaskIdBlk", "onInterceptUrl", "Lkotlin/coroutines/Continuation;", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;ZLcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getVideoMetaData", DBDefinition.TASK_ID, "getImageMetadata", "getUserCreationFromIM", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "position", "resolveFileFinalDownloadUrlIfNeeded", "url", "scene", "subScene", "contentType", "isAIGC", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkVideoMetaDataValid", "metaData", "createDigitalAvatarInstructionBizAdapter", "Lcom/larus/bmhome/instruction/biz/AbsInstructionBizAdapter;", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "instructionDependency", "Lcom/larus/bmhome/instruction/biz/IInstructionDependency;", "createAiCreationInstructionBizAdapter", "previousPage", "currentPage", "getLyricsToSongCellInfoList", "", "Lcom/larus/bmhome/chat/cell/CellManager$CellInfo;", "createMusicInstructionBizAdapter", "createMusicTemplateListFragment", "Landroidx/fragment/app/Fragment;", "templateViewModel", "Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "templateChooseCallback", "Lkotlin/Function2;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "enterFrom", "openMusicTemplateApplet", "arguments", "Landroid/os/Bundle;", "openMusicDetailApplet", "page", "routeMode", "hasCreatedAvatar", "isAvatarInCreating", "isAvatarCreated", "initFetch", "getDigitalAvatarPreGenImagesOfScan", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "getDigitalAvatarPreGenImagesOfUpload", "getDigitalAvatarPreGenImages", "getDigitalAvatarMasterPreGenImage", "getDigitalAvatarRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "updateDigitalAvatarIpaMainTempUrl", "tempUrl", "updateDigitalAvatarIpaMainTempUri", "tempUri", "needCompleteVideoAvatar", "getAiReplicaInfo", "Lcom/larus/uaigc/api/AiReplicaInfoData;", "fetchAiReplicaIpaMainUrl", "avatarCleared", "avatarCreated", "isNestedFileProcessing", LocationMonitorConst.IDENTIFIER, "galleryShareVideo", "Lcom/larus/uaigc/creation/VideoSharePanelParams;", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "mobDuplicateStatAsync", "uri", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "citeOrQuestionAttachmentToInput", "anchorView", WidgetService.PARAM_FRAGMENT, "vid", "coverUrl", "downloadUrl", "fromScene", "createSpringMultiAttachmentSelectorComponent", "Lcom/larus/ui/arch/component/external/api/Component;", "createCreationVideoManager", "Lcom/larus/bmhome/chat/markdown/creation/video/helper/ICreationVideoManager;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IUgcAIGCService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f373945a = null;

    @Metadata(d1 = {"\u0000\u009a\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u001f\u0010\u000b\u001a\u00020\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH\u0096\u0001Jm\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\n2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000eH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u0096\u0001J!\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0096\u0001J)\u0010$\u001a\u00020%2\n\u0010&\u001a\u00060'j\u0002`(2\b\u0010)\u001a\u0004\u0018\u00010\n2\b\u0010*\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0011\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0096\u0001J\u0011\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020.H\u0096\u0001J'\u00101\u001a\u00020%2\n\u0010&\u001a\u00060'j\u0002`(2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\nH\u0096\u0001J\u000b\u00105\u001a\u0004\u0018\u000106H\u0096\u0001J\u0011\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0096\u0001J/\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020.2\u0014\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020C\u0018\u00010B0AH\u0096\u0001J\t\u0010D\u001a\u00020EH\u0096\u0001J\u0084\u0001\u0010F\u001a\u0002082Q\u0010G\u001aM\u0012\u0013\u0012\u00110I¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(M\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u0005\u0018\u00010H2\b\u0010O\u001a\u0004\u0018\u00010\n2\b\u0010P\u001a\u0004\u0018\u00010\n2\b\u0010Q\u001a\u0004\u0018\u00010\n2\b\u0010R\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u001f\u0010S\u001a\u00020%2\n\u0010&\u001a\u00060'j\u0002`(2\b\u00102\u001a\u0004\u0018\u000103H\u0096\u0001JK\u0010T\u001a\u00020\u00132\b\u0010U\u001a\u0004\u0018\u00010V26\u0010W\u001a2\u0012\u0013\u0012\u00110Y¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\n¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020\u00050XH\u0096\u0001J\u000b\u0010[\u001a\u0004\u0018\u00010\\H\u0096\u0001J\t\u0010]\u001a\u00020^H\u0096\u0001J\t\u0010_\u001a\u00020\u0005H\u0096\u0001JL\u0010`\u001a\u00020\u00052\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020.2\u0006\u0010j\u001a\u00020\u00112\b\u0010k\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0002\u0010lJ\u0010\u0010m\u001a\u0004\u0018\u00010\nH\u0096A¢\u0006\u0002\u0010nJ\u0011\u0010o\u001a\u00020\u00052\u0006\u0010p\u001a\u00020qH\u0096\u0001J\u000b\u0010r\u001a\u0004\u0018\u00010sH\u0096\u0001J\t\u0010t\u001a\u00020uH\u0096\u0001J\u001c\u0010v\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010w0\u000eH\u0096A¢\u0006\u0002\u0010nJ\u000b\u0010x\u001a\u0004\u0018\u00010yH\u0096\u0001J\u0011\u0010z\u001a\u00020{2\u0006\u0010|\u001a\u00020}H\u0096\u0001J\u000b\u0010~\u001a\u0004\u0018\u00010\u007fH\u0096\u0001J\r\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0096\u0001J\u0013\u0010\u0082\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u007f\u0018\u00010\u0083\u0001H\u0096\u0001J\u0013\u0010\u0084\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u007f\u0018\u00010\u0083\u0001H\u0096\u0001J\u0013\u0010\u0085\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u007f\u0018\u00010\u0083\u0001H\u0096\u0001J\r\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0096\u0001J/\u0010\u0088\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001J/\u0010\u0088\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0012\u0010\u008e\u0001\u001a\n\u0012\u0005\u0012\u00030\u008f\u00010\u0083\u0001H\u0096\u0001J\f\u0010\u0090\u0001\u001a\u0004\u0018\u000106H\u0096\u0001J,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008d\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001J/\u0010\u0093\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001J/\u0010\u0093\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001J\f\u0010\u0094\u0001\u001a\u0004\u0018\u000106H\u0096\u0001J\n\u0010\u0095\u0001\u001a\u00020\fH\u0096\u0001J\n\u0010\u0096\u0001\u001a\u00020\u0005H\u0096\u0001J\n\u0010\u0097\u0001\u001a\u00020\fH\u0096\u0001J\n\u0010\u0098\u0001\u001a\u00020\fH\u0096\u0001J\u0015\u0010\u0099\u0001\u001a\u00020\f2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001J2\u0010\u009b\u0001\u001a\u00020\u00052\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\n2\u0007\u0010\u009d\u0001\u001a\u00020\"2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\b\u0010 \u0001\u001a\u00030¡\u0001H\u0096\u0001J\n\u0010¢\u0001\u001a\u00020\fH\u0096\u0001JB\u0010£\u0001\u001a\u00020\u00052\t\u0010¤\u0001\u001a\u0004\u0018\u00010 2\u0015\u0010¥\u0001\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010w0\u000e2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010w0\u000eH\u0096\u0001J\u0015\u0010¦\u0001\u001a\u00020\u00052\t\u0010¤\u0001\u001a\u0004\u0018\u00010 H\u0096\u0001J/\u0010§\u0001\u001a\u00020\u00052\u0006\u0010a\u001a\u00020b2\u000f\u0010¨\u0001\u001a\n\u0012\u0005\u0012\u00030ª\u00010©\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0097\u0001J\u0013\u0010\u00ad\u0001\u001a\u00020\u00052\u0007\u0010|\u001a\u00030®\u0001H\u0096\u0001J#\u0010¯\u0001\u001a\u00020\u00052\u000e\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020{0±\u00012\u0007\u0010|\u001a\u00030®\u0001H\u0096\u0001J&\u0010²\u0001\u001a\u00020\f2\b\u0010³\u0001\u001a\u00030´\u00012\u0007\u0010µ\u0001\u001a\u00020\n2\u0007\u0010¶\u0001\u001a\u00020\nH\u0096\u0001J\u0014\u0010·\u0001\u001a\u00020\f2\b\u0010³\u0001\u001a\u00030´\u0001H\u0096\u0001J\n\u0010¸\u0001\u001a\u00020\u0005H\u0096\u0001JC\u0010¹\u0001\u001a\u00020\u00052\n\u0010º\u0001\u001a\u0005\u0018\u00010»\u00012\u0006\u0010\u001f\u001a\u00020 2\t\u0010¼\u0001\u001a\u0004\u0018\u00010 2\b\u00104\u001a\u0004\u0018\u00010\n2\u000e\u0010½\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050¾\u0001H\u0096\u0001J9\u0010¿\u0001\u001a\u00020\u00052\b\u0010À\u0001\u001a\u00030\u008a\u00012\u0006\u0010\u001f\u001a\u00020 2\u0007\u0010Á\u0001\u001a\u00020\u00112\t\u0010¼\u0001\u001a\u0004\u0018\u00010 2\u0007\u0010Â\u0001\u001a\u00020\fH\u0096\u0001J\u000b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0096\u0001J\u0014\u0010Å\u0001\u001a\u00020\u00052\b\u0010Æ\u0001\u001a\u00030¡\u0001H\u0096\u0001JH\u0010Ç\u0001\u001a\u00020\n2\u0007\u0010È\u0001\u001a\u00020\n2\u0007\u0010\u009c\u0001\u001a\u00020\n2\u0007\u0010É\u0001\u001a\u00020\n2\u0007\u0010Ê\u0001\u001a\u00020\n2\u0007\u0010Ë\u0001\u001a\u00020\f2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\nH\u0096A¢\u0006\u0003\u0010Í\u0001JÌ\u0001\u0010Î\u0001\u001a\u00020\u00052\b\u0010a\u001a\u0004\u0018\u00010b2\u0007\u0010Ï\u0001\u001a\u00020\n2\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\u0006\u0010?\u001a\u00020.2\u0010\u0010Ò\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010¾\u00012\u0007\u0010Ó\u0001\u001a\u00020\f2\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012+\u0010Ô\u0001\u001a&\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020\n\u0012\u0005\u0012\u00030¡\u0001\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010Õ\u00012\u0010\u0010Ö\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u00010¾\u00012!\u0010×\u0001\u001a\u001c\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\n0Ù\u0001\u0012\u0006\u0012\u0004\u0018\u00010w\u0018\u00010Ø\u0001H\u0096\u0001¢\u0006\u0003\u0010Ú\u0001J/\u0010Û\u0001\u001a\u0004\u0018\u00010\b2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010Ü\u0001\u001a\u00030Ý\u00012\u0007\u0010Þ\u0001\u001a\u00020\nH\u0096A¢\u0006\u0003\u0010ß\u0001J/\u0010à\u0001\u001a\u0004\u0018\u00010\b2\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010Ü\u0001\u001a\u00030Ý\u00012\u0007\u0010Þ\u0001\u001a\u00020\nH\u0096A¢\u0006\u0003\u0010ß\u0001J>\u0010á\u0001\u001a\u00020\u00052\u0007\u0010|\u001a\u00030â\u00012\u0007\u0010ã\u0001\u001a\u00020h2\u0007\u0010ä\u0001\u001a\u00020\f2\u0017\u0010å\u0001\u001a\u0012\u0012\u0005\u0012\u00030æ\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010Ø\u0001H\u0096\u0001J\u001d\u0010ç\u0001\u001a\u00020\u00052\u0007\u0010|\u001a\u00030â\u00012\b\u0010è\u0001\u001a\u00030é\u0001H\u0096\u0001J\u001c\u0010ê\u0001\u001a\u00020\u00052\u0007\u0010|\u001a\u00030â\u00012\u0007\u0010ã\u0001\u001a\u00020hH\u0096\u0001J\u0081\u0001\u0010ë\u0001\u001a\u00020\u00052\b\u0010a\u001a\u0004\u0018\u00010b2\t\u0010ì\u0001\u001a\u0004\u0018\u00010\n2\b\u0010í\u0001\u001a\u00030î\u00012\n\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u00012\n\u0010ñ\u0001\u001a\u0005\u0018\u00010ò\u00012\n\u0010ó\u0001\u001a\u0005\u0018\u00010ô\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\u0010õ\u0001\u001a\u0004\u0018\u00010h2\t\u0010ö\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001¢\u0006\u0003\u0010÷\u0001J\n\u0010ø\u0001\u001a\u00020\u0005H\u0096\u0001J\"\u0010ù\u0001\u001a\u00020\u00052\u0007\u0010\u001f\u001a\u00030ú\u00012\u0007\u0010û\u0001\u001a\u00020{H\u0096A¢\u0006\u0003\u0010ü\u0001J\u0015\u0010ý\u0001\u001a\u00020\u00052\t\u0010þ\u0001\u001a\u0004\u0018\u00010\nH\u0096\u0001J\u0015\u0010ÿ\u0001\u001a\u00020\u00052\t\u0010\u0080\u0002\u001a\u0004\u0018\u00010\nH\u0096\u0001Jd\u0010\u0081\u0002\u001a\u00020\u00052\b\u0010\u0082\u0002\u001a\u00030\u0083\u00022\u0007\u0010\u0084\u0002\u001a\u00020\n2\u0007\u0010p\u001a\u00030\u0085\u00022\u0014\u0010\u0086\u0002\u001a\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0087\u00022&\u0010\u0088\u0002\u001a!\u0012\u0007\u0012\u0005\u0018\u00010\u0085\u0002\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00050HH\u0096\u0001¨\u0006\u0089\u0002"}, d2 = {"Lcom/larus/uaigc/service/IUgcAIGCService$Companion;", "Lcom/larus/uaigc/service/IUgcAIGCService;", "<init>", "()V", "avatarCleared", "", "avatarCreated", "buildSendImgCacheFile", "Ljava/io/File;", "formatSuffix", "", "checkVideoMetaDataValid", "", "metaData", "", "citeOrQuestionAttachmentToInput", "anchorView", "Landroid/view/View;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "vid", "coverUrl", "downloadUrl", "fromScene", "extra", "clearAvatarWhiteTUrl", "clearCreationActionbarDependencyCache", "copyUri", "activity", "Landroid/app/Activity;", "sourceUri", "Landroid/net/Uri;", "destinationUri", "createAiCreationInstructionBizAdapter", "Lcom/larus/bmhome/instruction/biz/AbsInstructionBizAdapter;", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "previousPage", "currentPage", "createCreationQueuingTaskViewModel", "Lcom/larus/bmhome/chat/component/loading/ICreationQueuingTaskViewModel;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "createCreationVideoManager", "Lcom/larus/bmhome/chat/markdown/creation/video/helper/ICreationVideoManager;", "createDigitalAvatarInstructionBizAdapter", "instructionDependency", "Lcom/larus/bmhome/instruction/biz/IInstructionDependency;", "enterMethod", "createDigitalAvatarRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createDigitalAvatarTemplateListDialogFragment", "Landroidx/fragment/app/DialogFragment;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/uaigc/avatar/DigitalAvatarTemplateModel;", "createImageLoadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "sketchProgressLoadingViewStub", "Landroid/view/ViewStub;", "scope", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "createImageRemoveDialogFragment", "Lcom/larus/uaigc/bean/remove/IImageRemoveDialogFragment;", "createImageTemplateListDialogFragment", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "conversationId", "localImagePath", "botId", "chatType", "recommendFrom", "cvsId", "createMusicInstructionBizAdapter", "createMusicTemplateListFragment", "templateViewModel", "Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "templateChooseCallback", "Lkotlin/Function2;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "enterFrom", "createSpringMultiAttachmentSelectorComponent", "Lcom/larus/ui/arch/component/external/api/Component;", "creationPagePerfMonitorHelper", "Lcom/larus/uaigc/bean/createpage/trace/ICreationPagePerfMonitorHelper;", "dismissCreationNotify", "downloadCreation", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "reportParams", "Lorg/json/JSONObject;", "creationType", "", "mainScope", "rootView", "creationId", "(Landroid/content/Context;Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;Lorg/json/JSONObject;Ljava/lang/Integer;Lkotlinx/coroutines/CoroutineScope;Landroid/view/View;Ljava/lang/String;)V", "fetchAiReplicaIpaMainUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "galleryShareVideo", "params", "Lcom/larus/uaigc/creation/VideoSharePanelParams;", "getAiReplicaInfo", "Lcom/larus/uaigc/api/AiReplicaInfoData;", "getAspectRatioSelectStrategy", "Lcom/larus/uaigc/bean/IAspectRatioSelectStrategy;", "getCacheOrFetchSpringPocketData", "", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "getCreationIntent", "Landroid/content/Intent;", "config", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "getDigitalAvatarMasterPreGenImage", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "getDigitalAvatarPreGenImages", "", "getDigitalAvatarPreGenImagesOfScan", "getDigitalAvatarPreGenImagesOfUpload", "getDigitalAvatarRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "getImageMetadata", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", DBDefinition.TASK_ID, "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "getLyricsToSongCellInfoList", "Lcom/larus/bmhome/chat/cell/CellManager$CellInfo;", "getSpringMainVenueRouterInterceptor", "getUserCreationFromIM", "position", "getVideoMetaData", "getWorldCupMainRouterInterceptor", "hasCreatedAvatar", "initFetch", "isAvatarCreated", "isAvatarInCreating", "isNestedFileProcessing", LocationMonitorConst.IDENTIFIER, "mobDuplicateStatAsync", "scene", "uri", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "", "needCompleteVideoAvatar", "onApplyPocket", "ownerActivity", "data", "onPopNativePage", "openBigImagesFragment", "properties", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "galleryContext", "Lcom/larus/uaigc/bean/chat/gallery/CreationGalleryContext;", "openCreatePage", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "openCreatePageForResult", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "openMusicDetailApplet", "arguments", "Landroid/os/Bundle;", "page", "routeMode", "openMusicTemplateApplet", "preFetchSpringPocketData", "pushCreationDoSameNotify", "notifyInfo", "Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "targetActivity", "clickCallBack", "Lkotlin/Function0;", "pushCreationNotify", "creation", "shareContainer", "skipChannel", "reportHelper", "Lcom/larus/uaigc/bean/IUgcReportHelper;", "reportTemplateRecommendOpCounter", "templatePrimaryKey", "resolveFileFinalDownloadUrlIfNeeded", "url", "subScene", "contentType", "isAIGC", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAigcVideoAndLoading", "downloadTaskKey", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "traceBlk", "enableUseSRDownLoad", "finishCallback", "Lkotlin/Function4;", "saveCreationTaskIdBlk", "onInterceptUrl", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;ZLcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "saveBitMapToFile", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "fileName", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitmapToCleanableDir", "sendImageAndTextMessage", "Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;", "instructionType", "needPreprocessImage", "uploadSuccessCallback", "Lcom/larus/uaigc/bean/UploadSuccessData;", "sendImageRemoveMessage", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "sendRemoteImageAndTextMessage", "showShareImagePanel", "imgUrl", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "taskType", "imageKey", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/ISharePanelClickListener;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/ixigua/lib/track/ITrackNode;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Integer;Ljava/lang/String;)V", "startObservePollingConfig", "tryDirectlyJumpImageTemplate", "Landroidx/appcompat/app/AppCompatActivity;", "intent", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDigitalAvatarIpaMainTempUri", "tempUri", "updateDigitalAvatarIpaMainTempUrl", "tempUrl", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "ext", "", "originalLogic", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IUgcAIGCService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f373946c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IUgcAIGCService f373947b;

        static {
            f373946c = new Companion();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void A(ActivityResultLauncher<Intent> r100, ny9.c r101) {
            Intrinsics.checkNotNullParameter(r100, "activityResultLauncher");
            Intrinsics.checkNotNullParameter(r101, "config");
            this.f373947b.A(r100, r101);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Map<String, String> B(UserCreation r100, String r101) {
            return this.f373947b.B(r100, r101);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Object C(Continuation<? super String> r100) {
            return this.f373947b.C(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Object D(String r100, String r110, String r111, String r112, boolean r113, String r114, Continuation<? super String> r115) {
            return this.f373947b.D(r100, r110, r111, r112, r113, r114, r115);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final xy9.b E() {
            return this.f373947b.E();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void F() {
            this.f373947b.F();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final com.larus.uaigc.api.a G() {
            return this.f373947b.G();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Map<String, String> H(UserCreation r100, String r101) {
            return this.f373947b.H(r100, r101);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final UserCreationFromIM I(Message r100, String r101, String r102) {
            return this.f373947b.I(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void J(UserCreation r100, FragmentActivity r101, View r110, Activity r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "creation");
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r110, "shareContainer");
            this.f373947b.J(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final List<ey9.k> K() {
            return this.f373947b.K();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Map<String, String> L(UserCreationFromIM r100, String r101) {
            return this.f373947b.L(r100, r101);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Component M() {
            return this.f373947b.M();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void N(Context r110, String r111, ShareScene r112, com.larus.bmhome.share.panel.d r113, com.larus.bmhome.share.panel.h r114, by7.e r115, UserCreationFromIM r116, UserCreation r210, Integer r211, String r212) {
            Intrinsics.checkNotNullParameter(r112, "shareScene");
            this.f373947b.N(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void O() {
            this.f373947b.O();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void P() {
            this.f373947b.P();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final List<ey9.k> Q() {
            return this.f373947b.Q();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final DialogFragment R(dy9.a r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            return this.f373947b.R(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final boolean S() {
            return this.f373947b.S();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void T(String r100) {
            this.f373947b.T(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void U(String r100, Uri r101, ic8.n0 r110, long r111) {
            Intrinsics.checkNotNullParameter(r101, "uri");
            Intrinsics.checkNotNullParameter(r110, "processFileResult");
            this.f373947b.U(r100, r101, r110, r111);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final kh8.a V(LifecycleCoroutineScope r100) {
            Intrinsics.checkNotNullParameter(r100, "viewModelScope");
            return this.f373947b.V(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void W(ny9.b r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f373947b.W(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final boolean X(Bundle r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "arguments");
            Intrinsics.checkNotNullParameter(r101, "page");
            Intrinsics.checkNotNullParameter(r102, "routeMode");
            return this.f373947b.X(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final boolean Y(Bundle r100) {
            Intrinsics.checkNotNullParameter(r100, "arguments");
            return this.f373947b.Y(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void Z(CreationDoSameNotifyInfo r100, FragmentActivity r101, FragmentActivity r110, String r111, Function0 r112) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            Intrinsics.checkNotNullParameter(r112, "clickCallBack");
            this.f373947b.Z(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final q97.a a() {
            return this.f373947b.a();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void b(Activity r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r102, "extra");
            this.f373947b.b(r100, r101, r102);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void c(String r100) {
            this.f373947b.c(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final q97.a d() {
            return this.f373947b.d();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Object e(Context r100, Bitmap r101, String r102, Continuation<? super File> r103) {
            return this.f373947b.e(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void f() {
            this.f373947b.f();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void g(Context r110, String r111, nr9.g r112, CoroutineScope r113, Function0<Unit> r114, boolean r115, UserCreationFromIM r210, UserCreation r211, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r212, Function0<Unit> r213, Function1<? super Continuation<? super String>, ? extends Object> r214) {
            Intrinsics.checkNotNullParameter(r111, "downloadTaskKey");
            Intrinsics.checkNotNullParameter(r113, "scope");
            this.f373947b.g(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final boolean h() {
            return this.f373947b.h();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void i() {
            this.f373947b.i();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final hy9.d j() {
            return this.f373947b.j();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final q97.a k() {
            return this.f373947b.k();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Object l(Continuation<? super Map<String, ? extends Object>> r100) {
            return this.f373947b.l(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Object m(Context r100, Bitmap r101, String r102, Continuation<? super File> r103) {
            return this.f373947b.m(r100, r101, r102, r103);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void n() {
            this.f373947b.n();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void o(com.larus.uaigc.creation.f r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f373947b.o(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final ey9.k p() {
            return this.f373947b.p();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final ey9.a q() {
            return this.f373947b.q();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void r(Activity r100) {
            this.f373947b.r(r100);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final Map<String, String> s(UserCreationFromIM r100, String r101) {
            return this.f373947b.s(r100, r101);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final com.larus.uaigc.utils.a t() {
            return this.f373947b.t();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final List<ey9.k> u() {
            return this.f373947b.u();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final boolean v() {
            return this.f373947b.v();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void w(Context r110, n1 r111, JSONObject r112, Integer r113, CoroutineScope r114, CommonDownLoadLayout r115, String r116) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r112, "reportParams");
            Intrinsics.checkNotNullParameter(r114, "mainScope");
            Intrinsics.checkNotNullParameter(r115, "rootView");
            this.f373947b.w(r110, r111, r112, r113, r114, r115, r116);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void x(hy9.f r100, ImageEditDataWithMask r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            Intrinsics.checkNotNullParameter(r101, "imageEditDataWithMask");
            this.f373947b.x(r100, r101);
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final void y() {
            this.f373947b.y();
        }

        @Override // com.larus.uaigc.service.IUgcAIGCService
        public final DialogFragment z(Function3 r100, String r101, String r102, String r103) {
            return this.f373947b.z(r100, r101, r102, r103);
        }

        private Companion() {
            IUgcAIGCService r100 = (IUgcAIGCService) ServiceManager.get().getService(IUgcAIGCService.class);
            if (r100 != null) goto L5;
            r100 = new IUgcAIGCServiceNoop();
        L5:
            this.f373947b = r100;
        }
    }

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void a(Companion r100, UserCreation r101, FragmentActivity r102, View r103) {
            r100.J(r101, r102, r103, null, false);
        }

        public static /* synthetic */ Object b(Companion r100, String r101, String r110, Continuation r111) {
            return r100.D(r101, "Creation", r110, "image", false, null, r111);
        }

        public static /* synthetic */ void d(Companion r110, Context r111, String r112, ShareScene r113, com.larus.bmhome.share.panel.d r114, com.larus.bmhome.share.panel.h r115, UserCreationFromIM r116, UserCreation r210, String r211, int r212) {
            if ((r212 & 4) == 0) goto L5;
            ShareScene r100 = ShareScene.IMAGE_VIEWER_REPORT;
        L7:
            if ((r212 & 8) == 0) goto L9;
            com.larus.bmhome.share.panel.d r101 = null;
        L11:
            if ((r212 & 16) == 0) goto L13;
            com.larus.bmhome.share.panel.h r102 = null;
        L15:
            if ((r212 & 64) == 0) goto L17;
            UserCreationFromIM r103 = null;
        L19:
            if ((r212 & 128) == 0) goto L21;
            UserCreation r117 = null;
        L23:
            if ((r212 & 512) == 0) goto L25;
            String r118 = null;
        L26:
            r110.N(r111, r112, r100, r101, r102, null, r103, r117, null, r118);
            return;
        L25:
            r118 = r211;
            goto L26
        L21:
            r117 = r210;
            goto L23
        L17:
            r103 = r116;
            goto L19
        L13:
            r102 = r115;
            goto L15
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(Companion r110, Context r111, String r112, nr9.g r113, CoroutineScope r114, Function0 r115, boolean r210, UserCreation r211, Function4 r212, Function0 r213, int r214) {
            if ((r214 & 2) == 0) goto L5;
            String r100 = UUID.randomUUID().toString();
        L7:
            if ((r214 & 16) == 0) goto L9;
            Function0 r101 = null;
        L11:
            if ((r214 & 128) == 0) goto L13;
            UserCreation r116 = null;
        L15:
            if ((r214 & 512) == 0) goto L17;
            Function0 r117 = null;
        L18:
            r110.g(r111, r100, r113, r114, r101, r210, null, r116, r212, r117, null);
            return;
        L17:
            r117 = r213;
            goto L18
        L13:
            r116 = r211;
            goto L15
        L9:
            r101 = r115;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    static {
        f373945a = Companion.f373946c;
    }

    void A(ActivityResultLauncher<Intent> r100, ny9.c r101);

    Map<String, String> B(UserCreation r100, String r101);

    Object C(Continuation<? super String> r100);

    Object D(String r100, String r101, String r102, String r103, boolean r104, String r105, Continuation<? super String> r106);

    xy9.b E();

    void F();

    com.larus.uaigc.api.a G();

    Map<String, String> H(UserCreation r100, String r101);

    UserCreationFromIM I(Message r100, String r101, String r102);

    void J(UserCreation r100, FragmentActivity r101, View r102, Activity r103, boolean r104);

    List<ey9.k> K();

    Map<String, String> L(UserCreationFromIM r100, String r101);

    Component M();

    void N(Context r100, String r101, ShareScene r102, com.larus.bmhome.share.panel.d r103, com.larus.bmhome.share.panel.h r104, by7.e r105, UserCreationFromIM r106, UserCreation r107, Integer r108, String r110);

    void O();

    void P();

    List<ey9.k> Q();

    DialogFragment R(dy9.a r100);

    boolean S();

    void T(String r100);

    void U(String r100, Uri r101, ic8.n0 r102, long r103);

    kh8.a V(LifecycleCoroutineScope r100);

    void W(ny9.b r100);

    boolean X(Bundle r100, String r101, String r102);

    boolean Y(Bundle r100);

    void Z(CreationDoSameNotifyInfo r100, FragmentActivity r101, FragmentActivity r102, String r103, Function0 r104);

    q97.a a();

    void b(Activity r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102);

    void c(String r100);

    q97.a d();

    Object e(Context r100, Bitmap r101, String r102, Continuation<? super File> r103);

    void f();

    void g(Context r100, String r101, nr9.g r102, CoroutineScope r103, Function0<Unit> r104, boolean r105, UserCreationFromIM r106, UserCreation r107, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r108, Function0<Unit> r110, Function1<? super Continuation<? super String>, ? extends Object> r111);

    boolean h();

    void i();

    hy9.d j();

    q97.a k();

    Object l(Continuation<? super Map<String, ? extends Object>> r100);

    Object m(Context r100, Bitmap r101, String r102, Continuation<? super File> r103);

    void n();

    void o(com.larus.uaigc.creation.f r100);

    ey9.k p();

    ey9.a q();

    void r(Activity r100);

    Map<String, String> s(UserCreationFromIM r100, String r101);

    com.larus.uaigc.utils.a t();

    List<ey9.k> u();

    boolean v();

    void w(Context r100, n1 r101, JSONObject r102, Integer r103, CoroutineScope r104, CommonDownLoadLayout r105, String r106);

    void x(hy9.f r100, ImageEditDataWithMask r101);

    void y();

    DialogFragment z(Function3 r100, String r101, String r102, String r103);
}
