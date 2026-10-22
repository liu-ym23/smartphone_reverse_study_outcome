package com.bytedance.android.livesdk.live.extension.plugin.api.livepusher;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Handler;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import uf2.a1;
import uf2.b0;
import uf2.b1;
import uf2.c;
import uf2.c0;
import uf2.c1;
import uf2.d;
import uf2.d0;
import uf2.d1;
import uf2.e;
import uf2.e0;
import uf2.e1;
import uf2.f;
import uf2.f0;
import uf2.f1;
import uf2.g;
import uf2.g0;
import uf2.g1;
import uf2.h;
import uf2.h0;
import uf2.h1;
import uf2.i1;
import uf2.j;
import uf2.j0;
import uf2.k;
import uf2.k0;
import uf2.l;
import uf2.l0;
import uf2.m;
import uf2.m0;
import uf2.m1;
import uf2.n;
import uf2.n0;
import uf2.n1;
import uf2.o;
import uf2.o1;
import uf2.p0;
import uf2.p1;
import uf2.q;
import uf2.q0;
import uf2.r;
import uf2.r0;
import uf2.s;
import uf2.t;
import uf2.t0;
import uf2.u;
import uf2.u0;
import uf2.v;
import uf2.v0;
import uf2.w;
import uf2.w0;
import uf2.x0;
import uf2.y;
import uf2.y0;
import uf2.z;
import uf2.z0;
import va1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000è\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 â\u00012\u00020\u0001:\u0002ã\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001bH\u0016J*\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0014\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0010\u001a\u0004\u0018\u00010%H\u0016J\u0014\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\u0010\u001a\u0004\u0018\u00010(H\u0016J\u0016\u0010-\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002H\u0016J:\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0016JF\u0010;\u001a\u0004\u0018\u00010:2\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.2\u0006\u0010+\u001a\u00020.2\b\u00106\u001a\u0004\u0018\u0001052\b\u00108\u001a\u0004\u0018\u0001072\u0006\u00109\u001a\u00020.H\u0016J\n\u0010=\u001a\u0004\u0018\u00010<H\u0016J\n\u0010?\u001a\u0004\u0018\u00010>H\u0016J\n\u0010A\u001a\u0004\u0018\u00010@H\u0016J\n\u0010C\u001a\u0004\u0018\u00010BH\u0016J6\u0010L\u001a\u0004\u0018\u00010K2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020.2\b\u0010H\u001a\u0004\u0018\u00010G2\b\u0010J\u001a\u0004\u0018\u00010IH\u0016J\n\u0010N\u001a\u0004\u0018\u00010MH\u0016J\n\u0010P\u001a\u0004\u0018\u00010OH\u0016J\n\u0010R\u001a\u0004\u0018\u00010QH\u0016JJ\u0010\\\u001a\u0004\u0018\u00010[2\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010S2\u0006\u0010T\u001a\u00020.2\b\u0010V\u001a\u0004\u0018\u00010U2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016J$\u0010a\u001a\u0004\u0018\u00010`2\b\u0010^\u001a\u0004\u0018\u00010]2\u0006\u00104\u001a\u00020.2\u0006\u0010_\u001a\u000200H\u0016J\u0014\u0010e\u001a\u0004\u0018\u00010d2\b\u0010c\u001a\u0004\u0018\u00010bH\u0016J\u0012\u0010h\u001a\u0004\u0018\u00010g2\u0006\u0010\u0010\u001a\u00020fH\u0016J\n\u0010j\u001a\u0004\u0018\u00010iH\u0016J\n\u0010l\u001a\u0004\u0018\u00010kH\u0016J\u0012\u0010o\u001a\u0004\u0018\u00010n2\u0006\u0010\u0010\u001a\u00020mH\u0016Jb\u0010y\u001a\u0004\u0018\u00010x2\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020.2\b\u0010q\u001a\u0004\u0018\u00010p2\u0006\u0010r\u001a\u00020.2\b\u0010s\u001a\u0004\u0018\u00010p2\u0006\u0010t\u001a\u00020.2\b\u0010u\u001a\u0004\u0018\u00010p2\u0006\u0010v\u001a\u00020.2\u0006\u0010w\u001a\u0002002\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016J\u0014\u0010|\u001a\u0004\u0018\u00010{2\b\u0010z\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010~\u001a\u0004\u0018\u00010}H\u0016J\u0015\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010z\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\b\u0010H\u001a\u0004\u0018\u00010GH\u0016J\u0018\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J#\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\u0017\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u00012\t\u0010\u0010\u001a\u0005\u0018\u00010\u008c\u0001H\u0016J\f\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\f\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J\f\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\f\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016J\f\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\f\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016J\f\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\f\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\f\u0010¤\u0001\u001a\u0005\u0018\u00010£\u0001H\u0016J\f\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0016J\f\u0010¨\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\f\u0010ª\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\f\u0010¬\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J\f\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0016J\f\u0010°\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016J\f\u0010²\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\f\u0010´\u0001\u001a\u0005\u0018\u00010³\u0001H\u0016J\f\u0010µ\u0001\u001a\u0005\u0018\u00010³\u0001H\u0016J\f\u0010·\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J\f\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0016J,\u0010½\u0001\u001a\u0005\u0018\u00010¼\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010<2\t\u0010»\u0001\u001a\u0004\u0018\u00010>2\b\u0010H\u001a\u0004\u0018\u00010GH\u0016J?\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u00012\n\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u00012\u0007\u0010À\u0001\u001a\u00020.2\u0007\u0010Á\u0001\u001a\u00020.2\u0007\u0010Â\u0001\u001a\u00020.2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016J\f\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u0001H\u0016J\u0017\u0010Ë\u0001\u001a\u0005\u0018\u00010Ê\u00012\t\u0010\u0010\u001a\u0005\u0018\u00010É\u0001H\u0016J'\u0010Ð\u0001\u001a\u0005\u0018\u00010Ï\u00012\u0007\u0010Ì\u0001\u001a\u00020.2\u0007\u0010Í\u0001\u001a\u00020\u00022\u0007\u0010Î\u0001\u001a\u00020\u0002H\u0016J\f\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0016J\f\u0010Ô\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0016J\f\u0010Ö\u0001\u001a\u0005\u0018\u00010Õ\u0001H\u0016J\u0017\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u00012\t\u0010×\u0001\u001a\u0004\u0018\u00010\u0004H\u0016J%\u0010Ü\u0001\u001a\u0005\u0018\u00010Û\u00012\u0007\u0010Ú\u0001\u001a\u00020p2\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020.H\u0016J&\u0010á\u0001\u001a\u00030à\u00012\b\u0010Ý\u0001\u001a\u00030Û\u00012\u0007\u0010Þ\u0001\u001a\u00020\u00022\u0007\u0010ß\u0001\u001a\u00020\u0002H\u0016¨\u0006ä\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedLivePusher;", "Lcom/bytedance/android/live/base/IService;", "", "getVersion", "", "liveCore", "Luf2/d0;", "buildLiveCore", "any", "Luf2/z$a;", "buildLayerControlLayer", "Luf2/k;", "newCoreAppPreviewBuilder", "Luf2/r0$b;", "newRenderFilterConfig", "Luf2/h0$a$a;", "callbacks", "Luf2/h0$a;", "newAudioFrameAvailableListener", "Luf2/j0;", "newLiveStreamParamBuilder", "Luf2/o$b;", "inFormat", "outFormat", "Luf2/o;", "newFFMpegAudioResampler", "newFFMpegAudioResamplerFormat", "Luf2/j$a;", "Luf2/j;", "newAudioSink", "", "left", "top", "right", "bottom", "Luf2/m1$a;", "newVideoMixerCropRegion", "Luf2/h0$e$a;", "Luf2/h0$e;", "newTextureFrameAvailableListener", "Luf2/d0$b$a;", "Luf2/d0$b;", "newLiveCoreVideoFrameAvailableListener", LocationMonitorConst.TYPE, "Luf2/m1$b;", "newVideoMixerDescription", "", "zOrder", "", "flags", "width", "height", "rotation", "", "texture", "", "matrix", "colorRange", "Luf2/m1$c;", "newVideoMixerTexture", "Luf2/g1;", "newTinyTextureBufferPool", "Luf2/f1;", "newTinyGLTextureFrameBufferPool", "Luf2/q0;", "newRecorderManager", "Luf2/q0$a;", "newRecorderManagerConfig", "sample", "channel", "bitwidth", "Landroid/os/Handler;", "handler", "Luf2/d;", "observer", "Luf2/e;", "newAudioCapturerExternal", "Luf2/n;", "newExternalVideoCapturer", "Luf2/h;", "newAudioDiagnosisResult", "Luf2/g;", "newAudioDiagnosisConfig", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedVideoFrame$ILiveWrappedTextureBuffer$ILiveWrappedType;", "id", "Landroid/graphics/Matrix;", "transformMatrix", "Luf2/c1$a;", "toI420Interface", "Ljava/lang/Runnable;", "releaseCallback", "Luf2/c1;", "newTextureBufferImpl", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedVideoFrame$a;", "buffer", "timestampNs", "Lcom/bytedance/android/livesdk/live/extension/plugin/api/livepusher/ILiveWrappedVideoFrame;", "newVideoFrame", "Landroid/view/View;", "view", "Luf2/t0;", "newRenderView", "Luf2/f$a$a;", "Luf2/f$a;", "newAudioDeviceModuleAudioFocusChangedCallBack", "Luf2/d0$a;", "newLiveCoreBuilder", "Luf2/c0;", "newLiveAlgorithmParamRhythmicMotion", "Luf2/r0$a$a;", "Luf2/r0$a;", "newRenderFilterFrameCallBack", "Ljava/nio/ByteBuffer;", "dataY", "strideY", "dataU", "strideU", "dataV", "strideV", "captureMs", "Luf2/y;", "newJavaI420Buffer", "threadName", "Luf2/s;", "newGLThread", "Luf2/u;", "newGlRenderDrawer", "Luf2/z0;", "newSurfaceTextureHelper", "Luf2/a1;", "newSurfaceTextureSharedHandler", "Luf2/p0;", "listener", "Luf2/g0;", "newLiveCoreUploadBWProbe", "core", "Luf2/b;", "player", "Luf2/m0;", "newMoviePlayer", "Luf2/c$a;", "Luf2/c;", "newAVPlayer", "Luf2/e0;", "getLiveCoreApp", "Luf2/l;", "getEarlyAVLog", "Luf2/v0;", "getSafeHandlerThreadPoolExecutor", "Luf2/h1;", "getTransportContextUtils", "Luf2/l0;", "getMiscUtils", "Luf2/m;", "getEffectWrapper", "Luf2/m$a;", "getEffectWrapperAlgorithmResult", "Luf2/v;", "getGLUtil", "Luf2/k0;", "getMediaEngineFactory", "Luf2/t;", "getGLThreadManager", "Luf2/i1;", "getUrlUtils", "Luf2/w0;", "getShortVideoAudioPushManager", "Luf2/o1;", "getYuvHelper", "Luf2/e1;", "getTimeUtils", "Luf2/b0;", "getLibraryLoader", "Luf2/o$a;", "getFFMpegAudioResampler", "Luf2/a;", "getAVLog", "Luf2/d1;", "getThreadUtils", "Luf2/f0;", "getLiveCoreKaraokFilter", "getLiveCoreKaraokFilter2", "Luf2/w;", "getImageLoadUtils", "Luf2/b1;", "newTEBundle", "pool", "tinyGLTextureFrameBufferPool", "Luf2/r;", "newGLConverter", "Landroid/content/Context;", "context", "outputWidth", "outputHeight", "outFps", "Luf2/x0$a;", "callback", "Luf2/x0;", "newShortVideoPushManager", "Luf2/m1;", "newVideoMixer", "Luf2/n1$a;", "Luf2/n1;", "newVideoSink", "liveRoomMode", "businessType", "sceneType", "Luf2/y0;", "newLiveStreamBusinessTag", "Luf2/p1;", "getZlibCompressUtils", "Luf2/n0;", "getPrivacyCertManager", "Luf2/u0;", "getRendererCommon", "findContourInfo", "Luf2/q;", "buildFindContourInfo", "yuvBuffer", "Landroid/graphics/Bitmap;", "debugHelpBitmap", "bmp", "dir", "filename", "", "debugHelpWriteToFile", "Companion", "a", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWrappedLivePusher extends IService {
    public static final a Companion = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static ILiveWrappedLivePusher b() {
            return (ILiveWrappedLivePusher) b.a.a.a(ILiveWrappedLivePusher.class);
        }

        public static boolean a(String r1, String r2) {
            if (r1 != null) goto L6;
            if (r2 != null) goto L6;
            return true;
        L6:
            if (r1 == null) goto L9;
            if (r2 == null) goto L9;
            return StringsKt.equals(r1, r2, true);
        L9:
            return false;
        }
    }

    static {
        Companion = a.a;
    }

    q buildFindContourInfo(Object r1);

    z.a buildLayerControlLayer(Object r1);

    d0 buildLiveCore(Object r1);

    Bitmap debugHelpBitmap(ByteBuffer r1, int r2, int r3);

    void debugHelpWriteToFile(Bitmap r1, String r2, String r3);

    uf2.a getAVLog();

    l getEarlyAVLog();

    m getEffectWrapper();

    m.a getEffectWrapperAlgorithmResult();

    o.a getFFMpegAudioResampler();

    t getGLThreadManager();

    v getGLUtil();

    w getImageLoadUtils();

    b0 getLibraryLoader();

    e0 getLiveCoreApp();

    f0 getLiveCoreKaraokFilter();

    f0 getLiveCoreKaraokFilter2();

    k0 getMediaEngineFactory();

    l0 getMiscUtils();

    n0 getPrivacyCertManager();

    u0 getRendererCommon();

    v0 getSafeHandlerThreadPoolExecutor();

    w0 getShortVideoAudioPushManager();

    d1 getThreadUtils();

    e1 getTimeUtils();

    h1 getTransportContextUtils();

    i1 getUrlUtils();

    String getVersion();

    o1 getYuvHelper();

    p1 getZlibCompressUtils();

    c newAVPlayer(c.a r1);

    e newAudioCapturerExternal(int r1, int r2, int r3, Handler r4, d r5);

    f.a newAudioDeviceModuleAudioFocusChangedCallBack(f.a.InterfaceC0178a r1);

    g newAudioDiagnosisConfig();

    h newAudioDiagnosisResult();

    h0.a newAudioFrameAvailableListener(h0.a.InterfaceC0179a r1);

    j newAudioSink(j.a r1);

    k newCoreAppPreviewBuilder();

    n newExternalVideoCapturer();

    o newFFMpegAudioResampler(o.b r1, o.b r2);

    o.b newFFMpegAudioResamplerFormat();

    r newGLConverter(g1 r1, f1 r2, Handler r3);

    s newGLThread(String r1);

    u newGlRenderDrawer();

    y newJavaI420Buffer(int r1, int r2, ByteBuffer r3, int r4, ByteBuffer r5, int r6, ByteBuffer r7, int r8, long r9, Runnable r11);

    c0 newLiveAlgorithmParamRhythmicMotion();

    d0.a newLiveCoreBuilder();

    g0 newLiveCoreUploadBWProbe(p0 r1);

    d0.b newLiveCoreVideoFrameAvailableListener(d0.b.a r1);

    y0 newLiveStreamBusinessTag(int r1, String r2, String r3);

    j0 newLiveStreamParamBuilder();

    m0 newMoviePlayer(d0 r1, uf2.b r2);

    q0 newRecorderManager();

    q0.a newRecorderManagerConfig();

    r0.b newRenderFilterConfig();

    r0.a newRenderFilterFrameCallBack(r0.a.InterfaceC0180a r1);

    t0 newRenderView(View r1);

    x0 newShortVideoPushManager(Context r1, int r2, int r3, int r4, x0.a r5);

    z0 newSurfaceTextureHelper(String r1);

    a1 newSurfaceTextureSharedHandler(Handler r1);

    b1 newTEBundle();

    c1 newTextureBufferImpl(int r1, int r2, ILiveWrappedVideoFrame.ILiveWrappedTextureBuffer.ILiveWrappedType r3, int r4, Matrix r5, c1.a r6, Runnable r7);

    h0.e newTextureFrameAvailableListener(h0.e.a r1);

    f1 newTinyGLTextureFrameBufferPool();

    g1 newTinyTextureBufferPool();

    ILiveWrappedVideoFrame newVideoFrame(ILiveWrappedVideoFrame.a r1, int r2, long r3);

    m1 newVideoMixer();

    m1.a newVideoMixerCropRegion(float r1, float r2, float r3, float r4);

    m1.b newVideoMixerDescription(float r1, float r2, float r3, float r4, int r5, long r6);

    m1.b newVideoMixerDescription(String r1);

    m1.c newVideoMixerTexture(int r1, int r2, int r3, int r4, int[] r5, float[] r6, int r7);

    n1 newVideoSink(n1.a r1);
}
