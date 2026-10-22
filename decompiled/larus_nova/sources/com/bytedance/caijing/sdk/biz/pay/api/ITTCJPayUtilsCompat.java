package com.bytedance.caijing.sdk.biz.pay.api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.adapter.ICJExternalEventCenterAdapter;
import com.android.ttcjpaysdk.base.adapter.ICJExternalLynxServiceAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayNetworkErrorAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayToastAdapter;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import com.android.ttcjpaysdk.ttcjpayapi.IBasicMode;
import com.android.ttcjpaysdk.ttcjpayapi.IBlockDialog;
import com.android.ttcjpaysdk.ttcjpayapi.ICJHostLoginService;
import com.android.ttcjpaysdk.ttcjpayapi.ICJHostPrivacyService;
import com.android.ttcjpaysdk.ttcjpayapi.ICJPayXBridgeCallback;
import com.android.ttcjpaysdk.ttcjpayapi.ICustomActionListener;
import com.android.ttcjpaysdk.ttcjpayapi.ICustomerServiceCallback;
import com.android.ttcjpaysdk.ttcjpayapi.IH5NotificationCallback;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.ITTCJPayPhoneCarrierService;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayAlipayAuthCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayEvent;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayHostJSBMethodsInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayMonitor;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayObserver;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeWithContextInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNameAuthCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNamePasswordCallback;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.heytap.mcssdk.constant.b;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import faceverify.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ê\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J \u0010\u0017\u001a\u00020\u00042\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0015H&J\u001e\u0010\u001a\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018H&J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J8\u0010%\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\tH&J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0012H&J \u0010)\u001a\u00020\u00042\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0018H&J\b\u0010*\u001a\u00020\u0004H'J\b\u0010+\u001a\u00020\u0004H&J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\tH&J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0012H&J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0012H&J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0012H&J\u0012\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u00010\tH&J\u0012\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010\tH&J\u0012\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u000108H&J\u001e\u0010=\u001a\u00020\u0004\"\u0004\b\u0000\u0010;2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010<H&J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>H&J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0012H&J\u0012\u0010E\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010CH&J\u0012\u0010G\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010FH&J\u0012\u0010I\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010HH&J\u0012\u0010K\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010N\u001a\u00020\u00042\u0006\u0010M\u001a\u00020LH&J\u0010\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020OH&J\u0010\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020RH&J\u0010\u0010V\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0012H&J\u0012\u0010Y\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010WH&J\u0012\u0010[\u001a\u00020\u00042\b\u0010Z\u001a\u0004\u0018\u00010\tH&J:\u0010`\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\\\u001a\u0004\u0018\u00010\t2\b\u0010]\u001a\u0004\u0018\u00010\t2\b\u0010^\u001a\u0004\u0018\u00010\t2\b\u0010_\u001a\u0004\u0018\u00010\tH&JB\u0010h\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010\t2\u0006\u0010b\u001a\u00020\"2\b\u0010c\u001a\u0004\u0018\u00010\t2\b\u0010d\u001a\u0004\u0018\u00010\t2\b\u0010e\u001a\u0004\u0018\u00010\t2\b\u0010g\u001a\u0004\u0018\u00010fH&JL\u0010h\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010\t2\u0006\u0010b\u001a\u00020\"2\b\u0010c\u001a\u0004\u0018\u00010\t2\b\u0010d\u001a\u0004\u0018\u00010\t2\b\u0010e\u001a\u0004\u0018\u00010\t2\b\u0010i\u001a\u0004\u0018\u00010\t2\b\u0010g\u001a\u0004\u0018\u00010fH&J]\u0010h\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010\t2\u0006\u0010b\u001a\u00020\"2\b\u0010c\u001a\u0004\u0018\u00010\t2\b\u0010d\u001a\u0004\u0018\u00010\t2\b\u0010e\u001a\u0004\u0018\u00010\t2\b\u0010i\u001a\u0004\u0018\u00010\t2\b\u0010j\u001a\u0004\u0018\u00010\u00122\b\u0010g\u001a\u0004\u0018\u00010fH&¢\u0006\u0004\bh\u0010kJ(\u0010q\u001a\u00020\u00042\u0006\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\u00122\u0006\u0010g\u001a\u00020pH&J\b\u0010r\u001a\u00020\u0004H&J\b\u0010s\u001a\u00020\u0004H&JB\u0010t\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010\t2\u0006\u0010b\u001a\u00020\"2\b\u0010c\u001a\u0004\u0018\u00010\t2\b\u0010d\u001a\u0004\u0018\u00010\t2\b\u0010e\u001a\u0004\u0018\u00010\t2\b\u0010g\u001a\u0004\u0018\u00010fH&J\b\u0010u\u001a\u00020\tH&J\u0010\u0010w\u001a\u00020\u00042\u0006\u0010v\u001a\u00020\tH&J \u0010z\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010x\u001a\u00020\t2\u0006\u0010y\u001a\u00020\u001fH&J\u0012\u0010|\u001a\u00020\u00042\b\u0010{\u001a\u0004\u0018\u00010\tH&J\u0012\u0010~\u001a\u00020\u00042\b\u0010}\u001a\u0004\u0018\u00010\tH&J\b\u0010\u007f\u001a\u00020\tH&J\t\u0010\u0080\u0001\u001a\u00020\tH&J\u0012\u0010\u0082\u0001\u001a\u00020\u00042\u0007\u0010\u0081\u0001\u001a\u00020\"H&J\u0014\u0010\u0084\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u0012H&J\u0012\u0010\u0086\u0001\u001a\u00020\u00042\u0007\u0010\u0085\u0001\u001a\u00020\u0012H&J\u0014\u0010\u0088\u0001\u001a\u00020\u00042\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001fH&J4\u0010\u008c\u0001\u001a\u00020\u00042)\u0010\u008b\u0001\u001a$\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0089\u0001j\u0011\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u008a\u0001H&J\u0012\u0010\u008e\u0001\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020\"H&J\t\u0010\u008f\u0001\u001a\u00020\u0004H&J\u0014\u0010\u0091\u0001\u001a\u00020\u00042\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u0093\u0001\u001a\u00020\u00042\u0007\u0010\u0092\u0001\u001a\u00020\u0012H&J\u0012\u0010\u0095\u0001\u001a\u00020\u00042\u0007\u0010\u0094\u0001\u001a\u00020\u0012H&J\u0013\u0010\u0098\u0001\u001a\u00020\u00042\b\u0010\u0097\u0001\u001a\u00030\u0096\u0001H&J\u0014\u0010\u009a\u0001\u001a\u00020\u00042\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\tH&J\u0015\u0010\u009d\u0001\u001a\u00020\u00042\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001H&J\u0015\u0010 \u0001\u001a\u00020\u00042\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u0001H&J\u0015\u0010£\u0001\u001a\u00020\u00042\n\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u0001H'J\u0013\u0010¦\u0001\u001a\u00020\u00042\b\u0010¥\u0001\u001a\u00030¤\u0001H&J\u0012\u0010¨\u0001\u001a\u00020\u00042\u0007\u0010g\u001a\u00030§\u0001H&J\u0015\u0010«\u0001\u001a\u00020\u00042\n\u0010ª\u0001\u001a\u0005\u0018\u00010©\u0001H&J\u0014\u0010\u00ad\u0001\u001a\u00020\u00042\t\u00109\u001a\u0005\u0018\u00010¬\u0001H&J\u0013\u0010°\u0001\u001a\u00020\u00042\b\u0010¯\u0001\u001a\u00030®\u0001H&J\u0012\u0010²\u0001\u001a\u00020\u00042\u0007\u0010b\u001a\u00030±\u0001H&J\t\u0010³\u0001\u001a\u00020\u0004H&J\t\u0010´\u0001\u001a\u00020\u0004H&J\t\u0010µ\u0001\u001a\u00020\u0004H&J\t\u0010¶\u0001\u001a\u00020\u0004H&J\t\u0010·\u0001\u001a\u00020\u0004H&J+\u0010º\u0001\u001a\u00020\u00042\u0007\u0010¸\u0001\u001a\u00020\"2\u0007\u0010¹\u0001\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&J?\u0010Á\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\t2\u0007\u0010¼\u0001\u001a\u00020\t2\n\u0010¾\u0001\u001a\u0005\u0018\u00010½\u00012\n\u0010À\u0001\u001a\u0005\u0018\u00010¿\u0001H&J6\u0010Â\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\t2\n\u0010¾\u0001\u001a\u0005\u0018\u00010½\u00012\n\u0010À\u0001\u001a\u0005\u0018\u00010¿\u0001H&J6\u0010Ã\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\t2\n\u0010¾\u0001\u001a\u0005\u0018\u00010½\u00012\n\u0010À\u0001\u001a\u0005\u0018\u00010¿\u0001H&J3\u0010Á\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\t2\u0007\u0010¼\u0001\u001a\u00020\t2\n\u0010¾\u0001\u001a\u0005\u0018\u00010½\u0001H&J*\u0010Â\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\t2\n\u0010¾\u0001\u001a\u0005\u0018\u00010½\u0001H&J*\u0010Ã\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\t2\n\u0010¾\u0001\u001a\u0005\u0018\u00010½\u0001H&J\u0011\u0010Ä\u0001\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H&J\t\u0010Å\u0001\u001a\u00020\u0004H&J4\u0010É\u0001\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0007\u0010Æ\u0001\u001a\u00020\u00122\u0007\u0010Ç\u0001\u001a\u00020\t2\u0007\u0010È\u0001\u001a\u00020\"H&J>\u0010É\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0007\u0010Æ\u0001\u001a\u00020\u00122\u0007\u0010Ç\u0001\u001a\u00020\t2\u0007\u0010È\u0001\u001a\u00020\"H&JH\u0010É\u0001\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0007\u0010Æ\u0001\u001a\u00020\u00122\u0007\u0010Ç\u0001\u001a\u00020\t2\u0007\u0010È\u0001\u001a\u00020\"2\b\u0010Ë\u0001\u001a\u00030Ê\u0001H&J*\u0010Í\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010x\u001a\u00020\t2\u0006\u0010y\u001a\u00020\u001f2\u0007\u0010g\u001a\u00030Ì\u0001H&J\t\u0010Î\u0001\u001a\u00020\u0004H&J\u001e\u0010Ð\u0001\u001a\u0017\u0012\u0004\u0012\u00020\t\u0012\r\u0012\u000b\u0012\u0006\b\u0001\u0012\u00020\u00010Ï\u00010\u0018H&J\t\u0010Ñ\u0001\u001a\u00020\u0004H&J\u0012\u0010Ó\u0001\u001a\u00020\u00042\u0007\u0010Ò\u0001\u001a\u00020\tH&J\u0012\u0010Õ\u0001\u001a\u00020\u00042\u0007\u0010Ô\u0001\u001a\u00020\tH&J\u0012\u0010Ö\u0001\u001a\u00020\u00042\u0007\u0010Ô\u0001\u001a\u00020\tH&J3\u0010Ù\u0001\u001a\u00020\u00042\u0006\u0010m\u001a\u00020l2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0007\u0010×\u0001\u001a\u00020\t2\u0007\u0010g\u001a\u00030Ø\u0001H&JE\u0010Ù\u0001\u001a\u00020\u00042\u0006\u0010m\u001a\u00020l2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0007\u0010×\u0001\u001a\u00020\t2\u0007\u0010Ú\u0001\u001a\u00020\t2\u0007\u0010Û\u0001\u001a\u00020\t2\u0007\u0010g\u001a\u00030Ø\u0001H&JN\u0010Ù\u0001\u001a\u00020\u00042\u0006\u0010m\u001a\u00020l2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0007\u0010×\u0001\u001a\u00020\t2\u0007\u0010Ú\u0001\u001a\u00020\t2\u0007\u0010Û\u0001\u001a\u00020\t2\u0007\u0010Ü\u0001\u001a\u00020\t2\u0007\u0010g\u001a\u00030Ø\u0001H&J\u001e\u0010à\u0001\u001a\u00020\u00042\u0007\u0010Ý\u0001\u001a\u00020\t2\n\u0010ß\u0001\u001a\u0005\u0018\u00010Þ\u0001H&J\u0015\u0010à\u0001\u001a\u00020\u00042\n\u0010ß\u0001\u001a\u0005\u0018\u00010Þ\u0001H&J=\u0010ã\u0001\u001a\u00020\u00042\b\u0010m\u001a\u0004\u0018\u00010l2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\t\u0010á\u0001\u001a\u0004\u0018\u00010\t2\t\u0010g\u001a\u0005\u0018\u00010â\u0001H&J\u0012\u0010å\u0001\u001a\u00020\u00042\u0007\u0010ä\u0001\u001a\u00020\"H&J\u0012\u0010æ\u0001\u001a\u00020\u00042\u0007\u0010ä\u0001\u001a\u00020\"H&J\t\u0010ç\u0001\u001a\u00020\u0004H&J\t\u0010è\u0001\u001a\u00020\u0004H&J\u0014\u0010ê\u0001\u001a\u0004\u0018\u00010\t2\u0007\u0010é\u0001\u001a\u00020\tH&J \u0010ì\u0001\u001a\u00020\u00042\u0015\u0010ë\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"\u0018\u00010\u0018H&J\u0014\u0010î\u0001\u001a\u00020\u00042\t\u0010í\u0001\u001a\u0004\u0018\u00010\tH&J\u0018\u0010ò\u0001\u001a\u0005\u0018\u00010ñ\u00012\n\u0010ð\u0001\u001a\u0005\u0018\u00010ï\u0001H&J2\u0010õ\u0001\u001a\u00020\u001f2\u0007\u0010Û\u0001\u001a\u00020\t2\u0007\u0010ó\u0001\u001a\u00020\t2\u0015\u0010ô\u0001\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018H&J\t\u0010ö\u0001\u001a\u00020\u0004H&J\u000b\u0010÷\u0001\u001a\u0004\u0018\u00010\u001fH&J\"\u0010ø\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010y\u001a\u00020\u001f2\u0007\u0010g\u001a\u00030Ì\u0001H&J2\u0010ú\u0001\u001a\u0004\u0018\u00010\u001f2%\u0010ù\u0001\u001a \u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0089\u0001j\u000f\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u008a\u0001H&J\u0012\u0010ü\u0001\u001a\u00020\"2\u0007\u0010û\u0001\u001a\u00020\u0002H&J9\u0010\u0082\u0002\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010ý\u0001\u001a\u00020\t2\b\u0010ÿ\u0001\u001a\u00030þ\u00012\u0007\u0010\u0080\u0002\u001a\u00020\t2\t\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u001fH&J\u001b\u0010\u0083\u0002\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\tH&J\u001a\u0010\u0084\u0002\u001a\u00020\u00042\u0007\u0010é\u0001\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH&J\u001b\u0010\u0086\u0002\u001a\u00020\t2\u0007\u0010é\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0002\u001a\u00020\tH&J\u001a\u0010\u0087\u0002\u001a\u00020\u00042\u0006\u0010m\u001a\u00020l2\u0007\u0010Ò\u0001\u001a\u00020\tH&J%\u0010\u008a\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010Z\u001a\u0004\u0018\u00010\t2\b\u0010\u0089\u0002\u001a\u00030\u0088\u0002H&J[\u0010\u008a\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010Z\u001a\u0004\u0018\u00010\t2\u0015\u0010\u008b\u0002\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00182\t\u0010\u008c\u0002\u001a\u0004\u0018\u00010\t2\t\u0010\u008d\u0002\u001a\u0004\u0018\u00010\t2\u0007\u0010\u008e\u0002\u001a\u00020\u00122\b\u0010\u0089\u0002\u001a\u00030\u0088\u0002H&JI\u0010\u008f\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00182\u0017\u0010\u008b\u0002\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00182\t\u0010g\u001a\u0005\u0018\u00010\u0088\u0002H&¨\u0006\u0090\u0002"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/pay/api/ITTCJPayUtilsCompat;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "setContext", "", "fontScale", "setFontScale", "", "appId", "setAppId", "merchantId", "setMerchantId", "aid", "setAid", a.KEY_DID, "setDid", "", "isUsingGecko", "setIsUsingGecko", "", "riskInfoParams", "setRiskInfoParams", "", "loginTokenMap", "setLoginToken", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayObserver;", "observer", "setObserver", "url", "Lorg/json/JSONObject;", "orderInfo", "channelInfo", "", "payCashDeskType", "navigationBarColor", "openH5CashDesk", "isNewGameStyle", "setGameNewStyle", "requestParams", "setRequestParams", "releaseAll", "execute", "titleStr", "setTitleStr", "isTransCheckoutCounterActivityWhenLoading", "setIsTransCheckoutCounterActivityWhenLoading", "needLoading", "setNeedLoading", "isUnifyHideLoading", "setUnifyHideLoading", "appUpdateVersion", "setAppUpdateVersion", "uid", "setUid", "Lcom/android/ttcjpaysdk/base/adapter/TTCJPayToastAdapter;", "adapter", "setToastAdapter", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/adapter/TTCJPayLoadingAdapter;", "setLoadingAdapter", "Lcom/android/ttcjpaysdk/ttcjpayapi/IBasicMode;", "basicModeCallback", "setBasicModeCallback", "isFollow", "setFollowSystemTheme", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayOpenSchemeWithContextInterface;", "openSchemeWithContextCallback", "setOpenSchemeWithContextCallback", "Lcom/android/ttcjpaysdk/base/adapter/ICJExternalLynxServiceAdapter;", "setExternalLynxServiceAdapter", "Lcom/android/ttcjpaysdk/base/adapter/ICJExternalEventCenterAdapter;", "setExternalEventCenterAdapter", "interceptor", "setNetworkInterceptor", "Lcom/android/ttcjpaysdk/ttcjpayapi/ITTCJPayPhoneCarrierService;", "phoneCarrierService", "setPhoneCarrierService", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICJHostLoginService;", "loginService", "setHostLoginService", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayHostJSBMethodsInterface;", "hostJSBMethodsInterface", "setHostJSBMethodsInterface", "fromImRedPacket", "setFromImRedPacket", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayOpenSchemeInterface;", "openSchemeInterface", "setOpenSchemeCallback", "sdkInfoStr", "bdPayForImRedPacket", "title", "isTransTitleBar", "statusBarColor", "backButtonColor", "openH5", d.D, "service", "subWay", AppConstants.BUNDLE_REFERER, "ext", "Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;", "callback", "pay", "from", "needOriginErrorCode", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;)V", "Landroid/app/Activity;", "activity", w.META_COLL_KEY_AUTH_INFO, "isShowLoading", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayAlipayAuthCallback;", "authAlipay", "releaseAllFromSubProcess", "closeSDK", "payFromSubProcess", "getSDKVersion", "scheme", "openH5ByScheme", e.f25671s, "params", "executeCloseAndCallback", "value", "setBoeEnv", "channel", "setEnvChannel", "getBioType", "getJailBreak", "screenOrientationType", "setScreenOrientationType", "backEnable", "setBackEnable", "needJSBridgeAuth", "setJSBridgeAuth", "trackInfoJson", "setTrackInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraHeaderMap", "setExtraHeaderMap", "type", "setServerType", "preLoadYuefuTemplate", "languageTypeStr", "setLanguageTypeStr", "isUsingTTNet", "setIsUsingTTNet", "isGameNewCounterStyle", "setGameNewCounterStyle", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "setTitleBitmap", "inheritTheme", "setInheritTheme", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayMonitor;", "monitor", "setMonitor", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayEvent;", "event", "setEvent", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayDoFaceLive;", "faceLive", "setFaceLive", "Lcom/android/ttcjpaysdk/ttcjpayapi/IBlockDialog;", "blockDialog", "setBlockDialog", "Lcom/android/ttcjpaysdk/ttcjpayapi/IH5NotificationCallback;", "setH5NotificationCallback", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICustomActionListener;", "customActionListener", "setCustomActionListener", "Lcom/android/ttcjpaysdk/base/adapter/TTCJPayNetworkErrorAdapter;", "setNetworkErrorAdapter", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICustomerServiceCallback;", "customerServiceCallback", "setCustomerServiceCallback", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICJHostPrivacyService;", "setHostPrivacyService", "bdPay", "init", "initMini", "doRefreshOnNetworkError", "sign", "amount", "tradeName", "executeAggregatePayment", "data", "wxPayType", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnResultCallback;", "onResultCallback", "wxPay", "aliPay", "cloudUnionPay", "isCloudUnionPayInstalled", "executeWithdraw", "enableAnim", "bgColor", DyPayConstant.KEY_SHOW_LOADING, "openH5ModalView", "Landroid/net/Uri;", "uri", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICJPayXBridgeCallback;", "handleXBridgeMethod", "registerCJPayXbridge", "Ljava/lang/Class;", "getCJPayXBridgeMethods", PbRequest.SwitchType.RECHARGE, "schema", "myBankCard", "smchId", "tradeRecord", "tradeManager", "eventTrack", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayRealNameAuthCallback;", "openRealNameAuth", "theme", "scene", "style", b.f276366p, "Lcom/android/ttcjpaysdk/base/service/ICJPayServiceRetCallBack;", "callBack", "openOCR", "channelOrderInfo", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayRealNamePasswordCallback;", "openRealNameSetPassword", "heightInPx", "fastPay", "fastPayShowLoading", "fastPayHideLoading", "fastPayOnlySendRequest", "key", "getSettingsInfo", "animationResourceMap", "setAnimationResourceMap", "integratedDomain", "setIntegratedHostDomain", "Lcom/android/ttcjpaysdk/base/service/IPayLifecycle;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/android/ttcjpaysdk/base/service/ITTCJPayComponent;", "getPayComponent", "triggerAction", "extraReportMap", "getFinanceRiskWithScene", "preLoadFinanceRisk", "getCJPassThroughInfo", "openPayScoreWithParams", "sceneContext", "getCJPayInfo", "applicationContext", "getAppVersionCode", "name", "", "timestamp", SocialConstants.PARAM_APP_DESC, "exts", "externalBizReport", "verifyScanResultSync", "storeString", "defaultValue", "readString", "openTestPage", "Lwc4/a;", "payCallback", "outerBDPay", "extraInfo", "source", "sceneSource", "isInvokeForInner", "routeSign", "cjpay-se-api_release"}, k = 1, mv = {1, 6, 0})
public interface ITTCJPayUtilsCompat {
    void aliPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102);

    void aliPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102, ICJPayBasisPaymentService.OnResultCallback r103);

    void authAlipay(Activity r100, String r101, boolean r102, TTCJPayAlipayAuthCallback r103);

    void bdPay();

    void bdPayForImRedPacket(String r100);

    void closeSDK();

    void cloudUnionPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102);

    void cloudUnionPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102, ICJPayBasisPaymentService.OnResultCallback r103);

    void doRefreshOnNetworkError();

    void execute();

    void executeAggregatePayment(int r100, String r101, String r102, String r103);

    void executeCloseAndCallback(Context r100, String r101, JSONObject r102);

    void executeWithdraw();

    void externalBizReport(String r100, String r101, long r102, String r103, JSONObject r104);

    void fastPay(int r100);

    void fastPayHideLoading();

    void fastPayOnlySendRequest();

    void fastPayShowLoading(int r100);

    int getAppVersionCode(Context r100);

    String getBioType();

    JSONObject getCJPassThroughInfo();

    JSONObject getCJPayInfo(HashMap<String, String> r100);

    Map<String, Class<? extends Object>> getCJPayXBridgeMethods();

    JSONObject getFinanceRiskWithScene(String r100, String r101, Map<String, ? extends Object> r102);

    String getJailBreak();

    ITTCJPayComponent getPayComponent(IPayLifecycle r100);

    String getSDKVersion();

    String getSettingsInfo(String r100);

    void handleXBridgeMethod(Context r100, String r101, JSONObject r102, ICJPayXBridgeCallback r103);

    void init();

    void initMini();

    boolean isCloudUnionPayInstalled(Context r100);

    void myBankCard(String r100);

    void openH5(String r100, String r101, String r102, String r103, String r104);

    void openH5ByScheme(String r100);

    void openH5CashDesk(String r100, JSONObject r101, JSONObject r102, int r103, String r104);

    void openH5ModalView(Context r100, String r101, int r102, boolean r103, String r104, int r105);

    void openH5ModalView(Context r100, String r101, int r102, boolean r103, String r104, int r105, Uri r106);

    void openH5ModalView(String r100, int r101, boolean r102, String r103, int r104);

    void openOCR(ICJPayServiceRetCallBack r100);

    void openOCR(String r100, ICJPayServiceRetCallBack r101);

    void openPayScoreWithParams(Context r100, JSONObject r101, ICJPayXBridgeCallback r102);

    void openRealNameAuth(Activity r100, String r101, String r102, String r103, TTCJPayRealNameAuthCallback r104);

    void openRealNameAuth(Activity r100, String r101, String r102, String r103, String r104, String r105, TTCJPayRealNameAuthCallback r106);

    void openRealNameAuth(Activity r100, String r101, String r102, String r103, String r104, String r105, String r106, TTCJPayRealNameAuthCallback r107);

    void openRealNameSetPassword(Activity r100, String r101, String r102, String r103, TTCJPayRealNamePasswordCallback r104);

    void openTestPage(Activity r100, String r101);

    void outerBDPay(Context r100, String r101, Map<String, String> r102, String r103, String r104, boolean r105, wc4.a r106);

    void outerBDPay(Context r100, String r101, wc4.a r102);

    void pay(String r100, int r101, String r102, String r103, String r104, IH5PayCallback r105);

    void pay(String r100, int r101, String r102, String r103, String r104, String r105, IH5PayCallback r106);

    void pay(String r100, int r101, String r102, String r103, String r104, String r105, Boolean r106, IH5PayCallback r107);

    void payFromSubProcess(String r100, int r101, String r102, String r103, String r104, IH5PayCallback r105);

    void preLoadFinanceRisk();

    void preLoadYuefuTemplate();

    String readString(String r100, String r101);

    void recharge();

    void registerCJPayXbridge();

    @Deprecated(message = "this function is deprecated!")
    void releaseAll();

    void releaseAllFromSubProcess();

    void routeSign(Context r100, Map<String, String> r101, Map<String, ? extends Object> r102, wc4.a r103);

    void setAid(String r100);

    void setAnimationResourceMap(Map<String, Integer> r100);

    void setAppId(String r100);

    void setAppUpdateVersion(String r100);

    void setBackEnable(boolean r100);

    void setBasicModeCallback(IBasicMode r100);

    void setBlockDialog(IBlockDialog r100);

    void setBoeEnv(String r100);

    void setContext(Context r100);

    void setCustomActionListener(ICustomActionListener r100);

    void setCustomerServiceCallback(ICustomerServiceCallback r100);

    void setDid(String r100);

    void setEnvChannel(String r100);

    void setEvent(TTCJPayEvent r100);

    void setExternalEventCenterAdapter(ICJExternalEventCenterAdapter r100);

    void setExternalLynxServiceAdapter(ICJExternalLynxServiceAdapter r100);

    void setExtraHeaderMap(HashMap<String, String> r100);

    @Deprecated(message = "this function is deprecated!")
    void setFaceLive(TTCJPayDoFaceLive r100);

    void setFollowSystemTheme(boolean r100);

    void setFontScale(float r100);

    void setFromImRedPacket(boolean r100);

    void setGameNewCounterStyle(boolean r100);

    void setGameNewStyle(boolean r100);

    void setH5NotificationCallback(IH5NotificationCallback r100);

    void setHostJSBMethodsInterface(TTCJPayHostJSBMethodsInterface r100);

    void setHostLoginService(ICJHostLoginService r100);

    void setHostPrivacyService(ICJHostPrivacyService r100);

    void setInheritTheme(String r100);

    void setIntegratedHostDomain(String r100);

    void setIsTransCheckoutCounterActivityWhenLoading(boolean r100);

    void setIsUsingGecko(boolean r100);

    void setIsUsingTTNet(boolean r100);

    void setJSBridgeAuth(boolean r100);

    void setLanguageTypeStr(String r100);

    <T> void setLoadingAdapter(TTCJPayLoadingAdapter<T> r100);

    void setLoginToken(Map<String, String> r100);

    void setMerchantId(String r100);

    void setMonitor(TTCJPayMonitor r100);

    void setNeedLoading(boolean r100);

    void setNetworkErrorAdapter(TTCJPayNetworkErrorAdapter r100);

    void setNetworkInterceptor(Object r100);

    void setObserver(TTCJPayObserver r100);

    void setOpenSchemeCallback(TTCJPayOpenSchemeInterface r100);

    void setOpenSchemeWithContextCallback(TTCJPayOpenSchemeWithContextInterface r100);

    void setPhoneCarrierService(ITTCJPayPhoneCarrierService r100);

    void setRequestParams(Map<String, String> r100);

    void setRiskInfoParams(Map<String, String> r100);

    void setScreenOrientationType(int r100);

    void setServerType(int r100);

    void setTitleBitmap(Bitmap r100);

    void setTitleStr(String r100);

    void setToastAdapter(TTCJPayToastAdapter r100);

    void setTrackInfo(JSONObject r100);

    void setUid(String r100);

    void setUnifyHideLoading(boolean r100);

    void sign();

    void storeString(String r100, String r101);

    void tradeManager(String r100);

    void tradeRecord(String r100);

    boolean verifyScanResultSync(Context r100, String r101);

    void wxPay(Context r100, String r101, String r102, ICJPayBasisPaymentService.OnPayResultCallback r103);

    void wxPay(Context r100, String r101, String r102, ICJPayBasisPaymentService.OnPayResultCallback r103, ICJPayBasisPaymentService.OnResultCallback r104);
}
