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
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.ShareScene;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.uaigc.applet.IMusicAppletHostService;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.chat.CreationVideoManagerViewModel;
import com.larus.uaigc.helper.EnterpriseFileDownloadHelper;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¨\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0096@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J>\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0016J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J2\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J<\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010!\u001a\u0004\u0018\u00010\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#H\u0016J\b\u0010$\u001a\u00020\nH\u0016JK\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\nH\u0016J\u0010\u00106\u001a\u00020\n2\u0006\u00107\u001a\u000208H\u0016J\u001e\u00109\u001a\u00020\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;2\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010=\u001a\u00020\n2\u0006\u00107\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016J6\u0010A\u001a\u00020\n2\u0006\u00107\u001a\u00020>2\u0006\u0010B\u001a\u00020-2\u0006\u0010C\u001a\u00020\u001d2\u0014\u0010D\u001a\u0010\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\n\u0018\u00010EH\u0016J\u0018\u0010G\u001a\u00020\n2\u0006\u00107\u001a\u00020>2\u0006\u0010B\u001a\u00020-H\u0016J\b\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020<2\u0006\u00107\u001a\u00020KH\u0016J*\u0010L\u001a\u0004\u0018\u00010M2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010QJ*\u0010R\u001a\u0004\u0018\u00010M2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010QJ\b\u0010S\u001a\u00020TH\u0016J(\u0010U\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020X0W2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J \u0010[\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020]H\u0016J\u0010\u0010_\u001a\u00020M2\u0006\u0010`\u001a\u00020\u0006H\u0016J\b\u0010a\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020/H\u0016J.\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020/2\u0014\u0010k\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020n\u0018\u00010m0lH\u0016J\n\u0010o\u001a\u0004\u0018\u00010pH\u0016J\u0010\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020tH\u0016J\n\u0010u\u001a\u0004\u0018\u00010\rH\u0016J\u001e\u0010v\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020w2\u0006\u0010x\u001a\u00020<H\u0096@¢\u0006\u0002\u0010yJ\u0010\u0010z\u001a\u00020\n2\u0006\u0010{\u001a\u00020|H\u0016J[\u0010}\u001a\u00020r2%\u0010~\u001a!\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0004\u0012\u00020\n\u0018\u00010\u007f2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u007f\u0010\u0085\u0001\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010-2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0003\u0010\u0094\u0001J\t\u0010\u0095\u0001\u001a\u00020\nH\u0016Jd\u0010\u0096\u0001\u001a\u00020\n2\b\u0010\u0097\u0001\u001a\u00030\u0098\u00012\u0007\u0010\u0099\u0001\u001a\u00020\u00062\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0014\u0010\u009c\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u009d\u00012&\u0010\u009e\u0001\u001a!\u0012\u0007\u0012\u0005\u0018\u00010\u009b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\n0\u007fH\u0016JÆ\u0001\u0010\u009f\u0001\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'2\u0007\u0010 \u0001\u001a\u00020\u00062\n\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00012\u0006\u0010j\u001a\u00020/2\u000f\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010#2\u0007\u0010¤\u0001\u001a\u00020\u001d2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00172*\u0010¥\u0001\u001a%\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020|\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\n\u0018\u00010¦\u00012\u000f\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010#2 \u0010¨\u0001\u001a\u001b\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00060©\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010EH\u0016¢\u0006\u0003\u0010ª\u0001J.\u0010«\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J-\u0010«\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u00ad\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u00012\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J-\u0010\u00ad\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010®\u0001\u001a\u0005\u0018\u00010\u0090\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u00012\t\u0010±\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010²\u0001\u001a\u0004\u0018\u00010\u0006H\u0016JH\u0010³\u0001\u001a\u00020\u00062\u0007\u0010´\u0001\u001a\u00020\u00062\u0007\u0010µ\u0001\u001a\u00020\u00062\u0007\u0010¶\u0001\u001a\u00020\u00062\u0007\u0010·\u0001\u001a\u00020\u00062\u0007\u0010¸\u0001\u001a\u00020\u001d2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0003\u0010º\u0001J \u0010»\u0001\u001a\u00020\u001d2\u0015\u0010¼\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J-\u0010½\u0001\u001a\u00030¾\u00012\r\u0010¿\u0001\u001a\b0À\u0001j\u0003`Á\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u00012\u0006\u0010!\u001a\u00020\u0006H\u0016J/\u0010Ä\u0001\u001a\u00030¾\u00012\r\u0010¿\u0001\u001a\b0À\u0001j\u0003`Á\u00012\t\u0010Å\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0011\u0010Ç\u0001\u001a\n\u0012\u0005\u0012\u00030É\u00010È\u0001H\u0016J%\u0010Ê\u0001\u001a\u00030¾\u00012\r\u0010¿\u0001\u001a\b0À\u0001j\u0003`Á\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016JW\u0010Ë\u0001\u001a\u00030Ì\u00012\n\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u00012?\u0010Ï\u0001\u001a:\u0012\u0017\u0012\u00150Ñ\u0001¢\u0006\u000f\bÒ\u0001\u0012\n\bÓ\u0001\u0012\u0005\b\b(Ô\u0001\u0012\u0016\u0012\u00140\u0006¢\u0006\u000f\bÒ\u0001\u0012\n\bÓ\u0001\u0012\u0005\b\b(Õ\u0001\u0012\u0004\u0012\u00020\n0Ð\u0001H\u0016J\u0013\u0010Ö\u0001\u001a\u00020\u001d2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0016J%\u0010Ù\u0001\u001a\u00020\u001d2\b\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010Ú\u0001\u001a\u00020\u00062\u0007\u0010Û\u0001\u001a\u00020\u0006H\u0016J(\u0010Ü\u0001\u001a\u00020\u001d2\b\u0010×\u0001\u001a\u00030Ø\u00012\b\u0010Ú\u0001\u001a\u00030Ý\u00012\t\b\u0002\u0010Û\u0001\u001a\u00020\u0006H\u0002J\t\u0010Þ\u0001\u001a\u00020\u001dH\u0016J\t\u0010ß\u0001\u001a\u00020\u001dH\u0016J\t\u0010à\u0001\u001a\u00020\u001dH\u0016J\t\u0010á\u0001\u001a\u00020\nH\u0016J\u0013\u0010â\u0001\u001a\f\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010È\u0001H\u0016J\u0013\u0010ä\u0001\u001a\f\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010È\u0001H\u0016J\u0013\u0010å\u0001\u001a\f\u0012\u0005\u0012\u00030ã\u0001\u0018\u00010È\u0001H\u0016J\f\u0010æ\u0001\u001a\u0005\u0018\u00010ã\u0001H\u0016J\f\u0010ç\u0001\u001a\u0005\u0018\u00010è\u0001H\u0016J\u0014\u0010é\u0001\u001a\u00020\n2\t\u0010ê\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010ë\u0001\u001a\u00020\n2\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010í\u0001\u001a\u00020\u001dH\u0016J\f\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0016J\u0011\u0010ð\u0001\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0002\u0010\bJ\t\u0010ñ\u0001\u001a\u00020\nH\u0016J\t\u0010ò\u0001\u001a\u00020\nH\u0016J\u0014\u0010ó\u0001\u001a\u00020\u001d2\t\u0010ô\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0013\u0010õ\u0001\u001a\u00020\n2\b\u0010\u009a\u0001\u001a\u00030ö\u0001H\u0016J\f\u0010÷\u0001\u001a\u0005\u0018\u00010ø\u0001H\u0016Jw\u0010ù\u0001\u001a\u00020\u001d2\u0007\u0010ú\u0001\u001a\u00020\u001a2\n\u0010û\u0001\u001a\u0005\u0018\u00010Ì\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u00012\t\u0010±\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ü\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010ý\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010þ\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010ÿ\u0001\u001a\u00020\u00062\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0016J\f\u0010\u0080\u0002\u001a\u0005\u0018\u00010\u0081\u0002H\u0016J0\u0010\u0082\u0002\u001a\u00020\n2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0083\u0002\u001a\u00020]2\b\u0010\u0084\u0002\u001a\u00030\u0085\u00022\u0007\u0010\u0086\u0002\u001a\u00020|H\u0016J\u0012\u0010\u0087\u0002\u001a\u00030\u0088\u00022\u0006\u0010e\u001a\u00020/H\u0016¨\u0006\u0089\u0002"}, d2 = {"Lcom/larus/uaigc/service/UgcAIGCServiceImpl;", "Lcom/larus/uaigc/service/IUgcAIGCService;", "<init>", "()V", "getCacheOrFetchSpringPocketData", "", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preFetchSpringPocketData", "", "startObservePollingConfig", "getSpringMainVenueRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "getWorldCupMainRouterInterceptor", "onApplyPocket", "ownerActivity", "Landroid/app/Activity;", "data", "extra", "onPopNativePage", "pushCreationNotify", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "activity", "shareContainer", "Landroid/view/View;", "targetActivity", "skipChannel", "", "pushCreationDoSameNotify", "notifyInfo", "Lcom/larus/uaigc/service/CreationDoSameNotifyInfo;", "enterMethod", "clickCallBack", "Lkotlin/Function0;", "dismissCreationNotify", "downloadCreation", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageUrl", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "reportParams", "Lorg/json/JSONObject;", "creationType", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "rootView", "creationId", "(Landroid/content/Context;Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;Lorg/json/JSONObject;Ljava/lang/Integer;Lkotlinx/coroutines/CoroutineScope;Landroid/view/View;Ljava/lang/String;)V", "reportHelper", "Lcom/larus/uaigc/bean/IUgcReportHelper;", "clearAvatarWhiteTUrl", "openCreatePage", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "openCreatePageForResult", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "sendImageRemoveMessage", "Lcom/larus/uaigc/bean/ImageEditSendMessageStrategyConfig;", "imageEditDataWithMask", "Lcom/larus/uaigc/bean/remove/ImageEditDataWithMask;", "sendImageAndTextMessage", "instructionType", "needPreprocessImage", "uploadSuccessCallback", "Lkotlin/Function1;", "Lcom/larus/uaigc/bean/UploadSuccessData;", "sendRemoteImageAndTextMessage", "getAspectRatioSelectStrategy", "Lcom/larus/uaigc/bean/IAspectRatioSelectStrategy;", "getCreationIntent", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "saveBitmapToCleanableDir", "Ljava/io/File;", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "fileName", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBitMapToFile", "createImageRemoveDialogFragment", "Lcom/larus/uaigc/bean/remove/IImageRemoveDialogFragment;", "openBigImagesFragment", "properties", "Lcom/larus/uaigc/bean/chat/ImageDetailFragmentProp;", "Lcom/larus/bmhome/creation/bean/ICreationContentData;", "galleryContext", "Lcom/larus/uaigc/bean/chat/gallery/CreationGalleryContext;", "copyUri", "sourceUri", "Landroid/net/Uri;", "destinationUri", "buildSendImgCacheFile", "formatSuffix", "creationPagePerfMonitorHelper", "Lcom/larus/uaigc/bean/createpage/trace/ICreationPagePerfMonitorHelper;", "createCreationQueuingTaskViewModel", "Lcom/larus/bmhome/chat/component/loading/ICreationQueuingTaskViewModel;", "viewModelScope", "createImageLoadingProgressComponent", "Lcom/larus/uaigc/bean/chat/loading/ILoadingProgress;", "sketchProgressLoadingViewStub", "Landroid/view/ViewStub;", "scope", "loadingProgressState", "Lkotlin/Lazy;", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/bmhome/creative/loading/MessageLoadingUIState;", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "createDigitalAvatarTemplateListDialogFragment", "Landroidx/fragment/app/DialogFragment;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/uaigc/avatar/DigitalAvatarTemplateModel;", "createDigitalAvatarRouteInterceptor", "tryDirectlyJumpImageTemplate", "Landroidx/appcompat/app/AppCompatActivity;", "intent", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportTemplateRecommendOpCounter", "templatePrimaryKey", "", "createImageTemplateListDialogFragment", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "botId", "chatType", "recommendFrom", "cvsId", "showShareImagePanel", "imgUrl", "shareScene", "Lcom/larus/bmhome/share/ShareScene;", "callback", "Lcom/larus/bmhome/share/panel/ISharePanelClickListener;", "eventParam", "Lcom/larus/bmhome/share/panel/SharePanelEventParam;", "node", "Lcom/ixigua/lib/track/ITrackNode;", "userCreationFromIM", "Lcom/larus/platform/api/creation/UserCreationFromIM;", "userCreation", "taskType", "imageKey", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/bmhome/share/ShareScene;Lcom/larus/bmhome/share/panel/ISharePanelClickListener;Lcom/larus/bmhome/share/panel/SharePanelEventParam;Lcom/ixigua/lib/track/ITrackNode;Lcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Ljava/lang/Integer;Ljava/lang/String;)V", "clearCreationActionbarDependencyCache", "uploadBeforeSendNestedFiles", "dependency", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputDependency;", "originContent", "params", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "ext", "", "originalLogic", "saveAigcVideoAndLoading", "downloadTaskKey", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "traceBlk", "enableUseSRDownLoad", "finishCallback", "Lkotlin/Function4;", "saveCreationTaskIdBlk", "onInterceptUrl", "Lkotlin/coroutines/Continuation;", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;ZLcom/larus/platform/api/creation/UserCreationFromIM;Lcom/larus/platform/api/creation/UserCreation;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getVideoMetaData", DBDefinition.TASK_ID, "getImageMetadata", "getUserCreationFromIM", "message", "Lcom/larus/im/bean/message/Message;", "creationTaskId", "position", "resolveFileFinalDownloadUrlIfNeeded", "url", "scene", "subScene", "contentType", "isAIGC", "resourceKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkVideoMetaDataValid", "metaData", "createDigitalAvatarInstructionBizAdapter", "Lcom/larus/bmhome/instruction/biz/AbsInstructionBizAdapter;", "component", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "instructionDependency", "Lcom/larus/bmhome/instruction/biz/IInstructionDependency;", "createAiCreationInstructionBizAdapter", "previousPage", "currentPage", "getLyricsToSongCellInfoList", "", "Lcom/larus/bmhome/chat/cell/CellManager$CellInfo;", "createMusicInstructionBizAdapter", "createMusicTemplateListFragment", "Landroidx/fragment/app/Fragment;", "templateViewModel", "Lcom/larus/uaigc/bean/chat/template/TemplateViewModel;", "templateChooseCallback", "Lkotlin/Function2;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "Lkotlin/ParameterName;", "name", "templateInfo", "enterFrom", "openMusicTemplateApplet", "arguments", "Landroid/os/Bundle;", "openMusicDetailApplet", "page", "routeMode", "openMusicApplet", "Lcom/larus/bmhome/music/applet/MusicAppletPage;", "hasCreatedAvatar", "isAvatarInCreating", "isAvatarCreated", "initFetch", "getDigitalAvatarPreGenImagesOfScan", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "getDigitalAvatarPreGenImagesOfUpload", "getDigitalAvatarPreGenImages", "getDigitalAvatarMasterPreGenImage", "getDigitalAvatarRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "updateDigitalAvatarIpaMainTempUrl", "tempUrl", "updateDigitalAvatarIpaMainTempUri", "tempUri", "needCompleteVideoAvatar", "getAiReplicaInfo", "Lcom/larus/uaigc/api/AiReplicaInfoData;", "fetchAiReplicaIpaMainUrl", "avatarCleared", "avatarCreated", "isNestedFileProcessing", LocationMonitorConst.IDENTIFIER, "galleryShareVideo", "Lcom/larus/uaigc/creation/VideoSharePanelParams;", "createSpringMultiAttachmentSelectorComponent", "Lcom/larus/ui/arch/component/external/api/Component;", "citeOrQuestionAttachmentToInput", "anchorView", WidgetService.PARAM_FRAGMENT, "vid", "coverUrl", "downloadUrl", "fromScene", "getCreationImageUploadPolicy", "Lcom/larus/uaigc/utils/ICreationImageUploadPolicy;", "mobDuplicateStatAsync", "uri", "processFileResult", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "processTime", "createCreationVideoManager", "Lcom/larus/bmhome/chat/markdown/creation/video/helper/ICreationVideoManager;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcAIGCServiceImpl implements IUgcAIGCService {
    public UgcAIGCServiceImpl() {
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final xy9.b E() {
        return ICreationWorkflowService.f373940a.E();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void F() {
        ICreationAvatarService.f373907a.F();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final com.larus.uaigc.api.a G() {
        return ICreationAvatarService.f373907a.G();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final List<ey9.k> K() {
        return ICreationAvatarService.f373907a.K();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Component M() {
        return ICreationAttachmentService.f373904a.M();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void O() {
        ICreationAvatarService.f373907a.O();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void P() {
        ICreationAvatarService.f373907a.P();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final List<ey9.k> Q() {
        return ICreationAvatarService.f373907a.Q();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final boolean S() {
        return ICreationAvatarService.f373907a.S();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final q97.a a() {
        return ICreationAvatarService.f373907a.a();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final q97.a d() {
        return ICreationSpringVenueService.f373934a.d();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void f() {
        ICreationSpringVenueService.f373934a.f();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final boolean h() {
        return ICreationAvatarService.f373907a.h();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void i() {
        ICreationAvatarService.f373907a.i();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final hy9.d j() {
        return ICreationReportService.f373922a.j();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final q97.a k() {
        return ICreationSpringVenueService.f373934a.k();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void n() {
        ICreationSpringVenueService.f373934a.n();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final ey9.k p() {
        return ICreationAvatarService.f373907a.p();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final ey9.a q() {
        return ICreationAvatarService.f373907a.q();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final com.larus.uaigc.utils.a t() {
        return ICreationUploadPolicyService.f373937a.t();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final List<ey9.k> u() {
        return ICreationAvatarService.f373907a.u();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final boolean v() {
        return ICreationAvatarService.f373907a.v();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void y() {
        ICreationNotifyService.f373919a.y();
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Object C(Continuation<? super String> r100) {
        return ICreationAvatarService.f373907a.C(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final DialogFragment R(dy9.a r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return ICreationAvatarService.f373907a.R(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void T(String r100) {
        ICreationAvatarService.f373907a.T(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final kh8.a V(LifecycleCoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModelScope");
        return new CreationVideoManagerViewModel(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void W(ny9.b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        ICreationWorkflowService.f373940a.f0(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final boolean Y(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "arguments");
        return a0(r100, MusicAppletPage.TEMPLATE_LIST, MusicAppletPage.ROUTE_MODE_RELAUNCH);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void c(String r100) {
        ICreationAvatarService.f373907a.c(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Object l(Continuation<? super Map<String, ? extends Object>> r100) {
        return ICreationSpringVenueService.f373934a.l(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void o(com.larus.uaigc.creation.f r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        ICreationShareService.f373931a.o(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void r(Activity r100) {
        ICreationSpringVenueService.f373934a.r(r100);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void A(ActivityResultLauncher<Intent> r100, ny9.c r101) {
        Intrinsics.checkNotNullParameter(r100, "activityResultLauncher");
        Intrinsics.checkNotNullParameter(r101, "config");
        ICreationWorkflowService.f373940a.A(r100, r101);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Map<String, String> B(UserCreation r100, String r101) {
        return ICreationMetadataService.f373916a.B(r100, r101);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Map<String, String> H(UserCreation r100, String r101) {
        return ICreationMetadataService.f373916a.H(r100, r101);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Map<String, String> L(UserCreationFromIM r100, String r101) {
        return ICreationMetadataService.f373916a.L(r100, r101);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Map<String, String> s(UserCreationFromIM r100, String r101) {
        return ICreationMetadataService.f373916a.s(r100, r101);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void x(hy9.f r100, ImageEditDataWithMask r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "imageEditDataWithMask");
        ICreationWorkflowService.f373940a.x(r100, r101);
    }

    public static boolean a0(Bundle r100, MusicAppletPage r101, String r102) {
        if (z2.f365865a.V3() == true) goto L7;
        FLogger.f375446a.i("UgcAIGCServiceImpl", "open music applet ignored by experiment, page=" + r101.getValue());
        return false;
    L7:
        return IMusicAppletHostService.f370279a.d(r100, r101.getValue(), r102);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final UserCreationFromIM I(Message r100, String r101, String r102) {
        return ICreationMetadataService.f373916a.I(r100, r101, r102);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final boolean X(Bundle r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "arguments");
        Intrinsics.checkNotNullParameter(r101, "page");
        Intrinsics.checkNotNullParameter(r102, "routeMode");
        Iterator<MusicAppletPage> r103 = MusicAppletPage.getEntries().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        MusicAppletPage r104 = r103.next();
        if (Intrinsics.areEqual(r104.getValue(), r101) == false) goto L4;
    L9:
        MusicAppletPage r105 = r104;
        if (r105 != null) goto L13;
        r105 = MusicAppletPage.TEMPLATE_LIST;
    L13:
        return a0(r100, r105, r102);
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void b(Activity r100, Map<String, ? extends Object> r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "extra");
        ICreationSpringVenueService.f373934a.b(r100, r101, r102);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void U(String r100, Uri r101, ic8.n0 r110, long r111) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r110, "processFileResult");
        ICreationUploadPolicyService.f373937a.U(r100, r101, r110, r111);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Object e(Context r100, Bitmap r101, String r102, Continuation<? super File> r103) {
        return ICreationWorkflowService.f373940a.e(r100, r101, r102, r103);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Object m(Context r100, Bitmap r101, String r102, Continuation<? super File> r103) {
        return ICreationWorkflowService.f373940a.m(r100, r101, r102, r103);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final DialogFragment z(Function3 r100, String r101, String r102, String r103) {
        return ICreationInstructionService.f373913a.z(r100, r101, r102, r103);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void J(UserCreation r100, FragmentActivity r101, View r110, Activity r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "creation");
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r110, "shareContainer");
        ICreationNotifyService.f373919a.J(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void Z(CreationDoSameNotifyInfo r100, FragmentActivity r101, FragmentActivity r110, String r111, Function0 r112) {
        Intrinsics.checkNotNullParameter(r101, "activity");
        Intrinsics.checkNotNullParameter(r112, "clickCallBack");
        ICreationNotifyService.f373919a.K(r100, r101, r110, r111, r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v15 */
    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final Object D(String r110, String r111, String r112, String r113, boolean r210, String r211, Continuation<? super String> r212) {
        String r100 = r113;
        if ((r212 instanceof UgcAIGCServiceImpl$resolveFileFinalDownloadUrlIfNeeded$1) == false) goto L7;
        UgcAIGCServiceImpl$resolveFileFinalDownloadUrlIfNeeded$1 r101 = (UgcAIGCServiceImpl$resolveFileFinalDownloadUrlIfNeeded$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L70:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r107 = (Ref.ObjectRef) r101.L$5;
        String r108 = (String) r101.L$4;
        String r109 = (String) r101.L$3;
        String r114 = (String) r101.L$2;
        String r115 = (String) r101.L$1;
        String r116 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L18
        Ref.ObjectRef r117 = r107;
        r100 = r109;
        String r118 = r114;
        String r119 = r116;
    L77:
        CreationNoWatermarkManager r120 = CreationNoWatermarkManager.f373832a;     // Catch: Throwable -> L41
        n1 r121 = new n1(r119);     // Catch: Throwable -> L41
        r120.getClass();     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r121, "original");     // Catch: Throwable -> L41
        Intrinsics.checkNotNullParameter(r121, "original");     // Catch: Throwable -> L41
        Object r122 = Result.m9449constructorimpl(r120.V(r108, r121, true).f373863a.f296032c);     // Catch: Throwable -> L41
    L51:
        if (Result.m9455isFailureimpl(r122) == false) goto L53;
        r122 = null;
    L53:
        T r123 = (String) r122;
        if (r123 != 0) goto L56;
    L64:
        EnterpriseFileDownloadHelper r124 = EnterpriseFileDownloadHelper.f372995a;
        String r125 = (String) r117.element;
        r124.getClass();
        String r126 = EnterpriseFileDownloadHelper.a(r125);
        String r127 = com.larus.utils.b0.d();
        if (Intrinsics.areEqual(r127, "zh") == false) goto L67;
        r127 = "zh-cn";
    L67:
        com.larus.uaigc.helper.e0 r128 = new com.larus.uaigc.helper.e0(r125, r118, r126, r127, r115, r100);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.L$3 = null;
        r101.L$4 = null;
        r101.L$5 = null;
        r101.label = 2;
        r103 = r124.d(r128, r101);
        if (r103 != r104) goto L70;
        return r104;
    L56:
        if (r123.length() <= 0) goto L58;
        r106 = true;
    L58:
        if (r106 == true) goto L61;
        r123 = 0;
    L61:
        if (r123 == 0) goto L64;
        r117.element = r123;
    L41:
        th = th;
    L42:
        String r129 = r115;
    L49:
        Result.Companion r130 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r115 = r129;
    L18:
        th = th;
        r117 = r107;
        r100 = r109;
        r118 = r114;
        goto L42
    L20:
        ResultKt.throwOnFailure(r103);
        r117 = new Ref.ObjectRef();
        r117.element = r110;
        if (r210 == false) goto L63;
        if (r211 != null) goto L24;
    L27:
        boolean r131 = true;
    L28:
        if (r131 == true) goto L63;
        if (Intrinsics.areEqual(r100, "image") == false) goto L63;
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L47
        CreationNoWatermarkManager r133 = CreationNoWatermarkManager.f373832a;     // Catch: Throwable -> L47
        r101.L$0 = r110;     // Catch: Throwable -> L47
        r129 = r111;
        r101.L$1 = r129;     // Catch: Throwable -> L45
        r118 = r112;
        r101.L$2 = r118;     // Catch: Throwable -> L43
        r101.L$3 = r100;     // Catch: Throwable -> L43
        r101.L$4 = r211;     // Catch: Throwable -> L43
        r101.L$5 = r117;     // Catch: Throwable -> L43
        r101.label = 1;     // Catch: Throwable -> L43
        if (r133.r(r211, "download_save", r101) != r104) goto L38;
        return r104;
    L38:
        r115 = r129;
        r119 = r110;
        r108 = r211;
    L43:
        th = th;
    L45:
        th = th;
    L46:
        r118 = r112;
    L47:
        th = th;
        r129 = r111;
        goto L46
    L24:
        if (r211.length() == 0) goto L27;
        r131 = false;
    L63:
        r118 = r112;
        r115 = r111;
    L7:
        r101 = new UgcAIGCServiceImpl$resolveFileFinalDownloadUrlIfNeeded$1(this, r212);
        goto L8
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void w(Context r110, n1 r111, JSONObject r112, Integer r113, CoroutineScope r114, CommonDownLoadLayout r115, String r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "reportParams");
        Intrinsics.checkNotNullParameter(r114, "mainScope");
        Intrinsics.checkNotNullParameter(r115, "rootView");
        ICreationSaveService.f373928a.w(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void N(Context r110, String r111, ShareScene r112, com.larus.bmhome.share.panel.d r113, com.larus.bmhome.share.panel.h r114, by7.e r115, UserCreationFromIM r116, UserCreation r210, Integer r211, String r212) {
        Intrinsics.checkNotNullParameter(r112, "shareScene");
        ICreationShareService.f373931a.N(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    @Override // com.larus.uaigc.service.IUgcAIGCService
    public final void g(Context r110, String r111, nr9.g r112, CoroutineScope r113, Function0<Unit> r114, boolean r115, UserCreationFromIM r210, UserCreation r211, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r212, Function0<Unit> r213, Function1<? super Continuation<? super String>, ? extends Object> r214) {
        Intrinsics.checkNotNullParameter(r111, "downloadTaskKey");
        Intrinsics.checkNotNullParameter(r113, "scope");
        ICreationSaveService.f373928a.g(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }
}
